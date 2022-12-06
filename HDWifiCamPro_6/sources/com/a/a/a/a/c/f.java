package com.a.a.a.a.c;

import android.content.Context;
import android.os.Handler;
import com.a.a.a.a.a.c;
import com.a.a.a.a.a.d;
import com.a.a.a.a.a.e;
import com.a.a.a.a.b.m;
import com.a.a.a.a.c.b;
import com.a.a.a.a.h.a;

public class f implements c, b.a {
    private static f a;
    private float b = 0.0f;
    private final e c;
    private final com.a.a.a.a.a.b d;
    private d e;
    private a f;

    public f(e eVar, com.a.a.a.a.a.b bVar) {
        this.c = eVar;
        this.d = bVar;
    }

    public static f a() {
        if (a == null) {
            a = new f(new e(), new com.a.a.a.a.a.b());
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
        for (m i : e().c()) {
            i.i().a(f2);
        }
    }

    public void a(Context context) {
        this.e = this.c.a(new Handler(), context, this.d.a(), this);
    }

    public void a(boolean z) {
        if (z) {
            a.a().b();
        } else {
            a.a().d();
        }
    }

    public void b() {
        b.a().a((b.a) this);
        b.a().b();
        a.a().b();
        this.e.a();
    }

    public void c() {
        a.a().c();
        b.a().c();
        this.e.b();
    }

    public float d() {
        return this.b;
    }
}
