package com.iab.omid.library.bigosg.h;

import android.view.View;
import com.iab.omid.library.bigosg.b.l;
import com.iab.omid.library.bigosg.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class b {
    final HashMap<View, String> a = new HashMap<>();
    final HashMap<View, a> b = new HashMap<>();
    final HashMap<String, View> c = new HashMap<>();
    final HashSet<View> d = new HashSet<>();
    final HashSet<String> e = new HashSet<>();
    final HashSet<String> f = new HashSet<>();
    final HashMap<String, String> g = new HashMap<>();
    boolean h;

    public static class a {
        public final c a;
        public final ArrayList<String> b = new ArrayList<>();

        public a(c cVar, String str) {
            this.a = cVar;
            a(str);
        }

        public final void a(String str) {
            this.b.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(l lVar) {
        for (c next : lVar.b) {
            View view = (View) next.a.get();
            if (view != null) {
                a aVar = this.b.get(view);
                if (aVar != null) {
                    aVar.a(lVar.f);
                } else {
                    this.b.put(view, new a(next, lVar.f));
                }
            }
        }
    }
}
