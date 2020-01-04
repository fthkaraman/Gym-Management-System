
package web;

public class SubeBilgi {
    
    private int subeID;
    private String subeAd;
    private String sehirAd;

    public SubeBilgi(int subeID, String subeAd, String sehirAd) {
        this.subeID = subeID;
        this.subeAd = subeAd;
        this.sehirAd = sehirAd;
    }

    public int getSubeID() {
        return subeID;
    }

    public void setSubeID(int subeID) {
        this.subeID = subeID;
    }

    public String getSubeAd() {
        return subeAd;
    }

    public void setSubeAd(String subeAd) {
        this.subeAd = subeAd;
    }
    
    public String getSehirAd() {
        return sehirAd;
    }

    public void setSehirAd(String sehirAd) {
        this.sehirAd = sehirAd;
    }    
}
