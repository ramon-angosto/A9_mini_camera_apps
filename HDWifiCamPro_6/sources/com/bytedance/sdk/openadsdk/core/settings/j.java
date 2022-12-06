package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.adexpress.a.b.c;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.d;
import com.bytedance.sdk.openadsdk.core.settings.g;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.vungle.warren.model.Cookie;
import java.io.File;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: TTSdkSettings */
public class j implements g.a {
    public static String a = null;
    public static String b = "IABTCF_TCString";
    public static String c;
    public static String d;
    public static String e = (t.a(m.a(), "tt_feedback_thank_text") + "\n" + t.a(m.a(), "tt_feedback_experience_text"));
    private static final String f = y.n();
    /* access modifiers changed from: private */
    public static final com.bytedance.sdk.component.g.g g = new com.bytedance.sdk.component.g.g("TemplateReInitTask") {
        public void run() {
            c.a().g();
            c.a().b(false);
            com.bytedance.sdk.component.adexpress.a.b.a.b();
            com.bytedance.sdk.openadsdk.h.b.c("1");
            c.a().b();
        }
    };
    private final d h;
    private final AtomicBoolean i;
    private volatile boolean j;
    private final Runnable k;

    /* compiled from: TTSdkSettings */
    private static class a {
        static j a = new j();
    }

    private int b(boolean z) {
        return z ? 20 : 5;
    }

    static {
        try {
            c = t.a(m.a(), "tt_txt_skip");
            d = t.a(m.a(), "tt_feedback_submit_text");
        } catch (Throwable th) {
            l.c("SdkSettings", "", th);
        }
    }

    private j() {
        this.h = new h();
        this.i = new AtomicBoolean(false);
        this.j = false;
        this.k = new Runnable() {
            public void run() {
                l.b("SdkSettings", "auto fetch task active, try fetch remote data");
                j.this.c(2);
                j.this.V();
            }
        };
        try {
            Context a2 = m.a();
            IntentFilter intentFilter = new IntentFilter();
            if (r.a(a2)) {
                intentFilter.addAction("_tryFetRemoDat");
            } else {
                intentFilter.addAction("_dataChanged");
            }
            a2.registerReceiver(new b(), intentFilter);
        } catch (Exception e2) {
            l.c("SdkSettings", "", (Throwable) e2);
        }
    }

    public static void a() {
        File file;
        try {
            Context a2 = m.a();
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(a2.getDataDir(), "shared_prefs");
            } else {
                file = new File(a2.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String replace = file2.getName().replace(".xml", "");
                if (Build.VERSION.SDK_INT >= 24) {
                    a2.deleteSharedPreferences(replace);
                } else {
                    a2.getSharedPreferences(replace, 0).edit().clear().apply();
                    f.c(file2);
                }
            }
            b.b();
        } catch (Throwable unused) {
        }
    }

    private static void b(int i2, boolean z) {
        Context a2 = m.a();
        if (a2 != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(a2.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z);
                intent.putExtra("_source", i2);
                a2.sendBroadcast(intent);
            } catch (Throwable th) {
                Log.e("SdkSettings", "requestMainProcessFetchRemoteData: ", th);
            }
        }
    }

    private static void Y() {
        Context a2 = m.a();
        if (a2 != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(a2.getPackageName());
                intent.setAction("_dataChanged");
                a2.sendBroadcast(intent);
            } catch (Throwable th) {
                l.c("SdkSettings", "", th);
            }
        }
    }

    public static int a(Context context) {
        if (context == null || !c(context)) {
            return -2;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("IABTCF_gdprApplies", -1);
    }

    public static String b(Context context) {
        if (context != null) {
            return PreferenceManager.getDefaultSharedPreferences(context).getString(b, "");
        }
        return "";
    }

    private static boolean c(Context context) {
        if (context == null) {
            return true;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i2 = defaultSharedPreferences.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE);
        int i3 = defaultSharedPreferences.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE);
        if (i2 == Integer.MIN_VALUE && i3 == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public static j b() {
        return a.a;
    }

    public synchronized void c() {
        l.b("SdkSettings", "loadLocalData: ");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = !this.j;
        this.h.a(this.j);
        b.a();
        h.d().d(A());
        this.j = true;
        l.a("SdkSettings", "loadLocalData: finished, used", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), "ms");
        if (z && r.a(m.a())) {
            k.c().postDelayed(new Runnable() {
                public void run() {
                    j.this.c(1);
                    j.this.V();
                }
            }, 1000);
        }
    }

    public int d() {
        return this.h.a("max_tpl_cnts", 100);
    }

    public JSONObject e() {
        return (JSONObject) this.h.a("digest", null, d.a);
    }

    public long f() {
        return this.h.a("data_time", 0);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.h.a().a("tt_sdk_settings").a("ab_test_param").a();
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, d.a aVar) {
        if (jSONObject != null && jSONObject.has("dyn_draw_engine_url")) {
            String a2 = this.h.a("dyn_draw_engine_url", f);
            String optString = jSONObject.optString("dyn_draw_engine_url", f);
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(optString) && !optString.equals(a2)) {
                k.c().postDelayed(new Runnable() {
                    public void run() {
                        w.a(j.g);
                    }
                }, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
            aVar.a("dyn_draw_engine_url", optString);
        }
    }

    public int a(String str) {
        if (str == null) {
            return 0;
        }
        return m.d().v(str).r;
    }

    /* access modifiers changed from: package-private */
    public void b(JSONObject jSONObject, d.a aVar) {
        if (jSONObject.has("is_gdpr_user")) {
            int optInt = jSONObject.optInt("is_gdpr_user", -1);
            if (!(optInt == -1 || optInt == 1 || optInt == 0)) {
                optInt = -1;
            }
            aVar.a("isGdprUser", optInt);
        }
    }

    public boolean h() {
        return this.h.a("if_both_open", 0) == 1;
    }

    public boolean i() {
        return this.h.a("support_tnc", 1) == 1;
    }

    public String j() {
        return this.h.a("ab_test_version", "");
    }

    public int k() {
        return this.h.a("load_callback_strategy", 0);
    }

    public int l() {
        return this.h.a("loadedCallbackOpportunity", 0);
    }

    public String m() {
        return this.h.a("ab_test_param", "");
    }

    public boolean n() {
        return this.h.a("landingpage_new_style", -1) == 1;
    }

    public long o() {
        return this.h.a(IronSourceConstants.EVENTS_DURATION, (long) WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public int p() {
        return this.h.a("max", 50);
    }

    public String q() {
        return this.h.a("pyload_h5", (String) null);
    }

    public e r() {
        return (e) this.h.a("insert_js_config", e.a, new d.b<e>() {
            /* renamed from: a */
            public e b(String str) {
                return new e(str);
            }
        });
    }

    public String s() {
        return this.h.a("playableLoadH5Url", "");
    }

    public int t() {
        int a2 = this.h.a("fetch_tpl_timeout_ctrl", (int) PathInterpolatorCompat.MAX_NUM_POINTS);
        return a2 <= 0 ? PathInterpolatorCompat.MAX_NUM_POINTS : a2;
    }

    public void u() {
        if (Build.VERSION.SDK_INT >= 17) {
            String Z = Z();
            if (!TextUtils.isEmpty(Z)) {
                if (Z.equals("zh-Hant")) {
                    i.a(m.a(), "zh", "tw");
                } else {
                    i.a(m.a(), Z, (String) null);
                }
                try {
                    c = t.a(m.a(), "tt_txt_skip");
                    d = t.a(m.a(), "tt_feedback_submit_text");
                    e = t.a(m.a(), "tt_feedback_thank_text") + "\n" + t.a(m.a(), "tt_feedback_experience_text");
                } catch (Throwable th) {
                    l.c("SdkSettings", "", th);
                }
            }
        }
    }

    private String Z() {
        return this.h.a("force_language", "");
    }

    public int v() {
        return this.h.a("disable_rotate_banner_on_dislike", Integer.MAX_VALUE);
    }

    public boolean b(String str) {
        return v(str).c == 1;
    }

    public boolean c(String str) {
        int i2 = v(str).e;
        if (i2 == 1) {
            return o.d(m.a());
        }
        if (i2 != 2) {
            if (i2 != 3) {
            }
            return false;
        } else if (o.c(m.a()) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean d(String str) {
        return v(str).g == 1;
    }

    public int e(String str) {
        return v(str).q;
    }

    public boolean f(String str) {
        if (str == null || v(str).m == 1) {
            return true;
        }
        return false;
    }

    public int g(String str) {
        if (str == null) {
            return 1500;
        }
        return v(str).o;
    }

    public int h(String str) {
        return v(String.valueOf(str)).k;
    }

    public boolean i(String str) {
        try {
            if (v(str).v != null) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            Log.e("SdkSettings", "haveTplIds: ", e2);
            return false;
        }
    }

    public boolean j(String str) {
        try {
            if (v(str).w == 8) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            l.c("SdkSettings", "", (Throwable) e2);
            return false;
        }
    }

    public boolean w() {
        return this.h.b();
    }

    public int k(String str) {
        return v(String.valueOf(str)).h;
    }

    public int l(String str) {
        return v(str).j;
    }

    public int a(String str, boolean z) {
        if (str == null) {
            return b(z);
        }
        a v = v(str);
        return v.x != -1 ? v.x : b(z);
    }

    public boolean m(String str) {
        return v(str).u == 0;
    }

    public boolean n(String str) {
        if (str == null || v(str).l == 1) {
            return true;
        }
        return false;
    }

    public String x() {
        return this.h.a("ads_url", "");
    }

    public String y() {
        return this.h.a("app_log_url", "");
    }

    public String z() {
        return this.h.a("apm_url", "");
    }

    public int A() {
        return this.h.a(Cookie.COPPA_KEY, -99);
    }

    public String B() {
        return this.h.a("policy_url", "");
    }

    public String C() {
        return this.h.a("consent_url", "https://lf-hs-sg.ibytedtos.com/obj/union-platform-i18n/union_platform_gdpr_607_en.html");
    }

    public int D() {
        return this.h.a("ivrv_downward", 0);
    }

    public String E() {
        return this.h.a("dyn_draw_engine_url", f);
    }

    public String F() {
        return this.h.a("dc", "");
    }

    public int G() {
        return this.h.a("isGdprUser", -1);
    }

    public int a(int i2) {
        return v(String.valueOf(i2)).b;
    }

    public int b(int i2) {
        return v(String.valueOf(i2)).i;
    }

    public int H() {
        return this.h.a("vbtt", 5);
    }

    public int o(String str) {
        return v(str).s;
    }

    public int p(String str) {
        return v(str).k;
    }

    public boolean q(String str) {
        return v(str).t;
    }

    public int r(String str) {
        return v(str).y;
    }

    public int s(String str) {
        return v(str).z;
    }

    public int t(String str) {
        return v(str).A;
    }

    public boolean u(String str) {
        return m.d().v(str).n == 1;
    }

    public a v(String str) {
        return b.a(str);
    }

    public void w(String str) {
        b.b(str);
    }

    public boolean I() {
        int a2 = this.h.a("privacy_ad_enable", Integer.MAX_VALUE);
        if (a2 == 1) {
            return true;
        }
        if (a2 == 0) {
            return false;
        }
        int p = y.p();
        if (p == 1 || p == 2 || p == 3) {
            return true;
        }
        if (p == 4 || p != 5) {
        }
        return false;
    }

    public int J() {
        int a2 = this.h.a("privacy_personalized_ad", Integer.MAX_VALUE);
        if (a2 != Integer.MAX_VALUE) {
            return a2;
        }
        int p = y.p();
        if (p == 1 || p == 2) {
            return 2;
        }
        if (p == 3) {
            return 1;
        }
        if (p == 4 || p != 5) {
        }
        return 0;
    }

    public boolean K() {
        return this.h.a("privacy_sladar_enable", Integer.MAX_VALUE) == 1;
    }

    public boolean L() {
        if ("VA".equalsIgnoreCase(F()) || y.p() == 3) {
            return false;
        }
        int a2 = this.h.a("privacy_sec_enable", Integer.MAX_VALUE);
        if (a2 == 1) {
            return true;
        }
        if (a2 == 0) {
            return false;
        }
        int p = y.p();
        if (p == 1 || p == 2 || p == 3) {
            return true;
        }
        if (p == 4 || p != 5) {
        }
        return false;
    }

    public boolean M() {
        return this.h.a("privacy_debug_unlock", 1) != 0;
    }

    public boolean x(String str) {
        Set set = (Set) this.h.a("privacy_fields_allowed", Collections.emptySet(), d.b);
        if (!set.isEmpty()) {
            return set.contains(str);
        }
        int p = y.p();
        if (p == 1) {
            return true;
        }
        if (p != 2 && p != 3) {
            if (p == 4 || p == 5) {
            }
            return false;
        } else if ("mcc".equals(str) || "mnc".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean N() {
        return this.j;
    }

    public boolean O() {
        return this.h.a("global_rate", 1.0f) == 1.0f;
    }

    public boolean P() {
        return this.h.a("read_video_from_cache", 1) == 1;
    }

    public int Q() {
        int a2 = this.h.a("webview_cache_count", 20);
        if (a2 < 0) {
            return 20;
        }
        return a2;
    }

    public int R() {
        return this.h.a("blank_detect_rate", 30);
    }

    public JSONObject S() {
        return (JSONObject) this.h.a("video_cache_config", null, d.a);
    }

    public long T() {
        long a2 = this.h.a("req_inter_min", (long) TTAdConstant.AD_MAX_EVENT_TIME);
        return (a2 < 0 || a2 > 86400000) ? TTAdConstant.AD_MAX_EVENT_TIME : a2;
    }

    public long U() {
        return this.h.a("last_req_time", 0);
    }

    public void a(long j2) {
        this.h.a().a("last_req_time", j2).a();
    }

    /* access modifiers changed from: package-private */
    public void V() {
        if (r.a(m.a())) {
            k.c().removeCallbacks(this.k);
            long T = m.d().T();
            l.b("SdkSettings", "scheduleAutoFetchTask, nextTimeDelay=" + T);
            k.c().postDelayed(this.k, T);
        }
    }

    public void c(int i2) {
        a(i2, false);
    }

    public void a(int i2, boolean z) {
        try {
            if (!aa()) {
                long U = m.d().U();
                long currentTimeMillis = System.currentTimeMillis();
                long T = m.d().T();
                long j2 = currentTimeMillis - U;
                Log.d("SdkSettings", "fetchRemoteSdkSettings: lastReq=" + U + ", dis=" + j2 + "/" + T + ", force=" + z + ", source=" + i2);
                if (!z && j2 < T) {
                    return;
                }
                if (!r.a(m.a())) {
                    b(i2, z);
                } else if (!this.i.compareAndSet(false, true)) {
                    Log.d("SdkSettings", "fetchRemoteSdkSettings: already requesting");
                } else {
                    w.a((com.bytedance.sdk.component.g.g) new g(this, this.h));
                    k.c().removeCallbacks(this.k);
                }
            }
        } catch (Throwable th) {
            l.a("SdkSettings", "load sdk settings error: ", th);
        }
    }

    private boolean aa() {
        return TextUtils.isEmpty(h.d().f());
    }

    public void a(boolean z) {
        Log.d("SdkSettings", "onFetchFinish() called with: dataChanged = [" + z + "]");
        this.i.set(false);
        V();
        if (z) {
            Y();
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        Y();
    }

    /* compiled from: TTSdkSettings */
    private class b extends BroadcastReceiver {
        private final Handler b;

        private b() {
            this.b = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    w.a((com.bytedance.sdk.component.g.g) new com.bytedance.sdk.component.g.g("LoadLocalData") {
                        public void run() {
                            try {
                                j.this.c();
                            } catch (Exception e) {
                                Log.e("SdkSettings", "", e);
                            }
                        }
                    });
                }
            };
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                l.b("SdkSettings", "onReceive: action=" + action);
                if ("_tryFetRemoDat".equals(action)) {
                    j.this.a(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                } else if ("_dataChanged".equals(action)) {
                    this.b.removeMessages(0);
                    this.b.sendEmptyMessageDelayed(0, WorkRequest.MIN_BACKOFF_MILLIS);
                }
            }
        }
    }
}
