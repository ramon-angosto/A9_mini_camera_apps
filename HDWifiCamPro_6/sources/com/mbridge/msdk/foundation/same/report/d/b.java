package com.mbridge.msdk.foundation.same.report.d;

import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;

/* compiled from: ReportResponseHandler */
public abstract class b extends f<String> {
    private static final String a = b.class.getSimpleName();

    public abstract void a(String str);

    public abstract void b(String str);

    public final void a(k<String> kVar) {
        if (kVar != null) {
            a((String) kVar.a);
        }
    }

    public final void a(a aVar) {
        b(com.mbridge.msdk.foundation.same.net.g.a.a(aVar.a));
    }
}
