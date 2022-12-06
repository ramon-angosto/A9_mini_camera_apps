package object.p2pipcam.bean;

import android.graphics.Bitmap;
import java.io.Serializable;
import object.p2pipcam.utils.CommonUtil;

public class CameraParamsBean implements Serializable {
    private static final long serialVersionUID = -1893938966606638092L;
    private boolean authority;
    private Bitmap bmp;
    private int devType;
    private String did;
    private int index1;
    private int mode;
    private String name;
    private Bitmap playBitmap;
    private String pwd;
    private boolean selected;
    private int status;
    private String strServer;
    private int sum;
    private int sum_pic;
    private String user;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getDevType() {
        return this.devType;
    }

    public void setDevType(int i) {
        this.devType = i;
    }

    public String getStrServer() {
        return this.strServer;
    }

    public void setStrServer(String str) {
        this.strServer = str;
    }

    public Bitmap getPlayBitmap() {
        return this.playBitmap;
    }

    public void setPlayBitmap(Bitmap bitmap) {
        this.playBitmap = bitmap;
    }

    public int getIndex1() {
        return this.index1;
    }

    public void setIndex1(int i) {
        this.index1 = i;
    }

    public int getSum_pic() {
        return this.sum_pic;
    }

    public void setSum_pic(int i) {
        this.sum_pic = i;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public boolean isAuthority() {
        return this.authority;
    }

    public void setAuthority(boolean z) {
        this.authority = z;
    }

    public Bitmap getBmp() {
        CommonUtil.Log(1, "getBmp");
        return this.bmp;
    }

    public void setBmp(Bitmap bitmap) {
        CommonUtil.Log(1, "setBmp");
        this.bmp = bitmap;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int i) {
        this.sum = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
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

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "CameraParamsBean [did=" + this.did + ", user=" + this.user + ", pwd=" + this.pwd + ", name=" + this.name + "]";
    }
}
