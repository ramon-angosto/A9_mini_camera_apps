package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxu implements Runnable {
    final /* synthetic */ IOException zza;
    final /* synthetic */ zzaxy zzb;

    zzaxu(zzaxy zzaxy, IOException iOException) {
        this.zzb = zzaxy;
        this.zza = iOException;
    }

    public final void run() {
        this.zzb.zze.zzi(this.zza);
    }
}
