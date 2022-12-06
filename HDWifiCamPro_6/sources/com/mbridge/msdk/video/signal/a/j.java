package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.b;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.w;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSCommon */
public final class j extends c {
    private Activity n;
    private String o;
    private String p;
    private CampaignEx q;
    private List<CampaignEx> r;
    private int s;
    private String t = "";
    private String u = "";
    private boolean v = false;
    private boolean w = false;

    public final void a(CampaignEx campaignEx) {
        this.q = campaignEx;
    }

    public final void a(List<CampaignEx> list) {
        this.r = list;
    }

    public final void c(boolean z) {
        this.v = z;
    }

    public j(Activity activity, CampaignEx campaignEx) {
        this.n = activity;
        this.q = campaignEx;
    }

    public j(Activity activity, CampaignEx campaignEx, List<CampaignEx> list) {
        this.n = activity;
        this.q = campaignEx;
        this.r = list;
    }

    public final void n() {
        this.o = "";
    }

    public final void c(String str) {
        this.t = str;
    }

    public final void d(String str) {
        this.u = str;
    }

    public final int o() {
        return this.s;
    }

    public final void i(int i) {
        this.s = i;
    }

    public final void d(boolean z) {
        this.w = z;
    }

    public final String c() {
        this.l.a();
        this.a = true;
        if (TextUtils.isEmpty(this.o)) {
            this.o = p();
        }
        return this.o;
    }

    private String p() {
        JSONObject jSONObject = new JSONObject();
        b bVar = new b(a.e().g());
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.t);
            jSONObject2.put("rootViewInstanceId", this.u);
            jSONObject2.put("isRootTemplateWebView", this.v);
            jSONObject.put("sdk_info", "MAL_16.0.11,3.0.1");
            jSONObject2.put("playVideoMute", this.m);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.a());
            JSONArray jSONArray = new JSONArray();
            if (this.r == null || this.r.size() <= 0) {
                jSONArray.put(CampaignEx.campaignToJsonObject(this.q));
            } else {
                for (CampaignEx next : this.r) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(next, next.isReady(), b(next)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", y());
            String c = com.mbridge.msdk.b.b.a().c(a.e().h());
            if (!TextUtils.isEmpty(c)) {
                JSONObject jSONObject3 = new JSONObject(c);
                a(jSONObject3);
                String d = com.mbridge.msdk.b.b.a().d(this.i);
                if (!TextUtils.isEmpty(d)) {
                    jSONObject3.put("ivreward", new JSONObject(d));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", z());
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
            }
            jSONObject.put("rw_plus", this.w ? "1" : MBridgeConstans.ENDCARD_URL_TYPE_PL);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void a(JSONObject jSONObject) {
        try {
            Context g = a.e().g();
            String obj = w.b(g, "MBridge_ConfirmTitle" + this.i, "").toString();
            String obj2 = w.b(g, "MBridge_ConfirmContent" + this.i, "").toString();
            String obj3 = w.b(g, "MBridge_CancelText" + this.i, "").toString();
            String obj4 = w.b(g, "MBridge_ConfirmText" + this.i, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put("confirm_title", obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put("confirm_description", obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put("confirm_t", obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_play", obj4);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_rv", obj4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:38|39|40|41|(1:43)|44|45|(2:48|46)|56|49|50|61) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0104 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010e A[Catch:{ JSONException -> 0x0125 }, LOOP:1: B:46:0x0108->B:48:0x010e, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.entity.CampaignEx a(java.lang.String r8, com.mbridge.msdk.foundation.entity.CampaignEx r9) {
        /*
            r7 = this;
            java.lang.String r0 = "deep_link"
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0009
            return r9
        L_0x0009:
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0015
            if (r9 == 0) goto L_0x0012
            goto L_0x0015
        L_0x0012:
            r9 = 0
            goto L_0x0129
        L_0x0015:
            java.lang.String r1 = "notice"
            boolean r1 = r8.contains(r1)
            if (r1 != 0) goto L_0x00f0
            org.json.JSONObject r0 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r9)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r1 != 0) goto L_0x0028
            r1 = r9
        L_0x0028:
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r2 != 0) goto L_0x00e4
            r7.a((org.json.JSONObject) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r8 = com.mbridge.msdk.foundation.same.a.g     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            org.json.JSONObject r8 = r0.optJSONObject(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r0 = "-999"
            if (r8 == 0) goto L_0x0073
            android.app.Activity r0 = r7.n     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.e     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r2 = r2.intValue()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            float r2 = (float) r2     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r0 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r0, (float) r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            android.app.Activity r2 = r7.n     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r3 = r8.getString(r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r3 = r3.intValue()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            float r3 = (float) r3     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r2, (float) r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            goto L_0x0074
        L_0x0073:
            r2 = r0
        L_0x0074:
            java.lang.String r3 = r1.getClickURL()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r0 = com.mbridge.msdk.click.b.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r1.setClickURL(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r0 = r1.getNoticeUrl()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r8 == 0) goto L_0x00e4
            java.util.Iterator r2 = r8.keys()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r3.<init>()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
        L_0x008e:
            boolean r4 = r2.hasNext()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r4 == 0) goto L_0x00d2
            java.lang.String r4 = "&"
            r3.append(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Object r4 = r2.next()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r5 = r8.optString(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.e     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r6 != 0) goto L_0x00b3
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r6 == 0) goto L_0x00c6
        L_0x00b3:
            android.app.Activity r6 = r7.n     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            float r5 = (float) r5     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r5 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r6, (float) r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
        L_0x00c6:
            r3.append(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r4 = "="
            r3.append(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r3.append(r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            goto L_0x008e
        L_0x00d2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r8.<init>()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r8.append(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r8.append(r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r1.setNoticeUrl(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
        L_0x00e4:
            r9 = r1
            goto L_0x0129
        L_0x00e6:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x0129
        L_0x00eb:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x0129
        L_0x00f0:
            org.json.JSONObject r1 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r9)     // Catch:{ JSONException -> 0x0125 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0125 }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x0125 }
            boolean r8 = r2.has(r0)     // Catch:{ Exception -> 0x0104 }
            if (r8 != 0) goto L_0x0104
            java.lang.String r8 = ""
            r1.put(r0, r8)     // Catch:{ Exception -> 0x0104 }
        L_0x0104:
            java.util.Iterator r8 = r2.keys()     // Catch:{ JSONException -> 0x0125 }
        L_0x0108:
            boolean r0 = r8.hasNext()     // Catch:{ JSONException -> 0x0125 }
            if (r0 == 0) goto L_0x011c
            java.lang.Object r0 = r8.next()     // Catch:{ JSONException -> 0x0125 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0125 }
            java.lang.String r3 = r2.getString(r0)     // Catch:{ JSONException -> 0x0125 }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x0125 }
            goto L_0x0108
        L_0x011c:
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r1)     // Catch:{ JSONException -> 0x0125 }
            r7.a((org.json.JSONObject) r1, (com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ JSONException -> 0x0125 }
            r9 = r8
            goto L_0x0129
        L_0x0125:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0129:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.j.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.foundation.entity.CampaignEx");
    }

    private void a(JSONObject jSONObject, CampaignEx campaignEx) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (!TextUtils.isEmpty(optString)) {
                campaignEx.setCampaignUnitId(optString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        com.mbridge.msdk.foundation.tools.q.a("DefaultJSCommon", "INSTALL", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ac, code lost:
        com.mbridge.msdk.foundation.tools.q.a("DefaultJSCommon", r6.getMessage(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x000d, B:29:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008a A[Catch:{ all -> 0x007e, all -> 0x00ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b A[Catch:{ all -> 0x007e, all -> 0x00ab }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void click(int r6, java.lang.String r7) {
        /*
            r5 = this;
            super.click(r6, r7)
            java.lang.String r0 = "DefaultJSCommon"
            r1 = 1
            if (r6 == r1) goto L_0x003f
            r2 = 3
            if (r6 == r2) goto L_0x000d
            goto L_0x00b3
        L_0x000d:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00ab }
            if (r6 == 0) goto L_0x0021
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00ab }
            int r6 = r6.getCbd()     // Catch:{ all -> 0x00ab }
            r2 = -2
            if (r6 <= r2) goto L_0x0021
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00ab }
            int r6 = r6.getCbd()     // Catch:{ all -> 0x00ab }
            goto L_0x002d
        L_0x0021:
            com.mbridge.msdk.videocommon.d.c r6 = r5.j     // Catch:{ all -> 0x00ab }
            if (r6 == 0) goto L_0x002c
            com.mbridge.msdk.videocommon.d.c r6 = r5.j     // Catch:{ all -> 0x00ab }
            int r6 = r6.n()     // Catch:{ all -> 0x00ab }
            goto L_0x002d
        L_0x002c:
            r6 = r1
        L_0x002d:
            r2 = -1
            if (r6 != r2) goto L_0x003a
            com.mbridge.msdk.video.signal.a.c$b r6 = new com.mbridge.msdk.video.signal.a.c$b     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.video.signal.c$a r2 = r5.l     // Catch:{ all -> 0x00ab }
            r6.<init>(r5, r2)     // Catch:{ all -> 0x00ab }
            r5.a((com.mbridge.msdk.video.signal.c.a) r6)     // Catch:{ all -> 0x00ab }
        L_0x003a:
            r5.click(r1, r7)     // Catch:{ all -> 0x00ab }
            goto L_0x00b3
        L_0x003f:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00ab }
            r2 = 0
            if (r6 != 0) goto L_0x005a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6 = r5.r     // Catch:{ all -> 0x00ab }
            if (r6 == 0) goto L_0x005a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6 = r5.r     // Catch:{ all -> 0x00ab }
            int r6 = r6.size()     // Catch:{ all -> 0x00ab }
            if (r6 <= 0) goto L_0x005a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6 = r5.r     // Catch:{ all -> 0x00ab }
            java.lang.Object r6 = r6.get(r2)     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ all -> 0x00ab }
            r5.q = r6     // Catch:{ all -> 0x00ab }
        L_0x005a:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00ab }
            if (r6 != 0) goto L_0x005f
            return
        L_0x005f:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.a((java.lang.String) r7, (com.mbridge.msdk.foundation.entity.CampaignEx) r6)     // Catch:{ all -> 0x00ab }
            java.lang.String r7 = r6.getNoticeUrl()     // Catch:{ all -> 0x00ab }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.h     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.getQueryParameter(r3)     // Catch:{ all -> 0x007e }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x007e }
            if (r3 != 0) goto L_0x0084
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ all -> 0x007e }
            goto L_0x0085
        L_0x007e:
            r7 = move-exception
            java.lang.String r3 = "INSTALL"
            com.mbridge.msdk.foundation.tools.q.a(r0, r3, r7)     // Catch:{ all -> 0x00ab }
        L_0x0084:
            r7 = r2
        L_0x0085:
            com.mbridge.msdk.video.signal.c$a r3 = r5.l     // Catch:{ all -> 0x00ab }
            r4 = 2
            if (r7 != r4) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r1 = r2
        L_0x008c:
            r3.a(r1)     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.click.a r7 = r5.q()     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.video.signal.c$a r1 = r5.l     // Catch:{ all -> 0x00ab }
            r7.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r1)     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.click.a r7 = r5.q()     // Catch:{ all -> 0x00ab }
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r6)     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.foundation.controller.a r7 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x00ab }
            android.content.Context r7 = r7.g()     // Catch:{ all -> 0x00ab }
            com.mbridge.msdk.video.module.b.a.d(r7, r6)     // Catch:{ all -> 0x00ab }
            goto L_0x00b3
        L_0x00ab:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r7, r6)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.j.click(int, java.lang.String):void");
    }

    public final void handlerH5Exception(int i, String str) {
        super.handlerH5Exception(i, str);
        try {
            this.l.a(i, str);
        } catch (Throwable th) {
            q.a("DefaultJSCommon", th.getMessage(), th);
        }
    }

    public final void a(int i, String str) {
        super.a(i, str);
        if (i == 2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT);
                String optString2 = jSONObject.optString("template", "-1");
                String optString3 = jSONObject.optString(TtmlNode.TAG_LAYOUT, "-1");
                String optString4 = jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
                int n2 = m.n(this.n.getApplication());
                p.a((f) g.a((Context) this.n.getApplication())).a(new com.mbridge.msdk.foundation.entity.m("2000039", optString, optString2, optString3, optString4, this.q.getId(), n2, m.a((Context) this.n.getApplication(), n2)));
            } catch (Throwable th) {
                q.a("DefaultJSCommon", th.getMessage(), th);
            }
        }
    }

    public final void f() {
        super.f();
        if (this.l != null) {
            this.l.b();
        }
    }

    public final void d() {
        super.d();
        try {
            if (this.n != null) {
                this.n.finish();
            }
        } catch (Throwable th) {
            q.a("DefaultJSCommon", th.getMessage(), th);
        }
    }

    private com.mbridge.msdk.click.a q() {
        if (this.k == null) {
            this.k = new com.mbridge.msdk.click.a(a.e().g(), this.i);
        }
        return this.k;
    }

    public final String g(int i) {
        switch (i) {
            case 1:
                return s().toString();
            case 2:
                return t().toString();
            case 3:
                return u().toString();
            case 4:
                return v().toString();
            case 5:
                return w().toString();
            case 6:
                return x().toString();
            default:
                return r().toString();
        }
    }

    private JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        b bVar = new b(a.e().g());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.m);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.a());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(CampaignEx.campaignToJsonObject(this.q));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", y());
            String c = com.mbridge.msdk.b.b.a().c(a.e().h());
            if (!TextUtils.isEmpty(c)) {
                JSONObject jSONObject3 = new JSONObject(c);
                a(jSONObject3);
                String d = com.mbridge.msdk.b.b.a().d(this.i);
                if (!TextUtils.isEmpty(d)) {
                    jSONObject3.put("ivreward", d);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", z());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_info", "MAL_16.0.11,3.0.1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            String c = com.mbridge.msdk.b.b.a().c(a.e().h());
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("appSetting", new JSONObject(c));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.j != null) {
                jSONObject.put("unitSetting", this.j.D());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", new b(a.e().g()).a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.m);
            jSONObject2.put("instanceId", this.t);
            jSONObject.put("sdkSetting", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject y() {
        return this.j != null ? this.j.D() : new JSONObject();
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.d.a b = com.mbridge.msdk.videocommon.d.b.a().b();
        return b != null ? b.j() : jSONObject;
    }

    public final void a(Activity activity) {
        this.n = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = com.mbridge.msdk.b.b.a().b(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.mbridge.msdk.foundation.entity.CampaignEx r7) {
        /*
            r6 = this;
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r0 = r0.h()     // Catch:{ Exception -> 0x0038 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0038 }
            r2 = 0
            if (r1 != 0) goto L_0x0022
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0038 }
            com.mbridge.msdk.b.a r0 = r1.b(r0)     // Catch:{ Exception -> 0x0038 }
            if (r0 == 0) goto L_0x0022
            long r0 = r0.v()     // Catch:{ Exception -> 0x0038 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r4
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            com.mbridge.msdk.videocommon.d.b r4 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0038 }
            com.mbridge.msdk.videocommon.d.a r4 = r4.b()     // Catch:{ Exception -> 0x0038 }
            if (r4 == 0) goto L_0x0031
            long r2 = r4.d()     // Catch:{ Exception -> 0x0038 }
        L_0x0031:
            if (r7 == 0) goto L_0x0038
            boolean r7 = r7.isSpareOffer(r2, r0)     // Catch:{ Exception -> 0x0038 }
            return r7
        L_0x0038:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.j.b(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.p = str;
        }
    }

    public final String i() {
        q.a("DefaultJSCommon", "getNotchArea");
        return this.p;
    }
}
