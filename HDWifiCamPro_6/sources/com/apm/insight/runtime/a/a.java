package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.l.s;

class a extends c {
    a(Context context, b bVar, d dVar) {
        super(CrashType.ANR, context, bVar, dVar);
    }

    public com.apm.insight.entity.a a(com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a a = super.a(aVar);
        Header a2 = Header.a(this.b);
        Header.a(a2);
        Header.b(a2);
        a2.c();
        a2.d();
        a2.e();
        a.a(a2);
        a.a("process_name", (Object) com.apm.insight.l.a.c(this.b));
        s.a(a, a2, this.a);
        return a;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return true;
    }
}
