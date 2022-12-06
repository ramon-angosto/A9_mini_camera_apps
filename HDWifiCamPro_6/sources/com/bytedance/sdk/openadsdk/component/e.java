package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.c.a;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.component.c;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.l.w;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTAppOpenAdLoadManager */
public class e implements x.a {
    private final Context a;
    private final n<a> b;
    /* access modifiers changed from: private */
    public final c c;
    private final AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public int e = 0;
    private AdSlot f;
    private TTAdNative.AppOpenAdListener g;
    private PAGAppOpenAdLoadListener h;
    private int i;
    /* access modifiers changed from: private */
    public volatile int j = 0;
    private r k;

    public e(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = m.a();
        }
        this.b = m.c();
        this.c = c.a(this.a);
    }

    public static e a(Context context) {
        return new e(context);
    }

    public void a(AdSlot adSlot, b bVar, int i2) {
        if (bVar != null) {
            if (i2 <= 0) {
                l.b("TTAppOpenAdLoadManager", "Since the timeout value passed by loadAppOpenAd is <=0, now it is set to the default value of 3500ms");
                i2 = IronSourceConstants.BN_AUCTION_REQUEST;
            }
            this.f = adSlot;
            if (bVar instanceof TTAdNative.AppOpenAdListener) {
                this.g = (TTAdNative.AppOpenAdListener) bVar;
                this.h = null;
                com.bytedance.sdk.openadsdk.tool.b.a(0, "open");
            } else if (bVar instanceof PAGAppOpenAdLoadListener) {
                this.h = (PAGAppOpenAdLoadListener) bVar;
                this.g = null;
                com.bytedance.sdk.openadsdk.tool.b.a(1, "open");
            }
            this.e = a(this.f);
            this.i = i2;
            new x(k.c().getLooper(), this).sendEmptyMessageDelayed(1, (long) i2);
            b(this.f);
            a();
        }
    }

    private void b(final AdSlot adSlot) {
        this.k = new r();
        this.k.a(com.bytedance.sdk.openadsdk.l.x.a());
        this.j = 1;
        o oVar = new o();
        oVar.i = this.k;
        oVar.d = 1;
        oVar.f = 2;
        this.b.a(adSlot, oVar, 3, new n.a() {
            public void a(int i, String str) {
                int unused = e.this.j = 3;
                l.b("TTAppOpenAdLoadManager", "try load app open ad from network fail, " + i + ", " + str);
                e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, i, str));
            }

            public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                int unused = e.this.j = 2;
                l.b("TTAppOpenAdLoadManager", "try load app open ad from network success");
                if (aVar == null || aVar.b() == null || aVar.b().size() == 0) {
                    int unused2 = e.this.j = 3;
                    e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, 20001, g.a(20001)));
                    bVar.a(-3);
                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.n nVar = aVar.b().get(0);
                if (com.bytedance.sdk.openadsdk.core.model.n.c(nVar)) {
                    e.this.a(nVar, adSlot);
                    return;
                }
                if (m.d().k() == 1) {
                    e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 100, nVar));
                }
                e.this.a(nVar);
            }
        });
    }

    private void a() {
        w.c(new com.bytedance.sdk.component.g.g("tryGetAppOpenAdFromCache") {
            public void run() {
                com.bytedance.sdk.openadsdk.core.model.n e = e.this.c.e(e.this.e);
                if (e != null) {
                    boolean c = com.bytedance.sdk.openadsdk.core.model.n.c(e);
                    boolean z = false;
                    if (!c && m.d().k() == 1) {
                        e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 101, e));
                        z = true;
                    }
                    if (e.this.c.b(e.this.e) || e.this.c.d(e.this.e)) {
                        e.this.c.g(e.this.e);
                        l.b("TTAppOpenAdLoadManager", "Cached material resolution success, video = " + c);
                        if (c) {
                            if (!TextUtils.isEmpty(e.this.c.a(e)) || Build.VERSION.SDK_INT < 23) {
                                e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 101, e));
                                return;
                            }
                            l.b("TTAppOpenAdLoadManager", "Video cache path not found");
                            com.bytedance.sdk.openadsdk.component.d.a.b(e);
                        } else if (!e.this.c.b(e)) {
                            l.b("TTAppOpenAdLoadManager", "Image cache path not found");
                            com.bytedance.sdk.openadsdk.component.d.a.b(e);
                        } else if (!z) {
                            e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(1, 101, e));
                        }
                    } else {
                        e.this.c.g(e.this.e);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.model.n nVar, AdSlot adSlot) {
        this.c.a(nVar, adSlot, this.k, (c.C0040c) new c.C0040c() {
            public void a() {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: video load success");
                int unused = e.this.j = 4;
                com.bytedance.sdk.openadsdk.component.e.b bVar = new com.bytedance.sdk.openadsdk.component.e.b(1, 100, nVar);
                bVar.a(true);
                e.this.a(bVar);
            }

            public void a(int i, String str) {
                l.b("TTAppOpenAdLoadManager", "preLoadFail() called with: code = [" + i + "], message = [" + str + "]");
                int unused = e.this.j = 5;
                e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, 10003, g.a(10003)));
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.model.n nVar) {
        this.c.a(nVar, this.k, (c.b) new c.b() {
            public void a(com.bytedance.sdk.openadsdk.i.a.b bVar) {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: image load success");
                int unused = e.this.j = 4;
                com.bytedance.sdk.openadsdk.component.e.b bVar2 = new com.bytedance.sdk.openadsdk.component.e.b(1, 100, nVar);
                bVar2.a(true);
                e.this.a(bVar2);
            }

            public void a() {
                Log.d("TTAppOpenAdLoadManager", "preLoadFail: image load fail");
                int unused = e.this.j = 5;
                e.this.a(new com.bytedance.sdk.openadsdk.component.e.b(2, 100, 10003, g.a(10003)));
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.component.e.b bVar) {
        int b2 = bVar.b();
        int c2 = bVar.c();
        if (this.d.get()) {
            if (b2 == 1 && c2 == 100 && bVar.a()) {
                c.a(m.a()).a(new com.bytedance.sdk.openadsdk.component.e.a(this.e, bVar.d()));
                com.bytedance.sdk.openadsdk.component.d.a.a(bVar.d(), 1, this.k);
            }
        } else if (b2 == 1) {
            if (this.g != null) {
                this.g.onAppOpenAdLoaded(new d(this.a, bVar.d(), c2 == 101));
            } else if (this.h != null) {
                this.h.onAdLoaded(new a(this.a, bVar.d(), c2 == 101));
            }
            this.d.set(true);
            if (c2 == 101) {
                com.bytedance.sdk.openadsdk.component.d.a.a(bVar.d(), this.k.a().c());
            } else if (c2 == 100) {
                com.bytedance.sdk.openadsdk.component.d.a.a(bVar.d(), 0, this.k);
                this.c.a(this.f);
            }
        } else if (b2 == 2 || b2 == 3) {
            TTAdNative.AppOpenAdListener appOpenAdListener = this.g;
            if (appOpenAdListener != null) {
                appOpenAdListener.onError(bVar.e(), bVar.f());
            } else {
                PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = this.h;
                if (pAGAppOpenAdLoadListener != null) {
                    pAGAppOpenAdLoadListener.onError(bVar.e(), bVar.f());
                }
            }
            this.d.set(true);
            if (b2 == 3) {
                com.bytedance.sdk.openadsdk.component.d.a.a(this.j, this.i);
            }
        }
    }

    public int a(AdSlot adSlot) {
        try {
            return Integer.parseInt(adSlot.getCodeId());
        } catch (Throwable unused) {
            a(new com.bytedance.sdk.openadsdk.component.e.b(2, 102, 40006, g.a(40006)));
            return 0;
        }
    }

    public void a(Message message) {
        if (message.what == 1 && !this.d.get()) {
            a(new com.bytedance.sdk.openadsdk.component.e.b(3, 102, 10002, g.a(10002)));
        }
    }
}
