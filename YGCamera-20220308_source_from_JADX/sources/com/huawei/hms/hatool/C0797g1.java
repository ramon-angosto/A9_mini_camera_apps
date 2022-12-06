package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.g1 */
public final class C0797g1 {

    /* renamed from: c */
    public static C0797g1 f630c;

    /* renamed from: a */
    public Context f631a;

    /* renamed from: b */
    public final Object f632b = new Object();

    /* renamed from: a */
    public static C0797g1 m836a() {
        if (f630c == null) {
            m837b();
        }
        return f630c;
    }

    /* renamed from: b */
    public static synchronized void m837b() {
        synchronized (C0797g1.class) {
            if (f630c == null) {
                f630c = new C0797g1();
            }
        }
    }

    /* renamed from: a */
    public final JSONObject mo13961a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException unused) {
                C0841y.m1084b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo13962a(Context context) {
        synchronized (this.f632b) {
            if (this.f631a == null) {
                this.f631a = context;
                C0799h0.m845a().mo13966a(context);
            }
        }
    }

    /* renamed from: a */
    public void mo13963a(String str, int i) {
        C0799h0.m845a().mo13967a(str, i);
    }

    /* renamed from: a */
    public void mo13964a(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        C0799h0.m845a().mo13968a(str, i, str2, mo13961a((Map<String, String>) linkedHashMap));
    }

    /* renamed from: a */
    public void mo13965a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            C0799h0.m845a().mo13968a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            C0841y.m1092f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }
}
