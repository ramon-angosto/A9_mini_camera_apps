package object.p2pipcam.bean;

import java.io.Serializable;

public class AlarmLogBean implements Serializable {
    private static final long serialVersionUID = 1;
    private String UUID;
    private String camName;
    private String content;
    private String createtime;
    private String did;
    private int isPic;
    private int status;
    private String user;

    public static long getSerialversionuid() {
        return 1;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getIsPic() {
        return this.isPic;
    }

    public void setIsPic(int i) {
        this.isPic = i;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String str) {
        this.UUID = str;
    }

    public String getCamName() {
        return this.camName;
    }

    public void setCamName(String str) {
        this.camName = str;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public String toString() {
        return "AlarmLogBean [camName=" + this.camName + ", did=" + this.did + ", content=" + this.content + ", createtime=" + this.createtime + "]";
    }
}
