package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.core.bannerexpress.e;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.x;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ExpressAdLoadManager */
public class c {
    private static Set<c> k = Collections.synchronizedSet(new HashSet());
    private AdSlot a;
    private final n b = m.c();
    private Context c;
    /* access modifiers changed from: private */
    public TTAdNative.NativeExpressAdListener d;
    private PAGBannerAdLoadListener e;
    private final AtomicBoolean f = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public List<com.bytedance.sdk.openadsdk.core.model.n> g;
    /* access modifiers changed from: private */
    public List<com.bytedance.sdk.openadsdk.core.model.n> h;
    /* access modifiers changed from: private */
    public a i;
    private int j = 5;
    private ScheduledFuture<?> l = null;
    private ScheduledFuture<?> m = null;
    private ScheduledFuture<?> n = null;
    /* access modifiers changed from: private */
    public final x o = x.b();

    /* compiled from: ExpressAdLoadManager */
    public interface a {
        void a();

        void a(List<com.bytedance.sdk.openadsdk.core.model.n> list);
    }

    private c(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = m.a();
        }
        k.add(this);
    }

    public static c a(Context context) {
        return new c(context);
    }

    public void a(AdSlot adSlot, int i2, b bVar, int i3) {
        a(adSlot, i2, bVar, (a) null, i3);
    }

    public void a(AdSlot adSlot, int i2, b bVar, a aVar, int i3) {
        this.o.d();
        if (this.f.get()) {
            l.e("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.j = i2;
        this.f.set(true);
        this.a = adSlot;
        if (bVar instanceof TTAdNative.NativeExpressAdListener) {
            this.d = (TTAdNative.NativeExpressAdListener) bVar;
        } else if (bVar instanceof PAGBannerAdLoadListener) {
            this.e = (PAGBannerAdLoadListener) bVar;
        }
        this.i = aVar;
        a(this.a, bVar);
    }

    private void a(final AdSlot adSlot, b bVar) {
        if (adSlot != null) {
            o oVar = new o();
            oVar.f = 2;
            this.b.a(adSlot, oVar, this.j, new n.a() {
                public void a(int i, String str) {
                    c.this.a(i, str);
                }

                public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                    if (aVar.b() == null || aVar.b().isEmpty()) {
                        c.this.a(-3, g.a(-3));
                        bVar.a(-3);
                        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                        return;
                    }
                    List unused = c.this.g = aVar.b();
                    List unused2 = c.this.h = aVar.b();
                    c.this.a(adSlot);
                    c cVar = c.this;
                    cVar.a(cVar.o);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        List<com.bytedance.sdk.openadsdk.core.model.n> list = this.g;
        if (list != null) {
            for (com.bytedance.sdk.openadsdk.core.model.n next : list) {
                if (next.ao() && next.P() != null && !next.P().isEmpty()) {
                    for (k next2 : next.P()) {
                        if (!TextUtils.isEmpty(next2.a())) {
                            d.a().c().a(new com.bytedance.sdk.openadsdk.i.a(next2.a(), next2.g()), com.bytedance.sdk.openadsdk.i.a.a.b(), next2.b(), next2.c(), (String) null);
                        }
                    }
                }
                if (!(!com.bytedance.sdk.openadsdk.core.model.n.c(next) || next.J() == null || next.J().i() == null)) {
                    if (m.d().c(String.valueOf(next.aW())) && m.d().P()) {
                        com.bykv.vk.openvk.component.video.api.c.c a2 = com.bytedance.sdk.openadsdk.core.model.n.a(CacheDirFactory.getICacheDir(next.aL()).c(), next);
                        a2.a("material_meta", next);
                        a2.a("ad_slot", adSlot);
                        com.bytedance.sdk.openadsdk.core.video.d.a.a(a2, (a.C0022a) null);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final x xVar) {
        if (this.f.getAndSet(false)) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.h == null || c.this.h.size() <= 0) {
                        if (c.this.d != null) {
                            c.this.d.onError(108, g.a(108));
                            c.this.a(108);
                        }
                        if (c.this.i != null) {
                            c.this.i.a();
                        }
                    } else {
                        c.this.b(xVar);
                        c.this.c(xVar);
                        if (c.this.i != null) {
                            c.this.i.a(c.this.h);
                        }
                    }
                    c.this.a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(x xVar) {
        if (this.d != null) {
            ArrayList arrayList = new ArrayList(this.h.size());
            for (com.bytedance.sdk.openadsdk.core.model.n a2 : this.h) {
                arrayList.add(a(a2));
            }
            if (!arrayList.isEmpty()) {
                if (!TextUtils.isEmpty(this.a.getBidAdm())) {
                    com.bytedance.sdk.openadsdk.c.c.a(this.h.get(0), y.b(this.j), this.o.c());
                } else {
                    com.bytedance.sdk.openadsdk.c.c.a(this.c, this.h.get(0), y.b(this.a.getDurationSlotType()), xVar);
                }
                this.d.onNativeExpressAdLoad(arrayList);
                return;
            }
            this.d.onError(103, g.a(103));
            a(103);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000b A[LOOP:0: B:3:0x000b->B:6:0x001b, LOOP_START, PHI: r0 
      PHI: (r0v2 com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd) = (r0v1 com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd), (r0v7 com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd) binds: [B:2:0x0004, B:6:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.bytedance.sdk.openadsdk.l.x r6) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener r0 = r5.e
            if (r0 == 0) goto L_0x006f
            r0 = 0
            java.util.List<com.bytedance.sdk.openadsdk.core.model.n> r1 = r5.h
            java.util.Iterator r1 = r1.iterator()
        L_0x000b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x001d
            java.lang.Object r0 = r1.next()
            com.bytedance.sdk.openadsdk.core.model.n r0 = (com.bytedance.sdk.openadsdk.core.model.n) r0
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd r0 = r5.b((com.bytedance.sdk.openadsdk.core.model.n) r0)
            if (r0 == 0) goto L_0x000b
        L_0x001d:
            if (r0 == 0) goto L_0x0061
            com.bytedance.sdk.openadsdk.AdSlot r1 = r5.a
            java.lang.String r1 = r1.getBidAdm()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0044
            com.bytedance.sdk.openadsdk.l.x r6 = r5.o
            long r3 = r6.c()
            java.util.List<com.bytedance.sdk.openadsdk.core.model.n> r6 = r5.h
            java.lang.Object r6 = r6.get(r2)
            com.bytedance.sdk.openadsdk.core.model.n r6 = (com.bytedance.sdk.openadsdk.core.model.n) r6
            int r1 = r5.j
            java.lang.String r1 = com.bytedance.sdk.openadsdk.l.y.b((int) r1)
            com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.openadsdk.core.model.n) r6, (java.lang.String) r1, (long) r3)
            goto L_0x005b
        L_0x0044:
            android.content.Context r1 = r5.c
            java.util.List<com.bytedance.sdk.openadsdk.core.model.n> r3 = r5.h
            java.lang.Object r2 = r3.get(r2)
            com.bytedance.sdk.openadsdk.core.model.n r2 = (com.bytedance.sdk.openadsdk.core.model.n) r2
            com.bytedance.sdk.openadsdk.AdSlot r3 = r5.a
            int r3 = r3.getDurationSlotType()
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.y.b((int) r3)
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r1, (com.bytedance.sdk.openadsdk.core.model.n) r2, (java.lang.String) r3, (com.bytedance.sdk.openadsdk.l.x) r6)
        L_0x005b:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener r6 = r5.e
            r6.onAdLoaded(r0)
            goto L_0x006f
        L_0x0061:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener r6 = r5.e
            r0 = 103(0x67, float:1.44E-43)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)
            r6.onError(r0, r1)
            r5.a((int) r0)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.c.c(com.bytedance.sdk.openadsdk.l.x):void");
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        List<com.bytedance.sdk.openadsdk.core.model.n> list = this.g;
        com.bytedance.sdk.openadsdk.h.a.b e2 = com.bytedance.sdk.openadsdk.h.a.b.b().a(this.j).c(this.a.getCodeId()).e((list == null || list.size() <= 0) ? "" : this.g.get(0).aZ());
        e2.b(i2).f(g.a(i2));
        com.bytedance.sdk.openadsdk.h.b.a().b(e2);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.f.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i2, str);
            }
            PAGBannerAdLoadListener pAGBannerAdLoadListener = this.e;
            if (pAGBannerAdLoadListener != null) {
                pAGBannerAdLoadListener.onError(i2, str);
            }
            a aVar = this.i;
            if (aVar != null) {
                aVar.a();
            }
            a();
        }
    }

    private TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.model.n nVar) {
        if (this.j != 1) {
            return null;
        }
        if (nVar.J() != null) {
            return new e(this.c, nVar, this.a);
        }
        return new com.bytedance.sdk.openadsdk.core.bannerexpress.d(this.c, nVar, this.a);
    }

    private PAGBannerAd b(com.bytedance.sdk.openadsdk.core.model.n nVar) {
        if (this.j != 1) {
            return null;
        }
        if (nVar.J() != null) {
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.c, nVar, this.a);
        }
        return new com.bytedance.sdk.openadsdk.core.bannerexpress.a(this.c, nVar, this.a);
    }

    /* access modifiers changed from: private */
    public void a() {
        List<com.bytedance.sdk.openadsdk.core.model.n> list = this.g;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.model.n> list2 = this.h;
        if (list2 != null) {
            list2.clear();
        }
        a(true);
        b(true);
        c(true);
        b();
    }

    private void a(boolean z) {
        try {
            if (this.m != null && !this.m.isCancelled()) {
                boolean cancel = this.m.cancel(z);
                l.e("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void b(boolean z) {
        try {
            if (this.n != null && !this.n.isCancelled()) {
                boolean cancel = this.n.cancel(z);
                l.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void c(boolean z) {
        try {
            if (this.l != null && !this.l.isCancelled()) {
                boolean cancel = this.l.cancel(z);
                l.e("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void b() {
        k.remove(this);
    }
}
