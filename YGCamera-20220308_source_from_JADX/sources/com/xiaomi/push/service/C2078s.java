package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1776eu;
import com.xiaomi.push.C1793fj;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1826gi;
import com.xiaomi.push.C1829gk;
import com.xiaomi.push.C1830gl;
import com.xiaomi.push.C1847gz;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1885ie;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C2087u;
import com.xiaomi.push.service.C1974af;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.s */
public class C2078s {
    /* renamed from: a */
    public static Intent m5333a(byte[] bArr, long j) {
        C1891ik a = m5335a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f3195b);
        return intent;
    }

    /* renamed from: a */
    public static C1891ik m5334a(Context context, C1891ik ikVar) {
        C1885ie ieVar = new C1885ie();
        ieVar.mo17930b(ikVar.mo18043a());
        C1882ib a = ikVar.mo18043a();
        if (a != null) {
            ieVar.mo17926a(a.mo17876a());
            ieVar.mo17925a(a.mo17876a());
            if (!TextUtils.isEmpty(a.mo17883b())) {
                ieVar.mo17933c(a.mo17883b());
            }
        }
        ieVar.mo17927a(C1905iy.m4541a(context, ikVar));
        C1891ik a2 = C1970ab.m4880a(ikVar.mo18052b(), ikVar.mo18043a(), ieVar, C1868ho.AckMessage);
        C1882ib a3 = ikVar.mo18043a();
        if (a3 != null) {
            a3 = C2023bk.m5141a(a3.mo17876a());
        }
        a3.mo17881a("mat", Long.toString(System.currentTimeMillis()));
        a2.mo18045a(a3);
        return a2;
    }

    /* renamed from: a */
    public static C1891ik m5335a(byte[] bArr) {
        C1891ik ikVar = new C1891ik();
        try {
            C1905iy.m4542a(ikVar, bArr);
            return ikVar;
        } catch (Throwable th) {
            C1524b.m2155a(th);
            return null;
        }
    }

    /* renamed from: a */
    public static void m5336a(Context context, C1891ik ikVar, byte[] bArr) {
        try {
            C1974af.m4915a(ikVar);
            ikVar.mo18043a();
            C1974af.C1977c a = C1974af.m4908a(context, ikVar, bArr);
            if (a.f3671a > 0 && !TextUtils.isEmpty(a.f3672a)) {
                C1847gz.m3818a(context, a.f3672a, a.f3671a, true, false, System.currentTimeMillis());
            }
            if (!C1938m.m4714a(context) || !a.f3673a || !C1967aa.m4869a(ikVar)) {
                m5347b(context, ikVar, bArr);
            } else {
                C1524b.m2141a("consume this broadcast by tts");
            }
        } catch (Exception e) {
            C1524b.m2141a("notify push msg error " + e);
        }
    }

    /* renamed from: a */
    private static void m5337a(XMPushService xMPushService, C1891ik ikVar) {
        xMPushService.mo18412a((XMPushService.C1956i) new C2079t(4, xMPushService, ikVar));
    }

    /* renamed from: a */
    private static void m5338a(XMPushService xMPushService, C1891ik ikVar, C1894in inVar) {
        xMPushService.mo18412a((XMPushService.C1956i) new C2085z(4, inVar, ikVar, xMPushService));
    }

    /* renamed from: a */
    private static void m5339a(XMPushService xMPushService, C1891ik ikVar, String str) {
        xMPushService.mo18412a((XMPushService.C1956i) new C2083x(4, xMPushService, ikVar, str));
    }

    /* renamed from: a */
    private static void m5340a(XMPushService xMPushService, C1891ik ikVar, String str, String str2) {
        xMPushService.mo18412a((XMPushService.C1956i) new C2084y(4, xMPushService, ikVar, str, str2));
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [com.xiaomi.push.iz] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0388 A[SYNTHETIC, Splitter:B:125:0x0388] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03c0  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m5341a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) {
        /*
            r1 = r19
            r0 = r21
            r2 = r22
            com.xiaomi.push.ik r3 = m5335a((byte[]) r21)
            com.xiaomi.push.ib r4 = r3.mo18043a()
            r5 = 0
            if (r0 == 0) goto L_0x0021
            java.lang.String r6 = r3.mo18052b()
            android.content.Context r7 = r19.getApplicationContext()
            com.xiaomi.push.ho r8 = r3.mo18043a()
            int r9 = r0.length
            com.xiaomi.push.C1712da.m2971a(r6, r7, r5, r8, r9)
        L_0x0021:
            boolean r6 = m5351c(r3)
            if (r6 == 0) goto L_0x0051
            boolean r6 = m5344a((android.content.Context) r19, (java.lang.String) r20)
            if (r6 == 0) goto L_0x0051
            boolean r0 = com.xiaomi.push.service.C1974af.m4951e((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x004c
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r2 = r3.mo18052b()
            java.lang.String r5 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r4 = r4.mo17876a()
            java.lang.String r6 = "5"
            r0.mo17538a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r6)
        L_0x004c:
            m5350c(r1, r3)
            goto L_0x0496
        L_0x0051:
            boolean r6 = m5345a((com.xiaomi.push.C1891ik) r3)
            if (r6 == 0) goto L_0x0087
            boolean r6 = m5344a((android.content.Context) r19, (java.lang.String) r20)
            if (r6 != 0) goto L_0x0087
            boolean r6 = m5349b(r3)
            if (r6 != 0) goto L_0x0087
            boolean r0 = com.xiaomi.push.service.C1974af.m4951e((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x0082
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r2 = r3.mo18052b()
            java.lang.String r5 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r4 = r4.mo17876a()
            java.lang.String r6 = "6"
            r0.mo17538a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r6)
        L_0x0082:
            m5352d(r1, r3)
            goto L_0x0496
        L_0x0087:
            boolean r6 = com.xiaomi.push.service.C1974af.m4915a((com.xiaomi.push.C1891ik) r3)
            if (r6 == 0) goto L_0x0095
            java.lang.String r6 = r3.f3195b
            boolean r6 = com.xiaomi.push.C1816g.m3669b((android.content.Context) r1, (java.lang.String) r6)
            if (r6 != 0) goto L_0x009b
        L_0x0095:
            boolean r6 = m5343a((android.content.Context) r1, (android.content.Intent) r2)
            if (r6 == 0) goto L_0x0447
        L_0x009b:
            com.xiaomi.push.ho r6 = com.xiaomi.push.C1868ho.Registration
            com.xiaomi.push.ho r7 = r3.mo18043a()
            java.lang.String r8 = "eventMessageType"
            java.lang.String r9 = "messageId"
            r10 = 0
            if (r6 != r7) goto L_0x00f7
            java.lang.String r12 = r3.mo18052b()
            java.lang.String r6 = "pref_registered_pkg_names"
            android.content.SharedPreferences r6 = r1.getSharedPreferences(r6, r10)
            android.content.SharedPreferences$Editor r6 = r6.edit()
            java.lang.String r7 = r3.f3191a
            r6.putString(r12, r7)
            r6.commit()
            com.xiaomi.push.service.p r6 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r19)
            r6.mo18560e(r12)
            com.xiaomi.push.service.p r6 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r19)
            r6.mo18561f(r12)
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.eu r11 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r6)
            java.lang.String r14 = r4.mo17876a()
            r15 = 6003(0x1773, float:8.412E-42)
            r16 = 0
            java.lang.String r13 = "E100003"
            r11.mo17537a(r12, r13, r14, r15, r16)
            java.lang.String r6 = r4.mo17876a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00f7
            java.lang.String r6 = r4.mo17876a()
            r2.putExtra(r9, r6)
            r6 = 6000(0x1770, float:8.408E-42)
            r2.putExtra(r8, r6)
        L_0x00f7:
            boolean r6 = com.xiaomi.push.service.C1974af.m4946c((com.xiaomi.push.C1891ik) r3)
            if (r6 == 0) goto L_0x0132
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.eu r11 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r6)
            java.lang.String r12 = r3.mo18052b()
            java.lang.String r13 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r14 = r4.mo17876a()
            r15 = 1001(0x3e9, float:1.403E-42)
            long r16 = java.lang.System.currentTimeMillis()
            r18 = 0
            r11.mo17536a(r12, r13, r14, r15, r16, r18)
            java.lang.String r6 = r4.mo17876a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0132
            java.lang.String r6 = r4.mo17876a()
            r2.putExtra(r9, r6)
            r6 = 1000(0x3e8, float:1.401E-42)
            r2.putExtra(r8, r6)
        L_0x0132:
            boolean r6 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            if (r6 == 0) goto L_0x016d
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.eu r11 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r6)
            java.lang.String r12 = r3.mo18052b()
            java.lang.String r13 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r14 = r4.mo17876a()
            r15 = 2001(0x7d1, float:2.804E-42)
            long r16 = java.lang.System.currentTimeMillis()
            r18 = 0
            r11.mo17536a(r12, r13, r14, r15, r16, r18)
            java.lang.String r6 = r4.mo17876a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x016d
            java.lang.String r6 = r4.mo17876a()
            r2.putExtra(r9, r6)
            r6 = 2000(0x7d0, float:2.803E-42)
            r2.putExtra(r8, r6)
        L_0x016d:
            boolean r6 = com.xiaomi.push.service.C1974af.m4915a((com.xiaomi.push.C1891ik) r3)
            if (r6 == 0) goto L_0x01a8
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.eu r11 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r6)
            java.lang.String r12 = r3.mo18052b()
            java.lang.String r13 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r14 = r4.mo17876a()
            r15 = 3001(0xbb9, float:4.205E-42)
            long r16 = java.lang.System.currentTimeMillis()
            r18 = 0
            r11.mo17536a(r12, r13, r14, r15, r16, r18)
            java.lang.String r6 = r4.mo17876a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01a8
            java.lang.String r6 = r4.mo17876a()
            r2.putExtra(r9, r6)
            r6 = 3000(0xbb8, float:4.204E-42)
            r2.putExtra(r8, r6)
        L_0x01a8:
            java.lang.String r6 = "com.xiaomi.xmsf"
            r7 = 1
            if (r4 == 0) goto L_0x0251
            java.lang.String r8 = r4.mo17888c()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0251
            java.lang.String r8 = r4.mo17894d()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0251
            int r8 = r4.f3035b
            if (r8 == r7) goto L_0x0251
            java.util.Map r8 = r4.mo17876a()
            boolean r8 = com.xiaomi.push.service.C1974af.m4897a((java.util.Map<java.lang.String, java.lang.String>) r8)
            if (r8 != 0) goto L_0x01d9
            java.lang.String r8 = r3.f3195b
            boolean r8 = com.xiaomi.push.service.C1974af.m4894a((android.content.Context) r1, (java.lang.String) r8)
            if (r8 == 0) goto L_0x01d9
            goto L_0x0251
        L_0x01d9:
            if (r4 == 0) goto L_0x01fb
            java.util.Map<java.lang.String, java.lang.String> r2 = r4.f3033a
            if (r2 == 0) goto L_0x01ea
            java.util.Map<java.lang.String, java.lang.String> r2 = r4.f3033a
            java.lang.String r5 = "jobkey"
            java.lang.Object r2 = r2.get(r5)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
        L_0x01ea:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x01f5
            java.lang.String r2 = r4.mo17876a()
            r5 = r2
        L_0x01f5:
            java.lang.String r2 = r3.f3195b
            boolean r10 = com.xiaomi.push.service.C1980ai.m4955a(r1, r2, r5)
        L_0x01fb:
            if (r10 == 0) goto L_0x023a
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r2 = r3.mo18052b()
            java.lang.String r7 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r4 = r4.mo17876a()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "1:"
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r0.mo17540c(r2, r7, r4, r8)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "drop a duplicate message, key="
            r0.append(r2)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
        L_0x0236:
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
            goto L_0x024c
        L_0x023a:
            boolean r2 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r19)
            if (r2 == 0) goto L_0x0249
            boolean r2 = com.xiaomi.push.service.C1967aa.m4872b(r3)
            if (r2 == 0) goto L_0x0249
            java.lang.String r0 = "receive pull down message"
            goto L_0x0236
        L_0x0249:
            m5336a((android.content.Context) r1, (com.xiaomi.push.C1891ik) r3, (byte[]) r0)
        L_0x024c:
            m5348b(r1, r3)
            goto L_0x0431
        L_0x0251:
            java.lang.String r0 = r3.f3195b
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L_0x0290
            boolean r0 = r3.mo18052b()
            if (r0 != 0) goto L_0x0290
            if (r4 == 0) goto L_0x0290
            java.util.Map r0 = r4.mo17876a()
            if (r0 == 0) goto L_0x0290
            java.util.Map r0 = r4.mo17876a()
            java.lang.String r8 = "ab"
            boolean r0 = r0.containsKey(r8)
            if (r0 == 0) goto L_0x0290
            m5348b(r1, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "receive abtest message. ack it."
            r0.append(r2)
            java.lang.String r2 = r4.mo17876a()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2159c(r0)
            goto L_0x0431
        L_0x0290:
            r0 = r20
            boolean r0 = m5346a((com.xiaomi.push.service.XMPushService) r1, (java.lang.String) r0, (com.xiaomi.push.C1891ik) r3, (com.xiaomi.push.C1882ib) r4)
            if (r0 == 0) goto L_0x0418
            if (r4 == 0) goto L_0x0320
            java.lang.String r0 = r4.mo17876a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0320
            boolean r0 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x02c6
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r11 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r12 = r3.mo18052b()
            java.lang.String r13 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r14 = r4.mo17876a()
            r15 = 2002(0x7d2, float:2.805E-42)
            r16 = 0
        L_0x02c2:
            r11.mo17537a(r12, r13, r14, r15, r16)
            goto L_0x0320
        L_0x02c6:
            boolean r0 = com.xiaomi.push.service.C1974af.m4915a((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x02e6
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r8 = r3.mo18052b()
            java.lang.String r9 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r11 = r4.mo17876a()
            java.lang.String r12 = "7"
        L_0x02e2:
            r0.mo17538a((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r11, (java.lang.String) r12)
            goto L_0x0320
        L_0x02e6:
            boolean r0 = com.xiaomi.push.service.C1974af.m4946c((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x0303
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r8 = r3.mo18052b()
            java.lang.String r9 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r11 = r4.mo17876a()
            java.lang.String r12 = "8"
            goto L_0x02e2
        L_0x0303:
            boolean r0 = com.xiaomi.push.service.C1974af.m4949d((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x0320
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r11 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r12 = r3.mo18052b()
            java.lang.String r14 = r4.mo17876a()
            r15 = 6004(0x1774, float:8.413E-42)
            r16 = 0
            java.lang.String r13 = "E100003"
            goto L_0x02c2
        L_0x0320:
            com.xiaomi.push.ho r0 = com.xiaomi.push.C1868ho.Notification
            com.xiaomi.push.ho r8 = r3.f3188a
            if (r0 != r8) goto L_0x0407
            com.xiaomi.push.iz r5 = com.xiaomi.push.service.C2036bv.m5187a((android.content.Context) r1, (com.xiaomi.push.C1891ik) r3)     // Catch:{ je -> 0x0345 }
            if (r5 != 0) goto L_0x0343
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ je -> 0x0345 }
            r0.<init>()     // Catch:{ je -> 0x0345 }
            java.lang.String r8 = "receiving an un-recognized notification message. "
            r0.append(r8)     // Catch:{ je -> 0x0345 }
            com.xiaomi.push.ho r8 = r3.f3188a     // Catch:{ je -> 0x0345 }
            r0.append(r8)     // Catch:{ je -> 0x0345 }
            java.lang.String r0 = r0.toString()     // Catch:{ je -> 0x0345 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)     // Catch:{ je -> 0x0345 }
            goto L_0x035a
        L_0x0343:
            r0 = 1
            goto L_0x035b
        L_0x0345:
            r0 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "receive a message which action string is not valid. "
            r8.append(r9)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)
        L_0x035a:
            r0 = 0
        L_0x035b:
            if (r0 == 0) goto L_0x0407
            boolean r0 = r5 instanceof com.xiaomi.push.C1894in
            if (r0 == 0) goto L_0x0407
            com.xiaomi.push.in r5 = (com.xiaomi.push.C1894in) r5
            com.xiaomi.push.hy r0 = com.xiaomi.push.C1878hy.CancelPushMessage
            java.lang.String r0 = r0.f2959a
            java.lang.String r8 = r5.f3229d
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0407
            java.util.Map r0 = r5.mo18077a()
            if (r0 == 0) goto L_0x0407
            java.util.Map r0 = r5.mo18077a()
            java.lang.String r7 = com.xiaomi.push.service.C2014bd.f3780L
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            r8 = -2
            if (r7 != 0) goto L_0x03a3
            int r8 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x038d }
            goto L_0x03a3
        L_0x038d:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "parse notifyId from STRING to INT failed: "
            r0.append(r9)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
        L_0x03a3:
            r0 = -1
            if (r8 < r0) goto L_0x03c0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = "try to retract a message by notifyId="
            r0.append(r7)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
            java.lang.String r0 = r3.f3195b
            com.xiaomi.push.service.C1974af.m4920a((android.content.Context) r1, (java.lang.String) r0, (int) r8)
            goto L_0x03e2
        L_0x03c0:
            java.util.Map r0 = r5.mo18077a()
            java.lang.String r7 = com.xiaomi.push.service.C2014bd.f3778J
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            java.util.Map r7 = r5.mo18077a()
            java.lang.String r8 = com.xiaomi.push.service.C2014bd.f3779K
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "try to retract a message by title&description."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r8)
            java.lang.String r8 = r3.f3195b
            com.xiaomi.push.service.C1974af.m4923a((android.content.Context) r1, (java.lang.String) r8, (java.lang.String) r0, (java.lang.String) r7)
        L_0x03e2:
            if (r4 == 0) goto L_0x0403
            java.util.Map r0 = r4.mo17876a()
            if (r0 == 0) goto L_0x0403
            boolean r0 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r19)
            if (r0 == 0) goto L_0x0403
            java.util.Map r0 = r4.mo17876a()
            java.lang.String r0 = com.xiaomi.push.service.C1994as.m5034a((java.lang.Object) r0)
            java.lang.String r4 = "pulldown"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0403
            com.xiaomi.push.service.C1967aa.m4869a((com.xiaomi.push.C1891ik) r3)
        L_0x0403:
            m5338a((com.xiaomi.push.service.XMPushService) r1, (com.xiaomi.push.C1891ik) r3, (com.xiaomi.push.C1894in) r5)
            r7 = 0
        L_0x0407:
            if (r7 == 0) goto L_0x0431
            java.lang.String r0 = "broadcast passthrough message."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
            java.lang.String r0 = r3.f3195b
            java.lang.String r0 = com.xiaomi.push.service.C1970ab.m4883a((java.lang.String) r0)
            r1.sendBroadcast(r2, r0)
            goto L_0x0431
        L_0x0418:
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r2 = r3.mo18052b()
            java.lang.String r5 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r4 = r4.mo17876a()
            java.lang.String r7 = "9"
            r0.mo17538a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r7)
        L_0x0431:
            com.xiaomi.push.ho r0 = r3.mo18043a()
            com.xiaomi.push.ho r2 = com.xiaomi.push.C1868ho.UnRegistration
            if (r0 != r2) goto L_0x0496
            java.lang.String r0 = r19.getPackageName()
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0496
            r19.stopSelf()
            goto L_0x0496
        L_0x0447:
            java.lang.String r0 = r3.f3195b
            boolean r0 = com.xiaomi.push.C1816g.m3669b((android.content.Context) r1, (java.lang.String) r0)
            if (r0 != 0) goto L_0x0472
            boolean r0 = com.xiaomi.push.service.C1974af.m4951e((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x046e
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r2 = r3.mo18052b()
            java.lang.String r5 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r4 = r4.mo17876a()
            java.lang.String r6 = "2"
            r0.mo17539b(r2, r5, r4, r6)
        L_0x046e:
            m5337a((com.xiaomi.push.service.XMPushService) r1, (com.xiaomi.push.C1891ik) r3)
            goto L_0x0496
        L_0x0472:
            java.lang.String r0 = "receive a mipush message, we can see the app, but we can't see the receiver."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
            boolean r0 = com.xiaomi.push.service.C1974af.m4951e((com.xiaomi.push.C1891ik) r3)
            if (r0 == 0) goto L_0x0496
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r1 = r3.mo18052b()
            java.lang.String r2 = com.xiaomi.push.service.C1974af.m4938b((com.xiaomi.push.C1891ik) r3)
            java.lang.String r3 = r4.mo17876a()
            java.lang.String r4 = "3"
            r0.mo17539b(r1, r2, r3, r4)
        L_0x0496:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2078s.m5341a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    /* renamed from: a */
    private static void m5342a(XMPushService xMPushService, byte[] bArr, long j) {
        Map a;
        C1891ik a2 = m5335a(bArr);
        if (a2 != null) {
            if (TextUtils.isEmpty(a2.f3195b)) {
                C1524b.m2141a("receive a mipush message without package name");
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Intent a3 = m5333a(bArr, valueOf.longValue());
            String a4 = C1974af.m4915a(a2);
            C1847gz.m3818a(xMPushService, a4, j, true, true, System.currentTimeMillis());
            C1882ib a5 = a2.mo18043a();
            if (!(a5 == null || a5.mo17876a() == null)) {
                C1524b.m2161e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", new Object[]{a2.mo18043a(), a5.mo17876a(), a2.mo18043a()}));
            }
            if (a5 != null) {
                a5.mo17881a("mrt", Long.toString(valueOf.longValue()));
            }
            String str = "";
            if (C1868ho.SendMessage == a2.mo18043a() && C2074p.m5312a((Context) xMPushService).mo18556a(a2.f3195b) && !C1974af.m4915a(a2)) {
                if (a5 != null) {
                    str = a5.mo17876a();
                    if (C1974af.m4951e(a2)) {
                        C1776eu.m3405a(xMPushService.getApplicationContext()).mo17538a(a2.mo18052b(), C1974af.m4938b(a2), str, "1");
                    }
                }
                C1524b.m2141a("Drop a message for unregistered, msgid=" + str);
                m5339a(xMPushService, a2, a2.f3195b);
            } else if (C1868ho.SendMessage == a2.mo18043a() && C2074p.m5312a((Context) xMPushService).mo18558c(a2.f3195b) && !C1974af.m4915a(a2)) {
                if (a5 != null) {
                    str = a5.mo17876a();
                    if (C1974af.m4951e(a2)) {
                        C1776eu.m3405a(xMPushService.getApplicationContext()).mo17538a(a2.mo18052b(), C1974af.m4938b(a2), str, "2");
                    }
                }
                C1524b.m2141a("Drop a message for push closed, msgid=" + str);
                m5339a(xMPushService, a2, a2.f3195b);
            } else if (C1868ho.SendMessage == a2.mo18043a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f3195b)) {
                C1524b.m2141a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f3195b);
                m5340a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f3195b);
                if (a5 != null && C1974af.m4951e(a2)) {
                    C1776eu.m3405a(xMPushService.getApplicationContext()).mo17538a(a2.mo18052b(), C1974af.m4938b(a2), a5.mo17876a(), "3");
                }
            } else if (a5 == null || (a = a5.mo17876a()) == null || !a.containsKey("hide") || !"true".equalsIgnoreCase((String) a.get("hide"))) {
                if (!(a5 == null || a5.mo17876a() == null || !a5.mo17876a().containsKey("__miid"))) {
                    String str2 = (String) a5.mo17876a().get("__miid");
                    String a6 = C2087u.m5375a(xMPushService.getApplicationContext());
                    if (TextUtils.isEmpty(a6) || !TextUtils.equals(str2, a6)) {
                        if (C1974af.m4951e(a2)) {
                            C1776eu.m3405a(xMPushService.getApplicationContext()).mo17538a(a2.mo18052b(), C1974af.m4938b(a2), a5.mo17876a(), "4");
                        }
                        C1524b.m2141a(str2 + " should be login, but got " + a6);
                        m5340a(xMPushService, a2, "miid already logout or anther already login", str2 + " should be login, but got " + a6);
                        return;
                    }
                }
                m5341a(xMPushService, a4, bArr, a3);
            } else {
                m5348b(xMPushService, a2);
            }
        }
    }

    /* renamed from: a */
    private static boolean m5343a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m5344a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return !packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() || !packageManager.queryIntentServices(intent, 32).isEmpty();
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m5345a(C1891ik ikVar) {
        return "com.xiaomi.xmsf".equals(ikVar.f3195b) && ikVar.mo18043a() != null && ikVar.mo18043a().mo17876a() != null && ikVar.mo18043a().mo17876a().containsKey("miui_package_name");
    }

    /* renamed from: a */
    private static boolean m5346a(XMPushService xMPushService, String str, C1891ik ikVar, C1882ib ibVar) {
        boolean z = true;
        if (ibVar != null && ibVar.mo17876a() != null && ibVar.mo17876a().containsKey("__check_alive") && ibVar.mo17876a().containsKey("__awake")) {
            C1894in inVar = new C1894in();
            inVar.mo18084b(ikVar.mo18043a());
            inVar.mo18091d(str);
            inVar.mo18087c(C1878hy.AwakeSystemApp.f2959a);
            inVar.mo18078a(ibVar.mo17876a());
            inVar.f3224a = new HashMap();
            boolean a = C1816g.m3659a(xMPushService.getApplicationContext(), str);
            inVar.f3224a.put("app_running", Boolean.toString(a));
            if (!a) {
                boolean parseBoolean = Boolean.parseBoolean((String) ibVar.mo17876a().get("__awake"));
                inVar.f3224a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                C1970ab.m4885a(xMPushService, C1970ab.m4880a(ikVar.mo18052b(), ikVar.mo18043a(), inVar, C1868ho.Notification));
            } catch (C1823gf e) {
                C1524b.m2155a((Throwable) e);
            }
        }
        return z;
    }

    /* renamed from: b */
    public static void m5347b(Context context, C1891ik ikVar, byte[] bArr) {
        if (!C1974af.m4915a(ikVar) && C1816g.m3659a(context.getApplicationContext(), C1974af.m4915a(ikVar))) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(ikVar.f3195b);
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                    C1524b.m2141a("broadcast message arrived.");
                    context.sendBroadcast(intent, C1970ab.m4883a(ikVar.f3195b));
                }
            } catch (Exception unused) {
                C1776eu.m3405a(context.getApplicationContext()).mo17539b(ikVar.mo18052b(), C1974af.m4938b(ikVar), ikVar.mo18043a().mo17876a(), "1");
            }
        }
    }

    /* renamed from: b */
    private static void m5348b(XMPushService xMPushService, C1891ik ikVar) {
        xMPushService.mo18412a((XMPushService.C1956i) new C2080u(4, xMPushService, ikVar));
    }

    /* renamed from: b */
    private static boolean m5349b(C1891ik ikVar) {
        Map a = ikVar.mo18043a().mo17876a();
        return a != null && a.containsKey("notify_effect");
    }

    /* renamed from: c */
    private static void m5350c(XMPushService xMPushService, C1891ik ikVar) {
        xMPushService.mo18412a((XMPushService.C1956i) new C2081v(4, xMPushService, ikVar));
    }

    /* renamed from: c */
    private static boolean m5351c(C1891ik ikVar) {
        if (ikVar.mo18043a() == null || ikVar.mo18043a().mo17876a() == null) {
            return false;
        }
        return "1".equals(ikVar.mo18043a().mo17876a().get("obslete_ads_message"));
    }

    /* renamed from: d */
    private static void m5352d(XMPushService xMPushService, C1891ik ikVar) {
        xMPushService.mo18412a((XMPushService.C1956i) new C2082w(4, xMPushService, ikVar));
    }

    /* renamed from: a */
    public void mo18565a(Context context, C2003az.C2005b bVar, boolean z, int i, String str) {
        C2071n a;
        if (!z && (a = C2072o.m5301a(context)) != null && "token-expired".equals(str)) {
            C2072o.m5303a(context, a.f3931f, a.f3929d, a.f3930e);
        }
    }

    /* renamed from: a */
    public void mo18566a(XMPushService xMPushService, C1793fj fjVar, C2003az.C2005b bVar) {
        try {
            m5342a(xMPushService, fjVar.mo17619a(bVar.f3749h), (long) fjVar.mo17625c());
        } catch (IllegalArgumentException e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo18567a(XMPushService xMPushService, C1830gl glVar, C2003az.C2005b bVar) {
        if (glVar instanceof C1829gk) {
            C1829gk gkVar = (C1829gk) glVar;
            C1826gi a = gkVar.mo17703a("s");
            if (a != null) {
                try {
                    m5342a(xMPushService, C2021bi.m5134a(C2021bi.m5133a(bVar.f3749h, gkVar.mo17726j()), a.mo17695c()), (long) C1847gz.m3810a(glVar.mo17698a()));
                } catch (IllegalArgumentException e) {
                    C1524b.m2155a((Throwable) e);
                }
            }
        } else {
            C1524b.m2141a("not a mipush message");
        }
    }
}
