package com.ironsource.mediationsdk.adunit.d.a;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0153f;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.adunit.b.d;
import com.ironsource.mediationsdk.adunit.c.a.b;
import com.ironsource.mediationsdk.b.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.f;
import com.ironsource.mediationsdk.utils.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c<Listener extends b> implements AdapterAdListener, NetworkInitializationListener, com.ironsource.mediationsdk.adunit.b.c, c.a, n.a {
    protected com.ironsource.mediationsdk.adunit.d.a a;
    protected Listener b;
    protected d c = new d(this.a.a, d.b.PROVIDER, this);
    protected a d;
    protected Placement e;
    protected AdData f;
    private BaseAdAdapter<?, AdapterAdListener> g;
    private com.ironsource.mediationsdk.model.a h;
    private JSONObject i;
    private String j;
    private Long k;
    private f l;
    private com.ironsource.mediationsdk.b.c m;

    public enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        SHOWING,
        FAILED
    }

    public c(com.ironsource.mediationsdk.adunit.d.a aVar, BaseAdAdapter<?, ?> baseAdAdapter, com.ironsource.mediationsdk.model.a aVar2, Listener listener) {
        this.a = aVar;
        this.b = listener;
        this.h = aVar2;
        this.i = aVar2.b;
        this.g = baseAdAdapter;
        this.m = new com.ironsource.mediationsdk.b.c((long) (this.a.d * 1000));
        a(a.NONE);
    }

    private boolean a() {
        return this.d == a.INIT_IN_PROGRESS;
    }

    public final Map<String, Object> a(com.ironsource.mediationsdk.adunit.b.b bVar) {
        HashMap hashMap = new HashMap();
        try {
            String str = "";
            hashMap.put("providerAdapterVersion", this.g != null ? this.g.getNetworkAdapter().getAdapterVersion() : str);
            if (this.g != null) {
                str = this.g.getNetworkAdapter().getNetworkSDKVersion();
            }
            hashMap.put("providerSDKVersion", str);
        } catch (Exception unused) {
            IronLog.INTERNAL.error(c("could not get adapter version for event data" + l()));
        }
        hashMap.put("spId", this.h.a.getSubProviderId());
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.h.a.getAdSourceNameForEvents());
        boolean z = true;
        hashMap.put("instanceType", Integer.valueOf(h() ? 2 : 1));
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        if (!TextUtils.isEmpty(this.j)) {
            hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.j);
        }
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.a.e));
        if (this.a.f != null && this.a.f.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.a.f);
        }
        if (!TextUtils.isEmpty(this.a.g)) {
            hashMap.put(IronSourceConstants.EVENTS_AUCTION_ID, this.a.g);
        }
        if (!(bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_SUCCESS || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_FAILED_WITH_REASON || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_NO_FILL || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_OPENED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_CLOSED || bVar == com.ironsource.mediationsdk.adunit.b.b.SHOW_AD || bVar == com.ironsource.mediationsdk.adunit.b.b.SHOW_AD_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_CLICKED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_REWARDED)) {
            z = false;
        }
        if (z) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.a.h));
            if (!TextUtils.isEmpty(this.a.i)) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.a.i);
            }
        }
        if (!TextUtils.isEmpty(this.a.c.getCustomNetwork())) {
            hashMap.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, this.a.c.getCustomNetwork());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(c("to " + aVar));
        this.d = aVar;
    }

    public final void a(String str) {
        try {
            IronLog.INTERNAL.verbose(c(""));
            this.c.b.a(false);
            this.k = null;
            this.l = new f();
            HashMap hashMap = new HashMap();
            hashMap.put("userId", this.a.b);
            hashMap.putAll(com.ironsource.mediationsdk.c.b.a(this.i));
            this.f = new AdData(str, hashMap);
            a(a.INIT_IN_PROGRESS);
            this.m.a(this);
            AdapterBaseInterface networkAdapter = this.g.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.f, ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str2 = "loadAd - network adapter not available " + l();
            IronLog.INTERNAL.error(c(str2));
            this.c.e.a(str2);
            onInitFailed(com.ironsource.mediationsdk.adunit.a.a.a(this.a.a), str2);
        } catch (Throwable th) {
            String str3 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(c(str3));
            d dVar = this.c;
            if (dVar != null) {
                dVar.e.l(str3);
            }
            onInitFailed(com.ironsource.mediationsdk.adunit.a.a.a(this.a.a), str3);
        }
    }

    public final void b() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(c("state = " + this.d + ", isBidder = " + h()));
        long a2 = f.a(this.l);
        if (c()) {
            a(a.FAILED);
            d dVar = this.c;
            if (dVar != null) {
                dVar.b.a(a2, 1025, "time out");
                this.c.b.b(a2, 1025, "time out");
            }
            Listener listener = this.b;
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("timed out");
            f.a(this.l);
            listener.a(buildLoadFailedError, this);
            return;
        }
        String format = String.format("unexpected timeout for %s, state - %s, error - %s", new Object[]{l(), this.d, 1025});
        d dVar2 = this.c;
        if (dVar2 != null) {
            dVar2.e.k(format);
        }
    }

    public final void b(String str) {
        C0153f.a();
        this.j = C0153f.d(str);
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        String str2 = this.a.a.name() + " - " + l() + " - state = " + this.d;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + " - " + str;
    }

    public final boolean c() {
        return this.d == a.INIT_IN_PROGRESS || this.d == a.LOADING;
    }

    public final boolean d() {
        return this.d == a.LOADED;
    }

    public final boolean e() {
        return this.d != a.FAILED;
    }

    public final void f() {
        IronLog.INTERNAL.verbose(c(""));
        d dVar = this.c;
        if (dVar != null) {
            dVar.d.a();
        }
    }

    public final Long g() {
        return this.k;
    }

    public final boolean h() {
        return this.h.c;
    }

    public final int i() {
        return this.h.d;
    }

    public final int j() {
        return this.h.e;
    }

    public final String k() {
        return this.h.a.getProviderName();
    }

    public final String l() {
        return String.format("%s %s", new Object[]{k(), Integer.valueOf(hashCode())});
    }

    public final String m() {
        return this.h.a.getProviderTypeForReflection();
    }

    public final String n() {
        return this.a.g;
    }

    public final void o() {
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.g;
        if (baseAdAdapter != null) {
            try {
                baseAdAdapter.releaseMemory();
                this.g = null;
            } catch (Exception e2) {
                String str = "Exception while calling adapter.releaseMemory() from " + this.h.a.getProviderName() + " - " + e2.getLocalizedMessage();
                IronLog.INTERNAL.error(c(str));
                this.c.e.l(str);
            }
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.a();
            this.c = null;
        }
        com.ironsource.mediationsdk.b.c cVar = this.m;
        if (cVar != null) {
            cVar.c();
            this.m = null;
        }
    }

    public void onAdClicked() {
        IronLog.INTERNAL.verbose(c(""));
        d dVar = this.c;
        if (dVar != null) {
            dVar.d.d(q());
        }
        this.b.b(this);
    }

    public void onAdLoadFailed(AdapterErrorType adapterErrorType, int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(c("error = " + i2 + ", " + str));
        com.ironsource.mediationsdk.b.c cVar = this.m;
        if (cVar != null) {
            cVar.d();
        }
        if (this.d == a.LOADING) {
            long a2 = f.a(this.l);
            if (this.c != null) {
                if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
                    this.c.b.a(a2, i2);
                } else {
                    if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED) {
                        this.k = Long.valueOf(System.currentTimeMillis());
                    }
                    this.c.b.a(a2, i2, str);
                    this.c.b.b(a2, i2, str);
                }
            }
            a(a.FAILED);
            this.b.a(new IronSourceError(i2, str), this);
        }
        if (this.d != a.FAILED) {
            String format = String.format("unexpected load failed for %s, state - %s, error - %s, %s", new Object[]{l(), this.d, Integer.valueOf(i2), str});
            d dVar = this.c;
            if (dVar != null) {
                dVar.e.j(format);
            }
        }
    }

    public void onAdLoadSuccess() {
        IronLog.INTERNAL.verbose(c(""));
        com.ironsource.mediationsdk.b.c cVar = this.m;
        if (cVar != null) {
            cVar.d();
        }
        if (this.d == a.LOADING) {
            long a2 = f.a(this.l);
            d dVar = this.c;
            if (dVar != null) {
                dVar.b.a(a2, false);
            }
            a(a.LOADED);
            this.b.a(this);
        } else if (this.d != a.FAILED) {
            String format = String.format("unexpected load success for %s, state - %s", new Object[]{l(), this.d});
            d dVar2 = this.c;
            if (dVar2 != null) {
                dVar2.e.i(format);
            }
        }
    }

    public void onInitFailed(int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(c("error = " + i2 + ", " + str));
        if (a()) {
            com.ironsource.mediationsdk.b.c cVar = this.m;
            if (cVar != null) {
                cVar.d();
            }
            a(a.FAILED);
            Listener listener = this.b;
            IronSourceError ironSourceError = new IronSourceError(i2, str);
            f.a(this.l);
            listener.a(ironSourceError, this);
        } else if (this.d != a.FAILED) {
            String format = String.format("unexpected init failed for %s, state - %s, error - %s, %s", new Object[]{l(), this.d, Integer.valueOf(i2), str});
            d dVar = this.c;
            if (dVar != null) {
                dVar.e.f(format);
            }
        }
    }

    public void onInitSuccess() {
        IronLog.INTERNAL.verbose(c(""));
        if (a()) {
            com.ironsource.mediationsdk.b.c cVar = this.m;
            if (cVar != null) {
                cVar.d();
            }
            a(a.READY_TO_LOAD);
            IronLog.INTERNAL.verbose(c(""));
            a(a.LOADING);
            try {
                this.m.a(this);
                this.g.loadAd(this.f, ContextProvider.getInstance().getCurrentActiveActivity(), this);
            } catch (Throwable th) {
                String str = "unexpected error while calling adapter.loadAd() - " + th.getLocalizedMessage();
                IronLog.INTERNAL.error(c(str));
                d dVar = this.c;
                if (dVar != null) {
                    dVar.e.l(str);
                }
                onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, IronSourceError.ERROR_CODE_GENERIC, str);
            }
        } else if (this.d != a.FAILED) {
            String format = String.format("unexpected init success for %s, state - %s", new Object[]{l(), this.d});
            d dVar2 = this.c;
            if (dVar2 != null) {
                dVar2.e.e(format);
            }
        }
    }

    public final boolean p() {
        return this.d == a.SHOWING;
    }

    /* access modifiers changed from: protected */
    public final String q() {
        Placement placement = this.e;
        return placement == null ? "" : placement.getPlacementName();
    }
}
