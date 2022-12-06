package object.p2pipcam.bean;

import java.io.Serializable;

public class WifiBean implements Serializable {
    private static final long serialVersionUID = 1;
    private int authtype;
    private int channel;
    private int dbm0;
    private int defkey;
    private String did;
    private int enable;
    private int encryp;
    private String key1;
    private int key1_bits;
    private String key2;
    private int key2_bits;
    private String key3;
    private int key3_bits;
    private String key4;
    private int key4_bits;
    private int keyformat;
    private int mode;
    private String ssid;
    private String wpa_psk;

    public int getDbm0() {
        return this.dbm0;
    }

    public void setDbm0(int i) {
        this.dbm0 = i;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public int getEnable() {
        return this.enable;
    }

    public void setEnable(int i) {
        this.enable = i;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public int getAuthtype() {
        return this.authtype;
    }

    public void setAuthtype(int i) {
        this.authtype = i;
    }

    public int getEncryp() {
        return this.encryp;
    }

    public void setEncryp(int i) {
        this.encryp = i;
    }

    public int getKeyformat() {
        return this.keyformat;
    }

    public void setKeyformat(int i) {
        this.keyformat = i;
    }

    public int getDefkey() {
        return this.defkey;
    }

    public void setDefkey(int i) {
        this.defkey = i;
    }

    public String getKey1() {
        return this.key1;
    }

    public void setKey1(String str) {
        this.key1 = str;
    }

    public String getKey2() {
        return this.key2;
    }

    public void setKey2(String str) {
        this.key2 = str;
    }

    public String getKey3() {
        return this.key3;
    }

    public void setKey3(String str) {
        this.key3 = str;
    }

    public String getKey4() {
        return this.key4;
    }

    public void setKey4(String str) {
        this.key4 = str;
    }

    public int getKey1_bits() {
        return this.key1_bits;
    }

    public void setKey1_bits(int i) {
        this.key1_bits = i;
    }

    public int getKey2_bits() {
        return this.key2_bits;
    }

    public void setKey2_bits(int i) {
        this.key2_bits = i;
    }

    public int getKey3_bits() {
        return this.key3_bits;
    }

    public void setKey3_bits(int i) {
        this.key3_bits = i;
    }

    public int getKey4_bits() {
        return this.key4_bits;
    }

    public void setKey4_bits(int i) {
        this.key4_bits = i;
    }

    public String getWpa_psk() {
        return this.wpa_psk;
    }

    public void setWpa_psk(String str) {
        this.wpa_psk = str;
    }

    public String toString() {
        return "WifiBean [did=" + this.did + ", enable=" + this.enable + ", ssid=" + this.ssid + ", channel=" + this.channel + ", mode=" + this.mode + ", authtype=" + this.authtype + ", encryp=" + this.encryp + ", keyformat=" + this.keyformat + ", defkey=" + this.defkey + ", key1=" + this.key1 + ", key2=" + this.key2 + ", key3=" + this.key3 + ", key4=" + this.key4 + ", key1_bits=" + this.key1_bits + ", key2_bits=" + this.key2_bits + ", key3_bits=" + this.key3_bits + ", key4_bits=" + this.key4_bits + ", wpa_psk=" + this.wpa_psk + "]";
    }
}
