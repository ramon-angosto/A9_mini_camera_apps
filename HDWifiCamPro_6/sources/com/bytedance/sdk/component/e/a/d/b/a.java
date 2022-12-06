package com.bytedance.sdk.component.e.a.d.b;

/* compiled from: PolicyConfig */
public class a {
    final int a;
    final int b;

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    a(int i, int i2, long j) {
        if (i2 >= i) {
            this.a = i;
            this.b = i2;
            return;
        }
        throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
    }

    public static a c() {
        return new a(1, 100, 172800000);
    }

    public static a d() {
        return new a(1, 100, -1);
    }

    public static a e() {
        return new a(3, 100, 172800000);
    }
}
