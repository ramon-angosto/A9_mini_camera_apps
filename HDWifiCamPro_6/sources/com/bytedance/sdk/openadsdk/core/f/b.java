package com.bytedance.sdk.openadsdk.core.f;

import com.bytedance.sdk.openadsdk.core.f.b.c;
import com.bytedance.sdk.openadsdk.core.f.c.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastIcon */
public class b extends c {
    private long j;
    private long k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i, int i2, long j2, long j3, a.C0048a aVar, a.b bVar, String str, List<c> list, List<c> list2, String str2) {
        super(i, i2, aVar, bVar, str, list, list2, str2);
        this.j = j2;
        this.k = j3;
        this.i = "icon_click";
    }

    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        if (a != null) {
            a.put("offset", this.j);
            a.put(IronSourceConstants.EVENTS_DURATION, this.k);
        }
        return a;
    }

    public static b a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        c b = c.b(jSONObject);
        if (b == null) {
            return null;
        }
        long optLong = jSONObject2.optLong("offset", -1);
        long optLong2 = jSONObject2.optLong(IronSourceConstants.EVENTS_DURATION, -1);
        return new b(b.a, b.b, optLong, optLong2, b.c, b.d, b.e, b.f, b.g, b.h);
    }
}
