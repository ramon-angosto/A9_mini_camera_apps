package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.a;
import com.apm.insight.l.s;

class j extends c {
    j(Context context, b bVar, d dVar) {
        super(CrashType.JAVA, context, bVar, dVar);
    }

    public a a(int i, a aVar) {
        a a = super.a(i, aVar);
        if (i == 0) {
            a.a("app_count", (Object) 1);
            a.a("magic_tag", (Object) "ss_app_log");
            g(a);
            Header a2 = Header.a(this.b);
            a2.c();
            a.a(a2);
            s.a(a, a2, this.a);
        } else if (i == 1) {
            Header i2 = a.i();
            i2.d();
            i2.e();
        } else if (i == 2) {
            Header.a(a.i());
        } else if (i == 5) {
            Header.b(a.i());
        }
        return a;
    }
}
