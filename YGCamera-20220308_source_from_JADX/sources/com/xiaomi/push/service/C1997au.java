package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.C1613af;
import com.xiaomi.push.C1874hu;
import com.xiaomi.push.C1875hv;
import com.xiaomi.push.C1877hx;
import com.xiaomi.push.C1879hz;
import com.xiaomi.push.C1892il;
import com.xiaomi.push.C1893im;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.au */
public class C1997au {
    /* renamed from: a */
    public static int m5060a(C1995at atVar, C1874hu huVar) {
        int i = 0;
        if (C1998av.f3720a[huVar.ordinal()] == 1) {
            i = 1;
        }
        return atVar.mo18466a(huVar, i);
    }

    /* renamed from: a */
    private static List<Pair<Integer, Object>> m5061a(List<C1879hz> list, boolean z) {
        if (C1613af.m2510a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C1879hz next : list) {
            int a = next.mo17830a();
            C1875hv a2 = C1875hv.m3949a(next.mo17833b());
            if (a2 != null) {
                if (!z || !next.f2972a) {
                    int i = C1998av.f3721b[a2.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(next.mo17845g())) : new Pair(Integer.valueOf(a), next.mo17830a()) : new Pair(Integer.valueOf(a), Long.valueOf(next.mo17830a())) : new Pair(Integer.valueOf(a), Integer.valueOf(next.mo17835c())));
                } else {
                    arrayList.add(new Pair(Integer.valueOf(a), (Object) null));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m5062a(C1995at atVar, C1892il ilVar) {
        atVar.mo18470a(m5061a(ilVar.mo18065a(), true));
        atVar.mo18473b();
    }

    /* renamed from: a */
    public static void m5063a(C1995at atVar, C1893im imVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C1877hx next : imVar.mo18071a()) {
            arrayList.add(new Pair(next.mo17820a(), Integer.valueOf(next.mo17820a())));
            List<Pair<Integer, Object>> a = m5061a(next.f2900a, false);
            if (!C1613af.m2510a(a)) {
                arrayList2.addAll(a);
            }
        }
        atVar.mo18471a((List<Pair<C1874hu, Integer>>) arrayList, (List<Pair<Integer, Object>>) arrayList2);
        atVar.mo18473b();
    }
}
