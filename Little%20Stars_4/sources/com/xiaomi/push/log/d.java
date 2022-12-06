package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.log.b;

class d extends f.b {
    f.b a;
    final /* synthetic */ b b;

    d(b bVar) {
        this.b = bVar;
    }

    public void b() {
        b.C0051b bVar = (b.C0051b) this.b.a.peek();
        if (bVar != null && bVar.d()) {
            this.a = (f.b) this.b.a.remove();
            this.a.b();
        }
    }

    public void c() {
        f.b bVar = this.a;
        if (bVar != null) {
            bVar.c();
        }
    }
}
