package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzglq extends zzgra implements zzgsp {
    private zzglq() {
        super(zzglr.zzb);
    }

    public final zzglq zza(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzglr) this.zza).zzg = zzgpw;
        return this;
    }

    public final zzglq zzb(zzglu zzglu) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzglr.zzi((zzglr) this.zza, zzglu);
        return this;
    }

    public final zzglq zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzglr) this.zza).zze = 0;
        return this;
    }

    /* synthetic */ zzglq(zzglp zzglp) {
        super(zzglr.zzb);
    }
}
