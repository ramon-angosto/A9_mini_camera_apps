package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.c;
import com.ironsource.sdk.g.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class o {
    public ArrayList<Placement> a;
    public d b;
    public int c;
    public boolean d;
    public int e;
    public String f;
    public String g;
    public int h;
    public int i;
    public int j;
    public Placement k;
    public c l;

    public o() {
        this.a = new ArrayList<>();
        this.b = new d();
    }

    public o(int i2, boolean z, int i3, int i4, int i5, d dVar, c cVar, int i6) {
        this.a = new ArrayList<>();
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.h = i4;
        this.b = dVar;
        this.i = i5;
        this.l = cVar;
        this.j = i6;
    }

    public final Placement a() {
        Iterator<Placement> it = this.a.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.k;
    }
}
