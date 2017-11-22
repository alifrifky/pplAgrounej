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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_user;
import view.v_tambahUser;

/**
 *
 * @author Alif
 */
public class c_user {

    private view.v_tambahUser viewUser;
    private model.m_user modelUser;

    public c_user(v_tambahUser viewUser, m_user modelUser) throws SQLException {
        this.viewUser = viewUser;
        this.modelUser = modelUser;
        this.viewUser.setVisible(true);

        viewUser.addTambahListener(new tambahListener());
        viewUser.addEditListener(new editListener());
        viewUser.addUpdateListener(new updateListener());
        viewUser.addHapusListener(new hapusListener());
        viewUser.setTable(modelUser.gettabel());
        viewUser.addTableListener(new TableListener());
        viewUser.addKembaliListener(new KembaliListener());

    }

    private class tambahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                modelUser.save(viewUser.getTulis_username(), viewUser.getTulis_Password(), viewUser.getTulis_nama(), viewUser.getTulis_alamat(), String.valueOf(viewUser.getLevel()+1));
                viewUser.setTable(modelUser.gettabel());
                viewUser.cleardata();
            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                int baris = viewUser.getSelectedRow();
                String id = viewUser.getValueAt(baris, 0);
                modelUser.delete(id);
                viewUser.setTable(modelUser.gettabel());
                

            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewUser.disableTambah();
            viewUser.enableUpdate();
            int baris = viewUser.getSelectedRow();
            if (baris != -1) {

                String username = viewUser.getValueAt(baris, 1);
                String nama = viewUser.getValueAt(baris, 2);
                String alamat = viewUser.getValueAt(baris, 3);
                String password = viewUser.getValueAt(baris, 4);

                viewUser.setTulis_username(username);
                viewUser.setTulis_nama(nama);
                viewUser.setTulis_alamat(alamat);
                viewUser.setTulis_password(password);
                viewUser.enableUpdate();

            }

        }
    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                int baris = viewUser.getSelectedRow();
                String id = viewUser.getValueAt(baris, 0);
//                int id = Integer.parseInt(iduser);
                String username = viewUser.getTulis_username();
                String password = viewUser.getTulis_Password();
                String nama = viewUser.getTulis_nama();
                String alamat = viewUser.getTulis_alamat();
                modelUser.update(id, username, password, nama, alamat);
                viewUser.cleardata();
                viewUser.setTable(modelUser.gettabel());
                viewUser.disableEdit();
                viewUser.disableUpdate();
                viewUser.enableTambah();
            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

            viewUser.enableEdit();
            viewUser.enableDelete();

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
    private class KembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            viewUser.setVisible(false);
            controller.c_beranda mt = new controller.c_beranda(new view.v_berandaAdmin());
        }
    }
}
