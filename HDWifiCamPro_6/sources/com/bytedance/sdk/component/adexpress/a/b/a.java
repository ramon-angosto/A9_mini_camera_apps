package com.bytedance.sdk.component.adexpress.a.b;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.a.c.a;
import com.bytedance.sdk.component.adexpress.a.c.b;
import com.bytedance.sdk.component.adexpress.a.c.c;
import com.bytedance.sdk.component.adexpress.c.c;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.l;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: TTDynamic */
public class a {
    static Object a = new Object();

    public static void a() {
        c.a();
    }

    public static void b() {
        try {
            f.d();
            File f = c.f();
            if (f != null && f.exists()) {
                if (f.getParentFile() != null) {
                    f.c(f.getParentFile());
                } else {
                    f.c(f);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(c cVar) {
        e.a().a(cVar, cVar.f);
    }

    public static String c() {
        return d.c();
    }

    public static b a(String str) {
        return e.a().a(str);
    }

    public static Set<String> b(String str) {
        return e.a().b(str);
    }

    public static b c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b a2 = e.a().a(str);
        if (a2 != null) {
            a2.a(Long.valueOf(System.currentTimeMillis()));
            a(a2);
        }
        return a2;
    }

    private static void a(final b bVar) {
        e.a(new g("updateTmplTime") {
            public void run() {
                synchronized (a.a) {
                    d.a().a(bVar);
                }
            }
        }, 10);
    }

    public static com.bytedance.sdk.component.adexpress.a.c.a d() {
        return c.a().d();
    }

    public static String e() {
        if (d() == null) {
            return null;
        }
        return d().c();
    }

    public static boolean f() {
        return c.a().c();
    }

    public static WebResourceResponse a(String str, c.a aVar, String str2) {
        File e = e(str);
        if (e == null) {
            e = d(str);
        }
        if (e != null) {
            try {
                return new WebResourceResponse(aVar.a(), "utf-8", new FileInputStream(e));
            } catch (Throwable th) {
                l.c("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return null;
    }

    private static File d(String str) {
        if (!f()) {
            return null;
        }
        for (a.C0025a next : d().e()) {
            if (next.a() != null && next.a().equals(str)) {
                File file = new File(c.f(), com.bytedance.sdk.component.utils.e.a(next.a()));
                String a2 = com.bytedance.sdk.component.utils.e.a(file);
                if (next.b() == null || !next.b().equals(a2)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static File e(String str) {
        List<Pair<String, String>> b;
        a.b d = d().d();
        if (d == null || (b = d.b()) == null || b.size() <= 0) {
            return null;
        }
        for (Pair next : b) {
            if (next.second != null && ((String) next.second).equals(str)) {
                return new File(c.f(), (String) next.first);
            }
        }
        return null;
    }

    public static boolean a(JSONObject jSONObject) {
        Object opt;
        if (jSONObject == null || (opt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) {
            return false;
        }
        return true;
    }
}
