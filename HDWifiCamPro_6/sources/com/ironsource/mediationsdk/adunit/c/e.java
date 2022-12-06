package com.ironsource.mediationsdk.adunit.c;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.j;
import com.ironsource.mediationsdk.B;
import com.ironsource.mediationsdk.C0150c;
import com.ironsource.mediationsdk.C0151d;
import com.ironsource.mediationsdk.C0154g;
import com.ironsource.mediationsdk.C0155h;
import com.ironsource.mediationsdk.C0156i;
import com.ironsource.mediationsdk.C0163p;
import com.ironsource.mediationsdk.C0171x;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.aa;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBidderInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.b.d;
import com.ironsource.mediationsdk.adunit.b.i;
import com.ironsource.mediationsdk.adunit.c.a.b;
import com.ironsource.mediationsdk.adunit.c.b.a;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.ae;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.f;
import com.ironsource.mediationsdk.utils.m;
import com.ironsource.mediationsdk.utils.n;
import com.ironsource.mediationsdk.utils.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public abstract class e<Smash extends c<?>, Adapter extends BaseAdAdapter<?, ? extends AdapterAdListener>> implements j, com.ironsource.mediationsdk.adunit.b.c, b, com.ironsource.mediationsdk.adunit.e.b, ae, C0150c, C0154g {
    protected com.ironsource.mediationsdk.adunit.e.a<Smash> a;
    protected ConcurrentHashMap<String, com.ironsource.mediationsdk.server.b> b;
    protected ConcurrentHashMap<String, C0156i.a> c;
    protected C0155h d;
    protected C0156i e;
    protected int f;
    protected String g = "";
    protected JSONObject h;
    protected com.ironsource.mediationsdk.server.b i;
    protected Placement j;
    protected boolean k = false;
    protected n l;
    protected a m;
    protected a n;
    protected c o;
    protected C0171x p;
    protected d q;
    protected b r;
    protected IronSourceSegment s;
    protected final Object t = new Object();
    private f u;
    private f v;
    private com.ironsource.mediationsdk.utils.a w;
    private long x = 0;
    private Boolean y;
    private Set<ImpressionDataListener> z = new HashSet();

    public enum a {
        NONE,
        READY_TO_LOAD,
        AUCTION,
        LOADING,
        READY_TO_SHOW,
        SHOWING
    }

    public e(a aVar, Set<ImpressionDataListener> set, IronSourceSegment ironSourceSegment) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + aVar.a + ", loading mode = " + aVar.h.a);
        f fVar = new f();
        this.s = ironSourceSegment;
        this.m = aVar;
        this.q = new d(this.m.a, d.b.MEDIATION, this);
        this.r = new b(this.m.a);
        this.o = new c(this.m.h, this);
        a(a.NONE);
        this.z = set;
        this.a = new com.ironsource.mediationsdk.adunit.e.a<>(this.m.d.o, this.m.d.g, this);
        this.q.a.a();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.j = null;
        C0163p.a().a(this.m.a, this.m.f);
        this.h = new JSONObject();
        if (this.m.a()) {
            this.d = new C0155h(this.m.a.toString(), this.m.d, this);
        }
        a(this.m.c, this.m.d.f);
        k();
        l();
        this.u = new f();
        a(a.READY_TO_LOAD);
        this.q.a.a(f.a(fVar));
        this.p = new C0171x(aVar.i, this);
        this.w = new com.ironsource.mediationsdk.utils.a();
        if (this.m.h.b()) {
            IronLog.INTERNAL.verbose("first automatic load");
            e();
        }
    }

    private static String a(com.ironsource.mediationsdk.server.b bVar, int i2) {
        return String.format("%s%s", new Object[]{Integer.valueOf(i2), bVar.a()});
    }

    private String a(List<com.ironsource.mediationsdk.server.b> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("waterfall.size() = " + list.size()));
        StringBuilder sb = new StringBuilder();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.ironsource.mediationsdk.server.b bVar = list.get(i2);
            c b2 = b(bVar, str);
            if (b2 != null) {
                copyOnWriteArrayList.add(b2);
                sb.append(a(bVar, b2.i()));
            }
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        this.a.a(this.m.h.a, copyOnWriteArrayList, str);
        IronLog.INTERNAL.verbose(a("updateWaterfall() - next waterfall is " + sb.toString()));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, boolean z2) {
        a(a.READY_TO_LOAD);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("errorCode = " + i2 + ", errorReason = " + str));
        if (this.m.h.a()) {
            if (z2) {
                this.q.b.a(f.a(this.v), i2, str);
            }
            C0163p.a().a(this.m.a, new IronSourceError(i2, str));
        } else {
            if (z2) {
                this.q.e.a(i2, str);
            }
            a(false, false);
        }
        this.o.a();
    }

    private void a(List<NetworkSettings> list, int i2) {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings providerName : list) {
            arrayList.add(providerName.getProviderName());
        }
        this.e = new C0156i(arrayList, i2);
    }

    private boolean a(a aVar, a aVar2) {
        boolean z2;
        synchronized (this.t) {
            if (this.n == aVar) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(a("set state from '" + this.n + "' to '" + aVar2 + "'"));
                z2 = true;
                this.n = aVar2;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public boolean a(NetworkSettings networkSettings) {
        AdapterBaseInterface a2 = C0151d.a().a(networkSettings, this.m.a);
        return (a2 instanceof AdapterSettingsInterface) && this.a.a(this.m.h.a, networkSettings.getProviderInstanceName(), networkSettings.getProviderTypeForReflection(), ((AdapterSettingsInterface) a2).getLoadWhileShowSupportedState(networkSettings));
    }

    private Smash b(com.ironsource.mediationsdk.server.b bVar, String str) {
        NetworkSettings a2 = this.m.a(bVar.a());
        if (a2 != null) {
            C0151d.a().a(a2, this.m.a);
            BaseAdAdapter a3 = a(a2, this.m.a);
            if (a3 != null) {
                Smash a4 = a(a2, a3, o.a().b(this.m.a), str);
                this.b.put(a4.k(), bVar);
                this.c.put(bVar.a(), C0156i.a.ISAuctionPerformanceDidntAttemptToLoad);
                return a4;
            }
            String str2 = "addSmashToWaterfall - could not load ad adapter for " + a2.getProviderInstanceName();
            IronLog.INTERNAL.error(a(str2));
            this.q.e.b(str2);
        } else {
            String str3 = "could not find matching provider settings for auction response item - item = " + bVar.a();
            IronLog.INTERNAL.error(a(str3));
            this.q.e.c(str3);
        }
        return null;
    }

    private void c(Smash smash) {
        IronLog.INTERNAL.verbose(a(""));
        String b2 = this.b.get(smash.k()).b();
        smash.b(b2);
        smash.a(b2);
    }

    private boolean c(boolean z2) {
        boolean z3;
        synchronized (this.t) {
            if (this.y != null) {
                if (this.y.booleanValue() == z2) {
                    z3 = false;
                }
            }
            z3 = true;
        }
        return z3;
    }

    private boolean i() {
        boolean z2;
        synchronized (this.t) {
            z2 = this.n == a.LOADING;
        }
        return z2;
    }

    private boolean j() {
        boolean z2;
        synchronized (this.t) {
            z2 = this.n == a.AUCTION;
        }
        return z2;
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings next : this.m.c) {
            arrayList.add(new m(next.getProviderInstanceName(), next.getMaxAdsPerSession(this.m.a)));
        }
        this.l = new n(arrayList);
    }

    private void l() {
        JSONObject jSONObject;
        IronLog.INTERNAL.verbose(a(""));
        for (NetworkSettings next : this.m.c) {
            if (next.isIronSource() || next.isBidder(this.m.a)) {
                HashMap hashMap = new HashMap();
                hashMap.put("userId", this.m.b);
                if (this.m.a == IronSource.AD_UNIT.INTERSTITIAL) {
                    jSONObject = next.getInterstitialSettings();
                } else if (this.m.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                    jSONObject = next.getRewardedVideoSettings();
                } else {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.error("ad unit not supported - " + this.m.a);
                    jSONObject = new JSONObject();
                }
                hashMap.putAll(com.ironsource.mediationsdk.c.b.a(jSONObject));
                AdData adData = new AdData((String) null, hashMap);
                AdapterBaseInterface a2 = C0151d.a().a(next, this.m.a);
                if (a2 != null) {
                    try {
                        a2.init(adData, ContextProvider.getInstance().getApplicationContext(), (NetworkInitializationListener) null);
                    } catch (Exception e2) {
                        i iVar = this.q.e;
                        iVar.a("initNetworks - exception while calling networkAdapter.init - " + e2);
                    }
                } else {
                    this.q.e.a("initNetworks - could not load network adapter");
                }
            }
        }
    }

    private void m() {
        IronLog.INTERNAL.verbose(a(""));
        a(n(), t());
    }

    private List<com.ironsource.mediationsdk.server.b> n() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (NetworkSettings next : this.m.c) {
            m mVar = new m(next.getProviderInstanceName(), next.getMaxAdsPerSession(this.m.a));
            if (!next.isBidder(this.m.a) && !this.l.b(mVar) && a(next)) {
                copyOnWriteArrayList.add(new com.ironsource.mediationsdk.server.b(mVar.k()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void o() {
        Iterator it = p().iterator();
        while (it.hasNext()) {
            c((c) it.next());
        }
    }

    private ArrayList<Smash> p() {
        StringBuilder sb;
        IronLog.INTERNAL.verbose(a("mWaterfall.size() = " + this.a.a().size()));
        ArrayList<Smash> arrayList = new ArrayList<>();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= this.a.a().size() || i3 >= this.m.e) {
                break;
            }
            c cVar = (c) this.a.a().get(i2);
            if (cVar.e()) {
                if (cVar.c() || cVar.d()) {
                    IronLog.INTERNAL.verbose("smash = " + cVar.l());
                } else if (!cVar.h()) {
                    arrayList.add(cVar);
                } else if (i3 == 0) {
                    sb.append(cVar.k());
                    sb.append(". No other instances will be loaded at the same time.");
                    String sb2 = sb.toString();
                    IronLog.INTERNAL.verbose(a(sb2));
                    IronSourceUtils.sendAutomationLog(sb2);
                    arrayList.add(cVar);
                    i3++;
                } else {
                    sb = new StringBuilder("Advanced Loading: Won't start loading bidder ");
                    sb.append(cVar.k());
                    sb.append(" as a non bidder is being loaded");
                    String sb3 = sb.toString();
                    IronLog.INTERNAL.verbose(a(sb3));
                    IronSourceUtils.sendAutomationLog(sb3);
                }
                i3++;
            }
            i2++;
        }
        if (i3 == 0) {
            a(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, "Mediation No fill", true);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        if (r2 <= 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        new java.util.Timer().schedule(new com.ironsource.mediationsdk.adunit.c.e.AnonymousClass1(r4), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        r();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r2 = r4.m.d.i - com.ironsource.mediationsdk.utils.f.a(r4.u);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q() {
        /*
            r4 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = ""
            java.lang.String r1 = r4.a((java.lang.String) r1)
            r0.verbose(r1)
            java.lang.Object r0 = r4.t
            monitor-enter(r0)
            com.ironsource.mediationsdk.adunit.c.e$a r1 = r4.n     // Catch:{ all -> 0x0041 }
            com.ironsource.mediationsdk.adunit.c.e$a r2 = com.ironsource.mediationsdk.adunit.c.e.a.AUCTION     // Catch:{ all -> 0x0041 }
            if (r1 != r2) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return
        L_0x0016:
            com.ironsource.mediationsdk.adunit.c.e$a r1 = com.ironsource.mediationsdk.adunit.c.e.a.AUCTION     // Catch:{ all -> 0x0041 }
            r4.a((com.ironsource.mediationsdk.adunit.c.e.a) r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            com.ironsource.mediationsdk.utils.f r0 = r4.u
            long r0 = com.ironsource.mediationsdk.utils.f.a(r0)
            com.ironsource.mediationsdk.adunit.c.a r2 = r4.m
            com.ironsource.mediationsdk.utils.c r2 = r2.d
            long r2 = r2.i
            long r2 = r2 - r0
            r0 = 0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x003d
            java.util.Timer r0 = new java.util.Timer
            r0.<init>()
            com.ironsource.mediationsdk.adunit.c.e$1 r1 = new com.ironsource.mediationsdk.adunit.c.e$1
            r1.<init>()
            r0.schedule(r1, r2)
            return
        L_0x003d:
            r4.r()
            return
        L_0x0041:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.e.q():void");
    }

    /* access modifiers changed from: private */
    public void r() {
        IronLog.INTERNAL.verbose(a(""));
        AsyncTask.execute(new Runnable() {
            public final void run() {
                int i;
                i iVar;
                String str;
                e.this.h = new JSONObject();
                e.this.q.c.a();
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                for (NetworkSettings next : e.this.m.c) {
                    if (!e.this.l.b(new m(next.getProviderInstanceName(), next.getMaxAdsPerSession(e.this.m.a))) && e.this.a(next)) {
                        if (next.isBidder(e.this.m.a)) {
                            AdapterBaseInterface a2 = C0151d.a().a(next, e.this.m.a);
                            if (a2 instanceof AdapterBidderInterface) {
                                try {
                                    Map<String, Object> biddingData = ((AdapterBidderInterface) a2).getBiddingData(ContextProvider.getInstance().getApplicationContext());
                                    if (biddingData != null) {
                                        hashMap.put(next.getProviderInstanceName(), biddingData);
                                        sb.append(next.getInstanceType(e.this.m.a) + next.getProviderInstanceName() + ",");
                                    } else {
                                        e.this.q.e.d("missing bidding data for " + next.getProviderInstanceName());
                                    }
                                } catch (Exception e) {
                                    iVar = e.this.q.e;
                                    str = "exception while calling networkAdapter.getBiddingData - " + e;
                                }
                            } else {
                                str = a2 == null ? "could not load network adapter" : "network adapter does not implementing AdapterBidderInterface";
                                iVar = e.this.q.e;
                                iVar.a(str);
                            }
                        } else {
                            arrayList.add(next.getProviderInstanceName());
                            sb.append(next.getInstanceType(e.this.m.a) + next.getProviderInstanceName() + ",");
                        }
                    }
                }
                IronLog.INTERNAL.verbose(e.this.a("auction waterfallString = " + sb));
                if (hashMap.size() == 0 && arrayList.size() == 0) {
                    IronLog.INTERNAL.verbose(e.this.a("auction failed - no candidates"));
                    e.this.q.c.a(0, 1005, "No candidates available for auctioning");
                    e eVar = e.this;
                    IronSource.AD_UNIT ad_unit = eVar.m.a;
                    if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
                        i = IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES;
                    } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
                        i = 1024;
                    } else {
                        IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
                        i = IronSourceError.ERROR_CODE_GENERIC;
                    }
                    eVar.a(i, "Empty waterfall", true);
                    return;
                }
                e.this.q.c.a(sb.toString());
                if (e.this.d != null) {
                    e.this.d.a(ContextProvider.getInstance().getApplicationContext(), hashMap, arrayList, e.this.e, o.a().b(e.this.m.a), e.this.s);
                } else {
                    IronLog.INTERNAL.error(e.this.a("mAuctionHandler is null"));
                }
            }
        });
    }

    private void s() {
        this.w.a(this.m.a, false);
    }

    private static String t() {
        return "fallback_" + System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public abstract Adapter a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit);

    /* access modifiers changed from: protected */
    public abstract Smash a(NetworkSettings networkSettings, Adapter adapter, int i2, String str);

    /* access modifiers changed from: protected */
    public final String a(String str) {
        String name = this.m.a.name();
        if (TextUtils.isEmpty(str)) {
            return name;
        }
        return name + " - " + str;
    }

    public final Map<String, Object> a(com.ironsource.mediationsdk.adunit.b.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        boolean z2 = true;
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        if (!TextUtils.isEmpty(this.a.b)) {
            hashMap.put(IronSourceConstants.EVENTS_AUCTION_ID, this.a.b);
        }
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.h);
        }
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(o.a().b(this.m.a)));
        if (!(bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_SUCCESS || bVar == com.ironsource.mediationsdk.adunit.b.b.LOAD_AD_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.AUCTION_SUCCESS || bVar == com.ironsource.mediationsdk.adunit.b.b.AUCTION_FAILED || bVar == com.ironsource.mediationsdk.adunit.b.b.AD_UNIT_CAPPED)) {
            z2 = false;
        }
        if (z2) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f));
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.g);
            }
        }
        return hashMap;
    }

    public final void a(int i2) {
        i iVar = this.q.e;
        iVar.n("waterfalls hold too many with size = " + i2);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        String str3 = "";
        IronLog.INTERNAL.verbose(a(str3));
        if (j()) {
            String str4 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
            IronLog.INTERNAL.verbose(a(str4));
            StringBuilder sb = new StringBuilder();
            IronSource.AD_UNIT ad_unit = this.m.a;
            if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                str3 = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
            } else if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                str3 = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
            } else if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                str3 = "BN";
            }
            sb.append(str3);
            sb.append(": ");
            sb.append(str4);
            IronSourceUtils.sendAutomationLog(sb.toString());
            this.f = i3;
            this.g = str2;
            this.h = new JSONObject();
            m();
            this.q.c.a(j2, i2, str);
            a(a.LOADING);
            o();
            return;
        }
        this.q.e.h("unexpected auction fail - error = " + i2 + ", " + str);
    }

    public final void a(IronSourceSegment ironSourceSegment) {
        this.s = ironSourceSegment;
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("from " + this.n + " to " + aVar));
        synchronized (this.t) {
            this.n = aVar;
        }
    }

    public final void a(c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.l()));
        if (cVar.n() != this.a.b) {
            String str = "onLoadSuccess was invoked with state = " + this.n + " auctionId: " + cVar.n() + " and the current id is " + this.a.b;
            IronLog.INTERNAL.verbose(str);
            this.q.e.i(str);
            return;
        }
        this.c.put(cVar.k(), C0156i.a.ISAuctionPerformanceLoadedSuccessfully);
        if (a(a.LOADING, a.READY_TO_SHOW)) {
            boolean z2 = false;
            if (this.m.h.a()) {
                b bVar = this.r;
                if (bVar.a == IronSource.AD_UNIT.INTERSTITIAL) {
                    B.a().b();
                } else if (bVar.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                    aa a2 = aa.a();
                    if (a2.a instanceof RewardedVideoManualListener) {
                        com.ironsource.environment.e.c.a.a(new Runnable() {
                            public final void run(
/*
Method generation error in method: com.ironsource.mediationsdk.aa.1.run():void, dex: classes2.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.mediationsdk.aa.1.run():void, class status: UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            
*/
                        });
                    }
                } else {
                    IronLog.INTERNAL.warning("ad unit not supported - " + bVar.a);
                }
            } else {
                a(true, false);
            }
            long a3 = f.a(this.v);
            if (this.m.a == IronSource.AD_UNIT.REWARDED_VIDEO && this.m.h.a == a.C0091a.MANUAL) {
                z2 = true;
            }
            this.q.b.a(a3, z2);
            if (this.m.h.b()) {
                this.p.a(0);
            }
            if (this.m.a()) {
                com.ironsource.mediationsdk.server.b bVar2 = this.b.get(cVar.k());
                if (bVar2 != null) {
                    C0155h.a(bVar2, cVar.i(), this.i);
                    ArrayList arrayList = new ArrayList();
                    Iterator<Smash> it = this.a.a().iterator();
                    while (it.hasNext()) {
                        arrayList.add(((c) it.next()).k());
                    }
                    C0155h.a((ArrayList<String>) arrayList, this.b, cVar.i(), this.i, bVar2);
                    return;
                }
                String k2 = cVar.k();
                String str2 = "winner instance missing from waterfall - " + k2;
                IronLog.INTERNAL.verbose(a(str2));
                this.q.e.a(1010, str2, k2);
            }
        }
    }

    public final void a(ImpressionDataListener impressionDataListener) {
        this.z.add(impressionDataListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0083, code lost:
        r6 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008b, code lost:
        if (r6.hasNext() == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008d, code lost:
        c((com.ironsource.mediationsdk.adunit.d.a.c) r6.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0097, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.logger.IronSourceError r6, com.ironsource.mediationsdk.adunit.d.a.c<?> r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r5.t
            monitor-enter(r1)
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ce }
            r3.<init>()     // Catch:{ all -> 0x00ce }
            java.lang.String r4 = r7.l()     // Catch:{ all -> 0x00ce }
            r3.append(r4)     // Catch:{ all -> 0x00ce }
            java.lang.String r4 = " - error = "
            r3.append(r4)     // Catch:{ all -> 0x00ce }
            r3.append(r6)     // Catch:{ all -> 0x00ce }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ce }
            java.lang.String r3 = r5.a((java.lang.String) r3)     // Catch:{ all -> 0x00ce }
            r2.verbose(r3)     // Catch:{ all -> 0x00ce }
            java.lang.String r2 = r7.n()     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.e.a<Smash> r3 = r5.a     // Catch:{ all -> 0x00ce }
            java.lang.String r3 = r3.b     // Catch:{ all -> 0x00ce }
            if (r2 != r3) goto L_0x0098
            com.ironsource.mediationsdk.adunit.c.e$a r2 = r5.n     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.c.e$a r3 = com.ironsource.mediationsdk.adunit.c.e.a.AUCTION     // Catch:{ all -> 0x00ce }
            if (r2 != r3) goto L_0x003a
            goto L_0x0098
        L_0x003a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r2 = r5.c     // Catch:{ all -> 0x00ce }
            java.lang.String r3 = r7.k()     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.i$a r4 = com.ironsource.mediationsdk.C0156i.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x00ce }
            r2.put(r3, r4)     // Catch:{ all -> 0x00ce }
            boolean r2 = r5.i()     // Catch:{ all -> 0x00ce }
            if (r2 != 0) goto L_0x007e
            boolean r2 = r5.f()     // Catch:{ all -> 0x00ce }
            if (r2 == 0) goto L_0x0052
            goto L_0x007e
        L_0x0052:
            com.ironsource.mediationsdk.adunit.b.d r2 = r5.q     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.b.i r2 = r2.e     // Catch:{ all -> 0x00ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ce }
            java.lang.String r4 = "unexpected load failed for state - "
            r3.<init>(r4)     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.c.e$a r4 = r5.n     // Catch:{ all -> 0x00ce }
            r3.append(r4)     // Catch:{ all -> 0x00ce }
            java.lang.String r4 = " smash - "
            r3.append(r4)     // Catch:{ all -> 0x00ce }
            java.lang.String r7 = r7.l()     // Catch:{ all -> 0x00ce }
            r3.append(r7)     // Catch:{ all -> 0x00ce }
            java.lang.String r7 = ", error - "
            r3.append(r7)     // Catch:{ all -> 0x00ce }
            r3.append(r6)     // Catch:{ all -> 0x00ce }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00ce }
            r2.j(r6)     // Catch:{ all -> 0x00ce }
            goto L_0x0082
        L_0x007e:
            java.util.ArrayList r0 = r5.p()     // Catch:{ all -> 0x00ce }
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x00ce }
            java.util.Iterator r6 = r0.iterator()
        L_0x0087:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0097
            java.lang.Object r7 = r6.next()
            com.ironsource.mediationsdk.adunit.d.a.c r7 = (com.ironsource.mediationsdk.adunit.d.a.c) r7
            r5.c(r7)
            goto L_0x0087
        L_0x0097:
            return
        L_0x0098:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = "onAdLoadFailed was invoked with state ="
            r6.<init>(r0)     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.c.e$a r0 = r5.n     // Catch:{ all -> 0x00ce }
            r6.append(r0)     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = " auctionId: "
            r6.append(r0)     // Catch:{ all -> 0x00ce }
            java.lang.String r7 = r7.n()     // Catch:{ all -> 0x00ce }
            r6.append(r7)     // Catch:{ all -> 0x00ce }
            java.lang.String r7 = " and the current id is "
            r6.append(r7)     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.e.a<Smash> r7 = r5.a     // Catch:{ all -> 0x00ce }
            java.lang.String r7 = r7.b     // Catch:{ all -> 0x00ce }
            r6.append(r7)     // Catch:{ all -> 0x00ce }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00ce }
            r7.verbose(r6)     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.b.d r7 = r5.q     // Catch:{ all -> 0x00ce }
            com.ironsource.mediationsdk.adunit.b.i r7 = r7.e     // Catch:{ all -> 0x00ce }
            r7.j(r6)     // Catch:{ all -> 0x00ce }
            monitor-exit(r1)     // Catch:{ all -> 0x00ce }
            return
        L_0x00ce:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ce }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.e.a(com.ironsource.mediationsdk.logger.IronSourceError, com.ironsource.mediationsdk.adunit.d.a.c):void");
    }

    /* access modifiers changed from: protected */
    public final void a(com.ironsource.mediationsdk.server.b bVar, String str) {
        if (bVar != null) {
            ImpressionData a2 = bVar.a(str);
            if (a2 != null) {
                for (ImpressionDataListener next : this.z) {
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info(a("onImpressionSuccess " + next.getClass().getSimpleName() + ": " + a2));
                    next.onImpressionSuccess(a2);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose(a("no auctionResponseItem or listener"));
    }

    public final void a(List<com.ironsource.mediationsdk.server.b> list, String str, com.ironsource.mediationsdk.server.b bVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog.INTERNAL.verbose(a(""));
        if (j()) {
            this.g = "";
            this.f = i2;
            this.i = bVar;
            this.h = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                this.q.e.b(i3, str2);
            }
            this.w.a(this.m.a, jSONObject2 != null ? jSONObject2.optBoolean("isAdUnitCapped", false) : false);
            if (this.w.a(this.m.a)) {
                this.q.c.c(str);
                a(IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped", false);
                return;
            }
            String a2 = a(list, str);
            this.q.c.a(j2);
            this.q.c.b(a2);
            a(a.LOADING);
            o();
            return;
        }
        i iVar = this.q.e;
        iVar.g("unexpected auction success for auctionId - " + str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (b() != false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r3.y.booleanValue() != false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r4) {
        /*
            r3 = this;
            boolean r0 = r3.k
            if (r0 == 0) goto L_0x0048
            com.ironsource.mediationsdk.adunit.c.a r0 = r3.m
            com.ironsource.mediationsdk.adunit.c.b.a r0 = r0.h
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x000f
            goto L_0x0048
        L_0x000f:
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "network availability changed to - "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.verbose(r1)
            java.lang.Boolean r0 = r3.y
            r1 = 0
            if (r0 != 0) goto L_0x0029
        L_0x0027:
            r2 = r1
            goto L_0x0043
        L_0x0029:
            r2 = 1
            if (r4 == 0) goto L_0x0039
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0039
            boolean r0 = r3.b()
            if (r0 == 0) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            if (r4 != 0) goto L_0x0027
            java.lang.Boolean r0 = r3.y
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0027
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r3.a((boolean) r4, (boolean) r1)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.e.a(boolean):void");
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z2, boolean z3) {
        if (c(z2)) {
            this.y = Boolean.valueOf(z2);
            long j2 = 0;
            if (this.x != 0) {
                j2 = new Date().getTime() - this.x;
            }
            this.x = new Date().getTime();
            this.q.b.a(z2, j2, z3);
            this.r.a(z2);
        }
    }

    public final void b(c<?> cVar) {
        IronLog.INTERNAL.verbose(a(cVar.l()));
        b bVar = this.r;
        Placement placement = this.j;
        if (bVar.a == IronSource.AD_UNIT.INTERSTITIAL) {
            B.a().f();
        } else if (bVar.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
            aa.a().b(placement);
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + bVar.a);
        }
    }

    public final void b(ImpressionDataListener impressionDataListener) {
        this.z.remove(impressionDataListener);
    }

    public final void b(boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("track = " + z2));
        this.k = z2;
    }

    /* access modifiers changed from: protected */
    public abstract boolean b();

    public final void c_() {
        if (this.m.h.b()) {
            a(a.READY_TO_LOAD);
            a(false, true);
            e();
        }
    }

    public final void d() {
        IronLog.INTERNAL.verbose(a(""));
        e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fd, code lost:
        if (r5.m.a() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ff, code lost:
        m();
        o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r5 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = ""
            java.lang.String r1 = r5.a((java.lang.String) r1)
            r0.verbose(r1)
            java.lang.Object r0 = r5.t
            monitor-enter(r0)
            com.ironsource.mediationsdk.adunit.c.a r1 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a r1 = r1.h     // Catch:{ all -> 0x0106 }
            boolean r1 = r1.b()     // Catch:{ all -> 0x0106 }
            r2 = 1
            if (r1 == 0) goto L_0x0034
            com.ironsource.mediationsdk.utils.n r1 = r5.l     // Catch:{ all -> 0x0106 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = "all smashes are capped"
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0106 }
            java.lang.String r4 = r5.a((java.lang.String) r1)     // Catch:{ all -> 0x0106 }
            r3.verbose(r4)     // Catch:{ all -> 0x0106 }
            r3 = 80001(0x13881, float:1.12105E-40)
            r5.a(r3, r1, r2)     // Catch:{ all -> 0x0106 }
            monitor-exit(r0)     // Catch:{ all -> 0x0106 }
            return
        L_0x0034:
            com.ironsource.mediationsdk.adunit.c.a r1 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a r1 = r1.h     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a$a r1 = r1.a     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a$a r3 = com.ironsource.mediationsdk.adunit.c.b.a.C0091a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch:{ all -> 0x0106 }
            r4 = 0
            if (r1 == r3) goto L_0x0074
            com.ironsource.mediationsdk.adunit.c.e$a r1 = r5.n     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.e$a r3 = com.ironsource.mediationsdk.adunit.c.e.a.SHOWING     // Catch:{ all -> 0x0106 }
            if (r1 != r3) goto L_0x0074
            java.lang.String r1 = "load cannot be invoked while showing an ad"
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r5.a((java.lang.String) r1)     // Catch:{ all -> 0x0106 }
            r2.error(r3)     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.a r3 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r3 = r3.a     // Catch:{ all -> 0x0106 }
            int r3 = com.ironsource.mediationsdk.adunit.a.a.b(r3)     // Catch:{ all -> 0x0106 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.a r1 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a r1 = r1.h     // Catch:{ all -> 0x0106 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x006d
            com.ironsource.mediationsdk.adunit.c.b r1 = r5.r     // Catch:{ all -> 0x0106 }
            r1.a((com.ironsource.mediationsdk.logger.IronSourceError) r2)     // Catch:{ all -> 0x0106 }
            goto L_0x0072
        L_0x006d:
            com.ironsource.mediationsdk.adunit.c.b r1 = r5.r     // Catch:{ all -> 0x0106 }
            r1.a((boolean) r4)     // Catch:{ all -> 0x0106 }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x0106 }
            return
        L_0x0074:
            com.ironsource.mediationsdk.adunit.c.a r1 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a r1 = r1.h     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a$a r1 = r1.a     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a$a r3 = com.ironsource.mediationsdk.adunit.c.b.a.C0091a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch:{ all -> 0x0106 }
            if (r1 == r3) goto L_0x00a5
            com.ironsource.mediationsdk.adunit.c.e$a r1 = r5.n     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.e$a r3 = com.ironsource.mediationsdk.adunit.c.e.a.READY_TO_LOAD     // Catch:{ all -> 0x0106 }
            if (r1 == r3) goto L_0x008a
            com.ironsource.mediationsdk.adunit.c.e$a r1 = r5.n     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.e$a r3 = com.ironsource.mediationsdk.adunit.c.e.a.READY_TO_SHOW     // Catch:{ all -> 0x0106 }
            if (r1 != r3) goto L_0x0098
        L_0x008a:
            com.ironsource.mediationsdk.p r1 = com.ironsource.mediationsdk.C0163p.a()     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.a r3 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r3 = r3.a     // Catch:{ all -> 0x0106 }
            boolean r1 = r1.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r3)     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x00a5
        L_0x0098:
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "load is already in progress"
            java.lang.String r2 = r5.a((java.lang.String) r2)     // Catch:{ all -> 0x0106 }
            r1.error(r2)     // Catch:{ all -> 0x0106 }
            monitor-exit(r0)     // Catch:{ all -> 0x0106 }
            return
        L_0x00a5:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0106 }
            r1.<init>()     // Catch:{ all -> 0x0106 }
            r5.h = r1     // Catch:{ all -> 0x0106 }
            r5.s()     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.a r1 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = r1.a     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r3 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x0106 }
            if (r1 != r3) goto L_0x00c2
            com.ironsource.mediationsdk.adunit.c.a r1 = r5.m     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a r1 = r1.h     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a$a r1 = r1.a     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.b.a$a r3 = com.ironsource.mediationsdk.adunit.c.b.a.C0091a.MANUAL     // Catch:{ all -> 0x0106 }
            if (r1 != r3) goto L_0x00c2
            goto L_0x00c3
        L_0x00c2:
            r2 = r4
        L_0x00c3:
            com.ironsource.mediationsdk.adunit.b.d r1 = r5.q     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.b.h r1 = r1.b     // Catch:{ all -> 0x0106 }
            r1.a(r2)     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.utils.f r1 = new com.ironsource.mediationsdk.utils.f     // Catch:{ all -> 0x0106 }
            r1.<init>()     // Catch:{ all -> 0x0106 }
            r5.v = r1     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.a r1 = r5.m     // Catch:{ all -> 0x0106 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x00f1
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r1 = r5.c     // Catch:{ all -> 0x0106 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0106 }
            if (r1 != 0) goto L_0x00ed
            com.ironsource.mediationsdk.i r1 = r5.e     // Catch:{ all -> 0x0106 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r2 = r5.c     // Catch:{ all -> 0x0106 }
            r1.a((java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.C0156i.a>) r2)     // Catch:{ all -> 0x0106 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r1 = r5.c     // Catch:{ all -> 0x0106 }
            r1.clear()     // Catch:{ all -> 0x0106 }
        L_0x00ed:
            r5.q()     // Catch:{ all -> 0x0106 }
            goto L_0x00f6
        L_0x00f1:
            com.ironsource.mediationsdk.adunit.c.e$a r1 = com.ironsource.mediationsdk.adunit.c.e.a.LOADING     // Catch:{ all -> 0x0106 }
            r5.a((com.ironsource.mediationsdk.adunit.c.e.a) r1)     // Catch:{ all -> 0x0106 }
        L_0x00f6:
            monitor-exit(r0)     // Catch:{ all -> 0x0106 }
            com.ironsource.mediationsdk.adunit.c.a r0 = r5.m
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0105
            r5.m()
            r5.o()
        L_0x0105:
            return
        L_0x0106:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0106 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.e.e():void");
    }

    /* access modifiers changed from: protected */
    public final boolean f() {
        boolean z2;
        synchronized (this.t) {
            z2 = this.n == a.READY_TO_SHOW;
        }
        return z2;
    }

    public final void g() {
        this.z.clear();
    }

    /* access modifiers changed from: protected */
    public final String h() {
        Placement placement = this.j;
        return placement == null ? "" : placement.getPlacementName();
    }
}
