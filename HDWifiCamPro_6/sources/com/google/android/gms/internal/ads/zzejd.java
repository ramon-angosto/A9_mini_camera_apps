package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzejd implements zzdmp {
    private final Context zza;
    private final zzcgv zzb;
    private final zzfzp zzc;
    private final zzfdk zzd;
    private final zzcmp zze;
    private final zzfef zzf;
    private final zzbpx zzg;
    private final boolean zzh;

    zzejd(Context context, zzcgv zzcgv, zzfzp zzfzp, zzfdk zzfdk, zzcmp zzcmp, zzfef zzfef, boolean z, zzbpx zzbpx) {
        this.zza = context;
        this.zzb = zzcgv;
        this.zzc = zzfzp;
        this.zzd = zzfdk;
        this.zze = zzcmp;
        this.zzf = zzfef;
        this.zzg = zzbpx;
        this.zzh = z;
    }

    public final void zza(boolean z, Context context, zzddn zzddn) {
        zzdlh zzdlh = (zzdlh) zzfzg.zzq(this.zzc);
        this.zze.zzap(true);
        boolean z2 = false;
        boolean zze2 = this.zzh ? this.zzg.zze(false) : false;
        zzt.zzp();
        boolean zzE = zzs.zzE(this.zza);
        boolean z3 = this.zzh;
        if (z3) {
            z2 = this.zzg.zzd();
        }
        zzj zzj = new zzj(zze2, zzE, z2, z3 ? this.zzg.zza() : 0.0f, -1, z, this.zzd.zzP, false);
        if (zzddn != null) {
            zzddn.zzf();
        }
        zzt.zzi();
        zzdme zzj2 = zzdlh.zzj();
        zzcmp zzcmp = this.zze;
        zzfdk zzfdk = this.zzd;
        int i = zzfdk.zzR;
        zzcgv zzcgv = this.zzb;
        String str = zzfdk.zzC;
        zzfdp zzfdp = zzfdk.zzt;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzo) zzj2, (zzz) null, zzcmp, i, zzcgv, str, zzj, zzfdp.zzb, zzfdp.zza, this.zzf.zzf, zzddn);
        zzm.zza(context, adOverlayInfoParcel, true);
    }
}
