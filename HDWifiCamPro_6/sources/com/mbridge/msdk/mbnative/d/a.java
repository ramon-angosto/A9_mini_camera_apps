package com.mbridge.msdk.mbnative.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: NativeReport */
public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0148 A[Catch:{ Exception -> 0x017e, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0154 A[Catch:{ Exception -> 0x017e, all -> 0x018c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(final android.content.Context r9, java.util.List<com.mbridge.msdk.out.Campaign> r10, java.lang.String r11) {
        /*
            if (r9 == 0) goto L_0x0190
            if (r10 == 0) goto L_0x0190
            int r0 = r10.size()     // Catch:{ all -> 0x018c }
            if (r0 <= 0) goto L_0x0190
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x018c }
            if (r0 != 0) goto L_0x0190
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x018c }
            r0.<init>()     // Catch:{ all -> 0x018c }
            java.lang.String r1 = "key=2000048&"
            r0.append(r1)     // Catch:{ all -> 0x018c }
            r1 = 0
            java.lang.String r2 = "&"
            if (r10 == 0) goto L_0x0046
            int r3 = r10.size()     // Catch:{ all -> 0x018c }
            if (r3 <= 0) goto L_0x0046
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r3.<init>()     // Catch:{ all -> 0x018c }
            java.lang.String r4 = "cid="
            r3.append(r4)     // Catch:{ all -> 0x018c }
            java.lang.Object r4 = r10.get(r1)     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.out.Campaign r4 = (com.mbridge.msdk.out.Campaign) r4     // Catch:{ all -> 0x018c }
            java.lang.String r4 = r4.getId()     // Catch:{ all -> 0x018c }
            r3.append(r4)     // Catch:{ all -> 0x018c }
            r3.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x018c }
            r0.append(r3)     // Catch:{ all -> 0x018c }
        L_0x0046:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r3.<init>()     // Catch:{ all -> 0x018c }
            java.lang.String r4 = "network_type="
            r3.append(r4)     // Catch:{ all -> 0x018c }
            int r4 = com.mbridge.msdk.foundation.tools.m.n(r9)     // Catch:{ all -> 0x018c }
            r3.append(r4)     // Catch:{ all -> 0x018c }
            r3.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x018c }
            r0.append(r3)     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r3.<init>()     // Catch:{ all -> 0x018c }
            java.lang.String r4 = "unit_id="
            r3.append(r4)     // Catch:{ all -> 0x018c }
            r3.append(r11)     // Catch:{ all -> 0x018c }
            r3.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x018c }
            r0.append(r3)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = "rid_n="
            java.lang.String r4 = "rid="
            java.lang.String r5 = "rtins_type="
            java.lang.String r6 = "hb="
            r7 = 1
            if (r10 == 0) goto L_0x00e1
            int r8 = r10.size()     // Catch:{ all -> 0x018c }
            if (r8 <= r7) goto L_0x00e1
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ all -> 0x018c }
            boolean r8 = r10.isBidCampaign()     // Catch:{ all -> 0x018c }
            if (r8 == 0) goto L_0x009e
            r0.append(r6)     // Catch:{ all -> 0x018c }
            r0.append(r7)     // Catch:{ all -> 0x018c }
            r0.append(r2)     // Catch:{ all -> 0x018c }
        L_0x009e:
            boolean r6 = com.mbridge.msdk.foundation.tools.u.b((com.mbridge.msdk.foundation.entity.CampaignEx) r10)     // Catch:{ all -> 0x018c }
            if (r6 == 0) goto L_0x00b1
            r0.append(r5)     // Catch:{ all -> 0x018c }
            int r5 = r10.getRtinsType()     // Catch:{ all -> 0x018c }
            r0.append(r5)     // Catch:{ all -> 0x018c }
            r0.append(r2)     // Catch:{ all -> 0x018c }
        L_0x00b1:
            java.lang.String r5 = r10.getRequestId()     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r6.<init>()     // Catch:{ all -> 0x018c }
            r6.append(r4)     // Catch:{ all -> 0x018c }
            r6.append(r5)     // Catch:{ all -> 0x018c }
            r6.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x018c }
            r0.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r10 = r10.getRequestIdNotice()     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r2.<init>()     // Catch:{ all -> 0x018c }
            r2.append(r3)     // Catch:{ all -> 0x018c }
            r2.append(r10)     // Catch:{ all -> 0x018c }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x018c }
            r0.append(r10)     // Catch:{ all -> 0x018c }
            goto L_0x013e
        L_0x00e1:
            int r8 = r10.size()     // Catch:{ all -> 0x018c }
            if (r8 != r7) goto L_0x013e
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ all -> 0x018c }
            boolean r8 = r10.isBidCampaign()     // Catch:{ all -> 0x018c }
            if (r8 == 0) goto L_0x00fc
            r0.append(r6)     // Catch:{ all -> 0x018c }
            r0.append(r7)     // Catch:{ all -> 0x018c }
            r0.append(r2)     // Catch:{ all -> 0x018c }
        L_0x00fc:
            boolean r6 = com.mbridge.msdk.foundation.tools.u.b((com.mbridge.msdk.foundation.entity.CampaignEx) r10)     // Catch:{ all -> 0x018c }
            if (r6 == 0) goto L_0x010f
            r0.append(r5)     // Catch:{ all -> 0x018c }
            int r5 = r10.getRtinsType()     // Catch:{ all -> 0x018c }
            r0.append(r5)     // Catch:{ all -> 0x018c }
            r0.append(r2)     // Catch:{ all -> 0x018c }
        L_0x010f:
            java.lang.String r5 = r10.getRequestId()     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r6.<init>()     // Catch:{ all -> 0x018c }
            r6.append(r4)     // Catch:{ all -> 0x018c }
            r6.append(r5)     // Catch:{ all -> 0x018c }
            r6.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x018c }
            r0.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r10 = r10.getRequestIdNotice()     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r2.<init>()     // Catch:{ all -> 0x018c }
            r2.append(r3)     // Catch:{ all -> 0x018c }
            r2.append(r10)     // Catch:{ all -> 0x018c }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x018c }
            r0.append(r10)     // Catch:{ all -> 0x018c }
        L_0x013e:
            com.mbridge.msdk.foundation.same.report.a r10 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x018c }
            boolean r10 = r10.c()     // Catch:{ all -> 0x018c }
            if (r10 == 0) goto L_0x0154
            com.mbridge.msdk.foundation.same.report.a r9 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x018c }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x018c }
            r9.a((java.lang.String) r10)     // Catch:{ all -> 0x018c }
            goto L_0x0190
        L_0x0154:
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x018c }
            if (r9 == 0) goto L_0x0190
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x018c }
            if (r0 != 0) goto L_0x0190
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x018c }
            if (r0 != 0) goto L_0x0190
            com.mbridge.msdk.foundation.same.report.d.a r0 = new com.mbridge.msdk.foundation.same.report.d.a     // Catch:{ Exception -> 0x017e }
            r0.<init>(r9)     // Catch:{ Exception -> 0x017e }
            com.mbridge.msdk.foundation.same.net.h.d r11 = com.mbridge.msdk.foundation.same.report.d.a((java.lang.String) r10, (android.content.Context) r9, (java.lang.String) r11)     // Catch:{ Exception -> 0x017e }
            com.mbridge.msdk.foundation.same.net.g.d r2 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x017e }
            java.lang.String r2 = r2.a     // Catch:{ Exception -> 0x017e }
            com.mbridge.msdk.mbnative.d.a$1 r3 = new com.mbridge.msdk.mbnative.d.a$1     // Catch:{ Exception -> 0x017e }
            r3.<init>(r10, r9)     // Catch:{ Exception -> 0x017e }
            r0.c(r1, r2, r11, r3)     // Catch:{ Exception -> 0x017e }
            goto L_0x0190
        L_0x017e:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x018c }
            java.lang.String r10 = "NativeReport"
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.tools.q.d(r10, r9)     // Catch:{ all -> 0x018c }
            goto L_0x0190
        L_0x018c:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0190:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.d.a.a(android.content.Context, java.util.List, java.lang.String):void");
    }

    public static void a(final Context context, String str, String str2, boolean z) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000047&");
                    stringBuffer.append("network_type=" + m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.k)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.k + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.l + "&");
                    }
                    if (z) {
                        stringBuffer.append("hb=1&");
                    }
                    stringBuffer.append("reason=" + str);
                    if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                        com.mbridge.msdk.foundation.same.report.a.a().a(stringBuffer.toString());
                        return;
                    }
                    final String stringBuffer2 = stringBuffer.toString();
                    if (context != null && !TextUtils.isEmpty(stringBuffer2)) {
                        new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(stringBuffer2, context), new b() {
                            public final void a(String str) {
                                q.d("NativeReport", str);
                            }

                            public final void b(String str) {
                                k kVar = new k();
                                kVar.c(stringBuffer2);
                                kVar.a(System.currentTimeMillis());
                                kVar.a(0);
                                kVar.b(ShareTarget.METHOD_POST);
                                kVar.a(d.c().a);
                                com.mbridge.msdk.foundation.db.m.a((f) g.a(context)).a(kVar);
                                q.d("NativeReport", str);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                q.d("NativeReport", e.getMessage());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
