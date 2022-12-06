package com.bytedance.sdk.openadsdk.core.settings;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SdkSwitch */
public class f {
    private static final AtomicInteger a = new AtomicInteger(1);

    public static boolean a() {
        return a.get() == 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void a(int r3) {
        /*
            r0 = 1
            if (r3 == r0) goto L_0x0007
            r1 = 2
            if (r3 == r1) goto L_0x0007
            return
        L_0x0007:
            r1 = 0
            java.util.concurrent.atomic.AtomicInteger r2 = a     // Catch:{ all -> 0x001a }
            int r2 = r2.get()     // Catch:{ all -> 0x001a }
            if (r2 == r3) goto L_0x0018
            java.util.concurrent.atomic.AtomicInteger r1 = a     // Catch:{ all -> 0x0016 }
            r1.set(r3)     // Catch:{ all -> 0x0016 }
            goto L_0x001f
        L_0x0016:
            r3 = move-exception
            goto L_0x001c
        L_0x0018:
            r0 = r1
            goto L_0x001f
        L_0x001a:
            r3 = move-exception
            r0 = r1
        L_0x001c:
            r3.printStackTrace()
        L_0x001f:
            if (r0 == 0) goto L_0x0048
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "switch status changed: "
            r3.append(r0)
            boolean r0 = a()
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "SdkSwitch"
            android.util.Log.e(r0, r3)
            boolean r3 = a()
            if (r3 == 0) goto L_0x0045
            com.bytedance.sdk.openadsdk.c.a.c.b()
            goto L_0x0048
        L_0x0045:
            com.bytedance.sdk.openadsdk.c.a.c.c()
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.f.a(int):void");
    }
}
