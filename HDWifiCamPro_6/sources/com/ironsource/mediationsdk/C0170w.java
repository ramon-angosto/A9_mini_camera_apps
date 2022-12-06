package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.w  reason: case insensitive filesystem */
public class C0170w {
    protected AbstractAdapter a;
    protected com.ironsource.mediationsdk.model.a b;
    protected JSONObject c;
    int d;
    protected String e;
    protected JSONObject f;
    protected List<String> g;
    protected String h;
    private a i;
    private Timer j;
    private final Object k = new Object();
    private final Object l = new Object();

    /* renamed from: com.ironsource.mediationsdk.w$a */
    public enum a {
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public C0170w(com.ironsource.mediationsdk.model.a aVar, AbstractAdapter abstractAdapter) {
        this.b = aVar;
        this.a = abstractAdapter;
        this.c = aVar.b;
        this.i = a.NOT_LOADED;
        this.j = null;
        this.e = "";
        this.f = null;
        this.g = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public final a a(a[] aVarArr, a aVar) {
        a aVar2;
        synchronized (this.k) {
            aVar2 = this.i;
            if (Arrays.asList(aVarArr).contains(this.i)) {
                a(aVar);
            }
        }
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlySmash " + this.b.a.getProviderName() + ": current state=" + this.i + ", new state=" + aVar, 0);
        synchronized (this.k) {
            this.i = aVar;
        }
    }

    public final void a(String str) {
        C0153f.a();
        this.h = C0153f.d(str);
    }

    /* access modifiers changed from: package-private */
    public final void a(TimerTask timerTask) {
        synchronized (this.l) {
            h();
            this.j = new Timer();
            this.j.schedule(timerTask, (long) (this.d * 1000));
        }
    }

    public final void a(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(a aVar, a aVar2) {
        synchronized (this.k) {
            if (this.i != aVar) {
                return false;
            }
            a(aVar2);
            return true;
        }
    }

    public final void b(String str) {
        this.e = str;
    }

    public Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        try {
            String str = "";
            hashMap.put("providerAdapterVersion", this.a != null ? this.a.getVersion() : str);
            if (this.a != null) {
                str = this.a.getCoreSDKVersion();
            }
            hashMap.put("providerSDKVersion", str);
            hashMap.put("spId", this.b.a.getSubProviderId());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.b.a.getAdSourceNameForEvents());
            hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            if (this.b.c) {
                hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                hashMap.put("instanceType", 2);
                if (!TextUtils.isEmpty(this.e)) {
                    hashMap.put(IronSourceConstants.EVENTS_AUCTION_ID, this.e);
                }
                if (this.f != null && this.f.length() > 0) {
                    hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.f);
                }
            } else {
                hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 0);
                hashMap.put("instanceType", 1);
            }
            if (!TextUtils.isEmpty(this.h)) {
                hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.h);
            }
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "getProviderEventData " + d() + ")", e2);
        }
        return hashMap;
    }

    public final String d() {
        return this.b.a.getProviderName();
    }

    public final int e() {
        return this.b.d;
    }

    public final String f() {
        return this.b.a.getSubProviderId();
    }

    /* access modifiers changed from: package-private */
    public final String g() {
        a aVar = this.i;
        return aVar == null ? "null" : aVar.toString();
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        synchronized (this.l) {
            if (this.j != null) {
                this.j.cancel();
                this.j = null;
            }
        }
    }

    public final boolean i() {
        return this.b.c;
    }
}
