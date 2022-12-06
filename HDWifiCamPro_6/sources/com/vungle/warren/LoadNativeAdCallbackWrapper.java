package com.vungle.warren;

import com.vungle.warren.model.Advertisement;
import java.util.concurrent.ExecutorService;

class LoadNativeAdCallbackWrapper extends LoadAdCallbackWrapper implements LoadNativeAdCallback {
    private final ExecutorService executorService;
    /* access modifiers changed from: private */
    public final LoadNativeAdCallback loadAdCallback;

    public LoadNativeAdCallbackWrapper(ExecutorService executorService2, LoadNativeAdCallback loadNativeAdCallback) {
        super(executorService2, loadNativeAdCallback);
        this.loadAdCallback = loadNativeAdCallback;
        this.executorService = executorService2;
    }

    public void onAdLoad(final Advertisement advertisement) {
        if (this.loadAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    LoadNativeAdCallbackWrapper.this.loadAdCallback.onAdLoad(advertisement);
                }
            });
        }
    }
}
