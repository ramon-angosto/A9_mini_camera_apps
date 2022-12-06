package com.ironsource.mediationsdk.adunit.c;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.c;
import java.util.List;

public final class a {
    IronSource.AD_UNIT a;
    String b;
    List<NetworkSettings> c;
    c d;
    int e;
    int f;
    int g;
    com.ironsource.mediationsdk.adunit.c.b.a h;
    int i;

    public a(IronSource.AD_UNIT ad_unit, String str, List<NetworkSettings> list, c cVar, int i2, int i3, int i4, int i5, com.ironsource.mediationsdk.adunit.c.b.a aVar) {
        this.a = ad_unit;
        this.b = str;
        this.c = list;
        this.d = cVar;
        this.e = i2;
        this.g = i3;
        this.f = i4;
        this.h = aVar;
        this.i = i5;
    }

    public final NetworkSettings a(String str) {
        for (NetworkSettings next : this.c) {
            if (next.getProviderInstanceName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final boolean a() {
        return this.d.e > 0;
    }
}
