package com.iab.omid.library.bigosg.h.a;

import com.iab.omid.library.bigosg.c.a;
import com.iab.omid.library.bigosg.g.a;
import com.iab.omid.library.bigosg.h.a.b;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public final class e extends a {
    public e(b.C0078b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        a a = a.a();
        if (a != null) {
            for (T t : Collections.unmodifiableCollection(a.a)) {
                if (this.a.contains(t.f)) {
                    com.iab.omid.library.bigosg.g.a aVar = t.c;
                    if (this.c >= aVar.e && aVar.d != a.C0077a.c) {
                        aVar.d = a.C0077a.c;
                        com.iab.omid.library.bigosg.c.e.a().b(aVar.c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.b.toString();
    }
}
