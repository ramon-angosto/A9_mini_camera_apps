package com.xiaomi.push;

import java.util.LinkedList;

/* renamed from: com.xiaomi.push.bk */
public class C1658bk {

    /* renamed from: a */
    private LinkedList<C1659a> f1876a = new LinkedList<>();

    /* renamed from: com.xiaomi.push.bk$a */
    public static class C1659a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C1658bk f1877a = new C1658bk();

        /* renamed from: a */
        public int f1878a;

        /* renamed from: a */
        public Object f1879a;

        /* renamed from: a */
        public String f1880a;

        C1659a(int i, Object obj) {
            this.f1878a = i;
            this.f1879a = obj;
        }
    }

    /* renamed from: a */
    public static C1658bk mo17259a() {
        return C1659a.f1877a;
    }

    /* renamed from: a */
    private void m2709a() {
        if (this.f1876a.size() > 100) {
            this.f1876a.removeFirst();
        }
    }

    /* renamed from: a */
    public synchronized int m2710a() {
        return this.f1876a.size();
    }

    /* renamed from: a */
    public synchronized LinkedList<C1659a> m2711a() {
        LinkedList<C1659a> linkedList;
        linkedList = this.f1876a;
        this.f1876a = new LinkedList<>();
        return linkedList;
    }

    /* renamed from: a */
    public synchronized void mo17260a(Object obj) {
        this.f1876a.add(new C1659a(0, obj));
        mo17259a();
    }
}
