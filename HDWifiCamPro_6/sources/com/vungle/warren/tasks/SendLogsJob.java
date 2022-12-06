package com.vungle.warren.tasks;

import android.os.Bundle;
import com.vungle.warren.log.LogManager;

public class SendLogsJob implements Job {
    static final String TAG = SendLogsJob.class.getSimpleName();
    private LogManager logManager;

    public SendLogsJob(LogManager logManager2) {
        this.logManager = logManager2;
    }

    public static JobInfo makeJobInfo() {
        return new JobInfo(TAG).setPriority(2);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        this.logManager.sendSdkLogs();
        return 0;
    }
}
