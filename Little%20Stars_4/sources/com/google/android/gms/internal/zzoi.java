package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzoi {
    private static final ExecutorService zzanJ = Executors.newFixedThreadPool(2, new zzpt("GAC_Executor"));

    public static ExecutorService zzsp() {
        return zzanJ;
    }
}
