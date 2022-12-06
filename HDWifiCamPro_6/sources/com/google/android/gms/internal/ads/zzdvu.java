package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdvu implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;

    public zzdvu(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcos) this.zza).zza();
        String zza3 = ((zzebz) this.zzb).zzb();
        zzcgv zza4 = ((zzcpc) this.zzc).zza();
        zzbez zzbez = (zzbez) this.zzd.zzb();
        String str = (String) this.zze.zzb();
        zzbep zzbep = new zzbep(new zzbev(zza2));
        zzbho zza5 = zzbhp.zza();
        zza5.zza(zza4.zzb);
        zza5.zzc(zza4.zzc);
        zza5.zzb(true != zza4.zzd ? 2 : 0);
        zzbep.zzb(new zzdvt(zzbez, zza3, (zzbhp) zza5.zzam(), str));
        return zzbep;
    }
}
