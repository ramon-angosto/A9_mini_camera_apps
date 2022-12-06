package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzazi {
    public final zzayt zza;
    public final zzazf zzb;
    public final Object zzc;
    public final zzatd[] zzd;

    public zzazi(zzayt zzayt, zzazf zzazf, Object obj, zzatd[] zzatdArr) {
        this.zza = zzayt;
        this.zzb = zzazf;
        this.zzc = obj;
        this.zzd = zzatdArr;
    }

    public final boolean zza(zzazi zzazi, int i) {
        if (zzazi != null && zzbar.zzo(this.zzb.zza(i), zzazi.zzb.zza(i)) && zzbar.zzo(this.zzd[i], zzazi.zzd[i])) {
            return true;
        }
        return false;
    }
}
