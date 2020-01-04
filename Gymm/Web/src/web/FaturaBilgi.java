
package web;


public class FaturaBilgi {
    
    private int urunID;
    private String Urun;
    private int Miktar;

    public FaturaBilgi(int urunID, String Urun, int Miktar) {
        this.urunID = urunID;
        this.Urun = Urun;
        this.Miktar = Miktar;
    }

    public int getUrunID() {
        return urunID;
    }

    public void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    public String getUrun() {
        return Urun;
    }

    public void setUrun(String Urun) {
        this.Urun = Urun;
    }

    public int getMiktar() {
        return Miktar;
    }

    public void setMiktar(int Miktar) {
        this.Miktar = Miktar;
    }
    
    
    
}
