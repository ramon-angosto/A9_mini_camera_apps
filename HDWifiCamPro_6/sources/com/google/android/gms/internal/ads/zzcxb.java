package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcxb implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzcxb(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    /* renamed from: zza */
    public final zzdfp zzb() {
        return new zzdfp((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb());
    }
}
