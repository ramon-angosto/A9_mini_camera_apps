package com.iab.omid.library.vungle.walking.a;

import com.iab.omid.library.vungle.walking.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {
    private final BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.a);
    private final ArrayDeque<b> c = new ArrayDeque<>();
    private b d = null;

    private void a() {
        this.d = this.c.poll();
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(this.b);
        }
    }

    public void a(b bVar) {
        this.d = null;
        a();
    }

    public void b(b bVar) {
        bVar.a((b.a) this);
        this.c.add(bVar);
        if (this.d == null) {
            a();
        }
    }
}
