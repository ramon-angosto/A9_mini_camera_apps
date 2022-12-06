package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: RequestQueue */
public class j {
    private static final String a = j.class.getSimpleName();
    /* access modifiers changed from: private */
    public Context b;
    /* access modifiers changed from: private */
    public c c;
    private Set<i> d = new HashSet();
    private ExecutorService e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());
    private AtomicInteger f = new AtomicInteger();

    public j(Context context) {
        this.b = context.getApplicationContext();
        this.c = new d(new Handler(Looper.getMainLooper()));
    }

    public final void a(final i iVar) {
        iVar.a(this);
        synchronized (this) {
            this.d.add(iVar);
        }
        iVar.a(this.f.incrementAndGet());
        this.e.execute(new Runnable() {
            public final void run() {
                new h(j.this.b, (SSLSocketFactory) null, j.this.c).a(iVar);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b(i iVar) {
        synchronized (this) {
            this.d.remove(iVar);
        }
    }
}
