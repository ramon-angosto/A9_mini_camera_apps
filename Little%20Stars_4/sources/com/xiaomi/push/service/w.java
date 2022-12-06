package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.b;
import com.xiaomi.xmpush.thrift.c;
import com.xiaomi.xmpush.thrift.d;
import com.xiaomi.xmpush.thrift.e;
import com.xiaomi.xmpush.thrift.g;
import com.xiaomi.xmpush.thrift.q;
import com.xiaomi.xmpush.thrift.r;
import java.util.ArrayList;
import java.util.List;

public class w {
    public static int a(v vVar, c cVar) {
        String a = a(cVar);
        int i = 0;
        if (x.a[cVar.ordinal()] == 1) {
            i = 1;
        }
        return vVar.a.getInt(a, i);
    }

    private static String a(c cVar) {
        return "oc_version_" + cVar.a();
    }

    private static List<Pair<Integer, Object>> a(List<g> list, boolean z) {
        if (b.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (g next : list) {
            int a = next.a();
            d a2 = d.a(next.c());
            if (a2 != null) {
                if (!z || !next.c) {
                    int i = x.b[a2.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(next.l())) : new Pair(Integer.valueOf(a), next.j()) : new Pair(Integer.valueOf(a), Long.valueOf(next.h())) : new Pair(Integer.valueOf(a), Integer.valueOf(next.f())));
                } else {
                    arrayList.add(new Pair(Integer.valueOf(a), (Object) null));
                }
            }
        }
        return arrayList;
    }

    public static void a(v vVar, c cVar, int i) {
        vVar.a.edit().putInt(a(cVar), i).commit();
    }

    public static void a(v vVar, q qVar) {
        vVar.b(a(qVar.a(), true));
    }

    public static void a(v vVar, r rVar) {
        for (e next : rVar.a()) {
            if (next.a() > a(vVar, next.d())) {
                a(vVar, next.d(), next.a());
                vVar.a(a(next.b, false));
            }
        }
    }
}
