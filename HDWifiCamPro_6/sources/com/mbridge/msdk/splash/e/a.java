package com.mbridge.msdk.splash.e;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.b;
import com.mbridge.msdk.foundation.tools.q;
import java.net.URLEncoder;

/* compiled from: SplashReport */
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
                    mVar.h("6");
                    mVar.a(m.a);
                    b.b(mVar, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.isMraid()) {
            m mVar = new m("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g()));
            mVar.a(m.a);
            b.b(mVar, com.mbridge.msdk.foundation.controller.a.e().g(), str);
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

    public static void a(CampaignEx campaignEx, String str, String str2) {
        a(campaignEx, str, 2, str2);
    }

    public static void a(CampaignEx campaignEx, String str) {
        a(campaignEx, "", 1, str);
    }

    private static void a(CampaignEx campaignEx, String str, int i, String str2) {
        a(com.mbridge.msdk.splash.a.b.a().c(campaignEx.getId()).b(str2).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).f(str).b(i).a(campaignEx.isBidCampaign()), str2);
    }

    private static void a(com.mbridge.msdk.splash.a.b bVar, String str) {
        if (bVar != null) {
            bVar.a("2000068");
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(bVar.b());
            } else {
                b.a(bVar.b(), com.mbridge.msdk.foundation.controller.a.e().g(), str);
            }
        }
    }

    public static void a(com.mbridge.msdk.splash.a.b bVar, String str, int i) {
        if (bVar != null) {
            bVar.a("2000069");
            bVar.a(i);
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(bVar.b());
            } else {
                b.a(bVar.b(), com.mbridge.msdk.foundation.controller.a.e().g(), str);
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().e() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().e(), false, false);
        }
    }

    public static void b(CampaignEx campaignEx, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g());
            StringBuilder sb = new StringBuilder();
            sb.append("key");
            sb.append("=");
            sb.append(URLEncoder.encode("2000092", "utf-8"));
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
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g())), "utf-8"));
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(sb.toString());
                return;
            }
            aVar.c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(sb.toString(), com.mbridge.msdk.foundation.controller.a.e().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() {
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
