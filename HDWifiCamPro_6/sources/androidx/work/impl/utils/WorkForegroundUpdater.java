package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String TAG = Logger.tagWithPrefix("WMFgUpdater");
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }

    public ListenableFuture<Void> setForegroundAsync(Context context, UUID uuid, ForegroundInfo foregroundInfo) {
        SettableFuture create = SettableFuture.create();
        final SettableFuture settableFuture = create;
        final UUID uuid2 = uuid;
        final ForegroundInfo foregroundInfo2 = foregroundInfo;
        final Context context2 = context;
        this.mTaskExecutor.executeOnBackgroundThread(new Runnable() {
            public void run() {
                try {
                    if (!settableFuture.isCancelled()) {
                        String uuid = uuid2.toString();
                        WorkInfo.State state = WorkForegroundUpdater.this.mWorkSpecDao.getState(uuid);
                        if (state == null || state.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        WorkForegroundUpdater.this.mForegroundProcessor.startForeground(uuid, foregroundInfo2);
                        context2.startService(SystemForegroundDispatcher.createNotifyIntent(context2, uuid, foregroundInfo2));
                    }
                    settableFuture.set(null);
                } catch (Throwable th) {
                    settableFuture.setException(th);
                }
            }
        });
        return create;
    }
}
