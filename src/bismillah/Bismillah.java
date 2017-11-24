/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah;

import controller.c_login;
import controller.c_peramalan;
import controller.c_pemanenan;
import controller.c_user;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import model.m_login;
import model.m_peramalan;
import model.m_pemanenan;
import model.m_user;
import view.v_pemanenan;
import view.v_login;
import view.v_peramalan;
import view.v_user;

/**
 *
 * @author Alif
 */
public class Bismillah {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
             m_login theModel = new m_login();
       v_login theView = new v_login();
       c_login theController = new c_login(theModel, theView);
//v_peramalan v=new v_peramalan();
//m_peramalan m=new m_peramalan();
//c_peramalan c=new c_peramalan(v, m);


    }}
    

