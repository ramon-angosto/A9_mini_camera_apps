package com.vungle.warren.utility;

import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.error.VungleException;
import java.lang.ref.WeakReference;

public class WeakLoadAdCallback implements LoadAdCallback {
    private WeakReference<LoadAdCallback> weak;

    public WeakLoadAdCallback(LoadAdCallback loadAdCallback) {
        this.weak = new WeakReference<>(loadAdCallback);
    }

    public void onAdLoad(String str) {
        LoadAdCallback loadAdCallback = (LoadAdCallback) this.weak.get();
        if (loadAdCallback != null) {
            loadAdCallback.onAdLoad(str);
        }
    }

    public void onError(String str, VungleException vungleException) {
        LoadAdCallback loadAdCallback = (LoadAdCallback) this.weak.get();
        if (loadAdCallback != null) {
            loadAdCallback.onError(str, vungleException);
        }
    }
}
