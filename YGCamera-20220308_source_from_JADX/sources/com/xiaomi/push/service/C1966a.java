package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.xiaomi.push.service.a */
public class C1966a {

    /* renamed from: a */
    private static volatile C1966a f3645a;

    /* renamed from: a */
    private Context f3646a;

    /* renamed from: a */
    private final Object f3647a = new Object();

    /* renamed from: a */
    private final String f3648a = "mipush_region";

    /* renamed from: b */
    private final Object f3649b = new Object();

    /* renamed from: b */
    private final String f3650b = "mipush_country_code";

    /* renamed from: c */
    private final String f3651c = "mipush_region.lock";

    /* renamed from: d */
    private final String f3652d = "mipush_country_code.lock";

    /* renamed from: e */
    private volatile String f3653e;

    /* renamed from: f */
    private volatile String f3654f;

    public C1966a(Context context) {
        this.f3646a = context;
    }

    /* renamed from: a */
    public static C1966a m4862a(Context context) {
        if (f3645a == null) {
            synchronized (C1966a.class) {
                if (f3645a == null) {
                    f3645a = new C1966a(context);
                }
            }
        }
        return f3645a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c A[SYNTHETIC, Splitter:B:34:0x006c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m4863a(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            java.io.File r1 = r4.getFilesDir()
            r0.<init>(r1, r5)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto L_0x0025
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "No ready file to get data from "
            r4.append(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r4)
            return r2
        L_0x0025:
            monitor-enter(r7)
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r5)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r6 = "rw"
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.nio.channels.FileChannel r5 = r4.getChannel()     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            java.nio.channels.FileLock r5 = r5.lock()     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            java.lang.String r6 = com.xiaomi.push.C1608aa.m2490a((java.io.File) r0)     // Catch:{ Exception -> 0x005a }
            if (r5 == 0) goto L_0x0055
            boolean r0 = r5.isValid()     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0055
            r5.release()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r5 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0095 }
        L_0x0055:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)     // Catch:{ all -> 0x0095 }
            monitor-exit(r7)     // Catch:{ all -> 0x0095 }
            return r6
        L_0x005a:
            r6 = move-exception
            goto L_0x0067
        L_0x005c:
            r6 = move-exception
            goto L_0x0081
        L_0x005e:
            r6 = move-exception
            r5 = r2
            goto L_0x0067
        L_0x0061:
            r6 = move-exception
            r4 = r2
            goto L_0x0081
        L_0x0064:
            r6 = move-exception
            r4 = r2
            r5 = r4
        L_0x0067:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r6)     // Catch:{ all -> 0x007f }
            if (r5 == 0) goto L_0x007a
            boolean r6 = r5.isValid()     // Catch:{ all -> 0x0095 }
            if (r6 == 0) goto L_0x007a
            r5.release()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r5 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0095 }
        L_0x007a:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)     // Catch:{ all -> 0x0095 }
            monitor-exit(r7)     // Catch:{ all -> 0x0095 }
            return r2
        L_0x007f:
            r6 = move-exception
            r2 = r5
        L_0x0081:
            if (r2 == 0) goto L_0x0091
            boolean r5 = r2.isValid()     // Catch:{ all -> 0x0095 }
            if (r5 == 0) goto L_0x0091
            r2.release()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r5 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0095 }
        L_0x0091:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)     // Catch:{ all -> 0x0095 }
            throw r6     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r4 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0095 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1966a.m4863a(android.content.Context, java.lang.String, java.lang.String, java.lang.Object):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[SYNTHETIC, Splitter:B:24:0x0049] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4864a(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.Object r8) {
        /*
            r3 = this;
            monitor-enter(r8)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.io.File r2 = r4.getFilesDir()     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r1.<init>(r2, r7)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r1)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.lang.String r2 = "rw"
            r7.<init>(r1, r2)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.nio.channels.FileChannel r1 = r7.getChannel()     // Catch:{ Exception -> 0x003d }
            java.nio.channels.FileLock r0 = r1.lock()     // Catch:{ Exception -> 0x003d }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x003d }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x003d }
            r1.<init>(r4, r6)     // Catch:{ Exception -> 0x003d }
            com.xiaomi.push.C1608aa.m2494a((java.io.File) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x003d }
            if (r0 == 0) goto L_0x0039
            boolean r4 = r0.isValid()     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0039
            r0.release()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r4)     // Catch:{ all -> 0x006f }
        L_0x0039:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r7)     // Catch:{ all -> 0x006f }
            goto L_0x0058
        L_0x003d:
            r4 = move-exception
            goto L_0x0044
        L_0x003f:
            r4 = move-exception
            r7 = r0
            goto L_0x005b
        L_0x0042:
            r4 = move-exception
            r7 = r0
        L_0x0044:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r4)     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0039
            boolean r4 = r0.isValid()     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0039
            r0.release()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0039
        L_0x0053:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r4)     // Catch:{ all -> 0x006f }
            goto L_0x0039
        L_0x0058:
            monitor-exit(r8)     // Catch:{ all -> 0x006f }
            return
        L_0x005a:
            r4 = move-exception
        L_0x005b:
            if (r0 == 0) goto L_0x006b
            boolean r5 = r0.isValid()     // Catch:{ all -> 0x006f }
            if (r5 == 0) goto L_0x006b
            r0.release()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r5 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r5)     // Catch:{ all -> 0x006f }
        L_0x006b:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r7)     // Catch:{ all -> 0x006f }
            throw r4     // Catch:{ all -> 0x006f }
        L_0x006f:
            r4 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x0072:
            throw r4
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1966a.m4864a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.Object):void");
    }

    /* renamed from: a */
    public String mo18436a() {
        if (TextUtils.isEmpty(this.f3653e)) {
            this.f3653e = m4863a(this.f3646a, "mipush_region", "mipush_region.lock", this.f3647a);
        }
        return this.f3653e;
    }

    /* renamed from: a */
    public void mo18437a(String str) {
        if (!TextUtils.equals(str, this.f3653e)) {
            this.f3653e = str;
            m4864a(this.f3646a, this.f3653e, "mipush_region", "mipush_region.lock", this.f3647a);
        }
    }

    /* renamed from: b */
    public String mo18438b() {
        if (TextUtils.isEmpty(this.f3654f)) {
            this.f3654f = m4863a(this.f3646a, "mipush_country_code", "mipush_country_code.lock", this.f3649b);
        }
        return this.f3654f;
    }

    /* renamed from: b */
    public void mo18439b(String str) {
        if (!TextUtils.equals(str, this.f3654f)) {
            this.f3654f = str;
            m4864a(this.f3646a, this.f3654f, "mipush_country_code", "mipush_country_code.lock", this.f3649b);
        }
    }
}
