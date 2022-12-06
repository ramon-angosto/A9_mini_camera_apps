package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AdInfo */
public class a {
    private String a;
    private int b;
    private String c;
    private List<n> d = new ArrayList();
    private String e;
    private long f;

    public void a(String str) {
        this.a = str;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public List<n> b() {
        return this.d;
    }

    public void a(n nVar) {
        this.d.add(nVar);
    }

    public void c(String str) {
        this.e = str;
    }

    public void a(long j) {
        this.f = j;
    }

    public static Map<String, n> a(a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (n next : aVar.b()) {
            if (!TextUtils.isEmpty(next.af())) {
                hashMap.put(next.af(), next);
            }
        }
        if (hashMap.size() != 0) {
            return hashMap;
        }
        return null;
    }
}
