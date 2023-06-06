/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import code.ClassAnggota;
import code.ClassBarang;
import code.ClassPengajuan;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSIFAULK
 */
public class Frame_2_3 extends javax.swing.JFrame {

    /**
     * Creates new form Frame_2_2
     */
    public Frame_2_3() {
        initComponents();
        this.setExtendedState(WIDTH);
        loadData();
    }
    private String namaAkun;
    public Frame_2_3(String nama) {
        initComponents();
        namaAkun = nama;
        loadData();
    }
    DefaultTableModel tableModel;
    int idx_table;
    private String idPengajuan, idAnggota, totalPengajuan, statusPengajuan;
    public void ModelTablePengajuan(){
        tableModel = new DefaultTableModel();
        tbPengajuan.setModel(tableModel);
        tableModel.addColumn("Id Pengajuan");
        tableModel.addColumn("Tanggal Pengajuan");
        tableModel.addColumn("Id Anggota");
        tableModel.addColumn("Total Pengajuan");
        tableModel.addColumn("Status");
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
    }
    void loadData() {
        ModelTablePengajuan();
        ClassPengajuan cp = new ClassPengajuan();
        cp.TampilPengajuan();
        int ndata = cp.getNumberDataPengajuan();
        Object[][] data = cp.getAllDataPengajuan();
        Object[] data1 = new Object[5];
        for (int i = 0; i < ndata; i++) {
            for (int j = 0; j < 5; j++) {
                data1[j] = data[i][j];
            }
            tableModel.addRow(data1);
        }
        int jumlah = tableModel.getRowCount(); 
       txTotalPengajuan.setText(Integer.toString(jumlah));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPengajuan = new javax.swing.JTable();
        btTolak = new javax.swing.JButton();
        btTerima = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txTotalPengajuan = new javax.swing.JLabel();
        btKembali1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(169, 226, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        jLabel1.setText("Cari");

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jLabel2.setText("Daftar Pengajuan");

        tbPengajuan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPengajuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPengajuanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPengajuan);

        btTolak.setBackground(new java.awt.Color(246, 253, 168));
        btTolak.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        btTolak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/decline.png"))); // NOI18N
        btTolak.setText("Tolak");
        btTolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTolakActionPerformed(evt);
            }
        });

        btTerima.setBackground(new java.awt.Color(167, 253, 204));
        btTerima.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        btTerima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/checklist.png"))); // NOI18N
        btTerima.setText("Terima");
        btTerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTerimaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel10.setText("Total Pengajuan");

        txTotalPengajuan.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        txTotalPengajuan.setText("1");

        btKembali1.setBackground(new java.awt.Color(255, 99, 129));
        btKembali1.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        btKembali1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/angle-left.png"))); // NOI18N
        btKembali1.setText("Kembali");
        btKembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKembali1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel2)
                .addGap(0, 687, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txTotalPengajuan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btKembali1)
                .addGap(18, 18, 18)
                .addComponent(btTolak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTerima)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTolak, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(btTerima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btKembali1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTotalPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTerimaActionPerformed
        // TODO add your handling code here:
        if (idx_table == -1) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan Pilih Data", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (statusPengajuan.equals("Diterima")) {
                JOptionPane.showMessageDialog(rootPane, "Pengajuan Telah Diterima", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ClassPengajuan cp = new ClassPengajuan();
                cp.UpdatePengajuan(idPengajuan, "Diterima");
                ClassAnggota ca = new ClassAnggota();
                int saldoAnggota = ca.getSaldo(idAnggota);
                int saldoPengajuan = Integer.parseInt(totalPengajuan);
                int saldoUpdate = saldoAnggota - saldoPengajuan;
                System.out.println("Saldo Anggota" + saldoAnggota);
                System.out.println("Saldo Pengajuan " + saldoPengajuan);
                System.out.println("Saldo Update" + saldoUpdate);
                ca.userNabung(idAnggota, saldoUpdate);
            }
            loadData();
        }
    }//GEN-LAST:event_btTerimaActionPerformed

    private void tbPengajuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPengajuanMouseClicked
        // TODO add your handling code here:
        idx_table = tbPengajuan.getSelectedRow();
        idPengajuan = (String) tableModel.getValueAt(idx_table, 0);
        idAnggota = (String) tableModel.getValueAt(idx_table, 2);
        totalPengajuan = (String) tableModel.getValueAt(idx_table, 3);
        statusPengajuan = (String) tableModel.getValueAt(idx_table, 4);
    }//GEN-LAST:event_tbPengajuanMouseClicked

    private void btTolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTolakActionPerformed
        // TODO add your handling code here:
        if (idx_table == -1) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan Pilih Data", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println(idPengajuan);
            ClassPengajuan cp = new ClassPengajuan();
            cp.UpdatePengajuan(idPengajuan, "Ditolak");
            loadData();
        }
    }//GEN-LAST:event_btTolakActionPerformed

    private void btKembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKembali1ActionPerformed
        // TODO add your handling code here:
        new Frame_2(namaAkun).setVisible(true);
        dispose();
    }//GEN-LAST:event_btKembali1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_2_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_2_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_2_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_2_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_2_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btKembali1;
    private javax.swing.JButton btTerima;
    private javax.swing.JButton btTolak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbPengajuan;
    private javax.swing.JLabel txTotalPengajuan;
    // End of variables declaration//GEN-END:variables
}
