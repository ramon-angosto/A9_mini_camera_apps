package object.p2pipcam.bean;

import java.io.Serializable;

public class PlayBackBean implements Serializable {
    private static final long serialVersionUID = 1;
    private String did;
    private String path;

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
