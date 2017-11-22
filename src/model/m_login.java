/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alif
 */
public class m_login {

    private koneksi kon;
    private String status_user;
    
    public static String id_user;
    

    public m_login() throws SQLException {
        kon = new koneksi("root", "", "tembakau");
        status_user = "";
    }

    public void cekLogin(String useraname, String password) throws SQLException {

        String query = "select * from user "
                + "where user_name='" + useraname + "' and "
                + "password ='" + password + "';";
        System.out.println(query);
      
        ResultSet rs = kon.getResult(query);

        if (rs.next()) {
            status_user = rs.getString("id_level");
            id_user = rs.getString("id_user");
        }

    }

    public static String getId_user() {
        return id_user;
    }
    
    public String getStatus() {
        return this.status_user;
    }

   

}
