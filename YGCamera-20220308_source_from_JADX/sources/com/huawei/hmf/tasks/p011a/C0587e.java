package com.huawei.hmf.tasks.p011a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* renamed from: com.huawei.hmf.tasks.a.e */
final class C0587e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a */
    private final Object f189a = new Object();

    /* renamed from: b */
    private final int f190b;

    /* renamed from: c */
    private final C0593i<Void> f191c;

    /* renamed from: d */
    private int f192d;

    /* renamed from: e */
    private Exception f193e;

    /* renamed from: f */
    private boolean f194f;

    C0587e(int i, C0593i<Void> iVar) {
        this.f190b = i;
        this.f191c = iVar;
    }

    /* renamed from: a */
    private void m146a() {
        if (this.f192d >= this.f190b) {
            Exception exc = this.f193e;
            if (exc != null) {
                this.f191c.mo12854a((Exception) new ExecutionException("a task failed", exc));
            } else if (this.f194f) {
                this.f191c.mo12856a();
            } else {
                this.f191c.mo12855a(null);
            }
        }
    }

    public final void onCanceled() {
        synchronized (this.f189a) {
            this.f192d++;
            this.f194f = true;
            m146a();
        }
    }

    public final void onFailure(Exception exc) {
        synchronized (this.f189a) {
            this.f192d++;
            this.f193e = exc;
            m146a();
        }
    }

    public final void onSuccess(TResult tresult) {
        synchronized (this.f189a) {
            this.f192d++;
            m146a();
        }
    }
}
