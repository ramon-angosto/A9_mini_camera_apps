package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdob implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;

    public zzdob(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcvu((Executor) this.zzb.zzb(), new zzcvg((Context) this.zzc.zzb(), (zzbbm) this.zza.zzb()), (Clock) this.zzd.zzb());
    }
}
