package com.ironsource.sdk.controller;

import java.util.ArrayList;

public final class b {
    private int a = a.a;
    private ArrayList b = new ArrayList();
    private String c;

    enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;

        static {
            c = new int[]{1, 2};
        }
    }

    public b(String str) {
        this.c = str;
    }

    public final synchronized void a() {
        this.a = a.b;
    }

    public final synchronized void a(Runnable runnable) {
        if (this.a != a.b) {
            this.b.add(runnable);
        } else {
            runnable.run();
        }
    }

    public final synchronized void b() {
        Object[] array = this.b.toArray();
        for (int i = 0; i < array.length; i++) {
            ((Runnable) array[i]).run();
            array[i] = null;
        }
        this.b.clear();
    }
}
