package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.vungle.warren.VungleApiClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ReportUtil */
public class d {
    public static final String a = d.class.getSimpleName();

    private static String b(Context context, String str) {
        if (context == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pf", "1");
            jSONObject.put("ov", m.f());
            jSONObject.put("pn", m.k(context));
            jSONObject.put("vn", m.f(context));
            jSONObject.put("vc", m.e(context));
            jSONObject.put("ot", m.d(context));
            jSONObject.put("dm", m.a());
            jSONObject.put("bd", m.c());
            jSONObject.put(VungleApiClient.GAID, m.i());
            int n = m.n(context);
            jSONObject.put("nt", n);
            jSONObject.put("nts", m.a(context, n));
            jSONObject.put("l", m.c(context));
            jSONObject.put("tz", m.e());
            jSONObject.put("ua", m.d());
            jSONObject.put("app_id", a.e().h());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sv", MBConfiguration.SDK_VERSION);
            jSONObject.put("ss", m.h(context) + "x" + m.i(context));
            if (b.a().b(a.e().h()) != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(m.k())) {
                        jSONObject2.put("manufacturer", m.k());
                    }
                    if (m.h() != -1) {
                        jSONObject2.put("sdkint", m.h());
                    }
                    if (!TextUtils.isEmpty(m.o(context))) {
                        jSONObject2.put("is24H", m.o(context));
                    }
                    if (!TextUtils.isEmpty(m.l())) {
                        jSONObject2.put("totalram", m.l());
                    }
                    if (!TextUtils.isEmpty(m.p(context))) {
                        jSONObject2.put("totalmemory", m.p(context));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(jSONObject2.toString())) {
                    String a2 = l.a(jSONObject2.toString());
                    if (!TextUtils.isEmpty(a2)) {
                        jSONObject.put("dvi", URLEncoder.encode(a2, "utf-8"));
                    }
                }
            }
            return jSONObject.toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String a(Campaign campaign, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put("action", str);
            jSONObject.put("label", i);
            if (campaign != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", campaign.getId());
                jSONObject2.put(CampaignEx.JSON_KEY_TITLE, campaign.getAppName());
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, jSONObject2);
            } else {
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
            }
        } catch (Exception e) {
            q.d(a, e.getMessage());
        }
        return jSONObject.toString();
    }

    public static com.mbridge.msdk.foundation.same.net.h.d a(String str, String str2, Context context, String str3) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d();
        dVar.a("m_device_info", b(context, str3));
        dVar.a("m_action", str);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String a2 = Aa.a();
                if (a2 == null) {
                    a2 = "";
                }
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("channel", a2);
                str2 = jSONObject.toString();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        dVar.a("m_data", str2);
        dVar.a("m_sdk", "msdk");
        return dVar;
    }

    public static com.mbridge.msdk.foundation.same.net.h.d a(Context context) {
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d();
        try {
            dVar.a("platform", "1");
            dVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, URLEncoder.encode(m.k(context)));
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a("os_version", Build.VERSION.RELEASE);
                dVar.a("brand", URLEncoder.encode(m.c()));
                dVar.a("model", URLEncoder.encode(m.a()));
                dVar.a(VungleApiClient.GAID, m.i());
                int n = m.n(context);
                dVar.a("network_type", n + "");
                dVar.a("network_str", m.a(context, n));
                dVar.a("language", URLEncoder.encode(m.c(context)));
                dVar.a("timezone", URLEncoder.encode(m.e()));
                dVar.a("ua", URLEncoder.encode(m.d()));
            }
            dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            dVar.a("app_version_name", URLEncoder.encode(m.f(context)));
            dVar.a("orientation", URLEncoder.encode(m.d(context) + ""));
            dVar.a("screen_size", m.h(context) + "x" + m.i(context));
            com.mbridge.msdk.b.a b = b.a().b(a.e().h());
            if (b == null) {
                b = b.a().b();
            }
            if (b != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                        if (!TextUtils.isEmpty(m.k())) {
                            jSONObject.put("manufacturer", m.k());
                        }
                        if (m.h() != -1) {
                            jSONObject.put("sdkint", m.h());
                        }
                        if (!TextUtils.isEmpty(m.o(context))) {
                            jSONObject.put("is24H", m.o(context));
                        }
                        if (!TextUtils.isEmpty(m.l())) {
                            jSONObject.put("totalram", m.l());
                        }
                        if (!TextUtils.isEmpty(m.p(context))) {
                            jSONObject.put("totalmemory", m.p(context));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String a2 = l.a(jSONObject.toString());
                    if (!TextUtils.isEmpty(a2)) {
                        dVar.a("dvi", a2);
                    }
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
        return dVar;
    }

    public static com.mbridge.msdk.foundation.same.net.h.d a(Context context, String str) {
        com.mbridge.msdk.foundation.same.net.h.d a2 = a(context);
        a2.a("app_id", a.e().h() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                a2.a(DataSchemeDataSource.SCHEME_DATA, URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return a2;
    }

    public static com.mbridge.msdk.foundation.same.net.h.d a(String str, Context context, String str2) {
        com.mbridge.msdk.foundation.same.net.h.d a2 = a(context);
        a2.a("app_id", a.e().h() + "");
        a2.a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                a2.a(DataSchemeDataSource.SCHEME_DATA, URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        a2.a("m_sdk", "msdk");
        return a2;
    }

    public static com.mbridge.msdk.foundation.same.net.h.d a(String str, Context context) {
        com.mbridge.msdk.foundation.same.net.h.d a2 = a(context);
        a2.a("app_id", a.e().h() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                a2.a(DataSchemeDataSource.SCHEME_DATA, URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        a2.a("m_sdk", "msdk");
        return a2;
    }

    public static String a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                sb.append("&" + ((String) next.getKey()) + "=" + next.getValue());
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public static boolean a() {
        try {
            if (System.currentTimeMillis() - 86400000 > ((Long) w.b(a.e().g(), "privateAuthorityTimesTamp", 0L)).longValue()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b() {
        try {
            w.a(a.e().g(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(final Context context, String str, String str2, boolean z) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000047&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("hb=");
                    stringBuffer.append(z ? 1 : 0);
                    stringBuffer.append("&");
                    stringBuffer.append("reason=" + str);
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                        return;
                    }
                    final String stringBuffer2 = stringBuffer.toString();
                    if (context != null && !TextUtils.isEmpty(stringBuffer2)) {
                        new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, com.mbridge.msdk.foundation.same.net.g.d.c().a, a(stringBuffer2, context), new com.mbridge.msdk.foundation.same.report.d.b() {
                            public final void a(String str) {
                                q.d(d.a, str);
                            }

                            public final void b(String str) {
                                k kVar = new k();
                                kVar.c(stringBuffer2);
                                kVar.a(System.currentTimeMillis());
                                kVar.a(0);
                                kVar.b(ShareTarget.METHOD_POST);
                                kVar.a(com.mbridge.msdk.foundation.same.net.g.d.c().a);
                                com.mbridge.msdk.foundation.db.m.a((f) g.a(context)).a(kVar);
                                q.d(d.a, str);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                q.d(a, e.getMessage());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, boolean z) {
        if (context != null && list != null) {
            try {
                if (list.size() > 0 && !TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000048&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str + "&");
                    CampaignEx campaignEx = list.get(0);
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    if (z) {
                        stringBuffer.append("hb=");
                        stringBuffer.append(1);
                        stringBuffer.append("&");
                    }
                    String requestId = campaignEx.getRequestId();
                    if (!TextUtils.isEmpty(requestId)) {
                        stringBuffer.append("rid=");
                        stringBuffer.append(requestId);
                        stringBuffer.append("&");
                    }
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    if (!TextUtils.isEmpty(requestIdNotice)) {
                        stringBuffer.append("rid_n=");
                        stringBuffer.append(requestIdNotice);
                        stringBuffer.append("&");
                    }
                    StringBuilder sb = new StringBuilder("rtins_type=");
                    for (int i = 0; i < list.size(); i++) {
                        CampaignEx campaignEx2 = list.get(i);
                        if (i < list.size() - 1) {
                            sb.append(campaignEx2.getRtinsType());
                            sb.append(",");
                        } else {
                            sb.append(campaignEx2.getRtinsType());
                        }
                    }
                    stringBuffer.append(sb);
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str);
                    }
                }
            } catch (Throwable th) {
                q.d(a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000054&");
                    stringBuffer.append("network_type=");
                    stringBuffer.append(m.n(context));
                    stringBuffer.append("&");
                    stringBuffer.append("unit_id=");
                    stringBuffer.append(str);
                    stringBuffer.append("&");
                    stringBuffer.append("cid=");
                    stringBuffer.append(campaignEx.getId());
                    stringBuffer.append("&");
                    stringBuffer.append("reason=&");
                    stringBuffer.append("result=2&");
                    if (!TextUtils.isEmpty(str2)) {
                        stringBuffer.append(str2);
                    }
                    if (campaignEx.getAdType() == 287) {
                        stringBuffer.append("creative=");
                        stringBuffer.append(URLEncoder.encode(campaignEx.getendcard_url()));
                        stringBuffer.append("&");
                        stringBuffer.append("ad_type=3&");
                    } else if (campaignEx.getAdType() == 94) {
                        stringBuffer.append("creative=");
                        stringBuffer.append(URLEncoder.encode(campaignEx.getendcard_url()));
                        stringBuffer.append("&");
                        stringBuffer.append("ad_type=1&");
                    } else if (campaignEx.getAdType() == 296) {
                        stringBuffer.append("ad_type=5&");
                        stringBuffer.append("creative=");
                        stringBuffer.append(campaignEx.getCreativeId());
                        stringBuffer.append("&");
                    } else if (campaignEx.getAdType() == 297) {
                        stringBuffer.append("ad_type=6&");
                        stringBuffer.append("creative=");
                        stringBuffer.append(campaignEx.getCreativeId());
                        stringBuffer.append("&");
                    } else if (campaignEx.getAdType() == 298) {
                        stringBuffer.append("ad_type=7&");
                        stringBuffer.append("creative=");
                        stringBuffer.append(campaignEx.getCreativeId());
                        stringBuffer.append("&");
                    } else {
                        stringBuffer.append("creative=");
                        stringBuffer.append(URLEncoder.encode(campaignEx.getendcard_url()));
                        stringBuffer.append("&");
                        stringBuffer.append("ad_type=1&");
                    }
                    stringBuffer.append("devid=");
                    stringBuffer.append(m.i());
                    stringBuffer.append("&");
                    if (campaignEx != null) {
                        if (campaignEx.isBidCampaign()) {
                            stringBuffer.append("hb=1&");
                        }
                        stringBuffer.append("rid=");
                        stringBuffer.append(campaignEx.getRequestId());
                        stringBuffer.append("&");
                        stringBuffer.append("rid_n=");
                        stringBuffer.append(campaignEx.getRequestIdNotice());
                        stringBuffer.append("&");
                        stringBuffer.append("adspace_t=");
                        stringBuffer.append(campaignEx.getAdSpaceT());
                    }
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void b(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000054&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str + "&");
                    stringBuffer.append("reason=" + str2 + "&");
                    stringBuffer.append("result=1&");
                    stringBuffer.append("devid=" + m.i() + "&");
                    if (campaignEx != null) {
                        stringBuffer.append("cid=" + campaignEx.getId() + "&");
                        if (campaignEx.getAdType() == 287) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=3&");
                        } else if (campaignEx.getAdType() == 94) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        } else if (campaignEx.getAdType() == 296) {
                            stringBuffer.append("ad_type=5&");
                            stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
                        } else if (campaignEx.getAdType() == 297) {
                            stringBuffer.append("ad_type=6&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else if (campaignEx.getAdType() == 298) {
                            stringBuffer.append("ad_type=7&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        }
                        stringBuffer.append("rid=");
                        stringBuffer.append(campaignEx.getRequestId());
                        stringBuffer.append("&");
                        stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                    }
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i, String str3) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000073&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("reason=" + str3 + "&");
                    stringBuffer.append("result=" + i + "&");
                    stringBuffer.append("rid=");
                    stringBuffer.append(campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000074&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("type=" + i + "&");
                    stringBuffer.append("rid=");
                    stringBuffer.append(campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i, int i2) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000075&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("type=" + i + "&");
                    stringBuffer.append("rid=");
                    stringBuffer.append(campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                    stringBuffer.append("statue=" + i2 + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000076&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("reason=" + str3 + "&");
                    stringBuffer.append("result=" + i + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (a.a().c()) {
                        a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, com.mbridge.msdk.foundation.same.net.g.d.c().a, a(str, context, str2), new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void a(String str) {
                        q.d(d.a, str);
                    }

                    public final void b(String str) {
                        k kVar = new k();
                        kVar.c(str);
                        kVar.a(System.currentTimeMillis());
                        kVar.a(0);
                        kVar.b(ShareTarget.METHOD_POST);
                        kVar.a(com.mbridge.msdk.foundation.same.net.g.d.c().a);
                        com.mbridge.msdk.foundation.db.m.a((f) g.a(context)).a(kVar);
                        q.d(d.a, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                q.d(a, e.getMessage());
            }
        }
    }

    public static void a(String str) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(a.e().g());
        String str2 = "key=2000088&state=" + str + "&network_type=" + m.n(a.e().g());
        q.d(a, str2);
        aVar.c(0, com.mbridge.msdk.foundation.same.net.g.d.c().a, a(str2, a.e().g(), ""), (e) null);
    }

    public static void a(int i, String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(a.e().g());
            aVar.c(0, com.mbridge.msdk.foundation.same.net.g.d.c().a, a("key=" + "2000080" + "&" + "reason=" + str2 + "&" + "ad_type=" + i + "&" + "url=" + URLEncoder.encode(str, "utf-8"), a.e().g(), ""), (e) null);
        } catch (Exception e) {
            q.d(a, e.getMessage());
        }
    }

    public static void b(String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(a.e().g());
            StringBuilder sb = new StringBuilder();
            sb.append("key=");
            sb.append("2000090");
            sb.append("&");
            sb.append("reason=");
            sb.append(TextUtils.isEmpty(str) ? "" : str);
            sb.append("&");
            sb.append("result=");
            sb.append(!TextUtils.isEmpty(str));
            aVar.c(0, com.mbridge.msdk.foundation.same.net.g.d.c().a, a(sb.toString(), a.e().g(), ""), (e) null);
        } catch (Exception e) {
            q.d(a, e.getMessage());
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i, int i2, String str2, int i3, int i4, int i5) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(a.e().g());
            StringBuilder sb = new StringBuilder();
            sb.append("key");
            sb.append("=");
            sb.append(URLEncoder.encode("2000094", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb.append("&");
            sb.append("cid");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getId(), "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("video_prg");
            sb.append("=");
            sb.append(i);
            sb.append("&");
            sb.append("phase");
            sb.append("=");
            sb.append(i2);
            sb.append("&");
            sb.append("feedback_content");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("feedback_close");
            sb.append("=");
            sb.append(i3);
            sb.append("&");
            sb.append("type");
            sb.append("=");
            sb.append(i5);
            sb.append("&");
            sb.append("ad_type");
            sb.append("=");
            sb.append(i4);
            sb.append("&");
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(m.n(a.e().g())), "utf-8"));
            if (i3 == 1) {
                sb.append("&");
                sb.append("campaign");
                sb.append("=");
                sb.append(URLEncoder.encode(CampaignEx.campaignToJsonObject(campaignEx).toString(), "utf-8"));
            }
            if (MBridgeConstans.DEBUG && i3 == 1) {
                String str3 = a;
                q.d(str3, "2000094:" + sb);
            }
            if (a.a().c()) {
                a.a().a(sb.toString());
                return;
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.g.d.c().a, a(sb.toString(), a.e().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() {
                public final void a(String str) {
                    q.a("", "FLBClick REPORT SUCCESS");
                }

                public final void b(String str) {
                    q.a("", "FLBClick REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
