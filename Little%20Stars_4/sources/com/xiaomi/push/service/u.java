package com.xiaomi.push.service;

import com.xiaomi.stats.h;
import java.util.Iterator;
import java.util.List;

final class u implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;

    u(List list, boolean z) {
        this.a = list;
        this.b = z;
    }

    public void run() {
        int i;
        boolean a2 = t.b("www.baidu.com:80");
        Iterator it = this.a.iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            a2 = a2 || t.b((String) it.next());
            if (a2 && !this.b) {
                break;
            }
        }
        if (!a2) {
            i = 2;
        }
        h.a(i);
    }
}
