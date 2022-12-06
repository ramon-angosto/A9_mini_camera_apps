package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcvl implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;

    public zzcvl(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcvk((zzbut) this.zza.zzb(), (zzcvg) this.zzb.zzb(), (Executor) this.zzc.zzb(), (zzcvf) this.zzd.zzb(), (Clock) this.zze.zzb());
    }
}
