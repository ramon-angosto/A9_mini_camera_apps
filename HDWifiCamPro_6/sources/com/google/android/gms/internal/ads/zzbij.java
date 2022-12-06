package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbij extends zzgra implements zzgsp {
    private zzbij() {
        super(zzbik.zzb);
    }

    public final zzbij zza(boolean z) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzbik.zzd((zzbik) this.zza, z);
        return this;
    }

    public final zzbij zzb(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzbik.zze((zzbik) this.zza, i);
        return this;
    }

    public final boolean zzc() {
        return ((zzbik) this.zza).zzf();
    }

    /* synthetic */ zzbij(zzbew zzbew) {
        super(zzbik.zzb);
    }
}
