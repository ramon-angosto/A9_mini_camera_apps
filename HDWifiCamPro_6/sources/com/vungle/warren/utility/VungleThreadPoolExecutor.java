package com.vungle.warren.utility;

import com.vungle.warren.persistence.FutureResult;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class VungleThreadPoolExecutor extends ThreadPoolExecutor {
    public VungleThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }

    public void execute(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError unused) {
        }
    }

    public void execute(Runnable runnable, Runnable runnable2) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError unused) {
            runnable2.run();
        }
    }

    public Future<?> submit(Runnable runnable) {
        try {
            return super.submit(runnable);
        } catch (OutOfMemoryError unused) {
            return new FutureResult((Future) null);
        }
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        try {
            return super.submit(runnable, t);
        } catch (OutOfMemoryError unused) {
            return new FutureResult((Future) null);
        }
    }

    public Future<?> submit(Runnable runnable, Runnable runnable2) {
        try {
            return super.submit(runnable);
        } catch (OutOfMemoryError unused) {
            runnable2.run();
            return new FutureResult((Future) null);
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        try {
            return super.submit(callable);
        } catch (OutOfMemoryError unused) {
            return new FutureResult((Future) null);
        }
    }
}
