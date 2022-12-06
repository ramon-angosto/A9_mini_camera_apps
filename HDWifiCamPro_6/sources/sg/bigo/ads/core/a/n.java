package sg.bigo.ads.core.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.m;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.r;

public final class n implements Runnable {
    public b a;
    public i b;
    public List<m> c;
    public f d;
    final AtomicBoolean e;

    public static class a {
        /* access modifiers changed from: private */
        public static final n a = new n((byte) 0);
    }

    private n() {
        this.e = new AtomicBoolean(false);
    }

    /* synthetic */ n(byte b2) {
        this();
    }

    public static n a() {
        return a.a;
    }

    static /* synthetic */ void a(n nVar) {
        if (nVar.e.compareAndSet(false, true)) {
            c.a(1, nVar);
        }
    }

    static /* synthetic */ void a(n nVar, int i) {
        if (i == -8) {
            nVar.b.e();
            sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) null, 3004, 10109, "Failed to decrypt the report data in server.");
        }
        nVar.e.set(false);
    }

    public final void a(final List<m> list) {
        c.a(1, new Runnable() {
            public final void run() {
                if (!list.isEmpty()) {
                    for (m mVar : list) {
                        mVar.c = 1;
                    }
                    l.a((List<m>) list);
                    n.this.c.addAll(list);
                    n.a(n.this);
                }
            }
        });
    }

    public final void run() {
        if (this.c.isEmpty()) {
            this.e.set(false);
            return;
        }
        d.a(this.c, this.a.c());
        final ArrayList arrayList = new ArrayList(this.c.subList(0, Math.min(20, this.c.size())));
        if (arrayList.isEmpty()) {
            this.e.set(false);
            return;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "AppCheckReport", "Start report apps, size = " + arrayList.size());
        final String jSONArray = d.a(arrayList).toString();
        if (o.b(jSONArray)) {
            this.e.set(false);
            return;
        }
        String a2 = m.a(jSONArray, this.b.d());
        if (o.b(a2)) {
            this.e.set(false);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cur_index", Integer.valueOf(this.b.c()));
        hashMap.put("apps", a2);
        this.d.a(hashMap, new f.a() {
            public final void a(int i, int i2, String str) {
                sg.bigo.ads.common.k.a.a(0, "AppCheckReport", "Fail to report apps: ".concat(String.valueOf(str)));
                n.a(n.this, i2);
            }

            public final void a(String str) {
                r.a();
                c.a(1, new Runnable(arrayList) {
                    public final void run() {
                        l.b((List<m>) r2);
                        n.this.c.removeAll(r2);
                        n.this.e.set(false);
                        n.a(n.this);
                    }
                });
                if (!o.b(str)) {
                    String b2 = m.b(str, n.this.b.d());
                    if (!o.b(b2)) {
                        try {
                            sg.bigo.ads.common.k.a.a(0, 3, "AppCheckReport", "Response data after report apps: ".concat(String.valueOf(b2)));
                            JSONObject jSONObject = new JSONObject(b2);
                            n.this.b.a(jSONObject.optInt("next_index"), jSONObject.optString("next_key"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
