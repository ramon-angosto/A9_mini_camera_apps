package com.iab.omid.library.vungle.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.vungle.a.c;
import com.iab.omid.library.vungle.a.d;
import com.iab.omid.library.vungle.a.e;
import com.iab.omid.library.vungle.adsession.a;
import com.iab.omid.library.vungle.b.b;
import com.iab.omid.library.vungle.walking.TreeWalker;

public class f implements c, b.a {
    private static f a;
    private float b = 0.0f;
    private final e c;
    private final com.iab.omid.library.vungle.a.b d;
    private d e;
    private a f;

    public f(e eVar, com.iab.omid.library.vungle.a.b bVar) {
        this.c = eVar;
        this.d = bVar;
    }

    public static f a() {
        if (a == null) {
            a = new f(new e(), new com.iab.omid.library.vungle.a.b());
        }
        return a;
    }

    private a e() {
        if (this.f == null) {
            this.f = a.a();
        }
        return this.f;
    }

    public void a(float f2) {
        this.b = f2;
        for (a adSessionStatePublisher : e().c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().a(f2);
        }
    }

    public void a(Context context) {
        this.e = this.c.a(new Handler(), context, this.d.a(), this);
    }

    public void a(boolean z) {
        if (z) {
            TreeWalker.getInstance().a();
        } else {
            TreeWalker.getInstance().c();
        }
    }

    public void b() {
        b.a().a((b.a) this);
        b.a().b();
        TreeWalker.getInstance().a();
        this.e.a();
    }

    public void c() {
        TreeWalker.getInstance().b();
        b.a().c();
        this.e.b();
    }

    public float d() {
        return this.b;
    }
}
