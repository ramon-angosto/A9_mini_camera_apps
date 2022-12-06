package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzesk implements zzeve {
    private final zzfzq zza;
    private final zzfef zzb;

    zzesk(zzfzq zzfzq, zzfef zzfef) {
        this.zza = zzfzq;
        this.zzb = zzfef;
    }

    public final int zza() {
        return 21;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzesj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzesl zzc() throws Exception {
        return new zzesl("requester_type_2".equals(zzf.zzb(this.zzb.zzd)));
    }
}
