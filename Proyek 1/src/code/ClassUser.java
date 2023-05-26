/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author MSIFAULK
 */
public class ClassUser {
    private String username, password, level;
    private Connection conn;
    private Statement st;
    private int ndata = 0;
    private Object[][] data;
    
    public ClassUser(){
        
    }
    
    public void TampilUser(){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM tb_admin";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM tb_admin";
            rs = st.executeQuery(sql);
            data = new Object[ndata][3];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("nama");
                data[idx][1] = rs.getString("username");
                data[idx][2] = rs.getString("password");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
            System.out.println("Data gagal tampil");
        }
    }
    public void CariUser(String key){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM tb_admin WHERE nama = '" + key + "' ";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM tb_admin WHERE nama = '" + key + "' ";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            data = new Object[ndata][3];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("username");
                data[idx][1] = rs.getString("nama");
                data[idx][2] = rs.getString("password");
                idx++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex){
            System.out.println("Data gagal tampil");
        }
    }
    public void InsertUser(String nama, String username, String password){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "INSERT INTO tb_admin VALUES (?, ?, ?)";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, nama);
                p.setString(2, username);
                p.setString(3, password);
                p.execute();
//                System.out.println("Data Berhasil Di Tambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di tambahkan");
            JOptionPane.showMessageDialog(null, "Username Telah Terdaftar");
        }
    }
    public void UpdateUser(String nama, String username, String password){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "UPDATE tb_admin SET nama = ? ,password = ? WHERE username=?";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, nama);
                p.setString(2, password);
                p.setString(3, username);
                p.executeUpdate();
                p.close();
//                System.out.println("Data Berhasil Di Update");
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Ubah");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di Update");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Ubah");
        }
    }
    public void DeleteUser(String username){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "DELETE FROM tb_admin WHERE username=?";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, username);
                p.executeUpdate();
                System.out.println("Data Berhasil Di Hapus");
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di Hapus");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }
    }
    public int getNumberDataUser(){
        return ndata;
    }
    public Object[][] getAllDataUser(){
        return data;
    }
}
