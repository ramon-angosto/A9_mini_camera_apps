package com.vungle.warren;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.ui.CloseDelegate;
import com.vungle.warren.ui.OrientationDelegate;
import com.vungle.warren.ui.VungleActivity;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.state.BundleOptionsState;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.ui.view.FullAdWidget;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AdActivity extends Activity {
    public static final String PRESENTER_STATE = "presenter_state";
    private static final String REQUEST_KEY_EXTRA = "request";
    private static final String TAG = "VungleActivity";
    /* access modifiers changed from: private */
    public static AdContract.AdvertisementPresenter.EventListener bus;
    private BroadcastReceiver broadcastReceiver;
    private PresentationFactory.FullScreenCallback fullscreenCallback = new PresentationFactory.FullScreenCallback() {
        public void onResult(Pair<AdContract.AdView, AdContract.AdvertisementPresenter> pair, VungleException vungleException) {
            if (vungleException != null) {
                PresentationFactory unused = AdActivity.this.presenterFactory = null;
                AdActivity.this.deliverError(vungleException.getExceptionCode(), AdActivity.this.request);
                AdActivity.this.finish();
                return;
            }
            AdContract.AdvertisementPresenter unused2 = AdActivity.this.presenter = (AdContract.AdvertisementPresenter) pair.second;
            AdActivity.this.presenter.setEventListener(AdActivity.bus);
            AdActivity.this.presenter.attach((AdContract.AdView) pair.first, AdActivity.this.state);
            if (AdActivity.this.pendingStart.getAndSet(false)) {
                AdActivity.this.start();
            }
        }
    };
    /* access modifiers changed from: private */
    public AtomicBoolean pendingStart = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public AdContract.AdvertisementPresenter presenter;
    /* access modifiers changed from: private */
    public PresentationFactory presenterFactory;
    /* access modifiers changed from: private */
    public AdRequest request;
    private boolean resumed = false;
    private boolean started = false;
    /* access modifiers changed from: private */
    public OptionsState state;

    /* access modifiers changed from: protected */
    public abstract boolean canRotate();

    public static void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        bus = eventListener;
    }

    protected static AdContract.AdvertisementPresenter.EventListener getEventListener() {
        return bus;
    }

    public static Intent createIntent(Context context, AdRequest adRequest) {
        Intent intent = new Intent(context, VungleActivity.class);
        intent.addFlags(268435456);
        Bundle bundle = new Bundle();
        bundle.putSerializable(REQUEST_KEY_EXTRA, adRequest);
        intent.putExtras(bundle);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AdRequest adRequest;
        OptionsState optionsState;
        Bundle bundle2 = bundle;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        this.request = getRequest(getIntent());
        ServiceLocator instance = ServiceLocator.getInstance(this);
        if (!((VungleStaticApi) instance.getService(VungleStaticApi.class)).isInitialized() || bus == null || (adRequest = this.request) == null || TextUtils.isEmpty(adRequest.getPlacementId())) {
            finish();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        VungleLogger.verbose(true, TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Creating ad, request = %1$s, at: %2$d", new Object[]{this.request, Long.valueOf(currentTimeMillis)}));
        try {
            FullAdWidget fullAdWidget = new FullAdWidget(this, getWindow());
            this.presenterFactory = (PresentationFactory) instance.getService(PresentationFactory.class);
            if (bundle2 == null) {
                optionsState = null;
            } else {
                optionsState = (OptionsState) bundle2.getParcelable(PRESENTER_STATE);
            }
            this.state = optionsState;
            PresentationFactory presentationFactory = this.presenterFactory;
            AdRequest adRequest2 = this.request;
            OptionsState optionsState2 = this.state;
            AnonymousClass1 r5 = new CloseDelegate() {
                public void close() {
                    AdActivity.this.finish();
                }
            };
            AnonymousClass2 r3 = new OrientationDelegate() {
                public void setOrientation(int i) {
                    AdActivity.this.setRequestedOrientation(i);
                }
            };
            PresentationFactory.FullScreenCallback fullScreenCallback = this.fullscreenCallback;
            FullAdWidget fullAdWidget2 = fullAdWidget;
            String str = TAG;
            presentationFactory.getFullScreenPresentation(this, adRequest2, fullAdWidget, optionsState2, r5, r3, bundle, fullScreenCallback);
            setContentView(fullAdWidget2, fullAdWidget2.getLayoutParams());
            connectBroadcastReceiver();
            String str2 = str;
            VungleLogger.verbose(true, str2, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Ad created, request = %1$s, elapsed time: %2$dms", new Object[]{this.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        } catch (InstantiationException unused) {
            deliverError(10, this.request);
            finish();
        }
    }

    static AdRequest getRequest(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return (AdRequest) extras.getSerializable(REQUEST_KEY_EXTRA);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        AdRequest request2 = getRequest(getIntent());
        AdRequest request3 = getRequest(intent);
        String str = null;
        String placementId = request2 != null ? request2.getPlacementId() : null;
        if (request3 != null) {
            str = request3.getPlacementId();
        }
        if (placementId != null && str != null && !placementId.equals(str)) {
            Log.d(TAG, "Tried to play another placement " + str + " while playing " + placementId);
            deliverError(15, request3);
            StringBuilder sb = new StringBuilder();
            sb.append(AdActivity.class.getSimpleName());
            sb.append("#onNewIntent");
            VungleLogger.warn(sb.toString(), String.format("Tried to play another placement %1$s while playing %2$s", new Object[]{str, placementId}));
        }
    }

    /* access modifiers changed from: private */
    public void deliverError(int i, AdRequest adRequest) {
        VungleException vungleException = new VungleException(i);
        AdContract.AdvertisementPresenter.EventListener eventListener = bus;
        if (eventListener != null) {
            eventListener.onError(vungleException, adRequest.getPlacementId());
        }
        VungleLogger.error(AdActivity.class.getSimpleName() + "#deliverError", vungleException.getLocalizedMessage());
    }

    private void connectBroadcastReceiver() {
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra(AdContract.AdvertisementBus.COMMAND);
                if (((stringExtra.hashCode() == -1884364225 && stringExtra.equals(AdContract.AdvertisementBus.STOP_ALL)) ? (char) 0 : 65535) != 0) {
                    VungleLogger.warn(AdActivity.class.getSimpleName() + "#connectBroadcastReceiver", String.format("Receiving Invalid Broadcast: %1$s", new Object[]{stringExtra}));
                    return;
                }
                AdActivity.this.finish();
            }
        };
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.broadcastReceiver, new IntentFilter(AdContract.AdvertisementBus.ACTION));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            start();
        } else {
            stop();
        }
    }

    /* access modifiers changed from: private */
    public void start() {
        if (this.presenter == null) {
            this.pendingStart.set(true);
        } else if (!this.started && this.resumed && hasWindowFocus()) {
            this.presenter.start();
            this.started = true;
        }
    }

    private void stop() {
        if (this.presenter != null && this.started) {
            this.presenter.stop(isChangingConfigurations() | (isFinishing() ? (char) 2 : 0) ? 1 : 0);
            this.started = false;
        }
        this.pendingStart.set(false);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.resumed = true;
        start();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.resumed = false;
        stop();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            Log.d(TAG, "landscape");
        } else if (configuration.orientation == 1) {
            Log.d(TAG, "portrait");
        }
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.onViewConfigurationChanged();
        }
    }

    public void onBackPressed() {
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.handleExit();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Log.d(TAG, "onSaveInstanceState");
        BundleOptionsState bundleOptionsState = new BundleOptionsState();
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.generateSaveState(bundleOptionsState);
            bundle.putParcelable(PRESENTER_STATE, bundleOptionsState);
        }
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.saveState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AdContract.AdvertisementPresenter advertisementPresenter;
        super.onRestoreInstanceState(bundle);
        Log.d(TAG, "onRestoreInstanceState(" + bundle + ")");
        if (bundle != null && (advertisementPresenter = this.presenter) != null) {
            advertisementPresenter.restoreFromSave((OptionsState) bundle.getParcelable(PRESENTER_STATE));
        }
    }

    public void setRequestedOrientation(int i) {
        if (canRotate()) {
            super.setRequestedOrientation(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.broadcastReceiver);
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.detach(isChangingConfigurations() | true ? 1 : 0);
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                deliverError(25, this.request);
            }
        }
        super.onDestroy();
    }
}
