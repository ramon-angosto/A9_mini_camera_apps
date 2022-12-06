package com.meizu.cloud.pushsdk.a.h;

import java.io.IOException;

public abstract class e implements k {
    private final k a;

    public e(k kVar) {
        if (kVar != null) {
            this.a = kVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void a(a aVar, long j) throws IOException {
        this.a.a(aVar, j);
    }

    public void flush() throws IOException {
        this.a.flush();
    }

    public void close() throws IOException {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
