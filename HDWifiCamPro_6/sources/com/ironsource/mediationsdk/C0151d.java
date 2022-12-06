package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.d  reason: case insensitive filesystem */
public final class C0151d {
    private static final C0151d d = new C0151d();
    private static final Object e = new Object();
    String a;
    String b;
    final ConcurrentHashMap<String, List<String>> c = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AbstractAdapter> f = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AdapterBaseWrapper> g = new ConcurrentHashMap<>();
    private Boolean h;
    private Boolean i;
    private final ConcurrentHashMap<IronSource.AD_UNIT, JSONObject> j = new ConcurrentHashMap<>();
    private final AtomicBoolean k = new AtomicBoolean(false);

    /* renamed from: com.ironsource.mediationsdk.d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[IronSource.AD_UNIT.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r0 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0151d.AnonymousClass1.<clinit>():void");
        }
    }

    private C0151d() {
    }

    private AbstractAdapter a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.ironsource.adapters." + str2.toLowerCase(Locale.ENGLISH) + "." + str2 + "Adapter");
            return (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            String str3 = "Error while loading adapter - exception = " + e2.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
            a(str3);
            return null;
        }
    }

    private AdapterBaseInterface a(String str, String str2, NetworkSettings networkSettings) {
        if (!networkSettings.isCustomNetwork() || !TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            String str3 = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : "com.ironsource.adapters") + "." + str2;
            try {
                BaseAdapter baseAdapter = (BaseAdapter) Class.forName(str3).newInstance();
                IronLog.INTERNAL.info(str3 + " was allocated (adapter version: " + baseAdapter.getAdapterVersion() + ", sdk version: " + baseAdapter.getNetworkSDKVersion() + ")");
                if (this.i != null && (baseAdapter instanceof AdapterDebugInterface)) {
                    try {
                        baseAdapter.setAdapterDebug(this.i.booleanValue());
                    } catch (Exception e2) {
                        String str4 = "error while setting adapterDebug of " + baseAdapter.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str4);
                        b(str4);
                        e2.printStackTrace();
                    }
                }
                this.g.put(str, new AdapterBaseWrapper(baseAdapter, networkSettings));
                return baseAdapter;
            } catch (Exception unused) {
                if (networkSettings.isCustomNetwork()) {
                    String str5 = "failed to load " + str3;
                    IronLog.INTERNAL.error(str5);
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str5);
                }
                return null;
            }
        } else {
            IronLog.INTERNAL.error("missing package definition for " + str);
            return null;
        }
    }

    public static C0151d a() {
        return d;
    }

    private static void a(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
            }
            d.e().b(new c(i2, jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(AbstractAdapter abstractAdapter) {
        try {
            if (this.h != null) {
                abstractAdapter.setConsent(this.h.booleanValue());
            }
        } catch (Throwable th) {
            String str = "error while setting consent of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
            b(str);
            th.printStackTrace();
        }
    }

    private void a(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, "APSData is empty");
            a("APSData is empty");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            if (!this.f.isEmpty()) {
                for (AbstractAdapter next : this.f.values()) {
                    if (next.getProviderName().toLowerCase(Locale.ENGLISH).equals("aps") && (next instanceof SetAPSInterface)) {
                        ((SetAPSInterface) next).setAPSData(ad_unit, jSONObject2);
                        return;
                    }
                }
            }
            for (AdapterBaseWrapper next2 : this.g.values()) {
                AdapterBaseInterface adapterBaseInterface = next2.getAdapterBaseInterface();
                if (!next2.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterAPSDataInterface)) {
                    ((AdapterAPSDataInterface) adapterBaseInterface).setAPSData(ad_unit, jSONObject2);
                    return;
                }
            }
            synchronized (e) {
                this.j.put(ad_unit, jSONObject2);
            }
        } catch (Exception e2) {
            String str = "error while setting APSData: " + e2.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str);
            a(str);
            e2.printStackTrace();
        }
    }

    private static void a(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "AdapterRepository: " + str, 3);
    }

    private static String b(NetworkSettings networkSettings) {
        return networkSettings.isMultipleInstances() ? networkSettings.getProviderDefaultInstance() : networkSettings.getProviderName();
    }

    private void b(AbstractAdapter abstractAdapter) {
        Boolean bool = this.i;
        if (bool != null) {
            try {
                abstractAdapter.setAdapterDebug(bool);
            } catch (Throwable th) {
                String str = "error while setting adapterDebug of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
                th.printStackTrace();
            }
        }
    }

    private static void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "AdapterRepository: " + str, 0);
    }

    private BaseAdAdapter<?, ?> c(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        if (!networkSettings.isCustomNetwork() || !TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            String str = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : "com.ironsource.adapters") + "." + (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName(ad_unit) : networkSettings.getProviderTypeForReflection());
            try {
                return (BaseAdAdapter) Class.forName(str).getConstructor(new Class[]{NetworkSettings.class}).newInstance(new Object[]{networkSettings});
            } catch (Exception unused) {
                if (networkSettings.isCustomNetwork()) {
                    String str2 = "failed to load " + str;
                    IronLog.INTERNAL.error(str2);
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                }
                return null;
            }
        } else {
            IronLog.INTERNAL.error("missing package definition for " + networkSettings.getProviderTypeForReflection());
            return null;
        }
    }

    private void c(AbstractAdapter abstractAdapter) {
        for (String next : this.c.keySet()) {
            try {
                List list = this.c.get(next);
                IronSourceUtils.sendAutomationLog(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + next + ", values = " + list);
                if (list != null) {
                    abstractAdapter.setMetaData(next, (List<String>) list);
                }
            } catch (Throwable th) {
                String str = "error while setting metadata of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
                th.printStackTrace();
            }
        }
    }

    private void d(AbstractAdapter abstractAdapter) {
        if (abstractAdapter.getProviderName().toLowerCase(Locale.ENGLISH).equals("aps") && this.j.size() != 0) {
            for (IronSource.AD_UNIT next : this.j.keySet()) {
                try {
                    JSONObject jSONObject = this.j.get(next);
                    if (jSONObject != null && jSONObject.length() > 0 && (abstractAdapter instanceof SetAPSInterface)) {
                        ((SetAPSInterface) abstractAdapter).setAPSData(next, jSONObject);
                    }
                } catch (Exception e2) {
                    String str = "error while setting aps data: " + e2.getLocalizedMessage();
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str);
                    b(str);
                    e2.printStackTrace();
                }
            }
            this.j.clear();
        }
    }

    public final AbstractAdapter a(NetworkSettings networkSettings) {
        String b2 = b(networkSettings);
        return networkSettings.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) ? this.f.get(b2) : a(b2, networkSettings.getProviderTypeForReflection());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0114, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ironsource.mediationsdk.AbstractAdapter a(com.ironsource.mediationsdk.model.NetworkSettings r7, org.json.JSONObject r8, boolean r9, boolean r10) {
        /*
            r6 = this;
            java.lang.String r0 = b((com.ironsource.mediationsdk.model.NetworkSettings) r7)
            if (r9 == 0) goto L_0x0009
            java.lang.String r7 = "IronSource"
            goto L_0x000d
        L_0x0009:
            java.lang.String r7 = r7.getProviderTypeForReflection()
        L_0x000d:
            java.lang.Object r9 = e
            monitor-enter(r9)
            if (r10 != 0) goto L_0x0024
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r1 = r6.f     // Catch:{ all -> 0x0115 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0115 }
            if (r1 == 0) goto L_0x0024
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r7 = r6.f     // Catch:{ all -> 0x0115 }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x0115 }
            com.ironsource.mediationsdk.AbstractAdapter r7 = (com.ironsource.mediationsdk.AbstractAdapter) r7     // Catch:{ all -> 0x0115 }
            monitor-exit(r9)     // Catch:{ all -> 0x0115 }
            return r7
        L_0x0024:
            com.ironsource.mediationsdk.AbstractAdapter r1 = r6.a((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x0115 }
            if (r1 != 0) goto L_0x0041
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r7.<init>()     // Catch:{ all -> 0x0115 }
            r7.append(r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r8 = " adapter was not loaded"
            r7.append(r8)     // Catch:{ all -> 0x0115 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0115 }
            a((java.lang.String) r7)     // Catch:{ all -> 0x0115 }
            r7 = 0
            monitor-exit(r9)     // Catch:{ all -> 0x0115 }
            return r7
        L_0x0041:
            r2 = 88001(0x157c1, float:1.23316E-40)
            java.lang.String r3 = r1.getCoreSDKVersion()     // Catch:{ Exception -> 0x0049 }
            goto L_0x0072
        L_0x0049:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = "error while retrieving coreSDKVersion "
            r4.<init>(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r1.getProviderName()     // Catch:{ all -> 0x0115 }
            r4.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = ": "
            r4.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x0115 }
            r4.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0115 }
            a((int) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0115 }
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0115 }
            r4.error(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "Unknown"
        L_0x0072:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r4.<init>()     // Catch:{ all -> 0x0115 }
            r4.append(r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = " was allocated (adapter version: "
            r4.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r1.getVersion()     // Catch:{ all -> 0x0115 }
            r4.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = ", sdk version: "
            r4.append(r5)     // Catch:{ all -> 0x0115 }
            r4.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = ")"
            r4.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0115 }
            b((java.lang.String) r3)     // Catch:{ all -> 0x0115 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x0115 }
            r1.setLogListener(r3)     // Catch:{ all -> 0x0115 }
            r6.c(r1)     // Catch:{ all -> 0x0115 }
            r6.d(r1)     // Catch:{ all -> 0x0115 }
            r6.a((com.ironsource.mediationsdk.AbstractAdapter) r1)     // Catch:{ all -> 0x0115 }
            r6.b((com.ironsource.mediationsdk.AbstractAdapter) r1)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "SupersonicAds"
            boolean r3 = r7.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0115 }
            if (r3 != 0) goto L_0x00bd
            java.lang.String r3 = "IronSource"
            boolean r3 = r7.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0115 }
            if (r3 == 0) goto L_0x010c
        L_0x00bd:
            java.util.concurrent.atomic.AtomicBoolean r3 = r6.k     // Catch:{ all -> 0x0115 }
            r4 = 0
            r5 = 1
            boolean r3 = r3.compareAndSet(r4, r5)     // Catch:{ all -> 0x0115 }
            if (r3 == 0) goto L_0x010c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            java.lang.String r4 = "SDK5 earlyInit  <"
            r3.<init>(r4)     // Catch:{ all -> 0x0115 }
            r3.append(r7)     // Catch:{ all -> 0x0115 }
            java.lang.String r7 = ">"
            r3.append(r7)     // Catch:{ all -> 0x0115 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0115 }
            b((java.lang.String) r7)     // Catch:{ all -> 0x0115 }
            java.lang.String r7 = r6.a     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r3 = r6.b     // Catch:{ Exception -> 0x00e5 }
            r1.earlyInit(r7, r3, r8)     // Catch:{ Exception -> 0x00e5 }
            goto L_0x010c
        L_0x00e5:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "error while calling early init for "
            r8.<init>(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = r1.getProviderName()     // Catch:{ all -> 0x0115 }
            r8.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = ": "
            r8.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x0115 }
            r8.append(r7)     // Catch:{ all -> 0x0115 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0115 }
            a((int) r2, (java.lang.String) r7)     // Catch:{ all -> 0x0115 }
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0115 }
            r8.error(r7)     // Catch:{ all -> 0x0115 }
        L_0x010c:
            if (r10 != 0) goto L_0x0113
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r7 = r6.f     // Catch:{ all -> 0x0115 }
            r7.put(r0, r1)     // Catch:{ all -> 0x0115 }
        L_0x0113:
            monitor-exit(r9)     // Catch:{ all -> 0x0115 }
            return r1
        L_0x0115:
            r7 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0115 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0151d.a(com.ironsource.mediationsdk.model.NetworkSettings, org.json.JSONObject, boolean, boolean):com.ironsource.mediationsdk.AbstractAdapter");
    }

    public final AdapterBaseInterface a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        String b2 = b(networkSettings);
        if (this.g.containsKey(b2)) {
            AdapterBaseInterface adapterBaseInterface = this.g.get(b2).getAdapterBaseInterface();
            if (adapterBaseInterface instanceof N) {
                ((N) adapterBaseInterface).a = ad_unit;
            }
            return adapterBaseInterface;
        }
        AdapterBaseInterface a2 = a(b2, networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName((IronSource.AD_UNIT) null) : networkSettings.getProviderTypeForReflection(), networkSettings);
        if (a2 != null) {
            return a2;
        }
        int i2 = AnonymousClass1.a[ad_unit.ordinal()];
        AbstractAdapter a3 = a(networkSettings, i2 != 1 ? i2 != 2 ? i2 != 3 ? null : networkSettings.getBannerSettings() : networkSettings.getInterstitialSettings() : networkSettings.getRewardedVideoSettings(), false, true);
        if (a3 != null) {
            N n = new N(a3, networkSettings, ad_unit);
            this.g.put(b2, new AdapterBaseWrapper(n, networkSettings));
            return n;
        }
        String str = "error creating network adapter " + networkSettings.getProviderName();
        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    public final void a(String str, List<String> list) {
        synchronized (e) {
            this.c.put(str, list);
            if (!this.f.isEmpty()) {
                IronSourceUtils.sendAutomationLog("setMetaData key = " + str + ", values = " + list);
                for (AbstractAdapter next : this.f.values()) {
                    try {
                        next.setMetaData(str, list);
                    } catch (Throwable th) {
                        String str2 = "error while setting metadata of " + next.getProviderName() + ": " + th.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                        b(str2);
                        th.printStackTrace();
                    }
                }
            }
            for (AdapterBaseWrapper next2 : this.g.values()) {
                AdapterBaseInterface adapterBaseInterface = next2.getAdapterBaseInterface();
                if (!next2.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterMetaDataInterface)) {
                    try {
                        ((AdapterMetaDataInterface) adapterBaseInterface).setMetaData(str, list);
                    } catch (Exception e2) {
                        String str3 = "error while setting metadata of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
                        b(str3);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        String str2;
        IronSource.AD_UNIT ad_unit;
        if (TextUtils.isEmpty(str)) {
            str2 = "Calling setNetworkData on an empty network";
        } else if (jSONObject == null || jSONObject.length() == 0) {
            str2 = "Calling setNetworkData with empty networkData";
        } else if (str.toLowerCase(Locale.ENGLISH).equals("aps")) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.toLowerCase(Locale.ENGLISH).equals(IronSource.AD_UNIT.BANNER.toString())) {
                    ad_unit = IronSource.AD_UNIT.BANNER;
                } else if (next.toLowerCase(Locale.ENGLISH).equals(IronSource.AD_UNIT.INTERSTITIAL.toString())) {
                    ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
                }
                a(ad_unit, jSONObject.optJSONObject(next));
            }
            return;
        } else {
            str2 = "Calling setNetworkData on an unsupported network: " + str;
        }
        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str2);
        a(str2);
    }

    public final void a(boolean z) {
        synchronized (e) {
            this.h = Boolean.valueOf(z);
            for (AbstractAdapter a2 : this.f.values()) {
                a(a2);
            }
            for (AdapterBaseWrapper next : this.g.values()) {
                AdapterBaseInterface adapterBaseInterface = next.getAdapterBaseInterface();
                if (!next.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterConsentInterface)) {
                    try {
                        ((AdapterConsentInterface) adapterBaseInterface).setConsent(z);
                    } catch (Exception e2) {
                        String str = "error while setting consent of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                        b(str);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final BaseAdAdapter<?, ?> b(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        BaseAdAdapter<?, ?> c2 = c(networkSettings, ad_unit);
        if (c2 != null) {
            return c2;
        }
        AbstractAdapter a2 = a(networkSettings);
        if (a2 != null) {
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
                return new N(a2, networkSettings, ad_unit);
            }
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
                return new N(a2, networkSettings, ad_unit);
            }
        }
        String str = "error creating ad adapter " + networkSettings.getProviderName();
        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    public final void b(boolean z) {
        synchronized (e) {
            this.i = Boolean.valueOf(z);
            for (AbstractAdapter b2 : this.f.values()) {
                b(b2);
            }
        }
    }
}
