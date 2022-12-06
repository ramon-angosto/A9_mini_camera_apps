package com.meizu.cloud.pushsdk.a.b;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class f implements ThreadFactory {
    /* access modifiers changed from: private */
    public final int a;

    public f(int i) {
        this.a = i;
    }

    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() {
            public void run() {
                try {
                    Process.setThreadPriority(f.this.a);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        });
    }
}
