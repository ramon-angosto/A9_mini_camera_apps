package com.mbridge.msdk.mbnative.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbnative.c.a;
import com.mbridge.msdk.mbnative.controller.NativeController;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: NativeReportUtils */
public final class b {
    public static synchronized void a(CampaignEx campaignEx, Context context, String str, a aVar) {
        synchronized (b.class) {
            if (!campaignEx.isReport()) {
                campaignEx.setReport(true);
                a(campaignEx, context, str);
                c(campaignEx, context, str);
                List<String> a = a(campaignEx);
                if (a != null) {
                    if (a.size() != 0) {
                        for (int i = 0; i < a.size(); i++) {
                            String str2 = a.get(i);
                            if (!TextUtils.isEmpty(str2)) {
                                com.mbridge.msdk.click.a.a(context, campaignEx, str, str2, false, false);
                            }
                        }
                    }
                }
                b(campaignEx, context, str);
            }
            if (aVar != null && !campaignEx.isCallBackImpression()) {
                campaignEx.setCallBackImpression(true);
                aVar.onLoggingImpression(campaignEx.getType());
            }
        }
    }

    private static synchronized void a(final CampaignEx campaignEx, final Context context, String str) {
        synchronized (b.class) {
            com.mbridge.msdk.foundation.controller.a.e().a(context);
            if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            j.a((f) g.a(context)).b(campaignEx.getId());
                        } catch (Exception unused) {
                            q.d("NativeReportUtils", "campain can't insert db");
                        }
                    }
                }).start();
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true);
            }
            if (!(TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().i() == null)) {
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().i(), false, false);
            }
        }
    }

    private static synchronized void b(CampaignEx campaignEx, Context context, String str) {
        synchronized (b.class) {
            if (campaignEx != null) {
                try {
                    List<String> pv_urls = campaignEx.getPv_urls();
                    if (pv_urls != null && pv_urls.size() > 0) {
                        for (String a : pv_urls) {
                            com.mbridge.msdk.click.a.a(context, campaignEx, str, a, false, true);
                        }
                    }
                } catch (Throwable th) {
                    q.a("NativeReportUtils", th.getMessage());
                }
            }
        }
        return;
    }

    private static synchronized void c(CampaignEx campaignEx, Context context, String str) {
        synchronized (b.class) {
            if (!TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) && NativeController.c != null && !NativeController.c.containsKey(campaignEx.getOnlyImpressionURL())) {
                NativeController.c.put(campaignEx.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true);
            }
        }
    }

    private static List<String> a(CampaignEx campaignEx) {
        ArrayList arrayList = new ArrayList();
        if (campaignEx == null) {
            return arrayList;
        }
        String ad_url_list = campaignEx.getAd_url_list();
        if (TextUtils.isEmpty(ad_url_list)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(ad_url_list);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add((String) jSONArray.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
