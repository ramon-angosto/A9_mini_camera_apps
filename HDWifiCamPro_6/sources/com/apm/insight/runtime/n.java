package com.apm.insight.runtime;

import android.text.TextUtils;
import com.apm.insight.b;
import com.apm.insight.c;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.l;
import com.apm.insight.l.o;
import com.apm.insight.l.q;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    protected static JSONObject a = new JSONObject();

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String a2 = a.a(jSONObject);
                File file = new File(o.j(h.g()), "apminsight/configCrash/configNative");
                if (a2 != null) {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    a = jSONObject2;
                    i.a(file, b(jSONObject2), false);
                    return;
                }
                a = new JSONObject();
            } catch (JSONException unused) {
            } catch (Throwable th) {
                b.a().a("NPTH_CATCH", th);
            }
        }
    }

    public static boolean a(String str, f fVar) {
        if (a == null) {
            return false;
        }
        if (fVar == null) {
            fVar = new f();
        }
        JSONObject optJSONObject = a.optJSONObject(str);
        if (optJSONObject != null && !a(optJSONObject.optJSONArray("disable"), fVar)) {
            return a(optJSONObject.optJSONArray("enable"), fVar);
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, f fVar) {
        if (l.a(jSONArray)) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                b.a().a("NPTH_CATCH", (Throwable) new IllegalArgumentException("err config: " + jSONArray));
            } else if (a(optJSONObject, fVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(JSONObject jSONObject, f fVar) {
        StringBuilder sb;
        Iterator<String> keys = jSONObject.keys();
        boolean z = false;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                z = true;
                if (next.startsWith("header_")) {
                    if (!a(jSONObject.optJSONObject(next), fVar.b(next.substring(7)))) {
                        sb = new StringBuilder();
                    }
                } else if (!next.startsWith("java_")) {
                    q.a((Object) "no rules match " + next);
                } else if (!a(jSONObject.optJSONObject(next), fVar.a(next.substring(5)))) {
                    sb = new StringBuilder();
                }
                sb.append("not match ");
                sb.append(next);
                q.a((Object) sb.toString());
                return false;
            }
        }
        return z;
    }

    private static boolean a(JSONObject jSONObject, Object obj) {
        JSONArray optJSONArray = jSONObject.optJSONArray("values");
        if (optJSONArray.length() == 0) {
            return false;
        }
        String optString = jSONObject.optString("op");
        String valueOf = String.valueOf(obj);
        if (optString.equals("=")) {
            return valueOf.equals(String.valueOf(optJSONArray.opt(0)));
        }
        if (optString.equals("in")) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (String.valueOf(optJSONArray.opt(i)).equals(valueOf)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static JSONArray b(JSONArray jSONArray, f fVar) {
        JSONArray jSONArray2 = new JSONArray();
        if (l.a(jSONArray)) {
            return jSONArray2;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                c a2 = b.a();
                a2.a("NPTH_CATCH", (Throwable) new IllegalArgumentException("err config: " + jSONArray));
            } else if (a(optJSONObject, fVar)) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    public static JSONObject b(JSONObject jSONObject) {
        StringBuilder sb;
        String str;
        Iterator<String> keys = jSONObject.keys();
        f fVar = new f();
        JSONObject jSONObject2 = new JSONObject();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!"configType".equals(next)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject == null) {
                    c a2 = b.a();
                    a2.a("NPTH_CATCH", (Throwable) new IllegalArgumentException("err config with key: " + next));
                } else {
                    if (a(optJSONObject.optJSONArray("disable"), fVar)) {
                        sb = new StringBuilder();
                        str = "match diable ";
                    } else {
                        JSONArray b = b(optJSONObject.optJSONArray("enable"), fVar);
                        if (l.a(b)) {
                            sb = new StringBuilder();
                            str = "not match ";
                        } else {
                            try {
                                jSONObject2.put(next, new JSONObject().put("enable", b));
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    sb.append(str);
                    sb.append(next);
                    q.a((Object) sb.toString());
                }
            }
        }
        return jSONObject2;
    }
}
