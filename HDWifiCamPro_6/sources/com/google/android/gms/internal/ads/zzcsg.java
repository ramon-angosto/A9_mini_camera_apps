package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzae;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import com.google.android.gms.ads.nonagon.signalgeneration.zzh;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcsg implements zzg {
    private final zzcpw zza;
    private zzdcm zzb;
    private zzae zzc;

    /* synthetic */ zzcsg(zzcpw zzcpw, zzcsf zzcsf) {
        this.zza = zzcpw;
    }

    public final /* synthetic */ zzg zza(zzdcm zzdcm) {
        this.zzb = zzdcm;
        return this;
    }

    public final /* synthetic */ zzg zzb(zzae zzae) {
        this.zzc = zzae;
        return this;
    }

    public final zzh zzc() {
        zzgxq.zzc(this.zzb, zzdcm.class);
        zzgxq.zzc(this.zzc, zzae.class);
        return new zzcsi(this.zza, this.zzc, new zzdaj(), new zzdyd(), this.zzb, (zzfbf) null, (zzfag) null, (zzcsh) null);
    }
}
