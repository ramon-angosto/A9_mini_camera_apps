package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcdx implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzcdx(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    /* renamed from: zza */
    public final zzcdw zzb() {
        return new zzcdw((Clock) this.zza.zzb(), (zzcdu) this.zzb.zzb());
    }
}
