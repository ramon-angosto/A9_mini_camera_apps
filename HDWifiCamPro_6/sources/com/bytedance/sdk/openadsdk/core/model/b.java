package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.h.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdLogInfoModel */
public class b {
    public String a;
    public int b;
    public int c = 1;
    public ArrayList<Integer> d;
    public AdSlot e;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public AdSlot d() {
        return this.e;
    }

    public void a(AdSlot adSlot) {
        this.e = adSlot;
    }

    public ArrayList<Integer> e() {
        return this.d;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.d = arrayList;
    }

    public static void a(b bVar) {
        if (bVar != null && bVar.d() != null && bVar.b() < 0) {
            com.bytedance.sdk.openadsdk.h.b.a().b((a) new a(bVar) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public com.bytedance.sdk.openadsdk.h.a.a a() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("from", this.a.c());
                    jSONObject.put("err_code", this.a.b());
                    jSONObject.put("server_res_str", this.a.a());
                    if (this.a.e() != null && this.a.e().size() > 0) {
                        jSONObject.put("mate_unavailable_code_list", new JSONArray(this.a.e()).toString());
                    }
                    l.b("AdLogInfoModel", "rd_client_custom_error = ", jSONObject);
                    return com.bytedance.sdk.openadsdk.h.a.b.b().a("rd_client_custom_error").a(this.a.d().getDurationSlotType()).b(jSONObject.toString());
                }
            });
        }
    }
}
