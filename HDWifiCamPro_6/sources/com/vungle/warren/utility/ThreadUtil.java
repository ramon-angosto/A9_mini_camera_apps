package com.vungle.warren.utility;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

public class ThreadUtil {
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());

    public static boolean isMainThread() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return mainLooper.isCurrentThread();
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null || !mainLooper.getThread().equals(myLooper.getThread())) {
            return false;
        }
        return true;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            UI_HANDLER.post(runnable);
        }
    }
}
