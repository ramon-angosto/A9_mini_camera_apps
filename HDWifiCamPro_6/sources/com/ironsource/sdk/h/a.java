package com.ironsource.sdk.h;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.sdk.k.c;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends Handler {
    public final ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>();

    public a(Looper looper) {
        super(looper);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023 A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[Catch:{ all -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r6.obj     // Catch:{ all -> 0x003d }
            com.ironsource.sdk.h.c r0 = (com.ironsource.sdk.h.c) r0     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r0.getPath()     // Catch:{ all -> 0x003d }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.sdk.k.c> r2 = r5.a     // Catch:{ all -> 0x003d }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003d }
            com.ironsource.sdk.k.c r2 = (com.ironsource.sdk.k.c) r2     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0013
            return
        L_0x0013:
            int r3 = r6.what     // Catch:{ all -> 0x003d }
            r4 = 1016(0x3f8, float:1.424E-42)
            if (r3 == r4) goto L_0x0020
            r4 = 1015(0x3f7, float:1.422E-42)
            if (r3 != r4) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r3 = 0
            goto L_0x0021
        L_0x0020:
            r3 = 1
        L_0x0021:
            if (r3 == 0) goto L_0x0027
            r2.a(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0037
        L_0x0027:
            com.ironsource.sdk.g.e r3 = new com.ironsource.sdk.g.e     // Catch:{ all -> 0x003d }
            int r4 = r6.what     // Catch:{ all -> 0x003d }
            int r6 = r6.what     // Catch:{ all -> 0x003d }
            java.lang.String r6 = com.ironsource.environment.a.AnonymousClass1.a((int) r6)     // Catch:{ all -> 0x003d }
            r3.<init>(r4, r6)     // Catch:{ all -> 0x003d }
            r2.a(r0, r3)     // Catch:{ all -> 0x003d }
        L_0x0037:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.sdk.k.c> r6 = r5.a     // Catch:{ all -> 0x003d }
            r6.remove(r1)     // Catch:{ all -> 0x003d }
            return
        L_0x003d:
            r6 = move-exception
            r6.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.h.a.handleMessage(android.os.Message):void");
    }
}
