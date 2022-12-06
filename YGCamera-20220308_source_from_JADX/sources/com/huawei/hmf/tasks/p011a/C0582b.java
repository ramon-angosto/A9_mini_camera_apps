package com.huawei.hmf.tasks.p011a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.b */
public final class C0582b<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnCanceledListener f177a;

    /* renamed from: b */
    private Executor f178b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f179c = new Object();

    C0582b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f177a = onCanceledListener;
        this.f178b = executor;
    }

    public final void cancel() {
        synchronized (this.f179c) {
            this.f177a = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.f178b.execute(new Runnable() {
                public final void run() {
                    synchronized (C0582b.this.f179c) {
                        if (C0582b.this.f177a != null) {
                            C0582b.this.f177a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
