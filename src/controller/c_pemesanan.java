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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import model.m_login;
import model.m_peramalan;
import model.m_pesanan;
import view.v_adminPesanan;
import view.v_login;
import view.v_pemesanan;

/**
 *
 * @author Alif
 */
public class c_pemesanan {

    private view.v_pemesanan viewPesanan;
    private view.v_login viewLogin;

    private model.m_pesanan modelPesanan;
    public static String jumlahStok;

    private controller.c_login cLogin;
    v_adminPesanan viewAdminPesanan;

    public c_pemesanan(v_pemesanan viewPesanan, m_pesanan modelPesanan) throws SQLException {
        this.viewPesanan = viewPesanan;
        this.modelPesanan = modelPesanan;
        viewPesanan.setVisible(true);
        viewPesanan.addPesanListener(new controller.c_pemesanan.pesanListener());
        viewPesanan.addKeluaristener(new controller.c_pemesanan.keluarListener());
        viewPesanan.setTable1(this.modelPesanan.gettabel(m_login.id_user));
        viewPesanan.addEditListener(new editListener());
        viewPesanan.addUpdateListener(new updateListener());
        viewPesanan.addTableListener(new TableListener());

    }

    public c_pemesanan(v_adminPesanan viewAdminPesanan, m_pesanan modelPesanan) throws SQLException {
        this.viewAdminPesanan = viewAdminPesanan;
        this.modelPesanan = modelPesanan;

        viewAdminPesanan.setVisible(true);
        viewAdminPesanan.setTable1(this.modelPesanan.gettabelbelum(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
        viewAdminPesanan.setTable2(this.modelPesanan.gettabelsudah(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
//        viewAdminPesanan.addTableListener(new TableListener());
        viewAdminPesanan.addKonfirmasiListener(new KonfirmasiListener());
        viewAdminPesanan.addTolakListener(new TolakListener());
        viewAdminPesanan.addPeriodeListener(new periodeListener());
        viewAdminPesanan.addJumlahkanListener(new jumlahkanListener());
        viewAdminPesanan.addKembaliListener(new BackListener());

    }

    private class pesanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(fm.format(viewPesanan.getKalender().getDate()));
            SimpleDateFormat a = new SimpleDateFormat("yyyy");
            String tahun = String.valueOf(a.format(viewPesanan.getKalender().getDate()));
            try {
                modelPesanan.pesan(viewPesanan.getTulis_pesanan(), tanggal, m_login.id_user, tahun);
                modelPesanan.kurangiUpdate(Integer.parseInt(viewPesanan.getTulis_pesanan()));
                viewPesanan.setTable1(modelPesanan.gettabel(m_login.id_user));
                viewPesanan.cleardata();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    private class keluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                new c_login(new m_login(), new v_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewPesanan.dispose();

        }

    }

    class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            viewPesanan.enableEdit();
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

    private class KonfirmasiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                modelPesanan.konfirmasi(viewAdminPesanan.getSelectedID_pesanan());
                System.out.println(viewAdminPesanan.getSelectedID_pesanan());
                viewAdminPesanan.setTable1(modelPesanan.gettabelbelum(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
                viewAdminPesanan.setTable2(modelPesanan.gettabelsudah(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(viewAdminPesanan, "pilih disek lur");
            }
        }

    }

    private class TolakListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                if (viewAdminPesanan.getjTable1().getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(viewPesanan, "milio disek lah");
                } else {
                    jumlahStok = (String) viewAdminPesanan.getjTable1().getValueAt(viewAdminPesanan.getjTable1().getSelectedRow(), 1);
                    modelPesanan.tolak((String) viewAdminPesanan.getjTable1().getValueAt(viewAdminPesanan.getjTable1().getSelectedRow(), 0));
                    modelPesanan.tolakUpdate(Integer.parseInt(jumlahStok));
                    viewAdminPesanan.setTable1(modelPesanan.gettabelbelum(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
                    viewAdminPesanan.setTable2(modelPesanan.gettabelsudah(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
                }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(viewAdminPesanan, "pilih disek lur");
            }
        }

    }

    private class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPesanan.disablePesan();
            viewPesanan.enableUpdate();
            int baris = viewPesanan.getSelectedRow();
            if (baris != -1) {

                String jumlah_pesanan = viewPesanan.getValueAt(baris, 1);

                viewPesanan.setTulis_pesanan(jumlah_pesanan);

                viewPesanan.enableUpdate();

            }

        }
    }

    private class periodeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                viewAdminPesanan.setTable1(modelPesanan.gettabelbelum(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
                viewAdminPesanan.setTable2(modelPesanan.gettabelsudah(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())));
            } catch (SQLException ex) {
                Logger.getLogger(c_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                int baris = viewPesanan.getSelectedRow();
                String id = viewPesanan.getValueAt(baris, 0);
                String jumlah_pesanan = viewPesanan.getTulis_pesanan();
                modelPesanan.update(id, jumlah_pesanan);
                viewPesanan.cleardata();
                viewPesanan.setTable(modelPesanan.gettabel(m_login.id_user));
                viewPesanan.disableEdit();
                viewPesanan.disableUpdate();
                viewPesanan.enablePesan();
            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class jumlahkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                int baris = viewAdminPesanan.getRowCount();
                int total = 0;
                for (int i = 0; i < modelPesanan.gettabelsudah(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())).getRowCount(); i++) {
                    int amount = Integer.parseInt((String) modelPesanan.gettabelsudah(Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem())).getValueAt(i, 1));
                    total += amount;
                }

                modelPesanan.updateTotal(total, Integer.parseInt((String) viewAdminPesanan.getCombo().getSelectedItem()));

            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewAdminPesanan.setVisible(false);
            controller.c_beranda mt = new controller.c_beranda(new view.v_berandaAdmin());
        }
    }

}
