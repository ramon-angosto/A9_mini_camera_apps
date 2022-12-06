package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzff implements zzew {
    private final zzft zza = new zzft();
    private zzfz zzb;
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzff zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzff zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzff zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzff zze(zzfz zzfz) {
        this.zzb = zzfz;
        return this;
    }

    public final zzff zzf(String str) {
        this.zzc = str;
        return this;
    }

    /* renamed from: zzg */
    public final zzfk zza() {
        zzfk zzfk = new zzfk(this.zzc, this.zzd, this.zze, this.zzf, this.zza, (zzfsy) null, false, (zzfj) null);
        zzfz zzfz = this.zzb;
        if (zzfz != null) {
            zzfk.zzf(zzfz);
        }
        return zzfk;
    }
}
