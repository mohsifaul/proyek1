/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MSIFAULK
 */
public class ClassValidasi {
    private String username, userpass;
    private Connection conn;
    private Statement st;
    public ClassValidasi(){
        
    }
    
    public String[] Login(String username, String password){
//        boolean valid = false;
        String userData[] = new String[2];
        String sql = "SELECT * FROM user WHERE username = '" + username + "'"
                + "AND userpass = '" + password + "'";
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                userData[0] = rs.getString("nama"); // Simpan nama ke indeks 0
                userData[1] = rs.getString("level"); // Simpan level ke indeks 1
            } else {
                System.out.println("Username atau Password Salah!!");
                JOptionPane.showMessageDialog(null, "Username atau Password Salah!!");
            }
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(ClassValidasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return userData;
    }
    public String[] Login2(String username, String password){
//        String level = null;
//        String nama = null;
        String userData[] = new String[2];
        String sql = "SELECT * FROM user WHERE username = '" + username + "'"
                + "AND userpass = '" + password + "'";
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                userData[0] = rs.getString("nama"); // Simpan nama ke indeks 0
                userData[1] = rs.getString("level"); // Simpan level ke indeks 1
            }
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(ClassValidasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return userData;
    }
}
