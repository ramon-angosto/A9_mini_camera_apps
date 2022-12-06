package com.iab.omid.library.bigosg.b;

import android.view.View;
import com.iab.omid.library.bigosg.Omid;
import com.iab.omid.library.bigosg.e.d;

public abstract class b {
    public static b a(c cVar, d dVar) {
        if (Omid.a()) {
            d.a((Object) cVar, "AdSessionConfiguration is null");
            d.a((Object) dVar, "AdSessionContext is null");
            return new l(cVar, dVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public abstract void a();

    public abstract void a(View view);

    public abstract void b();

    public abstract void b(View view);

    public abstract String c();
}
