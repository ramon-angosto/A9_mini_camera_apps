package com.mbridge.msdk.foundation.download.utils;

public final class Utils {
    public static int getDownloadRate(long j, long j2) {
        return (int) (((((double) j2) * 1.0d) / ((double) j)) * 1.0d * 100.0d);
    }

    private Utils() {
    }
}
