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
public class m_pemanenan {

    private koneksi kon;
    private String status_user;
    public static String hitung;

    public m_pemanenan() throws SQLException {
        kon = new koneksi("root", "", "tembakau");
    }

    public String getStatus() {
        return this.status_user;
    }

    public void save(float jumlahpanen, String tanggal, String id_user,int periode) throws SQLException {
        String query = "INSERT INTO pemanenan VALUES(NULL," + jumlahpanen + ",'" + tanggal + "'," + id_user + ","+periode+")";
    
        kon.execute(query);
   
    }

    public DefaultTableModel getDataTabel(int periode) throws SQLException {
        Object[] header = {"No", "Jumlah Panen", "tanggal", "nama_user"};

        DefaultTableModel tm = new DefaultTableModel(null, header);
        String sql = "SELECT * FROM pemanenan s join user u on s.id_user=u.id_user where id_level=1 and periode="+periode ;
        ResultSet rs = kon.getResult(sql);
        
        while (rs.next()) {
            String a[] = new String[4];
            a[0] = rs.getString("id_pemanenan");
            a[1] = rs.getString("jumlah_panen");
            a[2] = rs.getString("tanggal");
            a[3] = rs.getString("nama_user");

            tm.addRow(a);
        }
        return tm;
    }

    public void tambahUpdate(float jumlahpanen) throws SQLException {
        String jumlah = "select stok from updatestok";
        ResultSet rs = kon.getResult(jumlah);
        rs.next();
        float hitungkan = rs.getInt("stok") + jumlahpanen;
        String query = "UPDATE updatestok SET stok ='" + hitungkan + "' WHERE id_stoku =1";
        kon.execute(query);
     
    }

    public String select() throws SQLException {
        String sql = "SELECT * FROM updatestok";
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            hitung = rs.getString("stok");
        }
        return hitung;
    }
     

    public void update(String id_pemanenan,float total) throws SQLException {
        String query = "UPDATE pemanenan SET jumlah_panen ='" + total + "' WHERE id_pemanenan =" + id_pemanenan;
        kon.execute(query);
        System.out.println(query);
    }

    public void delete(String id_pemanenan) throws SQLException {
        String query = "DELETE FROM pemanenan where id_user ='" + id_pemanenan + "'";
        
        kon.execute(query);
    }
}
