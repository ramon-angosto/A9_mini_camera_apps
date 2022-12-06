package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutor mBackgroundExecutor;
    private final Executor mMainThreadExecutor = new Executor() {
        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.postToMainThread(runnable);
        }
    };
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    public WorkManagerTaskExecutor(Executor executor) {
        this.mBackgroundExecutor = new SerialExecutor(executor);
    }

    public void postToMainThread(Runnable runnable) {
        this.mMainThreadHandler.post(runnable);
    }

    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    public void executeOnBackgroundThread(Runnable runnable) {
        this.mBackgroundExecutor.execute(runnable);
    }

    public SerialExecutor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }
}
