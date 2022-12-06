package com.xiaomi.smack;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.filter.a;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.util.h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class l extends a {
    private volatile long A = 0;
    private int B;
    public Exception q = null;
    protected Socket r;
    String s = null;
    i t;
    g u;
    private String v = null;
    private String w = "";
    private String x;
    /* access modifiers changed from: private */
    public XMPushService y;
    private final String z = "<pf><p>t:%1$d</p></pf>";

    public l(XMPushService xMPushService, b bVar) {
        super(xMPushService, bVar);
        this.y = xMPushService;
    }

    private void a(b bVar) {
        a(bVar.f(), bVar.e());
    }

    private void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.A < 300000) {
            if (d.d(this.y)) {
                this.B++;
                if (this.B >= 2) {
                    String c = c();
                    b.a("max short conn time reached, sink down current host:" + c);
                    a(c, 0, exc);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.B = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00da, code lost:
        r1.A = android.os.SystemClock.elapsedRealtime();
        com.xiaomi.channel.commonutils.logger.b.a("connected to " + r10 + " in " + r1.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00fe, code lost:
        r19 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x023f, code lost:
        if (android.text.TextUtils.equals(r8, com.xiaomi.channel.commonutils.network.d.g(r1.y)) == false) goto L_0x0246;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0172 A[SYNTHETIC, Splitter:B:52:0x0172] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d0 A[SYNTHETIC, Splitter:B:61:0x01d0] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x024f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0223 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r24, int r25) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            java.lang.String r3 = "\n"
            java.lang.String r4 = " "
            java.lang.String r5 = " port:"
            java.lang.String r6 = "SMACK: Could not connect to "
            java.lang.String r7 = "SMACK: Could not connect to:"
            r8 = 0
            r1.q = r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "get bucket for host : "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.Integer r10 = com.xiaomi.channel.commonutils.logger.b.e(r10)
            int r10 = r10.intValue()
            com.xiaomi.network.Fallback r15 = r23.c(r24)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Integer) r10)
            r10 = 1
            if (r15 == 0) goto L_0x0043
            java.util.ArrayList r9 = r15.a((boolean) r10)
        L_0x0043:
            boolean r11 = r9.isEmpty()
            if (r11 == 0) goto L_0x004c
            r9.add(r0)
        L_0x004c:
            r11 = 0
            r1.A = r11
            com.xiaomi.push.service.XMPushService r0 = r1.y
            java.lang.String r13 = com.xiaomi.channel.commonutils.network.d.g(r0)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.util.Iterator r9 = r9.iterator()
            r0 = 0
            r11 = 0
        L_0x0061:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x0243
            java.lang.Object r0 = r9.next()
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            long r17 = java.lang.System.currentTimeMillis()
            int r0 = r1.b
            int r0 = r0 + r10
            r1.b = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r0.<init>()     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.lang.String r10 = "begin to connect to "
            r0.append(r10)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r0.append(r12)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.net.Socket r0 = r23.v()     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r1.r = r0     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.net.Socket r0 = r1.r     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r0.bind(r8)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.net.InetSocketAddress r0 = com.xiaomi.network.Host.b(r12, r2)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.net.Socket r10 = r1.r     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r8 = 8000(0x1f40, float:1.121E-41)
            r10.connect(r0, r8)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.lang.String r0 = "tcp connected"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            java.net.Socket r0 = r1.r     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r8 = 1
            r0.setTcpNoDelay(r8)     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r1.x = r12     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            r23.y()     // Catch:{ IOException -> 0x01c4, p -> 0x0166, Throwable -> 0x013b, all -> 0x0133 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0127, p -> 0x011c, Throwable -> 0x0112, all -> 0x010a }
            long r10 = r10 - r17
            r1.c = r10     // Catch:{ IOException -> 0x0127, p -> 0x011c, Throwable -> 0x0112, all -> 0x010a }
            r1.m = r13     // Catch:{ IOException -> 0x0127, p -> 0x011c, Throwable -> 0x0112, all -> 0x010a }
            if (r15 == 0) goto L_0x00d3
            long r10 = r1.c     // Catch:{ IOException -> 0x0127, p -> 0x011c, Throwable -> 0x0112, all -> 0x010a }
            r19 = 0
            r21 = r10
            r11 = r15
            r10 = r12
            r24 = r9
            r8 = r13
            r9 = r14
            r13 = r21
            r21 = r15
            r15 = r19
            r11.b(r12, r13, r15)     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            goto L_0x00da
        L_0x00d3:
            r24 = r9
            r10 = r12
            r8 = r13
            r9 = r14
            r21 = r15
        L_0x00da:
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            r1.A = r11     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            r0.<init>()     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            java.lang.String r11 = "connected to "
            r0.append(r11)     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            r0.append(r10)     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            java.lang.String r11 = " in "
            r0.append(r11)     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            long r11 = r1.c     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            r0.append(r11)     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ IOException -> 0x0108, p -> 0x0106, Throwable -> 0x0104, all -> 0x0102 }
            r19 = 1
            goto L_0x0246
        L_0x0102:
            r0 = move-exception
            goto L_0x010e
        L_0x0104:
            r0 = move-exception
            goto L_0x011a
        L_0x0106:
            r0 = move-exception
            goto L_0x0124
        L_0x0108:
            r0 = move-exception
            goto L_0x012f
        L_0x010a:
            r0 = move-exception
            r10 = r12
            r8 = r13
            r9 = r14
        L_0x010e:
            r19 = 1
            goto L_0x022e
        L_0x0112:
            r0 = move-exception
            r24 = r9
            r10 = r12
            r8 = r13
            r9 = r14
            r21 = r15
        L_0x011a:
            r11 = 1
            goto L_0x0143
        L_0x011c:
            r0 = move-exception
            r24 = r9
            r10 = r12
            r8 = r13
            r9 = r14
            r21 = r15
        L_0x0124:
            r19 = 1
            goto L_0x0170
        L_0x0127:
            r0 = move-exception
            r24 = r9
            r10 = r12
            r8 = r13
            r9 = r14
            r21 = r15
        L_0x012f:
            r19 = 1
            goto L_0x01ce
        L_0x0133:
            r0 = move-exception
            r10 = r12
            r8 = r13
            r9 = r14
        L_0x0137:
            r19 = r11
            goto L_0x022e
        L_0x013b:
            r0 = move-exception
            r24 = r9
            r10 = r12
            r8 = r13
            r9 = r14
            r21 = r15
        L_0x0143:
            java.lang.Exception r12 = new java.lang.Exception     // Catch:{ all -> 0x0164 }
            java.lang.String r13 = "abnormal exception"
            r12.<init>(r13, r0)     // Catch:{ all -> 0x0164 }
            r1.q = r12     // Catch:{ all -> 0x0164 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0164 }
            if (r11 != 0) goto L_0x0223
            java.lang.Exception r0 = r1.q
            com.xiaomi.stats.h.a((java.lang.String) r10, (java.lang.Exception) r0)
            com.xiaomi.push.service.XMPushService r0 = r1.y
            java.lang.String r0 = com.xiaomi.channel.commonutils.network.d.g(r0)
            boolean r0 = android.text.TextUtils.equals(r8, r0)
            if (r0 != 0) goto L_0x0223
            goto L_0x0244
        L_0x0164:
            r0 = move-exception
            goto L_0x0137
        L_0x0166:
            r0 = move-exception
            r24 = r9
            r10 = r12
            r8 = r13
            r9 = r14
            r21 = r15
            r19 = r11
        L_0x0170:
            if (r21 == 0) goto L_0x0182
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x022d }
            long r13 = r11 - r17
            r15 = 0
            r11 = r21
            r12 = r10
            r17 = r0
            r11.b(r12, r13, r15, r17)     // Catch:{ all -> 0x022d }
        L_0x0182:
            r1.q = r0     // Catch:{ all -> 0x022d }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x022d }
            r11.<init>()     // Catch:{ all -> 0x022d }
            r11.append(r7)     // Catch:{ all -> 0x022d }
            r11.append(r10)     // Catch:{ all -> 0x022d }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x022d }
            com.xiaomi.channel.commonutils.logger.b.d(r11)     // Catch:{ all -> 0x022d }
            r9.append(r6)     // Catch:{ all -> 0x022d }
            r9.append(r10)     // Catch:{ all -> 0x022d }
            r9.append(r5)     // Catch:{ all -> 0x022d }
            r9.append(r2)     // Catch:{ all -> 0x022d }
            r9.append(r4)     // Catch:{ all -> 0x022d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x022d }
            r9.append(r0)     // Catch:{ all -> 0x022d }
            r9.append(r3)     // Catch:{ all -> 0x022d }
            if (r19 != 0) goto L_0x0221
            java.lang.Exception r0 = r1.q
            com.xiaomi.stats.h.a((java.lang.String) r10, (java.lang.Exception) r0)
            com.xiaomi.push.service.XMPushService r0 = r1.y
            java.lang.String r0 = com.xiaomi.channel.commonutils.network.d.g(r0)
            boolean r0 = android.text.TextUtils.equals(r8, r0)
            if (r0 != 0) goto L_0x0221
            goto L_0x0246
        L_0x01c4:
            r0 = move-exception
            r24 = r9
            r10 = r12
            r8 = r13
            r9 = r14
            r21 = r15
            r19 = r11
        L_0x01ce:
            if (r21 == 0) goto L_0x01e0
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x022d }
            long r13 = r11 - r17
            r15 = 0
            r11 = r21
            r12 = r10
            r17 = r0
            r11.b(r12, r13, r15, r17)     // Catch:{ all -> 0x022d }
        L_0x01e0:
            r1.q = r0     // Catch:{ all -> 0x022d }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x022d }
            r11.<init>()     // Catch:{ all -> 0x022d }
            r11.append(r7)     // Catch:{ all -> 0x022d }
            r11.append(r10)     // Catch:{ all -> 0x022d }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x022d }
            com.xiaomi.channel.commonutils.logger.b.d(r11)     // Catch:{ all -> 0x022d }
            r9.append(r6)     // Catch:{ all -> 0x022d }
            r9.append(r10)     // Catch:{ all -> 0x022d }
            r9.append(r5)     // Catch:{ all -> 0x022d }
            r9.append(r2)     // Catch:{ all -> 0x022d }
            r9.append(r4)     // Catch:{ all -> 0x022d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x022d }
            r9.append(r0)     // Catch:{ all -> 0x022d }
            r9.append(r3)     // Catch:{ all -> 0x022d }
            if (r19 != 0) goto L_0x0221
            java.lang.Exception r0 = r1.q
            com.xiaomi.stats.h.a((java.lang.String) r10, (java.lang.Exception) r0)
            com.xiaomi.push.service.XMPushService r0 = r1.y
            java.lang.String r0 = com.xiaomi.channel.commonutils.network.d.g(r0)
            boolean r0 = android.text.TextUtils.equals(r8, r0)
            if (r0 != 0) goto L_0x0221
            goto L_0x0246
        L_0x0221:
            r11 = r19
        L_0x0223:
            r13 = r8
            r14 = r9
            r15 = r21
            r8 = 0
            r10 = 1
            r9 = r24
            goto L_0x0061
        L_0x022d:
            r0 = move-exception
        L_0x022e:
            if (r19 != 0) goto L_0x0242
            java.lang.Exception r2 = r1.q
            com.xiaomi.stats.h.a((java.lang.String) r10, (java.lang.Exception) r2)
            com.xiaomi.push.service.XMPushService r2 = r1.y
            java.lang.String r2 = com.xiaomi.channel.commonutils.network.d.g(r2)
            boolean r2 = android.text.TextUtils.equals(r8, r2)
            if (r2 != 0) goto L_0x0242
            goto L_0x0246
        L_0x0242:
            throw r0
        L_0x0243:
            r9 = r14
        L_0x0244:
            r19 = r11
        L_0x0246:
            com.xiaomi.network.HostManager r0 = com.xiaomi.network.HostManager.getInstance()
            r0.persist()
            if (r19 == 0) goto L_0x0250
            return
        L_0x0250:
            com.xiaomi.smack.p r0 = new com.xiaomi.smack.p
            java.lang.String r2 = r9.toString()
            r0.<init>((java.lang.String) r2)
            goto L_0x025b
        L_0x025a:
            throw r0
        L_0x025b:
            goto L_0x025a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.l.a(java.lang.String, int):void");
    }

    private void a(String str, long j, Exception exc) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(b.b(), false);
        if (fallbacksByHost != null) {
            fallbacksByHost.b(str, j, 0, exc);
            HostManager.getInstance().persist();
        }
    }

    private synchronized void y() {
        z();
        this.t = new i(this);
        this.u = new g(this);
        if (this.o.g()) {
            a(this.i.c(), (a) null);
            if (this.i.d() != null) {
                b(this.i.d(), (a) null);
            }
        }
        this.p.a(10);
        this.p.h();
        b.a("begin to openstream...");
        this.t.c();
        this.u.b();
    }

    private void z() {
        try {
            this.j = new BufferedReader(new InputStreamReader(this.r.getInputStream(), "UTF-8"), 4096);
            this.k = new BufferedWriter(new OutputStreamWriter(this.r.getOutputStream(), "UTF-8"));
            if (this.j != null && this.k != null) {
                g();
            }
        } catch (Exception e) {
            throw new p("Error to init reader and writer", e);
        }
    }

    public void a(int i, Exception exc) {
        this.y.a((XMPushService.g) new n(this, 2, i, exc));
    }

    public synchronized void a(y.b bVar) {
        new k().a(bVar, s(), this);
    }

    public void a(com.xiaomi.smack.packet.d dVar) {
        i iVar = this.t;
        if (iVar != null) {
            iVar.a(dVar);
            return;
        }
        throw new p("the writer is null.");
    }

    public void a(f fVar, int i, Exception exc) {
        b(fVar, i, exc);
        if ((exc != null || i == 18) && this.A != 0) {
            a(exc);
        }
    }

    public synchronized void a(String str, String str2) {
        f fVar = new f(f.b.unavailable);
        fVar.l(str);
        fVar.n(str2);
        if (this.t != null) {
            this.t.a(fVar);
        }
    }

    public void a(com.xiaomi.smack.packet.d[] dVarArr) {
        for (com.xiaomi.smack.packet.d a : dVarArr) {
            a(a);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0045 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040 A[SYNTHETIC, Splitter:B:24:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004b A[SYNTHETIC, Splitter:B:30:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.xiaomi.smack.packet.f r2, int r3, java.lang.Exception r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            int r2 = r1.o()     // Catch:{ all -> 0x005a }
            r0 = 2
            if (r2 != r0) goto L_0x000a
            monitor-exit(r1)
            return
        L_0x000a:
            r1.a((int) r0, (int) r3, (java.lang.Exception) r4)     // Catch:{ all -> 0x005a }
            java.lang.String r2 = ""
            r1.l = r2     // Catch:{ all -> 0x005a }
            com.xiaomi.smack.g r2 = r1.u     // Catch:{ all -> 0x005a }
            r3 = 0
            if (r2 == 0) goto L_0x0022
            com.xiaomi.smack.g r2 = r1.u     // Catch:{ all -> 0x005a }
            r2.c()     // Catch:{ all -> 0x005a }
            com.xiaomi.smack.g r2 = r1.u     // Catch:{ all -> 0x005a }
            r2.d()     // Catch:{ all -> 0x005a }
            r1.u = r3     // Catch:{ all -> 0x005a }
        L_0x0022:
            com.xiaomi.smack.i r2 = r1.t     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0037
            com.xiaomi.smack.i r2 = r1.t     // Catch:{ IOException -> 0x002c }
            r2.b()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r2 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x005a }
        L_0x0030:
            com.xiaomi.smack.i r2 = r1.t     // Catch:{ all -> 0x005a }
            r2.a()     // Catch:{ all -> 0x005a }
            r1.t = r3     // Catch:{ all -> 0x005a }
        L_0x0037:
            java.net.Socket r2 = r1.r     // Catch:{ Throwable -> 0x003c }
            r2.close()     // Catch:{ Throwable -> 0x003c }
        L_0x003c:
            java.io.Reader r2 = r1.j     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0047
            java.io.Reader r2 = r1.j     // Catch:{ Throwable -> 0x0045 }
            r2.close()     // Catch:{ Throwable -> 0x0045 }
        L_0x0045:
            r1.j = r3     // Catch:{ all -> 0x005a }
        L_0x0047:
            java.io.Writer r2 = r1.k     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0052
            java.io.Writer r2 = r1.k     // Catch:{ Throwable -> 0x0050 }
            r2.close()     // Catch:{ Throwable -> 0x0050 }
        L_0x0050:
            r1.k = r3     // Catch:{ all -> 0x005a }
        L_0x0052:
            r2 = 0
            r1.d = r2     // Catch:{ all -> 0x005a }
            r1.e = r2     // Catch:{ all -> 0x005a }
            monitor-exit(r1)
            return
        L_0x005a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.l.b(com.xiaomi.smack.packet.f, int, java.lang.Exception):void");
    }

    public void b(String str) {
        this.w = str;
    }

    /* access modifiers changed from: package-private */
    public Fallback c(String str) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(str, false);
        if (!fallbacksByHost.b()) {
            h.a((Runnable) new o(this, str));
        }
        this.f = 0;
        try {
            byte[] address = InetAddress.getByName(fallbacksByHost.f).getAddress();
            this.f = address[0] & 255;
            this.f |= (address[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            this.f |= (address[2] << 16) & 16711680;
            this.f = ((address[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | this.f;
        } catch (UnknownHostException unused) {
        }
        return fallbacksByHost;
    }

    public String c() {
        return this.x;
    }

    public void n() {
        if (this.t != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.t.d();
            this.y.a((XMPushService.g) new m(this, 13, currentTimeMillis), 10000);
            return;
        }
        throw new p("the packetwriter is null.");
    }

    public String s() {
        return this.l;
    }

    public synchronized void t() {
        try {
            if (!i()) {
                if (!h()) {
                    a(0, 0, (Exception) null);
                    a(this.o);
                    return;
                }
            }
            b.a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new p((Throwable) e);
        }
    }

    public String u() {
        String str;
        String c = com.xiaomi.stats.h.c();
        if (c != null) {
            str = "<q>" + c + "</q>";
        } else {
            str = "";
        }
        return String.format(this.w, new Object[]{"", str});
    }

    public Socket v() {
        return new Socket();
    }

    public void w() {
        this.d = SystemClock.elapsedRealtime();
    }

    public void x() {
        this.e = SystemClock.elapsedRealtime();
    }
}
