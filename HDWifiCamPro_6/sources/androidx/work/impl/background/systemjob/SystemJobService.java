package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("SystemJobService");
    private final Map<String, JobParameters> mJobParameters = new HashMap();
    private WorkManagerImpl mWorkManagerImpl;

    public void onCreate() {
        super.onCreate();
        try {
            this.mWorkManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.getProcessor().removeExecutionListener(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r2.triggeredContentUris = java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r2.triggeredContentAuthorities = java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        r2.network = r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r8.mWorkManagerImpl.startWork(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a9, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            androidx.work.impl.WorkManagerImpl r0 = r8.mWorkManagerImpl
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r3 = TAG
            java.lang.Throwable[] r4 = new java.lang.Throwable[r2]
            java.lang.String r5 = "WorkManager is not initialized; requesting retry."
            r0.debug(r3, r5, r4)
            r8.jobFinished(r9, r1)
            return r2
        L_0x0017:
            java.lang.String r0 = getWorkSpecIdFromJobParameters(r9)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x002f
            androidx.work.Logger r9 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]
            java.lang.String r3 = "WorkSpec id not found!"
            r9.error(r0, r3, r1)
            return r2
        L_0x002f:
            java.util.Map<java.lang.String, android.app.job.JobParameters> r3 = r8.mJobParameters
            monitor-enter(r3)
            java.util.Map<java.lang.String, android.app.job.JobParameters> r4 = r8.mJobParameters     // Catch:{ all -> 0x00aa }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00aa }
            if (r4 == 0) goto L_0x0051
            androidx.work.Logger r9 = androidx.work.Logger.get()     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00aa }
            java.lang.String r5 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00aa }
            r1[r2] = r0     // Catch:{ all -> 0x00aa }
            java.lang.String r0 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x00aa }
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00aa }
            r9.debug(r4, r0, r1)     // Catch:{ all -> 0x00aa }
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            return r2
        L_0x0051:
            androidx.work.Logger r4 = androidx.work.Logger.get()     // Catch:{ all -> 0x00aa }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00aa }
            r7[r2] = r0     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00aa }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00aa }
            r4.debug(r5, r6, r2)     // Catch:{ all -> 0x00aa }
            java.util.Map<java.lang.String, android.app.job.JobParameters> r2 = r8.mJobParameters     // Catch:{ all -> 0x00aa }
            r2.put(r0, r9)     // Catch:{ all -> 0x00aa }
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x00a4
            androidx.work.WorkerParameters$RuntimeExtras r2 = new androidx.work.WorkerParameters$RuntimeExtras
            r2.<init>()
            android.net.Uri[] r3 = r9.getTriggeredContentUris()
            if (r3 == 0) goto L_0x0088
            android.net.Uri[] r3 = r9.getTriggeredContentUris()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.triggeredContentUris = r3
        L_0x0088:
            java.lang.String[] r3 = r9.getTriggeredContentAuthorities()
            if (r3 == 0) goto L_0x0098
            java.lang.String[] r3 = r9.getTriggeredContentAuthorities()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.triggeredContentAuthorities = r3
        L_0x0098:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r3 < r4) goto L_0x00a4
            android.net.Network r9 = r9.getNetwork()
            r2.network = r9
        L_0x00a4:
            androidx.work.impl.WorkManagerImpl r9 = r8.mWorkManagerImpl
            r9.startWork(r0, r2)
            return r1
        L_0x00aa:
            r9 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String workSpecIdFromJobParameters = getWorkSpecIdFromJobParameters(jobParameters);
        if (TextUtils.isEmpty(workSpecIdFromJobParameters)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.get().debug(TAG, String.format("onStopJob for %s", new Object[]{workSpecIdFromJobParameters}), new Throwable[0]);
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(workSpecIdFromJobParameters);
        }
        this.mWorkManagerImpl.stopWork(workSpecIdFromJobParameters);
        return !this.mWorkManagerImpl.getProcessor().isCancelled(workSpecIdFromJobParameters);
    }

    public void onExecuted(String str, boolean z) {
        JobParameters remove;
        Logger.get().debug(TAG, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.mJobParameters) {
            remove = this.mJobParameters.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    private static String getWorkSpecIdFromJobParameters(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }
}
