package com.apm.insight.k;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.apm.insight.entity.b;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.o;
import com.apm.insight.l.q;
import com.apm.insight.runtime.a;
import com.apm.insight.runtime.e;
import com.apm.insight.runtime.p;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class k {
    private static File a = null;
    private static boolean b = false;
    private static boolean c = false;
    private static String d = "exception_modules";
    private static String e = "npth";
    private static Map<String, String> f;

    public static void a(String str) {
        if (f == null) {
            f = new HashMap();
        }
        f.put(str, String.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(boolean r2, org.json.JSONArray r3) {
        /*
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0013 }
            android.content.Context r0 = com.apm.insight.h.g()     // Catch:{ IOException -> 0x0013 }
            java.lang.String r0 = com.apm.insight.l.o.j((android.content.Context) r0)     // Catch:{ IOException -> 0x0013 }
            java.lang.String r1 = "apminsight/configCrash/configFile"
            r2.<init>(r0, r1)     // Catch:{ IOException -> 0x0013 }
            r0 = 0
            com.apm.insight.l.i.a((java.io.File) r2, (org.json.JSONArray) r3, (boolean) r0)     // Catch:{ IOException -> 0x0013 }
        L_0x0013:
            java.io.File r2 = f()     // Catch:{ all -> 0x001c }
            java.util.Map<java.lang.String, java.lang.String> r3 = f     // Catch:{ all -> 0x001c }
            com.apm.insight.l.i.a((java.io.File) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x001c }
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.k.a(boolean, org.json.JSONArray):void");
    }

    static boolean a() {
        return b;
    }

    static boolean a(boolean z) {
        try {
            f = f == null ? i.e(f()) : f;
            if (f == null) {
                f = new HashMap();
                return true;
            } else if (f.size() < b.c()) {
                return true;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z2 = false;
                for (Map.Entry next : f.entrySet()) {
                    if (currentTimeMillis - Long.decode((String) next.getValue()).longValue() > e.e((String) next.getKey())) {
                        z2 = true;
                    }
                }
                q.a((Object) z2 ? "config should be updated" : "config should not be updated");
                return z2;
            }
        } catch (Throwable th) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th);
            return true;
        }
    }

    static boolean b() {
        return c;
    }

    static void c() {
        if (!b) {
            c = true;
            File file = new File(o.j(h.g()), "apminsight/configCrash/configFile");
            if (file.exists()) {
                try {
                    a.a(new JSONArray(i.c(file)), false);
                    b = true;
                } catch (Throwable unused) {
                    a.a((JSONArray) null, false);
                }
            }
        }
    }

    public static void d() {
        c();
        if (a(false)) {
            a.a();
        }
    }

    public static void e() {
        p.b().a((Runnable) new Runnable() {
            public void run() {
                if (k.a(false)) {
                    a.a();
                }
            }
        });
    }

    private static File f() {
        if (a == null) {
            a = new File(o.j(h.g()), "apminsight/configCrash/configInvalid");
        }
        return a;
    }
}
