package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbkc implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;

    public zzbkc(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
    }

    public final /* synthetic */ Object zzb() {
        return new zzbkb(((zzcos) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb(), new zzbkd(), (zzfju) this.zzd.zzb(), (byte[]) null);
    }
}
