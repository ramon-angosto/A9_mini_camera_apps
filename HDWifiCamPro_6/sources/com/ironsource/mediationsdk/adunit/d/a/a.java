package com.ironsource.mediationsdk.adunit.d.a;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.c.a.a;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

public abstract class a<Listener extends com.ironsource.mediationsdk.adunit.c.a.a> extends c<Listener> implements AdapterAdInteractionListener {
    private BaseAdInteractionAdapter<?, AdapterAdInteractionListener> g;

    public a(com.ironsource.mediationsdk.adunit.d.a aVar, BaseAdInteractionAdapter<?, ?> baseAdInteractionAdapter, com.ironsource.mediationsdk.model.a aVar2, Listener listener) {
        super(aVar, baseAdInteractionAdapter, aVar2, listener);
        this.g = baseAdInteractionAdapter;
    }

    public final void a(Placement placement) {
        int i;
        IronLog.INTERNAL.verbose(c("placementName = " + placement.getPlacementName()));
        try {
            this.e = placement;
            this.c.d.a(q());
            this.g.showAd(this.f, this);
        } catch (Throwable th) {
            String str = "showAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(c(str));
            if (this.c != null) {
                this.c.e.l(str);
            }
            IronSource.AD_UNIT ad_unit = this.a.a;
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
                i = IronSourceError.ERROR_IS_SHOW_EXCEPTION;
            } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
                i = IronSourceError.ERROR_RV_SHOW_EXCEPTION;
            } else {
                IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
                i = IronSourceError.ERROR_CODE_GENERIC;
            }
            onAdShowFailed(i, str);
        }
    }

    public final void a(boolean z) {
        if (this.c != null) {
            this.c.d.a(z);
        }
    }

    public final boolean a() {
        if (this.f != null) {
            try {
                return h() ? this.d == c.a.LOADED && this.g.isAdAvailable(this.f) : this.g.isAdAvailable(this.f);
            } catch (Throwable th) {
                String str = "isReadyToShow - exception = " + th.getLocalizedMessage();
                IronLog.INTERNAL.error(c(str));
                if (this.c != null) {
                    this.c.e.l(str);
                }
            }
        }
        return false;
    }

    public void onAdClosed() {
        String str;
        String str2 = "";
        IronLog.INTERNAL.verbose(c(str2));
        a(c.a.NONE);
        if (this.c != null) {
            if (this.a.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                String c = ((com.ironsource.mediationsdk.adunit.c.a.a) this.b).c();
                StringBuilder sb = new StringBuilder("otherInstanceAvailable = ");
                if (c.length() > 0) {
                    str = "true|" + c;
                } else {
                    str = "false";
                }
                sb.append(str);
                str2 = sb.toString();
            }
            this.c.d.a(q(), str2);
        }
        ((com.ironsource.mediationsdk.adunit.c.a.a) this.b).c(this);
    }

    public void onAdEnded() {
        IronLog.INTERNAL.verbose(c(""));
        if (this.c != null) {
            this.c.d.f(q());
        }
        ((com.ironsource.mediationsdk.adunit.c.a.a) this.b).e(this);
    }

    public void onAdOpened() {
        IronLog.INTERNAL.verbose(c(""));
        a(c.a.SHOWING);
        if (this.c != null) {
            this.c.d.c(q());
        }
        ((com.ironsource.mediationsdk.adunit.c.a.a) this.b).b(this);
    }

    public void onAdShowFailed(int i, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(c("error = " + i + ", " + str));
        if (this.c != null) {
            this.c.d.a(q(), i, str, "");
        }
        ((com.ironsource.mediationsdk.adunit.c.a.a) this.b).a(new IronSourceError(i, str), this);
    }

    public void onAdShowSuccess() {
        IronLog.INTERNAL.verbose(c(""));
        if (this.c != null) {
            this.c.d.b(q());
        }
        ((com.ironsource.mediationsdk.adunit.c.a.a) this.b).a(this);
    }

    public void onAdStarted() {
        IronLog.INTERNAL.verbose(c(""));
        if (this.c != null) {
            this.c.d.e(q());
        }
        ((com.ironsource.mediationsdk.adunit.c.a.a) this.b).d(this);
    }

    public void onAdVisible() {
        IronLog.INTERNAL.verbose(c(""));
        if (this.c != null) {
            this.c.d.g(q());
        }
    }
}
