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
import javafx.beans.binding.Bindings;
import javax.swing.JOptionPane;
import model.m_login;
//import view.v_beranda;
import view.v_login;

/**
 *
 * @author Alif
 */
public class c_login {

    public String username;
    m_login theModel;
    v_login theView;

    public static String id;

    public c_login(m_login theModel, v_login theView) {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.addLoginListener(new loginListener());

    }

    private class loginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                theModel.cekLogin(theView.getTulis_username(), theView.getTulis_password());
                id = m_login.id_user;
                username = theView.getTulis_username();
                System.out.println(theModel.getStatus());
                if (theModel.getStatus().equals("1")) {
                    theView.dispose();
                    controller.c_beranda m = new controller.c_beranda(new view.v_beranda());
                    System.out.println(theModel.getStatus());
                } else if (theModel.getStatus().equals("2")) {
                    theView.dispose();
                    controller.c_pemesanan m = new controller.c_pemesanan(new view.v_pemesanan(), new model.m_pesanan());
                } else if (theModel.getStatus().equals("3")) {
                    theView.dispose();
                    controller.c_beranda m = new controller.c_beranda(new view.v_berandaAdmin());
                } else if (theView.getTulis_username().isEmpty() && theView.getTulis_password().isEmpty()) {
                    JOptionPane.showMessageDialog(theView, "masukkan password dan username");
                } else if (theView.getTulis_password().isEmpty()) {
                    JOptionPane.showMessageDialog(theView, "masukkan password dahulu");
                } else if (theView.getTulis_username().isEmpty()) {
                    JOptionPane.showMessageDialog(theView, "masukkan  username dahulu");

                } else {
                    JOptionPane.showMessageDialog(theView, "masukkan dengan benar");
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Setusername(String username) {
        this.username = username;
    }

    public String getusername() {
        return username;
    }
}
