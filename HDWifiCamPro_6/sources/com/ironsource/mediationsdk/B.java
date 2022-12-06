package com.ironsource.mediationsdk;

import com.ironsource.environment.e.c;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public final class B {
    private static final B a = new B();
    /* access modifiers changed from: private */
    public InterstitialListener b = null;

    private B() {
    }

    public static synchronized B a() {
        B b2;
        synchronized (B.class) {
            b2 = a;
        }
        return b2;
    }

    public final void a(final IronSourceError ironSourceError) {
        if (this.b != null) {
            c.a.a(new Runnable() {
                public final void run() {
                    B.this.b.onInterstitialAdLoadFailed(ironSourceError);
                    B b2 = B.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdLoadFailed() error=" + ironSourceError.getErrorMessage(), 1);
                }
            });
        }
    }

    public final synchronized void a(InterstitialListener interstitialListener) {
        this.b = interstitialListener;
    }

    public final void b() {
        if (this.b != null) {
            c.a.a(new Runnable() {
                public final void run() {
                    B.this.b.onInterstitialAdReady();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdReady()", 1);
                }
            });
        }
    }

    public final void b(final IronSourceError ironSourceError) {
        if (this.b != null) {
            c.a.a(new Runnable() {
                public final void run() {
                    B.this.b.onInterstitialAdShowFailed(ironSourceError);
                    B b2 = B.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowFailed() error=" + ironSourceError.getErrorMessage(), 1);
                }
            });
        }
    }

    public final void c() {
        if (this.b != null) {
            c.a.a(new Runnable() {
                public final void run() {
                    B.this.b.onInterstitialAdOpened();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdOpened()", 1);
                }
            });
        }
    }

    public final void d() {
        if (this.b != null) {
            c.a.a(new Runnable() {
                public final void run() {
                    B.this.b.onInterstitialAdClosed();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClosed()", 1);
                }
            });
        }
    }

    public final void e() {
        if (this.b != null) {
            c.a.a(new Runnable() {
                public final void run() {
                    B.this.b.onInterstitialAdShowSucceeded();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
                }
            });
        }
    }

    public final void f() {
        if (this.b != null) {
            c.a.a(new Runnable() {
                public final void run() {
                    B.this.b.onInterstitialAdClicked();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClicked()", 1);
                }
            });
        }
    }
}
