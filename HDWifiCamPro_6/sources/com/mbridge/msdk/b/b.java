package com.mbridge.msdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.tools.w;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SettingManager */
public class b {
    public static final String a = b.class.getSimpleName();
    private static b b = null;
    private static HashMap<String, d> c = new HashMap<>();
    private static a d = null;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public final boolean a(String str) {
        a b2 = b(str);
        if (b2 == null) {
            return true;
        }
        return b2.E() + (b2.D() * 1000) <= System.currentTimeMillis();
    }

    public final boolean a(String str, int i, String str2) {
        try {
            Context g = a.e().g();
            String str3 = str + "_" + i + "_" + str2;
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            long longValue = ((Long) w.b(g, str3, 0L)).longValue();
            a b2 = b(str);
            if (b2 == null) {
                b2 = a().b();
            } else {
                j = longValue;
            }
            if (j + (b2.x() * 1000) > currentTimeMillis) {
                return false;
            }
            w.a(g, str3, Long.valueOf(currentTimeMillis));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, String str2) {
        a b2 = b(str2);
        if (a(str2) && a(str2, 1, str)) {
            new c().a(a.e().g(), str2, a.e().i());
        }
        d e = e(str2, str);
        if (!(b2 == null || e == null)) {
            if (e.t() + (b2.z() * 1000) > System.currentTimeMillis()) {
                return false;
            }
        }
        return true;
    }

    public final void b(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a(str, str2);
        d = a.b(str2);
        a aVar = d;
        if (aVar != null) {
            aVar.N();
        }
    }

    public final a b(String str) {
        if (d == null) {
            try {
                d = a.b(com.mbridge.msdk.foundation.a.a.a.a().b(str));
                if (d != null) {
                    d.N();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    public final String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            String b2 = com.mbridge.msdk.foundation.a.a.a.a().b(str);
            return b2 == null ? "" : b2;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static void a(Context context, String str) {
        try {
            Map<String, ?> all = context.getSharedPreferences("mbridge", 0).getAll();
            for (String next : all.keySet()) {
                if (next.startsWith(str + "_")) {
                    c.put(next, d.b((String) all.get(next)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final d c(String str, String str2) {
        d e = e(str, str2);
        return e == null ? d.k() : e;
    }

    public final d e(String str, String str2) {
        d g = g(str, str2);
        if (g != null && g.i() == 0) {
            g.c(1);
        }
        return g;
    }

    private d g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = a.e().h();
        }
        String str3 = str + "_" + str2;
        d dVar = null;
        if (c.containsKey(str3)) {
            return c.get(str3);
        }
        try {
            dVar = d.b(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
            c.put(str3, dVar);
            return dVar;
        } catch (Exception e) {
            e.printStackTrace();
            return dVar;
        }
    }

    public final d f(String str, String str2) {
        return g(str, str2);
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        c.put(str4, d.b(str3));
    }

    public final String d(String str) {
        com.mbridge.msdk.foundation.a.a.a a2 = com.mbridge.msdk.foundation.a.a.a.a();
        return a2.b("ivreward_" + str);
    }

    public final void e(String str) {
        com.mbridge.msdk.foundation.a.a.a a2 = com.mbridge.msdk.foundation.a.a.a.a();
        a2.c("ivreward_" + str);
    }

    public final a b() {
        a aVar = new a();
        aVar.r(1);
        aVar.c(true);
        aVar.c(3600);
        aVar.d(0);
        aVar.b(false);
        aVar.a(false);
        aVar.a(7200);
        aVar.a("mbridge");
        aVar.p(1);
        aVar.b(1800);
        aVar.q(259200);
        aVar.e(10);
        aVar.k(1);
        aVar.j(1);
        aVar.l(1);
        aVar.m(0);
        aVar.n(1);
        aVar.o(-1);
        aVar.c(0);
        aVar.c("https://cdn-adn-https.rayjump.com/cdn-adn/v2/portal/19/08/20/11/06/5d5b63cb457e2.js");
        aVar.b(120);
        aVar.d(false);
        aVar.s(0);
        aVar.t(120);
        aVar.u(1);
        aVar.g(com.mbridge.msdk.foundation.same.a.w);
        aVar.f(com.mbridge.msdk.foundation.same.a.y);
        aVar.e(com.mbridge.msdk.foundation.same.a.x);
        aVar.a(10);
        aVar.h(com.mbridge.msdk.foundation.same.a.z);
        aVar.d(10);
        return aVar;
    }

    public final a f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return b();
            }
            a b2 = b(str);
            if (b2 == null) {
                return b();
            }
            return b2;
        } catch (Exception unused) {
            return b();
        }
    }

    public final d d(String str, String str2) {
        d g = g(str, str2);
        return g == null ? d.k() : g;
    }
}
