package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbfg extends zzgra implements zzgsp {
    private zzbfg() {
        super(zzbfh.zzb);
    }

    public final zzbfg zza(boolean z) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzbfh.zze((zzbfh) this.zza, z);
        return this;
    }

    public final zzbfg zzb(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzbfh.zzf((zzbfh) this.zza, i);
        return this;
    }

    /* synthetic */ zzbfg(zzbew zzbew) {
        super(zzbfh.zzb);
    }
}
