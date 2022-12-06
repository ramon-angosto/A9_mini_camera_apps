package com.bytedance.sdk.openadsdk.core.e;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ov.PglMSConfig;
import com.bytedance.mobsec.metasec.ov.PglMSManager;
import com.bytedance.mobsec.metasec.ov.PglMSManagerUtils;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;

/* compiled from: MSSdkImpl */
class a {
    /* access modifiers changed from: private */
    public PglMSManager a;
    private volatile boolean b;
    private volatile boolean c = true;

    public a() {
        a();
    }

    public synchronized void a() {
        if (!this.b) {
            try {
                Context a2 = m.a();
                String f = h.d().f();
                if (TextUtils.isEmpty(f)) {
                    f = h.a("app_id", Long.MAX_VALUE);
                }
                if (!TextUtils.isEmpty(f)) {
                    String a3 = j.a(a2);
                    l.c("mssdk", "Sdk.APP_ID: 1371\n appId: " + f + " \n MS_SDK_LICENCE:" + "6QsgjKNXt0ThHEOR/wpJGqVuDr4bHw6oKiicVF73p9+zvKfmlFZpi9d4zgrMWd9vbyPsZIdIHuN5cgNZGzmWdjdpJjlERMNPwKHauPaQbfRfY4VRpA5s7BaQ3NqhlpVXhpJcCGkhG0r8GX6Q1ys7HXrrwSLpidXsl992B79+GPi4GB9tgR1CtqsLFzcKbbd+/j76xqkGzAl1p2JxYeZswgj5c/Mg5K2bA7MquHtxWz4N1Tkj" + " \n did: " + a3 + " ");
                    PglMSManagerUtils.init(a2, new PglMSConfig.Builder("1371", f, "6QsgjKNXt0ThHEOR/wpJGqVuDr4bHw6oKiicVF73p9+zvKfmlFZpi9d4zgrMWd9vbyPsZIdIHuN5cgNZGzmWdjdpJjlERMNPwKHauPaQbfRfY4VRpA5s7BaQ3NqhlpVXhpJcCGkhG0r8GX6Q1ys7HXrrwSLpidXsl992B79+GPi4GB9tgR1CtqsLFzcKbbd+/j76xqkGzAl1p2JxYeZswgj5c/Mg5K2bA7MquHtxWz4N1Tkj", g()).setDeviceID(a3).setClientType(1).setOVRegionType(0).build());
                    f();
                    if (this.a != null) {
                        this.a.setDeviceID(a3);
                    }
                    l.c("mssdk", "init: success");
                    this.b = true;
                } else {
                    return;
                }
            } catch (Throwable th) {
                l.c("mssdk", "init: fail");
                l.b("MSSdkImpl", "appid is empty, initialization failed! or without the mssdk module", th);
                h();
                this.b = false;
            }
        }
        return;
    }

    public boolean b() {
        return this.b;
    }

    private boolean e() {
        if (!this.b && this.c) {
            a();
        }
        return this.b;
    }

    private void f() {
        if (this.a == null) {
            this.a = PglMSManagerUtils.get("1371");
            PglMSManager pglMSManager = this.a;
            if (pglMSManager != null) {
                pglMSManager.setCollectMode(g());
            }
        }
    }

    private int g() {
        int p = y.p();
        if (p == 4 || p == 5) {
            l.c("mssdk", "getCollectMode() PglMSConfig.COLLECT_MODE_TIKTOK_USEA");
            return 503;
        }
        l.c("mssdk", "getCollectMode() PglMSConfig.COLLECT_MODE_TIKTOK_NONUSEA");
        return 603;
    }

    public void a(final String str) {
        if (e()) {
            f();
            if (this.a != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    w.a((g) new g("updateDid") {
                        public void run() {
                            if (a.this.a != null) {
                                a.this.a.setDeviceID(str);
                            }
                        }
                    });
                } else {
                    this.a.setDeviceID(str);
                }
                l.c("mssdk did: ", str);
            }
        }
    }

    public void b(String str) {
        if (e()) {
            f();
            PglMSManager pglMSManager = this.a;
            if (pglMSManager != null) {
                pglMSManager.report(str);
            }
        }
    }

    public String c() {
        if (!e()) {
            return "";
        }
        f();
        PglMSManager pglMSManager = this.a;
        if (pglMSManager == null) {
            return "";
        }
        String token = pglMSManager.getToken();
        l.c("mssdk", "secDeviceToken: " + token);
        return token;
    }

    public Map<String, String> a(String str, byte[] bArr) {
        if (!e()) {
            return new HashMap();
        }
        f();
        PglMSManager pglMSManager = this.a;
        if (pglMSManager != null) {
            return pglMSManager.getFeatureHash(str, bArr);
        }
        return new HashMap();
    }

    public String d() {
        try {
            Context a2 = m.a();
            return a(MessageDigest.getInstance("SHA1").digest(a2.getPackageManager().getPackageInfo(a2.getPackageName(), 64).signatures[0].toByteArray())).toUpperCase();
        } catch (Throwable unused) {
            return "0000000000000000000000000000000000000000";
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (byte b2 = 0; b2 < bArr.length; b2 = (byte) (b2 + 1)) {
            byte b3 = bArr[b2] & UByte.MAX_VALUE;
            int i = b2 * 2;
            cArr[i] = charArray[b3 >>> 4];
            cArr[i + 1] = charArray[b3 & 15];
        }
        return new String(cArr);
    }

    private Class h() {
        Class<?> cls = null;
        try {
            cls = Class.forName("com.bytedance.mobsec.metasec.ov.PglMS");
            this.c = true;
            l.c("mssdk", "class found");
            return cls;
        } catch (Throwable unused) {
            l.c("mssdk", "class not found ");
            this.c = false;
            return cls;
        }
    }
}
