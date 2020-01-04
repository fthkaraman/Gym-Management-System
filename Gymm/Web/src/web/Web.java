
package web;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fatih
 */
public class Web {
    
    private String kullanici_adi = "root";
    private String parola = "";
    
    private String db_ismi = "Gym";
    
    private String host = "localhost";
    
    private int port = 3306;
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<AntrenorBilgi> antrenorGoster(){
        try {
            ArrayList<AntrenorBilgi> cikti = new ArrayList<AntrenorBilgi>();
            
            statement = con.createStatement();
            String sorgu = "Select * From antrenörler,antrenortip,sube where antrenortip.tipID = antrenörler.tipID and sube.subeID = antrenörler.subeID";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("antrenorID");
                String TCNO = rs.getString("TCNO");
                String ad = rs.getString("Ad");
                String soyad = rs.getString("Soyad");
                String TelefonNo = rs.getString("TelefonNo");
                Date Dogumtarihi = rs.getDate("Dogumtarihi");
                String Password = rs.getString("Password");
                String Tip = rs.getString("tipAd");
                String Sube = rs.getString("subeAd");
                
                
                cikti.add(new AntrenorBilgi(id,TCNO,ad,soyad,TelefonNo,Dogumtarihi,Password,Tip,Sube));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    public void antrenorEkle(String TCNO,String ad,String soyad,String TelefonNo,String Dogumtarihi,String Password,String Tip,String Sube){
        String sorgu = "Insert Into antrenörler(TCNO,Ad,Soyad,TelefonNo,Dogumtarihi,Password,tipID,subeID) VALUES(?,?,?,?,?,?,(Select tipID From antrenortip where tipAd = ?),"
                + "(Select subeID From sube where subeAd = ?))";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, TCNO);
            preparedStatement.setString(2, ad);
            preparedStatement.setString(3, soyad);
            preparedStatement.setString(4, TelefonNo);
            preparedStatement.setString(5, Dogumtarihi);
            preparedStatement.setString(6, Password);
            preparedStatement.setString(7, Tip);
            preparedStatement.setString(8, Sube);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void antrenorGuncelle(int id,String yeni_tc,String yeni_ad,String yeni_soyad,String yeni_TelefonNo,String yeni_Dogumtarihi,String yeni_Password){
        String sorgu = "Update antrenörler set TCNO = ? , Ad = ? , Soyad = ? , TelefonNo = ? , Dogumtarihi = ? , Password = ? where antrenorID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_tc);
            preparedStatement.setString(2, yeni_ad);
            preparedStatement.setString(3, yeni_soyad);
            preparedStatement.setString(4, yeni_TelefonNo);
            preparedStatement.setString(5, yeni_Dogumtarihi);
            preparedStatement.setString(6, yeni_Password);            
                      
            preparedStatement.setInt(7, id);            
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void antrenorSil(int id){
        String sorgu = "Delete from antrenörler where antrenorID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ArrayList<SubeBilgi> subeGoster(){
        try {
            ArrayList<SubeBilgi> cikti = new ArrayList<SubeBilgi>();
            
            statement = con.createStatement();
            String sorgu = "Select * From sube,sehir where sehir.sehirID = sube.sehirID";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int subeID = rs.getInt("subeID");
                String subeAd = rs.getString("subeAd");
                String sehirAd = rs.getString("sehirAd");
                
                cikti.add(new SubeBilgi(subeID,subeAd,sehirAd));
                
            }                      
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
    public void subeEkle(String sehirAd,String subeAd){
        
        String sorgu = "Insert Into sube(subeAd,sehirID) VALUES(?,(Select sehirID From sehir where sehirAd = ?))";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, subeAd);
            preparedStatement.setString(2, sehirAd);
                        
            preparedStatement.executeUpdate();           
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }
    
    public void subeGuncelle(int subeID,String yeni_sube){
        String sorgu = "Update sube set subeAd = ? where subeID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_sube);
                       
            preparedStatement.setInt(2, subeID);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void subeSil(int subeID){
        String sorgu = "Delete from sube where subeID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, subeID);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ArrayList<BransBilgi> bransGoster(){
        try {
            ArrayList<BransBilgi> cikti = new ArrayList<BransBilgi>();
            
            statement = con.createStatement();
            String sorgu = "Select * From antrenortip,branslar where branslar.bransID = antrenortip.bransID";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int tipID = rs.getInt("tipID");
                String tipAd = rs.getString("tipAd");
                String bransAd = rs.getString("bransAd");
            
                cikti.add(new BransBilgi(tipID,tipAd,bransAd));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
    public ArrayList<UyeBilgi> uyeGoster(){
        try {
            ArrayList<UyeBilgi> cikti = new ArrayList<UyeBilgi>();
            
            statement = con.createStatement();
            String sorgu = "Select * From uyeler,indeks,uyetip,uyeliktarihi,antrenörler where indeks.indeksID = uyeler.indeksID and uyetip.tipID = uyeler.tipID "
                    + "and uyeliktarihi.uyelikID = uyeler.uyelikID and antrenörler.antrenorID = uyeler.antrenorID";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int uyeID = rs.getInt("uyeID");
                String TCNO = rs.getString("TCNO");
                String ad = rs.getString("uyeAd");
                String soyad = rs.getString("Soyad");
                String TelefonNo = rs.getString("TelefonNo");
                String Adres = rs.getString("Adres");
                String Email = rs.getString("Email");
                String Cinsiyet = rs.getString("Cinsiyet");
                Date Dogumtarihi = rs.getDate("Dogumtarihi");               
                int Indeks = Integer.parseInt(rs.getString("indeks"));
                String Tip = rs.getString("tipAd");
                int Uyelik = Integer.parseInt(rs.getString("sure"));
                String Antrenor = rs.getString("Ad");
                
                
                cikti.add(new UyeBilgi(uyeID,TCNO,ad,soyad,TelefonNo,Adres,Email,Cinsiyet,Dogumtarihi,Indeks,Tip,Uyelik,Antrenor));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
    public void uyeEkle(String TCNO,String ad,String soyad,String TelefonNo,String Adres, String Email, String Cinsiyet, String Dogumtarihi, int Indeks, String Tip, int Uyelik, String Antrenor){
        String sorgu = "Insert Into uyeler(TCNO,uyeAd,Soyad,TelefonNo,Adres,Email,Cinsiyet,Dogumtarihi,indeksID,tipID,uyelikID,antrenorID) VALUES(?,?,?,?,?,?,?,?,(Select indeksID From indeks where indeks = ?),"
                + "(Select tipID From uyetip where tipAd = ?),"
                + "(Select uyelikID From uyeliktarihi where sure = ?),"
                + "(Select antrenorID From antrenörler where Ad = ?))";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, TCNO);
            preparedStatement.setString(2, ad);
            preparedStatement.setString(3, soyad);
            preparedStatement.setString(4, TelefonNo);
            preparedStatement.setString(5, Adres);
            preparedStatement.setString(6, Email);
            preparedStatement.setString(7, Cinsiyet);
            preparedStatement.setString(8, Dogumtarihi);
            preparedStatement.setInt(9, Indeks);
            preparedStatement.setString(10, Tip);
            preparedStatement.setInt(11, Uyelik);
            preparedStatement.setString(12, Antrenor);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void uyeGuncelle(int uyeID,String yeni_tc,String yeni_ad,String yeni_soyad,String yeni_TelefonNo,String yeni_Adres,String yeni_Email,String yeni_Cinsiyet,String yeni_Dogumtarihi,int yeni_Boy,int yeni_Kilo,String yeni_Tip,int yeni_Uyelik,String yeni_Antrenor){
        String sorgu = "Update uyeler,indeks,antrenörler set TCNO = ? , uyeAd = ? , Soyad = ? , TelefonNo = ? , Adres = ? , Email = ? , Cinsiyet = ? , Dogumtarihi = ? , indeks = ? , Ad = ? where antrenorID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_tc);
            preparedStatement.setString(2, yeni_ad);
            preparedStatement.setString(3, yeni_soyad);
            preparedStatement.setString(4, yeni_TelefonNo);
            preparedStatement.setString(5, yeni_Adres);
            preparedStatement.setString(6, yeni_Email);
            preparedStatement.setString(7, yeni_Cinsiyet); 
            preparedStatement.setString(8, yeni_Dogumtarihi);
            preparedStatement.setInt(9, yeni_Boy);
            preparedStatement.setInt(10, yeni_Kilo);
            preparedStatement.setString(11, yeni_Tip); 
            preparedStatement.setInt(12, yeni_Uyelik); 
            preparedStatement.setString(13, yeni_Antrenor); 
            
            preparedStatement.setInt(14, uyeID);            
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void uyeSil(int uyeID){
        String sorgu = "Delete from uyeler where uyeID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, uyeID);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ArrayList<EkipmanBilgi> ekipmanGoster(){
        try {
            ArrayList<EkipmanBilgi> cikti = new ArrayList<EkipmanBilgi>();
            
            statement = con.createStatement();
            String sorgu = "Select * From ekipman";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int ekipmanID = rs.getInt("ekipmanID");
                String ekipmanAd = rs.getString("ekipmanAd");
                int miktar = rs.getInt("miktar");
                
                cikti.add(new EkipmanBilgi(ekipmanID,ekipmanAd,miktar));
                
            }                      
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
       
    
    public boolean girisYap(String kullanici_adi,String parola){
        
        String sorgu = "Select * From Yönetici where Ad = ? and Password = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean girisYapAnt(String kullanici_adi,String parola){
        
        String sorgu = "Select * From antrenörler where Ad = ? and Password = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Web.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public Web(){
        
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver bulunamadı.");          
        } 
        
        try {
            con = DriverManager.getConnection(url, kullanici_adi, parola);
            System.out.println("Bağlantı başarılı.");
        } catch (SQLException ex) {
            System.out.println("Bağlantı başarısız.");  
        }
    }
    public static void main(String[] args) {
        Web web = new Web();
    }

    
}
