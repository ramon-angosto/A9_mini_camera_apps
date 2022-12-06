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

public final class J extends Y implements RewardedVideoSmashListener {
    /* access modifiers changed from: package-private */
    public a a;
    String b;
    /* access modifiers changed from: private */
    public K j;
    private Timer k;
    private int l;
    private String m;
    private String n;
    private Placement o;
    private long p;
    private JSONObject q;
    private int r;
    private String s;
    private final Object t;
    private final Object u;
    private long v;

    public enum a {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public J(com.ironsource.mediationsdk.J r10, com.ironsource.mediationsdk.K r11, com.ironsource.mediationsdk.AbstractAdapter r12, int r13, java.lang.String r14, org.json.JSONObject r15, int r16, java.lang.String r17) {
        /*
            r9 = this;
            r8 = r9
            r0 = r10
            java.lang.String r1 = r0.m
            java.lang.String r2 = r0.n
            com.ironsource.mediationsdk.model.a r3 = r0.d
            com.ironsource.mediationsdk.model.NetworkSettings r3 = r3.a
            int r5 = r0.l
            r0 = r9
            r4 = r11
            r6 = r12
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r14
            r8.b = r0
            r0 = r15
            r8.q = r0
            r0 = r16
            r8.r = r0
            r0 = r17
            r8.s = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.J.<init>(com.ironsource.mediationsdk.J, com.ironsource.mediationsdk.K, com.ironsource.mediationsdk.AbstractAdapter, int, java.lang.String, org.json.JSONObject, int, java.lang.String):void");
    }

    public J(String str, String str2, NetworkSettings networkSettings, K k2, int i, AbstractAdapter abstractAdapter, int i2) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.t = new Object();
        this.u = new Object();
        this.m = str;
        this.n = str2;
        this.j = k2;
        this.k = null;
        this.l = i;
        this.c.updateRewardedVideoListener(this);
        this.h = i2;
        this.a = a.NO_INIT;
        this.v = 0;
        if (this.d.c) {
            c("initForBidding()");
            a(a.INIT_IN_PROGRESS);
            g();
            try {
                this.c.initRewardedVideoForBidding(this.m, this.n, this.f, this);
            } catch (Throwable th) {
                d("initForBidding exception: " + th.getLocalizedMessage());
                th.printStackTrace();
                onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INIT_EXCEPTION, th.getLocalizedMessage()));
            }
        }
    }

    private void a(int i) {
        a(i, (Object[][]) null, false);
    }

    private void a(int i, Object[][] objArr, boolean z) {
        Placement placement;
        Map<String, Object> n2 = n();
        if (!TextUtils.isEmpty(this.b)) {
            n2.put(IronSourceConstants.EVENTS_AUCTION_ID, this.b);
        }
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.length() > 0) {
            n2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.q);
        }
        if (z && (placement = this.o) != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            n2.put("placement", this.o.getPlacementName());
        }
        if (b(i)) {
            h.e();
            h.a(n2, this.r, this.s);
        }
        n2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.h));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    n2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, k() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        h.e().b(new c(i, new JSONObject(n2)));
        if (i == 1203) {
            o.a().a(1);
        }
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        c("current state=" + this.a + ", new state=" + aVar);
        synchronized (this.t) {
            this.a = aVar;
        }
    }

    private static boolean b(int i) {
        return i == 1001 || i == 1002 || i == 1200 || i == 1212 || i == 1213 || i == 1005 || i == 1203 || i == 1201 || i == 1202 || i == 1006 || i == 1010;
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvSmash " + k() + " " + hashCode() + "  : " + str, 0);
    }

    private void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvSmash " + k() + " " + hashCode() + " : " + str, 3);
    }

    private boolean f() {
        try {
            return this.c.isRewardedVideoAvailable(this.f);
        } catch (Exception e) {
            d("isRewardedVideoAvailable exception: " + e.getLocalizedMessage());
            e.printStackTrace();
            b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_isReadyException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e.getLocalizedMessage()}});
            return false;
        }
    }

    private void g() {
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
            c("setCustomParams() " + e.getMessage());
        }
    }

    private void q() {
        synchronized (this.u) {
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public long r() {
        return new Date().getTime() - this.p;
    }

    public final Map<String, Object> a() {
        try {
            if (h()) {
                return this.c.getRewardedVideoBiddingData(this.f);
            }
            return null;
        } catch (Throwable th) {
            d("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_biddingDataException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return null;
        }
    }

    public final void a(int i, Object[][] objArr) {
        a(i, objArr, true);
    }

    public final void a(Placement placement) {
        q();
        c("showVideo()");
        this.o = placement;
        a(a.SHOW_IN_PROGRESS);
        a((int) IronSourceConstants.RV_INSTANCE_SHOW, (Object[][]) null);
        try {
            this.c.showRewardedVideo(this.f, this);
        } catch (Throwable th) {
            d("showVideo exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public final void a(String str) {
        a aVar;
        c("loadVideo() auctionId: " + this.b + " state: " + this.a);
        this.i = null;
        this.e = false;
        synchronized (this.t) {
            aVar = this.a;
            if (!(this.a == a.LOAD_IN_PROGRESS || this.a == a.SHOW_IN_PROGRESS)) {
                a(a.LOAD_IN_PROGRESS);
            }
        }
        if (aVar == a.LOAD_IN_PROGRESS) {
            b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during load"}});
        } else if (aVar == a.SHOW_IN_PROGRESS) {
            b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during show"}});
        } else {
            synchronized (this.u) {
                this.k = new Timer();
                this.k.schedule(new TimerTask() {
                    public final void run() {
                        int i;
                        boolean z;
                        int i2;
                        String str = "Rewarded Video - load instance time out";
                        if (J.this.a == a.LOAD_IN_PROGRESS || J.this.a == a.INIT_IN_PROGRESS) {
                            if (J.this.a == a.LOAD_IN_PROGRESS) {
                                i2 = 1025;
                            } else {
                                i2 = IronSourceError.ERROR_RV_INIT_FAILED_TIMEOUT;
                                str = "Rewarded Video - init instance time out";
                            }
                            J.this.a(a.NOT_LOADED);
                            i = i2;
                            z = true;
                        } else {
                            z = false;
                            i = 0;
                        }
                        J.this.c(str);
                        if (z) {
                            J.this.b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(J.this.r())}});
                            J.this.b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(J.this.r())}});
                            J.this.j.b(J.this);
                            return;
                        }
                        J.this.b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(J.this.r())}, new Object[]{IronSourceConstants.EVENTS_EXT1, J.this.a.name()}});
                    }
                }, (long) (this.l * 1000));
            }
            this.p = new Date().getTime();
            a(1001);
            try {
                if (h()) {
                    this.c.loadRewardedVideoForBidding(this.f, this, str);
                    return;
                }
                g();
                this.c.initRewardedVideo(this.m, this.n, this.f, this);
            } catch (Throwable th) {
                d("loadVideo exception: " + th.getLocalizedMessage());
                th.printStackTrace();
                b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(h() ? IronSourceConstants.errorCode_loadException : IronSourceConstants.errorCode_initFailed)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            }
        }
    }

    public final void a(boolean z) {
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = z ? "true" : "false";
        objArr[0] = objArr2;
        a(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, objArr, true);
    }

    public final void b(int i, Object[][] objArr) {
        a(i, objArr, false);
    }

    public final boolean b() {
        return h() ? this.a == a.LOADED && f() : f();
    }

    public final void b_() {
        this.c.setMediationState(C0149b.a.CAPPED_PER_SESSION, IronSourceConstants.AD_UNIT_RV_MEDIATION_STATE);
        a(IronSourceConstants.RV_CAP_SESSION, (Object[][]) null, false);
    }

    public final LoadWhileShowSupportState c() {
        try {
            return this.c.getLoadWhileShowSupportState(this.f);
        } catch (Exception e) {
            d("Exception while calling adapter.getLoadWhileShowSupportState() - " + e.getLocalizedMessage());
            return LoadWhileShowSupportState.NONE;
        }
    }

    public final int e() {
        return 2;
    }

    public final void onRewardedVideoAdClicked() {
        c("onRewardedVideoAdClicked");
        this.j.b(this, this.o);
        a(1006, (Object[][]) null);
    }

    public final void onRewardedVideoAdClosed() {
        c("onRewardedVideoAdClosed");
        synchronized (this.t) {
            if (this.a != a.SHOW_IN_PROGRESS) {
                a((int) IronSourceConstants.RV_INSTANCE_CLOSED, (Object[][]) null);
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_adClosed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "adClosed: " + this.a}});
                return;
            }
            a(a.ENDED);
            this.v = new Date().getTime();
            this.j.d(this);
        }
    }

    public final void onRewardedVideoAdEnded() {
        c("onRewardedVideoAdEnded");
        this.j.f(this);
        a((int) IronSourceConstants.RV_INSTANCE_ENDED, (Object[][]) null);
    }

    public final void onRewardedVideoAdOpened() {
        c("onRewardedVideoAdOpened");
        this.j.c(this);
        a(1005, (Object[][]) null);
    }

    public final void onRewardedVideoAdRewarded() {
        c("onRewardedVideoAdRewarded");
        long time = new Date().getTime();
        this.j.a(this, this.o);
        Map<String, Object> n2 = n();
        Placement placement = this.o;
        if (placement != null) {
            n2.put("placement", placement.getPlacementName());
            n2.put(IronSourceConstants.EVENTS_REWARD_NAME, this.o.getRewardName());
            n2.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.o.getRewardAmount()));
        }
        if (!TextUtils.isEmpty(H.a().m)) {
            n2.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, H.a().m);
        }
        if (H.a().n != null) {
            for (String next : H.a().n.keySet()) {
                n2.put("custom_" + next, H.a().n.get(next));
            }
        }
        if (!TextUtils.isEmpty(this.b)) {
            n2.put(IronSourceConstants.EVENTS_AUCTION_ID, this.b);
        }
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.length() > 0) {
            n2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.q);
        }
        if (b(1010)) {
            h.e();
            h.a(n2, this.r, this.s);
        }
        n2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.h));
        c cVar = new c(1010, new JSONObject(n2));
        cVar.a(IronSourceConstants.EVENTS_TRANS_ID, (Object) IronSourceUtils.getTransId(cVar.b(), k()));
        long j2 = this.v;
        if (j2 != 0) {
            long j3 = time - j2;
            c("onRewardedVideoAdRewarded timeAfterClosed=" + j3);
            cVar.a(IronSourceConstants.EVENTS_DURATION, (Object) Long.valueOf(j3));
        }
        h.e().b(cVar);
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        c("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        a((int) IronSourceConstants.RV_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
        synchronized (this.t) {
            if (this.a != a.SHOW_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showFailed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "showFailed: " + this.a}});
                return;
            }
            a(a.ENDED);
            this.j.a(ironSourceError, this);
        }
    }

    public final void onRewardedVideoAdStarted() {
        c("onRewardedVideoAdStarted");
        this.j.e(this);
        a((int) IronSourceConstants.RV_INSTANCE_STARTED, (Object[][]) null);
    }

    public final void onRewardedVideoAdVisible() {
        c("onRewardedVideoAdVisible");
        a((int) IronSourceConstants.RV_INSTANCE_VISIBLE, (Object[][]) null);
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z) {
        boolean z2;
        c("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.a.name());
        synchronized (this.t) {
            if (this.a == a.LOAD_IN_PROGRESS) {
                a(z ? a.LOADED : a.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            q();
            b(z ? 1002 : IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r())}});
            if (z) {
                this.j.a(this);
            } else {
                this.j.b(this);
            }
        } else if (z) {
            b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.a.name()}});
        } else {
            b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.a.name()}});
        }
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        c("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage());
        q();
        b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r())}});
        b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r())}});
        synchronized (this.t) {
            if (this.a != a.INIT_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "initFailed: " + this.a}});
                return;
            }
            a(a.NO_INIT);
            this.j.b(this);
        }
    }

    public final void onRewardedVideoInitSuccess() {
        c("onRewardedVideoInitSuccess");
        synchronized (this.t) {
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
            a(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r())}}, false);
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.i = Long.valueOf(System.currentTimeMillis());
        }
        a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r())}}, false);
    }

    public final void onRewardedVideoLoadSuccess() {
    }
}
