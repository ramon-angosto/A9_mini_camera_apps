package androidx.work.multiprocess;

import androidx.work.OneTimeWorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public abstract class RemoteWorkContinuation {
    /* access modifiers changed from: protected */
    public abstract RemoteWorkContinuation combineInternal(List<RemoteWorkContinuation> list);

    public abstract ListenableFuture<Void> enqueue();

    public abstract RemoteWorkContinuation then(List<OneTimeWorkRequest> list);

    protected RemoteWorkContinuation() {
    }

    public final RemoteWorkContinuation then(OneTimeWorkRequest oneTimeWorkRequest) {
        return then((List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    public static RemoteWorkContinuation combine(List<RemoteWorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }
}
