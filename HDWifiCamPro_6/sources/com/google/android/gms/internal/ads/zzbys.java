package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbys extends zzbnx {
    private final NativeAd.UnconfirmedClickListener zza;

    public zzbys(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    public final void zze() {
        this.zza.onUnconfirmedClickCancelled();
    }

    public final void zzf(String str) {
        this.zza.onUnconfirmedClickReceived(str);
    }
}
