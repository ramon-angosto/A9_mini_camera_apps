package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzok {
    private final zzng[] zza = new zzng[2];
    private final zzpc zzb;
    private final zzpe zzc;

    public zzok(zzng... zzngArr) {
        zzpc zzpc = new zzpc();
        zzpe zzpe = new zzpe();
        System.arraycopy(zzngArr, 0, this.zza, 0, 0);
        this.zzb = zzpc;
        this.zzc = zzpe;
        zzng[] zzngArr2 = this.zza;
        zzngArr2[0] = zzpc;
        zzngArr2[1] = zzpe;
    }

    public final long zza(long j) {
        return this.zzc.zzi(j);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzby zzc(zzby zzby) {
        this.zzc.zzk(zzby.zzc);
        this.zzc.zzj(zzby.zzd);
        return zzby;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzng[] zze() {
        return this.zza;
    }
}
