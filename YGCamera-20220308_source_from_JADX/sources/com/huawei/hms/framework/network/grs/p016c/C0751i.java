package com.huawei.hms.framework.network.grs.p016c;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.c.i */
public class C0751i extends C0739b implements Callable<C0748f> {

    /* renamed from: i */
    private static final String f551i = "i";

    public C0751i(String str, int i, C0737a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo) {
        super(str, i, aVar, context, str2, grsBaseInfo, (C0728c) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.framework.network.grs.p016c.C0748f call() {
        /*
            r15 = this;
            java.lang.String r0 = f551i
            java.lang.String r1 = "Get call execute"
            com.huawei.hms.framework.common.Logger.m474i(r0, r1)
            r0 = 0
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0072 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0070 }
            java.lang.String r4 = r15.mo13836c()     // Catch:{ IOException -> 0x0070 }
            android.content.Context r5 = r15.mo13835b()     // Catch:{ IOException -> 0x0070 }
            java.lang.String r6 = r15.mo13838e()     // Catch:{ IOException -> 0x0070 }
            javax.net.ssl.HttpsURLConnection r4 = com.huawei.hms.framework.network.grs.p019d.p020a.C0759a.m666a(r4, r5, r6)     // Catch:{ IOException -> 0x0070 }
            r5 = 0
            if (r4 != 0) goto L_0x002c
            java.lang.String r4 = f551i     // Catch:{ IOException -> 0x0070 }
            java.lang.String r6 = "create HttpsURLConnection instance by url return null."
            com.huawei.hms.framework.common.Logger.m478w(r4, r6)     // Catch:{ IOException -> 0x0070 }
            return r5
        L_0x002c:
            java.lang.String r6 = "GET"
            r4.setRequestMethod(r6)     // Catch:{ IOException -> 0x0070 }
            r4.connect()     // Catch:{ IOException -> 0x0070 }
            int r8 = r4.getResponseCode()     // Catch:{ IOException -> 0x0070 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r8 != r6) goto L_0x004e
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x0049 }
            byte[] r6 = com.huawei.hms.framework.common.IoUtils.toByteArray(r5)     // Catch:{ all -> 0x0049 }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r5)     // Catch:{ IOException -> 0x0070 }
            r5 = r6
            goto L_0x004e
        L_0x0049:
            r4 = move-exception
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r5)     // Catch:{ IOException -> 0x0070 }
            throw r4     // Catch:{ IOException -> 0x0070 }
        L_0x004e:
            java.util.Map r9 = r4.getHeaderFields()     // Catch:{ IOException -> 0x0070 }
            r4.disconnect()     // Catch:{ IOException -> 0x0070 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0070 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0070 }
            if (r5 != 0) goto L_0x0064
            r4 = 0
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0070 }
            r10 = r4
            goto L_0x0065
        L_0x0064:
            r10 = r5
        L_0x0065:
            com.huawei.hms.framework.network.grs.c.f r4 = new com.huawei.hms.framework.network.grs.c.f     // Catch:{ IOException -> 0x0070 }
            long r11 = r6 - r2
            r7 = r4
            r7.<init>(r8, r9, r10, r11)     // Catch:{ IOException -> 0x0070 }
            r15.f489a = r4     // Catch:{ IOException -> 0x0070 }
            goto L_0x008b
        L_0x0070:
            r4 = move-exception
            goto L_0x0074
        L_0x0072:
            r4 = move-exception
            r2 = r0
        L_0x0074:
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r13 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = f551i
            java.lang.String r8 = "RequestCallable run task catch IOException"
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r7, (java.lang.String) r8, (java.lang.Throwable) r4)
            com.huawei.hms.framework.network.grs.c.f r7 = new com.huawei.hms.framework.network.grs.c.f
            long r5 = r5 - r2
            r7.<init>(r4, r5)
            r15.f489a = r7
        L_0x008b:
            com.huawei.hms.framework.network.grs.c.f r2 = r15.f489a
            java.lang.String r3 = r15.mo13836c()
            r2.mo13864a((java.lang.String) r3)
            com.huawei.hms.framework.network.grs.c.f r2 = r15.f489a
            int r3 = r15.mo13837d()
            r2.mo13862a((int) r3)
            com.huawei.hms.framework.network.grs.c.f r2 = r15.f489a
            r2.mo13866b((long) r0)
            com.huawei.hms.framework.network.grs.c.f r0 = r15.f489a
            r0.mo13863a((long) r13)
            com.huawei.hms.framework.network.grs.c.a r0 = r15.mo13834a()
            if (r0 == 0) goto L_0x00b6
            com.huawei.hms.framework.network.grs.c.a r0 = r15.mo13834a()
            com.huawei.hms.framework.network.grs.c.f r1 = r15.f489a
            r0.mo13833a(r1)
        L_0x00b6:
            com.huawei.hms.framework.network.grs.c.f r0 = r15.f489a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p016c.C0751i.call():com.huawei.hms.framework.network.grs.c.f");
    }
}
