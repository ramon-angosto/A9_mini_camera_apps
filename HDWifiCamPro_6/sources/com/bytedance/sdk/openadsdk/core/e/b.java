package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SecSdkHelper */
class b {
    private static a a;
    private String b;

    /* compiled from: SecSdkHelper */
    private static class a {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    private b() {
        this.b = null;
        a = new a();
    }

    public void a(String str) {
        a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = a) != null) {
            aVar.a(str);
        }
    }

    public static b a() {
        return a.a;
    }

    public void b(String str) {
        a aVar = a;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public boolean b() {
        a aVar = a;
        if (aVar == null) {
            return false;
        }
        return aVar.b();
    }

    public String c() {
        try {
            l.c("mssdk", "enter getSha1");
            if (!TextUtils.isEmpty(this.b)) {
                l.c("mssdk", "sha1 RAM getSha1 " + this.b);
                return this.b;
            }
            this.b = h.a("sdk_app_sha1", 2592000000L);
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            if (a != null) {
                this.b = a.d();
            }
            if (c(this.b)) {
                this.b = this.b.toUpperCase();
                h.a("sdk_app_sha1", this.b);
                return this.b;
            }
            this.b = c.a(m.a());
            if (!c(this.b)) {
                return "";
            }
            this.b = this.b.toUpperCase();
            h.a("sdk_app_sha1", this.b);
            return this.b;
        } catch (Exception unused) {
            return "";
        }
    }

    private boolean c(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length < 20) {
            return false;
        }
        for (String equals : split) {
            if (!"00".equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        a aVar = a;
        if (aVar == null) {
            return "";
        }
        String c = aVar.c();
        l.c("mssdk", "sec_did: " + c);
        return c != null ? c : "";
    }

    public Map<String, String> a(String str, byte[] bArr) {
        a aVar = a;
        if (aVar != null) {
            return aVar.a("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", bArr);
        }
        return new HashMap();
    }
}
