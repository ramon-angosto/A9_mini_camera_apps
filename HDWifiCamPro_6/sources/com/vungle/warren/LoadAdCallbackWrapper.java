package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import com.vungle.warren.utility.ThreadUtil;
import java.util.concurrent.ExecutorService;

class LoadAdCallbackWrapper implements LoadAdCallback {
    private final ExecutorService executorService;
    /* access modifiers changed from: private */
    public final LoadAdCallback loadAdCallback;

    public LoadAdCallbackWrapper(ExecutorService executorService2, LoadAdCallback loadAdCallback2) {
        this.loadAdCallback = loadAdCallback2;
        this.executorService = executorService2;
    }

    public void onAdLoad(final String str) {
        if (this.loadAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.loadAdCallback.onAdLoad(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        LoadAdCallbackWrapper.this.loadAdCallback.onAdLoad(str);
                    }
                });
            }
        }
    }

    public void onError(final String str, final VungleException vungleException) {
        if (this.loadAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.loadAdCallback.onError(str, vungleException);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        LoadAdCallbackWrapper.this.loadAdCallback.onError(str, vungleException);
                    }
                });
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoadAdCallbackWrapper loadAdCallbackWrapper = (LoadAdCallbackWrapper) obj;
        LoadAdCallback loadAdCallback2 = this.loadAdCallback;
        if (loadAdCallback2 == null ? loadAdCallbackWrapper.loadAdCallback != null : !loadAdCallback2.equals(loadAdCallbackWrapper.loadAdCallback)) {
            return false;
        }
        ExecutorService executorService2 = this.executorService;
        ExecutorService executorService3 = loadAdCallbackWrapper.executorService;
        if (executorService2 != null) {
            return executorService2.equals(executorService3);
        }
        if (executorService3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        LoadAdCallback loadAdCallback2 = this.loadAdCallback;
        int i = 0;
        int hashCode = (loadAdCallback2 != null ? loadAdCallback2.hashCode() : 0) * 31;
        ExecutorService executorService2 = this.executorService;
        if (executorService2 != null) {
            i = executorService2.hashCode();
        }
        return hashCode + i;
    }
}
