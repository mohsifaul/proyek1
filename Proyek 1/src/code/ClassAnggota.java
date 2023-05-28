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
    private String username, userpass;
    private Connection conn;
    private Statement st;
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
    public void tabungUang(String nominal){
        int saldoTabung = parseInt(nominal);
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            
        } catch (SQLException ex){
//            System.out.println("Data gagal di Update");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Ubah");
        }
    }
}

