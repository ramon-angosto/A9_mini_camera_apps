package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.C0170w;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.a;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.c;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.t  reason: case insensitive filesystem */
public final class C0167t extends C0170w implements InterstitialSmashListener {
    /* access modifiers changed from: private */
    public c i;
    /* access modifiers changed from: private */
    public long j;

    public C0167t(String str, String str2, NetworkSettings networkSettings, c cVar, int i2, AbstractAdapter abstractAdapter) {
        super(new a(networkSettings, networkSettings.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), abstractAdapter);
        this.i = cVar;
        this.d = i2;
        this.a.initInterstitial(str, str2, this.c, this);
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyInterstitialSmash " + this.b.a.getProviderName() + " : " + str, 0);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyInterstitialSmash " + this.b.a.getProviderName() + " : " + str, 0);
    }

    public final void a() {
        d("showInterstitial state=" + g());
        if (a(C0170w.a.LOADED, C0170w.a.SHOW_IN_PROGRESS)) {
            this.a.showInterstitial(this.c, this);
            return;
        }
        this.i.a(new IronSourceError(IronSourceError.ERROR_DO_IS_CALL_LOAD_BEFORE_SHOW, "load must be called before show"), this);
    }

    public final void a(String str, String str2, JSONObject jSONObject, List<String> list) {
        d("loadInterstitial state=" + g());
        C0170w.a a = a(new C0170w.a[]{C0170w.a.NOT_LOADED, C0170w.a.LOADED}, C0170w.a.LOAD_IN_PROGRESS);
        if (a == C0170w.a.NOT_LOADED || a == C0170w.a.LOADED) {
            this.j = new Date().getTime();
            d("start timer");
            a((TimerTask) new TimerTask() {
                public final void run() {
                    C0167t tVar = C0167t.this;
                    tVar.d("load timed out state=" + C0167t.this.g());
                    if (C0167t.this.a(C0170w.a.LOAD_IN_PROGRESS, C0170w.a.NOT_LOADED)) {
                        C0167t.this.i.a(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_TIMED_OUT, "load timed out"), C0167t.this, new Date().getTime() - C0167t.this.j);
                    }
                }
            });
            if (i()) {
                this.e = str2;
                this.f = jSONObject;
                this.g = list;
                this.a.loadInterstitialForBidding(this.c, this, str);
                return;
            }
            this.a.loadInterstitial(this.c, this);
        } else if (a == C0170w.a.LOAD_IN_PROGRESS) {
            this.i.a(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS, "load already in progress"), this, 0);
        } else {
            this.i.a(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS, "cannot load because show is in progress"), this, 0);
        }
    }

    public final boolean b() {
        return this.a.isInterstitialReady(this.c);
    }

    public final void onInterstitialAdClicked() {
        c("onInterstitialAdClicked");
        this.i.c(this);
    }

    public final void onInterstitialAdClosed() {
        a(C0170w.a.NOT_LOADED);
        c("onInterstitialAdClosed");
        this.i.b(this);
    }

    public final void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        c("onInterstitialAdLoadFailed error=" + ironSourceError.getErrorMessage() + " state=" + g());
        h();
        if (a(C0170w.a.LOAD_IN_PROGRESS, C0170w.a.NOT_LOADED)) {
            this.i.a(ironSourceError, this, new Date().getTime() - this.j);
        }
    }

    public final void onInterstitialAdOpened() {
        c("onInterstitialAdOpened");
        this.i.a(this);
    }

    public final void onInterstitialAdReady() {
        c("onInterstitialAdReady state=" + g());
        h();
        if (a(C0170w.a.LOAD_IN_PROGRESS, C0170w.a.LOADED)) {
            this.i.a(this, new Date().getTime() - this.j);
        }
    }

    public final void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        a(C0170w.a.NOT_LOADED);
        c("onInterstitialAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.i.a(ironSourceError, this);
    }

    public final void onInterstitialAdShowSucceeded() {
    }

    public final void onInterstitialAdVisible() {
        c("onInterstitialAdVisible");
        this.i.d(this);
    }

    public final void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }

    public final void onInterstitialInitSuccess() {
    }
}
