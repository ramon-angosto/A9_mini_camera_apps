package com.bytedance.sdk.openadsdk.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.f.b.c;
import com.bytedance.sdk.openadsdk.l.v;
import java.util.Map;

/* compiled from: NetHook */
public final class d extends a {
    public static c a;

    public String a() {
        return "net";
    }

    public static String a(c cVar, String str) {
        c a2;
        if (!v.c() || (a2 = b.a("net")) == null) {
            return str;
        }
        Map map = (Map) a2.a(1, str);
        if (map == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                cVar.b(str3, (String) map2.get(str3));
            }
        }
        return str;
    }
}
