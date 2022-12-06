package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.w */
public class C0835w {
    /* renamed from: a */
    public static Map<String, List<C0823q>> m1048a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> a = C0796g0.m830a(context, str);
        m1054b(a);
        return m1050a(a);
    }

    /* renamed from: a */
    public static Map<String, List<C0823q>> m1049a(Context context, String str, String str2) {
        Map<String, List<C0823q>> map;
        Map<String, List<C0823q>> map2;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            C0841y.m1087c("hmsSdk", "read all event records");
            map = m1048a(context, "stat_v2_1");
            map2 = m1048a(context, "cached_v2_1");
        } else {
            String a = C0828s0.m1024a(str, str2);
            map = m1053b(context, "stat_v2_1", a);
            map2 = m1053b(context, "cached_v2_1", a);
        }
        return m1051a(map, map2);
    }

    /* renamed from: a */
    public static Map<String, List<C0823q>> m1050a(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (next.getValue() instanceof String) {
                m1052a(str, (String) next.getValue(), (Map<String, List<C0823q>>) hashMap);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, List<C0823q>> m1051a(Map<String, List<C0823q>> map, Map<String, List<C0823q>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            List list2 = map2.get(str);
            if (list2 != null && list2.size() > 0) {
                list.addAll(list2);
            }
            hashMap.put(str, list);
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m1052a(String str, String str2, Map<String, List<C0823q>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONArray jSONArray = new JSONArray(str2);
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        C0823q qVar = new C0823q();
                        try {
                            qVar.mo14099a(jSONArray.getJSONObject(i));
                            arrayList.add(qVar);
                        } catch (JSONException unused) {
                            C0841y.m1091e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                        }
                    }
                    map.put(str, arrayList);
                }
            }
        } catch (JSONException unused2) {
            C0841y.m1091e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    /* renamed from: b */
    public static Map<String, List<C0823q>> m1053b(Context context, String str, String str2) {
        String a = C0796g0.m829a(context, str, str2, "");
        HashMap hashMap = new HashMap();
        m1052a(str2, a, (Map<String, List<C0823q>>) hashMap);
        return hashMap;
    }

    /* renamed from: b */
    public static void m1054b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> a = C0828s0.m1026a(C0777b.m721a());
        while (it.hasNext()) {
            if (!a.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }
}
