package com.bytedance.sdk.openadsdk.k.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PAGMrcTrackerManager */
public class e {
    private static final Map<Integer, b> a = new ConcurrentHashMap();

    public static void a(View view, n nVar, int i) {
        if (view != null && nVar != null && !nVar.aE()) {
            boolean c = c(nVar);
            if (p.a(nVar)) {
                i = -1;
            }
            a(a(view, nVar, c, i));
        }
    }

    private static boolean c(n nVar) {
        if (nVar == null) {
            return false;
        }
        String a2 = y.a(nVar);
        if (!((("open_ad".equals(a2) || "fullscreen_interstitial_ad".equals(a2) || "rewarded_video".equals(a2)) && !p.a(nVar)) && nVar.f() != 5) || !n.c(nVar) || nVar.J() == null) {
            return false;
        }
        return true;
    }

    private static b a(View view, n nVar, boolean z, int i) {
        if (view == null || nVar == null || nVar.Y() == null) {
            return null;
        }
        Integer b = b(nVar);
        if (a.containsKey(b)) {
            b bVar = a.get(b);
            if (bVar != null) {
                bVar.a(view);
            }
            return bVar;
        }
        b a2 = b.a(z, b, view, nVar, i);
        a.put(b, a2);
        return a2;
    }

    private static void a(b bVar) {
        if (bVar != null) {
            bVar.a();
        }
    }

    public static void a(n nVar, int i) {
        if (nVar != null && nVar.Y() != null) {
            a(a.get(b(nVar)), i);
        }
    }

    public static void a(b bVar, int i) {
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public static void a(n nVar) {
        if (nVar != null && nVar.Y() != null) {
            Integer b = b(nVar);
            b bVar = a.get(b);
            if (bVar != null) {
                bVar.j();
            }
            b(b);
            if (a.size() <= 0) {
                g.a();
            }
        }
    }

    public static b a(Integer num) {
        return a.get(num);
    }

    public static void b(Integer num) {
        if (a.containsKey(num)) {
            a.remove(num);
        }
    }

    public static Integer b(n nVar) {
        return Integer.valueOf((nVar.aZ() + nVar.Y()).hashCode());
    }
}
