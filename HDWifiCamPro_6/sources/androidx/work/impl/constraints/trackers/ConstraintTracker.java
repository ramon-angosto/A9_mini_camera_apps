package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ConstraintTracker<T> {
    private static final String TAG = Logger.tagWithPrefix("ConstraintTracker");
    protected final Context mAppContext;
    T mCurrentState;
    private final Set<ConstraintListener<T>> mListeners = new LinkedHashSet();
    private final Object mLock = new Object();
    protected final TaskExecutor mTaskExecutor;

    public abstract T getInitialState();

    public abstract void startTracking();

    public abstract void stopTracking();

    ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public void addListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            if (this.mListeners.add(constraintListener)) {
                if (this.mListeners.size() == 1) {
                    this.mCurrentState = getInitialState();
                    Logger.get().debug(TAG, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.mCurrentState}), new Throwable[0]);
                    startTracking();
                }
                constraintListener.onConstraintChanged(this.mCurrentState);
            }
        }
    }

    public void removeListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            if (this.mListeners.remove(constraintListener) && this.mListeners.isEmpty()) {
                stopTracking();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setState(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            T r1 = r3.mCurrentState     // Catch:{ all -> 0x002f }
            if (r1 == r4) goto L_0x002d
            T r1 = r3.mCurrentState     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0014
            T r1 = r3.mCurrentState     // Catch:{ all -> 0x002f }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0014
            goto L_0x002d
        L_0x0014:
            r3.mCurrentState = r4     // Catch:{ all -> 0x002f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            java.util.Set<androidx.work.impl.constraints.ConstraintListener<T>> r1 = r3.mListeners     // Catch:{ all -> 0x002f }
            r4.<init>(r1)     // Catch:{ all -> 0x002f }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r1 = r3.mTaskExecutor     // Catch:{ all -> 0x002f }
            java.util.concurrent.Executor r1 = r1.getMainThreadExecutor()     // Catch:{ all -> 0x002f }
            androidx.work.impl.constraints.trackers.ConstraintTracker$1 r2 = new androidx.work.impl.constraints.trackers.ConstraintTracker$1     // Catch:{ all -> 0x002f }
            r2.<init>(r4)     // Catch:{ all -> 0x002f }
            r1.execute(r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.ConstraintTracker.setState(java.lang.Object):void");
    }
}
