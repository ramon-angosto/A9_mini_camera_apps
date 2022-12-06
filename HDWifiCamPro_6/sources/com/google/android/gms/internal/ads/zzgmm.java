package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmm extends zzgra implements zzgsp {
    private zzgmm() {
        super(zzgmp.zzb);
    }

    public final zzgmm zza(zzgmo zzgmo) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgmp.zze((zzgmp) this.zza, zzgmo);
        return this;
    }

    public final zzgmm zzb(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgmp) this.zza).zze = i;
        return this;
    }

    /* synthetic */ zzgmm(zzgml zzgml) {
        super(zzgmp.zzb);
    }
}
