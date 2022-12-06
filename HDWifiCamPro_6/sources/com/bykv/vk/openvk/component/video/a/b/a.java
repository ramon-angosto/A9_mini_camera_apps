package com.bykv.vk.openvk.component.video.a.b;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bykv.vk.openvk.component.video.a.b.b.c;
import com.bykv.vk.openvk.component.video.a.b.e.b;
import com.bykv.vk.openvk.component.video.a.b.e.e;
import com.bykv.vk.openvk.component.video.a.b.i;
import com.bykv.vk.openvk.component.video.a.b.l;
import com.ironsource.mediationsdk.config.VersionInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AbsTask */
abstract class a implements k {
    private static final AtomicLong m = new AtomicLong();
    protected volatile com.bykv.vk.openvk.component.video.a.b.a.a a;
    protected final c b;
    protected final AtomicInteger c = new AtomicInteger();
    protected final AtomicLong d = new AtomicLong();
    protected com.bykv.vk.openvk.component.video.a.b.d.a e;
    protected volatile List<i.b> f;
    protected volatile String g;
    protected volatile String h;
    protected volatile i i;
    protected volatile l j;
    protected volatile boolean k = false;
    public final long l = m.incrementAndGet();
    private final AtomicInteger n = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public int o = -1;

    /* access modifiers changed from: protected */
    public void a(Boolean bool, String str, Throwable th) {
    }

    public a(com.bykv.vk.openvk.component.video.a.b.a.a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    public void a() {
        this.n.compareAndSet(0, 1);
    }

    public boolean b() {
        return this.n.get() == 1;
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.n.compareAndSet(0, 2);
    }

    public boolean d() {
        return this.n.get() == 2;
    }

    /* access modifiers changed from: protected */
    public void e() throws com.bykv.vk.openvk.component.video.a.b.c.a {
        if (b()) {
            throw new com.bykv.vk.openvk.component.video.a.b.c.a();
        }
    }

    /* access modifiers changed from: protected */
    public com.bykv.vk.openvk.component.video.a.b.e.a a(l.a aVar, int i2, int i3, String str) throws IOException {
        b b2 = com.bykv.vk.openvk.component.video.a.b.e.c.a().b();
        e eVar = new e();
        HashMap hashMap = new HashMap();
        eVar.b = aVar.a;
        eVar.a = 0;
        if (VersionInfo.GIT_BRANCH.equalsIgnoreCase(str)) {
            eVar.a = 4;
        }
        List<i.b> list = this.f;
        if (list != null && !list.isEmpty()) {
            for (i.b next : list) {
                if (!"Range".equalsIgnoreCase(next.a) && !"Connection".equalsIgnoreCase(next.a) && !"Proxy-Connection".equalsIgnoreCase(next.a) && !HttpHeaders.HOST.equalsIgnoreCase(next.a)) {
                    hashMap.put(next.a, next.b);
                }
            }
        }
        String a2 = com.bykv.vk.openvk.component.video.a.c.a.a(i2, i3);
        if (a2 != null) {
            hashMap.put("Range", a2);
        }
        if (e.f) {
            hashMap.put(HttpHeaders.CACHE_CONTROL, "no-cache");
        }
        d c2 = d.c();
        f a3 = f.a();
        boolean z = this.i == null;
        c a4 = z ? c2.a() : a3.b();
        c b3 = z ? c2.b() : a3.c();
        if (!(a4 == null && b3 == null)) {
            if (a4 != null) {
                eVar.c = a4.a(aVar.b);
            }
            if (b3 != null) {
                eVar.d = b3.a(aVar.b);
            }
        }
        eVar.e = hashMap;
        if (!this.k) {
            return b2.a(eVar);
        }
        this.k = false;
        return null;
    }

    /* access modifiers changed from: protected */
    public int f() {
        if (this.i != null) {
            return this.i.c.a;
        }
        return this.a instanceof com.bykv.vk.openvk.component.video.a.b.a.b ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return f() == 1;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        if (i2 > 0 && i3 >= 0) {
            int i4 = e.g;
            int f2 = f();
            if (i4 == 1 || (i4 == 2 && f2 == 1)) {
                int i5 = (int) ((((float) i3) / ((float) i2)) * 100.0f);
                if (i5 > 100) {
                    i5 = 100;
                }
                synchronized (this) {
                    if (i5 > this.o) {
                        this.o = i5;
                        com.bykv.vk.openvk.component.video.a.c.a.a((Runnable) new Runnable() {
                            public void run() {
                                if (a.this.e != null) {
                                    a.this.e.a(a.this.j, a.this.o);
                                }
                            }
                        });
                    }
                }
            }
        }
    }
}
