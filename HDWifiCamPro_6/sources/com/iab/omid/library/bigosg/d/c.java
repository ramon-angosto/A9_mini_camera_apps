package com.iab.omid.library.bigosg.d;

import android.view.View;
import com.iab.omid.library.bigosg.d.a;
import com.iab.omid.library.bigosg.e.b;
import com.iab.omid.library.bigosg.e.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class c implements a {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public final JSONObject a(View view) {
        return b.a(0, 0, 0, 0);
    }

    public final void a(View view, JSONObject jSONObject, a.C0076a aVar, boolean z) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.bigosg.c.a a2 = com.iab.omid.library.bigosg.c.a.a();
        if (a2 != null) {
            Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(a2.b);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (T e : unmodifiableCollection) {
                View e2 = e.e();
                if (e2 != null && e.b(e2) && (rootView = e2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a3 = e.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && e.a((View) arrayList.get(size - 1)) > a3) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar.a((View) it.next(), this.a, jSONObject);
        }
    }
}
