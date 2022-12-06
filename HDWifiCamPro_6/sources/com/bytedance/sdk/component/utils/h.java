package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: HandlerUtils */
public class h {
    private static volatile HandlerThread a = new HandlerThread("csj_io_handler");
    private static volatile Handler b;
    private static volatile Handler c = new Handler(a.getLooper());

    static {
        a.start();
    }

    public static Handler a() {
        if (a == null || !a.isAlive()) {
            synchronized (h.class) {
                if (a == null || !a.isAlive()) {
                    a = new HandlerThread("csj_io_handler");
                    a.start();
                    c = new Handler(a.getLooper());
                }
            }
        }
        return c;
    }

    public static Handler b() {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new Handler(Looper.getMainLooper());
                }
            }
        }
        return b;
    }
}
