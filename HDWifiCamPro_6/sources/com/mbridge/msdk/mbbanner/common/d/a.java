package com.mbridge.msdk.mbbanner.common.d;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.m;
import java.net.URLEncoder;

/* compiled from: BannerReport */
public final class a {
    public static void a(String str, CampaignEx campaignEx, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g());
            StringBuilder sb = new StringBuilder();
            if (campaignEx.isBidCampaign()) {
                sb.append("hb=");
                sb.append(1);
                sb.append("&");
            }
            sb.append("key");
            sb.append("=");
            sb.append(URLEncoder.encode("2000070", "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
            sb.append("&");
            sb.append("cid");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getId(), "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("click_url");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(m.n(com.mbridge.msdk.foundation.controller.a.e().g())), "utf-8"));
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(sb.toString());
                return;
            }
            aVar.c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(sb.toString(), com.mbridge.msdk.foundation.controller.a.e().g(), str), new b() {
                public final void a(String str) {
                }

                public final void b(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void a(com.mbridge.msdk.mbbanner.common.a.a aVar, String str) {
        if (aVar != null) {
            aVar.a("2000068");
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(aVar.b());
            } else {
                com.mbridge.msdk.foundation.same.report.b.a(aVar.b(), com.mbridge.msdk.foundation.controller.a.e().g(), str);
            }
        }
    }
}
