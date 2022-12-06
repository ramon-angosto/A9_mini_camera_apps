package com.a.a.a.a.h;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.a.a.a.a.b.m;
import com.a.a.a.a.d.a;
import com.a.a.a.a.e.d;
import com.a.a.a.a.e.f;
import com.a.a.a.a.h.a.c;
import com.a.a.a.a.h.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class a implements a.C0000a {
    private static a a = new a();
    private static Handler b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler c = null;
    /* access modifiers changed from: private */
    public static final Runnable l = new Runnable() {
        public void run() {
            a.a().i();
        }
    };
    /* access modifiers changed from: private */
    public static final Runnable m = new Runnable() {
        public void run() {
            if (a.c != null) {
                a.c.post(a.l);
                a.c.postDelayed(a.m, 200);
            }
        }
    };
    private List<b> d = new ArrayList();
    private int e;
    private boolean f = false;
    private final List<com.a.a.a.a.f.a> g = new ArrayList();
    private com.a.a.a.a.d.b h = new com.a.a.a.a.d.b();
    private b i = new b();
    /* access modifiers changed from: private */
    public c j = new c(new c());
    private long k;

    /* renamed from: com.a.a.a.a.h.a$a  reason: collision with other inner class name */
    public interface C0002a extends b {
        void a(int i, long j);
    }

    public interface b {
        void b(int i, long j);
    }

    a() {
    }

    public static a a() {
        return a;
    }

    private void a(long j2) {
        if (this.d.size() > 0) {
            for (b next : this.d) {
                next.b(this.e, TimeUnit.NANOSECONDS.toMillis(j2));
                if (next instanceof C0002a) {
                    ((C0002a) next).a(this.e, j2);
                }
            }
        }
    }

    private void a(View view, com.a.a.a.a.d.a aVar, JSONObject jSONObject, d dVar, boolean z) {
        aVar.a(view, jSONObject, this, dVar == d.PARENT_VIEW, z);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.a.a.a.a.d.a b2 = this.h.b();
        String a2 = this.i.a(str);
        if (a2 != null) {
            JSONObject a3 = b2.a(view);
            com.a.a.a.a.e.b.a(a3, str);
            com.a.a.a.a.e.b.b(a3, a2);
            com.a.a.a.a.e.b.a(jSONObject, a3);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        String a2 = this.i.a(view);
        if (a2 == null) {
            return false;
        }
        com.a.a.a.a.e.b.a(jSONObject, a2);
        com.a.a.a.a.e.b.a(jSONObject, Boolean.valueOf(this.i.d(view)));
        this.i.e();
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        b.a b2 = this.i.b(view);
        if (b2 == null) {
            return false;
        }
        com.a.a.a.a.e.b.a(jSONObject, b2);
        return true;
    }

    /* access modifiers changed from: private */
    public void i() {
        j();
        e();
        k();
    }

    private void j() {
        this.e = 0;
        this.g.clear();
        this.f = false;
        Iterator<m> it = com.a.a.a.a.c.a.a().c().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().f()) {
                    this.f = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.k = d.a();
    }

    private void k() {
        a(d.a() - this.k);
    }

    private void l() {
        if (c == null) {
            c = new Handler(Looper.getMainLooper());
            c.post(l);
            c.postDelayed(m, 200);
        }
    }

    private void m() {
        Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(m);
            c = null;
        }
    }

    public void a(View view, com.a.a.a.a.d.a aVar, JSONObject jSONObject, boolean z) {
        d c2;
        if (f.d(view) && (c2 = this.i.c(view)) != d.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.a.a.a.a.e.b.a(jSONObject, a2);
            if (!a(view, a2)) {
                boolean z2 = z || b(view, a2);
                if (this.f && c2 == d.OBSTRUCTION_VIEW && !z2) {
                    this.g.add(new com.a.a.a.a.f.a(view));
                }
                a(view, aVar, a2, c2, z2);
            }
            this.e++;
        }
    }

    public void b() {
        l();
    }

    public void c() {
        d();
        this.d.clear();
        b.post(new Runnable() {
            public void run() {
                a.this.j.b();
            }
        });
    }

    public void d() {
        m();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.i.c();
        long a2 = d.a();
        com.a.a.a.a.d.a a3 = this.h.a();
        if (this.i.b().size() > 0) {
            Iterator<String> it = this.i.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a4 = a3.a((View) null);
                a(next, this.i.b(next), a4);
                com.a.a.a.a.e.b.a(a4);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.j.b(a4, hashSet, a2);
            }
        }
        if (this.i.a().size() > 0) {
            JSONObject a5 = a3.a((View) null);
            a((View) null, a3, a5, d.PARENT_VIEW, false);
            com.a.a.a.a.e.b.a(a5);
            this.j.a(a5, this.i.a(), a2);
            if (this.f) {
                for (m a6 : com.a.a.a.a.c.a.a().c()) {
                    a6.a(this.g);
                }
            }
        } else {
            this.j.b();
        }
        this.i.d();
    }
}
