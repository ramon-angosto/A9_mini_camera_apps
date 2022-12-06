package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.os.Handler;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.mbbanner.common.a.b;
import com.mbridge.msdk.mbbanner.common.a.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BannerLoadManager */
public class a {
    private static final String a = a.class.getSimpleName();
    private static volatile a h;
    private Context b = com.mbridge.msdk.foundation.controller.a.e().g();
    /* access modifiers changed from: private */
    public com.mbridge.msdk.mbbanner.common.util.a c = new com.mbridge.msdk.mbbanner.common.util.a();
    private Map<String, c> d = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Map<String, Boolean> e = new ConcurrentHashMap();
    private Map<String, Handler> f = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Map<String, Integer> g = new ConcurrentHashMap();

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    private a() {
    }

    public final void a(String str, String str2, final b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        c cVar;
        if (this.b == null) {
            this.c.a(bVar2, "Banner Context == null!", str2);
        } else if (bVar == null || bVar2 == null) {
            this.c.a(bVar2, "Banner request parameters or callback empty!", str2);
        } else {
            synchronized (a()) {
                if (this.e == null || !this.e.containsKey(str2) || !this.e.get(str2).booleanValue()) {
                    this.e.put(str2, true);
                    if (this.d.containsKey(str2)) {
                        cVar = this.d.get(str2);
                    } else {
                        d e2 = com.mbridge.msdk.b.b.a().e(com.mbridge.msdk.foundation.controller.a.e().h(), str2);
                        if (e2 == null) {
                            e2 = d.d(str2);
                        }
                        c cVar2 = new c(str2, "", 0, e2.u() * 1);
                        this.d.put(str2, cVar2);
                        cVar = cVar2;
                    }
                    new b(this.b, cVar, bVar2, this.c).a(str, str2, bVar, (com.mbridge.msdk.mbbanner.common.b.d) new com.mbridge.msdk.mbbanner.common.b.d() {
                        public final void a(String str) {
                            synchronized (a.a()) {
                                bVar.a("");
                                a.this.e.put(str, false);
                            }
                        }
                    });
                    return;
                }
                this.c.a(bVar2, "Current unit is loading!", str2);
            }
        }
    }

    public final void b(String str, String str2, b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        Handler handler;
        if (bVar != null && bVar.b() > 0) {
            if (this.f.containsKey(str2)) {
                handler = this.f.get(str2);
            } else {
                handler = new Handler();
                this.f.put(str2, handler);
            }
            final String str3 = str2;
            final com.mbridge.msdk.mbbanner.common.b.b bVar3 = bVar2;
            final String str4 = str;
            final b bVar4 = bVar;
            AnonymousClass2 r1 = new Runnable() {
                public final void run() {
                    int intValue;
                    if (a.this.e != null && a.this.e.containsKey(str3) && ((Boolean) a.this.e.get(str3)).booleanValue()) {
                        return;
                    }
                    if (!a.this.g.containsKey(str3) || !((intValue = ((Integer) a.this.g.get(str3)).intValue()) == 2 || intValue == 4)) {
                        a.this.a(str4, str3, bVar4, bVar3);
                    } else if (a.this.c != null) {
                        a.this.c.a(bVar3, "banner load failed because env is exception", str3);
                    }
                }
            };
            handler.removeCallbacksAndMessages((Object) null);
            handler.postDelayed(r1, (long) bVar.b());
        }
    }

    public final void a(String str) {
        if (this.f.containsKey(str)) {
            this.f.get(str).removeCallbacksAndMessages((Object) null);
            this.f.remove(str);
        }
    }

    public final void a(int i, String str, String str2, b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        int intValue = this.g.containsKey(str2) ? this.g.get(str2).intValue() : 0;
        if (i == 1) {
            if (this.f.containsKey(str2)) {
                this.f.get(str2).removeCallbacksAndMessages((Object) null);
            }
            this.g.put(str2, Integer.valueOf(i));
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    if (intValue == 0) {
                        this.g.put(str2, 0);
                        return;
                    }
                    if (this.f.containsKey(str2)) {
                        this.f.get(str2).removeCallbacksAndMessages((Object) null);
                    }
                    this.g.put(str2, Integer.valueOf(i));
                }
            } else if (intValue == 2 || intValue == 4) {
                this.g.put(str2, 1);
                b(str, str2, bVar, bVar2);
            }
        } else if (intValue == 1) {
            if (this.f.containsKey(str2)) {
                this.f.get(str2).removeCallbacksAndMessages((Object) null);
            }
            this.g.put(str2, Integer.valueOf(i));
        }
    }

    public final void b() {
        Map<String, c> map = this.d;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f;
        if (map3 != null) {
            for (Map.Entry next : map3.entrySet()) {
                if (next.getValue() != null) {
                    ((Handler) next.getValue()).removeCallbacksAndMessages((Object) null);
                }
            }
            this.f.clear();
        }
        Map<String, Integer> map4 = this.g;
        if (map4 != null) {
            map4.clear();
        }
    }
}
