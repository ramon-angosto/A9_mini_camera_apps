package com.xiaomi.channel.commonutils.android;

public class f {
    private static int a;

    public static synchronized boolean a() {
        boolean z;
        synchronized (f.class) {
            z = true;
            if (c() != 1) {
                z = false;
            }
        }
        return z;
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (f.class) {
            z = c() == 2;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038 A[Catch:{ Throwable -> 0x0043, all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039 A[Catch:{ Throwable -> 0x0043, all -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int c() {
        /*
            java.lang.Class<com.xiaomi.channel.commonutils.android.f> r0 = com.xiaomi.channel.commonutils.android.f.class
            monitor-enter(r0)
            int r1 = a     // Catch:{ all -> 0x0073 }
            if (r1 != 0) goto L_0x006f
            r1 = 0
            r2 = 0
            java.util.Properties r3 = new java.util.Properties     // Catch:{ Throwable -> 0x0049 }
            r3.<init>()     // Catch:{ Throwable -> 0x0049 }
            java.io.File r4 = new java.io.File     // Catch:{ Throwable -> 0x0049 }
            java.io.File r5 = android.os.Environment.getRootDirectory()     // Catch:{ Throwable -> 0x0049 }
            java.lang.String r6 = "build.prop"
            r4.<init>(r5, r6)     // Catch:{ Throwable -> 0x0049 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0049 }
            r5.<init>(r4)     // Catch:{ Throwable -> 0x0049 }
            r3.load(r5)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            java.lang.String r4 = "ro.miui.ui.version.code"
            java.lang.String r4 = r3.getProperty(r4, r2)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            r6 = 1
            if (r4 != 0) goto L_0x0035
            java.lang.String r4 = "ro.miui.ui.version.name"
            java.lang.String r2 = r3.getProperty(r4, r2)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            if (r2 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r2 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r6 = 2
        L_0x003a:
            a = r6     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r5)     // Catch:{ all -> 0x0073 }
            goto L_0x0054
        L_0x0040:
            r1 = move-exception
            r2 = r5
            goto L_0x006b
        L_0x0043:
            r2 = move-exception
            r3 = r2
            r2 = r5
            goto L_0x004a
        L_0x0047:
            r1 = move-exception
            goto L_0x006b
        L_0x0049:
            r3 = move-exception
        L_0x004a:
            java.lang.String r4 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r4, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0047 }
            a = r1     // Catch:{ all -> 0x0047 }
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r2)     // Catch:{ all -> 0x0073 }
        L_0x0054:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r1.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "isMIUI's value is:"
            r1.append(r2)     // Catch:{ all -> 0x0073 }
            int r2 = a     // Catch:{ all -> 0x0073 }
            r1.append(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0073 }
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ all -> 0x0073 }
            goto L_0x006f
        L_0x006b:
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r2)     // Catch:{ all -> 0x0073 }
            throw r1     // Catch:{ all -> 0x0073 }
        L_0x006f:
            int r1 = a     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)
            return r1
        L_0x0073:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.f.c():int");
    }
}
