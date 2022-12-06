package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import com.vungle.warren.utility.ThreadUtil;
import java.util.concurrent.ExecutorService;

class PlayAdCallbackWrapper implements PlayAdCallback {
    private final ExecutorService executorService;
    /* access modifiers changed from: private */
    public final PlayAdCallback playAdCallback;

    public PlayAdCallbackWrapper(ExecutorService executorService2, PlayAdCallback playAdCallback2) {
        this.playAdCallback = playAdCallback2;
        this.executorService = executorService2;
    }

    public void creativeId(final String str) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.creativeId(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.creativeId(str);
                    }
                });
            }
        }
    }

    public void onAdStart(final String str) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onAdStart(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onAdStart(str);
                    }
                });
            }
        }
    }

    public void onAdEnd(final String str, final boolean z, final boolean z2) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onAdEnd(str, z, z2);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onAdEnd(str, z, z2);
                    }
                });
            }
        }
    }

    public void onAdEnd(final String str) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onAdEnd(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onAdEnd(str);
                    }
                });
            }
        }
    }

    public void onAdClick(final String str) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onAdClick(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onAdClick(str);
                    }
                });
            }
        }
    }

    public void onAdLeftApplication(final String str) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onAdLeftApplication(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onAdLeftApplication(str);
                    }
                });
            }
        }
    }

    public void onAdRewarded(final String str) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onAdRewarded(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onAdRewarded(str);
                    }
                });
            }
        }
    }

    public void onError(final String str, final VungleException vungleException) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onError(str, vungleException);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onError(str, vungleException);
                    }
                });
            }
        }
    }

    public void onAdViewed(final String str) {
        if (this.playAdCallback != null) {
            if (ThreadUtil.isMainThread()) {
                this.playAdCallback.onAdViewed(str);
            } else {
                this.executorService.execute(new Runnable() {
                    public void run() {
                        PlayAdCallbackWrapper.this.playAdCallback.onAdViewed(str);
                    }
                });
            }
        }
    }
}
