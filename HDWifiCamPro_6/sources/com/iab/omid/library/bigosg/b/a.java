package com.iab.omid.library.bigosg.b;

import com.iab.omid.library.bigosg.c.e;
import com.iab.omid.library.bigosg.e.d;

public final class a {
    public final l a;

    public a(l lVar) {
        this.a = lVar;
    }

    public final void a() {
        d.a(this.a);
        d.c(this.a);
        if (!this.a.f()) {
            try {
                this.a.a();
            } catch (Exception unused) {
            }
        }
        if (this.a.f()) {
            l lVar = this.a;
            if (!lVar.g) {
                e.a().a(lVar.c.c(), "publishImpressionEvent", new Object[0]);
                lVar.g = true;
                return;
            }
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }
}
