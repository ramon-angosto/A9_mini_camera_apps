package com.mbridge.msdk.mbsignalcommon.a;

import android.util.Base64;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: H5ReportManager */
public class a {
    /* access modifiers changed from: private */
    public static final String c = a.class.getSimpleName();
    int a = 0;
    int b = 1;
    private String d = "handlerNativeResult";

    /* renamed from: com.mbridge.msdk.mbsignalcommon.a.a$a  reason: collision with other inner class name */
    /* compiled from: H5ReportManager */
    private static final class C0068a {
        /* access modifiers changed from: private */
        public static a a = new a();
    }

    public static a a() {
        return C0068a.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0199, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x019a, code lost:
        com.mbridge.msdk.foundation.tools.q.a(c, r0.getMessage());
        a(r1.b, "exception: " + r0.getMessage(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.mbridge.msdk.foundation.tools.q.d(c, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
        r6 = r3.optJSONObject(1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:2:0x000c, B:29:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0175 A[Catch:{ all -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cf A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d9 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e9 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ef A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ff A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0109 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010f A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0119 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0120 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012b A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0132 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013e A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0145 A[Catch:{ Exception -> 0x009b, all -> 0x0199 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r22, java.lang.String r23, org.json.JSONArray r24, int r25) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r0 = r23
            r3 = r24
            java.lang.String r4 = "called reporter failed, params empty"
            if (r3 != 0) goto L_0x0012
            int r0 = r1.b     // Catch:{ all -> 0x0199 }
            r1.a(r0, r4, r2)     // Catch:{ all -> 0x0199 }
            return
        L_0x0012:
            int r5 = r24.length()     // Catch:{ all -> 0x0199 }
            if (r5 != 0) goto L_0x001e
            int r0 = r1.b     // Catch:{ all -> 0x0199 }
            r1.a(r0, r4, r2)     // Catch:{ all -> 0x0199 }
            return
        L_0x001e:
            java.lang.String r4 = "reportMessageR"
            boolean r4 = r4.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0199 }
            r6 = 0
            r7 = 1
            java.lang.String r8 = "value"
            if (r4 == 0) goto L_0x00a7
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0199 }
            r0.<init>()     // Catch:{ all -> 0x0199 }
            r4 = r6
        L_0x0030:
            int r9 = r5 + -1
            java.lang.String r10 = "="
            java.lang.String r11 = "key"
            if (r4 >= r9) goto L_0x0057
            org.json.JSONObject r9 = r3.optJSONObject(r4)     // Catch:{ all -> 0x0199 }
            if (r9 == 0) goto L_0x0054
            java.lang.String r11 = r9.optString(r11)     // Catch:{ all -> 0x0199 }
            r0.append(r11)     // Catch:{ all -> 0x0199 }
            r0.append(r10)     // Catch:{ all -> 0x0199 }
            java.lang.Object r9 = r9.opt(r8)     // Catch:{ all -> 0x0199 }
            r0.append(r9)     // Catch:{ all -> 0x0199 }
            java.lang.String r9 = "&"
            r0.append(r9)     // Catch:{ all -> 0x0199 }
        L_0x0054:
            int r4 = r4 + 1
            goto L_0x0030
        L_0x0057:
            org.json.JSONObject r3 = r3.optJSONObject(r9)     // Catch:{ all -> 0x0199 }
            if (r3 == 0) goto L_0x006e
            java.lang.String r4 = r3.optString(r11)     // Catch:{ all -> 0x0199 }
            r0.append(r4)     // Catch:{ all -> 0x0199 }
            r0.append(r10)     // Catch:{ all -> 0x0199 }
            java.lang.Object r3 = r3.opt(r8)     // Catch:{ all -> 0x0199 }
            r0.append(r3)     // Catch:{ all -> 0x0199 }
        L_0x006e:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0199 }
            com.mbridge.msdk.foundation.controller.a r3 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0199 }
            android.content.Context r3 = r3.g()     // Catch:{ all -> 0x0199 }
            if (r3 == 0) goto L_0x0191
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0199 }
            if (r4 != 0) goto L_0x0191
            com.mbridge.msdk.foundation.same.report.d.a r4 = new com.mbridge.msdk.foundation.same.report.d.a     // Catch:{ Exception -> 0x009b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x009b }
            com.mbridge.msdk.foundation.same.net.h.d r0 = com.mbridge.msdk.foundation.same.report.d.a((java.lang.String) r0, (android.content.Context) r3)     // Catch:{ Exception -> 0x009b }
            com.mbridge.msdk.foundation.same.net.g.d r3 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x009b }
            java.lang.String r3 = r3.a     // Catch:{ Exception -> 0x009b }
            com.mbridge.msdk.mbsignalcommon.a.a$1 r5 = new com.mbridge.msdk.mbsignalcommon.a.a$1     // Catch:{ Exception -> 0x009b }
            r5.<init>()     // Catch:{ Exception -> 0x009b }
            r4.c(r6, r3, r0, r5)     // Catch:{ Exception -> 0x009b }
            goto L_0x0191
        L_0x009b:
            r0 = move-exception
            java.lang.String r3 = c     // Catch:{ all -> 0x0199 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0199 }
            com.mbridge.msdk.foundation.tools.q.d(r3, r0)     // Catch:{ all -> 0x0199 }
            goto L_0x0191
        L_0x00a7:
            java.lang.String r4 = "reportMessageD"
            boolean r0 = r4.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0199 }
            if (r0 == 0) goto L_0x0191
            java.lang.String r0 = ""
            if (r5 <= 0) goto L_0x00bf
            org.json.JSONObject r4 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r4 == 0) goto L_0x00bf
            java.lang.String r4 = r4.getString(r8)     // Catch:{ all -> 0x0199 }
            r10 = r4
            goto L_0x00c0
        L_0x00bf:
            r10 = r0
        L_0x00c0:
            r4 = -1
            if (r5 <= r7) goto L_0x00cf
            org.json.JSONObject r6 = r3.optJSONObject(r7)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x00cf
            int r6 = r6.getInt(r8)     // Catch:{ all -> 0x0199 }
            r11 = r6
            goto L_0x00d0
        L_0x00cf:
            r11 = r4
        L_0x00d0:
            r6 = 2
            if (r5 <= r6) goto L_0x00df
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x00df
            int r6 = r6.getInt(r8)     // Catch:{ all -> 0x0199 }
            r12 = r6
            goto L_0x00e0
        L_0x00df:
            r12 = r4
        L_0x00e0:
            r6 = 3
            if (r5 <= r6) goto L_0x00ef
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x00ef
            int r6 = r6.getInt(r8)     // Catch:{ all -> 0x0199 }
            r13 = r6
            goto L_0x00f0
        L_0x00ef:
            r13 = r4
        L_0x00f0:
            r6 = 4
            if (r5 <= r6) goto L_0x00ff
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x00ff
            int r6 = r6.getInt(r8)     // Catch:{ all -> 0x0199 }
            r14 = r6
            goto L_0x0100
        L_0x00ff:
            r14 = r4
        L_0x0100:
            r6 = 5
            if (r5 <= r6) goto L_0x010f
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x010f
            java.lang.String r6 = r6.getString(r8)     // Catch:{ all -> 0x0199 }
            r15 = r6
            goto L_0x0110
        L_0x010f:
            r15 = r0
        L_0x0110:
            r6 = 6
            if (r5 <= r6) goto L_0x0120
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x0120
            java.lang.String r6 = r6.getString(r8)     // Catch:{ all -> 0x0199 }
            r16 = r6
            goto L_0x0122
        L_0x0120:
            r16 = r0
        L_0x0122:
            r6 = 7
            if (r5 <= r6) goto L_0x0132
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x0132
            int r6 = r6.getInt(r8)     // Catch:{ all -> 0x0199 }
            r17 = r6
            goto L_0x0134
        L_0x0132:
            r17 = r4
        L_0x0134:
            r6 = 8
            if (r5 <= r6) goto L_0x0145
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x0145
            java.lang.String r6 = r6.getString(r8)     // Catch:{ all -> 0x0199 }
            r18 = r6
            goto L_0x0147
        L_0x0145:
            r18 = r0
        L_0x0147:
            r6 = 9
            if (r5 <= r6) goto L_0x0157
            r6 = 9
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0199 }
            if (r6 == 0) goto L_0x0157
            int r4 = r6.getInt(r8)     // Catch:{ all -> 0x0199 }
        L_0x0157:
            r19 = r4
            r4 = 10
            if (r5 <= r4) goto L_0x0169
            r4 = 10
            org.json.JSONObject r3 = r3.optJSONObject(r4)     // Catch:{ all -> 0x0199 }
            if (r3 == 0) goto L_0x0169
            java.lang.String r0 = r3.getString(r8)     // Catch:{ all -> 0x0199 }
        L_0x0169:
            r20 = r0
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0187 }
            android.content.Context r0 = r0.g()     // Catch:{ all -> 0x0187 }
            if (r0 == 0) goto L_0x0191
            com.mbridge.msdk.foundation.entity.m r3 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ all -> 0x0187 }
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0187 }
            com.mbridge.msdk.foundation.db.g r0 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r0)     // Catch:{ all -> 0x0187 }
            com.mbridge.msdk.foundation.db.p r0 = com.mbridge.msdk.foundation.db.p.a((com.mbridge.msdk.foundation.db.f) r0)     // Catch:{ all -> 0x0187 }
            r0.a((com.mbridge.msdk.foundation.entity.m) r3)     // Catch:{ all -> 0x0187 }
            goto L_0x0191
        L_0x0187:
            r0 = move-exception
            java.lang.String r3 = c     // Catch:{ all -> 0x0199 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0199 }
            com.mbridge.msdk.foundation.tools.q.a(r3, r0)     // Catch:{ all -> 0x0199 }
        L_0x0191:
            int r0 = r1.a     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = "called reporter success"
            r1.a(r0, r3, r2)     // Catch:{ all -> 0x0199 }
            goto L_0x01bd
        L_0x0199:
            r0 = move-exception
            java.lang.String r3 = c
            java.lang.String r4 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r3, r4)
            int r3 = r1.b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "exception: "
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r1.a(r3, r0, r2)
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.a.a.a(java.lang.Object, java.lang.String, org.json.JSONArray, int):void");
    }

    private void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            q.a(c, e.getMessage());
        } catch (Throwable th) {
            q.a(c, th.getMessage());
        }
    }
}
