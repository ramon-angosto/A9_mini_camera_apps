package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcxg implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;

    public zzcxg(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5, zzgxv zzgxv6, zzgxv zzgxv7, zzgxv zzgxv8, zzgxv zzgxv9, zzgxv zzgxv10) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
        this.zzf = zzgxv6;
        this.zzg = zzgxv7;
        this.zzh = zzgxv8;
        this.zzi = zzgxv9;
        this.zzj = zzgxv10;
    }

    public static zzcxf zzc(zzczd zzczd, Context context, zzfdl zzfdl, View view, zzcmp zzcmp, zzczc zzczc, zzdpb zzdpb, zzdkp zzdkp, zzgxc zzgxc, Executor executor) {
        return new zzcxf(zzczd, context, zzfdl, view, zzcmp, zzczc, zzdpb, zzdkp, zzgxc, executor);
    }

    /* renamed from: zza */
    public final zzcxf zzb() {
        return new zzcxf(((zzdaz) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcxm) this.zzc).zza(), ((zzcxl) this.zzd).zza(), ((zzcxx) this.zze).zza(), ((zzcxn) this.zzf).zza(), ((zzdnb) this.zzg).zza(), (zzdkp) this.zzh.zzb(), zzgxh.zza(this.zzi), (Executor) this.zzj.zzb());
    }
}
