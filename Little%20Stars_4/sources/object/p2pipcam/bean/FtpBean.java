package object.p2pipcam.bean;

public class FtpBean {
    private String dir;
    private int mode;
    private int port;
    private String pwd;
    private String svr_ftp;
    private int upload_interval;
    private String user;

    public String getDir() {
        return this.dir;
    }

    public void setDir(String str) {
        this.dir = str;
    }

    public String getSvr_ftp() {
        return this.svr_ftp;
    }

    public void setSvr_ftp(String str) {
        this.svr_ftp = str;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public int getUpload_interval() {
        return this.upload_interval;
    }

    public void setUpload_interval(int i) {
        this.upload_interval = i;
    }

    public String toString() {
        return "FtpBean [svr_ftp=" + this.svr_ftp + ", user=" + this.user + ", pwd=" + this.pwd + ", port=" + this.port + ", mode=" + this.mode + ", upload_interval=" + this.upload_interval + ", dir=" + this.dir + "]";
    }
}
