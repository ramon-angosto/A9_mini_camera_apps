package com.vungle.warren.utility;

import android.os.SystemClock;

public class UtilityResource {
    public long getSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public long getElapsedMillis() {
        return SystemClock.elapsedRealtime();
    }
}
