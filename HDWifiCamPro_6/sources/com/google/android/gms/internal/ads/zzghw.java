package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghw extends zzgra implements zzgsp {
    private zzghw() {
        super(zzghx.zzb);
    }

    public final zzghw zza(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzghx) this.zza).zzf = zzgpw;
        return this;
    }

    public final zzghw zzb(zzgid zzgid) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzghx.zzj((zzghx) this.zza, zzgid);
        return this;
    }

    public final zzghw zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzghx) this.zza).zze = 0;
        return this;
    }

    /* synthetic */ zzghw(zzghv zzghv) {
        super(zzghx.zzb);
    }
}
