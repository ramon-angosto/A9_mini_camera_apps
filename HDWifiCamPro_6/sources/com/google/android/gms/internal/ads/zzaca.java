package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaca implements zzaal {
    final /* synthetic */ zzaal zza;
    final /* synthetic */ zzacb zzb;

    zzaca(zzacb zzacb, zzaal zzaal) {
        this.zzb = zzacb;
        this.zza = zzaal;
    }

    public final long zze() {
        return this.zza.zze();
    }

    public final zzaaj zzg(long j) {
        zzaaj zzg = this.zza.zzg(j);
        zzaam zzaam = zzg.zza;
        zzaam zzaam2 = new zzaam(zzaam.zzb, zzaam.zzc + this.zzb.zzb);
        zzaam zzaam3 = zzg.zzb;
        return new zzaaj(zzaam2, new zzaam(zzaam3.zzb, zzaam3.zzc + this.zzb.zzb));
    }

    public final boolean zzh() {
        return this.zza.zzh();
    }
}
