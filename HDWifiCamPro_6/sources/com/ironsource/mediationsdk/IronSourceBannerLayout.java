package com.ironsource.mediationsdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.environment.e.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;

public class IronSourceBannerLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public View a;
    private ISBannerSize b;
    private String c;
    private Activity d;
    private boolean e = false;
    /* access modifiers changed from: private */
    public boolean f = false;
    /* access modifiers changed from: private */
    public BannerListener g;

    public IronSourceBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.d = activity;
        this.b = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    /* access modifiers changed from: protected */
    public final IronSourceBannerLayout a() {
        IronSourceBannerLayout ironSourceBannerLayout = new IronSourceBannerLayout(this.d, this.b);
        ironSourceBannerLayout.setBannerListener(this.g);
        ironSourceBannerLayout.setPlacementName(this.c);
        return ironSourceBannerLayout;
    }

    /* access modifiers changed from: package-private */
    public final void a(final View view, final FrameLayout.LayoutParams layoutParams) {
        c.a.a(new Runnable() {
            public final void run() {
                IronSourceBannerLayout.this.removeAllViews();
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                View unused = IronSourceBannerLayout.this.a = view;
                IronSourceBannerLayout.this.addView(view, 0, layoutParams);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(final IronSourceError ironSourceError) {
        c.a.a(new Runnable() {
            public final void run() {
                if (IronSourceBannerLayout.this.f) {
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info("onBannerAdLoadFailed error=" + ironSourceError);
                    IronSourceBannerLayout.this.g.onBannerAdLoadFailed(ironSourceError);
                    return;
                }
                try {
                    if (IronSourceBannerLayout.this.a != null) {
                        IronSourceBannerLayout.this.removeView(IronSourceBannerLayout.this.a);
                        View unused = IronSourceBannerLayout.this.a = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (IronSourceBannerLayout.this.g != null) {
                    IronLog ironLog2 = IronLog.CALLBACK;
                    ironLog2.info("onBannerAdLoadFailed error=" + ironSourceError);
                    IronSourceBannerLayout.this.g.onBannerAdLoadFailed(ironSourceError);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(final String str) {
        c.a.a(new Runnable() {
            public final void run() {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("smash - " + str);
                if (IronSourceBannerLayout.this.g != null && !IronSourceBannerLayout.this.f) {
                    IronLog.CALLBACK.info("");
                    IronSourceBannerLayout.this.g.onBannerAdLoaded();
                }
                boolean unused = IronSourceBannerLayout.this.f = true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.e = true;
        this.g = null;
        this.d = null;
        this.b = null;
        this.c = null;
        this.a = null;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        c.a.a(new Runnable() {
            public final void run() {
                if (IronSourceBannerLayout.this.g != null) {
                    IronLog.CALLBACK.info("");
                    IronSourceBannerLayout.this.g.onBannerAdClicked();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        c.a.a(new Runnable() {
            public final void run() {
                if (IronSourceBannerLayout.this.g != null) {
                    IronLog.CALLBACK.info("");
                    IronSourceBannerLayout.this.g.onBannerAdScreenPresented();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        c.a.a(new Runnable() {
            public final void run() {
                if (IronSourceBannerLayout.this.g != null) {
                    IronLog.CALLBACK.info("");
                    IronSourceBannerLayout.this.g.onBannerAdScreenDismissed();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        c.a.a(new Runnable() {
            public final void run() {
                if (IronSourceBannerLayout.this.g != null) {
                    IronLog.CALLBACK.info("");
                    IronSourceBannerLayout.this.g.onBannerAdLeftApplication();
                }
            }
        });
    }

    public Activity getActivity() {
        return this.d;
    }

    public BannerListener getBannerListener() {
        return this.g;
    }

    public View getBannerView() {
        return this.a;
    }

    public String getPlacementName() {
        return this.c;
    }

    public ISBannerSize getSize() {
        return this.b;
    }

    public boolean isDestroyed() {
        return this.e;
    }

    public void removeBannerListener() {
        IronLog.API.info("");
        this.g = null;
    }

    public void setBannerListener(BannerListener bannerListener) {
        IronLog.API.info("");
        this.g = bannerListener;
    }

    public void setPlacementName(String str) {
        this.c = str;
    }
}
