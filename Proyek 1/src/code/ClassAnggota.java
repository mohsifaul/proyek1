/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import static java.lang.Integer.parseInt;
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
public class ClassAnggota {
    private String username, userpass, nama, kelas;
    private Connection conn;
    private Statement st;
    private int ndata = 0;
    private Object[][] data;
    public ClassAnggota(){
        
    }
    public String[] LoginTabung(String username, String password){
        String userData[] = new String[2];
        String sql = "SELECT * FROM anggota WHERE username = '" + username + "'"
                + "AND userpass = '" + password + "'";
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                userData[0] = rs.getString("nama"); // Simpan nama ke indeks 0
                userData[1] = rs.getString("saldo"); // Simpan level ke indeks 1
            }
            // Mengubah saldo menjadi tipe data String
            
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(ClassValidasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return userData;
    }
    public void userNabung(String namaAkun, int saldo){
        try{
            String saldoBaru = String.valueOf(saldo);
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            
            String sql = "UPDATE anggota SET saldo=? WHERE username=?";
//            System.out.println(sql);
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, saldoBaru);
                p.setString(2, namaAkun);
                p.executeUpdate();
                p.close();
//                System.out.println("Data Berhasil Di Update");
//                JOptionPane.showMessageDialog(null, "Proses Menabung Berhasil.\n", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex){
//            System.out.println("Data gagal di Update");
            JOptionPane.showMessageDialog(null, "Gagal Setor");
        }
    }
    public void TampilAnggota(){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM anggota";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM anggota";
            rs = st.executeQuery(sql);
            data = new Object[ndata][5];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("username");
                data[idx][1] = rs.getString("userpass");
                data[idx][2] = rs.getString("nama");
                data[idx][3] = rs.getString("jenis_kelamin");
                data[idx][4] = rs.getString("kelas");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
//            System.out.println("Data gagal tampil");
        }
    }
    
//  Fungsi Untuk Tambah Data Anggota  
    public void insertAnggota(String NIS, String pass, String namaAnggota, String jenisKelamin, String kelasAnggota, int saldo){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            
            String sql = "INSERT INTO anggota VALUES (?, ?, ?, ?, ?, ?)";
//            System.out.println(sql);
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, NIS);
                p.setString(2, pass);
                p.setString(3, namaAnggota);
                p.setString(4, jenisKelamin);
                p.setString(5, kelasAnggota);
                p.setInt(6, saldo);
                p.execute();
//                System.out.println("Data Berhasil Di Update");
                JOptionPane.showMessageDialog(null, "Anggota berhasil ditambahkan");
           }
        } catch (SQLException ex){
//            System.out.println("Data gagal di Update");
            JOptionPane.showMessageDialog(null, "Gagal Tambah Anggota");
        }
    }
    
//    Fungsi Untuk Edit Anggota
    public void updateAnggota(String NIS, String pass, String namaAnggota, String jenisKelamin, String kelasAnggota){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            
            String sql = "UPDATE anggota SET userpass = ?, nama=?, jenis_kelamin=?, kelas=? WHERE username=?";
//            System.out.println(sql);
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, pass);
                p.setString(2, namaAnggota);
                p.setString(3, jenisKelamin);
                p.setString(4, kelasAnggota);
                p.setString(5, NIS);
                p.execute();
//                System.out.println("Data Berhasil Di Update");
                JOptionPane.showMessageDialog(null, "Data Anggota dengan\n NIS : " + NIS + "\nBerhasil diubah");
            }
        } catch (SQLException ex){
//            System.out.println("Data gagal di Update");
            JOptionPane.showMessageDialog(null, "Gagal Tambah Anggota");
        }
    }
    
    // FUngsi untuk mengahpus data anggota
    public void deleteAnggota(String NIS){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "DELETE FROM anggota WHERE username=?";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, NIS);
                p.executeUpdate();
//                System.out.println("Data Berhasil Di Hapus");
                JOptionPane.showMessageDialog(null, "Data Anggota dengan\n NIS : " + NIS + "\nBerhasil di Hapus");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di Hapus");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }
    }
    
    public int getNumberDataAnggota(){
        return ndata;
    }
    public Object[][] getAllDataAngggota(){
        return data;
    }
}

