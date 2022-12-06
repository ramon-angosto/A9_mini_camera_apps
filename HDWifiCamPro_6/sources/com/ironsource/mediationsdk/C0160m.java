package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.c.a;
import com.ironsource.mediationsdk.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.m  reason: case insensitive filesystem */
public class C0160m {

    /* renamed from: com.ironsource.mediationsdk.m$a */
    interface a {
        void a(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    /* renamed from: com.ironsource.mediationsdk.m$b */
    interface b {
        void a();

        void a(String str);
    }

    public static JSONObject a(Context context, String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = a.C0088a.a.a(context);
        for (String str : strArr) {
            if (a2.has(str)) {
                jSONObject.put(str, a2.opt(str));
            }
        }
        return jSONObject;
    }

    public static JSONObject a(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = a.C0088a.a.a(ContextProvider.getInstance().getApplicationContext());
        for (String str : strArr) {
            if (a2.has(str)) {
                jSONObject.put(str, a2.opt(str));
            }
        }
        return jSONObject;
    }

    static void a(String str, ConcurrentHashMap<String, R> concurrentHashMap, a aVar) {
        StringBuilder sb;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        if (!k.b((Context) ContextProvider.getInstance().getCurrentActiveActivity(), str)) {
            for (R next : concurrentHashMap.values()) {
                if (next.h()) {
                    Map<String, Object> c = next.c();
                    if (c != null) {
                        hashMap.put(next.k(), c);
                        sb = new StringBuilder("2");
                    }
                } else if (!next.h()) {
                    arrayList.add(next.k());
                    sb = new StringBuilder("1");
                }
                sb.append(next.k());
                sb.append(",");
                sb2.append(sb.toString());
            }
        }
        aVar.a(hashMap, arrayList, sb2);
    }

    static boolean a(IronSourceBannerLayout ironSourceBannerLayout) {
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    public JSONObject a(ArrayList<String> arrayList) {
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = a.C0088a.a.a(applicationContext);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (a2.has(next)) {
                jSONObject.put(next, a2.opt(next));
            }
        }
        return jSONObject;
    }
}
