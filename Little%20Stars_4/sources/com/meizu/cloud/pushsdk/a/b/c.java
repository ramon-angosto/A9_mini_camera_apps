package com.meizu.cloud.pushsdk.a.b;

import java.util.concurrent.Executor;

public class c implements d {
    public static final int a = ((Runtime.getRuntime().availableProcessors() * 2) + 1);
    private final a b;
    private final a c;
    private final Executor d = new e();

    public c() {
        f fVar = new f(10);
        this.b = new a(a, fVar);
        this.c = new a(2, fVar);
    }

    public a a() {
        return this.b;
    }

    public a b() {
        return this.c;
    }

    public Executor c() {
        return this.d;
    }
}
