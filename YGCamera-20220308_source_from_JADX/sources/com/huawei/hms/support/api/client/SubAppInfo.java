package com.huawei.hms.support.api.client;

public class SubAppInfo {

    /* renamed from: a */
    private String f964a;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.f964a = subAppInfo.getSubAppID();
        }
    }

    public String getSubAppID() {
        return this.f964a;
    }

    public void setSubAppID(String str) {
        this.f964a = str;
    }

    public SubAppInfo(String str) {
        this.f964a = str;
    }
}
