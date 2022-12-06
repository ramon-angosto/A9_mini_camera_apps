package com.shix.shixipc.bean;

import com.shix.shixipc.utils.CommonUtil;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraParamsBean implements Serializable {
    private static final long serialVersionUID = -1893938966606638092L;
    private String checkstr;
    private int devMode;
    private int devType;
    private String dev_Did;
    private String dev_Pwd;
    private String dev_User;
    private String dev_name;
    private int dev_p2pstatus = -1;
    private boolean isBkDoorBell = false;
    private int resetrict = -1;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isBkDoorBell() {
        return this.isBkDoorBell;
    }

    public void setBkDoorBell(boolean z) {
        this.isBkDoorBell = z;
    }

    public String getCheckstr() {
        return this.checkstr;
    }

    public void setCheckstr(String str) {
        this.checkstr = str;
    }

    public int getDevType() {
        return this.devType;
    }

    public void setDevType(int i) {
        this.devType = i;
    }

    public int getDevMode() {
        return this.devMode;
    }

    public void setDevMode(int i) {
        this.devMode = i;
    }

    public int getResetrict() {
        return this.resetrict;
    }

    public void setResetrict(int i) {
        this.resetrict = i;
    }

    public String getDev_Did() {
        return this.dev_Did;
    }

    public void setDev_Did(String str) {
        this.dev_Did = str;
    }

    public String getDev_User() {
        return this.dev_User;
    }

    public void setDev_User(String str) {
        this.dev_User = str;
    }

    public String getDev_Pwd() {
        return this.dev_Pwd;
    }

    public void setDev_Pwd(String str) {
        this.dev_Pwd = str;
    }

    public String getDev_name() {
        return this.dev_name;
    }

    public void setDev_name(String str) {
        this.dev_name = str;
    }

    public int getDev_p2pstatus() {
        return this.dev_p2pstatus;
    }

    public void setDev_p2pstatus(int i) {
        this.dev_p2pstatus = i;
    }

    public static CameraParamsBean jsonToModel(String str) throws JSONException {
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        JSONObject jSONObject = new JSONObject(str);
        cameraParamsBean.setDev_Did(CommonUtil.jasonPaseString(jSONObject, "dev_Did"));
        cameraParamsBean.setDev_User(CommonUtil.jasonPaseString(jSONObject, "dev_User"));
        cameraParamsBean.setDev_Pwd(CommonUtil.jasonPaseString(jSONObject, "dev_Pwd"));
        cameraParamsBean.setDev_name(CommonUtil.jasonPaseString(jSONObject, "dev_name"));
        return cameraParamsBean;
    }

    public static String toJson(CameraParamsBean cameraParamsBean) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dev_Did", cameraParamsBean.getDev_Did());
        jSONObject.put("dev_User", cameraParamsBean.getDev_User());
        jSONObject.put("dev_Pwd", cameraParamsBean.getDev_Pwd());
        jSONObject.put("dev_name", cameraParamsBean.getDev_name());
        return jSONObject.toString();
    }
}
