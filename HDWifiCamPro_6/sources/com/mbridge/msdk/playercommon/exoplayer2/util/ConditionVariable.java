package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.SystemClock;

public final class ConditionVariable {
    private boolean isOpen;

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean close() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }

    public final synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public final synchronized boolean block(long j) throws InterruptedException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = j + elapsedRealtime;
        while (!this.isOpen && elapsedRealtime < j2) {
            wait(j2 - elapsedRealtime);
            elapsedRealtime = SystemClock.elapsedRealtime();
        }
        return this.isOpen;
    }
}
