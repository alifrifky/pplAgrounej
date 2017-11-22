/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alif
 */
public class m_user {

    private koneksi kon;
    private String password;

    public m_user() throws SQLException {
        kon = new koneksi("root", "", "tembakau");
    }

    public String getPassword() {
        return this.password;
    }

    public void save(String username, String password, String nama, String alamat, String level) throws SQLException {
        String query = "INSERT INTO user VALUES(NULL,'" + username + "','" + password + "','" + nama + "','" + alamat + "','" + level + "')";
        kon.execute(query);
        System.out.println(query);
    }

    public void update(String id_user,String username, String password, String nama, String alamat) throws SQLException {
        String query = "UPDATE user SET user_name ='" + username + "', password = '" + password + "', nama_user ='" + nama + "', alamat = '" + alamat + "' WHERE nama_user =" + id_user;
        kon.execute(query);
        System.out.println(query);
    }

    public void delete(String iduser) throws SQLException {
        String query = "DELETE FROM user where id_user ='" + iduser + "'";
        
        kon.execute(query);
    }
    public DefaultTableModel gettabel() throws SQLException {
        Object[] header = {"id","username", "Nama", "Alamat","Paswword", "Status Sebagai"};

        DefaultTableModel tm = new DefaultTableModel(null, header);
        String sql = "SELECT * FROM user u join user_level ul on u.id_level=ul.id_level";

        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String a[] = new String[6];
            a[0] = rs.getString("id_user");
            a[1] = rs.getString("user_name");
            a[2] = rs.getString("nama_user");
            a[3] = rs.getString("alamat");
            a[4] = rs.getString("password");
            a[5] = rs.getString("nama_level");
            

            tm.addRow(a);
        }

        return tm;
    }

   
}
