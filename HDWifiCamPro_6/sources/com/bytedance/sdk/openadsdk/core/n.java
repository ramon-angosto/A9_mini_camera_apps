package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.e;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NetApi */
public interface n<T> {

    /* compiled from: NetApi */
    public interface a {
        void a(int i, String str);

        void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar);
    }

    /* compiled from: NetApi */
    public interface b {
        void a(int i, String str);

        void a(o.b bVar);
    }

    com.bytedance.sdk.component.adexpress.a.c.a a();

    e a(List<T> list);

    JSONObject a(JSONObject jSONObject);

    void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.o oVar, int i, a aVar);

    void a(String str);

    void a(String str, List<FilterWord> list);

    void a(JSONObject jSONObject, b bVar);

    void a(JSONObject jSONObject, String str);

    e b(JSONObject jSONObject);
}
