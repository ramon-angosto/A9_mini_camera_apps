package com.mbridge.msdk.foundation.same.report.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.tools.m;

/* compiled from: CampaignRequestTimeUtil */
public final class a {
    private g a;
    private com.mbridge.msdk.foundation.db.g b = null;
    private Context c;

    public a(g gVar) {
        Context context;
        this.a = gVar;
        this.c = com.mbridge.msdk.foundation.controller.a.e().g();
        this.b = com.mbridge.msdk.foundation.db.g.a(this.c);
        if (this.a != null && (context = this.c) != null) {
            int n = m.n(context);
            this.a.d(n);
            this.a.c(m.a(this.c, n));
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(str);
        }
    }

    public final void a(int i) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.b(i);
        }
    }

    public final void b(int i) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.c(i);
        }
    }

    public final void a() {
        if (this.a != null) {
            k.a((f) this.b).a(this.a);
        }
    }

    public final void b(String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.b(str);
        }
    }

    public final void c(int i) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(i);
        }
    }
}
