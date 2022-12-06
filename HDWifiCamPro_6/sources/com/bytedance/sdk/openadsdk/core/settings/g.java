package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.sdk.component.f.b;
import com.bytedance.sdk.component.f.b.c;
import com.bytedance.sdk.component.f.b.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.d;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.q;
import com.bytedance.sdk.openadsdk.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.ui.JavascriptBridge;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SettingsFetchTask */
public class g extends com.bytedance.sdk.component.g.g {
    static final ArrayList<String> a = new ArrayList<>(Arrays.asList(new String[]{"ja", "en", "ko", "zh", "th", "vi", "id", "ru", "ar", "fr", "de", "it", "es", "hi", "pt", "zh-Hant"}));
    /* access modifiers changed from: private */
    public final a b;
    private final d c;

    /* compiled from: SettingsFetchTask */
    public interface a {
        void a(boolean z);
    }

    public g(a aVar, d dVar) {
        super("SetF");
        this.b = aVar;
        this.c = dVar;
    }

    public void run() {
        Log.d("SdkSettings.Fetch", "Start Try");
        int a2 = v.a(m.a(), 0);
        if (a2 == 0) {
            Log.d("SdkSettings.Fetch", "No net");
            this.b.a(false);
            return;
        }
        final i iVar = new i();
        JSONObject a3 = a(a2);
        d b2 = com.bytedance.sdk.openadsdk.i.d.a().b().b();
        try {
            b2.a(com.bytedance.sdk.openadsdk.d.d.a(b2, y.d("/api/ad/union/sdk/settings/")));
            b2.b("User-Agent", y.c());
        } catch (Exception e) {
            l.c("SdkSettings.Fetch", "", (Throwable) e);
        }
        String jSONObject = b(a3).toString();
        b2.c(jSONObject);
        iVar.b(jSONObject.getBytes().length);
        b2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
            public void a(c cVar, b bVar) {
                JSONObject jSONObject;
                int a2 = bVar.a();
                iVar.a(a2);
                l.b("SdkSettings.Fetch", "response code is " + a2);
                String d = bVar.d();
                if (!bVar.f() || TextUtils.isEmpty(d)) {
                    l.e("SdkSettings.Fetch", "Fetch remote data fail, response fail");
                } else {
                    iVar.c(d.getBytes().length);
                    String str = null;
                    try {
                        jSONObject = new JSONObject(d);
                    } catch (JSONException e) {
                        l.c("SdkSettings.Fetch", "", (Throwable) e);
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (jSONObject.optInt("cypher", -1) == 3) {
                            str = com.bytedance.sdk.component.utils.a.b(jSONObject.optString("message"));
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    jSONObject = new JSONObject(str);
                                } catch (Throwable th) {
                                    l.a("SdkSettings.Fetch", "setting data error2: ", th);
                                }
                            }
                        }
                        try {
                            g.this.a(str, bVar.c());
                        } catch (Throwable th2) {
                            l.c("SdkSettings.Fetch", "", th2);
                        }
                        try {
                            boolean a3 = g.this.a(jSONObject);
                            iVar.b(a3);
                            iVar.a(m.d().j());
                            m.d().a(System.currentTimeMillis());
                            l.b("SdkSettings.Fetch", "Fetch remote data success, hitCache=" + a3);
                        } catch (Throwable th3) {
                            l.c("SdkSettings.Fetch", "", th3);
                        }
                        iVar.a(true);
                        iVar.a();
                        g.this.b.a(true);
                        return;
                    }
                    l.e("SdkSettings.Fetch", "fetch remote data fail, result is null");
                }
                iVar.a();
                g.this.b.a(false);
            }

            public void a(c cVar, IOException iOException) {
                l.c("SdkSettings.Fetch", "Fetch fail", (Throwable) iOException);
                iVar.a();
                g.this.b.a(false);
            }
        });
        e.g();
    }

    /* access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    String str2 = (String) next.getKey();
                    if (str2 != null) {
                        hashMap.put(str2.toLowerCase(Locale.US), next.getValue());
                    }
                }
                int parseInt = Integer.parseInt((String) hashMap.get("active-control"));
                long parseLong = Long.parseLong((String) hashMap.get(CampaignEx.JSON_KEY_ST_TS));
                String str3 = (String) hashMap.get("pst");
                String a2 = com.bykv.vk.openvk.component.video.api.f.b.a(str + parseInt + parseLong);
                if (a2 != null && a2.equalsIgnoreCase(str3)) {
                    i = parseInt;
                }
            }
        } catch (Throwable th) {
            l.c("SdkSettings.Fetch", "", th);
        }
        f.a(i);
    }

    private JSONObject a(int i) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            j d = m.d();
            int i2 = 2;
            l.a("setting", "Settings().isGdprUser =", Integer.valueOf(d.G()));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("device_city", y.o());
            if (d.x(VungleApiClient.GAID)) {
                jSONObject.put(VungleApiClient.GAID, com.com.bytedance.overseas.sdk.b.a.a().b());
            }
            jSONObject.put("gdpr", h.d().j());
            jSONObject.put(Cookie.COPPA_KEY, h.d().i());
            jSONObject.put("ccpa", h.d().v());
            if (d.x("mcc")) {
                jSONObject.put("mcc", q.b());
            }
            Context a2 = m.a();
            jSONObject.put("conn_type", y.f(i));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("language", j.a());
            jSONObject.put("time_zone", y.r());
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, y.e());
            boolean a3 = y.a();
            l.c("isApplicationForeground", "isApplicationForeground:" + a3);
            if (a3) {
                i2 = 1;
            }
            jSONObject.put("position", i2);
            jSONObject.put("app_version", y.g());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("uuid", j.c(a2));
            String f = h.d().f();
            if (f != null) {
                jSONObject.put("app_id", f);
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis);
            if (f != null) {
                str = f.concat(String.valueOf(currentTimeMillis)).concat(BuildConfig.VERSION_NAME);
            } else {
                str = "";
            }
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(str));
            jSONObject.put("tcstring", j.b(a2));
            jSONObject.put("tcf_gdpr", j.a(a2));
            jSONObject.put("lmt", e.b());
            jSONObject.put("locale_language", e.c());
            jSONObject.put("channel", "main");
            JSONObject e = d.e();
            if (e != null) {
                jSONObject.put("digest", e);
            }
            jSONObject.put("data_time", d.f());
            jSONObject.put("app_set_id_scope", c.a());
            jSONObject.put("app_set_id", c.b());
            jSONObject.put("installed_source", c.c());
        } catch (Exception e2) {
            l.c("SdkSettings.Fetch", "", (Throwable) e2);
        }
        return jSONObject;
    }

    private JSONObject b(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.a.a(jSONObject);
    }

    public boolean a(JSONObject jSONObject) {
        d.a a2 = this.c.a();
        JSONObject e = j.b().e();
        JSONObject optJSONObject = jSONObject.optJSONObject("digest");
        boolean z = (optJSONObject == null || e == null || !optJSONObject.toString().equals(e.toString())) ? false : true;
        if (optJSONObject != null) {
            a2.a("digest", optJSONObject.toString());
        } else {
            a2.a("digest");
        }
        a2.a("data_time", jSONObject.optLong("data_time"));
        if (jSONObject.has("req_inter_min")) {
            long optLong = jSONObject.optLong("req_inter_min", 10) * 60 * 1000;
            if (optLong < 0 || optLong > 86400000) {
                optLong = TTAdConstant.AD_MAX_EVENT_TIME;
            }
            a2.a("req_inter_min", optLong);
        }
        if (jSONObject.has("lp_new_style")) {
            a2.a("landingpage_new_style", jSONObject.optInt("lp_new_style", Integer.MAX_VALUE));
        }
        if (jSONObject.has("blank_detect_rate")) {
            int optInt = jSONObject.optInt("blank_detect_rate", 30);
            if (optInt < 0 || optInt > 100) {
                optInt = 30;
            }
            a2.a("blank_detect_rate", optInt);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject2 != null) {
            if (optJSONObject2.has(IronSourceConstants.EVENTS_DURATION)) {
                a2.a(IronSourceConstants.EVENTS_DURATION, optJSONObject2.optLong(IronSourceConstants.EVENTS_DURATION) * 1000);
            }
            if (optJSONObject2.has("max")) {
                a2.a("max", optJSONObject2.optInt("max"));
            }
        }
        if (jSONObject.has("vbtt")) {
            a2.a("vbtt", jSONObject.optInt("vbtt", 5));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("abtest");
        if (optJSONObject3 != null) {
            if (optJSONObject3.has("version")) {
                a2.a("ab_test_version", optJSONObject3.optString("version"));
            }
            if (optJSONObject3.has("param")) {
                a2.a("ab_test_param", optJSONObject3.optString("param"));
            }
        } else {
            j.b().g();
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("log_rate_conf");
        if (optJSONObject4 != null && optJSONObject4.has("global_rate")) {
            a2.a("global_rate", (float) optJSONObject4.optDouble("global_rate", 1.0d));
        }
        if (jSONObject.has("pyload_h5")) {
            a2.a("pyload_h5", jSONObject.optString("pyload_h5"));
        }
        if (jSONObject.has("pure_pyload_h5")) {
            a2.a("playableLoadH5Url", jSONObject.optString("pure_pyload_h5"));
        }
        if (jSONObject.has("ads_url")) {
            a2.a("ads_url", jSONObject.optString("ads_url"));
        }
        if (jSONObject.has("app_log_url")) {
            a2.a("app_log_url", jSONObject.optString("app_log_url"));
        }
        if (jSONObject.has("apm_url")) {
            a2.a("apm_url", jSONObject.optString("apm_url"));
        }
        if (jSONObject.has(Cookie.COPPA_KEY)) {
            int optInt2 = jSONObject.optInt(Cookie.COPPA_KEY, -99);
            h.d().d(optInt2);
            a2.a(Cookie.COPPA_KEY, optInt2);
        }
        if (jSONObject.has("privacy_url")) {
            a2.a("policy_url", jSONObject.optString("privacy_url"));
        }
        if (jSONObject.has("consent_url")) {
            a2.a("consent_url", jSONObject.optString("consent_url"));
        }
        if (jSONObject.has("ivrv_downward")) {
            a2.a("ivrv_downward", jSONObject.optInt("ivrv_downward", 0));
        }
        if (jSONObject.has("dc")) {
            a2.a("dc", jSONObject.optString("dc"));
        }
        j.b().a(jSONObject, a2);
        j.b().b(jSONObject, a2);
        if (jSONObject.has("if_both_open")) {
            a2.a("if_both_open", jSONObject.optInt("if_both_open", 0));
        }
        if (jSONObject.has("support_tnc")) {
            a2.a("support_tnc", jSONObject.optInt("support_tnc", 1));
        }
        if (jSONObject.has("insert_js_config")) {
            a2.a("insert_js_config", jSONObject.optString("insert_js_config", ""));
        }
        if (jSONObject.has("max_tpl_cnts")) {
            a2.a("max_tpl_cnts", jSONObject.optInt("max_tpl_cnts", 100));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject5 != null) {
            if (optJSONObject5.has("force_language")) {
                String optString = optJSONObject5.optString("force_language");
                if (!TextUtils.isEmpty(optString) && a.contains(optString)) {
                    a2.a("force_language", optString);
                }
            }
            if (optJSONObject5.has("fetch_tpl_timeout_ctrl")) {
                a2.a("fetch_tpl_timeout_ctrl", optJSONObject5.optInt("fetch_tpl_timeout_ctrl", PathInterpolatorCompat.MAX_NUM_POINTS));
            }
            if (optJSONObject5.has("disable_rotate_banner_on_dislike")) {
                a2.a("disable_rotate_banner_on_dislike", optJSONObject5.optInt("disable_rotate_banner_on_dislike", Integer.MAX_VALUE));
            }
            if (optJSONObject5.has("webview_cache_count")) {
                a2.a("webview_cache_count", optJSONObject5.optInt("webview_cache_count", 20));
            }
        }
        if (jSONObject.has("read_video_from_cache")) {
            a2.a("read_video_from_cache", jSONObject.optInt("read_video_from_cache", 1));
        }
        b.a(jSONObject.optJSONArray("ad_slot_conf_list"));
        JSONObject optJSONObject6 = jSONObject.optJSONObject(JavascriptBridge.MraidHandler.PRIVACY_ACTION);
        if (optJSONObject6 != null) {
            if (optJSONObject6.has("ad_enable")) {
                a2.a("privacy_ad_enable", optJSONObject6.optInt("ad_enable", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("personalized_ad")) {
                a2.a("privacy_personalized_ad", optJSONObject6.optInt("personalized_ad", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("sladar_enable")) {
                a2.a("privacy_sladar_enable", optJSONObject6.optInt("sladar_enable", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("app_log_enable")) {
                a2.a("privacy_app_log_enable", optJSONObject6.optInt("app_log_enable", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("sec_enable")) {
                a2.a("privacy_sec_enable", optJSONObject6.optInt("sec_enable", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("debug_unlock")) {
                a2.a("privacy_debug_unlock", optJSONObject6.optInt("debug_unlock", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("fields_allowed")) {
                String optString2 = optJSONObject6.optString("fields_allowed", "");
                if (!TextUtils.isEmpty(optString2)) {
                    a2.a("privacy_fields_allowed", optString2);
                } else {
                    a2.a("privacy_fields_allowed");
                }
            }
        }
        if (jSONObject.has("video_cache_config")) {
            a2.a("video_cache_config", jSONObject.optString("video_cache_config"));
        }
        if (jSONObject.has("loaded_recall_time")) {
            int optInt3 = jSONObject.optInt("loaded_recall_time", 0);
            if (!(optInt3 == 0 || optInt3 == 1)) {
                optInt3 = 0;
            }
            a2.a("loadedCallbackOpportunity", optInt3);
        }
        if (jSONObject.has("load_strategy")) {
            int optInt4 = jSONObject.optInt("load_strategy", 0);
            if (!(optInt4 == 0 || optInt4 == 1)) {
                optInt4 = 0;
            }
            a2.a("load_callback_strategy", optInt4);
        }
        a2.a();
        j.b().u();
        return z;
    }
}
