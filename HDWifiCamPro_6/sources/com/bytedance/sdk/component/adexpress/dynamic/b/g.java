package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.VisionDataDBAdapter;

/* compiled from: DynamicLayoutNativeValue */
public class g {
    public int a;
    public String b;
    private f c;
    private e d;
    private String e;

    public g(e eVar) {
        this.d = eVar;
        this.a = eVar.a();
        this.b = eVar.c();
        this.e = eVar.d();
        if (d.c() == 1) {
            this.c = eVar.f();
        } else {
            this.c = eVar.e();
        }
        if (d.b()) {
            this.c = eVar.e();
        }
    }

    public int a() {
        return (int) this.c.h();
    }

    public int b() {
        return (int) this.c.k();
    }

    public int c() {
        return (int) this.c.i();
    }

    public int d() {
        return (int) this.c.j();
    }

    public float e() {
        return this.c.l();
    }

    public String f() {
        return this.a == 0 ? this.b : "";
    }

    public int g() {
        return a(this.c.p());
    }

    public int h() {
        String o = this.c.o();
        if (TtmlNode.LEFT.equals(o)) {
            return 17;
        }
        if (TtmlNode.CENTER.equals(o)) {
            return 4;
        }
        return TtmlNode.RIGHT.equals(o) ? 3 : 2;
    }

    public int i() {
        int h = h();
        if (h == 4) {
            return 17;
        }
        return h == 3 ? 5 : 3;
    }

    public String j() {
        int i = this.a;
        if (i == 2 || i == 13) {
            return this.b;
        }
        return "";
    }

    public String k() {
        return this.a == 1 ? this.b : "";
    }

    public String l() {
        return this.e;
    }

    public double m() {
        if (this.a == 11) {
            try {
                double parseDouble = Double.parseDouble(this.b);
                return !d.b() ? (double) ((int) parseDouble) : parseDouble;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double n() {
        return this.c.m();
    }

    public float o() {
        return this.c.e();
    }

    public int p() {
        return a(this.c.s());
    }

    public float q() {
        return this.c.f();
    }

    public int r() {
        return this.c.ai();
    }

    public int s() {
        return this.c.ak();
    }

    public boolean t() {
        return this.c.aj();
    }

    public String u() {
        return this.c.r();
    }

    public void a(float f) {
        this.c.a(f);
    }

    public boolean v() {
        return this.c.B();
    }

    public int w() {
        return this.c.C();
    }

    public int x() {
        String x = this.c.x();
        if ("skip-with-time-skip-btn".equals(this.d.b()) || "skip".equals(this.d.b()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.d.b())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.d.b()) && !"skip-with-time".equals(this.d.b())) {
            if (this.a == 10 && TextUtils.equals(this.c.y(), CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                return 5;
            }
            if (N() && O()) {
                return 0;
            }
            if (N()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.d.b())) {
                return 3;
            }
            if (!TextUtils.isEmpty(x) && !x.equals("none")) {
                if (x.equals("video") || (this.d.a() == 7 && TextUtils.equals(x, "normal"))) {
                    return (!d.b() || this.d.e() == null || !this.d.e().am()) ? 4 : 11;
                }
                if (x.equals("normal")) {
                    return 1;
                }
                if (!x.equals(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE) && !"slide".equals(this.c.y())) {
                    return 0;
                }
                return 2;
            }
        }
        return 0;
    }

    private boolean N() {
        if ((!d.b() || (!this.d.b().contains("logo-union") && !this.d.b().contains("logounion") && !this.d.b().contains("logoad"))) && !"logo-union".equals(this.d.b()) && !"logounion".equals(this.d.b()) && !"logoad".equals(this.d.b())) {
            return false;
        }
        return true;
    }

    public int y() {
        return a(this.c.q());
    }

    public int z() {
        return this.c.c();
    }

    public String A() {
        return this.c.d();
    }

    public String B() {
        return this.c.y();
    }

    private boolean O() {
        if (d.b()) {
            return false;
        }
        if ((TextUtils.isEmpty(this.b) || !this.b.contains("adx:")) && !j.b()) {
            return false;
        }
        return true;
    }

    public static int a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith("rgba") || (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) == null || split.length != 4) {
            return -16777216;
        }
        return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2])) | 0;
    }

    public static float[] b(String str) {
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (split == null || split.length != 4) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        return new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])};
    }

    public boolean a(int i) {
        e eVar = this.d;
        if (eVar == null) {
            return false;
        }
        if (i == 1) {
            this.c = eVar.f();
        } else {
            this.c = eVar.e();
        }
        if (this.c != null) {
            return true;
        }
        return false;
    }

    public boolean C() {
        return this.c.U();
    }

    public int D() {
        return this.c.W();
    }

    public int E() {
        return this.c.V();
    }

    public String F() {
        return this.c.w();
    }

    public int G() {
        return this.c.b();
    }

    public int H() {
        return this.c.ah();
    }

    public int I() {
        return this.c.an();
    }

    public int J() {
        return this.c.ae();
    }

    public int K() {
        return this.c.ad();
    }

    public String L() {
        return this.c.v();
    }

    public boolean M() {
        return this.c.g();
    }
}
