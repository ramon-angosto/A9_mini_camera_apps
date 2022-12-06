package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzemh implements zzf {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzdcy zzb;
    private final zzdds zzc;
    private final zzdkp zzd;
    private final zzdki zze;
    private final zzcvk zzf;

    zzemh(zzdcy zzdcy, zzdds zzdds, zzdkp zzdkp, zzdki zzdki, zzcvk zzcvk) {
        this.zzb = zzdcy;
        this.zzc = zzdds;
        this.zzd = zzdkp;
        this.zze = zzdki;
        this.zzf = zzcvk;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzl();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
