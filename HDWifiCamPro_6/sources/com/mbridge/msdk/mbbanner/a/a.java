package com.mbridge.msdk.mbbanner.a;

import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbanner.common.a.b;
import com.mbridge.msdk.mbbanner.common.c.c;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;

/* compiled from: BannerController */
public final class a {
    private static String a = "BannerController";
    /* access modifiers changed from: private */
    public String b;
    /* access modifiers changed from: private */
    public String c;
    /* access modifiers changed from: private */
    public MBridgeIds d;
    private boolean e;
    private int f;
    /* access modifiers changed from: private */
    public MBBannerView g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public int j;
    private int k = -1;
    /* access modifiers changed from: private */
    public BannerAdListener l;
    /* access modifiers changed from: private */
    public CampaignUnit m;
    private c n;
    private d o;
    private com.mbridge.msdk.b.c p;
    private boolean q;
    private boolean r;
    private boolean s;
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public boolean u;
    private com.mbridge.msdk.mbbanner.common.b.c v = new com.mbridge.msdk.mbbanner.common.b.c() {
        public final void a(List<CampaignEx> list) {
            if (a.this.l != null) {
                a.this.l.onLoadSuccessed(a.this.d);
            }
        }

        public final void a(CampaignEx campaignEx) {
            a.this.c();
            if (a.this.l != null) {
                a.this.l.onLogImpression(a.this.d);
            }
        }

        public final void a(String str) {
            a.this.b(str);
        }

        public final void a() {
            if (a.this.l != null) {
                a.this.l.onClick(a.this.d);
            }
        }

        public final void b() {
            if (a.this.l != null) {
                a.this.l.onLeaveApp(a.this.d);
            }
        }

        public final void c() {
            if (a.this.l != null) {
                a.this.l.showFullScreen(a.this.d);
                boolean unused = a.this.u = true;
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, a.this.c, a.this.b, (b) null, (com.mbridge.msdk.mbbanner.common.b.b) null);
            }
        }

        public final void d() {
            if (a.this.l != null) {
                a.this.l.closeFullScreen(a.this.d);
                boolean unused = a.this.u = false;
                com.mbridge.msdk.mbbanner.common.c.a a2 = com.mbridge.msdk.mbbanner.common.c.a.a();
                String c = a.this.c;
                String d = a.this.b;
                a2.a(3, c, d, new b(a.this.i + "x" + a.this.h, a.this.j * 1000), a.this.w);
            }
        }

        public final void e() {
            if (a.this.l != null) {
                a.this.l.onCloseBanner(a.this.d);
            }
        }
    };
    /* access modifiers changed from: private */
    public com.mbridge.msdk.mbbanner.common.b.b w = new com.mbridge.msdk.mbbanner.common.b.b() {
        public final void a(String str, CampaignUnit campaignUnit, boolean z) {
            CampaignUnit unused = a.this.m = campaignUnit;
        }

        public final void a(String str, String str2, boolean z) {
            if (a.this.l != null) {
                a.this.l.onLoadFailed(a.this.d, str2);
            }
            a.this.c();
            com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g(), str2, a.this.b, z);
        }

        public final void a(String str, boolean z) {
            if (a.this.m != null) {
                com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g(), (List<CampaignEx>) a.this.m.getAds(), a.this.b, z);
            }
            if (a.this.g != null) {
                boolean unused = a.this.t = true;
                a.this.g();
            }
        }

        public final void b(String str, boolean z) {
            if (a.this.l != null) {
                a.this.l.onLoadFailed(a.this.d, "banner res load failed");
            }
            a.this.c();
            com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g(), "banner res load failed", a.this.b, z);
        }
    };

    private int b(int i2) {
        if (i2 <= 0) {
            return i2;
        }
        if (i2 < 10) {
            return 10;
        }
        if (i2 > 180) {
            return 180;
        }
        return i2;
    }

    public final String a() {
        CampaignUnit campaignUnit = this.m;
        return (campaignUnit == null || campaignUnit.getRequestId() == null) ? "" : this.m.getRequestId();
    }

    public a(MBBannerView mBBannerView, BannerSize bannerSize, String str, String str2) {
        this.g = mBBannerView;
        if (bannerSize != null) {
            this.h = bannerSize.getHeight();
            this.i = bannerSize.getWidth();
        }
        this.b = str2;
        this.c = str;
        this.d = new MBridgeIds(str, str2);
        String h2 = com.mbridge.msdk.foundation.controller.a.e().h();
        String i2 = com.mbridge.msdk.foundation.controller.a.e().i();
        if (this.p == null) {
            this.p = new com.mbridge.msdk.b.c();
        }
        this.p.a(com.mbridge.msdk.foundation.controller.a.e().g(), h2, i2, this.b);
        f();
    }

    public final void a(BannerSize bannerSize) {
        if (bannerSize != null) {
            this.h = bannerSize.getHeight();
            this.i = bannerSize.getWidth();
        }
    }

    public final void a(int i2) {
        this.k = b(i2);
        this.j = this.k;
    }

    public final void a(boolean z) {
        this.e = z;
        this.f = z ? 1 : 2;
    }

    private void f() {
        this.o = com.mbridge.msdk.b.b.a().e(com.mbridge.msdk.foundation.controller.a.e().h(), this.b);
        if (this.o == null) {
            this.o = d.d(this.b);
        }
        if (this.k == -1) {
            this.j = b(this.o.b());
        }
        if (this.f == 0) {
            boolean z = true;
            if (this.o.c() != 1) {
                z = false;
            }
            this.e = z;
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(this.e);
            }
        }
    }

    public final void a(String str) {
        if (this.h < 1 || this.i < 1) {
            BannerAdListener bannerAdListener = this.l;
            if (bannerAdListener != null) {
                bannerAdListener.onLoadFailed(this.d, "banner load failed because params are exception");
                return;
            }
            return;
        }
        b bVar = new b(this.i + "x" + this.h, this.j * 1000);
        bVar.a(str);
        bVar.b(this.c);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.c, this.b, bVar, this.w);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(1, this.c, this.b, bVar, this.w);
    }

    public final void a(BannerAdListener bannerAdListener) {
        this.l = bannerAdListener;
    }

    public final void b() {
        this.s = true;
        if (this.l != null) {
            this.l = null;
        }
        if (this.w != null) {
            this.w = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.c, this.b, (b) null, (com.mbridge.msdk.mbbanner.common.b.b) null);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.b);
        com.mbridge.msdk.mbbanner.common.c.a.a().b();
        c cVar = this.n;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (!this.s && this.t) {
            MBBannerView mBBannerView = this.g;
            if (this.m != null) {
                if (this.n == null) {
                    this.n = new c(mBBannerView, this.v, this.c, this.b, this.e, this.o);
                }
                this.n.b(this.q);
                this.n.c(this.r);
                this.n.a(this.e, this.f);
                this.n.a(this.m);
            } else {
                b("banner show failed because campain is exception");
            }
            this.t = false;
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        BannerAdListener bannerAdListener = this.l;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.d, str);
        }
        c();
    }

    public final void c() {
        if (!this.s) {
            h();
            f();
            b bVar = new b(this.i + "x" + this.h, this.j * 1000);
            bVar.b(this.c);
            com.mbridge.msdk.mbbanner.common.c.a.a().b(this.c, this.b, bVar, this.w);
        }
    }

    public final void b(boolean z) {
        this.q = z;
        i();
        g();
    }

    public final void c(boolean z) {
        this.r = z;
        i();
    }

    private void h() {
        MBBannerView mBBannerView = this.g;
        if (mBBannerView != null) {
            if (!this.q || !this.r || this.u || z.a(mBBannerView)) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, this.c, this.b, (b) null, (com.mbridge.msdk.mbbanner.common.b.b) null);
            } else {
                com.mbridge.msdk.mbbanner.common.c.a a2 = com.mbridge.msdk.mbbanner.common.c.a.a();
                String str = this.c;
                String str2 = this.b;
                a2.a(3, str, str2, new b(this.i + "x" + this.h, this.j * 1000), this.w);
            }
            if (!this.q) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.c, this.b, (b) null, (com.mbridge.msdk.mbbanner.common.b.b) null);
                com.mbridge.msdk.mbbanner.common.c.a.a().a(this.b);
            }
        }
    }

    private void i() {
        h();
        c cVar = this.n;
        if (cVar != null) {
            cVar.b(this.q);
            this.n.c(this.r);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(i2, i3, i4, i5);
        }
    }

    public final void d() {
        com.mbridge.msdk.mbbanner.common.c.a a2 = com.mbridge.msdk.mbbanner.common.c.a.a();
        String str = this.c;
        String str2 = this.b;
        a2.a(4, str, str2, new b(this.i + "x" + this.h, this.j * 1000), this.w);
    }

    public final void e() {
        com.mbridge.msdk.mbbanner.common.c.a a2 = com.mbridge.msdk.mbbanner.common.c.a.a();
        String str = this.c;
        String str2 = this.b;
        a2.a(3, str, str2, new b(this.i + "x" + this.h, this.j * 1000), this.w);
    }
}
