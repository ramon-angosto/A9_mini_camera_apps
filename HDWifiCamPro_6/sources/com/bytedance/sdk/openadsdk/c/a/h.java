package com.bytedance.sdk.openadsdk.c.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.b.b;
import com.bytedance.sdk.component.e.a.b.c;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.openadsdk.c.a;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.settings.f;
import com.bytedance.sdk.openadsdk.h.c.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OverSeaEventUploadImpl */
public class h implements c {
    public n<a> a;

    public void a(final List<com.bytedance.sdk.component.e.a.d.a> list, final b bVar) {
        com.bytedance.sdk.component.e.a.d.a aVar;
        if (list != null && list.size() > 0 && (aVar = list.get(0)) != null) {
            byte d = aVar.d();
            final ArrayList arrayList = new ArrayList();
            if (d == 0) {
                if (list.size() > 0) {
                    e.a().execute(new Runnable() {
                        public void run() {
                            try {
                                for (Map.Entry value : h.this.d(list).entrySet()) {
                                    a.a(a.d);
                                    List<com.bytedance.sdk.component.e.a.d.a> list = (List) value.getValue();
                                    ArrayList arrayList = new ArrayList();
                                    for (com.bytedance.sdk.component.e.a.d.a aVar : list) {
                                        arrayList.add(new a(aVar.c(), aVar.g()));
                                    }
                                    com.bytedance.sdk.openadsdk.c.e a2 = h.this.a(arrayList);
                                    if (!(bVar == null || a2 == null)) {
                                        boolean z = a2.d;
                                        if (h.this.a((List<a>) arrayList, a2)) {
                                            z = true;
                                        }
                                        arrayList.add(new com.bytedance.sdk.component.e.a.b.c.a(new com.bytedance.sdk.component.e.a.b.c.b(a2.a, a2.b, a2.c, z, ""), list));
                                        if (a2.b == 200) {
                                            a.a(a.d, true);
                                        } else if (z) {
                                            a.a(a.d, false);
                                        }
                                    }
                                }
                                bVar.a(arrayList);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            } else if (d == 1) {
                final ArrayList arrayList2 = new ArrayList();
                for (com.bytedance.sdk.component.e.a.d.a next : list) {
                    arrayList2.add(new b.a(next.c(), next.g()));
                }
                a.a(a.e);
                if (arrayList2.size() > 0) {
                    final com.bytedance.sdk.component.e.a.b.b bVar2 = bVar;
                    final List<com.bytedance.sdk.component.e.a.d.a> list2 = list;
                    e.a().execute(new Runnable() {
                        public void run() {
                            com.bytedance.sdk.openadsdk.c.e b2 = h.this.b(arrayList2);
                            if (bVar2 != null && b2 != null) {
                                arrayList.add(new com.bytedance.sdk.component.e.a.b.c.a(new com.bytedance.sdk.component.e.a.b.c.b(b2.a, b2.b, b2.c, b2.d, ""), list2));
                                bVar2.a(arrayList);
                                if (b2.b == 200) {
                                    a.a(a.e, true);
                                } else if (b2.d) {
                                    a.a(a.e, false);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private boolean c(List<a> list) {
        JSONObject c;
        if (list == null || list.size() == 0 || (c = list.get(0).c()) == null) {
            return true;
        }
        return TextUtils.isEmpty(c.optString("app_log_url"));
    }

    /* access modifiers changed from: private */
    public boolean a(List<a> list, com.bytedance.sdk.openadsdk.c.e eVar) {
        if (!c(list) && eVar.b >= 400 && eVar.b < 500) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public HashMap<String, List<com.bytedance.sdk.component.e.a.d.a>> d(List<com.bytedance.sdk.component.e.a.d.a> list) {
        HashMap<String, List<com.bytedance.sdk.component.e.a.d.a>> hashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.sdk.component.e.a.d.a aVar = list.get(i);
            JSONObject g = aVar.g();
            if (g != null) {
                String optString = g.optString("app_log_url");
                List list2 = hashMap.get(optString);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(optString, list2);
                }
                list2.add(aVar);
            }
        }
        return hashMap;
    }

    public com.bytedance.sdk.openadsdk.c.e a(List<a> list) {
        if (this.a == null) {
            this.a = m.c();
        }
        n<a> nVar = this.a;
        if (nVar == null) {
            return null;
        }
        return nVar.a(list);
    }

    public com.bytedance.sdk.openadsdk.c.e b(List<b.a> list) {
        if (this.a == null) {
            this.a = m.c();
        }
        if (list == null || list.size() == 0 || !f.a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : list) {
                jSONArray.put(aVar.b);
            }
            jSONObject.put("stats_list", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(String.valueOf(currentTimeMillis).concat("stats_list")));
        } catch (Exception unused) {
        }
        return this.a.b(jSONObject);
    }
}
