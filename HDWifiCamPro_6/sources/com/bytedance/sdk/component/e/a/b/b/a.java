package com.bytedance.sdk.component.e.a.b.b;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.a.a.f;
import com.bytedance.sdk.component.e.a.a.a.g;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.i;
import java.util.List;

/* compiled from: EventProviderImpl */
public class a {
    private static ContentResolver c() {
        try {
            if (i.e().d() != null) {
                return i.e().d().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a() {
        c.a("start()");
        if (i.e().d() != null) {
            try {
                ContentResolver c = c();
                if (c != null) {
                    c.getType(Uri.parse(d() + "adLogStart"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b() {
        if (i.e().d() != null) {
            try {
                ContentResolver c = c();
                if (c != null) {
                    c.getType(Uri.parse(d() + "adLogStop"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(com.bytedance.sdk.component.e.a.d.a aVar) {
        if (aVar != null) {
            try {
                ContentResolver c = c();
                if (c != null) {
                    String a = f.a(aVar.f());
                    c.getType(Uri.parse(d() + "adLogDispatch" + "?event=" + a));
                    c.a("dispatch event getType end ");
                }
            } catch (Throwable th) {
                c.d("dispatch event Throwable:" + th.toString());
            }
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String a : list) {
                    sb.append(f.a(a));
                    sb.append(",");
                }
                String a2 = f.a(sb.toString());
                String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(a2) + "&replace=" + String.valueOf(z);
                ContentResolver c = c();
                if (c != null) {
                    c.getType(Uri.parse(d() + "trackAdUrl" + str2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver c = c();
                if (c != null) {
                    c.getType(Uri.parse(d() + "trackAdFailed" + "?did=" + String.valueOf(str)));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String d() {
        return g.b + "/" + "ad_log_event" + "/";
    }
}
