package com.bytedance.sdk.openadsdk.i;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.c.b;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import java.util.Map;

/* compiled from: TTAdNetDepend */
public class c implements b {
    String a = "sp_multi_ttadnet_config";
    private Context b;

    public Address a(Context context) {
        return null;
    }

    public String b() {
        return "pangle_sdk";
    }

    public String c() {
        return "android";
    }

    public int d() {
        return BuildConfig.VERSION_CODE;
    }

    public c(Context context) {
        this.b = context;
    }

    public int a() {
        return Integer.parseInt("1371");
    }

    public String e() {
        return j.a(this.b);
    }

    public String a(Context context, String str, String str2) {
        return a.b(this.a, str, str2);
    }

    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    Object value = next.getValue();
                    if (value instanceof Integer) {
                        a.a(this.a, (String) next.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        a.a(this.a, (String) next.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        a.a(this.a, (String) next.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        a.a(this.a, (String) next.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        a.a(this.a, (String) next.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String[] f() {
        String[] strArr = {"tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com", "tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com"};
        String F = m.d().F();
        if (!TextUtils.isEmpty(F)) {
            return ("SG".equals(F) || "CN".equals(F)) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
        }
        int p = y.p();
        return (p == 2 || p == 1) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
    }
}
