package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.c;
import com.ironsource.sdk.g.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {
    public d a;
    public long b;
    public ArrayList<f> c;
    public f d;
    public int e;
    public int f;
    public c g;
    private int h;

    public e() {
        this.a = new d();
        this.c = new ArrayList<>();
    }

    public e(int i, long j, d dVar, int i2, c cVar, int i3) {
        this.c = new ArrayList<>();
        this.h = i;
        this.b = j;
        this.a = dVar;
        this.e = i2;
        this.f = i3;
        this.g = cVar;
    }

    public final f a() {
        Iterator<f> it = this.c.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.d;
    }

    public final f a(String str) {
        Iterator<f> it = this.c.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }
}
