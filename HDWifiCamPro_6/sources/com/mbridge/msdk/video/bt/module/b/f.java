package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.q;
import java.net.URLEncoder;

/* compiled from: RewardReport */
public class f {
    /* access modifiers changed from: private */
    public static final String a = f.class.getName();

    private static void a(final Context context, final String str, String str2) {
        if (a.e().g() != null) {
            context = a.e().g();
        }
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(str, context, str2), new b() {
                    public final void a(String str) {
                        q.d(f.a, str);
                    }

                    public final void b(String str) {
                        k kVar = new k();
                        kVar.c(str);
                        kVar.a(System.currentTimeMillis());
                        kVar.a(0);
                        kVar.b(ShareTarget.METHOD_POST);
                        kVar.a(d.c().a);
                        m.a((com.mbridge.msdk.foundation.db.f) g.a(context)).a(kVar);
                        q.d(f.a, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                q.d(a, e.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000054&");
                    stringBuffer.append("network_type=" + com.mbridge.msdk.foundation.tools.m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("reason=&");
                    stringBuffer.append("result=2&");
                    if (campaignEx == null || campaignEx.getAdType() != 287) {
                        if (campaignEx != null) {
                            if (campaignEx.getAdType() == 94) {
                                stringBuffer.append("ad_type=1&");
                            }
                        }
                        stringBuffer.append("ad_type=1&");
                    } else {
                        stringBuffer.append("ad_type=3&");
                    }
                    stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                    stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.m.i() + "&");
                    if (campaignEx != null) {
                        stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                        stringBuffer.append("&adspace_t=" + campaignEx.getAdSpaceT());
                    }
                    if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                        com.mbridge.msdk.foundation.same.report.a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null && campaignEx != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000054&");
                    stringBuffer.append("network_type=" + com.mbridge.msdk.foundation.tools.m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("reason=" + str2 + "&");
                    stringBuffer.append("result=1&");
                    stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                    stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.m.i() + "&");
                    if (campaignEx == null || campaignEx.getAdType() != 287) {
                        if (campaignEx != null) {
                            if (campaignEx.getAdType() == 94) {
                                stringBuffer.append("ad_type=1&");
                            }
                        }
                        stringBuffer.append("ad_type=1&");
                    } else {
                        stringBuffer.append("ad_type=3&");
                    }
                    if (campaignEx != null) {
                        stringBuffer.append("rid=");
                        stringBuffer.append(campaignEx.getRequestId());
                        stringBuffer.append("&");
                        stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                        stringBuffer.append("&");
                        stringBuffer.append("adspace_t=" + campaignEx.getAdSpaceT());
                    }
                    if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                        com.mbridge.msdk.foundation.same.report.a.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
