package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzaak implements zzaal {
    private final long zza;
    private final zzaaj zzb;

    public zzaak(long j, long j2) {
        this.zza = j;
        zzaam zzaam = j2 == 0 ? zzaam.zza : new zzaam(0, j2);
        this.zzb = new zzaaj(zzaam, zzaam);
    }

    public final long zze() {
        return this.zza;
    }

    public final zzaaj zzg(long j) {
        return this.zzb;
    }

    public final boolean zzh() {
        return false;
    }
}
