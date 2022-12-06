package com.bykv.vk.openvk.component.video.a.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.a.b.c.c;
import com.bykv.vk.openvk.component.video.a.b.h;
import com.bykv.vk.openvk.component.video.a.b.i;
import com.bykv.vk.openvk.component.video.a.b.l;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* compiled from: DownloadTask */
class b extends a {
    final Object m = this;
    final Object n;
    private final int o;
    private final C0015b p;
    private volatile h.a q;
    private volatile com.bykv.vk.openvk.component.video.a.b.c.b r;

    /* renamed from: com.bykv.vk.openvk.component.video.a.b.b$b  reason: collision with other inner class name */
    /* compiled from: DownloadTask */
    public interface C0015b {
        void a(b bVar);
    }

    b(a aVar) {
        super(aVar.d, aVar.e);
        this.o = aVar.g;
        this.p = aVar.i;
        this.g = aVar.a;
        this.h = aVar.b;
        this.f = aVar.f;
        this.j = aVar.c;
        this.i = aVar.h;
        this.n = aVar.j;
    }

    public void run() {
        this.a.a(this.h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bykv.vk.openvk.component.video.a.b.c.a unused) {
        }
        this.d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.a.b(this.h);
        C0015b bVar = this.p;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public h.a h() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public com.bykv.vk.openvk.component.video.a.b.c.b i() {
        return this.r;
    }

    private boolean j() throws com.bykv.vk.openvk.component.video.a.b.c.a {
        while (this.j.a()) {
            e();
            l.a b = this.j.b();
            try {
                a(b);
                return true;
            } catch (c e) {
                b.a();
                a(Boolean.valueOf(g()), this.g, e);
            } catch (IOException e2) {
                if (e2 instanceof SocketTimeoutException) {
                    b.b();
                }
                if (!b()) {
                    a(Boolean.valueOf(g()), this.g, e2);
                }
            } catch (h.a e3) {
                this.q = e3;
                a(Boolean.valueOf(g()), this.g, e3);
                return false;
            } catch (com.bykv.vk.openvk.component.video.a.b.c.b e4) {
                this.r = e4;
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01cf, code lost:
        if (com.bykv.vk.openvk.component.video.a.b.e.c == false) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01d1, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01d8, code lost:
        com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r6.d());
        r4.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e2, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bykv.vk.openvk.component.video.a.b.l.a r13) throws java.io.IOException, com.bykv.vk.openvk.component.video.a.b.h.a, com.bykv.vk.openvk.component.video.a.b.c.a, com.bykv.vk.openvk.component.video.a.b.c.b {
        /*
            r12 = this;
            com.bykv.vk.openvk.component.video.a.b.a.a r0 = r12.a
            java.lang.String r1 = r12.h
            java.io.File r0 = r0.c(r1)
            long r1 = r0.length()
            int r3 = r12.o
            if (r3 <= 0) goto L_0x0044
            long r3 = (long) r3
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0044
            boolean r13 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r13 == 0) goto L_0x0043
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "no necessary to download for "
            r13.append(r0)
            java.lang.String r0 = r12.h
            r13.append(r0)
            java.lang.String r0 = ", cache file size: "
            r13.append(r0)
            r13.append(r1)
            java.lang.String r0 = ", max: "
            r13.append(r0)
            int r0 = r12.o
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            android.util.Log.i(r0, r13)
        L_0x0043:
            return
        L_0x0044:
            int r3 = r12.f()
            com.bykv.vk.openvk.component.video.a.b.b.c r4 = r12.b
            java.lang.String r5 = r12.h
            com.bykv.vk.openvk.component.video.a.b.b.a r4 = r4.a((java.lang.String) r5, (int) r3)
            if (r4 == 0) goto L_0x0076
            int r5 = r4.c
            long r5 = (long) r5
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x0076
            boolean r13 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r13 == 0) goto L_0x0075
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "file download complete, key: "
            r13.append(r0)
            java.lang.String r0 = r12.h
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            android.util.Log.i(r0, r13)
        L_0x0075:
            return
        L_0x0076:
            r12.e()
            int r5 = (int) r1
            int r6 = r12.o
            java.lang.String r7 = "GET"
            com.bykv.vk.openvk.component.video.a.b.e.a r6 = r12.a(r13, r5, r6, r7)
            if (r6 != 0) goto L_0x0085
            return
        L_0x0085:
            r7 = 0
            r8 = 1
            r9 = 0
            r12.e()     // Catch:{ all -> 0x020e }
            com.bykv.vk.openvk.component.video.a.b.i r10 = r12.i     // Catch:{ all -> 0x020e }
            if (r10 != 0) goto L_0x0095
            boolean r10 = com.bykv.vk.openvk.component.video.a.b.e.e     // Catch:{ all -> 0x020e }
            if (r10 == 0) goto L_0x0095
            r10 = r8
            goto L_0x0096
        L_0x0095:
            r10 = r9
        L_0x0096:
            java.lang.String r10 = com.bykv.vk.openvk.component.video.a.c.a.a(r6, r10, r8)     // Catch:{ all -> 0x020e }
            if (r10 != 0) goto L_0x01ea
            int r10 = com.bykv.vk.openvk.component.video.a.c.a.a((com.bykv.vk.openvk.component.video.a.b.e.a) r6)     // Catch:{ all -> 0x020e }
            if (r4 == 0) goto L_0x0111
            int r11 = r4.c     // Catch:{ all -> 0x020e }
            if (r11 == r10) goto L_0x0111
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x020e }
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020e }
            r1.<init>()     // Catch:{ all -> 0x020e }
            java.lang.String r2 = "Content-Length not match, old: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            int r2 = r4.c     // Catch:{ all -> 0x020e }
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            r1.append(r10)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = ", key: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = r12.h     // Catch:{ all -> 0x020e }
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x020e }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x020e }
        L_0x00d4:
            com.bykv.vk.openvk.component.video.a.b.c.b r0 = new com.bykv.vk.openvk.component.video.a.b.c.b     // Catch:{ all -> 0x020e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020e }
            r1.<init>()     // Catch:{ all -> 0x020e }
            java.lang.String r2 = "Content-Length not match, old length: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            int r2 = r4.c     // Catch:{ all -> 0x020e }
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = ", new length: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            r1.append(r10)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = ", rawKey: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = r12.g     // Catch:{ all -> 0x020e }
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = ", currentUrl: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            r1.append(r13)     // Catch:{ all -> 0x020e }
            java.lang.String r13 = ", previousInfo: "
            r1.append(r13)     // Catch:{ all -> 0x020e }
            java.lang.String r13 = r4.e     // Catch:{ all -> 0x020e }
            r1.append(r13)     // Catch:{ all -> 0x020e }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x020e }
            r0.<init>(r13)     // Catch:{ all -> 0x020e }
            throw r0     // Catch:{ all -> 0x020e }
        L_0x0111:
            com.bykv.vk.openvk.component.video.a.b.b.c r13 = r12.b     // Catch:{ all -> 0x020e }
            java.lang.String r4 = r12.h     // Catch:{ all -> 0x020e }
            com.bykv.vk.openvk.component.video.a.c.a.a(r6, r13, r4, r3)     // Catch:{ all -> 0x020e }
            com.bykv.vk.openvk.component.video.a.b.b.c r13 = r12.b     // Catch:{ all -> 0x020e }
            java.lang.String r4 = r12.h     // Catch:{ all -> 0x020e }
            com.bykv.vk.openvk.component.video.a.b.b.a r13 = r13.a((java.lang.String) r4, (int) r3)     // Catch:{ all -> 0x020e }
            if (r13 != 0) goto L_0x0124
            r13 = r9
            goto L_0x0126
        L_0x0124:
            int r13 = r13.c     // Catch:{ all -> 0x020e }
        L_0x0126:
            java.io.InputStream r3 = r6.d()     // Catch:{ all -> 0x020e }
            com.bykv.vk.openvk.component.video.a.b.h r4 = new com.bykv.vk.openvk.component.video.a.b.h     // Catch:{ all -> 0x020e }
            boolean r10 = com.bykv.vk.openvk.component.video.a.b.e.d     // Catch:{ all -> 0x020e }
            if (r10 == 0) goto L_0x0133
            java.lang.String r10 = "rwd"
            goto L_0x0135
        L_0x0133:
            java.lang.String r10 = "rw"
        L_0x0135:
            r4.<init>(r0, r10)     // Catch:{ all -> 0x020e }
            r4.a((long) r1)     // Catch:{ all -> 0x01e7 }
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01e7 }
            if (r0 == 0) goto L_0x0155
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e7 }
            r7.<init>()     // Catch:{ all -> 0x01e7 }
            java.lang.String r10 = "preload start from: "
            r7.append(r10)     // Catch:{ all -> 0x01e7 }
            r7.append(r1)     // Catch:{ all -> 0x01e7 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x01e7 }
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x01e7 }
        L_0x0155:
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x01e7 }
        L_0x0159:
            int r1 = r3.read(r0)     // Catch:{ all -> 0x01e7 }
            if (r1 < 0) goto L_0x01ca
            r12.e()     // Catch:{ all -> 0x01e7 }
            if (r1 <= 0) goto L_0x0181
            r4.a(r0, r9, r1)     // Catch:{ all -> 0x01e7 }
            int r5 = r5 + r1
            com.bykv.vk.openvk.component.video.a.b.i r2 = r12.i     // Catch:{ all -> 0x01e7 }
            if (r2 == 0) goto L_0x0179
            java.lang.Object r2 = r12.m     // Catch:{ all -> 0x01e7 }
            monitor-enter(r2)     // Catch:{ all -> 0x01e7 }
            java.lang.Object r7 = r12.m     // Catch:{ all -> 0x0176 }
            r7.notifyAll()     // Catch:{ all -> 0x0176 }
            monitor-exit(r2)     // Catch:{ all -> 0x0176 }
            goto L_0x0179
        L_0x0176:
            r13 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0176 }
            throw r13     // Catch:{ all -> 0x01e7 }
        L_0x0179:
            java.util.concurrent.atomic.AtomicInteger r2 = r12.c     // Catch:{ all -> 0x01e7 }
            r2.addAndGet(r1)     // Catch:{ all -> 0x01e7 }
            r12.a(r13, r5)     // Catch:{ all -> 0x01e7 }
        L_0x0181:
            int r1 = r12.o     // Catch:{ all -> 0x01e7 }
            if (r1 <= 0) goto L_0x01c6
            int r1 = r12.o     // Catch:{ all -> 0x01e7 }
            if (r5 < r1) goto L_0x01c6
            boolean r13 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01e7 }
            if (r13 == 0) goto L_0x01ad
            java.lang.String r13 = "TAG_PROXY_DownloadTask"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e7 }
            r0.<init>()     // Catch:{ all -> 0x01e7 }
            java.lang.String r1 = "download, more data received, currentCacheFileSize: "
            r0.append(r1)     // Catch:{ all -> 0x01e7 }
            r0.append(r5)     // Catch:{ all -> 0x01e7 }
            java.lang.String r1 = ", max: "
            r0.append(r1)     // Catch:{ all -> 0x01e7 }
            int r1 = r12.o     // Catch:{ all -> 0x01e7 }
            r0.append(r1)     // Catch:{ all -> 0x01e7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01e7 }
            android.util.Log.w(r13, r0)     // Catch:{ all -> 0x01e7 }
        L_0x01ad:
            java.io.InputStream r13 = r6.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r13)
            r4.a()
            r12.a()
            boolean r13 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r13 == 0) goto L_0x01c5
            java.lang.String r13 = "TAG_PROXY_DownloadTask"
            java.lang.String r0 = "cancel call"
            android.util.Log.w(r13, r0)
        L_0x01c5:
            return
        L_0x01c6:
            r12.e()     // Catch:{ all -> 0x01e7 }
            goto L_0x0159
        L_0x01ca:
            r12.c()     // Catch:{ all -> 0x01e3 }
            boolean r13 = com.bykv.vk.openvk.component.video.a.b.e.c     // Catch:{ all -> 0x01e3 }
            if (r13 == 0) goto L_0x01d8
            java.lang.String r13 = "TAG_PROXY_DownloadTask"
            java.lang.String r0 = "download succeed, no need to cancel call"
            android.util.Log.i(r13, r0)     // Catch:{ all -> 0x01e3 }
        L_0x01d8:
            java.io.InputStream r13 = r6.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r13)
            r4.a()
            return
        L_0x01e3:
            r13 = move-exception
            r7 = r4
            r8 = r9
            goto L_0x020f
        L_0x01e7:
            r13 = move-exception
            r7 = r4
            goto L_0x020f
        L_0x01ea:
            com.bykv.vk.openvk.component.video.a.b.c.c r0 = new com.bykv.vk.openvk.component.video.a.b.c.c     // Catch:{ all -> 0x020e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020e }
            r1.<init>()     // Catch:{ all -> 0x020e }
            r1.append(r10)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = ", rawKey: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = r12.g     // Catch:{ all -> 0x020e }
            r1.append(r2)     // Catch:{ all -> 0x020e }
            java.lang.String r2 = ", url: "
            r1.append(r2)     // Catch:{ all -> 0x020e }
            r1.append(r13)     // Catch:{ all -> 0x020e }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x020e }
            r0.<init>(r13)     // Catch:{ all -> 0x020e }
            throw r0     // Catch:{ all -> 0x020e }
        L_0x020e:
            r13 = move-exception
        L_0x020f:
            java.io.InputStream r0 = r6.d()
            com.bykv.vk.openvk.component.video.a.c.a.a((java.io.Closeable) r0)
            if (r7 == 0) goto L_0x021b
            r7.a()
        L_0x021b:
            if (r8 == 0) goto L_0x022b
            r12.a()
            boolean r0 = com.bykv.vk.openvk.component.video.a.b.e.c
            if (r0 == 0) goto L_0x022b
            java.lang.String r0 = "TAG_PROXY_DownloadTask"
            java.lang.String r1 = "cancel call"
            android.util.Log.w(r0, r1)
        L_0x022b:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.b.b.a(com.bykv.vk.openvk.component.video.a.b.l$a):void");
    }

    /* compiled from: DownloadTask */
    static final class a {
        String a;
        String b;
        l c;
        com.bykv.vk.openvk.component.video.a.b.a.a d;
        com.bykv.vk.openvk.component.video.a.b.b.c e;
        List<i.b> f;
        int g;
        i h;
        C0015b i;
        Object j;

        a() {
        }

        /* access modifiers changed from: package-private */
        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        /* access modifiers changed from: package-private */
        public a a(l lVar) {
            if (lVar != null) {
                this.c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        /* access modifiers changed from: package-private */
        public a a(com.bykv.vk.openvk.component.video.a.b.a.a aVar) {
            if (aVar != null) {
                this.d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        /* access modifiers changed from: package-private */
        public a a(com.bykv.vk.openvk.component.video.a.b.b.c cVar) {
            if (cVar != null) {
                this.e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* access modifiers changed from: package-private */
        public a a(List<i.b> list) {
            this.f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(int i2) {
            this.g = i2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(C0015b bVar) {
            this.i = bVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(i iVar) {
            this.h = iVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(Object obj) {
            this.j = obj;
            return this;
        }

        /* access modifiers changed from: package-private */
        public b a() {
            if (this.d != null && this.e != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && this.c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
