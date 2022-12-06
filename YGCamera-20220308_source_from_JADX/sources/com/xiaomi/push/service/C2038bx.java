package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C2088v;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.bx */
public class C2038bx implements XMPushService.C1959l {

    /* renamed from: a */
    private static Context f3854a;

    /* renamed from: a */
    private static final Map<Integer, Map<String, List<String>>> f3855a = new HashMap();

    /* renamed from: a */
    private static final boolean f3856a = Log.isLoggable("UNDatas", 3);

    public C2038bx(Context context) {
        f3854a = context;
    }

    /* renamed from: a */
    private static C1894in m5190a(String str, String str2, String str3, String str4) {
        C1894in inVar = new C1894in();
        if (str3 != null) {
            inVar.mo18087c(str3);
        }
        if (str != null) {
            inVar.mo18084b(str);
        }
        if (str2 != null) {
            inVar.mo18078a(str2);
        }
        if (str4 != null) {
            inVar.mo18091d(str4);
        }
        inVar.mo18081a(false);
        return inVar;
    }

    /* renamed from: a */
    private static void m5191a(Context context, C1894in inVar) {
        if (f3856a) {
            C1524b.m2158b("UNDatas upload message notification:" + inVar);
        }
        C1618ak.m2518a(context).mo17212a((Runnable) new C2039by(inVar));
    }

    /* renamed from: b */
    private static void m5192b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f3855a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(Constants.COLON_SEPARATOR);
                        List list = (List) map.get(str);
                        if (!C2088v.m5383a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(";");
                    }
                    C1894in a = m5190a((String) null, C1999aw.m5064a(), C1878hy.NotificationRemoved.f2959a, (String) null);
                    a.mo18083a("removed_reason", String.valueOf(num));
                    a.mo18083a("all_delete_msgId_appId", sb.toString());
                    C1524b.m2158b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    m5191a(f3854a, a);
                }
                f3855a.remove(num);
            }
        }
    }

    /* renamed from: a */
    public void m5193a() {
        if (f3855a.size() > 0) {
            synchronized (f3855a) {
                m5192b();
            }
        }
    }
}
