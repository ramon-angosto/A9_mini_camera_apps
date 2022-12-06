package com.vungle.warren.tasks.utility;

import com.vungle.warren.tasks.JobInfo;

public class JobRunnerThreadPriorityHelper implements ThreadPriorityHelper {
    private static final String TAG = JobRunnerThreadPriorityHelper.class.getSimpleName();

    public int makeAndroidThreadPriority(JobInfo jobInfo) {
        return Math.min(19, Math.abs(Math.min(0, jobInfo.getPriority() - 2)) + 10);
    }
}
