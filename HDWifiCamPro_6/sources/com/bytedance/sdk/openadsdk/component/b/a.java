package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.a.b.c;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.l.x;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FeedAdManager */
public class a {
    private static volatile a a;
    private final n b = m.c();

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private a() {
    }

    public void a(Context context, AdSlot adSlot, b bVar) {
        final x a2 = x.a();
        final b bVar2 = bVar;
        final Context context2 = context;
        final AdSlot adSlot2 = adSlot;
        this.b.a(adSlot, new o(), 5, new n.a() {
            public void a(int i, String str) {
                bVar2.onError(i, str);
            }

            public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                boolean z;
                if (aVar.b() == null || aVar.b().isEmpty()) {
                    bVar2.onError(-3, g.a(-3));
                    bVar.a(-3);
                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                    return;
                }
                List<com.bytedance.sdk.openadsdk.core.model.n> b2 = aVar.b();
                ArrayList arrayList = new ArrayList(b2.size());
                ArrayList arrayList2 = new ArrayList(b2.size());
                Iterator<com.bytedance.sdk.openadsdk.core.model.n> it = b2.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.bytedance.sdk.openadsdk.core.model.n next = it.next();
                    if (com.bytedance.sdk.openadsdk.core.model.n.c(next) || (next != null && next.ao())) {
                        c cVar = new c(context2, next, 5, adSlot2);
                        b bVar2 = bVar2;
                        if (bVar2 instanceof TTAdNative.FeedAdListener) {
                            arrayList.add(new b(cVar));
                        } else if (bVar2 instanceof PAGNativeAdLoadListener) {
                            arrayList2.add(cVar);
                        }
                    }
                    if (!(!com.bytedance.sdk.openadsdk.core.model.n.c(next) || next.J() == null || next.J().i() == null)) {
                        if (m.d().c(String.valueOf(next.aW())) && m.d().P()) {
                            if (next.J() != null) {
                                next.J().f(1);
                            }
                            if (next.aN() != null) {
                                next.aN().f(1);
                            }
                            com.bykv.vk.openvk.component.video.api.c.c a2 = com.bytedance.sdk.openadsdk.core.model.n.a(CacheDirFactory.getICacheDir(next.aL()).c(), next);
                            a2.a("material_meta", next);
                            a2.a("ad_slot", adSlot2);
                            com.bytedance.sdk.openadsdk.core.video.d.a.a(a2, (a.C0022a) null);
                        }
                    }
                }
                if ((!(bVar2 instanceof TTAdNative.FeedAdListener) || arrayList.isEmpty()) && (!(bVar2 instanceof PAGNativeAdLoadListener) || arrayList2.isEmpty())) {
                    z = false;
                }
                if (z) {
                    AdSlot adSlot = adSlot2;
                    if (adSlot == null) {
                        com.bytedance.sdk.openadsdk.c.c.a(context2, b2.get(0), y.b(5), a2);
                    } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.c.c.a(b2.get(0), "embeded_ad", a2.c());
                    } else {
                        com.bytedance.sdk.openadsdk.c.c.a(context2, b2.get(0), y.b(adSlot2.getDurationSlotType()), a2);
                    }
                    b bVar3 = bVar2;
                    if (bVar3 instanceof TTAdNative.FeedAdListener) {
                        ((TTAdNative.FeedAdListener) bVar3).onFeedAdLoad(arrayList);
                    } else if (bVar3 instanceof PAGNativeAdLoadListener) {
                        ((PAGNativeAdLoadListener) bVar3).onAdLoaded(arrayList2.get(0));
                    }
                    if (bVar.e() != null && !bVar.e().isEmpty()) {
                        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                        return;
                    }
                    return;
                }
                bVar2.onError(-4, g.a(-4));
                bVar.a(-4);
                com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
            }
        });
    }
}
