package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.f;
import com.ironsource.mediationsdk.sdk.j;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.l;
import com.ironsource.mediationsdk.utils.o;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class O implements f {
    j a;
    f b;
    private final String c = getClass().getName();
    private IronSourceLoggerManager d = IronSourceLoggerManager.getLogger();
    private AtomicBoolean e = new AtomicBoolean(true);
    private AtomicBoolean f = new AtomicBoolean(false);
    private l g;
    private NetworkSettings h;
    private String i;

    O() {
    }

    private synchronized void a(IronSourceError ironSourceError) {
        if (this.f != null) {
            this.f.set(false);
        }
        if (this.e != null) {
            this.e.set(true);
        }
        if (this.b != null) {
            this.b.a(false, ironSourceError);
        }
    }

    private AbstractAdapter b(String str) {
        try {
            H a2 = H.a();
            AbstractAdapter b2 = a2.b(str);
            if (b2 == null) {
                Class<?> cls = Class.forName("com.ironsource.adapters." + str.toLowerCase(Locale.ENGLISH) + "." + str + "Adapter");
                b2 = (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, new Class[]{String.class}).invoke(cls, new Object[]{str});
                if (b2 == null) {
                    return null;
                }
            }
            a2.a(b2);
            return b2;
        } catch (Throwable th) {
            IronSourceLoggerManager ironSourceLoggerManager = this.d;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, str + " initialization failed - please verify that required dependencies are in you build path.", 2);
            IronSourceLoggerManager ironSourceLoggerManager2 = this.d;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager2.logException(ironSourceTag2, this.c + ":startOfferwallAdapter", th);
            return null;
        }
    }

    public final void a(String str) {
        String str2 = "OWManager:showOfferwall(" + str + ")";
        try {
            if (!IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
                this.b.onOfferwallShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError(IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            this.i = str;
            com.ironsource.mediationsdk.model.j a2 = this.g.c.c.a(str);
            if (a2 == null) {
                this.d.log(IronSourceLogger.IronSourceTag.INTERNAL, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                a2 = this.g.c.c.a();
                if (a2 == null) {
                    this.d.log(IronSourceLogger.IronSourceTag.INTERNAL, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.d.log(IronSourceLogger.IronSourceTag.INTERNAL, str2, 1);
            if (this.f != null && this.f.get() && this.a != null) {
                this.a.showOfferwall(String.valueOf(a2.a), this.h.getRewardedVideoSettings());
            }
        } catch (Exception e2) {
            this.d.logException(IronSourceLogger.IronSourceTag.INTERNAL, str2, e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c A[Catch:{ Exception -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069 A[SYNTHETIC, Splitter:B:18:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r7.d     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.NATIVE     // Catch:{ all -> 0x0102 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r2.<init>()     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = r7.c     // Catch:{ all -> 0x0102 }
            r2.append(r3)     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = ":initOfferwall(appKey: "
            r2.append(r3)     // Catch:{ all -> 0x0102 }
            r2.append(r8)     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = ", userId: "
            r2.append(r3)     // Catch:{ all -> 0x0102 }
            r2.append(r9)     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0102 }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.H r0 = com.ironsource.mediationsdk.H.a()     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.utils.l r0 = r0.i     // Catch:{ all -> 0x0102 }
            r7.g = r0     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.utils.l r0 = r7.g     // Catch:{ all -> 0x0102 }
            if (r0 == 0) goto L_0x0056
            com.ironsource.mediationsdk.model.g r1 = r0.c     // Catch:{ all -> 0x0102 }
            if (r1 == 0) goto L_0x0056
            com.ironsource.mediationsdk.model.g r1 = r0.c     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.model.i r1 = r1.c     // Catch:{ all -> 0x0102 }
            if (r1 == 0) goto L_0x0056
            com.ironsource.mediationsdk.model.g r1 = r0.c     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.model.i r1 = r1.c     // Catch:{ all -> 0x0102 }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0102 }
            if (r1 != 0) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            com.ironsource.mediationsdk.model.g r0 = r0.c     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.model.i r0 = r0.c     // Catch:{ all -> 0x0102 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0102 }
            goto L_0x0058
        L_0x0056:
            java.lang.String r0 = "SupersonicAds"
        L_0x0058:
            com.ironsource.mediationsdk.utils.l r1 = r7.g     // Catch:{ all -> 0x0102 }
            if (r1 != 0) goto L_0x0069
            java.lang.String r8 = "Please check configurations for Offerwall adapters"
            java.lang.String r9 = "Offerwall"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r9)     // Catch:{ all -> 0x0102 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0102 }
            monitor-exit(r7)
            return
        L_0x0069:
            com.ironsource.mediationsdk.utils.l r1 = r7.g     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.model.n r1 = r1.b     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0102 }
            r7.h = r1     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r7.h     // Catch:{ all -> 0x0102 }
            if (r1 != 0) goto L_0x0084
            java.lang.String r8 = "Please check configurations for Offerwall adapters"
            java.lang.String r9 = "Offerwall"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r9)     // Catch:{ all -> 0x0102 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0102 }
            monitor-exit(r7)
            return
        L_0x0084:
            com.ironsource.mediationsdk.AbstractAdapter r0 = r7.b(r0)     // Catch:{ all -> 0x0102 }
            if (r0 != 0) goto L_0x0097
            java.lang.String r8 = "Please check configurations for Offerwall adapters"
            java.lang.String r9 = "Offerwall"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r9)     // Catch:{ all -> 0x0102 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0102 }
            monitor-exit(r7)
            return
        L_0x0097:
            com.ironsource.mediationsdk.H r1 = com.ironsource.mediationsdk.H.a()     // Catch:{ Exception -> 0x00cc }
            java.lang.String r1 = r1.l     // Catch:{ Exception -> 0x00cc }
            if (r1 == 0) goto L_0x00a2
            r0.setMediationSegment(r1)     // Catch:{ Exception -> 0x00cc }
        L_0x00a2:
            com.ironsource.mediationsdk.H r1 = com.ironsource.mediationsdk.H.a()     // Catch:{ Exception -> 0x00cc }
            java.lang.Boolean r1 = r1.y     // Catch:{ Exception -> 0x00cc }
            if (r1 == 0) goto L_0x00e7
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r7.d     // Catch:{ Exception -> 0x00cc }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.ADAPTER_API     // Catch:{ Exception -> 0x00cc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cc }
            java.lang.String r6 = "Offerwall | setConsent(consent:"
            r5.<init>(r6)     // Catch:{ Exception -> 0x00cc }
            r5.append(r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00cc }
            r2.log(r4, r5, r3)     // Catch:{ Exception -> 0x00cc }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x00cc }
            r0.setConsent(r1)     // Catch:{ Exception -> 0x00cc }
            goto L_0x00e7
        L_0x00cc:
            r1 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r7.d     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x0102 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            java.lang.String r5 = ":setCustomParams():"
            r4.<init>(r5)     // Catch:{ all -> 0x0102 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0102 }
            r4.append(r1)     // Catch:{ all -> 0x0102 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0102 }
            r4 = 3
            r2.log(r3, r1, r4)     // Catch:{ all -> 0x0102 }
        L_0x00e7:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r7.d     // Catch:{ all -> 0x0102 }
            r0.setLogListener(r1)     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.sdk.j r0 = (com.ironsource.mediationsdk.sdk.j) r0     // Catch:{ all -> 0x0102 }
            r7.a = r0     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.sdk.j r0 = r7.a     // Catch:{ all -> 0x0102 }
            r0.setInternalOfferwallListener(r7)     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.sdk.j r0 = r7.a     // Catch:{ all -> 0x0102 }
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r7.h     // Catch:{ all -> 0x0102 }
            org.json.JSONObject r1 = r1.getRewardedVideoSettings()     // Catch:{ all -> 0x0102 }
            r0.initOfferwall(r8, r9, r1)     // Catch:{ all -> 0x0102 }
            monitor-exit(r7)
            return
        L_0x0102:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.O.a(java.lang.String, java.lang.String):void");
    }

    public final void a(boolean z, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallAvailable(isAvailable: " + z + ")", 1);
        if (z) {
            this.f.set(true);
            f fVar = this.b;
            if (fVar != null) {
                fVar.onOfferwallAvailable(true);
                return;
            }
            return;
        }
        a(ironSourceError);
    }

    public final synchronized boolean a() {
        boolean z;
        z = false;
        if (this.f != null) {
            z = this.f.get();
        }
        return z;
    }

    public final void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onGetOfferwallCreditsFailed(" + ironSourceError + ")", 1);
        f fVar = this.b;
        if (fVar != null) {
            fVar.onGetOfferwallCreditsFailed(ironSourceError);
        }
    }

    public final boolean onOfferwallAdCredited(int i2, int i3, boolean z) {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        f fVar = this.b;
        if (fVar != null) {
            return fVar.onOfferwallAdCredited(i2, i3, z);
        }
        return false;
    }

    public final void onOfferwallAvailable(boolean z) {
        a(z, (IronSourceError) null);
    }

    public final void onOfferwallClosed() {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        f fVar = this.b;
        if (fVar != null) {
            fVar.onOfferwallClosed();
        }
    }

    public final void onOfferwallOpened() {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        int b2 = o.a().b(0);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (!TextUtils.isEmpty(this.i)) {
                mediationAdditionalData.put("placement", this.i);
            }
            mediationAdditionalData.put(IronSourceConstants.KEY_SESSION_DEPTH, b2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        h.e().b(new c(IronSourceConstants.OFFERWALL_OPENED, mediationAdditionalData));
        o.a().a(0);
        f fVar = this.b;
        if (fVar != null) {
            fVar.onOfferwallOpened();
        }
    }

    public final void onOfferwallShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallShowFailed(" + ironSourceError + ")", 1);
        f fVar = this.b;
        if (fVar != null) {
            fVar.onOfferwallShowFailed(ironSourceError);
        }
    }
}
