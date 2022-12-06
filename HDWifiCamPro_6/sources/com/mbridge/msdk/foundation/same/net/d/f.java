package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.q;
import java.io.UnsupportedEncodingException;

/* compiled from: StringRequest */
public class f extends i<String> {
    private static final String c = f.class.getSimpleName();
    private String d;

    public f(int i, String str, String str2, e<String> eVar) {
        super(i, str, eVar);
        this.d = str2;
    }

    public final byte[] e() {
        try {
            if (this.d == null) {
                return null;
            }
            return this.d.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final k<String> a(c cVar) {
        try {
            return k.a(new String(cVar.b, b.a(cVar.d)), cVar);
        } catch (UnsupportedEncodingException e) {
            q.d(c, e.getMessage());
            return k.a(new a(8, cVar));
        }
    }
}
