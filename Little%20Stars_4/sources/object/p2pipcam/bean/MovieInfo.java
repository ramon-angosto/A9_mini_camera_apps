package object.p2pipcam.bean;

import java.io.Serializable;
import java.util.Date;

public class MovieInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String camerName;
    public Date date;
    public String displayName;
    public int page;
    public String path;
    public String size;
    public int totalPage;
    public String videoName;

    public String getVideoName() {
        return this.videoName;
    }

    public void setVideoName(String str) {
        this.videoName = str;
    }

    public String getCamerName() {
        return this.camerName;
    }

    public void setCamerName(String str) {
        this.camerName = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }
}
