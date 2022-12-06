package com.apm.insight.j;

import android.os.Handler;

public abstract class a implements Runnable {
    private Handler a;
    private final long b;
    private final long c;

    a(Handler handler, long j, long j2) {
        this.a = handler;
        this.b = j;
        this.c = j2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (b() > 0) {
            this.a.postDelayed(this, b());
        } else {
            this.a.post(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        if (j > 0) {
            this.a.postDelayed(this, j);
        } else {
            this.a.post(this);
        }
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }
}
