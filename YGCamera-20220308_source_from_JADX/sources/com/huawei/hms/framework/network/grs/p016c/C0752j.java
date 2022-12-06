package com.huawei.hms.framework.network.grs.p016c;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.c.j */
public class C0752j extends C0739b implements Callable<C0748f> {

    /* renamed from: i */
    private static final String f552i = "j";

    public C0752j(String str, int i, C0737a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo, C0728c cVar) {
        super(str, i, aVar, context, str2, grsBaseInfo, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.framework.network.grs.p016c.C0748f call() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = f552i
            java.lang.String r2 = "Post call execute"
            com.huawei.hms.framework.common.Logger.m474i(r0, r2)
            r2 = 0
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x009e }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x009c }
            java.lang.String r0 = r17.mo13836c()     // Catch:{ IOException -> 0x009c }
            android.content.Context r6 = r17.mo13835b()     // Catch:{ IOException -> 0x009c }
            java.lang.String r7 = r17.mo13838e()     // Catch:{ IOException -> 0x009c }
            javax.net.ssl.HttpsURLConnection r0 = com.huawei.hms.framework.network.grs.p019d.p020a.C0759a.m666a(r0, r6, r7)     // Catch:{ IOException -> 0x009c }
            r6 = 0
            if (r0 != 0) goto L_0x002e
            java.lang.String r0 = f552i     // Catch:{ IOException -> 0x009c }
            java.lang.String r7 = "create HttpsURLConnection instance by url return null."
            com.huawei.hms.framework.common.Logger.m478w(r0, r7)     // Catch:{ IOException -> 0x009c }
            return r6
        L_0x002e:
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "application/json; charset=UTF-8"
            r0.setRequestProperty(r7, r8)     // Catch:{ IOException -> 0x009c }
            java.lang.String r7 = "POST"
            r0.setRequestMethod(r7)     // Catch:{ IOException -> 0x009c }
            r7 = 1
            r0.setDoOutput(r7)     // Catch:{ IOException -> 0x009c }
            r0.setDoInput(r7)     // Catch:{ IOException -> 0x009c }
            r0.connect()     // Catch:{ IOException -> 0x009c }
            java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ IOException -> 0x009c }
            com.huawei.hms.framework.network.grs.a.c r8 = r17.mo13839f()     // Catch:{ IOException -> 0x009c }
            java.lang.String r9 = "services"
            java.lang.String r10 = ""
            java.lang.String r8 = r8.mo13805a(r9, r10)     // Catch:{ IOException -> 0x009c }
            java.lang.String r9 = "UTF-8"
            byte[] r8 = r8.getBytes(r9)     // Catch:{ IOException -> 0x009c }
            r7.write(r8)     // Catch:{ IOException -> 0x009c }
            r7.close()     // Catch:{ IOException -> 0x009c }
            int r10 = r0.getResponseCode()     // Catch:{ IOException -> 0x009c }
            r7 = 200(0xc8, float:2.8E-43)
            if (r10 != r7) goto L_0x007a
            java.io.InputStream r6 = r0.getInputStream()     // Catch:{ all -> 0x0075 }
            byte[] r7 = com.huawei.hms.framework.common.IoUtils.toByteArray(r6)     // Catch:{ all -> 0x0075 }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r6)     // Catch:{ IOException -> 0x009c }
            r6 = r7
            goto L_0x007a
        L_0x0075:
            r0 = move-exception
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r6)     // Catch:{ IOException -> 0x009c }
            throw r0     // Catch:{ IOException -> 0x009c }
        L_0x007a:
            java.util.Map r11 = r0.getHeaderFields()     // Catch:{ IOException -> 0x009c }
            r0.disconnect()     // Catch:{ IOException -> 0x009c }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x009c }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x009c }
            if (r6 != 0) goto L_0x0090
            r0 = 0
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x009c }
            r12 = r0
            goto L_0x0091
        L_0x0090:
            r12 = r6
        L_0x0091:
            com.huawei.hms.framework.network.grs.c.f r0 = new com.huawei.hms.framework.network.grs.c.f     // Catch:{ IOException -> 0x009c }
            long r13 = r7 - r4
            r9 = r0
            r9.<init>(r10, r11, r12, r13)     // Catch:{ IOException -> 0x009c }
            r1.f489a = r0     // Catch:{ IOException -> 0x009c }
            goto L_0x00b7
        L_0x009c:
            r0 = move-exception
            goto L_0x00a0
        L_0x009e:
            r0 = move-exception
            r4 = r2
        L_0x00a0:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r15 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = f552i
            java.lang.String r9 = "RequestCallableV2 run task catch IOException"
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r8, (java.lang.String) r9, (java.lang.Throwable) r0)
            com.huawei.hms.framework.network.grs.c.f r8 = new com.huawei.hms.framework.network.grs.c.f
            long r6 = r6 - r4
            r8.<init>(r0, r6)
            r1.f489a = r8
        L_0x00b7:
            r4 = r15
            com.huawei.hms.framework.network.grs.c.f r0 = r1.f489a
            java.lang.String r6 = r17.mo13836c()
            r0.mo13864a((java.lang.String) r6)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.f489a
            int r6 = r17.mo13837d()
            r0.mo13862a((int) r6)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.f489a
            r0.mo13866b((long) r2)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.f489a
            r0.mo13863a((long) r4)
            com.huawei.hms.framework.network.grs.c.a r0 = r17.mo13834a()
            if (r0 == 0) goto L_0x00e3
            com.huawei.hms.framework.network.grs.c.a r0 = r17.mo13834a()
            com.huawei.hms.framework.network.grs.c.f r2 = r1.f489a
            r0.mo13833a(r2)
        L_0x00e3:
            com.huawei.hms.framework.network.grs.c.f r0 = r1.f489a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p016c.C0752j.call():com.huawei.hms.framework.network.grs.c.f");
    }
}
