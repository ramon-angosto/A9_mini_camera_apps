package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

public class EmptyPendingResult<R extends Result> extends PendingResult<R> {

    /* renamed from: a */
    private R f961a;

    public R await() {
        return this.f961a;
    }

    public void cancel() {
    }

    public R getResult() {
        return this.f961a;
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResult(R r) {
        this.f961a = r;
    }

    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
    }

    public void setResultCallback(ResultCallback<R> resultCallback) {
    }

    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
    }

    public R await(long j, TimeUnit timeUnit) {
        return this.f961a;
    }
}
