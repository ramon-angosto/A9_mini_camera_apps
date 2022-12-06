package com.mbridge.msdk.foundation.same.net.h;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.c.a;
import com.mbridge.msdk.foundation.tools.q;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: CommonRequestParams */
public final class d {
    public static String a = CampaignUnit.JSON_KEY_SESSION_ID;
    public static String b = "d";
    public static String c = "e";
    public static String d = "f";
    public static String e = "g";
    public static String f = "h";
    public static String g = "i";
    private static final String h = d.class.getSimpleName();
    private Map<String, String> i = new LinkedHashMap();
    private Map<String, a> j = new LinkedHashMap();

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.i.put(str, str2);
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : this.i.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public final void a(String str) {
        this.i.remove(str);
        this.j.remove(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry next : this.i.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
            }
            for (Map.Entry next2 : this.j.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode((String) next2.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + ((a) next2.getValue()).a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            q.d(h, e2.getMessage());
        }
        return sb.toString();
    }

    public final Map<String, String> b() {
        return this.i;
    }
}
