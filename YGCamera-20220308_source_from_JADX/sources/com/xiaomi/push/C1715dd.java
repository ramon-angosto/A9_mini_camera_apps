package com.xiaomi.push;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.lang.Thread;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.dd */
public class C1715dd {

    /* renamed from: a */
    private static volatile C1715dd f2010a;

    /* renamed from: a */
    private static ThreadPoolExecutor f2011a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    private Context f2012a;

    /* renamed from: a */
    private C1719dh f2013a;

    /* renamed from: a */
    private final Object f2014a = new Object();

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f2015a;

    private C1715dd(Context context) {
        this.f2012a = context.getApplicationContext();
        this.f2015a = Thread.getDefaultUncaughtExceptionHandler();
        this.f2013a = new C1719dh(context);
        Thread.setDefaultUncaughtExceptionHandler(new C1716de(this));
    }

    /* renamed from: a */
    private static C1715dd m2973a(Context context) {
        if (f2010a == null) {
            synchronized (C1715dd.class) {
                if (f2010a == null) {
                    f2010a = new C1715dd(context);
                }
            }
        }
        return f2010a;
    }

    /* renamed from: a */
    private String m2975a() {
        if (C1614ag.f1764a && C2087u.m5375a(this.f2012a)) {
            String a = C2086t.m5370a("log.tag.debug.sdk.cr", "");
            if (!TextUtils.isEmpty(a)) {
                C1524b.m2141a("[debug] scr rep url：" + a);
                return a;
            }
        }
        if (C1720di.m2993a()) {
            return "https://api.xmpush.xiaomi.com/v1/trace/report/sdk";
        }
        return null;
    }

    /* renamed from: a */
    private void m2977a() {
        C1524b.m2141a("scr init in " + Process.myPid());
        f2011a.execute(new C1718dg(this));
    }

    /* renamed from: a */
    public static void m2978a(Context context) {
        if (context == null || C1938m.m4714a(context)) {
            C1524b.m2158b("scr the conditions are not met");
            return;
        }
        try {
            m2973a(context).m2975a();
        } catch (Throwable th) {
            C1524b.m2141a("scr init error " + th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2982a(Thread thread, Throwable th) {
        if (this.f2015a != null) {
            C1524b.m2158b("scr dispatch to " + this.f2015a);
            this.f2015a.uncaughtException(thread, th);
            return;
        }
        C1524b.m2141a("scr kill process " + Process.myPid());
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        m2982a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002f */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2983a(java.lang.Thread r3, java.lang.Throwable r4, int r5) {
        /*
            r2 = this;
            boolean r0 = r2.m2975a()     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x000f
            java.lang.String r5 = "scr not enabled, dispatch this ex"
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r5)     // Catch:{ all -> 0x002f }
            r2.m2982a(r3, r4)
            return
        L_0x000f:
            java.lang.String r0 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x002f }
            boolean r1 = com.xiaomi.push.C1720di.m2996a((java.lang.String) r0)     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0022
            java.lang.String r5 = "scr not found, dispatch this ex"
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r5)     // Catch:{ all -> 0x002f }
            r2.m2982a(r3, r4)
            return
        L_0x0022:
            com.xiaomi.push.dh r1 = r2.f2013a     // Catch:{ all -> 0x002f }
            java.lang.String r0 = com.xiaomi.push.C1720di.m3001b((java.lang.String) r0)     // Catch:{ all -> 0x002f }
            r1.mo17384a(r0, r5)     // Catch:{ all -> 0x002f }
            r2.m2985b()     // Catch:{ all -> 0x002f }
            goto L_0x0043
        L_0x002f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r5.<init>()     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = "scr handle error "
            r5.append(r0)     // Catch:{ all -> 0x0047 }
            r5.append(r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0047 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r5)     // Catch:{ all -> 0x0047 }
        L_0x0043:
            r2.m2982a(r3, r4)
            return
        L_0x0047:
            r5 = move-exception
            r2.m2982a(r3, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1715dd.m2983a(java.lang.Thread, java.lang.Throwable, int):void");
    }

    /* renamed from: a */
    private boolean m2984a() {
        return C1720di.m2995a(this.f2012a) && C1720di.m2993a();
    }

    /* renamed from: b */
    private void m2985b() {
        try {
            if (m2985b()) {
                JSONArray a = this.f2013a.mo17383a();
                if (a != null) {
                    if (a.length() > 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("report", a.toString());
                        C1651bg b = C1653bi.m2684b(this.f2012a, m2975a(), hashMap);
                        int i = -1;
                        if (b != null) {
                            i = b.f1864a;
                        }
                        C1524b.m2158b("scr response code " + i);
                        if (i == 200) {
                            int i2 = new JSONObject(b.mo17255a()).getInt("code");
                            if (i2 == 0) {
                                this.f2013a.mo17383a();
                                return;
                            }
                            C1524b.m2158b("scr error code " + i2);
                            return;
                        }
                        return;
                    }
                }
                C1524b.m2158b("scr no data to rep");
            }
        } catch (Throwable th) {
            C1524b.m2141a("scr rep error " + th);
        }
    }

    /* renamed from: b */
    private boolean m2986b() {
        String str;
        long currentTimeMillis = System.currentTimeMillis() - this.f2013a.mo17383a();
        if (currentTimeMillis < 180000) {
            str = "scr not rep because time " + currentTimeMillis;
        } else if (C1653bi.m2688e(this.f2012a)) {
            return true;
        } else {
            str = "scr not rep because net is other";
        }
        C1524b.m2158b(str);
        return false;
    }
}
