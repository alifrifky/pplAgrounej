/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author Alif
 */
public class v_berandaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form v_berandaAdmin
     */
    public v_berandaAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_pemesanan = new javax.swing.JButton();
        btn_user = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_peramalan = new javax.swing.JButton();
        btn_stok = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_pemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_pemesanan.png"))); // NOI18N
        btn_pemesanan.setContentAreaFilled(false);
        getContentPane().add(btn_pemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 150, 150));

        btn_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_user.png"))); // NOI18N
        btn_user.setContentAreaFilled(false);
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });
        getContentPane().add(btn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 150, 150));

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/btn_logout.png"))); // NOI18N
        btn_logout.setContentAreaFilled(false);
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, -1));

        btn_peramalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_peramalan.png"))); // NOI18N
        btn_peramalan.setContentAreaFilled(false);
        getContentPane().add(btn_peramalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 150, 150));

        btn_stok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_monitoring.png"))); // NOI18N
        btn_stok.setContentAreaFilled(false);
        getContentPane().add(btn_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 150, 150));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("ADMIN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 80, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_homepetani.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_userActionPerformed
    public void addUserListener(ActionListener listener) {
        btn_user.addActionListener(listener);
    }

    public void addPemesananListener(ActionListener listener) {
        btn_pemesanan.addActionListener(listener);
    }
     public void addPeramalanListener(ActionListener listener) {
        btn_peramalan.addActionListener(listener);
    }
   
      public void addlogoutListener(ActionListener listener) {
        btn_logout.addActionListener(listener);
    }
      public void addStokListener(ActionListener listener) {
        btn_stok.addActionListener(listener);
    }

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
            java.util.logging.Logger.getLogger(v_berandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_berandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_berandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_berandaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_berandaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_pemesanan;
    private javax.swing.JButton btn_peramalan;
    private javax.swing.JToggleButton btn_stok;
    private javax.swing.JButton btn_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
