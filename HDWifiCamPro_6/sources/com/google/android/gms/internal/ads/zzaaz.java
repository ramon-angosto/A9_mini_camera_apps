package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaaz implements zzaal {
    final /* synthetic */ zzabc zza;
    private final long zzb;

    public zzaaz(zzabc zzabc, long j) {
        this.zza = zzabc;
        this.zzb = j;
    }

    public final long zze() {
        return this.zzb;
    }

    public final zzaaj zzg(long j) {
        zzaaj zza2 = this.zza.zzg[0].zza(j);
        int i = 1;
        while (true) {
            zzabc zzabc = this.zza;
            if (i >= zzabc.zzg.length) {
                return zza2;
            }
            zzaaj zza3 = zzabc.zzg[i].zza(j);
            if (zza3.zza.zzc < zza2.zza.zzc) {
                zza2 = zza3;
            }
            i++;
        }
    }

    public final boolean zzh() {
        return true;
    }
}
