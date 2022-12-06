package com.ironsource.sdk;

import com.ironsource.sdk.j.a;
import java.util.Map;

public final class b {
    public final boolean a;
    public String b;
    public String c;
    public boolean d;
    public a e;
    public Map<String, String> f;
    public a g;
    public boolean h = false;

    b(String str, String str2, boolean z, boolean z2, Map<String, String> map, a aVar, a aVar2) {
        this.b = str;
        this.c = str2;
        this.a = z;
        this.d = z2;
        this.f = map;
        this.g = aVar;
        this.e = aVar2;
    }

    public final boolean a() {
        a aVar = this.e;
        if (aVar != null) {
            if (aVar.b > 0 && aVar.a > 0) {
                return true;
            }
        }
        return false;
    }
}
