package com.ironsource.environment.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.a;
import com.ironsource.environment.e.c;
import com.ironsource.environment.h;
import com.vungle.warren.VungleApiClient;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a {
    public ConcurrentHashMap<String, Object> a;
    AtomicBoolean b;
    public AtomicBoolean c;

    /* renamed from: com.ironsource.environment.c.a$a  reason: collision with other inner class name */
    public static class C0088a {
        public static volatile a a = new a((byte) 0);
    }

    private a() {
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.a = new ConcurrentHashMap<>();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    private void a(String str) {
        try {
            this.a.remove(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean b(String str) {
        try {
            return this.a.containsKey(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c(final Context context) {
        if (!this.b.get()) {
            try {
                this.b.set(true);
                c.b(new Runnable() {
                    public final void run() {
                        String[] C;
                        try {
                            a aVar = a.this;
                            Context context = context;
                            if (!(context == null || (C = h.C(context)) == null || C.length != 2)) {
                                String str = C[0];
                                Boolean valueOf = Boolean.valueOf(C[1]);
                                if (!TextUtils.isEmpty(str)) {
                                    aVar.a(VungleApiClient.GAID, str);
                                    aVar.a("lat", valueOf);
                                }
                            }
                        } catch (Exception unused) {
                        }
                        a.this.b.set(false);
                    }
                }, 0);
            } catch (Exception unused) {
                this.b.set(false);
            }
        }
    }

    public final JSONObject a(Context context) {
        b(context);
        return new JSONObject(b.a(this.a));
    }

    public void a(String str, Object obj) {
        if (str != null && obj != null) {
            try {
                if (obj instanceof Boolean) {
                    obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                this.a.put(str, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(Context context) {
        if (context != null) {
            c(context);
            String B = h.B(context);
            if (!TextUtils.isEmpty(B)) {
                a("asid", B);
            } else if (b("asid")) {
                a("asid");
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                a("lang", language.toUpperCase());
            }
            String c2 = h.c();
            if (!TextUtils.isEmpty(c2)) {
                a("tz", c2);
            }
            String a2 = com.ironsource.d.a.a(context);
            if (!TextUtils.isEmpty(a2) && !a2.equals("none")) {
                a("connt", a2);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                a("vpn", Boolean.valueOf(com.ironsource.d.a.c(context)));
            }
            String j = h.j(context);
            if (!TextUtils.isEmpty(j)) {
                a("icc", j);
            }
            a("vol", Float.valueOf(h.l(context)));
            a("dfs", String.valueOf(h.p()));
            a("scrnw", Integer.valueOf(h.k()));
            a("scrnh", Integer.valueOf(h.l()));
            a("ltime", String.valueOf(h.a()));
            a("tzoff", String.valueOf(h.b()));
            a("mcc", Integer.valueOf(a.AnonymousClass1.c(context)));
            a("mnc", Integer.valueOf(a.AnonymousClass1.d(context)));
            a("sdcrd", Boolean.valueOf(h.d()));
            a("chrg", Boolean.valueOf(h.e(context)));
            a("chrgt", Integer.valueOf(h.f(context)));
            a("apm", Boolean.valueOf(h.g(context)));
            a("owp", Boolean.valueOf(h.h(context)));
            a("rt", Boolean.valueOf(h.j()));
            a("sscl", String.valueOf(h.o()));
            a("bat", Integer.valueOf(h.v(context)));
            a("lpm", Boolean.valueOf(h.w(context)));
            a("apor", h.n(context));
            a("ua", h.r());
            int D = h.D(context);
            if (D >= 0) {
                a("tca", Integer.valueOf(D));
            }
            String E = h.E(context);
            if (E != null) {
                a("tcs", E);
            }
        }
    }
}
