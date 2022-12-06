package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ironsource.mediationsdk.e  reason: case insensitive filesystem */
public final class C0152e {
    private static final C0152e c = new C0152e();
    final ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    final ConcurrentHashMap<String, String> b;

    private C0152e() {
        this.a.put("adcolony", "4.1.6");
        this.a.put("vungle", "4.1.5");
        this.a.put("applovin", "4.3.3");
        this.a.put("admob", "4.3.2");
        this.b = new ConcurrentHashMap<>();
        this.b.put("adcolony", "4.1.6");
        this.b.put("admob", "4.3.2");
        this.b.put("applovin", "4.3.3");
        this.b.put("chartboost", "4.1.9");
        this.b.put("fyber", "4.1.0");
        this.b.put("hyprmx", "4.1.2");
        this.b.put("inmobi", "4.3.1");
        this.b.put("maio", "4.1.3");
        this.b.put("tapjoy", "4.0.0");
        this.b.put("unityads", "4.1.4");
        this.b.put("vungle", "4.1.5");
    }

    public static C0152e a() {
        return c;
    }

    private static boolean a(String str, String str2) {
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i = 0; i < 3; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt2 < parseInt) {
                return false;
            }
            if (parseInt2 > parseInt) {
                return true;
            }
        }
        return true;
    }

    public final boolean a(AbstractAdapter abstractAdapter) {
        if (abstractAdapter == null) {
            return false;
        }
        String version = abstractAdapter.getVersion();
        boolean a2 = a("4.3.0", version);
        if (!a2) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, abstractAdapter.getProviderName() + " adapter " + version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + ", please update your adapter to the latest version", 3);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(AbstractAdapter abstractAdapter, Map<String, String> map, String str) {
        if (abstractAdapter == null) {
            return false;
        }
        String lowerCase = abstractAdapter.getProviderName().toLowerCase(Locale.ENGLISH);
        if (!map.containsKey(lowerCase)) {
            return true;
        }
        String version = abstractAdapter.getVersion();
        boolean a2 = a(map.get(lowerCase), version);
        if (!a2) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, abstractAdapter.getProviderName() + " adapter " + version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + " for " + str + " ad unit, please update your adapter to the latest version", 3);
        }
        return a2;
    }
}
