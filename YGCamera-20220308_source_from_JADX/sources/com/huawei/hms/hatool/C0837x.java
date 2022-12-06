package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.hms.hatool.x */
public class C0837x {

    /* renamed from: b */
    public static C0837x f763b = new C0837x();

    /* renamed from: a */
    public C0838a f764a = new C0838a();

    /* renamed from: com.huawei.hms.hatool.x$a */
    public class C0838a {

        /* renamed from: a */
        public String f765a;

        /* renamed from: b */
        public String f766b;

        /* renamed from: c */
        public String f767c;

        /* renamed from: d */
        public long f768d = 0;

        public C0838a() {
        }

        /* renamed from: a */
        public void mo14129a(long j) {
            C0837x.this.f764a.f768d = j;
        }

        /* renamed from: a */
        public void mo14130a(String str) {
            C0837x.this.f764a.f767c = str;
        }

        /* renamed from: b */
        public void mo14131b(String str) {
            C0837x.this.f764a.f765a = str;
        }

        /* renamed from: c */
        public void mo14132c(String str) {
            C0837x.this.f764a.f766b = str;
        }
    }

    /* renamed from: f */
    public static C0837x m1056f() {
        return f763b;
    }

    /* renamed from: a */
    public String mo14124a() {
        return this.f764a.f767c;
    }

    /* renamed from: b */
    public long mo14125b() {
        return this.f764a.f768d;
    }

    /* renamed from: c */
    public String mo14126c() {
        return this.f764a.f766b;
    }

    /* renamed from: d */
    public void mo14127d() {
        long b = mo14125b();
        if (b == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String e = mo14128e();
            if (TextUtils.isEmpty(e)) {
                C0841y.m1092f("hmsSdk", "get rsa pubkey config error");
                return;
            }
            String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
            String a = C0787e.m788a(e, generateSecureRandomStr);
            this.f764a.mo14131b(e);
            this.f764a.mo14129a(currentTimeMillis);
            this.f764a.mo14132c(generateSecureRandomStr);
            this.f764a.mo14130a(a);
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 - b > 43200000) {
            String str = this.f764a.f765a;
            String generateSecureRandomStr2 = EncryptUtil.generateSecureRandomStr(16);
            String a2 = C0787e.m788a(str, generateSecureRandomStr2);
            this.f764a.mo14129a(currentTimeMillis2);
            this.f764a.mo14132c(generateSecureRandomStr2);
            this.f764a.mo14130a(a2);
        }
    }

    /* renamed from: e */
    public final String mo14128e() {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = C0777b.m729f().getResources().getAssets().open("hianalytics_njjn");
            try {
                String a = C0826r0.m1014a(inputStream);
                C0826r0.m1015a((Closeable) inputStream);
                return a;
            } catch (IOException unused) {
                try {
                    C0841y.m1092f("hmsSdk", "read pubKey error,the file is corrupted");
                    C0826r0.m1015a((Closeable) inputStream);
                    return null;
                } catch (Throwable th2) {
                    InputStream inputStream3 = inputStream;
                    th = th2;
                    inputStream2 = inputStream3;
                    C0826r0.m1015a((Closeable) inputStream2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            inputStream = null;
            C0841y.m1092f("hmsSdk", "read pubKey error,the file is corrupted");
            C0826r0.m1015a((Closeable) inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            C0826r0.m1015a((Closeable) inputStream2);
            throw th;
        }
    }
}
