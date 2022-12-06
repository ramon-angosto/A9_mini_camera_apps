package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.component.reward.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.l.x;
import com.bytedance.sdk.openadsdk.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FullScreenVideoLoadManager */
public class d {
    private static volatile d a;
    /* access modifiers changed from: private */
    public Context b;
    private final n c = m.c();
    private AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public List<a> e = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public g f;
    private final v.a g = new v.a() {
        public void a(Context context, Intent intent, boolean z) {
            if (z) {
                if (d.this.f == null) {
                    d dVar = d.this;
                    g unused = dVar.f = new a("fsv net connect task", dVar.e);
                }
                h.a().post(d.this.f);
            }
        }
    };

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private d(Context context) {
        this.b = context == null ? m.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        try {
            b.a(this.b).a();
        } catch (Throwable unused) {
        }
    }

    public void b() {
        AdSlot b2 = b.a(this.b).b();
        if (b2 != null && !TextUtils.isEmpty(b2.getCodeId()) && b.a(this.b).c(b2.getCodeId()) == null) {
            b(b2);
        }
    }

    public void a(AdSlot adSlot) {
        b.a(this.b).b(adSlot);
    }

    public void a(AdSlot adSlot, b bVar) {
        if (bVar instanceof TTAdNative.FullScreenVideoAdListener) {
            com.bytedance.sdk.openadsdk.tool.b.a(0, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
        } else if (bVar instanceof PAGInterstitialAdLoadListener) {
            com.bytedance.sdk.openadsdk.tool.b.a(1, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
        }
        b.a(this.b).a(adSlot);
        a(adSlot, false, bVar);
    }

    public void b(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getBidAdm())) {
            a(adSlot, true, (b) null);
        }
    }

    private void a(AdSlot adSlot, boolean z, b bVar) {
        AdSlot adSlot2 = adSlot;
        b bVar2 = bVar;
        x a2 = x.a();
        boolean z2 = true;
        if (z) {
            a(adSlot2, true, a2, bVar2);
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.n c2 = b.a(this.b).c(adSlot.getCodeId());
        if (c2 != null) {
            o oVar = new o(this.b, c2, adSlot2);
            if (!p.i(c2)) {
                oVar.a(b.a(this.b).a(c2));
            }
            c.a(c2);
            if (bVar2 != null) {
                boolean z3 = bVar2 instanceof TTAdNative.FullScreenVideoAdListener;
                if (z3) {
                    ((TTAdNative.FullScreenVideoAdListener) bVar2).onFullScreenVideoAdLoad(oVar);
                } else if ((bVar2 instanceof PAGInterstitialAdLoadListener) && m.d().l() == 0) {
                    ((PAGInterstitialAdLoadListener) bVar2).onAdLoaded(oVar.a());
                }
                if (!(bVar2 instanceof PAGInterstitialAdLoadListener) || m.d().l() != 1) {
                    z2 = false;
                }
                if (!p.i(c2)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        final com.bykv.vk.openvk.component.video.api.c.b J = c2.J();
                        com.bykv.vk.openvk.component.video.api.c.c a3 = com.bytedance.sdk.openadsdk.core.model.n.a(CacheDirFactory.getICacheDir(c2.aL()).a(), c2);
                        a3.a("material_meta", c2);
                        a3.a("ad_slot", adSlot2);
                        final com.bytedance.sdk.openadsdk.core.model.n nVar = c2;
                        final AdSlot adSlot3 = adSlot;
                        final x xVar = a2;
                        final b bVar3 = bVar;
                        AnonymousClass1 r13 = r0;
                        final o oVar2 = oVar;
                        AnonymousClass1 r0 = new com.bykv.vk.openvk.component.video.api.e.b() {
                            public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                                c.a(d.this.b, nVar, y.b(adSlot3.getDurationSlotType()), xVar);
                                b bVar = bVar3;
                                if (bVar instanceof TTAdNative.FullScreenVideoAdListener) {
                                    ((TTAdNative.FullScreenVideoAdListener) bVar).onFullScreenVideoCached();
                                    l.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onFullScreenVideoCached");
                                } else if ((bVar instanceof PAGInterstitialAdLoadListener) && m.d().l() == 1) {
                                    ((PAGInterstitialAdLoadListener) bVar3).onAdLoaded(oVar2.a());
                                }
                            }

                            public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i, String str) {
                                l.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail");
                                if (J.s()) {
                                    c.a(d.this.b, nVar, y.b(adSlot3.getDurationSlotType()), xVar);
                                    b bVar = bVar3;
                                    if (bVar instanceof TTAdNative.FullScreenVideoAdListener) {
                                        ((TTAdNative.FullScreenVideoAdListener) bVar).onFullScreenVideoCached();
                                        l.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail and exec onFullScreenVideoCached");
                                    }
                                }
                                if ((bVar3 instanceof PAGInterstitialAdLoadListener) && m.d().l() == 1) {
                                    bVar3.onError(i, str);
                                }
                            }
                        };
                        com.bytedance.sdk.openadsdk.core.video.d.a.a(a3, r13);
                        z2 = false;
                    } else {
                        c.a(this.b, c2, y.b(adSlot.getDurationSlotType()), a2);
                        if (z3) {
                            ((TTAdNative.FullScreenVideoAdListener) bVar2).onFullScreenVideoCached();
                        }
                    }
                }
                if (z2) {
                    ((PAGInterstitialAdLoadListener) bVar2).onAdLoaded(oVar.a());
                }
            }
            final com.bytedance.sdk.openadsdk.core.model.n nVar2 = c2;
            final AdSlot adSlot4 = adSlot;
            final x xVar2 = a2;
            final b bVar4 = bVar;
            com.bytedance.sdk.openadsdk.core.video.b.a.a().a(c2, (a.C0049a) new a.C0049a() {
                public void a(boolean z) {
                    if (p.i(nVar2)) {
                        c.a(d.this.b, nVar2, y.b(adSlot4.getDurationSlotType()), xVar2);
                        b bVar = bVar4;
                        if (bVar instanceof TTAdNative.FullScreenVideoAdListener) {
                            ((TTAdNative.FullScreenVideoAdListener) bVar).onFullScreenVideoCached();
                        }
                    }
                }
            });
            l.b("FullScreenVideoLoadManager", "get cache data success");
            l.b("bidding", "full video get cache data success");
            return;
        }
        a(adSlot2, false, a2, bVar2);
    }

    private void a(AdSlot adSlot, boolean z, x xVar, b bVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        o oVar = new o();
        oVar.c = z ? 2 : 1;
        if (m.d().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            oVar.f = 2;
        }
        final boolean z2 = z;
        final b bVar2 = bVar;
        final AdSlot adSlot2 = adSlot;
        final x xVar2 = xVar;
        AdSlot adSlot3 = adSlot;
        this.c.a(adSlot, oVar, 8, new n.a() {
            public void a(int i, String str) {
                b bVar;
                if (!z2 && (bVar = bVar2) != null) {
                    bVar.onError(i, str);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x017d  */
            /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.openadsdk.core.model.a r8, com.bytedance.sdk.openadsdk.core.model.b r9) {
                /*
                    r7 = this;
                    java.util.List r0 = r8.b()
                    if (r0 == 0) goto L_0x0189
                    java.util.List r0 = r8.b()
                    boolean r0 = r0.isEmpty()
                    if (r0 != 0) goto L_0x0189
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    java.lang.String r0 = "get material data success isPreload="
                    r9.append(r0)
                    boolean r0 = r2
                    r9.append(r0)
                    java.lang.String r9 = r9.toString()
                    java.lang.String r0 = "FullScreenVideoLoadManager"
                    com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r9)
                    java.util.List r8 = r8.b()
                    r9 = 0
                    java.lang.Object r8 = r8.get(r9)
                    com.bytedance.sdk.openadsdk.core.model.n r8 = (com.bytedance.sdk.openadsdk.core.model.n) r8
                    r1 = 1
                    com.bytedance.sdk.openadsdk.core.model.k r2 = r8.M()     // Catch:{ all -> 0x007b }
                    if (r2 == 0) goto L_0x007b
                    com.bytedance.sdk.openadsdk.core.model.k r2 = r8.M()     // Catch:{ all -> 0x007b }
                    java.lang.String r2 = r2.a()     // Catch:{ all -> 0x007b }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x007b }
                    if (r2 != 0) goto L_0x007b
                    com.bytedance.sdk.openadsdk.i.b r2 = new com.bytedance.sdk.openadsdk.i.b     // Catch:{ all -> 0x007b }
                    r2.<init>(r1)     // Catch:{ all -> 0x007b }
                    com.bytedance.sdk.openadsdk.AdSlot r3 = r4     // Catch:{ all -> 0x007b }
                    java.lang.String r3 = r3.getCodeId()     // Catch:{ all -> 0x007b }
                    r2.a((java.lang.String) r3)     // Catch:{ all -> 0x007b }
                    r3 = 8
                    r2.a((int) r3)     // Catch:{ all -> 0x007b }
                    java.lang.String r3 = r8.Y()     // Catch:{ all -> 0x007b }
                    r2.c(r3)     // Catch:{ all -> 0x007b }
                    java.lang.String r3 = r8.ac()     // Catch:{ all -> 0x007b }
                    r2.d(r3)     // Catch:{ all -> 0x007b }
                    java.lang.String r3 = r8.aZ()     // Catch:{ all -> 0x007b }
                    r2.b(r3)     // Catch:{ all -> 0x007b }
                    com.bytedance.sdk.openadsdk.core.model.k r3 = r8.M()     // Catch:{ all -> 0x007b }
                    com.bytedance.sdk.component.d.j r3 = com.bytedance.sdk.openadsdk.e.a.a((com.bytedance.sdk.openadsdk.core.model.k) r3)     // Catch:{ all -> 0x007b }
                    r3.a((com.bytedance.sdk.component.d.o) r2)     // Catch:{ all -> 0x007b }
                L_0x007b:
                    com.bytedance.sdk.openadsdk.component.reward.o r2 = new com.bytedance.sdk.openadsdk.component.reward.o
                    com.bytedance.sdk.openadsdk.component.reward.d r3 = com.bytedance.sdk.openadsdk.component.reward.d.this
                    android.content.Context r3 = r3.b
                    com.bytedance.sdk.openadsdk.AdSlot r4 = r4
                    r2.<init>(r3, r8, r4)
                    boolean r3 = r2
                    if (r3 != 0) goto L_0x00c9
                    com.bytedance.sdk.openadsdk.AdSlot r3 = r4
                    java.lang.String r3 = r3.getBidAdm()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L_0x00a4
                    long r3 = java.lang.System.currentTimeMillis()
                    long r5 = r5
                    long r3 = r3 - r5
                    java.lang.String r5 = "fullscreen_interstitial_ad"
                    com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.openadsdk.core.model.n) r8, (java.lang.String) r5, (long) r3)
                L_0x00a4:
                    com.bytedance.sdk.openadsdk.common.b r3 = r3
                    boolean r4 = r3 instanceof com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                    if (r4 == 0) goto L_0x00b0
                    com.bytedance.sdk.openadsdk.TTAdNative$FullScreenVideoAdListener r3 = (com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener) r3
                    r3.onFullScreenVideoAdLoad(r2)
                    goto L_0x00c9
                L_0x00b0:
                    boolean r3 = r3 instanceof com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener
                    if (r3 == 0) goto L_0x00c9
                    com.bytedance.sdk.openadsdk.core.settings.j r3 = com.bytedance.sdk.openadsdk.core.m.d()
                    int r3 = r3.l()
                    if (r3 != 0) goto L_0x00c9
                    com.bytedance.sdk.openadsdk.common.b r3 = r3
                    com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener r3 = (com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener) r3
                    com.bytedance.sdk.openadsdk.component.reward.e r4 = r2.a()
                    r3.onAdLoaded(r4)
                L_0x00c9:
                    com.bytedance.sdk.openadsdk.core.video.b.a r3 = com.bytedance.sdk.openadsdk.core.video.b.a.a()
                    com.bytedance.sdk.openadsdk.component.reward.d$3$1 r4 = new com.bytedance.sdk.openadsdk.component.reward.d$3$1
                    r4.<init>(r8)
                    r3.a((com.bytedance.sdk.openadsdk.core.model.n) r8, (com.bytedance.sdk.openadsdk.core.video.b.a.C0049a) r4)
                    boolean r3 = r2
                    if (r3 == 0) goto L_0x010a
                    boolean r3 = com.bytedance.sdk.openadsdk.core.model.p.i(r8)
                    if (r3 != 0) goto L_0x010a
                    com.bytedance.sdk.openadsdk.core.settings.j r3 = com.bytedance.sdk.openadsdk.core.m.d()
                    com.bytedance.sdk.openadsdk.AdSlot r4 = r4
                    java.lang.String r4 = r4.getCodeId()
                    com.bytedance.sdk.openadsdk.core.settings.a r3 = r3.v(r4)
                    int r3 = r3.d
                    if (r3 != r1) goto L_0x010a
                    com.bytedance.sdk.openadsdk.component.reward.d r3 = com.bytedance.sdk.openadsdk.component.reward.d.this
                    android.content.Context r3 = r3.b
                    boolean r3 = com.bytedance.sdk.component.utils.o.d(r3)
                    if (r3 != 0) goto L_0x010a
                    com.bytedance.sdk.openadsdk.component.reward.d r9 = com.bytedance.sdk.openadsdk.component.reward.d.this
                    com.bytedance.sdk.openadsdk.component.reward.d$a r0 = new com.bytedance.sdk.openadsdk.component.reward.d$a
                    com.bytedance.sdk.openadsdk.AdSlot r1 = r4
                    r0.<init>(r8, r1)
                    r9.a((com.bytedance.sdk.openadsdk.component.reward.d.a) r0)
                    return
                L_0x010a:
                    com.bytedance.sdk.openadsdk.common.b r3 = r3
                    boolean r3 = r3 instanceof com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener
                    if (r3 == 0) goto L_0x011b
                    com.bytedance.sdk.openadsdk.core.settings.j r3 = com.bytedance.sdk.openadsdk.core.m.d()
                    int r3 = r3.l()
                    if (r3 != r1) goto L_0x011b
                    goto L_0x011c
                L_0x011b:
                    r1 = r9
                L_0x011c:
                    boolean r3 = com.bytedance.sdk.openadsdk.core.model.p.i(r8)
                    if (r3 != 0) goto L_0x016b
                    int r3 = android.os.Build.VERSION.SDK_INT
                    r4 = 23
                    if (r3 < r4) goto L_0x0158
                    com.bykv.vk.openvk.component.video.api.c.b r3 = r8.J()
                    if (r3 == 0) goto L_0x017a
                    int r1 = r8.aL()
                    com.bykv.vk.openvk.component.video.api.a.b r1 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r1)
                    java.lang.String r1 = r1.a()
                    com.bykv.vk.openvk.component.video.api.c.c r1 = com.bytedance.sdk.openadsdk.core.model.n.a((java.lang.String) r1, (com.bytedance.sdk.openadsdk.core.model.n) r8)
                    java.lang.String r4 = "material_meta"
                    r1.a(r4, r8)
                    com.bytedance.sdk.openadsdk.AdSlot r4 = r4
                    java.lang.String r5 = "ad_slot"
                    r1.a(r5, r4)
                    java.lang.String r4 = "FullScreenLog: preload video "
                    com.bytedance.sdk.component.utils.l.c((java.lang.String) r0, (java.lang.String) r4)
                    com.bytedance.sdk.openadsdk.component.reward.d$3$2 r0 = new com.bytedance.sdk.openadsdk.component.reward.d$3$2
                    r0.<init>(r8, r2, r3)
                    com.bytedance.sdk.openadsdk.core.video.d.a.a(r1, r0)
                    goto L_0x017b
                L_0x0158:
                    com.bytedance.sdk.openadsdk.component.reward.d r0 = com.bytedance.sdk.openadsdk.component.reward.d.this
                    android.content.Context r0 = r0.b
                    com.bytedance.sdk.openadsdk.component.reward.b r0 = com.bytedance.sdk.openadsdk.component.reward.b.a((android.content.Context) r0)
                    com.bytedance.sdk.openadsdk.component.reward.d$3$3 r1 = new com.bytedance.sdk.openadsdk.component.reward.d$3$3
                    r1.<init>(r8, r2)
                    r0.a((com.bytedance.sdk.openadsdk.core.model.n) r8, (com.bytedance.sdk.openadsdk.component.reward.b.a<java.lang.Object>) r1)
                    goto L_0x017b
                L_0x016b:
                    com.bytedance.sdk.openadsdk.component.reward.d r9 = com.bytedance.sdk.openadsdk.component.reward.d.this
                    android.content.Context r9 = r9.b
                    com.bytedance.sdk.openadsdk.component.reward.b r9 = com.bytedance.sdk.openadsdk.component.reward.b.a((android.content.Context) r9)
                    com.bytedance.sdk.openadsdk.AdSlot r0 = r4
                    r9.a((com.bytedance.sdk.openadsdk.AdSlot) r0, (com.bytedance.sdk.openadsdk.core.model.n) r8)
                L_0x017a:
                    r9 = r1
                L_0x017b:
                    if (r9 == 0) goto L_0x019f
                    com.bytedance.sdk.openadsdk.common.b r8 = r3
                    com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener r8 = (com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener) r8
                    com.bytedance.sdk.openadsdk.component.reward.e r9 = r2.a()
                    r8.onAdLoaded(r9)
                    goto L_0x019f
                L_0x0189:
                    boolean r8 = r2
                    if (r8 != 0) goto L_0x019f
                    com.bytedance.sdk.openadsdk.common.b r8 = r3
                    if (r8 == 0) goto L_0x019f
                    r0 = -3
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)
                    r8.onError(r0, r1)
                    r9.a((int) r0)
                    com.bytedance.sdk.openadsdk.core.model.b.a((com.bytedance.sdk.openadsdk.core.model.b) r9)
                L_0x019f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.d.AnonymousClass3.a(com.bytedance.sdk.openadsdk.core.model.a, com.bytedance.sdk.openadsdk.core.model.b):void");
            }
        });
    }

    public void a(String str) {
        b.a(this.b).a(str);
    }

    public AdSlot b(String str) {
        return b.a(this.b).b(str);
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            if (this.e.size() >= 1) {
                this.e.remove(0);
            }
            this.e.add(aVar);
        }
    }

    private void c() {
        if (!this.d.get()) {
            this.d.set(true);
            v.a(this.g, this.b);
        }
    }

    private void d() {
        if (this.d.get()) {
            this.d.set(false);
            try {
                v.a(this.g);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.f != null) {
            try {
                h.a().removeCallbacks(this.f);
            } catch (Exception unused) {
            }
            this.f = null;
        }
        d();
    }

    /* compiled from: FullScreenVideoLoadManager */
    private static class a extends g {
        com.bytedance.sdk.openadsdk.core.model.n a;
        AdSlot b;

        a(com.bytedance.sdk.openadsdk.core.model.n nVar, AdSlot adSlot) {
            super("Fullscreen Task");
            this.a = nVar;
            this.b = adSlot;
        }

        public void run() {
            if (this.a != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    b.a(m.a()).a(this.a, (b.a<Object>) new b.a<Object>() {
                        public void a(boolean z, Object obj) {
                            if (z) {
                                b.a(m.a()).a(a.this.b, a.this.a);
                                l.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
                                return;
                            }
                            l.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail ");
                        }
                    });
                } else if (this.a.J() != null) {
                    com.bykv.vk.openvk.component.video.api.c.c a2 = com.bytedance.sdk.openadsdk.core.model.n.a(CacheDirFactory.getICacheDir(this.a.aL()).a(), this.a);
                    a2.a("material_meta", this.a);
                    a2.a("ad_slot", this.b);
                    l.c("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                    com.bytedance.sdk.openadsdk.core.video.d.a.a(a2, new com.bykv.vk.openvk.component.video.api.e.b() {
                        public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                            b.a(m.a()).a(a.this.b, a.this.a);
                            l.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
                        }

                        public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i, String str) {
                            l.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail with net change ");
                        }
                    });
                }
            }
        }
    }
}
