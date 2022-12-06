package com.meizu.cloud.pushsdk.common.base;

import com.meizu.cloud.pushsdk.common.b.c;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a<T> {
    protected T a;
    protected String b;
    private AtomicInteger c = new AtomicInteger(0);

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void b();

    public a(String str) {
        this.b = str;
    }

    public final void a(T t) {
        synchronized (this.c) {
            if (this.c.incrementAndGet() == 1) {
                c.b(this.b, "call onInit");
                this.a = t;
                a();
            }
        }
    }

    public final void c() {
        synchronized (this.c) {
            if (this.c.decrementAndGet() == 0) {
                c.b(this.b, "call onDestroy");
                b();
            }
        }
    }
}
