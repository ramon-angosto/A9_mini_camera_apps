package com.bytedance.sdk.openadsdk.component.d;

import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.h.b;
import com.bytedance.sdk.openadsdk.l.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: TTAppOpenAdReport */
public class a {
    public static void a(final int i, final int i2) {
        b.a().b((com.bytedance.sdk.openadsdk.h.a) new com.bytedance.sdk.openadsdk.h.a() {
            public com.bytedance.sdk.openadsdk.h.a.a a() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeout_type", i);
                jSONObject.put("user_timeout_time", i2);
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("openad_load_ad_timeout").b(jSONObject.toString());
            }
        });
    }

    public static void a(n nVar, int i, int i2, float f) {
        HashMap hashMap = new HashMap();
        hashMap.put("openad_creative_type", n.c(nVar) ? "video_normal_ad" : "image_normal_ad");
        hashMap.put("skip_time", Integer.valueOf(i));
        hashMap.put("skip_show_time", Integer.valueOf(i2));
        hashMap.put("total_time", Float.valueOf(f));
        c.b(nVar, "skip", (Map<String, Object>) hashMap);
    }

    public static void a(n nVar, long j, float f, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("openad_creative_type", n.c(nVar) ? "video_normal_ad" : "image_normal_ad");
        if (z) {
            hashMap.put("video_duration", Float.valueOf(f));
            hashMap.put("video_percent", Integer.valueOf((int) (((((double) j) * 1.0d) / 10.0d) / ((double) f))));
        } else {
            hashMap.put("image_duration", Float.valueOf(f));
        }
        c.b(nVar, "destroy", (Map<String, Object>) hashMap);
    }

    public static void a(n nVar) {
        c.b(nVar, "cache_expire", (Map<String, Object>) null);
    }

    public static void b(n nVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("openad_creative_type", n.c(nVar) ? "video_normal_ad" : "image_normal_ad");
        c.b(nVar, "cache_loss", (Map<String, Object>) hashMap);
    }

    public static void a(n nVar, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("order", Integer.valueOf(z ? 1 : 2));
        c.a(nVar, "download_image_duration", j, (Map<String, Object>) hashMap);
    }

    public static void b(n nVar, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("size", Long.valueOf(nVar.J().e()));
        hashMap.put("video_duration", Double.valueOf(nVar.J().f()));
        hashMap.put("order", Integer.valueOf(z ? 1 : 2));
        c.a(nVar, "download_video_duration", j, (Map<String, Object>) hashMap);
    }

    public static void a(n nVar, int i, r rVar) {
        long j;
        HashMap hashMap = new HashMap();
        hashMap.put("openad_creative_type", n.c(nVar) ? "video_normal_ad" : "image_normal_ad");
        hashMap.put("open_ad_cache_type", Integer.valueOf(i));
        if (rVar != null) {
            rVar.b(x.a());
            hashMap.put("client_start_time", Long.valueOf(rVar.b()));
            hashMap.put("sever_time", Long.valueOf(rVar.d()));
            hashMap.put("network_time", Long.valueOf(rVar.c()));
            hashMap.put("client_end_time", Long.valueOf(rVar.e()));
            hashMap.put("download_resource_duration", Long.valueOf(rVar.g()));
            hashMap.put("resource_source", Integer.valueOf(rVar.h()));
            j = rVar.f();
        } else {
            j = 0;
        }
        c.a(nVar, "load_net_duration", j, (Map<String, Object>) hashMap);
    }

    public static void a(n nVar, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("openad_creative_type", n.c(nVar) ? "video_normal_ad" : "image_normal_ad");
        c.a(nVar, "load_cache_duration", j, (Map<String, Object>) hashMap);
    }
}
