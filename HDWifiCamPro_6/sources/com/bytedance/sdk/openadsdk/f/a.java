package com.bytedance.sdk.openadsdk.f;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.l.y;
import com.com.bytedance.overseas.sdk.a.c;
import com.com.bytedance.overseas.sdk.a.d;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsAppAdDownloadManager */
public class a implements c {
    private final n a;
    private final b b;
    private final Map<String, c> c = new HashMap();

    public void a() {
    }

    public void b() {
    }

    public void b(JSONObject jSONObject) {
    }

    private a(b bVar, n nVar) {
        this.b = bVar;
        this.a = nVar;
    }

    public static a a(b bVar, n nVar) {
        return new a(bVar, nVar);
    }

    public void c() {
        this.c.clear();
    }

    private n a(JSONObject jSONObject, String str) {
        String str2 = null;
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.b(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            nVar.m(str);
        }
        if (this.a == null) {
            return nVar;
        }
        if (nVar.aa() != null) {
            str2 = nVar.aa().a();
        }
        if (TextUtils.isEmpty(str2)) {
            return this.a;
        }
        return (this.a.aa() == null || !str2.equals(this.a.aa().a())) ? nVar : this.a;
    }

    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
            a(context, a(optJSONObject, str), optJSONObject, i, z);
        }
    }

    private void a(Context context, n nVar, JSONObject jSONObject, int i, boolean z) {
        if (context != null && nVar != null && nVar.aa() != null && jSONObject != null && this.b != null && this.c.get(nVar.aa().a()) == null) {
            String a2 = y.a(i);
            if (!TextUtils.isEmpty(a2)) {
                this.c.put(nVar.aa().a(), a(context, nVar, jSONObject, a2, z));
            }
        }
    }

    public void a(Context context, JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
            a(context, a(optJSONObject, (String) null), str);
        }
    }

    private void a(Context context, n nVar, String str) {
        if (context != null && nVar != null) {
            if (nVar.aa() == null) {
                d.a(context, nVar, str).d();
            } else {
                c cVar = this.c.get(nVar.aa().a());
                if (cVar != null) {
                    cVar.d();
                }
            }
            if (context instanceof b) {
                ((b) context).L();
            }
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
            a(a(optJSONObject, (String) null), optJSONObject);
        }
    }

    private void a(n nVar, JSONObject jSONObject) {
        if (this.b != null && nVar != null && nVar.aa() != null) {
            String a2 = nVar.aa().a();
            if (this.c.containsKey(a2)) {
                this.c.remove(a2);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("status", "unsubscribed");
                    jSONObject2.put("appad", jSONObject);
                    this.b.a("app_ad_event", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private c a(Context context, n nVar, JSONObject jSONObject, String str, boolean z) {
        c a2 = d.a(context, nVar, str);
        a2.a(true);
        return a2;
    }
}
