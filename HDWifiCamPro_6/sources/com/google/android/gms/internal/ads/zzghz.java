package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghz extends zzgra implements zzgsp {
    private zzghz() {
        super(zzgia.zzb);
    }

    public final zzghz zza(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgia) this.zza).zze = 32;
        return this;
    }

    public final zzghz zzb(zzgid zzgid) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgia.zzh((zzgia) this.zza, zzgid);
        return this;
    }

    /* synthetic */ zzghz(zzghy zzghy) {
        super(zzgia.zzb);
    }
}
