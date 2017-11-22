/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alif
 */
public class v_adminPesanan extends javax.swing.JFrame {

    /**
     * Creates new form v_admin
     */
    public v_adminPesanan() {
        initComponents();
    }

    public JTable getTabel() {
        return jTable1;
    }

    public String getId() {
        return id.getText();
    }

    public void setId(String id) {
        this.id.setText(id);
    }

    public int getSelectedRow() {
        return jTable1.getSelectedRow();
    }

    public int getRowCount() {
        return jTable1.getRowCount();
    }

    public String getSelectedID_pesanan() {
        return jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
    }

    public String getValueAt(int baris, int kolom) {
        return (String) this.jTable1.getValueAt(baris, kolom);
    }

    public void setTable1(DefaultTableModel tm) {
        jTable1.setModel(tm);
    }

    public void setTable2(DefaultTableModel tm) {
        jTable2.setModel(tm);
    }

    public void addTableListener(MouseListener listener) {
        jTable1.addMouseListener(listener);
    }

    public JTable getjTable1() {
        return jTable1;
    }
    
    

    public String getSelected() {
        return jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
    }

    public void addKonfirmasiListener(ActionListener e) {
        this.btn_konfirmasi.addActionListener(e);
    }

    public void addJumlahkanListener(ActionListener e) {
        this.btn_jumlahkan.addActionListener(e);
    }

    public void addTolakListener(ActionListener e) {
        this.btn_tolak.addActionListener(e);
    }

    public void addKembaliListener(ActionListener e) {
        this.btn_kembali.addActionListener(e);
    }

    public JComboBox<String> getCombo() {
        return combo;
    }

    public void setLevel(int level) {
        this.combo.setSelectedIndex(level);
    }

    public void addPeriodeListener(ActionListener listener) {
        combo.addActionListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_konfirmasi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        id = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_tolak = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        btn_jumlahkan = new javax.swing.JButton();
        btn_kembali = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_konfirmasi.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alif\\Downloads\\expotan\\1\\konfirmasi (2).png")); // NOI18N
        btn_konfirmasi.setBorderPainted(false);
        btn_konfirmasi.setContentAreaFilled(false);
        getContentPane().add(btn_konfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 690, 150));

        id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("belum di konfirmasi");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 690, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sudah di konfirmasi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, -1, -1));

        btn_tolak.setText("Tolak");
        getContentPane().add(btn_tolak, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021" }));
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));

        btn_jumlahkan.setText("Jumlahkan");
        getContentPane().add(btn_jumlahkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        btn_kembali.setText("KEMBALI");
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/konfirmasiii.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(v_adminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_adminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_adminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_adminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_adminPesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_jumlahkan;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_konfirmasi;
    private javax.swing.JButton btn_tolak;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
