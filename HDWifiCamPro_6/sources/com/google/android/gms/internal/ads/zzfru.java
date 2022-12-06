package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfru extends zzfro {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzfrx zzb;

    zzfru(zzfrx zzfrx, IBinder iBinder) {
        this.zzb = zzfrx;
        this.zza = iBinder;
    }

    public final void zza() {
        this.zzb.zza.zzn = zzfrj.zzb(this.zza);
        zzfry.zzn(this.zzb.zza);
        this.zzb.zza.zzh = false;
        for (Runnable run : this.zzb.zza.zze) {
            run.run();
        }
        this.zzb.zza.zze.clear();
    }
}
