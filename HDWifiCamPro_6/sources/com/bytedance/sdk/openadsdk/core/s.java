package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.core.e.c;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.l.p;
import com.bytedance.sdk.openadsdk.l.q;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.com.bytedance.overseas.sdk.b.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.VungleApiClient;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
/* compiled from: TTAdManagerImpl */
public class s implements TTAdManager {
    private static final Map<Integer, String> f = new HashMap<Integer, String>(12) {
        {
            put(1, "abtest");
            put(2, "user_data");
            put(3, VungleApiClient.GAID);
            put(4, "apk-sign");
            put(5, "app_set_id_scope");
            put(6, "app_set_id");
            put(7, "installed_source");
            put(8, "app_running_time");
            put(9, "vendor");
            put(10, "model");
            put(11, "user_agent_device");
            put(12, "user_agent_webview");
            put(13, "sys_compiling_time");
            put(14, "sec_did");
            put(15, "url");
            put(16, "X-Argus");
            put(17, "X-Ladon");
            put(18, "X-Khronos");
            put(19, "X-Gorgon");
            put(20, "pangle_m");
            put(21, "screen_height");
            put(22, "screen_width");
            put(23, "rom_version");
            put(24, "carrier_name");
            put(25, "os_version");
            put(26, "conn_type");
            put(27, "boot");
        }
    };
    String a;
    boolean b = false;
    boolean c = false;
    String d = "com.union_test.internationad";
    String e = "8025677";
    private int g = 0;

    private void e(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.a)) {
            this.a = str;
            try {
                JSONObject a2 = m.c().a(new JSONObject(str));
                if (a2 != null) {
                    o.a a3 = o.a.a(a2, (AdSlot) null, (com.bytedance.sdk.openadsdk.core.model.o) null);
                    if (a3.d == 20000) {
                        if (a3.h != null) {
                            if (a3.h.b().size() > 0) {
                                boolean z = false;
                                n nVar = a3.h.b().get(0);
                                this.b = nVar.aU();
                                if (nVar.G() != null) {
                                    z = true;
                                }
                                this.c = z;
                            }
                            while (true) {
                                switch (13) {
                                    case 13:
                                        return;
                                    case 14:
                                        if (((84 * 84) + (7 * 7)) - ((84 * 7) * 2) >= 0) {
                                            return;
                                        }
                                        break;
                                    case 15:
                                        break;
                                }
                            }
                            if (((17 + 1) * 17) % 2 != 0) {
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public s setAppId(String str) {
        h.d().a(str);
        return this;
    }

    /* renamed from: a */
    public s setPaid(boolean z) {
        h.d().b(z);
        return this;
    }

    /* renamed from: b */
    public s setName(String str) {
        h.d().b(str);
        return this;
    }

    /* renamed from: c */
    public s setKeywords(String str) {
        h.d().c(str);
        return this;
    }

    public TTAdNative createAdNative(Context context) {
        return new t(context);
    }

    /* renamed from: d */
    public s setData(String str) {
        h.d().d(str);
        return this;
    }

    public TTAdManager debugLog(int i) {
        this.g = i;
        return this;
    }

    public String getBiddingToken() {
        return getBiddingToken((String) null);
    }

    public String getBiddingToken(String str) {
        int i;
        String str2 = str;
        y.j("getBiddingToken");
        c.a();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_init", TTAdSdk.isInitSuccess() ? 1 : 0);
            String j = m.d().j();
            String m = m.d().m();
            if (!(j == null || m == null)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("version", j);
                jSONObject3.put("param", m);
                jSONObject2.put("abtest", jSONObject3);
            }
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put(CampaignEx.JSON_KEY_PACKAGE_NAME, y.e());
            jSONObject2.put("user_data", o.a(TextUtils.isEmpty(str2) ? null : new AdSlot.Builder().setCodeId(str2).build()));
            jSONObject2.put(CampaignEx.JSON_KEY_ST_TS, System.currentTimeMillis() / 1000);
            if (jSONObject2.toString().getBytes().length <= 2680) {
                j d2 = m.d();
                if (d2.x(VungleApiClient.GAID)) {
                    jSONObject2.put(VungleApiClient.GAID, a.a().b());
                }
                Context a2 = m.a();
                jSONObject2.put("apk-sign", c.b());
                jSONObject2.put("app_set_id_scope", com.bytedance.sdk.openadsdk.core.settings.c.a());
                jSONObject2.put("app_set_id", com.bytedance.sdk.openadsdk.core.settings.c.b());
                jSONObject2.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.c.c());
                jSONObject2.put("app_running_time", (System.currentTimeMillis() - PAGSdk.INIT_TIME) / 1000);
                jSONObject2.put("vendor", Build.MANUFACTURER);
                jSONObject2.put("model", Build.MODEL);
                jSONObject2.put("user_agent_device", y.b());
                jSONObject2.put("user_agent_webview", y.c());
                jSONObject2.put("sys_compiling_time", j.b(a2));
                jSONObject2.put("screen_height", z.d(a2));
                jSONObject2.put("screen_width", z.c(a2));
                jSONObject2.put("rom_version", p.a());
                jSONObject2.put("carrier_name", q.a());
                jSONObject2.put("os_version", Build.VERSION.RELEASE);
                jSONObject2.put("conn_type", y.m(a2));
                if (d2.x("boot")) {
                    jSONObject2.put("boot", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + "");
                }
                c.a(jSONObject2);
                i = f.size();
            } else {
                i = 2;
            }
            while (i >= 1 && jSONObject2.toString().getBytes().length > 2680) {
                jSONObject2.remove(f.get(Integer.valueOf(i)));
                i--;
            }
            jSONObject = com.bytedance.sdk.component.utils.a.a(jSONObject2);
            while (i >= 1 && jSONObject.toString().getBytes().length > 4096) {
                jSONObject2.remove(f.get(Integer.valueOf(i)));
                jSONObject = com.bytedance.sdk.component.utils.a.a(jSONObject2);
                i--;
            }
            if (l.d()) {
                l.c("mssdk", "bidding token: " + jSONObject.toString() + "\nbidding token length: " + jSONObject.toString().getBytes().length);
            }
            com.bytedance.sdk.openadsdk.c.c.a(str);
        } catch (Throwable unused) {
        }
        l.b("TTAdManagerImpl", "bidding token: " + jSONObject.toString());
        return jSONObject.toString();
    }

    public int getCcpa() {
        return h.d().v();
    }

    public int getCoppa() {
        return h.d().i();
    }

    public int getDebugLog() {
        return this.g;
    }

    public int getGdpr() {
        return h.d().j();
    }

    public String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getSupportRegion() {
        return "VA";
    }

    public boolean isExpressAd(String str, String str2) {
        if (m.d().i(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        e(str2);
        return this.c;
    }

    public boolean isFullScreenVideoAd(String str, String str2) {
        if (m.d().j(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        e(str2);
        return this.b;
    }

    public TTAdManager isUseTextureView(boolean z) {
        h.d().d(z);
        return this;
    }

    public boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (!this.d.equals(m.a().getPackageName()) || !this.e.equals(h.d().f()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (a2 != null) {
                a2.invoke((Object) null, new Object[]{str, Integer.valueOf(i), str2, str3, str4});
            }
        } catch (Throwable th) {
            l.b("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
        }
        return true;
    }

    public TTAdManager openDebugMode() {
        l.b();
        com.bytedance.sdk.component.f.a.a();
        return this;
    }

    public void requestPermissionIfNecessary(Context context) {
    }

    public TTAdManager setAllowShowNotifiFromSDK(boolean z) {
        h.d().c(z);
        return this;
    }

    public TTAdManager setCcpa(int i) {
        h.d().f(i);
        return this;
    }

    public TTAdManager setCoppa(int i) {
        h.d().b(i);
        return this;
    }

    public TTAdManager setGdpr(int i) {
        h.d().c(i);
        return this;
    }

    public TTAdManager setIconId(int i) {
        h.d().a(i);
        return this;
    }

    public TTAdManager setNeedClearTaskReset(String[] strArr) {
        h.d().a(strArr);
        return this;
    }

    public TTAdManager setTitleBarTheme(int i) {
        h.d().e(i);
        return this;
    }

    public void showPrivacyProtection() {
        TTDelegateActivity.a();
    }
}
