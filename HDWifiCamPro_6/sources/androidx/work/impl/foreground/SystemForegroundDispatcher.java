package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    String mCurrentForegroundWorkSpecId;
    final Map<String, ForegroundInfo> mForegroundInfoById;
    final Object mLock;
    private final TaskExecutor mTaskExecutor;
    final Set<WorkSpec> mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map<String, WorkSpec> mWorkSpecById;

    interface Callback {
        void cancelNotification(int i);

        void notify(int i, Notification notification);

        void startForeground(int i, int i2, Notification notification);

        void stop();
    }

    public void onAllConstraintsMet(List<String> list) {
    }

    SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        this.mLock = new Object();
        this.mWorkManagerImpl = WorkManagerImpl.getInstance(this.mContext);
        this.mTaskExecutor = this.mWorkManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTracker(this.mContext, this.mTaskExecutor, this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    SystemForegroundDispatcher(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mLock = new Object();
        this.mWorkManagerImpl = workManagerImpl;
        this.mTaskExecutor = this.mWorkManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = workConstraintsTracker;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    public void onExecuted(String str, boolean z) {
        Map.Entry entry;
        synchronized (this.mLock) {
            WorkSpec remove = this.mWorkSpecById.remove(str);
            if (remove != null ? this.mTrackedWorkSpecs.remove(remove) : false) {
                this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);
            }
        }
        ForegroundInfo remove2 = this.mForegroundInfoById.remove(str);
        if (str.equals(this.mCurrentForegroundWorkSpecId) && this.mForegroundInfoById.size() > 0) {
            Iterator it = this.mForegroundInfoById.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.mCurrentForegroundWorkSpecId = (String) entry.getKey();
            if (this.mCallback != null) {
                ForegroundInfo foregroundInfo = (ForegroundInfo) entry.getValue();
                this.mCallback.startForeground(foregroundInfo.getNotificationId(), foregroundInfo.getForegroundServiceType(), foregroundInfo.getNotification());
                this.mCallback.cancelNotification(foregroundInfo.getNotificationId());
            }
        }
        Callback callback = this.mCallback;
        if (remove2 != null && callback != null) {
            Logger.get().debug(TAG, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(remove2.getNotificationId()), str, Integer.valueOf(remove2.getForegroundServiceType())}), new Throwable[0]);
            callback.cancelNotification(remove2.getNotificationId());
        }
    }

    /* access modifiers changed from: package-private */
    public void setCallback(Callback callback) {
        if (this.mCallback != null) {
            Logger.get().error(TAG, "A callback already exists.", new Throwable[0]);
        } else {
            this.mCallback = callback;
        }
    }

    /* access modifiers changed from: package-private */
    public WorkManagerImpl getWorkManager() {
        return this.mWorkManagerImpl;
    }

    /* access modifiers changed from: package-private */
    public void onStartCommand(Intent intent) {
        String action = intent.getAction();
        if (ACTION_START_FOREGROUND.equals(action)) {
            handleStartForeground(intent);
            handleNotify(intent);
        } else if (ACTION_NOTIFY.equals(action)) {
            handleNotify(intent);
        } else if (ACTION_CANCEL_WORK.equals(action)) {
            handleCancelWork(intent);
        } else if (ACTION_STOP_FOREGROUND.equals(action)) {
            handleStop(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.mCallback = null;
        synchronized (this.mLock) {
            this.mConstraintsTracker.reset();
        }
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
    }

    private void handleStartForeground(Intent intent) {
        Logger.get().info(TAG, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        final String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        final WorkDatabase workDatabase = this.mWorkManagerImpl.getWorkDatabase();
        this.mTaskExecutor.executeOnBackgroundThread(new Runnable() {
            public void run() {
                WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(stringExtra);
                if (workSpec != null && workSpec.hasConstraints()) {
                    synchronized (SystemForegroundDispatcher.this.mLock) {
                        SystemForegroundDispatcher.this.mWorkSpecById.put(stringExtra, workSpec);
                        SystemForegroundDispatcher.this.mTrackedWorkSpecs.add(workSpec);
                        SystemForegroundDispatcher.this.mConstraintsTracker.replace(SystemForegroundDispatcher.this.mTrackedWorkSpecs);
                    }
                }
            }
        });
    }

    private void handleNotify(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int intExtra2 = intent.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        Notification notification = (Notification) intent.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(TAG, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.mCallback != null) {
            this.mForegroundInfoById.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.mCurrentForegroundWorkSpecId)) {
                this.mCurrentForegroundWorkSpecId = stringExtra;
                this.mCallback.startForeground(intExtra, intExtra2, notification);
                return;
            }
            this.mCallback.notify(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, ForegroundInfo> value : this.mForegroundInfoById.entrySet()) {
                    i |= ((ForegroundInfo) value.getValue()).getForegroundServiceType();
                }
                ForegroundInfo foregroundInfo = this.mForegroundInfoById.get(this.mCurrentForegroundWorkSpecId);
                if (foregroundInfo != null) {
                    this.mCallback.startForeground(foregroundInfo.getNotificationId(), i, foregroundInfo.getNotification());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleStop(Intent intent) {
        Logger.get().info(TAG, "Stopping foreground service", new Throwable[0]);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.stop();
        }
    }

    private void handleCancelWork(Intent intent) {
        Logger.get().info(TAG, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.mWorkManagerImpl.cancelWorkById(UUID.fromString(stringExtra));
        }
    }

    public void onAllConstraintsNotMet(List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                Logger.get().debug(TAG, String.format("Constraints unmet for WorkSpec %s", new Object[]{next}), new Throwable[0]);
                this.mWorkManagerImpl.stopForegroundWork(next);
            }
        }
    }

    public static Intent createStartForegroundIntent(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_START_FOREGROUND);
        intent.putExtra(KEY_WORKSPEC_ID, str);
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    public static Intent createCancelWorkIntent(Context context, String str) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_CANCEL_WORK);
        intent.setData(Uri.parse(String.format("workspec://%s", new Object[]{str})));
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    public static Intent createNotifyIntent(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_NOTIFY);
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    public static Intent createStopForegroundIntent(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_STOP_FOREGROUND);
        return intent;
    }
}
