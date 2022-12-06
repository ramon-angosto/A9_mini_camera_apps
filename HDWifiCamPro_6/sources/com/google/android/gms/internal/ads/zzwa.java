package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzwa {
    public final int zza;
    public final zzkc[] zzb;
    public final zzvt[] zzc;
    public final zzcy zzd;
    public final Object zze;

    public zzwa(zzkc[] zzkcArr, zzvt[] zzvtArr, zzcy zzcy, Object obj) {
        this.zzb = zzkcArr;
        this.zzc = (zzvt[]) zzvtArr.clone();
        this.zzd = zzcy;
        this.zze = obj;
        this.zza = zzkcArr.length;
    }

    public final boolean zza(zzwa zzwa, int i) {
        if (zzwa != null && zzen.zzT(this.zzb[i], zzwa.zzb[i]) && zzen.zzT(this.zzc[i], zzwa.zzc[i])) {
            return true;
        }
        return false;
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}
