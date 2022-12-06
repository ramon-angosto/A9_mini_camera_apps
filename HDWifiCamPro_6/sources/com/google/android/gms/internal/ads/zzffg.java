package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzffg implements zzgxi {
    private final zzfff zza;

    public zzffg(zzfff zzfff) {
        this.zza = zzfff;
    }

    public final /* synthetic */ Object zzb() {
        Clock instance = DefaultClock.getInstance();
        zzgxq.zzb(instance);
        return instance;
    }
}
