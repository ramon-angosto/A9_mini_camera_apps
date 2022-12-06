package com.iab.omid.library.bigosg.h;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.bigosg.d.a;
import com.iab.omid.library.bigosg.d.b;
import com.iab.omid.library.bigosg.d.d;
import com.iab.omid.library.bigosg.e.e;
import com.iab.omid.library.bigosg.h.a.c;
import com.iab.omid.library.bigosg.h.a.f;
import com.iab.omid.library.bigosg.h.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class a implements a.C0076a {
    public static Handler a = new Handler(Looper.getMainLooper());
    private static a c = new a();
    /* access modifiers changed from: private */
    public static Handler d = null;
    /* access modifiers changed from: private */
    public static final Runnable j = new Runnable() {
        public final void run() {
            a.b(a.a());
        }
    };
    /* access modifiers changed from: private */
    public static final Runnable k = new Runnable() {
        public final void run() {
            if (a.d != null) {
                a.d.post(a.j);
                a.d.postDelayed(a.k, 200);
            }
        }
    };
    public List<Object> b = new ArrayList();
    private int e;
    private b f = new b();
    private b g = new b();
    /* access modifiers changed from: private */
    public c h = new c(new c());
    private long i;

    a() {
    }

    public static a a() {
        return c;
    }

    private void a(long j2) {
        if (this.b.size() > 0) {
            Iterator<Object> it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
                TimeUnit.NANOSECONDS.toMillis(j2);
            }
        }
    }

    private void a(View view, com.iab.omid.library.bigosg.d.a aVar, JSONObject jSONObject, int i2) {
        aVar.a(view, jSONObject, this, i2 == d.a);
    }

    public static void b() {
        if (d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            d = handler;
            handler.post(j);
            d.postDelayed(k, 200);
        }
    }

    static /* synthetic */ void b(a aVar) {
        String str;
        aVar.e = 0;
        aVar.i = System.nanoTime();
        b bVar = aVar.g;
        com.iab.omid.library.bigosg.c.a a2 = com.iab.omid.library.bigosg.c.a.a();
        if (a2 != null) {
            for (T t : Collections.unmodifiableCollection(a2.b)) {
                View e2 = t.e();
                if (t.f()) {
                    String str2 = t.f;
                    if (e2 != null) {
                        if (!e2.hasWindowFocus()) {
                            str = "noWindowFocus";
                        } else {
                            HashSet hashSet = new HashSet();
                            View view = e2;
                            while (true) {
                                if (view == null) {
                                    bVar.d.addAll(hashSet);
                                    str = null;
                                    break;
                                }
                                String c2 = e.c(view);
                                if (c2 != null) {
                                    str = c2;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        }
                        if (str == null) {
                            bVar.e.add(str2);
                            bVar.a.put(e2, str2);
                            bVar.a(t);
                        } else {
                            bVar.f.add(str2);
                            bVar.c.put(str2, e2);
                            bVar.g.put(str2, str);
                        }
                    } else {
                        bVar.f.add(str2);
                        bVar.g.put(str2, "noAdView");
                    }
                }
            }
        }
        long nanoTime = System.nanoTime();
        com.iab.omid.library.bigosg.d.c cVar = aVar.f.b;
        if (aVar.g.f.size() > 0) {
            Iterator<String> it = aVar.g.f.iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = cVar.a((View) null);
                View view2 = aVar.g.c.get(next);
                d dVar = aVar.f.a;
                String str3 = aVar.g.g.get(next);
                if (str3 != null) {
                    JSONObject a4 = dVar.a(view2);
                    com.iab.omid.library.bigosg.e.b.a(a4, next);
                    com.iab.omid.library.bigosg.e.b.b(a4, str3);
                    com.iab.omid.library.bigosg.e.b.a(a3, a4);
                }
                com.iab.omid.library.bigosg.e.b.a(a3);
                HashSet hashSet2 = new HashSet();
                hashSet2.add(next);
                c cVar2 = aVar.h;
                cVar2.a.a(new com.iab.omid.library.bigosg.h.a.e(cVar2, hashSet2, a3, nanoTime));
            }
        }
        if (aVar.g.e.size() > 0) {
            JSONObject a5 = cVar.a((View) null);
            aVar.a((View) null, cVar, a5, d.a);
            com.iab.omid.library.bigosg.e.b.a(a5);
            c cVar3 = aVar.h;
            cVar3.a.a(new f(cVar3, aVar.g.e, a5, nanoTime));
        } else {
            aVar.h.b();
        }
        b bVar2 = aVar.g;
        bVar2.a.clear();
        bVar2.b.clear();
        bVar2.c.clear();
        bVar2.d.clear();
        bVar2.e.clear();
        bVar2.f.clear();
        bVar2.g.clear();
        bVar2.h = false;
        aVar.a(System.nanoTime() - aVar.i);
    }

    public static void c() {
        Handler handler = d;
        if (handler != null) {
            handler.removeCallbacks(k);
            d = null;
        }
    }

    public final void a(View view, com.iab.omid.library.bigosg.d.a aVar, JSONObject jSONObject) {
        String str;
        boolean z = false;
        if (e.c(view) == null) {
            b bVar = this.g;
            int i2 = bVar.d.contains(view) ? d.a : bVar.h ? d.b : d.c;
            if (i2 != d.c) {
                JSONObject a2 = aVar.a(view);
                com.iab.omid.library.bigosg.e.b.a(jSONObject, a2);
                b bVar2 = this.g;
                if (bVar2.a.size() == 0) {
                    str = null;
                } else {
                    String str2 = bVar2.a.get(view);
                    if (str2 != null) {
                        bVar2.a.remove(view);
                    }
                    str = str2;
                }
                if (str != null) {
                    com.iab.omid.library.bigosg.e.b.a(a2, str);
                    this.g.h = true;
                    z = true;
                }
                if (!z) {
                    b bVar3 = this.g;
                    b.a aVar2 = bVar3.b.get(view);
                    if (aVar2 != null) {
                        bVar3.b.remove(view);
                    }
                    if (aVar2 != null) {
                        com.iab.omid.library.bigosg.e.b.a(a2, aVar2);
                    }
                    a(view, aVar, a2, i2);
                }
                this.e++;
            }
        }
    }
}
