package com.huawei.hmf.tasks.p011a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.f */
public final class C0588f<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnFailureListener f195a;

    /* renamed from: b */
    private Executor f196b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f197c = new Object();

    C0588f(Executor executor, OnFailureListener onFailureListener) {
        this.f195a = onFailureListener;
        this.f196b = executor;
    }

    public final void cancel() {
        synchronized (this.f197c) {
            this.f195a = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            this.f196b.execute(new Runnable() {
                public final void run() {
                    synchronized (C0588f.this.f197c) {
                        if (C0588f.this.f195a != null) {
                            C0588f.this.f195a.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
