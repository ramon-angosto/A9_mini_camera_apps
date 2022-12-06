package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzecg implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;

    public zzecg(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
    }

    /* renamed from: zza */
    public final zzecf zzb() {
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return new zzecf((ScheduledExecutorService) this.zza.zzb(), zzfzq, ((zzecx) this.zzc).zzb(), zzgxh.zza(this.zzd));
    }
}
