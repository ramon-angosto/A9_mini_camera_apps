package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfli {
    private final zzfmp zza;
    private final String zzb;
    private final zzfkx zzc;
    private final String zzd = "Ad overlay";

    public zzfli(View view, zzfkx zzfkx, String str) {
        this.zza = new zzfmp(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzfkx;
    }

    public final zzfkx zza() {
        return this.zzc;
    }

    public final zzfmp zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzb;
    }
}
