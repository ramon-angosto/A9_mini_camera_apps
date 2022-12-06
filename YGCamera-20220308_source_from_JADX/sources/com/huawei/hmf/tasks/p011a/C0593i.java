package com.huawei.hmf.tasks.p011a;

import android.app.Activity;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.i */
public final class C0593i<TResult> extends Task<TResult> {

    /* renamed from: a */
    private final Object f207a = new Object();

    /* renamed from: b */
    private boolean f208b;

    /* renamed from: c */
    private volatile boolean f209c;

    /* renamed from: d */
    private TResult f210d;

    /* renamed from: e */
    private Exception f211e;

    /* renamed from: f */
    private List<ExecuteResult<TResult>> f212f = new ArrayList();

    /* renamed from: a */
    private Task<TResult> m154a(ExecuteResult<TResult> executeResult) {
        boolean isComplete;
        synchronized (this.f207a) {
            isComplete = isComplete();
            if (!isComplete) {
                this.f212f.add(executeResult);
            }
        }
        if (isComplete) {
            executeResult.onComplete(this);
        }
        return this;
    }

    /* renamed from: b */
    private void m155b() {
        synchronized (this.f207a) {
            for (ExecuteResult onComplete : this.f212f) {
                try {
                    onComplete.onComplete(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f212f = null;
        }
    }

    /* renamed from: a */
    public final void mo12854a(Exception exc) {
        synchronized (this.f207a) {
            if (!this.f208b) {
                this.f208b = true;
                this.f211e = exc;
                this.f207a.notifyAll();
                m155b();
            }
        }
    }

    /* renamed from: a */
    public final void mo12855a(TResult tresult) {
        synchronized (this.f207a) {
            if (!this.f208b) {
                this.f208b = true;
                this.f210d = tresult;
                this.f207a.notifyAll();
                m155b();
            }
        }
    }

    /* renamed from: a */
    public final boolean mo12856a() {
        synchronized (this.f207a) {
            if (this.f208b) {
                return false;
            }
            this.f208b = true;
            this.f209c = true;
            this.f207a.notifyAll();
            m155b();
            return true;
        }
    }

    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        C0582b bVar = new C0582b(TaskExecutors.uiThread(), onCanceledListener);
        C0590g.m151a(activity, bVar);
        return m154a(bVar);
    }

    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.uiThread(), onCanceledListener);
    }

    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return m154a(new C0582b(executor, onCanceledListener));
    }

    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        C0585d dVar = new C0585d(TaskExecutors.uiThread(), onCompleteListener);
        C0590g.m151a(activity, dVar);
        return m154a(dVar);
    }

    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.uiThread(), onCompleteListener);
    }

    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        return m154a(new C0585d(executor, onCompleteListener));
    }

    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        C0588f fVar = new C0588f(TaskExecutors.uiThread(), onFailureListener);
        C0590g.m151a(activity, fVar);
        return m154a(fVar);
    }

    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.uiThread(), onFailureListener);
    }

    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return m154a(new C0588f(executor, onFailureListener));
    }

    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<TResult> onSuccessListener) {
        C0591h hVar = new C0591h(TaskExecutors.uiThread(), onSuccessListener);
        C0590g.m151a(activity, hVar);
        return m154a(hVar);
    }

    public final Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.uiThread(), onSuccessListener);
    }

    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        return m154a(new C0591h(executor, onSuccessListener));
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.uiThread(), continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, final Continuation<TResult, TContinuationResult> continuation) {
        final C0593i iVar = new C0593i();
        addOnCompleteListener(executor, new OnCompleteListener<TResult>() {
            public final void onComplete(Task<TResult> task) {
                if (task.isCanceled()) {
                    iVar.mo12856a();
                    return;
                }
                try {
                    iVar.mo12855a(continuation.then(task));
                } catch (Exception e) {
                    iVar.mo12854a(e);
                }
            }
        });
        return iVar;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.uiThread(), continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, final Continuation<TResult, Task<TContinuationResult>> continuation) {
        final C0593i iVar = new C0593i();
        addOnCompleteListener(executor, new OnCompleteListener<TResult>() {
            public final void onComplete(Task<TResult> task) {
                try {
                    Task task2 = (Task) continuation.then(task);
                    if (task2 == null) {
                        iVar.mo12854a((Exception) new NullPointerException("Continuation returned null"));
                    } else {
                        task2.addOnCompleteListener(new OnCompleteListener<TContinuationResult>() {
                            public final void onComplete(Task<TContinuationResult> task) {
                                if (task.isSuccessful()) {
                                    iVar.mo12855a(task.getResult());
                                } else if (task.isCanceled()) {
                                    iVar.mo12856a();
                                } else {
                                    iVar.mo12854a(task.getException());
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    iVar.mo12854a(e);
                }
            }
        });
        return iVar;
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.f207a) {
            exc = this.f211e;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.f207a) {
            if (this.f211e == null) {
                tresult = this.f210d;
            } else {
                throw new RuntimeException(this.f211e);
            }
        }
        return tresult;
    }

    public final <E extends Throwable> TResult getResultThrowException(Class<E> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f207a) {
            if (cls != null) {
                if (cls.isInstance(this.f211e)) {
                    throw ((Throwable) cls.cast(this.f211e));
                }
            }
            if (this.f211e == null) {
                tresult = this.f210d;
            } else {
                throw new RuntimeException(this.f211e);
            }
        }
        return tresult;
    }

    public final boolean isCanceled() {
        return this.f209c;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f207a) {
            z = this.f208b;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f207a) {
            z = this.f208b && !isCanceled() && this.f211e == null;
        }
        return z;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.uiThread(), successContinuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, final SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        final C0593i iVar = new C0593i();
        addOnSuccessListener(executor, new OnSuccessListener<TResult>() {
            public final void onSuccess(TResult tresult) {
                try {
                    Task then = successContinuation.then(tresult);
                    if (then == null) {
                        iVar.mo12854a((Exception) new NullPointerException("SuccessContinuation returned null"));
                    } else {
                        then.addOnCompleteListener(new OnCompleteListener<TContinuationResult>() {
                            public final void onComplete(Task<TContinuationResult> task) {
                                if (task.isSuccessful()) {
                                    iVar.mo12855a(task.getResult());
                                } else if (task.isCanceled()) {
                                    iVar.mo12856a();
                                } else {
                                    iVar.mo12854a(task.getException());
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    iVar.mo12854a(e);
                }
            }
        });
        addOnFailureListener(new OnFailureListener() {
            public final void onFailure(Exception exc) {
                iVar.mo12854a(exc);
            }
        });
        addOnCanceledListener(new OnCanceledListener() {
            public final void onCanceled() {
                iVar.mo12856a();
            }
        });
        return iVar;
    }
}
