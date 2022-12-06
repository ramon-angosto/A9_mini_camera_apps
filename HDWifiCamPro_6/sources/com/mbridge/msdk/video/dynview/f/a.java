package com.mbridge.msdk.video.dynview.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.y;

/* compiled from: MOfferReport */
public class a {
    /* access modifiers changed from: private */
    public static final String a = a.class.getName();

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000091&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.k)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.k + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.l + "&");
                    }
                    stringBuffer.append("hb=0&");
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid_n=");
                        stringBuffer.append(str3);
                        stringBuffer.append("&");
                    }
                    stringBuffer.append("reason=" + str);
                    if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null)) {
                        stringBuffer.append("&view=");
                        stringBuffer.append(u.i(campaignEx.getRewardTemplateMode().e()));
                    }
                    if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                        com.mbridge.msdk.foundation.same.report.a.a().a(stringBuffer.toString());
                        return;
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (context != null && !TextUtils.isEmpty(stringBuffer2)) {
                        new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(stringBuffer2, context), new b() {
                            public final void a(String str) {
                                q.d(a.a, str);
                            }

                            public final void b(String str) {
                                q.d(a.a, str);
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

    public static void a(CampaignUnit campaignUnit, int i, int i2, String str) {
        String impressionURL;
        if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && campaignUnit.getAds().get(i) != null) {
            String a2 = y.a(campaignUnit.getAds().get(i).getendcard_url(), "mof_testuid");
            if (TextUtils.isEmpty(a2)) {
                a2 = y.a(campaignUnit.getAds().get(i).getendcard_url(), "mof_uid");
            }
            String str2 = TextUtils.isEmpty(a2) ? str : a2;
            if (i2 == 0) {
                impressionURL = campaignUnit.getAds().get(i).getImpressionURL();
            } else if (i2 != 1) {
                impressionURL = "";
            } else {
                impressionURL = campaignUnit.getAds().get(i).getOnlyImpressionURL();
            }
            String str3 = impressionURL;
            if (!TextUtils.isEmpty(str3)) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignUnit.getAds().get(i), str2, str3, false, true);
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str) {
        if (context != null && campaignEx != null) {
            if (!(campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().e() == null)) {
                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().e(), false, false);
            }
            new com.mbridge.msdk.click.a(context, str).a(campaignEx);
        }
    }
}
