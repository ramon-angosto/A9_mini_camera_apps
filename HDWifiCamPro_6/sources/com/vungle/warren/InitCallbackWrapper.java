package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import com.vungle.warren.utility.ThreadUtil;
import java.util.concurrent.ExecutorService;

class InitCallbackWrapper implements InitCallback {
    /* access modifiers changed from: private */
    public final InitCallback callback;
    private final ExecutorService executorService;

    InitCallbackWrapper(ExecutorService executorService2, InitCallback initCallback) {
        this.callback = initCallback;
        this.executorService = executorService2;
    }

    public void onSuccess() {
        if (this.callback != null) {
            if (ThreadUtil.isMainThread()) {
                this.callback.onSuccess();
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        InitCallbackWrapper.this.callback.onSuccess();
                    }
                });
            }
        }
    }

    public void onError(final VungleException vungleException) {
        if (this.callback != null) {
            if (ThreadUtil.isMainThread()) {
                this.callback.onError(vungleException);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        InitCallbackWrapper.this.callback.onError(vungleException);
                    }
                });
            }
        }
    }

    public void onAutoCacheAdAvailable(final String str) {
        if (this.callback != null) {
            if (ThreadUtil.isMainThread()) {
                this.callback.onAutoCacheAdAvailable(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        InitCallbackWrapper.this.callback.onAutoCacheAdAvailable(str);
                    }
                });
            }
        }
    }
}
