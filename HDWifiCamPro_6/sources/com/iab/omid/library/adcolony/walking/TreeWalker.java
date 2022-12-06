package com.iab.omid.library.adcolony.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.adcolony.c.a;
import com.iab.omid.library.adcolony.c.b;
import com.iab.omid.library.adcolony.d.d;
import com.iab.omid.library.adcolony.d.f;
import com.iab.omid.library.adcolony.walking.a;
import com.iab.omid.library.adcolony.walking.a.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements a.C0073a {
    private static TreeWalker a = new TreeWalker();
    private static Handler b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler c = null;
    /* access modifiers changed from: private */
    public static final Runnable l = new Runnable() {
        public void run() {
            TreeWalker.getInstance().h();
        }
    };
    /* access modifiers changed from: private */
    public static final Runnable m = new Runnable() {
        public void run() {
            if (TreeWalker.c != null) {
                TreeWalker.c.post(TreeWalker.l);
                TreeWalker.c.postDelayed(TreeWalker.m, 200);
            }
        }
    };
    private List<TreeWalkerTimeLogger> d = new ArrayList();
    private int e;
    private boolean f = false;
    private final List<com.iab.omid.library.adcolony.e.a> g = new ArrayList();
    private b h = new b();
    private a i = new a();
    /* access modifiers changed from: private */
    public b j = new b(new c());
    private long k;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    private void a(long j2) {
        if (this.d.size() > 0) {
            for (TreeWalkerTimeLogger next : this.d) {
                next.onTreeProcessed(this.e, TimeUnit.NANOSECONDS.toMillis(j2));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.e, j2);
                }
            }
        }
    }

    private void a(View view, a aVar, JSONObject jSONObject, c cVar, boolean z) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW, z);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        a b2 = this.h.b();
        String a2 = this.i.a(str);
        if (a2 != null) {
            JSONObject a3 = b2.a(view);
            com.iab.omid.library.adcolony.d.b.a(a3, str);
            com.iab.omid.library.adcolony.d.b.b(a3, a2);
            com.iab.omid.library.adcolony.d.b.a(jSONObject, a3);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        String a2 = this.i.a(view);
        if (a2 == null) {
            return false;
        }
        com.iab.omid.library.adcolony.d.b.a(jSONObject, a2);
        com.iab.omid.library.adcolony.d.b.a(jSONObject, Boolean.valueOf(this.i.d(view)));
        this.i.e();
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        a.C0074a b2 = this.i.b(view);
        if (b2 == null) {
            return false;
        }
        com.iab.omid.library.adcolony.d.b.a(jSONObject, b2);
        return true;
    }

    public static TreeWalker getInstance() {
        return a;
    }

    /* access modifiers changed from: private */
    public void h() {
        i();
        d();
        j();
    }

    private void i() {
        this.e = 0;
        this.g.clear();
        this.f = false;
        Iterator<com.iab.omid.library.adcolony.adsession.a> it = com.iab.omid.library.adcolony.b.a.a().c().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().b()) {
                    this.f = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.k = d.a();
    }

    private void j() {
        a(d.a() - this.k);
    }

    private void k() {
        if (c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            c = handler;
            handler.post(l);
            c.postDelayed(m, 200);
        }
    }

    private void l() {
        Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(m);
            c = null;
        }
    }

    public void a() {
        k();
    }

    public void a(View view, com.iab.omid.library.adcolony.c.a aVar, JSONObject jSONObject, boolean z) {
        c c2;
        if (f.d(view) && (c2 = this.i.c(view)) != c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.iab.omid.library.adcolony.d.b.a(jSONObject, a2);
            if (!a(view, a2)) {
                boolean z2 = z || b(view, a2);
                if (this.f && c2 == c.OBSTRUCTION_VIEW && !z2) {
                    this.g.add(new com.iab.omid.library.adcolony.e.a(view));
                }
                a(view, aVar, a2, c2, z2);
            }
            this.e++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.d.contains(treeWalkerTimeLogger)) {
            this.d.add(treeWalkerTimeLogger);
        }
    }

    public void b() {
        c();
        this.d.clear();
        b.post(new Runnable() {
            public void run() {
                TreeWalker.this.j.a();
            }
        });
    }

    public void c() {
        l();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.i.c();
        long a2 = d.a();
        com.iab.omid.library.adcolony.c.a a3 = this.h.a();
        if (this.i.b().size() > 0) {
            Iterator<String> it = this.i.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a4 = a3.a((View) null);
                a(next, this.i.b(next), a4);
                com.iab.omid.library.adcolony.d.b.a(a4);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.j.b(a4, hashSet, a2);
            }
        }
        if (this.i.a().size() > 0) {
            JSONObject a5 = a3.a((View) null);
            a((View) null, a3, a5, c.PARENT_VIEW, false);
            com.iab.omid.library.adcolony.d.b.a(a5);
            this.j.a(a5, this.i.a(), a2);
            if (this.f) {
                for (com.iab.omid.library.adcolony.adsession.a a6 : com.iab.omid.library.adcolony.b.a.a().c()) {
                    a6.a(this.g);
                }
            }
        } else {
            this.j.a();
        }
        this.i.d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.d.contains(treeWalkerTimeLogger)) {
            this.d.remove(treeWalkerTimeLogger);
        }
    }
}
