package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzglt extends zzgra implements zzgsp {
    private zzglt() {
        super(zzglu.zzb);
    }

    public final zzglt zza(zzglo zzglo) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzglu.zzj((zzglu) this.zza, zzglo);
        return this;
    }

    public final zzglt zzb(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzglu) this.zza).zzg = zzgpw;
        return this;
    }

    public final zzglt zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzglu) this.zza).zze = 0;
        return this;
    }

    /* synthetic */ zzglt(zzgls zzgls) {
        super(zzglu.zzb);
    }
}
