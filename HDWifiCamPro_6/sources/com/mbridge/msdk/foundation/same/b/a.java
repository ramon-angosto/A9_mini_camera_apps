package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Directory */
public final class a {
    private c a;
    private String b;
    private a c;
    private List<a> d;

    public final c a() {
        return this.a;
    }

    public final void a(c cVar) {
        this.a = cVar;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final a c() {
        return this.c;
    }

    public final List<a> d() {
        return this.d;
    }

    private void a(a aVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        aVar.c = this;
        this.d.add(aVar);
    }

    public final void a(c cVar, String str) {
        a aVar = new a();
        aVar.a = cVar;
        aVar.b = str;
        a(aVar);
    }

    public final void a(List<a> list) {
        if (list != null && list.size() != 0) {
            for (a a2 : list) {
                a(a2);
            }
        }
    }
}
