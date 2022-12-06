package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult {

    /* renamed from: a */
    private int f959a;

    /* renamed from: b */
    private Bundle f960b;

    public BundleResult(int i, Bundle bundle) {
        this.f959a = i;
        this.f960b = bundle;
    }

    public int getResultCode() {
        return this.f959a;
    }

    public Bundle getRspBody() {
        return this.f960b;
    }

    public void setResultCode(int i) {
        this.f959a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.f960b = bundle;
    }
}
