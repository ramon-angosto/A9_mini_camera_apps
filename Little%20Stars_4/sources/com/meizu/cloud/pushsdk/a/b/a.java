package com.meizu.cloud.pushsdk.a.b;

import com.meizu.cloud.pushsdk.a.a.d;
import com.meizu.cloud.pushsdk.a.f.c;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a extends ThreadPoolExecutor {
    a(int i, ThreadFactory threadFactory) {
        super(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
    }

    public Future<?> submit(Runnable runnable) {
        C0041a aVar = new C0041a((c) runnable);
        execute(aVar);
        return aVar;
    }

    /* renamed from: com.meizu.cloud.pushsdk.a.b.a$a  reason: collision with other inner class name */
    private static final class C0041a extends FutureTask<c> implements Comparable<C0041a> {
        private final c a;

        public C0041a(c cVar) {
            super(cVar, (Object) null);
            this.a = cVar;
        }

        /* renamed from: a */
        public int compareTo(C0041a aVar) {
            d a2 = this.a.a();
            d a3 = aVar.a.a();
            return a2 == a3 ? this.a.a - aVar.a.a : a3.ordinal() - a2.ordinal();
        }
    }
}
