package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzglc extends zzgra implements zzgsp {
    private zzglc() {
        super(zzgld.zzb);
    }

    public final zzglc zza(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgld) this.zza).zzf = i;
        return this;
    }

    public final zzglc zzb(zzglg zzglg) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgld.zzh((zzgld) this.zza, zzglg);
        return this;
    }

    /* synthetic */ zzglc(zzglb zzglb) {
        super(zzgld.zzb);
    }
}
