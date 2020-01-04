
package web;

import java.sql.Date;


public class UyeBilgi {
    
    private int uyeID;
    private String TCNO;  
    private String ad;
    private String soyad;
    private String TelefonNo;
    private String Adres;
    private String Email;
    private String Cinsiyet;
    private Date Dogumtarihi;    
    private int Indeks;
    private String Tip;
    private int Uyelik;
    private String Antrenor;

    public UyeBilgi(int uyeID, String TCNO, String ad, String soyad, String TelefonNo, String Adres, String Email, String Cinsiyet, Date Dogumtarihi, int Indeks, String Tip, int Uyelik, String Antrenor) {
        this.uyeID = uyeID;
        this.TCNO = TCNO;
        this.ad = ad;
        this.soyad = soyad;
        this.TelefonNo = TelefonNo;
        this.Adres = Adres;
        this.Email = Email;
        this.Cinsiyet = Cinsiyet;
        this.Dogumtarihi = Dogumtarihi;
        this.Indeks = Indeks;
        this.Tip = Tip;
        this.Uyelik = Uyelik;
        this.Antrenor = Antrenor;
    }

    public int getUyeID() {
        return uyeID;
    }

    public void setUyeID(int uyeID) {
        this.uyeID = uyeID;
    }

    public String getTCNO() {
        return TCNO;
    }

    public void setTCNO(String TCNO) {
        this.TCNO = TCNO;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefonNo() {
        return TelefonNo;
    }

    public void setTelefonNo(String TelefonNo) {
        this.TelefonNo = TelefonNo;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCinsiyet() {
        return Cinsiyet;
    }

    public void setCinsiyet(String Cinsiyet) {
        this.Cinsiyet = Cinsiyet;
    }

    public Date getDogumtarihi() {
        return Dogumtarihi;
    }

    public void setDogumtarihi(Date Dogumtarihi) {
        this.Dogumtarihi = Dogumtarihi;
    }
      
    
    public int getIndeks() {
        return Indeks;
    }

    public void setIndeks(int Indeks) {
        this.Indeks = Indeks;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String Tip) {
        this.Tip = Tip;
    }

    public int getUyelik() {
        return Uyelik;
    }

    public void setUyelik(int Uyelik) {
        this.Uyelik = Uyelik;
    }

    public String getAntrenor() {
        return Antrenor;
    }

    public void setAntrenor(String Antrenor) {
        this.Antrenor = Antrenor;
    }
          
}
