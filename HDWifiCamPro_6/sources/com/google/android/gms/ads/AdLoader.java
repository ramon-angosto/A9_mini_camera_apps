package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbl;
import com.google.android.gms.ads.internal.client.zzbo;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzeo;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbkq;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzboj;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzbyp;
import com.google.android.gms.internal.ads.zzbyr;
import com.google.android.gms.internal.ads.zzcge;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class AdLoader {
    private final zzp zza;
    private final Context zzb;
    private final zzbl zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static class Builder {
        private final Context zza;
        private final zzbo zzb;

        public Builder(Context context, String str) {
            zzbo zzc = zzaw.zza().zzc(context, str, new zzbvh());
            this.zza = (Context) Preconditions.checkNotNull(context, "context cannot be null");
            this.zzb = zzc;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zza, this.zzb.zze(), zzp.zza);
            } catch (RemoteException e) {
                zzcgp.zzh("Failed to build AdLoader.", e);
                return new AdLoader(this.zza, new zzeo().zzc(), zzp.zza);
            }
        }

        public Builder forCustomFormatAd(String str, NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzbyp zzbyp = new zzbyp(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzh(str, zzbyp.zzb(), zzbyp.zza());
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to add custom format ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzboj zzboj = new zzboj(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzh(str, zzboj.zze(), zzboj.zzd());
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forNativeAd(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.zzb.zzk(new zzbyr(onNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to add google native ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzb.zzk(new zzbom(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzb.zzl(new zzg(adListener));
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withAdManagerAdViewOptions(AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.zzb.zzm(adManagerAdViewOptions);
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to specify Ad Manager banner ad options", e);
            }
            return this;
        }

        @Deprecated
        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzo(new zzbls(nativeAdOptions));
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder forAdManagerAdView(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzb.zzj(new zzbol(onAdManagerAdViewLoadedListener), new zzq(this.zza, adSizeArr));
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to add Google Ad Manager banner ad listener", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzo(new zzbls(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzff(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio()));
            } catch (RemoteException e) {
                zzcgp.zzk("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzbl zzbl, zzp zzp) {
        this.zzb = context;
        this.zzc = zzbl;
        this.zza = zzp;
    }

    private final void zzb(zzdr zzdr) {
        zzbjc.zzc(this.zzb);
        if (((Boolean) zzbkq.zzc.zze()).booleanValue()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziM)).booleanValue()) {
                zzcge.zzb.execute(new zza(this, zzdr));
                return;
            }
        }
        try {
            this.zzc.zzg(this.zza.zza(this.zzb, zzdr));
        } catch (RemoteException e) {
            zzcgp.zzh("Failed to load ad.", e);
        }
    }

    public boolean isLoading() {
        try {
            return this.zzc.zzi();
        } catch (RemoteException e) {
            zzcgp.zzk("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zzb(adRequest.zza());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzc.zzh(this.zza.zza(this.zzb, adRequest.zza()), i);
        } catch (RemoteException e) {
            zzcgp.zzh("Failed to load ads.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdr zzdr) {
        try {
            this.zzc.zzg(this.zza.zza(this.zzb, zzdr));
        } catch (RemoteException e) {
            zzcgp.zzh("Failed to load ad.", e);
        }
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        zzb(adManagerAdRequest.zza);
    }
}
