package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyRewardedVideoListener;

public final class Z {
    private static final Z b = new Z();
    /* access modifiers changed from: package-private */
    public ISDemandOnlyRewardedVideoListener a = null;

    private Z() {
    }

    public static Z a() {
        return b;
    }

    public final void a(final String str, final IronSourceError ironSourceError) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    Z.this.a.onRewardedVideoAdLoadFailed(str, ironSourceError);
                    Z z = Z.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdLoadFailed() instanceId=" + str + "error=" + ironSourceError.getErrorMessage(), 1);
                }
            });
        }
    }

    public final void b(final String str, final IronSourceError ironSourceError) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    Z.this.a.onRewardedVideoAdShowFailed(str, ironSourceError);
                    Z z = Z.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdShowFailed() instanceId=" + str + "error=" + ironSourceError.getErrorMessage(), 1);
                }
            });
        }
    }
}
