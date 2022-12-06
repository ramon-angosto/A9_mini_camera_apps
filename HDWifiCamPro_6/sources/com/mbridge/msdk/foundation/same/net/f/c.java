package com.mbridge.msdk.foundation.same.net.f;

import com.mbridge.msdk.foundation.same.net.c.b;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: NetworkResponse */
public final class c {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<b> d;

    public c(int i, byte[] bArr, List<b> list) {
        this(i, bArr, a(list), list);
    }

    private c(int i, byte[] bArr, Map<String, String> map, List<b> list) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
    }

    private static Map<String, String> a(List<b> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (b next : list) {
            treeMap.put(next.a(), next.b());
        }
        return treeMap;
    }
}
