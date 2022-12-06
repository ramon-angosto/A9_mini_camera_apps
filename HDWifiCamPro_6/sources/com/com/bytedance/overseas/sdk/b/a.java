package com.com.bytedance.overseas.sdk.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.vungle.warren.VungleApiClient;

/* compiled from: AdvertisingIdHelper */
public class a {
    private static volatile a b;
    private String a = "";

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private a() {
    }

    public String b() {
        if (!m.d().x(VungleApiClient.GAID)) {
            return "";
        }
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        this.a = c.a(m.a()).b(VungleApiClient.GAID, "");
        return this.a;
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.a(m.a()).a(VungleApiClient.GAID, str);
        }
    }

    public void b(String str) {
        this.a = str;
    }
}
