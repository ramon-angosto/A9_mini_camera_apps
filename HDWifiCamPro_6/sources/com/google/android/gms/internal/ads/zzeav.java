package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeav implements NativeAd.OnNativeAdLoadedListener {
    public final /* synthetic */ zzebe zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzeav(zzebe zzebe, String str, String str2) {
        this.zza = zzebe;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void onNativeAdLoaded(NativeAd nativeAd) {
        this.zza.zze(this.zzb, nativeAd, this.zzc);
    }
}
