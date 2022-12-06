package com.bytedance.sdk.openadsdk.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.h.a.a;
import java.io.File;
import org.json.JSONObject;

/* compiled from: StatsLogManager */
public class b {
    private static volatile b a;

    /* access modifiers changed from: private */
    public boolean g(com.bytedance.sdk.openadsdk.h.a.b bVar) {
        return bVar == null;
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void a(final com.bytedance.sdk.openadsdk.h.a.b bVar) {
        if (!g(bVar)) {
            m.e().a(new a() {
                public a a() throws Exception {
                    return bVar;
                }
            });
        }
    }

    public void b(final com.bytedance.sdk.openadsdk.h.a.b bVar) {
        if (!g(bVar)) {
            bVar.a("express_ad_render");
            m.e().a(new a() {
                public a a() throws Exception {
                    return bVar;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str, int i) {
        c a2 = c.a(m.a());
        boolean z = false;
        int b = a2.b(str, 0);
        if ((b & 2) == 0 || (b & 1) != i) {
            z = true;
        }
        if (z) {
            a2.a(str, i + 2);
        }
        return z;
    }

    public void c(final com.bytedance.sdk.openadsdk.h.a.b bVar) {
        if (!g(bVar)) {
            m.e().a(new a() {
                public a a() throws Exception {
                    if (b.this.g(bVar) || !b.this.a(bVar.e(), 1)) {
                        return null;
                    }
                    bVar.a("reg_creative");
                    return bVar;
                }
            });
        }
    }

    public void d(final com.bytedance.sdk.openadsdk.h.a.b bVar) {
        if (!g(bVar)) {
            m.e().a(new a() {
                public a a() throws Exception {
                    if (b.this.g(bVar) || !b.this.a(bVar.e(), 0)) {
                        return null;
                    }
                    bVar.a("no_reg_creative");
                    return bVar;
                }
            });
        }
    }

    public void e(final com.bytedance.sdk.openadsdk.h.a.b bVar) {
        if (!g(bVar)) {
            bVar.a("load_icon_error");
            m.e().a(new a() {
                public a a() throws Exception {
                    return bVar;
                }
            });
        }
    }

    public void f(final com.bytedance.sdk.openadsdk.h.a.b bVar) {
        if (!g(bVar)) {
            bVar.a("show_backup_endcard");
            m.e().a(new a() {
                public a a() throws Exception {
                    return bVar;
                }
            });
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            b(aVar);
        }
    }

    public void a(final String str) {
        m.e().a(new a() {
            public a a() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("click_playable_test_tool").b(jSONObject.toString());
            }
        }, false);
    }

    public void b(final String str) {
        m.e().a(new a() {
            public a a() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("close_playable_test_tool").b(jSONObject.toString());
            }
        }, false);
    }

    public void a(final String str, final int i, final String str2) {
        m.e().a(new a() {
            public a a() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                    jSONObject.put("error_code", i);
                    jSONObject.put("error_message", str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("use_playable_test_tool_error").b(jSONObject.toString());
            }
        }, false);
    }

    public void a(long j, long j2) {
        final long j3 = j2 - j;
        final long j4 = j;
        final long j5 = j2;
        m.e().a(new a() {
            public a a() throws Exception {
                boolean z = !k.b.get();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j4);
                    jSONObject.put("endtime", j5);
                    jSONObject.put("start_type", z ? 1 : 0);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("general_label").h(j3 + "").b(jSONObject.toString());
            }
        }, false);
    }

    public void a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            final com.bytedance.sdk.openadsdk.h.a.b b = com.bytedance.sdk.openadsdk.h.a.b.b().a(str).b(jSONObject.toString());
            m.e().a(new a() {
                public a a() throws Exception {
                    return b;
                }
            }, false);
        }
    }

    public static void b() {
        m.e().a(new a() {
            public a a() throws Exception {
                JSONObject jSONObject = new JSONObject();
                File file = new File(CacheDirFactory.getRootDir());
                long j = 0;
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        long a = b.a(file2);
                        j += a;
                        jSONObject.put(file2.getName(), a);
                    }
                }
                if (j < 524288000) {
                    return null;
                }
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("disk_log").b(jSONObject.toString());
            }
        }, false);
    }

    public void c() {
        try {
            m.e().a(new a() {
                public a a() throws Exception {
                    return com.bytedance.sdk.openadsdk.h.a.b.b().a("bidding_get_creative");
                }
            }, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static long a(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long j = 0;
        for (File a2 : file.listFiles()) {
            j += a(a2);
        }
        return j;
    }

    public void b(a aVar) {
        m.e().a(aVar, false);
    }

    public static void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                final com.bytedance.sdk.openadsdk.h.a.b b = com.bytedance.sdk.openadsdk.h.a.b.b().a(str).b(str2);
                m.e().a(new a() {
                    public a a() throws Exception {
                        return b;
                    }
                }, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", str);
                final com.bytedance.sdk.openadsdk.h.a.b b = com.bytedance.sdk.openadsdk.h.a.b.b().a("pangle_clear_ndr_cache").b(jSONObject.toString());
                m.e().a(new a() {
                    public a a() {
                        return b;
                    }
                }, false);
            }
        } catch (Throwable unused) {
        }
    }
}
