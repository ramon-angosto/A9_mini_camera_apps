package com.apm.insight.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.b.g;
import com.apm.insight.f;
import com.apm.insight.g.a;
import com.apm.insight.g.c;
import com.apm.insight.g.d;
import com.apm.insight.h;
import com.apm.insight.i.b;
import com.apm.insight.k.e;
import com.apm.insight.l.q;
import com.apm.insight.nativecrash.NativeImpl;
import java.io.File;
import java.util.Map;

public class o {
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static c f = new c();
    /* access modifiers changed from: private */
    public static volatile boolean g = false;
    private static boolean h = false;

    public static c a() {
        return f;
    }

    public static void a(long j) {
        NativeImpl.a(j);
    }

    public static synchronized void a(Application application, Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        synchronized (o.class) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (!a) {
                a = true;
                if (context == null || application == null) {
                    throw new IllegalArgumentException("context or Application must be not null.");
                }
                h.a(application, context);
                if (z || z2) {
                    a a2 = a.a();
                    if (z2) {
                        a2.a((c) new b(context));
                    }
                    if (z) {
                        a2.b((c) new d(context));
                    }
                    b = true;
                }
                NativeImpl.a();
                if (z3) {
                    d = NativeImpl.a(context);
                    if (!d) {
                        e = true;
                    }
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    g = true;
                    NativeImpl.h();
                }
                c(z4);
                q.a((Object) "Npth.init takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms.");
            }
        }
    }

    public static synchronized void a(Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        String str;
        Application application;
        synchronized (o.class) {
            if (h.h() != null) {
                application = h.h();
            } else if (context instanceof Application) {
                application = (Application) context;
                if (application.getBaseContext() == null) {
                    throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                }
            } else {
                try {
                    application = (Application) context.getApplicationContext();
                    if (application == null) {
                        throw new IllegalArgumentException(str);
                    } else if (application.getBaseContext() != null) {
                        context = application.getBaseContext();
                    }
                } finally {
                    str = "Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.";
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
                }
            }
            a(application, context, z, z2, z3, z4, j);
        }
    }

    public static void a(ICrashCallback iCrashCallback, CrashType crashType) {
        a().a(iCrashCallback, crashType);
    }

    public static void a(IOOMCallback iOOMCallback) {
        a().a(iOOMCallback);
    }

    public static void a(IOOMCallback iOOMCallback, CrashType crashType) {
        a().b(iOOMCallback);
    }

    public static void a(com.apm.insight.d dVar) {
        h.i().setEncryptImpl(dVar);
    }

    public static void a(com.apm.insight.k.h hVar) {
        e.a(hVar);
    }

    public static void a(j jVar) {
        k.a(jVar);
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.apm.insight.d.a.a(str);
        }
    }

    public static void a(String str, com.apm.insight.a.b bVar, com.apm.insight.a.c cVar) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            com.apm.insight.a.a.a().a(str, bVar, cVar);
        }
    }

    public static void a(final String str, final com.apm.insight.e eVar) {
        p.b().a((Runnable) new Runnable() {
            public void run() {
                if (com.apm.insight.l.a.b(h.g())) {
                    com.apm.insight.b.d.a(str, eVar);
                }
            }
        });
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, f fVar) {
        if (!TextUtils.isEmpty(str)) {
            com.apm.insight.d.a.a(str, map, map2, fVar);
        }
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, f fVar) {
        if (!TextUtils.isEmpty(str)) {
            com.apm.insight.d.a.a(str, map, map2, map3, fVar);
        }
    }

    @Deprecated
    public static void a(Throwable th) {
        if (h.i().isReportErrorEnable()) {
            a.a(th);
        }
    }

    public static void b(long j) {
        NativeImpl.b(j);
    }

    public static void b(ICrashCallback iCrashCallback, CrashType crashType) {
        a().b(iCrashCallback, crashType);
    }

    @Deprecated
    public static void b(String str) {
        if (h.i().isReportErrorEnable()) {
            a.c(str);
        }
    }

    public static boolean b() {
        return b;
    }

    public static void c(long j) {
        NativeImpl.c(j);
    }

    public static void c(String str) {
        NativeImpl.b(str);
    }

    private static void c(final boolean z) {
        p.b().a((Runnable) new Runnable() {
            public void run() {
                if (!o.g) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            boolean unused = o.g = true;
                            NativeImpl.h();
                        }
                    });
                }
                o.d(z);
            }
        }, 0);
    }

    public static boolean c() {
        return c;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(boolean r3) {
        /*
            android.content.Context r0 = com.apm.insight.h.g()
            com.apm.insight.runtime.a.f.a()
            com.apm.insight.runtime.m.a()
            java.lang.String r1 = "Npth.initAsync-createCallbackThread"
            com.apm.insight.j.a(r1)
            int r1 = com.apm.insight.nativecrash.NativeImpl.b()
            com.apm.insight.j.a()
            com.apm.insight.nativecrash.NativeImpl.c()
            boolean r2 = e
            if (r2 == 0) goto L_0x0027
            com.apm.insight.c r1 = com.apm.insight.b.a()
            java.lang.String r2 = "NativeLibraryLoad faild"
        L_0x0023:
            r1.a((java.lang.String) r2)
            goto L_0x0030
        L_0x0027:
            if (r1 >= 0) goto L_0x0030
            com.apm.insight.c r1 = com.apm.insight.b.a()
            java.lang.String r2 = "createCallbackThread faild"
            goto L_0x0023
        L_0x0030:
            java.lang.String r1 = "Npth.initAsync-NpthDataManager"
            com.apm.insight.j.a(r1)
            com.apm.insight.e.a r1 = com.apm.insight.e.a.a()
            r1.a((android.content.Context) r0)
            com.apm.insight.j.a()
            com.apm.insight.b.a()
            java.lang.String r1 = "Npth.initAsync-LaunchScanner"
            com.apm.insight.j.a(r1)
            com.apm.insight.k.i.a(r0)
            com.apm.insight.j.a()
            if (r3 == 0) goto L_0x0060
            java.lang.String r1 = "Npth.initAsync-CrashANRHandler"
            com.apm.insight.j.a(r1)
            com.apm.insight.b.g r0 = com.apm.insight.b.g.a(r0)
            r0.c()
            com.apm.insight.j.a()
            c = r3
        L_0x0060:
            java.lang.String r3 = "Npth.initAsync-EventUploadQueue"
            com.apm.insight.j.a(r3)
            com.apm.insight.k.g r3 = com.apm.insight.k.g.a()
            r3.b()
            com.apm.insight.j.a()
            java.lang.String r3 = "Npth.initAsync-BlockMonitor"
            com.apm.insight.j.a(r3)
            com.apm.insight.j.a()
            java.lang.String r3 = "Npth.initAsync-OriginExceptionMonitor"
            com.apm.insight.j.a(r3)
            com.apm.insight.j.a()
            com.apm.insight.nativecrash.NativeImpl.f()
            com.apm.insight.i.a()
            com.apm.insight.k.k.d()
            com.apm.insight.nativecrash.NativeImpl.j()
            java.lang.String r3 = "afterNpthInitAsync"
            java.lang.String r0 = "noValue"
            com.apm.insight.runtime.r.a((java.lang.String) r3, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.o.d(boolean):void");
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        return a;
    }

    public static void f() {
        if (a && !b) {
            Context g2 = h.g();
            a a2 = a.a();
            a2.a((c) new b(g2));
            a2.b((c) new d(g2));
        }
    }

    public static void g() {
        if (a) {
            g.a(h.g()).c();
            c = true;
        }
    }

    public static boolean h() {
        if (a && !d) {
            d = NativeImpl.a(h.g());
            if (!d) {
                e = true;
            }
        }
        return d;
    }

    public static boolean i() {
        return com.apm.insight.b.c.c();
    }

    public static void j() {
        if (a) {
            g.a(h.g()).d();
            c = false;
        }
    }

    public static boolean k() {
        return a.b() || NativeImpl.d();
    }

    public static boolean l() {
        return a.c() || NativeImpl.d();
    }

    public static boolean m() {
        return a.b();
    }

    public static boolean n() {
        return h;
    }

    public static void o() {
        h = true;
    }
}
