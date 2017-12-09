/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import model.m_pemanenan;
import view.v_pemanenan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.m_login;
import view.v_stok;

/**
 *
 * @author Alif
 */
public class c_pemanenan {

    public int stok;
    private view.v_pemanenan viewPemanenan;
    private view.v_stok viewStok;

    private view.v_beranda viewBeranda;
    private view.v_login viewLogin;

    private model.m_pemanenan modelPemanenan;
    private controller.c_login cLogin;

    public c_pemanenan(v_pemanenan viewPemanenan, m_pemanenan modelPemanenan) throws SQLException {
        this.viewPemanenan = viewPemanenan;
        this.modelPemanenan = modelPemanenan;
        viewPemanenan.setVisible(true);
        c_stok();
        viewPemanenan.addInputStokListener(new inputPemanenanListener());
        viewPemanenan.addKembaliListener(new kembaliListener());
        viewPemanenan.setTable(modelPemanenan.getTable(viewPemanenan.getLevel() + 1));
        viewPemanenan.addPeriodeListener(new periodeListener());
        viewPemanenan.addEditListener(new editListener());
        viewPemanenan.addHapusListener(new hapusListener());
        viewPemanenan.addUpdateListener(new updateListener());
        viewPemanenan.addTableListener(new TableListener());

    }

    public c_pemanenan(v_stok viewStok, m_pemanenan modelStok) throws SQLException {
        this.modelPemanenan = modelStok;
        this.viewStok = viewStok;
        viewStok.setVisible(true);
        viewStok.addKembaliListener(new backListener());
        viewStok.setTable1(modelStok.getTable(viewStok.getCombo().getSelectedIndex()));
        viewStok.setNilai(modelPemanenan.select());

        viewStok.addComboListener(new tahunListener());
    }

    private class tahunListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                viewStok.setTable1(modelPemanenan.getTable(viewStok.getCombo().getSelectedIndex()));

            } catch (SQLException ex) {
                Logger.getLogger(c_pemanenan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewStok.setVisible(false);
            controller.c_beranda mt = new controller.c_beranda(new view.v_berandaAdmin());
        }
    }

    private class inputPemanenanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat a = new SimpleDateFormat("yyyy");

            String tanggal = String.valueOf(fm.format(viewPemanenan.getKalendar().getDate()));
            String tahun = String.valueOf(a.format(viewPemanenan.getKalendar().getDate()));

            try {
                if (viewPemanenan.getTulis_input().isEmpty()) {
                    JOptionPane.showMessageDialog(viewStok, "masukkan data terlebih dahulu");

                } else {
                    modelPemanenan.save(Float.parseFloat(viewPemanenan.getTulis_input()), tanggal, m_login.id_user, viewPemanenan.getLevel() + 1);
                    modelPemanenan.tambahUpdate(Float.parseFloat(viewPemanenan.getTulis_input()));
                    viewPemanenan.setTable(modelPemanenan.getTable(viewPemanenan.getLevel() + 1));
                    viewPemanenan.cleardata();
                }
            } catch (SQLException ex) {

            }

        }
    }

    private class periodeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                viewPemanenan.setTable(modelPemanenan.getTable(viewPemanenan.getLevel() + 1));
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    private void c_stok() throws SQLException {

        modelPemanenan.select();
        String hitung = m_pemanenan.hitung;
        viewPemanenan.getTotal_stok().setText(hitung);
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewPemanenan.setVisible(false);
            controller.c_beranda mt = new controller.c_beranda(new view.v_beranda());
        }
    }

    private class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPemanenan.disableInput();
            viewPemanenan.enableUpdate();
            int baris = viewPemanenan.getSelectedRow();
            if (baris != -1) {

                String jumlah = viewPemanenan.getValueAt(baris, 1);
                stok = Integer.parseInt(jumlah);
                viewPemanenan.setInputStok(jumlah);

                viewPemanenan.enableUpdate();

            }

        }
    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                int baris = viewPemanenan.getSelectedRow();
                String id = viewPemanenan.getValueAt(baris, 0);

                float jumlah = Float.parseFloat(viewPemanenan.getTulis_input());

                float updatestok = (float) ((jumlah) - stok);

                modelPemanenan.update(id, jumlah);
                modelPemanenan.tambahUpdate(updatestok);
                viewPemanenan.cleardata();
                viewPemanenan.setTable(modelPemanenan.getTable(viewPemanenan.getLevel() + 1));
                viewPemanenan.disableEdit();
                viewPemanenan.disableUpdate();
                viewPemanenan.enableInput();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(viewPemanenan, "masukkan dengan benar");
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int baris = viewPemanenan.getSelectedRow();
            String id = viewPemanenan.getValueAt(baris, 0);
            try {
                modelPemanenan.delete(id);
                viewPemanenan.setTable(modelPemanenan.getTable(viewPemanenan.getLevel() + 1));

            } catch (SQLException ex) {
                Logger.getLogger(c_pemanenan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            viewPemanenan.enableEdit();
            viewPemanenan.enableHapus();
        }

        @Override
        public void mousePressed(MouseEvent me) {

        }

        @Override
        public void mouseReleased(MouseEvent me) {

        }

        @Override
        public void mouseEntered(MouseEvent me) {

        }

        @Override
        public void mouseExited(MouseEvent me) {

        }

    }

}
