package object.p2pipcam.bean;

public class DateBean {
    private int now;
    private int ntp_enable;
    private String ntp_ser;
    private int tz;

    public int getNow() {
        return this.now;
    }

    public void setNow(int i) {
        this.now = i;
    }

    public int getTz() {
        return this.tz;
    }

    public void setTz(int i) {
        this.tz = i;
    }

    public int getNtp_enable() {
        return this.ntp_enable;
    }

    public void setNtp_enable(int i) {
        this.ntp_enable = i;
    }

    public String getNtp_ser() {
        return this.ntp_ser;
    }

    public void setNtp_ser(String str) {
        this.ntp_ser = str;
    }

    public String toString() {
        return "DateBean [now=" + this.now + ", tz=" + this.tz + ", ntp_enable=" + this.ntp_enable + ", ntp_ser=" + this.ntp_ser + "]";
    }
}
