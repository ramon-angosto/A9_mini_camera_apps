package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzczg implements zzczh {
    private final Map zza;

    zzczg(Map map) {
        this.zza = map;
    }

    public final zzehc zza(int i, String str) {
        return (zzehc) this.zza.get(str);
    }
}
