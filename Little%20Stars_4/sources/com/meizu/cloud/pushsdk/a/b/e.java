package com.meizu.cloud.pushsdk.a.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class e implements Executor {
    private final Handler a = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
