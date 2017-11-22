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
public class m_peramalan {

    private koneksi kon;
    public static int jumlahTotal;
    public static String peramlan;

    public m_peramalan() throws SQLException {
        kon = new koneksi("root", "", "tembakau");
    }

    public DefaultTableModel getAll() throws SQLException {
        Object[] header = {"id_peramalan", "jumlah pemesanan/ton", "Hasil Ramalan", "Periode"};

        DefaultTableModel tm = new DefaultTableModel(null, header);
        String sql = "SELECT * FROM peramalan";
        ResultSet rs = kon.getResult(sql);

        while (rs.next()) {
            String a[] = new String[4];
            a[0] = rs.getString("id_peramalan");
            a[1] = rs.getString("total_stok");
            a[2] = rs.getString("hasil_peramalan");
            a[3] = rs.getString("periode");

            tm.addRow(a);
        }
        return tm;
    }

    public void peramalan(float peramalan, String periode) throws SQLException {
        String query = "UPDATE peramalan SET hasil_peramalan =" + peramalan + "where periode=" + periode;
        kon.execute(query);
//        peramlan = peramalan;
        System.out.println(query);
    }

}
