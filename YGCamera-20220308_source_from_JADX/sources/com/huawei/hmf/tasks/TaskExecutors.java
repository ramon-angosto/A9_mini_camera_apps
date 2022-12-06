package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p011a.C0580a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class TaskExecutors {
    private static final TaskExecutors INSTANCE = new TaskExecutors();
    private final ExecutorService mBackground = C0580a.m140a();
    private final Executor mImmediate = new ImmediateExecutor();
    private final Executor mUiThread = C0580a.m141b();

    static final class ImmediateExecutor implements Executor {
        ImmediateExecutor() {
        }

        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private TaskExecutors() {
    }

    static ExecutorService background() {
        return INSTANCE.mBackground;
    }

    public static Executor immediate() {
        return INSTANCE.mImmediate;
    }

    public static Executor uiThread() {
        return INSTANCE.mUiThread;
    }
}
