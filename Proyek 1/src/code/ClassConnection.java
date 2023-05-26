/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConnection {
    public static Connection koneksi;
    public static Connection getKoneksi(){
        if (koneksi == null) {
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                String url = "jdbc:mysql://localhost/db_proyek1"; //url database
                String user = "root"; //user database
                String pass = ""; //password database
                koneksi = (Connection) DriverManager.getConnection(url, user, pass); 
                System.out.println("Database tersambung");
            } catch (SQLException ex){
                System.out.println("Database tidak tersambung");
            }    
        }
        return koneksi;
    }
}
