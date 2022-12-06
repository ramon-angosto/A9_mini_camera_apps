package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxs implements Runnable {
    final /* synthetic */ zzaxy zza;

    zzaxs(zzaxy zzaxy) {
        this.zza = zzaxy;
    }

    public final void run() {
        zzaxy zzaxy = this.zza;
        if (!zzaxy.zzF) {
            zzaxy.zzo.zze(zzaxy);
        }
    }
}
