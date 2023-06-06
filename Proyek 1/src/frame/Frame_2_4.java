/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import code.ClassBarang;
import code.ClassTransaksi;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author MSIFAULK
 */
public class Frame_2_4 extends javax.swing.JFrame {

    /**
     * Creates new form Frame_2_2
     */
    public Frame_2_4() {
        initComponents();
        this.setExtendedState(WIDTH);
        loadData();
        sum();
    }
    private String namaAkun, idInvoice, idBarang;
    private int index, hargaBarang;
    private int[] hargaBarangArray;
    private String[] idBarangArray;
    public Frame_2_4(String nama) {
        initComponents();
        namaAkun = nama;
        loadData();
        sum();
        
    }
    DefaultTableModel tableModel;
    void ModelTableUser(){
        tableModel = new DefaultTableModel();
        tbTransaksi.setModel(tableModel);
        tableModel.addColumn("No");
        tableModel.addColumn("Tanggal");
        tableModel.addColumn("ID Transaksi");
        tableModel.addColumn("Total Barang");
        tableModel.addColumn("Sub Total");
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        
        // Mengatur ukuran kolom
        TableColumnModel columnModel = tbTransaksi.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(29);  // Kolom "No" dengan lebar 30 piksel
        columnModel.getColumn(1).setPreferredWidth(80);  // Kolom "ID Barang" dengan lebar 80 piksel
        columnModel.getColumn(2).setPreferredWidth(150); // Kolom "Nama Barang" dengan lebar 150 piksel
        columnModel.getColumn(3).setPreferredWidth(100); // Kolom "Jenis Barang" dengan lebar 100 piksel
        columnModel.getColumn(4).setPreferredWidth(100); // Kolom "Tempat Barang" dengan lebar 100 piksel
    }
    private void loadData() {
        ModelTableUser();        
        ClassTransaksi ct = new ClassTransaksi();
        ct.getDataTrx();
        int no = 1;
        int ndata = ct.getNumberTrx();
        Object[][] data = ct.getAllTrx();
        Object[] data1 = new Object[5];
        for (int i = 0; i < ndata; i++) {
            data1[0] = no;
            for (int j = 1; j < 5; j++) {
                data1[j] = data[i][j - 1];
                System.out.println(data1[j]);
            }
            tableModel.addRow(data1);
            no++;
        }
    }
    private void sum(){
        int jumlah = tableModel.getRowCount();
        int sumHarga =0;        
        for (int i = 0; i < jumlah; i++) {
            int dataHarga = Integer.valueOf(tableModel.getValueAt(i, 4).toString());
            sumHarga += dataHarga;
        }
        DecimalFormat DF = new DecimalFormat("#,###,###"); 
        txTotalPemasukkan.setText("Rp " + DF.format(sumHarga));  
        txTotalBarang.setText(String.valueOf(jumlah));
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
        tbTransaksi = new javax.swing.JTable();
        btDetail = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btKembali1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txTotalBarang = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txTotalPemasukkan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(169, 226, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        jLabel1.setText("Cari");

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jLabel2.setText("Daftar Transaksi");

        tbTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTransaksi);

        btDetail.setBackground(new java.awt.Color(167, 253, 204));
        btDetail.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        btDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pencil.png"))); // NOI18N
        btDetail.setText("Detail");
        btDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetailActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(246, 253, 168));
        jButton1.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer.png"))); // NOI18N
        jButton1.setText("Cetak Struk");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btKembali1.setBackground(new java.awt.Color(255, 99, 129));
        btKembali1.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        btKembali1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/angle-left.png"))); // NOI18N
        btKembali1.setText("Kembali");
        btKembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKembali1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel10.setText("Total Barang");

        txTotalBarang.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        txTotalBarang.setText("1");

        jLabel11.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel11.setText("Total Pemasukan");

        txTotalPemasukkan.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        txTotalPemasukkan.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(421, 421, 421))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txTotalPemasukkan)
                .addGap(144, 144, 144)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txTotalBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btKembali1)
                .addGap(18, 18, 18)
                .addComponent(btDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTotalPemasukkan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTotalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btKembali1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(481, 481, 481))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btKembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKembali1ActionPerformed
        // TODO add your handling code here:
        new Frame_2(namaAkun).setVisible(true);
        dispose();
    }//GEN-LAST:event_btKembali1ActionPerformed

    private void btDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetailActionPerformed
        // TODO add your handling code here:
        new Frame_2_4_2(idInvoice).setVisible(true);
        dispose();
    }//GEN-LAST:event_btDetailActionPerformed

    private void tbTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTransaksiMouseClicked
        // TODO add your handling code here:
        index = tbTransaksi.getSelectedRow();
        if (index == -1) {
            return;
        }
        idInvoice = (String) tableModel.getValueAt(index, 2);
        System.out.println("Terpilih " + idInvoice);
//        idBarang = (String) tableModel.getValueAt(index, 3);        
    }//GEN-LAST:event_tbTransaksiMouseClicked

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
            java.util.logging.Logger.getLogger(Frame_2_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_2_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_2_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_2_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_2_4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDetail;
    private javax.swing.JButton btKembali1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbTransaksi;
    private javax.swing.JLabel txTotalBarang;
    private javax.swing.JLabel txTotalPemasukkan;
    // End of variables declaration//GEN-END:variables
}
