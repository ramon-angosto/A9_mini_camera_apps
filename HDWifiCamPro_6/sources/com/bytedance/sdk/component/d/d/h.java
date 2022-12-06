package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.a;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.o;
import java.util.List;
import java.util.Map;

/* compiled from: FailVisitor */
public class h extends a {
    private Throwable a;
    private int b;
    private String c;

    public String a() {
        return "failed";
    }

    public h(int i, String str, Throwable th) {
        this.b = i;
        this.c = str;
        this.a = th;
    }

    public void a(c cVar) {
        cVar.a(new a(this.b, this.c, this.a));
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

    private void b(c cVar) {
        o h = cVar.h();
        if (h != null) {
            h.a(this.b, this.c, this.a);
        }
    }
}
