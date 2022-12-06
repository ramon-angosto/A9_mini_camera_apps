package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

/* renamed from: com.huawei.updatesdk.service.otaupdate.d */
public class C1083d {

    /* renamed from: b */
    private static final Object f1471b = new Object();

    /* renamed from: c */
    private static C1083d f1472c;

    /* renamed from: a */
    private CheckUpdateCallBack f1473a;

    /* renamed from: a */
    public static C1083d m2090a() {
        C1083d dVar;
        synchronized (f1471b) {
            if (f1472c == null) {
                f1472c = new C1083d();
            }
            dVar = f1472c;
        }
        return dVar;
    }

    /* renamed from: a */
    public void mo15189a(int i) {
        CheckUpdateCallBack checkUpdateCallBack = this.f1473a;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onMarketStoreError(i);
        }
    }

    /* renamed from: a */
    public void mo15190a(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack = this.f1473a;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onMarketInstallInfo(intent);
        }
    }

    /* renamed from: a */
    public void mo15191a(CheckUpdateCallBack checkUpdateCallBack) {
        this.f1473a = checkUpdateCallBack;
    }

    /* renamed from: b */
    public void mo15192b(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack = this.f1473a;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onUpdateInfo(intent);
        }
    }
}
