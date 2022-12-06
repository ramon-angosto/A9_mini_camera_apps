package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.component.utils.l;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ISettingsDataRepository */
public interface d {
    public static final b<JSONObject> a = new b<JSONObject>() {
        /* renamed from: a */
        public JSONObject b(String str) {
            try {
                return new JSONObject(str);
            } catch (Exception e) {
                l.c("ISettingsDataRepository", "", (Throwable) e);
                return null;
            }
        }
    };
    public static final b<Set<String>> b = new b<Set<String>>() {
        /* renamed from: a */
        public Set<String> b(String str) {
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    hashSet.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                l.c("ISettingsDataRepository", "", (Throwable) e);
            }
            return hashSet;
        }
    };

    /* compiled from: ISettingsDataRepository */
    public interface a {
        a a(String str);

        a a(String str, float f);

        a a(String str, int i);

        a a(String str, long j);

        a a(String str, String str2);

        void a();
    }

    /* compiled from: ISettingsDataRepository */
    public interface b<T> {
        T b(String str);
    }

    float a(String str, float f);

    int a(String str, int i);

    long a(String str, long j);

    a a();

    <T> T a(String str, T t, b<T> bVar);

    String a(String str, String str2);

    void a(boolean z);

    boolean b();
}
