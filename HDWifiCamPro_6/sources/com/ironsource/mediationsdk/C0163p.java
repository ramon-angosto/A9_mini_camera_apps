package com.ironsource.mediationsdk;

import com.ironsource.environment.e.c;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ironsource.mediationsdk.p  reason: case insensitive filesystem */
public final class C0163p {
    private static final C0163p c = new C0163p();
    InterstitialListener a = null;
    RewardedVideoManualListener b = null;
    private Map<String, Long> d = new HashMap();
    /* access modifiers changed from: private */
    public Map<String, Boolean> e = new HashMap();
    private int f;
    private int g;

    private C0163p() {
    }

    public static synchronized C0163p a() {
        C0163p pVar;
        synchronized (C0163p.class) {
            pVar = c;
        }
        return pVar;
    }

    /* access modifiers changed from: private */
    public void b(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError) {
        this.d.put(ad_unit.toString(), Long.valueOf(System.currentTimeMillis()));
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            if (this.a != null) {
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onInterstitialAdLoadFailed - error = " + ironSourceError.toString());
                this.a.onInterstitialAdLoadFailed(ironSourceError);
                return;
            }
            IronLog.INTERNAL.error("mInterstitialListener is null");
        } else if (ad_unit != IronSource.AD_UNIT.REWARDED_VIDEO) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.warning("ad unit not supported - " + ad_unit);
        } else if (this.b != null) {
            IronLog ironLog3 = IronLog.CALLBACK;
            ironLog3.info("onRewardedVideoAdLoadFailed - error = " + ironSourceError.toString());
            this.b.onRewardedVideoAdLoadFailed(ironSourceError);
        } else {
            IronLog.INTERNAL.warning("mRewardedVideoListener is null");
        }
    }

    public final void a(IronSource.AD_UNIT ad_unit, int i) {
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.f = i;
        } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.g = i;
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + ad_unit);
        }
    }

    public final synchronized void a(final IronSource.AD_UNIT ad_unit, final IronSourceError ironSourceError) {
        int i;
        if (!a(ad_unit)) {
            final String ad_unit2 = ad_unit.toString();
            if (!this.d.containsKey(ad_unit2)) {
                b(ad_unit, ironSourceError);
                return;
            }
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
                i = this.f;
            } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
                i = this.g;
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.warning("ad unit not supported - " + ad_unit);
                i = 0;
            }
            long j = (long) (i * 1000);
            long currentTimeMillis = System.currentTimeMillis() - this.d.get(ad_unit2).longValue();
            if (currentTimeMillis > j) {
                b(ad_unit, ironSourceError);
                return;
            }
            this.e.put(ad_unit2, Boolean.TRUE);
            long j2 = j - currentTimeMillis;
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("delaying callback by " + j2);
            c cVar = c.a;
            c.a(new Runnable() {
                public final void run() {
                    C0163p.this.b(ad_unit, ironSourceError);
                    C0163p.this.e.put(ad_unit2, Boolean.FALSE);
                }
            }, j2);
        }
    }

    public final synchronized boolean a(IronSource.AD_UNIT ad_unit) {
        if (!this.e.containsKey(ad_unit.toString())) {
            return false;
        }
        return this.e.get(ad_unit.toString()).booleanValue();
    }
}
