package sg.bigo.ads.controller.b;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.b;
import sg.bigo.ads.api.a.d;
import sg.bigo.ads.api.a.f;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.core.j;
import sg.bigo.ads.api.core.k;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.h;
import sg.bigo.ads.common.j.a;
import sg.bigo.ads.common.utils.o;

public abstract class c extends sg.bigo.ads.common.c implements d {
    protected int A;
    protected boolean B;
    protected String C;
    protected String D;
    protected k E = new k();
    protected sg.bigo.ads.api.a.c F = new j();
    protected i G = new p();
    protected sg.bigo.ads.api.a.j H = new q();
    protected String I;
    protected Map<String, b> J = new HashMap();
    protected String K;
    private final Runnable a = new Runnable() {
        public final void run() {
            c cVar = c.this;
            cVar.k = a.a(cVar.b);
            c.this.o();
        }
    };
    protected sg.bigo.ads.common.a i;
    protected sg.bigo.ads.common.a j;
    protected sg.bigo.ads.common.j.b k;
    protected long l;
    protected boolean m;
    protected long n;
    protected int o;
    protected String p;
    protected String q;
    protected int r = 1;
    protected String s;
    protected String t;
    protected String u;
    protected String v;
    protected String w;
    protected String x;
    protected String y;
    protected String z;

    public c(Context context) {
        super(context);
    }

    public static long u() {
        return TimeUnit.SECONDS.toMillis(30);
    }

    public final sg.bigo.ads.common.a A() {
        if (this.i == null) {
            this.i = sg.bigo.ads.common.a.a;
        }
        if (this.i.a()) {
            sg.bigo.ads.common.f.c.a(0, new Runnable() {
                public final void run() {
                    c cVar = c.this;
                    cVar.i = sg.bigo.ads.common.g.c.a(cVar.b);
                    c.this.o();
                }
            });
        }
        return this.i;
    }

    public final sg.bigo.ads.common.a B() {
        if (this.j == null) {
            this.j = sg.bigo.ads.common.a.a;
        }
        if (this.j.a()) {
            sg.bigo.ads.common.f.c.a(0, new Runnable() {
                public final void run() {
                    c cVar = c.this;
                    cVar.j = sg.bigo.ads.common.e.b.a(cVar.b);
                    c.this.o();
                }
            });
        }
        return this.j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if ((java.lang.System.currentTimeMillis() - r5.k.h > sg.bigo.ads.common.j.b.a) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized sg.bigo.ads.common.j.b C() {
        /*
            r5 = this;
            monitor-enter(r5)
            sg.bigo.ads.common.j.b r0 = r5.k     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x001f
            sg.bigo.ads.common.j.b r0 = r5.k     // Catch:{ all -> 0x002e }
            boolean r0 = r0.b     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002a
            sg.bigo.ads.common.j.b r0 = r5.k     // Catch:{ all -> 0x002e }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002e }
            long r3 = r0.h     // Catch:{ all -> 0x002e }
            long r1 = r1 - r3
            long r3 = sg.bigo.ads.common.j.b.a     // Catch:{ all -> 0x002e }
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 == 0) goto L_0x002a
        L_0x001f:
            java.lang.Runnable r0 = r5.a     // Catch:{ all -> 0x002e }
            sg.bigo.ads.common.f.c.a((java.lang.Runnable) r0)     // Catch:{ all -> 0x002e }
            r0 = 3
            java.lang.Runnable r1 = r5.a     // Catch:{ all -> 0x002e }
            sg.bigo.ads.common.f.c.a(r0, r1)     // Catch:{ all -> 0x002e }
        L_0x002a:
            sg.bigo.ads.common.j.b r0 = r5.k     // Catch:{ all -> 0x002e }
            monitor-exit(r5)
            return r0
        L_0x002e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.b.c.C():sg.bigo.ads.common.j.b");
    }

    public final boolean D() {
        return this.l != 0;
    }

    public final b a(String str) {
        if (this.J == null || o.b(str)) {
            return b.a;
        }
        b bVar = this.J.get(str);
        return bVar != null ? bVar : b.a;
    }

    public final void a(Parcel parcel) {
        if (this.i == null) {
            this.i = sg.bigo.ads.common.a.a;
        }
        this.i.a(parcel);
        if (this.j == null) {
            this.j = sg.bigo.ads.common.a.a;
        }
        this.j.a(parcel);
        if (this.k == null) {
            this.k = new sg.bigo.ads.common.j.b(this.b);
        }
        this.k.a(parcel);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeLong(this.n);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B ? 1 : 0);
        parcel.writeString(this.C);
        parcel.writeLong(this.l);
        this.E.a(parcel);
        parcel.writeString(this.D);
        this.F.a(parcel);
        parcel.writeString(this.I);
        h.a(parcel, this.J);
        parcel.writeString(this.K);
        this.G.a(parcel);
        this.H.a(parcel);
    }

    /* access modifiers changed from: protected */
    public abstract void a(JSONObject jSONObject);

    public final String a_() {
        return "bigoad_config.dat";
    }

    public final void b(Parcel parcel) {
        this.i = new sg.bigo.ads.common.a(parcel);
        this.j = new sg.bigo.ads.common.a(parcel);
        this.k = new sg.bigo.ads.common.j.b(this.b, parcel);
        boolean z2 = true;
        this.m = parcel.readInt() != 0;
        this.n = parcel.readLong();
        this.o = parcel.readInt();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readInt();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.B = z2;
        this.C = parcel.readString();
        this.l = parcel.readLong();
        if (parcel.dataAvail() > 0) {
            this.E.b(parcel);
        }
        if (parcel.dataAvail() > 0) {
            this.D = parcel.readString();
        }
        if (parcel.dataAvail() > 0) {
            this.F.b(parcel);
        }
        this.I = h.a(parcel, "");
        this.J = h.a(parcel, b.b, new HashMap());
        this.K = h.a(parcel, "");
        if (parcel.dataAvail() > 0) {
            this.G.b(parcel);
        }
        if (parcel.dataAvail() > 0) {
            this.H.b(parcel);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b(JSONObject jSONObject);

    public final long c() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public abstract void c(JSONObject jSONObject);

    public final String d() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public abstract void d(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract void e(JSONObject jSONObject);

    public final boolean e() {
        return this.m;
    }

    public final String f() {
        return this.p;
    }

    /* access modifiers changed from: protected */
    public abstract void f(JSONObject jSONObject);

    public final void g(JSONObject jSONObject) {
        boolean z2 = true;
        int i2 = 0;
        this.m = jSONObject.optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, 1) == 1;
        this.n = jSONObject.optLong("config_id", 0);
        this.o = jSONObject.optInt("conf_interval", 3600);
        this.p = jSONObject.optString("token", "");
        this.q = jSONObject.optString("anti_ban", "");
        this.r = jSONObject.optInt("config_strategy", 1);
        this.s = jSONObject.optString("abflags", "");
        this.t = jSONObject.optString("country", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("creatives");
        if (optJSONObject != null) {
            this.u = optJSONObject.toString();
        } else {
            this.u = "";
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("track");
        if (optJSONObject2 != null) {
            this.v = optJSONObject2.toString();
        } else {
            this.v = "";
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("cb");
        if (optJSONObject3 != null) {
            this.w = optJSONObject3.toString();
        } else {
            this.w = "";
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject(ReportDBAdapter.ReportColumns.TABLE_NAME);
        if (optJSONObject4 != null) {
            this.x = optJSONObject4.toString();
        } else {
            this.x = "";
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("app_chk");
        if (optJSONObject5 != null) {
            this.y = optJSONObject5.toString();
        } else {
            this.y = "";
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("u_running_lock");
        if (optJSONObject6 != null) {
            this.K = optJSONObject6.toString();
        } else {
            this.K = "";
        }
        String optString = jSONObject.optString("uid", "");
        if (!TextUtils.isEmpty(optString)) {
            this.z = optString;
        }
        this.A = jSONObject.optInt("concurrent_req_num", 3);
        if (this.A <= 0) {
            this.A = Integer.MAX_VALUE;
        }
        if (jSONObject.optInt("neg_feedback", 1) != 1) {
            z2 = false;
        }
        this.B = z2;
        this.C = jSONObject.optString("om_js_url", "");
        this.D = jSONObject.optString("banner_js_url", "");
        this.F.a(jSONObject.optJSONObject("free_material"));
        this.G.a(jSONObject.optJSONObject("u_running_conf"));
        this.H.a(jSONObject.optJSONObject("u_running_inf"));
        this.E.a = jSONObject.optLong("global_switch", 0);
        this.I = jSONObject.optString("sdk_report_url");
        String optString2 = jSONObject.optString("global_conf");
        JSONArray jSONArray = null;
        try {
            if (!o.b(optString2)) {
                jSONArray = new JSONArray(optString2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        while (jSONArray != null && i2 < jSONArray.length()) {
            JSONObject optJSONObject7 = jSONArray.optJSONObject(i2);
            if (optJSONObject7 != null) {
                String optString3 = optJSONObject7.optString("key");
                if (!o.b(optString3)) {
                    hashMap.put(optString3, new b(optJSONObject7.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, "")));
                }
            }
            i2++;
        }
        this.J = hashMap;
        a(optJSONObject2);
        b(optJSONObject);
        c(optJSONObject4);
        d(optJSONObject3);
        e(optJSONObject5);
        f(optJSONObject6);
        this.l = sg.bigo.ads.common.utils.p.b() / 1000;
    }

    public final f h() {
        return this.E;
    }

    public final String i() {
        return this.D;
    }

    public final sg.bigo.ads.api.a.c j() {
        return this.F;
    }

    public final String k() {
        return this.I;
    }

    public final void q() {
        B();
        A();
        C();
    }

    public final boolean r() {
        return Math.abs((sg.bigo.ads.common.utils.p.b() / 1000) - this.l) > ((long) this.o);
    }

    public final boolean s() {
        return this.r == 0;
    }

    public final int t() {
        return this.A;
    }

    public final String v() {
        return this.z;
    }

    public final String w() {
        return this.t;
    }

    public final String x() {
        return this.C;
    }

    public final i y() {
        return this.G;
    }

    public final sg.bigo.ads.api.a.j z() {
        return this.H;
    }
}
