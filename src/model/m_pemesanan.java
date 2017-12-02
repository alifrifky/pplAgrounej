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
public class m_pemesanan {

    private koneksi kon;
    private String status_user;
    public static String kurangi;
    public static String id_periode;
    public static String status;

    public m_pemesanan() throws SQLException {
        kon = new koneksi("root", "", "tembakau");
    }

    public String getStatus() {
        return this.status_user;
    }

    public void pesan(String jumlahstok, String tanggal, String id_user, String periode) throws SQLException {

        String query = "INSERT INTO pesanan VALUES(NULL," + jumlahstok + ",'" + tanggal + "','" + '1' + "'," + id_user + ",'" + periode + "')";
        kon.execute(query);
    }

    public void kurangiUpdate(int jumlahstok) throws SQLException {
        String jumlah = "select stok from updatestok";
        ResultSet rs = kon.getResult(jumlah);
        rs.next();
        int kurangi = rs.getInt("stok") - jumlahstok;
        String query = "UPDATE updatestok SET stok ='" + kurangi + "' WHERE id_stoku =1";
        kon.execute(query);
    }

    public void tolakUpdate(int jumlahstok) throws SQLException {
        String jumlah = "select stok from updatestok";
        ResultSet rs = kon.getResult(jumlah);
        rs.next();
        int jumlahkan = rs.getInt("stok") + jumlahstok;
        String query = "UPDATE updatestok SET stok ='" + jumlahkan + "' WHERE id_stoku =1";
        kon.execute(query);
    }

    public DefaultTableModel gettabel(String id) throws SQLException {
        Object[] header = {"No", "Jumlah Pesanan/kw ", "tanggal pesanan", "status"};

        DefaultTableModel tm = new DefaultTableModel(null, header);
        String sql = "SELECT * FROM pesanan a join status u on a.id_status=u.id_status where id_user= " + id;
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String a[] = new String[4];
            a[0] = rs.getString("id_pesanan");
            a[1] = rs.getString("jumlah_pesanan");
            a[2] = rs.getString("tanggal_pesanan");
            a[3] = rs.getString("status");

            tm.addRow(a);

        }
        return tm;

    }

    public DefaultTableModel gettabelbelum(int periode) throws SQLException {
        Object[] header = {"No", "jumlah pesanan/kw", "tanggal pesanan", "nama user", "status", "Periode"};

        DefaultTableModel tm = new DefaultTableModel(null, header);
        String sql = "SELECT * FROM pesanan a join status u on a.id_status=u.id_status join user us on a.id_user=us.id_user where a.id_status=1 and periode=" + periode;
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String a[] = new String[6];
            a[0] = rs.getString("id_pesanan");
            a[1] = rs.getString("jumlah_pesanan");
            a[2] = rs.getString("tanggal_pesanan");
            a[3] = rs.getString("nama_user");
            a[4] = rs.getString("status");
            a[5] = rs.getString("periode");

            tm.addRow(a);
        }
        return tm;
    }

    public DefaultTableModel gettabelsudah(int periode) throws SQLException {
        Object[] header = {"No", "jumlah pesanan/kw", "tanggal_pesanan", "nama user", "status", "Periode"};

        DefaultTableModel tm = new DefaultTableModel(null, header);
        String sql = "SELECT * FROM pesanan a join status u on a.id_status=u.id_status join user us on a.id_user=us.id_user  where a.id_status=2 and periode=" + periode;
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String a[] = new String[6];
            a[0] = rs.getString("id_pesanan");
            a[1] = rs.getString("jumlah_pesanan");
            a[2] = rs.getString("tanggal_pesanan");
            a[3] = rs.getString("nama_user");
            a[4] = rs.getString("status");
            a[5] = rs.getString("periode");

            tm.addRow(a);
        }
        return tm;
    }

    public void konfirmasi(String id_pesanan) throws SQLException {
        String query = "UPDATE pesanan SET id_status ='" + "2" + "' where id_pesanan =" + id_pesanan;
        kon.execute(query);
    }

    public void tolak(String id_pesanan) throws SQLException {
        String query = "UPDATE pesanan SET id_status ='" + "3" + "' where id_pesanan =" + id_pesanan;
        kon.execute(query);
    }

    public void update(String id_pesanan, String jumlah_pesanan) throws SQLException {
        String query = "UPDATE pesanan SET jumlah_pesanan ='" + jumlah_pesanan + "' WHERE id_status =1 && id_pesanan =" + id_pesanan;
        kon.execute(query);
    }

    public void updateTotal(int totalStok, int periode) throws SQLException {
        String query = "UPDATE peramalan SET total_stok ='" + totalStok + "' WHERE periode =" + periode;
        kon.execute(query);
    }

}
