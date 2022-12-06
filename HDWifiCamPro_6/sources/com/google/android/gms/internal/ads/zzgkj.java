package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgkj extends zzgra implements zzgsp {
    private zzgkj() {
        super(zzgkk.zzb);
    }

    public final zzgkj zza(zzgke zzgke) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgkk.zzh((zzgkk) this.zza, zzgke);
        return this;
    }

    public final zzgkj zzb(zzgkt zzgkt) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgkk.zzg((zzgkk) this.zza, zzgkt);
        return this;
    }

    public final zzgkj zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgkk) this.zza).zzg = zzgkb.zza(i);
        return this;
    }

    /* synthetic */ zzgkj(zzgki zzgki) {
        super(zzgkk.zzb);
    }
}
