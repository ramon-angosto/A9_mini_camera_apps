package com.vungle.warren.persistence;

import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureResult<T> implements Future<T> {
    public static final String TAG = FutureResult.class.getSimpleName();
    private final Future<T> future;

    public FutureResult(Future<T> future2) {
        this.future = future2;
    }

    public boolean cancel(boolean z) {
        return this.future.cancel(z);
    }

    public boolean isCancelled() {
        return this.future.isCancelled();
    }

    public boolean isDone() {
        return this.future.isDone();
    }

    public T get() {
        try {
            return this.future.get();
        } catch (InterruptedException unused) {
            String str = TAG;
            Log.w(str, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Log.e(TAG, "error on execution", e);
            return null;
        }
    }

    public T get(long j, TimeUnit timeUnit) {
        try {
            return this.future.get(j, timeUnit);
        } catch (InterruptedException unused) {
            String str = TAG;
            Log.w(str, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            Log.e(TAG, "error on execution", e);
            return null;
        } catch (TimeoutException unused2) {
            String str2 = TAG;
            Log.w(str2, "future.get() Timeout on Thread " + Thread.currentThread().getName());
            return null;
        }
    }
}
