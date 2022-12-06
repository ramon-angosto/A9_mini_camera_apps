package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.core.video.b.c;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.l.f;
import com.bytedance.sdk.openadsdk.l.u;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GlobalInfo */
public class h {
    public static PAGSdk.PAGInitCallback a;
    public static final Set<String> b = new HashSet<String>() {
        {
            add("8025677");
            add("5001121");
        }
    };
    private String c;
    private String d;
    private int e;
    private boolean f;
    private String g;
    private String h;
    private AtomicBoolean i;
    private int j;
    private boolean k;
    private final Set<Integer> l;
    private boolean m;
    private Bitmap n;
    private com.bytedance.sdk.openadsdk.l.a o;
    private String[] p;
    private int q;
    private int r;
    private Boolean s;
    private String t;
    private c u;
    private volatile ConcurrentHashMap<String, a.C0044a> v;

    /* compiled from: GlobalInfo */
    private static class a {
        /* access modifiers changed from: private */
        public static h a = new h();
    }

    public static void a(PAGSdk.PAGInitCallback pAGInitCallback) {
        a = pAGInitCallback;
    }

    public boolean a() {
        return this.o.a();
    }

    public boolean b() {
        ShortcutManager shortcutManager;
        if (this.s == null) {
            this.s = false;
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    Context a2 = m.a();
                    if (!(a2 == null || (shortcutManager = (ShortcutManager) a2.getSystemService(ShortcutManager.class)) == null)) {
                        this.s = Boolean.valueOf(shortcutManager.isRequestPinShortcutSupported());
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return this.s.booleanValue();
    }

    public com.bytedance.sdk.openadsdk.l.a c() {
        return this.o;
    }

    private h() {
        this.i = new AtomicBoolean(false);
        this.j = 0;
        this.k = true;
        this.l = Collections.synchronizedSet(new HashSet());
        this.m = false;
        this.n = null;
        this.o = new com.bytedance.sdk.openadsdk.l.a();
        this.q = 0;
        this.r = 0;
        this.v = null;
        try {
            com.bykv.vk.openvk.component.video.api.f.a.a(m.a());
            this.l.add(4);
            Context a2 = m.a();
            if (a2 instanceof Application) {
                ((Application) a2).registerActivityLifecycleCallbacks(this.o);
            } else if (a2 != null && a2.getApplicationContext() != null) {
                ((Application) a2.getApplicationContext()).registerActivityLifecycleCallbacks(this.o);
            }
        } catch (Throwable unused) {
        }
    }

    public static h d() {
        return a.a;
    }

    public boolean e() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "sdk_activate_init", true);
        }
        return u.a((String) null, m.a()).b("sdk_activate_init", true);
    }

    public void a(boolean z) {
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "sdk_activate_init", Boolean.valueOf(z));
        }
        u.a((String) null, m.a()).a("sdk_activate_init", z);
    }

    public String f() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_app_id", "app_id", (String) null);
        }
        return this.c;
    }

    public void a(String str) {
        g(str);
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_app_id", "app_id", str);
        }
        this.c = str;
        if (!TextUtils.isEmpty(str)) {
            a("app_id", str);
        }
    }

    public String g() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = PAGSdk.getApplicationName(m.a());
        }
        return this.d;
    }

    public void b(String str) {
        h(str);
        this.d = str;
    }

    public void a(int i2) {
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_icon_id", "icon_id", Integer.valueOf(i2));
        }
        this.e = i2;
    }

    public int h() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_icon_id", "icon_id", 0);
        }
        return this.e;
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            int i3 = i();
            if (b.c()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "sdk_coppa", Integer.valueOf(i2));
            } else {
                u.a((String) null, m.a()).a("sdk_coppa", i2);
            }
            if (i3 != i2) {
                j.b().a(3, true);
            }
            this.q = i2;
        }
    }

    public int i() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "sdk_coppa", -1);
        }
        this.q = u.a((String) null, m.a()).b("sdk_coppa", -1);
        return this.q;
    }

    public int j() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "tt_gdpr", -1);
        }
        return u.a((String) null, m.a()).b("tt_gdpr", -1);
    }

    public void c(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            int j2 = j();
            if (b.c()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "tt_gdpr", Integer.valueOf(i2));
            } else {
                u.a((String) null, m.a()).a("tt_gdpr", i2);
            }
            if (j2 != i2) {
                j.b().a(4, true);
            }
        }
    }

    public void d(int i2) {
        if (!(i2 == 0 || i2 == 1)) {
            i2 = -99;
        }
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "global_coppa", Integer.valueOf(i2));
        } else {
            u.a((String) null, m.a()).a("global_coppa", i2);
        }
        this.r = i2;
    }

    public int k() {
        if (b.c()) {
            this.r = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "global_coppa", -99);
        } else {
            this.r = u.a((String) null, m.a()).b("global_coppa", -99);
        }
        if (this.r == -99) {
            this.r = i();
        }
        return this.r;
    }

    public boolean l() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "is_paid", false);
        }
        return this.f;
    }

    public void b(boolean z) {
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "is_paid", Boolean.valueOf(z));
        }
        this.f = z;
    }

    public String m() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_file", "keywords", (String) null);
        }
        return this.g;
    }

    public void c(String str) {
        i(str);
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "keywords", str);
        }
        this.g = str;
    }

    public String n() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_file", "extra_data", (String) null);
        }
        return this.h;
    }

    public void d(String str) {
        j(str);
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "extra_data", str);
        }
        this.h = str;
    }

    public void e(int i2) {
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "title_bar_theme", Integer.valueOf(i2));
        }
        this.j = i2;
    }

    public int o() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "title_bar_theme", 0);
        }
        return this.j;
    }

    public void c(boolean z) {
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "allow_show_notify", Boolean.valueOf(z));
        }
        this.k = z;
    }

    private static void g(String str) {
        PAGSdk.PAGInitCallback pAGInitCallback;
        if (TextUtils.isEmpty(str) && (pAGInitCallback = a) != null) {
            pAGInitCallback.fail(PAGSdk.INIT_LOCAL_FAIL_CODE, "appid cannot be empty");
        }
        l.e("GlobalInfo", "appid cannot be empty");
    }

    private static void h(String str) {
        PAGSdk.PAGInitCallback pAGInitCallback;
        if (TextUtils.isEmpty(str) && (pAGInitCallback = a) != null) {
            pAGInitCallback.fail(PAGSdk.INIT_LOCAL_FAIL_CODE, "name cannot be empty");
        }
        l.e("GlobalInfo", "name cannot be empty");
    }

    private static void i(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 1000) {
            PAGSdk.PAGInitCallback pAGInitCallback = a;
            if (pAGInitCallback != null) {
                pAGInitCallback.fail(PAGSdk.INIT_LOCAL_FAIL_CODE, "keyword is super long, the longest is 1000");
            }
            l.e("GlobalInfo", "keyword is super long, the longest is 1000");
        }
    }

    private static void j(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 1000) {
            PAGSdk.PAGInitCallback pAGInitCallback = a;
            if (pAGInitCallback != null) {
                pAGInitCallback.fail(PAGSdk.INIT_LOCAL_FAIL_CODE, "Data is very long, the longest is 1000");
            }
            l.e("GlobalInfo", "Data is very long, the longest is 1000");
        }
    }

    public c p() {
        if (this.u == null) {
            this.u = new c(10, 8);
        }
        return this.u;
    }

    public boolean q() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "is_use_texture", false);
        }
        return this.m;
    }

    public void d(boolean z) {
        if (b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "is_use_texture", Boolean.valueOf(z));
        }
        this.m = z;
    }

    public Bitmap r() {
        if (b.c()) {
            return d.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_file", "pause_icon", (String) null));
        }
        return this.n;
    }

    public void a(String[] strArr) {
        if (b.c() && strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    int i3 = i2 + 1;
                    if (i2 > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                    i2 = i3;
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", "need_clear_task_reset", sb2);
            }
        }
        this.p = strArr;
    }

    public boolean s() {
        return b.contains(this.c);
    }

    public boolean t() {
        return "com.union_test.internationad".equals(y.e());
    }

    public String u() {
        if (!TextUtils.isEmpty(this.t)) {
            return this.t;
        }
        this.t = f.a();
        if (!TextUtils.isEmpty(this.t)) {
            return this.t;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        f.a(valueOf);
        this.t = valueOf;
        return this.t;
    }

    private static JSONObject k(String str) {
        String str2;
        if (b.c()) {
            str2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_file", str, (String) null);
        } else {
            str2 = u.a((String) null, m.a()).b(str, (String) null);
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str2);
                jSONObject.put("time", System.currentTimeMillis());
                if (b.c()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_file", str, jSONObject.toString());
                } else {
                    u.a((String) null, m.a()).a(str, jSONObject.toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject k2 = k(str);
            if (k2 == null) {
                return null;
            }
            if (System.currentTimeMillis() - k2.getLong("time") <= j2) {
                return k2.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public int v() {
        if (b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "global_ccpa", -1);
        }
        return u.a((String) null, m.a()).b("global_ccpa", -1);
    }

    public void f(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            int v2 = v();
            if (b.c()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_privacy", "global_ccpa", Integer.valueOf(i2));
            } else {
                u.a((String) null, m.a()).a("global_ccpa", i2);
            }
            if (v2 != i2) {
                j.b().a(5, true);
            }
        }
    }

    public a.C0044a e(String str) {
        if (this.v == null || str == null) {
            return null;
        }
        return this.v.get(str);
    }

    public void a(String str, a.C0044a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            if (b.c()) {
                TTDislikeListView.a(6, str, aVar);
                return;
            }
            if (this.v == null) {
                synchronized (h.class) {
                    if (this.v == null) {
                        this.v = new ConcurrentHashMap<>();
                    }
                }
            }
            this.v.put(str, aVar);
        }
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (b.c()) {
            TTDislikeListView.a(6, str);
        } else if (this.v != null) {
            this.v.remove(str);
        }
    }

    public void w() {
        if (this.v != null && this.v.size() == 0) {
            this.v = null;
        }
    }
}
