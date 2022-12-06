package com.mbridge.msdk.video.module.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.b;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.out.MBConfiguration;
import com.vungle.warren.VungleApiClient;
import org.json.JSONObject;

/* compiled from: VideoViewRequest */
public final class a extends b {
    public a(Context context) {
        super(context);
    }

    public final void a(String str, d dVar) {
        super.a(str, dVar);
        dVar.a("platform", "1");
        dVar.a("os_version", Build.VERSION.RELEASE);
        dVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, m.k(this.a));
        dVar.a("app_version_name", m.f(this.a));
        dVar.a("app_version_code", m.e(this.a) + "");
        dVar.a("orientation", m.d(this.a) + "");
        dVar.a("model", m.a());
        dVar.a("brand", m.c());
        dVar.a(VungleApiClient.GAID, "");
        dVar.a("gaid2", m.j());
        int n = m.n(this.a);
        dVar.a("network_type", n + "");
        dVar.a("network_str", m.a(this.a, n) + "");
        dVar.a("language", m.c(this.a));
        dVar.a("timezone", m.e());
        dVar.a("useragent", m.d());
        dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        dVar.a("screen_size", m.h(this.a) + "x" + m.i(this.a));
        if (com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String a = l.a(jSONObject.toString());
                    if (!TextUtils.isEmpty(a)) {
                        dVar.a("dvi", a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
