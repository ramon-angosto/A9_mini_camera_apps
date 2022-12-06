package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeg implements zzde {
    protected zzeg() {
    }

    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    public final zzdn zzb(Looper looper, Handler.Callback callback) {
        return new zzej(new Handler(looper, callback));
    }
}
