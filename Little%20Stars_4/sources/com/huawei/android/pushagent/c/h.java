package com.huawei.android.pushagent.c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import java.util.Map;

public class h {
    public static synchronized void a(Context context) {
        synchronized (h.class) {
            com.huawei.android.pushagent.c.a.h hVar = new com.huawei.android.pushagent.c.a.h(context, "pushConfig");
            int c = hVar.c("version_config");
            if (c != 2) {
                e.b("PushLogAC2705", "update xml data, old version is " + c + ",new version is " + 2);
                if (c < 2) {
                    b(context);
                }
                hVar.a("version_config", (Integer) 2);
            }
        }
    }

    private static void a(Context context, String str) {
        Map b = new com.huawei.android.pushagent.c.a.h(context, str).b();
        if (b != null && b.size() > 0) {
            com.huawei.android.pushagent.c.a.h hVar = new com.huawei.android.pushagent.c.a.h(context, "pclient_request_info");
            for (String str2 : b.keySet()) {
                hVar.a(str2, "true");
                e.a("PushLogAC2705", str2 + " need to register again");
            }
        }
        a.e(context, str);
    }

    private static void b(Context context) {
        new com.huawei.android.pushagent.c.a.h(context, "device_info").c();
        new com.huawei.android.pushagent.c.a.h(context, "PushRouteInfo").f("PushID");
        new com.huawei.android.pushagent.c.a.h(context, "pushConfig").f("selftoken");
        new com.huawei.android.pushagent.c.a.h(context, "push_client_self_info").f("token_info");
        new com.huawei.android.pushagent.c.a.h(context, "PushRouteInfo").f("PushID_encrypt");
        new com.huawei.android.pushagent.c.a.h(context, "pushConfig").f("selftoken_encrypt");
        new com.huawei.android.pushagent.c.a.h(context, "push_client_self_info").f("token_info_encrypt");
        a.e(context, "pclient_unRegist_info");
        a(context, "pclient_info_encrypt");
        a(context, "pclient_info");
    }
}
