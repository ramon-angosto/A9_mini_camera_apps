package com.huawei.hms.push.ups.entity;

public class CodeResult {

    /* renamed from: a */
    public int f936a;

    /* renamed from: b */
    public String f937b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f937b;
    }

    public int getReturnCode() {
        return this.f936a;
    }

    public void setReason(String str) {
        this.f937b = str;
    }

    public void setReturnCode(int i) {
        this.f936a = i;
    }

    public CodeResult(int i) {
        this.f936a = i;
    }

    public CodeResult(int i, String str) {
        this.f936a = i;
        this.f937b = str;
    }
}
