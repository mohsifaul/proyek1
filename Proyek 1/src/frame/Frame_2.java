/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import javax.swing.JOptionPane;

/**
 *
 * @author BANI BANN
 */
public class Frame_2 extends javax.swing.JFrame {

    /**
     * Creates new form KOCAK_2
     */
    public Frame_2() {
        if (nama == null) {
            JOptionPane.showConfirmDialog(rootPane, "Silahkan Login Dulu", "INFORMASI", JOptionPane.CLOSED_OPTION);
            new Frame_Login().setVisible(true);
        } else {
            initComponents();
        }
    }
    private String nama;
    public Frame_2(String user) {
        initComponents();
        nama = user;
        txUser.setText(nama);
//      loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btDaftarAnggota = new javax.swing.JButton();
        btMenabung = new javax.swing.JButton();
        btKatalogBarang = new javax.swing.JButton();
        btTransaksi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

<<<<<<< HEAD
        btDaftarAnggota.setText("DAFTAR ANGGOTA");
        btDaftarAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDaftarAnggotaActionPerformed(evt);
            }
        });
=======
        btBayarUang.setBackground(new java.awt.Color(46, 204, 113));
        btBayarUang.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btBayarUang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-add.png"))); // NOI18N
        btBayarUang.setText("DAFTAR ANGGOTA");
>>>>>>> 0521940258b18c6262bb6cdd422aa19b2e241760

        btMenabung.setBackground(new java.awt.Color(46, 204, 113));
        btMenabung.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btMenabung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money-check-edit.png"))); // NOI18N
        btMenabung.setText("TABUNGAN");

        btKatalogBarang.setBackground(new java.awt.Color(46, 204, 113));
        btKatalogBarang.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btKatalogBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-bag.png"))); // NOI18N
        btKatalogBarang.setText("KATALOG BARANG");

<<<<<<< HEAD
        btTransaksi.setText("TRANSAKSI BARANG");
=======
        btAmbilUang.setBackground(new java.awt.Color(46, 204, 113));
        btAmbilUang.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btAmbilUang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file-invoice-dollar.png"))); // NOI18N
        btAmbilUang.setText("TRANSAKSI BARANG");
>>>>>>> 0521940258b18c6262bb6cdd422aa19b2e241760

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("> Bayar Barang :\nDigunakan ketika melakukan\npengelolaan anggota \n\n> Katalog Barang :\nDigunakan untuk membuat\nbarang dan jumlah stok\n\n> Tabungan :\nDigunakan untuk cek saldo\npengajuan ambil uang\n\n> Transaksi Barang :\ndigunakan untuk melihat\nriwayat transaksi yang \ntelah berjalan");
        jScrollPane1.setViewportView(jTextArea1);

        txUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txUser.setText("Nama User");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Frame Mahasiswa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
<<<<<<< HEAD
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btKatalogBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDaftarAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btMenabung, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txUser)))
                .addGap(36, 36, 36)
=======
                    .addComponent(btKatalogBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(btBayarUang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAmbilUang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMenabung, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
>>>>>>> 0521940258b18c6262bb6cdd422aa19b2e241760
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDaftarAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btMenabung, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btKatalogBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDaftarAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDaftarAnggotaActionPerformed
        // TODO add your handling code here:
        new Frame_2_1().setVisible(true);
        dispose();
    }//GEN-LAST:event_btDaftarAnggotaActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDaftarAnggota;
    private javax.swing.JButton btKatalogBarang;
    private javax.swing.JButton btMenabung;
    private javax.swing.JButton btTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel txUser;
    // End of variables declaration//GEN-END:variables
}
