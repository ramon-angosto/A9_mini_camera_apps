package com.iab.omid.library.bigosg;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.bigosg.a.a;
import com.iab.omid.library.bigosg.c.b;
import com.iab.omid.library.bigosg.c.f;
import com.iab.omid.library.bigosg.e.d;

public final class Omid {
    private static b a = new b();

    private Omid() {
    }

    public static void a(Context context) {
        b bVar = a;
        Context applicationContext = context.getApplicationContext();
        d.a((Object) applicationContext, "Application Context cannot be null");
        if (!bVar.a) {
            bVar.a = true;
            f a2 = f.a();
            a2.b = new com.iab.omid.library.bigosg.a.d(new Handler(), applicationContext, new a(), a2);
            b.a().a = applicationContext.getApplicationContext();
            com.iab.omid.library.bigosg.e.b.a(applicationContext);
            com.iab.omid.library.bigosg.c.d.a().a = applicationContext != null ? applicationContext.getApplicationContext() : null;
        }
    }

    public static boolean a() {
        return a.a;
    }
}
