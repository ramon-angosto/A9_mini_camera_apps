package sg.bigo.ads.core.e.a;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.c.b.c;
import sg.bigo.ads.core.e.a;

public final class e extends c {
    public int i = 0;
    public long j = 0;
    public int k = 0;
    public long l = 0;
    public int m = 0;
    public long n = 0;
    public int o = 0;
    public long p = 0;
    /* access modifiers changed from: package-private */
    public final o q;
    public CopyOnWriteArrayList<d> r;
    public CopyOnWriteArrayList<d> s;
    public CopyOnWriteArrayList<d> t;
    public CopyOnWriteArrayList<d> u;

    public e(o oVar, Cursor cursor) {
        super(cursor);
        this.q = oVar;
        this.c = 1;
    }

    public e(o oVar, Map<String, String> map) {
        super(map);
        this.q = oVar;
        this.c = 1;
    }

    private void a(final String str, final d dVar) {
        String str2 = dVar.b;
        if (!dVar.b()) {
            int i2 = this.i;
            if ("click_track".equals(str)) {
                i2 = this.k;
            } else if ("nurl_track".equals(str)) {
                i2 = this.m;
            } else if ("lurl_track".equals(str)) {
                i2 = this.o;
            }
            int i3 = i2;
            String d = dVar.d();
            dVar.a();
            a.a(str, d, str2, this.b, i3, this.h, new a.C0138a() {
                public final void a() {
                    c.a().b(e.this);
                }

                public final boolean a(int i) {
                    return e.this.q.a(i);
                }

                public final void b() {
                    CopyOnWriteArrayList<d> copyOnWriteArrayList;
                    if ("impl_track".equals(str)) {
                        copyOnWriteArrayList = e.this.r;
                    } else if ("click_track".equals(str)) {
                        copyOnWriteArrayList = e.this.s;
                    } else if ("nurl_track".equals(str)) {
                        copyOnWriteArrayList = e.this.t;
                    } else {
                        if ("lurl_track".equals(str)) {
                            copyOnWriteArrayList = e.this.u;
                        }
                        c.a().b(e.this);
                    }
                    copyOnWriteArrayList.remove(dVar);
                    c.a().b(e.this);
                }
            });
        } else if ("impl_track".equals(str)) {
            this.r.remove(dVar);
        } else if ("click_track".equals(str)) {
            this.s.remove(dVar);
        } else if ("nurl_track".equals(str)) {
            this.t.remove(dVar);
        } else if ("lurl_track".equals(str)) {
            this.u.remove(dVar);
        }
    }

    private static boolean a(List<d> list) {
        return list != null && list.size() == 0;
    }

    public final void a(String str) {
        if (!sg.bigo.ads.common.utils.o.b(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.r = new CopyOnWriteArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.r.add(new d(jSONArray.getJSONObject(i2)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        return this.q.b(i2);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(List<d> list, int i2) {
        return list == null || list.size() == 0 || !a(i2);
    }

    public final String b() {
        if (this.r == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.r.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().c);
        }
        return jSONArray.toString();
    }

    public final void b(String str) {
        if (!sg.bigo.ads.common.utils.o.b(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.s = new CopyOnWriteArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.s.add(new d(jSONArray.getJSONObject(i2)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final String c() {
        if (this.s == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.s.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().c);
        }
        return jSONArray.toString();
    }

    public final void c(String str) {
        if (!sg.bigo.ads.common.utils.o.b(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.t = new CopyOnWriteArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.t.add(new d(jSONArray.getJSONObject(i2)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final String d() {
        if (this.t == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.t.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().c);
        }
        return jSONArray.toString();
    }

    public final void d(String str) {
        if (!sg.bigo.ads.common.utils.o.b(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.u = new CopyOnWriteArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.u.add(new d(jSONArray.getJSONObject(i2)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final String e() {
        if (this.u == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.u.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().c);
        }
        return jSONArray.toString();
    }

    public final long f() {
        return Math.max(Math.max(this.j, this.l), this.d);
    }

    public final boolean g() {
        return a((List<d>) this.r) && a((List<d>) this.s) && a((List<d>) this.t) && a((List<d>) this.u);
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        Iterator<d> it = this.r.iterator();
        while (it.hasNext()) {
            a("impl_track", it.next());
        }
    }

    /* access modifiers changed from: package-private */
    public final int i() {
        Iterator<d> it = this.s.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            a("click_track", it.next());
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final int j() {
        Iterator<d> it = this.t.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            a("nurl_track", it.next());
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final int k() {
        Iterator<d> it = this.u.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            a("lurl_track", it.next());
        }
        return i2;
    }
}
