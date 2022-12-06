package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {

    /* renamed from: a */
    private R f949a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f950b;

    /* renamed from: com.huawei.hms.support.api.ErrorResultImpl$a */
    class C0901a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ResultCallback f951a;

        C0901a(ResultCallback resultCallback) {
            this.f951a = resultCallback;
        }

        public void run() {
            ResultCallback resultCallback = this.f951a;
            ErrorResultImpl errorResultImpl = ErrorResultImpl.this;
            resultCallback.onResult(errorResultImpl.m1344a(errorResultImpl.f950b));
        }
    }

    public ErrorResultImpl(int i) {
        this.f950b = i;
    }

    public final R await() {
        return await(0, (TimeUnit) null);
    }

    @Deprecated
    public void cancel() {
    }

    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public final void setResultCallback(ResultCallback<R> resultCallback) {
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    public R await(long j, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return m1344a(this.f950b);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public R m1344a(int i) {
        Type genericSuperclass = ErrorResultImpl.class.getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        try {
            this.f949a = (Result) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).newInstance();
            this.f949a.setStatus(new Status(i));
        } catch (InstantiationException unused) {
            HMSLog.m1377e("ErrorResultImpl", "InstantiationException");
        } catch (IllegalAccessException unused2) {
            HMSLog.m1377e("ErrorResultImpl", "IllegalAccessException");
        }
        return this.f949a;
    }

    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        if (looper == null) {
            looper = Looper.myLooper();
        }
        new Handler(looper).post(new C0901a(resultCallback));
    }
}
