package com.bytedance.sdk.component.utils;

import android.os.Environment;
import android.os.StatFs;

/* compiled from: MemorySize */
public class m {
    public static long a() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0;
        }
    }
}
