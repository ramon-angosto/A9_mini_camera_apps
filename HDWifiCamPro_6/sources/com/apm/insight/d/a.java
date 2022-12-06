package com.apm.insight.d;

import com.apm.insight.CrashType;
import com.apm.insight.f;
import com.apm.insight.h;
import com.apm.insight.k.d;
import com.apm.insight.runtime.p;
import java.util.Map;
import org.json.JSONObject;

public class a {
    public static void a(String str) {
        a(str, (Map<? extends String, ? extends String>) null, (Map<String, String>) null, (f) null);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, f fVar) {
        a(str, map, map2, (Map<String, String>) null, fVar);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, f fVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final String str2 = str;
            final Map<? extends String, ? extends String> map4 = map;
            final Map<String, String> map5 = map2;
            final Map<String, String> map6 = map3;
            final f fVar2 = fVar;
            p.b().a((Runnable) new Runnable() {
                public void run() {
                    boolean z;
                    try {
                        com.apm.insight.entity.a a2 = com.apm.insight.runtime.a.f.a().a(CrashType.DART, com.apm.insight.entity.a.a(currentTimeMillis, h.g(), str2));
                        if (map4 != null) {
                            JSONObject optJSONObject = a2.h().optJSONObject("custom");
                            if (optJSONObject == null) {
                                optJSONObject = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(optJSONObject, (Map<? extends String, ? extends String>) map4);
                            a2.a("custom", (Object) optJSONObject);
                        }
                        if (map5 != null) {
                            JSONObject optJSONObject2 = a2.h().optJSONObject("custom_long");
                            if (optJSONObject2 == null) {
                                optJSONObject2 = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(optJSONObject2, (Map<? extends String, ? extends String>) map5);
                            a2.a("custom_long", (Object) optJSONObject2);
                        }
                        if (map6 != null) {
                            JSONObject optJSONObject3 = a2.h().optJSONObject("filters");
                            if (optJSONObject3 == null) {
                                optJSONObject3 = new JSONObject();
                                a2.a("filters", (Object) optJSONObject3);
                            }
                            com.apm.insight.entity.a.a(optJSONObject3, (Map<? extends String, ? extends String>) map6);
                        }
                        z = d.a().a(currentTimeMillis, a2.h());
                    } catch (Throwable unused) {
                        z = false;
                    }
                    f fVar = fVar2;
                    if (fVar != null) {
                        try {
                            fVar.a(z);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
