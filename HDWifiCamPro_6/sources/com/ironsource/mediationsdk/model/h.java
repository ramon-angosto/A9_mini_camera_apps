package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.c;
import com.ironsource.sdk.g.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    public ArrayList<InterstitialPlacement> a;
    public d b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public String g;
    public String h;
    public c i;
    public InterstitialPlacement j;

    public h() {
        this.a = new ArrayList<>();
        this.b = new d();
    }

    public h(int i2, boolean z, int i3, d dVar, c cVar, int i4) {
        this.a = new ArrayList<>();
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.b = dVar;
        this.i = cVar;
        this.f = i4;
    }

    public final InterstitialPlacement a() {
        Iterator<InterstitialPlacement> it = this.a.iterator();
        while (it.hasNext()) {
            InterstitialPlacement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.j;
    }
}
