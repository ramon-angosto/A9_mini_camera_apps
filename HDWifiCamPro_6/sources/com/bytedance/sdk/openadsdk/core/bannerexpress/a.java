package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.l.s;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: PAGBannerAdImpl */
public class a extends PAGBannerAd implements x.a {
    protected BannerExpressView a;
    protected final Context b;
    protected n c;
    protected AdSlot d;
    TTDislikeDialogAbstract e;
    public AtomicBoolean f = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public PAGBannerAdWrapperListener g;
    /* access modifiers changed from: private */
    public boolean h = true;
    /* access modifiers changed from: private */
    public int i;
    private int j = 0;
    /* access modifiers changed from: private */
    public c k;
    /* access modifiers changed from: private */
    public com.com.bytedance.overseas.sdk.a.c l;
    private x m;
    private TTAdDislike.DislikeInteractionCallback n;
    private Context o;
    /* access modifiers changed from: private */
    public final Queue<Long> p = new LinkedList();
    private boolean q;
    private boolean r;
    /* access modifiers changed from: private */
    public Double s = null;
    /* access modifiers changed from: private */
    public String t = "banner_ad";
    /* access modifiers changed from: private */
    public NativeExpressView u;

    /* renamed from: com.bytedance.sdk.openadsdk.core.bannerexpress.a$a  reason: collision with other inner class name */
    /* compiled from: PAGBannerAdImpl */
    public interface C0044a {
        void a();
    }

    public a(Context context, n nVar, AdSlot adSlot) {
        this.b = context;
        this.c = nVar;
        this.d = adSlot;
    }

    public void win(Double d2) {
        if (!this.q) {
            s.a(this.c, d2);
            this.q = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.r) {
            s.a(this.c, d2, str, str2);
            this.r = true;
        }
    }

    public void setPrice(Double d2) {
        this.s = d2;
    }

    public Map<String, Object> getMediaExtraInfo() {
        n nVar = this.c;
        if (nVar != null) {
            return nVar.aj();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public BannerExpressView g() {
        if (this.a == null) {
            a(this.b, this.c, this.d);
        }
        return this.a;
    }

    public void setAdInteractionListener(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        this.g = new b(pAGBannerAdInteractionListener);
        g().setExpressInteractionListener(this.g);
    }

    public View getBannerView() {
        return g();
    }

    public void destroy() {
        BannerExpressView bannerExpressView = this.a;
        if (bannerExpressView != null) {
            bannerExpressView.c();
        }
        i();
    }

    public void a(Context context, n nVar, AdSlot adSlot) {
        this.a = new BannerExpressView(context, nVar, adSlot);
        a(this.a.getCurView(), this.c);
    }

    /* access modifiers changed from: protected */
    public void a(final NativeExpressView nativeExpressView, n nVar) {
        if (nativeExpressView != null && nVar != null) {
            this.c = nVar;
            this.l = a(nVar);
            this.u = nativeExpressView;
            final String a2 = o.a();
            final C0044a a3 = a();
            nativeExpressView.setClosedListenerKey(a2);
            nativeExpressView.setBannerClickClosedListener(a3);
            nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.b.c() {
                public boolean a(ViewGroup viewGroup, int i) {
                    try {
                        nativeExpressView.p();
                        if (a.this.c.aw()) {
                            VastBannerBackupView vastBannerBackupView = new VastBannerBackupView(nativeExpressView.getContext());
                            vastBannerBackupView.setClosedListenerKey(a2);
                            vastBannerBackupView.a(a.this.c, nativeExpressView, a.this.l);
                            vastBannerBackupView.setDislikeInner(a.this.k);
                            vastBannerBackupView.setDislikeOuter(a.this.e);
                            nativeExpressView.setVastVideoHelper(vastBannerBackupView);
                            return true;
                        }
                        BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView.getContext());
                        bannerExpressBackupView.setClosedListenerKey(a2);
                        bannerExpressBackupView.a(a.this.c, nativeExpressView, a.this.l);
                        bannerExpressBackupView.setDislikeInner(a.this.k);
                        bannerExpressBackupView.setDislikeOuter(a.this.e);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            com.bytedance.sdk.openadsdk.c.c.a(nVar);
            EmptyView a4 = a((ViewGroup) nativeExpressView);
            if (a4 == null) {
                a4 = new EmptyView(this.b, nativeExpressView);
                nativeExpressView.addView(a4);
            }
            final n nVar2 = nVar;
            final EmptyView emptyView = a4;
            final NativeExpressView nativeExpressView2 = nativeExpressView;
            a4.setCallback(new EmptyView.a() {
                public void a(boolean z) {
                    if (z) {
                        a.this.j();
                        l.a("TTBannerExpressAd", "banner_ad", "Get focus, start timing");
                    } else {
                        a.this.i();
                        l.a("TTBannerExpressAd", "banner_ad", "Lose focus, stop timing");
                    }
                    e.b().execute(new b(z, nVar2, a.this));
                }

                public void a() {
                    if (a.this.h) {
                        a.this.e();
                    }
                    a.this.j();
                }

                public void b() {
                    if (a.this.a != null) {
                        EmptyView emptyView = emptyView;
                        a aVar = a.this;
                        if (emptyView == aVar.a((ViewGroup) aVar.a.getCurView())) {
                            a.this.i();
                        }
                    }
                    a.this.b(nVar2);
                }

                public void a(View view) {
                    h.d().a(a2, a3);
                    l.a("TTBannerExpressAd", "banner_ad", "ExpressView SHOW");
                    if (a.this.p != null) {
                        a.this.p.offer(Long.valueOf(System.currentTimeMillis()));
                    }
                    HashMap hashMap = new HashMap();
                    NativeExpressView nativeExpressView = nativeExpressView2;
                    if (nativeExpressView != null) {
                        hashMap.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
                    }
                    if (view != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("width", view.getWidth());
                            jSONObject.put("height", view.getHeight());
                            jSONObject.put("alpha", (double) view.getAlpha());
                        } catch (Throwable unused) {
                        }
                        hashMap.put("root_view", jSONObject.toString());
                    }
                    com.bytedance.sdk.openadsdk.c.c.a(a.this.b, nVar2, a.this.t, (Map<String, Object>) hashMap, a.this.s);
                    if (a.this.g != null) {
                        a.this.g.onAdShow(view, nVar2.L());
                    }
                    if (nVar2.ai()) {
                        y.a(nVar2, view);
                    }
                    a.this.j();
                    if (!(a.this.f.getAndSet(true) || a.this.a == null || a.this.a.getCurView() == null || a.this.a.getCurView().getWebView() == null)) {
                        z.a(a.this.b, a.this.c, a.this.t, a.this.a.getCurView().getWebView().getWebView());
                    }
                    if (a.this.a != null && a.this.a.getCurView() != null) {
                        a.this.a.getCurView().n();
                        a.this.a.getCurView().l();
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(this.b, nVar, this.t, 2);
            eVar.a((View) nativeExpressView);
            eVar.a((PangleAd) this);
            eVar.a(this.l);
            nativeExpressView.setClickListener(eVar);
            d dVar = new d(this.b, nVar, this.t, 2);
            dVar.a((View) nativeExpressView);
            dVar.a((PangleAd) this);
            dVar.a(this.l);
            nativeExpressView.setClickCreativeListener(dVar);
            a4.setNeedCheckingShow(true);
        }
    }

    private com.com.bytedance.overseas.sdk.a.c a(n nVar) {
        if (nVar.L() == 4) {
            return com.com.bytedance.overseas.sdk.a.d.a(this.b, nVar, this.t);
        }
        return null;
    }

    /* compiled from: PAGBannerAdImpl */
    private static class b implements Runnable {
        boolean a;
        n b;
        WeakReference<a> c;

        b(boolean z, n nVar, a aVar) {
            this.a = z;
            this.b = nVar;
            this.c = new WeakReference<>(aVar);
        }

        public void run() {
            WeakReference<a> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                ((a) this.c.get()).a(this.a, this.b);
            }
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    /* access modifiers changed from: private */
    public void a(boolean z, n nVar) {
        Long poll;
        if (z) {
            try {
                this.p.offer(Long.valueOf(System.currentTimeMillis()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.p.size() > 0 && this.u != null && (poll = this.p.poll()) != null) {
            long longValue = poll.longValue();
            com.bytedance.sdk.openadsdk.c.c.a((System.currentTimeMillis() - longValue) + "", nVar, this.t, this.u.getAdShowTime());
        }
    }

    /* access modifiers changed from: private */
    public EmptyView a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int i2 = 0;
        while (i2 < viewGroup.getChildCount()) {
            try {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
                i2++;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void b(n nVar) {
        Queue<Long> queue = this.p;
        if (queue != null && queue.size() > 0 && nVar != null) {
            try {
                long longValue = this.p.poll().longValue();
                if (longValue > 0 && this.u != null) {
                    com.bytedance.sdk.openadsdk.c.c.a((System.currentTimeMillis() - longValue) + "", nVar, this.t, this.u.getAdShowTime());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public C0044a a() {
        return new C0044a() {
            public void a() {
                View view;
                int width = a.this.u.getWidth();
                int height = a.this.u.getHeight();
                if (((double) height) >= Math.floor((((double) width) * 450.0d) / 600.0d)) {
                    view = LayoutInflater.from(a.this.b).inflate(t.f(a.this.b, "tt_banner_ad_closed_300_250"), (ViewGroup) null, false);
                } else {
                    view = LayoutInflater.from(a.this.b).inflate(t.f(a.this.b, "tt_banner_ad_closed_320_50"), (ViewGroup) null, false);
                }
                a.this.u.r();
                a aVar = a.this;
                EmptyView a2 = aVar.a((ViewGroup) aVar.u);
                a.this.u.removeAllViews();
                a.this.u.addView(view, new ViewGroup.LayoutParams(width, height));
                view.findViewById(t.e(a.this.b, "tt_ad_closed_page_logo")).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TTWebsiteActivity.a(a.this.b, a.this.c, a.this.t);
                    }
                });
                TextView textView = (TextView) view.findViewById(t.e(a.this.b, "tt_ad_closed_text"));
                textView.setText(t.a(a.this.b, "tt_ad_is_closed"));
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TTWebsiteActivity.a(a.this.b, a.this.c, a.this.t);
                    }
                });
                a.this.u.setClickCreativeListener((d) null);
                a.this.u.setClickListener((com.bytedance.sdk.openadsdk.core.nativeexpress.e) null);
                if (m.d().v() == 1) {
                    a.this.i();
                } else if (a.this.i != 0) {
                    a.this.u.addView(a2);
                }
                if (a.this.g != null) {
                    a.this.g.onAdDismissed();
                }
            }
        };
    }

    public void a(Message message) {
        if (message.what == 112202) {
            if (v.a(g(), 50, 1)) {
                this.j += 1000;
            }
            if (this.j >= this.i) {
                h();
                AdSlot adSlot = this.d;
                adSlot.setRotateOrder(adSlot.getRotateOrder() + 1);
                this.j = 0;
                i();
                return;
            }
            j();
        }
    }

    private void h() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.c.a(this.b).a(this.d, 1, (com.bytedance.sdk.openadsdk.common.b) null, new c.a() {
            public void a(List<n> list) {
                if (list == null || list.isEmpty()) {
                    a.this.j();
                    return;
                }
                n nVar = list.get(0);
                BannerExpressView l = a.this.g();
                l.a(nVar, a.this.d);
                a.this.c(nVar);
                l.d();
            }

            public void a() {
                a.this.j();
            }
        }, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
    }

    /* access modifiers changed from: private */
    public void c(n nVar) {
        BannerExpressView g2 = g();
        NativeExpressView nextView = g2.getNextView();
        if (nextView != null && g2.f()) {
            b(nextView, nVar);
            a(nextView, nVar);
        }
    }

    private void b(NativeExpressView nativeExpressView, n nVar) {
        if (nativeExpressView != null && nVar != null) {
            if (this.n != null) {
                this.k.a(nVar.ac(), nVar.ae());
                nativeExpressView.setDislike(this.k);
            }
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.e;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.setMaterialMeta(nVar.ac(), nVar.ae());
                nativeExpressView.setOuterDislike(this.e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        x xVar = this.m;
        if (xVar != null) {
            xVar.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        x xVar = this.m;
        if (xVar != null) {
            xVar.removeCallbacksAndMessages((Object) null);
            this.m.sendEmptyMessageDelayed(112202, 1000);
        }
    }

    private void b(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        n nVar;
        this.o = activity;
        if (this.k == null && (nVar = this.c) != null) {
            this.k = new com.bytedance.sdk.openadsdk.dislike.c(activity, nVar.ac(), this.c.ae());
        }
        com.bytedance.sdk.openadsdk.dislike.c cVar = this.k;
        if (cVar != null) {
            cVar.setDislikeInteractionCallback(dislikeInteractionCallback);
        }
        BannerExpressView bannerExpressView = this.a;
        if (bannerExpressView != null && bannerExpressView.getCurView() != null) {
            this.a.getCurView().setDislike(this.k);
        }
    }

    public int b() {
        n nVar = this.c;
        if (nVar == null) {
            return -1;
        }
        return nVar.ad();
    }

    public List<FilterWord> c() {
        n nVar = this.c;
        if (nVar == null) {
            return null;
        }
        return nVar.ae();
    }

    public void a(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.g = new b(expressAdInteractionListener);
        g().setExpressInteractionListener(this.g);
    }

    public void a(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.g = new b((TTNativeExpressAd.ExpressAdInteractionListener) adInteractionListener);
        g().setExpressInteractionListener(this.g);
    }

    public int d() {
        n nVar = this.c;
        if (nVar == null) {
            return -1;
        }
        return nVar.L();
    }

    public void e() {
        g().b();
    }

    public void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.n = dislikeInteractionCallback;
            b(activity, dislikeInteractionCallback);
        }
    }

    public void a(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        n nVar;
        if (tTDislikeDialogAbstract == null || (nVar = this.c) == null) {
            l.c("TTBannerExpressAd", "banner_ad", "dialog or meta is null, please check");
            return;
        }
        this.e = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(nVar.ac(), this.c.ae());
        BannerExpressView bannerExpressView = this.a;
        if (bannerExpressView != null && bannerExpressView.getCurView() != null) {
            this.a.getCurView().setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    public String f() {
        return this.c.n();
    }

    public void a(int i2) {
        if (i2 > 0) {
            this.t = "slide_banner_ad";
            BannerExpressView g2 = g();
            a(g2.getCurView(), this.c);
            g2.setDuration(1000);
            if (i2 < 30000) {
                i2 = 30000;
            } else if (i2 > 120000) {
                i2 = 120000;
            }
            this.i = i2;
            this.m = new x(Looper.getMainLooper(), this);
            this.d.setIsRotateBanner(1);
            this.d.setRotateTime(this.i);
            this.d.setRotateOrder(1);
        }
    }
}
