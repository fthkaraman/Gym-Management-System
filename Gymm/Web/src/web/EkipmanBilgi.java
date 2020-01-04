
package web;


public class EkipmanBilgi {
    
    private int ekipmanID;
    private String ekipmanAd;
    private int miktar;

    public EkipmanBilgi(int ekipmanID, String ekipmanAd, int miktar) {
        this.ekipmanID = ekipmanID;
        this.ekipmanAd = ekipmanAd;
        this.miktar = miktar;
    }

    public int getEkipmanID() {
        return ekipmanID;
    }

    public void setEkipmanID(int ekipmanID) {
        this.ekipmanID = ekipmanID;
    }

    public String getEkipmanAd() {
        return ekipmanAd;
    }

    public void setEkipmanAd(String ekipmanAd) {
        this.ekipmanAd = ekipmanAd;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
    
    
}
