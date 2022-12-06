package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: DuplicateRequestCheckVisitor */
public class g extends a {
    public String a() {
        return "check_duplicate";
    }

    public void a(c cVar) {
        List list;
        String t = cVar.t();
        Map<String, List<c>> f = cVar.r().f();
        synchronized (f) {
            list = f.get(t);
            if (list == null) {
                list = new LinkedList();
            }
        }
        synchronized (list) {
            list.add(cVar);
            f.put(t, list);
            if (list.size() <= 1) {
                cVar.a((i) new d());
            }
        }
    }
}
