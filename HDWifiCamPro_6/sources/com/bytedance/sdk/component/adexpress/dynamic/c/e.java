package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.c;
import com.bytedance.sdk.component.adexpress.dynamic.b.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c.d;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DynamicLayoutInflater */
public class e {
    private static HashMap<String, String> g = new HashMap<>();
    private JSONObject a;
    private JSONObject b;
    private c c;
    private a d;
    private b e;
    private d f;

    static {
        g.put("subtitle", "description");
        g.put("source", "source|app.app_name");
        g.put("screenshot", "dynamic_creative.screenshot");
    }

    public e(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.a = jSONObject;
        this.b = jSONObject2;
        this.c = new c(jSONObject2);
        this.d = a.a(jSONObject3);
        this.f = d.a(jSONObject4);
    }

    public h a() {
        JSONObject jSONObject;
        this.c.a();
        try {
            jSONObject = new JSONObject(this.f.b);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        h a2 = a(c.a(this.a, jSONObject), (h) null);
        a(a2);
        d dVar = new d();
        d.a aVar = new d.a();
        aVar.a = this.d.a;
        aVar.b = this.d.b;
        aVar.c = 0.0f;
        dVar.a(aVar);
        dVar.a(a2, 0.0f, 0.0f);
        dVar.a();
        if (dVar.a.d == 65536.0f) {
            return null;
        }
        return dVar.a.f;
    }

    private void a(h hVar) {
        float f2;
        if (hVar != null) {
            int b2 = b.b(com.bytedance.sdk.component.adexpress.d.a(), (float) b.a(com.bytedance.sdk.component.adexpress.d.a()));
            if (this.d.c) {
                f2 = this.d.a;
            } else {
                f2 = Math.min(this.d.a, (float) b2);
            }
            if (this.d.b == 0.0f) {
                hVar.e(f2);
                hVar.i().e().j("auto");
                hVar.f(0.0f);
                return;
            }
            hVar.e(f2);
            hVar.f(this.d.c ? this.d.b : Math.min(this.d.b, (float) b.b(com.bytedance.sdk.component.adexpress.d.a(), (float) b.b(com.bytedance.sdk.component.adexpress.d.a()))));
            hVar.i().e().j("fixed");
        }
    }

    public h a(JSONObject jSONObject, h hVar) {
        int i;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        if (TextUtils.equals(optString, "custom-component-vessel")) {
            int optInt = jSONObject.optInt("componentId");
            if (this.f != null) {
                this.e = new b();
                JSONObject a2 = this.e.a(this.f.a, optInt, jSONObject);
                if (a2 != null) {
                    jSONObject = a2;
                }
            }
        }
        h a3 = a(jSONObject);
        a3.a(hVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            a3.a((List<h>) null);
            return a3;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i2);
            if (optJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(optString, "tag-group")) {
                    i = a3.i().e().T();
                } else {
                    i = optJSONArray2.length();
                }
                for (int i3 = 0; i3 < i; i3++) {
                    h a4 = a(optJSONArray2.optJSONObject(i3), a3);
                    arrayList.add(a4);
                    arrayList3.add(a4);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            a3.a((List<h>) arrayList);
        }
        if (arrayList2.size() > 0) {
            a3.b((List<List<h>>) arrayList2);
        }
        return a3;
    }

    public h a(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("id");
        JSONObject optJSONObject = jSONObject.optJSONObject("values");
        h.a(optString, optJSONObject);
        JSONObject a2 = h.a(optString, h.a(jSONObject.optJSONArray("sceneValues")), optJSONObject);
        h hVar = new h();
        if (TextUtils.isEmpty(optString2)) {
            hVar.b(String.valueOf(hVar.hashCode()));
        } else {
            hVar.b(optString2);
        }
        if (optJSONObject != null) {
            hVar.c((float) optJSONObject.optDouble("x"));
            hVar.d((float) optJSONObject.optDouble("y"));
            hVar.e((float) optJSONObject.optDouble("width"));
            hVar.f((float) optJSONObject.optDouble("height"));
            hVar.g((float) optJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.b.e eVar = new com.bytedance.sdk.component.adexpress.dynamic.b.e();
            eVar.a(optString);
            eVar.b(optJSONObject.optString(DataSchemeDataSource.SCHEME_DATA));
            eVar.c(optJSONObject.optString("dataExtraInfo"));
            f a3 = f.a(optJSONObject);
            eVar.a(a3);
            f a4 = f.a(a2);
            if (a4 == null) {
                eVar.b(a3);
            } else {
                eVar.b(a4);
            }
            a(a3);
            a(a4);
            if (TextUtils.equals(optString, "video-image-budget") && (jSONObject2 = this.b) != null) {
                a(eVar, jSONObject2.optInt("image_mode"));
            }
            String b2 = eVar.b();
            f e2 = eVar.e();
            if (g.containsKey(b2) && !e2.J()) {
                e2.s(g.get(b2));
            }
            if (e2.J()) {
                str = eVar.c();
            } else {
                str = a(eVar.c());
            }
            if (com.bytedance.sdk.component.adexpress.d.b()) {
                if (TextUtils.equals(b2, "star") || TextUtils.equals(b2, "text_star")) {
                    str = a("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(b2, "score-count") || TextUtils.equals(b2, "score-count-type-1") || TextUtils.equals(b2, "score-count-type-2")) {
                    str = a("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(b2) && a3.aj()) {
                    str = a("image.0.url");
                }
            }
            if (TextUtils.isEmpty(b()) || (!TextUtils.equals("logo-union", optString) && !TextUtils.equals("logo", optString))) {
                eVar.b(str);
            } else {
                eVar.b(str + "adx:" + b());
            }
            hVar.a(eVar);
        }
        return hVar;
    }

    private void a(com.bytedance.sdk.component.adexpress.dynamic.b.e eVar, int i) {
        int lastIndexOf;
        if (i == 5 || i == 15 || i == 50 || i == 154) {
            eVar.a("video");
            String a2 = h.a("video");
            eVar.e().s(a2);
            String a3 = h.a("video", "clickArea");
            if (!TextUtils.isEmpty(a3)) {
                eVar.e().n(a3);
                eVar.f().n(a3);
            }
            eVar.f().s(a2);
            eVar.b(a2);
            eVar.e().ap();
            return;
        }
        eVar.a("image");
        String a4 = h.a("image");
        eVar.e().s(a4);
        eVar.f().s(a4);
        String a5 = h.a("image", "clickArea");
        if (!TextUtils.isEmpty(a5)) {
            eVar.e().n(a5);
            eVar.f().n(a5);
        }
        eVar.b(a4);
        if (a4 != null && (lastIndexOf = a4.lastIndexOf(".")) > 0) {
            String substring = a4.substring(0, lastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", a(substring + ".width"));
                jSONObject.put("height", a(substring + ".height"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            eVar.c(jSONObject.toString());
        }
        eVar.e().aq();
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.c.b(str2)) {
                String valueOf = String.valueOf(this.c.a(str2));
                if (!TextUtils.isEmpty(valueOf)) {
                    return valueOf;
                }
            }
        }
        return "";
    }

    private String b() {
        c cVar = this.c;
        if (cVar == null) {
            return "";
        }
        return String.valueOf(cVar.a("adx_name"));
    }

    private void a(f fVar) {
        if (fVar != null) {
            String v = fVar.v();
            if (com.bytedance.sdk.component.adexpress.d.b()) {
                String c2 = b.c(com.bytedance.sdk.component.adexpress.d.a());
                if (!TextUtils.isEmpty(c2) && fVar.a() != null) {
                    String optString = fVar.a().optString(c2);
                    if (!TextUtils.isEmpty(optString)) {
                        v = optString;
                    }
                }
            }
            if (!TextUtils.isEmpty(v)) {
                int indexOf = v.indexOf("{{");
                int indexOf2 = v.indexOf("}}");
                if (indexOf >= 0 && indexOf2 >= 0 && indexOf2 >= indexOf) {
                    String a2 = a(v.substring(indexOf + 1, indexOf2));
                    if (!TextUtils.isEmpty(a2)) {
                        fVar.l((v.substring(0, indexOf) + v.substring(indexOf2 + 2)) + a2);
                    }
                }
            }
        }
    }

    /* compiled from: DynamicLayoutInflater */
    static class a {
        float a;
        float b;
        boolean c;

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                aVar.a = (float) jSONObject.optDouble("width");
                aVar.b = (float) jSONObject.optDouble("height");
                aVar.c = jSONObject.optBoolean("isLandscape");
            }
            return aVar;
        }
    }
}
