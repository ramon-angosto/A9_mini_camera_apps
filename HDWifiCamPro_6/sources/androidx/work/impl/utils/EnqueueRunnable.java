package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation = new OperationImpl();
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.setState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.mWorkContinuation}));
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            boolean z2 = false;
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z2 |= processContinuation(next);
                } else {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.getIds())}), new Throwable[0]);
                }
            }
            z = z2;
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01e8 A[LOOP:7: B:119:0x01e2->B:121:0x01e8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0211 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r18, java.util.List<? extends androidx.work.WorkRequest> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r22
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r18.getWorkDatabase()
            r7 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = r7
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r12 = r7
            r11 = 0
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            androidx.work.impl.model.WorkSpecDao r8 = r6.workSpecDao()
            androidx.work.impl.model.WorkSpec r8 = r8.getWorkSpec(r15)
            if (r8 != 0) goto L_0x0045
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r3 = 0
            r2[r3] = r15
            java.lang.String r4 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r0.error(r1, r2, r4)
            return r3
        L_0x0045:
            androidx.work.WorkInfo$State r8 = r8.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r8 != r15) goto L_0x004d
            r15 = r7
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r8 != r15) goto L_0x0055
            r14 = r7
            goto L_0x005a
        L_0x0055:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r8 != r15) goto L_0x005a
            r13 = r7
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = r7
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r8 = android.text.TextUtils.isEmpty(r21)
            r8 = r8 ^ r7
            if (r8 == 0) goto L_0x006b
            if (r9 != 0) goto L_0x006b
            r10 = r7
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x0151
            androidx.work.impl.model.WorkSpecDao r10 = r6.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x0151
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND
            if (r3 == r11) goto L_0x00cf
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r11) goto L_0x0085
            goto L_0x00cf
        L_0x0085:
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.KEEP
            if (r3 != r11) goto L_0x00aa
            java.util.Iterator r3 = r10.iterator()
        L_0x008d:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x00aa
            java.lang.Object r11 = r3.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            androidx.work.WorkInfo$State r15 = r11.state
            androidx.work.WorkInfo$State r7 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 == r7) goto L_0x00a8
            androidx.work.WorkInfo$State r7 = r11.state
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.RUNNING
            if (r7 != r11) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r7 = 1
            goto L_0x008d
        L_0x00a8:
            r7 = 0
            return r7
        L_0x00aa:
            r7 = 0
            androidx.work.impl.utils.CancelWorkRunnable r3 = androidx.work.impl.utils.CancelWorkRunnable.forName(r2, r0, r7)
            r3.run()
            androidx.work.impl.model.WorkSpecDao r3 = r6.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00ba:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00cc
            java.lang.Object r11 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            java.lang.String r11 = r11.id
            r3.delete(r11)
            goto L_0x00ba
        L_0x00cc:
            r3 = 1
            goto L_0x0152
        L_0x00cf:
            r7 = 0
            androidx.work.impl.model.DependencyDao r9 = r6.dependencyDao()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00dd:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x0119
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r7 = r15.id
            boolean r7 = r9.hasDependents(r7)
            if (r7 != 0) goto L_0x0113
            androidx.work.WorkInfo$State r7 = r15.state
            r16 = r9
            androidx.work.WorkInfo$State r9 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r9) goto L_0x00fb
            r7 = 1
            goto L_0x00fc
        L_0x00fb:
            r7 = 0
        L_0x00fc:
            r7 = r7 & r12
            androidx.work.WorkInfo$State r9 = r15.state
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.FAILED
            if (r9 != r12) goto L_0x0105
            r14 = 1
            goto L_0x010c
        L_0x0105:
            androidx.work.WorkInfo$State r9 = r15.state
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.CANCELLED
            if (r9 != r12) goto L_0x010c
            r13 = 1
        L_0x010c:
            java.lang.String r9 = r15.id
            r11.add(r9)
            r12 = r7
            goto L_0x0115
        L_0x0113:
            r16 = r9
        L_0x0115:
            r9 = r16
            r7 = 0
            goto L_0x00dd
        L_0x0119:
            androidx.work.ExistingWorkPolicy r7 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r7) goto L_0x0145
            if (r13 != 0) goto L_0x0121
            if (r14 == 0) goto L_0x0145
        L_0x0121:
            androidx.work.impl.model.WorkSpecDao r3 = r6.workSpecDao()
            java.util.List r7 = r3.getWorkSpecIdAndStatesForName(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x012d:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x013f
            java.lang.Object r9 = r7.next()
            androidx.work.impl.model.WorkSpec$IdAndState r9 = (androidx.work.impl.model.WorkSpec.IdAndState) r9
            java.lang.String r9 = r9.id
            r3.delete(r9)
            goto L_0x012d
        L_0x013f:
            java.util.List r11 = java.util.Collections.emptyList()
            r13 = 0
            r14 = 0
        L_0x0145:
            java.lang.Object[] r1 = r11.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r3 = r1.length
            if (r3 <= 0) goto L_0x0150
            r9 = 1
            goto L_0x0151
        L_0x0150:
            r9 = 0
        L_0x0151:
            r3 = 0
        L_0x0152:
            java.util.Iterator r7 = r19.iterator()
        L_0x0156:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0217
            java.lang.Object r10 = r7.next()
            androidx.work.WorkRequest r10 = (androidx.work.WorkRequest) r10
            androidx.work.impl.model.WorkSpec r11 = r10.getWorkSpec()
            if (r9 == 0) goto L_0x017d
            if (r12 != 0) goto L_0x017d
            if (r14 == 0) goto L_0x0171
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            r11.state = r15
            goto L_0x0185
        L_0x0171:
            if (r13 == 0) goto L_0x0178
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            r11.state = r15
            goto L_0x0185
        L_0x0178:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            r11.state = r15
            goto L_0x0185
        L_0x017d:
            boolean r15 = r11.isPeriodic()
            if (r15 != 0) goto L_0x0188
            r11.periodStartTime = r4
        L_0x0185:
            r16 = r4
            goto L_0x018e
        L_0x0188:
            r16 = r4
            r4 = 0
            r11.periodStartTime = r4
        L_0x018e:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x019e
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 25
            if (r4 > r5) goto L_0x019e
            tryDelegateConstrainedWorkSpec(r11)
            goto L_0x01af
        L_0x019e:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 22
            if (r4 > r5) goto L_0x01af
            java.lang.String r4 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r4 = usesScheduler(r0, r4)
            if (r4 == 0) goto L_0x01af
            tryDelegateConstrainedWorkSpec(r11)
        L_0x01af:
            androidx.work.WorkInfo$State r4 = r11.state
            androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.ENQUEUED
            if (r4 != r5) goto L_0x01b6
            r3 = 1
        L_0x01b6:
            androidx.work.impl.model.WorkSpecDao r4 = r6.workSpecDao()
            r4.insertWorkSpec(r11)
            if (r9 == 0) goto L_0x01da
            int r4 = r1.length
            r5 = 0
        L_0x01c1:
            if (r5 >= r4) goto L_0x01da
            r11 = r1[r5]
            androidx.work.impl.model.Dependency r15 = new androidx.work.impl.model.Dependency
            java.lang.String r0 = r10.getStringId()
            r15.<init>(r0, r11)
            androidx.work.impl.model.DependencyDao r0 = r6.dependencyDao()
            r0.insertDependency(r15)
            int r5 = r5 + 1
            r0 = r18
            goto L_0x01c1
        L_0x01da:
            java.util.Set r0 = r10.getTags()
            java.util.Iterator r0 = r0.iterator()
        L_0x01e2:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01ff
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.work.impl.model.WorkTagDao r5 = r6.workTagDao()
            androidx.work.impl.model.WorkTag r11 = new androidx.work.impl.model.WorkTag
            java.lang.String r15 = r10.getStringId()
            r11.<init>(r4, r15)
            r5.insert(r11)
            goto L_0x01e2
        L_0x01ff:
            if (r8 == 0) goto L_0x0211
            androidx.work.impl.model.WorkNameDao r0 = r6.workNameDao()
            androidx.work.impl.model.WorkName r4 = new androidx.work.impl.model.WorkName
            java.lang.String r5 = r10.getStringId()
            r4.<init>(r2, r5)
            r0.insert(r4)
        L_0x0211:
            r0 = r18
            r4 = r16
            goto L_0x0156
        L_0x0217:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    private static boolean usesScheduler(WorkManagerImpl workManagerImpl, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.getSchedulers()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
