package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class Y implements n.a {
    protected AbstractAdapter c;
    protected a d;
    boolean e;
    protected JSONObject f;
    protected String g;
    protected int h;
    protected Long i = null;

    Y(a aVar, AbstractAdapter abstractAdapter) {
        this.d = aVar;
        this.c = abstractAdapter;
        this.f = aVar.b;
    }

    private String a() {
        return this.d.a.isMultipleInstances() ? this.d.a.getProviderTypeForReflection() : this.d.a.getProviderName();
    }

    public final void b(String str) {
        C0153f.a();
        this.g = C0153f.d(str);
    }

    public void d() {
        try {
            if (this.c != null) {
                this.c.releaseMemory(this.d.f, this.f);
            }
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception - " + e2.getMessage());
        }
        this.c = null;
    }

    public int e() {
        return 1;
    }

    public final boolean h() {
        return this.d.c;
    }

    public final int i() {
        return this.d.d;
    }

    public final int j() {
        return this.d.e;
    }

    public final String k() {
        return this.d.a.getProviderName();
    }

    public final String l() {
        return this.d.a.getProviderTypeForReflection();
    }

    public final int m() {
        return this.h;
    }

    public final Map<String, Object> n() {
        HashMap hashMap = new HashMap();
        try {
            String str = "";
            hashMap.put("providerAdapterVersion", this.c != null ? this.c.getVersion() : str);
            if (this.c != null) {
                str = this.c.getCoreSDKVersion();
            }
            hashMap.put("providerSDKVersion", str);
            hashMap.put("spId", this.d.a.getSubProviderId());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.d.a.getAdSourceNameForEvents());
            hashMap.put("instanceType", Integer.valueOf(h() ? 2 : 1));
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(e()));
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.g);
            }
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "getProviderEventData " + k() + ")", e2);
        }
        return hashMap;
    }

    public final Long o() {
        return this.i;
    }

    public final String p() {
        return String.format("%s %s", new Object[]{a(), Integer.valueOf(hashCode())});
    }
}
