package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbfa extends zzgra implements zzgsp {
    private zzbfa() {
        super(zzbfb.zzb);
    }

    public final zzbfa zza(zzbez zzbez) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzbfb.zze((zzbfb) this.zza, zzbez);
        return this;
    }

    public final zzbfa zzb(zzbfs zzbfs) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzbfb.zzf((zzbfb) this.zza, (zzbft) zzbfs.zzam());
        return this;
    }

    /* synthetic */ zzbfa(zzbew zzbew) {
        super(zzbfb.zzb);
    }
}
