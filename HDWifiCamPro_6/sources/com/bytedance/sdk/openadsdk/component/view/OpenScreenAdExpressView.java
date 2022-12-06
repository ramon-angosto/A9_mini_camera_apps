package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.component.f.a;
import com.bytedance.sdk.openadsdk.component.h.b;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import org.json.JSONObject;

public class OpenScreenAdExpressView extends NativeExpressView {
    private final a a;
    private final b b;

    public OpenScreenAdExpressView(Context context, n nVar, AdSlot adSlot, String str, a aVar, b bVar) {
        super(context, nVar, adSlot, str, true);
        this.a = aVar;
        this.b = bVar;
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.l = true;
        super.g();
    }

    public int getDynamicShowType() {
        if (this.s == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    public void a(d<? extends View> dVar, m mVar) {
        super.a(dVar, mVar);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a() {
        super.a();
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void e() {
        super.e();
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(View view, int i, c cVar) {
        if (i == -1 || cVar == null || i != 3) {
            super.a(view, i, cVar);
        } else {
            e();
        }
    }

    /* access modifiers changed from: protected */
    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.component.g.a.a(this.i, com.bytedance.sdk.openadsdk.core.m.d().e(String.valueOf(this.i.aW())));
    }

    /* access modifiers changed from: protected */
    public void a(l.a aVar) {
        super.a(aVar);
        aVar.e(com.bytedance.sdk.openadsdk.component.g.a.b());
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        com.bytedance.sdk.openadsdk.component.g.a.a(jSONObject, this.i.aW());
    }
}
