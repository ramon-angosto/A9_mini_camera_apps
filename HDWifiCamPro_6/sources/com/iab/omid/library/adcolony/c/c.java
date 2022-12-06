package com.iab.omid.library.adcolony.c;

import android.view.View;
import com.iab.omid.library.adcolony.b.a;
import com.iab.omid.library.adcolony.c.a;
import com.iab.omid.library.adcolony.d.b;
import com.iab.omid.library.adcolony.d.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c implements a {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        a a2 = a.a();
        if (a2 != null) {
            Collection<com.iab.omid.library.adcolony.adsession.a> c = a2.c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (com.iab.omid.library.adcolony.adsession.a e : c) {
                View e2 = e.e();
                if (e2 != null && f.c(e2) && (rootView = e2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a3 = f.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && f.a(arrayList.get(size - 1)) > a3) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    public JSONObject a(View view) {
        return b.a(0, 0, 0, 0);
    }

    public void a(View view, JSONObject jSONObject, a.C0073a aVar, boolean z, boolean z2) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            aVar.a(it.next(), this.a, jSONObject, z2);
        }
    }
}
