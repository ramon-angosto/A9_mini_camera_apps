package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.b.c;
import com.ironsource.mediationsdk.c.b;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.f;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.json.JSONObject;

public final class R extends Y implements c.a, BannerSmashListener {
    String a;
    private b b;
    private c j;
    private a k;
    private Q l;
    private IronSourceBannerLayout m;
    private JSONObject n;
    private int o;
    private String p;
    private f q;
    private final Object r;
    private com.ironsource.mediationsdk.utils.f s;
    private boolean t;

    public enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    R(b bVar, Q q2, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i, String str, JSONObject jSONObject, int i2, String str2, boolean z) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.r = new Object();
        this.k = R.a.NONE;
        this.b = bVar;
        this.j = new c(bVar.f());
        this.l = q2;
        this.h = i;
        this.a = str;
        this.o = i2;
        this.p = str2;
        this.n = jSONObject;
        this.t = z;
        this.c.addBannerListener(this);
        if (h()) {
            f();
        }
    }

    R(b bVar, Q q2, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i, boolean z) {
        this(bVar, q2, networkSettings, abstractAdapter, i, "", (JSONObject) null, 0, "", z);
    }

    private void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(r() + "state = " + aVar.name());
        synchronized (this.r) {
            this.k = aVar;
        }
    }

    private void a(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 606) {
            a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL : IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.s))}});
        } else {
            a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD_ERROR : IronSourceConstants.BN_INSTANCE_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.s))}});
        }
        Q q2 = this.l;
        if (q2 != null) {
            q2.a(ironSourceError, this);
        }
    }

    private void a(String str) {
        IronLog.INTERNAL.verbose(p());
        if (a(R.a.READY_TO_LOAD, R.a.LOADING)) {
            this.s = new com.ironsource.mediationsdk.utils.f();
            a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD : IronSourceConstants.BN_INSTANCE_LOAD, (Object[][]) null);
            if (this.c != null) {
                try {
                    if (h()) {
                        this.c.loadBannerForBidding(this.m, this.f, this, str);
                    } else {
                        this.c.loadBanner(this.m, this.f, this);
                    }
                } catch (Exception e) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.error("Exception while trying to load banner from " + this.c.getProviderName() + ", exception =  " + e.getLocalizedMessage());
                    e.printStackTrace();
                    onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, e.getLocalizedMessage()));
                    a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e.getLocalizedMessage()}});
                }
            }
        } else {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("wrong state - state = " + this.k);
        }
    }

    private static void a(Map<String, Object> map, ISBannerSize iSBannerSize) {
        int i;
        try {
            String description = iSBannerSize.getDescription();
            char c = 65535;
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        c = 2;
                        break;
                    }
                    break;
                case 72205083:
                    if (description.equals("LARGE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1999208305:
                    if (description.equals("CUSTOM")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                i = 1;
            } else if (c == 1) {
                i = 2;
            } else if (c == 2) {
                i = 3;
            } else if (c == 3) {
                i = 5;
            } else if (c == 4) {
                map.put("bannerAdSize", 6);
                map.put("custom_banner_size", iSBannerSize.getWidth() + "x" + iSBannerSize.getHeight());
                return;
            } else {
                return;
            }
            map.put("bannerAdSize", i);
        } catch (Exception e) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e));
        }
    }

    private static boolean a(int i) {
        return i == 3005 || i == 3002 || i == 3012 || i == 3015 || i == 3008 || i == 3305 || i == 3300 || i == 3306 || i == 3307 || i == 3302 || i == 3303 || i == 3304 || i == 3009;
    }

    private boolean a(a aVar, a aVar2) {
        boolean z;
        synchronized (this.r) {
            if (this.k == aVar) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(r() + "set state from '" + this.k + "' to '" + aVar2 + "'");
                z = true;
                this.k = aVar2;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void b(int i) {
        a(i, (Object[][]) null);
    }

    private void f() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(r() + "isBidder = " + h());
        a(R.a.INIT_IN_PROGRESS);
        g();
        try {
            if (this.c == null) {
                return;
            }
            if (h()) {
                this.c.initBannerForBidding(this.b.a(), this.b.b(), this.f, this);
            } else {
                this.c.initBanners(this.b.a(), this.b.b(), this.f, this);
            }
        } catch (Throwable th) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("Exception while trying to init banner from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
            onBannerInitFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, th.getLocalizedMessage()));
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
        }
    }

    private void g() {
        if (this.c != null) {
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
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("Exception while trying to set custom params from " + this.c.getProviderName() + ", exception =  " + e.getLocalizedMessage());
                e.printStackTrace();
                a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_internal)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e.getLocalizedMessage()}});
            }
        }
    }

    private boolean q() {
        boolean z;
        synchronized (this.r) {
            z = this.k == R.a.LOADED;
        }
        return z;
    }

    private String r() {
        return String.format("%s - ", new Object[]{p()});
    }

    private boolean s() {
        IronSourceBannerLayout ironSourceBannerLayout = this.m;
        return ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed();
    }

    public final void a() {
        IronLog.INTERNAL.verbose(p());
        a(R.a.DESTROYED);
        if (this.c == null) {
            IronLog.INTERNAL.warning("mAdapter == null");
            return;
        }
        try {
            this.c.destroyBanner(this.d.a.getBannerSettings());
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to destroy banner from " + this.c.getProviderName() + ", exception =  " + e.getLocalizedMessage());
            e.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_destroy)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e.getLocalizedMessage()}});
        }
        b(IronSourceConstants.BN_INSTANCE_DESTROY);
    }

    public final void a(int i, Object[][] objArr) {
        Map<String, Object> n2 = n();
        if (s()) {
            n2.put(IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed");
        } else {
            a(n2, this.m.getSize());
        }
        if (!TextUtils.isEmpty(this.a)) {
            n2.put(IronSourceConstants.EVENTS_AUCTION_ID, this.a);
        }
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.length() > 0) {
            n2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.n);
        }
        f fVar = this.q;
        if (fVar != null) {
            n2.put("placement", fVar.getPlacementName());
        }
        if (a(i)) {
            d.e();
            d.a(n2, this.o, this.p);
        }
        n2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.h));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    n2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error(k() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e));
            }
        }
        d.e().b(new com.ironsource.mediationsdk.a.c(i, new JSONObject(n2)));
    }

    public final void a(IronSourceBannerLayout ironSourceBannerLayout, f fVar, String str) {
        Q q2;
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose(p());
        this.q = fVar;
        if (!C0160m.a(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            IronLog.INTERNAL.verbose(str2);
            q2 = this.l;
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, str2);
        } else if (this.c == null) {
            IronLog.INTERNAL.verbose("mAdapter is null");
            q2 = this.l;
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_ADAPTER, "mAdapter is null");
        } else {
            this.m = ironSourceBannerLayout;
            this.j.a(this);
            try {
                if (h()) {
                    a(str);
                    return;
                } else {
                    f();
                    return;
                }
            } catch (Throwable th) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("exception = " + th.getLocalizedMessage());
                th.printStackTrace();
                onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, th.getLocalizedMessage()));
                return;
            }
        }
        q2.a(ironSourceError, this);
    }

    public final void b() {
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose(p());
        if (a(R.a.INIT_IN_PROGRESS, R.a.LOAD_FAILED)) {
            IronLog.INTERNAL.verbose("init timed out");
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, "Timed out");
        } else if (a(R.a.LOADING, R.a.LOAD_FAILED)) {
            IronLog.INTERNAL.verbose("load timed out");
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_TIMEOUT, "Timed out");
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("unexpected state - " + this.k);
            return;
        }
        a(ironSourceError);
    }

    public final Map<String, Object> c() {
        try {
            if (!h() || this.c == null) {
                return null;
            }
            return this.c.getBannerBiddingData(this.f);
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to getBannerBiddingData from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_biddingDataException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return null;
        }
    }

    public final void d() {
        this.j.c();
        super.d();
    }

    public final void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(p());
        a((int) IronSourceConstants.BN_INSTANCE_CLICK, (Object[][]) null);
        Q q2 = this.l;
        if (q2 != null) {
            q2.a(this);
        }
    }

    public final void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(p());
        a((int) IronSourceConstants.BN_INSTANCE_LEAVE_APP, (Object[][]) null);
        Q q2 = this.l;
        if (q2 != null) {
            q2.d(this);
        }
    }

    public final void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(r() + "error = " + ironSourceError);
        this.j.d();
        if (a(R.a.LOADING, R.a.LOAD_FAILED)) {
            a(ironSourceError);
        }
    }

    public final void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(p());
        this.j.d();
        if (a(R.a.LOADING, R.a.LOADED)) {
            a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS : IronSourceConstants.BN_INSTANCE_LOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.s))}});
            Q q2 = this.l;
            if (q2 != null) {
                q2.a(this, view, layoutParams);
                return;
            }
            return;
        }
        a(this.t ? IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS, (Object[][]) null);
    }

    public final void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(p());
        a((int) IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN, (Object[][]) null);
        Q q2 = this.l;
        if (q2 != null) {
            q2.b(this);
        }
    }

    public final void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(p());
        a((int) IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN, (Object[][]) null);
        Q q2 = this.l;
        if (q2 != null) {
            q2.c(this);
        }
    }

    public final void onBannerAdShown() {
        IronLog.INTERNAL.verbose(p());
        if (q()) {
            a((int) IronSourceConstants.BN_INSTANCE_SHOW, (Object[][]) null);
            Q q2 = this.l;
            if (q2 != null) {
                q2.e(this);
                return;
            }
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("wrong state - mState = " + this.k);
        Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1};
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong State - " + this.k}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
    }

    public final void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(r() + "error = " + ironSourceError);
        this.j.d();
        if (a(R.a.INIT_IN_PROGRESS, R.a.NONE)) {
            Q q2 = this.l;
            if (q2 != null) {
                q2.a(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, "Banner init failed"), this);
                return;
            }
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.warning("wrong state - mState = " + this.k);
    }

    public final void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(p());
        if (a(R.a.INIT_IN_PROGRESS, R.a.READY_TO_LOAD) && !h()) {
            if (!C0160m.a(this.m)) {
                this.l.a(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, this.m == null ? "banner is null" : "banner is destroyed"), this);
            } else {
                a((String) null);
            }
        }
    }
}
