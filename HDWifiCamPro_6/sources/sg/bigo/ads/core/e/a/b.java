package sg.bigo.ads.core.e.a;

import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.core.e.a;
import sg.bigo.ads.core.h.d;
import sg.bigo.ads.core.h.e;

public abstract class b {
    public CopyOnWriteArrayList<d> a;
    public CopyOnWriteArrayList<d> b;
    public CopyOnWriteArrayList<d> c;
    public CopyOnWriteArrayList<d> d;
    protected o e;
    protected e f;
    final Map<String, String> g;
    public long h = 0;
    public long i = 0;
    public long j = 0;
    public long k = 0;
    public CopyOnWriteArrayList<d> l;
    public CopyOnWriteArrayList<d> m;
    public CopyOnWriteArrayList<d> n;
    public CopyOnWriteArrayList<d> o;

    public b(o oVar) {
        this.e = oVar;
        this.a = new CopyOnWriteArrayList<>();
        this.b = new CopyOnWriteArrayList<>();
        this.c = new CopyOnWriteArrayList<>();
        this.d = new CopyOnWriteArrayList<>();
        this.g = new HashMap();
        this.f = new e(this.e, this.g);
    }

    private void a(final String str, final d dVar, final boolean z) {
        String str2 = dVar.b;
        String d2 = dVar.d();
        dVar.a();
        a.a(str, d2, str2, this.g, new a.C0138a() {
            public final void a() {
                c.a().b(b.this.f);
            }

            public final boolean a(int i) {
                return b.this.e.a(i);
            }

            public final void b() {
                CopyOnWriteArrayList<d> copyOnWriteArrayList;
                if ("impl_track".equals(str)) {
                    if (z && b.this.l != null) {
                        copyOnWriteArrayList = b.this.l;
                    }
                    c.a().b(b.this.f);
                } else if ("click_track".equals(str)) {
                    if (z && b.this.m != null) {
                        copyOnWriteArrayList = b.this.m;
                    }
                    c.a().b(b.this.f);
                } else if ("nurl_track".equals(str)) {
                    if (z && b.this.n != null) {
                        copyOnWriteArrayList = b.this.n;
                    }
                    c.a().b(b.this.f);
                } else {
                    if ("lurl_track".equals(str) && z && b.this.o != null) {
                        copyOnWriteArrayList = b.this.o;
                    }
                    c.a().b(b.this.f);
                }
                copyOnWriteArrayList.remove(dVar);
                c.a().b(b.this.f);
            }
        });
    }

    static /* synthetic */ void a(b bVar, final String str, d dVar) {
        String d2 = dVar.d();
        final String str2 = dVar.b;
        if (!TextUtils.isEmpty(d2)) {
            if ("sizmek".equals(str2)) {
                d2 = d2.replaceAll("\\?", "%3f");
            }
            bVar.a(str, "start", d2, str2);
            final e a2 = e.a(sg.bigo.ads.common.b.a.a);
            if (a2 != null) {
                a2.setWebViewClient(new d() {
                    public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                        a2.destroy();
                    }

                    public final void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.a(str, "success", str, str2);
                    }

                    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        return false;
                    }
                });
                try {
                    boolean z = false;
                    if (dVar.a == 1) {
                        a2.loadUrl(d2);
                        return;
                    }
                    if (dVar.a == 2) {
                        z = true;
                    }
                    if (z) {
                        a2.loadData(d2, "text/html", "UTF-8");
                    }
                } catch (Exception e2) {
                    sg.bigo.ads.core.d.a.a((c) null, (int) IronSourceConstants.BN_INSTANCE_LOAD, 10106, e2.getMessage());
                }
            }
        }
    }

    public final void a(String str, String str2) {
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.c()) {
                next.a(str, str2);
            }
        }
        Iterator<d> it2 = this.b.iterator();
        while (it2.hasNext()) {
            d next2 = it2.next();
            if (next2.c()) {
                next2.a(str, str2);
            }
        }
        Iterator<d> it3 = this.c.iterator();
        while (it3.hasNext()) {
            d next3 = it3.next();
            if (next3.c()) {
                next3.a(str, str2);
            }
        }
        Iterator<d> it4 = this.d.iterator();
        while (it4.hasNext()) {
            d next4 = it4.next();
            if (next4.c()) {
                next4.a(str, str2);
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        g a2 = g.a(this.g, this.e, str, str2, str3);
        a2.a(a2.a);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap(this.g);
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        hashMap.put("action", str);
        hashMap.put("track_url", str3);
        hashMap.put("track_name", str4);
        hashMap.put("states", str2);
        hashMap.put("retry", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        if ("impl_track".equals(str)) {
            sg.bigo.ads.core.d.a.a((Map<String, String>) hashMap);
        } else if ("click_track".equals(str)) {
            sg.bigo.ads.core.d.a.b((Map<String, String>) hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        if (!sg.bigo.ads.common.n.a.c()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = this.e.a;
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
            if (z2) {
                this.h = currentTimeMillis;
                this.l = new CopyOnWriteArrayList<>();
                Iterator<d> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    d next = it2.next();
                    if ((!z || next.a()) && next.c()) {
                        this.l.add(next);
                    }
                }
                if (this.l.size() > 0) {
                    e eVar = this.f;
                    eVar.r = this.l;
                    eVar.j = currentTimeMillis;
                    eVar.i = 0;
                    c.a().a(this.f);
                }
            } else {
                sg.bigo.ads.common.k.a.a(0, 3, "AdTracker", "trackThirdImpression not need retry");
            }
            Iterator<d> it3 = this.a.iterator();
            while (it3.hasNext()) {
                final d next2 = it3.next();
                if (!z || next2.a()) {
                    if (next2.c()) {
                        a("impl_track", next2, z2);
                    } else {
                        sg.bigo.ads.common.f.c.a(2, new Runnable() {
                            public final void run() {
                                b.a(b.this, "impl_track", next2);
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z) {
        if (!sg.bigo.ads.common.n.a.c()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = this.e.a;
            Iterator<d> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
            if (z2) {
                this.i = currentTimeMillis;
                this.m = new CopyOnWriteArrayList<>();
                Iterator<d> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    d next = it2.next();
                    if ((!z || next.a()) && next.c()) {
                        this.m.add(next);
                    }
                }
                if (this.m.size() > 0) {
                    e eVar = this.f;
                    eVar.s = this.m;
                    eVar.l = currentTimeMillis;
                    eVar.k = 0;
                    c.a().a(this.f);
                }
            } else {
                sg.bigo.ads.common.k.a.a(0, 3, "AdTracker", "trackThirdClick not need retry");
            }
            Iterator<d> it3 = this.b.iterator();
            while (it3.hasNext()) {
                final d next2 = it3.next();
                if (!z || next2.a()) {
                    if (next2.c()) {
                        a("click_track", next2, z2);
                    } else {
                        sg.bigo.ads.common.f.c.a(2, new Runnable() {
                            public final void run() {
                                b.a(b.this, "click_track", next2);
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c(boolean z) {
        if (!sg.bigo.ads.common.n.a.c()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = this.e.a;
            Iterator<d> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
            if (z2) {
                this.j = currentTimeMillis;
                this.n = new CopyOnWriteArrayList<>();
                Iterator<d> it2 = this.c.iterator();
                while (it2.hasNext()) {
                    d next = it2.next();
                    if ((!z || next.a()) && next.c()) {
                        this.n.add(next);
                    }
                }
                if (this.n.size() > 0) {
                    e eVar = this.f;
                    eVar.t = this.n;
                    eVar.n = currentTimeMillis;
                    eVar.m = 0;
                    c.a().a(this.f);
                }
            } else {
                sg.bigo.ads.common.k.a.a(0, 3, "AdTracker", "trackThirdNUrl not need retry");
            }
            Iterator<d> it3 = this.c.iterator();
            while (it3.hasNext()) {
                final d next2 = it3.next();
                if (!z || next2.a()) {
                    if (next2.c()) {
                        a("nurl_track", next2, z2);
                    } else {
                        sg.bigo.ads.common.f.c.a(2, new Runnable() {
                            public final void run() {
                                b.a(b.this, "nurl_track", next2);
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void d(boolean z) {
        if (!sg.bigo.ads.common.n.a.c()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = this.e.a;
            Iterator<d> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
            if (z2) {
                this.k = currentTimeMillis;
                this.o = new CopyOnWriteArrayList<>();
                Iterator<d> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    d next = it2.next();
                    if ((!z || next.a()) && next.c()) {
                        this.o.add(next);
                    }
                }
                if (this.o.size() > 0) {
                    e eVar = this.f;
                    eVar.u = this.o;
                    eVar.p = currentTimeMillis;
                    eVar.o = 0;
                    c.a().a(this.f);
                }
            } else {
                sg.bigo.ads.common.k.a.a(0, 3, "AdTracker", "trackThirdLUrl not need retry");
            }
            Iterator<d> it3 = this.d.iterator();
            while (it3.hasNext()) {
                final d next2 = it3.next();
                if (!z || next2.a()) {
                    if (next2.c()) {
                        a("lurl_track", next2, z2);
                    } else {
                        sg.bigo.ads.common.f.c.a(2, new Runnable() {
                            public final void run() {
                                b.a(b.this, "lurl_track", next2);
                            }
                        });
                    }
                }
            }
        }
    }
}
