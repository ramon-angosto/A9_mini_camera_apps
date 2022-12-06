package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.a;
import com.ironsource.environment.j;
import com.ironsource.mediationsdk.C0156i;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.o;
import com.ironsource.mediationsdk.server.b;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.mediationsdk.utils.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

final class V extends C0161n implements j, W, ae, C0150c, C0154g, C0173z {
    private a A;
    private int B;
    private String C = "";
    private boolean D = false;
    private NetworkStateReceiver E;
    private C0171x F;
    final ConcurrentHashMap<String, X> c;
    n d;
    C0155h e;
    C0156i f;
    String g;
    JSONObject h;
    int i = 1;
    long j;
    private CopyOnWriteArrayList<X> k;
    private List<b> l;
    private ConcurrentHashMap<String, b> m;
    private ConcurrentHashMap<String, C0156i.a> n;
    private b o;
    private ad p;
    private boolean q;
    private boolean r;
    private boolean s;
    private String t;
    private long u;
    private long v;
    private int w;
    private boolean x;
    private boolean y;
    private Boolean z;

    enum a {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public V(List<NetworkSettings> list, o oVar, String str, String str2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        o oVar2 = oVar;
        long time = new Date().getTime();
        a((int) IronSourceConstants.RV_MANAGER_INIT_STARTED);
        a(a.RV_STATE_INITIATING);
        this.z = null;
        this.w = oVar2.c;
        this.x = oVar2.d;
        this.t = "";
        c cVar = oVar2.l;
        this.y = false;
        this.k = new CopyOnWriteArrayList<>();
        this.l = new ArrayList();
        this.m = new ConcurrentHashMap<>();
        this.n = new ConcurrentHashMap<>();
        this.v = new Date().getTime();
        this.q = cVar.e > 0;
        this.r = cVar.m;
        this.s = !cVar.n;
        this.u = cVar.l;
        if (this.q) {
            this.e = new C0155h("rewardedVideo", cVar, this);
        }
        this.p = new ad(cVar, this);
        this.c = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings next : list) {
            AbstractAdapter a2 = C0151d.a().a(next, next.getRewardedVideoSettings(), false, false);
            if (a2 != null) {
                C0152e a3 = C0152e.a();
                if (a3.a(a2, a3.b, "rewarded video")) {
                    X x2 = r0;
                    X x3 = new X(str, str2, next, this, oVar2.e, a2);
                    String k2 = x2.k();
                    this.c.put(k2, x2);
                    arrayList.add(k2);
                }
            }
        }
        this.f = new C0156i(arrayList, cVar.f);
        this.d = new n(new ArrayList(this.c.values()));
        for (X next2 : this.c.values()) {
            if (next2.h()) {
                next2.b();
            }
        }
        a((int) IronSourceConstants.RV_MANAGER_INIT_ENDED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}}));
        this.F = new C0171x(oVar2.i, this);
        a(cVar.i);
    }

    private String a(b bVar) {
        X x2 = this.c.get(bVar.a());
        String num = x2 != null ? Integer.toString(x2.i()) : TextUtils.isEmpty(bVar.b()) ? "1" : "2";
        return num + bVar.a();
    }

    private void a(int i2, Map<String, Object> map, boolean z2, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        if (z3 && !TextUtils.isEmpty(this.g)) {
            hashMap.put(IronSourceConstants.EVENTS_AUCTION_ID, this.g);
        }
        JSONObject jSONObject = this.h;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.h);
        }
        if (z2 && !TextUtils.isEmpty(this.t)) {
            hashMap.put("placement", this.t);
        }
        if (c(i2)) {
            h.e();
            h.a((Map<String, Object>) hashMap, this.B, this.C);
        }
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.i));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    hashMap.putAll(map);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "ProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        h.e().b(new com.ironsource.mediationsdk.a.c(i2, new JSONObject(hashMap)));
    }

    private void a(long j2) {
        if (this.d.a()) {
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "all smashes are capped"}}));
            f();
        } else if (this.q) {
            if (!this.n.isEmpty()) {
                this.f.a(this.n);
                this.n.clear();
            }
            new Timer().schedule(new TimerTask() {
                public final void run() {
                    V v = V.this;
                    v.a(a.RV_STATE_AUCTION_IN_PROGRESS);
                    AsyncTask.execute(new Runnable() {
                        public final void run() {
                            StringBuilder sb;
                            V v = V.this;
                            V.a("makeAuction()");
                            V v2 = V.this;
                            v2.g = "";
                            v2.h = null;
                            v2.a(IronSource.AD_UNIT.REWARDED_VIDEO);
                            V.this.j = new Date().getTime();
                            HashMap hashMap = new HashMap();
                            ArrayList arrayList = new ArrayList();
                            StringBuilder sb2 = new StringBuilder();
                            for (X next : V.this.c.values()) {
                                if (next.h()) {
                                    next.b = false;
                                }
                                if (!V.this.d.b(next)) {
                                    if (next.h()) {
                                        Map<String, Object> a2 = next.a();
                                        if (a2 != null) {
                                            hashMap.put(next.k(), a2);
                                            sb = new StringBuilder();
                                        }
                                    } else {
                                        arrayList.add(next.k());
                                        sb = new StringBuilder();
                                    }
                                    sb.append(next.i());
                                    sb.append(next.k());
                                    sb.append(",");
                                    sb2.append(sb.toString());
                                }
                            }
                            if (hashMap.keySet().size() == 0 && arrayList.size() == 0) {
                                V.this.b((int) IronSourceConstants.RV_AUCTION_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}}));
                                V v3 = V.this;
                                V.a("makeAuction() failed - No candidates available for auctioning");
                                V.this.f();
                                return;
                            }
                            V v4 = V.this;
                            V.a("makeAuction() - request waterfall is: " + sb2);
                            V.this.a(1000);
                            V.this.a((int) IronSourceConstants.RV_AUCTION_REQUEST);
                            V.this.a((int) IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb2.toString()}}));
                            V.this.e.a(ContextProvider.getInstance().getApplicationContext(), hashMap, arrayList, V.this.f, V.this.i, V.this.b);
                        }
                    });
                }
            }, j2);
        } else {
            IronLog.INTERNAL.verbose("auction is disabled, fallback flow will occur");
            g();
            if (this.l.isEmpty()) {
                b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80002}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
                f();
                return;
            }
            a(1000);
            if (!this.s || !this.y) {
                e();
            }
        }
    }

    static void a(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "ProgRvManager: " + str, 0);
    }

    private void a(List<b> list) {
        this.l = list;
        StringBuilder sb = new StringBuilder();
        for (b a2 : list) {
            sb.append(a(a2) + ",");
        }
        a("updateNextWaterfallToLoad() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            a("Updated waterfall is empty");
        }
        b((int) IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    private void a(boolean z2, Map<String, Object> map) {
        Boolean bool = this.z;
        if (bool == null || bool.booleanValue() != z2) {
            this.z = Boolean.valueOf(z2);
            long time = new Date().getTime() - this.v;
            this.v = new Date().getTime();
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(time));
            b(z2 ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, map);
            aa.a().a(z2);
        }
    }

    private void b(int i2) {
        a(i2, new HashMap(), true, true);
    }

    private static void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "ProgRvManager: " + str, 3);
    }

    private void b(List<b> list) {
        this.k.clear();
        this.m.clear();
        this.n.clear();
        for (b next : list) {
            X x2 = this.c.get(next.a());
            if (x2 != null) {
                x2.e = true;
                this.k.add(x2);
                this.m.put(x2.k(), next);
                this.n.put(next.a(), C0156i.a.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                a("updateWaterfall() - could not find matching smash for auction response item " + next.a());
            }
        }
        this.l.clear();
    }

    private void b(boolean z2) {
        a(z2, (Map<String, Object>) new HashMap());
    }

    private void c(int i2, Map<String, Object> map) {
        a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, map, true, true);
    }

    private static void c(X x2, String str) {
        String str2 = x2.k() + " : " + str;
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvManager: " + str2, 0);
    }

    private static void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private static boolean c(int i2) {
        return i2 == 1003 || i2 == 1302 || i2 == 1301 || i2 == 1303;
    }

    private void e(X x2) {
        String b = this.m.get(x2.k()).b();
        C0153f.a();
        X x3 = x2;
        x3.a(b, this.g, this.h, this.B, this.C, this.i, C0153f.d(b));
    }

    private void g() {
        this.g = c();
        a(h());
    }

    private List<b> h() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (X next : this.c.values()) {
            if (!next.h() && !this.d.b(next)) {
                copyOnWriteArrayList.add(new b(next.k()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void i() {
        if (this.k.isEmpty()) {
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
            f();
            return;
        }
        a(a.RV_STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.k.size() && i2 < this.w; i3++) {
            X x2 = this.k.get(i3);
            if (x2.e) {
                if (!this.x || !x2.h()) {
                    e(x2);
                    i2++;
                } else if (i2 == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + x2.k() + ". No other instances will be loaded at the same time.";
                    a(str);
                    IronSourceUtils.sendAutomationLog(str);
                    e(x2);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + x2.k() + " as a non bidder is being loaded";
                    a(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a(i2, new HashMap(), false, false);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        Map<String, Object> map;
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        a(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.B = i3;
        this.C = str2;
        this.h = null;
        g();
        if (TextUtils.isEmpty(str)) {
            map = a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        } else {
            map = a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        }
        b((int) IronSourceConstants.RV_AUCTION_FAILED, map);
        if (!this.s || !this.y) {
            e();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Map<String, Object> map) {
        a(i2, map, false, false);
    }

    public final void a(Context context, boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "ProgRvManager Should Track Network State: " + z2, 0);
        try {
            this.D = z2;
            if (this.D) {
                if (this.E == null) {
                    this.E = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.E, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.E != null) {
                context.getApplicationContext().unregisterReceiver(this.E);
            }
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        a("current state=" + this.A + ", new state=" + aVar);
        this.A = aVar;
    }

    public final void a(X x2) {
        synchronized (this) {
            this.i++;
            c(x2, "onRewardedVideoAdOpened");
            aa.a().b();
            if (this.q) {
                b bVar = this.m.get(x2.k());
                if (bVar != null) {
                    C0155h.a(bVar, x2.i(), this.o, this.t);
                    this.n.put(x2.k(), C0156i.a.ISAuctionPerformanceShowedSuccessfully);
                    a(bVar, this.t);
                } else {
                    String k2 = x2.k();
                    b("onRewardedVideoAdOpened showing instance " + k2 + " missing from waterfall");
                    b((int) IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1011}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Showing missing " + this.A}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2}}));
                }
            }
            this.p.a();
        }
    }

    public final void a(X x2, Placement placement) {
        c(x2, "onRewardedVideoAdRewarded");
        aa.a().a(placement);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0140, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.ironsource.mediationsdk.X r12, java.lang.String r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = "onLoadSuccess "
            c((com.ironsource.mediationsdk.X) r12, (java.lang.String) r0)     // Catch:{ all -> 0x0141 }
            java.lang.String r0 = r11.g     // Catch:{ all -> 0x0141 }
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = r11.g     // Catch:{ all -> 0x0141 }
            boolean r0 = r13.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0141 }
            if (r0 != 0) goto L_0x0062
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = "onLoadSuccess was invoked with auctionId: "
            r0.<init>(r4)     // Catch:{ all -> 0x0141 }
            r0.append(r13)     // Catch:{ all -> 0x0141 }
            java.lang.String r13 = " and the current id is "
            r0.append(r13)     // Catch:{ all -> 0x0141 }
            java.lang.String r13 = r11.g     // Catch:{ all -> 0x0141 }
            r0.append(r13)     // Catch:{ all -> 0x0141 }
            java.lang.String r13 = r0.toString()     // Catch:{ all -> 0x0141 }
            a((java.lang.String) r13)     // Catch:{ all -> 0x0141 }
            r13 = 81315(0x13da3, float:1.13947E-40)
            java.lang.Object[][] r0 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0141 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0141 }
            java.lang.String r5 = "errorCode"
            r4[r1] = r5     // Catch:{ all -> 0x0141 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0141 }
            r4[r3] = r5     // Catch:{ all -> 0x0141 }
            r0[r1] = r4     // Catch:{ all -> 0x0141 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = "reason"
            r2[r1] = r4     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = "onLoadSuccess wrong auction ID "
            r1.<init>(r4)     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.V$a r4 = r11.A     // Catch:{ all -> 0x0141 }
            r1.append(r4)     // Catch:{ all -> 0x0141 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0141 }
            r2[r3] = r1     // Catch:{ all -> 0x0141 }
            r0[r3] = r2     // Catch:{ all -> 0x0141 }
            r12.b(r13, r0)     // Catch:{ all -> 0x0141 }
            monitor-exit(r11)
            return
        L_0x0062:
            com.ironsource.mediationsdk.V$a r0 = r11.A     // Catch:{ all -> 0x0141 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r4 = r11.n     // Catch:{ all -> 0x0141 }
            java.lang.String r5 = r12.k()     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.i$a r6 = com.ironsource.mediationsdk.C0156i.a.ISAuctionPerformanceLoadedSuccessfully     // Catch:{ all -> 0x0141 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.V$a r4 = r11.A     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.V$a r5 = com.ironsource.mediationsdk.V.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x0141 }
            if (r4 != r5) goto L_0x013f
            r11.b((boolean) r3)     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.V$a r4 = com.ironsource.mediationsdk.V.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0141 }
            r11.a((com.ironsource.mediationsdk.V.a) r4)     // Catch:{ all -> 0x0141 }
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x0141 }
            r4.<init>()     // Catch:{ all -> 0x0141 }
            long r4 = r4.getTime()     // Catch:{ all -> 0x0141 }
            long r6 = r11.j     // Catch:{ all -> 0x0141 }
            long r4 = r4 - r6
            r6 = 1003(0x3eb, float:1.406E-42)
            java.lang.Object[][] r7 = new java.lang.Object[r3][]     // Catch:{ all -> 0x0141 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0141 }
            java.lang.String r9 = "duration"
            r8[r1] = r9     // Catch:{ all -> 0x0141 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0141 }
            r8[r3] = r4     // Catch:{ all -> 0x0141 }
            r7[r1] = r8     // Catch:{ all -> 0x0141 }
            java.util.Map r4 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r7)     // Catch:{ all -> 0x0141 }
            r11.b((int) r6, (java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.x r4 = r11.F     // Catch:{ all -> 0x0141 }
            r5 = 0
            r4.a(r5)     // Catch:{ all -> 0x0141 }
            boolean r4 = r11.q     // Catch:{ all -> 0x0141 }
            if (r4 == 0) goto L_0x013f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b> r4 = r11.m     // Catch:{ all -> 0x0141 }
            java.lang.String r5 = r12.k()     // Catch:{ all -> 0x0141 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x0141 }
            r10 = r4
            com.ironsource.mediationsdk.server.b r10 = (com.ironsource.mediationsdk.server.b) r10     // Catch:{ all -> 0x0141 }
            if (r10 == 0) goto L_0x00d9
            int r13 = r12.i()     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.server.b r0 = r11.o     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.C0155h.a(r10, r13, r0)     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.h r5 = r11.e     // Catch:{ all -> 0x0141 }
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.X> r13 = r11.k     // Catch:{ all -> 0x0141 }
            r6 = r13
            java.util.concurrent.CopyOnWriteArrayList r6 = (java.util.concurrent.CopyOnWriteArrayList) r6     // Catch:{ all -> 0x0141 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b> r7 = r11.m     // Catch:{ all -> 0x0141 }
            int r8 = r12.i()     // Catch:{ all -> 0x0141 }
            com.ironsource.mediationsdk.server.b r9 = r11.o     // Catch:{ all -> 0x0141 }
            r5.a((java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.Y>) r6, (java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b>) r7, (int) r8, (com.ironsource.mediationsdk.server.b) r9, (com.ironsource.mediationsdk.server.b) r10)     // Catch:{ all -> 0x0141 }
            monitor-exit(r11)
            return
        L_0x00d9:
            java.lang.String r12 = r12.k()     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r5 = "onLoadSuccess winner instance "
            r4.<init>(r5)     // Catch:{ all -> 0x0141 }
            r4.append(r12)     // Catch:{ all -> 0x0141 }
            java.lang.String r5 = " missing from waterfall. auctionId: "
            r4.append(r5)     // Catch:{ all -> 0x0141 }
            r4.append(r13)     // Catch:{ all -> 0x0141 }
            java.lang.String r13 = " and the current id is "
            r4.append(r13)     // Catch:{ all -> 0x0141 }
            java.lang.String r13 = r11.g     // Catch:{ all -> 0x0141 }
            r4.append(r13)     // Catch:{ all -> 0x0141 }
            java.lang.String r13 = r4.toString()     // Catch:{ all -> 0x0141 }
            b((java.lang.String) r13)     // Catch:{ all -> 0x0141 }
            r13 = 81317(0x13da5, float:1.1395E-40)
            r4 = 3
            java.lang.Object[][] r4 = new java.lang.Object[r4][]     // Catch:{ all -> 0x0141 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0141 }
            java.lang.String r6 = "errorCode"
            r5[r1] = r6     // Catch:{ all -> 0x0141 }
            r6 = 1010(0x3f2, float:1.415E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0141 }
            r5[r3] = r6     // Catch:{ all -> 0x0141 }
            r4[r1] = r5     // Catch:{ all -> 0x0141 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0141 }
            java.lang.String r6 = "reason"
            r5[r1] = r6     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            java.lang.String r7 = "Loaded missing "
            r6.<init>(r7)     // Catch:{ all -> 0x0141 }
            r6.append(r0)     // Catch:{ all -> 0x0141 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0141 }
            r5[r3] = r0     // Catch:{ all -> 0x0141 }
            r4[r3] = r5     // Catch:{ all -> 0x0141 }
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0141 }
            java.lang.String r5 = "ext1"
            r0[r1] = r5     // Catch:{ all -> 0x0141 }
            r0[r3] = r12     // Catch:{ all -> 0x0141 }
            r4[r2] = r0     // Catch:{ all -> 0x0141 }
            java.util.Map r12 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r4)     // Catch:{ all -> 0x0141 }
            r11.b((int) r13, (java.util.Map<java.lang.String, java.lang.Object>) r12)     // Catch:{ all -> 0x0141 }
        L_0x013f:
            monitor-exit(r11)
            return
        L_0x0141:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.V.a(com.ironsource.mediationsdk.X, java.lang.String):void");
    }

    public final void a(IronSourceError ironSourceError, X x2) {
        synchronized (this) {
            c(x2, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
            c((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}}));
            aa.a().a(ironSourceError);
            this.y = false;
            this.n.put(x2.k(), C0156i.a.ISAuctionPerformanceFailedToShow);
            if (this.A != a.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
            this.p.c();
        }
    }

    public final synchronized void a(Placement placement) {
        if (placement == null) {
            c("showRewardedVideo error: empty default placement");
            aa.a().a(new IronSourceError(1021, "showRewardedVideo error: empty default placement"));
            a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1021}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "showRewardedVideo error: empty default placement"}}), false, true);
            return;
        }
        this.t = placement.getPlacementName();
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "showRewardedVideo(" + placement + ")", 0);
        b((int) IronSourceConstants.RV_API_SHOW_CALLED);
        if (this.y) {
            c("showRewardedVideo error: can't show ad while an ad is already showing");
            aa.a().a(new IronSourceError(IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW, "showRewardedVideo error: can't show ad while an ad is already showing"));
            c((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "showRewardedVideo error: can't show ad while an ad is already showing"}}));
        } else if (this.A != a.RV_STATE_READY_TO_SHOW) {
            c("showRewardedVideo error: show called while no ads are available");
            aa.a().a(new IronSourceError(IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE, "showRewardedVideo error: show called while no ads are available"));
            c((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "showRewardedVideo error: show called while no ads are available"}}));
        } else if (k.c(ContextProvider.getInstance().getApplicationContext(), this.t)) {
            String str = "showRewardedVideo error: placement " + this.t + " is capped";
            c(str);
            aa.a().a(new IronSourceError(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, str));
            c((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}}));
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<X> it = this.k.iterator();
            while (it.hasNext()) {
                X next = it.next();
                if (next.c()) {
                    this.y = true;
                    next.a(true, this.i);
                    a("showVideo()");
                    this.d.a(next);
                    if (this.d.b(next)) {
                        next.f();
                        IronSourceUtils.sendAutomationLog(next.k() + " rewarded video is now session capped");
                    }
                    k.e(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName());
                    if (k.c(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName())) {
                        b((int) IronSourceConstants.RV_CAP_PLACEMENT);
                    }
                    this.F.a();
                    next.a(placement, this.i);
                    a(a.RV_STATE_NOT_LOADED);
                    return;
                }
                if (next.o() != null) {
                    stringBuffer.append(next.k() + ":" + next.o() + ",");
                }
                next.a(false, this.i);
            }
            a("showRewardedVideo(): No ads to show");
            aa.a().a(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            HashMap hashMap = new HashMap();
            hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW));
            hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, "showRewardedVideo(): No ads to show");
            if (stringBuffer.length() != 0) {
                hashMap.put(IronSourceConstants.EVENTS_EXT1, stringBuffer.toString());
            }
            c((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, (Map<String, Object>) hashMap);
            this.p.c();
        }
    }

    public final void a(List<b> list, String str, b bVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        a("makeAuction(): success");
        this.g = str;
        this.o = bVar;
        this.h = jSONObject;
        this.B = i2;
        this.C = "";
        if (!TextUtils.isEmpty(str2)) {
            b((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i3)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}}));
        }
        a(jSONObject2, IronSource.AD_UNIT.REWARDED_VIDEO);
        if (this.a.a(IronSource.AD_UNIT.REWARDED_VIDEO)) {
            b((int) IronSourceConstants.RV_AD_UNIT_CAPPED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_AUCTION_ID, str}}));
            f();
            return;
        }
        b((int) IronSourceConstants.RV_AUCTION_SUCCESS, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}}));
        a(list);
        if (!this.s || !this.y) {
            e();
        }
    }

    public final void a(boolean z2) {
        if (this.D) {
            boolean z3 = false;
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z2, 0);
            Boolean bool = this.z;
            if (bool != null && ((z2 && !bool.booleanValue() && a_()) || (!z2 && this.z.booleanValue()))) {
                z3 = true;
            }
            if (z3) {
                b(z2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a_() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.D     // Catch:{ all -> 0x0040 }
            r1 = 0
            if (r0 == 0) goto L_0x0016
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0040 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0040 }
            boolean r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.isNetworkConnected(r0)     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x0016
            monitor-exit(r3)
            return r1
        L_0x0016:
            com.ironsource.mediationsdk.V$a r0 = r3.A     // Catch:{ all -> 0x0040 }
            com.ironsource.mediationsdk.V$a r2 = com.ironsource.mediationsdk.V.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0040 }
            if (r0 != r2) goto L_0x003e
            boolean r0 = r3.y     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0021
            goto L_0x003e
        L_0x0021:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.X> r0 = r3.k     // Catch:{ all -> 0x0040 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0040 }
        L_0x0027:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0040 }
            com.ironsource.mediationsdk.X r2 = (com.ironsource.mediationsdk.X) r2     // Catch:{ all -> 0x0040 }
            boolean r2 = r2.c()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0027
            r0 = 1
            monitor-exit(r3)
            return r0
        L_0x003c:
            monitor-exit(r3)
            return r1
        L_0x003e:
            monitor-exit(r3)
            return r1
        L_0x0040:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.V.a_():boolean");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, Map<String, Object> map) {
        a(i2, map, false, true);
    }

    public final void b(X x2) {
        synchronized (this) {
            x2.a((int) IronSourceConstants.RV_INSTANCE_CLOSED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, "otherRVAvailable = false"}});
            c(x2, "onRewardedVideoAdClosed, mediation state: " + this.A.name());
            aa.a().c();
            this.y = false;
            if (this.A != a.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
            if (!this.r) {
                this.p.b();
            } else if (this.l != null && this.l.size() > 0) {
                new Timer().schedule(new TimerTask() {
                    public final void run() {
                        V.this.e();
                    }
                }, this.u);
            }
        }
    }

    public final void b(X x2, Placement placement) {
        c(x2, "onRewardedVideoAdClicked");
        aa.a().b(placement);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015b, code lost:
        r9 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0163, code lost:
        if (r9.hasNext() == false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0165, code lost:
        e((com.ironsource.mediationsdk.X) r9.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016f, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.ironsource.mediationsdk.X r9, java.lang.String r10) {
        /*
            r8 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            monitor-enter(r8)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = "onLoadError state="
            r1.<init>(r2)     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.V$a r2 = r8.A     // Catch:{ all -> 0x0170 }
            r1.append(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0170 }
            c((com.ironsource.mediationsdk.X) r9, (java.lang.String) r1)     // Catch:{ all -> 0x0170 }
            java.lang.String r1 = r8.g     // Catch:{ all -> 0x0170 }
            boolean r1 = r10.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0170 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0072
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            java.lang.String r1 = "onLoadError was invoked with auctionId:"
            r0.<init>(r1)     // Catch:{ all -> 0x0170 }
            r0.append(r10)     // Catch:{ all -> 0x0170 }
            java.lang.String r10 = " and the current id is "
            r0.append(r10)     // Catch:{ all -> 0x0170 }
            java.lang.String r10 = r8.g     // Catch:{ all -> 0x0170 }
            r0.append(r10)     // Catch:{ all -> 0x0170 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0170 }
            a((java.lang.String) r10)     // Catch:{ all -> 0x0170 }
            r10 = 81315(0x13da3, float:1.13947E-40)
            r0 = 2
            java.lang.Object[][] r1 = new java.lang.Object[r0][]     // Catch:{ all -> 0x0170 }
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ all -> 0x0170 }
            java.lang.String r5 = "errorCode"
            r4[r3] = r5     // Catch:{ all -> 0x0170 }
            r5 = 4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0170 }
            r4[r2] = r5     // Catch:{ all -> 0x0170 }
            r1[r3] = r4     // Catch:{ all -> 0x0170 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = "reason"
            r0[r3] = r4     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = "loadError wrong auction ID "
            r3.<init>(r4)     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.V$a r4 = r8.A     // Catch:{ all -> 0x0170 }
            r3.append(r4)     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0170 }
            r0[r2] = r3     // Catch:{ all -> 0x0170 }
            r1[r2] = r0     // Catch:{ all -> 0x0170 }
            r9.b(r10, r1)     // Catch:{ all -> 0x0170 }
            monitor-exit(r8)     // Catch:{ all -> 0x0170 }
            return
        L_0x0072:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r10 = r8.n     // Catch:{ all -> 0x0170 }
            java.lang.String r1 = r9.k()     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.i$a r4 = com.ironsource.mediationsdk.C0156i.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x0170 }
            r10.put(r1, r4)     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.V$a r10 = r8.A     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.V$a r1 = com.ironsource.mediationsdk.V.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x0170 }
            if (r10 == r1) goto L_0x008b
            com.ironsource.mediationsdk.V$a r10 = r8.A     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.V$a r1 = com.ironsource.mediationsdk.V.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0170 }
            if (r10 == r1) goto L_0x008b
            monitor-exit(r8)     // Catch:{ all -> 0x0170 }
            return
        L_0x008b:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.X> r10 = r8.k     // Catch:{ all -> 0x0170 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0170 }
            r1 = r3
            r4 = r1
        L_0x0093:
            boolean r5 = r10.hasNext()     // Catch:{ all -> 0x0170 }
            if (r5 == 0) goto L_0x013e
            java.lang.Object r5 = r10.next()     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.X r5 = (com.ironsource.mediationsdk.X) r5     // Catch:{ all -> 0x0170 }
            boolean r6 = r5.e     // Catch:{ all -> 0x0170 }
            if (r6 == 0) goto L_0x0120
            boolean r6 = r8.x     // Catch:{ all -> 0x0170 }
            if (r6 == 0) goto L_0x00f8
            boolean r6 = r5.h()     // Catch:{ all -> 0x0170 }
            if (r6 == 0) goto L_0x00f8
            if (r1 != 0) goto L_0x00d0
            if (r4 == 0) goto L_0x00b2
            goto L_0x00d0
        L_0x00b2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            java.lang.String r7 = "Advanced Loading: Starting to load bidder "
            r6.<init>(r7)     // Catch:{ all -> 0x0170 }
            java.lang.String r7 = r5.k()     // Catch:{ all -> 0x0170 }
            r6.append(r7)     // Catch:{ all -> 0x0170 }
            java.lang.String r7 = ". No other instances will be loaded at the same time."
            r6.append(r7)     // Catch:{ all -> 0x0170 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0170 }
            a((java.lang.String) r6)     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r6)     // Catch:{ all -> 0x0170 }
            goto L_0x00f8
        L_0x00d0:
            if (r1 == 0) goto L_0x00d5
            java.lang.String r9 = "a non bidder is being loaded"
            goto L_0x00d7
        L_0x00d5:
            java.lang.String r9 = "a non bidder was already loaded successfully"
        L_0x00d7:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = "Advanced Loading: Won't start loading bidder "
            r10.<init>(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = r5.k()     // Catch:{ all -> 0x0170 }
            r10.append(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = " as "
            r10.append(r2)     // Catch:{ all -> 0x0170 }
            r10.append(r9)     // Catch:{ all -> 0x0170 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x0170 }
            a((java.lang.String) r9)     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r9)     // Catch:{ all -> 0x0170 }
            goto L_0x013e
        L_0x00f8:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b> r6 = r8.m     // Catch:{ all -> 0x0170 }
            java.lang.String r7 = r5.k()     // Catch:{ all -> 0x0170 }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x0170 }
            if (r6 == 0) goto L_0x0093
            r0.add(r5)     // Catch:{ all -> 0x0170 }
            boolean r6 = r8.x     // Catch:{ all -> 0x0170 }
            if (r6 == 0) goto L_0x013e
            boolean r6 = r9.h()     // Catch:{ all -> 0x0170 }
            if (r6 == 0) goto L_0x013e
            boolean r5 = r5.h()     // Catch:{ all -> 0x0170 }
            if (r5 != 0) goto L_0x013e
            int r5 = r0.size()     // Catch:{ all -> 0x0170 }
            int r6 = r8.w     // Catch:{ all -> 0x0170 }
            if (r5 >= r6) goto L_0x013e
            goto L_0x0132
        L_0x0120:
            com.ironsource.mediationsdk.X$a r6 = r5.a     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.X$a r7 = com.ironsource.mediationsdk.X.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x0170 }
            if (r6 == r7) goto L_0x012f
            com.ironsource.mediationsdk.X$a r6 = r5.a     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.X$a r7 = com.ironsource.mediationsdk.X.a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x0170 }
            if (r6 != r7) goto L_0x012d
            goto L_0x012f
        L_0x012d:
            r6 = r3
            goto L_0x0130
        L_0x012f:
            r6 = r2
        L_0x0130:
            if (r6 == 0) goto L_0x0135
        L_0x0132:
            r1 = r2
            goto L_0x0093
        L_0x0135:
            boolean r5 = r5.c()     // Catch:{ all -> 0x0170 }
            if (r5 == 0) goto L_0x0093
            r4 = r2
            goto L_0x0093
        L_0x013e:
            int r9 = r0.size()     // Catch:{ all -> 0x0170 }
            if (r9 != 0) goto L_0x015a
            if (r4 != 0) goto L_0x015a
            if (r1 != 0) goto L_0x015a
            java.lang.String r9 = "onLoadError(): No other available smashes"
            a((java.lang.String) r9)     // Catch:{ all -> 0x0170 }
            r8.b((boolean) r3)     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.V$a r9 = com.ironsource.mediationsdk.V.a.RV_STATE_NOT_LOADED     // Catch:{ all -> 0x0170 }
            r8.a((com.ironsource.mediationsdk.V.a) r9)     // Catch:{ all -> 0x0170 }
            com.ironsource.mediationsdk.ad r9 = r8.p     // Catch:{ all -> 0x0170 }
            r9.d()     // Catch:{ all -> 0x0170 }
        L_0x015a:
            monitor-exit(r8)     // Catch:{ all -> 0x0170 }
            java.util.Iterator r9 = r0.iterator()
        L_0x015f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x016f
            java.lang.Object r10 = r9.next()
            com.ironsource.mediationsdk.X r10 = (com.ironsource.mediationsdk.X) r10
            r8.e(r10)
            goto L_0x015f
        L_0x016f:
            return
        L_0x0170:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0170 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.V.b(com.ironsource.mediationsdk.X, java.lang.String):void");
    }

    public final void c(X x2) {
        c(x2, "onRewardedVideoAdStarted");
        aa.a().d();
    }

    public final void c_() {
        a(a.RV_STATE_NOT_LOADED);
        a(false, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "loaded ads are expired"}}));
        a(0);
    }

    public final synchronized void d() {
        a("onLoadTriggered: RV load was triggered in " + this.A + " state");
        a(0);
    }

    public final void d(X x2) {
        c(x2, "onRewardedVideoAdEnded");
        aa.a().e();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        b(this.l);
        i();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        a(a.RV_STATE_NOT_LOADED);
        b(false);
        this.p.d();
    }
}
