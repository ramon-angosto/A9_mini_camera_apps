package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.x;
import java.util.List;

/* compiled from: HttpUtils */
public class b {
    private static final String a = b.class.getSimpleName();

    public static String a(List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        com.mbridge.msdk.foundation.same.net.c.b b = b(list, HttpHeaders.CONTENT_TYPE);
        if (b != null) {
            String b2 = b.b();
            if (!TextUtils.isEmpty(b2)) {
                String[] split = b2.split(";");
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].trim().split("=");
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
        }
        return "UTF-8";
    }

    private static com.mbridge.msdk.foundation.same.net.c.b b(List<com.mbridge.msdk.foundation.same.net.c.b> list, String str) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                com.mbridge.msdk.foundation.same.net.c.b bVar = list.get(i);
                if (bVar != null && str.equals(bVar.a())) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public static String a(List<com.mbridge.msdk.foundation.same.net.c.b> list, String str) {
        com.mbridge.msdk.foundation.same.net.c.b b = b(list, str);
        return b != null ? b.b() : "";
    }

    public static boolean b(List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        return TextUtils.equals(a(list, HttpHeaders.CONTENT_ENCODING), "gzip");
    }

    public static void a(d dVar, String str, String str2) {
        if (dVar != null) {
            try {
                if (x.a(str)) {
                    return;
                }
                if (!x.a(str2)) {
                    dVar.a(str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
