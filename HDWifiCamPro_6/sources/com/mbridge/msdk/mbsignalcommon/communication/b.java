package com.mbridge.msdk.mbsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;

/* compiled from: CommonSignalCommunicatioImpUtils */
public class b {
    public static final String a = b.class.getSimpleName();
    public static int b = 0;
    public static int c = 1;

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        j a2 = j.a((f) g.a(a.e().g()));
                        if (a2 != null) {
                            if (!a2.a(parseCampaignWithBackData.getId())) {
                                com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                                fVar.a(parseCampaignWithBackData.getId());
                                fVar.a(parseCampaignWithBackData.getFca());
                                fVar.b(parseCampaignWithBackData.getFcb());
                                fVar.d(0);
                                fVar.c(1);
                                fVar.a(System.currentTimeMillis());
                                a2.a(fVar);
                            } else {
                                a2.b(parseCampaignWithBackData.getId());
                            }
                        }
                        b.a(parseCampaignWithBackData.getCampaignUnitId(), parseCampaignWithBackData);
                    } catch (Throwable th) {
                        q.a(b.a, th.getMessage(), th);
                    }
                }
            }).start();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", b);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", "");
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject3);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e) {
            a(obj, e.getMessage());
            q.a(a, e.getMessage());
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public static String a(float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.e, u.a(a.e().g(), f));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f, u.a(a.e().g(), f2));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.h, 0);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.i, a.e().g().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.j, (double) u.d(a.e().g()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.g, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            q.d(a, "code to string is error");
            return "";
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", c);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            q.a(a, e.getMessage());
        }
    }

    static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (d.g != null && !TextUtils.isEmpty(campaignEx.getId())) {
            d.a(str, campaignEx, "banner");
        }
    }
}
