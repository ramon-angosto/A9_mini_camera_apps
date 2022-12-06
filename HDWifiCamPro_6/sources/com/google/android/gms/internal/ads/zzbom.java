package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbom extends zzbnr {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zza;

    public zzbom(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zza = onUnifiedNativeAdLoadedListener;
    }

    public final void zze(zzbob zzbob) {
        this.zza.onUnifiedNativeAdLoaded(new zzboc(zzbob));
    }
}
