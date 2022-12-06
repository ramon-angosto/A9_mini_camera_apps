package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.q;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JsonArrayRequest */
public class c extends e<JSONArray> {
    private static final String c = c.class.getSimpleName();

    public c(int i, String str, String str2, e<JSONArray> eVar) {
        super(i, str, str2, eVar);
    }

    /* access modifiers changed from: protected */
    public final k<JSONArray> a(com.mbridge.msdk.foundation.same.net.f.c cVar) {
        try {
            return k.a(new JSONArray(new String(cVar.b, b.a(cVar.d))), cVar);
        } catch (UnsupportedEncodingException e) {
            q.d(c, e.getMessage());
            return k.a(new a(8, cVar));
        } catch (JSONException e2) {
            q.d(c, e2.getMessage());
            return k.a(new a(8, cVar));
        }
    }
}
