package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.c.d;
import com.bytedance.sdk.component.d.f;
import com.bytedance.sdk.component.d.o;
import java.util.List;
import java.util.Map;

/* compiled from: SuccessVisitor */
public class m<T> extends a {
    private T a;
    private f b;
    private boolean c;

    public String a() {
        return "success";
    }

    public m(T t, f fVar, boolean z) {
        this.a = t;
        this.b = fVar;
        this.c = z;
    }

    public void a(c cVar) {
        String t = cVar.t();
        Map<String, List<c>> f = cVar.r().f();
        List<c> list = f.get(t);
        if (list == null) {
            b(cVar);
            return;
        }
        synchronized (list) {
            for (c b2 : list) {
                b(b2);
            }
            list.clear();
            f.remove(t);
        }
    }

    private Map<String, String> b() {
        f fVar = this.b;
        if (fVar != null) {
            return fVar.e();
        }
        return null;
    }

    private void b(c cVar) {
        o h = cVar.h();
        if (h != null) {
            h.a(new d().a(cVar, this.a, b(), this.c));
        }
    }
}
