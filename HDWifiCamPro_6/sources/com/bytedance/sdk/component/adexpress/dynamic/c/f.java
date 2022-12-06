package com.bytedance.sdk.component.adexpress.dynamic.c;

import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.d.b;
import com.bytedance.sdk.component.g.e;
import com.vungle.warren.model.VisionDataDBAdapter;
import org.json.JSONObject;

/* compiled from: DynamicNativeParser */
public class f implements g {
    private b a;

    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(final l lVar) {
        if (lVar.i() == 1) {
            com.bytedance.sdk.component.utils.l.b("DynamicNativeParser", "parse on ui thread");
            b(lVar);
            return;
        }
        e.a().execute(new Runnable() {
            public void run() {
                com.bytedance.sdk.component.utils.l.b("DynamicNativeParser", "parse on non ui thread");
                f.this.b(lVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(l lVar) {
        try {
            JSONObject a2 = lVar.a();
            JSONObject jSONObject = new JSONObject(a2.optString("template_Plugin"));
            JSONObject optJSONObject = a2.optJSONObject(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE);
            h a3 = new e(jSONObject, optJSONObject, a2.optJSONObject("AdSize"), new JSONObject(a2.optString("diff_template_Plugin"))).a();
            a3.a(new JSONObject(optJSONObject.optString("dynamic_creative")).optString(TtmlNode.ATTR_TTS_COLOR));
            this.a.a(a3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
