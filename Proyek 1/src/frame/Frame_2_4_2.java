/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import code.ClassBarang;
import code.ClassCetakPdf;
import code.ClassTransaksi;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author MSIFAULK
 */
public class Frame_2_4_2 extends javax.swing.JFrame {

    /**
     * Creates new form Frame_2_2
     */
    private String idInvoice, idBarang, idB;
    private String[][] hargaBarangJumlah;
    private String[] barang;
    private int subTotal;
    public Frame_2_4_2() {
        this.setExtendedState(WIDTH);
        if (idInvoice == null) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan Pilih Barang dulu", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            new Frame_2_4().setVisible(true);
        } else {
            initComponents();
        }
    }
    public Frame_2_4_2(String idtrx) {
        initComponents();
        idInvoice = idtrx;
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
        tableModel.addColumn("ID Barang");
        tableModel.addColumn("Nama Barang");
        tableModel.addColumn("Jumlah Barang");
        tableModel.addColumn("Harga Barang");
        tableModel.addColumn("Total Harga");
        tableModel.addColumn("Keuntungan");
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
    }
    private void loadData() {
        ModelTableUser();
        ClassTransaksi ct = new ClassTransaksi();
        ct.getDataInv(idInvoice);
        ClassBarang cb = new ClassBarang();
        hargaBarangJumlah = cb.getHargaBarangJumlahFromIdTrx(idInvoice); // Ubah tipe data menjadi String[][]
        int no = 1;
        int ndata = ct.getNumberTrx();
        Object[][] data = ct.getAllTrx();
        int jumlahIdBarang = hargaBarangJumlah.length;

        for (int i = 0; i < ndata; i++) {
            Object[] data1 = new Object[8 + jumlahIdBarang]; // Inisialisasi array data1 dengan ukuran yang sesuai
            data1[0] = no;
            for (int j = 1; j < 8; j++) {
                data1[j] = data[i][j - 1];
            }
                int hargaBarangBeli = Integer.parseInt(hargaBarangJumlah[i][0]);
                int jumlah = Integer.parseInt(hargaBarangJumlah[i][1]);
                int hargaBarangJual = Integer.parseInt(hargaBarangJumlah[i][2]);
                String idB = hargaBarangJumlah[i][3];
                int subTotal = (hargaBarangJual - hargaBarangBeli) * jumlah;
                System.out.println("Harga Beli : " + hargaBarangBeli + "\nHarga Jual : " + hargaBarangJual + "\nJumlah Barang : " + jumlah);
                System.out.println("Sub Total : " + subTotal);
                int columnIndex = getColumnIndexByIdBarang(idB);

                if (columnIndex != -1) {
                    data1[columnIndex] = subTotal; // Set nilai subTotal pada indeks yang sesuai dengan columnIndex pada data1
                }
//            }
            tableModel.addRow(data1);
            no++;
        }
    }
    private int getColumnIndexByIdBarang(String idB) {
        TableColumnModel columnModel = tbTransaksi.getColumnModel();
        int columnCount = columnModel.getColumnCount();

        for (int i = 0; i < columnCount; i++) {
            TableColumn column = columnModel.getColumn(i);
            String columnName = column.getHeaderValue().toString();

            if (columnName.equals("Keuntungan")) {
                return i; // Jika kolom memiliki nama yang sama dengan idB, kembalikan indeks kolom
            }
        }

        return -1; // Jika tidak ditemukan kolom dengan nama yang sesuai, kembalikan -1
    }
    private void sum(){
        int jumlah = tableModel.getRowCount();
        int sumHarga =0;        
        int sumUntung = 0;
        for (int i = 0; i < jumlah; i++) {
            int dataHarga = Integer.valueOf(tableModel.getValueAt(i, 7).toString());
            int dataUntung = Integer.valueOf(tableModel.getValueAt(i, 8).toString());
            sumUntung += dataUntung;
            sumHarga += dataHarga;
        }
        DecimalFormat DF = new DecimalFormat("#,###,###"); 
        txTotalPemasukkan.setText("Rp " + DF.format(sumHarga));  
        txTotalUntung.setText("Rp " + DF.format(sumUntung));  
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransaksi = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txTotalPemasukkan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txTotalBarang = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txTotalUntung = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1286, 726));

        jPanel1.setBackground(new java.awt.Color(169, 226, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jLabel2.setText("Detail Transaksi");

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
        jScrollPane1.setViewportView(tbTransaksi);

        jButton1.setBackground(new java.awt.Color(255, 99, 129));
        jButton1.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/angle-left.png"))); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txTotalPemasukkan.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        txTotalPemasukkan.setText("1");

        jLabel11.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel11.setText("Total Harga");

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel10.setText("Total Item");

        txTotalBarang.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        txTotalBarang.setText("1");

        jLabel12.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel12.setText("Total Keuntungan");

        txTotalUntung.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        txTotalUntung.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txTotalBarang)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTotalPemasukkan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txTotalUntung, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(469, 469, 469)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txTotalUntung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txTotalPemasukkan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txTotalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Frame_2_4().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_2_4_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_2_4_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_2_4_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_2_4_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_2_4_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTransaksi;
    private javax.swing.JLabel txTotalBarang;
    private javax.swing.JLabel txTotalPemasukkan;
    private javax.swing.JLabel txTotalUntung;
    // End of variables declaration//GEN-END:variables
}
