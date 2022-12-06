package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzepp implements zzeve {
    private final zzfzq zza;
    private final zzfef zzb;
    private final zzfer zzc;

    zzepp(zzfzq zzfzq, zzfef zzfef, zzfer zzfer) {
        this.zza = zzfzq;
        this.zzb = zzfef;
        this.zzc = zzfer;
    }

    public final int zza() {
        return 5;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzepo(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepq zzc() throws Exception {
        String str = null;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgn)).booleanValue() && "requester_type_2".equals(zzf.zzb(this.zzb.zzd))) {
            str = zzfer.zza();
        }
        return new zzepq(str);
    }
}
