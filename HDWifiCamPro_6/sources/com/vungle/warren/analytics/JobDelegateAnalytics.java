package com.vungle.warren.analytics;

import com.google.gson.JsonObject;
import com.vungle.warren.tasks.AnalyticsJob;
import com.vungle.warren.tasks.JobRunner;

public class JobDelegateAnalytics implements AdAnalytics {
    private final JobRunner jobRunner;

    public void saveVungleUrls(String[] strArr) {
    }

    public JobDelegateAnalytics(JobRunner jobRunner2) {
        this.jobRunner = jobRunner2;
    }

    public String[] ping(String[] strArr) {
        this.jobRunner.execute(AnalyticsJob.makeJob(3, (String) null, strArr, 0));
        this.jobRunner.execute(AnalyticsJob.makeJob(1, (String) null, strArr, 1));
        return new String[0];
    }

    public void ri(JsonObject jsonObject) {
        this.jobRunner.execute(AnalyticsJob.makeJob(0, jsonObject.toString(), (String[]) null, 1));
    }

    public String[] retryUnsent() {
        this.jobRunner.execute(AnalyticsJob.makeJob(2, (String) null, (String[]) null, 1));
        return new String[0];
    }
}
