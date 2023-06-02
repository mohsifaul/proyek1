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
public class ClassTransaksi {
    private Connection conn;
    private Statement st;
    private int ndata = 0;
    private Object[][] data;
    String tanggal, kasir,idtrx, kodeBrg, namaBrg, itemBrg, hargaItem, total;
    
    public ClassTransaksi(){
        
    }
    public void getDataTrx(){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(DISTINCT idtrx) FROM transaksi";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(DISTINCT idtrx)");
            }
            sql = "SELECT tanggal, idtrx, COUNT(idtrx) AS nJenis, " 
                    + "SUM(itemBarang) AS nItem, SUM(total) AS pemasukan " 
                    + "FROM transaksi GROUP BY idtrx";
            rs = st.executeQuery(sql);
            data = new Object[ndata][5];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("tanggal");
                data[idx][1] = rs.getString("idtrx");
                data[idx][2] = rs.getString("nJenis");
                data[idx][3] = rs.getString("nItem");
                data[idx][4] = rs.getString("pemasukan");
                idx++;
            }
            rs.close();
            st.close();
        }catch(SQLException ex){
            System.out.println("Data gagal tampil");
        }
    } // end getDataLog
    public void getDataLog(String key){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(DISTINCT idtrx) FROM transaksi WHERE idtrx like '%" + key + "%' ";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(DISTINCT idtrx)");
            }
            sql = "SELECT tanggal, idtrx, COUNT(idtrx) AS nJenis, " 
                    + "SUM(itemBarang) AS nItem, SUM(total) AS pemasukan " 
                    + "FROM transaksi WHERE idtrx like '%" + key + "%' GROUP BY idtrx";
            rs = st.executeQuery(sql);
            data = new Object[ndata][5];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("tanggal");
                data[idx][1] = rs.getString("idtrx");
                data[idx][2] = rs.getString("nJenis");
                data[idx][3] = rs.getString("nItem");
                data[idx][4] = rs.getString("pemasukan");
                idx++;
            }
            rs.close();
            st.close();
        } catch(SQLException ex){
            System.out.println("Data gagal tampil");
        }
    } // end getDataLog
    public void getDataInv(String key){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM transaksi WHERE idtrx = '" + key + "' ";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ndata = rs.getInt("COUNT(*)");
            }
            sql = "SELECT * FROM transaksi WHERE idtrx = '" + key + "'";
            rs = st.executeQuery(sql);
            data = new Object[ndata][8];
            int idx = 0;
            while(rs.next()){
                data[idx][0] = rs.getString("tanggal");
                data[idx][1] = rs.getString("idtrx");
                data[idx][2] = rs.getString("idBarang");
                data[idx][3] = rs.getString("namaBarang");
                data[idx][4] = rs.getString("itemBarang");
                data[idx][5] = rs.getString("hargaItem");
                data[idx][6] = rs.getString("total");
                idx++;
            }
            rs.close();
            st.close();
        }catch(SQLException ex){
            System.out.println("Data gagal tampil");
        }
    } // end getDataLog
    public void InsertLog(String tanggal, String idtrx, String[][] data, int n){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            for (int i = 0; i < n; i++) {
                kodeBrg = data[i][0];
                namaBrg = data[i][1];
                itemBrg = data[i][2];
                hargaItem = data[i][3];
                total = data[i][4];
                String sql = "INSERT INTO transaksi VALUES (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement p = conn.prepareStatement(sql)){
                  p.setString(1, tanggal);
                  p.setString(2, idtrx);
                  p.setString(3, kodeBrg);
                  p.setString(4, namaBrg);
                  p.setString(5, itemBrg);
                  p.setString(6, hargaItem);
                  p.setString(7, total);
                  p.execute();
//                  JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan di Log Transaksi");
                }
            }
          } catch (SQLException ex){
//              System.out.println("Data gagal di tambahkan");
                System.out.println(ex);
//                Logger.getLogger(ClassTransaksi.class.getName()).log(Level.SEVERE,null,ex);
              JOptionPane.showMessageDialog(null, "Data Gagal Di Tambahkan");
          }  
    } // end insertLog
    public void DeleteLog(String idtrx){
        try{
            conn = ClassConnection.getKoneksi();
            st = conn.createStatement();
            String sql = "DELETE FROM transaksi WHERE idtrx=?";
            try(PreparedStatement p = conn.prepareStatement(sql)){
                p.setString(1, idtrx);
                p.executeUpdate();
//                System.out.println("Data Berhasil Di Hapus");
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            }
        } catch (SQLException ex){
            System.out.println("Data gagal di Hapus");
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }
    } // end DeleteLog
    public int getNumberTrx(){
        return ndata;
    }
    public Object[][] getAllTrx(){
        return data;
    }
}
