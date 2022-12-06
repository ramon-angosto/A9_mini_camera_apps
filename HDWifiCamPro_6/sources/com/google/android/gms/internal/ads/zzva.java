package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzva implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzva(zzaf zzaf, int i) {
        this.zza = 1 != (zzaf.zze & 1) ? false : true;
        this.zzb = zzvr.zzm(i, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzva zzva) {
        return zzfvc.zzj().zzd(this.zzb, zzva.zzb).zzd(this.zza, zzva.zza).zza();
    }
}
