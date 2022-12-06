package com.vungle.warren;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.vungle.warren.AdConfig;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.AdMarkupDecoder;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.TimeoutProvider;
import com.vungle.warren.utility.VungleThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class Banners {
    /* access modifiers changed from: private */
    public static final String TAG = Banners.class.getSimpleName();

    public static boolean canPlayAd(String str, AdConfig.AdSize adSize) {
        return canPlayAd(str, (String) null, adSize);
    }

    public static boolean canPlayAd(final String str, String str2, final AdConfig.AdSize adSize) {
        if (!AdConfig.AdSize.isBannerAdSize(adSize)) {
            Log.e(TAG, "Invalid Ad Size. Cannot check loaded status of non banner size placements.");
            return false;
        }
        final Context appContext = Vungle.appContext();
        if (appContext == null) {
            Log.e(TAG, "Context is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "PlacementId is null");
            return false;
        } else {
            final AdMarkup decode = AdMarkupDecoder.decode(str2);
            if (str2 == null || decode != null) {
                ServiceLocator instance = ServiceLocator.getInstance(appContext);
                return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
                    public Boolean call() {
                        Advertisement advertisement;
                        AdConfig.AdSize adSize;
                        boolean z = false;
                        if (!Vungle.isInitialized()) {
                            Log.e(Banners.TAG, "Vungle is not initialized");
                            return false;
                        }
                        Repository repository = (Repository) ServiceLocator.getInstance(appContext).getService(Repository.class);
                        AdMarkup adMarkup = decode;
                        String eventId = adMarkup != null ? adMarkup.getEventId() : null;
                        Placement placement = repository.load(str, Placement.class).get();
                        if (placement == null) {
                            return false;
                        }
                        if ((placement.isMultipleHBPEnabled() && eventId == null) || (advertisement = repository.findValidAdvertisementForPlacement(str, eventId).get()) == null) {
                            return false;
                        }
                        AdConfig.AdSize adSize2 = placement.getAdSize();
                        AdConfig.AdSize adSize3 = advertisement.getAdConfig().getAdSize();
                        if (adSize == AdConfig.AdSize.VUNGLE_MREC && AdConfig.AdSize.isDefaultAdSize(adSize2) && AdConfig.AdSize.isDefaultAdSize(adSize3) && placement.getPlacementAdType() == 3) {
                            z = true;
                        }
                        if (placement.isMultipleHBPEnabled() && AdConfig.AdSize.isNonMrecBannerAdSize(adSize2) && AdConfig.AdSize.isNonMrecBannerAdSize(adSize3) && AdConfig.AdSize.isNonMrecBannerAdSize(adSize)) {
                            z = true;
                        }
                        if (z || ((adSize = adSize) == adSize2 && adSize == adSize3)) {
                            return Boolean.valueOf(Vungle.canPlayAd(advertisement));
                        }
                        return false;
                    }
                })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS));
            }
            Log.e(TAG, "Invalid AdMarkup");
            return false;
        }
    }

    @Deprecated
    public static VungleBanner getBanner(String str, AdConfig.AdSize adSize, PlayAdCallback playAdCallback) {
        return getBanner(str, new BannerAdConfig(adSize), playAdCallback);
    }

    public static VungleBanner getBanner(String str, BannerAdConfig bannerAdConfig, PlayAdCallback playAdCallback) {
        return getBanner(str, (String) null, bannerAdConfig, playAdCallback);
    }

    public static VungleBanner getBanner(String str, String str2, BannerAdConfig bannerAdConfig, PlayAdCallback playAdCallback) {
        String str3 = str;
        PlayAdCallback playAdCallback2 = playAdCallback;
        VungleLogger.debug("VungleBanner#getBanner", "getBanner call invoked");
        Context appContext = Vungle.appContext();
        if (appContext == null) {
            Log.e(TAG, "Vungle is not initialized, returned VungleBanner = null");
            onPlaybackError(str3, playAdCallback2, 9);
            return null;
        }
        AdConfig.AdSize adSize = bannerAdConfig.getAdSize();
        final ServiceLocator instance = ServiceLocator.getInstance(appContext);
        Executors executors = (Executors) instance.getService(Executors.class);
        VungleSettings vungleSettings = ((RuntimeValues) ServiceLocator.getInstance(appContext).getService(RuntimeValues.class)).settings.get();
        PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(executors.getUIExecutor(), playAdCallback2);
        VungleThreadPoolExecutor backgroundExecutor = executors.getBackgroundExecutor();
        final String str4 = str;
        final PlayAdCallbackWrapper playAdCallbackWrapper2 = playAdCallbackWrapper;
        final AdConfig.AdSize adSize2 = adSize;
        AnonymousClass2 r9 = r0;
        final String str5 = str2;
        AnonymousClass2 r0 = new Callable<Pair<Boolean, Placement>>() {
            public Pair<Boolean, Placement> call() throws Exception {
                if (!Vungle.isInitialized()) {
                    Log.e(Banners.TAG, "Vungle is not initialized.");
                    Banners.onPlaybackError(str4, playAdCallbackWrapper2, 9);
                    return new Pair<>(false, (Object) null);
                } else if (TextUtils.isEmpty(str4)) {
                    Banners.onPlaybackError(str4, playAdCallbackWrapper2, 13);
                    return new Pair<>(false, (Object) null);
                } else {
                    Placement placement = ((Repository) instance.getService(Repository.class)).load(str4, Placement.class).get();
                    if (placement == null) {
                        Banners.onPlaybackError(str4, playAdCallbackWrapper2, 13);
                        return new Pair<>(false, (Object) null);
                    } else if (!AdConfig.AdSize.isBannerAdSize(adSize2)) {
                        Banners.onPlaybackError(str4, playAdCallbackWrapper2, 30);
                        return new Pair<>(false, placement);
                    } else if (Banners.canPlayAd(str4, str5, adSize2)) {
                        return new Pair<>(true, placement);
                    } else {
                        Banners.onPlaybackError(str4, playAdCallbackWrapper2, 10);
                        return new Pair<>(false, placement);
                    }
                }
            }
        };
        Pair pair = (Pair) new FutureResult(backgroundExecutor.submit(r9)).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        if (pair == null) {
            onPlaybackError(str3, playAdCallback2, 13);
            return null;
        } else if (!((Boolean) pair.first).booleanValue()) {
            return null;
        } else {
            return new VungleBanner(appContext, str, str2, (vungleSettings == null || !vungleSettings.getBannerRefreshDisabled()) ? adSize != AdConfig.AdSize.VUNGLE_MREC ? ((Placement) pair.second).getAdRefreshDuration() : 0 : 0, bannerAdConfig, playAdCallbackWrapper);
        }
    }

    public static void loadBanner(String str, BannerAdConfig bannerAdConfig, LoadAdCallback loadAdCallback) {
        loadBanner(str, (String) null, bannerAdConfig, loadAdCallback);
    }

    @Deprecated
    public static void loadBanner(String str, AdConfig.AdSize adSize, LoadAdCallback loadAdCallback) {
        if (adSize == null) {
            onLoadError(str, loadAdCallback, 28);
        } else {
            loadBanner(str, new BannerAdConfig(adSize), loadAdCallback);
        }
    }

    public static void loadBanner(String str, String str2, BannerAdConfig bannerAdConfig, LoadAdCallback loadAdCallback) {
        VungleLogger.debug("Banners#loadBanner", "loadBanner API call invoked");
        if (Vungle.appContext() == null || !Vungle.isInitialized()) {
            onLoadError(str, loadAdCallback, 9);
            return;
        }
        AdConfig adConfig = new AdConfig((BaseAdConfig) bannerAdConfig);
        if (!AdConfig.AdSize.isBannerAdSize(adConfig.getAdSize())) {
            onLoadError(str, loadAdCallback, 30);
        } else {
            Vungle.loadAdInternal(str, str2, adConfig, loadAdCallback);
        }
    }

    /* access modifiers changed from: private */
    public static void onPlaybackError(String str, PlayAdCallback playAdCallback, int i) {
        VungleException vungleException = new VungleException(i);
        if (playAdCallback != null) {
            playAdCallback.onError(str, vungleException);
        }
        VungleLogger.error("Banners#onPlaybackError", "Banner play error: " + vungleException.getLocalizedMessage());
    }

    private static void onLoadError(String str, LoadAdCallback loadAdCallback, int i) {
        VungleException vungleException = new VungleException(i);
        if (loadAdCallback != null) {
            loadAdCallback.onError(str, vungleException);
        }
        VungleLogger.error("Banners#onLoadError", "Banner load error: " + vungleException.getLocalizedMessage());
    }
}
