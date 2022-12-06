package com.mbridge.msdk.foundation.same.net.b;

import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;

/* compiled from: CommonStringResponseHandler */
public abstract class a extends f<String> {
    private static final String a = a.class.getSimpleName();

    public abstract void a(String str);

    public abstract void b(String str);

    public final void a(k<String> kVar) {
        if (kVar != null) {
            a((String) kVar.a);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        b(com.mbridge.msdk.foundation.same.net.g.a.a(aVar.a));
    }
}
