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
import com.ironsource.mediationsdk.J;
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
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
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

final class I extends C0161n implements j, K, ae, C0150c, C0154g, C0173z {
    private Boolean A;
    private C0171x B;
    L c;
    C0156i d;
    C0155h e;
    long f;
    final ConcurrentHashMap<String, J> g;
    n h;
    int i = 1;
    a j;
    final Object k = new Object();
    private ConcurrentHashMap<String, b> l;
    private ConcurrentHashMap<String, C0156i.a> m;
    private b n;
    private JSONObject o;
    private ad p;
    private boolean q;
    private String r = "";
    private int s;
    private NetworkStateReceiver t;
    private boolean u = false;
    private String v;
    private int w;
    private boolean x;
    private boolean y;
    private long z;

    enum a {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public I(List<NetworkSettings> list, o oVar, String str, String str2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        o oVar2 = oVar;
        long time = new Date().getTime();
        a((int) IronSourceConstants.RV_MANAGER_INIT_STARTED);
        a(a.RV_STATE_INITIATING);
        this.A = null;
        this.w = oVar2.c;
        this.x = oVar2.d;
        this.v = "";
        this.o = null;
        c cVar = oVar2.l;
        this.y = false;
        this.c = new L(oVar2.l.o, oVar2.l.g);
        this.l = new ConcurrentHashMap<>();
        this.m = new ConcurrentHashMap<>();
        this.z = new Date().getTime();
        this.q = cVar.e > 0;
        if (this.q) {
            this.e = new C0155h("rewardedVideo", cVar, this);
        }
        this.p = new ad(cVar, this);
        this.g = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings next : list) {
            AbstractAdapter a2 = C0151d.a().a(next, next.getRewardedVideoSettings(), false, false);
            if (a2 != null) {
                J j2 = r0;
                J j3 = new J(str, str2, next, this, oVar2.e, a2, this.i);
                String k2 = j2.k();
                this.g.put(k2, j2);
                arrayList.add(k2);
            }
        }
        this.d = new C0156i(arrayList, cVar.f);
        this.h = new n(new ArrayList(this.g.values()));
        a((int) IronSourceConstants.RV_MANAGER_INIT_ENDED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}}));
        this.B = new C0171x(oVar2.i, this);
        a(cVar.i);
    }

    private String a(b bVar) {
        J j2 = this.g.get(bVar.a());
        String num = j2 != null ? Integer.toString(j2.i()) : TextUtils.isEmpty(bVar.b()) ? "1" : "2";
        return num + bVar.a();
    }

    private void a(int i2, Map<String, Object> map, boolean z2, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z3 && !TextUtils.isEmpty(this.c.b)) {
            hashMap.put(IronSourceConstants.EVENTS_AUCTION_ID, this.c.b);
        }
        JSONObject jSONObject = this.o;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.o);
        }
        if (z2 && !TextUtils.isEmpty(this.v)) {
            hashMap.put("placement", this.v);
        }
        if (b(i2)) {
            h.e();
            h.a((Map<String, Object>) hashMap, this.s, this.r);
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
                logger.log(ironSourceTag, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        h.e().b(new com.ironsource.mediationsdk.a.c(i2, new JSONObject(hashMap)));
    }

    private void a(long j2) {
        if (this.h.a()) {
            a("all smashes are capped");
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "all smashes are capped"}}));
            e();
            return;
        }
        a(IronSource.AD_UNIT.REWARDED_VIDEO);
        if (this.q) {
            if (!this.m.isEmpty()) {
                this.d.a(this.m);
                this.m.clear();
            }
            new Timer().schedule(new TimerTask() {
                public final void run() {
                    I i = I.this;
                    synchronized (i.k) {
                        if (i.j != a.RV_STATE_AUCTION_IN_PROGRESS) {
                            i.a(a.RV_STATE_AUCTION_IN_PROGRESS);
                            AsyncTask.execute(new Runnable() {
                                public final void run() {
                                    StringBuilder sb;
                                    I i = I.this;
                                    I.a("makeAuction()");
                                    I.this.f = new Date().getTime();
                                    HashMap hashMap = new HashMap();
                                    ArrayList arrayList = new ArrayList();
                                    StringBuilder sb2 = new StringBuilder();
                                    for (J next : I.this.g.values()) {
                                        if (!I.this.h.b(next) && I.this.c.b(next)) {
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
                                        I.this.b((int) IronSourceConstants.RV_AUCTION_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}}));
                                        I i2 = I.this;
                                        I.a("makeAuction() failed - No candidates available for auctioning");
                                        I.this.e();
                                        return;
                                    }
                                    I i3 = I.this;
                                    I.a("makeAuction() - request waterfall is: " + sb2);
                                    I.this.a(1000);
                                    I.this.a((int) IronSourceConstants.RV_AUCTION_REQUEST);
                                    I.this.a((int) IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb2.toString()}}));
                                    I.this.e.a(ContextProvider.getInstance().getApplicationContext(), hashMap, arrayList, I.this.d, I.this.i, I.this.b);
                                }
                            });
                        }
                    }
                }
            }, j2);
            return;
        }
        a("auction fallback flow starting");
        f();
        if (this.c.a().isEmpty()) {
            a("loadSmashes -  waterfall is empty");
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
            e();
            return;
        }
        a(1000);
        h();
    }

    private static void a(J j2, String str) {
        String str2 = j2.k() + " : " + str;
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    static void a(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 0);
    }

    private void a(List<b> list, String str, JSONObject jSONObject) {
        this.l.clear();
        this.m.clear();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        StringBuilder sb = new StringBuilder();
        for (b next : list) {
            sb.append(a(next) + ",");
            J j2 = this.g.get(next.a());
            if (j2 != null) {
                AbstractAdapter a2 = C0151d.a().a(j2.d.a);
                if (a2 != null) {
                    J j3 = new J(j2, this, a2, this.i, str, jSONObject, this.s, this.r);
                    j3.e = true;
                    copyOnWriteArrayList.add(j3);
                    this.l.put(j3.k(), next);
                    this.m.put(next.a(), C0156i.a.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                a("updateWaterfall() - could not find matching smash for auction response item " + next.a());
            }
        }
        this.c.a(copyOnWriteArrayList, str);
        if (this.c.b()) {
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfalls hold too many with size=" + this.c.a.size()}}));
        }
        a("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            a("Updated waterfall is empty");
        }
        b((int) IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    private void a(boolean z2, Map<String, Object> map) {
        synchronized (this.k) {
            if (this.A == null || this.A.booleanValue() != z2) {
                this.A = Boolean.valueOf(z2);
                long time = new Date().getTime() - this.z;
                this.z = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(time));
                b(z2 ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, map);
                aa.a().a(z2);
            }
        }
    }

    private static void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 3);
    }

    private static boolean b(int i2) {
        return i2 == 1003 || i2 == 1302 || i2 == 1301 || i2 == 1303;
    }

    private void c(int i2) {
        a(i2, (Map<String, Object>) null, true, true);
    }

    private void c(int i2, Map<String, Object> map) {
        a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, map, true, true);
    }

    private static void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void f() {
        List<b> g2 = g();
        a(g2, "fallback_" + System.currentTimeMillis(), this.o);
    }

    private List<b> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (J next : this.g.values()) {
            if (!next.h() && !this.h.b(next) && this.c.b(next)) {
                copyOnWriteArrayList.add(new b(next.k()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void g(J j2) {
        String b = this.l.get(j2.k()).b();
        j2.b(b);
        j2.a(b);
    }

    private void h() {
        if (this.c.a().isEmpty()) {
            a("loadSmashes -  waterfall is empty");
            b((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
            e();
            return;
        }
        a(a.RV_STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.a().size() && i2 < this.w; i3++) {
            J j2 = this.c.a().get(i3);
            if (j2.e) {
                if (!this.x || !j2.h()) {
                    g(j2);
                    i2++;
                } else if (i2 == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + j2.k() + ". No other instances will be loaded at the same time.";
                    a(str);
                    IronSourceUtils.sendAutomationLog(str);
                    g(j2);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + j2.k() + " as a non bidder is being loaded";
                    a(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a(i2, (Map<String, Object>) null, false, false);
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        Map<String, Object> map;
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        a(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.s = i3;
        this.r = str2;
        this.o = null;
        f();
        if (TextUtils.isEmpty(str)) {
            map = a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        } else {
            map = a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        }
        b((int) IronSourceConstants.RV_AUCTION_FAILED, map);
        h();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Map<String, Object> map) {
        a(i2, map, false, false);
    }

    public final void a(Context context, boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager Should Track Network State: " + z2, 0);
        try {
            this.u = z2;
            if (this.u) {
                if (this.t == null) {
                    this.t = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.t, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.t != null) {
                context.getApplicationContext().unregisterReceiver(this.t);
            }
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        a("current state=" + this.j + ", new state=" + aVar);
        this.j = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x010f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.J r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.k
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = "onLoadSuccess mState="
            r1.<init>(r2)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.I$a r2 = r12.j     // Catch:{ all -> 0x0161 }
            r1.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0161 }
            a((com.ironsource.mediationsdk.J) r13, (java.lang.String) r1)     // Catch:{ all -> 0x0161 }
            java.lang.String r1 = r13.b     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.L r2 = r12.c     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r2.b     // Catch:{ all -> 0x0161 }
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 != r2) goto L_0x0110
            com.ironsource.mediationsdk.I$a r1 = r12.j     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.I$a r2 = com.ironsource.mediationsdk.I.a.RV_STATE_AUCTION_IN_PROGRESS     // Catch:{ all -> 0x0161 }
            if (r1 != r2) goto L_0x0029
            goto L_0x0110
        L_0x0029:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r1 = r12.m     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r13.k()     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.i$a r6 = com.ironsource.mediationsdk.C0156i.a.ISAuctionPerformanceLoadedSuccessfully     // Catch:{ all -> 0x0161 }
            r1.put(r2, r6)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.I$a r1 = r12.j     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.I$a r2 = com.ironsource.mediationsdk.I.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x0161 }
            if (r1 != r2) goto L_0x010e
            r1 = 0
            r12.a((boolean) r5, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.I$a r1 = com.ironsource.mediationsdk.I.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0161 }
            r12.a((com.ironsource.mediationsdk.I.a) r1)     // Catch:{ all -> 0x0161 }
            java.util.Date r1 = new java.util.Date     // Catch:{ all -> 0x0161 }
            r1.<init>()     // Catch:{ all -> 0x0161 }
            long r1 = r1.getTime()     // Catch:{ all -> 0x0161 }
            long r6 = r12.f     // Catch:{ all -> 0x0161 }
            long r1 = r1 - r6
            r6 = 1003(0x3eb, float:1.406E-42)
            java.lang.Object[][] r7 = new java.lang.Object[r5][]     // Catch:{ all -> 0x0161 }
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x0161 }
            java.lang.String r9 = "duration"
            r8[r3] = r9     // Catch:{ all -> 0x0161 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0161 }
            r8[r5] = r1     // Catch:{ all -> 0x0161 }
            r7[r3] = r8     // Catch:{ all -> 0x0161 }
            java.util.Map r1 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r7)     // Catch:{ all -> 0x0161 }
            r12.b((int) r6, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.x r1 = r12.B     // Catch:{ all -> 0x0161 }
            r6 = 0
            r1.a(r6)     // Catch:{ all -> 0x0161 }
            boolean r1 = r12.q     // Catch:{ all -> 0x0161 }
            if (r1 == 0) goto L_0x010e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b> r1 = r12.l     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r13.k()     // Catch:{ all -> 0x0161 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0161 }
            r11 = r1
            com.ironsource.mediationsdk.server.b r11 = (com.ironsource.mediationsdk.server.b) r11     // Catch:{ all -> 0x0161 }
            if (r11 == 0) goto L_0x00a2
            int r1 = r13.i()     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.server.b r2 = r12.n     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.C0155h.a(r11, r1, r2)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.h r6 = r12.e     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.L r1 = r12.c     // Catch:{ all -> 0x0161 }
            java.util.concurrent.CopyOnWriteArrayList r1 = r1.a()     // Catch:{ all -> 0x0161 }
            r7 = r1
            java.util.concurrent.CopyOnWriteArrayList r7 = (java.util.concurrent.CopyOnWriteArrayList) r7     // Catch:{ all -> 0x0161 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b> r8 = r12.l     // Catch:{ all -> 0x0161 }
            int r9 = r13.i()     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.server.b r10 = r12.n     // Catch:{ all -> 0x0161 }
            r6.a((java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.Y>) r7, (java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b>) r8, (int) r9, (com.ironsource.mediationsdk.server.b) r10, (com.ironsource.mediationsdk.server.b) r11)     // Catch:{ all -> 0x0161 }
            goto L_0x010e
        L_0x00a2:
            java.lang.String r1 = r13.k()     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            java.lang.String r6 = "onLoadSuccess winner instance "
            r2.<init>(r6)     // Catch:{ all -> 0x0161 }
            r2.append(r1)     // Catch:{ all -> 0x0161 }
            java.lang.String r6 = " missing from waterfall. auctionId: "
            r2.append(r6)     // Catch:{ all -> 0x0161 }
            java.lang.String r13 = r13.b     // Catch:{ all -> 0x0161 }
            r2.append(r13)     // Catch:{ all -> 0x0161 }
            java.lang.String r13 = " and the current id is "
            r2.append(r13)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.L r13 = r12.c     // Catch:{ all -> 0x0161 }
            java.lang.String r13 = r13.b     // Catch:{ all -> 0x0161 }
            r2.append(r13)     // Catch:{ all -> 0x0161 }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x0161 }
            b((java.lang.String) r13)     // Catch:{ all -> 0x0161 }
            r13 = 81317(0x13da5, float:1.1395E-40)
            r2 = 3
            java.lang.Object[][] r2 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0161 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0161 }
            java.lang.String r7 = "errorCode"
            r6[r3] = r7     // Catch:{ all -> 0x0161 }
            r7 = 1010(0x3f2, float:1.415E-42)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0161 }
            r6[r5] = r7     // Catch:{ all -> 0x0161 }
            r2[r3] = r6     // Catch:{ all -> 0x0161 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0161 }
            java.lang.String r7 = "reason"
            r6[r3] = r7     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            java.lang.String r8 = "Loaded missing "
            r7.<init>(r8)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.I$a r8 = com.ironsource.mediationsdk.I.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x0161 }
            r7.append(r8)     // Catch:{ all -> 0x0161 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0161 }
            r6[r5] = r7     // Catch:{ all -> 0x0161 }
            r2[r5] = r6     // Catch:{ all -> 0x0161 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0161 }
            java.lang.String r7 = "ext1"
            r6[r3] = r7     // Catch:{ all -> 0x0161 }
            r6[r5] = r1     // Catch:{ all -> 0x0161 }
            r2[r4] = r6     // Catch:{ all -> 0x0161 }
            java.util.Map r1 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r2)     // Catch:{ all -> 0x0161 }
            r12.b((int) r13, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x0161 }
        L_0x010e:
            monitor-exit(r0)     // Catch:{ all -> 0x0161 }
            return
        L_0x0110:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = "onLoadSuccess was invoked with auctionId: "
            r1.<init>(r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r13.b     // Catch:{ all -> 0x0161 }
            r1.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = " and the current id is "
            r1.append(r2)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.L r2 = r12.c     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r2.b     // Catch:{ all -> 0x0161 }
            r1.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0161 }
            a((java.lang.String) r1)     // Catch:{ all -> 0x0161 }
            r1 = 81315(0x13da3, float:1.13947E-40)
            java.lang.Object[][] r2 = new java.lang.Object[r4][]     // Catch:{ all -> 0x0161 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0161 }
            java.lang.String r7 = "errorCode"
            r6[r3] = r7     // Catch:{ all -> 0x0161 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0161 }
            r6[r5] = r7     // Catch:{ all -> 0x0161 }
            r2[r3] = r6     // Catch:{ all -> 0x0161 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0161 }
            java.lang.String r6 = "reason"
            r4[r3] = r6     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            java.lang.String r6 = "onLoadSuccess wrong auction ID "
            r3.<init>(r6)     // Catch:{ all -> 0x0161 }
            com.ironsource.mediationsdk.I$a r6 = r12.j     // Catch:{ all -> 0x0161 }
            r3.append(r6)     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0161 }
            r4[r5] = r3     // Catch:{ all -> 0x0161 }
            r2[r5] = r4     // Catch:{ all -> 0x0161 }
            r13.b(r1, r2)     // Catch:{ all -> 0x0161 }
            monitor-exit(r0)     // Catch:{ all -> 0x0161 }
            return
        L_0x0161:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0161 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.I.a(com.ironsource.mediationsdk.J):void");
    }

    public final void a(J j2, Placement placement) {
        a(j2, "onRewardedVideoAdRewarded");
        aa.a().a(placement);
    }

    public final void a(IronSourceError ironSourceError, J j2) {
        a(j2, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.y = false;
        c(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}}));
        aa.a().a(ironSourceError);
        this.m.put(j2.k(), C0156i.a.ISAuctionPerformanceFailedToShow);
        if (this.j != a.RV_STATE_READY_TO_SHOW) {
            a(false, (Map<String, Object>) null);
        }
        this.p.c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01d4, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01d6, code lost:
        a("showVideo()");
        r9.h.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01e6, code lost:
        if (r9.h.b(r6) == false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01e8, code lost:
        r6.b_();
        com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r6.k() + " rewarded video is now session capped");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0203, code lost:
        com.ironsource.mediationsdk.utils.k.e(com.ironsource.environment.ContextProvider.getInstance().getApplicationContext(), r10.getPlacementName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0222, code lost:
        if (com.ironsource.mediationsdk.utils.k.c(com.ironsource.environment.ContextProvider.getInstance().getApplicationContext(), r10.getPlacementName()) == false) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0224, code lost:
        c((int) com.ironsource.mediationsdk.utils.IronSourceConstants.RV_CAP_PLACEMENT);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0229, code lost:
        r9.B.a();
        r6.a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.model.Placement r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.k
            monitor-enter(r0)
            r1 = 1113(0x459, float:1.56E-42)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r10 != 0) goto L_0x0040
            java.lang.String r10 = "showRewardedVideo error: empty default placement"
            c((java.lang.String) r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.logger.IronSourceError r5 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0232 }
            r6 = 1021(0x3fd, float:1.431E-42)
            r5.<init>(r6, r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.aa r7 = com.ironsource.mediationsdk.aa.a()     // Catch:{ all -> 0x0232 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r5)     // Catch:{ all -> 0x0232 }
            java.lang.Object[][] r5 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r8 = "errorCode"
            r7[r4] = r8     // Catch:{ all -> 0x0232 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0232 }
            r7[r3] = r6     // Catch:{ all -> 0x0232 }
            r5[r4] = r7     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r6 = "reason"
            r2[r4] = r6     // Catch:{ all -> 0x0232 }
            r2[r3] = r10     // Catch:{ all -> 0x0232 }
            r5[r3] = r2     // Catch:{ all -> 0x0232 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r5)     // Catch:{ all -> 0x0232 }
            r9.a(r1, r10, r4, r3)     // Catch:{ all -> 0x0232 }
            monitor-exit(r0)     // Catch:{ all -> 0x0232 }
            return
        L_0x0040:
            java.lang.String r5 = r10.getPlacementName()     // Catch:{ all -> 0x0232 }
            r9.v = r5     // Catch:{ all -> 0x0232 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0232 }
            java.lang.String r6 = "showRewardedVideo("
            r5.<init>(r6)     // Catch:{ all -> 0x0232 }
            r5.append(r10)     // Catch:{ all -> 0x0232 }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0232 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0232 }
            r6.log(r7, r5, r4)     // Catch:{ all -> 0x0232 }
            r5 = 1100(0x44c, float:1.541E-42)
            r9.c((int) r5)     // Catch:{ all -> 0x0232 }
            boolean r5 = r9.y     // Catch:{ all -> 0x0232 }
            if (r5 == 0) goto L_0x00a1
            java.lang.String r10 = "showRewardedVideo error: can't show ad while an ad is already showing"
            c((java.lang.String) r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.logger.IronSourceError r5 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0232 }
            r6 = 1022(0x3fe, float:1.432E-42)
            r5.<init>(r6, r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.aa r7 = com.ironsource.mediationsdk.aa.a()     // Catch:{ all -> 0x0232 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r5)     // Catch:{ all -> 0x0232 }
            java.lang.Object[][] r5 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r8 = "errorCode"
            r7[r4] = r8     // Catch:{ all -> 0x0232 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0232 }
            r7[r3] = r6     // Catch:{ all -> 0x0232 }
            r5[r4] = r7     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r6 = "reason"
            r2[r4] = r6     // Catch:{ all -> 0x0232 }
            r2[r3] = r10     // Catch:{ all -> 0x0232 }
            r5[r3] = r2     // Catch:{ all -> 0x0232 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r5)     // Catch:{ all -> 0x0232 }
            r9.c(r1, r10)     // Catch:{ all -> 0x0232 }
            monitor-exit(r0)     // Catch:{ all -> 0x0232 }
            return
        L_0x00a1:
            com.ironsource.mediationsdk.I$a r5 = r9.j     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.I$a r6 = com.ironsource.mediationsdk.I.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0232 }
            if (r5 == r6) goto L_0x00dd
            java.lang.String r10 = "showRewardedVideo error: show called while no ads are available"
            c((java.lang.String) r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.logger.IronSourceError r5 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0232 }
            r6 = 1023(0x3ff, float:1.434E-42)
            r5.<init>(r6, r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.aa r7 = com.ironsource.mediationsdk.aa.a()     // Catch:{ all -> 0x0232 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r5)     // Catch:{ all -> 0x0232 }
            java.lang.Object[][] r5 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r8 = "errorCode"
            r7[r4] = r8     // Catch:{ all -> 0x0232 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0232 }
            r7[r3] = r6     // Catch:{ all -> 0x0232 }
            r5[r4] = r7     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r6 = "reason"
            r2[r4] = r6     // Catch:{ all -> 0x0232 }
            r2[r3] = r10     // Catch:{ all -> 0x0232 }
            r5[r3] = r2     // Catch:{ all -> 0x0232 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r5)     // Catch:{ all -> 0x0232 }
            r9.c(r1, r10)     // Catch:{ all -> 0x0232 }
            monitor-exit(r0)     // Catch:{ all -> 0x0232 }
            return
        L_0x00dd:
            com.ironsource.environment.ContextProvider r5 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0232 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x0232 }
            java.lang.String r6 = r9.v     // Catch:{ all -> 0x0232 }
            boolean r5 = com.ironsource.mediationsdk.utils.k.c((android.content.Context) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0232 }
            if (r5 == 0) goto L_0x0136
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0232 }
            java.lang.String r5 = "showRewardedVideo error: placement "
            r10.<init>(r5)     // Catch:{ all -> 0x0232 }
            java.lang.String r5 = r9.v     // Catch:{ all -> 0x0232 }
            r10.append(r5)     // Catch:{ all -> 0x0232 }
            java.lang.String r5 = " is capped"
            r10.append(r5)     // Catch:{ all -> 0x0232 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0232 }
            c((java.lang.String) r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.logger.IronSourceError r5 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0232 }
            r6 = 524(0x20c, float:7.34E-43)
            r5.<init>(r6, r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.aa r7 = com.ironsource.mediationsdk.aa.a()     // Catch:{ all -> 0x0232 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r5)     // Catch:{ all -> 0x0232 }
            java.lang.Object[][] r5 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r8 = "errorCode"
            r7[r4] = r8     // Catch:{ all -> 0x0232 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0232 }
            r7[r3] = r6     // Catch:{ all -> 0x0232 }
            r5[r4] = r7     // Catch:{ all -> 0x0232 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0232 }
            java.lang.String r6 = "reason"
            r2[r4] = r6     // Catch:{ all -> 0x0232 }
            r2[r3] = r10     // Catch:{ all -> 0x0232 }
            r5[r3] = r2     // Catch:{ all -> 0x0232 }
            java.util.Map r10 = com.ironsource.environment.a.AnonymousClass1.a((java.lang.Object[][]) r5)     // Catch:{ all -> 0x0232 }
            r9.c(r1, r10)     // Catch:{ all -> 0x0232 }
            monitor-exit(r0)     // Catch:{ all -> 0x0232 }
            return
        L_0x0136:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ all -> 0x0232 }
            r2.<init>()     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.L r5 = r9.c     // Catch:{ all -> 0x0232 }
            java.util.concurrent.CopyOnWriteArrayList r5 = r5.a()     // Catch:{ all -> 0x0232 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0232 }
        L_0x0145:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0232 }
            if (r6 == 0) goto L_0x0190
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.J r6 = (com.ironsource.mediationsdk.J) r6     // Catch:{ all -> 0x0232 }
            boolean r7 = r6.b()     // Catch:{ all -> 0x0232 }
            if (r7 == 0) goto L_0x0162
            r9.y = r3     // Catch:{ all -> 0x0232 }
            r6.a((boolean) r3)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.I$a r3 = com.ironsource.mediationsdk.I.a.RV_STATE_NOT_LOADED     // Catch:{ all -> 0x0232 }
            r9.a((com.ironsource.mediationsdk.I.a) r3)     // Catch:{ all -> 0x0232 }
            goto L_0x0191
        L_0x0162:
            java.lang.Long r7 = r6.o()     // Catch:{ all -> 0x0232 }
            if (r7 == 0) goto L_0x018c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0232 }
            r7.<init>()     // Catch:{ all -> 0x0232 }
            java.lang.String r8 = r6.k()     // Catch:{ all -> 0x0232 }
            r7.append(r8)     // Catch:{ all -> 0x0232 }
            java.lang.String r8 = ":"
            r7.append(r8)     // Catch:{ all -> 0x0232 }
            java.lang.Long r8 = r6.o()     // Catch:{ all -> 0x0232 }
            r7.append(r8)     // Catch:{ all -> 0x0232 }
            java.lang.String r8 = ","
            r7.append(r8)     // Catch:{ all -> 0x0232 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0232 }
            r2.append(r7)     // Catch:{ all -> 0x0232 }
        L_0x018c:
            r6.a((boolean) r4)     // Catch:{ all -> 0x0232 }
            goto L_0x0145
        L_0x0190:
            r6 = 0
        L_0x0191:
            if (r6 != 0) goto L_0x01d3
            java.lang.String r10 = "showRewardedVideo(): No ads to show"
            a((java.lang.String) r10)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.aa r3 = com.ironsource.mediationsdk.aa.a()     // Catch:{ all -> 0x0232 }
            java.lang.String r4 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r4 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoAdsToShowError(r4)     // Catch:{ all -> 0x0232 }
            r3.a((com.ironsource.mediationsdk.logger.IronSourceError) r4)     // Catch:{ all -> 0x0232 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0232 }
            r3.<init>()     // Catch:{ all -> 0x0232 }
            java.lang.String r4 = "errorCode"
            r5 = 509(0x1fd, float:7.13E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0232 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0232 }
            java.lang.String r4 = "reason"
            r3.put(r4, r10)     // Catch:{ all -> 0x0232 }
            int r10 = r2.length()     // Catch:{ all -> 0x0232 }
            if (r10 == 0) goto L_0x01c9
            java.lang.String r10 = "ext1"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0232 }
            r3.put(r10, r2)     // Catch:{ all -> 0x0232 }
        L_0x01c9:
            r9.c(r1, r3)     // Catch:{ all -> 0x0232 }
            com.ironsource.mediationsdk.ad r10 = r9.p     // Catch:{ all -> 0x0232 }
            r10.c()     // Catch:{ all -> 0x0232 }
            monitor-exit(r0)     // Catch:{ all -> 0x0232 }
            return
        L_0x01d3:
            monitor-exit(r0)     // Catch:{ all -> 0x0232 }
            if (r6 == 0) goto L_0x0231
            java.lang.String r0 = "showVideo()"
            a((java.lang.String) r0)
            com.ironsource.mediationsdk.utils.n r0 = r9.h
            r0.a(r6)
            com.ironsource.mediationsdk.utils.n r0 = r9.h
            boolean r0 = r0.b(r6)
            if (r0 == 0) goto L_0x0203
            r6.b_()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r6.k()
            r0.append(r1)
            java.lang.String r1 = " rewarded video is now session capped"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r0)
        L_0x0203:
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = r10.getPlacementName()
            com.ironsource.mediationsdk.utils.k.e(r0, r1)
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = r10.getPlacementName()
            boolean r0 = com.ironsource.mediationsdk.utils.k.c((android.content.Context) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x0229
            r0 = 1400(0x578, float:1.962E-42)
            r9.c((int) r0)
        L_0x0229:
            com.ironsource.mediationsdk.x r0 = r9.B
            r0.a()
            r6.a((com.ironsource.mediationsdk.model.Placement) r10)
        L_0x0231:
            return
        L_0x0232:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0232 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.I.a(com.ironsource.mediationsdk.model.Placement):void");
    }

    public final void a(List<b> list, String str, b bVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        a("makeAuction(): success");
        this.n = bVar;
        this.s = i2;
        this.o = jSONObject;
        this.r = "";
        if (!TextUtils.isEmpty(str2)) {
            b((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i3)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}}));
        }
        a(jSONObject2, IronSource.AD_UNIT.REWARDED_VIDEO);
        if (this.a.a(IronSource.AD_UNIT.REWARDED_VIDEO)) {
            b((int) IronSourceConstants.RV_AD_UNIT_CAPPED, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_AUCTION_ID, str}}));
            e();
            return;
        }
        a(list, str, this.o);
        b((int) IronSourceConstants.RV_AUCTION_SUCCESS, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}}));
        h();
    }

    public final void a(boolean z2) {
        if (this.u) {
            boolean z3 = false;
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z2, 0);
            Boolean bool = this.A;
            if (bool != null && ((z2 && !bool.booleanValue() && a_()) || (!z2 && this.A.booleanValue()))) {
                z3 = true;
            }
            if (z3) {
                a(z2, (Map<String, Object>) null);
            }
        }
    }

    public final boolean a_() {
        if ((!this.u || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) && this.j == a.RV_STATE_READY_TO_SHOW && !this.y) {
            Iterator<J> it = this.c.a().iterator();
            while (it.hasNext()) {
                if (it.next().b()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, Map<String, Object> map) {
        a(i2, map, false, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011f, code lost:
        r11 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0127, code lost:
        if (r11.hasNext() == false) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0129, code lost:
        g((com.ironsource.mediationsdk.J) r11.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0133, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.ironsource.mediationsdk.J r11) {
        /*
            r10 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            java.lang.Object r1 = r10.k
            monitor-enter(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            java.lang.String r3 = "onLoadError mState="
            r2.<init>(r3)     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.I$a r3 = r10.j     // Catch:{ all -> 0x0187 }
            r2.append(r3)     // Catch:{ all -> 0x0187 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0187 }
            a((com.ironsource.mediationsdk.J) r11, (java.lang.String) r2)     // Catch:{ all -> 0x0187 }
            java.lang.String r2 = r11.b     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.L r3 = r10.c     // Catch:{ all -> 0x0187 }
            java.lang.String r3 = r3.b     // Catch:{ all -> 0x0187 }
            r4 = 1
            r5 = 0
            if (r2 != r3) goto L_0x0134
            com.ironsource.mediationsdk.I$a r2 = r10.j     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.I$a r3 = com.ironsource.mediationsdk.I.a.RV_STATE_AUCTION_IN_PROGRESS     // Catch:{ all -> 0x0187 }
            if (r2 != r3) goto L_0x002d
            goto L_0x0134
        L_0x002d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r2 = r10.m     // Catch:{ all -> 0x0187 }
            java.lang.String r3 = r11.k()     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.i$a r6 = com.ironsource.mediationsdk.C0156i.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x0187 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.I$a r2 = r10.j     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.I$a r3 = com.ironsource.mediationsdk.I.a.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x0187 }
            if (r2 == r3) goto L_0x0046
            com.ironsource.mediationsdk.I$a r2 = r10.j     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.I$a r3 = com.ironsource.mediationsdk.I.a.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x0187 }
            if (r2 == r3) goto L_0x0046
            monitor-exit(r1)     // Catch:{ all -> 0x0187 }
            return
        L_0x0046:
            com.ironsource.mediationsdk.L r2 = r10.c     // Catch:{ all -> 0x0187 }
            java.util.concurrent.CopyOnWriteArrayList r2 = r2.a()     // Catch:{ all -> 0x0187 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0187 }
            r3 = r5
            r6 = r3
        L_0x0052:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x0187 }
            if (r7 == 0) goto L_0x00fd
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.J r7 = (com.ironsource.mediationsdk.J) r7     // Catch:{ all -> 0x0187 }
            boolean r8 = r7.e     // Catch:{ all -> 0x0187 }
            if (r8 == 0) goto L_0x00df
            boolean r8 = r10.x     // Catch:{ all -> 0x0187 }
            if (r8 == 0) goto L_0x00b7
            boolean r8 = r7.h()     // Catch:{ all -> 0x0187 }
            if (r8 == 0) goto L_0x00b7
            if (r3 != 0) goto L_0x008f
            if (r6 == 0) goto L_0x0071
            goto L_0x008f
        L_0x0071:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            java.lang.String r9 = "Advanced Loading: Starting to load bidder "
            r8.<init>(r9)     // Catch:{ all -> 0x0187 }
            java.lang.String r9 = r7.k()     // Catch:{ all -> 0x0187 }
            r8.append(r9)     // Catch:{ all -> 0x0187 }
            java.lang.String r9 = ". No other instances will be loaded at the same time."
            r8.append(r9)     // Catch:{ all -> 0x0187 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0187 }
            a((java.lang.String) r8)     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r8)     // Catch:{ all -> 0x0187 }
            goto L_0x00b7
        L_0x008f:
            if (r3 == 0) goto L_0x0094
            java.lang.String r11 = "a non bidder is being loaded"
            goto L_0x0096
        L_0x0094:
            java.lang.String r11 = "a non bidder was already loaded successfully"
        L_0x0096:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            java.lang.String r4 = "Advanced Loading: Won't start loading bidder "
            r2.<init>(r4)     // Catch:{ all -> 0x0187 }
            java.lang.String r4 = r7.k()     // Catch:{ all -> 0x0187 }
            r2.append(r4)     // Catch:{ all -> 0x0187 }
            java.lang.String r4 = " as "
            r2.append(r4)     // Catch:{ all -> 0x0187 }
            r2.append(r11)     // Catch:{ all -> 0x0187 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x0187 }
            a((java.lang.String) r11)     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r11)     // Catch:{ all -> 0x0187 }
            goto L_0x00fd
        L_0x00b7:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.server.b> r8 = r10.l     // Catch:{ all -> 0x0187 }
            java.lang.String r9 = r7.k()     // Catch:{ all -> 0x0187 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x0187 }
            if (r8 == 0) goto L_0x0052
            r0.add(r7)     // Catch:{ all -> 0x0187 }
            boolean r8 = r10.x     // Catch:{ all -> 0x0187 }
            if (r8 == 0) goto L_0x00fd
            boolean r8 = r11.h()     // Catch:{ all -> 0x0187 }
            if (r8 == 0) goto L_0x00fd
            boolean r7 = r7.h()     // Catch:{ all -> 0x0187 }
            if (r7 != 0) goto L_0x00fd
            int r7 = r0.size()     // Catch:{ all -> 0x0187 }
            int r8 = r10.w     // Catch:{ all -> 0x0187 }
            if (r7 >= r8) goto L_0x00fd
            goto L_0x00f1
        L_0x00df:
            com.ironsource.mediationsdk.J$a r8 = r7.a     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.J$a r9 = com.ironsource.mediationsdk.J.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x0187 }
            if (r8 == r9) goto L_0x00ee
            com.ironsource.mediationsdk.J$a r8 = r7.a     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.J$a r9 = com.ironsource.mediationsdk.J.a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x0187 }
            if (r8 != r9) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r8 = r5
            goto L_0x00ef
        L_0x00ee:
            r8 = r4
        L_0x00ef:
            if (r8 == 0) goto L_0x00f4
        L_0x00f1:
            r3 = r4
            goto L_0x0052
        L_0x00f4:
            boolean r7 = r7.b()     // Catch:{ all -> 0x0187 }
            if (r7 == 0) goto L_0x0052
            r6 = r4
            goto L_0x0052
        L_0x00fd:
            int r11 = r0.size()     // Catch:{ all -> 0x0187 }
            if (r11 != 0) goto L_0x011e
            if (r6 != 0) goto L_0x011e
            if (r3 != 0) goto L_0x011e
            java.lang.String r11 = "onLoadError(): No other available smashes"
            a((java.lang.String) r11)     // Catch:{ all -> 0x0187 }
            boolean r11 = r10.y     // Catch:{ all -> 0x0187 }
            if (r11 != 0) goto L_0x0114
            r11 = 0
            r10.a((boolean) r5, (java.util.Map<java.lang.String, java.lang.Object>) r11)     // Catch:{ all -> 0x0187 }
        L_0x0114:
            com.ironsource.mediationsdk.I$a r11 = com.ironsource.mediationsdk.I.a.RV_STATE_NOT_LOADED     // Catch:{ all -> 0x0187 }
            r10.a((com.ironsource.mediationsdk.I.a) r11)     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.ad r11 = r10.p     // Catch:{ all -> 0x0187 }
            r11.d()     // Catch:{ all -> 0x0187 }
        L_0x011e:
            monitor-exit(r1)     // Catch:{ all -> 0x0187 }
            java.util.Iterator r11 = r0.iterator()
        L_0x0123:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0133
            java.lang.Object r0 = r11.next()
            com.ironsource.mediationsdk.J r0 = (com.ironsource.mediationsdk.J) r0
            r10.g(r0)
            goto L_0x0123
        L_0x0133:
            return
        L_0x0134:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            java.lang.String r2 = "onLoadError was invoked with auctionId:"
            r0.<init>(r2)     // Catch:{ all -> 0x0187 }
            java.lang.String r2 = r11.b     // Catch:{ all -> 0x0187 }
            r0.append(r2)     // Catch:{ all -> 0x0187 }
            java.lang.String r2 = " and the current id is "
            r0.append(r2)     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.L r2 = r10.c     // Catch:{ all -> 0x0187 }
            java.lang.String r2 = r2.b     // Catch:{ all -> 0x0187 }
            r0.append(r2)     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0187 }
            a((java.lang.String) r0)     // Catch:{ all -> 0x0187 }
            r0 = 81315(0x13da3, float:1.13947E-40)
            r2 = 2
            java.lang.Object[][] r3 = new java.lang.Object[r2][]     // Catch:{ all -> 0x0187 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0187 }
            java.lang.String r7 = "errorCode"
            r6[r5] = r7     // Catch:{ all -> 0x0187 }
            r7 = 4
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0187 }
            r6[r4] = r7     // Catch:{ all -> 0x0187 }
            r3[r5] = r6     // Catch:{ all -> 0x0187 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0187 }
            java.lang.String r6 = "reason"
            r2[r5] = r6     // Catch:{ all -> 0x0187 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            java.lang.String r6 = "loadError wrong auction ID "
            r5.<init>(r6)     // Catch:{ all -> 0x0187 }
            com.ironsource.mediationsdk.I$a r6 = r10.j     // Catch:{ all -> 0x0187 }
            r5.append(r6)     // Catch:{ all -> 0x0187 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0187 }
            r2[r4] = r5     // Catch:{ all -> 0x0187 }
            r3[r4] = r2     // Catch:{ all -> 0x0187 }
            r11.b(r0, r3)     // Catch:{ all -> 0x0187 }
            monitor-exit(r1)     // Catch:{ all -> 0x0187 }
            return
        L_0x0187:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0187 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.I.b(com.ironsource.mediationsdk.J):void");
    }

    public final void b(J j2, Placement placement) {
        a(j2, "onRewardedVideoAdClicked");
        aa.a().b(placement);
    }

    public final void c(J j2) {
        this.c.a(j2);
        this.i++;
        a(j2, "onRewardedVideoAdOpened");
        aa.a().b();
        a(false, (Map<String, Object>) null);
        if (this.q) {
            b bVar = this.l.get(j2.k());
            if (bVar != null) {
                C0155h.a(bVar, j2.i(), this.n, this.v);
                this.m.put(j2.k(), C0156i.a.ISAuctionPerformanceShowedSuccessfully);
                a(bVar, this.v);
            } else {
                String k2 = j2.k();
                b("onRewardedVideoAdOpened showing instance " + k2 + " missing from waterfall");
                b((int) IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1011}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Showing missing " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2}}));
            }
        }
        this.p.a();
    }

    public final void c_() {
        a(a.RV_STATE_NOT_LOADED);
        a(false, a.AnonymousClass1.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "loaded ads are expired"}}));
        a(0);
    }

    public final void d() {
        a("onLoadTriggered: RV load was triggered in " + this.j + " state");
        a(0);
    }

    public final void d(J j2) {
        String str;
        a(j2, "onRewardedVideoAdClosed, mediation state: " + this.j.name());
        aa.a().c();
        this.y = false;
        boolean z2 = this.j == a.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z2) {
            Iterator<J> it = this.c.a().iterator();
            while (it.hasNext()) {
                J next = it.next();
                if (next.a == J.a.LOADED) {
                    sb.append(next.k() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1][];
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
        objArr[0] = objArr2;
        j2.a((int) IronSourceConstants.RV_INSTANCE_CLOSED, objArr);
        if (j2.equals(this.c.c)) {
            this.c.a((J) null);
            if (this.j != a.RV_STATE_READY_TO_SHOW) {
                a(false, (Map<String, Object>) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a(a.RV_STATE_NOT_LOADED);
        if (!this.y) {
            a(false, (Map<String, Object>) null);
        }
        this.p.d();
    }

    public final void e(J j2) {
        a(j2, "onRewardedVideoAdStarted");
        aa.a().d();
    }

    public final void f(J j2) {
        a(j2, "onRewardedVideoAdEnded");
        aa.a().e();
    }
}
