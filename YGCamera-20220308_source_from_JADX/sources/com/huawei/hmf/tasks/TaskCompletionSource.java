package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p011a.C0593i;

public class TaskCompletionSource<TResult> {
    /* access modifiers changed from: private */
    public final C0593i<TResult> task = new C0593i<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.register(new Runnable() {
            public void run() {
                TaskCompletionSource.this.task.mo12856a();
            }
        });
    }

    public Task<TResult> getTask() {
        return this.task;
    }

    public void setException(Exception exc) {
        this.task.mo12854a(exc);
    }

    public void setResult(TResult tresult) {
        this.task.mo12855a(tresult);
    }
}
