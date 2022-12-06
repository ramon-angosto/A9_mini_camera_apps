package com.mbridge.msdk.foundation.download.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
    /* access modifiers changed from: private */
    public final int threadPriority;

    PriorityThreadFactory(int i) {
        this.threadPriority = i;
    }

    public Thread newThread(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Process.setThreadPriority(PriorityThreadFactory.this.threadPriority);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        });
        thread.setName("mb_download_thread");
        return thread;
    }
}
