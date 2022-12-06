package com.mbridge.msdk.mbbanner.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;

/* compiled from: BannerV3Params */
public class d {
    private static final String a = d.class.getSimpleName();

    public static com.mbridge.msdk.foundation.same.net.h.d a(boolean z, Context context, String str, String str2, int i, b bVar) {
        String h = a.e().h();
        String md5 = SameMD5.getMD5(a.e().h() + a.e().i());
        String b = u.b(context, str);
        String a2 = com.mbridge.msdk.foundation.same.a.d.a(str, "banner");
        String closeIds = BannerUtils.getCloseIds(str);
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d();
        b.a(dVar, "app_id", h);
        b.a(dVar, MBridgeConstans.PROPERTIES_UNIT_ID, str);
        if (!TextUtils.isEmpty(bVar.d())) {
            b.a(dVar, MBridgeConstans.PLACEMENT_ID, bVar.d());
        }
        b.a(dVar, "sign", md5);
        b.a(dVar, "only_impression", "1");
        b.a(dVar, "ping_mode", "1");
        b.a(dVar, com.mbridge.msdk.foundation.same.net.h.d.c, b);
        b.a(dVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, "1");
        b.a(dVar, com.mbridge.msdk.foundation.same.net.h.d.a, str2);
        b.a(dVar, "ad_type", "296");
        b.a(dVar, "offset", i + "");
        b.a(dVar, com.mbridge.msdk.foundation.same.net.h.d.b, a2);
        b.a(dVar, "close_id", closeIds);
        b.a(dVar, CampaignUnit.JSON_KEY_UNIT_SIZE, bVar.a() + "");
        b.a(dVar, "refresh_time", bVar.b() + "");
        if (!TextUtils.isEmpty(bVar.c())) {
            b.a(dVar, "token", bVar.c() + "");
        }
        return dVar;
    }
}
