package com.huawei.updatesdk.p039b.p043b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;

/* renamed from: com.huawei.updatesdk.b.b.a */
public final class C1003a {

    /* renamed from: d */
    private static final Object f1360d = new Object();

    /* renamed from: e */
    private static C1003a f1361e;

    /* renamed from: a */
    private C1004b f1362a;

    /* renamed from: b */
    private String f1363b;

    /* renamed from: c */
    private boolean f1364c = false;

    private C1003a(Context context) {
        this.f1362a = C1004b.m1844a("DeviceSessionUpdateSDK_V1", context);
    }

    /* renamed from: d */
    public static C1003a m1831d() {
        C1003a aVar;
        synchronized (f1360d) {
            if (f1361e == null) {
                f1361e = new C1003a(C0985a.m1757c().mo14892a());
            }
            aVar = f1361e;
        }
        return aVar;
    }

    /* renamed from: a */
    public String mo14954a() {
        return this.f1363b;
    }

    /* renamed from: a */
    public String mo14955a(String str) {
        C1004b bVar = this.f1362a;
        return bVar.mo14967a("updatesdk.lastAccountZone" + str, "");
    }

    /* renamed from: a */
    public void mo14956a(long j) {
        this.f1362a.mo14969b("updatesdk.lastCheckDate", j);
    }

    /* renamed from: a */
    public void mo14957a(String str, long j) {
        C1004b bVar = this.f1362a;
        bVar.mo14969b("updatesdk.lastInitAccountTime" + str, j);
    }

    /* renamed from: a */
    public void mo14958a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f1362a.mo14970b(str, str2);
        }
    }

    /* renamed from: b */
    public long mo14959b() {
        return this.f1362a.mo14966a("updatesdk.lastCheckDate", 0);
    }

    /* renamed from: b */
    public long mo14960b(String str) {
        C1004b bVar = this.f1362a;
        return bVar.mo14966a("updatesdk.lastInitAccountTime" + str, 0);
    }

    /* renamed from: b */
    public void mo14961b(String str, String str2) {
        C1004b bVar = this.f1362a;
        bVar.mo14970b("updatesdk.lastAccountZone" + str, str2);
    }

    /* renamed from: c */
    public String mo14962c(String str) {
        return TextUtils.isEmpty(str) ? "" : this.f1362a.mo14967a(str, "");
    }

    /* renamed from: c */
    public void mo14963c() {
        if (!this.f1364c) {
            mo14964d("updatesdk.sign.param");
            mo14964d("updatesdk.signkey");
            mo14964d("updatesdk.signtime");
            this.f1364c = true;
        }
    }

    /* renamed from: d */
    public void mo14964d(String str) {
        this.f1362a.mo14968a(str);
    }

    /* renamed from: e */
    public void mo14965e(String str) {
        this.f1363b = str;
    }
}
