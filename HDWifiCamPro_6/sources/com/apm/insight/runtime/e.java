package com.apm.insight.runtime;

import com.apm.insight.l.l;
import com.apm.insight.l.q;
import java.util.HashMap;
import org.json.JSONObject;

public class e {
    private static HashMap<String, e> a = new HashMap<>();
    private JSONObject b = null;
    private JSONObject c = null;
    private boolean d = false;
    private String e;

    public e(JSONObject jSONObject, String str) {
        this.e = str;
        a(jSONObject);
        a.put(this.e, this);
        q.a((Object) "after update aid " + str);
    }

    public static void a(String str, JSONObject jSONObject) {
        e eVar = a.get(str);
        if (eVar != null) {
            eVar.a(jSONObject);
        } else {
            new e(jSONObject, str);
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.b = jSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("error_module")) != null) {
            boolean z = true;
            if (optJSONObject.optInt("switcher") != 1) {
                z = false;
            }
            this.d = z;
        }
    }

    public static boolean b(String str) {
        return a.get(str) != null;
    }

    public static JSONObject c(String str) {
        e eVar = a.get(str);
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public static e d(String str) {
        return a.get(str);
    }

    public static long e(String str) {
        e eVar = a.get(str);
        if (eVar == null) {
            return 3600000;
        }
        try {
            return Long.decode(l.b(eVar.a(), "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000;
        }
    }

    public static boolean f(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.b();
    }

    public static boolean g(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.c();
    }

    public static boolean h(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.d();
    }

    public JSONObject a() {
        return this.b;
    }

    public boolean a(String str) {
        if (this.b == null) {
            return false;
        }
        return this.d;
    }

    public boolean b() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == l.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean c() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == l.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean d() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == l.a(jSONObject, 0, "crash_module", "switcher");
    }
}
