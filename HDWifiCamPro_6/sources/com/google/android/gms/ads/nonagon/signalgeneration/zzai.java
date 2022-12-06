package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzdch;
import com.google.android.gms.internal.ads.zzfib;
import com.google.android.gms.internal.ads.zzfih;
import com.google.android.gms.internal.ads.zzgxi;
import com.google.android.gms.internal.ads.zzgxv;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzai implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzai(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzfih) this.zza.zzb()).zzb(zzfib.GENERATE_SIGNALS, ((zzdch) this.zzc).zzb().zzc()).zzf(((zzal) this.zzb).zzb()).zzi((long) ((Integer) zzay.zzc().zzb(zzbjc.zzeE)).intValue(), TimeUnit.SECONDS).zza();
    }
}
