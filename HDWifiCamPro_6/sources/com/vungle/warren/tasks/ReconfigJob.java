package com.vungle.warren.tasks;

import android.os.Bundle;

public class ReconfigJob implements Job {
    public static final String TAG = ReconfigJob.class.getCanonicalName();
    private ReconfigCall reconfigCall;

    public interface ReconfigCall {
        void reConfigVungle();
    }

    public ReconfigJob(ReconfigCall reconfigCall2) {
        this.reconfigCall = reconfigCall2;
    }

    public static JobInfo makeJobInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        return new JobInfo(TAG).setExtras(bundle).setUpdateCurrent(true).setPriority(4);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        if (bundle.getString("appId", (String) null) == null) {
            return 1;
        }
        this.reconfigCall.reConfigVungle();
        return 0;
    }
}
