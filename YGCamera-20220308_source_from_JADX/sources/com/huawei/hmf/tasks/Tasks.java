package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p011a.C0593i;
import com.huawei.hmf.tasks.p011a.C0601j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tasks {
    private static C0601j IMPL = new C0601j();

    public static Task<List<Task<?>>> allOf(Collection<? extends Task<?>> collection) {
        return C0601j.m160a(collection);
    }

    public static Task<List<Task<?>>> allOf(Task<?>... taskArr) {
        return C0601j.m160a((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        C0601j.m162a("await must not be called on the UI thread");
        if (task.isComplete()) {
            return C0601j.m161a(task);
        }
        C0601j.C0605a aVar = new C0601j.C0605a();
        task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
        aVar.f233a.await();
        return C0601j.m161a(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C0601j.m162a("await must not be called on the UI thread");
        if (!task.isComplete()) {
            C0601j.C0605a aVar = new C0601j.C0605a();
            task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
            if (!aVar.f233a.await(j, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return C0601j.m161a(task);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return IMPL.mo12857a(TaskExecutors.immediate(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return IMPL.mo12857a(TaskExecutors.background(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Executor executor, Callable<TResult> callable) {
        return IMPL.mo12857a(executor, callable);
    }

    public static <TResult> Task<TResult> fromCanceled() {
        C0593i iVar = new C0593i();
        iVar.mo12856a();
        return iVar;
    }

    public static <TResult> Task<TResult> fromException(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> fromResult(TResult tresult) {
        return C0601j.m159a(tresult);
    }

    public static Task<Void> join(Collection<? extends Task<?>> collection) {
        return C0601j.m164c(collection);
    }

    public static Task<Void> join(Task<?>... taskArr) {
        return C0601j.m164c(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> successOf(Collection<? extends Task<TResult>> collection) {
        return C0601j.m163b(collection);
    }

    public static <TResult> Task<List<TResult>> successOf(Task<?>... taskArr) {
        return C0601j.m163b(Arrays.asList(taskArr));
    }
}
