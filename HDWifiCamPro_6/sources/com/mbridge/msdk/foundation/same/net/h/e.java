package com.mbridge.msdk.foundation.same.net.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.s;
import com.vungle.warren.VungleApiClient;
import org.json.JSONObject;

/* compiled from: CommonRequestParamsForAdd */
public final class e {
    private static String a = "";
    private static String b = "";

    public static void a(d dVar, Context context) {
        if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            a.a();
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DNT, 0) == 1) {
                dVar.a("dnt", "1");
            }
        }
        if (a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            String str = d.f;
            dVar.a(str, s.b() + "");
            String str2 = d.g;
            dVar.a(str2, s.a() + "");
            dVar.a(d.d, m.m());
        }
        dVar.a("pkg_source", m.a(m.k(context), context));
        if (com.mbridge.msdk.foundation.controller.a.e().k() != null) {
            dVar.a("web_env", com.mbridge.msdk.foundation.controller.a.e().k().toString());
        }
        if (Build.VERSION.SDK_INT > 18) {
            dVar.a("http_req", "2");
        }
        a(dVar, true);
        e(dVar);
        d(dVar);
        com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 == null) {
            b2 = b.a().b();
        }
        if (b2.af()) {
            dVar.a("gdpr_consent", a.a().e() + "");
        }
    }

    public static void a(d dVar) {
        dVar.a("api_version", com.mbridge.msdk.foundation.same.a.a);
    }

    public static void b(d dVar) {
        a(dVar, false);
        e(dVar);
        d(dVar);
    }

    private static void d(d dVar) {
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.k)) {
                com.mbridge.msdk.foundation.same.a.k = com.mbridge.msdk.foundation.a.a.a.a().b("b");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.k)) {
                dVar.a("b", com.mbridge.msdk.foundation.same.a.k);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                com.mbridge.msdk.foundation.same.a.l = com.mbridge.msdk.foundation.a.a.a.a().b("c");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                dVar.a("c", com.mbridge.msdk.foundation.same.a.l);
            }
        } catch (Exception e) {
            q.d("CommonRequestParamsForAdd", e.getMessage());
        }
    }

    private static void e(d dVar) {
        int p = m.p();
        if (p != -1) {
            dVar.a("unknown_source", p + "");
        }
    }

    private static void a(d dVar, boolean z) {
        com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 != null) {
            if (!TextUtils.isEmpty(b2.c()) && z) {
                dVar.a("a_stid", b2.c());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("dmt", m.o() + "");
                    jSONObject.put("dmf", m.n());
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    if (!jSONObject.equals(a)) {
                        b = l.a(jSONObject.toString());
                    }
                    if (!TextUtils.isEmpty(b)) {
                        dVar.a("dvi", b);
                    }
                }
            } catch (Exception e) {
                q.d("CommonRequestParamsForAdd", e.getMessage());
            }
        }
    }

    public static void c(d dVar) {
        if (dVar != null) {
            if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a("model");
                dVar.a("brand");
                dVar.a("screen_size");
                dVar.a("sub_ip");
                dVar.a("network_type");
                dVar.a("useragent");
                dVar.a("ua");
                dVar.a("language");
                dVar.a("network_str");
                dVar.a("os_version");
                dVar.a("country_code");
            }
            if (!a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                dVar.a(d.f);
                dVar.a(d.g);
                dVar.a("power_rate");
                dVar.a("charging");
                dVar.a("timezone");
            }
            if (!a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                dVar.a(VungleApiClient.GAID);
                dVar.a("gaid2");
            }
        }
    }
}
