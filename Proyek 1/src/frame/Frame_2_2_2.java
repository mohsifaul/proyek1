/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import code.ClassAnggota;
import code.ClassBarang;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author BANI BANN
 */
public class Frame_2_2_2 extends javax.swing.JFrame {

    /**
     * Creates new form KOCAK_1_1
     */
    public Frame_2_2_2() {
        initComponents();
        this.setExtendedState(WIDTH);
        loadData();
    }
    void filterangka(KeyEvent b){
        if(Character.isAlphabetic(b.getKeyChar())){
            b.consume();
            JOptionPane.showMessageDialog(null,"Pada Kolom Username Hanya Bisa Memasukan Angka");
        }
    }
    DefaultTableModel tableModel;
    void ModelTableUser(){
        tableModel = new DefaultTableModel();
        tbBarang.setModel(tableModel);
        tableModel.addColumn("No");
        tableModel.addColumn("ID Barang");
        tableModel.addColumn("Nama Barang");
        tableModel.addColumn("Jenis Barang");
        tableModel.addColumn("Tempat");
        tableModel.addColumn("Stok");
        tableModel.addColumn("Harga Beli");
        tableModel.addColumn("Harga Jual");
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        
        // Mengatur ukuran kolom
        TableColumnModel columnModel = tbBarang.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(29);  // Kolom "No" dengan lebar 30 piksel
        columnModel.getColumn(1).setPreferredWidth(80);  // Kolom "ID Barang" dengan lebar 80 piksel
        columnModel.getColumn(2).setPreferredWidth(150); // Kolom "Nama Barang" dengan lebar 150 piksel
        columnModel.getColumn(3).setPreferredWidth(100); // Kolom "Jenis Barang" dengan lebar 100 piksel
        columnModel.getColumn(4).setPreferredWidth(100); // Kolom "Tempat Barang" dengan lebar 100 piksel
        columnModel.getColumn(5).setPreferredWidth(50);  // Kolom "Stok" dengan lebar 50 piksel
        columnModel.getColumn(6).setPreferredWidth(100); // Kolom "Harga Beli" dengan lebar 100 piksel
        columnModel.getColumn(7).setPreferredWidth(100); // Kolom "Harga Jual" dengan lebar 100 piksel
    }
    void loadData() {
        ModelTableUser();
        ClassBarang cb = new ClassBarang();
        cb.TampilBarang();
        int no = 1;
        int ndata = cb.getNumberDataBarang();
        Object[][] data = cb.getAllDataBarang();
        Object[] data1 = new Object[8];
        for (int i = 0; i < ndata; i++) {
            data1[0] = no;
            for (int j = 1; j < 8; j++) {
                data1[j] = data[i][j - 1];
                System.out.println(data1[j]);
            }
            tableModel.addRow(data1);
            no++;
        }
        
        int jumlah = tableModel.getRowCount(); 
       txTotalBarang.setText(Integer.toString(jumlah));
    }
    void clearData(){
        txIdBarang.setEnabled(true);
        txIdBarang.setEditable(true);
        txIdBarang.setText("");
        txJenisBarang.setText("");
        txRakBarang.setText("");
        txNamaBarang.setText("");
        txStock.setValue(0);
        txHargaBeli.setText("");
        txHargaJual.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBarang = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btTambah = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        txIdBarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txNamaBarang = new javax.swing.JTextField();
        btHapus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txHargaBeli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txStock = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txHargaJual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txTotalBarang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txJenisBarang = new javax.swing.JTextField();
        txRakBarang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 153));

        jPanel1.setBackground(new java.awt.Color(169, 226, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        tbBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBarang);

        jTextField1.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-interface-symbol.png"))); // NOI18N
        jLabel1.setText("Cari");

        btTambah.setBackground(new java.awt.Color(46, 204, 113));
        btTambah.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btTambah.setText("Tambah");
        btTambah.setEnabled(false);
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });

        btEdit.setBackground(new java.awt.Color(241, 196, 15));
        btEdit.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btEdit.setText("Edit");
        btEdit.setEnabled(false);
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        txIdBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txIdBarangKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel2.setText("Kode Barang :");

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel3.setText("Nama Barang :");

        btHapus.setBackground(new java.awt.Color(231, 76, 60));
        btHapus.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        btHapus.setText("Hapus");
        btHapus.setEnabled(false);
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(246, 253, 168));
        jButton4.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer.png"))); // NOI18N
        jButton4.setText("Cetak");

        jButton5.setBackground(new java.awt.Color(255, 99, 129));
        jButton5.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/angle-left.png"))); // NOI18N
        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel4.setText("Stok :");

        txHargaBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txHargaBeliKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel5.setText("Harga Beli");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel6.setText("Harga Jual");

        txHargaJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txHargaJualKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jLabel7.setText("Data Barang");

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel10.setText("Total Barang");

        txTotalBarang.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        txTotalBarang.setText("1");

        jLabel8.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel8.setText("Jenis Barang");

        txRakBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRakBarangActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel9.setText("Letak Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(txJenisBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(txIdBarang)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(19, 19, 19)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txNamaBarang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txStock)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 75, Short.MAX_VALUE))))
                            .addComponent(jLabel9)
                            .addComponent(txRakBarang, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 628, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txTotalBarang)
                                .addGap(76, 76, 76))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7)))
                .addGap(28, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txIdBarang)
                            .addComponent(txNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txRakBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTotalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        String idBarang = txIdBarang.getText();
        String namaBarang = txNamaBarang.getText();
        String jenisBarang = txJenisBarang.getText();
        int stokB = (int) txStock.getValue();
        String hargaB = txHargaBeli.getText();
        String hargaJ = txHargaJual.getText();
        int hargaBeli = Integer.valueOf(hargaB);
        int hargaJual = Integer.valueOf(hargaJ);
        String rakBarang = txRakBarang.getText();
        if (idBarang.isEmpty() || namaBarang.isEmpty() || jenisBarang.isEmpty() || hargaB.isEmpty() || hargaJ.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Lengkapi Data", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ClassBarang cb = new ClassBarang();
            cb.InsertBarang(idBarang, namaBarang, jenisBarang, rakBarang, stokB, hargaBeli, hargaJual);
            loadData();
            clearData();
        }
    }//GEN-LAST:event_btTambahActionPerformed

    private void txHargaBeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txHargaBeliKeyTyped
        // TODO add your handling code here:
        filterangka(evt);
    }//GEN-LAST:event_txHargaBeliKeyTyped

    private void txHargaJualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txHargaJualKeyTyped
        // TODO add your handling code here:
        filterangka(evt);
    }//GEN-LAST:event_txHargaJualKeyTyped

    private void txIdBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIdBarangKeyTyped
        // TODO add your handling code here:
        if (txIdBarang.getText().isEmpty()) {
            btTambah.setEnabled(false);
        } else {
            btTambah.setEnabled(true);
            btEdit.setEnabled(true);
            btHapus.setEnabled(true);
        }
    }//GEN-LAST:event_txIdBarangKeyTyped

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        String idBarang = txIdBarang.getText();
        String namaBarang = txNamaBarang.getText();
        String jenisBarang = txJenisBarang.getText();
        int stokB = (int) txStock.getValue();
        String hargaB = txHargaBeli.getText();
        String hargaJ = txHargaJual.getText();
        int hargaBeli = Integer.valueOf(hargaB);
        int hargaJual = Integer.valueOf(hargaJ);
        String rakBarang = txRakBarang.getText();
        if (idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Data Yang Diedit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ClassBarang cb = new ClassBarang();
            cb.UpdateBarang(idBarang, namaBarang, jenisBarang, rakBarang, stokB, hargaBeli, hargaJual);
            System.out.println("Data" + idBarang + namaBarang+ jenisBarang+ rakBarang+ stokB+ hargaJual+ hargaJual);
            loadData();
            clearData();
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void tbBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBarangMouseClicked
        // TODO add your handling code here:
        int i = tbBarang.getSelectedRow();
        if (i == -1) {
            return;
        }
        String idBarang = (String) tableModel.getValueAt(i, 1);
        txIdBarang.setText(idBarang);
        txIdBarang.setEditable(false);
        String namaBarang = (String) tableModel.getValueAt(i, 2);
        txNamaBarang.setText(namaBarang);
        String jenisBarang = (String) tableModel.getValueAt(i, 3);
        txJenisBarang.setText(jenisBarang);
        String rakBarang = (String) tableModel.getValueAt(i, 4);
        txRakBarang.setText(rakBarang);
        String stokBarang = (String) tableModel.getValueAt(i, 5);
        int stokB = Integer.parseInt(stokBarang);
        txStock.setValue(stokB);
        String hargaBeli = (String) tableModel.getValueAt(i, 6);
        txHargaBeli.setText(hargaBeli);
        String hargaJual = (String) tableModel.getValueAt(i, 7);
        txHargaJual.setText(hargaJual);
        if (!txIdBarang.getText().isEmpty()) {
            btEdit.setEnabled(true);
            btHapus.setEnabled(true);
        }
    }//GEN-LAST:event_tbBarangMouseClicked

    private void txRakBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRakBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRakBarangActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        String idBarang = txIdBarang.getText();
        if (idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Data yang Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
             int selectedOption = JOptionPane.showConfirmDialog(null,
            "Apakah anda ingin menghapus data " + idBarang + " ?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_OPTION) {
                ClassBarang cb = new ClassBarang();
                cb.DeleteBarang(idBarang);
                loadData();
                clearData();
            }
        }
    }//GEN-LAST:event_btHapusActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new Frame_2_2().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_2_2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_2_2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_2_2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_2_2_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Frame_2_2_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btTambah;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbBarang;
    private javax.swing.JTextField txHargaBeli;
    private javax.swing.JTextField txHargaJual;
    private javax.swing.JTextField txIdBarang;
    private javax.swing.JTextField txJenisBarang;
    private javax.swing.JTextField txNamaBarang;
    private javax.swing.JTextField txRakBarang;
    private javax.swing.JSpinner txStock;
    private javax.swing.JLabel txTotalBarang;
    // End of variables declaration//GEN-END:variables
}
