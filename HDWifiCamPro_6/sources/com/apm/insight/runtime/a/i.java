package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.a;
import com.apm.insight.l.s;

public class i extends c {
    i(Context context, b bVar, d dVar) {
        super(CrashType.ENSURE, context, bVar, dVar);
    }

    public a a(a aVar) {
        a a = super.a(aVar);
        g(a);
        s.a(a, (Header) null, this.a);
        return a;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return false;
    }
}
