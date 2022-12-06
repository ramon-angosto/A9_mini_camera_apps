package com.huawei.updatesdk.p025a.p034b.p036b;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.p025a.p026a.C0964a;

/* renamed from: com.huawei.updatesdk.a.b.b.b */
public final class C0987b {

    /* renamed from: a */
    private Intent f1329a;

    private C0987b(Intent intent) {
        this.f1329a = intent;
    }

    /* renamed from: a */
    public static C0987b m1761a(Intent intent) {
        return new C0987b(intent);
    }

    /* renamed from: a */
    public int mo14896a(String str, int i) {
        if (mo14903d()) {
            try {
                return this.f1329a.getIntExtra(str, i);
            } catch (Exception unused) {
                C0964a.m1666a("SecureIntent", "getIntExtra exception!");
            }
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f1329a.getAction();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo14897a() {
        /*
            r2 = this;
            boolean r0 = r2.mo14903d()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0012
            android.content.Intent r0 = r2.f1329a
            java.lang.String r0 = r0.getAction()
            if (r0 != 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r1 = r0
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p025a.p034b.p036b.C0987b.mo14897a():java.lang.String");
    }

    /* renamed from: a */
    public String mo14898a(String str) {
        if (!mo14903d()) {
            return "";
        }
        try {
            return this.f1329a.getStringExtra(str);
        } catch (Exception unused) {
            C0964a.m1666a("SecureIntent", "getStringExtra exception!");
            return "";
        }
    }

    /* renamed from: a */
    public boolean mo14899a(String str, boolean z) {
        if (mo14903d()) {
            try {
                return this.f1329a.getBooleanExtra(str, z);
            } catch (Exception unused) {
                C0964a.m1666a("SecureIntent", "getBooleanExtra exception!");
            }
        }
        return z;
    }

    /* renamed from: b */
    public long mo14900b(String str, int i) {
        if (mo14903d()) {
            try {
                return this.f1329a.getLongExtra(str, (long) i);
            } catch (Exception unused) {
                C0964a.m1666a("SecureIntent", "getIntExtra exception!");
            }
        }
        return (long) i;
    }

    /* renamed from: b */
    public Bundle mo14901b() {
        if (mo14903d()) {
            return this.f1329a.getExtras();
        }
        return null;
    }

    /* renamed from: c */
    public Intent mo14902c() {
        return this.f1329a;
    }

    /* renamed from: d */
    public boolean mo14903d() {
        return this.f1329a != null;
    }
}
