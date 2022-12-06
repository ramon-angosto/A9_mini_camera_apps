package com.mbridge.msdk.advanced.d;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.common.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.b;
import java.net.URLEncoder;

/* compiled from: NativeAdvancedReport */
public final class a {
    public static void a(Context context, CampaignEx campaignEx, String str, String str2, long j, int i) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isMraid()) {
                    m mVar = new m();
                    mVar.k(campaignEx.getRequestId());
                    mVar.l(campaignEx.getRequestIdNotice());
                    mVar.n(campaignEx.getId());
                    mVar.d(i);
                    mVar.q(String.valueOf(System.currentTimeMillis() - j));
                    mVar.f("");
                    mVar.p(str2);
                    mVar.h("8");
                    mVar.a(m.a);
                    b.b(mVar, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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
            sb.append("click_url");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g())), "utf-8"));
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(sb.toString());
                return;
            }
            aVar.c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(sb.toString(), com.mbridge.msdk.foundation.controller.a.e().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() {
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

    public static void a(c cVar, String str) {
        if (cVar != null) {
            cVar.a("2000067");
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(cVar.b());
            } else {
                b.a(cVar.b(), com.mbridge.msdk.foundation.controller.a.e().g(), str);
            }
        }
    }

    public static void b(c cVar, String str) {
        if (cVar != null) {
            cVar.a("2000068");
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(cVar.b());
            } else {
                b.a(cVar.b(), com.mbridge.msdk.foundation.controller.a.e().g(), str);
            }
        }
    }
}
