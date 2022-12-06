package com.iab.omid.library.bigosg.b;

import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.bigosg.c.c;
import com.iab.omid.library.bigosg.c.e;
import com.iab.omid.library.bigosg.c.f;
import com.iab.omid.library.bigosg.e.d;
import com.iab.omid.library.bigosg.g.a;
import com.iab.omid.library.bigosg.g.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class l extends b {
    private static final Pattern i = Pattern.compile("^[a-zA-Z0-9 ]+$");
    public final c a;
    public final List<c> b = new ArrayList();
    public a c;
    public boolean d = false;
    public boolean e = false;
    public String f;
    boolean g;
    public boolean h;
    private final d j;
    private com.iab.omid.library.bigosg.f.a k;

    l(c cVar, d dVar) {
        String str;
        Object obj;
        this.a = cVar;
        this.j = dVar;
        this.f = UUID.randomUUID().toString();
        d((View) null);
        this.c = dVar.h == e.HTML ? new b(dVar.b) : new com.iab.omid.library.bigosg.g.c(Collections.unmodifiableMap(dVar.d), dVar.e);
        this.c.a();
        com.iab.omid.library.bigosg.c.a.a().a.add(this);
        a aVar = this.c;
        e a2 = e.a();
        WebView c2 = aVar.c();
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.bigosg.e.b.a(jSONObject, "impressionOwner", cVar.a);
        if (cVar.d == null || cVar.e == null) {
            obj = cVar.b;
            str = "videoEventsOwner";
        } else {
            com.iab.omid.library.bigosg.e.b.a(jSONObject, "mediaEventsOwner", cVar.b);
            com.iab.omid.library.bigosg.e.b.a(jSONObject, "creativeType", cVar.d);
            obj = cVar.e;
            str = "impressionType";
        }
        com.iab.omid.library.bigosg.e.b.a(jSONObject, str, obj);
        com.iab.omid.library.bigosg.e.b.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(cVar.c));
        a2.a(c2, "init", jSONObject);
    }

    private c c(View view) {
        for (c next : this.b) {
            if (next.a.get() == view) {
                return next;
            }
        }
        return null;
    }

    private void d(View view) {
        this.k = new com.iab.omid.library.bigosg.f.a(view);
    }

    public final void a() {
        if (!this.d) {
            this.d = true;
            com.iab.omid.library.bigosg.c.a.a().a(this);
            this.c.a(f.a().a);
            this.c.a(this, this.j);
        }
    }

    public final void a(View view) {
        if (!this.e) {
            d.a((Object) view, "AdView is null");
            if (e() != view) {
                d(view);
                this.c.d();
                Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(com.iab.omid.library.bigosg.c.a.a().a);
                if (unmodifiableCollection != null && unmodifiableCollection.size() > 0) {
                    for (T t : unmodifiableCollection) {
                        if (t != this && t.e() == view) {
                            t.k.clear();
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        if (!this.e) {
            this.k.clear();
            if (!this.e) {
                this.b.clear();
            }
            this.e = true;
            e.a().a(this.c.c(), "finishSession", new Object[0]);
            com.iab.omid.library.bigosg.c.a a2 = com.iab.omid.library.bigosg.c.a.a();
            boolean b2 = a2.b();
            a2.a.remove(this);
            a2.b.remove(this);
            if (b2 && !a2.b()) {
                f a3 = f.a();
                com.iab.omid.library.bigosg.h.a a4 = com.iab.omid.library.bigosg.h.a.a();
                com.iab.omid.library.bigosg.h.a.c();
                a4.b.clear();
                com.iab.omid.library.bigosg.h.a.a.post(new Runnable() {
                    public final void run() {
                        a.this.h.b();
                    }
                });
                com.iab.omid.library.bigosg.c.b a5 = com.iab.omid.library.bigosg.c.b.a();
                if (!(a5.a == null || a5.b == null)) {
                    a5.a.unregisterReceiver(a5.b);
                    a5.b = null;
                }
                a5.c = false;
                a5.d = false;
                a5.e = null;
                com.iab.omid.library.bigosg.a.d dVar = a3.b;
                dVar.a.getContentResolver().unregisterContentObserver(dVar);
            }
            this.c.b();
            this.c = null;
        }
    }

    public final void b(View view) {
        g gVar = g.OTHER;
        if (this.e) {
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        } else if (c(view) == null) {
            this.b.add(new c(view, gVar));
        }
    }

    public final String c() {
        return this.f;
    }

    public final void d() {
        if (this.h) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public final View e() {
        return (View) this.k.get();
    }

    public final boolean f() {
        return this.d && !this.e;
    }

    public final boolean g() {
        return i.NATIVE == this.a.a;
    }
}
