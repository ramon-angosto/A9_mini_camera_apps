package com.iab.omid.library.bigosg.h.a;

import com.iab.omid.library.bigosg.h.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class c implements b.a {
    private final BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.a);
    private final ArrayDeque<b> c = new ArrayDeque<>();
    private b d = null;

    private void b() {
        this.d = this.c.poll();
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(this.b);
        }
    }

    public final void a() {
        this.d = null;
        b();
    }

    public final void a(b bVar) {
        bVar.d = this;
        this.c.add(bVar);
        if (this.d == null) {
            b();
        }
    }
}
