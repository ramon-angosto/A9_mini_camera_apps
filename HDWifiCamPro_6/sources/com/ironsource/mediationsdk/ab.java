package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.a;
import com.ironsource.environment.j;
import com.ironsource.mediationsdk.C0149b;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.i;
import com.ironsource.mediationsdk.sdk.l;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.d;
import com.ironsource.mediationsdk.utils.e;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.mediationsdk.utils.o;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

final class ab extends C0148a implements j, C0150c, l, d {
    i m;
    boolean n = false;
    int o;
    C0171x p;
    private final String q = getClass().getSimpleName();
    private boolean r = false;
    private NetworkStateReceiver s;
    private Placement t;
    private Timer u = null;
    private List<C0149b.a> v = Arrays.asList(new C0149b.a[]{C0149b.a.INIT_FAILED, C0149b.a.CAPPED_PER_SESSION, C0149b.a.EXHAUSTED, C0149b.a.CAPPED_PER_DAY});
    private boolean w = false;
    private long x = new Date().getTime();
    private boolean y = false;

    ab() {
        this.a = new e("rewarded_video", this);
    }

    private void a(int i) {
        a(i, (Object[][]) null);
    }

    private void a(int i, C0149b bVar, Object[][] objArr) {
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData(bVar);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        h.e().b(new c(i, providerAdditionalData));
    }

    private void a(int i, Object[][] objArr) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logMediationEvent " + Log.getStackTraceString(e), 3);
            }
        }
        h.e().b(new c(i, mediationAdditionalData));
    }

    private synchronized void a(C0149b bVar, int i) {
        Object[][] objArr;
        k.c((Context) ContextProvider.getInstance().getCurrentActiveActivity(), this.t);
        if (k.c((Context) ContextProvider.getInstance().getCurrentActiveActivity(), p())) {
            a((int) IronSourceConstants.RV_CAP_PLACEMENT, new Object[][]{new Object[]{"placement", p()}});
        }
        this.a.a(bVar);
        if (this.t != null) {
            if (this.n) {
                a(((ac) bVar).v, true, this.t.getPlacementId());
                int placementId = this.t.getPlacementId();
                int i2 = 0;
                while (i2 < i && i2 < this.c.size()) {
                    if (!this.v.contains(((C0149b) this.c.get(i2)).a)) {
                        a(((ac) this.c.get(i2)).v, false, placementId);
                    }
                    i2++;
                }
            }
            String p2 = p();
            a((int) IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, bVar, new Object[][]{new Object[]{"placement", p2}, new Object[]{"status", "true"}});
            int i3 = 0;
            while (i3 < this.c.size() && i3 < i) {
                C0149b bVar2 = (C0149b) this.c.get(i3);
                if (bVar2.a == C0149b.a.NOT_AVAILABLE || bVar2.a == C0149b.a.NEEDS_RELOAD) {
                    a((int) IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, bVar2, new Object[][]{new Object[]{"placement", p2}, new Object[]{"status", "false"}});
                }
                i3++;
            }
        } else {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
        if (this.t != null) {
            objArr = new Object[][]{new Object[]{"placement", p()}};
        } else {
            objArr = null;
        }
        a((int) IronSourceConstants.RV_INSTANCE_SHOW, bVar, objArr);
        this.y = true;
        this.p.a();
        ((ac) bVar).w = o.a().b(1);
        ac acVar = (ac) bVar;
        if (acVar.b != null) {
            acVar.q.log(IronSourceLogger.IronSourceTag.INTERNAL, acVar.d + ":showRewardedVideo()", 1);
            acVar.d();
            acVar.b.showRewardedVideo(acVar.r, acVar);
        }
    }

    private synchronized void a(String str, boolean z, int i) {
        String str2 = "";
        try {
            str2 = (str2 + str) + "&sdkVersion=" + IronSourceUtils.getSDKVersion();
            Thread thread = new Thread(new Runnable(str2, z, i) {
                private /* synthetic */ String a;
                private /* synthetic */ boolean b;
                private /* synthetic */ int c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                public final void run() {
                    String str = this.a;
                    boolean z = this.b;
                    try {
                        new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getRequestURL(str, z, this.c)));
                        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NETWORK;
                        logger.log(ironSourceTag, "callRequestURL(reqUrl:" + str + ", hit:" + z + ")", 1);
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder("callRequestURL(reqUrl:");
                        if (str == null) {
                            sb.append("null");
                        } else {
                            sb.append(str);
                        }
                        sb.append(", hit:");
                        sb.append(z);
                        sb.append(")");
                        IronSourceLoggerManager logger2 = IronSourceLoggerManager.getLogger();
                        IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NETWORK;
                        logger2.log(ironSourceTag2, sb.toString() + ", e:" + Log.getStackTraceString(th), 0);
                    }
                }
            }, "callAsyncRequestURL");
            thread.setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.c());
            thread.start();
        } catch (Throwable th) {
            this.h.logException(IronSourceLogger.IronSourceTag.NETWORK, "reportImpression:(providerURL:" + str2 + ", hit:" + z + ")", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.util.Map<java.lang.String, java.lang.Object> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.mediationsdk.b r0 = r2.d     // Catch:{ all -> 0x004a }
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r0 = r2.k     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x0023
            r2.k = r1     // Catch:{ all -> 0x004a }
            com.ironsource.mediationsdk.b r3 = r2.d     // Catch:{ all -> 0x004a }
            com.ironsource.mediationsdk.ac r3 = (com.ironsource.mediationsdk.ac) r3     // Catch:{ all -> 0x004a }
            com.ironsource.mediationsdk.AbstractAdapter r3 = r2.h(r3)     // Catch:{ all -> 0x004a }
            if (r3 != 0) goto L_0x0021
            com.ironsource.mediationsdk.sdk.i r3 = r2.m     // Catch:{ all -> 0x004a }
            java.lang.Boolean r0 = r2.j     // Catch:{ all -> 0x004a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004a }
            r3.onRewardedVideoAvailabilityChanged(r0)     // Catch:{ all -> 0x004a }
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            boolean r0 = r2.k()     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x003d
            r3 = 0
            boolean r3 = r2.a((boolean) r1, (boolean) r3)     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0048
            com.ironsource.mediationsdk.sdk.i r3 = r2.m     // Catch:{ all -> 0x004a }
            java.lang.Boolean r0 = r2.j     // Catch:{ all -> 0x004a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004a }
            r3.onRewardedVideoAvailabilityChanged(r0)     // Catch:{ all -> 0x004a }
            monitor-exit(r2)
            return
        L_0x003d:
            com.ironsource.mediationsdk.sdk.i r0 = r2.m     // Catch:{ all -> 0x004a }
            java.lang.Boolean r1 = r2.j     // Catch:{ all -> 0x004a }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x004a }
            r0.a((boolean) r1, (java.util.Map<java.lang.String, java.lang.Object>) r3)     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r2)
            return
        L_0x004a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.a(java.util.Map):void");
    }

    private synchronized boolean a(boolean z, boolean z2) {
        boolean z3;
        Boolean bool;
        z3 = true;
        if (this.j == null) {
            d();
            if (z) {
                bool = Boolean.TRUE;
            } else {
                if (!k() && h()) {
                    bool = Boolean.FALSE;
                }
                z3 = false;
            }
        } else if (!z || this.j.booleanValue()) {
            if (!z && this.j.booleanValue() && ((!j() || z2) && !k())) {
                bool = Boolean.FALSE;
            }
            z3 = false;
        } else {
            bool = Boolean.TRUE;
        }
        this.j = bool;
        return z3;
    }

    private void b(boolean z) {
        if (!z && c()) {
            a(1000, (Object[][]) null);
            a(1003, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, 0}});
            this.w = false;
        } else if (i()) {
            a(1000, (Object[][]) null);
            this.w = true;
            this.x = new Date().getTime();
        }
    }

    private AbstractAdapter f() {
        AbstractAdapter abstractAdapter = null;
        int i = 0;
        for (int i2 = 0; i2 < this.c.size() && abstractAdapter == null; i2++) {
            if (((C0149b) this.c.get(i2)).a == C0149b.a.AVAILABLE || ((C0149b) this.c.get(i2)).a == C0149b.a.INITIATED) {
                i++;
                if (i >= this.b) {
                    break;
                }
            } else if (((C0149b) this.c.get(i2)).a == C0149b.a.NOT_INITIATED && (abstractAdapter = h((ac) this.c.get(i2))) == null) {
                ((C0149b) this.c.get(i2)).a(C0149b.a.INIT_FAILED);
            }
        }
        return abstractAdapter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a8, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.ironsource.mediationsdk.AbstractAdapter h(com.ironsource.mediationsdk.ac r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.h     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.NATIVE     // Catch:{ all -> 0x00d7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r2.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r3 = r9.q     // Catch:{ all -> 0x00d7 }
            r2.append(r3)     // Catch:{ all -> 0x00d7 }
            java.lang.String r3 = ":startAdapter("
            r2.append(r3)     // Catch:{ all -> 0x00d7 }
            java.lang.String r3 = r10.d     // Catch:{ all -> 0x00d7 }
            r2.append(r3)     // Catch:{ all -> 0x00d7 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x00d7 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d7 }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.d r0 = com.ironsource.mediationsdk.C0151d.a()     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r10.c     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.model.NetworkSettings r2 = r10.c     // Catch:{ all -> 0x00d7 }
            org.json.JSONObject r2 = r2.getRewardedVideoSettings()     // Catch:{ all -> 0x00d7 }
            r4 = 0
            com.ironsource.mediationsdk.AbstractAdapter r0 = r0.a(r1, r2, r4, r4)     // Catch:{ all -> 0x00d7 }
            r1 = 0
            if (r0 != 0) goto L_0x0057
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.h     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00d7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r3.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r10 = r10.d     // Catch:{ all -> 0x00d7 }
            r3.append(r10)     // Catch:{ all -> 0x00d7 }
            java.lang.String r10 = " is configured in IronSource's platform, but the adapter is not integrated"
            r3.append(r10)     // Catch:{ all -> 0x00d7 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x00d7 }
            r3 = 2
            r0.log(r2, r10, r3)     // Catch:{ all -> 0x00d7 }
            monitor-exit(r9)
            return r1
        L_0x0057:
            r10.b = r0     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.b$a r2 = com.ironsource.mediationsdk.C0149b.a.INITIATED     // Catch:{ all -> 0x00d7 }
            r10.a(r2)     // Catch:{ all -> 0x00d7 }
            r9.b(r10)     // Catch:{ all -> 0x00d7 }
            r2 = 1001(0x3e9, float:1.403E-42)
            r9.a((int) r2, (com.ironsource.mediationsdk.C0149b) r10, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x00d7 }
            java.lang.String r2 = r9.g     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = r9.f     // Catch:{ all -> 0x00a9 }
            r10.h()     // Catch:{ all -> 0x00a9 }
            com.ironsource.mediationsdk.AbstractAdapter r5 = r10.b     // Catch:{ all -> 0x00a9 }
            if (r5 == 0) goto L_0x00a7
            java.util.concurrent.atomic.AtomicBoolean r5 = r10.t     // Catch:{ all -> 0x00a9 }
            r5.set(r3)     // Catch:{ all -> 0x00a9 }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x00a9 }
            r5.<init>()     // Catch:{ all -> 0x00a9 }
            long r5 = r5.getTime()     // Catch:{ all -> 0x00a9 }
            r10.u = r5     // Catch:{ all -> 0x00a9 }
            com.ironsource.mediationsdk.AbstractAdapter r5 = r10.b     // Catch:{ all -> 0x00a9 }
            r5.addRewardedVideoListener(r10)     // Catch:{ all -> 0x00a9 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r10.q     // Catch:{ all -> 0x00a9 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r7.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r8 = r10.d     // Catch:{ all -> 0x00a9 }
            r7.append(r8)     // Catch:{ all -> 0x00a9 }
            java.lang.String r8 = ":initRewardedVideo()"
            r7.append(r8)     // Catch:{ all -> 0x00a9 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a9 }
            r5.log(r6, r7, r3)     // Catch:{ all -> 0x00a9 }
            com.ironsource.mediationsdk.AbstractAdapter r3 = r10.b     // Catch:{ all -> 0x00a9 }
            org.json.JSONObject r5 = r10.r     // Catch:{ all -> 0x00a9 }
            r3.initRewardedVideo(r2, r4, r5, r10)     // Catch:{ all -> 0x00a9 }
        L_0x00a7:
            monitor-exit(r9)
            return r0
        L_0x00a9:
            r0 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r9.h     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00d7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r4.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r5 = r9.q     // Catch:{ all -> 0x00d7 }
            r4.append(r5)     // Catch:{ all -> 0x00d7 }
            java.lang.String r5 = "failed to init adapter: "
            r4.append(r5)     // Catch:{ all -> 0x00d7 }
            java.lang.String r5 = r10.j()     // Catch:{ all -> 0x00d7 }
            r4.append(r5)     // Catch:{ all -> 0x00d7 }
            java.lang.String r5 = "v"
            r4.append(r5)     // Catch:{ all -> 0x00d7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d7 }
            r2.logException(r3, r4, r0)     // Catch:{ all -> 0x00d7 }
            com.ironsource.mediationsdk.b$a r0 = com.ironsource.mediationsdk.C0149b.a.INIT_FAILED     // Catch:{ all -> 0x00d7 }
            r10.a(r0)     // Catch:{ all -> 0x00d7 }
            monitor-exit(r9)
            return r1
        L_0x00d7:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.h(com.ironsource.mediationsdk.ac):com.ironsource.mediationsdk.AbstractAdapter");
    }

    private synchronized boolean h() {
        int i;
        Iterator it = this.c.iterator();
        i = 0;
        while (it.hasNext()) {
            C0149b bVar = (C0149b) it.next();
            if (bVar.a == C0149b.a.INIT_FAILED || bVar.a == C0149b.a.CAPPED_PER_DAY || bVar.a == C0149b.a.CAPPED_PER_SESSION || bVar.a == C0149b.a.NOT_AVAILABLE || bVar.a == C0149b.a.NEEDS_RELOAD || bVar.a == C0149b.a.EXHAUSTED) {
                i++;
            }
        }
        return this.c.size() == i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean i() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.CopyOnWriteArrayList r0 = r4.c     // Catch:{ all -> 0x003c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003c }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b r1 = (com.ironsource.mediationsdk.C0149b) r1     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b$a r2 = r1.a     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b$a r3 = com.ironsource.mediationsdk.C0149b.a.NOT_AVAILABLE     // Catch:{ all -> 0x003c }
            if (r2 == r3) goto L_0x0037
            com.ironsource.mediationsdk.b$a r2 = r1.a     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b$a r3 = com.ironsource.mediationsdk.C0149b.a.NEEDS_RELOAD     // Catch:{ all -> 0x003c }
            if (r2 == r3) goto L_0x0037
            com.ironsource.mediationsdk.b$a r2 = r1.a     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b$a r3 = com.ironsource.mediationsdk.C0149b.a.AVAILABLE     // Catch:{ all -> 0x003c }
            if (r2 == r3) goto L_0x0037
            com.ironsource.mediationsdk.b$a r2 = r1.a     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b$a r3 = com.ironsource.mediationsdk.C0149b.a.INITIATED     // Catch:{ all -> 0x003c }
            if (r2 == r3) goto L_0x0037
            com.ironsource.mediationsdk.b$a r2 = r1.a     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b$a r3 = com.ironsource.mediationsdk.C0149b.a.INIT_PENDING     // Catch:{ all -> 0x003c }
            if (r2 == r3) goto L_0x0037
            com.ironsource.mediationsdk.b$a r1 = r1.a     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.b$a r2 = com.ironsource.mediationsdk.C0149b.a.LOAD_PENDING     // Catch:{ all -> 0x003c }
            if (r1 != r2) goto L_0x0007
        L_0x0037:
            r0 = 1
        L_0x0038:
            monitor-exit(r4)
            return r0
        L_0x003a:
            r0 = 0
            goto L_0x0038
        L_0x003c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.i():boolean");
    }

    private synchronized boolean j() {
        boolean z;
        z = false;
        Iterator it = this.c.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((C0149b) it.next()).a == C0149b.a.AVAILABLE) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        return z;
    }

    private synchronized boolean k() {
        if (this.d == null) {
            return false;
        }
        return ((ac) this.d).o();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void l() {
        /*
            r9 = this;
            monitor-enter(r9)
            com.ironsource.mediationsdk.AbstractAdapter r0 = r9.f()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r9)
            return
        L_0x0009:
            r0 = 4
            com.ironsource.mediationsdk.b$a[] r1 = new com.ironsource.mediationsdk.C0149b.a[r0]     // Catch:{ all -> 0x005d }
            com.ironsource.mediationsdk.b$a r2 = com.ironsource.mediationsdk.C0149b.a.NOT_AVAILABLE     // Catch:{ all -> 0x005d }
            r3 = 0
            r1[r3] = r2     // Catch:{ all -> 0x005d }
            com.ironsource.mediationsdk.b$a r2 = com.ironsource.mediationsdk.C0149b.a.NEEDS_RELOAD     // Catch:{ all -> 0x005d }
            r4 = 1
            r1[r4] = r2     // Catch:{ all -> 0x005d }
            r2 = 2
            com.ironsource.mediationsdk.b$a r4 = com.ironsource.mediationsdk.C0149b.a.CAPPED_PER_SESSION     // Catch:{ all -> 0x005d }
            r1[r2] = r4     // Catch:{ all -> 0x005d }
            r2 = 3
            com.ironsource.mediationsdk.b$a r4 = com.ironsource.mediationsdk.C0149b.a.CAPPED_PER_DAY     // Catch:{ all -> 0x005d }
            r1[r2] = r4     // Catch:{ all -> 0x005d }
            java.util.concurrent.CopyOnWriteArrayList r2 = r9.c     // Catch:{ all -> 0x005d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x005d }
            r4 = r3
        L_0x0027:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0044
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x005d }
            com.ironsource.mediationsdk.b r5 = (com.ironsource.mediationsdk.C0149b) r5     // Catch:{ all -> 0x005d }
            r6 = r4
            r4 = r3
        L_0x0035:
            if (r4 >= r0) goto L_0x0042
            r7 = r1[r4]     // Catch:{ all -> 0x005d }
            com.ironsource.mediationsdk.b$a r8 = r5.a     // Catch:{ all -> 0x005d }
            if (r8 != r7) goto L_0x003f
            int r6 = r6 + 1
        L_0x003f:
            int r4 = r4 + 1
            goto L_0x0035
        L_0x0042:
            r4 = r6
            goto L_0x0027
        L_0x0044:
            java.util.concurrent.CopyOnWriteArrayList r0 = r9.c     // Catch:{ all -> 0x005d }
            int r0 = r0.size()     // Catch:{ all -> 0x005d }
            if (r4 >= r0) goto L_0x0051
            r9.m()     // Catch:{ all -> 0x005d }
            monitor-exit(r9)
            return
        L_0x0051:
            boolean r0 = r9.a((boolean) r3, (boolean) r3)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x005b
            r0 = 0
            r9.a((java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r9)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.l():void");
    }

    private synchronized void m() {
        if (n()) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            Iterator it = this.c.iterator();
            boolean z = false;
            while (it.hasNext()) {
                C0149b bVar = (C0149b) it.next();
                if (bVar.a == C0149b.a.EXHAUSTED) {
                    bVar.g();
                }
                if (bVar.a == C0149b.a.AVAILABLE) {
                    z = true;
                }
            }
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
            if (a(z, false)) {
                this.m.onRewardedVideoAvailabilityChanged(this.j.booleanValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0028 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean n() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.CopyOnWriteArrayList r0 = r4.c     // Catch:{ all -> 0x002a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002a }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0028
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x002a }
            com.ironsource.mediationsdk.b r1 = (com.ironsource.mediationsdk.C0149b) r1     // Catch:{ all -> 0x002a }
            com.ironsource.mediationsdk.b$a r2 = r1.a     // Catch:{ all -> 0x002a }
            com.ironsource.mediationsdk.b$a r3 = com.ironsource.mediationsdk.C0149b.a.NOT_INITIATED     // Catch:{ all -> 0x002a }
            if (r2 == r3) goto L_0x0025
            com.ironsource.mediationsdk.b$a r2 = r1.a     // Catch:{ all -> 0x002a }
            com.ironsource.mediationsdk.b$a r3 = com.ironsource.mediationsdk.C0149b.a.INITIATED     // Catch:{ all -> 0x002a }
            if (r2 == r3) goto L_0x0025
            com.ironsource.mediationsdk.b$a r1 = r1.a     // Catch:{ all -> 0x002a }
            com.ironsource.mediationsdk.b$a r2 = com.ironsource.mediationsdk.C0149b.a.AVAILABLE     // Catch:{ all -> 0x002a }
            if (r1 != r2) goto L_0x0007
        L_0x0025:
            r0 = 0
        L_0x0026:
            monitor-exit(r4)
            return r0
        L_0x0028:
            r0 = 1
            goto L_0x0026
        L_0x002a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.n():boolean");
    }

    private void o() {
        for (int i = 0; i < this.c.size(); i++) {
            String providerTypeForReflection = ((C0149b) this.c.get(i)).c.getProviderTypeForReflection();
            if (providerTypeForReflection.equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME) || providerTypeForReflection.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME)) {
                C0151d.a().a(((C0149b) this.c.get(i)).c, ((C0149b) this.c.get(i)).c.getRewardedVideoSettings(), false, false);
                return;
            }
        }
    }

    private String p() {
        Placement placement = this.t;
        return placement == null ? "" : placement.getPlacementName();
    }

    private void q() {
        Iterator it = this.c.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            C0149b bVar = (C0149b) it.next();
            if (bVar.a == C0149b.a.AVAILABLE && bVar.l() != null && bVar.l().longValue() < j) {
                j = bVar.l().longValue();
            }
        }
        if (j != Long.MAX_VALUE) {
            this.p.a(System.currentTimeMillis() - j);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, boolean z) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, this.q + " Should Track Network State: " + z, 0);
        try {
            this.i = z;
            if (this.i) {
                if (this.s == null) {
                    this.s = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.s, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.s != null) {
                context.getApplicationContext().unregisterReceiver(this.s);
            }
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Got an error from receiver with message: " + e.getMessage());
        }
    }

    public final void a(ac acVar) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, acVar.d + ":onRewardedVideoAdOpened()", 1);
        a(1005, (C0149b) acVar, new Object[][]{new Object[]{"placement", p()}, new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(acVar.w)}});
        this.m.onRewardedVideoAdOpened();
    }

    public final void a(IronSourceError ironSourceError, ac acVar) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, acVar.d + ":onRewardedVideoAdShowFailed(" + ironSourceError + ")", 1);
        this.y = false;
        int i = acVar.w;
        a((int) IronSourceConstants.RV_INSTANCE_SHOW_FAILED, (C0149b) acVar, new Object[][]{new Object[]{"placement", p()}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(i)}});
        b(false);
        this.m.onRewardedVideoAdShowFailed(ironSourceError);
    }

    /* access modifiers changed from: package-private */
    public final void a(Placement placement) {
        this.t = placement;
        this.m.f = placement.getPlacementName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.h     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r2.<init>()     // Catch:{ all -> 0x01a1 }
            java.lang.String r3 = r9.q     // Catch:{ all -> 0x01a1 }
            r2.append(r3)     // Catch:{ all -> 0x01a1 }
            java.lang.String r3 = ":showRewardedVideo(placementName: "
            r2.append(r3)     // Catch:{ all -> 0x01a1 }
            r2.append(r10)     // Catch:{ all -> 0x01a1 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01a1 }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.sdk.i r0 = r9.m     // Catch:{ all -> 0x01a1 }
            r0.f = r10     // Catch:{ all -> 0x01a1 }
            r0 = 1100(0x44c, float:1.541E-42)
            java.lang.Object[][] r1 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01a1 }
            r2 = 2
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x01a1 }
            java.lang.String r5 = "placement"
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x01a1 }
            r4[r3] = r10     // Catch:{ all -> 0x01a1 }
            r1[r6] = r4     // Catch:{ all -> 0x01a1 }
            r9.a((int) r0, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x01a1 }
            boolean r10 = r9.y     // Catch:{ all -> 0x01a1 }
            r0 = 3
            if (r10 == 0) goto L_0x0057
            java.lang.String r10 = "showRewardedVideo error: can't show ad while an ad is already showing"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r9.h     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x01a1 }
            r1.log(r2, r10, r0)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01a1 }
            r1 = 1022(0x3fe, float:1.432E-42)
            r0.<init>(r1, r10)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.sdk.i r10 = r9.m     // Catch:{ all -> 0x01a1 }
            r10.onRewardedVideoAdShowFailed(r0)     // Catch:{ all -> 0x01a1 }
            monitor-exit(r9)
            return
        L_0x0057:
            boolean r10 = r9.i     // Catch:{ all -> 0x01a1 }
            if (r10 == 0) goto L_0x007f
            com.ironsource.environment.ContextProvider r10 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01a1 }
            android.app.Activity r10 = r10.getCurrentActiveActivity()     // Catch:{ all -> 0x01a1 }
            boolean r10 = com.ironsource.mediationsdk.utils.IronSourceUtils.isNetworkConnected(r10)     // Catch:{ all -> 0x01a1 }
            if (r10 != 0) goto L_0x007f
            java.lang.String r10 = "showRewardedVideo error: can't show ad when there's no internet connection"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r9.h     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x01a1 }
            r1.log(r2, r10, r0)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.sdk.i r10 = r9.m     // Catch:{ all -> 0x01a1 }
            java.lang.String r0 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r0 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoInternetConnectionShowFailError(r0)     // Catch:{ all -> 0x01a1 }
            r10.onRewardedVideoAdShowFailed(r0)     // Catch:{ all -> 0x01a1 }
            monitor-exit(r9)
            return
        L_0x007f:
            java.lang.StringBuffer r10 = new java.lang.StringBuffer     // Catch:{ all -> 0x01a1 }
            r10.<init>()     // Catch:{ all -> 0x01a1 }
            r0 = r6
        L_0x0085:
            java.util.concurrent.CopyOnWriteArrayList r1 = r9.c     // Catch:{ all -> 0x01a1 }
            int r1 = r1.size()     // Catch:{ all -> 0x01a1 }
            if (r0 >= r1) goto L_0x0173
            java.util.concurrent.CopyOnWriteArrayList r1 = r9.c     // Catch:{ all -> 0x01a1 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.b r1 = (com.ironsource.mediationsdk.C0149b) r1     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r9.h     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            java.lang.String r8 = "showRewardedVideo, iterating on: "
            r7.<init>(r8)     // Catch:{ all -> 0x01a1 }
            java.lang.String r8 = r1.d     // Catch:{ all -> 0x01a1 }
            r7.append(r8)     // Catch:{ all -> 0x01a1 }
            java.lang.String r8 = ", Status: "
            r7.append(r8)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.b$a r8 = r1.a     // Catch:{ all -> 0x01a1 }
            r7.append(r8)     // Catch:{ all -> 0x01a1 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01a1 }
            r4.log(r5, r7, r6)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.b$a r4 = r1.a     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.b$a r5 = com.ironsource.mediationsdk.C0149b.a.AVAILABLE     // Catch:{ all -> 0x01a1 }
            if (r4 != r5) goto L_0x016f
            r4 = r1
            com.ironsource.mediationsdk.ac r4 = (com.ironsource.mediationsdk.ac) r4     // Catch:{ all -> 0x01a1 }
            boolean r4 = r4.o()     // Catch:{ all -> 0x01a1 }
            if (r4 == 0) goto L_0x0120
            r9.a((com.ironsource.mediationsdk.C0149b) r1, (int) r0)     // Catch:{ all -> 0x01a1 }
            boolean r10 = r9.l     // Catch:{ all -> 0x01a1 }
            if (r10 == 0) goto L_0x00d7
            com.ironsource.mediationsdk.b r10 = r9.e     // Catch:{ all -> 0x01a1 }
            boolean r10 = r1.equals(r10)     // Catch:{ all -> 0x01a1 }
            if (r10 != 0) goto L_0x00d7
            r9.b()     // Catch:{ all -> 0x01a1 }
        L_0x00d7:
            boolean r10 = r1.b()     // Catch:{ all -> 0x01a1 }
            if (r10 == 0) goto L_0x00ed
            com.ironsource.mediationsdk.b$a r10 = com.ironsource.mediationsdk.C0149b.a.CAPPED_PER_SESSION     // Catch:{ all -> 0x01a1 }
            r1.a(r10)     // Catch:{ all -> 0x01a1 }
            r10 = 1401(0x579, float:1.963E-42)
            r0 = 0
            r9.a((int) r10, (com.ironsource.mediationsdk.C0149b) r1, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x01a1 }
            r9.l()     // Catch:{ all -> 0x01a1 }
            monitor-exit(r9)
            return
        L_0x00ed:
            com.ironsource.mediationsdk.utils.e r10 = r9.a     // Catch:{ all -> 0x01a1 }
            boolean r10 = r10.c((com.ironsource.mediationsdk.C0149b) r1)     // Catch:{ all -> 0x01a1 }
            if (r10 == 0) goto L_0x0112
            com.ironsource.mediationsdk.b$a r10 = com.ironsource.mediationsdk.C0149b.a.CAPPED_PER_DAY     // Catch:{ all -> 0x01a1 }
            r1.a(r10)     // Catch:{ all -> 0x01a1 }
            r10 = 150(0x96, float:2.1E-43)
            java.lang.Object[][] r0 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01a1 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "status"
            r2[r6] = r4     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "true"
            r2[r3] = r4     // Catch:{ all -> 0x01a1 }
            r0[r6] = r2     // Catch:{ all -> 0x01a1 }
            r9.a((int) r10, (com.ironsource.mediationsdk.C0149b) r1, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x01a1 }
            r9.l()     // Catch:{ all -> 0x01a1 }
            monitor-exit(r9)
            return
        L_0x0112:
            boolean r10 = r1.a()     // Catch:{ all -> 0x01a1 }
            if (r10 == 0) goto L_0x011e
            r9.f()     // Catch:{ all -> 0x01a1 }
            r9.m()     // Catch:{ all -> 0x01a1 }
        L_0x011e:
            monitor-exit(r9)
            return
        L_0x0120:
            java.lang.Long r4 = r1.m()     // Catch:{ all -> 0x01a1 }
            if (r4 == 0) goto L_0x0148
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r4.<init>()     // Catch:{ all -> 0x01a1 }
            java.lang.String r5 = r1.d     // Catch:{ all -> 0x01a1 }
            r4.append(r5)     // Catch:{ all -> 0x01a1 }
            java.lang.String r5 = ":"
            r4.append(r5)     // Catch:{ all -> 0x01a1 }
            java.lang.Long r5 = r1.m()     // Catch:{ all -> 0x01a1 }
            r4.append(r5)     // Catch:{ all -> 0x01a1 }
            java.lang.String r5 = ","
            r4.append(r5)     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01a1 }
            r10.append(r4)     // Catch:{ all -> 0x01a1 }
        L_0x0148:
            r4 = r1
            com.ironsource.mediationsdk.ac r4 = (com.ironsource.mediationsdk.ac) r4     // Catch:{ all -> 0x01a1 }
            r9.a((boolean) r6, (com.ironsource.mediationsdk.ac) r4)     // Catch:{ all -> 0x01a1 }
            java.lang.Exception r4 = new java.lang.Exception     // Catch:{ all -> 0x01a1 }
            java.lang.String r5 = "FailedToShowVideoException"
            r4.<init>(r5)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r9.h     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r8.<init>()     // Catch:{ all -> 0x01a1 }
            java.lang.String r1 = r1.d     // Catch:{ all -> 0x01a1 }
            r8.append(r1)     // Catch:{ all -> 0x01a1 }
            java.lang.String r1 = " Failed to show video"
            r8.append(r1)     // Catch:{ all -> 0x01a1 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x01a1 }
            r5.logException(r7, r1, r4)     // Catch:{ all -> 0x01a1 }
        L_0x016f:
            int r0 = r0 + 1
            goto L_0x0085
        L_0x0173:
            boolean r0 = r9.k()     // Catch:{ all -> 0x01a1 }
            if (r0 == 0) goto L_0x0186
            com.ironsource.mediationsdk.b r10 = r9.d     // Catch:{ all -> 0x01a1 }
            java.util.concurrent.CopyOnWriteArrayList r0 = r9.c     // Catch:{ all -> 0x01a1 }
            int r0 = r0.size()     // Catch:{ all -> 0x01a1 }
            r9.a((com.ironsource.mediationsdk.C0149b) r10, (int) r0)     // Catch:{ all -> 0x01a1 }
            monitor-exit(r9)
            return
        L_0x0186:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x01a1 }
            r0.<init>()     // Catch:{ all -> 0x01a1 }
            java.lang.String r1 = "ext1"
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01a1 }
            r0.put(r1, r10)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.sdk.i r10 = r9.m     // Catch:{ all -> 0x01a1 }
            java.lang.String r1 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r1 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoAdsToShowError(r1)     // Catch:{ all -> 0x01a1 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r1, (java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ all -> 0x01a1 }
            monitor-exit(r9)
            return
        L_0x01a1:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00de, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.h     // Catch:{ all -> 0x00df }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00df }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r2.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r3 = r9.q     // Catch:{ all -> 0x00df }
            r2.append(r3)     // Catch:{ all -> 0x00df }
            java.lang.String r3 = ":initRewardedVideo(appKey: "
            r2.append(r3)     // Catch:{ all -> 0x00df }
            r2.append(r10)     // Catch:{ all -> 0x00df }
            java.lang.String r3 = ", userId: "
            r2.append(r3)     // Catch:{ all -> 0x00df }
            r2.append(r11)     // Catch:{ all -> 0x00df }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00df }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x00df }
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x00df }
            r0.<init>()     // Catch:{ all -> 0x00df }
            long r0 = r0.getTime()     // Catch:{ all -> 0x00df }
            r2 = 81312(0x13da0, float:1.13942E-40)
            r9.a((int) r2)     // Catch:{ all -> 0x00df }
            r9.g = r10     // Catch:{ all -> 0x00df }
            r9.f = r11     // Catch:{ all -> 0x00df }
            java.util.concurrent.CopyOnWriteArrayList r10 = r9.c     // Catch:{ all -> 0x00df }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00df }
            r11 = 0
            r2 = r11
        L_0x0047:
            boolean r4 = r10.hasNext()     // Catch:{ all -> 0x00df }
            r5 = 2
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r10.next()     // Catch:{ all -> 0x00df }
            com.ironsource.mediationsdk.b r4 = (com.ironsource.mediationsdk.C0149b) r4     // Catch:{ all -> 0x00df }
            com.ironsource.mediationsdk.utils.e r6 = r9.a     // Catch:{ all -> 0x00df }
            boolean r6 = r6.b((com.ironsource.mediationsdk.C0149b) r4)     // Catch:{ all -> 0x00df }
            if (r6 == 0) goto L_0x006f
            r6 = 150(0x96, float:2.1E-43)
            java.lang.Object[][] r7 = new java.lang.Object[r3][]     // Catch:{ all -> 0x00df }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "status"
            r5[r11] = r8     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "false"
            r5[r3] = r8     // Catch:{ all -> 0x00df }
            r7[r11] = r5     // Catch:{ all -> 0x00df }
            r9.a((int) r6, (com.ironsource.mediationsdk.C0149b) r4, (java.lang.Object[][]) r7)     // Catch:{ all -> 0x00df }
        L_0x006f:
            com.ironsource.mediationsdk.utils.e r5 = r9.a     // Catch:{ all -> 0x00df }
            boolean r5 = r5.c((com.ironsource.mediationsdk.C0149b) r4)     // Catch:{ all -> 0x00df }
            if (r5 == 0) goto L_0x0047
            com.ironsource.mediationsdk.b$a r5 = com.ironsource.mediationsdk.C0149b.a.CAPPED_PER_DAY     // Catch:{ all -> 0x00df }
            r4.a(r5)     // Catch:{ all -> 0x00df }
            int r2 = r2 + 1
            goto L_0x0047
        L_0x007f:
            java.util.concurrent.CopyOnWriteArrayList r10 = r9.c     // Catch:{ all -> 0x00df }
            int r10 = r10.size()     // Catch:{ all -> 0x00df }
            if (r2 != r10) goto L_0x008e
            com.ironsource.mediationsdk.sdk.i r10 = r9.m     // Catch:{ all -> 0x00df }
            r10.onRewardedVideoAvailabilityChanged(r11)     // Catch:{ all -> 0x00df }
            monitor-exit(r9)
            return
        L_0x008e:
            r10 = 1000(0x3e8, float:1.401E-42)
            r9.a((int) r10)     // Catch:{ all -> 0x00df }
            com.ironsource.mediationsdk.sdk.i r10 = r9.m     // Catch:{ all -> 0x00df }
            r2 = 0
            r10.f = r2     // Catch:{ all -> 0x00df }
            r9.w = r3     // Catch:{ all -> 0x00df }
            java.util.Date r10 = new java.util.Date     // Catch:{ all -> 0x00df }
            r10.<init>()     // Catch:{ all -> 0x00df }
            long r6 = r10.getTime()     // Catch:{ all -> 0x00df }
            r9.x = r6     // Catch:{ all -> 0x00df }
            java.util.Date r10 = new java.util.Date     // Catch:{ all -> 0x00df }
            r10.<init>()     // Catch:{ all -> 0x00df }
            long r6 = r10.getTime()     // Catch:{ all -> 0x00df }
            long r6 = r6 - r0
            r10 = 81313(0x13da1, float:1.13944E-40)
            java.lang.Object[][] r0 = new java.lang.Object[r3][]     // Catch:{ all -> 0x00df }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "duration"
            r1[r11] = r2     // Catch:{ all -> 0x00df }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00df }
            r1[r3] = r2     // Catch:{ all -> 0x00df }
            r0[r11] = r1     // Catch:{ all -> 0x00df }
            r9.a((int) r10, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x00df }
            r9.o()     // Catch:{ all -> 0x00df }
        L_0x00c8:
            int r10 = r9.b     // Catch:{ all -> 0x00df }
            if (r11 >= r10) goto L_0x00dd
            java.util.concurrent.CopyOnWriteArrayList r10 = r9.c     // Catch:{ all -> 0x00df }
            int r10 = r10.size()     // Catch:{ all -> 0x00df }
            if (r11 >= r10) goto L_0x00dd
            com.ironsource.mediationsdk.AbstractAdapter r10 = r9.f()     // Catch:{ all -> 0x00df }
            if (r10 == 0) goto L_0x00dd
            int r11 = r11 + 1
            goto L_0x00c8
        L_0x00dd:
            monitor-exit(r9)
            return
        L_0x00df:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.a(java.lang.String, java.lang.String):void");
    }

    public final void a(boolean z) {
        Boolean bool;
        if (this.i) {
            boolean z2 = false;
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z, 0);
            if (this.j != null) {
                if (z && !this.j.booleanValue() && j()) {
                    bool = Boolean.TRUE;
                } else if (!z && this.j.booleanValue()) {
                    bool = Boolean.FALSE;
                }
                this.j = bool;
                z2 = true;
            }
            if (z2) {
                this.r = !z;
                this.m.onRewardedVideoAvailabilityChanged(z);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ed, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r9, com.ironsource.mediationsdk.ac r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r8.h     // Catch:{ all -> 0x0117 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            r2.<init>()     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = r10.d     // Catch:{ all -> 0x0117 }
            r2.append(r3)     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = ": onRewardedVideoAvailabilityChanged(available:"
            r2.append(r3)     // Catch:{ all -> 0x0117 }
            r2.append(r9)     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x0117 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0117 }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x0117 }
            boolean r0 = r8.r     // Catch:{ all -> 0x0117 }
            if (r0 == 0) goto L_0x002a
            monitor-exit(r8)
            return
        L_0x002a:
            r0 = 0
            if (r9 == 0) goto L_0x0058
            boolean r1 = r8.w     // Catch:{ all -> 0x0117 }
            if (r1 == 0) goto L_0x0058
            r8.w = r0     // Catch:{ all -> 0x0117 }
            java.util.Date r1 = new java.util.Date     // Catch:{ all -> 0x0117 }
            r1.<init>()     // Catch:{ all -> 0x0117 }
            long r1 = r1.getTime()     // Catch:{ all -> 0x0117 }
            long r4 = r8.x     // Catch:{ all -> 0x0117 }
            long r1 = r1 - r4
            r4 = 1003(0x3eb, float:1.406E-42)
            java.lang.Object[][] r5 = new java.lang.Object[r3][]     // Catch:{ all -> 0x0117 }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0117 }
            java.lang.String r7 = "duration"
            r6[r0] = r7     // Catch:{ all -> 0x0117 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0117 }
            r6[r3] = r1     // Catch:{ all -> 0x0117 }
            r5[r0] = r6     // Catch:{ all -> 0x0117 }
            r8.a((int) r4, (java.lang.Object[][]) r5)     // Catch:{ all -> 0x0117 }
            r8.q()     // Catch:{ all -> 0x0117 }
        L_0x0058:
            com.ironsource.mediationsdk.b r1 = r8.d     // Catch:{ all -> 0x00ee }
            boolean r1 = r10.equals(r1)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0073
            boolean r0 = r8.a((boolean) r9, (boolean) r0)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0071
            com.ironsource.mediationsdk.sdk.i r0 = r8.m     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r1 = r8.j     // Catch:{ all -> 0x00ee }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ee }
            r0.onRewardedVideoAvailabilityChanged(r1)     // Catch:{ all -> 0x00ee }
        L_0x0071:
            monitor-exit(r8)
            return
        L_0x0073:
            com.ironsource.mediationsdk.b r1 = r8.e     // Catch:{ all -> 0x00ee }
            boolean r1 = r10.equals(r1)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00ba
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r8.h     // Catch:{ all -> 0x00ee }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r4.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r5 = r10.d     // Catch:{ all -> 0x00ee }
            r4.append(r5)     // Catch:{ all -> 0x00ee }
            java.lang.String r5 = " is a premium adapter, canShowPremium: "
            r4.append(r5)     // Catch:{ all -> 0x00ee }
            boolean r5 = r8.a()     // Catch:{ all -> 0x00ee }
            r4.append(r5)     // Catch:{ all -> 0x00ee }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00ee }
            r1.log(r2, r4, r3)     // Catch:{ all -> 0x00ee }
            boolean r1 = r8.a()     // Catch:{ all -> 0x00ee }
            if (r1 != 0) goto L_0x00ba
            com.ironsource.mediationsdk.b$a r1 = com.ironsource.mediationsdk.C0149b.a.CAPPED_PER_SESSION     // Catch:{ all -> 0x00ee }
            r10.a(r1)     // Catch:{ all -> 0x00ee }
            boolean r0 = r8.a((boolean) r0, (boolean) r0)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00b8
            com.ironsource.mediationsdk.sdk.i r0 = r8.m     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r1 = r8.j     // Catch:{ all -> 0x00ee }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ee }
            r0.onRewardedVideoAvailabilityChanged(r1)     // Catch:{ all -> 0x00ee }
        L_0x00b8:
            monitor-exit(r8)
            return
        L_0x00ba:
            com.ironsource.mediationsdk.utils.e r1 = r8.a     // Catch:{ all -> 0x00ee }
            boolean r1 = r1.c((com.ironsource.mediationsdk.C0149b) r10)     // Catch:{ all -> 0x00ee }
            if (r1 != 0) goto L_0x00ec
            if (r9 == 0) goto L_0x00dc
            boolean r1 = r10.c()     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00dc
            boolean r0 = r8.a((boolean) r3, (boolean) r0)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00ec
            com.ironsource.mediationsdk.sdk.i r0 = r8.m     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r1 = r8.j     // Catch:{ all -> 0x00ee }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ee }
            r0.onRewardedVideoAvailabilityChanged(r1)     // Catch:{ all -> 0x00ee }
            goto L_0x0115
        L_0x00dc:
            boolean r0 = r8.a((boolean) r0, (boolean) r0)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00e6
            r0 = 0
            r8.a((java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ all -> 0x00ee }
        L_0x00e6:
            r8.f()     // Catch:{ all -> 0x00ee }
            r8.m()     // Catch:{ all -> 0x00ee }
        L_0x00ec:
            monitor-exit(r8)
            return
        L_0x00ee:
            r0 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r8.h     // Catch:{ all -> 0x0117 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            java.lang.String r4 = "onRewardedVideoAvailabilityChanged(available:"
            r3.<init>(r4)     // Catch:{ all -> 0x0117 }
            r3.append(r9)     // Catch:{ all -> 0x0117 }
            java.lang.String r9 = ", provider:"
            r3.append(r9)     // Catch:{ all -> 0x0117 }
            java.lang.String r9 = r10.j()     // Catch:{ all -> 0x0117 }
            r3.append(r9)     // Catch:{ all -> 0x0117 }
            java.lang.String r9 = ")"
            r3.append(r9)     // Catch:{ all -> 0x0117 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x0117 }
            r1.logException(r2, r9, r0)     // Catch:{ all -> 0x0117 }
        L_0x0115:
            monitor-exit(r8)
            return
        L_0x0117:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.a(boolean, com.ironsource.mediationsdk.ac):void");
    }

    /* access modifiers changed from: protected */
    public final synchronized void b() {
        super.b();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            C0149b bVar = (C0149b) it.next();
            if (bVar.equals(this.e)) {
                bVar.a(C0149b.a.CAPPED_PER_SESSION);
                f();
                return;
            }
        }
    }

    public final void b(ac acVar) {
        String str;
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, acVar.d + ":onRewardedVideoAdClosed()", 1);
        this.y = false;
        StringBuilder sb = new StringBuilder();
        try {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0149b bVar = (C0149b) it.next();
                if (((ac) bVar).o()) {
                    sb.append(bVar.d + ";");
                }
            }
        } catch (Throwable unused) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Failed to check RV availability", 0);
        }
        Object[][] objArr = new Object[3][];
        objArr[0] = new Object[]{"placement", p()};
        Object[] objArr2 = new Object[2];
        objArr2[0] = IronSourceConstants.EVENTS_EXT1;
        StringBuilder sb2 = new StringBuilder("otherRVAvailable = ");
        if (sb.length() > 0) {
            str = "true|" + sb;
        } else {
            str = "false";
        }
        sb2.append(str);
        objArr2[1] = sb2.toString();
        objArr[1] = objArr2;
        objArr[2] = new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(acVar.w)};
        a((int) IronSourceConstants.RV_INSTANCE_CLOSED, (C0149b) acVar, objArr);
        o.a().a(1);
        if (!acVar.b() && !this.a.c((C0149b) acVar)) {
            a(1001, (C0149b) acVar, (Object[][]) null);
        }
        b(false);
        this.m.onRewardedVideoAdClosed();
        q();
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            C0149b bVar2 = (C0149b) it2.next();
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Fetch on ad closed, iterating on: " + bVar2.d + ", Status: " + bVar2.a, 0);
            if (bVar2.a == C0149b.a.NOT_AVAILABLE || bVar2.a == C0149b.a.NEEDS_RELOAD) {
                try {
                    if (!bVar2.d.equals(acVar.d)) {
                        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, bVar2.d + ":reload smash", 1);
                        ((ac) bVar2).n();
                        a(1001, bVar2, (Object[][]) null);
                    }
                } catch (Throwable th) {
                    this.h.log(IronSourceLogger.IronSourceTag.NATIVE, bVar2.d + " Failed to call fetchVideo(), " + th.getLocalizedMessage(), 1);
                }
            }
        }
    }

    public final void c(ac acVar) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, acVar.d + ":onRewardedVideoAdStarted()", 1);
        a((int) IronSourceConstants.RV_INSTANCE_STARTED, (C0149b) acVar, new Object[][]{new Object[]{"placement", p()}, new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(acVar.w)}});
        this.m.onRewardedVideoAdStarted();
    }

    public final synchronized boolean c() {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, this.q + ":isRewardedVideoAvailable()", 1);
        if (this.i && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
            return false;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            C0149b bVar = (C0149b) it.next();
            if (bVar.c() && ((ac) bVar).o()) {
                return true;
            }
        }
        return false;
    }

    public final void c_() {
        if (!IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext()) || this.j == null) {
            IronLog.INTERNAL.info("while reloading mediation due to expiration, internet loss occurred");
            a((int) IronSourceConstants.TROUBLESHOOTING_RV_TRADITIONAL_RELOAD_FAILED_INTERNET_LOSS, (Object[][]) null);
            return;
        }
        if (a(false, true)) {
            a(a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "loaded ads are expired"}}));
        }
        b(true);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            C0149b bVar = (C0149b) it.next();
            if (bVar.a == C0149b.a.AVAILABLE || bVar.a == C0149b.a.NOT_AVAILABLE) {
                bVar.a(C0149b.a.NEEDS_RELOAD);
            }
        }
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            C0149b bVar2 = (C0149b) it2.next();
            if (bVar2.a == C0149b.a.NEEDS_RELOAD) {
                try {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.info(bVar2.d + ":reload smash");
                    a(1001, bVar2, (Object[][]) null);
                    ((ac) bVar2).n();
                } catch (Throwable th) {
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.error(bVar2.d + " Failed to call fetchVideo(), " + th.getLocalizedMessage());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.o <= 0) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "load interval is not set, ignoring", 1);
            return;
        }
        Timer timer = this.u;
        if (timer != null) {
            timer.cancel();
        }
        this.u = new Timer();
        this.u.schedule(new TimerTask() {
            public final void run() {
                cancel();
                ab.this.e();
                ab.this.d();
            }
        }, (long) (this.o * 1000));
    }

    public final void d(ac acVar) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, acVar.d + ":onRewardedVideoAdEnded()", 1);
        a((int) IronSourceConstants.RV_INSTANCE_ENDED, (C0149b) acVar, new Object[][]{new Object[]{"placement", p()}, new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(acVar.w)}});
        this.m.onRewardedVideoAdEnded();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0091, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0092 }
            android.app.Activity r0 = r0.getCurrentActiveActivity()     // Catch:{ all -> 0x0092 }
            boolean r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.isNetworkConnected(r0)     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x0090
            java.lang.Boolean r0 = r8.j     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x0015
            goto L_0x0090
        L_0x0015:
            java.lang.Boolean r0 = r8.j     // Catch:{ all -> 0x0092 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x008e
            r0 = 102(0x66, float:1.43E-43)
            r1 = 0
            r8.a((int) r0, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x0092 }
            r0 = 1000(0x3e8, float:1.401E-42)
            r8.a((int) r0, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x0092 }
            r0 = 1
            r8.w = r0     // Catch:{ all -> 0x0092 }
            java.util.concurrent.CopyOnWriteArrayList r2 = r8.c     // Catch:{ all -> 0x0092 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0092 }
        L_0x0031:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0092 }
            if (r3 == 0) goto L_0x008e
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0092 }
            com.ironsource.mediationsdk.b r3 = (com.ironsource.mediationsdk.C0149b) r3     // Catch:{ all -> 0x0092 }
            com.ironsource.mediationsdk.b$a r4 = r3.a     // Catch:{ all -> 0x0092 }
            com.ironsource.mediationsdk.b$a r5 = com.ironsource.mediationsdk.C0149b.a.NOT_AVAILABLE     // Catch:{ all -> 0x0092 }
            if (r4 != r5) goto L_0x0031
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r8.h     // Catch:{ all -> 0x006b }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            java.lang.String r7 = "Fetch from timer: "
            r6.<init>(r7)     // Catch:{ all -> 0x006b }
            java.lang.String r7 = r3.d     // Catch:{ all -> 0x006b }
            r6.append(r7)     // Catch:{ all -> 0x006b }
            java.lang.String r7 = ":reload smash"
            r6.append(r7)     // Catch:{ all -> 0x006b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006b }
            r4.log(r5, r6, r0)     // Catch:{ all -> 0x006b }
            r4 = 1001(0x3e9, float:1.403E-42)
            r8.a((int) r4, (com.ironsource.mediationsdk.C0149b) r3, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x006b }
            r4 = r3
            com.ironsource.mediationsdk.ac r4 = (com.ironsource.mediationsdk.ac) r4     // Catch:{ all -> 0x006b }
            r4.n()     // Catch:{ all -> 0x006b }
            goto L_0x0031
        L_0x006b:
            r4 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r8.h     // Catch:{ all -> 0x0092 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.NATIVE     // Catch:{ all -> 0x0092 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r7.<init>()     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = r3.d     // Catch:{ all -> 0x0092 }
            r7.append(r3)     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = " Failed to call fetchVideo(), "
            r7.append(r3)     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0092 }
            r7.append(r3)     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0092 }
            r5.log(r6, r3, r0)     // Catch:{ all -> 0x0092 }
            goto L_0x0031
        L_0x008e:
            monitor-exit(r8)
            return
        L_0x0090:
            monitor-exit(r8)
            return
        L_0x0092:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ab.e():void");
    }

    public final void e(ac acVar) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, acVar.d + ":onRewardedVideoAdRewarded()", 1);
        if (this.t == null) {
            this.t = H.a().i.c.a.a();
        }
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData((C0149b) acVar);
        try {
            providerAdditionalData.put(IronSourceConstants.KEY_SESSION_DEPTH, acVar.w);
            if (this.t != null) {
                providerAdditionalData.put("placement", p());
                providerAdditionalData.put(IronSourceConstants.EVENTS_REWARD_NAME, this.t.getRewardName());
                providerAdditionalData.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, this.t.getRewardAmount());
            } else {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c cVar = new c(1010, providerAdditionalData);
        if (!TextUtils.isEmpty(this.g)) {
            cVar.a(IronSourceConstants.EVENTS_TRANS_ID, (Object) IronSourceUtils.getTransId(cVar.b(), acVar.j()));
            if (!TextUtils.isEmpty(H.a().m)) {
                cVar.a(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, (Object) H.a().m);
            }
            Map<String, String> map = H.a().n;
            if (map != null) {
                for (String next : map.keySet()) {
                    cVar.a("custom_" + next, (Object) map.get(next));
                }
            }
        }
        h.e().b(cVar);
        Placement placement = this.t;
        if (placement != null) {
            this.m.onRewardedVideoAdRewarded(placement);
        } else {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
    }

    public final void f(ac acVar) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, acVar.d + ":onRewardedVideoAdClicked()", 1);
        if (this.t == null) {
            this.t = H.a().i.c.a.a();
        }
        if (this.t == null) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
            return;
        }
        a(1006, (C0149b) acVar, new Object[][]{new Object[]{"placement", p()}, new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(acVar.w)}});
        this.m.onRewardedVideoAdClicked(this.t);
    }

    public final void g() {
        Iterator it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            C0149b bVar = (C0149b) it.next();
            if (bVar.a == C0149b.a.CAPPED_PER_DAY) {
                a((int) IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, bVar, new Object[][]{new Object[]{"status", "false"}});
                bVar.a(C0149b.a.NOT_AVAILABLE);
                if (((ac) bVar).o() && bVar.c()) {
                    bVar.a(C0149b.a.AVAILABLE);
                    z = true;
                }
            }
        }
        if (z && a(true, false)) {
            this.m.onRewardedVideoAvailabilityChanged(true);
        }
    }

    public final void g(ac acVar) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, acVar.d + ":onRewardedVideoAdVisible()", 1);
        if (this.t != null) {
            a((int) IronSourceConstants.RV_INSTANCE_VISIBLE, (C0149b) acVar, new Object[][]{new Object[]{"placement", p()}, new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(acVar.w)}});
            return;
        }
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
    }
}
