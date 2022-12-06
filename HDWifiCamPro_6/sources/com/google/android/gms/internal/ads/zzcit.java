package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcit implements Runnable {
    zzcit(zzciv zzciv) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
