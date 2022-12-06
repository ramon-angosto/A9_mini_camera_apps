package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.i.c;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.l.t;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.z;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: InitHelper */
public class k {
    public static volatile boolean a = false;
    public static AtomicBoolean b = new AtomicBoolean(false);
    public static long c = 0;
    public static final List<PAGSdk.PAGInitCallback> d = new ArrayList();
    public static float e = 1.0f;
    public static volatile boolean f = false;
    private static AtomicBoolean g = new AtomicBoolean(false);
    private static long h = WorkRequest.MIN_BACKOFF_MILLIS;
    private static volatile int i = 0;
    private static volatile HandlerThread j;
    private static volatile Handler k = null;

    /* compiled from: InitHelper */
    private static class a {
        /* access modifiers changed from: private */
        public static final Handler a = new Handler(Looper.getMainLooper());
    }

    static {
        j = null;
        j = new HandlerThread("csj_init", 10);
        j.start();
    }

    public static void a() {
        Context a2;
        if (m.d().i() && (a2 = m.a()) != null) {
            try {
                d.a().b().a(a2, b.c(), true, new c(a2));
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context) {
        t.a();
        z.a(context);
        c(context);
        m.e().a();
        com.bytedance.sdk.openadsdk.core.e.c.a(j.a(context));
        com.bytedance.sdk.openadsdk.c.a.c.a((String) null);
        com.bytedance.sdk.component.adexpress.a.b.a.a();
        com.bytedance.sdk.openadsdk.core.video.b.a.a().b();
        b(context);
    }

    public static void b(Context context) {
        try {
            e = Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
            if (e <= 0.0f) {
                e = 1.0f;
            }
        } catch (Throwable unused) {
            e = 1.0f;
        }
    }

    public static void b() {
        com.bytedance.sdk.component.adexpress.a.a.a.a().a((com.bytedance.sdk.component.adexpress.a.a.b) new com.bytedance.sdk.component.adexpress.a.a.b() {
            public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.a.a.a(m.a(), str, contentValues, str2, strArr);
            }

            public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return new com.bytedance.sdk.openadsdk.multipro.aidl.c(com.bytedance.sdk.openadsdk.multipro.a.a.a(m.a(), str, strArr, str2, strArr2, str3, str4, str5));
            }

            public int a(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.a.a.a(m.a(), str, str2, strArr);
            }

            public void a(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(m.a(), str, contentValues);
            }
        });
        com.bytedance.sdk.component.adexpress.a.a.a.a().a((com.bytedance.sdk.component.adexpress.a.a.c) new com.bytedance.sdk.component.adexpress.a.a.c() {
            public void d() {
            }

            public int i() {
                return 1;
            }

            public int k() {
                return 0;
            }

            public int a() {
                if (m.d() == null) {
                    return 0;
                }
                return m.d().d();
            }

            public Context b() {
                return m.a();
            }

            public Handler c() {
                return k.d();
            }

            public com.bytedance.sdk.component.adexpress.a.c.a e() {
                return m.c().a();
            }

            public com.bytedance.sdk.component.f.b.a f() {
                return d.a().b().d();
            }

            public com.bytedance.sdk.component.f.b.b g() {
                return d.a().b().c();
            }

            public String h() {
                return h.d().f();
            }

            public int j() {
                return m.d().Q();
            }
        });
        com.bytedance.sdk.component.adexpress.a.a.a.a().a((com.bytedance.sdk.component.adexpress.a.a.d) new com.bytedance.sdk.component.adexpress.a.a.d() {
            public void a(int i) {
                com.bytedance.sdk.openadsdk.h.b.a().b(com.bytedance.sdk.openadsdk.h.a.b.b().b(i).f(g.a(i)));
            }

            public void a(String str) {
                com.bytedance.sdk.openadsdk.h.b.c(str);
            }
        });
        com.bytedance.sdk.component.widget.a.a.a().a(new com.bytedance.sdk.component.widget.a.b() {
            public boolean a() {
                return true;
            }

            public void a(com.bytedance.sdk.component.widget.b.a aVar, String str, String str2, JSONObject jSONObject, long j) {
                n nVar = new n();
                nVar.q(aVar.a());
                nVar.m(aVar.b());
                nVar.k(aVar.c());
                com.bytedance.sdk.openadsdk.c.c.a(m.a(), nVar, str, str2, jSONObject, j);
            }
        });
    }

    private static void c(Context context) {
        c.a(context).a("uuid", o.a());
    }

    public static Handler c() {
        Class<k> cls = k.class;
        if (j == null || !j.isAlive()) {
            synchronized (cls) {
                if (j == null || !j.isAlive()) {
                    j = new HandlerThread("csj_init", -1);
                    j.start();
                    k = new Handler(j.getLooper());
                }
            }
        } else if (k == null) {
            synchronized (cls) {
                if (k == null) {
                    k = new Handler(j.getLooper());
                }
            }
        }
        return k;
    }

    public static Handler d() {
        return a.a;
    }

    public static int e() {
        return i;
    }

    public static void a(int i2) {
        i = i2;
    }

    public static void f() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - c > h) {
                c = elapsedRealtime;
                w.a((g) new g("onSharedPreferenceChanged") {
                    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
                        if (r0.equals(com.bytedance.sdk.openadsdk.core.settings.j.a) == false) goto L_0x0021;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r4 = this;
                            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x002e }
                            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.settings.j.b((android.content.Context) r0)     // Catch:{ all -> 0x002e }
                            r1 = 0
                            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x002e }
                            r3 = 1
                            if (r2 == 0) goto L_0x0019
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.settings.j.a     // Catch:{ all -> 0x002e }
                            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x002e }
                            if (r2 != 0) goto L_0x0019
                            goto L_0x0021
                        L_0x0019:
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.settings.j.a     // Catch:{ all -> 0x002e }
                            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x002e }
                            if (r2 != 0) goto L_0x0022
                        L_0x0021:
                            r1 = r3
                        L_0x0022:
                            if (r1 == 0) goto L_0x002e
                            com.bytedance.sdk.openadsdk.core.settings.j r1 = com.bytedance.sdk.openadsdk.core.settings.j.b()     // Catch:{ all -> 0x002e }
                            r2 = 6
                            r1.a((int) r2, (boolean) r3)     // Catch:{ all -> 0x002e }
                            com.bytedance.sdk.openadsdk.core.settings.j.a = r0     // Catch:{ all -> 0x002e }
                        L_0x002e:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.k.AnonymousClass5.run():void");
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
