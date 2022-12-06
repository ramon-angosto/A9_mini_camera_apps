package com.ironsource.mediationsdk;

import android.util.Log;
import com.ironsource.mediationsdk.C0149b;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.sdk.l;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class ac extends C0149b implements RewardedVideoSmashListener {
    JSONObject r;
    /* access modifiers changed from: package-private */
    public l s;
    /* access modifiers changed from: package-private */
    public AtomicBoolean t;
    /* access modifiers changed from: package-private */
    public long u;
    String v;
    public int w;
    private int x;
    private final String y = IronSourceConstants.REQUEST_URL;

    ac(NetworkSettings networkSettings, int i) {
        super(networkSettings);
        this.r = networkSettings.getRewardedVideoSettings();
        this.k = this.r.optInt("maxAdsPerIteration", 99);
        this.l = this.r.optInt("maxAdsPerSession", 99);
        this.m = this.r.optInt("maxAdsPerDay", 99);
        this.v = this.r.optString(IronSourceConstants.REQUEST_URL);
        this.t = new AtomicBoolean(false);
        this.x = i;
    }

    /* access modifiers changed from: private */
    public void a(int i, Object[][] objArr) {
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData((C0149b) this);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                this.q.log(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoSmash logProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        h.e().b(new c(i, providerAdditionalData));
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.h = 0;
        a(o() ? C0149b.a.AVAILABLE : C0149b.a.NOT_AVAILABLE);
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        try {
            e();
            this.i = new Timer();
            this.i.schedule(new TimerTask() {
                public final void run() {
                    synchronized (ac.this) {
                        cancel();
                        if (ac.this.s != null) {
                            String str = "Timeout for " + ac.this.d;
                            ac.this.q.log(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                            ac.this.a(C0149b.a.NOT_AVAILABLE);
                            long time = new Date().getTime() - ac.this.u;
                            if (ac.this.t.compareAndSet(true, false)) {
                                ac.this.a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
                                ac.this.a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
                            } else {
                                ac.this.a(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
                            }
                            ac.this.s.a(false, ac.this);
                        }
                    }
                }
            }, (long) (this.x * 1000));
        } catch (Exception e) {
            a("startInitTimer", e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void i() {
    }

    /* access modifiers changed from: protected */
    public final String k() {
        return IronSourceConstants.AD_UNIT_RV_MEDIATION_STATE;
    }

    public final void n() {
        this.p = null;
        if (this.b != null) {
            if (!(this.a == C0149b.a.CAPPED_PER_DAY || this.a == C0149b.a.CAPPED_PER_SESSION)) {
                this.t.set(true);
                this.u = new Date().getTime();
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.q;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, this.d + ":fetchRewardedVideoForAutomaticLoad()", 1);
            this.b.fetchRewardedVideoForAutomaticLoad(this.r, this);
        }
    }

    public final boolean o() {
        if (this.b == null) {
            return false;
        }
        IronSourceLoggerManager ironSourceLoggerManager = this.q;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, this.d + ":isRewardedVideoAvailable()", 1);
        return this.b.isRewardedVideoAvailable(this.r);
    }

    public final void onRewardedVideoAdClicked() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.f(this);
        }
    }

    public final void onRewardedVideoAdClosed() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.b(this);
        }
        n();
    }

    public final void onRewardedVideoAdEnded() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.d(this);
        }
    }

    public final void onRewardedVideoAdOpened() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.a(this);
        }
    }

    public final void onRewardedVideoAdRewarded() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.e(this);
        }
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        l lVar = this.s;
        if (lVar != null) {
            lVar.a(ironSourceError, this);
        }
    }

    public final void onRewardedVideoAdStarted() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.c(this);
        }
    }

    public final void onRewardedVideoAdVisible() {
        l lVar = this.s;
        if (lVar != null) {
            lVar.g(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onRewardedVideoAvailabilityChanged(boolean r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.e()     // Catch:{ all -> 0x00b4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.t     // Catch:{ all -> 0x00b4 }
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r2, r1)     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x0036
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x00b4 }
            r0.<init>()     // Catch:{ all -> 0x00b4 }
            long r3 = r0.getTime()     // Catch:{ all -> 0x00b4 }
            long r5 = r8.u     // Catch:{ all -> 0x00b4 }
            long r3 = r3 - r5
            if (r9 == 0) goto L_0x001f
            r0 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0021
        L_0x001f:
            r0 = 1200(0x4b0, float:1.682E-42)
        L_0x0021:
            java.lang.Object[][] r5 = new java.lang.Object[r2][]     // Catch:{ all -> 0x00b4 }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b4 }
            java.lang.String r7 = "duration"
            r6[r1] = r7     // Catch:{ all -> 0x00b4 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00b4 }
            r6[r2] = r3     // Catch:{ all -> 0x00b4 }
            r5[r1] = r6     // Catch:{ all -> 0x00b4 }
            r8.a(r0, r5)     // Catch:{ all -> 0x00b4 }
            goto L_0x0041
        L_0x0036:
            if (r9 == 0) goto L_0x003b
            r0 = 1207(0x4b7, float:1.691E-42)
            goto L_0x003d
        L_0x003b:
            r0 = 1208(0x4b8, float:1.693E-42)
        L_0x003d:
            r1 = 0
            r8.a(r0, r1)     // Catch:{ all -> 0x00b4 }
        L_0x0041:
            boolean r0 = r8.c()     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x009a
            if (r9 == 0) goto L_0x004f
            com.ironsource.mediationsdk.b$a r0 = r8.a     // Catch:{ all -> 0x00b4 }
            com.ironsource.mediationsdk.b$a r1 = com.ironsource.mediationsdk.C0149b.a.AVAILABLE     // Catch:{ all -> 0x00b4 }
            if (r0 != r1) goto L_0x0057
        L_0x004f:
            if (r9 != 0) goto L_0x0078
            com.ironsource.mediationsdk.b$a r0 = r8.a     // Catch:{ all -> 0x00b4 }
            com.ironsource.mediationsdk.b$a r1 = com.ironsource.mediationsdk.C0149b.a.NOT_AVAILABLE     // Catch:{ all -> 0x00b4 }
            if (r0 == r1) goto L_0x0078
        L_0x0057:
            if (r9 == 0) goto L_0x005c
            com.ironsource.mediationsdk.b$a r0 = com.ironsource.mediationsdk.C0149b.a.AVAILABLE     // Catch:{ all -> 0x00b4 }
            goto L_0x005e
        L_0x005c:
            com.ironsource.mediationsdk.b$a r0 = com.ironsource.mediationsdk.C0149b.a.NOT_AVAILABLE     // Catch:{ all -> 0x00b4 }
        L_0x005e:
            r8.a(r0)     // Catch:{ all -> 0x00b4 }
            if (r9 == 0) goto L_0x006d
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b4 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00b4 }
            r8.o = r0     // Catch:{ all -> 0x00b4 }
        L_0x006d:
            com.ironsource.mediationsdk.sdk.l r0 = r8.s     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x00b2
            com.ironsource.mediationsdk.sdk.l r0 = r8.s     // Catch:{ all -> 0x00b4 }
            r0.a((boolean) r9, (com.ironsource.mediationsdk.ac) r8)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r8)
            return
        L_0x0078:
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00b4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r1.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r8.d     // Catch:{ all -> 0x00b4 }
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = ": state remains "
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            r1.append(r9)     // Catch:{ all -> 0x00b4 }
            java.lang.String r9 = " in smash, mediation remains unchanged"
            r1.append(r9)     // Catch:{ all -> 0x00b4 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00b4 }
            r0.info(r9)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r8)
            return
        L_0x009a:
            com.ironsource.mediationsdk.logger.IronLog r9 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00b4 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r0.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = r8.d     // Catch:{ all -> 0x00b4 }
            r0.append(r1)     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = ": is capped or exhausted"
            r0.append(r1)     // Catch:{ all -> 0x00b4 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b4 }
            r9.info(r0)     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r8)
            return
        L_0x00b4:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ac.onRewardedVideoAvailabilityChanged(boolean):void");
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    public final void onRewardedVideoInitSuccess() {
    }

    public final void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        long time = new Date().getTime() - this.u;
        if (ironSourceError.getErrorCode() == 1058) {
            a(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.p = Long.valueOf(System.currentTimeMillis());
        }
        a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
    }

    public final void onRewardedVideoLoadSuccess() {
    }
}
