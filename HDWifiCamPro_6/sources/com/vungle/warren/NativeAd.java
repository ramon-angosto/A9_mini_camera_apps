package com.vungle.warren;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.ui.view.MediaView;
import com.vungle.warren.utility.AdMarkupDecoder;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.ImageLoader;
import com.vungle.warren.utility.ImpressionTracker;
import com.vungle.warren.utility.TimeoutProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class NativeAd {
    private static final int STATE_DESTROY = 4;
    private static final int STATE_ERROR = 5;
    private static final int STATE_NEW = 1;
    private static final int STATE_READY = 2;
    private static final int STATE_VIEWING = 3;
    /* access modifiers changed from: private */
    public static final String TAG = NativeAd.class.getSimpleName();
    private static final String TOKEN_APP_DESCRIPTION = "APP_DESCRIPTION";
    private static final String TOKEN_APP_ICON = "APP_ICON";
    private static final String TOKEN_APP_NAME = "APP_NAME";
    private static final String TOKEN_APP_RATING_VALUE = "APP_RATING_VALUE";
    private static final String TOKEN_CTA_BUTTON_TEXT = "CTA_BUTTON_TEXT";
    public static final String TOKEN_CTA_BUTTON_URL = "CTA_BUTTON_URL";
    private static final String TOKEN_MAIN_IMAGE = "MAIN_IMAGE";
    private static final String TOKEN_SPONSORED_BY = "SPONSORED_BY";
    private static final String TOKEN_VUNGLE_PRIVACY_ICON_URL = "VUNGLE_PRIVACY_ICON_URL";
    public static final String TOKEN_VUNGLE_PRIVACY_URL = "VUNGLE_PRIVACY_URL";
    private AdConfig adConfig;
    /* access modifiers changed from: private */
    public String adMarkUp;
    private FrameLayout adOptionsRootView;
    private NativeAdOptionsView adOptionsView;
    /* access modifiers changed from: private */
    public int adState;
    private List<View> clickableViews;
    private MediaView contentView;
    private final Context context;
    private ImageView iconView;
    private final ImageLoader imageLoader;
    private ImpressionTracker impressionTracker;
    private final LoadNativeAdCallback loadAdCallback = new LoadNativeAdCallback() {
        public void onAdLoad(Advertisement advertisement) {
            String access$000 = NativeAd.TAG;
            VungleLogger.debug(true, access$000, "NativeAd", "Native Ad Loaded : " + NativeAd.this.placementId);
            if (advertisement == null) {
                NativeAd nativeAd = NativeAd.this;
                nativeAd.onLoadError(nativeAd.placementId, NativeAd.this.nativeAdCallback, 11);
                return;
            }
            int unused = NativeAd.this.adState = 2;
            Map unused2 = NativeAd.this.nativeAdAssetMap = advertisement.getMRAIDArgsInMap();
            if (NativeAd.this.nativeAdCallback != null) {
                NativeAd.this.nativeAdCallback.onNativeAdLoaded(NativeAd.this);
            }
        }

        public void onAdLoad(String str) {
            VungleLogger.error(true, NativeAd.TAG, "NativeAd", "Internal error! For native ads we should use onAdLoad(advertisement) callback.");
        }

        public void onError(String str, VungleException vungleException) {
            String access$000 = NativeAd.TAG;
            VungleLogger.debug(true, access$000, "NativeAd", "Native Ad Load Error : " + str + " Message : " + vungleException.getLocalizedMessage());
            NativeAd nativeAd = NativeAd.this;
            nativeAd.onLoadError(str, nativeAd.nativeAdCallback, vungleException.getExceptionCode());
        }
    };
    /* access modifiers changed from: private */
    public Map<String, String> nativeAdAssetMap;
    /* access modifiers changed from: private */
    public NativeAdListener nativeAdCallback;
    /* access modifiers changed from: private */
    public final String placementId;
    private final PlayAdCallback playAdCallback = new PlayAdCallback() {
        public void onAdEnd(String str) {
        }

        public void onAdEnd(String str, boolean z, boolean z2) {
        }

        public void onAdRewarded(String str) {
        }

        public void onAdStart(String str) {
        }

        public void creativeId(String str) {
            if (NativeAd.this.nativeAdCallback != null) {
                NativeAd.this.nativeAdCallback.creativeId(str);
            }
        }

        public void onAdClick(String str) {
            if (NativeAd.this.nativeAdCallback != null) {
                NativeAd.this.nativeAdCallback.onAdClick(str);
            }
        }

        public void onAdLeftApplication(String str) {
            if (NativeAd.this.nativeAdCallback != null) {
                NativeAd.this.nativeAdCallback.onAdLeftApplication(str);
            }
        }

        public void onError(String str, VungleException vungleException) {
            int unused = NativeAd.this.adState = 5;
            if (NativeAd.this.nativeAdCallback != null) {
                NativeAd.this.nativeAdCallback.onAdPlayError(str, vungleException);
            }
        }

        public void onAdViewed(String str) {
            if (NativeAd.this.nativeAdCallback != null) {
                NativeAd.this.nativeAdCallback.onAdImpression(str);
            }
        }
    };
    /* access modifiers changed from: private */
    public NativeAdLayout rootNativeView;
    /* access modifiers changed from: private */
    public final Executor uiExecutor;

    public NativeAd(Context context2, String str) {
        this.context = context2;
        this.placementId = str;
        Executors executors = (Executors) ServiceLocator.getInstance(context2).getService(Executors.class);
        this.uiExecutor = executors.getUIExecutor();
        this.imageLoader = ImageLoader.getInstance();
        this.imageLoader.init(executors.getIOExecutor());
        this.adState = 1;
    }

    public void loadAd(AdConfig adConfig2, NativeAdListener nativeAdListener) {
        loadAd(adConfig2, (String) null, nativeAdListener);
    }

    public void loadAd(AdConfig adConfig2, String str, NativeAdListener nativeAdListener) {
        VungleLogger.debug("NativeAd#loadAd", "loadAd API call invoked");
        if (!Vungle.isInitialized()) {
            onLoadError(this.placementId, nativeAdListener, 9);
            return;
        }
        this.adState = 1;
        if (adConfig2 == null) {
            adConfig2 = new AdConfig();
        }
        this.adConfig = adConfig2;
        this.adMarkUp = str;
        this.nativeAdCallback = nativeAdListener;
        Vungle.loadAdInternal(this.placementId, str, this.adConfig, this.loadAdCallback);
    }

    /* access modifiers changed from: private */
    public void onLoadError(String str, NativeAdListener nativeAdListener, int i) {
        this.adState = 5;
        VungleException vungleException = new VungleException(i);
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str, vungleException);
        }
        VungleLogger.error("NativeAd#onLoadError", "NativeAd load error: " + vungleException.getLocalizedMessage());
    }

    public boolean canPlayAd() {
        if (TextUtils.isEmpty(this.placementId)) {
            VungleLogger.error(true, TAG, "NativeAd", "PlacementId is null");
            return false;
        } else if (this.adState != 2) {
            String str = TAG;
            Log.w(str, "Ad is not loaded or is displaying for placement: " + this.placementId);
            return false;
        } else {
            AdMarkup decode = AdMarkupDecoder.decode(this.adMarkUp);
            if (TextUtils.isEmpty(this.adMarkUp) || decode != null) {
                final ServiceLocator instance = ServiceLocator.getInstance(this.context);
                return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
                    public Boolean call() {
                        Advertisement advertisement;
                        if (!Vungle.isInitialized()) {
                            VungleLogger.error(true, NativeAd.TAG, "NativeAd", "Vungle is not initialized");
                            return false;
                        }
                        Repository repository = (Repository) instance.getService(Repository.class);
                        AdRequest adRequest = new AdRequest(NativeAd.this.placementId, AdMarkupDecoder.decode(NativeAd.this.adMarkUp), false);
                        Placement placement = repository.load(NativeAd.this.placementId, Placement.class).get();
                        if (placement == null) {
                            return false;
                        }
                        if ((!placement.isMultipleHBPEnabled() || adRequest.getEventId() != null) && (advertisement = repository.findValidAdvertisementForPlacement(NativeAd.this.placementId, adRequest.getEventId()).get()) != null) {
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

    public String getPlacementId() {
        return this.placementId;
    }

    public void destroy() {
        Log.d(TAG, "destroy()");
        this.adState = 4;
        Map<String, String> map = this.nativeAdAssetMap;
        if (map != null) {
            map.clear();
            this.nativeAdAssetMap = null;
        }
        ImpressionTracker impressionTracker2 = this.impressionTracker;
        if (impressionTracker2 != null) {
            impressionTracker2.destroy();
            this.impressionTracker = null;
        }
        ImageView imageView = this.iconView;
        if (imageView != null) {
            imageView.setImageDrawable((Drawable) null);
            this.iconView = null;
        }
        MediaView mediaView = this.contentView;
        if (mediaView != null) {
            mediaView.destroy();
            this.contentView = null;
        }
        NativeAdOptionsView nativeAdOptionsView = this.adOptionsView;
        if (nativeAdOptionsView != null) {
            nativeAdOptionsView.destroy();
            this.adOptionsView = null;
        }
        NativeAdLayout nativeAdLayout = this.rootNativeView;
        if (nativeAdLayout != null) {
            nativeAdLayout.finishDisplayingAdInternal(true);
            this.rootNativeView = null;
        }
    }

    public String getAppIcon() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_APP_ICON);
        return str == null ? "" : str;
    }

    public String getAdTitle() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_APP_NAME);
        return str == null ? "" : str;
    }

    public String getAdBodyText() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_APP_DESCRIPTION);
        return str == null ? "" : str;
    }

    public String getAdCallToActionText() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_CTA_BUTTON_TEXT);
        return str == null ? "" : str;
    }

    public Double getAdStarRating() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? null : map.get(TOKEN_APP_RATING_VALUE);
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException unused) {
                String str2 = TAG;
                VungleLogger.error(true, str2, "NativeAd", "Unable to parse " + str + " as double.");
            }
        }
        return null;
    }

    public String getAdSponsoredText() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_SPONSORED_BY);
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    public String getPrivacyIconUrl() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_VUNGLE_PRIVACY_ICON_URL);
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    public String getPrivacyUrl() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_VUNGLE_PRIVACY_URL);
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    public String getCtaUrl() {
        Map<String, String> map = this.nativeAdAssetMap;
        String str = map == null ? "" : map.get(TOKEN_CTA_BUTTON_URL);
        return str == null ? "" : str;
    }

    public boolean hasCallToAction() {
        return !TextUtils.isEmpty(getCtaUrl());
    }

    public void setAdOptionsRootView(FrameLayout frameLayout) {
        if (VungleApiClient.WRAPPER_FRAMEWORK_SELECTED == null || VungleApiClient.WRAPPER_FRAMEWORK_SELECTED == VungleApiClient.WrapperFramework.none) {
            Log.w(TAG, "You can NOT use this API to change the privacy icon parent view, please use NativeAdLayout as your native ad root view!");
        } else {
            this.adOptionsRootView = frameLayout;
        }
    }

    public void unregisterView() {
        NativeAdOptionsView nativeAdOptionsView = this.adOptionsView;
        if (!(nativeAdOptionsView == null || nativeAdOptionsView.getParent() == null)) {
            ((ViewGroup) this.adOptionsView.getParent()).removeView(this.adOptionsView);
        }
        ImpressionTracker impressionTracker2 = this.impressionTracker;
        if (impressionTracker2 != null) {
            impressionTracker2.clear();
        }
        List<View> list = this.clickableViews;
        if (list != null) {
            for (View onClickListener : list) {
                onClickListener.setOnClickListener((View.OnClickListener) null);
            }
            return;
        }
        MediaView mediaView = this.contentView;
        if (mediaView != null) {
            mediaView.setOnClickListener((View.OnClickListener) null);
        }
    }

    public void registerViewForInteraction(final NativeAdLayout nativeAdLayout, MediaView mediaView, ImageView imageView, List<View> list) {
        if (!canPlayAd()) {
            this.playAdCallback.onError(this.placementId, new VungleException(10));
            return;
        }
        this.adState = 3;
        this.rootNativeView = nativeAdLayout;
        this.contentView = mediaView;
        this.iconView = imageView;
        this.clickableViews = list;
        NativeAdOptionsView nativeAdOptionsView = this.adOptionsView;
        if (nativeAdOptionsView != null) {
            nativeAdOptionsView.destroy();
        }
        this.adOptionsView = new NativeAdOptionsView(this.context);
        if (this.adOptionsRootView == null) {
            this.adOptionsRootView = nativeAdLayout;
        }
        this.adOptionsView.renderTo(this, this.adOptionsRootView, this.adConfig.getAdOptionsPosition());
        this.impressionTracker = new ImpressionTracker(this.context);
        nativeAdLayout.finishDisplayingAdInternal(false);
        this.impressionTracker.addView(this.adOptionsRootView, new ImpressionTracker.ImpressionListener() {
            public void onImpression(View view) {
                nativeAdLayout.onImpression();
            }
        });
        ServiceLocator instance = ServiceLocator.getInstance(this.context);
        AdRequest adRequest = new AdRequest(this.placementId, AdMarkupDecoder.decode(this.adMarkUp), false);
        nativeAdLayout.register(this.context, this, (PresentationFactory) instance.getService(PresentationFactory.class), Vungle.getEventListener(adRequest, this.playAdCallback), this.adConfig, adRequest);
        Map<String, String> map = this.nativeAdAssetMap;
        displayImage(map == null ? null : map.get(TOKEN_MAIN_IMAGE), mediaView.getMainImage());
        if (imageView != null) {
            displayImage(getAppIcon(), imageView);
        }
        if (list == null || list.size() <= 0) {
            registerClickEvent(mediaView, 1);
            return;
        }
        for (View registerClickEvent : list) {
            registerClickEvent(registerClickEvent, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void registerClickEvent(View view, final int i) {
        view.setClickable(true);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (NativeAd.this.rootNativeView != null) {
                    NativeAd.this.rootNativeView.onItemClicked(i);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void displayImage(String str, final ImageView imageView) {
        this.imageLoader.displayImage(str, new ImageLoader.ImageLoaderListener() {
            public void onImageLoaded(final Bitmap bitmap) {
                if (imageView != null) {
                    NativeAd.this.uiExecutor.execute(new Runnable() {
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }
}
