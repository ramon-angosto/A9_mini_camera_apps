package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zztr implements zzwc {
    public long zza;
    public long zzb;
    public zzwb zzc;
    public zztr zzd;

    public zztr(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = this.zza;
        int i = this.zzc.zzb;
        return (int) (j - j2);
    }

    public final zztr zzb() {
        this.zzc = null;
        zztr zztr = this.zzd;
        this.zzd = null;
        return zztr;
    }

    public final zzwb zzc() {
        zzwb zzwb = this.zzc;
        if (zzwb != null) {
            return zzwb;
        }
        throw null;
    }

    public final zzwc zzd() {
        zztr zztr = this.zzd;
        if (zztr == null || zztr.zzc == null) {
            return null;
        }
        return zztr;
    }

    public final void zze(long j, int i) {
        zzdd.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + 65536;
    }
}
