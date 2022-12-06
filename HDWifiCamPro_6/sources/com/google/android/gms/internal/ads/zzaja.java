package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaja implements zzaal {
    private final zzaix zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaja(zzaix zzaix, int i, long j, long j2) {
        this.zza = zzaix;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzaix.zzd);
        this.zzd = j3;
        this.zze = zza(j3);
    }

    private final long zza(long j) {
        return zzen.zzw(j * ((long) this.zzb), 1000000, (long) this.zza.zzc);
    }

    public final long zze() {
        return this.zze;
    }

    public final zzaaj zzg(long j) {
        long zzr = zzen.zzr((((long) this.zza.zzc) * j) / (((long) this.zzb) * 1000000), 0, this.zzd - 1);
        long j2 = this.zzc;
        int i = this.zza.zzd;
        long zza2 = zza(zzr);
        zzaam zzaam = new zzaam(zza2, j2 + (((long) i) * zzr));
        if (zza2 >= j || zzr == this.zzd - 1) {
            return new zzaaj(zzaam, zzaam);
        }
        long j3 = zzr + 1;
        return new zzaaj(zzaam, new zzaam(zza(j3), this.zzc + (j3 * ((long) this.zza.zzd))));
    }

    public final boolean zzh() {
        return true;
    }
}
