package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzcaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzc implements Runnable {
    public final /* synthetic */ BaseAdView zza;
    public final /* synthetic */ AdRequest zzb;

    public /* synthetic */ zzc(BaseAdView baseAdView, AdRequest adRequest) {
        this.zza = baseAdView;
        this.zzb = adRequest;
    }

    public final void run() {
        BaseAdView baseAdView = this.zza;
        try {
            baseAdView.zza.zzm(this.zzb.zza());
        } catch (IllegalStateException e) {
            zzcaf.zza(baseAdView.getContext()).zzd(e, "BaseAdView.loadAd");
        }
    }
}
