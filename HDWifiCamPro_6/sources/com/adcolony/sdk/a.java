package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import com.adcolony.sdk.e0;

class a {
    private static Context a = null;
    private static k b = null;
    static boolean c = false;
    static boolean d = false;
    static boolean e = false;

    static void a(AdColonyAppOptions adColonyAppOptions) {
        e = adColonyAppOptions.getIsChildDirectedApp() && (!adColonyAppOptions.isPrivacyFrameworkRequiredSet(AdColonyAppOptions.COPPA) || adColonyAppOptions.getPrivacyFrameworkRequired(AdColonyAppOptions.COPPA));
    }

    static k b() {
        if (!d()) {
            Context a2 = a();
            if (a2 == null) {
                return new k();
            }
            b = new k();
            b.a(new AdColonyAppOptions().a(c0.h(c0.c(a2.getFilesDir().getAbsolutePath() + "/adc3/AppInfo"), "appId")), false);
        }
        return b;
    }

    static boolean c() {
        return a != null;
    }

    static boolean d() {
        return b != null;
    }

    static boolean e() {
        return c;
    }

    static void f() {
        b().r().j();
    }

    static void a(Context context, AdColonyAppOptions adColonyAppOptions, boolean z) {
        a((!z || !(context instanceof Activity)) ? context : ((Activity) context).getApplication());
        d = true;
        if (b == null) {
            b = new k();
            adColonyAppOptions.b(context);
            b.a(adColonyAppOptions, z);
        } else {
            adColonyAppOptions.b(context);
            b.a(adColonyAppOptions);
        }
        a(adColonyAppOptions);
        q n = b.n();
        n.a(context);
        n.b(context);
        new e0.a().a("Configuring AdColony").a(e0.d);
        b.c(false);
        b.x().g(false);
        b.d(true);
        b.x().c(false);
        b.x().d(true);
    }

    static void b(String str, j0 j0Var) {
        b().r().b(str, j0Var);
    }

    static void a(Context context) {
        a = context;
    }

    static Context a() {
        return a;
    }

    static void a(String str, j0 j0Var) {
        b().r().a(str, j0Var);
    }

    static j0 a(String str, j0 j0Var, boolean z) {
        b().r().a(str, j0Var);
        return j0Var;
    }

    static void a(String str, f1 f1Var) {
        if (f1Var == null) {
            f1Var = c0.b();
        }
        c0.a(f1Var, "m_type", str);
        b().r().c(f1Var);
    }
}
