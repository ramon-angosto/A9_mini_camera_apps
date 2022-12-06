package com.iab.omid.library.bigosg.c;

import com.iab.omid.library.bigosg.a.c;
import com.iab.omid.library.bigosg.a.d;
import com.iab.omid.library.bigosg.a.e;
import com.iab.omid.library.bigosg.c.b;
import com.iab.omid.library.bigosg.h.a;
import java.util.Collections;

public final class f implements c, b.a {
    private static f c;
    public float a = 0.0f;
    public d b;
    private final e d;
    private final com.iab.omid.library.bigosg.a.b e;
    private a f;

    private f(e eVar, com.iab.omid.library.bigosg.a.b bVar) {
        this.d = eVar;
        this.e = bVar;
    }

    public static f a() {
        if (c == null) {
            c = new f(new e(), new com.iab.omid.library.bigosg.a.b());
        }
        return c;
    }

    public final void a(float f2) {
        this.a = f2;
        if (this.f == null) {
            this.f = a.a();
        }
        for (T t : Collections.unmodifiableCollection(this.f.b)) {
            t.c.a(f2);
        }
    }

    public final void a(boolean z) {
        a.a();
        if (z) {
            a.b();
        } else {
            a.c();
        }
    }

    public final void b() {
        b.a().e = this;
        b.a().b();
        if (b.a().c()) {
            a.a();
            a.b();
        }
        this.b.a();
    }
}
