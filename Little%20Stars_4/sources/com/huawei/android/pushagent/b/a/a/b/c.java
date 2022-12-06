package com.huawei.android.pushagent.b.a.a.b;

import com.huawei.android.pushagent.b.a.a.a;

public class c extends com.huawei.android.pushagent.b.a.a.c {
    public c(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:50|51|(3:53|54|(1:56)(1:57))(1:109)) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "call getEntityByCmdId(cmd:" + r6 + " Exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x014b, code lost:
        if (r2 != null) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0157, code lost:
        if (com.huawei.android.pushagent.b.a.a.c() == r12.c.e()) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0159, code lost:
        r7 = r12.c.c.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0162, code lost:
        r7 = r12.c.c.c();
        r8 = r12.c.e.b(false);
        r10 = com.huawei.android.pushagent.b.b.a.a(r12.b).Q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "call getEntityByCmdId(cmd:" + r6 + " cause InstantiationException");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0194, code lost:
        if (r2 != null) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a0, code lost:
        if (com.huawei.android.pushagent.b.a.a.c() == r12.c.e()) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01a2, code lost:
        r7 = r12.c.c.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01ac, code lost:
        r7 = r12.c.c.c();
        r8 = r12.c.e.b(false);
        r10 = com.huawei.android.pushagent.b.b.a.a(r12.b).Q();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0134 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x017d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() throws java.lang.Exception {
        /*
            r12 = this;
            java.lang.String r0 = "call getEntityByCmdId(cmd:"
            r1 = 0
            com.huawei.android.pushagent.b.a.a.a r2 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r2 = r2.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.lang.String r3 = "PushLogAC2705"
            if (r2 == 0) goto L_0x021e
            com.huawei.android.pushagent.b.a.a.a r2 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r2 = r2.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r2 = r2.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r2 != 0) goto L_0x0017
            goto L_0x021e
        L_0x0017:
            com.huawei.android.pushagent.b.a.a.a r2 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r2 = r2.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r2 = r2.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r2 == 0) goto L_0x0039
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r4.<init>()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.lang.String r5 = "socket timeout is "
            r4.append(r5)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            int r5 = r2.getSoTimeout()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r4.append(r5)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.lang.String r4 = r4.toString()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.c.a.e.a(r3, r4)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
        L_0x0039:
            com.huawei.android.pushagent.b.a.a.a r4 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r4 = r4.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.io.InputStream r1 = r4.d()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r4 = -1
            r5 = -1
            r6 = -1
        L_0x0044:
            boolean r7 = r12.isInterrupted()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r7 != 0) goto L_0x0202
            com.huawei.android.pushagent.b.a.a.a r7 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r7 = r7.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            boolean r7 = r7.b()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r7 == 0) goto L_0x0202
            if (r5 == r4) goto L_0x0059
            r6 = r5
            r5 = -1
            goto L_0x0065
        L_0x0059:
            if (r1 == 0) goto L_0x0060
            int r6 = r1.read()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x0065
        L_0x0060:
            java.lang.String r7 = "inputstream is null, cannot get cmdId"
            com.huawei.android.pushagent.c.a.e.a(r3, r7)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
        L_0x0065:
            if (r4 != r6) goto L_0x006e
            java.lang.String r0 = "read -1 data, socket may be close"
            com.huawei.android.pushagent.c.a.e.a(r3, r0)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x0202
        L_0x006e:
            r7 = 1
            byte[] r7 = new byte[r7]     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            byte r8 = (byte) r6     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r9 = 0
            r7[r9] = r8     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.lang.String r7 = com.huawei.android.pushagent.c.a.a((byte[]) r7)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r10.<init>()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.lang.String r11 = "received a msg cmdId:"
            r10.append(r11)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r10.append(r7)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.lang.String r10 = r10.toString()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.c.a.e.a(r3, r10)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            byte r10 = com.huawei.android.pushagent.a.b.l.c()     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            if (r10 != r8) goto L_0x00c2
            java.lang.String r10 = "is PushDataReqMessage set read TimeOut 100"
            com.huawei.android.pushagent.c.a.e.a(r3, r10)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            if (r2 == 0) goto L_0x00a0
            r10 = 100
            r2.setSoTimeout(r10)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            goto L_0x00a5
        L_0x00a0:
            java.lang.String r10 = "socket is null"
            com.huawei.android.pushagent.c.a.e.a(r3, r10)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
        L_0x00a5:
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            com.huawei.android.pushagent.a.b.a.b r8 = com.huawei.android.pushagent.a.b.a.a.a(r8, r1)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            if (r8 == 0) goto L_0x00ca
            r10 = r8
            com.huawei.android.pushagent.a.b.l r10 = (com.huawei.android.pushagent.a.b.l) r10     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            byte r11 = r10.i()     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            if (r11 == r4) goto L_0x00ca
            java.lang.String r11 = "is get next cmdId, so set it"
            com.huawei.android.pushagent.c.a.e.a(r3, r11)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            byte r5 = r10.i()     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            goto L_0x00ca
        L_0x00c2:
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            com.huawei.android.pushagent.a.b.a.b r8 = com.huawei.android.pushagent.a.b.a.a.a(r8, r1)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
        L_0x00ca:
            if (r8 == 0) goto L_0x00e1
            com.huawei.android.pushagent.c.a.b()     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            r7.<init>()     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            java.lang.String r10 = "push_msg"
            r7.putSerializable(r10, r8)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            com.huawei.android.pushagent.b.a.a.a r8 = r12.c     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            com.huawei.android.pushagent.b.a.a.c$a r10 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_MSG_RECEIVED     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            r8.a((com.huawei.android.pushagent.b.a.a.c.a) r10, (android.os.Bundle) r7)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            goto L_0x00f5
        L_0x00e1:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            r8.<init>()     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            java.lang.String r10 = "received invalid msg, cmdId"
            r8.append(r10)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            r8.append(r7)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            java.lang.String r7 = r8.toString()     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
            com.huawei.android.pushagent.c.a.e.d(r3, r7)     // Catch:{ InstantiationException -> 0x017d, Exception -> 0x0134 }
        L_0x00f5:
            if (r2 == 0) goto L_0x0044
            com.huawei.android.pushagent.b.a.a$a r7 = com.huawei.android.pushagent.b.a.a.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r8 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a$a r8 = r8.e()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r7 != r8) goto L_0x0110
            com.huawei.android.pushagent.b.a.a.a r7 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r7 = r7.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r7 = r7.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
        L_0x010b:
            r7.setSoTimeout(r9)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x0044
        L_0x0110:
            com.huawei.android.pushagent.b.a.a.a r7 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r7 = r7.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r7 = r7.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r8 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.b r8 = r8.e     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r8 = r8.b((boolean) r9)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            android.content.Context r10 = r12.b     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.b.a r10 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r10)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r10 = r10.Q()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
        L_0x012a:
            long r8 = r8 + r10
            int r9 = (int) r8     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r7.setSoTimeout(r9)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x0044
        L_0x0131:
            r0 = move-exception
            goto L_0x01c8
        L_0x0134:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r7.<init>()     // Catch:{ all -> 0x0131 }
            r7.append(r0)     // Catch:{ all -> 0x0131 }
            r7.append(r6)     // Catch:{ all -> 0x0131 }
            java.lang.String r8 = " Exception"
            r7.append(r8)     // Catch:{ all -> 0x0131 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0131 }
            com.huawei.android.pushagent.c.a.e.d(r3, r7)     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0044
            com.huawei.android.pushagent.b.a.a$a r7 = com.huawei.android.pushagent.b.a.a.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r8 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a$a r8 = r8.e()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r7 != r8) goto L_0x0162
            com.huawei.android.pushagent.b.a.a.a r7 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r7 = r7.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r7 = r7.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x010b
        L_0x0162:
            com.huawei.android.pushagent.b.a.a.a r7 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r7 = r7.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r7 = r7.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r8 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.b r8 = r8.e     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r8 = r8.b((boolean) r9)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            android.content.Context r10 = r12.b     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.b.a r10 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r10)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r10 = r10.Q()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x012a
        L_0x017d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r7.<init>()     // Catch:{ all -> 0x0131 }
            r7.append(r0)     // Catch:{ all -> 0x0131 }
            r7.append(r6)     // Catch:{ all -> 0x0131 }
            java.lang.String r8 = " cause InstantiationException"
            r7.append(r8)     // Catch:{ all -> 0x0131 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0131 }
            com.huawei.android.pushagent.c.a.e.d(r3, r7)     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0044
            com.huawei.android.pushagent.b.a.a$a r7 = com.huawei.android.pushagent.b.a.a.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r8 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a$a r8 = r8.e()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r7 != r8) goto L_0x01ac
            com.huawei.android.pushagent.b.a.a.a r7 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r7 = r7.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r7 = r7.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x010b
        L_0x01ac:
            com.huawei.android.pushagent.b.a.a.a r7 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r7 = r7.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r7 = r7.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r8 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.b r8 = r8.e     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r8 = r8.b((boolean) r9)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            android.content.Context r10 = r12.b     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.b.a r10 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r10)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r10 = r10.Q()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x012a
        L_0x01c8:
            if (r2 == 0) goto L_0x0201
            com.huawei.android.pushagent.b.a.a$a r2 = com.huawei.android.pushagent.b.a.a.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r3 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a$a r3 = r3.e()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            if (r2 != r3) goto L_0x01e2
            com.huawei.android.pushagent.b.a.a.a r2 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r2 = r2.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r2 = r2.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r2.setSoTimeout(r9)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            goto L_0x0201
        L_0x01e2:
            com.huawei.android.pushagent.b.a.a.a r2 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.b.b r2 = r2.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            java.net.Socket r2 = r2.c()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r3 = r12.c     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.b r3 = r3.e     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r3 = r3.b((boolean) r9)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            android.content.Context r5 = r12.b     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.b.a r5 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r5)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r5 = r5.Q()     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            long r3 = r3 + r5
            int r4 = (int) r3     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            r2.setSoTimeout(r4)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
        L_0x0201:
            throw r0     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
        L_0x0202:
            if (r1 == 0) goto L_0x0207
            r1.close()
        L_0x0207:
            com.huawei.android.pushagent.b.a.a.a r0 = r12.c
            com.huawei.android.pushagent.b.a.b.b r0 = r0.c
            if (r0 == 0) goto L_0x0214
            com.huawei.android.pushagent.b.a.a.a r0 = r12.c
            com.huawei.android.pushagent.b.a.b.b r0 = r0.c
            r0.a()
        L_0x0214:
            com.huawei.android.pushagent.a.c r0 = new com.huawei.android.pushagent.a.c
            com.huawei.android.pushagent.a.c$a r1 = com.huawei.android.pushagent.a.c.a.Err_Read
            java.lang.String r2 = " read normal Exit"
            r0.<init>((java.lang.String) r2, (com.huawei.android.pushagent.a.c.a) r1)
            throw r0
        L_0x021e:
            java.lang.String r0 = "no socket when in readSSLSocket"
            com.huawei.android.pushagent.c.a.e.d(r3, r0)     // Catch:{ SocketException -> 0x0245, IOException -> 0x023c, Exception -> 0x0233 }
            com.huawei.android.pushagent.b.a.a.a r0 = r12.c
            com.huawei.android.pushagent.b.a.b.b r0 = r0.c
            if (r0 == 0) goto L_0x0230
            com.huawei.android.pushagent.b.a.a.a r0 = r12.c
            com.huawei.android.pushagent.b.a.b.b r0 = r0.c
            r0.a()
        L_0x0230:
            return
        L_0x0231:
            r0 = move-exception
            goto L_0x024e
        L_0x0233:
            r0 = move-exception
            com.huawei.android.pushagent.a.c r2 = new com.huawei.android.pushagent.a.c     // Catch:{ all -> 0x0231 }
            com.huawei.android.pushagent.a.c$a r3 = com.huawei.android.pushagent.a.c.a.Err_Read     // Catch:{ all -> 0x0231 }
            r2.<init>((java.lang.Throwable) r0, (com.huawei.android.pushagent.a.c.a) r3)     // Catch:{ all -> 0x0231 }
            throw r2     // Catch:{ all -> 0x0231 }
        L_0x023c:
            r0 = move-exception
            com.huawei.android.pushagent.a.c r2 = new com.huawei.android.pushagent.a.c     // Catch:{ all -> 0x0231 }
            com.huawei.android.pushagent.a.c$a r3 = com.huawei.android.pushagent.a.c.a.Err_Read     // Catch:{ all -> 0x0231 }
            r2.<init>((java.lang.Throwable) r0, (com.huawei.android.pushagent.a.c.a) r3)     // Catch:{ all -> 0x0231 }
            throw r2     // Catch:{ all -> 0x0231 }
        L_0x0245:
            r0 = move-exception
            com.huawei.android.pushagent.a.c r2 = new com.huawei.android.pushagent.a.c     // Catch:{ all -> 0x0231 }
            com.huawei.android.pushagent.a.c$a r3 = com.huawei.android.pushagent.a.c.a.Err_Read     // Catch:{ all -> 0x0231 }
            r2.<init>((java.lang.Throwable) r0, (com.huawei.android.pushagent.a.c.a) r3)     // Catch:{ all -> 0x0231 }
            throw r2     // Catch:{ all -> 0x0231 }
        L_0x024e:
            if (r1 == 0) goto L_0x0253
            r1.close()
        L_0x0253:
            com.huawei.android.pushagent.b.a.a.a r1 = r12.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            if (r1 == 0) goto L_0x0260
            com.huawei.android.pushagent.b.a.a.a r1 = r12.c
            com.huawei.android.pushagent.b.a.b.b r1 = r1.c
            r1.a()
        L_0x0260:
            goto L_0x0262
        L_0x0261:
            throw r0
        L_0x0262:
            goto L_0x0261
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.b.c.b():void");
    }
}
