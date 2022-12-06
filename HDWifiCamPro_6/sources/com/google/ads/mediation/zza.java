package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zze;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zza extends UnifiedNativeAdMapper {
    private final UnifiedNativeAd zza;

    public zza(UnifiedNativeAd unifiedNativeAd) {
        this.zza = unifiedNativeAd;
        setHeadline(unifiedNativeAd.getHeadline());
        setImages(unifiedNativeAd.getImages());
        setBody(unifiedNativeAd.getBody());
        setIcon(unifiedNativeAd.getIcon());
        setCallToAction(unifiedNativeAd.getCallToAction());
        setAdvertiser(unifiedNativeAd.getAdvertiser());
        setStarRating(unifiedNativeAd.getStarRating());
        setStore(unifiedNativeAd.getStore());
        setPrice(unifiedNativeAd.getPrice());
        zzd(unifiedNativeAd.zza());
        setOverrideImpressionRecording(true);
        setOverrideClickHandling(true);
        zze(unifiedNativeAd.getVideoController());
    }

    public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        if (view instanceof zzg) {
            zzg zzg = (zzg) view;
            throw null;
        } else if (((zze) zze.zza.get(view)) != null) {
            throw null;
        }
    }
}
