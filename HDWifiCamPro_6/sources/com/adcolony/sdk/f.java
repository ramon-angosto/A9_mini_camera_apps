package com.adcolony.sdk;

class f {
    private boolean a;

    f() {
    }

    public synchronized void a(long j) {
        if (!this.a) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
            }
        }
    }

    public synchronized void a(boolean z) {
        this.a = z;
        if (z) {
            notifyAll();
        }
    }

    public boolean a() {
        return this.a;
    }
}
