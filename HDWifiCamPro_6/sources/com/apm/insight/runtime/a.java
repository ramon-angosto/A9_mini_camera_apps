package com.apm.insight.runtime;

import com.apm.insight.entity.b;
import com.apm.insight.h;
import com.apm.insight.k.k;
import com.apm.insight.l.l;
import com.apm.insight.l.q;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    private static ConcurrentLinkedQueue<Object> a = new ConcurrentLinkedQueue<>();

    public static int a(int i, String... strArr) {
        return l.a(a(), i, strArr);
    }

    public static int a(String... strArr) {
        return l.a(a(), -1, strArr);
    }

    public static String a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("exception_modules")) == null) {
            return null;
        }
        return optJSONObject.optString("npth");
    }

    public static JSONObject a() {
        return e.c(h.a().e());
    }

    public static JSONObject a(JSONArray jSONArray, String str) {
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i).optJSONObject(str);
                if (optJSONObject != null) {
                    return optJSONObject;
                }
            }
        }
        return null;
    }

    public static void a(JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            q.a("apmconfig", (Object) "fromnet " + z + " : " + jSONArray);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String next = optJSONObject.keys().next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                    q.a((Object) "update config " + next + " : " + optJSONObject2);
                    e.a(next, optJSONObject2);
                    if (z) {
                        k.a(next);
                    }
                } catch (Throwable unused) {
                }
            }
            n.a(a(jSONArray, String.valueOf(h.a().e())));
            if (z) {
                k.a(false, jSONArray);
            }
        }
    }

    public static boolean a(Object obj) {
        String b = b.b(obj);
        if (b != null) {
            return e.b(b);
        }
        return false;
    }

    public static boolean a(Object obj, String str) {
        e d;
        String b = b.b(obj);
        if (b == null || (d = e.d(b)) == null) {
            return false;
        }
        return d.a(str);
    }

    public static boolean a(String str) {
        if (!e.b(str)) {
            com.apm.insight.k.a.b();
        }
        return e.f(str);
    }

    public static boolean b() {
        return o.e();
    }

    public static boolean b(String str) {
        if (!e.b(str)) {
            com.apm.insight.k.a.b();
        }
        return e.h(str);
    }

    public static JSONArray c() {
        return l.a(a(), "custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore");
    }

    public static boolean c(String str) {
        if (!e.b(str)) {
            com.apm.insight.k.a.b();
        }
        return e.g(str);
    }

    public static boolean d() {
        return a("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    public static boolean e() {
        return a("custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native") == 1;
    }

    public static boolean f() {
        return a("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") == 1;
    }

    public static boolean g() {
        return a("custom_event_settings", "npth_simple_setting", "upload_crash_crash") == 1;
    }

    public static boolean h() {
        return a("custom_event_settings", "npth_simple_setting", "force_apm_crash") == 1;
    }

    public static boolean i() {
        return a("custom_event_settings", "npth_simple_setting", "enable_killed_anr") == 1;
    }

    public static boolean j() {
        return a("custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace") == 1;
    }
}
