package com.google.zxing.decoding;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class InactivityTimer {
    private static final int INACTIVITY_DELAY_SECONDS = 300;
    private final Activity activity;
    private ScheduledFuture<?> inactivityFuture = null;
    private final ScheduledExecutorService inactivityTimer = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory());

    public InactivityTimer(Activity activity2) {
        this.activity = activity2;
        onActivity();
    }

    public void onActivity() {
        cancel();
        this.inactivityFuture = this.inactivityTimer.schedule(new FinishListener(this.activity), 300, TimeUnit.SECONDS);
    }

    private void cancel() {
        ScheduledFuture<?> scheduledFuture = this.inactivityFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.inactivityFuture = null;
        }
    }

    public void shutdown() {
        cancel();
        this.inactivityTimer.shutdown();
    }

    private static final class DaemonThreadFactory implements ThreadFactory {
        private DaemonThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }
}
