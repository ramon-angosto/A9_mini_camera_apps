package com.google.ads.mediation.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;
import java.util.Iterator;

public class PangleInitializer implements PAGSdk.PAGInitCallback {
    private static PangleInitializer instance;
    private final ArrayList<Listener> initListeners = new ArrayList<>();
    private boolean isInitialized = false;
    private boolean isInitializing = false;

    public interface Listener {
        void onInitializeError(AdError adError);

        void onInitializeSuccess();
    }

    public static PangleInitializer getInstance() {
        if (instance == null) {
            instance = new PangleInitializer();
        }
        return instance;
    }

    private PangleInitializer() {
    }

    public void initialize(Context context, String str, Listener listener) {
        if (TextUtils.isEmpty(str)) {
            AdError createAdapterError = PangleConstants.createAdapterError(101, "Failed to initialize Pangle SDK. Missing or invalid App ID.");
            Log.w(PangleMediationAdapter.TAG, createAdapterError.toString());
            listener.onInitializeError(createAdapterError);
        } else if (this.isInitializing) {
            this.initListeners.add(listener);
        } else if (this.isInitialized) {
            listener.onInitializeSuccess();
        } else {
            this.isInitializing = true;
            this.initListeners.add(listener);
            PAGSdk.init(context, new PAGConfig.Builder().appId(str).setChildDirected(PangleAdapterUtils.getCoppa()).setGDPRConsent(PangleMediationAdapter.getGDPRConsent()).setDoNotSell(PangleMediationAdapter.getDoNotSell()).build(), this);
        }
    }

    public void success() {
        this.isInitializing = false;
        this.isInitialized = true;
        Iterator<Listener> it = this.initListeners.iterator();
        while (it.hasNext()) {
            it.next().onInitializeSuccess();
        }
        this.initListeners.clear();
    }

    public void fail(int i, String str) {
        this.isInitializing = false;
        this.isInitialized = false;
        AdError createSdkError = PangleConstants.createSdkError(i, str);
        Iterator<Listener> it = this.initListeners.iterator();
        while (it.hasNext()) {
            it.next().onInitializeError(createSdkError);
        }
        this.initListeners.clear();
    }
}
