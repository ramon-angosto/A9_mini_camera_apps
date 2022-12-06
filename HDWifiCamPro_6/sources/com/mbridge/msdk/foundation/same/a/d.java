package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.same.d.a;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StaticDataPoll */
public class d {
    public static Map<String, Long> a = new HashMap();
    public static Map<String, List<a>> b = new HashMap();
    public static Map<String, List<a>> c = new HashMap();
    public static Map<String, List<a>> d = new HashMap();
    public static Map<String, List<a>> e = new HashMap();
    public static Map<String, List<a>> f = new HashMap();
    public static Map<String, List<a>> g = new HashMap();
    public static Map<String, List<a>> h = new HashMap();
    public static Map<String, List<a>> i = new HashMap();
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, b>> j;
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> k;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> l;
    private static final String m = d.class.getSimpleName();

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<a>> d2 = d(str2);
        if (campaignEx != null && d2 != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    a aVar = new a(campaignEx.getId(), campaignEx.getRequestIdNotice());
                    if (d2.containsKey(str)) {
                        List list = d2.get(str);
                        if (list != null && list.size() == 20) {
                            list.remove(0);
                        }
                        if (list != null) {
                            list.add(aVar);
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(aVar);
                    d2.put(str, arrayList);
                }
            } catch (Throwable th) {
                q.a(m, th.getMessage(), th);
            }
        }
    }

    public static String a(String str, String str2) {
        Map<String, List<a>> map;
        List list;
        JSONArray jSONArray = new JSONArray();
        if (TextUtils.isEmpty(str2)) {
            map = null;
            if (c.containsKey(str)) {
                map = c;
            } else if (d.containsKey(str)) {
                map = d;
            } else if (e.containsKey(str)) {
                map = e;
            } else if (f.containsKey(str)) {
                map = f;
            } else if (g.containsKey(str)) {
                map = g;
            } else if (h.containsKey(str)) {
                map = h;
            } else if (i.containsKey(str)) {
                map = i;
            }
        } else {
            map = d(str2);
        }
        if (map != null) {
            try {
                if (x.b(str) && map.containsKey(str) && (list = map.get(str)) != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", ((a) list.get(i2)).a());
                        jSONObject.put("1", ((a) list.get(i2)).b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static void a(String str, String str2, String str3, long j2, long j3, long j4) {
        if (j == null) {
            j = new ConcurrentHashMap<>();
        }
        try {
            if (j.containsKey(str)) {
                Map map = j.get(str);
                if (map != null) {
                    b bVar = (b) map.get(str2);
                    if (bVar == null) {
                        b bVar2 = new b();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        bVar2.a((List<String>) arrayList);
                        bVar2.a(j2);
                        bVar2.b(j3);
                        bVar2.c(j4);
                        map.put(str2, bVar2);
                    } else if (bVar.c() != null) {
                        bVar.a(j2);
                        bVar.b(j3);
                        bVar.c(j4);
                        bVar.c().add(str3);
                    }
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str3);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                b bVar3 = new b();
                bVar3.a((List<String>) arrayList2);
                bVar3.a(j2);
                bVar3.b(j3);
                bVar3.c(j4);
                concurrentHashMap.put(str2, bVar3);
                j.put(str, concurrentHashMap);
            }
        } catch (Throwable th) {
            q.d(m, th.getMessage());
        }
    }

    public static void b(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = j) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            j.remove(str);
            return;
        }
        Map map = j.get(str);
        if (map != null && map.containsKey(str2)) {
            map.remove(str2);
        }
    }

    public static ConcurrentHashMap<String, b> a(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> concurrentHashMap = j;
        if (concurrentHashMap == null) {
            e a2 = e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
            if (a2 != null) {
                a2.d(str, "");
                j = new ConcurrentHashMap<>();
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return j.get(str);
        }
        return null;
    }

    public static void a(String str, String str2, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        int size;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (k == null) {
                k = new ConcurrentHashMap<>();
            }
            try {
                if (k.containsKey(str)) {
                    copyOnWriteArrayList = k.get(str);
                    copyOnWriteArrayList.add(str2);
                } else {
                    CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                    copyOnWriteArrayList2.add(str2);
                    k.put(str, copyOnWriteArrayList2);
                    copyOnWriteArrayList = copyOnWriteArrayList2;
                }
                if (copyOnWriteArrayList != null && (size = copyOnWriteArrayList.size() - i2) >= 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        copyOnWriteArrayList.remove(i3);
                    }
                }
            } catch (Exception e2) {
                q.a(m, e2.getMessage());
            }
        }
    }

    public static void b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = k) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = k.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            copyOnWriteArrayList.remove(0);
        }
    }

    public static String c(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = k) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = k.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            return (String) copyOnWriteArrayList.get(0);
        }
        return "";
    }

    public static void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (l == null) {
                    l = new ConcurrentHashMap<>();
                }
                if (!l.containsKey(str)) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(str2, str3);
                    l.put(str, concurrentHashMap);
                } else if (l.get(str) == null) {
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    concurrentHashMap2.put(str2, str3);
                    l.put(str, concurrentHashMap2);
                }
            } catch (Exception e2) {
                q.a(m, e2.getMessage());
            }
        }
    }

    public static c c(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        c cVar = new c();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        try {
            if (l != null && l.containsKey(str) && (concurrentHashMap = l.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                cVar.b(1);
                cVar.c((String) concurrentHashMap.get(str2));
            }
        } catch (Exception e2) {
            q.a(m, e2.getMessage());
        }
        return cVar;
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (l != null && l.containsKey(str) && (concurrentHashMap = l.get(str2)) != null && concurrentHashMap.containsKey(str2)) {
                    concurrentHashMap.remove(str2);
                }
            } catch (Exception e2) {
                q.a(m, e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> d(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1396342996: goto L_0x0044;
                case -1052618729: goto L_0x003a;
                case -934326481: goto L_0x0030;
                case -895866265: goto L_0x0026;
                case 538816457: goto L_0x001c;
                case 604727084: goto L_0x0012;
                case 1844104930: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "interactive"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 2
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "interstitial"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 3
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "h5_native"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 6
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "splash"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 5
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "reward"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 1
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "native"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 0
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "banner"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004e
            r1 = 4
            goto L_0x004f
        L_0x004e:
            r1 = -1
        L_0x004f:
            switch(r1) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0063;
                case 2: goto L_0x0060;
                case 3: goto L_0x005d;
                case 4: goto L_0x005a;
                case 5: goto L_0x0057;
                case 6: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            r1 = 0
            goto L_0x0068
        L_0x0054:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> r1 = i
            goto L_0x0068
        L_0x0057:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> r1 = h
            goto L_0x0068
        L_0x005a:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> r1 = g
            goto L_0x0068
        L_0x005d:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> r1 = f
            goto L_0x0068
        L_0x0060:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> r1 = e
            goto L_0x0068
        L_0x0063:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> r1 = d
            goto L_0x0068
        L_0x0066:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.same.d.a>> r1 = c
        L_0x0068:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.a.d.d(java.lang.String):java.util.Map");
    }
}
