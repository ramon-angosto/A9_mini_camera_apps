package com.iab.omid.library.bigosg.h.a;

import android.text.TextUtils;
import com.iab.omid.library.bigosg.c.a;
import com.iab.omid.library.bigosg.c.e;
import com.iab.omid.library.bigosg.g.a;
import com.iab.omid.library.bigosg.h.a.b;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public final class f extends a {
    public f(b.C0078b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        a a;
        if (!TextUtils.isEmpty(str) && (a = a.a()) != null) {
            for (T t : Collections.unmodifiableCollection(a.a)) {
                if (this.a.contains(t.f)) {
                    com.iab.omid.library.bigosg.g.a aVar = t.c;
                    if (this.c >= aVar.e) {
                        aVar.d = a.C0077a.b;
                        e.a().b(aVar.c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (com.iab.omid.library.bigosg.e.b.b(this.b, this.e.a())) {
            return null;
        }
        this.e.a(this.b);
        return this.b.toString();
    }
}
