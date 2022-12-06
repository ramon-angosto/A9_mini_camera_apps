package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxv extends zzdxx {
    private final zzfiz zzf;

    public zzdxv(Executor executor, zzcgu zzcgu, zzfiz zzfiz, zzfjb zzfjb) {
        super(executor, zzcgu, zzfjb);
        this.zzf = zzfiz;
        this.zzf.zza(this.zzb);
    }

    public final Map zza() {
        return new HashMap(this.zzb);
    }
}
