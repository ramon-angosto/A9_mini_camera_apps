package com.huawei.android.pushagent.b.a.a.a;

import com.huawei.android.pushagent.b.a.a.a;

public class c extends com.huawei.android.pushagent.b.a.a.c {
    public c(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() throws java.lang.Exception {
        /*
            r6 = this;
            r0 = 0
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            java.lang.String r2 = "PushLogAC2705"
            if (r1 == 0) goto L_0x00bf
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            java.net.Socket r1 = r1.c()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            if (r1 != 0) goto L_0x0015
            goto L_0x00bf
        L_0x0015:
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            java.net.Socket r1 = r1.c()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            r3.<init>()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            java.lang.String r4 = "socket timeout is "
            r3.append(r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            int r1 = r1.getSoTimeout()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            r3.append(r1)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            com.huawei.android.pushagent.c.a.e.a(r2, r1)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            java.io.InputStream r1 = r1.d()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
        L_0x003d:
            boolean r3 = r6.isInterrupted()     // Catch:{ Exception -> 0x00bd }
            if (r3 != 0) goto L_0x00a6
            com.huawei.android.pushagent.b.a.a.a r3 = r6.c     // Catch:{ Exception -> 0x00bd }
            com.huawei.android.pushagent.b.a.b.b r3 = r3.c     // Catch:{ Exception -> 0x00bd }
            boolean r3 = r3.b()     // Catch:{ Exception -> 0x00bd }
            if (r3 == 0) goto L_0x00a6
            if (r1 == 0) goto L_0x0058
            com.huawei.android.pushagent.a.a.a.b r3 = com.huawei.android.pushagent.a.a.a.b.b(r1)     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            goto L_0x005e
        L_0x0054:
            r3 = move-exception
            goto L_0x0075
        L_0x0056:
            r3 = move-exception
            goto L_0x008e
        L_0x0058:
            java.lang.String r3 = "InputStream is null, get pollingMessage failed"
            com.huawei.android.pushagent.c.a.e.b(r2, r3)     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            r3 = r0
        L_0x005e:
            if (r3 == 0) goto L_0x003d
            com.huawei.android.pushagent.c.a.b()     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            r4.<init>()     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            java.lang.String r5 = "push_msg"
            r4.putSerializable(r5, r3)     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            com.huawei.android.pushagent.b.a.a.a r3 = r6.c     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            com.huawei.android.pushagent.b.a.a.c$a r5 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_MSG_RECEIVED     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            r3.a((com.huawei.android.pushagent.b.a.a.c.a) r5, (android.os.Bundle) r4)     // Catch:{ SocketException -> 0x0056, Exception -> 0x0054 }
            goto L_0x003d
        L_0x0075:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bd }
            r4.<init>()     // Catch:{ Exception -> 0x00bd }
            java.lang.String r5 = "call getEntityByCmdId cause:"
            r4.append(r5)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x00bd }
            r4.append(r5)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00bd }
            com.huawei.android.pushagent.c.a.e.c(r2, r4, r3)     // Catch:{ Exception -> 0x00bd }
            throw r3     // Catch:{ Exception -> 0x00bd }
        L_0x008e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bd }
            r4.<init>()     // Catch:{ Exception -> 0x00bd }
            java.lang.String r5 = "SocketException:"
            r4.append(r5)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00bd }
            r4.append(r3)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00bd }
            com.huawei.android.pushagent.c.a.e.a(r2, r3)     // Catch:{ Exception -> 0x00bd }
        L_0x00a6:
            if (r1 == 0) goto L_0x00ab
            r1.close()
        L_0x00ab:
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            if (r1 == 0) goto L_0x00bc
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            r1.a()
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            r1.c = r0
        L_0x00bc:
            return
        L_0x00bd:
            r2 = move-exception
            goto L_0x00db
        L_0x00bf:
            java.lang.String r1 = "no socket when in readSSLSocket"
            com.huawei.android.pushagent.c.a.e.d(r2, r1)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            if (r1 == 0) goto L_0x00d5
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            r1.a()
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            r1.c = r0
        L_0x00d5:
            return
        L_0x00d6:
            r2 = move-exception
            r1 = r0
            goto L_0x00e4
        L_0x00d9:
            r2 = move-exception
            r1 = r0
        L_0x00db:
            com.huawei.android.pushagent.a.c r3 = new com.huawei.android.pushagent.a.c     // Catch:{ all -> 0x00e3 }
            com.huawei.android.pushagent.a.c$a r4 = com.huawei.android.pushagent.a.c.a.Err_Read     // Catch:{ all -> 0x00e3 }
            r3.<init>((java.lang.Throwable) r2, (com.huawei.android.pushagent.a.c.a) r4)     // Catch:{ all -> 0x00e3 }
            throw r3     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r2 = move-exception
        L_0x00e4:
            if (r1 == 0) goto L_0x00e9
            r1.close()
        L_0x00e9:
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            if (r1 == 0) goto L_0x00fa
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            r1.a()
            com.huawei.android.pushagent.b.a.a.a r1 = r6.c
            r1.c = r0
        L_0x00fa:
            goto L_0x00fc
        L_0x00fb:
            throw r2
        L_0x00fc:
            goto L_0x00fb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.a.c.b():void");
    }
}
