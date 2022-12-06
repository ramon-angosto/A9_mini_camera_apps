package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzepl implements zzeve {
    private final Clock zza;
    private final zzfef zzb;

    zzepl(Clock clock, zzfef zzfef) {
        this.zza = clock;
        this.zzb = zzfef;
    }

    public final int zza() {
        return 4;
    }

    public final zzfzp zzb() {
        return zzfzg.zzi(new zzepm(this.zzb, this.zza.currentTimeMillis()));
    }
}
