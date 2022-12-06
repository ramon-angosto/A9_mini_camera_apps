package com.huawei.android.pushagent.b.c;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.Serializable;

public class a extends com.huawei.android.pushagent.b.a {
    int a = -1;

    public a(Context context) {
        try {
            this.a = b.a(context);
            a(context, com.huawei.android.pushagent.b.e.b.b(context).size() != 0 ? new Intent("com.huawei.action.CONNECT_PUSHSRV_PUSHSRV").setPackage(context.getPackageName()) : new Intent("com.huawei.action.CONNECT_PUSHSRV").setPackage(context.getPackageName()));
        } catch (Exception e) {
            e.c("PushLogAC2705", "call switchChannel cause Exception", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "call channel.close cause exceptino:" + r7.toString(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x017b, code lost:
        if ("com.huawei.android.push.intent.TRS_QUERY_SUCCESS".equals(r13) != false) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0297, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0298, code lost:
        r13 = new java.lang.StringBuilder();
        r13.append("call connectSrv cause Exceptino:");
        r12 = r12.toString();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0297 A[ExcHandler: c (r12v3 'e' com.huawei.android.pushagent.a.c A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r0 = "com.huawei.android.push.intent.TRS_QUERY_SUCCESS"
            java.lang.String r1 = "call connectSrv cause Exceptino:"
            java.lang.String r2 = "PushLogAC2705"
            java.lang.String r3 = "cloudpush_isNoDelayConnect"
            r4 = 0
            boolean r3 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r12, (java.lang.String) r3, (boolean) r4)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.util.ArrayList r5 = com.huawei.android.pushagent.b.e.b.b(r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r3 != 0) goto L_0x005a
            int r6 = r5.size()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r6 != 0) goto L_0x005a
            com.huawei.android.pushagent.b.e.b r6 = com.huawei.android.pushagent.b.e.b.a(r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.util.HashMap r6 = r6.a     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            int r6 = r6.size()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r6 != 0) goto L_0x005a
            com.huawei.android.pushagent.b.a.a r13 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r13.b()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = "no push client, stop push apk service"
            com.huawei.android.pushagent.c.a.e.b(r2, r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            android.content.Intent r13 = new android.content.Intent     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r0 = "com.huawei.intent.action.PUSH_OFF"
            r13.<init>(r0)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r0 = r12.getPackageName()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            android.content.Intent r13 = r13.setPackage(r0)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r0 = "Remote_Package_Name"
            java.lang.String r3 = r12.getPackageName()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            android.content.Intent r13 = r13.putExtra(r0, r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.b.a r0 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            long r3 = r0.P()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            com.huawei.android.pushagent.c.a.a.c(r12, r13, r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            return
        L_0x005a:
            com.huawei.android.pushagent.b.b.a r6 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            boolean r6 = r6.V()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r6 != 0) goto L_0x0070
            java.lang.String r6 = "TRS is invalid, so need to query TRS"
            com.huawei.android.pushagent.c.a.e.b(r2, r6)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.b.a r6 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r6.c(r4)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x0070:
            boolean r6 = r0.equals(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r6 == 0) goto L_0x008b
            com.huawei.android.pushagent.b.a.a.a r6 = com.huawei.android.pushagent.b.a.a.f()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a.b r6 = r6.e     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r6.f()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a.a r6 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a.b r6 = r6.e     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r6.f()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.d.a.c(r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x008b:
            int r6 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r7 = -1
            if (r7 == r6) goto L_0x0096
            int r8 = r11.a     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r6 == r8) goto L_0x012d
        L_0x0096:
            java.lang.String r8 = "socket_add_info"
            java.lang.String r9 = "com.huawei.android.push.intent.SOCKET_INFO"
            java.lang.String r10 = "cloudpush_isSupportCollectSocketInfo"
            if (r7 != r6) goto L_0x00ca
            boolean r7 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r12, (java.lang.String) r10, (boolean) r4)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r7 == 0) goto L_0x00c4
            com.huawei.android.pushagent.b.a.a.a r7 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            boolean r7 = r7.a()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r7 != 0) goto L_0x00c4
            android.content.Intent r7 = new android.content.Intent     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r7.<init>(r9)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r9 = "no network."
            android.content.Intent r7 = r7.putExtra(r8, r9)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r8 = r12.getPackageName()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            android.content.Intent r7 = r7.setPackage(r8)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.sendBroadcast(r7)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x00c4:
            java.lang.String r7 = "no network in ConnectMgrProcessor:connect, so close socket"
        L_0x00c6:
            com.huawei.android.pushagent.c.a.e.a(r2, r7)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            goto L_0x010c
        L_0x00ca:
            boolean r7 = com.huawei.android.pushagent.b.b.c.a((android.content.Context) r12, (java.lang.String) r10, (boolean) r4)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r7 == 0) goto L_0x00f0
            com.huawei.android.pushagent.b.a.a.a r7 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            boolean r7 = r7.a()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r7 != 0) goto L_0x00f0
            android.content.Intent r7 = new android.content.Intent     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r7.<init>(r9)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r9 = "network switch."
            android.content.Intent r7 = r7.putExtra(r8, r9)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r8 = r12.getPackageName()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            android.content.Intent r7 = r7.setPackage(r8)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.sendBroadcast(r7)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x00f0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r7.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r8 = "net work switch from:"
            r7.append(r8)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            int r8 = r11.a     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r7.append(r8)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r8 = " to "
            r7.append(r8)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r7.append(r6)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r7 = r7.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            goto L_0x00c6
        L_0x010c:
            com.huawei.android.pushagent.b.a.a r7 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r12)     // Catch:{ Exception -> 0x0114, c -> 0x0297 }
            r7.b()     // Catch:{ Exception -> 0x0114, c -> 0x0297 }
            goto L_0x012d
        L_0x0114:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r8.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r9 = "call channel.close cause exceptino:"
            r8.append(r9)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r9 = r7.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r8.append(r9)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r8 = r8.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.c.a.e.c(r2, r8, r7)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x012d:
            int r7 = r11.a     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r8 = 1
            if (r7 == r6) goto L_0x0134
            r7 = 1
            goto L_0x0135
        L_0x0134:
            r7 = 0
        L_0x0135:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r9.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r10 = "lastnetWorkType:"
            r9.append(r10)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            int r10 = r11.a     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r9.append(r10)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r10 = " "
            r9.append(r10)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r10 = "curNetWorkType:"
            r9.append(r10)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r9.append(r6)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r9 = r9.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.c.a.e.b(r2, r9)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r11.a = r6     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r3 == 0) goto L_0x016d
            com.huawei.android.pushagent.b.a.a r12 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a$a r13 = com.huawei.android.pushagent.b.a.a.C0032a.ConnectEntity_Push     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.a((com.huawei.android.pushagent.b.a.a.C0032a) r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a.a r12 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.a((boolean) r8)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            return
        L_0x016d:
            java.lang.String r3 = "android.net.conn.CONNECTIVITY_CHANGE"
            boolean r3 = r3.equals(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r6 = "com.huawei.action.CONNECT_PUSHSRV_PUSHSRV"
            if (r3 != 0) goto L_0x017d
            boolean r0 = r0.equals(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r0 == 0) goto L_0x01ca
        L_0x017d:
            com.huawei.android.pushagent.b.a.a.a r0 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            boolean r0 = r0.a()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r0 != 0) goto L_0x01ca
            com.huawei.android.pushagent.b.a.a$a r0 = com.huawei.android.pushagent.b.a.a.c()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a$a r3 = com.huawei.android.pushagent.b.a.a.C0032a.ConnectEntity_Push     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r0 == r3) goto L_0x01ca
            int r0 = r5.size()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r0 == 0) goto L_0x01ca
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r3 = "received "
            r0.append(r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = ", cur ConType:"
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a$a r13 = com.huawei.android.pushagent.b.a.a.c()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = ", but have need depose size:"
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            int r13 = r5.size()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = r0.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.c.a.e.b(r2, r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            android.content.Intent r13 = new android.content.Intent     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r13.<init>(r6)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r11.a((android.content.Context) r12, (android.content.Intent) r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            return
        L_0x01ca:
            boolean r0 = r6.equals(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r3 = "get "
            if (r0 == 0) goto L_0x0201
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = " so get a pushSrv to connect"
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = r0.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.c.a.e.a(r2, r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            int r13 = r5.size()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r13 == 0) goto L_0x01f8
            com.huawei.android.pushagent.b.a.a r12 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a$a r13 = com.huawei.android.pushagent.b.a.a.C0032a.ConnectEntity_Push     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.a((com.huawei.android.pushagent.b.a.a.C0032a) r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x01f8:
            com.huawei.android.pushagent.b.a.a.a r12 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x01fc:
            r12.a((boolean) r8)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            goto L_0x02ae
        L_0x0201:
            java.lang.String r0 = "com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV"
            boolean r0 = r0.equals(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r0 == 0) goto L_0x0225
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.append(r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = " so get a pollingSrv to connect"
            r12.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r12 = r12.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.c.a.e.a(r2, r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a.a r12 = com.huawei.android.pushagent.b.a.a.f()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            goto L_0x01fc
        L_0x0225:
            com.huawei.android.pushagent.b.a.a r0 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a.a r0 = r0.d()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            boolean r0 = r0.a()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r0 != 0) goto L_0x0266
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = " so get a srv to connect"
            r0.append(r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r13 = r0.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.c.a.e.a(r2, r13)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            if (r7 == 0) goto L_0x025a
            com.huawei.android.pushagent.b.d.b r13 = com.huawei.android.pushagent.b.d.b.a(r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.d.b$b r0 = com.huawei.android.pushagent.b.d.b.C0035b.NETWORK_CHANGE     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r3.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r13.a(r12, r0, r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
        L_0x025a:
            com.huawei.android.pushagent.b.a.a r12 = com.huawei.android.pushagent.b.a.a.a((android.content.Context) r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.b.a.a.a r12 = r12.d()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r12.a((boolean) r4)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            goto L_0x02ae
        L_0x0266:
            com.huawei.android.pushagent.b.a.a.b r12 = com.huawei.android.pushagent.b.a.a.b(r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            long r12 = r12.e()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.<init>()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r3 = "pushChannel already connect, so needn't handle, nextSendHearBeatTime:"
            r0.append(r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss SSS"
            java.lang.String r12 = com.huawei.android.pushagent.c.a.a((long) r12, (java.lang.String) r3)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            r0.append(r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            java.lang.String r12 = r0.toString()     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            com.huawei.android.pushagent.c.a.e.a(r2, r12)     // Catch:{ c -> 0x0297, Exception -> 0x0289 }
            goto L_0x02ae
        L_0x0289:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r1)
            java.lang.String r12 = r12.toString()
            goto L_0x02a4
        L_0x0297:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r1)
            java.lang.String r12 = r12.toString()
        L_0x02a4:
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.huawei.android.pushagent.c.a.e.d(r2, r12)
        L_0x02ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.c.a.a(android.content.Context, java.lang.String):void");
    }

    private boolean a(Context context, Intent intent, String str, String str2) {
        return ("com.huawei.intent.action.PUSH".equals(str) && "com.huawei.android.push.intent.HEARTBEAT_REQ".equals(str2)) || "com.huawei.android.push.intent.REFRESH_PUSH_CHANNEL".equals(str) || "android.intent.action.TIME_SET".equals(str) || "android.intent.action.TIMEZONE_CHANGED".equals(str);
    }

    private boolean a(Context context, String str, String str2) {
        return "android.net.conn.CONNECTIVITY_CHANGE".equals(str) || "com.huawei.action.CONNECT_PUSHSRV".equals(str) || "com.huawei.action.CONNECT_PUSHSRV_PUSHSRV".equals(str) || "com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV".equals(str) || "com.huawei.android.push.intent.TRS_QUERY_SUCCESS".equals(str) || ("com.huawei.intent.action.PUSH".equals(str) && "com.huawei.intent.action.PUSH_ON".equals(str2));
    }

    public void a(Context context, Intent intent) {
        String str;
        Intent intent2;
        try {
            e.a("PushLogAC2705", "enter ConnectMgrProcessor:onReceive(intent:" + intent + " context:" + context);
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("EXTRA_INTENT_TYPE");
            if ("com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT".equals(action)) {
                if (c.a(context, "cloudpush_isSupportCollectSocketInfo", false)) {
                    context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_add_info", "heart beat time out.").setPackage(context.getPackageName()));
                }
                com.huawei.android.pushagent.b.a.a.a(context).a(intent);
            } else if (a(context, intent, action, stringExtra)) {
                com.huawei.android.pushagent.b.a.a.a(context).a(intent);
            } else if (a(context, action, stringExtra)) {
                a(context, action);
            } else if ("com.huawei.android.push.intent.CHANNEL_CLOSED".equals(action)) {
                e.b("PushLogAC2705", "receive the channal closed action.");
                Serializable serializableExtra = intent.getSerializableExtra("push_exception");
                context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_event_type", 0).putExtra("socket_next_connect_time", "").putExtra("socket_exception", serializableExtra != null ? serializableExtra.toString() : "").setPackage(context.getPackageName()));
            } else {
                if ("com.huawei.android.push.intent.CONNECTING".equals(action)) {
                    intent2 = new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_event_type", 2).setPackage(context.getPackageName());
                } else if ("com.huawei.android.push.intent.CONNECTED".equals(action)) {
                    intent2 = new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_event_type", 1).setPackage(context.getPackageName());
                } else {
                    if (!"com.huawei.intent.action.PUSH_OFF".equals(action)) {
                        if (!"com.huawei.android.push.intent.inner.STOP_SERVICE".equals(action)) {
                            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                                int intExtra = intent.getIntExtra("status", 1);
                                com.huawei.android.pushagent.b.a.a.b(context).a(intExtra);
                                if (2 != intExtra) {
                                    if (5 != intExtra) {
                                        str = "current battery no charging :" + intExtra;
                                        e.a("PushLogAC2705", str);
                                        return;
                                    }
                                }
                                str = "current battery is charging!";
                                e.a("PushLogAC2705", str);
                                return;
                            }
                            return;
                        }
                    }
                    String stringExtra2 = intent.getStringExtra("Remote_Package_Name");
                    if (stringExtra2 != null) {
                        if (stringExtra2.equals(context.getPackageName())) {
                            if (c.a(context, "cloudpush_isSupportCollectSocketInfo", false)) {
                                context.sendBroadcast(new Intent("com.huawei.android.push.intent.SOCKET_INFO").putExtra("socket_add_info", "receive push off action.").setPackage(context.getPackageName()));
                            }
                            com.huawei.android.pushagent.b.a.a.a(context).b();
                            if ("com.huawei.intent.action.PUSH_OFF".equals(action)) {
                                PushService.b();
                                return;
                            }
                            return;
                        }
                    }
                    e.a("PushLogAC2705", "need stop PkgName:" + stringExtra2 + " is not me, need not stop!");
                    return;
                }
                context.sendBroadcast(intent2);
            }
        } catch (Exception e) {
            e.a("PushLogAC2705", e.toString(), (Throwable) e);
        }
    }
}
