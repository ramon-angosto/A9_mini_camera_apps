package com.a.a.a.a.c;

import com.a.a.a.a.b.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a {
    private static a a = new a();
    private final ArrayList<m> b = new ArrayList<>();
    private final ArrayList<m> c = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return a;
    }

    public void a(m mVar) {
        this.b.add(mVar);
    }

    public Collection<m> b() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void b(m mVar) {
        boolean d = d();
        this.c.add(mVar);
        if (!d) {
            f.a().b();
        }
    }

    public Collection<m> c() {
        return Collections.unmodifiableCollection(this.c);
    }

    public void c(m mVar) {
        boolean d = d();
        this.b.remove(mVar);
        this.c.remove(mVar);
        if (d && !d()) {
            f.a().c();
        }
    }

    public boolean d() {
        return this.c.size() > 0;
    }
}
