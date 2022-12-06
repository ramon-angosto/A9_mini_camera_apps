package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgkz extends zzgra implements zzgsp {
    private zzgkz() {
        super(zzgla.zzb);
    }

    public final zzgkz zza(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgla) this.zza).zzg = zzgpw;
        return this;
    }

    public final zzgkz zzb(zzglg zzglg) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgla.zzj((zzgla) this.zza, zzglg);
        return this;
    }

    public final zzgkz zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgla) this.zza).zze = 0;
        return this;
    }

    /* synthetic */ zzgkz(zzgky zzgky) {
        super(zzgla.zzb);
    }
}
