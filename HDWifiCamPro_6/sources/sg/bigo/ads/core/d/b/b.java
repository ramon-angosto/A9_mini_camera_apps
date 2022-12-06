package sg.bigo.ads.core.d.b;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.p.c;
import sg.bigo.ads.core.d.a.a;
import sg.bigo.ads.core.d.c.a;

public final class b {
    final a a;
    a.b b = null;
    public final c c;
    final e d;
    private final f e;

    public b(sg.bigo.ads.core.d.a.a aVar, f fVar, e eVar) {
        this.c = new c(aVar);
        this.a = aVar;
        this.e = fVar;
        this.d = eVar;
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.c.b() >= bVar.a.a) {
            bVar.a();
        } else {
            bVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        sg.bigo.ads.core.d.c.a.a(this.b);
        this.b = null;
        final List<sg.bigo.ads.common.c.b.b> a2 = this.c.a();
        if (a2.isEmpty()) {
            sg.bigo.ads.common.k.a.b("Stats", "sendGeneralStats but event list is empty!!");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (sg.bigo.ads.common.c.b.b next : a2) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_id", next.b);
                jSONObject.put("event_info", next.c);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_events", jSONArray);
        this.e.a(hashMap, new f.a() {
            public final void a(int i, int i2, String str) {
                sg.bigo.ads.core.d.c.a.a((Runnable) new Runnable() {
                    public final void run() {
                        b.this.c.a(a2, false);
                        b.this.b();
                    }
                });
            }

            public final void a(String str) {
                sg.bigo.ads.core.d.c.a.a((Runnable) new Runnable() {
                    public final void run() {
                        b.this.c.a(a2, true);
                        b.this.c.d();
                        b.this.b();
                    }
                });
            }
        });
    }

    public final void a(final String str, final Map<String, String> map) {
        sg.bigo.ads.core.d.c.a.a((Runnable) new Runnable() {
            public final void run() {
                a.C0136a aVar = b.this.a.c.get(str);
                boolean z = aVar == null ? true : aVar.c;
                a.C0136a aVar2 = b.this.a.c.get(str);
                long currentTimeMillis = ((long) (aVar2 == null ? 3600000 : aVar2.d)) + System.currentTimeMillis();
                a aVar3 = new a(str, map);
                b.this.c.a(new sg.bigo.ads.common.c.b.b(aVar3.a, aVar3.a(b.this.d).toString(), currentTimeMillis));
                if (z) {
                    sg.bigo.ads.common.k.a.a(0, 3, "Stats", "SendDefer -> eventId=" + str + ", events=" + map);
                    b.a(b.this);
                    return;
                }
                sg.bigo.ads.common.k.a.a(0, 3, "Stats", "SendImmediately -> eventId=" + str + ", events=" + map);
                b.this.a();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.b == null) {
            if (this.c.c()) {
                sg.bigo.ads.common.k.a.a(0, 3, "Stats", "no events waitting for sending");
            } else {
                this.b = sg.bigo.ads.core.d.c.a.a(new Runnable() {
                    public final void run() {
                        if (c.c(sg.bigo.ads.common.b.a.a)) {
                            b.this.a();
                            return;
                        }
                        b bVar = b.this;
                        bVar.b = null;
                        bVar.b();
                    }
                }, (long) this.a.b);
            }
        }
    }
}
