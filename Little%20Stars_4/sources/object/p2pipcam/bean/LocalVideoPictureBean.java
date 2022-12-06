package object.p2pipcam.bean;

import java.io.Serializable;

public class LocalVideoPictureBean implements Serializable {
    private static final long serialVersionUID = 1;
    private String createTime;
    private String did;
    private String filePath;
    private String type;

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String toString() {
        return "LocalVideoPictureBean [filePath=" + this.filePath + ", createTime=" + this.createTime + ", type=" + this.type + ", did=" + this.did + "]";
    }
}
