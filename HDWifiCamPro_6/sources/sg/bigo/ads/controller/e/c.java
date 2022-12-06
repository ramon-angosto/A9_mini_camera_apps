package sg.bigo.ads.controller.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.l.a;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.controller.b.b;

public final class c implements e {
    public final AdConfig a;
    final Context b;
    final b c;
    String d;
    String e;
    int f;
    String g;
    String h;
    String i;
    String j;
    String k;
    public int l;
    String m;
    String n;
    int o;
    long p;
    long q;
    String r;
    private final a s;

    c(Context context, AdConfig adConfig, b bVar, a aVar) {
        this.b = context;
        this.a = adConfig;
        this.c = bVar;
        this.s = aVar;
    }

    public final String A() {
        return sg.bigo.ads.common.a.a.a(this.b);
    }

    public final String B() {
        return this.c.v();
    }

    public final int C() {
        return (int) (p.b() / 1000);
    }

    public final String D() {
        return this.s.a(sg.bigo.ads.b.a());
    }

    public final String E() {
        return this.c.d();
    }

    public final boolean F() {
        sg.bigo.ads.common.a A = this.c.A();
        if (A != null) {
            return A.c;
        }
        return true;
    }

    public final String G() {
        sg.bigo.ads.common.a A = this.c.A();
        return A != null ? A.b : "";
    }

    public final String H() {
        return this.m;
    }

    public final String I() {
        return this.n;
    }

    public final int J() {
        return this.o;
    }

    public final long K() {
        return this.p;
    }

    public final long L() {
        return this.q;
    }

    public final long M() {
        return n.a(this.b);
    }

    public final long N() {
        return n.c();
    }

    public final long O() {
        return n.a();
    }

    public final String P() {
        return this.c.f();
    }

    public final String Q() {
        sg.bigo.ads.common.j.b C = this.c.C();
        return o.f(C != null ? C.e : "");
    }

    public final String R() {
        return o.f(sg.bigo.ads.common.p.b.d(this.b));
    }

    public final String S() {
        return o.f(sg.bigo.ads.common.p.b.b(this.b));
    }

    public final String T() {
        return this.r;
    }

    public final String a() {
        return this.a.getAppKey();
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final int d() {
        return this.f;
    }

    public final String e() {
        return this.a.getChannel();
    }

    public final String f() {
        return "android";
    }

    public final String g() {
        return Build.VERSION.RELEASE;
    }

    public final String h() {
        return this.g;
    }

    public final String i() {
        return this.h;
    }

    public final String j() {
        return this.i;
    }

    public final String k() {
        return this.j;
    }

    public final String l() {
        return this.k;
    }

    public final int m() {
        return this.l;
    }

    public final String n() {
        int b2 = sg.bigo.ads.common.p.c.b(this.b);
        return b2 != 1 ? b2 != 2 ? b2 != 3 ? b2 != 4 ? b2 != 5 ? "unknown" : "5g" : "4g" : "wifi" : "3g" : "2g";
    }

    public final String o() {
        return o.f(sg.bigo.ads.common.utils.b.a());
    }

    public final boolean p() {
        return this.c.z().a();
    }

    public final int q() {
        sg.bigo.ads.common.j.b C = this.c.C();
        if (C != null) {
            return (int) ((long) (C.d * 1000000.0d));
        }
        return 0;
    }

    public final int r() {
        sg.bigo.ads.common.j.b C = this.c.C();
        if (C != null) {
            return (int) ((long) (C.c * 1000000.0d));
        }
        return 0;
    }

    public final String s() {
        String w = this.c.w();
        return !TextUtils.isEmpty(w) ? w : u();
    }

    public final String t() {
        return this.c.w();
    }

    public final String u() {
        String Q = Q();
        if (!TextUtils.isEmpty(Q)) {
            return Q;
        }
        String R = R();
        return !TextUtils.isEmpty(R) ? R : S();
    }

    public final String v() {
        sg.bigo.ads.common.j.b C = this.c.C();
        return C != null ? C.f : "";
    }

    public final String w() {
        sg.bigo.ads.common.j.b C = this.c.C();
        return C != null ? C.g : "";
    }

    public final String x() {
        return "2.4.1";
    }

    public final boolean y() {
        sg.bigo.ads.common.a B = this.c.B();
        if (B != null) {
            return B.c;
        }
        return true;
    }

    public final String z() {
        sg.bigo.ads.common.a B = this.c.B();
        return B != null ? B.b : "";
    }
}
