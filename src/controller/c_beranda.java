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
import model.m_login;
import model.m_pesanan;
import model.m_pemanenan;
import view.v_adminPesanan;
import view.v_beranda;
import view.v_berandaAdmin;
import view.v_login;
import view.v_pemanenan;
import view.v_pemesanan;
import view.v_user;

/**
 *
 * @author Alif
 */
public class c_beranda {

    v_beranda viewBeranda;
    v_pemanenan viewStok;
    v_pemesanan viewPesanan;
    v_berandaAdmin viewberandaAdmin;

    public c_beranda(v_beranda viewBeranda) {
        this.viewBeranda = viewBeranda;
        viewBeranda.setVisible(true);
        viewBeranda.addinputListener(new inputListener());
        viewBeranda.adddlogoutListener(new logout());
    }

    public c_beranda(v_berandaAdmin viewberandaAdmin) {

        this.viewberandaAdmin = viewberandaAdmin;
        viewberandaAdmin.setVisible(true);
        viewberandaAdmin.addUserListener(new userListener());
   
        viewberandaAdmin.addPemesananListener(new pemesananListener());
        viewberandaAdmin.addStokListener(new stokListener());

        viewberandaAdmin.addlogoutListener(new LogoutListener());
        viewberandaAdmin.addPeramalanListener(new PeramalanListener());
    }

    private class logout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                c_login a = new c_login(new m_login(), new v_login());
                viewBeranda.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class inputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            try {
                c_pemanenan b = new c_pemanenan(new v_pemanenan(), new m_pemanenan());
                viewBeranda.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class LogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
            c_login a = new c_login(new m_login(), new v_login());
            viewberandaAdmin.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class userListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                controller.c_user m = new controller.c_user(new view.v_user(), new model.m_user());
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewberandaAdmin.dispose();

        }

    }
    private class stokListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                controller.c_pemanenan m = new controller.c_pemanenan(new view.v_stok(), new model.m_pemanenan());
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewberandaAdmin.dispose();

        }

    }
    

    private class PeramalanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                controller.c_peramalan m = new controller.c_peramalan(new view.v_peramalan(), new model.m_peramalan());
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewberandaAdmin.dispose();

        }

    }

    private class pemesananListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                controller.c_pemesanan m = new controller.c_pemesanan(new view.v_adminPesanan(), new model.m_pesanan());
            } catch (SQLException ex) {
                Logger.getLogger(c_beranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewberandaAdmin.dispose();

        }

    }}

   
