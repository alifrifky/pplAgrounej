/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alif
 */
public class v_pemanenan extends javax.swing.JFrame {

    /**
     * Creates new form v_metodetanam
     */
    public v_pemanenan() {
        initComponents();
    }

    public int getLevel() {
        return combo.getSelectedIndex();
    }

    public void setLevel(int level) {
        this.combo.setSelectedIndex(level);
    }

    public void setInputStok(String input) {
        this.tulis_input.setText(input);
    }

//    public String getInputStok() {
//        return this.tulis_input.getText();
//    }
    public String getTulis_input() {
        return tulis_input.getText();
    }

    public JDateChooser getKalendar() {
        return kalendar;
    }

    public void setKalendar(String kalendar) {
        this.kalendar.setDate(Date.from(Instant.MAX));
    }

    public void setTable(DefaultTableModel tm) {
        jTable2.setModel(tm);
    }

    public void setuserLogin(String materi) {
        this.total_stok.setText(materi);
    }

    public void addInputStokListener(ActionListener listener) {
        btn_input.addActionListener(listener);
    }

    public void addKembaliListener(ActionListener listener) {
        btn_kembali.addActionListener(listener);
    }

    public void addPeriodeListener(ActionListener listener) {
        combo.addActionListener(listener);
    }

    public void cleardata() {
        tulis_input.setText("");
        kalendar.setCalendar(Calendar.getInstance());
        
    }

    public String getValueAt(int baris, int kolom) {
        return (String) this.jTable2.getValueAt(baris, kolom);
    }

    public int getSelectedRow() {
        return jTable2.getSelectedRow();

    }

    
    

    public void addTableListener(MouseListener listener) {
        jTable2.addMouseListener(listener);
    }

    public void addUpdateListener(ActionListener listener) {
        btn_update.addActionListener(listener);
    }

    public void addHapusListener(ActionListener listener) {
        btn_delete.addActionListener(listener);
    }

    public void addEditListener(ActionListener listener) {
        btn_edit.addActionListener(listener);
    }

    public void enableEdit() {
        btn_edit.setEnabled(true);
    }

    public void disableEdit() {
        btn_edit.setEnabled(false);
    }

    public void enableUpdate() {
        btn_update.setEnabled(true);
    }

    public void enableInput() {
        btn_input.setEnabled(true);
    }

    public void disableUpdate() {
        btn_update.setEnabled(false);
    }

    public void disableInput() {
        btn_input.setEnabled(false);
    }

    public void enableHapus() {
        btn_delete.setEnabled(true);
    }

    public void disableHapus() {
        btn_delete.setEnabled(false);
    }
        public void setTable1(DefaultTableModel tm) {
        jTable1.setModel(tm);
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_kembali = new javax.swing.JButton();
        tulis_input = new javax.swing.JTextField();
        btn_input = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        total_stok = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        kalendar = new com.toedter.calendar.JDateChooser();
        btn_edit = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/btn_kembali.png"))); // NOI18N
        btn_kembali.setContentAreaFilled(false);
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, -1, -1));

        tulis_input.setForeground(new java.awt.Color(255, 255, 255));
        tulis_input.setOpaque(false);
        getContentPane().add(tulis_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 120, -1));

        btn_input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_input.png"))); // NOI18N
        btn_input.setBorderPainted(false);
        btn_input.setContentAreaFilled(false);
        getContentPane().add(btn_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 390, 340));

        total_stok.setFont(new java.awt.Font("Bebas Neue", 2, 24)); // NOI18N
        total_stok.setForeground(new java.awt.Color(255, 255, 255));
        total_stok.setText("sotk");
        getContentPane().add(total_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 80, 60));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 80, 30));
        getContentPane().add(kalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_edit.png"))); // NOI18N
        btn_edit.setContentAreaFilled(false);
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, -1));

        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_update.png"))); // NOI18N
        btn_update.setContentAreaFilled(false);
        btn_update.setEnabled(false);
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/btn_hapus.png"))); // NOI18N
        btn_delete.setContentAreaFilled(false);
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg_pemanenan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
            java.util.logging.Logger.getLogger(v_pemanenan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_pemanenan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_pemanenan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_pemanenan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_pemanenan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_input;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JDateChooser kalendar;
    private javax.swing.JLabel total_stok;
    private javax.swing.JTextField tulis_input;
    // End of variables declaration//GEN-END:variables

    public JTable getjTable2() {
        return jTable2;
    }

    public JLabel getTotal_stok() {
        return total_stok;
    }

}
