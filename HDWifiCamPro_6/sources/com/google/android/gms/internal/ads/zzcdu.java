package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcdu {
    private final Clock zza;
    private final zzg zzb;
    private final zzceu zzc;

    zzcdu(Clock clock, zzg zzg, zzceu zzceu) {
        this.zza = clock;
        this.zzb = zzg;
        this.zzc = zzceu;
    }

    public final void zza() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzao)).booleanValue()) {
            this.zzc.zzt();
        }
    }

    public final void zzb(int i, long j) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzan)).booleanValue()) {
            if (j - this.zzb.zzf() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzao)).booleanValue()) {
                this.zzb.zzK(-1);
                this.zzb.zzL(j);
            } else {
                this.zzb.zzK(i);
                this.zzb.zzL(j);
            }
            zza();
        }
    }
}
