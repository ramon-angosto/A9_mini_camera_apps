package object.p2pipcam.bean;

import java.io.Serializable;

public class WifiScanBean implements Serializable {
    private static final long serialVersionUID = 1;
    private int channel;
    private int dbm0;
    private int dbm1;
    private String did;
    private String mac;
    private int mode;
    private int security;
    private String ssid;

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public int getSecurity() {
        return this.security;
    }

    public void setSecurity(int i) {
        this.security = i;
    }

    public int getDbm0() {
        return this.dbm0;
    }

    public void setDbm0(int i) {
        this.dbm0 = i;
    }

    public int getDbm1() {
        return this.dbm1;
    }

    public void setDbm1(int i) {
        this.dbm1 = i;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    public String toString() {
        return "WifiScanBean [did=" + this.did + ", ssid=" + this.ssid + ", mac=" + this.mac + ", security=" + this.security + ", dbm0=" + this.dbm0 + ", dbm1=" + this.dbm1 + ", mode=" + this.mode + ", channel=" + this.channel + "]";
    }
}
