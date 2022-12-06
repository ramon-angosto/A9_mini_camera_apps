package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1608aa;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1871hr;
import com.xiaomi.push.C1872hs;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C2087u;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.xiaomi.push.service.bs */
public class C2033bs {

    /* renamed from: a */
    private static String f3847a = f3848a.format(Long.valueOf(System.currentTimeMillis()));

    /* renamed from: a */
    private static SimpleDateFormat f3848a = new SimpleDateFormat("yyyy/MM/dd");

    /* renamed from: a */
    private static AtomicLong f3849a = new AtomicLong(0);

    /* renamed from: a */
    private static C1894in m5176a(String str, String str2, C1871hr hrVar) {
        return new C1894in("-1", false).mo18091d(str).mo18084b(str2).mo18082a(C1608aa.m2497a(C1905iy.m4543a(hrVar))).mo18087c(C1878hy.UploadTinyData.f2959a);
    }

    /* renamed from: a */
    public static synchronized String m5177a() {
        String str;
        synchronized (C2033bs.class) {
            String format = f3848a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f3847a, format)) {
                f3849a.set(0);
                f3847a = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f3849a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.xiaomi.push.C1894in> m5178a(java.util.List<com.xiaomi.push.C1872hs> r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r0 = 0
            if (r11 != 0) goto L_0x0009
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
        L_0x0005:
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r11)
            return r0
        L_0x0009:
            int r1 = r11.size()
            if (r1 != 0) goto L_0x0012
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.hr r2 = new com.xiaomi.push.hr
            r2.<init>()
            r3 = 0
            r4 = r2
            r2 = 0
            r5 = 0
        L_0x0020:
            int r6 = r11.size()
            if (r2 >= r6) goto L_0x00ab
            java.lang.Object r6 = r11.get(r2)
            com.xiaomi.push.hs r6 = (com.xiaomi.push.C1872hs) r6
            if (r6 != 0) goto L_0x0030
            goto L_0x00a7
        L_0x0030:
            java.util.Map r7 = r6.mo17777a()
            if (r7 == 0) goto L_0x006f
            java.util.Map r7 = r6.mo17777a()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L_0x006f
            java.util.Map r7 = r6.mo17777a()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L_0x0057
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0058
        L_0x0057:
            r7 = 0
        L_0x0058:
            java.util.Map r9 = r6.mo17777a()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L_0x0067
            r6.mo17780a((java.util.Map<java.lang.String, java.lang.String>) r0)
            goto L_0x0070
        L_0x0067:
            java.util.Map r9 = r6.mo17777a()
            r9.remove(r8)
            goto L_0x0070
        L_0x006f:
            r7 = 0
        L_0x0070:
            if (r7 > 0) goto L_0x0077
            byte[] r7 = com.xiaomi.push.C1905iy.m4543a(r6)
            int r7 = r7.length
        L_0x0077:
            if (r7 <= r14) goto L_0x0092
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.mo17792d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r6)
            goto L_0x00a7
        L_0x0092:
            int r8 = r5 + r7
            if (r8 <= r14) goto L_0x00a3
            com.xiaomi.push.in r4 = m5176a(r12, r13, r4)
            r1.add(r4)
            com.xiaomi.push.hr r4 = new com.xiaomi.push.hr
            r4.<init>()
            r5 = 0
        L_0x00a3:
            r4.mo17771a((com.xiaomi.push.C1872hs) r6)
            int r5 = r5 + r7
        L_0x00a7:
            int r2 = r2 + 1
            goto L_0x0020
        L_0x00ab:
            int r11 = r4.mo17769a()
            if (r11 == 0) goto L_0x00b8
            com.xiaomi.push.in r11 = m5176a(r12, r13, r4)
            r1.add(r11)
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2033bs.m5178a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    /* renamed from: a */
    public static void m5179a(Context context, String str, String str2, long j, String str3) {
        C1872hs hsVar = new C1872hs();
        hsVar.mo17791d(str);
        hsVar.mo17787c(str2);
        hsVar.mo17778a(j);
        hsVar.mo17784b(str3);
        hsVar.mo17779a("push_sdk_channel");
        hsVar.mo17798g(context.getPackageName());
        hsVar.mo17793e(context.getPackageName());
        hsVar.mo17781a(true);
        hsVar.mo17783b(System.currentTimeMillis());
        hsVar.mo17796f(m5177a());
        C2034bt.m5182a(context, hsVar);
    }

    /* renamed from: a */
    public static boolean m5180a(C1872hs hsVar, boolean z) {
        String str;
        if (hsVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(hsVar.f2737a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hsVar.f2744d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hsVar.f2743c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!C1663bo.m2727a(hsVar.f2744d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (!C1663bo.m2727a(hsVar.f2743c)) {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (hsVar.f2742b == null || hsVar.f2742b.length() <= 10240) {
            return false;
        } else {
            str = "item.data is too large(" + hsVar.f2742b.length() + "), max size for data is " + 10240 + " , verfiy ClientUploadDataItem failed.";
        }
        C1524b.m2141a(str);
        return true;
    }

    /* renamed from: a */
    public static boolean m5181a(String str) {
        return !C2087u.m5379b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
