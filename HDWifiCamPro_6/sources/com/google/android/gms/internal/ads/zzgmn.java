package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgmn extends zzgra implements zzgsp {
    private zzgmn() {
        super(zzgmo.zzb);
    }

    public final zzgmn zza(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgmo) this.zza).zzg = i;
        return this;
    }

    public final zzgmn zzb(String str) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgmo.zzd((zzgmo) this.zza, str);
        return this;
    }

    public final zzgmn zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgmo) this.zza).zzh = zzgnd.zza(i);
        return this;
    }

    public final zzgmn zzd(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgmo) this.zza).zzf = zzglz.zza(i);
        return this;
    }

    /* synthetic */ zzgmn(zzgml zzgml) {
        super(zzgmo.zzb);
    }
}
