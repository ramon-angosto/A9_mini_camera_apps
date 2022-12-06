package com.meizu.cloud.pushsdk.a.b;

public class b {
    private static b a;
    private final d b = new c();

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public d b() {
        return this.b;
    }
}
