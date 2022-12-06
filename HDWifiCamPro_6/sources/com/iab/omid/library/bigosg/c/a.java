package com.iab.omid.library.bigosg.c;

import com.iab.omid.library.bigosg.b.l;
import java.util.ArrayList;

public final class a {
    private static a c = new a();
    public final ArrayList<l> a = new ArrayList<>();
    public final ArrayList<l> b = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return c;
    }

    public final void a(l lVar) {
        boolean b2 = b();
        this.b.add(lVar);
        if (!b2) {
            f.a().b();
        }
    }

    public final boolean b() {
        return this.b.size() > 0;
    }
}
