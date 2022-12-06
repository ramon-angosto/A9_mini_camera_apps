package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgix extends zzgra implements zzgsp {
    private zzgix() {
        super(zzgiy.zzb);
    }

    public final zzgix zza(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgiy) this.zza).zzf = i;
        return this;
    }

    public final zzgix zzb(zzgjb zzgjb) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgiy.zzg((zzgiy) this.zza, zzgjb);
        return this;
    }

    /* synthetic */ zzgix(zzgiw zzgiw) {
        super(zzgiy.zzb);
    }
}
