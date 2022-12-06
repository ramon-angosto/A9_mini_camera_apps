package com.ironsource.mediationsdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0156i;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.h;
import com.ironsource.mediationsdk.server.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.n;
import com.ironsource.mediationsdk.utils.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

final class S extends C0161n implements T, C0154g, C0172y {
    n c;
    final ConcurrentHashMap<String, U> d;
    String e;
    JSONObject f;
    C0155h g;
    C0156i h;
    long i;
    long j;
    private a k;
    private CopyOnWriteArrayList<U> l;
    private ConcurrentHashMap<String, b> m;
    private ConcurrentHashMap<String, C0156i.a> n;
    private b o;
    private String p;
    private int q;
    private boolean r;
    private boolean s;
    private long t;
    private int u;
    private String v = "";
    private boolean w = false;

    enum a {
        STATE_NOT_INITIALIZED,
        STATE_READY_TO_LOAD,
        STATE_AUCTION,
        STATE_LOADING_SMASHES,
        STATE_READY_TO_SHOW,
        STATE_SHOWING
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public S(List<NetworkSettings> list, h hVar, String str, String str2, int i2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        h hVar2 = hVar;
        long time = new Date().getTime();
        a((int) IronSourceConstants.IS_MANAGER_INIT_STARTED);
        a(a.STATE_NOT_INITIALIZED);
        this.d = new ConcurrentHashMap<>();
        this.l = new CopyOnWriteArrayList<>();
        this.m = new ConcurrentHashMap<>();
        this.n = new ConcurrentHashMap<>();
        this.p = "";
        this.e = "";
        this.f = null;
        this.q = hVar2.c;
        this.r = hVar2.d;
        C0163p.a().a(IronSource.AD_UNIT.INTERSTITIAL, i2);
        c cVar = hVar2.i;
        this.j = cVar.i;
        this.s = cVar.e > 0;
        if (this.s) {
            this.g = new C0155h(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, cVar, this);
        }
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings next : list) {
            AbstractAdapter a2 = C0151d.a().a(next, next.getInterstitialSettings(), false, false);
            if (a2 != null) {
                C0152e a3 = C0152e.a();
                if (a3.a(a2, a3.a, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE)) {
                    U u2 = r0;
                    U u3 = new U(str, str2, next, this, hVar2.e, a2);
                    String k2 = u2.k();
                    this.d.put(k2, u2);
                    arrayList.add(k2);
                }
            }
        }
        this.h = new C0156i(arrayList, cVar.f);
        this.c = new n(new ArrayList(this.d.values()));
        for (U next2 : this.d.values()) {
            if (next2.h()) {
                next2.b();
            }
        }
        this.i = new Date().getTime();
        a(a.STATE_READY_TO_LOAD);
        a((int) IronSourceConstants.IS_MANAGER_INIT_ENDED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}});
    }

    private String a(b bVar) {
        U u2 = this.d.get(bVar.a());
        String num = u2 != null ? Integer.toString(u2.i()) : TextUtils.isEmpty(bVar.b()) ? "1" : "2";
        return num + bVar.a();
    }

    private void a(int i2) {
        a(i2, (Object[][]) null, false);
    }

    private void a(int i2, U u2) {
        a(i2, u2, (Object[][]) null, false);
    }

    private void a(int i2, U u2, Object[][] objArr) {
        a(i2, u2, objArr, false);
    }

    private void a(int i2, U u2, Object[][] objArr, boolean z) {
        Map<String, Object> n2 = u2.n();
        if (!TextUtils.isEmpty(this.e)) {
            n2.put(IronSourceConstants.EVENTS_AUCTION_ID, this.e);
        }
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.length() > 0) {
            n2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.f);
        }
        if (z && !TextUtils.isEmpty(this.p)) {
            n2.put("placement", this.p);
        }
        if (c(i2)) {
            d.e();
            d.a(n2, this.u, this.v);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    n2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        d.e().b(new com.ironsource.mediationsdk.a.c(i2, new JSONObject(n2)));
    }

    private void a(int i2, Object[][] objArr) {
        a(i2, objArr, false);
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object[][] objArr, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        if (!TextUtils.isEmpty(this.e)) {
            hashMap.put(IronSourceConstants.EVENTS_AUCTION_ID, this.e);
        }
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.f);
        }
        if (z && !TextUtils.isEmpty(this.p)) {
            hashMap.put("placement", this.p);
        }
        if (c(i2)) {
            d.e();
            d.a((Map<String, Object>) hashMap, this.u, this.v);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    hashMap.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                b("sendMediationEvent " + e2.getMessage());
            }
        }
        d.e().b(new com.ironsource.mediationsdk.a.c(i2, new JSONObject(hashMap)));
    }

    private static void a(U u2, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsManager " + u2.k() + " : " + str, 0);
    }

    private void a(List<b> list) {
        this.l.clear();
        this.m.clear();
        this.n.clear();
        StringBuilder sb = new StringBuilder();
        for (b next : list) {
            sb.append(a(next) + ",");
            U u2 = this.d.get(next.a());
            if (u2 != null) {
                u2.e = true;
                this.l.add(u2);
                this.m.put(u2.k(), next);
                this.n.put(next.a(), C0156i.a.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                b("updateWaterfall() - could not find matching smash for auction response item " + next.a());
            }
        }
        b("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            b("Updated waterfall is empty");
        }
        a((int) IronSourceConstants.IS_RESULT_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
    }

    private void b(int i2) {
        a(i2, (Object[][]) null, true);
    }

    private void b(int i2, U u2) {
        a(i2, u2, (Object[][]) null, true);
    }

    private void b(int i2, U u2, Object[][] objArr) {
        a(i2, u2, objArr, true);
    }

    private void b(int i2, Object[][] objArr) {
        a((int) IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, objArr, true);
    }

    static void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "ProgIsManager " + str, 0);
    }

    private static void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private static boolean c(int i2) {
        return i2 == 2002 || i2 == 2003 || i2 == 2200 || i2 == 2213 || i2 == 2005 || i2 == 2204 || i2 == 2201 || i2 == 2203 || i2 == 2006 || i2 == 2004 || i2 == 2110 || i2 == 2301 || i2 == 2300 || i2 == 2303;
    }

    private void f() {
        List<b> g2 = g();
        this.e = c();
        a(g2);
    }

    private List<b> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (U next : this.d.values()) {
            if (!next.h() && !this.c.b(next)) {
                copyOnWriteArrayList.add(new b(next.k()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void g(U u2) {
        String b = this.m.get(u2.k()).b();
        u2.b(b);
        a(2002, u2);
        u2.a(b);
    }

    private void h() {
        if (this.l.isEmpty()) {
            a(a.STATE_READY_TO_LOAD);
            a((int) IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Empty waterfall"}}, false);
            C0163p.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES, "Empty waterfall"));
            return;
        }
        a(a.STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.l.size() && i2 < this.q; i3++) {
            U u2 = this.l.get(i3);
            if (u2.e) {
                if (!this.r || !u2.h()) {
                    g(u2);
                    i2++;
                } else if (i2 == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + u2.k() + ". No other instances will be loaded at the same time.";
                    b(str);
                    IronSourceUtils.sendAutomationLog(str);
                    g(u2);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + u2.k() + " as a non bidder is being loaded";
                    b(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a(a.STATE_AUCTION);
        AsyncTask.execute(new Runnable() {
            public final void run() {
                StringBuilder sb;
                S s = S.this;
                s.e = "";
                s.f = null;
                StringBuilder sb2 = new StringBuilder();
                long time = S.this.j - (new Date().getTime() - S.this.i);
                if (time > 0) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("delaying auction by " + time);
                    com.ironsource.environment.e.c cVar = com.ironsource.environment.e.c.a;
                    com.ironsource.environment.e.c.b(new Runnable() {
                        public final void run() {
                            S.this.a();
                        }
                    }, time);
                    return;
                }
                S.this.a(2000, (Object[][]) null, false);
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (U next : S.this.d.values()) {
                    if (!S.this.c.b(next)) {
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
                if (hashMap.size() == 0 && arrayList.size() == 0) {
                    S.this.a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}}, false);
                    S s2 = S.this;
                    S.b("makeAuction() failed - No candidates available for auctioning");
                    C0163p.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(1005, "No candidates available for auctioning"));
                    S.this.a((int) IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}}, false);
                    S.this.a(a.STATE_READY_TO_LOAD);
                    return;
                }
                S.this.a((int) IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb2.toString()}}, false);
                int b = o.a().b(2);
                if (S.this.g != null) {
                    S.this.g.a(ContextProvider.getInstance().getApplicationContext(), hashMap, arrayList, S.this.h, b, S.this.b);
                }
            }
        });
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        b(str3);
        IronSourceUtils.sendAutomationLog("IS: " + str3);
        this.u = i3;
        this.v = str2;
        this.f = null;
        f();
        if (TextUtils.isEmpty(str)) {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        } else {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        }
        h();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.k = aVar;
        b("state=" + aVar);
    }

    public final void a(U u2) {
        synchronized (this) {
            a(u2, "onInterstitialAdOpened");
            B.a().c();
            b((int) IronSourceConstants.IS_INSTANCE_OPENED, u2);
            if (this.s) {
                b bVar = this.m.get(u2.k());
                if (bVar != null) {
                    C0155h.a(bVar, u2.i(), this.o, this.p);
                    this.n.put(u2.k(), C0156i.a.ISAuctionPerformanceShowedSuccessfully);
                    a(bVar, this.p);
                } else {
                    String k2 = u2.k();
                    b("onInterstitialAdOpened showing instance " + k2 + " missing from waterfall");
                    Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1011};
                    a((int) IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Showing missing " + this.k}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2}});
                }
            }
        }
    }

    public final void a(U u2, long j2) {
        U u3 = u2;
        synchronized (this) {
            a(u3, "onInterstitialAdReady");
            a(2003, u3, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
            if (this.n.containsKey(u2.k())) {
                this.n.put(u2.k(), C0156i.a.ISAuctionPerformanceLoadedSuccessfully);
            }
            if (this.k == a.STATE_LOADING_SMASHES) {
                a(a.STATE_READY_TO_SHOW);
                B.a().b();
                a(2004, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - this.t)}});
                if (this.s) {
                    b bVar = this.m.get(u2.k());
                    if (bVar != null) {
                        C0155h.a(bVar, u2.i(), this.o);
                        this.g.a((CopyOnWriteArrayList<Y>) this.l, this.m, u2.i(), this.o, bVar);
                    } else {
                        String k2 = u2.k();
                        b("onInterstitialAdReady winner instance " + k2 + " missing from waterfall");
                        a((int) IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, k2}});
                    }
                }
            }
        }
    }

    public final void a(IronSourceError ironSourceError, U u2) {
        synchronized (this) {
            a(u2, "onInterstitialAdShowFailed error=" + ironSourceError.getErrorMessage());
            B.a().b(ironSourceError);
            b(IronSourceConstants.IS_INSTANCE_SHOW_FAILED, u2, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
            this.n.put(u2.k(), C0156i.a.ISAuctionPerformanceFailedToShow);
            a(a.STATE_READY_TO_LOAD);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f0, code lost:
        if (r11 == false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f2, code lost:
        r9 = "a non bidder is being loaded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f5, code lost:
        r9 = "a non bidder was already loaded successfully";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f7, code lost:
        r9 = "Advanced Loading: Won't start loading bidder " + r1.k() + " as " + r9;
        b(r9);
        com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.logger.IronSourceError r9, com.ironsource.mediationsdk.U r10, long r11) {
        /*
            r8 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            monitor-enter(r8)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b9 }
            java.lang.String r2 = "onInterstitialAdLoadFailed error="
            r1.<init>(r2)     // Catch:{ all -> 0x01b9 }
            java.lang.String r2 = r9.getErrorMessage()     // Catch:{ all -> 0x01b9 }
            r1.append(r2)     // Catch:{ all -> 0x01b9 }
            java.lang.String r2 = " state="
            r1.append(r2)     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.S$a r2 = r8.k     // Catch:{ all -> 0x01b9 }
            java.lang.String r2 = r2.name()     // Catch:{ all -> 0x01b9 }
            r1.append(r2)     // Catch:{ all -> 0x01b9 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01b9 }
            a((com.ironsource.mediationsdk.U) r10, (java.lang.String) r1)     // Catch:{ all -> 0x01b9 }
            int r1 = r9.getErrorCode()     // Catch:{ all -> 0x01b9 }
            r2 = 1158(0x486, float:1.623E-42)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 != r2) goto L_0x005c
            r1 = 2213(0x8a5, float:3.101E-42)
            java.lang.Object[][] r2 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b9 }
            java.lang.String r7 = "errorCode"
            r6[r4] = r7     // Catch:{ all -> 0x01b9 }
            int r9 = r9.getErrorCode()     // Catch:{ all -> 0x01b9 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x01b9 }
            r6[r5] = r9     // Catch:{ all -> 0x01b9 }
            r2[r4] = r6     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b9 }
            java.lang.String r6 = "duration"
            r9[r4] = r6     // Catch:{ all -> 0x01b9 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x01b9 }
            r9[r5] = r11     // Catch:{ all -> 0x01b9 }
            r2[r5] = r9     // Catch:{ all -> 0x01b9 }
            r8.a((int) r1, (com.ironsource.mediationsdk.U) r10, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x01b9 }
            goto L_0x0092
        L_0x005c:
            r1 = 2200(0x898, float:3.083E-42)
            r2 = 3
            java.lang.Object[][] r2 = new java.lang.Object[r2][]     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b9 }
            java.lang.String r7 = "errorCode"
            r6[r4] = r7     // Catch:{ all -> 0x01b9 }
            int r7 = r9.getErrorCode()     // Catch:{ all -> 0x01b9 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x01b9 }
            r6[r5] = r7     // Catch:{ all -> 0x01b9 }
            r2[r4] = r6     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b9 }
            java.lang.String r7 = "reason"
            r6[r4] = r7     // Catch:{ all -> 0x01b9 }
            java.lang.String r9 = r9.getErrorMessage()     // Catch:{ all -> 0x01b9 }
            r6[r5] = r9     // Catch:{ all -> 0x01b9 }
            r2[r5] = r6     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b9 }
            java.lang.String r6 = "duration"
            r9[r4] = r6     // Catch:{ all -> 0x01b9 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x01b9 }
            r9[r5] = r11     // Catch:{ all -> 0x01b9 }
            r2[r3] = r9     // Catch:{ all -> 0x01b9 }
            r8.a((int) r1, (com.ironsource.mediationsdk.U) r10, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x01b9 }
        L_0x0092:
            if (r10 == 0) goto L_0x00ab
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r9 = r8.n     // Catch:{ all -> 0x01b9 }
            java.lang.String r11 = r10.k()     // Catch:{ all -> 0x01b9 }
            boolean r9 = r9.containsKey(r11)     // Catch:{ all -> 0x01b9 }
            if (r9 == 0) goto L_0x00ab
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.i$a> r9 = r8.n     // Catch:{ all -> 0x01b9 }
            java.lang.String r11 = r10.k()     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.i$a r12 = com.ironsource.mediationsdk.C0156i.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x01b9 }
            r9.put(r11, r12)     // Catch:{ all -> 0x01b9 }
        L_0x00ab:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.U> r9 = r8.l     // Catch:{ all -> 0x01b9 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x01b9 }
            r11 = r4
            r12 = r11
        L_0x00b3:
            boolean r1 = r9.hasNext()     // Catch:{ all -> 0x01b9 }
            if (r1 == 0) goto L_0x0152
            java.lang.Object r1 = r9.next()     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.U r1 = (com.ironsource.mediationsdk.U) r1     // Catch:{ all -> 0x01b9 }
            boolean r2 = r1.e     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x0134
            boolean r2 = r8.r     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x0118
            boolean r2 = r1.h()     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x0118
            if (r11 != 0) goto L_0x00f0
            if (r12 == 0) goto L_0x00d2
            goto L_0x00f0
        L_0x00d2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b9 }
            java.lang.String r6 = "Advanced Loading: Starting to load bidder "
            r2.<init>(r6)     // Catch:{ all -> 0x01b9 }
            java.lang.String r6 = r1.k()     // Catch:{ all -> 0x01b9 }
            r2.append(r6)     // Catch:{ all -> 0x01b9 }
            java.lang.String r6 = ". No other instances will be loaded at the same time."
            r2.append(r6)     // Catch:{ all -> 0x01b9 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01b9 }
            b((java.lang.String) r2)     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r2)     // Catch:{ all -> 0x01b9 }
            goto L_0x0118
        L_0x00f0:
            if (r11 == 0) goto L_0x00f5
            java.lang.String r9 = "a non bidder is being loaded"
            goto L_0x00f7
        L_0x00f5:
            java.lang.String r9 = "a non bidder was already loaded successfully"
        L_0x00f7:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = "Advanced Loading: Won't start loading bidder "
            r10.<init>(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r1.k()     // Catch:{ all -> 0x01b9 }
            r10.append(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = " as "
            r10.append(r12)     // Catch:{ all -> 0x01b9 }
            r10.append(r9)     // Catch:{ all -> 0x01b9 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x01b9 }
            b((java.lang.String) r9)     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r9)     // Catch:{ all -> 0x01b9 }
            goto L_0x0152
        L_0x0118:
            r0.add(r1)     // Catch:{ all -> 0x01b9 }
            boolean r2 = r8.r     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x0152
            boolean r2 = r10.h()     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x0152
            boolean r1 = r1.h()     // Catch:{ all -> 0x01b9 }
            if (r1 != 0) goto L_0x0152
            int r1 = r0.size()     // Catch:{ all -> 0x01b9 }
            int r2 = r8.q     // Catch:{ all -> 0x01b9 }
            if (r1 >= r2) goto L_0x0152
            goto L_0x0146
        L_0x0134:
            com.ironsource.mediationsdk.U$a r2 = r1.a     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.U$a r6 = com.ironsource.mediationsdk.U.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x01b9 }
            if (r2 == r6) goto L_0x0143
            com.ironsource.mediationsdk.U$a r2 = r1.a     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.U$a r6 = com.ironsource.mediationsdk.U.a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x01b9 }
            if (r2 != r6) goto L_0x0141
            goto L_0x0143
        L_0x0141:
            r2 = r4
            goto L_0x0144
        L_0x0143:
            r2 = r5
        L_0x0144:
            if (r2 == 0) goto L_0x0149
        L_0x0146:
            r11 = r5
            goto L_0x00b3
        L_0x0149:
            boolean r1 = r1.g()     // Catch:{ all -> 0x01b9 }
            if (r1 == 0) goto L_0x00b3
            r12 = r5
            goto L_0x00b3
        L_0x0152:
            int r9 = r0.size()     // Catch:{ all -> 0x01b9 }
            if (r9 != 0) goto L_0x018c
            com.ironsource.mediationsdk.S$a r9 = r8.k     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.S$a r10 = com.ironsource.mediationsdk.S.a.STATE_LOADING_SMASHES     // Catch:{ all -> 0x01b9 }
            if (r9 != r10) goto L_0x018c
            if (r11 != 0) goto L_0x018c
            com.ironsource.mediationsdk.p r9 = com.ironsource.mediationsdk.C0163p.a()     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r10 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = "No ads to show"
            r1 = 509(0x1fd, float:7.13E-43)
            r11.<init>(r1, r12)     // Catch:{ all -> 0x01b9 }
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r10, (com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x01b9 }
            r9 = 2110(0x83e, float:2.957E-42)
            java.lang.Object[][] r10 = new java.lang.Object[r5][]     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = "errorCode"
            r11[r4] = r12     // Catch:{ all -> 0x01b9 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01b9 }
            r11[r5] = r12     // Catch:{ all -> 0x01b9 }
            r10[r4] = r11     // Catch:{ all -> 0x01b9 }
            r8.a((int) r9, (java.lang.Object[][]) r10)     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.S$a r9 = com.ironsource.mediationsdk.S.a.STATE_READY_TO_LOAD     // Catch:{ all -> 0x01b9 }
            r8.a((com.ironsource.mediationsdk.S.a) r9)     // Catch:{ all -> 0x01b9 }
        L_0x018c:
            monitor-exit(r8)     // Catch:{ all -> 0x01b9 }
            com.ironsource.mediationsdk.logger.IronLog r9 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "smashesToLoad.size() = "
            r10.<init>(r11)
            int r11 = r0.size()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.verbose(r10)
            java.util.Iterator r9 = r0.iterator()
        L_0x01a8:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01b8
            java.lang.Object r10 = r9.next()
            com.ironsource.mediationsdk.U r10 = (com.ironsource.mediationsdk.U) r10
            r8.g(r10)
            goto L_0x01a8
        L_0x01b8:
            return
        L_0x01b9:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x01b9 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.S.a(com.ironsource.mediationsdk.logger.IronSourceError, com.ironsource.mediationsdk.U, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0190, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.ironsource.mediationsdk.S$a r0 = r8.k     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.S$a r1 = com.ironsource.mediationsdk.S.a.STATE_SHOWING     // Catch:{ all -> 0x01db }
            r2 = 2111(0x83f, float:2.958E-42)
            r3 = 1
            r4 = 2
            r5 = 0
            if (r0 != r1) goto L_0x003e
            java.lang.String r9 = "showInterstitial error: can't show ad while an ad is already showing"
            c((java.lang.String) r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01db }
            r1 = 1036(0x40c, float:1.452E-42)
            r0.<init>(r1, r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.B r6 = com.ironsource.mediationsdk.B.a()     // Catch:{ all -> 0x01db }
            r6.b(r0)     // Catch:{ all -> 0x01db }
            java.lang.Object[][] r0 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01db }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r7 = "errorCode"
            r6[r5] = r7     // Catch:{ all -> 0x01db }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01db }
            r6[r3] = r1     // Catch:{ all -> 0x01db }
            r0[r5] = r6     // Catch:{ all -> 0x01db }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r4 = "reason"
            r1[r5] = r4     // Catch:{ all -> 0x01db }
            r1[r3] = r9     // Catch:{ all -> 0x01db }
            r0[r3] = r1     // Catch:{ all -> 0x01db }
            r8.a((int) r2, (java.lang.Object[][]) r0, (boolean) r5)     // Catch:{ all -> 0x01db }
            monitor-exit(r8)
            return
        L_0x003e:
            com.ironsource.mediationsdk.S$a r0 = r8.k     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.S$a r1 = com.ironsource.mediationsdk.S.a.STATE_READY_TO_SHOW     // Catch:{ all -> 0x01db }
            r6 = 509(0x1fd, float:7.13E-43)
            if (r0 == r1) goto L_0x008d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "showInterstitial() error state="
            r9.<init>(r0)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.S$a r0 = r8.k     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01db }
            r9.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01db }
            b((java.lang.String) r9)     // Catch:{ all -> 0x01db }
            java.lang.String r9 = "showInterstitial error: show called while no ads are available"
            c((java.lang.String) r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01db }
            r0.<init>(r6, r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.B r1 = com.ironsource.mediationsdk.B.a()     // Catch:{ all -> 0x01db }
            r1.b(r0)     // Catch:{ all -> 0x01db }
            java.lang.Object[][] r0 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01db }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r7 = "errorCode"
            r1[r5] = r7     // Catch:{ all -> 0x01db }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01db }
            r1[r3] = r6     // Catch:{ all -> 0x01db }
            r0[r5] = r1     // Catch:{ all -> 0x01db }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r4 = "reason"
            r1[r5] = r4     // Catch:{ all -> 0x01db }
            r1[r3] = r9     // Catch:{ all -> 0x01db }
            r0[r3] = r1     // Catch:{ all -> 0x01db }
            r8.a((int) r2, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x01db }
            monitor-exit(r8)
            return
        L_0x008d:
            if (r9 != 0) goto L_0x00c1
            java.lang.String r9 = "showInterstitial error: empty default placement"
            c((java.lang.String) r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01db }
            r1 = 1020(0x3fc, float:1.43E-42)
            r0.<init>(r1, r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.B r6 = com.ironsource.mediationsdk.B.a()     // Catch:{ all -> 0x01db }
            r6.b(r0)     // Catch:{ all -> 0x01db }
            java.lang.Object[][] r0 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01db }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r7 = "errorCode"
            r6[r5] = r7     // Catch:{ all -> 0x01db }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01db }
            r6[r3] = r1     // Catch:{ all -> 0x01db }
            r0[r5] = r6     // Catch:{ all -> 0x01db }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r4 = "reason"
            r1[r5] = r4     // Catch:{ all -> 0x01db }
            r1[r3] = r9     // Catch:{ all -> 0x01db }
            r0[r3] = r1     // Catch:{ all -> 0x01db }
            r8.a((int) r2, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x01db }
            monitor-exit(r8)
            return
        L_0x00c1:
            r8.p = r9     // Catch:{ all -> 0x01db }
            r9 = 2100(0x834, float:2.943E-42)
            r8.b((int) r9)     // Catch:{ all -> 0x01db }
            com.ironsource.environment.ContextProvider r9 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01db }
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r8.p     // Catch:{ all -> 0x01db }
            boolean r9 = com.ironsource.mediationsdk.utils.k.a((android.content.Context) r9, (java.lang.String) r0)     // Catch:{ all -> 0x01db }
            if (r9 == 0) goto L_0x011d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "placement "
            r9.<init>(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r8.p     // Catch:{ all -> 0x01db }
            r9.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = " is capped"
            r9.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01db }
            c((java.lang.String) r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01db }
            r1 = 524(0x20c, float:7.34E-43)
            r0.<init>(r1, r9)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.B r6 = com.ironsource.mediationsdk.B.a()     // Catch:{ all -> 0x01db }
            r6.b(r0)     // Catch:{ all -> 0x01db }
            java.lang.Object[][] r0 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01db }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r7 = "errorCode"
            r6[r5] = r7     // Catch:{ all -> 0x01db }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01db }
            r6[r3] = r1     // Catch:{ all -> 0x01db }
            r0[r5] = r6     // Catch:{ all -> 0x01db }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r4 = "reason"
            r1[r5] = r4     // Catch:{ all -> 0x01db }
            r1[r3] = r9     // Catch:{ all -> 0x01db }
            r0[r3] = r1     // Catch:{ all -> 0x01db }
            r8.b((int) r2, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x01db }
            monitor-exit(r8)
            return
        L_0x011d:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.U> r9 = r8.l     // Catch:{ all -> 0x01db }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x01db }
        L_0x0123:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x01db }
            if (r0 == 0) goto L_0x01ad
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.U r0 = (com.ironsource.mediationsdk.U) r0     // Catch:{ all -> 0x01db }
            boolean r1 = r0.g()     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x0191
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.S$a r1 = com.ironsource.mediationsdk.S.a.STATE_SHOWING     // Catch:{ all -> 0x01db }
            r8.a((com.ironsource.mediationsdk.S.a) r1)     // Catch:{ all -> 0x01db }
            r0.c()     // Catch:{ all -> 0x01db }
            r1 = 2201(0x899, float:3.084E-42)
            r8.b((int) r1, (com.ironsource.mediationsdk.U) r0)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.utils.n r1 = r8.c     // Catch:{ all -> 0x01db }
            r1.a(r0)     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.utils.n r1 = r8.c     // Catch:{ all -> 0x01db }
            boolean r1 = r1.b(r0)     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x0171
            r0.f()     // Catch:{ all -> 0x01db }
            r1 = 2401(0x961, float:3.365E-42)
            r8.a((int) r1, (com.ironsource.mediationsdk.U) r0)     // Catch:{ all -> 0x01db }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r0.k()     // Catch:{ all -> 0x01db }
            r1.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = " was session capped"
            r1.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r0)     // Catch:{ all -> 0x01db }
        L_0x0171:
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01db }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x01db }
            com.ironsource.mediationsdk.utils.k.d(r0, r9)     // Catch:{ all -> 0x01db }
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01db }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x01db }
            boolean r9 = com.ironsource.mediationsdk.utils.k.a((android.content.Context) r0, (java.lang.String) r9)     // Catch:{ all -> 0x01db }
            if (r9 == 0) goto L_0x018f
            r9 = 2400(0x960, float:3.363E-42)
            r8.b((int) r9)     // Catch:{ all -> 0x01db }
        L_0x018f:
            monitor-exit(r8)
            return
        L_0x0191:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            java.lang.String r7 = "showInterstitial "
            r1.<init>(r7)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r0.k()     // Catch:{ all -> 0x01db }
            r1.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = " isReadyToShow() == false"
            r1.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01db }
            b((java.lang.String) r0)     // Catch:{ all -> 0x01db }
            goto L_0x0123
        L_0x01ad:
            com.ironsource.mediationsdk.B r9 = com.ironsource.mediationsdk.B.a()     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r0 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoAdsToShowError(r0)     // Catch:{ all -> 0x01db }
            r9.b(r0)     // Catch:{ all -> 0x01db }
            java.lang.Object[][] r9 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01db }
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r1 = "errorCode"
            r0[r5] = r1     // Catch:{ all -> 0x01db }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01db }
            r0[r3] = r1     // Catch:{ all -> 0x01db }
            r9[r5] = r0     // Catch:{ all -> 0x01db }
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            java.lang.String r1 = "reason"
            r0[r5] = r1     // Catch:{ all -> 0x01db }
            java.lang.String r1 = "Show Fail - No ads to show"
            r0[r3] = r1     // Catch:{ all -> 0x01db }
            r9[r3] = r0     // Catch:{ all -> 0x01db }
            r8.b((int) r2, (java.lang.Object[][]) r9)     // Catch:{ all -> 0x01db }
            monitor-exit(r8)
            return
        L_0x01db:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.S.a(java.lang.String):void");
    }

    public final void a(List<b> list, String str, b bVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        this.e = str;
        this.o = bVar;
        this.f = jSONObject;
        this.u = i2;
        this.v = "";
        if (!TextUtils.isEmpty(str2)) {
            a((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i3)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str2}}, false);
        }
        a(jSONObject2, IronSource.AD_UNIT.INTERSTITIAL);
        if (this.a.a(IronSource.AD_UNIT.INTERSTITIAL)) {
            a((int) IronSourceConstants.IS_AD_UNIT_CAPPED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_AUCTION_ID, str}}, false);
            a(a.STATE_READY_TO_LOAD);
            C0163p.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped"));
            return;
        }
        a((int) IronSourceConstants.IS_AUCTION_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}}, false);
        a(list);
        h();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "Should Track Network State: " + z, 0);
        this.w = z;
    }

    public final void b(U u2) {
        synchronized (this) {
            a(u2, "onInterstitialAdClosed");
            b(IronSourceConstants.IS_INSTANCE_CLOSED, u2, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(o.a().b(2))}});
            o.a().a(2);
            B.a().d();
            a(a.STATE_READY_TO_LOAD);
        }
    }

    public final void b(IronSourceError ironSourceError, U u2) {
        a((int) IronSourceConstants.IS_INSTANCE_INIT_FAILED, u2, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
    }

    public final void c(U u2) {
        a(u2, "onInterstitialAdShowSucceeded");
        B.a().e();
        b((int) IronSourceConstants.IS_INSTANCE_SHOW_SUCCESS, u2);
    }

    public final synchronized void d() {
        if (this.k == a.STATE_SHOWING) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "loadInterstitial: load cannot be invoked while showing an ad", 3);
            B.a().a(new IronSourceError(IronSourceError.ERROR_IS_LOAD_DURING_SHOW, "loadInterstitial: load cannot be invoked while showing an ad"));
        } else if ((this.k == a.STATE_READY_TO_LOAD || this.k == a.STATE_READY_TO_SHOW) && !C0163p.a().a(IronSource.AD_UNIT.INTERSTITIAL)) {
            this.e = "";
            this.p = "";
            this.f = null;
            a(IronSource.AD_UNIT.INTERSTITIAL);
            a(2001, (Object[][]) null, false);
            this.t = new Date().getTime();
            if (this.s) {
                if (!this.n.isEmpty()) {
                    this.h.a(this.n);
                    this.n.clear();
                }
                a();
                return;
            }
            f();
            h();
        } else {
            b("loadInterstitial: load is already in progress");
        }
    }

    public final void d(U u2) {
        a(u2, "onInterstitialAdClicked");
        B.a().f();
        b(2006, u2);
    }

    public final void e(U u2) {
        a(u2, "onInterstitialAdVisible");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean e() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.w     // Catch:{ all -> 0x0039 }
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0039 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0039 }
            boolean r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.isNetworkConnected(r0)     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x001a
        L_0x0014:
            com.ironsource.mediationsdk.S$a r0 = r3.k     // Catch:{ all -> 0x0039 }
            com.ironsource.mediationsdk.S$a r2 = com.ironsource.mediationsdk.S.a.STATE_READY_TO_SHOW     // Catch:{ all -> 0x0039 }
            if (r0 == r2) goto L_0x001c
        L_0x001a:
            monitor-exit(r3)
            return r1
        L_0x001c:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.U> r0 = r3.l     // Catch:{ all -> 0x0039 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0039 }
        L_0x0022:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0039 }
            com.ironsource.mediationsdk.U r2 = (com.ironsource.mediationsdk.U) r2     // Catch:{ all -> 0x0039 }
            boolean r2 = r2.g()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0022
            r0 = 1
            monitor-exit(r3)
            return r0
        L_0x0037:
            monitor-exit(r3)
            return r1
        L_0x0039:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.S.e():boolean");
    }

    public final void f(U u2) {
        a((int) IronSourceConstants.IS_INSTANCE_INIT_SUCCESS, u2);
    }
}
