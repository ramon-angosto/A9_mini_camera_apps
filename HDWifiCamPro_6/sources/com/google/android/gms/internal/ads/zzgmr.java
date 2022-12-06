package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmr extends zzgra implements zzgsp {
    private zzgmr() {
        super(zzgms.zzb);
    }

    public final zzgmr zza(zzgmv zzgmv) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgms.zzh((zzgms) this.zza, zzgmv);
        return this;
    }

    public final zzgmr zzb(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgms) this.zza).zze = 0;
        return this;
    }

    /* synthetic */ zzgmr(zzgmq zzgmq) {
        super(zzgms.zzb);
    }
}
