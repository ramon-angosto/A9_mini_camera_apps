package com.bytedance.sdk.openadsdk.g.a;

import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DoInterstitialWebViewCloseMethod */
public class b extends d<JSONObject, JSONObject> {
    private WeakReference<u> a;

    /* access modifiers changed from: protected */
    public void d() {
    }

    public static void a(r rVar, final u uVar) {
        rVar.a("interstitial_webview_close", (d.b) new d.b() {
            public d a() {
                return new b(uVar);
            }
        });
    }

    public b(u uVar) {
        this.a = new WeakReference<>(uVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        h.d().s();
        u uVar = (u) this.a.get();
        if (uVar == null) {
            l.e("DoInterstitialWebViewCloseMethod", "invoke error");
            c();
            return;
        }
        uVar.g();
    }
}
