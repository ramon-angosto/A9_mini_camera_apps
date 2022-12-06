package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzglw extends zzgra implements zzgsp {
    private zzglw() {
        super(zzglx.zzb);
    }

    public final zzglw zza(String str) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzglx) this.zza).zze = str;
        return this;
    }

    public final zzglw zzb(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzglx) this.zza).zzf = zzgpw;
        return this;
    }

    public final zzglw zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzglx) this.zza).zzg = i - 2;
        return this;
    }

    /* synthetic */ zzglw(zzglv zzglv) {
        super(zzglx.zzb);
    }
}
