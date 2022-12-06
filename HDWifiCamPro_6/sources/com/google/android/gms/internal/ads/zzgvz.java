package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgvz extends zzgra implements zzgsp {
    private zzgvz() {
        super(zzgwa.zzb);
    }

    public final zzgvz zza(String str) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgwa.zzd((zzgwa) this.zza, str);
        return this;
    }

    public final zzgvz zzb(long j) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgwa.zze((zzgwa) this.zza, j);
        return this;
    }

    public final zzgvz zzc(boolean z) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgwa.zzf((zzgwa) this.zza, z);
        return this;
    }

    /* synthetic */ zzgvz(zzguq zzguq) {
        super(zzgwa.zzb);
    }
}
