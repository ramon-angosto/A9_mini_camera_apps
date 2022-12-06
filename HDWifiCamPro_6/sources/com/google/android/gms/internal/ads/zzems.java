package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzems implements zzf {
    private zzf zza;

    public final synchronized void zza(View view) {
        zzf zzf = this.zza;
        if (zzf != null) {
            zzf.zza(view);
        }
    }

    public final synchronized void zzb() {
        zzf zzf = this.zza;
        if (zzf != null) {
            zzf.zzb();
        }
    }

    public final synchronized void zzc() {
        zzf zzf = this.zza;
        if (zzf != null) {
            zzf.zzc();
        }
    }

    public final synchronized void zzd(zzf zzf) {
        this.zza = zzf;
    }
}
