package sg.bigo.ads.controller.h;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.l.b;
import sg.bigo.ads.common.l.c.c;
import sg.bigo.ads.common.l.c.d;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.l.h;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.o;

public abstract class a {
    protected final int a;
    protected final e b;
    protected final long c;
    protected final String d;
    protected final String e;
    protected final String f;
    private final b<sg.bigo.ads.common.l.b.b, d> g;

    /* renamed from: sg.bigo.ads.controller.h.a$a  reason: collision with other inner class name */
    public interface C0132a {
        void a(String str, Object obj);
    }

    public a(e eVar) {
        this(eVar, 15000);
    }

    public a(e eVar, long j) {
        this.g = new b<sg.bigo.ads.common.l.b.b, d>() {
            private long b = -1;
            private int d = -1;

            public final /* synthetic */ c a(sg.bigo.ads.common.l.c.a aVar) {
                return new sg.bigo.ads.controller.i.a(aVar);
            }

            public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar) {
                super.a((sg.bigo.ads.common.l.b.b) cVar);
                this.b = SystemClock.elapsedRealtime();
                this.d = sg.bigo.ads.common.b.c.b();
            }

            public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, c cVar2) {
                sg.bigo.ads.common.l.b.b bVar = (sg.bigo.ads.common.l.b.b) cVar;
                d dVar = (d) cVar2;
                if (a.this.d()) {
                    long j = 0;
                    if (this.b > 0) {
                        j = SystemClock.elapsedRealtime() - this.b;
                    }
                    sg.bigo.ads.core.d.a.a(bVar.f(), true, j, dVar.a.a, "", this.d, bVar.e(), a.this.d, a.this.e, a.this.f);
                }
                boolean z = false;
                if (dVar instanceof sg.bigo.ads.controller.i.a) {
                    sg.bigo.ads.controller.i.a aVar = (sg.bigo.ads.controller.i.a) dVar;
                    if (aVar.c == 1) {
                        z = true;
                    }
                    if (z) {
                        a.this.a(dVar.a(), aVar.e);
                    } else {
                        a.this.a(1005, aVar.c, aVar.d);
                    }
                } else {
                    a.this.a(1005, 0, "Invalid response.");
                }
            }

            public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, h hVar) {
                String str;
                h hVar2 = hVar;
                sg.bigo.ads.common.l.b.b bVar = (sg.bigo.ads.common.l.b.b) cVar;
                if (a.this.d()) {
                    long j = 0;
                    if (this.b > 0) {
                        j = SystemClock.elapsedRealtime() - this.b;
                    }
                    long j2 = j;
                    String f = bVar.f();
                    if (hVar2.a == 3000) {
                        f = "https://invalid.url";
                    }
                    sg.bigo.ads.core.d.a.a(f, false, j2, hVar2.a, hVar.getMessage(), this.d, bVar.e(), a.this.d, a.this.e, a.this.f);
                }
                if (hVar2.a == 1001 || hVar2.a == 1002) {
                    str = "Request timeout.";
                } else {
                    str = "(" + hVar2.a + ") " + hVar.getMessage();
                }
                a.this.a(1003, hVar2.a, str);
            }
        };
        this.a = sg.bigo.ads.common.o.a.a();
        this.b = eVar;
        this.c = j;
        this.d = this.b.Q();
        this.e = this.b.R();
        this.f = this.b.S();
    }

    public final int a() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public StringBuilder a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.a(this.b.a()));
        sb.append(",");
        sb.append(o.a(this.b.b()));
        sb.append(",");
        sb.append(o.a(this.b.c()));
        sb.append(",");
        sb.append(this.b.d());
        sb.append(",");
        sb.append(o.a(this.b.f()));
        sb.append(",");
        sb.append(o.a(this.b.g()));
        sb.append(",");
        sb.append(o.a(this.b.x()));
        sb.append(",20401");
        sb.append(",");
        sb.append(j);
        sb.append(",");
        sb.append(o.a(this.b.z()));
        sb.append(",");
        sb.append(o.a(this.b.A()));
        sb.append(",");
        sb.append(o.a(this.b.B()));
        sb.append(",");
        sb.append(o.a(this.b.G()));
        sb.append(",");
        sb.append(o.a(str));
        return sb;
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i, int i2, String str);

    /* access modifiers changed from: protected */
    public abstract void a(String str, Map<String, Object> map);

    /* access modifiers changed from: protected */
    public abstract void a(C0132a aVar);

    public final void b() {
        final JSONObject jSONObject;
        String c2 = c();
        sg.bigo.ads.common.l.b.b bVar = new sg.bigo.ads.common.l.b.b(this.a, c2);
        if (sg.bigo.ads.common.n.a.c()) {
            this.g.a(bVar, new h(2000, "Missing user consent."));
        } else if (!URLUtil.isNetworkUrl(c2)) {
            this.g.a(bVar, new h((int) PathInterpolatorCompat.MAX_NUM_POINTS, "Invalid url(" + c2 + ") ."));
        } else {
            try {
                jSONObject = new JSONObject();
                jSONObject.putOpt(MBridgeConstans.APP_KEY, o.a(this.b.a()));
                jSONObject.putOpt("pkg_name", o.a(this.b.b()));
                jSONObject.putOpt("pkg_ver", o.a(this.b.c()));
                jSONObject.putOpt("pkg_vc", Integer.valueOf(this.b.d()));
                jSONObject.putOpt("pkg_ch", this.b.e());
                jSONObject.putOpt("os", o.a(this.b.f()));
                jSONObject.putOpt("os_ver", o.a(this.b.g()));
                jSONObject.putOpt("os_lang", this.b.h());
                jSONObject.putOpt("vendor", this.b.i());
                jSONObject.putOpt("model", this.b.j());
                jSONObject.putOpt("isp", this.b.k());
                jSONObject.putOpt("resolution", this.b.l());
                jSONObject.putOpt("dpi", Integer.valueOf(this.b.m()));
                jSONObject.putOpt("net", this.b.n());
                jSONObject.putOpt("timezone", this.b.o());
                if (this.b.p()) {
                    jSONObject.putOpt("ewd", String.valueOf(this.b.q() ^ 3023727));
                    jSONObject.putOpt("ejd", String.valueOf(this.b.r() ^ 3023727));
                }
                jSONObject.putOpt("country", this.b.s());
                jSONObject.putOpt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, this.b.v());
                jSONObject.putOpt("city", this.b.w());
                jSONObject.putOpt("sdk_ver", o.a(this.b.x()));
                jSONObject.putOpt("sdk_vc", 20401);
                jSONObject.putOpt(VungleApiClient.GAID, o.a(this.b.z()));
                jSONObject.putOpt("af_id", o.a(this.b.A()));
                jSONObject.putOpt("uid", o.a(this.b.B()));
                long C = (long) this.b.C();
                jSONObject.putOpt("timestamp", Long.valueOf(C));
                jSONObject.putOpt("pre_host", this.b.D());
                jSONObject.putOpt("abflags", this.b.E());
                jSONObject.putOpt("hw_id", o.a(this.b.G()));
                jSONObject.putOpt("gg_service_ver", this.b.H());
                jSONObject.putOpt("webkit_ver", this.b.I());
                jSONObject.putOpt("cpu_core_num", Integer.valueOf(this.b.J()));
                jSONObject.putOpt("cpu_clock_speed", Long.valueOf(this.b.K()));
                jSONObject.putOpt("total_memory", Long.valueOf(this.b.L()));
                jSONObject.putOpt("free_memory", Long.valueOf(this.b.M()));
                jSONObject.putOpt("rom_free_in", Long.valueOf(this.b.N()));
                jSONObject.putOpt("rom_free_ext", Long.valueOf(this.b.O()));
                String uuid = UUID.randomUUID().toString();
                jSONObject.putOpt("request_id", o.a(uuid));
                jSONObject.putOpt("gps_country", this.d);
                jSONObject.putOpt("sim_country", this.e);
                jSONObject.putOpt("system_country", this.f);
                jSONObject.putOpt("inst_src", this.b.T());
                a(new C0132a() {
                    public final void a(String str, Object obj) {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject.putOpt(str, obj);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                jSONObject.putOpt("sign", k.a(a(C, uuid).toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            bVar.a = null;
            if (jSONObject != null) {
                bVar.b = jSONObject.toString();
                try {
                    bVar.a = bVar.b.getBytes("utf-8");
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
            bVar.f = this.c;
            bVar.a("SDK-Version-Code", BigoAdSdk.getSDKVersion());
            b bVar2 = this.g;
            if (bVar2 == null) {
                bVar2 = b.c;
            }
            g.a.a(bVar, bVar2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract String c();

    /* access modifiers changed from: protected */
    public boolean d() {
        return true;
    }
}
