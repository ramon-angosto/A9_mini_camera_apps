package com.huawei.hmf.tasks.p011a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.h */
public final class C0591h<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnSuccessListener<TResult> f202a;

    /* renamed from: b */
    private Executor f203b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f204c = new Object();

    C0591h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f202a = onSuccessListener;
        this.f203b = executor;
    }

    public final void cancel() {
        synchronized (this.f204c) {
            this.f202a = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() && !task.isCanceled()) {
            this.f203b.execute(new Runnable() {
                public final void run() {
                    synchronized (C0591h.this.f204c) {
                        if (C0591h.this.f202a != null) {
                            C0591h.this.f202a.onSuccess(task.getResult());
                        }
                    }
                }
            });
        }
    }
}
