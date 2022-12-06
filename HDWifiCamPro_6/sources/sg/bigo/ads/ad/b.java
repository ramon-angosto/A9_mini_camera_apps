package sg.bigo.ads.ad;

import android.graphics.Point;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.ad.a;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.d;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.l;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.controller.f.a;
import sg.bigo.ads.core.a.f;
import sg.bigo.ads.core.a.m;
import sg.bigo.ads.core.a.n;

public abstract class b<T extends Ad> implements Ad, l {
    protected AdInteractionListener a;
    public g b;
    protected View c;
    public sg.bigo.ads.core.e.a.a d;
    public boolean e = false;
    boolean f = false;
    public boolean g = false;
    public sg.bigo.ads.controller.f.a h;
    public int i = -1;
    private long j;
    private boolean k = false;
    private boolean l = false;
    private long m;
    private long n;
    private AdBid o;
    private final Map<String, Object> p = new HashMap();
    private boolean q = false;

    public interface a<T extends Ad> {
        void a(T t);

        void a(T t, int i, String str);
    }

    /* renamed from: sg.bigo.ads.ad.b$b  reason: collision with other inner class name */
    public interface C0113b {
        void a();

        void a(d dVar);
    }

    public b(g gVar) {
        this.b = gVar;
        p();
    }

    private m a(String str, int i2, int i3) {
        c cVar = this.b.a;
        m mVar = new m(str, i2, i3);
        mVar.e = System.currentTimeMillis();
        mVar.j = cVar.n();
        mVar.k = cVar.g();
        mVar.l = cVar.k();
        return mVar;
    }

    private void a(String str) {
        char c2;
        g gVar = this.b;
        Map<String, Object> a2 = sg.bigo.ads.core.b.a.a(str, gVar, Integer.valueOf(gVar.a.O()), (String) null, (String) null);
        int hashCode = str.hashCode();
        if (hashCode != 120623625) {
            if (hashCode == 860524583 && str.equals("clicked")) {
                c2 = 0;
                if (c2 == 0 || c2 == 1) {
                    a2.put("ad_size", e());
                    a2.put("show_proportion", b("show_proportion", ""));
                    a2.put("render_style", b("render_style", 0));
                }
                sg.bigo.ads.core.b.b.a().a(str, a2);
            }
        } else if (str.equals("impression")) {
            c2 = 1;
            a2.put("ad_size", e());
            a2.put("show_proportion", b("show_proportion", ""));
            a2.put("render_style", b("render_style", 0));
            sg.bigo.ads.core.b.b.a().a(str, a2);
        }
        c2 = 65535;
        a2.put("ad_size", e());
        a2.put("show_proportion", b("show_proportion", ""));
        a2.put("render_style", b("render_style", 0));
        sg.bigo.ads.core.b.b.a().a(str, a2);
    }

    private void a(String str, int i2) {
        c cVar = this.b.a;
        String f2 = cVar.B().f();
        if (!TextUtils.isEmpty(f2)) {
            boolean z = true;
            if (!this.q) {
                this.q = true;
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    m a2 = a(f2, 1, 2);
                    a2.d = 2;
                    a2.f = i2 == 1 ? 1 : 0;
                    arrayList.add(a2);
                }
                if (i2 != 1 && cVar.a(2)) {
                    m a3 = a(f2, 1, 3);
                    a3.d = 3;
                    a3.f = i2 == 4 ? 1 : 0;
                    arrayList.add(a3);
                }
                if (!arrayList.isEmpty()) {
                    n.a().a((List<m>) arrayList);
                }
            }
            if ((i2 != 1 || sg.bigo.ads.core.landing.a.a(str)) && i2 != 4) {
                z = false;
            }
            long F = cVar.F();
            if (!z && F > 0) {
                f.a.a.a(a(f2, 0, 4), F);
            }
        }
    }

    private void c(Point point, int i2, int i3, e eVar) {
        if (!this.l && !this.g) {
            this.l = true;
            b(point, i2, i3, eVar);
        }
        AdInteractionListener adInteractionListener = this.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        a(eVar.d, eVar.a);
    }

    private void p() {
        c cVar = this.b.a;
        o g2 = sg.bigo.ads.api.a.e.a.g();
        c.e[] r = cVar.r();
        sg.bigo.ads.core.e.a.d[] dVarArr = new sg.bigo.ads.core.e.a.d[0];
        if (r != null && r.length > 0) {
            dVarArr = new sg.bigo.ads.core.e.a.d[r.length];
            for (int i2 = 0; i2 < r.length; i2++) {
                dVarArr[i2] = new sg.bigo.ads.core.e.a.d(r[i2].a(), this.b.e);
            }
        }
        c.e[] s = cVar.s();
        sg.bigo.ads.core.e.a.d[] dVarArr2 = new sg.bigo.ads.core.e.a.d[0];
        if (s != null && s.length > 0) {
            dVarArr2 = new sg.bigo.ads.core.e.a.d[s.length];
            for (int i3 = 0; i3 < s.length; i3++) {
                dVarArr2[i3] = new sg.bigo.ads.core.e.a.d(s[i3].a(), this.b.e);
            }
        }
        c.e[] t = cVar.t();
        sg.bigo.ads.core.e.a.d[] dVarArr3 = new sg.bigo.ads.core.e.a.d[0];
        if (t != null && t.length > 0) {
            dVarArr3 = new sg.bigo.ads.core.e.a.d[t.length];
            for (int i4 = 0; i4 < t.length; i4++) {
                dVarArr3[i4] = new sg.bigo.ads.core.e.a.d(t[i4].a(), this.b.e);
            }
        }
        c.e[] u = cVar.u();
        sg.bigo.ads.core.e.a.d[] dVarArr4 = new sg.bigo.ads.core.e.a.d[0];
        if (u != null && u.length > 0) {
            dVarArr4 = new sg.bigo.ads.core.e.a.d[u.length];
            for (int i5 = 0; i5 < u.length; i5++) {
                dVarArr4[i5] = new sg.bigo.ads.core.e.a.d(u[i5].a(), this.b.e);
            }
        }
        this.d = new sg.bigo.ads.core.e.a.a(g2, dVarArr, dVarArr2, dVarArr3, dVarArr4, sg.bigo.ads.core.d.a.b(this.b.a));
        this.d.a("express_id", cVar.G());
    }

    private int q() {
        c.a C = this.b.a.C();
        if (C != null) {
            return C.a();
        }
        return 0;
    }

    private long r() {
        c.a C = this.b.a.C();
        if (C != null) {
            return (long) C.b();
        }
        return 0;
    }

    public final void a() {
        if (!this.b.a.M()) {
            a("filled");
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.j;
            long currentTimeMillis = System.currentTimeMillis() - this.b.d.d();
            c cVar = this.b.a;
            boolean booleanValue = ((Boolean) b("is_cache", Boolean.FALSE)).booleanValue();
            Map<String, String> b2 = sg.bigo.ads.core.d.a.b(cVar);
            String str = "1";
            b2.put("rslt", str);
            b2.put("cost", String.valueOf(elapsedRealtime));
            b2.put("cost_total", String.valueOf(currentTimeMillis));
            b2.put("is_cache", booleanValue ? str : MBridgeConstans.ENDCARD_URL_TYPE_PL);
            if (cVar instanceof sg.bigo.ads.api.core.n) {
                sg.bigo.ads.api.core.n nVar = (sg.bigo.ads.api.core.n) cVar;
                if (nVar.ad()) {
                    str = "2";
                }
                b2.put("material_type", str);
                b2.put("media_type", nVar.ak());
            }
            sg.bigo.ads.core.d.a.a("06002008", b2);
            if (this.b.a.B().j() == 1) {
                m();
            }
            if (this.b.a.B().c() == 2) {
                sg.bigo.ads.a.c.a(sg.bigo.ads.common.b.a.a);
            }
        }
    }

    public final void a(int i2, String str) {
        if (!this.b.a.M()) {
            sg.bigo.ads.core.d.a.a(this.b.a, SystemClock.elapsedRealtime() - this.j, i2, str);
        }
    }

    public final void a(Point point, int i2, int i3, e eVar) {
        if (!isExpired() && !this.g) {
            if (q() != 2 || (this.e && SystemClock.elapsedRealtime() - this.m >= r())) {
                c(point, i2, i3, eVar);
            }
        }
    }

    public final void a(Point point, e eVar) {
        a(point, 0, 1, eVar);
    }

    public final synchronized void a(String str, Object obj) {
        this.p.put(str, obj);
    }

    public void a(a<T> aVar) {
        this.j = SystemClock.elapsedRealtime();
    }

    public <ValueType> ValueType b(String str, ValueType valuetype) {
        ValueType valuetype2 = this.p.get(str);
        return valuetype2 != null ? valuetype2 : valuetype;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.e = false;
        this.l = false;
    }

    public final void b(int i2, String str) {
        sg.bigo.ads.common.k.a.a(2, 5, "", "onAdError: (" + i2 + ") " + str);
        AdInteractionListener adInteractionListener = this.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdError(new AdError(i2, str));
        }
    }

    /* access modifiers changed from: protected */
    public void b(Point point, int i2, int i3, e eVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        float f2;
        String str;
        sg.bigo.ads.api.core.m ah;
        Point point2 = point;
        int i8 = i3;
        e eVar2 = eVar;
        long j3 = 0;
        if (this.m > 0) {
            j3 = SystemClock.elapsedRealtime() - this.m;
        }
        h();
        this.d.a("action_type", String.valueOf(eVar2.a));
        sg.bigo.ads.core.e.a.a aVar = this.d;
        if (point2 != null) {
            i5 = point2.x;
            i4 = point2.y;
        } else {
            i5 = 0;
            i4 = 0;
        }
        View view = this.c;
        if (view != null) {
            i7 = view.getWidth();
            i6 = this.c.getHeight();
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (i7 > 0) {
            j2 = j3;
            f2 = new BigDecimal((double) (((float) i5) / ((float) i7))).setScale(3, 4).floatValue();
        } else {
            j2 = j3;
            f2 = 0.0f;
        }
        aVar.a("click_prop", sg.bigo.ads.common.utils.o.g(sg.bigo.ads.common.utils.o.a("{'x':%d,'y':%d,'ad_w':%d,'ad_h':%d,'x_r':%s,'y_r':%s,'mode':'%s'}", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i7), Integer.valueOf(i6), Float.valueOf(f2), Float.valueOf(i6 > 0 ? new BigDecimal((double) (((float) i4) / ((float) i6))).setScale(3, 4).floatValue() : 0.0f), (i8 == 1 || i8 == 2) ? "direct" : i8 == 3 ? "confirm" : "unknown")));
        this.d.a("scene", String.valueOf(i3));
        int i9 = eVar2.a;
        sg.bigo.ads.common.f.c.a(1, new Runnable(i9 != 1 ? i9 != 4 ? false : this.b.a.a(8) : this.b.a.a(4)) {
            final /* synthetic */ boolean a;

            {
                this.a = r2;
            }

            public final void run() {
                a.this.b(this.a);
            }
        });
        if (point2 != null) {
            str = point2.x + "," + point2.y;
        } else {
            str = "";
        }
        c cVar = this.b.a;
        String e2 = e();
        int i10 = eVar2.a;
        Map<String, String> b2 = sg.bigo.ads.core.d.a.b(cVar);
        b2.put("ad_size", e2);
        b2.put("click_area", str);
        b2.put("click_module", String.valueOf(i2));
        b2.put("click_source", String.valueOf(i3));
        b2.put("open_way", String.valueOf(cVar.B().c()));
        b2.put("url_t", String.valueOf(i10));
        b2.put("cost", String.valueOf(j2));
        if ((cVar instanceof sg.bigo.ads.api.core.n) && (ah = ((sg.bigo.ads.api.core.n) cVar).ah()) != null) {
            b2.put("creative_size", sg.bigo.ads.common.utils.o.a("%1$d*%2$d", Integer.valueOf(ah.a), Integer.valueOf(ah.b)));
        }
        sg.bigo.ads.core.d.a.a("06002011", b2);
        sg.bigo.ads.core.d.a.a(this.b.a, 1, eVar2);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (!isExpired() && !this.g && !this.e) {
            this.e = true;
            this.m = SystemClock.elapsedRealtime();
            d();
            AdInteractionListener adInteractionListener = this.a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        sg.bigo.ads.api.core.m ah;
        g();
        sg.bigo.ads.common.f.c.a(1, new Runnable() {
            final /* synthetic */ boolean a = false;

            public final void run() {
                a.this.a(this.a);
            }
        });
        c cVar = this.b.a;
        String str = (String) b("show_proportion", "");
        String e2 = e();
        int intValue = ((Integer) b("render_style", 0)).intValue();
        long j2 = 0;
        if (this.n != 0) {
            j2 = SystemClock.elapsedRealtime() - this.n;
        }
        long longValue = ((Long) b("attach_render_cost", -1L)).longValue();
        Map<String, String> b2 = sg.bigo.ads.core.d.a.b(cVar);
        b2.put("show_proportion", str);
        b2.put("ad_size", e2);
        b2.put("render_style", String.valueOf(intValue));
        b2.put("render_cost", String.valueOf(j2));
        b2.put("attach_render_cost", String.valueOf(longValue));
        if ((cVar instanceof sg.bigo.ads.api.core.n) && (ah = ((sg.bigo.ads.api.core.n) cVar).ah()) != null) {
            b2.put("creative_size", sg.bigo.ads.common.utils.o.a("%1$d*%2$d", Integer.valueOf(ah.a), Integer.valueOf(ah.b)));
        }
        sg.bigo.ads.core.d.a.a("06002010", b2);
        if (this.b.a.B().j() == 0) {
            m();
        }
    }

    public void destroy() {
        this.g = true;
        sg.bigo.ads.controller.f.a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
        setAdInteractionListener((AdInteractionListener) null);
        sg.bigo.ads.common.k.a.a(0, 3, "Ad", "Ad was destroyed.");
    }

    public final String e() {
        if (this.c == null) {
            return "";
        }
        return this.c.getWidth() + "x" + this.c.getHeight();
    }

    /* access modifiers changed from: protected */
    public void f() {
        AdInteractionListener adInteractionListener = this.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
        this.f = true;
    }

    /* access modifiers changed from: protected */
    public void g() {
        a("impression");
    }

    public AdBid getBid() {
        if (this.o == null) {
            g gVar = this.b;
            c cVar = gVar.a;
            this.o = cVar.P() ? new a.C0111a(gVar, cVar, this.d) : null;
        }
        return this.o;
    }

    /* access modifiers changed from: protected */
    public void h() {
        a("clicked");
    }

    /* access modifiers changed from: protected */
    public final int i() {
        return this.b.b.b();
    }

    public boolean isExpired() {
        return this.b.a.y();
    }

    /* access modifiers changed from: protected */
    public final int j() {
        return this.b.a.l();
    }

    public final void k() {
        this.i++;
    }

    public final void l() {
        this.i = -1;
    }

    public void m() {
        if (this.b.a.B().e() > 0) {
            this.h = new sg.bigo.ads.controller.f.a(this.b.a);
            sg.bigo.ads.controller.f.a aVar = this.h;
            String a2 = aVar.b.a();
            String i2 = aVar.b.i();
            int c2 = aVar.b.c();
            if (((aVar.c != 4 && aVar.c != 5) || !TextUtils.isEmpty(i2)) && !sg.bigo.ads.core.landing.a.a(a2) && !TextUtils.isEmpty(a2) && a2.startsWith("http")) {
                if (c2 == 0 || c2 == 2) {
                    sg.bigo.ads.common.f.c.a(2, new Runnable(a2, c2, new a.C0130a() {
                        public final void a(String str) {
                            sg.bigo.ads.common.k.a.a(0, 3, "Preload", "preloadWebView onStart preloadType = " + a.this.c + ", url = " + str);
                        }

                        public final void a(String str, long j, boolean z, int i) {
                            a.this.d = z;
                            HashMap hashMap = new HashMap();
                            hashMap.put("land_way", String.valueOf(i));
                            sg.bigo.ads.core.d.a.a(a.this.a, "preload_cost", j, z ? 1 : 0, (Map<String, String>) hashMap);
                            sg.bigo.ads.common.k.a.a(0, 3, "Preload", "preload landing page onComplete preloadType=" + a.this.c + ", success = " + z + ", cost = " + j + ", url = " + str);
                            if (!z) {
                                a.this.a();
                            }
                        }
                    }, i2) {
                        final /* synthetic */ String a;
                        final /* synthetic */ int b;
                        final /* synthetic */ C0130a c;
                        final /* synthetic */ String d;

                        {
                            this.a = r2;
                            this.b = r3;
                            this.c = r4;
                            this.d = r5;
                        }

                        public final void run() {
                            int i = a.this.c;
                            if (i == 1) {
                                Uri parse = Uri.parse(this.a);
                                a.a(a.this, parse.getScheme() + "://" + parse.getHost(), this.b, this.c);
                            } else if (i != 2 && i != 3) {
                                if (i == 4 || i == 5) {
                                    a.a(a.this, this.d, this.b, this.c);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public c n() {
        return this.b.a;
    }

    /* access modifiers changed from: protected */
    public final void o() {
        if (!this.k) {
            this.k = true;
            this.n = SystemClock.elapsedRealtime();
        }
    }

    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }
}
