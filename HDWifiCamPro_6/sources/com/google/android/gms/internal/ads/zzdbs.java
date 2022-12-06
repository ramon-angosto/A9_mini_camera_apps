package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdbs implements zzdfv {
    private final Context zza;
    private final zzfef zzb;
    private final zzcgv zzc;
    private final zzg zzd;
    private final zzdzs zze;
    private final zzfjw zzf;

    public zzdbs(Context context, zzfef zzfef, zzcgv zzcgv, zzg zzg, zzdzs zzdzs, zzfjw zzfjw) {
        this.zza = context;
        this.zzb = zzfef;
        this.zzc = zzcgv;
        this.zzd = zzg;
        this.zze = zzdzs;
        this.zzf = zzfjw;
    }

    public final void zzb(zzfdw zzfdw) {
    }

    public final void zzbE(zzcbc zzcbc) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzde)).booleanValue()) {
            zzt.zza().zzc(this.zza, this.zzc, this.zzb.zzf, this.zzd.zzh(), this.zzf);
        }
        this.zze.zzr();
    }
}
