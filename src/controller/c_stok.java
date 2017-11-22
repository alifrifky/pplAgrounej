/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.m_stok;
import view.v_pemanenan;

import java.text.SimpleDateFormat;

import model.m_login;

/**
 *
 * @author Alif
 */
public class c_stok {

    private view.v_pemanenan viewStok;
    private view.v_beranda viewBeranda;
    private view.v_login viewLogin;

    private model.m_stok modelStok;
    private controller.c_login cLogin;

    public c_stok(v_pemanenan viewStok, m_stok modelStok) throws SQLException {
        this.viewStok = viewStok;
        this.modelStok = modelStok;
        viewStok.setVisible(true);
        c_stok();
        viewStok.addInputStokListener(new inputPemanenanListener());
        viewStok.addKembaliListener(new kembaliListener());
        viewStok.setTable(modelStok.getDataTabel(viewStok.getLevel() + 1));

        viewStok.addPeriodeListener(new periodeListener());
        //viewStok.addCetakListener(new cetakListener());

    }

    private class inputPemanenanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat a = new SimpleDateFormat("yyyy");

            String tanggal = String.valueOf(fm.format(viewStok.getKalendar().getDate()));
            String tahun = String.valueOf(a.format(viewStok.getKalendar().getDate()));
            System.out.println(tahun);
            try {
               
                modelStok.save(viewStok.getTulis_input().getText(), tanggal, m_login.id_user, viewStok.getLevel() + 1);
                modelStok.tambahUpdate(Integer.parseInt(viewStok.getTulis_input().getText()));
                viewStok.setTable(modelStok.getDataTabel(viewStok.getLevel() + 1));
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    private class periodeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                viewStok.setTable(modelStok.getDataTabel(viewStok.getLevel() + 1));
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    private void c_stok() throws SQLException {

        modelStok.select();
        String hitung = m_stok.hitung;
        viewStok.getTotal_stok().setText(hitung);
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewStok.setVisible(false);
            controller.c_beranda mt = new controller.c_beranda(new view.v_beranda());
        }
    }

    private class cetakListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

        }

    }
}
