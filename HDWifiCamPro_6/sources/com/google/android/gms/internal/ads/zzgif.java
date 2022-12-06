package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgif extends zzgra implements zzgsp {
    private zzgif() {
        super(zzgig.zzb);
    }

    public final zzgif zza(zzgim zzgim) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgig.zzi((zzgig) this.zza, zzgim);
        return this;
    }

    public final zzgif zzb(zzgla zzgla) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgig.zzj((zzgig) this.zza, zzgla);
        return this;
    }

    public final zzgif zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgig) this.zza).zze = i;
        return this;
    }

    /* synthetic */ zzgif(zzgie zzgie) {
        super(zzgig.zzb);
    }
}
