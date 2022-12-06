package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsEnhance {

    private static class DelegatedExecutorService extends AbstractExecutorService {

        /* renamed from: e */
        private final ExecutorService f444e;

        DelegatedExecutorService(ExecutorService executorService) {
            this.f444e = executorService;
        }

        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return this.f444e.awaitTermination(j, timeUnit);
        }

        public void execute(Runnable runnable) {
            this.f444e.execute(runnable);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.f444e.invokeAll(collection);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
            return this.f444e.invokeAll(collection, j, timeUnit);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return this.f444e.invokeAny(collection);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
            return this.f444e.invokeAny(collection, j, timeUnit);
        }

        public boolean isShutdown() {
            return this.f444e.isShutdown();
        }

        public boolean isTerminated() {
            return this.f444e.isTerminated();
        }

        public void shutdown() {
            this.f444e.shutdown();
        }

        public List<Runnable> shutdownNow() {
            return this.f444e.shutdownNow();
        }

        public Future<?> submit(Runnable runnable) {
            return this.f444e.submit(runnable);
        }

        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.f444e.submit(runnable, t);
        }

        public <T> Future<T> submit(Callable<T> callable) {
            return this.f444e.submit(callable);
        }
    }

    private static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        FinalizableDelegatedExecutorService(ExecutorService executorService) {
            super(executorService);
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            super.shutdown();
        }
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExcutorEnhance(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory));
    }
}
