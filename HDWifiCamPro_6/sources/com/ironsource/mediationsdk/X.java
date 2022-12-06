package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.mediationsdk.C0149b;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.o;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class X extends Y implements RewardedVideoSmashListener {
    private String A;
    private String B;
    private final Object C = new Object();
    /* access modifiers changed from: private */
    public final Object D = new Object();
    /* access modifiers changed from: package-private */
    public a a = a.NO_INIT;
    boolean b;
    /* access modifiers changed from: private */
    public W j;
    private Timer k;
    private int l;
    private String m;
    private String n;
    private String o;
    private boolean p;
    private boolean q;
    private Placement r;
    private long s;
    /* access modifiers changed from: private */
    public String t;
    private JSONObject u;
    private String v;
    private int w;
    private String x;
    private int y;
    private int z;

    public enum a {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public X(String str, String str2, NetworkSettings networkSettings, W w2, int i, AbstractAdapter abstractAdapter) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.m = str;
        this.n = str2;
        this.j = w2;
        this.k = null;
        this.l = i;
        this.c.addRewardedVideoListener(this);
        this.p = false;
        this.q = false;
        this.b = false;
        this.r = null;
        this.t = "";
        this.u = null;
        this.h = 1;
        g();
    }

    private void a(int i) {
        a(i, (Object[][]) null, false);
    }

    private void a(int i, Object[][] objArr, boolean z2) {
        Placement placement;
        Map<String, Object> n2 = n();
        if (!TextUtils.isEmpty(this.t)) {
            n2.put(IronSourceConstants.EVENTS_AUCTION_ID, this.t);
        }
        JSONObject jSONObject = this.u;
        if (jSONObject != null && jSONObject.length() > 0) {
            n2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.u);
        }
        if (z2 && (placement = this.r) != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            n2.put("placement", this.r.getPlacementName());
        }
        if (b(i)) {
            h.e();
            h.a(n2, this.w, this.x);
        }
        n2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.h));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    n2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, k() + " smash: RV sendMediationEvent " + Log.getStackTraceString(e), 3);
            }
        }
        h.e().b(new c(i, new JSONObject(n2)));
        if (i == 1203) {
            o.a().a(1);
        }
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        a("current state=" + this.a + ", new state=" + aVar);
        synchronized (this.D) {
            this.a = aVar;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvSmash " + k() + " : " + str, 0);
    }

    private void a(String str, String str2, int i, String str3, int i2, String str4) {
        this.v = str2;
        this.o = str;
        this.y = i;
        this.B = str3;
        this.z = i2;
        this.A = str4;
    }

    private static boolean b(int i) {
        return i == 1001 || i == 1002 || i == 1200 || i == 1213 || i == 1212 || i == 1005 || i == 1203 || i == 1201 || i == 1202 || i == 1006 || i == 1010;
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvSmash " + k() + " : " + str, 3);
    }

    private void g() {
        this.v = "";
        this.y = -1;
        this.B = "";
        this.o = "";
        this.z = this.h;
        this.A = "";
    }

    private boolean q() {
        try {
            return this.c.isRewardedVideoAvailable(this.f);
        } catch (Exception e) {
            c("isRewardedVideoAvailable exception: " + e.getLocalizedMessage());
            e.printStackTrace();
            b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_isReadyException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e.getLocalizedMessage()}});
            return false;
        }
    }

    private void r() {
        try {
            String str = H.a().l;
            if (!TextUtils.isEmpty(str)) {
                this.c.setMediationSegment(str);
            }
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                this.c.setPluginData(pluginType, ConfigFile.getConfigFile().getPluginFrameworkVersion());
            }
        } catch (Exception e) {
            a("setCustomParams() " + e.getMessage());
        }
    }

    private void s() {
        synchronized (this.C) {
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public long t() {
        return new Date().getTime() - this.s;
    }

    public final Map<String, Object> a() {
        try {
            if (h()) {
                return this.c.getRewardedVideoBiddingData(this.f);
            }
            return null;
        } catch (Throwable th) {
            c("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_biddingDataException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return null;
        }
    }

    public final void a(int i, Object[][] objArr) {
        a(i, objArr, true);
    }

    public final void a(Placement placement, int i) {
        s();
        a("showVideo()");
        this.r = placement;
        this.h = i;
        a(a.SHOW_IN_PROGRESS);
        a((int) IronSourceConstants.RV_INSTANCE_SHOW, (Object[][]) null);
        try {
            this.c.showRewardedVideo(this.f, this);
        } catch (Throwable th) {
            c("showVideo exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public final void a(String str, String str2, JSONObject jSONObject, int i, String str3, int i2, String str4) {
        a aVar;
        a("loadVideo() auctionId: " + str2 + " state: " + this.a);
        this.i = null;
        this.e = false;
        this.b = true;
        synchronized (this.D) {
            aVar = this.a;
            if (!(this.a == a.LOAD_IN_PROGRESS || this.a == a.SHOW_IN_PROGRESS)) {
                a(a.LOAD_IN_PROGRESS);
            }
        }
        if (aVar == a.LOAD_IN_PROGRESS) {
            b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during load"}});
            this.q = true;
            a(str, str2, i, str3, i2, str4);
            this.j.b(this, str2);
        } else if (aVar == a.SHOW_IN_PROGRESS) {
            b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during show"}});
            this.p = true;
            a(str, str2, i, str3, i2, str4);
        } else {
            this.g = str4;
            this.t = str2;
            this.u = jSONObject;
            this.w = i;
            this.x = str3;
            this.h = i2;
            synchronized (this.C) {
                s();
                this.k = new Timer();
                this.k.schedule(new TimerTask() {
                    public final void run() {
                        String str;
                        int i;
                        boolean z;
                        int i2;
                        synchronized (X.this.D) {
                            str = "Rewarded Video - load instance time out";
                            if (X.this.a != a.LOAD_IN_PROGRESS) {
                                if (X.this.a != a.INIT_IN_PROGRESS) {
                                    z = false;
                                    i = 0;
                                }
                            }
                            if (X.this.a == a.LOAD_IN_PROGRESS) {
                                i2 = 1025;
                            } else {
                                i2 = IronSourceError.ERROR_RV_INIT_FAILED_TIMEOUT;
                                str = "Rewarded Video - init instance time out";
                            }
                            X.this.a(a.NOT_LOADED);
                            i = i2;
                            z = true;
                        }
                        X.this.a(str);
                        if (z) {
                            X.this.b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(X.this.t())}});
                            X.this.b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(X.this.t())}});
                            W e = X.this.j;
                            X x = X.this;
                            e.b(x, x.t);
                            return;
                        }
                        X.this.b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(X.this.t())}, new Object[]{IronSourceConstants.EVENTS_EXT1, X.this.a.name()}});
                    }
                }, (long) (this.l * 1000));
            }
            this.s = new Date().getTime();
            a(1001);
            try {
                if (h()) {
                    this.c.loadRewardedVideoForBidding(this.f, this, str);
                } else if (aVar == a.NO_INIT) {
                    r();
                    this.c.initRewardedVideo(this.m, this.n, this.f, this);
                } else {
                    this.c.fetchRewardedVideoForAutomaticLoad(this.f, this);
                }
            } catch (Throwable th) {
                c("loadRewardedVideoForBidding exception: " + th.getLocalizedMessage());
                th.printStackTrace();
                onRewardedVideoLoadFailed(new IronSourceError(IronSourceError.ERROR_RV_LOAD_FAIL_UNEXPECTED, th.getLocalizedMessage()));
                b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            }
        }
    }

    public final void a(boolean z2, int i) {
        this.h = i;
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = z2 ? "true" : "false";
        objArr[0] = objArr2;
        a(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, objArr, true);
    }

    public final void b() {
        a("initForBidding()");
        a(a.INIT_IN_PROGRESS);
        r();
        try {
            this.c.initRewardedVideoForBidding(this.m, this.n, this.f, this);
        } catch (Throwable th) {
            c("initForBidding exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public final void b(int i, Object[][] objArr) {
        a(i, objArr, false);
    }

    public final boolean c() {
        return h() ? this.b && this.a == a.LOADED && q() : q();
    }

    public final void f() {
        this.c.setMediationState(C0149b.a.CAPPED_PER_SESSION, IronSourceConstants.AD_UNIT_RV_MEDIATION_STATE);
        a(IronSourceConstants.RV_CAP_SESSION, (Object[][]) null, false);
    }

    public final void onRewardedVideoAdClicked() {
        a("onRewardedVideoAdClicked");
        this.j.b(this, this.r);
        a(1006, (Object[][]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
        r12.j.b(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        if (r12.p == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
        a("onRewardedVideoAdClosed and mShouldLoadAfterClose is true - calling loadRewardedVideoForBidding");
        r12.p = false;
        a(r12.o, r12.v, r12.u, r12.y, r12.B, r12.z, r12.A);
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onRewardedVideoAdClosed() {
        /*
            r12 = this;
            java.lang.String r0 = "onRewardedVideoAdClosed"
            r12.a((java.lang.String) r0)
            java.lang.Object r0 = r12.D
            monitor-enter(r0)
            com.ironsource.mediationsdk.X$a r1 = r12.a     // Catch:{ all -> 0x0077 }
            com.ironsource.mediationsdk.X$a r2 = com.ironsource.mediationsdk.X.a.SHOW_IN_PROGRESS     // Catch:{ all -> 0x0077 }
            r3 = 0
            if (r1 == r2) goto L_0x004b
            r1 = 1203(0x4b3, float:1.686E-42)
            r2 = 0
            r12.a((int) r1, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x0077 }
            r1 = 81316(0x13da4, float:1.13948E-40)
            r2 = 2
            java.lang.Object[][] r4 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0077 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "errorCode"
            r5[r3] = r6     // Catch:{ all -> 0x0077 }
            r6 = 5009(0x1391, float:7.019E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0077 }
            r7 = 1
            r5[r7] = r6     // Catch:{ all -> 0x0077 }
            r4[r3] = r5     // Catch:{ all -> 0x0077 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = "reason"
            r2[r3] = r5     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = "adClosed: "
            r3.<init>(r5)     // Catch:{ all -> 0x0077 }
            com.ironsource.mediationsdk.X$a r5 = r12.a     // Catch:{ all -> 0x0077 }
            r3.append(r5)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0077 }
            r2[r7] = r3     // Catch:{ all -> 0x0077 }
            r4[r7] = r2     // Catch:{ all -> 0x0077 }
            r12.b(r1, r4)     // Catch:{ all -> 0x0077 }
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return
        L_0x004b:
            com.ironsource.mediationsdk.X$a r1 = com.ironsource.mediationsdk.X.a.NOT_LOADED     // Catch:{ all -> 0x0077 }
            r12.a((com.ironsource.mediationsdk.X.a) r1)     // Catch:{ all -> 0x0077 }
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            com.ironsource.mediationsdk.W r0 = r12.j
            r0.b(r12)
            boolean r0 = r12.p
            if (r0 == 0) goto L_0x0076
            java.lang.String r0 = "onRewardedVideoAdClosed and mShouldLoadAfterClose is true - calling loadRewardedVideoForBidding"
            r12.a((java.lang.String) r0)
            r12.p = r3
            java.lang.String r5 = r12.o
            java.lang.String r6 = r12.v
            org.json.JSONObject r7 = r12.u
            int r8 = r12.y
            java.lang.String r9 = r12.B
            int r10 = r12.z
            java.lang.String r11 = r12.A
            r4 = r12
            r4.a(r5, r6, r7, r8, r9, r10, r11)
            r12.g()
        L_0x0076:
            return
        L_0x0077:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.X.onRewardedVideoAdClosed():void");
    }

    public final void onRewardedVideoAdEnded() {
        a("onRewardedVideoAdEnded");
        this.j.d(this);
        a((int) IronSourceConstants.RV_INSTANCE_ENDED, (Object[][]) null);
    }

    public final void onRewardedVideoAdOpened() {
        a("onRewardedVideoAdOpened");
        this.j.a(this);
        a(1005, (Object[][]) null);
    }

    public final void onRewardedVideoAdRewarded() {
        a("onRewardedVideoAdRewarded");
        this.j.a(this, this.r);
        Map<String, Object> n2 = n();
        Placement placement = this.r;
        if (placement != null) {
            n2.put("placement", placement.getPlacementName());
            n2.put(IronSourceConstants.EVENTS_REWARD_NAME, this.r.getRewardName());
            n2.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.r.getRewardAmount()));
        }
        if (!TextUtils.isEmpty(H.a().m)) {
            n2.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, H.a().m);
        }
        if (H.a().n != null) {
            for (String next : H.a().n.keySet()) {
                n2.put("custom_" + next, H.a().n.get(next));
            }
        }
        if (!TextUtils.isEmpty(this.t)) {
            n2.put(IronSourceConstants.EVENTS_AUCTION_ID, this.t);
        }
        JSONObject jSONObject = this.u;
        if (jSONObject != null && jSONObject.length() > 0) {
            n2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.u);
        }
        if (b(1010)) {
            h.e();
            h.a(n2, this.w, this.x);
        }
        n2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.h));
        c cVar = new c(1010, new JSONObject(n2));
        cVar.a(IronSourceConstants.EVENTS_TRANS_ID, (Object) IronSourceUtils.getTransId(cVar.b(), k()));
        h.e().b(cVar);
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        a((int) IronSourceConstants.RV_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
        synchronized (this.D) {
            if (this.a != a.SHOW_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showFailed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "showFailed: " + this.a}});
                return;
            }
            a(a.NOT_LOADED);
            this.j.a(ironSourceError, this);
        }
    }

    public final void onRewardedVideoAdStarted() {
        a("onRewardedVideoAdStarted");
        this.j.c(this);
        a((int) IronSourceConstants.RV_INSTANCE_STARTED, (Object[][]) null);
    }

    public final void onRewardedVideoAdVisible() {
        a("onRewardedVideoAdVisible");
        a((int) IronSourceConstants.RV_INSTANCE_VISIBLE, (Object[][]) null);
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z2) {
        boolean z3;
        a("onRewardedVideoAvailabilityChanged available=" + z2 + " state=" + this.a.name());
        synchronized (this.D) {
            if (this.a == a.LOAD_IN_PROGRESS) {
                a(z2 ? a.LOADED : a.NOT_LOADED);
                z3 = false;
            } else {
                z3 = true;
            }
        }
        if (!z3) {
            s();
            b(z2 ? 1002 : IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(t())}});
            if (this.q) {
                this.q = false;
                a("onRewardedVideoAvailabilityChanged to " + z2 + "and mShouldLoadAfterLoad is true - calling loadVideo");
                a(this.o, this.v, this.u, this.y, this.B, this.z, this.A);
                g();
            } else if (z2) {
                this.j.a(this, this.t);
            } else {
                this.j.b(this, this.t);
            }
        } else if (z2) {
            b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.a.name()}});
        } else {
            b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(t())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.a.name()}});
        }
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage());
        s();
        b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(t())}});
        b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(t())}});
        synchronized (this.D) {
            if (this.a != a.INIT_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "initFailed: " + this.a}});
                return;
            }
            a(a.NO_INIT);
            this.j.b(this, this.t);
        }
    }

    public final void onRewardedVideoInitSuccess() {
        a("onRewardedVideoInitSuccess");
        synchronized (this.D) {
            if (this.a != a.INIT_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initSuccess)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "initSuccess: " + this.a}});
                return;
            }
            a(a.NOT_LOADED);
        }
    }

    public final void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(t())}}, false);
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.i = Long.valueOf(System.currentTimeMillis());
        }
        a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(t())}}, false);
    }

    public final void onRewardedVideoLoadSuccess() {
    }
}
