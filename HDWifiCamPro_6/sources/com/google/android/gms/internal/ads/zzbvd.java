package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbvd {
    private static zzbvd zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    zzbvd() {
    }

    public static zzbvd zza() {
        if (zza == null) {
            zza = new zzbvd();
        }
        return zza;
    }

    public final Thread zzb(Context context, String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbvc(this, context, str));
        thread.start();
        return thread;
    }
}
