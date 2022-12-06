package com.iab.omid.library.ironsrc.walking.a;

import com.iab.omid.library.ironsrc.b.a;
import com.iab.omid.library.ironsrc.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public class e extends a {
    public e(b.C0081b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    private void b(String str) {
        a a = a.a();
        if (a != null) {
            for (com.iab.omid.library.ironsrc.adsession.a next : a.b()) {
                if (this.a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().b(str, this.c);
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
