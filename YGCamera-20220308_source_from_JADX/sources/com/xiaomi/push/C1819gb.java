package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C2061i;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* renamed from: com.xiaomi.push.gb */
public abstract class C1819gb extends C1809fu {

    /* renamed from: a */
    protected Exception f2471a = null;

    /* renamed from: a */
    protected Socket f2472a;

    /* renamed from: b */
    protected XMPushService f2473b;

    /* renamed from: c */
    private int f2474c;

    /* renamed from: c */
    String f2475c = null;

    /* renamed from: d */
    private String f2476d;

    /* renamed from: e */
    protected volatile long f2477e = 0;

    /* renamed from: f */
    protected volatile long f2478f = 0;

    /* renamed from: g */
    protected volatile long f2479g = 0;

    /* renamed from: h */
    private long f2480h = 0;

    public C1819gb(XMPushService xMPushService, C1811fv fvVar) {
        super(xMPushService, fvVar);
        this.f2473b = xMPushService;
    }

    /* renamed from: a */
    private void m3682a(C1811fv fvVar) {
        m3683a(fvVar.mo17674c(), fvVar.mo17670a());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0140, code lost:
        r1.f2479g = android.os.SystemClock.elapsedRealtime();
        com.xiaomi.channel.commonutils.logger.C1524b.m2141a("connected to " + r3 + " in " + r1.f2433a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0164, code lost:
        r2 = r24;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0181, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0182, code lost:
        r27 = r11;
        r28 = r12;
        r31 = r15;
        r29 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01cf, code lost:
        r0 = r3;
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01d3, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append(r27);
        r15 = r21;
        r0.append(r15);
        r0.append(r3);
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01f0, code lost:
        r12 = r3;
        r3 = r15;
        r31.mo17345b(r12, java.lang.System.currentTimeMillis() - r22, 0, r1.f2471a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0208, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0219, code lost:
        r11 = r0;
        r26 = r3;
        r25 = r9;
        r9 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x022a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x022b, code lost:
        r31 = r15;
        r13 = r21;
        r29 = 0;
        r15 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x026d, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x026f, code lost:
        r0 = r11 + r13 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0288, code lost:
        r25 = r9;
        r26 = r13;
        r9 = r15;
        r31.mo17345b(r3, java.lang.System.currentTimeMillis() - r22, 0, r1.f2471a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02a6, code lost:
        r25 = r9;
        r26 = r13;
        r9 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02bb, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02b7 A[EDGE_INSN: B:107:0x02b7->B:73:0x02b7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02b7 A[EDGE_INSN: B:109:0x02b7->B:73:0x02b7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0181 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:25:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0359  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3683a(java.lang.String r33, int r34) {
        /*
            r32 = this;
            r1 = r32
            r0 = r33
            r2 = r34
            java.lang.String r3 = "|"
            java.lang.String r4 = "\n"
            java.lang.String r5 = " err:"
            java.lang.String r6 = " port:"
            java.lang.String r7 = "SMACK: Could not connect to "
            java.lang.String r8 = "SMACK: Could not connect to:"
            r9 = 0
            r1.f2471a = r9
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "get bucket for host : "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.Integer r10 = com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r10)
            int r10 = r10.intValue()
            com.xiaomi.push.cq r15 = r32.mo17659a((java.lang.String) r33)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.xiaomi.channel.commonutils.logger.C1524b.m2151a((java.lang.Integer) r10)
            r10 = 1
            if (r15 == 0) goto L_0x0045
            java.util.ArrayList r9 = r15.mo17333a((boolean) r10)
        L_0x0045:
            com.xiaomi.push.cu r11 = com.xiaomi.push.C1702cu.mo17360a()
            com.xiaomi.push.cq r11 = r11.mo17366d(r0)
            if (r11 == 0) goto L_0x006e
            java.util.ArrayList r11 = r11.mo17333a((boolean) r10)
            java.util.Iterator r11 = r11.iterator()
        L_0x0057:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x006e
            java.lang.Object r12 = r11.next()
            java.lang.String r12 = (java.lang.String) r12
            int r13 = r9.indexOf(r12)
            r14 = -1
            if (r13 != r14) goto L_0x0057
            r9.add(r12)
            goto L_0x0057
        L_0x006e:
            boolean r11 = r9.isEmpty()
            if (r11 == 0) goto L_0x0077
            r9.add(r0)
        L_0x0077:
            boolean r0 = com.xiaomi.push.C1614ag.f1764a
            java.lang.String r11 = ""
            if (r0 == 0) goto L_0x00ab
            com.xiaomi.push.service.XMPushService r0 = r1.f2473b
            boolean r0 = com.xiaomi.push.C1938m.m4728b((android.content.Context) r0)
            if (r0 == 0) goto L_0x00ab
            java.lang.String r0 = "log.tag.debug.xmsf.ip"
            java.lang.String r0 = com.xiaomi.push.C2086t.m5370a(r0, r11)
            boolean r12 = android.text.TextUtils.isEmpty(r0)
            if (r12 != 0) goto L_0x00ab
            r9.clear()
            r9.add(r0)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "[debug] connect ip："
            r12.append(r13)
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
        L_0x00ab:
            r13 = 0
            r1.f2479g = r13
            long r18 = android.os.SystemClock.elapsedRealtime()
            com.xiaomi.push.service.XMPushService r0 = r1.f2473b
            java.lang.String r12 = com.xiaomi.push.C1653bi.m2669a((android.content.Context) r0)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.util.Iterator r9 = r9.iterator()
            r21 = r3
            r0 = 0
        L_0x00c5:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x0343
            java.lang.Object r16 = r9.next()
            r3 = r16
            java.lang.String r3 = (java.lang.String) r3
            long r22 = java.lang.System.currentTimeMillis()
            int r13 = r1.f2432a
            r14 = 1
            int r13 = r13 + r14
            r1.f2432a = r13
            int r24 = r0 + 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022a, all -> 0x0181 }
            r0.<init>()     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            java.lang.String r13 = "begin to connect to "
            r0.append(r13)     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r0.append(r3)     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            java.net.Socket r0 = r32.mo17639a()     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r1.f2472a = r0     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            java.net.InetSocketAddress r0 = com.xiaomi.push.C1700cs.m2904a((java.lang.String) r3, (int) r2)     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            java.net.Socket r13 = r1.f2472a     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r14 = 8000(0x1f40, float:1.121E-41)
            r13.connect(r0, r14)     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            java.lang.String r0 = "tcp connected"
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            java.net.Socket r0 = r1.f2472a     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r13 = 1
            r0.setTcpNoDelay(r13)     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r1.f2476d = r3     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r32.mo17639a()     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            long r25 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            long r13 = r25 - r22
            r1.f2433a = r13     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r1.f2443b = r12     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            if (r15 == 0) goto L_0x0136
            long r13 = r1.f2433a     // Catch:{ Exception -> 0x0175, all -> 0x0181 }
            r25 = 0
            r27 = r11
            r11 = r15
            r28 = r12
            r12 = r3
            r20 = 1
            r29 = 0
            r31 = r15
            r15 = r25
            r11.mo17344b(r12, r13, r15)     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            goto L_0x0140
        L_0x0136:
            r27 = r11
            r28 = r12
            r31 = r15
            r20 = 1
            r29 = 0
        L_0x0140:
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            r1.f2479g = r11     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            r0.<init>()     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            java.lang.String r11 = "connected to "
            r0.append(r11)     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            r0.append(r3)     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            java.lang.String r11 = " in "
            r0.append(r11)     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            long r11 = r1.f2433a     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            r0.append(r11)     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ Exception -> 0x016c, all -> 0x016a }
            r2 = r24
            r0 = r27
            goto L_0x0349
        L_0x016a:
            r0 = move-exception
            goto L_0x018c
        L_0x016c:
            r0 = move-exception
            r13 = r21
            r11 = r27
            r15 = r28
            goto L_0x0234
        L_0x0175:
            r0 = move-exception
            r31 = r15
            r20 = 1
            r29 = 0
            r15 = r12
            r13 = r21
            goto L_0x0234
        L_0x0181:
            r0 = move-exception
            r27 = r11
            r28 = r12
            r31 = r15
            r20 = 1
            r29 = 0
        L_0x018c:
            java.lang.Exception r11 = new java.lang.Exception     // Catch:{ all -> 0x0221 }
            java.lang.String r12 = "abnormal exception"
            r11.<init>(r12, r0)     // Catch:{ all -> 0x0221 }
            r1.f2471a = r11     // Catch:{ all -> 0x0221 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0221 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)
            r10.append(r7)
            r10.append(r3)
            r10.append(r6)
            r10.append(r2)
            r10.append(r5)
            java.lang.Exception r0 = r1.f2471a
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            r10.append(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r27)
            if (r0 == 0) goto L_0x01d3
            r0 = r3
            r15 = r21
            goto L_0x01e9
        L_0x01d3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r11 = r27
            r0.append(r11)
            r15 = r21
            r0.append(r15)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
        L_0x01e9:
            java.lang.Exception r11 = r1.f2471a
            com.xiaomi.push.C1860hi.m3867a((java.lang.String) r3, (java.lang.Exception) r11)
            if (r31 == 0) goto L_0x0208
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = r11 - r22
            r16 = 0
            java.lang.Exception r12 = r1.f2471a
            r11 = r31
            r21 = r12
            r12 = r3
            r3 = r15
            r15 = r16
            r17 = r21
            r11.mo17345b(r12, r13, r15, r17)
            goto L_0x0209
        L_0x0208:
            r3 = r15
        L_0x0209:
            com.xiaomi.push.service.XMPushService r11 = r1.f2473b
            java.lang.String r11 = com.xiaomi.push.C1653bi.m2669a((android.content.Context) r11)
            r15 = r28
            boolean r11 = android.text.TextUtils.equals(r15, r11)
            if (r11 != 0) goto L_0x0219
            goto L_0x02b7
        L_0x0219:
            r11 = r0
            r26 = r3
            r25 = r9
            r9 = r15
            goto L_0x02bc
        L_0x0221:
            r0 = move-exception
            r11 = r27
            r26 = r21
            r9 = r28
            goto L_0x02cd
        L_0x022a:
            r0 = move-exception
            r31 = r15
            r13 = r21
            r20 = 1
            r29 = 0
            r15 = r12
        L_0x0234:
            r1.f2471a = r0     // Catch:{ all -> 0x02c9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)
            r10.append(r7)
            r10.append(r3)
            r10.append(r6)
            r10.append(r2)
            r10.append(r5)
            java.lang.Exception r0 = r1.f2471a
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            r10.append(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto L_0x026f
            r0 = r3
            goto L_0x0281
        L_0x026f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r13)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
        L_0x0281:
            java.lang.Exception r11 = r1.f2471a
            com.xiaomi.push.C1860hi.m3867a((java.lang.String) r3, (java.lang.Exception) r11)
            if (r31 == 0) goto L_0x02a6
            long r11 = java.lang.System.currentTimeMillis()
            long r16 = r11 - r22
            r21 = 0
            java.lang.Exception r14 = r1.f2471a
            r11 = r31
            r12 = r3
            r25 = r9
            r9 = r13
            r3 = r14
            r13 = r16
            r26 = r9
            r9 = r15
            r15 = r21
            r17 = r3
            r11.mo17345b(r12, r13, r15, r17)
            goto L_0x02ab
        L_0x02a6:
            r25 = r9
            r26 = r13
            r9 = r15
        L_0x02ab:
            com.xiaomi.push.service.XMPushService r3 = r1.f2473b
            java.lang.String r3 = com.xiaomi.push.C1653bi.m2669a((android.content.Context) r3)
            boolean r3 = android.text.TextUtils.equals(r9, r3)
            if (r3 != 0) goto L_0x02bb
        L_0x02b7:
            r2 = r24
            goto L_0x0347
        L_0x02bb:
            r11 = r0
        L_0x02bc:
            r12 = r9
            r0 = r24
            r9 = r25
            r21 = r26
            r13 = r29
            r15 = r31
            goto L_0x00c5
        L_0x02c9:
            r0 = move-exception
            r26 = r13
            r9 = r15
        L_0x02cd:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r8)
            r12.append(r3)
            java.lang.String r8 = r12.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r8)
            r10.append(r7)
            r10.append(r3)
            r10.append(r6)
            r10.append(r2)
            r10.append(r5)
            java.lang.Exception r2 = r1.f2471a
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r10.append(r2)
            r10.append(r4)
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 == 0) goto L_0x0306
            r2 = r3
            goto L_0x031a
        L_0x0306:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            r4 = r26
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
        L_0x031a:
            java.lang.Exception r4 = r1.f2471a
            com.xiaomi.push.C1860hi.m3867a((java.lang.String) r3, (java.lang.Exception) r4)
            if (r31 == 0) goto L_0x0333
            long r4 = java.lang.System.currentTimeMillis()
            long r13 = r4 - r22
            r15 = 0
            java.lang.Exception r4 = r1.f2471a
            r11 = r31
            r12 = r3
            r17 = r4
            r11.mo17345b(r12, r13, r15, r17)
        L_0x0333:
            com.xiaomi.push.service.XMPushService r3 = r1.f2473b
            java.lang.String r3 = com.xiaomi.push.C1653bi.m2669a((android.content.Context) r3)
            boolean r3 = android.text.TextUtils.equals(r9, r3)
            if (r3 != 0) goto L_0x0342
            r0 = r2
            goto L_0x02b7
        L_0x0342:
            throw r0
        L_0x0343:
            r29 = r13
            r2 = r0
            r0 = r11
        L_0x0347:
            r20 = 0
        L_0x0349:
            com.xiaomi.push.cu r3 = com.xiaomi.push.C1702cu.mo17360a()
            r3.mo17365c()
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r18
            int r4 = (int) r3
            if (r20 != 0) goto L_0x0391
            long r2 = r1.f2480h
            int r5 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r5 == 0) goto L_0x036d
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r5 = r1.f2480h
            long r2 = r2 - r5
            r5 = 480000(0x75300, double:2.371515E-318)
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0387
        L_0x036d:
            long r2 = android.os.SystemClock.elapsedRealtime()
            r1.f2480h = r2
            com.xiaomi.push.service.XMPushService r2 = r1.f2473b
            android.content.Context r2 = r2.getApplicationContext()
            boolean r2 = com.xiaomi.push.C1653bi.m2686c(r2)
            com.xiaomi.push.ff r3 = com.xiaomi.push.C1789ff.BATCH_TCP_CONN_FAIL
            int r3 = r3.mo17573a()
            r5 = 0
            com.xiaomi.push.C1860hi.m3863a(r5, r3, r4, r0, r2)
        L_0x0387:
            com.xiaomi.push.gf r0 = new com.xiaomi.push.gf
            java.lang.String r2 = r10.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x0391:
            r5 = 0
            com.xiaomi.push.ff r3 = com.xiaomi.push.C1789ff.BATCH_TCP_CONN_SUCCESS
            int r3 = r3.mo17573a()
            com.xiaomi.push.C1860hi.m3863a(r5, r3, r4, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1819gb.m3683a(java.lang.String, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1698cq mo17659a(String str) {
        C1698cq a = C1702cu.mo17360a().mo17358a(str, false);
        if (!a.mo17346b()) {
            C1845gx.m3807a((Runnable) new C1822ge(this, str));
        }
        return a;
    }

    /* renamed from: a */
    public String mo17639a() {
        return this.f2476d;
    }

    /* renamed from: a */
    public Socket m3686a() {
        return new Socket();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void m3687a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo17640a(int i, Exception exc) {
        if (mo17661b() != 2) {
            mo17656a(2, i, exc);
            this.f2437a = "";
            try {
                this.f2472a.close();
            } catch (Throwable unused) {
            }
            this.f2477e = 0;
            this.f2478f = 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17677a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f2479g < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL) {
            if (C1653bi.m2685b(this.f2473b)) {
                this.f2474c++;
                if (this.f2474c >= 2) {
                    String a = mo17639a();
                    C1524b.m2141a("max short conn time reached, sink down current host:" + a);
                    mo17678a(a, 0, exc);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f2474c = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17678a(String str, long j, Exception exc) {
        C1698cq a = C1702cu.mo17360a().mo17358a(C1811fv.mo17670a(), false);
        if (a != null) {
            a.mo17345b(str, j, 0, exc);
            C1702cu.mo17360a().mo17365c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo17645a(boolean z);

    /* renamed from: a */
    public void mo17646a(C1793fj[] fjVarArr) {
        throw new C1823gf("Don't support send Blob");
    }

    /* renamed from: b */
    public void mo17662b(int i, Exception exc) {
        mo17640a(i, exc);
        if ((exc != null || i == 18) && this.f2479g != 0) {
            mo17677a(exc);
        }
    }

    /* renamed from: b */
    public void mo17665b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo17645a(z);
        C2061i.m5236a((Context) this.f2473b).mo18535c();
        if (!z) {
            this.f2473b.mo18413a((XMPushService.C1956i) new C1820gc(this, 13, currentTimeMillis), 10000);
        }
    }

    /* renamed from: c */
    public String mo17666c() {
        return this.f2437a;
    }

    /* renamed from: c */
    public void mo17679c(int i, Exception exc) {
        this.f2473b.mo18412a((XMPushService.C1956i) new C1821gd(this, 2, i, exc));
    }

    /* renamed from: e */
    public synchronized void mo17680e() {
        try {
            if (!mo17666c()) {
                if (!mo17661b()) {
                    mo17656a(0, 0, (Exception) null);
                    m3682a(this.f2434a);
                    return;
                }
            }
            C1524b.m2141a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new C1823gf((Throwable) e);
        }
    }

    /* renamed from: f */
    public void mo17681f() {
        this.f2477e = SystemClock.elapsedRealtime();
    }

    /* renamed from: g */
    public void mo17682g() {
        this.f2478f = SystemClock.elapsedRealtime();
    }
}
