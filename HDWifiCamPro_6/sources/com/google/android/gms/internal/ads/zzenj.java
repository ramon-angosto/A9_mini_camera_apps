package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzbl;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzenj extends zzbn {
    final zzfed zza = new zzfed();
    final zzdoz zzb = new zzdoz();
    private final Context zzc;
    private final zzcom zzd;
    private zzbf zze;

    public zzenj(zzcom zzcom, Context context, String str) {
        this.zzd = zzcom;
        this.zza.zzs(str);
        this.zzc = context;
    }

    public final zzbl zze() {
        zzdpb zzg = this.zzb.zzg();
        this.zza.zzB(zzg.zzi());
        this.zza.zzC(zzg.zzh());
        zzfed zzfed = this.zza;
        if (zzfed.zzg() == null) {
            zzfed.zzr(zzq.zzc());
        }
        return new zzenk(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbnc zzbnc) {
        this.zzb.zza(zzbnc);
    }

    public final void zzg(zzbnf zzbnf) {
        this.zzb.zzb(zzbnf);
    }

    public final void zzh(String str, zzbnl zzbnl, zzbni zzbni) {
        this.zzb.zzc(str, zzbnl, zzbni);
    }

    public final void zzi(zzbsl zzbsl) {
        this.zzb.zzd(zzbsl);
    }

    public final void zzj(zzbnp zzbnp, zzq zzq) {
        this.zzb.zze(zzbnp);
        this.zza.zzr(zzq);
    }

    public final void zzk(zzbns zzbns) {
        this.zzb.zzf(zzbns);
    }

    public final void zzl(zzbf zzbf) {
        this.zze = zzbf;
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzq(adManagerAdViewOptions);
    }

    public final void zzn(zzbsc zzbsc) {
        this.zza.zzv(zzbsc);
    }

    public final void zzo(zzbls zzbls) {
        this.zza.zzA(zzbls);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzD(publisherAdViewOptions);
    }

    public final void zzq(zzcd zzcd) {
        this.zza.zzQ(zzcd);
    }
}
