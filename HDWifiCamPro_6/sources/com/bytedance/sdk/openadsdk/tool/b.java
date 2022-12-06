package com.bytedance.sdk.openadsdk.tool;

import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.h.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: ReportAPIUseStats */
public class b {
    private static Map<String, AtomicBoolean> a = new HashMap();
    private static String b = "_old";

    static {
        a.put("native", new AtomicBoolean(false));
        a.put("open", new AtomicBoolean(false));
        a.put(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, new AtomicBoolean(false));
        a.put("rewarded", new AtomicBoolean(false));
        a.put("banner", new AtomicBoolean(false));
        a.put("init", new AtomicBoolean(false));
        Map<String, AtomicBoolean> map = a;
        map.put("native" + b, new AtomicBoolean(false));
        Map<String, AtomicBoolean> map2 = a;
        map2.put("open" + b, new AtomicBoolean(false));
        Map<String, AtomicBoolean> map3 = a;
        map3.put(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE + b, new AtomicBoolean(false));
        Map<String, AtomicBoolean> map4 = a;
        map4.put("rewarded" + b, new AtomicBoolean(false));
        Map<String, AtomicBoolean> map5 = a;
        map5.put("banner" + b, new AtomicBoolean(false));
        Map<String, AtomicBoolean> map6 = a;
        map6.put("init" + b, new AtomicBoolean(false));
    }

    public static void a(final int i, final String str) {
        String str2;
        if (i == 1) {
            str2 = str;
        } else {
            str2 = str + b;
        }
        if (a.containsKey(str2)) {
            AtomicBoolean atomicBoolean = a.get(str2);
            if (atomicBoolean == null || !atomicBoolean.getAndSet(true)) {
                m.e().a(new a() {
                    public com.bytedance.sdk.openadsdk.h.a.a a() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("method", str);
                            jSONObject.put("method_type", i);
                        } catch (Throwable unused) {
                        }
                        return com.bytedance.sdk.openadsdk.h.a.b.b().a("api_method").b(jSONObject.toString());
                    }
                }, false);
            }
        }
    }
}
