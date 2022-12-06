package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbwk extends zzbvs {
    private final MediationInterscrollerAd zza;

    public zzbwk(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zza = mediationInterscrollerAd;
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    public final boolean zzf() {
        return this.zza.shouldDelegateInterscrollerEffect();
    }
}
