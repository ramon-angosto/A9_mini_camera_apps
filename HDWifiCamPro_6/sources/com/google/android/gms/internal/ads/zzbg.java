package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbg {
    public static final zzbg zza = new zzaj().zzc();
    public static final zzn zzb = zzah.zza;
    public final String zzc;
    public final zzay zzd;
    @Deprecated
    public final zzba zze;
    public final zzaw zzf;
    public final zzbm zzg;
    public final zzan zzh;
    @Deprecated
    public final zzap zzi;
    public final zzbd zzj;

    /* synthetic */ zzbg(String str, zzap zzap, zzba zzba, zzaw zzaw, zzbm zzbm, zzbd zzbd, zzbf zzbf) {
        this.zzc = str;
        this.zzd = zzba;
        this.zze = zzba;
        this.zzf = zzaw;
        this.zzg = zzbm;
        this.zzh = zzap;
        this.zzi = zzap;
        this.zzj = zzbd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbg)) {
            return false;
        }
        zzbg zzbg = (zzbg) obj;
        return zzen.zzT(this.zzc, zzbg.zzc) && this.zzh.equals(zzbg.zzh) && zzen.zzT(this.zzd, zzbg.zzd) && zzen.zzT(this.zzf, zzbg.zzf) && zzen.zzT(this.zzg, zzbg.zzg) && zzen.zzT(this.zzj, zzbg.zzj);
    }

    public final int hashCode() {
        int hashCode = this.zzc.hashCode() * 31;
        zzay zzay = this.zzd;
        return (((((((hashCode + (zzay != null ? zzay.hashCode() : 0)) * 31) + this.zzf.hashCode()) * 31) + this.zzh.hashCode()) * 31) + this.zzg.hashCode()) * 31;
    }
}
