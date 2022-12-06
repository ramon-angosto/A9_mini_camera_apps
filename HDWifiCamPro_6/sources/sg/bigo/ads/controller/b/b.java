package sg.bigo.ads.controller.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.d.a.a;
import sg.bigo.ads.core.a.a;
import sg.bigo.ads.core.a.b;

public final class b extends c {
    public final o a = new o();
    public final a d = new a();
    public final sg.bigo.ads.core.d.a.a e = new sg.bigo.ads.core.d.a.a();
    public final sg.bigo.ads.core.b.a.a f = new sg.bigo.ads.core.b.a.a();
    public final sg.bigo.ads.core.a.b g = b.a.a;
    public final sg.bigo.ads.core.a.a h = a.C0133a.a;

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void a(JSONObject jSONObject) {
        this.a.a(jSONObject);
    }

    public final String b() {
        return "GlobalConfigData";
    }

    /* access modifiers changed from: protected */
    public final void b(JSONObject jSONObject) {
        this.d.a(jSONObject);
    }

    /* access modifiers changed from: protected */
    public final void c(JSONObject jSONObject) {
        this.e.a(jSONObject);
    }

    /* access modifiers changed from: protected */
    public final void d(JSONObject jSONObject) {
        this.f.a(jSONObject);
    }

    /* access modifiers changed from: protected */
    public final void e(JSONObject jSONObject) {
        this.g.a(jSONObject);
    }

    /* access modifiers changed from: protected */
    public final void f(JSONObject jSONObject) {
        this.h.a(jSONObject);
    }

    public final o g() {
        return this.a;
    }

    public final void l() {
        super.l();
        if (!TextUtils.isEmpty(this.w)) {
            try {
                d(new JSONObject(this.w));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.v)) {
            try {
                a(new JSONObject(this.v));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.u)) {
            try {
                b(new JSONObject(this.u));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.x)) {
            try {
                c(new JSONObject(this.x));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.y)) {
            try {
                e(new JSONObject(this.y));
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.K)) {
            try {
                f(new JSONObject(this.K));
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
        }
    }

    public final String p() {
        return this.q;
    }

    public final String toString() {
        return "GlobalConfigData{huaweiAdIdInfo=" + this.i + ", googleAdIdInfo=" + this.j + ", location=" + this.k + ", state=" + this.m + ", configId=" + this.n + ", interval=" + this.o + ", token='" + this.p + '\'' + ", antiBan='" + this.q + '\'' + ", strategy=" + this.r + ", abflags='" + this.s + '\'' + ", country='" + this.t + '\'' + ", creatives='" + this.u + '\'' + ", trackConfig='" + this.v + '\'' + ", callbackConfig='" + this.w + '\'' + ", reportConfig='" + this.x + '\'' + ", appCheckConfig='" + this.y + '\'' + ", uid='" + this.z + '\'' + ", maxRequestNum=" + this.A + ", negFeedbackState=" + this.B + ", omUrl='" + this.C + '\'' + ", globalSwitch=" + this.E.a + ", bannerJsUrl='" + this.D + '\'' + '}';
    }
}
