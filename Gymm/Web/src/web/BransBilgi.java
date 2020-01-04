
package web;


public class BransBilgi {
    
    private int tipID;
    private String tipAd;
    private String bransAd;

    public BransBilgi(int tipID, String tipAd, String bransAd) {
        this.tipID = tipID;
        this.tipAd = tipAd;
        this.bransAd = bransAd;
    }

    public int getTipID() {
        return tipID;
    }

    public void setTipID(int tipID) {
        this.tipID = tipID;
    }

    public String getTipAd() {
        return tipAd;
    }

    public void setTipAd(String tipAd) {
        this.tipAd = tipAd;
    }

    public String getBransAd() {
        return bransAd;
    }

    public void setBransAd(String bransAd) {
        this.bransAd = bransAd;
    }
    
    
}
