package com.bykv.vk.openvk.component.video.a.a.a;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.b;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/* compiled from: VideoCacheImpl */
public class c implements b {
    /* access modifiers changed from: private */
    public volatile long a = -2147483648L;
    /* access modifiers changed from: private */
    public final Object b = new Object();
    /* access modifiers changed from: private */
    public File c;
    private File d;
    /* access modifiers changed from: private */
    public long e = 0;
    /* access modifiers changed from: private */
    public volatile long f = -1;
    private volatile boolean g = false;
    /* access modifiers changed from: private */
    public volatile boolean h = false;
    /* access modifiers changed from: private */
    public RandomAccessFile i = null;
    /* access modifiers changed from: private */
    public final com.bykv.vk.openvk.component.video.api.c.c j;

    public c(Context context, com.bykv.vk.openvk.component.video.api.c.c cVar) {
        this.j = cVar;
        try {
            this.c = com.bykv.vk.openvk.component.video.a.e.c.b(cVar.a(), cVar.l());
            this.d = com.bykv.vk.openvk.component.video.a.e.c.c(cVar.a(), cVar.l());
            if (d()) {
                this.i = new RandomAccessFile(this.d, CampaignEx.JSON_KEY_AD_R);
            } else {
                this.i = new RandomAccessFile(this.c, "rw");
            }
            if (!d()) {
                this.e = this.c.length();
                c();
            }
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "Error using file ", cVar.k(), " as disc cache");
        }
    }

    private boolean d() {
        return this.d.exists();
    }

    public void c() {
        i.a aVar;
        if (b.d() != null) {
            aVar = b.d().b();
        } else {
            aVar = new i.a("v_cache");
        }
        aVar.a((long) this.j.n(), TimeUnit.MILLISECONDS).b((long) this.j.o(), TimeUnit.MILLISECONDS).c((long) this.j.p(), TimeUnit.MILLISECONDS);
        i a2 = aVar.a();
        com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "RANGE, bytes=", Long.valueOf(this.e), " file hash=", this.j.l());
        k.a aVar2 = new k.a();
        a2.a(aVar2.a("RANGE", "bytes=" + this.e + "-").a(this.j.k()).a().b()).a(new com.bytedance.sdk.component.b.a.c() {
            public void a(com.bytedance.sdk.component.b.a.b bVar, IOException iOException) {
                boolean unused = c.this.h = false;
                long unused2 = c.this.a = -1;
            }

            /* JADX WARNING: Removed duplicated region for block: B:119:0x015c A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x0132 A[Catch:{ all -> 0x01c9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x022d A[SYNTHETIC, Splitter:B:85:0x022d] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0235 A[Catch:{ all -> 0x0231 }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x023a A[Catch:{ all -> 0x0231 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0259 A[Catch:{ all -> 0x0231 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.b.a.b r28, com.bytedance.sdk.component.b.a.m r29) throws java.io.IOException {
                /*
                    r27 = this;
                    r1 = r27
                    if (r29 == 0) goto L_0x029d
                    r3 = 0
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0213 }
                    boolean r4 = r29.d()     // Catch:{ all -> 0x0213 }
                    boolean unused = r0.h = r4     // Catch:{ all -> 0x0213 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0213 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0213 }
                    if (r0 == 0) goto L_0x01cf
                    com.bytedance.sdk.component.b.a.n r4 = r29.f()     // Catch:{ all -> 0x0213 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01cb }
                    boolean r0 = r0.h     // Catch:{ all -> 0x01cb }
                    if (r0 == 0) goto L_0x0038
                    if (r4 == 0) goto L_0x0038
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01cb }
                    long r5 = r4.a()     // Catch:{ all -> 0x01cb }
                    com.bykv.vk.openvk.component.video.a.a.a.c r7 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01cb }
                    long r7 = r7.e     // Catch:{ all -> 0x01cb }
                    long r5 = r5 + r7
                    long unused = r0.a = r5     // Catch:{ all -> 0x01cb }
                    java.io.InputStream r3 = r4.c()     // Catch:{ all -> 0x01cb }
                L_0x0038:
                    if (r3 != 0) goto L_0x0072
                    if (r3 == 0) goto L_0x0042
                    r3.close()     // Catch:{ all -> 0x0040 }
                    goto L_0x0042
                L_0x0040:
                    r0 = move-exception
                    goto L_0x006e
                L_0x0042:
                    if (r4 == 0) goto L_0x0047
                    r4.close()     // Catch:{ all -> 0x0040 }
                L_0x0047:
                    if (r29 == 0) goto L_0x004c
                    r29.close()     // Catch:{ all -> 0x0040 }
                L_0x004c:
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0040 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0040 }
                    if (r0 == 0) goto L_0x0071
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0040 }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x0040 }
                    long r2 = r0.length()     // Catch:{ all -> 0x0040 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0040 }
                    long r4 = r0.a     // Catch:{ all -> 0x0040 }
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x0071
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0040 }
                    r0.f()     // Catch:{ all -> 0x0040 }
                    goto L_0x0071
                L_0x006e:
                    r0.printStackTrace()
                L_0x0071:
                    return
                L_0x0072:
                    r0 = 8192(0x2000, float:1.14794E-41)
                    byte[] r5 = new byte[r0]     // Catch:{ all -> 0x01cb }
                    com.bykv.vk.openvk.component.video.a.a.a.c r6 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01cb }
                    long r6 = r6.e     // Catch:{ all -> 0x01cb }
                    r8 = 0
                    r12 = r6
                    r10 = r8
                    r6 = 0
                L_0x0081:
                    int r7 = 8192 - r6
                    int r7 = r3.read(r5, r6, r7)     // Catch:{ all -> 0x01cb }
                    r14 = -1
                    r15 = 9
                    r16 = 8
                    r17 = 7
                    r18 = 6
                    r19 = 5
                    r20 = 4
                    r21 = 3
                    r22 = 2
                    r0 = 10
                    r23 = 1
                    if (r7 == r14) goto L_0x0164
                    int r6 = r6 + r7
                    r24 = r3
                    long r2 = (long) r7
                    long r10 = r10 + r2
                    r2 = 8192(0x2000, double:4.0474E-320)
                    long r2 = r10 % r2
                    int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                    if (r2 == 0) goto L_0x00c0
                    com.bykv.vk.openvk.component.video.a.a.a.c r2 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r2 = r2.a     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r7 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r25 = r7.e     // Catch:{ all -> 0x01c9 }
                    long r2 = r2 - r25
                    int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
                    if (r2 != 0) goto L_0x00be
                    goto L_0x00c0
                L_0x00be:
                    r2 = 0
                    goto L_0x00c2
                L_0x00c0:
                    r2 = r23
                L_0x00c2:
                    java.lang.String r3 = "VideoCacheImpl"
                    r7 = 14
                    java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x01c9 }
                    java.lang.String r25 = "Write segment,execAppend ="
                    r14 = 0
                    r7[r14] = r25     // Catch:{ all -> 0x01c9 }
                    java.lang.Boolean r25 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x01c9 }
                    r7[r23] = r25     // Catch:{ all -> 0x01c9 }
                    java.lang.String r23 = " offset="
                    r7[r22] = r23     // Catch:{ all -> 0x01c9 }
                    java.lang.Integer r22 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01c9 }
                    r7[r21] = r22     // Catch:{ all -> 0x01c9 }
                    java.lang.String r21 = " totalLength = "
                    r7[r20] = r21     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r8 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r8 = r8.a     // Catch:{ all -> 0x01c9 }
                    java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01c9 }
                    r7[r19] = r8     // Catch:{ all -> 0x01c9 }
                    java.lang.String r8 = " saveSize ="
                    r7[r18] = r8     // Catch:{ all -> 0x01c9 }
                    java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01c9 }
                    r7[r17] = r8     // Catch:{ all -> 0x01c9 }
                    java.lang.String r8 = " startSaved="
                    r7[r16] = r8     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r8 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r8 = r8.e     // Catch:{ all -> 0x01c9 }
                    java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01c9 }
                    r7[r15] = r8     // Catch:{ all -> 0x01c9 }
                    java.lang.String r8 = " fileHash="
                    r7[r0] = r8     // Catch:{ all -> 0x01c9 }
                    r0 = 11
                    com.bykv.vk.openvk.component.video.a.a.a.c r8 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.api.c.c r8 = r8.j     // Catch:{ all -> 0x01c9 }
                    java.lang.String r8 = r8.l()     // Catch:{ all -> 0x01c9 }
                    r7[r0] = r8     // Catch:{ all -> 0x01c9 }
                    r0 = 12
                    java.lang.String r8 = " url="
                    r7[r0] = r8     // Catch:{ all -> 0x01c9 }
                    r0 = 13
                    com.bykv.vk.openvk.component.video.a.a.a.c r8 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.api.c.c r8 = r8.j     // Catch:{ all -> 0x01c9 }
                    java.lang.String r8 = r8.k()     // Catch:{ all -> 0x01c9 }
                    r7[r0] = r8     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r3, (java.lang.Object[]) r7)     // Catch:{ all -> 0x01c9 }
                    if (r2 == 0) goto L_0x015c
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    java.lang.Object r2 = r0.b     // Catch:{ all -> 0x01c9 }
                    monitor-enter(r2)     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0159 }
                    java.io.RandomAccessFile r0 = r0.i     // Catch:{ all -> 0x0159 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0159 }
                    int r3 = r3.intValue()     // Catch:{ all -> 0x0159 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r7 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0159 }
                    com.bykv.vk.openvk.component.video.api.c.c r7 = r7.j     // Catch:{ all -> 0x0159 }
                    java.lang.String r7 = r7.l()     // Catch:{ all -> 0x0159 }
                    com.bykv.vk.openvk.component.video.a.e.c.a(r0, r5, r3, r6, r7)     // Catch:{ all -> 0x0159 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0159 }
                    long r2 = (long) r6     // Catch:{ all -> 0x0159 }
                    long r12 = r12 + r2
                    r6 = 0
                    goto L_0x015c
                L_0x0159:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0159 }
                    throw r0     // Catch:{ all -> 0x01c9 }
                L_0x015c:
                    r3 = r24
                    r0 = 8192(0x2000, float:1.14794E-41)
                    r8 = 0
                    goto L_0x0081
                L_0x0164:
                    r24 = r3
                    java.lang.String r2 = "VideoCacheImpl"
                    java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x01c9 }
                    java.lang.String r3 = "Write segment,Write over, startIndex ="
                    r5 = 0
                    r0[r5] = r3     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r3 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r5 = r3.e     // Catch:{ all -> 0x01c9 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x01c9 }
                    r0[r23] = r3     // Catch:{ all -> 0x01c9 }
                    java.lang.String r3 = " totalLength = "
                    r0[r22] = r3     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r3 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r5 = r3.a     // Catch:{ all -> 0x01c9 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x01c9 }
                    r0[r21] = r3     // Catch:{ all -> 0x01c9 }
                    java.lang.String r3 = " saveSize = "
                    r0[r20] = r3     // Catch:{ all -> 0x01c9 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01c9 }
                    r0[r19] = r3     // Catch:{ all -> 0x01c9 }
                    java.lang.String r3 = " writeEndSegment ="
                    r0[r18] = r3     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r3 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r5 = r3.a     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r3 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    long r7 = r3.e     // Catch:{ all -> 0x01c9 }
                    long r5 = r5 - r7
                    int r3 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                    if (r3 != 0) goto L_0x01ab
                    goto L_0x01ad
                L_0x01ab:
                    r23 = 0
                L_0x01ad:
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r23)     // Catch:{ all -> 0x01c9 }
                    r0[r17] = r3     // Catch:{ all -> 0x01c9 }
                    java.lang.String r3 = " url="
                    r0[r16] = r3     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r3 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.api.c.c r3 = r3.j     // Catch:{ all -> 0x01c9 }
                    java.lang.String r3 = r3.k()     // Catch:{ all -> 0x01c9 }
                    r0[r15] = r3     // Catch:{ all -> 0x01c9 }
                    com.bykv.vk.openvk.component.video.api.f.c.b((java.lang.String) r2, (java.lang.Object[]) r0)     // Catch:{ all -> 0x01c9 }
                    r3 = r24
                    goto L_0x01e1
                L_0x01c9:
                    r0 = move-exception
                    goto L_0x0217
                L_0x01cb:
                    r0 = move-exception
                    r24 = r3
                    goto L_0x0217
                L_0x01cf:
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0213 }
                    r2 = 0
                    boolean unused = r0.h = r2     // Catch:{ all -> 0x0213 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0213 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r2 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0213 }
                    long r4 = r2.f     // Catch:{ all -> 0x0213 }
                    long unused = r0.a = r4     // Catch:{ all -> 0x0213 }
                    r4 = r3
                L_0x01e1:
                    if (r3 == 0) goto L_0x01e6
                    r3.close()     // Catch:{ all -> 0x0231 }
                L_0x01e6:
                    if (r4 == 0) goto L_0x01eb
                    r4.close()     // Catch:{ all -> 0x0231 }
                L_0x01eb:
                    if (r29 == 0) goto L_0x01f0
                    r29.close()     // Catch:{ all -> 0x0231 }
                L_0x01f0:
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0231 }
                    if (r0 == 0) goto L_0x02ac
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x0231 }
                    long r2 = r0.length()     // Catch:{ all -> 0x0231 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    long r4 = r0.a     // Catch:{ all -> 0x0231 }
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x02ac
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    r0.f()     // Catch:{ all -> 0x0231 }
                    goto L_0x02ac
                L_0x0213:
                    r0 = move-exception
                    r4 = r3
                    r24 = r4
                L_0x0217:
                    com.bykv.vk.openvk.component.video.a.a.a.c r2 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0263 }
                    r3 = 0
                    boolean unused = r2.h = r3     // Catch:{ all -> 0x0263 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r2 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0263 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r3 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0263 }
                    long r5 = r3.f     // Catch:{ all -> 0x0263 }
                    long unused = r2.a = r5     // Catch:{ all -> 0x0263 }
                    r0.printStackTrace()     // Catch:{ all -> 0x0263 }
                    if (r24 == 0) goto L_0x0233
                    r24.close()     // Catch:{ all -> 0x0231 }
                    goto L_0x0233
                L_0x0231:
                    r0 = move-exception
                    goto L_0x025f
                L_0x0233:
                    if (r4 == 0) goto L_0x0238
                    r4.close()     // Catch:{ all -> 0x0231 }
                L_0x0238:
                    if (r29 == 0) goto L_0x023d
                    r29.close()     // Catch:{ all -> 0x0231 }
                L_0x023d:
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    boolean r0 = r0.h     // Catch:{ all -> 0x0231 }
                    if (r0 == 0) goto L_0x02ac
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x0231 }
                    long r2 = r0.length()     // Catch:{ all -> 0x0231 }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    long r4 = r0.a     // Catch:{ all -> 0x0231 }
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x02ac
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x0231 }
                    r0.f()     // Catch:{ all -> 0x0231 }
                    goto L_0x02ac
                L_0x025f:
                    r0.printStackTrace()
                    goto L_0x02ac
                L_0x0263:
                    r0 = move-exception
                    r2 = r0
                    if (r24 == 0) goto L_0x026d
                    r24.close()     // Catch:{ all -> 0x026b }
                    goto L_0x026d
                L_0x026b:
                    r0 = move-exception
                    goto L_0x0299
                L_0x026d:
                    if (r4 == 0) goto L_0x0272
                    r4.close()     // Catch:{ all -> 0x026b }
                L_0x0272:
                    if (r29 == 0) goto L_0x0277
                    r29.close()     // Catch:{ all -> 0x026b }
                L_0x0277:
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x026b }
                    boolean r0 = r0.h     // Catch:{ all -> 0x026b }
                    if (r0 == 0) goto L_0x029c
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x026b }
                    java.io.File r0 = r0.c     // Catch:{ all -> 0x026b }
                    long r3 = r0.length()     // Catch:{ all -> 0x026b }
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x026b }
                    long r5 = r0.a     // Catch:{ all -> 0x026b }
                    int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r0 != 0) goto L_0x029c
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this     // Catch:{ all -> 0x026b }
                    r0.f()     // Catch:{ all -> 0x026b }
                    goto L_0x029c
                L_0x0299:
                    r0.printStackTrace()
                L_0x029c:
                    throw r2
                L_0x029d:
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this
                    r2 = 0
                    boolean unused = r0.h = r2
                    com.bykv.vk.openvk.component.video.a.a.a.c r0 = com.bykv.vk.openvk.component.video.a.a.a.c.this
                    long r2 = r0.f
                    long unused = r0.a = r2
                L_0x02ac:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.a.a.c.AnonymousClass1.a(com.bytedance.sdk.component.b.a.b, com.bytedance.sdk.component.b.a.m):void");
            }
        });
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        long j3 = j2;
        try {
            if (j3 == this.a) {
                return -1;
            }
            int i4 = 0;
            int i5 = 0;
            while (!this.g) {
                synchronized (this.b) {
                    long e2 = e();
                    if (j3 < e2) {
                        com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "read:  read " + j3 + " success");
                        this.i.seek(j3);
                        i5 = this.i.read(bArr, i2, i3);
                    } else {
                        byte[] bArr2 = bArr;
                        int i6 = i2;
                        int i7 = i3;
                        com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "read: wait at ", Long.valueOf(j2), "  file size = ", Long.valueOf(e2));
                        i4 += 33;
                        this.b.wait(33);
                    }
                }
                if (i5 > 0) {
                    return i5;
                }
                if (i4 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    public void a() {
        try {
            if (!this.g) {
                this.i.close();
            }
            if (this.c != null) {
                this.c.setLastModified(System.currentTimeMillis());
            }
            if (this.d != null) {
                this.d.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.g = true;
        return;
    }

    private long e() {
        if (d()) {
            return this.d.length();
        }
        return this.c.length();
    }

    /* access modifiers changed from: private */
    public void f() throws IOException {
        synchronized (this.b) {
            if (d()) {
                com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "complete: isCompleted ", this.j.k(), this.j.l());
                return;
            }
            try {
                if (this.c.renameTo(this.d)) {
                    if (this.i != null) {
                        this.i.close();
                    }
                    this.i = new RandomAccessFile(this.d, "rw");
                    com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "complete: rename ", this.j.l(), this.j.k());
                    return;
                }
                throw new IOException("Error renaming file " + this.c + " to " + this.d + " for completion!");
            } catch (Throwable th) {
                th.printStackTrace();
                com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", th.getMessage());
            }
        }
    }

    public long b() throws IOException {
        if (d()) {
            this.a = this.d.length();
        } else {
            synchronized (this.b) {
                int i2 = 0;
                do {
                    if (this.a == -2147483648L) {
                        try {
                            com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "totalLength: wait");
                            i2 += 15;
                            this.b.wait(5);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i2 <= 20000);
                return -1;
            }
        }
        com.bykv.vk.openvk.component.video.api.f.c.b("VideoCacheImpl", "totalLength= ", Long.valueOf(this.a));
        return this.a;
    }
}
