package com.bytedance.sdk.openadsdk.api.init;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.c.a.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.f;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.k.a.g;
import com.bytedance.sdk.openadsdk.l.i;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.aidl.a;
import com.bytedance.sdk.openadsdk.tool.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    public static final long INIT_TIME = System.currentTimeMillis();
    private static final AtomicBoolean a = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static long b = 0;

    public interface PAGInitCallback {
        void fail(int i, String str);

        void success();
    }

    static {
        k.c();
    }

    public static void doInit(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        b = SystemClock.elapsedRealtime();
        if (pAGInitCallback != null) {
            synchronized (k.d) {
                if (!k.d.contains(pAGInitCallback)) {
                    k.d.add(pAGInitCallback);
                    if (k.e() == 3) {
                        return;
                    }
                }
            }
        }
        if (isInitSuccess()) {
            d();
            return;
        }
        k.a(3);
        if (context == null) {
            b((int) INIT_LOCAL_FAIL_CODE, "Context is null, please check. ");
        } else if (initConfig != null) {
            f(context, initConfig);
            try {
                h.a(pAGInitCallback);
                try {
                    t.a(m.a(), "tt_ad_logo_txt");
                    int e = t.e(context, "tt_ad_logo");
                    int f = t.f(context, "tt_activity_reward_and_full_video_no_bar");
                    if (e == 0 || f == 0) {
                        a(initConfig, pAGInitCallback);
                    } else if (isInitSuccess()) {
                        if (pAGInitCallback != null) {
                            d();
                            b.a(initConfig instanceof PAGConfig ? 1 : 0, "init");
                        }
                    } else if (!a.getAndSet(true)) {
                        if (!initConfig.isSupportMultiProcess()) {
                            d(context, initConfig);
                            return;
                        }
                        a.a((com.bytedance.sdk.openadsdk.multipro.aidl.b) new com.bytedance.sdk.openadsdk.multipro.aidl.b() {
                            public void onServiceConnected() {
                                PAGSdk.d(context, initConfig);
                            }
                        });
                        a.a(context).a();
                    }
                } catch (Throwable unused) {
                    a(initConfig, pAGInitCallback);
                }
            } catch (Throwable unused2) {
                b((int) INIT_LOCAL_FAIL_CODE, "Internal Error, setting exception. ");
            }
        } else if (pAGInitCallback instanceof TTAdSdk.InitCallback) {
            b((int) INIT_LOCAL_FAIL_CODE, "TTAdConfig is null, please check.");
        } else {
            b((int) INIT_LOCAL_FAIL_CODE, "PAGConfig is null, please check.");
        }
    }

    private static void a(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback == null) {
            return;
        }
        if (initConfig instanceof PAGConfig) {
            b((int) INIT_LOCAL_FAIL_CODE, "resources not found, if you use aab please call PAGConfig.setPackageName");
        } else {
            b((int) INIT_LOCAL_FAIL_CODE, "resources not found, if you use aab please call TTAdConfig.setPackageName");
        }
    }

    /* access modifiers changed from: private */
    public static void d(final Context context, final InitConfig initConfig) {
        k.c().post(new Runnable() {
            public void run() {
                long j;
                try {
                    if (PAGSdk.isInitSuccess()) {
                        PAGSdk.d();
                        return;
                    }
                    c.a(context, initConfig.isSupportMultiProcess());
                    PAGSdk.g(context, initConfig);
                    PAGSdk.h(context, initConfig);
                    j = SystemClock.elapsedRealtime() - PAGSdk.b;
                    PAGSdk.d();
                    g.b();
                    long elapsedRealtime = SystemClock.elapsedRealtime() - PAGSdk.b;
                    PAGSdk.b(context, PAGSdk.isInitSuccess(), initConfig, elapsedRealtime, j);
                    l.b("PAGSdk", "Pangle exec init sdk sdkInitTime=", Long.valueOf(j), " duration=", Long.valueOf(elapsedRealtime));
                    b.a(initConfig instanceof PAGConfig ? 1 : 0, "init");
                } catch (Throwable th) {
                    th.printStackTrace();
                    PAGSdk.b((int) PAGSdk.INIT_LOCAL_FAIL_CODE, th.getMessage());
                    j = SystemClock.elapsedRealtime() - PAGSdk.b;
                }
            }
        });
    }

    private static void e(Context context, InitConfig initConfig) {
        k.a = b(initConfig);
        int gdpr = initConfig.getGdpr();
        boolean z = initConfig instanceof PAGConfig;
        if (z) {
            if (gdpr == 1) {
                gdpr = 0;
            } else if (gdpr == 0) {
                gdpr = 1;
            }
        }
        com.bytedance.sdk.openadsdk.a.b.a().setAppId(initConfig.getAppId()).setCoppa(initConfig.getCoppa()).setGdpr(gdpr).setCcpa(initConfig.getCcpa()).setIconId(initConfig.getAppIconId()).setTitleBarTheme(initConfig.getTitleBarTheme()).isUseTextureView(initConfig.isUseTextureView());
        if (z) {
            com.bytedance.sdk.openadsdk.a.b.a().debugLog(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        a(initConfig, com.bytedance.sdk.openadsdk.a.b.a());
        try {
            if (c(initConfig)) {
                l.b();
                com.bytedance.sdk.openadsdk.a.b.a().openDebugMode();
                i.a();
                com.bykv.vk.openvk.component.video.api.f.c.a();
            }
        } catch (Throwable unused) {
        }
        j.a = j.b(context);
    }

    private static boolean b(InitConfig initConfig) {
        if (initConfig instanceof TTAdConfig) {
            return ((TTAdConfig) initConfig).isAsyncInit();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean c(InitConfig initConfig) {
        if (initConfig instanceof TTAdConfig) {
            return ((TTAdConfig) initConfig).isDebug();
        }
        if (initConfig instanceof PAGConfig) {
            return ((PAGConfig) initConfig).getDebugLog();
        }
        return false;
    }

    private static void a(InitConfig initConfig, TTAdManager tTAdManager) {
        if (initConfig != null && tTAdManager != null && (initConfig instanceof TTAdConfig)) {
            TTAdConfig tTAdConfig = (TTAdConfig) initConfig;
            tTAdManager.setName(tTAdConfig.getAppName()).setPaid(tTAdConfig.isPaid()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setAllowShowNotifiFromSDK(tTAdConfig.isAllowShowNotify()).setNeedClearTaskReset(tTAdConfig.getNeedClearTaskReset()).debugLog(tTAdConfig.getDebugLog());
        }
    }

    private static void f(Context context, InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getPackageName())) {
            t.a(initConfig.getPackageName());
        }
        m.a(context);
        if (!initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.multipro.b.b();
        }
        k.b();
    }

    /* access modifiers changed from: private */
    public static void g(Context context, InitConfig initConfig) {
        if (f.a()) {
            e.c(-1);
            com.bytedance.sdk.openadsdk.multipro.c.a(context);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) e.a();
            com.bytedance.sdk.component.f.c.a.a(context).a(threadPoolExecutor);
            k.b.set(true);
            if (initConfig.isSupportMultiProcess()) {
                com.bytedance.sdk.openadsdk.multipro.b.a();
            }
            try {
                com.bytedance.sdk.component.adexpress.a.a.a.a().a(com.bytedance.sdk.openadsdk.e.a.a());
            } catch (Exception e) {
                e.printStackTrace();
            }
            d(initConfig);
            e(context, initConfig);
            com.bykv.vk.openvk.component.video.api.f.c.a("PangleSDK-4806");
            l.a("PangleSDK-4806");
            k.a();
            com.bykv.vk.openvk.component.video.a.a.a(m.d().S());
            com.bykv.vk.openvk.component.video.a.a.a(CacheDirFactory.getICacheDir(0));
            com.bykv.vk.openvk.component.video.api.b.a(context, (String) null, threadPoolExecutor, k.c());
            com.bykv.vk.openvk.component.video.api.b.a(initConfig.isSupportMultiProcess());
            com.bykv.vk.openvk.component.video.api.b.a(d.a().b().e());
            if (Build.VERSION.SDK_INT < 23) {
                com.bykv.vk.openvk.component.video.a.a.a(context);
            }
            com.bytedance.sdk.openadsdk.core.e.c.a();
        }
    }

    /* access modifiers changed from: private */
    public static void h(final Context context, InitConfig initConfig) {
        w.a(new com.bytedance.sdk.component.g.g("init sync") {
            public void run() {
                j d = m.d();
                if (!d.N()) {
                    synchronized (d) {
                        if (!d.N()) {
                            d.c();
                            d.u();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.l.e.f();
                k.a(context);
                e.a(true);
                e.a((com.bytedance.sdk.component.g.c) new com.bytedance.sdk.openadsdk.h.b.a());
                com.bytedance.sdk.openadsdk.l.e.h(context);
                com.bytedance.sdk.openadsdk.l.e.i(context);
                com.bytedance.sdk.openadsdk.c.a.a.b();
            }
        }, 10, 5);
        c();
    }

    private static void c() {
        e.b(new com.bytedance.sdk.component.g.g("Disk Event") {
            public void run() {
                com.bytedance.sdk.openadsdk.h.b.b();
            }
        }, 5);
    }

    private static void d(InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getData())) {
            h.d().d(initConfig.getData());
        }
        if (initConfig instanceof TTAdConfig) {
            TTAdConfig tTAdConfig = (TTAdConfig) initConfig;
            if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
                h.d().c(tTAdConfig.getKeywords());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, boolean z, InitConfig initConfig, long j, long j2) {
        final Context context2 = context;
        final InitConfig initConfig2 = initConfig;
        final long j3 = j;
        final long j4 = j2;
        final boolean z2 = z;
        w.a(new com.bytedance.sdk.component.g.g("initMustBeCall") {
            public void run() {
                ApmHelper.initApm(context2, initConfig2);
                if (m.d().O()) {
                    try {
                        boolean e2 = h.d().e();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(IronSourceConstants.EVENTS_DURATION, j3);
                        jSONObject.put("sdk_init_time", j4);
                        jSONObject.put("is_async", true);
                        jSONObject.put("is_multi_process", initConfig2.isSupportMultiProcess());
                        jSONObject.put("is_debug", PAGSdk.c(initConfig2));
                        jSONObject.put("is_use_texture_view", initConfig2.isUseTextureView());
                        jSONObject.put("is_activate_init", e2);
                        jSONObject.put("minSdkVersion", y.l(context2));
                        jSONObject.put("targetSdkVersion", y.k(context2));
                        jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                        jSONObject.put("is_success", z2);
                        h.d().a(false);
                        com.bytedance.sdk.openadsdk.h.b.a().a("pangle_sdk_init", jSONObject);
                        l.b("PAGSdk", "pangle_sdk_init = ", jSONObject);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }, 5);
    }

    /* access modifiers changed from: private */
    public static void d() {
        k.a(1);
        try {
            synchronized (k.d) {
                for (PAGInitCallback next : k.d) {
                    if (next != null) {
                        next.success();
                    }
                }
                k.d.clear();
            }
        } catch (Throwable th) {
            l.d(th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public static void b(int i, String str) {
        k.a(2);
        try {
            synchronized (k.d) {
                for (PAGInitCallback next : k.d) {
                    if (next != null) {
                        next.fail(i, str);
                    }
                }
                k.d.clear();
            }
        } catch (Throwable th) {
            l.d(th.getMessage());
        }
    }

    public static void init(Context context, PAGConfig pAGConfig, PAGInitCallback pAGInitCallback) {
        doInit(context, pAGConfig, pAGInitCallback);
    }

    public static boolean isInitSuccess() {
        return k.e() == 1;
    }

    public static String getSDKVersion() {
        return com.bytedance.sdk.openadsdk.a.b.a() != null ? com.bytedance.sdk.openadsdk.a.b.a().getSDKVersion() : "";
    }

    public static String getBiddingToken(String str) {
        return com.bytedance.sdk.openadsdk.a.b.a() != null ? com.bytedance.sdk.openadsdk.a.b.a().getBiddingToken(str) : "";
    }

    public static String getBiddingToken() {
        return com.bytedance.sdk.openadsdk.a.b.a() != null ? com.bytedance.sdk.openadsdk.a.b.a().getBiddingToken() : "";
    }

    public static boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (com.bytedance.sdk.openadsdk.a.b.a() != null) {
            return com.bytedance.sdk.openadsdk.a.b.a().onlyVerityPlayable(str, i, str2, str3, str4);
        }
        return false;
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && k.e() == 0) {
            k.d.add(pAGInitCallback);
        }
    }
}
