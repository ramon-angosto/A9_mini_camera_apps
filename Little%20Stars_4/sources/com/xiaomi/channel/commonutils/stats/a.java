package com.xiaomi.channel.commonutils.stats;

import java.util.LinkedList;

public class a {
    private LinkedList<C0049a> a = new LinkedList<>();

    /* renamed from: com.xiaomi.channel.commonutils.stats.a$a  reason: collision with other inner class name */
    public static class C0049a {
        /* access modifiers changed from: private */
        public static final a d = new a();
        public int a;
        public String b;
        public Object c;

        C0049a(int i, Object obj) {
            this.a = i;
            this.c = obj;
        }
    }

    public static a a() {
        return C0049a.d;
    }

    private void d() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    public synchronized void a(Object obj) {
        this.a.add(new C0049a(0, obj));
        d();
    }

    public synchronized int b() {
        return this.a.size();
    }

    public synchronized LinkedList<C0049a> c() {
        LinkedList<C0049a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }
}
