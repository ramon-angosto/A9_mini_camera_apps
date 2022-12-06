package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzca {
    private final zzy zza = new zzy();

    public final zzca zza(int i) {
        this.zza.zza(i);
        return this;
    }

    public final zzca zzb(zzcc zzcc) {
        zzy zzy = this.zza;
        zzaa zza2 = zzcc.zzc;
        for (int i = 0; i < zza2.zzb(); i++) {
            zzy.zza(zza2.zza(i));
        }
        return this;
    }

    public final zzca zzc(int... iArr) {
        zzy zzy = this.zza;
        for (int i = 0; i < 21; i++) {
            zzy.zza(iArr[i]);
        }
        return this;
    }

    public final zzca zzd(int i, boolean z) {
        zzy zzy = this.zza;
        if (z) {
            zzy.zza(i);
        }
        return this;
    }

    public final zzcc zze() {
        return new zzcc(this.zza.zzb(), (zzcb) null);
    }
}
