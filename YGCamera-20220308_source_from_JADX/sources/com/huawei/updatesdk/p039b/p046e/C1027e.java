package com.huawei.updatesdk.p039b.p046e;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.updatesdk.b.e.e */
public class C1027e {

    /* renamed from: a */
    private static final Map<String, C1023a> f1388a = new ConcurrentHashMap();

    /* renamed from: a */
    public static C1023a m1931a(String str) {
        Object obj;
        Map<String, C1023a> map;
        if (TextUtils.isEmpty(str)) {
            return new C1025c();
        }
        if (f1388a.containsKey(str)) {
            return f1388a.get(str);
        }
        if ("apptouch".equals(str)) {
            map = f1388a;
            obj = new C1024b();
        } else {
            map = f1388a;
            obj = new C1025c();
        }
        map.put(str, obj);
        return f1388a.get(str);
    }
}
