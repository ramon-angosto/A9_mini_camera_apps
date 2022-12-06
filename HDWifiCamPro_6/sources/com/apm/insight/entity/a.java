package com.apm.insight.entity;

import android.content.Context;
import com.apm.insight.h;
import com.apm.insight.l.l;
import com.apm.insight.l.o;
import com.apm.insight.l.q;
import com.apm.insight.l.v;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.nativecrash.b;
import com.apm.insight.nativecrash.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    protected JSONObject a;
    protected Header b;

    public a() {
        this.a = new JSONObject();
    }

    public a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public static a a(long j, Context context, String str) {
        a aVar = new a();
        aVar.a("is_dart", (Object) 1);
        aVar.a("crash_time", (Object) Long.valueOf(j));
        aVar.a("process_name", (Object) com.apm.insight.l.a.c(context));
        aVar.a(DataSchemeDataSource.SCHEME_DATA, (Object) str);
        com.apm.insight.l.a.a(context, aVar.h());
        return aVar;
    }

    public static a a(long j, Context context, Thread thread, Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.a("isJava", (Object) 1);
        aVar.a(DataSchemeDataSource.SCHEME_DATA, (Object) v.a(th));
        aVar.a("crash_time", (Object) Long.valueOf(j));
        aVar.a("process_name", (Object) com.apm.insight.l.a.c(context));
        if (!com.apm.insight.l.a.b(context)) {
            aVar.a("remote_process", (Object) 1);
        }
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            aVar.a("crash_thread_name", (Object) name);
        }
        return aVar;
    }

    public static void a(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject == null) {
                try {
                    optJSONObject = new JSONObject();
                    jSONObject.put(str, optJSONObject);
                } catch (Throwable unused) {
                    return;
                }
            }
            optJSONObject.put(str2, str3);
        }
    }

    public static void a(JSONObject jSONObject, Throwable th) {
        String str = "npth_err_info";
        if (jSONObject.opt(str) != null) {
            int i = 0;
            while (i < 5) {
                if (jSONObject.opt(str + i) == null) {
                    str = str + i;
                } else {
                    i++;
                }
            }
            return;
        }
        try {
            jSONObject.put(str, v.a(th));
        } catch (Throwable unused) {
        }
    }

    public static void a(JSONObject jSONObject, Map<? extends String, ? extends String> map) {
        if (map != null) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = jSONObject;
        JSONObject jSONObject4 = jSONObject2;
        try {
            jSONObject3.put("storage", jSONObject4);
        } catch (Throwable unused) {
        }
        long optLong = jSONObject4.optLong("inner_free");
        long optLong2 = jSONObject4.optLong("sdcard_free");
        long optLong3 = jSONObject4.optLong("inner_free_real");
        String str = "64M - ";
        String str2 = optLong <= 1024 ? "0 - 1K" : optLong <= 65536 ? "1K - 64K" : optLong <= 524288 ? "64K - 512K" : optLong <= 1048576 ? "512K - 1M" : optLong <= 67108864 ? "1M - 64M" : str;
        String str3 = optLong3 <= 1024 ? "0 - 1K" : optLong3 <= 65536 ? "1K - 64K" : optLong3 <= 524288 ? "64K - 512K" : optLong3 <= 1048576 ? "512K - 1M" : optLong3 <= 67108864 ? "1M - 64M" : str;
        if (optLong2 <= 1024) {
            str = "0 - 1K";
        } else if (optLong2 <= 65536) {
            str = "1K - 64K";
        } else if (optLong2 <= 524288) {
            str = "64K - 512K";
        } else if (optLong2 <= 1048576) {
            str = "512K - 1M";
        } else if (optLong2 <= 67108864) {
            str = "1M - 64M";
        }
        a(jSONObject3, "filters", "inner_free", str2);
        a(jSONObject3, "filters", "inner_free_real", str3);
        a(jSONObject3, "filters", "sdcard_free", str);
    }

    public static boolean a(String str) {
        return o.d(str).exists();
    }

    public static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        Object opt;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (jSONObject != null && jSONObject2 != null && jSONObject2.length() > 0) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt2 = jSONObject.opt(next);
                    if (opt2 == null) {
                        opt = jSONObject2.opt(next);
                    } else {
                        if (opt2 instanceof JSONObject) {
                            jSONObject3 = jSONObject.getJSONObject(next);
                            jSONObject4 = jSONObject2.getJSONObject(next);
                        } else if (opt2 instanceof JSONArray) {
                            JSONArray optJSONArray = jSONObject2.optJSONArray(next);
                            if (optJSONArray != null) {
                                JSONArray jSONArray = (JSONArray) opt2;
                                if (jSONArray.length() != 1 || !(jSONArray.opt(0) instanceof JSONObject) || !(optJSONArray.opt(0) instanceof JSONObject)) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        jSONArray.put(optJSONArray.get(i));
                                    }
                                } else {
                                    jSONObject3 = jSONArray.getJSONObject(0);
                                    jSONObject4 = optJSONArray.getJSONObject(0);
                                }
                            }
                        } else {
                            opt = jSONObject2.opt(next);
                        }
                        b(jSONObject3, jSONObject4);
                    }
                    jSONObject.put(next, opt);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean b(String str) {
        return ((long) c.c(str)) > b.i();
    }

    public static boolean c(String str) {
        return c.a(str) > 960;
    }

    public static boolean d(String str) {
        return c.b(str) > 350;
    }

    public a a(int i, String str) {
        try {
            this.a.put("miniapp_id", i);
            this.a.put("miniapp_version", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public a a(long j) {
        try {
            a("app_start_time", (Object) Long.valueOf(j));
            a("app_start_time_readable", (Object) new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public a a(Header header) {
        a("header", (Object) header.f());
        this.b = header;
        return this;
    }

    public a a(com.apm.insight.runtime.a.b bVar) {
        a("activity_trace", (Object) bVar.g());
        a("activity_track", bVar.i());
        return this;
    }

    public a a(String str, String str2) {
        Object opt = h().opt(DataSchemeDataSource.SCHEME_DATA);
        a(opt instanceof JSONArray ? ((JSONArray) opt).optJSONObject(0) : h(), "filters", str, str2);
        return this;
    }

    public a a(String str, JSONArray jSONArray) {
        JSONObject optJSONObject = h().optJSONObject("custom_long");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            a("custom_long", (Object) optJSONObject);
        }
        try {
            optJSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
        return this;
    }

    public a a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            a("patch_info", (Object) jSONArray);
            return this;
        }
        for (String put : list) {
            jSONArray.put(put);
        }
        a("patch_info", (Object) jSONArray);
        return this;
    }

    public a a(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            try {
                this.a.put("plugin_info", jSONArray);
                return this;
            } catch (Exception unused) {
            }
        } else {
            for (String next : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, next);
                jSONObject.put("version_code", map.get(next));
                jSONArray.put(jSONObject);
            }
            this.a.put("plugin_info", jSONArray);
            return this;
        }
    }

    public a a(JSONObject jSONObject) {
        a("header", (Object) jSONObject);
        return this;
    }

    public void a(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (Exception e) {
            q.b((Throwable) e);
        }
    }

    public boolean a() {
        Object opt = h().opt(DataSchemeDataSource.SCHEME_DATA);
        return opt instanceof JSONArray ? !l.a(((JSONArray) opt).optJSONObject(0), "logcat") : !l.a(this.a, "logcat");
    }

    public a b(String str, String str2) {
        Object opt = h().opt(DataSchemeDataSource.SCHEME_DATA);
        a(opt instanceof JSONArray ? ((JSONArray) opt).optJSONObject(0) : h(), "custom", str, str2);
        return this;
    }

    public a b(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer next : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(next), map.get(next));
                } catch (JSONException e) {
                    q.b((Throwable) e);
                }
            }
            try {
                this.a.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public a b(JSONObject jSONObject) {
        a(this.a, jSONObject);
        return this;
    }

    public void b() {
        a("has_logcat", String.valueOf(a()));
    }

    public a c(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject e = e("filters");
            for (Map.Entry next : map.entrySet()) {
                try {
                    e.put((String) next.getKey(), next.getValue());
                } catch (JSONException unused) {
                }
            }
            a("filters", (Object) e);
        }
        return this;
    }

    public void c() {
        a("is_64_devices", String.valueOf(Header.a()));
        a("is_64_runtime", String.valueOf(NativeImpl.e()));
        a("is_x86_devices", String.valueOf(Header.b()));
    }

    public void c(JSONObject jSONObject) {
        b(this.a, jSONObject);
    }

    public boolean d() {
        return c(h.f());
    }

    public JSONObject e(String str) {
        Object opt = h().opt(DataSchemeDataSource.SCHEME_DATA);
        JSONObject optJSONObject = opt instanceof JSONArray ? ((JSONArray) opt).optJSONObject(0) : h();
        if (optJSONObject == null) {
            return new JSONObject();
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (optJSONObject2 != null) {
            return optJSONObject2;
        }
        JSONObject jSONObject = new JSONObject();
        a(str, (Object) jSONObject);
        return jSONObject;
    }

    public boolean e() {
        return d(h.f());
    }

    public boolean f() {
        return b(h.f());
    }

    public boolean g() {
        return a(h.f());
    }

    public JSONObject h() {
        return this.a;
    }

    public Header i() {
        if (this.b == null) {
            this.b = new Header(h.g());
            a(this.b);
        }
        return this.b;
    }
}
