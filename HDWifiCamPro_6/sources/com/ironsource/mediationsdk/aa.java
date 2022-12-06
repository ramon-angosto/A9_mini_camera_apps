package com.ironsource.mediationsdk;

import com.ironsource.environment.e.c;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;

public final class aa {
    private static final aa b = new aa();
    public RewardedVideoListener a = null;

    private aa() {
    }

    public static aa a() {
        return b;
    }

    public final void a(final IronSourceError ironSourceError) {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAdShowFailed(ironSourceError);
                    aa aaVar = aa.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdShowFailed() error=" + ironSourceError.getErrorMessage(), 1);
                }
            }
        });
    }

    public final void a(final Placement placement) {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAdRewarded(placement);
                    aa aaVar = aa.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdRewarded(" + placement + ")", 1);
                }
            }
        });
    }

    public final void a(final boolean z) {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAvailabilityChanged(z);
                    aa aaVar = aa.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAvailabilityChanged() available=" + z, 1);
                }
            }
        });
    }

    public final void b() {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAdOpened();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
                }
            }
        });
    }

    public final void b(final Placement placement) {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAdClicked(placement);
                    aa aaVar = aa.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClicked(" + placement + ")", 1);
                }
            }
        });
    }

    public final void c() {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAdClosed();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
                }
            }
        });
    }

    public final void d() {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAdStarted();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdStarted()", 1);
                }
            }
        });
    }

    public final void e() {
        c.a.a(new Runnable() {
            public final void run() {
                if (aa.this.a != null) {
                    aa.this.a.onRewardedVideoAdEnded();
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdEnded()", 1);
                }
            }
        });
    }
}
