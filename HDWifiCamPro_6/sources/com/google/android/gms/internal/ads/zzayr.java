package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzayr extends zzath {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;

    public zzayr(long j, boolean z) {
        this.zzc = j;
        this.zzd = j;
    }

    public final int zza(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzatf zzd(int i, zzatf zzatf, boolean z) {
        zzbac.zza(i, 0, 1);
        Object obj = z ? zzb : null;
        long j = this.zzc;
        zzatf.zza = obj;
        zzatf.zzb = obj;
        zzatf.zzc = j;
        return zzatf;
    }

    public final zzatg zze(int i, zzatg zzatg, boolean z, long j) {
        zzbac.zza(i, 0, 1);
        zzatg.zza = this.zzd;
        return zzatg;
    }
}
