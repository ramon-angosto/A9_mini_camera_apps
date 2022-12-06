package com.bytedance.sdk.component.e.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.a.e;
import com.bytedance.sdk.component.e.a.b.c;
import com.bytedance.sdk.component.e.a.b.d;
import com.bytedance.sdk.component.e.a.e.a;
import com.bytedance.sdk.component.e.a.e.b;
import java.util.List;

/* compiled from: LogInternalManager */
public class i {
    private static volatile a i;
    private static i k;
    private volatile Context a;
    private volatile com.bytedance.sdk.component.e.a.d.b.a b;
    private volatile com.bytedance.sdk.component.e.a.d.b.a c;
    private volatile com.bytedance.sdk.component.e.a.d.b.a d;
    private volatile com.bytedance.sdk.component.e.a.d.b.a e;
    private volatile e f;
    private volatile boolean g;
    private volatile f h;
    private volatile c j;

    public boolean a() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public e b() {
        return this.f;
    }

    public static a c() {
        if (i == null) {
            synchronized (i.class) {
                if (i == null) {
                    i = new b();
                }
            }
        }
        return i;
    }

    public void a(e eVar) {
        this.f = eVar;
    }

    public Context d() {
        return this.a;
    }

    public void a(Context context) {
        this.a = context;
    }

    private i() {
    }

    public static synchronized i e() {
        i iVar;
        synchronized (i.class) {
            if (k == null) {
                k = new i();
            }
            iVar = k;
        }
        return iVar;
    }

    public void a(c cVar) {
        this.j = cVar;
    }

    public c f() {
        return this.j;
    }

    public void g() {
        d.a.b();
    }

    public void h() {
        d.a.c();
    }

    public void a(com.bytedance.sdk.component.e.a.d.a aVar) {
        if (aVar != null) {
            aVar.a(System.currentTimeMillis());
            d.a.a(aVar, (int) aVar.d());
        }
    }

    public void a(String str) {
        com.bytedance.sdk.component.e.a.f.a.a().a(str);
    }

    public void a(String str, List<String> list, boolean z) {
        com.bytedance.sdk.component.e.a.f.a.a().a(str, list, z);
    }

    public void a(com.bytedance.sdk.component.e.a.d.b.a aVar) {
        this.b = aVar;
    }

    public com.bytedance.sdk.component.e.a.d.b.a i() {
        return this.b;
    }

    public void b(com.bytedance.sdk.component.e.a.d.b.a aVar) {
        this.c = aVar;
    }

    public com.bytedance.sdk.component.e.a.d.b.a j() {
        return this.c;
    }

    public void c(com.bytedance.sdk.component.e.a.d.b.a aVar) {
        this.d = aVar;
    }

    public com.bytedance.sdk.component.e.a.d.b.a k() {
        return this.d;
    }

    public com.bytedance.sdk.component.e.a.d.b.a l() {
        return this.e;
    }

    public void d(com.bytedance.sdk.component.e.a.d.b.a aVar) {
        this.e = aVar;
    }

    public void a(f fVar) {
        this.h = fVar;
    }

    public f m() {
        return this.h;
    }
}
