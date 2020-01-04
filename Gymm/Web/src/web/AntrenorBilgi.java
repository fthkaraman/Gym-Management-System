package web;

import java.sql.Date;

public class AntrenorBilgi {
    
    private int id;
    private String TCNO;
    private String ad;
    private String soyad;
    private String TelefonNo;
    private Date Dogumtarihi;
    private String Password;
    private String Tip;
    private String Sube;
    

    public AntrenorBilgi(int id, String TCNO, String ad, String soyad, String TelefonNo, Date Dogumtarihi, String Password, String Tip, String Sube) {
        this.id = id;
        this.TCNO = TCNO;
        this.ad = ad;
        this.soyad = soyad;
        this.TelefonNo = TelefonNo;
        this.Dogumtarihi = Dogumtarihi;
        this.Password = Password;
        this.Tip = Tip;
        this.Sube = Sube;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDogumtarihi() {
        return Dogumtarihi;
    }

    public void setDogumtarihi(Date Dogumtarihi) {
        this.Dogumtarihi = Dogumtarihi;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getTip() {
        return Tip;
    }

    public void setTip(String Tip) {
        this.Tip = Tip;
    }
    
    public String getSube() {
        return Sube;
    }

    public void setSube(String Sube) {
        this.Sube = Sube;
    }
}
