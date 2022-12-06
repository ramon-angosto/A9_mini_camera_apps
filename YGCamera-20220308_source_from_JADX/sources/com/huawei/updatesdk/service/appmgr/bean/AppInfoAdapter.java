package com.huawei.updatesdk.service.appmgr.bean;

import java.util.List;

public class AppInfoAdapter {
    private String appId;
    private String appStorePkgName;
    private String business;
    private String carrierId;
    private boolean isShowImmediate = false;
    private int minIntervalDay = 0;
    private boolean mustBtnOne = false;
    private List<String> packageList;
    private String serviceZone;
    private String targetPkgName;

    public String getAppId() {
        return this.appId;
    }

    public String getAppStorePkgName() {
        return this.appStorePkgName;
    }

    public String getBusiness() {
        return this.business;
    }

    public String getCarrierId() {
        return this.carrierId;
    }

    public int getMinIntervalDay() {
        return this.minIntervalDay;
    }

    public List<String> getPackageList() {
        return this.packageList;
    }

    public String getServiceZone() {
        return this.serviceZone;
    }

    public String getTargetPkgName() {
        return this.targetPkgName;
    }

    public boolean isMustBtnOne() {
        return this.mustBtnOne;
    }

    public boolean isShowImmediate() {
        return this.isShowImmediate;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppStorePkgName(String str) {
        this.appStorePkgName = str;
    }

    public void setBusiness(String str) {
        this.business = str;
    }

    public void setCarrierId(String str) {
        this.carrierId = str;
    }

    public void setMinIntervalDay(int i) {
        this.minIntervalDay = i;
    }

    public void setMustBtnOne(boolean z) {
        this.mustBtnOne = z;
    }

    public void setPackageList(List<String> list) {
        this.packageList = list;
    }

    public void setServiceZone(String str) {
        this.serviceZone = str;
    }

    public void setShowImmediate(boolean z) {
        this.isShowImmediate = z;
    }

    public void setTargetPkgName(String str) {
        this.targetPkgName = str;
    }
}
