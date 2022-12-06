package com.vungle.warren.utility;

import android.os.Handler;

public class RefreshHandler extends Handler {
    private static final int DISABLE_REFRESH_VALUE = 0;
    private static final int ID = 0;
    private long handlerStartTime;
    private long handlerTimeElapsed;
    private final long refreshDuration;
    private Runnable runnable;

    public RefreshHandler(Runnable runnable2, long j) {
        this.refreshDuration = j;
        this.runnable = runnable2;
    }

    public synchronized void pause() {
        if (hasMessages(0)) {
            this.handlerTimeElapsed += System.currentTimeMillis() - this.handlerStartTime;
            removeMessages(0);
            removeCallbacks(this.runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void start() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.refreshDuration     // Catch:{ all -> 0x0024 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x000b
            monitor-exit(r4)
            return
        L_0x000b:
            r0 = 0
            boolean r0 = r4.hasMessages(r0)     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            long r0 = r4.refreshDuration     // Catch:{ all -> 0x0024 }
            long r2 = r4.handlerTimeElapsed     // Catch:{ all -> 0x0024 }
            long r0 = r0 - r2
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0024 }
            r4.handlerStartTime = r2     // Catch:{ all -> 0x0024 }
            java.lang.Runnable r2 = r4.runnable     // Catch:{ all -> 0x0024 }
            r4.postDelayed(r2, r0)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r4)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.utility.RefreshHandler.start():void");
    }

    public synchronized void clean() {
        removeMessages(0);
        removeCallbacks(this.runnable);
        this.handlerTimeElapsed = 0;
        this.handlerStartTime = 0;
    }
}
