package com.huawei.secure.android.common.util;

public class SecurityCommonException extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: v */
    private String f1273v;

    /* renamed from: w */
    private String f1274w;

    public SecurityCommonException() {
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f1274w = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f1273v = str;
        this.f1274w = str2;
    }

    public String getRetCd() {
        return this.f1273v;
    }

    public String getMsgDes() {
        return this.f1274w;
    }
}
