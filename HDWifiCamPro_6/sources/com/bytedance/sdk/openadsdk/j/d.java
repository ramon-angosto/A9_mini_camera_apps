package com.bytedance.sdk.openadsdk.j;

/* compiled from: NetType */
public enum d {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_UNKNOWN("mobile");
    
    private String g;

    private d(String str) {
        this.g = str;
    }

    public String toString() {
        return this.g;
    }
}
