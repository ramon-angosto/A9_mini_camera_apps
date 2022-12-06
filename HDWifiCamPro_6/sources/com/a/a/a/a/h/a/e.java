package com.a.a.a.a.h.a;

import com.a.a.a.a.b.m;
import com.a.a.a.a.c.a;
import com.a.a.a.a.h.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public class e extends a {
    public e(b.C0003b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    private void b(String str) {
        a a = a.a();
        if (a != null) {
            for (m next : a.b()) {
                if (this.a.contains(next.c())) {
                    next.i().b(str, this.c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}
