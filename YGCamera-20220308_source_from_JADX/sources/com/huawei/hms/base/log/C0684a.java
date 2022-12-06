package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* renamed from: com.huawei.hms.base.log.a */
/* compiled from: LogAdaptor */
public class C0684a {

    /* renamed from: c */
    public static final C0685b f419c = new C0687d();

    /* renamed from: a */
    public int f420a = 4;

    /* renamed from: b */
    public String f421b;

    /* renamed from: a */
    public void mo13315a(Context context, int i, String str) {
        this.f420a = i;
        this.f421b = str;
        f419c.mo13319a(context, "HMSCore");
    }

    /* renamed from: b */
    public void mo13318b(int i, String str, String str2, Throwable th) {
        if (mo13317a(i)) {
            C0686c a = mo13313a(i, str, str2, th);
            C0685b bVar = f419c;
            bVar.mo13320a(a.mo13327c() + a.mo13323a(), i, str, str2 + 10 + Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    public boolean mo13317a(int i) {
        return i >= this.f420a;
    }

    /* renamed from: a */
    public void mo13314a(int i, String str, String str2) {
        if (mo13317a(i)) {
            C0686c a = mo13313a(i, str, str2, (Throwable) null);
            f419c.mo13320a(a.mo13327c() + a.mo13323a(), i, str, str2);
        }
    }

    /* renamed from: a */
    public void mo13316a(String str, String str2) {
        C0686c a = mo13313a(4, str, str2, (Throwable) null);
        f419c.mo13320a(a.mo13327c() + 10 + a.mo13323a(), 4, str, str2);
    }

    /* renamed from: a */
    public final C0686c mo13313a(int i, String str, String str2, Throwable th) {
        C0686c cVar = new C0686c(8, this.f421b, i, str);
        cVar.mo13321a(str2);
        cVar.mo13322a(th);
        return cVar;
    }
}
