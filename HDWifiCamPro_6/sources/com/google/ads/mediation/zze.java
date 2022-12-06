package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zze extends AdListener implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener {
    final AbstractAdViewAdapter zza;
    final MediationNativeListener zzb;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, (AdError) loadAdError);
    }

    public final void onAdImpression() {
        this.zzb.onAdImpression(this.zza);
    }

    public final void onAdLoaded() {
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened(this.zza);
    }

    public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        this.zzb.zze(this.zza, nativeCustomTemplateAd, str);
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        this.zzb.zzc(this.zza, nativeCustomTemplateAd);
    }

    public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
        this.zzb.onAdLoaded(this.zza, new zza(unifiedNativeAd));
    }
}
