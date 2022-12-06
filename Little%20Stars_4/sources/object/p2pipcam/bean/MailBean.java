package object.p2pipcam.bean;

public class MailBean {
    private boolean isChecked;
    private int port;
    private String pwd;
    private String receiver1;
    private String receiver2;
    private String receiver3;
    private String receiver4;
    private String sender;
    private int ssl;
    private String svr;
    private String user;

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public String getSvr() {
        return this.svr;
    }

    public void setSvr(String str) {
        this.svr = str;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public int getSsl() {
        return this.ssl;
    }

    public void setSsl(int i) {
        this.ssl = i;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public String getReceiver1() {
        return this.receiver1;
    }

    public void setReceiver1(String str) {
        this.receiver1 = str;
    }

    public String getReceiver2() {
        return this.receiver2;
    }

    public void setReceiver2(String str) {
        this.receiver2 = str;
    }

    public String getReceiver3() {
        return this.receiver3;
    }

    public void setReceiver3(String str) {
        this.receiver3 = str;
    }

    public String getReceiver4() {
        return this.receiver4;
    }

    public void setReceiver4(String str) {
        this.receiver4 = str;
    }

    public String toString() {
        return "MailBean [svr=" + this.svr + ", user=" + this.user + ", port=" + this.port + ", pwd=" + this.pwd + ", ssl=" + this.ssl + ", sender=" + this.sender + ", receiver1=" + this.receiver1 + ", receiver2=" + this.receiver2 + ", receiver3=" + this.receiver3 + ", receiver4=" + this.receiver4 + "]";
    }
}
