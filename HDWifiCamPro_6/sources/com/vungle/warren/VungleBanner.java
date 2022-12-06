package com.vungle.warren;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.vungle.warren.AdConfig;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.ui.view.VungleBannerView;
import com.vungle.warren.utility.AdMarkupDecoder;
import com.vungle.warren.utility.RefreshHandler;
import com.vungle.warren.utility.ViewUtility;
import com.vungle.warren.utility.WeakLoadAdCallback;
import com.vungle.warren.utility.WeakRunnable;

public class VungleBanner extends RelativeLayout {
    /* access modifiers changed from: private */
    public static final String TAG = VungleBanner.class.getSimpleName();
    /* access modifiers changed from: private */
    public VungleBannerView bannerAd;
    /* access modifiers changed from: private */
    public BannerAdConfig bannerAdConfig;
    private int calculatedPixelHeight;
    private int calculatedPixelWidth;
    private boolean destroyed;
    private boolean disableRenderManagement;
    private LoadAdCallback loadAdCallback = new LoadAdCallback() {
        public void onAdLoad(String str) {
            String access$000 = VungleBanner.TAG;
            Log.d(access$000, "Ad Loaded : " + str);
            if (VungleBanner.this.renderWhenAvailable && VungleBanner.this.canRender()) {
                boolean unused = VungleBanner.this.renderWhenAvailable = false;
                VungleBanner.this.finishAdInternal(false);
                VungleBannerView bannerViewInternal = Vungle.getBannerViewInternal(VungleBanner.this.placementId, (AdMarkup) null, new AdConfig((BaseAdConfig) VungleBanner.this.bannerAdConfig), VungleBanner.this.playAdCallback);
                if (bannerViewInternal != null) {
                    VungleBannerView unused2 = VungleBanner.this.bannerAd = bannerViewInternal;
                    VungleBanner.this.renderAd();
                    return;
                }
                onError(VungleBanner.this.placementId, new VungleException(10));
                VungleLogger.error(VungleBanner.class.getSimpleName() + "#loadAdCallback; onAdLoad", "VungleBannerView is null");
            }
        }

        public void onError(String str, VungleException vungleException) {
            String access$000 = VungleBanner.TAG;
            Log.d(access$000, "Ad Load Error : " + str + " Message : " + vungleException.getLocalizedMessage());
            if (VungleBanner.this.getVisibility() == 0 && VungleBanner.this.canRender()) {
                VungleBanner.this.refreshHandler.start();
            }
        }
    };
    /* access modifiers changed from: private */
    public String placementId;
    /* access modifiers changed from: private */
    public PlayAdCallback playAdCallback;
    private Runnable refreshAdRunnable = new Runnable() {
        public void run() {
            Log.d(VungleBanner.TAG, "Refresh Timeout Reached");
            boolean unused = VungleBanner.this.renderWhenAvailable = true;
            VungleBanner.this.loadAdInternal();
        }
    };
    /* access modifiers changed from: private */
    public RefreshHandler refreshHandler;
    private boolean renderAdRequested;
    /* access modifiers changed from: private */
    public boolean renderWhenAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected VungleBanner(Context context, String str, String str2, int i, BannerAdConfig bannerAdConfig2, PlayAdCallback playAdCallback2) {
        super(context);
        Context context2 = context;
        String str3 = str;
        BannerAdConfig bannerAdConfig3 = bannerAdConfig2;
        long currentTimeMillis = System.currentTimeMillis();
        VungleLogger.verbose(true, TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Creating banner ad, id = %1$s, at: %2$d", new Object[]{str3, Long.valueOf(currentTimeMillis)}));
        this.placementId = str3;
        this.bannerAdConfig = bannerAdConfig3;
        AdConfig.AdSize adSize = bannerAdConfig2.getAdSize();
        this.playAdCallback = playAdCallback2;
        this.calculatedPixelHeight = ViewUtility.dpToPixels(context2, adSize.getHeight());
        this.calculatedPixelWidth = ViewUtility.dpToPixels(context2, adSize.getWidth());
        SessionTracker.getInstance().trackAdConfig(bannerAdConfig3);
        this.bannerAd = Vungle.getBannerViewInternal(str3, AdMarkupDecoder.decode(str2), new AdConfig((BaseAdConfig) bannerAdConfig3), this.playAdCallback);
        this.refreshHandler = new RefreshHandler(new WeakRunnable(this.refreshAdRunnable), ((long) i) * 1000);
        VungleLogger.verbose(true, TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Banner ad created, id = %1$s, elapsed time: %2$dms", new Object[]{str3, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        String str = TAG;
        Log.d(str, "Banner onWindowVisibilityChanged: " + i);
        setAdVisibility(i == 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "Banner onAttachedToWindow");
        if (!this.disableRenderManagement) {
            renderAd();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.disableRenderManagement) {
            Log.d(TAG, "Banner onDetachedFromWindow: render management disabled, do nothing");
        } else {
            finishAdInternal(true);
        }
    }

    public void renderAd() {
        this.renderAdRequested = true;
        if (getVisibility() == 0) {
            VungleBannerView vungleBannerView = this.bannerAd;
            if (vungleBannerView != null) {
                View renderBannerView = vungleBannerView.renderBannerView();
                if (renderBannerView.getParent() != this) {
                    addView(renderBannerView, this.calculatedPixelWidth, this.calculatedPixelHeight);
                    Log.d(TAG, "Add VungleBannerView to Parent");
                }
                String str = TAG;
                Log.d(str, "Rendering new ad for: " + this.placementId);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.calculatedPixelHeight;
                    layoutParams.width = this.calculatedPixelWidth;
                    requestLayout();
                }
                this.refreshHandler.start();
            } else if (canRender()) {
                this.renderWhenAvailable = true;
                loadAdInternal();
            }
        }
    }

    public void finishAd() {
        finishAdInternal(true);
    }

    /* access modifiers changed from: private */
    public void finishAdInternal(boolean z) {
        synchronized (this) {
            this.refreshHandler.clean();
            if (this.bannerAd != null) {
                this.bannerAd.finishDisplayingAdInternal(z);
                this.bannerAd = null;
                try {
                    removeAllViews();
                } catch (Exception e) {
                    String str = TAG;
                    Log.d(str, "Removing webview error: " + e.getLocalizedMessage());
                }
            }
        }
    }

    public void destroyAd() {
        finishAdInternal(true);
        this.destroyed = true;
        this.playAdCallback = null;
    }

    public void setAdVisibility(boolean z) {
        if (!z || !canRender()) {
            this.refreshHandler.pause();
        } else {
            this.refreshHandler.start();
        }
        VungleBannerView vungleBannerView = this.bannerAd;
        if (vungleBannerView != null) {
            vungleBannerView.setAdVisibility(z);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        setAdVisibility(z);
    }

    /* access modifiers changed from: private */
    public boolean canRender() {
        return !this.destroyed && (!this.disableRenderManagement || this.renderAdRequested);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        setAdVisibility(i == 0);
    }

    /* access modifiers changed from: protected */
    public void loadAdInternal() {
        Log.d(TAG, "Loading Ad");
        Banners.loadBanner(this.placementId, this.bannerAdConfig, (LoadAdCallback) new WeakLoadAdCallback(this.loadAdCallback));
    }

    public void disableLifeCycleManagement(boolean z) {
        this.disableRenderManagement = z;
    }
}
