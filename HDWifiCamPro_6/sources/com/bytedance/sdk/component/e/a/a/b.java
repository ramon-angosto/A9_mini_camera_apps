package com.bytedance.sdk.component.e.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.b.d;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: CacheManager */
public class b extends a {
    private final d a = new f(this.c);
    private final c b = new c();
    private final Queue<String> c = new ConcurrentLinkedQueue();

    public synchronized void a(a aVar, int i) {
        if (i != 5) {
            if (!(!i.e().m().a(i.e().d()) || this.a == null || aVar == null)) {
                this.a.a(aVar, i);
            }
        }
        if (!(this.b == null || aVar == null)) {
            this.b.a(aVar, i);
        }
    }

    public synchronized void a(int i, List<a> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.c.size());
        arrayList.addAll(this.c);
        for (String str : arrayList) {
            for (a c2 : list) {
                if (TextUtils.equals(str, c2.c())) {
                    this.c.remove(str);
                }
            }
        }
        if (this.a != null) {
            this.a.a(i, list);
        }
        if (this.b != null) {
            this.b.a(i, list);
        }
    }

    public synchronized List<a> a(int i, int i2) {
        List<a> b2;
        boolean z;
        List<a> a2 = this.a.a(i, i2);
        if (a2 == null || a2.size() == 0) {
            a2 = this.b.a(i, i2);
            if (!(a2 == null || a2.size() == 0)) {
                HashMap hashMap = new HashMap();
                for (a next : a2) {
                    hashMap.put(next.c(), next);
                }
                ArrayList<String> arrayList = new ArrayList<>(this.c);
                c.a("allSendingQueue:" + arrayList.size());
                if (arrayList.size() != 0) {
                    for (String str : arrayList) {
                        if (hashMap.get(str) != null) {
                            c.a("db duplicate delete");
                            hashMap.remove(str);
                        }
                    }
                }
                a2.clear();
                for (String str2 : hashMap.keySet()) {
                    a2.add(hashMap.get(str2));
                }
            }
        } else {
            c.a("memory get " + a2.size());
            if (!((i != 1 && i != 2) || (b2 = this.b.b(a2.get(0), a2.size())) == null || b2.size() == 0)) {
                c.a("db get " + b2.size());
                HashMap hashMap2 = new HashMap();
                for (a next2 : b2) {
                    hashMap2.put(next2.c(), next2);
                }
                ArrayList arrayList2 = new ArrayList(this.c);
                for (a next3 : b2) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        if (TextUtils.equals(next3.c(), (String) it.next())) {
                            c.a(" duplicate delete ");
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        hashMap2.remove(next3.c());
                    }
                }
                for (a next4 : a2) {
                    hashMap2.put(next4.c(), next4);
                }
                a2.clear();
                for (String str3 : hashMap2.keySet()) {
                    a2.add(hashMap2.get(str3));
                }
            }
        }
        if (a2 != null) {
            if (!a2.isEmpty()) {
                for (a c2 : a2) {
                    this.c.offer(c2.c());
                }
                return a2;
            }
        }
        return new ArrayList();
    }

    public synchronized boolean a(int i, boolean z) {
        if (this.a.a(i, z)) {
            com.bytedance.sdk.component.e.a.c.b.a(d.d.E(), 1);
            return true;
        }
        if (i == 1 || i == 2) {
            if (this.b.a(i, z)) {
                com.bytedance.sdk.component.e.a.c.b.a(d.d.F(), 1);
                return true;
            }
        }
        return false;
    }
}
