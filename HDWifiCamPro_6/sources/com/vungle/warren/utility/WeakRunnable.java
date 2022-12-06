package com.vungle.warren.utility;

import java.lang.ref.WeakReference;

public class WeakRunnable implements Runnable {
    private WeakReference<Runnable> weak;

    public WeakRunnable(Runnable runnable) {
        this.weak = new WeakReference<>(runnable);
    }

    public void run() {
        Runnable runnable = (Runnable) this.weak.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
