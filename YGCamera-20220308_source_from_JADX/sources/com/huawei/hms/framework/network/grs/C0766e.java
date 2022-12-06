package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.e */
public class C0766e {

    /* renamed from: a */
    private static Map<String, C0757d> f585a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private static final Object f586b = new Object();

    /* renamed from: a */
    public static C0757d m679a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (f586b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, C0757d> map = f585a;
            C0757d dVar = map.get(context.getPackageName() + uniqueCode);
            if (dVar == null) {
                C0757d dVar2 = new C0757d(context, grsBaseInfo);
                Map<String, C0757d> map2 = f585a;
                map2.put(context.getPackageName() + uniqueCode, dVar2);
                return dVar2;
            } else if (dVar.mo13891a((Object) new C0757d(grsBaseInfo))) {
                return dVar;
            } else {
                C0757d dVar3 = new C0757d(context, grsBaseInfo);
                Map<String, C0757d> map3 = f585a;
                map3.put(context.getPackageName() + uniqueCode, dVar3);
                return dVar3;
            }
        }
    }
}
