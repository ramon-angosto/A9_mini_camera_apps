package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0159l;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.f;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.mediationsdk.utils.o;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.k  reason: case insensitive filesystem */
public final class C0158k implements com.ironsource.mediationsdk.sdk.a {
    private C0159l a;
    private IronSourceBannerLayout b;
    private f c;
    private a d = a.NOT_INITIATED;
    private IronSourceLoggerManager e = IronSourceLoggerManager.getLogger();
    private String f;
    private String g;
    private final CopyOnWriteArrayList<C0159l> h = new CopyOnWriteArrayList<>();
    private long i;
    private Timer j;
    private AtomicBoolean k = new AtomicBoolean();
    private AtomicBoolean l = new AtomicBoolean();
    private com.ironsource.mediationsdk.utils.f m;
    private com.ironsource.mediationsdk.utils.f n;
    private int o;
    private int p;

    /* renamed from: com.ironsource.mediationsdk.k$a */
    enum a {
        NOT_INITIATED,
        READY_TO_LOAD,
        FIRST_LOAD_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        RELOAD_IN_PROGRESS
    }

    public C0158k(List<NetworkSettings> list, String str, String str2, long j2, int i2, int i3) {
        this.f = str;
        this.g = str2;
        this.i = (long) i2;
        C0157j.a().a = i3;
        for (int i4 = 0; i4 < list.size(); i4++) {
            NetworkSettings networkSettings = list.get(i4);
            AbstractAdapter a2 = C0151d.a().a(networkSettings, networkSettings.getBannerSettings(), false, false);
            if (a2 == null || !C0152e.a().a(a2)) {
                a(networkSettings.getProviderInstanceName() + " can't load adapter or wrong version");
            } else {
                this.h.add(new C0159l(this, networkSettings, a2, j2, i4 + 1));
            }
        }
        this.c = null;
        a(a.READY_TO_LOAD);
    }

    private void a(int i2) {
        a(i2, (Object[][]) null);
    }

    private void a(int i2, C0159l lVar) {
        a(i2, lVar, (Object[][]) null);
    }

    private void a(int i2, C0159l lVar, Object[][] objArr) {
        a(i2, lVar, objArr, this.p);
    }

    private void a(int i2, C0159l lVar, Object[][] objArr, int i3) {
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData(lVar);
        try {
            if (this.b != null) {
                a(providerAdditionalData, this.b.getSize());
            }
            if (this.c != null) {
                providerAdditionalData.put("placement", this.c.getPlacementName());
            }
            providerAdditionalData.put(IronSourceConstants.KEY_SESSION_DEPTH, i3);
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    providerAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "sendProviderEvent " + Log.getStackTraceString(e2), 3);
        }
        d.e().b(new c(i2, providerAdditionalData));
    }

    private void a(int i2, Object[][] objArr) {
        a(i2, objArr, this.p);
    }

    private void a(int i2, Object[][] objArr, int i3) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (this.b != null) {
                a(mediationAdditionalData, this.b.getSize());
            }
            if (this.c != null) {
                mediationAdditionalData.put("placement", this.c.getPlacementName());
            }
            mediationAdditionalData.put(IronSourceConstants.KEY_SESSION_DEPTH, i3);
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "sendMediationEvent " + Log.getStackTraceString(e2), 3);
        }
        d.e().b(new c(i2, mediationAdditionalData));
    }

    private void a(a aVar) {
        this.d = aVar;
        a("state=" + aVar.name());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.ironsource.mediationsdk.C0158k r8) {
        /*
            com.ironsource.mediationsdk.k$a r0 = r8.d
            com.ironsource.mediationsdk.k$a r1 = com.ironsource.mediationsdk.C0158k.a.RELOAD_IN_PROGRESS
            if (r0 == r1) goto L_0x001e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "onReloadTimer wrong state="
            r0.<init>(r1)
            com.ironsource.mediationsdk.k$a r1 = r8.d
            java.lang.String r1 = r1.name()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.a((java.lang.String) r0)
            return
        L_0x001e:
            r0 = 0
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r2 = "checking with IronsourceLifecycleManager if app in foreground"
            r1.verbose(r2)
            com.ironsource.lifecycle.d r1 = com.ironsource.lifecycle.d.a()
            boolean r1 = r1.b()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x00e2
            com.ironsource.mediationsdk.IronSourceBannerLayout r1 = r8.b
            java.lang.String r4 = "banner is null"
            if (r1 != 0) goto L_0x003f
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r1.verbose(r4)
        L_0x003d:
            r1 = r3
            goto L_0x0078
        L_0x003f:
            boolean r1 = r1.isShown()
            if (r1 != 0) goto L_0x004d
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r5 = "banner or one of its parents are INVISIBLE or GONE"
        L_0x0049:
            r1.verbose(r5)
            goto L_0x003d
        L_0x004d:
            com.ironsource.mediationsdk.IronSourceBannerLayout r1 = r8.b
            boolean r1 = r1.hasWindowFocus()
            if (r1 != 0) goto L_0x005a
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r5 = "banner has no window focus"
            goto L_0x0049
        L_0x005a:
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            com.ironsource.mediationsdk.IronSourceBannerLayout r5 = r8.b
            boolean r1 = r5.getGlobalVisibleRect(r1)
            com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "visible = "
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5.verbose(r6)
        L_0x0078:
            if (r1 == 0) goto L_0x00df
            com.ironsource.mediationsdk.utils.o r1 = com.ironsource.mediationsdk.utils.o.a()
            r5 = 3
            int r1 = r1.b((int) r5)
            r8.p = r1
            r1 = 3011(0xbc3, float:4.22E-42)
            r8.a((int) r1)
            r1 = 3012(0xbc4, float:4.221E-42)
            com.ironsource.mediationsdk.l r5 = r8.a
            r8.a((int) r1, (com.ironsource.mediationsdk.C0159l) r5)
            com.ironsource.mediationsdk.utils.f r1 = new com.ironsource.mediationsdk.utils.f
            r1.<init>()
            r8.m = r1
            com.ironsource.mediationsdk.utils.f r1 = new com.ironsource.mediationsdk.utils.f
            r1.<init>()
            r8.n = r1
            com.ironsource.mediationsdk.l r1 = r8.a
            java.lang.String r5 = "reloadBanner()"
            r1.a((java.lang.String) r5)
            com.ironsource.mediationsdk.IronSourceBannerLayout r5 = r1.e
            if (r5 == 0) goto L_0x00c9
            com.ironsource.mediationsdk.IronSourceBannerLayout r5 = r1.e
            boolean r5 = r5.isDestroyed()
            if (r5 == 0) goto L_0x00b3
            goto L_0x00c9
        L_0x00b3:
            r1.b()
            com.ironsource.mediationsdk.l$a r4 = com.ironsource.mediationsdk.C0159l.a.LOADED
            r1.a((com.ironsource.mediationsdk.C0159l.a) r4)
            com.ironsource.mediationsdk.AbstractAdapter r4 = r1.a
            com.ironsource.mediationsdk.IronSourceBannerLayout r5 = r1.e
            com.ironsource.mediationsdk.model.NetworkSettings r6 = r1.b
            org.json.JSONObject r6 = r6.getBannerSettings()
            r4.reloadBanner(r5, r6, r1)
            goto L_0x00dc
        L_0x00c9:
            com.ironsource.mediationsdk.IronSourceBannerLayout r5 = r1.e
            if (r5 != 0) goto L_0x00ce
            goto L_0x00d0
        L_0x00ce:
            java.lang.String r4 = "banner is destroyed"
        L_0x00d0:
            com.ironsource.mediationsdk.sdk.a r5 = r1.c
            com.ironsource.mediationsdk.logger.IronSourceError r6 = new com.ironsource.mediationsdk.logger.IronSourceError
            r7 = 610(0x262, float:8.55E-43)
            r6.<init>(r7, r4)
            r5.a((com.ironsource.mediationsdk.logger.IronSourceError) r6, (com.ironsource.mediationsdk.C0159l) r1, (boolean) r3)
        L_0x00dc:
            r1 = r0
            r0 = r3
            goto L_0x00e6
        L_0x00df:
            java.lang.String r0 = "banner is not visible - start reload timer"
            goto L_0x00e4
        L_0x00e2:
            java.lang.String r0 = "app in background - start reload timer"
        L_0x00e4:
            r1 = r0
            r0 = r2
        L_0x00e6:
            if (r0 == 0) goto L_0x0108
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r0.verbose(r1)
            r0 = 3200(0xc80, float:4.484E-42)
            java.lang.Object[][] r1 = new java.lang.Object[r2][]
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "errorCode"
            r4[r3] = r5
            r5 = 614(0x266, float:8.6E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r2] = r5
            r1[r3] = r4
            r8.a((int) r0, (java.lang.Object[][]) r1)
            r8.d()
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0158k.a(com.ironsource.mediationsdk.k):void");
    }

    private void a(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, "BannerManager " + str, 0);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r8, com.ironsource.mediationsdk.ISBannerSize r9) {
        /*
            r7 = this;
            r0 = 3
            java.lang.String r1 = r9.getDescription()     // Catch:{ Exception -> 0x0088 }
            r2 = -1
            int r3 = r1.hashCode()     // Catch:{ Exception -> 0x0088 }
            r4 = 4
            r5 = 2
            r6 = 1
            switch(r3) {
                case -387072689: goto L_0x0039;
                case 72205083: goto L_0x002f;
                case 79011241: goto L_0x0025;
                case 1951953708: goto L_0x001b;
                case 1999208305: goto L_0x0011;
                default: goto L_0x0010;
            }     // Catch:{ Exception -> 0x0088 }
        L_0x0010:
            goto L_0x0043
        L_0x0011:
            java.lang.String r3 = "CUSTOM"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0088 }
            if (r1 == 0) goto L_0x0043
            r1 = r4
            goto L_0x0044
        L_0x001b:
            java.lang.String r3 = "BANNER"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0088 }
            if (r1 == 0) goto L_0x0043
            r1 = 0
            goto L_0x0044
        L_0x0025:
            java.lang.String r3 = "SMART"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0088 }
            if (r1 == 0) goto L_0x0043
            r1 = r0
            goto L_0x0044
        L_0x002f:
            java.lang.String r3 = "LARGE"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0088 }
            if (r1 == 0) goto L_0x0043
            r1 = r6
            goto L_0x0044
        L_0x0039:
            java.lang.String r3 = "RECTANGLE"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0088 }
            if (r1 == 0) goto L_0x0043
            r1 = r5
            goto L_0x0044
        L_0x0043:
            r1 = r2
        L_0x0044:
            java.lang.String r2 = "bannerAdSize"
            if (r1 == 0) goto L_0x0084
            if (r1 == r6) goto L_0x0080
            if (r1 == r5) goto L_0x007c
            if (r1 == r0) goto L_0x0077
            if (r1 == r4) goto L_0x0051
            goto L_0x0076
        L_0x0051:
            r1 = 6
            r8.put(r2, r1)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r1 = "custom_banner_size"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0088 }
            r2.<init>()     // Catch:{ Exception -> 0x0088 }
            int r3 = r9.getWidth()     // Catch:{ Exception -> 0x0088 }
            r2.append(r3)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ Exception -> 0x0088 }
            int r9 = r9.getHeight()     // Catch:{ Exception -> 0x0088 }
            r2.append(r9)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r9 = r2.toString()     // Catch:{ Exception -> 0x0088 }
            r8.put(r1, r9)     // Catch:{ Exception -> 0x0088 }
        L_0x0076:
            return
        L_0x0077:
            r9 = 5
            r8.put(r2, r9)     // Catch:{ Exception -> 0x0088 }
            goto L_0x00a2
        L_0x007c:
            r8.put(r2, r0)     // Catch:{ Exception -> 0x0088 }
            goto L_0x00a2
        L_0x0080:
            r8.put(r2, r5)     // Catch:{ Exception -> 0x0088 }
            goto L_0x00a2
        L_0x0084:
            r8.put(r2, r6)     // Catch:{ Exception -> 0x0088 }
            goto L_0x00a2
        L_0x0088:
            r8 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r7.e
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "sendProviderEvent "
            r2.<init>(r3)
            java.lang.String r8 = android.util.Log.getStackTraceString(r8)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r9.log(r1, r8, r0)
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0158k.a(org.json.JSONObject, com.ironsource.mediationsdk.ISBannerSize):void");
    }

    private boolean a() {
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    private void b() {
        Iterator<C0159l> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().d = true;
        }
    }

    private void b(C0159l lVar, View view, FrameLayout.LayoutParams layoutParams) {
        this.a = lVar;
        this.b.a(view, layoutParams);
    }

    private void b(C0159l lVar, View view, FrameLayout.LayoutParams layoutParams, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("bindView = " + z + " smash - " + lVar.a());
        a((int) IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS, lVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.n))}});
        a((int) IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.m))}});
        this.o = o.a().b(3);
        o.a().a(3);
        if (z) {
            b(lVar, view, layoutParams);
        }
        d();
    }

    private boolean c() {
        Iterator<C0159l> it = this.h.iterator();
        while (it.hasNext()) {
            C0159l next = it.next();
            if (next.d && this.a != next) {
                a(this.d == a.FIRST_LOAD_IN_PROGRESS ? IronSourceConstants.BN_INSTANCE_LOAD : IronSourceConstants.BN_INSTANCE_RELOAD, next, (Object[][]) null);
                this.n = new com.ironsource.mediationsdk.utils.f();
                next.a(this.b.a(), this.f, this.g);
                return true;
            }
        }
        return false;
    }

    private void d() {
        try {
            e();
            if (this.i > 0) {
                this.j = new Timer();
                this.j.schedule(new TimerTask() {
                    public final void run() {
                        C0158k.a(C0158k.this);
                    }
                }, this.i * 1000);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        Timer timer = this.j;
        if (timer != null) {
            timer.cancel();
            this.j = null;
        }
    }

    public final synchronized void a(IronSourceBannerLayout ironSourceBannerLayout) {
        if (ironSourceBannerLayout == null) {
            this.e.log(IronSourceLogger.IronSourceTag.API, "destroyBanner banner cannot be null", 3);
        } else if (ironSourceBannerLayout.isDestroyed()) {
            this.e.log(IronSourceLogger.IronSourceTag.API, "Banner is already destroyed and can't be used anymore. Please create a new one using IronSource.createBanner API", 3);
        } else {
            a((int) IronSourceConstants.BN_DESTROY, (Object[][]) null, this.o);
            e();
            if (this.a != null) {
                a((int) IronSourceConstants.BN_INSTANCE_DESTROY, this.a, (Object[][]) null);
                C0159l lVar = this.a;
                lVar.a("destroyBanner()");
                if (lVar.a == null) {
                    lVar.a("destroyBanner() mAdapter == null");
                } else {
                    lVar.a.destroyBanner(lVar.b.getBannerSettings());
                    lVar.a(C0159l.a.DESTROYED);
                }
                this.a = null;
            }
            ironSourceBannerLayout.b();
            this.b = null;
            this.c = null;
            a(a.READY_TO_LOAD);
        }
    }

    public final synchronized void a(IronSourceBannerLayout ironSourceBannerLayout, f fVar) {
        if (ironSourceBannerLayout != null) {
            try {
                if (!ironSourceBannerLayout.isDestroyed()) {
                    if (fVar != null) {
                        if (!TextUtils.isEmpty(fVar.getPlacementName())) {
                            if (this.d == a.READY_TO_LOAD) {
                                if (!C0157j.a().b()) {
                                    this.p = o.a().b(3);
                                    a(a.FIRST_LOAD_IN_PROGRESS);
                                    this.b = ironSourceBannerLayout;
                                    this.c = fVar;
                                    a(3001, (Object[][]) null);
                                    if (k.b((Context) ContextProvider.getInstance().getCurrentActiveActivity(), fVar.getPlacementName())) {
                                        C0157j a2 = C0157j.a();
                                        a2.a(ironSourceBannerLayout, new IronSourceError(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED, "placement " + fVar.getPlacementName() + " is capped"));
                                        a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED)}});
                                        a(a.READY_TO_LOAD);
                                        return;
                                    }
                                    this.m = new com.ironsource.mediationsdk.utils.f();
                                    Iterator<C0159l> it = this.h.iterator();
                                    while (it.hasNext()) {
                                        it.next().d = true;
                                    }
                                    this.n = new com.ironsource.mediationsdk.utils.f();
                                    C0159l lVar = this.h.get(0);
                                    a((int) IronSourceConstants.BN_INSTANCE_LOAD, lVar, (Object[][]) null);
                                    lVar.a(ironSourceBannerLayout.a(), this.f, this.g);
                                    return;
                                }
                            }
                            this.e.log(IronSourceLogger.IronSourceTag.API, "A banner is already loaded", 3);
                            return;
                        }
                    }
                    Object[] objArr = new Object[1];
                    objArr[0] = fVar == null ? "placement is null" : "placement name is empty";
                    this.e.log(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr), 3);
                    return;
                }
            } catch (Exception e2) {
                C0157j a3 = C0157j.a();
                a3.a(ironSourceBannerLayout, new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, "loadBanner() failed " + e2.getMessage()));
                a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_LOAD_EXCEPTION)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e2.getMessage()}});
                a(a.READY_TO_LOAD);
                return;
            }
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
        this.e.log(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr2), 3);
    }

    public final void a(C0159l lVar) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + lVar.a());
        if (a()) {
            this.b.c();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_CLICK, objArr, this.o);
        a((int) IronSourceConstants.BN_INSTANCE_CLICK, lVar, objArr, this.o);
    }

    public final void a(C0159l lVar, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + lVar.a());
        if (this.d == a.FIRST_LOAD_IN_PROGRESS) {
            a((int) IronSourceConstants.BN_INSTANCE_LOAD_SUCCESS, lVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.n))}});
            b(lVar, view, layoutParams);
            f fVar = this.c;
            String placementName = fVar != null ? fVar.getPlacementName() : "";
            k.f(ContextProvider.getInstance().getCurrentActiveActivity(), placementName);
            if (k.b((Context) ContextProvider.getInstance().getCurrentActiveActivity(), placementName)) {
                a((int) IronSourceConstants.BN_PLACEMENT_CAPPED, (Object[][]) null);
            }
            a((int) IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.m))}});
            this.b.a(lVar.a());
            this.o = o.a().b(3);
            o.a().a(3);
            a(a.RELOAD_IN_PROGRESS);
            d();
        } else if (this.d == a.LOAD_IN_PROGRESS) {
            a(a.RELOAD_IN_PROGRESS);
            b(lVar, view, layoutParams, true);
        } else {
            a((int) IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS, lVar, (Object[][]) null);
        }
    }

    public final void a(C0159l lVar, View view, FrameLayout.LayoutParams layoutParams, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + lVar.a());
        if (this.d != a.RELOAD_IN_PROGRESS) {
            a("onBannerAdReloaded " + lVar.a() + " wrong state=" + this.d.name());
            a((int) IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS, lVar, (Object[][]) null);
            return;
        }
        IronSourceUtils.sendAutomationLog("bannerReloadSucceeded");
        b(lVar, view, layoutParams, z);
    }

    public final void a(IronSourceError ironSourceError, C0159l lVar, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("error = " + ironSourceError.getErrorMessage() + " smash - " + lVar.a());
        if (this.d == a.FIRST_LOAD_IN_PROGRESS || this.d == a.LOAD_IN_PROGRESS) {
            if (z) {
                a((int) IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, lVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.n))}});
            } else {
                a((int) IronSourceConstants.BN_INSTANCE_LOAD_ERROR, lVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.n))}});
            }
            if (!c()) {
                if (this.d == a.FIRST_LOAD_IN_PROGRESS) {
                    C0157j.a().a(this.b, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_FILL, "No ads to show"));
                    a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_LOAD_NO_FILL)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.m))}});
                    a(a.READY_TO_LOAD);
                    return;
                }
                a((int) IronSourceConstants.BN_RELOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.m))}});
                a(a.RELOAD_IN_PROGRESS);
                d();
                return;
            }
            return;
        }
        a("onBannerAdLoadFailed " + lVar.a() + " wrong state=" + this.d.name());
    }

    public final void b(C0159l lVar) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + lVar.a());
        if (a()) {
            this.b.e();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, this.o);
        a((int) IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN, lVar, objArr, this.o);
    }

    public final void b(IronSourceError ironSourceError, C0159l lVar, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("error = " + ironSourceError.getErrorMessage() + " smash - " + lVar.a());
        if (this.d != a.RELOAD_IN_PROGRESS) {
            a("onBannerAdReloadFailed " + lVar.a() + " wrong state=" + this.d.name());
            return;
        }
        if (z) {
            a((int) IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL, lVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.n))}});
        } else {
            a((int) IronSourceConstants.BN_INSTANCE_RELOAD_ERROR, lVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.n))}});
        }
        if (this.h.size() == 1) {
            a((int) IronSourceConstants.BN_RELOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(com.ironsource.mediationsdk.utils.f.a(this.m))}});
            d();
            return;
        }
        a(a.LOAD_IN_PROGRESS);
        b();
        c();
    }

    public final void c(C0159l lVar) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + lVar.a());
        if (a()) {
            this.b.d();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, this.o);
        a((int) IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN, lVar, objArr, this.o);
    }

    public final void d(C0159l lVar) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + lVar.a());
        if (a()) {
            this.b.f();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, this.o);
        a((int) IronSourceConstants.BN_INSTANCE_LEAVE_APP, lVar, objArr, this.o);
    }

    public final void e(C0159l lVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + lVar.a());
        a((int) IronSourceConstants.BN_CALLBACK_SHOW, (Object[][]) null);
        a((int) IronSourceConstants.BN_INSTANCE_SHOW, lVar, (Object[][]) null);
    }
}
