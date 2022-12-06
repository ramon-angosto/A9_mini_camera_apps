package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.q;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonObjectRequest */
public class d extends e<JSONObject> {
    private static final String c = d.class.getSimpleName();

    public d(int i, String str, String str2, e<JSONObject> eVar) {
        super(i, str, str2, eVar);
    }

    /* access modifiers changed from: protected */
    public final k<JSONObject> a(c cVar) {
        try {
            return k.a(new JSONObject(new String(cVar.b, b.a(cVar.d))), cVar);
        } catch (UnsupportedEncodingException e) {
            q.d(c, e.getMessage());
            return k.a(new a(8, cVar));
        } catch (JSONException e2) {
            q.d(c, e2.getMessage());
            return k.a(new a(8, cVar));
        }
    }
}
