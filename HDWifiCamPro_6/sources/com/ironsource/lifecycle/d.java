package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.ironsource.environment.e.c;
import com.ironsource.lifecycle.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d implements Application.ActivityLifecycleCallbacks {
    static AtomicBoolean a = new AtomicBoolean(false);
    private static d j = new d();
    int b = 0;
    int c = 0;
    boolean d = true;
    boolean e = true;
    int f = e.a;
    /* access modifiers changed from: package-private */
    public List<c> g = new CopyOnWriteArrayList();
    Runnable h = new Runnable() {
        public final void run() {
            d.a(d.this);
            d.this.c();
        }
    };
    private String i = "IronsourceLifecycleManager";
    private b.a k = new b.a() {
        public final void a(Activity activity) {
            d dVar = d.this;
            dVar.b++;
            if (dVar.b == 1 && dVar.e) {
                c.a.c(new Runnable() {
                    public final void run() {
                        for (c a2 : d.this.g) {
                            a2.a();
                        }
                    }
                });
                dVar.e = false;
                dVar.f = e.b;
            }
        }

        public final void b(Activity activity) {
            d dVar = d.this;
            dVar.c++;
            if (dVar.c != 1) {
                return;
            }
            if (dVar.d) {
                c.a.c(new Runnable() {
                    public final void run() {
                        Iterator it = d.this.g.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                });
                dVar.d = false;
                dVar.f = e.c;
                return;
            }
            c cVar = c.a;
            c.b(dVar.h);
        }
    };

    public static d a() {
        return j;
    }

    static /* synthetic */ void a(d dVar) {
        if (dVar.c == 0) {
            dVar.d = true;
            c.a.c(new Runnable() {
                public final void run() {
                    Iterator it = d.this.g.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
            dVar.f = e.d;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.b == 0 && this.d) {
            c.a.c(new Runnable() {
                public final void run() {
                    for (c b : d.this.g) {
                        b.b();
                    }
                }
            });
            this.e = true;
            this.f = e.e;
        }
    }

    public final void a(c cVar) {
        if (IronsourceLifecycleProvider.a() && !this.g.contains(cVar)) {
            this.g.add(cVar);
        }
    }

    public final boolean b() {
        return this.f == e.e;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        b.b(activity);
        b a2 = b.a(activity);
        if (a2 != null) {
            a2.a = this.k;
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        this.c--;
        if (this.c == 0) {
            c cVar = c.a;
            c.a(this.h, 700);
        }
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.b--;
        c();
    }
}
