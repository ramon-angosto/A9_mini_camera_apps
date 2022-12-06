package com.huawei.hmf.tasks.p011a;

import android.os.Looper;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.j */
public final class C0601j {

    /* renamed from: com.huawei.hmf.tasks.a.j$a */
    public static class C0605a<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

        /* renamed from: a */
        public final CountDownLatch f233a = new CountDownLatch(1);

        public final void onCanceled() {
            this.f233a.countDown();
        }

        public final void onFailure(Exception exc) {
            this.f233a.countDown();
        }

        public final void onSuccess(TResult tresult) {
            this.f233a.countDown();
        }
    }

    /* renamed from: a */
    public static <TResult> Task<TResult> m159a(TResult tresult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    /* renamed from: a */
    public static Task<List<Task<?>>> m160a(final Collection<? extends Task<?>> collection) {
        return m164c(collection).continueWith(new Continuation<Void, List<Task<?>>>() {
            public final /* synthetic */ Object then(Task task) throws Exception {
                ArrayList arrayList = new ArrayList(collection.size());
                arrayList.addAll(collection);
                return arrayList;
            }
        });
    }

    /* renamed from: a */
    public static <TResult> TResult m161a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: a */
    public static void m162a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: b */
    public static <TResult> Task<List<TResult>> m163b(final Collection<? extends Task<?>> collection) {
        return m164c(collection).continueWith(new Continuation<Void, List<TResult>>() {
            public final /* synthetic */ Object then(Task task) throws Exception {
                ArrayList arrayList = new ArrayList();
                for (Task result : collection) {
                    arrayList.add(result.getResult());
                }
                return arrayList;
            }
        });
    }

    /* renamed from: c */
    public static Task<Void> m164c(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return m159a((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        C0593i iVar = new C0593i();
        C0587e eVar = new C0587e(collection.size(), iVar);
        for (Task task2 : collection) {
            task2.addOnSuccessListener(TaskExecutors.immediate(), eVar);
            task2.addOnFailureListener(TaskExecutors.immediate(), (OnFailureListener) eVar);
            task2.addOnCanceledListener(TaskExecutors.immediate(), (OnCanceledListener) eVar);
        }
        return iVar;
    }

    /* renamed from: a */
    public final <TResult> Task<TResult> mo12857a(Executor executor, final Callable<TResult> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() {
                public final void run() {
                    try {
                        taskCompletionSource.setResult(callable.call());
                    } catch (Exception e) {
                        taskCompletionSource.setException(e);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
        return taskCompletionSource.getTask();
    }
}
