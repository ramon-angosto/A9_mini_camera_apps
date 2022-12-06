package com.bytedance.sdk.openadsdk.l;

import android.os.SystemClock;

/* compiled from: TimeStamp */
public class x {
    public long a;
    private long b;

    private x(boolean z) {
        if (z) {
            d();
        }
    }

    public static x a() {
        return new x(true);
    }

    public static x b() {
        return new x(false);
    }

    public long a(x xVar) {
        return Math.abs(xVar.b - this.b);
    }

    public long c() {
        return SystemClock.elapsedRealtime() - this.b;
    }

    public void d() {
        this.a = System.currentTimeMillis();
        this.b = SystemClock.elapsedRealtime();
    }

    public boolean e() {
        return this.b > 0;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
