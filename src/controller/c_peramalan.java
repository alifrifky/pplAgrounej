/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.m_peramalan;
import view.v_peramalan;

/**
 *
 * @author Alif
 */
public class c_peramalan {

    private view.v_peramalan viewPeramalan;
    private model.m_peramalan modelPeramalan;
    private model.m_pemesanan modelPesanan;
    private view.v_adminPesanan viewAdminPesanan;

    public c_peramalan(v_peramalan viewPeramalan, m_peramalan modelPeramalan) throws SQLException {
        this.viewPeramalan = viewPeramalan;
        viewPeramalan.setVisible(true);
        this.modelPeramalan = modelPeramalan;

        viewPeramalan.addKembaliListener(new kembaliListener());
        viewPeramalan.addPeramalanListener(new peramalanListener());
        viewPeramalan.setTable1(modelPeramalan.getAll());

    }

    private class peramalanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int jumlahBaris = viewPeramalan.getRowCount();
            float Peramalan = 0;
            float pemesanan, nilaiPeramalan;
            int baris = viewPeramalan.getCombo().getSelectedIndex();

            pemesanan = Integer.parseInt(viewPeramalan.getValueAt((baris - 1), 1));
//            System.out.println("jumlahstok" + pemesanan);
            nilaiPeramalan = Float.parseFloat(viewPeramalan.getValueAt((baris - 1), 2));
//            System.out.println("peramalan" + nilaiPeramalan);
            Peramalan = (float) ((0.9 * pemesanan) + ((0.1) * nilaiPeramalan));
//            System.out.println(Peramalan);
            try {
                modelPeramalan.peramalan((float) Peramalan, (String) viewPeramalan.getCombo().getSelectedItem());
                viewPeramalan.setTable1(modelPeramalan.getAll());
                viewPeramalan.setNilai(String.valueOf(Peramalan));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(viewPeramalan, "Maaf Data Peramalan Kosongr");
            }
        }
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewPeramalan.setVisible(false);
            controller.c_beranda mt = new controller.c_beranda(new view.v_berandaAdmin());
        }
    }
}
