package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.MuteThisAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcr extends zzcp {
    private final MuteThisAdListener zza;

    public zzcr(MuteThisAdListener muteThisAdListener) {
        this.zza = muteThisAdListener;
    }

    public final void zze() {
        this.zza.onAdMuted();
    }
}
