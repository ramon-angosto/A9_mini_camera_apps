package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.C0149b;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.h;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class F extends C0149b implements InterstitialSmashListener {
    JSONObject r;
    /* access modifiers changed from: package-private */
    public h s;
    /* access modifiers changed from: package-private */
    public long t;
    private int u;

    F(NetworkSettings networkSettings, int i) {
        super(networkSettings);
        this.r = networkSettings.getInterstitialSettings();
        this.k = this.r.optInt("maxAdsPerIteration", 99);
        this.l = this.r.optInt("maxAdsPerSession", 99);
        this.m = this.r.optInt("maxAdsPerDay", 99);
        this.e = networkSettings.isMultipleInstances();
        this.f = networkSettings.getSubProviderId();
        this.u = i;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.h = 0;
        a(C0149b.a.INITIATED);
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        try {
            e();
            this.i = new Timer();
            this.i.schedule(new TimerTask() {
                public final void run() {
                    cancel();
                    if (F.this.a == C0149b.a.INIT_PENDING && F.this.s != null) {
                        F.this.a(C0149b.a.INIT_FAILED);
                        F.this.s.a(ErrorBuilder.buildInitFailedError("Timeout", IronSourceConstants.INTERSTITIAL_AD_UNIT), F.this);
                    }
                }
            }, (long) (this.u * 1000));
        } catch (Exception e) {
            a("startInitTimer", e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        try {
            f();
            this.j = new Timer();
            this.j.schedule(new TimerTask() {
                public final void run() {
                    cancel();
                    if (F.this.a == C0149b.a.LOAD_PENDING && F.this.s != null) {
                        F.this.a(C0149b.a.NOT_AVAILABLE);
                        F.this.s.a(ErrorBuilder.buildLoadFailedError("Timeout"), F.this, new Date().getTime() - F.this.t);
                    }
                }
            }, (long) (this.u * 1000));
        } catch (Exception e) {
            a("startLoadTimer", e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final String k() {
        return IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
    }

    public final void onInterstitialAdClicked() {
        h hVar = this.s;
        if (hVar != null) {
            hVar.e(this);
        }
    }

    public final void onInterstitialAdClosed() {
        h hVar = this.s;
        if (hVar != null) {
            hVar.c(this);
        }
    }

    public final void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        f();
        if (this.a == C0149b.a.LOAD_PENDING && this.s != null) {
            this.s.a(ironSourceError, this, new Date().getTime() - this.t);
        }
    }

    public final void onInterstitialAdOpened() {
        h hVar = this.s;
        if (hVar != null) {
            hVar.b(this);
        }
    }

    public final void onInterstitialAdReady() {
        f();
        if (this.a == C0149b.a.LOAD_PENDING && this.s != null) {
            this.s.a(this, new Date().getTime() - this.t);
        }
    }

    public final void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        h hVar = this.s;
        if (hVar != null) {
            hVar.b(ironSourceError, this);
        }
    }

    public final void onInterstitialAdShowSucceeded() {
        h hVar = this.s;
        if (hVar != null) {
            hVar.d(this);
        }
    }

    public final void onInterstitialAdVisible() {
        h hVar = this.s;
        if (hVar != null) {
            hVar.f(this);
        }
    }

    public final void onInterstitialInitFailed(IronSourceError ironSourceError) {
        e();
        if (this.a == C0149b.a.INIT_PENDING) {
            a(C0149b.a.INIT_FAILED);
            h hVar = this.s;
            if (hVar != null) {
                hVar.a(ironSourceError, this);
            }
        }
    }

    public final void onInterstitialInitSuccess() {
        e();
        if (this.a == C0149b.a.INIT_PENDING) {
            a(C0149b.a.INITIATED);
            h hVar = this.s;
            if (hVar != null) {
                hVar.a(this);
            }
        }
    }
}
