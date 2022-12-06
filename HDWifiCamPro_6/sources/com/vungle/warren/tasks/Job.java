package com.vungle.warren.tasks;

import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Job {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
        public static final int FAILURE = 1;
        public static final int RESCHEDULE = 2;
        public static final int SUCCESS = 0;
    }

    int onRunJob(Bundle bundle, JobRunner jobRunner);
}
