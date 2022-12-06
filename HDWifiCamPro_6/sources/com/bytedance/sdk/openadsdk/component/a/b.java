package com.bytedance.sdk.openadsdk.component.a;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.com.bytedance.overseas.sdk.a.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TTAppOpenAdClickManager */
public class b {
    private final a a;

    public b(n nVar, Activity activity) {
        this.a = new a(activity.getApplicationContext(), nVar, "open_ad", 4);
        this.a.a(activity.findViewById(16908290));
        this.a.b(activity.findViewById(t.e(m.a(), "tt_top_dislike")));
        a((com.bytedance.sdk.openadsdk.core.b.b) this.a, nVar);
        a(activity.getApplicationContext(), nVar);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.b.b bVar, n nVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("click_area", Integer.valueOf(nVar.c()));
        hashMap.put("openad_creative_type", n.c(nVar) ? "video_normal_ad" : "image_normal_ad");
        hashMap.put("click_scence", Integer.valueOf(p.i(nVar) ? 3 : 1));
        bVar.a((Map<String, Object>) hashMap);
    }

    private void a(Context context, n nVar) {
        if (a(nVar) == 4) {
            this.a.a(d.a(context, nVar, "open_ad"));
        }
    }

    public int a(n nVar) {
        if (nVar == null) {
            return -1;
        }
        return nVar.L();
    }

    public void a(b.a aVar) {
        a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public a a() {
        return this.a;
    }
}
