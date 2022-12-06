package com.huawei.hms.push.ups.entity;

public class TokenResult extends CodeResult {

    /* renamed from: c */
    public String f938c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f938c;
    }

    public void setToken(String str) {
        this.f938c = str;
    }

    public TokenResult(int i) {
        super(i);
    }

    public TokenResult(int i, String str) {
        super(i, str);
    }

    public TokenResult(String str) {
        this.f938c = str;
    }
}
