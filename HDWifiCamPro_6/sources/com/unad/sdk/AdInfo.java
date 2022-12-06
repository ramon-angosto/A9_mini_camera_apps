package com.unad.sdk;

import com.unad.sdk.dto.AdList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdInfo implements Serializable {
    private List<AdList> adUnits = new ArrayList();
    private String appId;
    private String bigo;
    private String chose;
    private String des;
    private String facebook;
    private String idServer;
    private boolean isGetServiceId;
    private boolean isOpenLogs;
    private String mintegral;
    private boolean openApplovin;
    private String pangle;
    private String status;

    public List<AdList> getAdUnits() {
        return this.adUnits;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBigo() {
        return this.bigo;
    }

    public String getChose() {
        return this.chose;
    }

    public String getDes() {
        return this.des;
    }

    public String getFacebook() {
        return this.facebook;
    }

    public String getIdServer() {
        return this.idServer;
    }

    public String getMintegral() {
        return this.mintegral;
    }

    public String getPangle() {
        return this.pangle;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isGetServiceId() {
        return this.isGetServiceId;
    }

    public boolean isOpenApplovin() {
        return this.openApplovin;
    }

    public boolean isOpenLogs() {
        return this.isOpenLogs;
    }

    public void setAdUnits(List<AdList> list) {
        this.adUnits = list;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBigo(String str) {
        this.bigo = str;
    }

    public void setChose(String str) {
        this.chose = str;
    }

    public void setDes(String str) {
        this.des = str;
    }

    public void setFacebook(String str) {
        this.facebook = str;
    }

    public void setGetServiceId(boolean z) {
        this.isGetServiceId = z;
    }

    public void setIdServer(String str) {
        this.idServer = str;
    }

    public void setMintegral(String str) {
        this.mintegral = str;
    }

    public void setOpenApplovin(boolean z) {
        this.openApplovin = z;
    }

    public void setOpenLogs(boolean z) {
        this.isOpenLogs = z;
    }

    public void setPangle(String str) {
        this.pangle = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
