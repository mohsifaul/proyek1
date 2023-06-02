/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MSIFAULK
 */
public class ClassBarang {
    private String kode;
    int stok, harga, hargaJual;
    private Connection conn;
    private Statement st;
    private int ndata = 0;
    private Object[][] data;
    
    public ClassBarang(){
        
    }
    public void TampilBarang(){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM barang";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM barang";
            rs = st.executeQuery(sql);
            data = new Object[ndata][7];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("id_barang");
                data[idx][1] = rs.getString("nama_barang");
                data[idx][2] = rs.getString("jenis_barang");
                data[idx][3] = rs.getString("rak_barang");
                data[idx][4] = rs.getString("stok_barang");
                data[idx][5] = rs.getString("harga_barang");
                data[idx][6] = rs.getString("harga_jual");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
//            System.out.println("Data gagal tampil");
        }
    }
    public void CariBarang(String key){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM barang WHERE nama_barang like '%" + key + "%' ";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM barang WHERE nama_barang like '%" + key + "%' ";
            rs = st.executeQuery(sql);
            data = new Object[ndata][7];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("id_barang");
                data[idx][1] = rs.getString("nama_barang");
                data[idx][2] = rs.getString("jenis_barang");
                data[idx][3] = rs.getString("rak_barang");
                data[idx][4] = rs.getString("stok_barang");
                data[idx][5] = rs.getString("harga_barang");
                data[idx][6] = rs.getString("harga_jual");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
            System.out.println("Data gagal tampil");
        }
    }
    public void CariKode(String key){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM barang WHERE nama_barang='" + key + "'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM barang WHERE nama_barang='" + key + "'";
            rs = st.executeQuery(sql);
            data = new Object[ndata][7];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("id_barang");
                data[idx][1] = rs.getString("nama_barang");
                data[idx][2] = rs.getString("jenis_barang");
                data[idx][3] = rs.getString("rak_barang");
                data[idx][4] = rs.getString("stok_barang");
                data[idx][5] = rs.getString("harga_barang");
                data[idx][6] = rs.getString("harga_jual");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
            System.out.println("Data gagal tampil");
        }
    }
    public void UpdateStock(String[][] data, int n){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            for (int i = 0; i < n; i++) {
                kode = data[i][0];
                int itemBrg = Integer.valueOf(data[i][2]);
                stok = getStok(kode) - itemBrg;
                String sql = "UPDATE barang SET stok_barang=? WHERE id_barang=?";
                try(PreparedStatement p = conn.prepareStatement(sql)){
                    p.setInt(1, stok);
                    p.setString(2, kode);
                    p.executeUpdate();
                    p.close();
//                    System.out.println("Data Berhasil Di Update");
//                    JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
                }
            }
            
        } catch (SQLException ex){
            System.out.println("Data gagal di Update");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Ubah");
        }
    }
    public void InsertBarang(String idBarang, String namaBarang, String jenisBarang, String rakBarang, 
            int stokBarang, int hargaBarang, int hargaJual){
      try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "INSERT INTO barang VALUES (?, ?, ?, ?, ?, ?, ?)";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, idBarang);
                p.setString(2, namaBarang);
                p.setString(3, jenisBarang);
                p.setString(4, rakBarang);
                p.setInt(5, stokBarang);
                p.setInt(6, hargaBarang);
                p.setInt(7, hargaJual);
                p.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di tambahkan");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Tambahkan");
        }  
    }
    public void UpdateBarang(String idBarang, String namaBarang, String jenisBarang, String rakBarang,
            int stokBarang, int hargaBarang, int hargaJual){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "UPDATE barang SET nama_barang=?, jenis_barang=?, rak_barang=?, stok_barang=?, harga_barang=?, harga_jual=? WHERE id_barang=?";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, namaBarang);
                p.setString(2, jenisBarang);
                p.setString(3, rakBarang);
                p.setInt(4, stokBarang);
                p.setInt(5, hargaBarang);
                p.setInt(6, hargaJual);
                p.setString(7, idBarang);
                p.executeUpdate();
                p.close();
//                System.out.println("Data Berhasil Di Update");
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di Update");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Ubah");
        }
    }
    public void DeleteBarang(String kode){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "DELETE FROM barang WHERE id=?";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, kode);
                p.executeUpdate();
//                System.out.println("Data Berhasil Di Hapus");
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di Hapus");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }
    }
    public int getNumberDataBarang(){
        return ndata;
    }
    public Object[][] getAllDataBarang(){
        return data;
    }
    public int getStok(String kode){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT stok_barang FROM barang WHERE id_barang='" + kode + "';";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                stok = rs.getInt("stok_barang");
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
            System.out.println("Data gagal di Update");
        }
        return stok;
    }
}
