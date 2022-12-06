package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import java.util.List;

/* compiled from: RewardReport */
public class a {
    /* access modifiers changed from: private */
    public static final String a = a.class.getName();
    private static String b = "";

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                p a2 = p.a((f) g.a(context));
                if (!TextUtils.isEmpty(str) && a2 != null && a2.a() > 0) {
                    List<m> a3 = a2.a("2000022");
                    List<m> a4 = a2.a("2000021");
                    List<m> a5 = a2.a("2000039");
                    List<m> a6 = a2.a("2000043");
                    List<m> a7 = a2.a("2000045");
                    List<m> a8 = a2.a("2000044");
                    String a9 = m.a(a4);
                    String b2 = m.b(a3);
                    String f = m.f(a5);
                    String c = m.c(a6);
                    String d = m.d(a7);
                    String e = m.e(a8);
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(a9)) {
                        sb.append(a9);
                    }
                    if (!TextUtils.isEmpty(b2)) {
                        sb.append(b2);
                    }
                    if (!TextUtils.isEmpty(f)) {
                        sb.append(f);
                    }
                    if (!TextUtils.isEmpty(c)) {
                        sb.append(c);
                    }
                    if (!TextUtils.isEmpty(d)) {
                        sb.append(d);
                    }
                    if (!TextUtils.isEmpty(e)) {
                        sb.append(e);
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        String sb2 = sb.toString();
                        if (context != null && !TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(str)) {
                            try {
                                new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(sb2, context, str), new b() {
                                    public final void a(String str) {
                                        q.d(a.a, str);
                                    }

                                    public final void b(String str) {
                                        q.d(a.a, str);
                                    }
                                });
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                q.d(a, e2.getMessage());
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(str, context, str2), new b() {
                    public final void a(String str) {
                        q.d(a.a, str);
                    }

                    public final void b(String str) {
                        k kVar = new k();
                        kVar.c(str);
                        kVar.a(System.currentTimeMillis());
                        kVar.a(0);
                        kVar.b(ShareTarget.METHOD_POST);
                        kVar.a(d.c().a);
                        com.mbridge.msdk.foundation.db.m.a((f) g.a(context)).a(kVar);
                        q.d(a.a, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                q.d(a, e.getMessage());
            }
        }
    }

    private static void b(final Context context, final String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(str, context), new b() {
                    public final void a(String str) {
                        q.d(a.a, str);
                    }

                    public final void b(String str) {
                        k kVar = new k();
                        kVar.c(str);
                        kVar.a(System.currentTimeMillis());
                        kVar.a(0);
                        kVar.b(ShareTarget.METHOD_POST);
                        kVar.a(d.c().a);
                        com.mbridge.msdk.foundation.db.m.a((f) g.a(context)).a(kVar);
                        q.d(a.a, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                q.d(a, e.getMessage());
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, long j) {
        q.a("test_load_time", "time: " + j);
        if (context != null && list != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (list.size() > 0) {
                        String requestId = list.get(0).getRequestId();
                        if (TextUtils.isEmpty(b) || !requestId.equals(b)) {
                            b = requestId;
                        } else {
                            return;
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=");
                    stringBuffer.append("2000048");
                    stringBuffer.append("&");
                    stringBuffer.append("network_type=");
                    stringBuffer.append(com.mbridge.msdk.foundation.tools.m.n(context));
                    stringBuffer.append("&");
                    stringBuffer.append("unit_id=");
                    stringBuffer.append(str);
                    stringBuffer.append("&");
                    stringBuffer.append("load_time=");
                    stringBuffer.append(j);
                    stringBuffer.append("&");
                    if (list != null && list.size() > 0) {
                        stringBuffer.append("cid=");
                        StringBuilder sb = new StringBuilder("rtins_type=");
                        for (int i = 0; i < list.size(); i++) {
                            CampaignEx campaignEx = list.get(i);
                            if (i < list.size() - 1) {
                                stringBuffer.append(campaignEx.getId());
                                stringBuffer.append(",");
                                sb.append(campaignEx.getRtinsType());
                                sb.append(",");
                            } else {
                                stringBuffer.append(campaignEx.getId());
                                stringBuffer.append("&");
                                sb.append(campaignEx.getRtinsType());
                                sb.append("&");
                                if (campaignEx.isBidCampaign()) {
                                    stringBuffer.append("hb=1&");
                                } else {
                                    stringBuffer.append("hb=0&");
                                }
                            }
                        }
                        stringBuffer.append(sb);
                        CampaignEx campaignEx2 = list.get(0);
                        if (!(campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null)) {
                            stringBuffer.append("rid=");
                            stringBuffer.append(campaignEx2.getRequestId());
                            try {
                                int i2 = u.i(campaignEx2.getRewardTemplateMode().e());
                                if (i2 != -1) {
                                    stringBuffer.append("&view=");
                                    stringBuffer.append(i2);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        String str2 = "";
                        String str3 = str2;
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            str2 = str2 + list.get(i3).getRequestIdNotice();
                            str3 = str3 + list.get(i3).getAdSpaceT();
                            if (i3 < list.size() - 1) {
                                str2 = str2 + ",";
                                str3 = str3 + ",";
                            }
                        }
                        stringBuffer.append("&rid_n=");
                        stringBuffer.append(str2);
                        stringBuffer.append("&adspace_t=");
                        stringBuffer.append(str3);
                        if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                            com.mbridge.msdk.foundation.same.report.a.a().a(stringBuffer.toString());
                        } else {
                            a(context, stringBuffer.toString(), str);
                        }
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, boolean z, String str3, String str4) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000047&");
                    stringBuffer.append("network_type=" + com.mbridge.msdk.foundation.tools.m.n(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.k)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.k + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.l + "&");
                    }
                    if (z) {
                        stringBuffer.append("hb=1&");
                    } else {
                        stringBuffer.append("hb=0&");
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid=");
                        stringBuffer.append(str3);
                        stringBuffer.append("&");
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid_n=");
                        stringBuffer.append(str4);
                        stringBuffer.append("&");
                    }
                    stringBuffer.append("reason=" + str);
                    if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null)) {
                        try {
                            int i = u.i(campaignEx.getRewardTemplateMode().e());
                            if (i != -1) {
                                stringBuffer.append("&view=");
                                stringBuffer.append(i);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (campaignEx != null) {
                        stringBuffer.append("&adspace_t=");
                        stringBuffer.append(campaignEx.getAdSpaceT());
                    }
                    if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                        com.mbridge.msdk.foundation.same.report.a.a().a(stringBuffer.toString());
                    } else {
                        b(context, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:5|6|(2:8|9)|10|(1:12)|13|(1:15)(1:16)|(1:18)|(3:22|23|(1:25))|26|27|(2:29|37)(2:30|38)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00fa */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0104 A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0110 A[Catch:{ all -> 0x0118 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r4, com.mbridge.msdk.foundation.entity.CampaignEx r5, java.lang.String r6) {
        /*
            if (r4 == 0) goto L_0x011c
            if (r5 == 0) goto L_0x011c
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0118 }
            if (r0 != 0) goto L_0x011c
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0118 }
            r0.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = "key=2000048&"
            r0.append(r1)     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = "&"
            if (r5 == 0) goto L_0x0033
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r2.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "cid="
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r5.getId()     // Catch:{ all -> 0x0118 }
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            r2.append(r1)     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0118 }
            r0.append(r2)     // Catch:{ all -> 0x0118 }
        L_0x0033:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r2.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "network_type="
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            int r3 = com.mbridge.msdk.foundation.tools.m.n(r4)     // Catch:{ all -> 0x0118 }
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            r2.append(r1)     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0118 }
            r0.append(r2)     // Catch:{ all -> 0x0118 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r2.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "unit_id="
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            r2.append(r6)     // Catch:{ all -> 0x0118 }
            r2.append(r1)     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0118 }
            r0.append(r2)     // Catch:{ all -> 0x0118 }
            boolean r2 = com.mbridge.msdk.foundation.tools.u.b((com.mbridge.msdk.foundation.entity.CampaignEx) r5)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x007a
            java.lang.String r2 = "rtins_type="
            r0.append(r2)     // Catch:{ all -> 0x0118 }
            int r2 = r5.getRtinsType()     // Catch:{ all -> 0x0118 }
            r0.append(r2)     // Catch:{ all -> 0x0118 }
            r0.append(r1)     // Catch:{ all -> 0x0118 }
        L_0x007a:
            boolean r2 = r5.isBidCampaign()     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x0086
            java.lang.String r2 = "hb=1&"
            r0.append(r2)     // Catch:{ all -> 0x0118 }
            goto L_0x008b
        L_0x0086:
            java.lang.String r2 = "hb=0&"
            r0.append(r2)     // Catch:{ all -> 0x0118 }
        L_0x008b:
            if (r5 == 0) goto L_0x00db
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r2.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "rid="
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r5.getRequestId()     // Catch:{ all -> 0x0118 }
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            r2.append(r1)     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0118 }
            r0.append(r2)     // Catch:{ all -> 0x0118 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r2.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "rid_n="
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = r5.getRequestIdNotice()     // Catch:{ all -> 0x0118 }
            r2.append(r3)     // Catch:{ all -> 0x0118 }
            r2.append(r1)     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0118 }
            r0.append(r1)     // Catch:{ all -> 0x0118 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r1.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = "adspace_t="
            r1.append(r2)     // Catch:{ all -> 0x0118 }
            int r2 = r5.getAdSpaceT()     // Catch:{ all -> 0x0118 }
            r1.append(r2)     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0118 }
            r0.append(r1)     // Catch:{ all -> 0x0118 }
        L_0x00db:
            if (r5 == 0) goto L_0x00fa
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r5.getRewardTemplateMode()     // Catch:{ all -> 0x0118 }
            if (r1 == 0) goto L_0x00fa
            com.mbridge.msdk.foundation.entity.CampaignEx$c r5 = r5.getRewardTemplateMode()     // Catch:{ Exception -> 0x00fa }
            java.lang.String r5 = r5.e()     // Catch:{ Exception -> 0x00fa }
            int r5 = com.mbridge.msdk.foundation.tools.u.i((java.lang.String) r5)     // Catch:{ Exception -> 0x00fa }
            r1 = -1
            if (r5 == r1) goto L_0x00fa
            java.lang.String r1 = "&view="
            r0.append(r1)     // Catch:{ Exception -> 0x00fa }
            r0.append(r5)     // Catch:{ Exception -> 0x00fa }
        L_0x00fa:
            com.mbridge.msdk.foundation.same.report.a r5 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x0118 }
            boolean r5 = r5.c()     // Catch:{ all -> 0x0118 }
            if (r5 == 0) goto L_0x0110
            com.mbridge.msdk.foundation.same.report.a r4 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x0118 }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0118 }
            r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0118 }
            goto L_0x011c
        L_0x0110:
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0118 }
            a((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r4 = move-exception
            r4.printStackTrace()
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|(1:9)|10|(1:12)|(1:14)(1:15)|16|(1:18)|19|(1:21)|22|(3:26|27|(1:29))|30|31|(2:33|41)(2:34|42)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00f0 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fa A[Catch:{ all -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0106 A[Catch:{ all -> 0x010e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(com.mbridge.msdk.foundation.entity.CampaignEx r4, android.content.Context r5, java.lang.String r6, java.lang.String r7, boolean r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "&"
            if (r5 == 0) goto L_0x0112
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x010e }
            if (r1 != 0) goto L_0x0112
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x010e }
            if (r1 != 0) goto L_0x0112
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x010e }
            r1.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r2 = "key=2000047&"
            r1.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r2.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r3 = "network_type="
            r2.append(r3)     // Catch:{ all -> 0x010e }
            int r3 = com.mbridge.msdk.foundation.tools.m.n(r5)     // Catch:{ all -> 0x010e }
            r2.append(r3)     // Catch:{ all -> 0x010e }
            r2.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x010e }
            r1.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r2.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r3 = "unit_id="
            r2.append(r3)     // Catch:{ all -> 0x010e }
            r2.append(r7)     // Catch:{ all -> 0x010e }
            r2.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x010e }
            r1.append(r7)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x010e }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x010e }
            if (r7 != 0) goto L_0x006d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r7.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r2 = "b="
            r7.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x010e }
            r7.append(r2)     // Catch:{ all -> 0x010e }
            r7.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x010e }
            r1.append(r7)     // Catch:{ all -> 0x010e }
        L_0x006d:
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x010e }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x010e }
            if (r7 != 0) goto L_0x008e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r7.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r2 = "c="
            r7.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x010e }
            r7.append(r2)     // Catch:{ all -> 0x010e }
            r7.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x010e }
            r1.append(r7)     // Catch:{ all -> 0x010e }
        L_0x008e:
            if (r8 == 0) goto L_0x0096
            java.lang.String r7 = "hb=1&"
            r1.append(r7)     // Catch:{ all -> 0x010e }
            goto L_0x009b
        L_0x0096:
            java.lang.String r7 = "hb=0&"
            r1.append(r7)     // Catch:{ all -> 0x010e }
        L_0x009b:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x010e }
            if (r7 != 0) goto L_0x00ac
            java.lang.String r7 = "rid="
            r1.append(r7)     // Catch:{ all -> 0x010e }
            r1.append(r9)     // Catch:{ all -> 0x010e }
            r1.append(r0)     // Catch:{ all -> 0x010e }
        L_0x00ac:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x010e }
            if (r7 != 0) goto L_0x00bd
            java.lang.String r7 = "rid_n="
            r1.append(r7)     // Catch:{ all -> 0x010e }
            r1.append(r10)     // Catch:{ all -> 0x010e }
            r1.append(r0)     // Catch:{ all -> 0x010e }
        L_0x00bd:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r7.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r8 = "reason="
            r7.append(r8)     // Catch:{ all -> 0x010e }
            r7.append(r6)     // Catch:{ all -> 0x010e }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x010e }
            r1.append(r6)     // Catch:{ all -> 0x010e }
            if (r4 == 0) goto L_0x00f0
            com.mbridge.msdk.foundation.entity.CampaignEx$c r6 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x010e }
            if (r6 == 0) goto L_0x00f0
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r4 = r4.e()     // Catch:{ Exception -> 0x00f0 }
            int r4 = com.mbridge.msdk.foundation.tools.u.i((java.lang.String) r4)     // Catch:{ Exception -> 0x00f0 }
            r6 = -1
            if (r4 == r6) goto L_0x00f0
            java.lang.String r6 = "&view="
            r1.append(r6)     // Catch:{ Exception -> 0x00f0 }
            r1.append(r4)     // Catch:{ Exception -> 0x00f0 }
        L_0x00f0:
            com.mbridge.msdk.foundation.same.report.a r4 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x010e }
            boolean r4 = r4.c()     // Catch:{ all -> 0x010e }
            if (r4 == 0) goto L_0x0106
            com.mbridge.msdk.foundation.same.report.a r4 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x010e }
            r4.a((java.lang.String) r5)     // Catch:{ all -> 0x010e }
            goto L_0x0112
        L_0x0106:
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x010e }
            b(r5, r4)     // Catch:{ all -> 0x010e }
            goto L_0x0112
        L_0x010e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.b(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:7|(1:9)|10|(1:12)|(1:14)(1:15)|16|17|(2:19|20)(1:(1:24))|25|26|(2:28|29)(1:(1:33))|34|(3:38|39|(1:41))|42|43|(2:45|53)(2:46|54)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x012c */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0136 A[Catch:{ all -> 0x014a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0142 A[Catch:{ all -> 0x014a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.mbridge.msdk.foundation.entity.CampaignEx r4, android.content.Context r5, java.lang.String r6, java.lang.String r7, boolean r8, java.lang.String r9, java.lang.String r10, long r11) {
        /*
            java.lang.String r0 = "&"
            if (r5 == 0) goto L_0x014e
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x014a }
            if (r1 != 0) goto L_0x014e
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014a }
            if (r1 != 0) goto L_0x014e
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x014a }
            r1.<init>()     // Catch:{ all -> 0x014a }
            java.lang.String r2 = "key=2000078&"
            r1.append(r2)     // Catch:{ all -> 0x014a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
            r2.<init>()     // Catch:{ all -> 0x014a }
            java.lang.String r3 = "network_type="
            r2.append(r3)     // Catch:{ all -> 0x014a }
            int r3 = com.mbridge.msdk.foundation.tools.m.n(r5)     // Catch:{ all -> 0x014a }
            r2.append(r3)     // Catch:{ all -> 0x014a }
            r2.append(r0)     // Catch:{ all -> 0x014a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x014a }
            r1.append(r2)     // Catch:{ all -> 0x014a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
            r2.<init>()     // Catch:{ all -> 0x014a }
            java.lang.String r3 = "unit_id="
            r2.append(r3)     // Catch:{ all -> 0x014a }
            r2.append(r7)     // Catch:{ all -> 0x014a }
            r2.append(r0)     // Catch:{ all -> 0x014a }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x014a }
            r1.append(r7)     // Catch:{ all -> 0x014a }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x014a }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014a }
            if (r7 != 0) goto L_0x006d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
            r7.<init>()     // Catch:{ all -> 0x014a }
            java.lang.String r2 = "b="
            r7.append(r2)     // Catch:{ all -> 0x014a }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x014a }
            r7.append(r2)     // Catch:{ all -> 0x014a }
            r7.append(r0)     // Catch:{ all -> 0x014a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x014a }
            r1.append(r7)     // Catch:{ all -> 0x014a }
        L_0x006d:
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x014a }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014a }
            if (r7 != 0) goto L_0x008e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
            r7.<init>()     // Catch:{ all -> 0x014a }
            java.lang.String r2 = "c="
            r7.append(r2)     // Catch:{ all -> 0x014a }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x014a }
            r7.append(r2)     // Catch:{ all -> 0x014a }
            r7.append(r0)     // Catch:{ all -> 0x014a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x014a }
            r1.append(r7)     // Catch:{ all -> 0x014a }
        L_0x008e:
            if (r8 == 0) goto L_0x0096
            java.lang.String r7 = "hb=1&"
            r1.append(r7)     // Catch:{ all -> 0x014a }
            goto L_0x009b
        L_0x0096:
            java.lang.String r7 = "hb=0&"
            r1.append(r7)     // Catch:{ all -> 0x014a }
        L_0x009b:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x014a }
            java.lang.String r8 = "rid="
            if (r7 != 0) goto L_0x00ad
            r1.append(r8)     // Catch:{ all -> 0x014a }
            r1.append(r9)     // Catch:{ all -> 0x014a }
            r1.append(r0)     // Catch:{ all -> 0x014a }
            goto L_0x00c6
        L_0x00ad:
            if (r4 == 0) goto L_0x00c6
            java.lang.String r7 = r4.getRequestId()     // Catch:{ all -> 0x014a }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014a }
            if (r7 != 0) goto L_0x00c6
            r1.append(r8)     // Catch:{ all -> 0x014a }
            java.lang.String r7 = r4.getRequestId()     // Catch:{ all -> 0x014a }
            r1.append(r7)     // Catch:{ all -> 0x014a }
            r1.append(r0)     // Catch:{ all -> 0x014a }
        L_0x00c6:
            boolean r7 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x014a }
            java.lang.String r8 = "rid_n="
            if (r7 != 0) goto L_0x00d8
            r1.append(r8)     // Catch:{ all -> 0x014a }
            r1.append(r10)     // Catch:{ all -> 0x014a }
            r1.append(r0)     // Catch:{ all -> 0x014a }
            goto L_0x00f1
        L_0x00d8:
            if (r4 == 0) goto L_0x00f1
            java.lang.String r7 = r4.getRequestIdNotice()     // Catch:{ all -> 0x014a }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014a }
            if (r7 != 0) goto L_0x00f1
            r1.append(r8)     // Catch:{ all -> 0x014a }
            java.lang.String r7 = r4.getRequestIdNotice()     // Catch:{ all -> 0x014a }
            r1.append(r7)     // Catch:{ all -> 0x014a }
            r1.append(r0)     // Catch:{ all -> 0x014a }
        L_0x00f1:
            java.lang.String r7 = "during="
            r1.append(r7)     // Catch:{ all -> 0x014a }
            r1.append(r11)     // Catch:{ all -> 0x014a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
            r7.<init>()     // Catch:{ all -> 0x014a }
            java.lang.String r8 = "&reason="
            r7.append(r8)     // Catch:{ all -> 0x014a }
            r7.append(r6)     // Catch:{ all -> 0x014a }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x014a }
            r1.append(r6)     // Catch:{ all -> 0x014a }
            if (r4 == 0) goto L_0x012c
            com.mbridge.msdk.foundation.entity.CampaignEx$c r6 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x014a }
            if (r6 == 0) goto L_0x012c
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ Exception -> 0x012c }
            java.lang.String r4 = r4.e()     // Catch:{ Exception -> 0x012c }
            int r4 = com.mbridge.msdk.foundation.tools.u.i((java.lang.String) r4)     // Catch:{ Exception -> 0x012c }
            r6 = -1
            if (r4 == r6) goto L_0x012c
            java.lang.String r6 = "&view="
            r1.append(r6)     // Catch:{ Exception -> 0x012c }
            r1.append(r4)     // Catch:{ Exception -> 0x012c }
        L_0x012c:
            com.mbridge.msdk.foundation.same.report.a r4 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x014a }
            boolean r4 = r4.c()     // Catch:{ all -> 0x014a }
            if (r4 == 0) goto L_0x0142
            com.mbridge.msdk.foundation.same.report.a r4 = com.mbridge.msdk.foundation.same.report.a.a()     // Catch:{ all -> 0x014a }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x014a }
            r4.a((java.lang.String) r5)     // Catch:{ all -> 0x014a }
            goto L_0x014e
        L_0x0142:
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x014a }
            b(r5, r4)     // Catch:{ all -> 0x014a }
            goto L_0x014e
        L_0x014a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x014e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, long):void");
    }
}
