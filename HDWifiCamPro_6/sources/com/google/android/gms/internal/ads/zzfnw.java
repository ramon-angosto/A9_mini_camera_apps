package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfnw extends zzgra implements zzgsp {
    private zzfnw() {
        super(zzfny.zzb);
    }

    public final zzfnw zza(String str) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzfny.zzd((zzfny) this.zza, str);
        return this;
    }

    public final zzfnw zzb(zzfnt zzfnt) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzfny.zze((zzfny) this.zza, (zzfnu) zzfnt.zzam());
        return this;
    }

    public final zzfnw zzc(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzfny.zzf((zzfny) this.zza, 2);
        return this;
    }

    /* synthetic */ zzfnw(zzfnv zzfnv) {
        super(zzfny.zzb);
    }
}
