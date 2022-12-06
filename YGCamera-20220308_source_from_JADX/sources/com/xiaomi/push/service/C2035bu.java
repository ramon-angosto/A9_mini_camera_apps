package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.C1872hs;

/* renamed from: com.xiaomi.push.service.bu */
final class C2035bu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3851a;

    /* renamed from: a */
    final /* synthetic */ C1872hs f3852a;

    C2035bu(Context context, C1872hs hsVar) {
        this.f3851a = context;
        this.f3852a = hsVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a A[SYNTHETIC, Splitter:B:25:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.Object r0 = com.xiaomi.push.service.C2034bt.f3850a
            monitor-enter(r0)
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            android.content.Context r3 = r5.f3851a     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.lang.String r4 = "tiny_data.lock"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r2)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.lang.String r4 = "rw"
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.nio.channels.FileChannel r2 = r3.getChannel()     // Catch:{ Exception -> 0x003e }
            java.nio.channels.FileLock r1 = r2.lock()     // Catch:{ Exception -> 0x003e }
            android.content.Context r2 = r5.f3851a     // Catch:{ Exception -> 0x003e }
            com.xiaomi.push.hs r4 = r5.f3852a     // Catch:{ Exception -> 0x003e }
            com.xiaomi.push.service.C2034bt.m5186c(r2, r4)     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x003a
            boolean r2 = r1.isValid()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x003a
            r1.release()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r1 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0070 }
        L_0x003a:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r3)     // Catch:{ all -> 0x0070 }
            goto L_0x0059
        L_0x003e:
            r2 = move-exception
            goto L_0x0045
        L_0x0040:
            r2 = move-exception
            r3 = r1
            goto L_0x005c
        L_0x0043:
            r2 = move-exception
            r3 = r1
        L_0x0045:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r2)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x003a
            boolean r2 = r1.isValid()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x003a
            r1.release()     // Catch:{ IOException -> 0x0054 }
            goto L_0x003a
        L_0x0054:
            r1 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0070 }
            goto L_0x003a
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            return
        L_0x005b:
            r2 = move-exception
        L_0x005c:
            if (r1 == 0) goto L_0x006c
            boolean r4 = r1.isValid()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x006c
            r1.release()     // Catch:{ IOException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r1 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0070 }
        L_0x006c:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r3)     // Catch:{ all -> 0x0070 }
            throw r2     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0074
        L_0x0073:
            throw r1
        L_0x0074:
            goto L_0x0073
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2035bu.run():void");
    }
}
