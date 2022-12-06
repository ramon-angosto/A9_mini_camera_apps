package com.vungle.warren.ui.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcessClient;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.AdRequest;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.CloseDelegate;
import com.vungle.warren.ui.JavascriptBridge;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.WebAdContract;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.ExternalRouter;
import com.vungle.warren.utility.HandlerScheduler;
import java.util.concurrent.atomic.AtomicReference;

public class VungleBannerView extends WebView implements WebAdContract.WebAdView {
    private static final String TAG = VungleBannerView.class.getName();
    private BroadcastReceiver broadcastReceiver;
    private final AdConfig config;
    private boolean destroyed;
    /* access modifiers changed from: private */
    public AtomicReference<Boolean> isAdVisible = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AdContract.AdvertisementPresenter.EventListener listener;
    /* access modifiers changed from: private */
    public OnViewTouchListener onViewTouchListener = new OnViewTouchListener() {
        public boolean onTouch(MotionEvent motionEvent) {
            if (VungleBannerView.this.presenter == null) {
                return false;
            }
            VungleBannerView.this.presenter.onViewTouched(motionEvent);
            return false;
        }
    };
    /* access modifiers changed from: private */
    public WebAdContract.WebAdPresenter presenter;
    PresentationFactory presenterFactory;
    /* access modifiers changed from: private */
    public final AdRequest request;

    public boolean hasWebView() {
        return true;
    }

    public void refreshDialogIfVisible() {
    }

    public View renderBannerView() {
        return this;
    }

    public void setImmersiveMode() {
    }

    public void setOrientation(int i) {
    }

    public void setPresenter(WebAdContract.WebAdPresenter webAdPresenter) {
    }

    public void updateWindow() {
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "Resuming Flex");
        setAdVisibility(true);
    }

    public void onPause() {
        super.onPause();
        setAdVisibility(false);
    }

    public VungleBannerView(Context context, AdRequest adRequest, AdConfig adConfig, PresentationFactory presentationFactory, AdContract.AdvertisementPresenter.EventListener eventListener) {
        super(context);
        this.listener = eventListener;
        this.request = adRequest;
        this.config = adConfig;
        this.presenterFactory = presentationFactory;
        setLayerType(2, (Paint) null);
        setBackgroundColor(0);
        attachListeners();
    }

    private void attachListeners() {
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (VungleBannerView.this.onViewTouchListener != null) {
                    return VungleBannerView.this.onViewTouchListener.onTouch(motionEvent);
                }
                return VungleBannerView.super.onTouchEvent(motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    public void prepare() {
        WebSettingsUtils.applyDefault(this);
        addJavascriptInterface(new JavascriptBridge(this.presenter), "Android");
        getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    public void finishDisplayingAd() {
        finishDisplayingAdInternal(true);
    }

    public void finishDisplayingAdInternal(boolean z) {
        if (this.presenter != null) {
            this.presenter.detach((z ? 4 : 0) | 2);
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                this.listener.onError(new VungleException(25), this.request.getPlacementId());
            }
        }
        if (z) {
            SessionData.Builder event = new SessionData.Builder().setEvent(SessionEvent.DISMISS_AD);
            AdRequest adRequest = this.request;
            if (!(adRequest == null || adRequest.getEventId() == null)) {
                event.addData(SessionAttribute.EVENT_ID, this.request.getEventId());
            }
            SessionTracker.getInstance().trackEvent(event.build());
        }
        destroyAdView(0);
    }

    public void setAdVisibility(boolean z) {
        WebAdContract.WebAdPresenter webAdPresenter = this.presenter;
        if (webAdPresenter != null) {
            webAdPresenter.setAdVisibility(z);
        } else {
            this.isAdVisible.set(Boolean.valueOf(z));
        }
    }

    public void showWebsite(String str) {
        loadUrl(str);
    }

    public String getWebsiteUrl() {
        return getUrl();
    }

    public void close() {
        if (this.presenter != null) {
            finishDisplayingAdInternal(false);
            return;
        }
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.destroy();
            this.presenterFactory = null;
            this.listener.onError(new VungleException(25), this.request.getPlacementId());
        }
    }

    public void destroyAdView(long j) {
        if (!this.destroyed) {
            this.destroyed = true;
            this.presenter = null;
            this.presenterFactory = null;
            removeJavascriptInterface("Android");
            setWebChromeClient((WebChromeClient) null);
            AnonymousClass3 r0 = new Runnable() {
                public void run() {
                    VungleBannerView.this.stopLoading();
                    VungleBannerView.this.setWebViewClient((WebViewClient) null);
                    if (Build.VERSION.SDK_INT >= 29) {
                        VungleBannerView.this.setWebViewRenderProcessClient((WebViewRenderProcessClient) null);
                    }
                    VungleBannerView.this.loadUrl("about:blank");
                }
            };
            if (j <= 0) {
                r0.run();
            } else {
                new HandlerScheduler().schedule(r0, j);
            }
        }
    }

    public void showCloseButton() {
        throw new UnsupportedOperationException("VungleBannerView does not implement a close button");
    }

    public void open(String str, String str2, ActivityManager.LeftApplicationCallback leftApplicationCallback, PresenterAdOpenCallback presenterAdOpenCallback) {
        String str3 = TAG;
        Log.d(str3, "Opening " + str2);
        if (!ExternalRouter.launch(str, str2, getContext(), leftApplicationCallback, true, presenterAdOpenCallback)) {
            String str4 = TAG;
            Log.e(str4, "Cannot open url " + str2);
        }
    }

    public void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        throw new UnsupportedOperationException("VungleBannerView does not implement a dialog.");
    }

    public void resumeWeb() {
        onResume();
    }

    public void pauseWeb() {
        onPause();
    }

    public void removeWebView() {
        ViewParent parent = getParent();
        if (parent instanceof ViewManager) {
            ((ViewManager) parent).removeView(this);
        }
    }

    public void setVisibility(boolean z) {
        setVisibility(z ? 0 : 4);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null && this.presenter == null) {
            presentationFactory.getBannerViewPresentation(getContext(), this.request, this.config, new CloseDelegate() {
                public void close() {
                    VungleBannerView.this.finishDisplayingAdInternal(false);
                }
            }, new PresentationFactory.ViewCallback() {
                public void onResult(Pair<WebAdContract.WebAdPresenter, VungleWebClient> pair, VungleException vungleException) {
                    VungleBannerView vungleBannerView = VungleBannerView.this;
                    vungleBannerView.presenterFactory = null;
                    if (vungleException == null) {
                        WebAdContract.WebAdPresenter unused = vungleBannerView.presenter = (WebAdContract.WebAdPresenter) pair.first;
                        VungleBannerView.this.setWebViewClient((VungleWebClient) pair.second);
                        VungleBannerView.this.presenter.setEventListener(VungleBannerView.this.listener);
                        VungleBannerView.this.presenter.attach(VungleBannerView.this, (OptionsState) null);
                        VungleBannerView.this.prepare();
                        if (VungleBannerView.this.isAdVisible.get() != null) {
                            VungleBannerView vungleBannerView2 = VungleBannerView.this;
                            vungleBannerView2.setAdVisibility(((Boolean) vungleBannerView2.isAdVisible.get()).booleanValue());
                        }
                        ViewGroup.LayoutParams layoutParams = VungleBannerView.this.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = -1;
                            layoutParams.width = -1;
                        }
                    } else if (vungleBannerView.listener != null) {
                        VungleBannerView.this.listener.onError(vungleException, VungleBannerView.this.request.getPlacementId());
                    }
                }
            });
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra(AdContract.AdvertisementBus.COMMAND);
                if (AdContract.AdvertisementBus.STOP_ALL.equalsIgnoreCase(stringExtra)) {
                    VungleBannerView.this.finishDisplayingAdInternal(false);
                    return;
                }
                VungleLogger.warn(VungleBannerView.class.getSimpleName() + "#onAttachedToWindow", String.format("Receiving Invalid Broadcast: %1$s", new Object[]{stringExtra}));
            }
        };
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.broadcastReceiver, new IntentFilter(AdContract.AdvertisementBus.ACTION));
        resumeWeb();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setAdVisibility(z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.broadcastReceiver);
        super.onDetachedFromWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.destroy();
        }
        pauseWeb();
    }
}
