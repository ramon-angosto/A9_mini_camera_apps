package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* renamed from: com.huawei.hms.hatool.d0 */
public class C0785d0 {

    /* renamed from: c */
    public static C0785d0 f611c;

    /* renamed from: a */
    public String f612a;

    /* renamed from: b */
    public String f613b;

    /* renamed from: f */
    public static C0785d0 m776f() {
        if (f611c == null) {
            m777g();
        }
        return f611c;
    }

    /* renamed from: g */
    public static synchronized void m777g() {
        synchronized (C0785d0.class) {
            if (f611c == null) {
                f611c = new C0785d0();
            }
        }
    }

    /* renamed from: a */
    public String mo13938a() {
        if (TextUtils.isEmpty(this.f612a)) {
            this.f612a = mo13942c();
        }
        return this.f612a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (mo13945e() != false) goto L_0x003d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo13939a(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = r2.mo13945e()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "analytics_keystore"
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.decrypt((java.lang.String) r0, (java.lang.String) r3)
            goto L_0x000f
        L_0x000d:
            java.lang.String r0 = ""
        L_0x000f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x004f
            java.lang.String r0 = "hmsSdk"
            java.lang.String r1 = "deCrypt work key first"
            com.huawei.hms.hatool.C0841y.m1087c(r0, r1)
            java.lang.String r0 = r2.mo13944d()
            java.lang.String r0 = com.huawei.hms.hatool.C0784d.m774a(r3, r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0041
            r3 = 16
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(r3)
            java.lang.String r3 = r2.mo13940b(r0)
            r2.mo13943c(r3)
            boolean r3 = r2.mo13945e()
            if (r3 == 0) goto L_0x004f
        L_0x003d:
            com.huawei.hms.hatool.C0782c0.m757d()
            goto L_0x004f
        L_0x0041:
            boolean r3 = r2.mo13945e()
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = r2.mo13940b(r0)
            r2.mo13943c(r3)
            goto L_0x003d
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.C0785d0.mo13939a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public final String mo13940b(String str) {
        return mo13945e() ? AesGcmKS.encrypt("analytics_keystore", str) : C0784d.m775b(str, mo13944d());
    }

    /* renamed from: b */
    public void mo13941b() {
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (mo13943c(mo13940b(generateSecureRandomStr))) {
            this.f612a = generateSecureRandomStr;
        }
    }

    /* renamed from: c */
    public final String mo13942c() {
        String a = C0796g0.m829a(C0777b.m729f(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(a)) {
            return mo13939a(a);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        mo13943c(mo13940b(generateSecureRandomStr));
        return generateSecureRandomStr;
    }

    /* renamed from: c */
    public final boolean mo13943c(String str) {
        C0841y.m1087c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            C0841y.m1087c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        C0796g0.m834b(C0777b.m729f(), "Privacy_MY", "PrivacyData", str);
        C0796g0.m833b(C0777b.m729f(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    /* renamed from: d */
    public final String mo13944d() {
        if (TextUtils.isEmpty(this.f613b)) {
            this.f613b = new C0782c0().mo13923a();
        }
        return this.f613b;
    }

    /* renamed from: e */
    public final boolean mo13945e() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
