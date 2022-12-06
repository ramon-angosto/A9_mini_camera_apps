package com.ironsource.sdk.g;

import com.ironsource.sdk.j.a;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public String a;
    public String b;
    public int c = -1;
    public Map<String, String> d;
    public int e;
    public boolean f;
    public a g;

    public c(String str, String str2, Map<String, String> map, a aVar) {
        this.b = str;
        this.a = str2;
        this.d = map;
        this.g = aVar;
        this.e = 0;
        this.f = false;
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceId", this.b);
        hashMap.put("demandSourceName", this.a);
        Map<String, String> map = this.d;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public final synchronized void a(int i) {
        this.e = i;
    }
}
