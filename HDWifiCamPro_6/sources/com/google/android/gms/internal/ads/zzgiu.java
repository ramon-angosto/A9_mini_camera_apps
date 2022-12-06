package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgiu extends zzgra implements zzgsp {
    private zzgiu() {
        super(zzgiv.zzb);
    }

    public final zzgiu zza(zzgpw zzgpw) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgiv) this.zza).zzg = zzgpw;
        return this;
    }

    public final zzgiu zzb(zzgjb zzgjb) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgiv.zzi((zzgiv) this.zza, zzgjb);
        return this;
    }

    public final zzgiu zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgiv) this.zza).zze = 0;
        return this;
    }

    /* synthetic */ zzgiu(zzgit zzgit) {
        super(zzgiv.zzb);
    }
}
