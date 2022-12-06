package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DirectoryContext */
public abstract class b {
    protected a a;

    /* access modifiers changed from: protected */
    public abstract List<a> b();

    public b(String str) {
        a aVar = new a();
        aVar.a(str);
        aVar.a(c.AD_ROOT);
        List<a> b = b();
        if (b != null && b.size() > 0) {
            aVar.a(b);
        }
        this.a = aVar;
    }

    public final a a() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final a a(ArrayList<a> arrayList, c cVar, String str) {
        a aVar = new a();
        aVar.a(cVar);
        aVar.a(str);
        arrayList.add(aVar);
        return aVar;
    }
}
