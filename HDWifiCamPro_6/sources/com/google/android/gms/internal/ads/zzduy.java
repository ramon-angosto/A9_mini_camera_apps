package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzduy {
    private final zzcnb zza;
    private final Context zzb;
    private final zzape zzc;
    private final zzbkb zzd;
    private final zzcgv zze;
    private final zza zzf;
    private final zzbep zzg;
    /* access modifiers changed from: private */
    public final zzdfp zzh;

    public zzduy(zzcnb zzcnb, Context context, zzape zzape, zzbkb zzbkb, zzcgv zzcgv, zza zza2, zzbep zzbep, zzdfp zzdfp) {
        this.zza = zzcnb;
        this.zzb = context;
        this.zzc = zzape;
        this.zzd = zzbkb;
        this.zze = zzcgv;
        this.zzf = zza2;
        this.zzg = zzbep;
        this.zzh = zzdfp;
    }

    public final zzcmp zza(zzq zzq, zzfdk zzfdk, zzfdn zzfdn) throws zzcna {
        return zzcnb.zza(this.zzb, zzcoe.zzc(zzq), zzq.zza, false, false, this.zzc, this.zzd, this.zze, (zzbjr) null, new zzdun(this), this.zzf, this.zzg, zzfdk, zzfdn);
    }
}
