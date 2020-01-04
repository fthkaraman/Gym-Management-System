
package web;

import java.sql.Date;


public class IndeksBilgi extends UyeBilgi {
    
    private int Boy;
    private int Kilo;
    private Date Basla;
    private Date Bitis;
    

    public IndeksBilgi(int Boy, int Kilo, int uyeID, String TCNO, String ad, String soyad, String TelefonNo, String Adres, String Email, String Cinsiyet, Date Dogumtarihi, int Indeks, String Tip, int Uyelik, String Antrenor) {
        super(uyeID, TCNO, ad, soyad, TelefonNo, Adres, Email, Cinsiyet, Dogumtarihi, Indeks, Tip, Uyelik, Antrenor);
        this.Boy = Boy;
        this.Kilo = Kilo;
        this.Basla = Basla;
        this.Bitis = Bitis;
    }

    public int getBoy() {
        return Boy;
    }

    public void setBoy(int Boy) {
        this.Boy = Boy;
    }

    public int getKilo() {
        return Kilo;
    }

    public void setKilo(int Kilo) {
        this.Kilo = Kilo;
    }
    
    public Date getBasla() {
        return Basla;
    }
    
    public void setBasla(Date Basla) {
        this.Basla = Basla;
    }
    
    public Date getBitis() {
        return Bitis;
    }
    
    public void setBitis(Date Bitis) {
        this.Bitis = Bitis;
    }
    
}
