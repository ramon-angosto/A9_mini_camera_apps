package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0156i;
import com.ironsource.mediationsdk.C0160m;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.b.b;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.f;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.mediationsdk.utils.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public final class P extends C0161n implements Q, b.a, C0154g {
    com.ironsource.mediationsdk.c.b c;
    b d;
    IronSourceBannerLayout e;
    f f;
    R g;
    int h;
    final ConcurrentHashMap<String, R> i;
    C0155h j;
    C0156i k;
    ConcurrentHashMap<String, C0156i.a> l;
    long m;
    private a n = a.NONE;
    private int o;
    private CopyOnWriteArrayList<R> p;
    private String q;
    private JSONObject r;
    private String s = "";
    private int t;
    private com.ironsource.mediationsdk.server.b u;
    private ConcurrentHashMap<String, com.ironsource.mediationsdk.server.b> v;
    private final Object w = new Object();
    private com.ironsource.mediationsdk.utils.f x;

    enum a {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    public P(List<NetworkSettings> list, com.ironsource.mediationsdk.c.b bVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("isAuctionEnabled = " + bVar.c());
        this.c = bVar;
        this.d = new b(this.c.g());
        this.i = new ConcurrentHashMap<>();
        this.p = new CopyOnWriteArrayList<>();
        this.v = new ConcurrentHashMap<>();
        this.l = new ConcurrentHashMap<>();
        this.h = o.a().b(3);
        C0157j.a().a = this.c.e();
        if (this.c.c()) {
            this.j = new C0155h("banner", this.c.h(), this);
        }
        a(list);
        b(list);
        this.m = new Date().getTime();
        a(a.READY_TO_LOAD);
    }

    static /* synthetic */ ISBannerSize a(P p2) {
        IronSourceBannerLayout ironSourceBannerLayout = p2.e;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return p2.e.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getCurrentActiveActivity()) ? ISBannerSize.a : ISBannerSize.BANNER : p2.e.getSize();
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object[][] objArr) {
        a(i2, objArr, this.h);
    }

    private void a(R r2, com.ironsource.mediationsdk.server.b bVar) {
        C0155h.a(bVar, r2.i(), this.u, e());
        a(this.v.get(r2.k()), e());
    }

    private void a(List<NetworkSettings> list) {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings providerName : list) {
            arrayList.add(providerName.getProviderName());
        }
        this.k = new C0156i(arrayList, this.c.h().f);
    }

    private static void a(JSONObject jSONObject, ISBannerSize iSBannerSize) {
        try {
            String description = iSBannerSize.getDescription();
            char c2 = 65535;
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 72205083:
                    if (description.equals("LARGE")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1999208305:
                    if (description.equals("CUSTOM")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                jSONObject.put("bannerAdSize", 1);
            } else if (c2 == 1) {
                jSONObject.put("bannerAdSize", 2);
            } else if (c2 == 2) {
                jSONObject.put("bannerAdSize", 3);
            } else if (c2 == 3) {
                jSONObject.put("bannerAdSize", 5);
            } else if (c2 == 4) {
                jSONObject.put("bannerAdSize", 6);
                jSONObject.put("custom_banner_size", iSBannerSize.getWidth() + "x" + iSBannerSize.getHeight());
            }
            if (iSBannerSize.isAdaptive()) {
                String str = "Adaptive=true";
                if (jSONObject.has(IronSourceConstants.EVENTS_EXT1)) {
                    str = jSONObject.optString(IronSourceConstants.EVENTS_EXT1) + " , Adaptive=true";
                }
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, str);
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.n);
        if (a(a.STARTED_LOADING, this.c.c() ? z ? a.AUCTION : a.FIRST_AUCTION : z ? a.RELOADING : a.LOADING)) {
            this.x = new com.ironsource.mediationsdk.utils.f();
            this.q = "";
            this.r = null;
            this.o = 0;
            this.h = o.a().b(3);
            a(z ? IronSourceConstants.BN_RELOAD : 3001, (Object[][]) null);
            if (this.c.c()) {
                d();
                return;
            }
            g();
            f();
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.error("wrong state - " + this.n);
    }

    private void b(List<NetworkSettings> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            NetworkSettings networkSettings = list.get(i2);
            AbstractAdapter a2 = C0151d.a().a(networkSettings, networkSettings.getBannerSettings(), false, false);
            if (a2 != null) {
                R r2 = new R(this.c, this, networkSettings, a2, this.h, n());
                this.i.put(r2.k(), r2);
            } else {
                IronLog.INTERNAL.verbose(networkSettings.getProviderInstanceName() + " can't load adapter");
            }
        }
    }

    private static boolean b(int i2) {
        return i2 == 3201 || i2 == 3110 || i2 == 3111 || i2 == 3116 || i2 == 3119 || i2 == 3112 || i2 == 3115 || i2 == 3501 || i2 == 3502 || i2 == 3506;
    }

    private String c(List<com.ironsource.mediationsdk.server.b> list) {
        int i2;
        int i3;
        IronLog.INTERNAL.verbose("waterfall.size() = " + list.size());
        this.p.clear();
        this.v.clear();
        this.l.clear();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (i4 < list.size()) {
            com.ironsource.mediationsdk.server.b bVar = list.get(i4);
            R r2 = this.i.get(bVar.a());
            if (r2 != null) {
                AbstractAdapter a2 = C0151d.a().a(r2.d.a);
                if (a2 != null) {
                    R r3 = r0;
                    i2 = i4;
                    i3 = 1;
                    R r4 = new R(this.c, this, r2.d.a, a2, this.h, this.q, this.r, this.t, this.s, n());
                    r3.e = true;
                    this.p.add(r3);
                    this.v.put(r3.k(), bVar);
                    this.l.put(bVar.a(), C0156i.a.ISAuctionPerformanceDidntAttemptToLoad);
                } else {
                    i2 = i4;
                    i3 = 1;
                }
            } else {
                i2 = i4;
                i3 = 1;
                IronLog.INTERNAL.error("could not find matching smash for auction response item - item = " + bVar.a());
            }
            R r5 = this.i.get(bVar.a());
            String str = "1";
            if (r5 == null ? !TextUtils.isEmpty(bVar.b()) : r5.h()) {
                str = "2";
            }
            sb.append(str + bVar.a());
            int i5 = i2;
            if (i5 != list.size() - i3) {
                sb.append(",");
            }
            i4 = i5 + 1;
        }
        IronLog.INTERNAL.verbose("updateWaterfall() - next waterfall is " + sb.toString());
        return sb.toString();
    }

    private void f() {
        int i2 = this.o;
        while (true) {
            String str = null;
            if (i2 < this.p.size()) {
                R r2 = this.p.get(i2);
                if (r2.e) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("loading smash - " + r2.p());
                    this.o = i2 + 1;
                    IronSourceBannerLayout ironSourceBannerLayout = this.e;
                    if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
                        if (r2.h()) {
                            str = this.v.get(r2.k()).b();
                            r2.b(str);
                        }
                        r2.a(this.e.a(), this.f, str);
                        return;
                    }
                    return;
                }
                i2++;
            } else {
                String str2 = this.p.isEmpty() ? "Empty waterfall" : "Mediation No fill";
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("errorReason = " + str2);
                f((R) null);
                if (a(a.LOADING, a.READY_TO_LOAD)) {
                    a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_LOAD_NO_FILL)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.x))}});
                    C0157j.a().a(this.e, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_FILL, str2));
                    return;
                } else if (a(a.RELOADING, a.LOADED)) {
                    a((int) IronSourceConstants.BN_RELOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.x))}});
                    this.d.a(this);
                    return;
                } else {
                    a(a.READY_TO_LOAD);
                    IronLog ironLog3 = IronLog.INTERNAL;
                    ironLog3.error("wrong state = " + this.n);
                    return;
                }
            }
        }
    }

    private void f(R r2) {
        Iterator<R> it = this.p.iterator();
        while (it.hasNext()) {
            R next = it.next();
            if (!next.equals(r2)) {
                next.d();
            }
        }
    }

    private void g() {
        List<com.ironsource.mediationsdk.server.b> h2 = h();
        this.q = c();
        c(h2);
    }

    private List<com.ironsource.mediationsdk.server.b> h() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (R next : this.i.values()) {
            if (!next.h() && !k.b((Context) ContextProvider.getInstance().getCurrentActiveActivity(), e())) {
                copyOnWriteArrayList.add(new com.ironsource.mediationsdk.server.b(next.k()));
            }
        }
        return copyOnWriteArrayList;
    }

    private boolean i() {
        IronSourceBannerLayout ironSourceBannerLayout = this.e;
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    private ISBannerSize j() {
        IronSourceBannerLayout ironSourceBannerLayout = this.e;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.getSize();
        }
        return null;
    }

    private boolean k() {
        boolean z;
        synchronized (this.w) {
            if (this.n != a.LOADING) {
                if (this.n != a.RELOADING) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private boolean l() {
        boolean z;
        synchronized (this.w) {
            if (this.n != a.FIRST_AUCTION) {
                if (this.n != a.AUCTION) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private boolean m() {
        boolean z;
        synchronized (this.w) {
            z = this.n == a.LOADED;
        }
        return z;
    }

    private boolean n() {
        return this.n == a.RELOADING || this.n == a.AUCTION;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r6 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = "checking with IronsourceLifecycleManager if app in foreground"
            r0.verbose(r1)
            com.ironsource.lifecycle.d r0 = com.ironsource.lifecycle.d.a()
            boolean r0 = r0.b()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0089
            com.ironsource.mediationsdk.IronSourceBannerLayout r0 = r6.e
            if (r0 != 0) goto L_0x0020
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r3 = "banner is null"
        L_0x001b:
            r0.verbose(r3)
            r0 = r2
            goto L_0x0056
        L_0x0020:
            boolean r0 = r0.isShown()
            if (r0 != 0) goto L_0x002b
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r3 = "banner or one of its parents are INVISIBLE or GONE"
            goto L_0x001b
        L_0x002b:
            com.ironsource.mediationsdk.IronSourceBannerLayout r0 = r6.e
            boolean r0 = r0.hasWindowFocus()
            if (r0 != 0) goto L_0x0038
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r3 = "banner has no window focus"
            goto L_0x001b
        L_0x0038:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            com.ironsource.mediationsdk.IronSourceBannerLayout r3 = r6.e
            boolean r0 = r3.getGlobalVisibleRect(r0)
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "visible = "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.verbose(r4)
        L_0x0056:
            if (r0 == 0) goto L_0x0086
            com.ironsource.mediationsdk.P$a r0 = com.ironsource.mediationsdk.P.a.LOADED
            com.ironsource.mediationsdk.P$a r3 = com.ironsource.mediationsdk.P.a.STARTED_LOADING
            boolean r0 = r6.a((com.ironsource.mediationsdk.P.a) r0, (com.ironsource.mediationsdk.P.a) r3)
            if (r0 == 0) goto L_0x006d
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r3 = "start loading"
            r0.verbose(r3)
            r6.a((boolean) r1)
            goto L_0x0082
        L_0x006d:
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "wrong state = "
            r3.<init>(r4)
            com.ironsource.mediationsdk.P$a r4 = r6.n
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.error(r3)
        L_0x0082:
            r0 = 0
            r3 = r0
            r0 = r2
            goto L_0x008d
        L_0x0086:
            java.lang.String r0 = "banner is not visible - start reload timer"
            goto L_0x008b
        L_0x0089:
            java.lang.String r0 = "app in background - start reload timer"
        L_0x008b:
            r3 = r0
            r0 = r1
        L_0x008d:
            if (r0 == 0) goto L_0x00b1
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r0.verbose(r3)
            r0 = 3200(0xc80, float:4.484E-42)
            java.lang.Object[][] r3 = new java.lang.Object[r1][]
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "errorCode"
            r4[r2] = r5
            r5 = 614(0x266, float:8.6E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r1] = r5
            r3[r2] = r4
            r6.a((int) r0, (java.lang.Object[][]) r3)
            com.ironsource.mediationsdk.b.b r0 = r6.d
            r0.a(r6)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.P.a():void");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a(i2, (Object[][]) null);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        IronLog.INTERNAL.verbose(str3);
        IronSourceUtils.sendAutomationLog("BN: " + str3);
        if (l()) {
            this.s = str2;
            this.t = i3;
            this.r = null;
            g();
            a((int) IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}});
            a(this.n == a.FIRST_AUCTION ? a.LOADING : a.RELOADING);
            f();
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mCurrentState = " + this.n);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Object[][] objArr, int i3) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        try {
            ISBannerSize j2 = j();
            if (j2 != null) {
                a(mediationAdditionalData, j2);
            }
            if (this.f != null) {
                mediationAdditionalData.put("placement", e());
            }
            mediationAdditionalData.put(IronSourceConstants.KEY_SESSION_DEPTH, i3);
            if (!TextUtils.isEmpty(this.q)) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_AUCTION_ID, this.q);
            }
            if (this.r != null && this.r.length() > 0) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.r);
            }
            if (b(i2)) {
                mediationAdditionalData.put(IronSourceConstants.AUCTION_TRIALS, this.t);
                if (!TextUtils.isEmpty(this.s)) {
                    mediationAdditionalData.put(IronSourceConstants.AUCTION_FALLBACK, this.s);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
        d.e().b(new c(i2, mediationAdditionalData));
    }

    public final void a(final IronSourceBannerLayout ironSourceBannerLayout, final f fVar) {
        IronLog.INTERNAL.verbose("");
        a(IronSource.AD_UNIT.BANNER);
        if (!a(a.READY_TO_LOAD, a.STARTED_LOADING)) {
            IronLog.API.error("can't load banner - loadBanner already called and still in progress");
        } else if (!C0157j.a().b()) {
            AnonymousClass1 r0 = new C0160m.b() {
                public final void a() {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("placement = " + fVar.getPlacementName());
                    P p = P.this;
                    p.e = ironSourceBannerLayout;
                    p.f = fVar;
                    if (k.b((Context) ContextProvider.getInstance().getCurrentActiveActivity(), fVar.getPlacementName())) {
                        IronLog.INTERNAL.verbose("placement is capped");
                        C0157j a2 = C0157j.a();
                        IronSourceBannerLayout ironSourceBannerLayout = ironSourceBannerLayout;
                        a2.a(ironSourceBannerLayout, new IronSourceError(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED, "placement " + fVar.getPlacementName() + " is capped"));
                        P.this.a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED)}});
                        P.this.a(a.READY_TO_LOAD);
                        return;
                    }
                    P.this.a(false);
                }

                public final void a(String str) {
                    IronLog ironLog = IronLog.API;
                    ironLog.error("can't load banner - errorMessage = " + str);
                }
            };
            String str = null;
            if (!C0160m.a(ironSourceBannerLayout)) {
                Object[] objArr = new Object[1];
                objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
                str = String.format("can't load banner - %s", objArr);
            }
            if (fVar == null || TextUtils.isEmpty(fVar.getPlacementName())) {
                Object[] objArr2 = new Object[1];
                objArr2[0] = fVar == null ? "placement is null" : "placement name is empty";
                str = String.format("can't load banner - %s", objArr2);
            }
            if (!TextUtils.isEmpty(str)) {
                IronLog.INTERNAL.error(str);
                r0.a(str);
                return;
            }
            r0.a();
        } else {
            IronLog.INTERNAL.verbose("can't load banner - already has pending invocation");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("from '" + this.n + "' to '" + aVar + "'");
        synchronized (this.w) {
            this.n = aVar;
        }
    }

    public final void a(R r2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(r2.p());
        if (i()) {
            this.e.c();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_CLICK, objArr, r2.m());
    }

    public final void a(R r2, View view, FrameLayout.LayoutParams layoutParams) {
        Object[][] objArr;
        R r3 = r2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + r2.p());
        if (r3.a != this.q) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("invoked with auctionId: " + r3.a + " and the current id is " + this.q);
            Object[] objArr2 = {IronSourceConstants.EVENTS_ERROR_CODE, 2};
            r3.a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{objArr2, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong auction id " + r3.a + " State - " + this.n}, new Object[]{IronSourceConstants.EVENTS_EXT1, r2.k()}});
        } else if (k()) {
            R r4 = this.g;
            if (r4 != null) {
                r4.d();
            }
            f(r2);
            this.g = r3;
            IronSourceBannerLayout ironSourceBannerLayout = this.e;
            if (ironSourceBannerLayout != null) {
                ironSourceBannerLayout.a(view, layoutParams);
            }
            this.l.put(r2.k(), C0156i.a.ISAuctionPerformanceShowedSuccessfully);
            if (this.c.c()) {
                com.ironsource.mediationsdk.server.b bVar = this.v.get(r2.k());
                if (bVar != null) {
                    C0155h.a(bVar, r2.i(), this.u);
                    this.j.a((CopyOnWriteArrayList<Y>) this.p, this.v, r2.i(), this.u, bVar);
                    if (!this.c.h().s) {
                        a(r3, bVar);
                    }
                } else {
                    String k2 = r2.k();
                    IronLog ironLog3 = IronLog.INTERNAL;
                    ironLog3.error("onLoadSuccess winner instance " + k2 + " missing from waterfall. auctionId = " + this.q);
                    a((int) IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2}});
                }
            }
            if (this.n == a.LOADING) {
                if (i()) {
                    this.e.a(r2.k());
                    objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.x))}};
                } else {
                    objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.x))}};
                }
                a((int) IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, objArr);
            } else {
                IronSourceUtils.sendAutomationLog("bannerReloadSucceeded");
                a((int) IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.x))}});
            }
            String e2 = e();
            k.f(ContextProvider.getInstance().getCurrentActiveActivity(), e2);
            if (k.b((Context) ContextProvider.getInstance().getCurrentActiveActivity(), e2)) {
                a((int) IronSourceConstants.BN_PLACEMENT_CAPPED, (Object[][]) null);
            }
            o.a().a(3);
            a(a.LOADED);
            this.d.a(this);
        } else {
            IronLog ironLog4 = IronLog.INTERNAL;
            ironLog4.warning("wrong state - mCurrentState = " + this.n);
        }
    }

    public final void a(IronSourceError ironSourceError, R r2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError);
        if (r2.a != this.q) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("invoked with auctionId: " + r2.a + " and the current id is " + this.q);
            Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 3};
            r2.a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong auction " + r2.a + " State - " + this.n}, new Object[]{IronSourceConstants.EVENTS_EXT1, r2.k()}});
        } else if (k()) {
            this.l.put(r2.k(), C0156i.a.ISAuctionPerformanceFailedToLoad);
            f();
        } else {
            IronLog ironLog3 = IronLog.INTERNAL;
            ironLog3.warning("wrong state - mCurrentState = " + this.n);
        }
    }

    public final void a(List<com.ironsource.mediationsdk.server.b> list, String str, com.ironsource.mediationsdk.server.b bVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auctionId = " + str);
        if (l()) {
            this.s = "";
            this.q = str;
            this.t = i2;
            this.u = bVar;
            this.r = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                a((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i3)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}});
            }
            a(jSONObject2, IronSource.AD_UNIT.BANNER);
            if (this.a.a(IronSource.AD_UNIT.BANNER)) {
                a((int) IronSourceConstants.BN_AD_UNIT_CAPPED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_AUCTION_ID, str}});
                a(a.READY_TO_LOAD);
                C0157j.a().a(this.e, new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped"));
                return;
            }
            a((int) IronSourceConstants.BN_AUCTION_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
            a(this.n == a.FIRST_AUCTION ? a.LOADING : a.RELOADING);
            a((int) IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, c(list)}});
            f();
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.warning("wrong state - mCurrentState = " + this.n);
    }

    /* access modifiers changed from: package-private */
    public boolean a(a aVar, a aVar2) {
        boolean z;
        synchronized (this.w) {
            if (this.n == aVar) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("set state from '" + this.n + "' to '" + aVar2 + "'");
                z = true;
                this.n = aVar2;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void b(R r2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(r2.p());
        if (i()) {
            this.e.e();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, r2.m());
    }

    public final void c(R r2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(r2.p());
        if (i()) {
            this.e.d();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, r2.m());
    }

    /* access modifiers changed from: package-private */
    public void d() {
        IronLog.INTERNAL.verbose("");
        AsyncTask.execute(new Runnable() {
            public final void run() {
                boolean z;
                P p = P.this;
                if (!p.l.isEmpty()) {
                    p.k.a(p.l);
                    p.l.clear();
                }
                P p2 = P.this;
                long d = p2.c.d() - (new Date().getTime() - p2.m);
                if (d > 0) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("waiting before auction - timeToWaitBeforeAuction = " + d);
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            P.this.d();
                        }
                    }, d);
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    P.this.a((int) IronSourceConstants.BN_AUCTION_REQUEST);
                    C0160m.a(P.this.e(), P.this.i, new C0160m.a() {
                        public final void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
                            IronLog ironLog = IronLog.INTERNAL;
                            ironLog.verbose("auction waterfallString = " + sb);
                            if (map.size() == 0 && list.size() == 0) {
                                P.this.a((int) IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}});
                                if (P.this.a(a.AUCTION, a.LOADED)) {
                                    P.this.d.a(P.this);
                                    return;
                                }
                                C0157j.a().a(P.this.e, new IronSourceError(1005, "No candidates available for auctioning"));
                                P.this.a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}});
                                P.this.a(a.READY_TO_LOAD);
                                return;
                            }
                            P.this.a((int) IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
                            if (P.this.j != null) {
                                C0155h hVar = P.this.j;
                                Context applicationContext = ContextProvider.getInstance().getApplicationContext();
                                C0156i iVar = P.this.k;
                                int i = P.this.h;
                                IronSourceSegment ironSourceSegment = P.this.b;
                                hVar.a = P.a(P.this);
                                hVar.a(applicationContext, map, list, iVar, i, ironSourceSegment);
                                return;
                            }
                            IronLog.INTERNAL.error("mAuctionHandler is null");
                        }
                    });
                }
            }
        });
    }

    public final void d(R r2) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(r2.p());
        if (i()) {
            this.e.f();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, r2.m());
    }

    /* access modifiers changed from: package-private */
    public String e() {
        f fVar = this.f;
        return fVar != null ? fVar.getPlacementName() : "";
    }

    public final void e(R r2) {
        com.ironsource.mediationsdk.server.b bVar;
        IronLog.INTERNAL.verbose(r2.p());
        if (m()) {
            if (this.c.c() && this.c.h().s && (bVar = this.v.get(r2.k())) != null) {
                a(r2, bVar);
            }
            a((int) IronSourceConstants.BN_CALLBACK_SHOW, (Object[][]) null);
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("wrong state - mCurrentState = " + this.n);
        String k2 = r2.k();
        Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1};
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong State - " + this.n}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2}});
    }
}
