package com.vungle.warren;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.NativeAdContract;
import com.vungle.warren.ui.state.OptionsState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class NativeAdLayout extends FrameLayout {
    private static final String TAG = NativeAdLayout.class.getSimpleName();
    private BroadcastReceiver broadcastReceiver;
    private OnItemClickListener clickListener;
    private Context context;
    /* access modifiers changed from: private */
    public boolean destroyed;
    private boolean disableRenderManagement;
    /* access modifiers changed from: private */
    public final AtomicReference<Boolean> isAdVisible = new AtomicReference<>();
    /* access modifiers changed from: private */
    public AdContract.AdvertisementPresenter.EventListener listener;
    private NativeAd nativeAd;
    /* access modifiers changed from: private */
    public final AtomicBoolean pendingImpression = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean pendingStart = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public NativeAdContract.NativePresenter presenter;
    /* access modifiers changed from: private */
    public PresentationFactory presenterFactory;
    private AdRequest request;
    private boolean started = false;

    public interface OnItemClickListener {
        void onItemClicked(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewEvent {
        public static final int CTA_CLICK = 1;
        public static final int PRIVACY_CLICK = 2;
    }

    public NativeAdLayout(Context context2) {
        super(context2);
        initView(context2);
    }

    public NativeAdLayout(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        initView(context2);
    }

    public NativeAdLayout(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        initView(context2);
    }

    public NativeAdLayout(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        initView(context2);
    }

    private void initView(Context context2) {
        this.context = context2;
    }

    public void finishDisplayingAdInternal(boolean z) {
        String str = TAG;
        Log.d(str, "finishDisplayingAdInternal() " + z + " " + hashCode());
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
        release();
    }

    public void onImpression() {
        String str = TAG;
        Log.d(str, "onImpression() " + hashCode());
        NativeAdContract.NativePresenter nativePresenter = this.presenter;
        if (nativePresenter == null) {
            this.pendingImpression.set(true);
        } else {
            nativePresenter.onProgressUpdate(1, 100.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = TAG;
        Log.d(str, "onAttachedToWindow() " + hashCode());
        if (!this.disableRenderManagement) {
            renderNativeAd();
        }
    }

    public void renderNativeAd() {
        String str = TAG;
        Log.d(str, "renderNativeAd() " + hashCode());
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra(AdContract.AdvertisementBus.COMMAND);
                if (AdContract.AdvertisementBus.STOP_ALL.equalsIgnoreCase(stringExtra)) {
                    NativeAdLayout.this.finishDisplayingAdInternal(false);
                    return;
                }
                VungleLogger.warn(NativeAdLayout.class.getSimpleName() + "#onAttachedToWindow", String.format("Receiving Invalid Broadcast: %1$s", new Object[]{stringExtra}));
            }
        };
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.broadcastReceiver, new IntentFilter(AdContract.AdvertisementBus.ACTION));
        start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        String str = TAG;
        Log.d(str, "onDetachedFromWindow() " + hashCode());
        if (!this.disableRenderManagement) {
            finishNativeAd();
        }
    }

    public void finishNativeAd() {
        String str = TAG;
        Log.d(str, "finishNativeAd() " + hashCode());
        LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.broadcastReceiver);
        NativeAd nativeAd2 = this.nativeAd;
        if (nativeAd2 != null) {
            nativeAd2.destroy();
        } else {
            Log.d(TAG, "No need to destroy due to haven't played the ad.");
        }
    }

    public void onWindowFocusChanged(boolean z) {
        String str = TAG;
        Log.d(str, "onWindowFocusChanged() hasWindowFocus=" + z + " " + hashCode());
        super.onWindowFocusChanged(z);
        setAdVisibility(z);
        if (this.presenter != null && !this.started) {
            start();
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        String str = TAG;
        Log.d(str, "onVisibilityChanged() visibility=" + i + " " + hashCode());
        setAdVisibility(i == 0);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        String str = TAG;
        Log.d(str, "onWindowVisibilityChanged() visibility=" + i + " " + hashCode());
        setAdVisibility(i == 0);
    }

    /* access modifiers changed from: private */
    public void setAdVisibility(boolean z) {
        NativeAdContract.NativePresenter nativePresenter = this.presenter;
        if (nativePresenter != null) {
            nativePresenter.setAdVisibility(z);
        } else {
            this.isAdVisible.set(Boolean.valueOf(z));
        }
    }

    /* access modifiers changed from: private */
    public void start() {
        String str = TAG;
        Log.d(str, "start() " + hashCode());
        if (this.presenter == null) {
            this.pendingStart.set(true);
        } else if (!this.started && hasWindowFocus()) {
            this.presenter.start();
            this.started = true;
        }
    }

    public void disableLifeCycleManagement(boolean z) {
        this.disableRenderManagement = z;
    }

    public void register(Context context2, NativeAd nativeAd2, PresentationFactory presentationFactory, AdContract.AdvertisementPresenter.EventListener eventListener, AdConfig adConfig, final AdRequest adRequest) {
        this.presenterFactory = presentationFactory;
        this.listener = eventListener;
        this.request = adRequest;
        this.nativeAd = nativeAd2;
        if (this.presenter == null) {
            presentationFactory.getNativeViewPresentation(context2, this, adRequest, adConfig, new PresentationFactory.NativeViewCallback() {
                public void onResult(Pair<NativeAdContract.NativeView, NativeAdContract.NativePresenter> pair, VungleException vungleException) {
                    PresentationFactory unused = NativeAdLayout.this.presenterFactory = null;
                    if (vungleException == null) {
                        NativeAdContract.NativePresenter unused2 = NativeAdLayout.this.presenter = (NativeAdContract.NativePresenter) pair.second;
                        NativeAdLayout.this.presenter.setEventListener(NativeAdLayout.this.listener);
                        NativeAdLayout.this.presenter.attach((NativeAdContract.NativeView) pair.first, (OptionsState) null);
                        if (NativeAdLayout.this.pendingStart.getAndSet(false)) {
                            NativeAdLayout.this.start();
                        }
                        if (NativeAdLayout.this.pendingImpression.getAndSet(false)) {
                            NativeAdLayout.this.presenter.onProgressUpdate(1, 100.0f);
                        }
                        if (NativeAdLayout.this.isAdVisible.get() != null) {
                            NativeAdLayout nativeAdLayout = NativeAdLayout.this;
                            nativeAdLayout.setAdVisibility(((Boolean) nativeAdLayout.isAdVisible.get()).booleanValue());
                        }
                        boolean unused3 = NativeAdLayout.this.destroyed = false;
                    } else if (NativeAdLayout.this.listener != null) {
                        NativeAdLayout.this.listener.onError(vungleException, adRequest.getPlacementId());
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.clickListener = onItemClickListener;
    }

    public void onItemClicked(int i) {
        OnItemClickListener onItemClickListener = this.clickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClicked(i);
        }
    }

    public void release() {
        if (!this.destroyed) {
            this.destroyed = true;
            this.presenter = null;
            this.presenterFactory = null;
        }
    }
}
