package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.n;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RitInfo */
public class p {
    public static ConcurrentHashMap<Integer, p> a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private int d;
    private int e;
    private String f;

    public String a() {
        return this.f;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    private void f() {
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = 0;
    }

    public void a(n nVar) {
        if (nVar != null) {
            String aZ = nVar.aZ();
            if (!TextUtils.isEmpty(aZ)) {
                this.f = aZ;
            }
            String O = nVar.O();
            if (TextUtils.isEmpty(O) && nVar.aw()) {
                O = nVar.ax().i();
            }
            if (!TextUtils.isEmpty(O)) {
                String[] split = nVar.O().split("/");
                if (split.length >= 3) {
                    this.b = split[2];
                }
            }
            if (nVar.aa() != null && !TextUtils.isEmpty(nVar.aa().c())) {
                this.c = nVar.aa().c();
            }
        }
    }

    public static void b(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.ac())) {
            Integer valueOf = Integer.valueOf(nVar.aW());
            if (valueOf.intValue() != 0) {
                p pVar = null;
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                if (a.containsKey(valueOf)) {
                    pVar = a.get(valueOf);
                }
                if (pVar == null) {
                    pVar = new p();
                }
                String aZ = nVar.aZ();
                if (TextUtils.isEmpty(aZ) || !aZ.equals(pVar.a())) {
                    pVar.f();
                    pVar.a(nVar);
                    a.put(valueOf, pVar);
                }
            }
        }
    }

    public static void c(int i) {
        p pVar;
        if (i != 0) {
            if (a == null) {
                a = new ConcurrentHashMap<>();
            }
            if (a.containsKey(Integer.valueOf(i)) && (pVar = a.get(Integer.valueOf(i))) != null) {
                pVar.b(1);
            }
        }
    }

    public static void c(n nVar) {
        p pVar;
        if (nVar != null) {
            Integer valueOf = Integer.valueOf(nVar.aW());
            if (valueOf.intValue() != 0) {
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                if (a.containsKey(valueOf) && (pVar = a.get(valueOf)) != null) {
                    pVar.a(1);
                }
            }
        }
    }
}
