package com.huawei.appgallery.serviceverifykit.p009b.p010d;

import android.util.Log;

/* renamed from: com.huawei.appgallery.serviceverifykit.b.d.b */
public class C0577b {

    /* renamed from: b */
    public static final C0577b f170b = new C0577b();

    /* renamed from: a */
    private boolean f171a;

    private C0577b() {
        try {
            Class.forName("com.huawei.appgallery.log.LogAdaptor");
            this.f171a = true;
        } catch (ClassNotFoundException unused) {
            this.f171a = false;
        }
    }

    /* renamed from: a */
    public void mo12804a(String str, String str2) {
        if (this.f171a) {
            C0576a.f169a.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    /* renamed from: a */
    public void mo12805a(String str, String str2, Throwable th) {
        if (this.f171a) {
            C0576a.f169a.e(str, str2, th);
        } else {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: b */
    public void mo12806b(String str, String str2) {
        if (this.f171a) {
            C0576a.f169a.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }
}
