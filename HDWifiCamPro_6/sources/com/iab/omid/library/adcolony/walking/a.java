package com.iab.omid.library.adcolony.walking;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.adcolony.b.c;
import com.iab.omid.library.adcolony.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class a {
    private final HashMap<View, String> a = new HashMap<>();
    private final HashMap<View, C0074a> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();
    private final HashSet<View> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private final HashSet<String> f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final Map<View, Boolean> h = new WeakHashMap();
    private boolean i;

    /* renamed from: com.iab.omid.library.adcolony.walking.a$a  reason: collision with other inner class name */
    public static class C0074a {
        private final c a;
        private final ArrayList<String> b = new ArrayList<>();

        public C0074a(c cVar, String str) {
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

    private void a(com.iab.omid.library.adcolony.adsession.a aVar) {
        for (c a2 : aVar.a()) {
            a(a2, aVar);
        }
    }

    private void a(c cVar, com.iab.omid.library.adcolony.adsession.a aVar) {
        View view = (View) cVar.a().get();
        if (view != null) {
            C0074a aVar2 = this.b.get(view);
            if (aVar2 != null) {
                aVar2.a(aVar.getAdSessionId());
            } else {
                this.b.put(view, new C0074a(cVar, aVar.getAdSessionId()));
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
            return Boolean.FALSE;
        } else if (this.h.containsKey(view)) {
            return this.h.get(view);
        } else {
            Map<View, Boolean> map = this.h;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
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

    public C0074a b(View view) {
        C0074a aVar = this.b.get(view);
        if (aVar != null) {
            this.b.remove(view);
        }
        return aVar;
    }

    public HashSet<String> b() {
        return this.f;
    }

    public c c(View view) {
        return this.d.contains(view) ? c.PARENT_VIEW : this.i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void c() {
        com.iab.omid.library.adcolony.b.a a2 = com.iab.omid.library.adcolony.b.a.a();
        if (a2 != null) {
            for (com.iab.omid.library.adcolony.adsession.a next : a2.c()) {
                View e2 = next.e();
                if (next.f()) {
                    String adSessionId = next.getAdSessionId();
                    if (e2 != null) {
                        String e3 = e(e2);
                        if (e3 == null) {
                            this.e.add(adSessionId);
                            this.a.put(e2, adSessionId);
                            a(next);
                        } else if (e3 != "noWindowFocus") {
                            this.f.add(adSessionId);
                            this.c.put(adSessionId, e2);
                            this.g.put(adSessionId, e3);
                        }
                    } else {
                        this.f.add(adSessionId);
                        this.g.put(adSessionId, "noAdView");
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
        this.h.put(view, Boolean.TRUE);
        return false;
    }

    public void e() {
        this.i = true;
    }
}
