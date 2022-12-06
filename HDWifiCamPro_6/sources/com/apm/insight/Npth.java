package com.apm.insight;

import android.app.Application;
import android.content.Context;
import com.apm.insight.a.b;
import com.apm.insight.a.c;
import com.apm.insight.k.h;
import com.apm.insight.l.a;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.j;
import com.apm.insight.runtime.o;
import java.util.Map;

public final class Npth {
    private static boolean sInit;

    public static void addAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            h.b().b(attachUserData, crashType);
        }
    }

    public static void addAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            h.b().a(attachUserData, crashType);
        }
    }

    public static void addTags(Map<? extends String, ? extends String> map) {
        if (map != null && !map.isEmpty()) {
            h.b().a(map);
        }
    }

    public static void dumpHprof(String str) {
        o.c(str);
    }

    public static void enableALogCollector(String str, b bVar, c cVar) {
        o.a(str, bVar, cVar);
    }

    public static void enableThreadsBoost() {
        h.a(1);
    }

    public static ConfigManager getConfigManager() {
        return h.i();
    }

    public static boolean hasCrash() {
        return o.k();
    }

    public static boolean hasCrashWhenJavaCrash() {
        return o.l();
    }

    public static boolean hasCrashWhenNativeCrash() {
        return o.m();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.app.Application r10, android.content.Context r11, com.apm.insight.ICommonParams r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17) {
        /*
            java.lang.Class<com.apm.insight.Npth> r1 = com.apm.insight.Npth.class
            monitor-enter(r1)
            boolean r0 = sInit     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            r0 = 1
            sInit = r0     // Catch:{ all -> 0x006e }
            r4 = 1
            r5 = 1
            r6 = 1
            r7 = 1
            r2 = r10
            r3 = r11
            r8 = r17
            com.apm.insight.runtime.o.a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x006e }
            com.apm.insight.h.a(r10, r11, r12)     // Catch:{ all -> 0x006e }
            com.apm.insight.runtime.d r0 = com.apm.insight.h.a()     // Catch:{ all -> 0x006e }
            java.util.Map r0 = r0.a()     // Catch:{ all -> 0x006e }
            java.lang.String r2 = "update_version_code"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x006e }
            r3 = 0
            int r2 = com.apm.insight.l.r.a(r2, r3)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = "aid"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x006e }
            r4 = 4444(0x115c, float:6.227E-42)
            int r3 = com.apm.insight.l.r.a(r3, r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = "app_version"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x006e }
            long r5 = (long) r2     // Catch:{ all -> 0x006e }
            r2 = r11
            com.apm.insight.MonitorCrash r2 = com.apm.insight.MonitorCrash.init(r11, r3, r5, r4)     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x006c
            com.apm.insight.MonitorCrash$Config r2 = r2.config()     // Catch:{ all -> 0x006e }
            com.apm.insight.runtime.d r3 = com.apm.insight.h.a()     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r3.d()     // Catch:{ all -> 0x006e }
            com.apm.insight.MonitorCrash$Config r2 = r2.setDeviceId(r3)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = "channel"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x006e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x006e }
            r2.setChannel(r0)     // Catch:{ all -> 0x006e }
        L_0x006c:
            monitor-exit(r1)
            return
        L_0x006e:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.Npth.init(android.app.Application, android.content.Context, com.apm.insight.ICommonParams, boolean, boolean, boolean, boolean, long):void");
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams) {
        synchronized (Npth.class) {
            init(context, iCommonParams, true, false, false);
        }
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3) {
        synchronized (Npth.class) {
            init(context, iCommonParams, z, z, z2, z3);
        }
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4) {
        synchronized (Npth.class) {
            init(context, iCommonParams, z, z2, z3, z4, 0);
        }
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        String str;
        Application application;
        Context context2 = context;
        synchronized (Npth.class) {
            if (h.h() != null) {
                application = h.h();
            } else if (context2 instanceof Application) {
                application = (Application) context2;
                if (application.getBaseContext() == null) {
                    throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                }
            } else {
                try {
                    application = (Application) context.getApplicationContext();
                    if (application == null) {
                        throw new IllegalArgumentException(str);
                    } else if (application.getBaseContext() != null) {
                        context2 = application.getBaseContext();
                    }
                } finally {
                    str = "Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.";
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
                }
            }
            init(application, context2, iCommonParams, z, z2, z3, z4, j);
        }
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams) {
        synchronized (Npth.class) {
            h.a(true);
            init(context, iCommonParams, true, false, true, true);
        }
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams, int i, String str) {
        synchronized (Npth.class) {
            h.a(true);
            h.b(i, str);
            init(context, iCommonParams, true, true, true, true);
        }
    }

    public static boolean isANREnable() {
        return o.c();
    }

    public static boolean isInit() {
        return sInit;
    }

    public static boolean isJavaCrashEnable() {
        return o.b();
    }

    public static boolean isNativeCrashEnable() {
        return o.d();
    }

    public static boolean isRunning() {
        return o.i();
    }

    public static boolean isStopUpload() {
        return o.n();
    }

    public static void openANRMonitor() {
        o.g();
    }

    public static void openJavaCrashMonitor() {
        o.f();
    }

    public static boolean openNativeCrashMonitor() {
        return o.h();
    }

    public static void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        o.a(iCrashCallback, crashType);
    }

    public static void registerOOMCallback(IOOMCallback iOOMCallback) {
        o.a(iOOMCallback);
    }

    public static void registerSdk(int i, String str) {
        h.a(i, str);
    }

    public static void removeAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            h.b().b(crashType, attachUserData);
        }
    }

    public static void removeAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            h.b().a(crashType, attachUserData);
        }
    }

    public static void reportDartError(String str) {
        o.a(str);
    }

    public static void reportDartError(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, f fVar) {
        o.a(str, map, map2, fVar);
    }

    public static void reportDartError(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, f fVar) {
        o.a(str, map, map2, map3, fVar);
    }

    @Deprecated
    public static void reportError(String str) {
        o.b(str);
    }

    @Deprecated
    public static void reportError(Throwable th) {
        o.a(th);
    }

    public static void setAlogFlushAddr(long j) {
        o.a(j);
    }

    public static void setAlogFlushV2Addr(long j) {
        o.b(j);
    }

    public static void setAlogLogDirAddr(long j) {
        o.c(j);
    }

    public static void setAlogWriteAddr(long j) {
    }

    public static void setAnrInfoFileObserver(String str, e eVar) {
        o.a(str, eVar);
    }

    public static void setApplication(Application application) {
        h.a(application);
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            h.b().a(attachUserData, crashType);
        }
    }

    public static void setBusiness(String str) {
        if (str != null) {
            h.a(str);
        }
    }

    public static void setCrashFilter(ICrashFilter iCrashFilter) {
        h.b().a(iCrashFilter);
    }

    public static void setCurProcessName(String str) {
        a.a(str);
    }

    public static void setEncryptImpl(d dVar) {
        o.a(dVar);
    }

    public static void setLogcatImpl(j jVar) {
        o.a(jVar);
    }

    public static void setRequestIntercept(h hVar) {
        o.a(hVar);
    }

    public static void stopAnr() {
        o.j();
    }

    public static void stopUpload() {
        o.o();
    }

    public static void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        o.b(iCrashCallback, crashType);
    }

    public static void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        o.a(iOOMCallback, crashType);
    }
}
