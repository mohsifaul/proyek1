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
public class ClassPengajuan {
    private String kode;
    int stok, harga, hargaJual;
    private Connection conn;
    private Statement st;
    private int ndata = 0;
    private Object[][] data;
    
    public ClassPengajuan(){
        
    }
    public void TampilPengajuan(){ // digunakan pada user admin pada daftar pengajuan
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM pengajuan";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM pengajuan";
            rs = st.executeQuery(sql);
            data = new Object[ndata][5];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("id_pengajuan");
                data[idx][1] = rs.getString("tanggal");
                data[idx][2] = rs.getString("id_anggota");
                data[idx][3] = rs.getString("total_pengajuan");
                data[idx][4] = rs.getString("status");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
//            System.out.println("Data gagal tampil");
        }
    }
    public void TampilPengajuan(String idAnggota){ // Digunakan pada tampilan tabungan
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM pengajuan WHERE id_anggota= '" + idAnggota + "'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM pengajuan WHERE id_anggota= '" + idAnggota + "'";
            rs = st.executeQuery(sql);
            data = new Object[ndata][5];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("id_pengajuan");
                data[idx][1] = rs.getString("tanggal");
                data[idx][2] = rs.getString("id_anggota");
                data[idx][3] = rs.getString("total_pengajuan");
                data[idx][4] = rs.getString("status");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
//            System.out.println("Data gagal tampil");
        }
    }
    public void CariPengajuan(String key){ // Cari Barang Pada Tabel
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM pengajuan WHERE id_anggota= '" + key + "'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM pengajuan WHERE id_anggota= '" + key + "'";
            rs = st.executeQuery(sql);
            data = new Object[ndata][7];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("id_pengajuan");
                data[idx][1] = rs.getString("tanggal");
                data[idx][2] = rs.getString("id_anggota");
                data[idx][3] = rs.getString("total_pengajuan");
                data[idx][4] = rs.getString("status");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
            System.out.println("Data gagal tampil");
        }
    }
    public void InsertPengajuan(String idPengajuan, String tanggal, String idAnggota, int totalPengajuan, 
            String statusPengajuan){
      try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "INSERT INTO pengajuan VALUES (?, ?, ?, ?, ?)";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, idPengajuan);
                p.setString(2, tanggal);
                p.setString(3, idAnggota);
                p.setInt(4, totalPengajuan);
                p.setString(5,statusPengajuan);
                p.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di tambahkan");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Tambahkan");
        }  
    }
    public void UpdatePengajuan(String idPengajuan, String status){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "UPDATE pengajuan SET status=? WHERE id_pengajuan=?";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, status);
                p.setString(2, idPengajuan);
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
    public int getNumberDataPengajuan(){
        return ndata;
    }
    public Object[][] getAllDataPengajuan(){
        return data;
    }
    public void getDataPengajuan(){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM pengajuan";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT COUNT(*) FROM pengajuan";
            rs = st.executeQuery(sql);
            data = new Object[ndata][5];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("id_pengajuan");
                data[idx][1] = rs.getString("tanggal");
                data[idx][2] = rs.getString("id_anggota");
                data[idx][3] = rs.getString("total_pengajuan");
                data[idx][4] = rs.getString("status");
                idx++;
            }
            rs.close();
            st.close();
        }catch(SQLException ex){
            System.out.println("Data gagal tampil");
        }
    }
}
