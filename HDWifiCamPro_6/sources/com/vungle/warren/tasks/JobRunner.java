package com.vungle.warren.tasks;

public interface JobRunner {
    void cancelPendingJob(String str);

    void execute(JobInfo jobInfo);
}
