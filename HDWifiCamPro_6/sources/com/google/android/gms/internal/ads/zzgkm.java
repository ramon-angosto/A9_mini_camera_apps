package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgkm extends zzgra implements zzgsp {
    private zzgkm() {
        super(zzgkn.zzb);
    }

    public final zzgkm zza(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgkn) this.zza).zzg = zzgpw;
        return this;
    }

    public final zzgkm zzb(zzgkq zzgkq) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgkn.zzi((zzgkn) this.zza, zzgkq);
        return this;
    }

    public final zzgkm zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgkn) this.zza).zze = 0;
        return this;
    }

    /* synthetic */ zzgkm(zzgkl zzgkl) {
        super(zzgkn.zzb);
    }
}
