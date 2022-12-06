package com.apm.insight.entity;

import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.g;
import com.apm.insight.l.i;
import com.apm.insight.l.l;
import com.apm.insight.l.q;
import com.apm.insight.l.v;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static ConcurrentLinkedQueue<g> a = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<Integer, g> b = new ConcurrentHashMap<>();

    public interface a {
        void a(JSONObject jSONObject);
    }

    public static File a(File file) {
        return new File(file, "all_data.json");
    }

    public static JSONArray a() {
        g next;
        JSONArray jSONArray = new JSONArray();
        Iterator<g> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.c());
        }
        return jSONArray;
    }

    public static JSONArray a(Object obj) {
        JSONArray jSONArray = new JSONArray();
        Iterator<g> it = a.iterator();
        while (true) {
            if (it.hasNext()) {
                g next = it.next();
                if (next != null && next.a(obj)) {
                    jSONArray.put(next.a(CrashType.JAVA, (JSONArray) null));
                    break;
                }
            } else {
                break;
            }
        }
        return jSONArray;
    }

    public static JSONArray a(Object obj, Throwable th, StackTraceElement[] stackTraceElementArr) {
        Iterator<g> it = a.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.a(obj)) {
                JSONArray a2 = next.a(stackTraceElementArr, th);
                JSONArray jSONArray = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("aid", next.b());
                    jSONObject.put("lines", a2);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
                return jSONArray;
            }
        }
        return null;
    }

    public static JSONArray a(String str) {
        g next;
        JSONArray jSONArray = new JSONArray();
        String[] split = str.split("\n");
        Iterator<g> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.b(next.b())) {
                JSONArray a2 = next.a(split);
                if (!l.a(a2)) {
                    jSONArray.put(next.a(CrashType.ANR, a2));
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray a(String str, String str2, JSONArray jSONArray) {
        JSONObject optJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("header")) != null && com.apm.insight.runtime.a.c(String.valueOf(optJSONObject.opt("aid")))) {
                if (!TextUtils.isEmpty(optJSONObject.optString("package"))) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("so_list");
                    if (!l.a(optJSONArray)) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= optJSONArray.length()) {
                                break;
                            } else if (str.contains(optJSONArray.optString(i2))) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                jSONArray2.put(optJSONObject2);
            }
        }
        return jSONArray2;
    }

    public static JSONArray a(Throwable th, Thread thread, File file) {
        g next;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] b2 = v.b(th);
        Iterator<g> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (!com.apm.insight.runtime.a.a(next.b())) {
                q.a((Object) "not enable javaCrash aid: " + next.b());
            } else {
                JSONArray a2 = next.a(b2, th);
                if (!l.a(a2)) {
                    jSONArray.put(next.a(CrashType.JAVA, a2));
                }
            }
        }
        if (l.a(jSONArray)) {
            return null;
        }
        if (file != null) {
            try {
                i.a(new File(file, "all_data.json"), jSONArray, false);
            } catch (IOException unused) {
            }
        }
        return jSONArray;
    }

    public static void a(g gVar) {
        a.add(gVar);
        if (gVar.d()) {
            b.put(4444, gVar);
        }
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray, a aVar) {
        JSONObject optJSONObject;
        q.a((Object) "uploadFromFile with allData " + jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (i < jSONArray.length() && (optJSONObject = jSONArray.optJSONObject(i)) != null) {
            if (l.a(optJSONObject, 0, "header", "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                a.b(jSONObject2, jSONObject);
                a.b(jSONObject2, optJSONObject);
                aVar.a(jSONObject2);
            } else {
                jSONArray2.put(optJSONObject);
            }
            i++;
        }
        if (jSONArray2.length() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            a.b(jSONObject3, jSONObject);
            try {
                jSONObject3.put("all_data", jSONArray2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aVar.a(jSONObject3);
        }
    }

    public static String b(Object obj) {
        Iterator<g> it = a.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.a(obj)) {
                return next.b();
            }
        }
        return null;
    }

    public static JSONArray b() {
        g next;
        JSONArray jSONArray = new JSONArray();
        Iterator<g> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.a((CrashType) null));
        }
        return jSONArray;
    }

    public static int c() {
        return a.size();
    }
}
