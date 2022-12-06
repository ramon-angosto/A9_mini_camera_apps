package com.meizu.cloud.pushsdk.a.h;

import java.io.IOException;
import java.io.InterruptedIOException;

public class m {
    public static final m a = new m() {
        public void a() throws IOException {
        }
    };
    private boolean b;
    private long c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
