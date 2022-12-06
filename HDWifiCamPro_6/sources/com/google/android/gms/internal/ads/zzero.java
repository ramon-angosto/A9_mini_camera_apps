package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzero implements zzeve {
    private final AtomicReference zza = new AtomicReference();
    private final Clock zzb;
    private final zzeve zzc;
    private final long zzd;

    public zzero(zzeve zzeve, long j, Clock clock) {
        this.zzb = clock;
        this.zzc = zzeve;
        this.zzd = j;
    }

    public final int zza() {
        return 16;
    }

    public final zzfzp zzb() {
        zzern zzern = (zzern) this.zza.get();
        if (zzern == null || zzern.zza()) {
            zzern = new zzern(this.zzc.zzb(), this.zzd, this.zzb);
            this.zza.set(zzern);
        }
        return zzern.zza;
    }
}
