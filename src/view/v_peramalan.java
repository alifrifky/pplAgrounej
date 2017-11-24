/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alif
 */
public class v_peramalan extends javax.swing.JFrame {

    /**
     * Creates new form view_peramalan
     */
    public v_peramalan() {
        initComponents();
    }

    public void addPeramalanListener(ActionListener listener) {
        btn_peramalan.addActionListener(listener);
    }
    public void addKembaliListener(ActionListener listener) {
        btn_kembali.addActionListener(listener);
    }
    
    
     public JComboBox<String> getCombo() {
        return combo;
    }
      public void setTable1(DefaultTableModel tm) {
        tabel.setModel(tm);
    }
       public String getValueAt(int baris, int kolom) {
        return (String) this.tabel.getValueAt(baris, kolom);
    }
public int getRowCount() {
        return tabel.getRowCount();
    }

    public JTable getTabel() {
        return tabel;
    }

    public void setNilai(String nilai) {
        this.nilai.setText(nilai);
    }

//    public void SetPeramalan(float jTextArea1) {
//        this.jTextArea1.setText("Hasil Peramalan untuk "+getCombo().getSelectedItem()+"="+jTextArea1); ;
//    }

  
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        combo = new javax.swing.JComboBox<>();
        btn_peramalan = new javax.swing.JButton();
        btn_kembali = new javax.swing.JToggleButton();
        nilai = new javax.swing.JLabel();
        nilai1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 319, 271));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2015", "2016", "2017", "2018", "2019", "2020", "2021" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, 37));

        btn_peramalan.setIcon(new javax.swing.ImageIcon("E:\\Kuliah\\Semester 5\\PPL AGRO\\UI PPL\\btn_peraaamaaalan.png")); // NOI18N
        btn_peramalan.setContentAreaFilled(false);
        getContentPane().add(btn_peramalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        btn_kembali.setIcon(new javax.swing.ImageIcon("E:\\Kuliah\\Semester 5\\PPL AGRO\\UI PPL\\btn_kembali.png")); // NOI18N
        btn_kembali.setBorderPainted(false);
        btn_kembali.setContentAreaFilled(false);
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        nilai.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        nilai.setForeground(new java.awt.Color(255, 204, 0));
        nilai.setText("Nilai Peramalan");
        getContentPane().add(nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 180, 30));

        nilai1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        nilai1.setForeground(new java.awt.Color(255, 255, 255));
        nilai1.setText("jLabel1");
        getContentPane().add(nilai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_peramalan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

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
            java.util.logging.Logger.getLogger(v_peramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_peramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_peramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_peramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_peramalan().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_kembali;
    private javax.swing.JButton btn_peramalan;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nilai;
    private javax.swing.JLabel nilai1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables

    

    
}
