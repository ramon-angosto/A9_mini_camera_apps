package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzefm implements zzdeo, zzddd {
    private static final Object zza = new Object();
    private static int zzb = 0;
    private final zzg zzc;
    private final zzefw zzd;

    public zzefm(zzefw zzefw, zzg zzg) {
        this.zzd = zzefw;
        this.zzc = zzg;
    }

    private final void zzb(boolean z) {
        int i;
        int intValue;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue() && !this.zzc.zzP()) {
            synchronized (zza) {
                i = zzb;
                intValue = ((Integer) zzay.zzc().zzb(zzbjc.zzfn)).intValue();
            }
            if (i < intValue) {
                this.zzd.zzd(z);
                synchronized (zza) {
                    zzb++;
                }
            }
        }
    }

    public final void zza(zze zze) {
        zzb(false);
    }

    public final void zzn() {
        zzb(true);
    }
}
