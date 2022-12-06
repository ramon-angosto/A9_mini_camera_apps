package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {
    private static final String TAG = Logger.tagWithPrefix("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        WorkDatabase workDatabase = WorkManagerImpl.getInstance(getApplicationContext()).getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao = workDatabase.workNameDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        List<WorkSpec> recentlyCompletedWork = workSpecDao.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<WorkSpec> runningWork = workSpecDao.getRunningWork();
        List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
        if (recentlyCompletedWork != null && !recentlyCompletedWork.isEmpty()) {
            Logger.get().info(TAG, "Recently completed work:\n\n", new Throwable[0]);
            Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, recentlyCompletedWork), new Throwable[0]);
        }
        if (runningWork != null && !runningWork.isEmpty()) {
            Logger.get().info(TAG, "Running work:\n\n", new Throwable[0]);
            Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork), new Throwable[0]);
        }
        if (allEligibleWorkSpecsForScheduling != null && !allEligibleWorkSpecsForScheduling.isEmpty()) {
            Logger.get().info(TAG, "Enqueued work:\n\n", new Throwable[0]);
            Logger.get().info(TAG, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling), new Throwable[0]);
        }
        return ListenableWorker.Result.success();
    }

    private static String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"}));
        for (WorkSpec next : list) {
            Integer num = null;
            SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(next.id);
            if (systemIdInfo != null) {
                num = Integer.valueOf(systemIdInfo.systemId);
            }
            sb.append(workSpecRow(next, TextUtils.join(",", workNameDao.getNamesForWorkSpecId(next.id)), num, TextUtils.join(",", workTagDao.getTagsForWorkSpecId(next.id))));
        }
        return sb.toString();
    }

    private static String workSpecRow(WorkSpec workSpec, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{workSpec.id, workSpec.workerClassName, num, workSpec.state.name(), str, str2});
    }
}
