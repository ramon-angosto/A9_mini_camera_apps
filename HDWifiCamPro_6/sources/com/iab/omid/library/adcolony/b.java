package com.iab.omid.library.adcolony;

import android.content.Context;
import com.iab.omid.library.adcolony.b.d;
import com.iab.omid.library.adcolony.b.f;
import com.iab.omid.library.adcolony.d.e;

public class b {
    private boolean a;

    private void b(Context context) {
        e.a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return "1.3.30-Adcolony";
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        b(context);
        if (!b()) {
            a(true);
            f.a().a(context);
            com.iab.omid.library.adcolony.b.b.a().a(context);
            com.iab.omid.library.adcolony.d.b.a(context);
            d.a().a(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.a = z;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.a;
    }
}
