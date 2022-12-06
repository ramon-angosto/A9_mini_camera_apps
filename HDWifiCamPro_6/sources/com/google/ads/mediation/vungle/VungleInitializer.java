package com.google.ads.mediation.vungle;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.vungle.mediation.VungleNetworkSettings;
import com.vungle.warren.InitCallback;
import com.vungle.warren.Plugin;
import com.vungle.warren.Vungle;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleSettings;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class VungleInitializer implements InitCallback {
    private static final VungleInitializer instance = new VungleInitializer();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ArrayList<VungleInitializationListener> mInitListeners = new ArrayList<>();
    private final AtomicBoolean mIsInitializing = new AtomicBoolean(false);

    public interface VungleInitializationListener {
        void onInitializeError(AdError adError);

        void onInitializeSuccess();
    }

    public void onAutoCacheAdAvailable(String str) {
    }

    public static VungleInitializer getInstance() {
        return instance;
    }

    private VungleInitializer() {
        Plugin.addWrapperInfo(VungleApiClient.WrapperFramework.admob, "6.12.0.0".replace('.', '_'));
    }

    public void initialize(final String str, final Context context, VungleInitializationListener vungleInitializationListener) {
        if (Vungle.isInitialized()) {
            vungleInitializationListener.onInitializeSuccess();
        } else if (this.mIsInitializing.getAndSet(true)) {
            this.mInitListeners.add(vungleInitializationListener);
        } else {
            VungleNetworkSettings.setVungleSettingsChangedListener(new VungleNetworkSettings.VungleSettingsChangedListener() {
                public void onVungleSettingsChanged(VungleSettings vungleSettings) {
                    if (Vungle.isInitialized()) {
                        VungleInitializer.this.updateCoppaStatus(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment());
                        Vungle.init(str, context.getApplicationContext(), (InitCallback) VungleInitializer.this, vungleSettings);
                    }
                }
            });
            updateCoppaStatus(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment());
            Vungle.init(str, context.getApplicationContext(), (InitCallback) this, VungleNetworkSettings.getVungleSettings());
            this.mInitListeners.add(vungleInitializationListener);
        }
    }

    public void onSuccess() {
        this.mHandler.post(new Runnable() {
            public void run() {
                Iterator it = VungleInitializer.this.mInitListeners.iterator();
                while (it.hasNext()) {
                    ((VungleInitializationListener) it.next()).onInitializeSuccess();
                }
                VungleInitializer.this.mInitListeners.clear();
            }
        });
        this.mIsInitializing.set(false);
    }

    public void onError(VungleException vungleException) {
        final AdError adError = VungleMediationAdapter.getAdError(vungleException);
        this.mHandler.post(new Runnable() {
            public void run() {
                Iterator it = VungleInitializer.this.mInitListeners.iterator();
                while (it.hasNext()) {
                    ((VungleInitializationListener) it.next()).onInitializeError(adError);
                }
                VungleInitializer.this.mInitListeners.clear();
            }
        });
        this.mIsInitializing.set(false);
    }

    public void updateCoppaStatus(int i) {
        if (i == 0) {
            Vungle.updateUserCoppaStatus(false);
        } else if (i == 1) {
            Vungle.updateUserCoppaStatus(true);
        }
    }
}
