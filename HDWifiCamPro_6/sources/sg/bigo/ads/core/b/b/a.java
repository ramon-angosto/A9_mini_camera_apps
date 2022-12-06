package sg.bigo.ads.core.b.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.p.c;
import sg.bigo.ads.core.b.c.b;

public final class a {
    b.C0134b a = null;
    public final b b;
    final e c;
    private final sg.bigo.ads.core.b.a.a d;
    private final f e;

    public a(sg.bigo.ads.core.b.a.a aVar, f fVar, e eVar) {
        this.b = new b(aVar);
        this.d = aVar;
        this.e = fVar;
        this.c = eVar;
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.b.c() >= aVar.d.a) {
            aVar.a();
        } else if (!aVar.b.d()) {
            aVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        b.a(this.a);
        this.a = null;
        final List<sg.bigo.ads.common.c.b.a> b2 = this.b.b();
        if (b2.isEmpty()) {
            sg.bigo.ads.common.k.a.b("Callback", "sendGeneralStats but event list is empty!!");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (sg.bigo.ads.common.c.b.a aVar : b2) {
            try {
                jSONArray.put(new JSONObject(aVar.c));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("events", jSONArray);
        this.e.a(hashMap, new f.a() {
            public final void a(int i, int i2, String str) {
                b.a((Runnable) new Runnable() {
                    public final void run() {
                        a.this.b.a(b2, false);
                        a.this.b();
                    }
                });
            }

            public final void a(String str) {
                b.a((Runnable) new Runnable() {
                    public final void run() {
                        a.this.b.a(b2, true);
                        a.this.b.e();
                        if (!a.this.b.d()) {
                            a.this.b();
                        }
                    }
                });
            }
        });
    }

    public final void a(final String str, final JSONObject jSONObject) {
        b.a((Runnable) new Runnable() {
            public final void run() {
                sg.bigo.ads.common.c.b.a aVar = new sg.bigo.ads.common.c.b.a(str, jSONObject.toString());
                a.this.b.a(aVar);
                if (!TextUtils.isEmpty(a.this.c.P())) {
                    if (!"impression".equals(str) && !"clicked".equals(str)) {
                        sg.bigo.ads.common.k.a.a(0, 3, "Callback", "SendDefer -> action=" + str + ", eventInfo=" + aVar.toString());
                        a.a(a.this);
                        return;
                    }
                    sg.bigo.ads.common.k.a.a(0, 3, "Callback", "SendImmediately -> action=" + str + ", eventInfo=" + aVar.toString());
                    a.this.a();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.a == null) {
            this.a = b.a(new Runnable() {
                public final void run() {
                    if (c.c(sg.bigo.ads.common.b.a.a)) {
                        a.this.a();
                        return;
                    }
                    a aVar = a.this;
                    aVar.a = null;
                    aVar.b();
                }
            }, (long) this.d.b);
        }
    }
}
