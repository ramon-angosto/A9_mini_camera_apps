package com.mbridge.msdk.foundation.db.a;

import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.same.a.b;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReplaceTempDaoMiddle */
public final class a {
    private l a;
    private b b;

    /* renamed from: com.mbridge.msdk.foundation.db.a.a$a  reason: collision with other inner class name */
    /* compiled from: ReplaceTempDaoMiddle */
    private static class C0061a {
        /* access modifiers changed from: private */
        public static a a = new a();
    }

    private a() {
        this.b = new b(1000);
        this.a = l.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        a(this.a.a(), false);
    }

    public static a a() {
        return C0061a.a;
    }

    public final JSONObject a(String str) {
        JSONObject a2 = this.b.b(str);
        if (a2 != null) {
            return a2;
        }
        JSONObject a3 = this.a.a(str);
        if (a3 != null) {
            this.b.a(str, a3);
        }
        return a3;
    }

    public final void a(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                this.b.a(next, optJSONObject);
                if (z) {
                    this.a.a(next, optJSONObject);
                }
            }
        }
    }

    public final JSONArray b() {
        return new JSONArray(this.b.a());
    }
}
