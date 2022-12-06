package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmb extends zzgra implements zzgsp {
    private zzgmb() {
        super(zzgmc.zzb);
    }

    public final zzgmb zza(String str) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgmc.zzg((zzgmc) this.zza, str);
        return this;
    }

    public final zzgmb zzb(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgmc) this.zza).zzf = zzgpw;
        return this;
    }

    public final zzgmb zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgmc) this.zza).zzg = zzgnd.zza(i);
        return this;
    }

    /* synthetic */ zzgmb(zzgma zzgma) {
        super(zzgmc.zzb);
    }
}
