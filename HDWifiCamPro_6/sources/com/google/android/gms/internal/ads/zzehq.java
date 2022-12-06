package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzehq implements zzdmp {
    private final zzcgv zza;
    private final zzfzp zzb;
    private final zzfdk zzc;
    private final zzcmp zzd;
    private final zzfef zze;
    private final zzbpx zzf;
    private final boolean zzg;

    zzehq(zzcgv zzcgv, zzfzp zzfzp, zzfdk zzfdk, zzcmp zzcmp, zzfef zzfef, boolean z, zzbpx zzbpx) {
        this.zza = zzcgv;
        this.zzb = zzfzp;
        this.zzc = zzfdk;
        this.zzd = zzcmp;
        this.zze = zzfef;
        this.zzg = z;
        this.zzf = zzbpx;
    }

    public final void zza(boolean z, Context context, zzddn zzddn) {
        zzcwn zzcwn = (zzcwn) zzfzg.zzq(this.zzb);
        this.zzd.zzap(true);
        boolean zze2 = this.zzg ? this.zzf.zze(true) : true;
        boolean z2 = this.zzg;
        zzj zzj = new zzj(zze2, true, z2 ? this.zzf.zzd() : false, z2 ? this.zzf.zza() : 0.0f, -1, z, this.zzc.zzP, false);
        if (zzddn != null) {
            zzddn.zzf();
        }
        zzt.zzi();
        zzdme zzg2 = zzcwn.zzg();
        zzcmp zzcmp = this.zzd;
        int i = this.zzc.zzR;
        if (i == -1) {
            zzw zzw = this.zze.zzj;
            if (zzw != null) {
                int i2 = zzw.zza;
                if (i2 == 1) {
                    i = 7;
                } else if (i2 == 2) {
                    i = 6;
                }
            }
            zze.zze("Error setting app open orientation; no targeting orientation available.");
            i = this.zzc.zzR;
        }
        int i3 = i;
        zzcgv zzcgv = this.zza;
        zzfdk zzfdk = this.zzc;
        String str = zzfdk.zzC;
        zzfdp zzfdp = zzfdk.zzt;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzo) zzg2, (zzz) null, zzcmp, i3, zzcgv, str, zzj, zzfdp.zzb, zzfdp.zza, this.zze.zzf, zzddn);
        zzm.zza(context, adOverlayInfoParcel, true);
    }
}
