package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.component.reward.k;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.l.x;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardVideoLoadManager */
public class m {
    private static volatile m a;
    /* access modifiers changed from: private */
    public Context b;
    private final n c = com.bytedance.sdk.openadsdk.core.m.c();
    private AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public List<a> e = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public g f;
    private final v.a g = new v.a() {
        public void a(Context context, Intent intent, boolean z) {
            if (z) {
                if (m.this.f == null) {
                    m mVar = m.this;
                    g unused = mVar.f = new a("net connect task", mVar.e);
                }
                h.a().post(m.this.f);
            }
        }
    };

    public static m a(Context context) {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m(context);
                }
            }
        }
        return a;
    }

    private m(Context context) {
        this.b = context == null ? com.bytedance.sdk.openadsdk.core.m.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        AdSlot b2 = k.a(this.b).b();
        if (b2 != null && !TextUtils.isEmpty(b2.getCodeId()) && k.a(this.b).c(b2.getCodeId()) == null) {
            b(b2);
        }
    }

    public void a(AdSlot adSlot) {
        k.a(this.b).b(adSlot);
    }

    public void b() {
        try {
            k.a(this.b).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot, b bVar) {
        if (bVar instanceof TTAdNative.RewardVideoAdListener) {
            com.bytedance.sdk.openadsdk.tool.b.a(0, "rewarded");
        } else if (bVar instanceof PAGRewardedAdLoadListener) {
            com.bytedance.sdk.openadsdk.tool.b.a(1, "rewarded");
        }
        k.a(this.b).a(adSlot);
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
        com.bytedance.sdk.openadsdk.core.model.n c2 = k.a(this.b).c(adSlot.getCodeId());
        if (c2 != null) {
            p pVar = new p(this.b, c2, adSlot2);
            if (!p.i(c2)) {
                pVar.a(k.a(this.b).a(c2));
            }
            c.a(c2);
            if (bVar2 != null) {
                boolean z3 = bVar2 instanceof TTAdNative.RewardVideoAdListener;
                if (z3) {
                    ((TTAdNative.RewardVideoAdListener) bVar2).onRewardVideoAdLoad(pVar);
                } else if ((bVar2 instanceof PAGRewardedAdLoadListener) && com.bytedance.sdk.openadsdk.core.m.d().l() == 0) {
                    ((PAGRewardedAdLoadListener) bVar2).onAdLoaded(pVar.a());
                }
                if (!(bVar2 instanceof PAGRewardedAdLoadListener) || com.bytedance.sdk.openadsdk.core.m.d().l() != 1) {
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
                        final p pVar2 = pVar;
                        AnonymousClass1 r0 = new com.bykv.vk.openvk.component.video.api.e.b() {
                            public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                                Log.d("RewardVideoLoadManager", "onVideoPreloadSuccess: ");
                                c.a(m.this.b, nVar, y.b(adSlot3.getDurationSlotType()), xVar);
                                b bVar = bVar3;
                                if (bVar instanceof TTAdNative.RewardVideoAdListener) {
                                    ((TTAdNative.RewardVideoAdListener) bVar).onRewardVideoCached();
                                    l.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onRewardVideoCached");
                                } else if ((bVar instanceof PAGRewardedAdLoadListener) && com.bytedance.sdk.openadsdk.core.m.d().l() == 1) {
                                    ((PAGRewardedAdLoadListener) bVar3).onAdLoaded(pVar2.a());
                                }
                            }

                            public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i, String str) {
                                l.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail");
                                if (J.s()) {
                                    c.a(m.this.b, nVar, y.b(adSlot3.getDurationSlotType()), xVar);
                                    b bVar = bVar3;
                                    if (bVar instanceof TTAdNative.RewardVideoAdListener) {
                                        ((TTAdNative.RewardVideoAdListener) bVar).onRewardVideoCached();
                                        l.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail and exec onRewardVideoCached");
                                    }
                                }
                                if ((bVar3 instanceof PAGRewardedAdLoadListener) && com.bytedance.sdk.openadsdk.core.m.d().l() == 1) {
                                    bVar3.onError(i, str);
                                }
                            }
                        };
                        com.bytedance.sdk.openadsdk.core.video.d.a.a(a3, r13);
                        z2 = false;
                    } else {
                        c.a(this.b, c2, y.b(adSlot.getDurationSlotType()), a2);
                        if (z3) {
                            ((TTAdNative.RewardVideoAdListener) bVar2).onRewardVideoCached();
                        }
                    }
                }
                if (z2) {
                    ((PAGRewardedAdLoadListener) bVar2).onAdLoaded(pVar.a());
                }
            }
            final com.bytedance.sdk.openadsdk.core.model.n nVar2 = c2;
            final AdSlot adSlot4 = adSlot;
            final x xVar2 = a2;
            final b bVar4 = bVar;
            com.bytedance.sdk.openadsdk.core.video.b.a.a().a(c2, (a.C0049a) new a.C0049a() {
                public void a(boolean z) {
                    if (p.i(nVar2)) {
                        c.a(m.this.b, nVar2, y.b(adSlot4.getDurationSlotType()), xVar2);
                        b bVar = bVar4;
                        if (bVar instanceof TTAdNative.RewardVideoAdListener) {
                            ((TTAdNative.RewardVideoAdListener) bVar).onRewardVideoCached();
                        }
                    }
                }
            });
            l.b("RewardVideoLoadManager", "get cache data success");
            l.b("bidding", "reward video get cache data success");
            return;
        }
        a(adSlot2, false, a2, bVar2);
    }

    private void a(AdSlot adSlot, boolean z, x xVar, b bVar) {
        l.b("bidding", "reward video doNetwork , get new materials:BidAdm->MD5->" + com.bykv.vk.openvk.component.video.api.f.b.a(adSlot.getBidAdm()));
        final long currentTimeMillis = System.currentTimeMillis();
        o oVar = new o();
        oVar.b = z ? 2 : 1;
        if (com.bytedance.sdk.openadsdk.core.m.d().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            oVar.f = 2;
        }
        final boolean z2 = z;
        final b bVar2 = bVar;
        final AdSlot adSlot2 = adSlot;
        final x xVar2 = xVar;
        AdSlot adSlot3 = adSlot;
        this.c.a(adSlot, oVar, 7, new n.a() {
            public void a(int i, String str) {
                b bVar;
                if (!z2 && (bVar = bVar2) != null) {
                    bVar.onError(i, str);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x0177  */
            /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.openadsdk.core.model.a r7, com.bytedance.sdk.openadsdk.core.model.b r8) {
                /*
                    r6 = this;
                    java.util.List r0 = r7.b()
                    if (r0 == 0) goto L_0x0183
                    java.util.List r0 = r7.b()
                    boolean r0 = r0.isEmpty()
                    if (r0 != 0) goto L_0x0183
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    r8.<init>()
                    java.lang.String r0 = "get material data success isPreload="
                    r8.append(r0)
                    boolean r0 = r4
                    r8.append(r0)
                    java.lang.String r8 = r8.toString()
                    java.lang.String r0 = "RewardVideoLoadManager"
                    com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r8)
                    java.util.List r7 = r7.b()
                    r8 = 0
                    java.lang.Object r7 = r7.get(r8)
                    com.bytedance.sdk.openadsdk.core.model.n r7 = (com.bytedance.sdk.openadsdk.core.model.n) r7
                    r0 = 1
                    com.bytedance.sdk.openadsdk.core.model.k r1 = r7.M()     // Catch:{ all -> 0x007a }
                    if (r1 == 0) goto L_0x007a
                    com.bytedance.sdk.openadsdk.core.model.k r1 = r7.M()     // Catch:{ all -> 0x007a }
                    java.lang.String r1 = r1.a()     // Catch:{ all -> 0x007a }
                    boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x007a }
                    if (r1 != 0) goto L_0x007a
                    com.bytedance.sdk.openadsdk.i.b r1 = new com.bytedance.sdk.openadsdk.i.b     // Catch:{ all -> 0x007a }
                    r1.<init>(r0)     // Catch:{ all -> 0x007a }
                    com.bytedance.sdk.openadsdk.AdSlot r2 = r6     // Catch:{ all -> 0x007a }
                    java.lang.String r2 = r2.getCodeId()     // Catch:{ all -> 0x007a }
                    r1.a((java.lang.String) r2)     // Catch:{ all -> 0x007a }
                    r2 = 7
                    r1.a((int) r2)     // Catch:{ all -> 0x007a }
                    java.lang.String r2 = r7.Y()     // Catch:{ all -> 0x007a }
                    r1.c(r2)     // Catch:{ all -> 0x007a }
                    java.lang.String r2 = r7.ac()     // Catch:{ all -> 0x007a }
                    r1.d(r2)     // Catch:{ all -> 0x007a }
                    java.lang.String r2 = r7.aZ()     // Catch:{ all -> 0x007a }
                    r1.b(r2)     // Catch:{ all -> 0x007a }
                    com.bytedance.sdk.openadsdk.core.model.k r2 = r7.M()     // Catch:{ all -> 0x007a }
                    com.bytedance.sdk.component.d.j r2 = com.bytedance.sdk.openadsdk.e.a.a((com.bytedance.sdk.openadsdk.core.model.k) r2)     // Catch:{ all -> 0x007a }
                    r2.a((com.bytedance.sdk.component.d.o) r1)     // Catch:{ all -> 0x007a }
                L_0x007a:
                    com.bytedance.sdk.openadsdk.component.reward.p r1 = new com.bytedance.sdk.openadsdk.component.reward.p
                    com.bytedance.sdk.openadsdk.component.reward.m r2 = com.bytedance.sdk.openadsdk.component.reward.m.this
                    android.content.Context r2 = r2.b
                    com.bytedance.sdk.openadsdk.AdSlot r3 = r6
                    r1.<init>(r2, r7, r3)
                    boolean r2 = r4
                    if (r2 != 0) goto L_0x00c8
                    com.bytedance.sdk.openadsdk.AdSlot r2 = r6
                    java.lang.String r2 = r2.getBidAdm()
                    boolean r2 = android.text.TextUtils.isEmpty(r2)
                    if (r2 != 0) goto L_0x00a3
                    long r2 = java.lang.System.currentTimeMillis()
                    long r4 = r7
                    long r2 = r2 - r4
                    java.lang.String r4 = "rewarded_video"
                    com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.openadsdk.core.model.n) r7, (java.lang.String) r4, (long) r2)
                L_0x00a3:
                    com.bytedance.sdk.openadsdk.common.b r2 = r5
                    boolean r3 = r2 instanceof com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
                    if (r3 == 0) goto L_0x00af
                    com.bytedance.sdk.openadsdk.TTAdNative$RewardVideoAdListener r2 = (com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener) r2
                    r2.onRewardVideoAdLoad(r1)
                    goto L_0x00c8
                L_0x00af:
                    boolean r2 = r2 instanceof com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener
                    if (r2 == 0) goto L_0x00c8
                    com.bytedance.sdk.openadsdk.core.settings.j r2 = com.bytedance.sdk.openadsdk.core.m.d()
                    int r2 = r2.l()
                    if (r2 != 0) goto L_0x00c8
                    com.bytedance.sdk.openadsdk.common.b r2 = r5
                    com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener r2 = (com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener) r2
                    com.bytedance.sdk.openadsdk.component.reward.g r3 = r1.a()
                    r2.onAdLoaded(r3)
                L_0x00c8:
                    com.bytedance.sdk.openadsdk.core.video.b.a r2 = com.bytedance.sdk.openadsdk.core.video.b.a.a()
                    com.bytedance.sdk.openadsdk.component.reward.m$3$1 r3 = new com.bytedance.sdk.openadsdk.component.reward.m$3$1
                    r3.<init>(r7)
                    r2.a((com.bytedance.sdk.openadsdk.core.model.n) r7, (com.bytedance.sdk.openadsdk.core.video.b.a.C0049a) r3)
                    boolean r2 = r4
                    if (r2 == 0) goto L_0x0109
                    boolean r2 = com.bytedance.sdk.openadsdk.core.model.p.i(r7)
                    if (r2 != 0) goto L_0x0109
                    com.bytedance.sdk.openadsdk.core.settings.j r2 = com.bytedance.sdk.openadsdk.core.m.d()
                    com.bytedance.sdk.openadsdk.AdSlot r3 = r6
                    java.lang.String r3 = r3.getCodeId()
                    com.bytedance.sdk.openadsdk.core.settings.a r2 = r2.v(r3)
                    int r2 = r2.d
                    if (r2 != r0) goto L_0x0109
                    com.bytedance.sdk.openadsdk.component.reward.m r2 = com.bytedance.sdk.openadsdk.component.reward.m.this
                    android.content.Context r2 = r2.b
                    boolean r2 = com.bytedance.sdk.component.utils.o.d(r2)
                    if (r2 != 0) goto L_0x0109
                    com.bytedance.sdk.openadsdk.component.reward.m r8 = com.bytedance.sdk.openadsdk.component.reward.m.this
                    com.bytedance.sdk.openadsdk.component.reward.m$a r0 = new com.bytedance.sdk.openadsdk.component.reward.m$a
                    com.bytedance.sdk.openadsdk.AdSlot r1 = r6
                    r0.<init>(r7, r1)
                    r8.a((com.bytedance.sdk.openadsdk.component.reward.m.a) r0)
                    return
                L_0x0109:
                    com.bytedance.sdk.openadsdk.common.b r2 = r5
                    boolean r2 = r2 instanceof com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener
                    if (r2 == 0) goto L_0x011a
                    com.bytedance.sdk.openadsdk.core.settings.j r2 = com.bytedance.sdk.openadsdk.core.m.d()
                    int r2 = r2.l()
                    if (r2 != r0) goto L_0x011a
                    goto L_0x011b
                L_0x011a:
                    r0 = r8
                L_0x011b:
                    boolean r2 = com.bytedance.sdk.openadsdk.core.model.p.i(r7)
                    if (r2 != 0) goto L_0x0165
                    int r2 = android.os.Build.VERSION.SDK_INT
                    r3 = 23
                    if (r2 < r3) goto L_0x0152
                    com.bykv.vk.openvk.component.video.api.c.b r2 = r7.J()
                    if (r2 == 0) goto L_0x0174
                    int r0 = r7.aL()
                    com.bykv.vk.openvk.component.video.api.a.b r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
                    java.lang.String r0 = r0.a()
                    com.bykv.vk.openvk.component.video.api.c.c r0 = com.bytedance.sdk.openadsdk.core.model.n.a((java.lang.String) r0, (com.bytedance.sdk.openadsdk.core.model.n) r7)
                    java.lang.String r3 = "material_meta"
                    r0.a(r3, r7)
                    com.bytedance.sdk.openadsdk.AdSlot r3 = r6
                    java.lang.String r4 = "ad_slot"
                    r0.a(r4, r3)
                    com.bytedance.sdk.openadsdk.component.reward.m$3$2 r3 = new com.bytedance.sdk.openadsdk.component.reward.m$3$2
                    r3.<init>(r7, r1, r2)
                    com.bytedance.sdk.openadsdk.core.video.d.a.a(r0, r3)
                    goto L_0x0175
                L_0x0152:
                    com.bytedance.sdk.openadsdk.component.reward.m r0 = com.bytedance.sdk.openadsdk.component.reward.m.this
                    android.content.Context r0 = r0.b
                    com.bytedance.sdk.openadsdk.component.reward.k r0 = com.bytedance.sdk.openadsdk.component.reward.k.a((android.content.Context) r0)
                    com.bytedance.sdk.openadsdk.component.reward.m$3$3 r2 = new com.bytedance.sdk.openadsdk.component.reward.m$3$3
                    r2.<init>(r7, r1)
                    r0.a((com.bytedance.sdk.openadsdk.core.model.n) r7, (com.bytedance.sdk.openadsdk.component.reward.k.a<java.lang.Object>) r2)
                    goto L_0x0175
                L_0x0165:
                    com.bytedance.sdk.openadsdk.component.reward.m r8 = com.bytedance.sdk.openadsdk.component.reward.m.this
                    android.content.Context r8 = r8.b
                    com.bytedance.sdk.openadsdk.component.reward.k r8 = com.bytedance.sdk.openadsdk.component.reward.k.a((android.content.Context) r8)
                    com.bytedance.sdk.openadsdk.AdSlot r2 = r6
                    r8.a((com.bytedance.sdk.openadsdk.AdSlot) r2, (com.bytedance.sdk.openadsdk.core.model.n) r7)
                L_0x0174:
                    r8 = r0
                L_0x0175:
                    if (r8 == 0) goto L_0x0199
                    com.bytedance.sdk.openadsdk.common.b r7 = r5
                    com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener r7 = (com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener) r7
                    com.bytedance.sdk.openadsdk.component.reward.g r8 = r1.a()
                    r7.onAdLoaded(r8)
                    goto L_0x0199
                L_0x0183:
                    boolean r7 = r4
                    if (r7 != 0) goto L_0x0199
                    com.bytedance.sdk.openadsdk.common.b r7 = r5
                    if (r7 == 0) goto L_0x0199
                    r0 = -3
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)
                    r7.onError(r0, r1)
                    r8.a((int) r0)
                    com.bytedance.sdk.openadsdk.core.model.b.a((com.bytedance.sdk.openadsdk.core.model.b) r8)
                L_0x0199:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.m.AnonymousClass3.a(com.bytedance.sdk.openadsdk.core.model.a, com.bytedance.sdk.openadsdk.core.model.b):void");
            }
        });
    }

    public void a(String str) {
        k.a(this.b).a(str);
    }

    public AdSlot b(String str) {
        return k.a(this.b).b(str);
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

    /* compiled from: RewardVideoLoadManager */
    public static class a extends g {
        com.bytedance.sdk.openadsdk.core.model.n a;
        AdSlot b;

        a(com.bytedance.sdk.openadsdk.core.model.n nVar, AdSlot adSlot) {
            super("Reward Task");
            this.a = nVar;
            this.b = adSlot;
        }

        public void run() {
            if (this.a != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    k.a(com.bytedance.sdk.openadsdk.core.m.a()).a(this.a, (k.a<Object>) new k.a<Object>() {
                        public void a(boolean z, Object obj) {
                            if (z) {
                                l.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                                k.a(com.bytedance.sdk.openadsdk.core.m.a()).a(a.this.b, a.this.a);
                                return;
                            }
                            l.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
                        }
                    });
                } else if (this.a.J() != null) {
                    com.bykv.vk.openvk.component.video.api.c.c a2 = com.bytedance.sdk.openadsdk.core.model.n.a(CacheDirFactory.getICacheDir(this.a.aL()).a(), this.a);
                    a2.a("material_meta", this.a);
                    a2.a("ad_slot", this.b);
                    com.bytedance.sdk.openadsdk.core.video.d.a.a(a2, new com.bykv.vk.openvk.component.video.api.e.b() {
                        public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                            l.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                            k.a(com.bytedance.sdk.openadsdk.core.m.a()).a(a.this.b, a.this.a);
                        }

                        public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i, String str) {
                            l.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
                        }
                    });
                }
            }
        }
    }
}
