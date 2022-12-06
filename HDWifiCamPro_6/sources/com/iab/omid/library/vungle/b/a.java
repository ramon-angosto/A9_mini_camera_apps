package com.iab.omid.library.vungle.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a {
    private static a a = new a();
    private final ArrayList<com.iab.omid.library.vungle.adsession.a> b = new ArrayList<>();
    private final ArrayList<com.iab.omid.library.vungle.adsession.a> c = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return a;
    }

    public void a(com.iab.omid.library.vungle.adsession.a aVar) {
        this.b.add(aVar);
    }

    public Collection<com.iab.omid.library.vungle.adsession.a> b() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void b(com.iab.omid.library.vungle.adsession.a aVar) {
        boolean d = d();
        this.c.add(aVar);
        if (!d) {
            f.a().b();
        }
    }

    public Collection<com.iab.omid.library.vungle.adsession.a> c() {
        return Collections.unmodifiableCollection(this.c);
    }

    public void c(com.iab.omid.library.vungle.adsession.a aVar) {
        boolean d = d();
        this.b.remove(aVar);
        this.c.remove(aVar);
        if (d && !d()) {
            f.a().c();
        }
    }

    public boolean d() {
        return this.c.size() > 0;
    }
}
