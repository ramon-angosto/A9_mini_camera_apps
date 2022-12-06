package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbyr extends zzbnr {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbyr(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbob zzbob) {
        this.zza.onNativeAdLoaded(new zzbyk(zzbob));
    }
}
