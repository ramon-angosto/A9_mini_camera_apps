package com.bytedance.sdk.openadsdk.g.a;

import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.jslistener.c;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DoGetAdsFromNetworkAsyncMethod */
public class a extends d<JSONObject, JSONObject> {
    private WeakReference<u> a;

    /* access modifiers changed from: protected */
    public void d() {
    }

    public static void a(r rVar, final u uVar) {
        rVar.a("getNetworkData", (d.b) new d.b() {
            public d a() {
                return new a(uVar);
            }
        });
    }

    public a(u uVar) {
        this.a = new WeakReference<>(uVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        u uVar = (u) this.a.get();
        if (uVar == null) {
            c();
        } else {
            uVar.a(jSONObject, (c) new c() {
            });
        }
    }
}
