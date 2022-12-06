package sg.bigo.ads.controller.e;

import android.os.SystemClock;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.controller.c;
import sg.bigo.ads.controller.h.f;

public final class d implements c<String> {
    final e a;
    final sg.bigo.ads.controller.b.b b;
    final sg.bigo.ads.controller.b.d c;
    final sg.bigo.ads.common.l.a d;
    f e;
    long f = -1;
    int g;
    private final List<b> h;

    public interface a {
        void a();

        void a(int i, String str);
    }

    static class b implements a {
        private final a a;

        public b(a aVar) {
            this.a = aVar;
        }

        public final void a() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public final void a(int i, String str) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(i, str);
            }
        }
    }

    public d(sg.bigo.ads.controller.b.b bVar, sg.bigo.ads.controller.b.d dVar, e eVar, sg.bigo.ads.common.l.a aVar) {
        this.a = eVar;
        this.b = bVar;
        this.c = dVar;
        this.d = aVar;
        this.h = new ArrayList();
    }

    private void a(int i) {
        if (this.e == null) {
            this.g = i;
            this.f = SystemClock.elapsedRealtime();
            if (o.b(this.a.a())) {
                a(1001, "App Id cannot be null.");
                return;
            }
            this.e = new f(this.a, sg.bigo.ads.controller.b.b.u(), this);
            this.e.b();
        }
    }

    static /* synthetic */ void a(d dVar) {
        for (b a2 : dVar.h) {
            a2.a();
        }
        dVar.h.clear();
    }

    public final void a(int i, int i2, int i3, String str, Object obj) {
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final int i6 = i3;
        sg.bigo.ads.common.f.c.a(3, new Runnable() {
            public final void run() {
                sg.bigo.ads.common.k.a.a(0, "GlobalConfig", "request error, seq=" + i4 + ", error=" + i5 + ", message=" + str2);
                d.this.e = null;
                StringBuilder sb = new StringBuilder("Error from server: ");
                sb.append(str2);
                d.this.a(i5, sb.toString());
                sg.bigo.ads.core.d.a.a(i5, i6, str2, d.this.g);
            }
        });
    }

    public final /* synthetic */ void a(final int i, Object obj) {
        final String str = (String) obj;
        sg.bigo.ads.common.f.c.a(3, new Runnable() {
            public final void run() {
                String str = "1";
                sg.bigo.ads.common.k.a.a(0, 3, "GlobalConfig", "request success, seq=" + i + ", result=" + str);
                try {
                    boolean D = d.this.b.D();
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("global");
                    JSONArray optJSONArray = jSONObject.optJSONArray("slots");
                    if (optJSONObject != null) {
                        if (optJSONArray != null) {
                            d.this.b.g(optJSONObject);
                            d.this.b.n();
                            d.this.c.a(optJSONArray);
                            d.this.c.n();
                            sg.bigo.ads.b.a(d.this.b, d.this.a.u());
                            d.this.d.a(sg.bigo.ads.b.a(), d.this.b.p());
                            d.this.d.a();
                            d.a(d.this);
                            long c2 = d.this.b.c();
                            long elapsedRealtime = SystemClock.elapsedRealtime() - d.this.f;
                            int i = d.this.g;
                            sg.bigo.ads.core.d.b.d dVar = new sg.bigo.ads.core.d.b.d("06002002");
                            dVar.a("rslt", str);
                            dVar.a("config_id", c2);
                            dVar.a("cost", elapsedRealtime);
                            if (D) {
                                str = MBridgeConstans.ENDCARD_URL_TYPE_PL;
                            }
                            dVar.a("n_rt", str);
                            dVar.a("src", i);
                            sg.bigo.ads.core.d.a.a(dVar);
                            f.a().a(d.this.b.y());
                            d.this.e = null;
                        }
                    }
                    d.this.a(1005, "Missing `global` or `slots` params.");
                    sg.bigo.ads.core.d.a.a(1005, 10002, "Missing `global` or `slots` params.", d.this.g);
                } catch (JSONException e) {
                    e.printStackTrace();
                    d.this.a(1005, "Failed to parse global config.");
                    sg.bigo.ads.core.d.a.a(1005, 10002, "Failed to parse global config.", d.this.g);
                }
                d.this.e = null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(int i, String str) {
        if (!this.h.isEmpty()) {
            this.h.remove(0).a(i, str);
            if (!this.h.isEmpty()) {
                a(this.g);
            }
        }
    }

    public final void a(a aVar, int i) {
        b bVar = new b(aVar);
        if (this.b.s()) {
            bVar.a();
            if (this.b.r()) {
                a(i);
            }
        } else if (this.b.r()) {
            this.h.add(bVar);
            a(i);
        } else {
            bVar.a();
        }
    }
}
