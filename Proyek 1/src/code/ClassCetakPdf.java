/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

//import pbo_prakt11_mohsifaulkhoir.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
//import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author MSIFAULK
 */
public class ClassCetakPdf {
    String nama, judul, isi, total;
    
    public ClassCetakPdf(){
        
    }
    public void CetakTeks(String nmDokumen, String isiDokumen){
        try{
            nama = nmDokumen + ".pdf";
            isi = isiDokumen;
            
            Document document = new Document();
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(nama));
            document.open();
            Paragraph p = new Paragraph(isi);
            document.add(p);
            document.close();
            
            System.out.println("Cetak Dokumen Berhasil");
        } catch(FileNotFoundException ex){
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public void CetakTeks(String nmDokumen, String jdlDokumen, String isiDokumen){
        try{
            nama = nmDokumen + ".pdf";
            judul = jdlDokumen;
            isi = isiDokumen;
            
            Document document = new Document();
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(nama));
            document.open();
            Paragraph p = new Paragraph(judul);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            p.setSpacingAfter(10);
            document.add(p);
            
            p = new Paragraph(isi);
            document.add(p);
            document.close();
            
            System.out.println("Cetak Dokumen Berhasil");
        } catch(FileNotFoundException ex){
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public void CetakTextGambar(String pathGambar, String nmDokumen, String jdlDoc, 
            String[] judulTabel, String[][] isi, int bar, int kol, String totalX){
        try{
            nama = nmDokumen + ".pdf";
            judul = jdlDoc;
            total = totalX;
            
            Document document = new Document();
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(nama));
            document.open();
            Image img;
            img = Image.getInstance(pathGambar);
            img.setAlignment(Image.ALIGN_CENTER);
            img.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getHeight());
            img.setSpacingAfter(5);
            document.add(img);

            PdfPTable pt = new PdfPTable(kol);
            Paragraph p = new Paragraph(judul);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            p.setSpacingAfter(5);
            document.add(p);
//            p = new Paragraph(isi);
            for (int i = 0; i < kol; i++) {
                pt.addCell(judulTabel[i]);
            }
            for(int i = 0; i < bar; i++){
                for(int j = 0; j < kol; j++){
                    pt.addCell(isi[i][j]);
                }
            }
            document.add(pt);
            pt.setSpacingAfter(5);
            Paragraph pT = new Paragraph();
            pT.add(total);
            pT.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(pT);
            document.close();
            JOptionPane.showMessageDialog(null, "Cetak Berhasil", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (DocumentException | IOException ex) {
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }       
    public void CetakTabel(String nmDokumen, String jdlDoc, String[] judulTabel, String[][] isi, int bar, int kol){
        try{
            nama = nmDokumen + ".pdf";
            judul = jdlDoc;
            Document document = new Document();
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(nama));

            PdfPTable pt = new PdfPTable(kol);
            document.open();
            Paragraph p = new Paragraph(judul);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            p.setSpacingAfter(5);
            document.add(p);
            for (int i = 0; i < kol; i++) {
                pt.addCell(judulTabel[i]);
            }
            for(int i = 0; i < bar; i++){
                for(int j = 0; j < kol; j++){
                    pt.addCell(isi[i][j]);
                }
            }
            document.add(pt);
            document.close();
            JOptionPane.showMessageDialog(null, "Cetak Berhasil");
        } catch (DocumentException | FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    }
    public void CetakTabelTransaksi(String pathGambar, String nmDokumen, String jdlDoc, 
            String[] judulTabel, String[][] isi, int bar, int kol, int total, int tBayar){
        try{
            nama = nmDokumen + ".pdf";
            judul = jdlDoc;
            int bayar = total, jBayar = tBayar, kembalian;
            Document document = new Document();
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(nama));
            PdfPTable pt = new PdfPTable(kol);
            document.open();
            Image img;
            img = Image.getInstance(pathGambar);
            img.setAlignment(Image.ALIGN_CENTER);
            img.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getHeight());
            img.setSpacingAfter(5);
            document.add(img);
            Paragraph p = new Paragraph();
            p = new Paragraph(judul);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            p.setSpacingAfter(5);
            document.add(p);            
            for (int i = 0; i < kol; i++) {
                pt.addCell(judulTabel[i]);
            }
            for(int i = 0; i < bar; i++){
                for(int j = 0; j < kol; j++){
                    pt.addCell(isi[i][j]);
                }
            }
            document.add(pt);
            pt.setSpacingAfter(20);
            DecimalFormat DF = new DecimalFormat("#,###,###"); 
            p = new Paragraph("Total Bayar  : Rp " + DF.format(bayar));
            p.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(p);
            p = new Paragraph("Tunai    : Rp " + DF.format(jBayar));
            p.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(p);
            kembalian = jBayar - bayar;
            p = new Paragraph("Kembalian    : Rp " + DF.format(kembalian));
            p.setAlignment(Paragraph.ALIGN_RIGHT);
            p.setSpacingAfter(5);
            document.add(p);
            document.close();
            JOptionPane.showMessageDialog(null, "Cetak Berhasil");
        } catch (DocumentException | FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ClassCetakPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
