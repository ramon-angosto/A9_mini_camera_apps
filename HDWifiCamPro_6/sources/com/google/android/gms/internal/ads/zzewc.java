package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzewc implements zzeve {
    private final Context zza;
    private final String zzb;
    private final zzfzq zzc;

    public zzewc(zzcbe zzcbe, Context context, String str, zzfzq zzfzq) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzfzq;
    }

    public final int zza() {
        return 42;
    }

    public final zzfzp zzb() {
        return this.zzc.zzb(new zzewb(this));
    }
}
