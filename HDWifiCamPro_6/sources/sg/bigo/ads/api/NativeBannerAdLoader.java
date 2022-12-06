package sg.bigo.ads.api;

import sg.bigo.ads.ad.a.a;
import sg.bigo.ads.ad.banner.d;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

public class NativeBannerAdLoader extends AbstractAdLoader<Ad, NativeBannerAdRequest> {

    public static class Builder implements AdLoader.Builder<Ad, Builder, NativeBannerAdLoader> {
        AdLoadListener<BannerAd> mBannerAdLoader;
        AdLoadListener<NativeAd> mNativeAdLoader;

        /* access modifiers changed from: private */
        public AdLoadListener<Ad> createMixAdLoadListener() {
            return new AdLoadListener<Ad>() {
                public final void onAdLoaded(Ad ad) {
                    if ((ad instanceof NativeAd) && Builder.this.mNativeAdLoader != null) {
                        Builder.this.mNativeAdLoader.onAdLoaded((NativeAd) ad);
                    } else if ((ad instanceof BannerAd) && Builder.this.mBannerAdLoader != null) {
                        Builder.this.mBannerAdLoader.onAdLoaded((BannerAd) ad);
                    }
                }

                public final void onError(AdError adError) {
                    if (Builder.this.mNativeAdLoader != null) {
                        Builder.this.mNativeAdLoader.onError(adError);
                    } else if (Builder.this.mBannerAdLoader != null) {
                        Builder.this.mBannerAdLoader.onError(adError);
                    }
                }
            };
        }

        public NativeBannerAdLoader build() {
            return new NativeBannerAdLoader(this);
        }

        @Deprecated
        public Builder withAdLoadListener(AdLoadListener<Ad> adLoadListener) {
            return this;
        }

        public Builder withBannerAdLoadListener(AdLoadListener<BannerAd> adLoadListener) {
            this.mBannerAdLoader = adLoadListener;
            return this;
        }

        public Builder withNativeAdLoadListener(AdLoadListener<NativeAd> adLoadListener) {
            this.mNativeAdLoader = adLoadListener;
            return this;
        }
    }

    public NativeBannerAdLoader(Builder builder) {
        super(builder.createMixAdLoadListener());
    }

    public final Ad a(g gVar) {
        int m = gVar.a.m();
        int l = gVar.a.l();
        return (m == 2 || l == 3) ? new d(gVar) : m == 1 ? a.a(l, gVar) : super.a(gVar);
    }
}
