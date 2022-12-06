package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzdv implements InitializationStatus {
    public final /* synthetic */ zzed zza;

    public /* synthetic */ zzdv(zzed zzed) {
        this.zza = zzed;
    }

    public final Map getAdapterStatusMap() {
        zzed zzed = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzdy(zzed));
        return hashMap;
    }
}
