package com.bytedance.sdk.component.a;

import android.net.Uri;
import com.bytedance.sdk.component.a.k;
import com.bytedance.sdk.component.a.v;
import com.bytedance.sdk.component.a.w;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: PermissionChecker */
class u {
    private final Set<String> a;
    private final Set<String> b;
    private final w c = r.a;
    private final v d;
    private k.b e;

    u(v vVar, Set<String> set, Set<String> set2) {
        this.d = vVar;
        if (set == null || set.isEmpty()) {
            this.a = new LinkedHashSet();
        } else {
            this.a = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.b = new LinkedHashSet();
        } else {
            this.b = new LinkedHashSet(set2);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized x a(boolean z, String str, b bVar) throws v.a {
        x xVar;
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null) {
            return null;
        }
        x xVar2 = this.b.contains(bVar.a()) ? x.PUBLIC : null;
        Iterator<String> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (parse.getHost().equals(next)) {
                break;
            }
            if (host.endsWith("." + next)) {
                break;
            }
        }
        xVar2 = x.PRIVATE;
        if (xVar2 == null && this.e != null && this.e.a(str)) {
            if (this.e.a(str, bVar.a())) {
                return null;
            }
            xVar2 = x.PRIVATE;
        }
        if (z) {
            xVar = a(str, bVar);
        } else {
            xVar = b(str, bVar);
        }
        if (xVar != null) {
            return xVar;
        }
        return xVar2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized x a(String str, b bVar) throws v.a {
        return a(str, bVar, true);
    }

    /* access modifiers changed from: package-private */
    public final synchronized x b(String str, b bVar) {
        return a(str, bVar, false);
    }

    /* access modifiers changed from: package-private */
    public void a(k.b bVar) {
        this.e = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(w.a aVar) {
        w wVar = this.c;
        if (wVar != null) {
            wVar.a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(w.a aVar) {
        w wVar = this.c;
        if (wVar != null) {
            wVar.b(aVar);
        }
    }

    private x a(String str, b bVar, boolean z) {
        v vVar;
        if (!z || (vVar = this.d) == null) {
            return null;
        }
        v.c a2 = vVar.a(str, this.a);
        if (a2.c.contains(bVar.a())) {
            return null;
        }
        if (a2.b.contains(bVar.a())) {
            return x.PRIVATE;
        }
        if (a2.a.compareTo(bVar.b()) < 0) {
            return null;
        }
        return a2.a;
    }
}
