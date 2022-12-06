package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzez;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcdw {
    private final Clock zza;
    private final zzcdu zzb;

    zzcdw(Clock clock, zzcdu zzcdu) {
        this.zza = clock;
        this.zzb = zzcdu;
    }

    public static zzcdw zza(Context context) {
        return zzcev.zzd(context).zzb();
    }

    public final void zzb(int i, long j) {
        this.zzb.zzb(i, j);
    }

    public final void zzc() {
        this.zzb.zza();
    }

    public final void zzd(zzez zzez) {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }

    public final void zze() {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }
}
