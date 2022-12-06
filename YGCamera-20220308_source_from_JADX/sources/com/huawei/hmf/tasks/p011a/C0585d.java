package com.huawei.hmf.tasks.p011a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.d */
public final class C0585d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    Executor f184a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnCompleteListener<TResult> f185b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f186c = new Object();

    C0585d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f185b = onCompleteListener;
        this.f184a = executor;
    }

    public final void cancel() {
        synchronized (this.f186c) {
            this.f185b = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        this.f184a.execute(new Runnable() {
            public final void run() {
                synchronized (C0585d.this.f186c) {
                    if (C0585d.this.f185b != null) {
                        C0585d.this.f185b.onComplete(task);
                    }
                }
            }
        });
    }
}
