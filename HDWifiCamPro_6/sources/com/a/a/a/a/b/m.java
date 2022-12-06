package com.a.a.a.a.b;

import android.view.View;
import com.a.a.a.a.c.c;
import com.a.a.a.a.c.f;
import com.a.a.a.a.e.e;
import com.a.a.a.a.f.a;
import com.a.a.a.a.g.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class m extends b {
    private static final Pattern a = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final d b;
    private final c c;
    private final List<c> d = new ArrayList();
    private a e;
    private com.a.a.a.a.g.a f;
    private boolean g = false;
    private boolean h = false;
    private final String i;
    private boolean j;
    private boolean k;
    private k l;

    m(c cVar, d dVar) {
        this.c = cVar;
        this.b = dVar;
        this.i = UUID.randomUUID().toString();
        d((View) null);
        this.f = (dVar.h() == e.HTML || dVar.h() == e.JAVASCRIPT) ? new b(dVar.d()) : new com.a.a.a.a.g.c(dVar.c(), dVar.g());
        this.f.a();
        com.a.a.a.a.c.a.a().a(this);
        this.f.a(cVar);
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private c b(View view) {
        for (c next : this.d) {
            if (next.a().get() == view) {
                return next;
            }
        }
        return null;
    }

    private static void c(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void d(View view) {
        this.e = new a(view);
    }

    private void e(View view) {
        Collection<m> b2 = com.a.a.a.a.c.a.a().b();
        if (b2 != null && !b2.isEmpty()) {
            for (m next : b2) {
                if (next != this && next.j() == view) {
                    next.e.clear();
                }
            }
        }
    }

    private void p() {
        if (this.j) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void q() {
        if (this.k) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public void a() {
        if (!this.g) {
            this.g = true;
            com.a.a.a.a.c.a.a().b(this);
            this.f.a(f.a().d());
            this.f.a(this, this.b);
        }
    }

    public void a(View view) {
        if (!this.h) {
            e.a((Object) view, "AdView is null");
            if (j() != view) {
                d(view);
                i().j();
                e(view);
            }
        }
    }

    public void a(View view, g gVar, String str) {
        if (!this.h) {
            c(view);
            a(str);
            if (b(view) == null) {
                this.d.add(new c(view, gVar, str));
            }
        }
    }

    public void a(List<a> list) {
        if (f()) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : list) {
                View view = (View) aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.l.a(this.i, arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        q();
        i().a(jSONObject);
        this.k = true;
    }

    public void b() {
        if (!this.h) {
            this.e.clear();
            d();
            this.h = true;
            i().g();
            com.a.a.a.a.c.a.a().c(this);
            i().b();
            this.f = null;
            this.l = null;
        }
    }

    public String c() {
        return this.i;
    }

    public void d() {
        if (!this.h) {
            this.d.clear();
        }
    }

    public List<c> e() {
        return this.d;
    }

    public boolean f() {
        return this.l != null;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        p();
        i().h();
        this.j = true;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        q();
        i().i();
        this.k = true;
    }

    public com.a.a.a.a.g.a i() {
        return this.f;
    }

    public View j() {
        return (View) this.e.get();
    }

    public boolean k() {
        return this.g && !this.h;
    }

    public boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.h;
    }

    public boolean n() {
        return this.c.a();
    }

    public boolean o() {
        return this.c.b();
    }
}
