package com.bytedance.sdk.openadsdk.g.a;

import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DoNewClickEventMethod */
public class c extends d<JSONObject, JSONObject> {
    private WeakReference<u> a;

    /* access modifiers changed from: protected */
    public void d() {
    }

    public static void a(r rVar, final u uVar) {
        rVar.a("newClickEvent", (d.b) new d.b() {
            public d a() {
                return new c(uVar);
            }
        });
    }

    public c(u uVar) {
        this.a = new WeakReference<>(uVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        u uVar = (u) this.a.get();
        if (uVar == null) {
            c();
        } else {
            uVar.c(jSONObject);
        }
    }
}
