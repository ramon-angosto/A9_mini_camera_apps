package com.bykv.vk.openvk.component.video.a.a.b;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.k;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: ReallyVideoPreload */
public class b {
    private Context a;
    /* access modifiers changed from: private */
    public c b;
    /* access modifiers changed from: private */
    public volatile boolean c = false;
    /* access modifiers changed from: private */
    public File d = null;
    private File e = null;
    private final List<a.C0022a> f = new ArrayList();
    private volatile boolean g = false;

    public b(Context context, c cVar) {
        this.a = context;
        this.b = cVar;
        this.d = com.bykv.vk.openvk.component.video.a.e.c.b(cVar.a(), cVar.l());
        this.e = com.bykv.vk.openvk.component.video.a.e.c.c(cVar.a(), cVar.l());
    }

    public void a(a.C0022a aVar) {
        if (this.g) {
            synchronized (a.C0022a.class) {
                this.f.add(aVar);
            }
            return;
        }
        this.f.add(aVar);
        if (this.e.exists() || (!this.b.i() && this.d.length() >= ((long) this.b.b()))) {
            com.bykv.vk.openvk.component.video.api.f.c.b("VideoPreload", "Cache file is exist");
            this.b.g(1);
            a(this.b, 200);
            c.a(this.b);
            return;
        }
        this.g = true;
        this.b.g(0);
        b();
    }

    private void b() {
        i.a aVar;
        if (com.bykv.vk.openvk.component.video.api.b.d() != null) {
            aVar = com.bykv.vk.openvk.component.video.api.b.d().b();
        } else {
            aVar = new i.a("v_preload");
        }
        aVar.a((long) this.b.n(), TimeUnit.MILLISECONDS).b((long) this.b.o(), TimeUnit.MILLISECONDS).c((long) this.b.p(), TimeUnit.MILLISECONDS);
        i a2 = aVar.a();
        k.a aVar2 = new k.a();
        final long length = this.d.length();
        if (this.b.i()) {
            aVar2.a("RANGE", "bytes=" + length + "-").a(this.b.k()).a().b();
        } else {
            aVar2.a("RANGE", "bytes=" + length + "-" + this.b.b()).a(this.b.k()).a().b();
        }
        a2.a(aVar2.b()).a(new com.bytedance.sdk.component.b.a.c() {
            public void a(com.bytedance.sdk.component.b.a.b bVar, IOException iOException) {
                b bVar2 = b.this;
                bVar2.a(bVar2.b, (int) IronSourceError.ERROR_BN_LOAD_AFTER_LONG_INITIATION, iOException.getMessage());
                c.a(b.this.b);
            }

            /* JADX WARNING: Removed duplicated region for block: B:54:0x018a A[Catch:{ all -> 0x01db }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0262 A[Catch:{ all -> 0x02aa }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x01a3 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.b.a.b r26, com.bytedance.sdk.component.b.a.m r27) throws java.io.IOException {
                /*
                    r25 = this;
                    r1 = r25
                    r2 = r27
                    long r3 = r2
                    r5 = 601(0x259, float:8.42E-43)
                    r6 = 0
                    r7 = 3
                    java.lang.String r8 = " Preload size="
                    r9 = 2
                    java.lang.String r10 = "Pre finally "
                    r11 = 4
                    java.lang.String r12 = "VideoPreload"
                    r13 = 1
                    r14 = 0
                    if (r2 == 0) goto L_0x01f3
                    boolean r0 = r27.d()     // Catch:{ all -> 0x01ed }
                    if (r0 != 0) goto L_0x007c
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x0072 }
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x0072 }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.b     // Catch:{ all -> 0x0072 }
                    int r4 = r27.c()     // Catch:{ all -> 0x0072 }
                    java.lang.String r15 = r27.e()     // Catch:{ all -> 0x0072 }
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r4, (java.lang.String) r15)     // Catch:{ all -> 0x0072 }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r6)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r6)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r6)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r11]
                    r0[r14] = r10
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.k()
                    r0[r13] = r2
                    r0[r9] = r8
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.b()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r0[r7] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r12, (java.lang.Object[]) r0)
                L_0x0068:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r0 = r0.b
                    com.bykv.vk.openvk.component.video.a.a.b.c.a(r0)
                    return
                L_0x0072:
                    r0 = move-exception
                    r7 = r6
                    r15 = r7
                    r26 = r8
                    r24 = r10
                    r8 = r15
                    goto L_0x0250
                L_0x007c:
                    com.bytedance.sdk.component.b.a.n r15 = r27.f()     // Catch:{ all -> 0x01ed }
                    com.bytedance.sdk.component.b.a.n r15 = r27.f()     // Catch:{ all -> 0x01e5 }
                    r16 = 0
                    if (r0 == 0) goto L_0x00a0
                    if (r15 == 0) goto L_0x00a0
                    r26 = r8
                    long r7 = r2     // Catch:{ all -> 0x009c }
                    long r18 = r15.a()     // Catch:{ all -> 0x009c }
                    long r7 = r7 + r18
                    java.io.InputStream r0 = r15.c()     // Catch:{ all -> 0x009c }
                    r18 = r7
                    r7 = r0
                    goto L_0x00a5
                L_0x009c:
                    r0 = move-exception
                    r7 = r6
                    r8 = r7
                    goto L_0x00f8
                L_0x00a0:
                    r26 = r8
                    r7 = r6
                    r18 = r16
                L_0x00a5:
                    if (r7 != 0) goto L_0x00fc
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x00f6 }
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x00f6 }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.b     // Catch:{ all -> 0x00f6 }
                    int r4 = r27.c()     // Catch:{ all -> 0x00f6 }
                    java.lang.String r8 = r27.e()     // Catch:{ all -> 0x00f6 }
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r4, (java.lang.String) r8)     // Catch:{ all -> 0x00f6 }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r6)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r7)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r11]
                    r0[r14] = r10
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.k()
                    r0[r13] = r2
                    r0[r9] = r26
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.b()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3 = 3
                    r0[r3] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r12, (java.lang.Object[]) r0)
                    goto L_0x0068
                L_0x00f6:
                    r0 = move-exception
                    r8 = r6
                L_0x00f8:
                    r24 = r10
                    goto L_0x0250
                L_0x00fc:
                    java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ all -> 0x01e1 }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01e1 }
                    java.io.File r0 = r0.d     // Catch:{ all -> 0x01e1 }
                    java.lang.String r6 = "rw"
                    r8.<init>(r0, r6)     // Catch:{ all -> 0x01e1 }
                    r0 = 8192(0x2000, float:1.14794E-41)
                    byte[] r6 = new byte[r0]     // Catch:{ all -> 0x01de }
                    r22 = r3
                    r3 = r14
                    r20 = r16
                L_0x0112:
                    int r4 = 8192 - r3
                    int r4 = r7.read(r6, r3, r4)     // Catch:{ all -> 0x01de }
                    r0 = -1
                    if (r4 == r0) goto L_0x01aa
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01de }
                    boolean r0 = r0.c     // Catch:{ all -> 0x01de }
                    if (r0 == 0) goto L_0x016e
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01de }
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01de }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.b     // Catch:{ all -> 0x01de }
                    int r4 = r27.c()     // Catch:{ all -> 0x01de }
                    r0.b(r3, r4)     // Catch:{ all -> 0x01de }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r8)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r7)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r11]
                    r0[r14] = r10
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.k()
                    r0[r13] = r2
                    r0[r9] = r26
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.b()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3 = 3
                    r0[r3] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r12, (java.lang.Object[]) r0)
                    goto L_0x0068
                L_0x016e:
                    int r3 = r3 + r4
                    r24 = r10
                    long r9 = (long) r4
                    long r20 = r20 + r9
                    r9 = 8192(0x2000, double:4.0474E-320)
                    long r9 = r20 % r9
                    int r0 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
                    if (r0 == 0) goto L_0x0187
                    long r9 = r2     // Catch:{ all -> 0x01db }
                    long r9 = r18 - r9
                    int r0 = (r20 > r9 ? 1 : (r20 == r9 ? 0 : -1))
                    if (r0 != 0) goto L_0x0185
                    goto L_0x0187
                L_0x0185:
                    r0 = r14
                    goto L_0x0188
                L_0x0187:
                    r0 = r13
                L_0x0188:
                    if (r0 == 0) goto L_0x01a3
                    java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x01db }
                    int r0 = r0.intValue()     // Catch:{ all -> 0x01db }
                    com.bykv.vk.openvk.component.video.a.a.b.b r4 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01db }
                    com.bykv.vk.openvk.component.video.api.c.c r4 = r4.b     // Catch:{ all -> 0x01db }
                    java.lang.String r4 = r4.l()     // Catch:{ all -> 0x01db }
                    com.bykv.vk.openvk.component.video.a.e.c.a(r8, r6, r0, r3, r4)     // Catch:{ all -> 0x01db }
                    long r3 = (long) r3     // Catch:{ all -> 0x01db }
                    long r22 = r22 + r3
                    r3 = r14
                L_0x01a3:
                    r10 = r24
                    r0 = 8192(0x2000, float:1.14794E-41)
                    r9 = 2
                    goto L_0x0112
                L_0x01aa:
                    r24 = r10
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01db }
                    com.bykv.vk.openvk.component.video.api.c.c r0 = r0.b     // Catch:{ all -> 0x01db }
                    boolean r0 = r0.i()     // Catch:{ all -> 0x01db }
                    if (r0 == 0) goto L_0x01cb
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01db }
                    java.io.File r0 = r0.d     // Catch:{ all -> 0x01db }
                    long r3 = r0.length()     // Catch:{ all -> 0x01db }
                    int r0 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x01cb
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01db }
                    r0.d()     // Catch:{ all -> 0x01db }
                L_0x01cb:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01db }
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x01db }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.b     // Catch:{ all -> 0x01db }
                    int r4 = r27.c()     // Catch:{ all -> 0x01db }
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r4)     // Catch:{ all -> 0x01db }
                    goto L_0x0207
                L_0x01db:
                    r0 = move-exception
                    goto L_0x0250
                L_0x01de:
                    r0 = move-exception
                    goto L_0x00f8
                L_0x01e1:
                    r0 = move-exception
                    r24 = r10
                    goto L_0x01eb
                L_0x01e5:
                    r0 = move-exception
                    r26 = r8
                    r24 = r10
                    r7 = 0
                L_0x01eb:
                    r8 = 0
                    goto L_0x0250
                L_0x01ed:
                    r0 = move-exception
                    r26 = r8
                    r24 = r10
                    goto L_0x024d
                L_0x01f3:
                    r26 = r8
                    r24 = r10
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x024c }
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x024c }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.b     // Catch:{ all -> 0x024c }
                    java.lang.String r4 = "Network link failed."
                    r0.a((com.bykv.vk.openvk.component.video.api.c.c) r3, (int) r5, (java.lang.String) r4)     // Catch:{ all -> 0x024c }
                    r7 = 0
                    r8 = 0
                    r15 = 0
                L_0x0207:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r8)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r7)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r11]
                    r0[r14] = r24
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.k()
                    r0[r13] = r2
                    r2 = 2
                    r0[r2] = r26
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.b()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3 = 3
                    r0[r3] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r12, (java.lang.Object[]) r0)
                L_0x0242:
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r0 = r0.b
                    com.bykv.vk.openvk.component.video.a.a.b.c.a(r0)
                    goto L_0x02a9
                L_0x024c:
                    r0 = move-exception
                L_0x024d:
                    r7 = 0
                    r8 = 0
                    r15 = 0
                L_0x0250:
                    r0.printStackTrace()     // Catch:{ all -> 0x02aa }
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x02aa }
                    r3.c()     // Catch:{ all -> 0x02aa }
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x02aa }
                    com.bykv.vk.openvk.component.video.a.a.b.b r4 = com.bykv.vk.openvk.component.video.a.a.b.b.this     // Catch:{ all -> 0x02aa }
                    com.bykv.vk.openvk.component.video.api.c.c r4 = r4.b     // Catch:{ all -> 0x02aa }
                    if (r2 == 0) goto L_0x0266
                    int r5 = r27.c()     // Catch:{ all -> 0x02aa }
                L_0x0266:
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02aa }
                    r3.a((com.bykv.vk.openvk.component.video.api.c.c) r4, (int) r5, (java.lang.String) r0)     // Catch:{ all -> 0x02aa }
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r8)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r7)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r0 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r0.a((java.io.Closeable) r2)
                    java.lang.Object[] r0 = new java.lang.Object[r11]
                    r0[r14] = r24
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    java.lang.String r2 = r2.k()
                    r0[r13] = r2
                    r2 = 2
                    r0[r2] = r26
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    int r2 = r2.b()
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3 = 3
                    r0[r3] = r2
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r12, (java.lang.Object[]) r0)
                    goto L_0x0242
                L_0x02a9:
                    return
                L_0x02aa:
                    r0 = move-exception
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r3.a((java.io.Closeable) r8)
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r3.a((java.io.Closeable) r7)
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r3.a((java.io.Closeable) r15)
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    r3.a((java.io.Closeable) r2)
                    java.lang.Object[] r2 = new java.lang.Object[r11]
                    r2[r14] = r24
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.b
                    java.lang.String r3 = r3.k()
                    r2[r13] = r3
                    r3 = 2
                    r2[r3] = r26
                    com.bykv.vk.openvk.component.video.a.a.b.b r3 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.b
                    int r3 = r3.b()
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    r4 = 3
                    r2[r4] = r3
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r12, (java.lang.Object[]) r2)
                    com.bykv.vk.openvk.component.video.a.a.b.b r2 = com.bykv.vk.openvk.component.video.a.a.b.b.this
                    com.bykv.vk.openvk.component.video.api.c.c r2 = r2.b
                    com.bykv.vk.openvk.component.video.a.a.b.c.a(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.a.b.b.AnonymousClass1.a(com.bytedance.sdk.component.b.a.b, com.bytedance.sdk.component.b.a.m):void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public c a() {
        return this.b;
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* access modifiers changed from: private */
    public void a(c cVar, int i) {
        synchronized (a.C0022a.class) {
            for (a.C0022a next : this.f) {
                if (next != null) {
                    next.a(cVar, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(c cVar, int i, String str) {
        synchronized (a.C0022a.class) {
            for (a.C0022a next : this.f) {
                if (next != null) {
                    next.a(cVar, i, str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar, int i) {
        synchronized (a.C0022a.class) {
            for (a.C0022a next : this.f) {
                if (next != null) {
                    next.b(cVar, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            this.e.delete();
            this.d.delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            if (!this.d.renameTo(this.e)) {
                throw new IOException("Error renaming file " + this.d + " to " + this.e + " for completion!");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.bykv.vk.openvk.component.video.api.f.c.b("VideoPreload", th.getMessage());
        }
    }
}
