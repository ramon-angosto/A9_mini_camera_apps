package com.ironsource.mediationsdk;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.e;
import com.ironsource.mediationsdk.sdk.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.q  reason: case insensitive filesystem */
public final class C0164q implements b {
    C0165r a;
    IronSourceBannerLayout b;
    ConcurrentHashMap<String, C0165r> c = new ConcurrentHashMap<>();
    private C0165r d;

    public C0164q(List<NetworkSettings> list, e eVar, String str, String str2) {
        for (NetworkSettings next : list) {
            if (next.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) || next.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME)) {
                AbstractAdapter a2 = C0151d.a().a(next, next.getBannerSettings(), true, false);
                if (a2 != null) {
                    this.c.put(next.getSubProviderId(), new C0165r(str, str2, next, this, (int) eVar.b, a2));
                }
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("cannot load " + next.getProviderTypeForReflection());
            }
        }
    }

    static void a(int i, C0165r rVar, Object[][] objArr) {
        Map<String, Object> c2 = rVar.c();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    c2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error(e.getMessage());
            }
        }
        d.e().b(new c(i, new JSONObject(c2)));
    }

    static void a(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
        if (str == null) {
            str = "";
        }
        hashMap.put("spId", str);
        d.e().b(new c(i, new JSONObject(hashMap)));
    }

    /* access modifiers changed from: package-private */
    public void a(int i, C0165r rVar) {
        a(i, rVar, (Object[][]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.ironsource.mediationsdk.IronSourceBannerLayout r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "demand only banner manager : destroyBanner"
            r0.verbose(r1)     // Catch:{ all -> 0x005c }
            if (r4 != 0) goto L_0x0013
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x005c }
            java.lang.String r0 = "destroyBanner banner cannot be null"
            r4.error(r0)     // Catch:{ all -> 0x005c }
            monitor-exit(r3)
            return
        L_0x0013:
            boolean r0 = r4.isDestroyed()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0022
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x005c }
            java.lang.String r0 = "Banner is already destroyed and can't be used anymore. Please create a new one using IronSource.createBanner API"
            r4.error(r0)     // Catch:{ all -> 0x005c }
            monitor-exit(r3)
            return
        L_0x0022:
            r4.b()     // Catch:{ all -> 0x005c }
            r4 = 0
            r3.b = r4     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.r r0 = r3.d     // Catch:{ all -> 0x005c }
            r1 = 3305(0xce9, float:4.631E-42)
            if (r0 == 0) goto L_0x0043
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x005c }
            java.lang.String r2 = "demand only banner manager : destroyBanner | mActiveSmash != null "
            r0.verbose(r2)     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.r r0 = r3.d     // Catch:{ all -> 0x005c }
            a((int) r1, (com.ironsource.mediationsdk.C0165r) r0, (java.lang.Object[][]) r4)     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.r r0 = r3.d     // Catch:{ all -> 0x005c }
            r0.a()     // Catch:{ all -> 0x005c }
            r3.d = r4     // Catch:{ all -> 0x005c }
            monitor-exit(r3)
            return
        L_0x0043:
            com.ironsource.mediationsdk.r r0 = r3.a     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x005a
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x005c }
            java.lang.String r2 = "demand only banner manager : destroyBanner | mLoadingSmash != null "
            r0.verbose(r2)     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.r r0 = r3.a     // Catch:{ all -> 0x005c }
            a((int) r1, (com.ironsource.mediationsdk.C0165r) r0, (java.lang.Object[][]) r4)     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.r r0 = r3.a     // Catch:{ all -> 0x005c }
            r0.a()     // Catch:{ all -> 0x005c }
            r3.a = r4     // Catch:{ all -> 0x005c }
        L_0x005a:
            monitor-exit(r3)
            return
        L_0x005c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0164q.a(com.ironsource.mediationsdk.IronSourceBannerLayout):void");
    }

    public final void a(IronSourceError ironSourceError, C0165r rVar, boolean z, long j) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError.getErrorMessage() + " smash - " + rVar.b());
        if (z) {
            a((int) IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, rVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        } else {
            a((int) IronSourceConstants.BN_INSTANCE_LOAD_ERROR, rVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        }
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            this.b.a(ironSourceError);
        }
    }

    public final void a(C0165r rVar) {
        IronLog.INTERNAL.verbose(rVar.b());
        a((int) IronSourceConstants.BN_INSTANCE_CLICK, rVar, (Object[][]) null);
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.c();
        }
    }

    public final void a(C0165r rVar, View view, FrameLayout.LayoutParams layoutParams) {
        C0165r rVar2 = rVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + rVar.b());
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            a((int) IronSourceConstants.BN_INSTANCE_LOAD_ERROR, rVar2);
            return;
        }
        IronSourceBannerLayout ironSourceBannerLayout2 = this.b;
        if (ironSourceBannerLayout2 != null) {
            ironSourceBannerLayout2.a(view, layoutParams);
        }
        this.d = rVar2;
        int b2 = o.a().b(3);
        a((int) IronSourceConstants.BN_INSTANCE_LOAD_SUCCESS, rVar2, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(b2)}});
        a((int) IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, rVar2, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(b2)}});
        o.a().a(3);
        if (rVar.i()) {
            for (String a2 : rVar2.g) {
                C0153f.a();
                String a3 = C0153f.a(a2, rVar.d(), rVar.e(), rVar2.h, "", "", "", "");
                C0153f.a();
                C0153f.a("onBannerAdLoaded", rVar.d(), a3);
            }
        }
        IronSourceBannerLayout ironSourceBannerLayout3 = this.b;
        if (ironSourceBannerLayout3 != null) {
            ironSourceBannerLayout3.a(String.format("%s %s", new Object[]{rVar.b(), Integer.valueOf(rVar.hashCode())}));
        }
    }

    public final void b(C0165r rVar) {
        IronLog.INTERNAL.verbose(rVar.b());
        a((int) IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN, rVar, (Object[][]) null);
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.e();
        }
    }

    public final void c(C0165r rVar) {
        IronLog.INTERNAL.verbose(rVar.b());
        a((int) IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN, rVar, (Object[][]) null);
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.d();
        }
    }

    public final void d(C0165r rVar) {
        IronLog.INTERNAL.verbose(rVar.b());
        a((int) IronSourceConstants.BN_INSTANCE_LEFT_APPLICATION, rVar, (Object[][]) null);
        IronSourceBannerLayout ironSourceBannerLayout = this.b;
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.f();
        }
    }

    public final void e(C0165r rVar) {
        IronLog.INTERNAL.verbose(rVar.b());
        a((int) IronSourceConstants.BN_INSTANCE_SHOW, rVar, (Object[][]) null);
        a((int) IronSourceConstants.BN_CALLBACK_SHOW, "");
    }
}
