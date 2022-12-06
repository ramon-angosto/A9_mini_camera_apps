package com.xiaomi.push.service;

import com.xiaomi.push.C1860hi;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.ak */
final class C1982ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f3687a;

    /* renamed from: a */
    final /* synthetic */ boolean f3688a;

    C1982ak(List list, boolean z) {
        this.f3687a = list;
        this.f3688a = z;
    }

    public void run() {
        int i;
        boolean a = C1981aj.m4956a("www.baidu.com:80");
        Iterator it = this.f3687a.iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            a = a || C1981aj.m4956a((String) it.next());
            if (a && !this.f3688a) {
                break;
            }
        }
        if (!a) {
            i = 2;
        }
        C1860hi.m3861a(i);
    }
}
