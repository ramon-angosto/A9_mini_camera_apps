package com.bytedance.sdk.component.e.a.e;

import java.util.UUID;

/* compiled from: TTRunnable */
public abstract class e implements Comparable<e>, Runnable {
    private int a;
    private String b;
    private String c;

    public e(String str) {
        this.a = 0;
        this.a = 5;
        this.b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.c = str;
    }

    public void a(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a */
    public int compareTo(e eVar) {
        if (a() < eVar.a()) {
            return 1;
        }
        return a() >= eVar.a() ? -1 : 0;
    }
}
