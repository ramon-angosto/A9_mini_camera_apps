package com.mbridge.msdk.mbnative.a;

import com.mbridge.msdk.out.Campaign;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: NativeCacheFactory */
public final class c {
    public static Map<Integer, b<String, List<Campaign>>> a = new HashMap();

    public static b<String, List<Campaign>> a(int i) {
        if (a.containsKey(Integer.valueOf(i))) {
            return a.get(Integer.valueOf(i));
        }
        a aVar = new a(i);
        a.put(Integer.valueOf(i), aVar);
        return aVar;
    }
}
