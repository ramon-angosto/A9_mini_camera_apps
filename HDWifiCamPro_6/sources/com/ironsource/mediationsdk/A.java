package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;

public final class A {
    private static final A b = new A();
    /* access modifiers changed from: package-private */
    public ISDemandOnlyInterstitialListener a = null;

    private A() {
    }

    public static A a() {
        return b;
    }

    public final void a(final String str, final IronSourceError ironSourceError) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    A.this.a.onInterstitialAdLoadFailed(str, ironSourceError);
                    A a2 = A.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdLoadFailed() instanceId=" + str + " error=" + ironSourceError.getErrorMessage(), 1);
                }
            });
        }
    }

    public final void b(final String str, final IronSourceError ironSourceError) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    A.this.a.onInterstitialAdShowFailed(str, ironSourceError);
                    A a2 = A.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowFailed() instanceId=" + str + " error=" + ironSourceError.getErrorMessage(), 1);
                }
            });
        }
    }
}
