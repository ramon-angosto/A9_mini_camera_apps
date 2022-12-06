package com.vungle.warren;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.vungle.warren.tasks.CacheBustJob;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.ActivityManager;

public class CacheBustManager {
    public static final String CACHE_BUST_INTERVAL = "cache_bust_interval";
    private static final int DEFAULT_REFRESH_RATE = 0;
    static final long MINIMUM_REFRESH_RATE = 900000;
    public static final String NEXT_CACHE_BUST = "next_cache_bust";
    public static final int NO_VALUE = Integer.MIN_VALUE;
    private JobRunner jobRunner;
    private long overrideRefreshRate = -2147483648L;
    private long refreshElapsed;
    long refreshRate = 0;
    private long startTrackingTime;
    private int status;

    protected CacheBustManager(JobRunner jobRunner2) {
        Class<CacheBustManager> cls = CacheBustManager.class;
        this.jobRunner = jobRunner2;
        if (ActivityManager.getInstance().isInitialized()) {
            setLifecycleListener();
        } else {
            Log.e(cls.getSimpleName(), "No lifecycle listener set");
            VungleLogger.error(cls.getSimpleName() + "#deliverError", "No lifecycle listener set");
        }
        this.status = 0;
    }

    public synchronized void startBust() {
        if (this.status != 1) {
            this.status = 1;
            if (this.refreshRate == 0) {
                this.jobRunner.execute(CacheBustJob.makeJobInfo());
            } else {
                Bundle bundle = new Bundle();
                bundle.putLong(CACHE_BUST_INTERVAL, this.refreshRate);
                bundle.putLong(NEXT_CACHE_BUST, getCurrentTime() + this.refreshRate);
                this.jobRunner.execute(CacheBustJob.makeJobInfo().setReschedulePolicy(this.refreshRate, 0).setExtras(bundle));
            }
            this.startTrackingTime = getCurrentTime();
        }
    }

    /* access modifiers changed from: package-private */
    public void overrideRefreshRate(long j) {
        this.overrideRefreshRate = j;
        this.refreshRate = j;
    }

    public void setRefreshRate(long j) {
        long j2 = this.overrideRefreshRate;
        if (j2 != -2147483648L) {
            this.refreshRate = j2;
            return;
        }
        long j3 = 0;
        if (j > 0) {
            j3 = Math.max(j, 900000);
        }
        if (j3 != this.refreshRate) {
            this.refreshRate = j3;
            if (this.status == 1) {
                this.jobRunner.cancelPendingJob(CacheBustJob.TAG);
                this.status = 0;
                startBust();
            }
        }
    }

    private void setLifecycleListener() {
        ActivityManager.getInstance().addListener(new ActivityManager.LifeCycleCallback() {
            public void onStart() {
                super.onStart();
                CacheBustManager.this.resumeCacheBust();
            }

            public void onStop() {
                super.onStop();
                CacheBustManager.this.stopCacheBust();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void resumeCacheBust() {
        if (this.status == 0 && this.refreshRate != 0) {
            this.status = 1;
            Bundle bundle = new Bundle();
            bundle.putLong(CACHE_BUST_INTERVAL, this.refreshRate);
            bundle.putLong(NEXT_CACHE_BUST, getCurrentTime() + this.refreshRate);
            this.jobRunner.execute(CacheBustJob.makeJobInfo().setDelay(this.refreshRate - this.refreshElapsed).setReschedulePolicy(this.refreshRate, 0).setExtras(bundle));
            this.refreshElapsed = 0;
            this.startTrackingTime = getCurrentTime();
        }
    }

    /* access modifiers changed from: package-private */
    public void stopCacheBust() {
        if (this.refreshRate != 0) {
            this.refreshElapsed = (getCurrentTime() - this.startTrackingTime) % this.refreshRate;
        }
        this.jobRunner.cancelPendingJob(CacheBustJob.TAG);
        this.status = 0;
    }

    /* access modifiers changed from: package-private */
    public long getCurrentTime() {
        return SystemClock.elapsedRealtime();
    }
}
