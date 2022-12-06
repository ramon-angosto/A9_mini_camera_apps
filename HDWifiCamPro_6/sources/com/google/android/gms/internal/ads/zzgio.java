package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgio extends zzgra implements zzgsp {
    private zzgio() {
        super(zzgip.zzb);
    }

    public final zzgio zza(int i) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        ((zzgip) this.zza).zzf = i;
        return this;
    }

    public final zzgio zzb(zzgis zzgis) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zzgip.zzh((zzgip) this.zza, zzgis);
        return this;
    }

    /* synthetic */ zzgio(zzgin zzgin) {
        super(zzgip.zzb);
    }
}
