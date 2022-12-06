package sg.bigo.ads.controller.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.VisionDataDBAdapter;
import com.vungle.warren.ui.JavascriptBridge;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.controller.b.f;

public class b implements c {
    private final long A;
    private final h B;
    private long C;
    private int D;
    private int E;
    private int F = 0;
    private boolean G;
    private long H;
    private sg.bigo.ads.api.a.h I;
    private final String J;
    private String K;
    private int L = 2;
    private final double M;
    protected final g a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected int g;
    protected int h;
    protected long i;
    protected String j;
    protected String k;
    protected c.d l;
    protected c.e[] m;
    protected c.e[] n;
    protected c.e[] o;
    protected c.e[] p;
    protected List<c.C0120c> q;
    protected String r;
    protected long s;
    protected String t;
    protected String u;
    protected c.b v;
    protected c.a w;
    private JSONObject x;
    private final long y;
    private final long z;

    protected b(long j2, h hVar, g gVar, JSONObject jSONObject) {
        this.A = j2;
        this.B = hVar;
        this.a = gVar;
        this.z = SystemClock.elapsedRealtime();
        this.b = jSONObject.optString("ad_id", "");
        this.c = jSONObject.optString(CampaignEx.JSON_KEY_TITLE, "");
        this.d = jSONObject.optString("description", "");
        this.e = jSONObject.optString("cta", "");
        this.f = jSONObject.optString("dsp_name", "");
        this.g = jSONObject.optInt("adx_type", 0);
        this.h = jSONObject.optInt("ad_type", -1);
        this.i = jSONObject.optLong("sid");
        this.j = jSONObject.optString(CampaignEx.JSON_KEY_CREATIVE_ID, "");
        this.k = jSONObject.optString("series_id", "");
        JSONObject optJSONObject = jSONObject.optJSONObject(JavascriptBridge.MraidHandler.PRIVACY_ACTION);
        if (optJSONObject != null) {
            this.l = new m(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("track_clicks_third");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    arrayList.add(new n(optJSONObject2));
                }
            }
            this.n = new c.e[arrayList.size()];
            this.n = (c.e[]) arrayList.toArray(this.n);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("track_impls_third");
        if (optJSONArray2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    arrayList2.add(new n(optJSONObject3));
                }
            }
            this.m = new c.e[arrayList2.size()];
            this.m = (c.e[]) arrayList2.toArray(this.m);
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("ad_nurls");
        if (optJSONArray3 != null) {
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                if (optJSONObject4 != null) {
                    arrayList3.add(new n(optJSONObject4));
                }
            }
            this.o = new c.e[arrayList3.size()];
            this.o = (c.e[]) arrayList3.toArray(this.o);
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("ad_lurls");
        if (optJSONArray4 != null) {
            ArrayList arrayList4 = new ArrayList();
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i5);
                if (optJSONObject5 != null) {
                    arrayList4.add(new n(optJSONObject5));
                }
            }
            this.p = new c.e[arrayList4.size()];
            this.p = (c.e[]) arrayList4.toArray(this.p);
        }
        this.q = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("om_data");
        if (optJSONArray5 != null) {
            this.q = new ArrayList();
            for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                this.q.add(new l(optJSONArray5.optJSONObject(i6)));
            }
        }
        this.r = jSONObject.optString("enc_price", "");
        this.v = new j(jSONObject);
        this.w = new e(jSONObject);
        this.s = jSONObject.optLong("switch_bit_map", 0);
        this.t = jSONObject.optString("abflags", "");
        this.y = jSONObject.optLong("expired_interval", 0);
        this.u = jSONObject.optString("mapping_slot", "");
        this.C = jSONObject.optLong("probe_interval");
        this.D = jSONObject.optInt("playable_ad_switch", 0);
        String optString = jSONObject.optString("interstitial_style_getad_config");
        if (!TextUtils.isEmpty(optString)) {
            try {
                this.I = new f(new JSONObject(optString));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.K = jSONObject.optString(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER);
        this.J = jSONObject.optString("sdk_style_id");
        this.M = (((double) jSONObject.optLong("bid_price", 0)) * 1.0d) / 1.0E8d;
        if (sg.bigo.ads.api.core.b.c(this.h)) {
            this.x = jSONObject;
        }
    }

    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r1v6, types: [sg.bigo.ads.controller.c.k] */
    /* JADX WARNING: type inference failed for: r1v7, types: [sg.bigo.ads.controller.c.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static sg.bigo.ads.controller.c.b a(long r7, sg.bigo.ads.api.core.h r9, sg.bigo.ads.api.a.g r10, java.lang.String r11) {
        /*
            r0 = 0
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002c }
            r6.<init>(r11)     // Catch:{ JSONException -> 0x002c }
            java.lang.String r11 = "adx_type"
            r1 = 0
            int r11 = r6.optInt(r11, r1)     // Catch:{ JSONException -> 0x002c }
            r1 = 1
            if (r11 == r1) goto L_0x0021
            r1 = 2
            if (r11 == r1) goto L_0x0021
            r1 = 3
            if (r11 == r1) goto L_0x0017
            goto L_0x0030
        L_0x0017:
            sg.bigo.ads.controller.c.c r11 = new sg.bigo.ads.controller.c.c     // Catch:{ JSONException -> 0x002c }
            r1 = r11
            r2 = r7
            r4 = r9
            r5 = r10
            r1.<init>(r2, r4, r5, r6)     // Catch:{ JSONException -> 0x002c }
            goto L_0x002a
        L_0x0021:
            sg.bigo.ads.controller.c.k r11 = new sg.bigo.ads.controller.c.k     // Catch:{ JSONException -> 0x002c }
            r1 = r11
            r2 = r7
            r4 = r9
            r5 = r10
            r1.<init>(r2, r4, r5, r6)     // Catch:{ JSONException -> 0x002c }
        L_0x002a:
            r0 = r11
            goto L_0x0030
        L_0x002c:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.c.b.a(long, sg.bigo.ads.api.core.h, sg.bigo.ads.api.a.g, java.lang.String):sg.bigo.ads.controller.c.b");
    }

    public final String A() {
        return this.u;
    }

    public final c.b B() {
        return this.v;
    }

    public final c.a C() {
        return this.w;
    }

    public final long D() {
        return this.A;
    }

    public final h E() {
        return this.B;
    }

    public final long F() {
        return this.C;
    }

    public final String G() {
        return (this.h == 3 && this.g == 3) ? "1999999" : !o.b(this.J) ? this.J : this.a.o();
    }

    public final boolean H() {
        return this.D == 1;
    }

    public final int I() {
        return this.E;
    }

    public final int J() {
        return this.F;
    }

    public final JSONObject K() {
        return this.x;
    }

    public final void L() {
        this.G = true;
    }

    public final boolean M() {
        return this.G;
    }

    public final double N() {
        return this.M;
    }

    public final int O() {
        return this.a.u();
    }

    public final boolean P() {
        return this.a.u() == 2;
    }

    public final String a() {
        return this.a.k();
    }

    public final void a(long j2) {
        this.H = j2;
    }

    public final void a(boolean z2) {
        this.L = z2 ? 1 : 2;
    }

    public final boolean a(int i2) {
        return (this.s & ((long) i2)) > 0;
    }

    public final g b() {
        return this.a;
    }

    public final void b(int i2) {
        this.E = i2;
    }

    public final sg.bigo.ads.api.a.h c() {
        return this.I;
    }

    public final void c(int i2) {
        this.F = i2;
    }

    public final int d() {
        return this.L;
    }

    public final boolean e() {
        sg.bigo.ads.api.a.h hVar = this.I;
        return hVar != null && hVar.a("endpage.ad_component_layout") == 5;
    }

    public final String f() {
        return this.K;
    }

    public final String g() {
        return this.b;
    }

    public String h() {
        return this.c;
    }

    public String i() {
        return this.d;
    }

    public final String j() {
        return this.e;
    }

    public final String k() {
        return this.f;
    }

    public final int l() {
        return this.g;
    }

    public final int m() {
        return this.h;
    }

    public final long n() {
        return this.i;
    }

    public final String o() {
        return this.j;
    }

    public final String p() {
        return this.k;
    }

    public final c.d q() {
        return this.l;
    }

    public final c.e[] r() {
        return this.m;
    }

    public final c.e[] s() {
        return this.n;
    }

    public final c.e[] t() {
        return this.o;
    }

    public final c.e[] u() {
        return this.p;
    }

    public final List<c.C0120c> v() {
        return this.q;
    }

    public final String w() {
        return this.r;
    }

    public final String x() {
        return this.t;
    }

    public final boolean y() {
        return (!this.G || this.H <= 0) ? SystemClock.elapsedRealtime() - this.z >= this.y * 1000 : System.currentTimeMillis() > this.H;
    }

    public final long z() {
        return this.y;
    }
}
