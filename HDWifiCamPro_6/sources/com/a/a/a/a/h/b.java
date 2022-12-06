package com.a.a.a.a.h;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.a.a.a.a.b.m;
import com.a.a.a.a.c.c;
import com.a.a.a.a.e.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class b {
    private final HashMap<View, String> a = new HashMap<>();
    private final HashMap<View, a> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();
    private final HashSet<View> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private final HashSet<String> f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final Map<View, Boolean> h = new WeakHashMap();
    private boolean i;

    public static class a {
        private final c a;
        private final ArrayList<String> b = new ArrayList<>();

        public a(c cVar, String str) {
            this.a = cVar;
            a(str);
        }

        public c a() {
            return this.a;
        }

        public void a(String str) {
            this.b.add(str);
        }

        public ArrayList<String> b() {
            return this.b;
        }
    }

    private void a(m mVar) {
        for (c a2 : mVar.e()) {
            a(a2, mVar);
        }
    }

    private void a(c cVar, m mVar) {
        View view = (View) cVar.a().get();
        if (view != null) {
            a aVar = this.b.get(view);
            if (aVar != null) {
                aVar.a(mVar.c());
            } else {
                this.b.put(view, new a(cVar, mVar.c()));
            }
        }
    }

    private String e(View view) {
        if (Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (f(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e2 = f.e(view);
            if (e2 != null) {
                return e2;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.d.addAll(hashSet);
        return null;
    }

    private Boolean f(View view) {
        if (view.hasWindowFocus()) {
            this.h.remove(view);
            return false;
        } else if (this.h.containsKey(view)) {
            return this.h.get(view);
        } else {
            this.h.put(view, false);
            return false;
        }
    }

    public String a(View view) {
        if (this.a.size() == 0) {
            return null;
        }
        String str = this.a.get(view);
        if (str != null) {
            this.a.remove(view);
        }
        return str;
    }

    public String a(String str) {
        return this.g.get(str);
    }

    public HashSet<String> a() {
        return this.e;
    }

    public View b(String str) {
        return this.c.get(str);
    }

    public a b(View view) {
        a aVar = this.b.get(view);
        if (aVar != null) {
            this.b.remove(view);
        }
        return aVar;
    }

    public HashSet<String> b() {
        return this.f;
    }

    public d c(View view) {
        return this.d.contains(view) ? d.PARENT_VIEW : this.i ? d.OBSTRUCTION_VIEW : d.UNDERLYING_VIEW;
    }

    public void c() {
        com.a.a.a.a.c.a a2 = com.a.a.a.a.c.a.a();
        if (a2 != null) {
            for (m next : a2.c()) {
                View j = next.j();
                if (next.k()) {
                    String c2 = next.c();
                    if (j != null) {
                        String e2 = e(j);
                        if (e2 == null) {
                            this.e.add(c2);
                            this.a.put(j, c2);
                            a(next);
                        } else if (e2 != "noWindowFocus") {
                            this.f.add(c2);
                            this.c.put(c2, j);
                            this.g.put(c2, e2);
                        }
                    } else {
                        this.f.add(c2);
                        this.g.put(c2, "noAdView");
                    }
                }
            }
        }
    }

    public void d() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.i = false;
    }

    public boolean d(View view) {
        if (!this.h.containsKey(view)) {
            return true;
        }
        this.h.put(view, true);
        return false;
    }

    public void e() {
        this.i = true;
    }
}
