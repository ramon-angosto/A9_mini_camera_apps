package com.bytedance.sdk.openadsdk.k.a;

import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.core.f.b.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import org.json.JSONObject;

/* compiled from: PAGMRCEventManager */
public class d {
    public static void a(final n nVar, final a aVar, final int i) {
        nVar.aD();
        w.b(new g("mrc_report") {
            public void run() {
                if (nVar.aC()) {
                    if (nVar.ba()) {
                        c.a(nVar.R(), new c.b("show_urls", nVar));
                    } else {
                        com.bytedance.sdk.openadsdk.c.c.b(nVar);
                    }
                }
                String a2 = y.a(nVar);
                JSONObject jSONObject = new JSONObject();
                a aVar = aVar;
                if (aVar != null) {
                    try {
                        jSONObject.put("root_view", a.a(aVar));
                        if (i != -1) {
                            jSONObject.put("dynamic_show_type", i);
                        }
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.c.c.b(m.a(), nVar, a2, "mrc_show", jSONObject);
            }
        });
    }
}
