package com.huawei.android.pushagent.b.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.android.pushagent.a.b.n;
import com.huawei.android.pushagent.a.b.p;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.f;
import com.huawei.android.pushagent.c.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {
    private static b b;
    public HashMap a = new HashMap();

    private b(Context context) {
        e.a("PushLogAC2705", "DeviceTokenMgr: create the DeviceTokenMgr");
        h hVar = new h(context, "pclient_info_v2");
        Set<String> keySet = hVar.b().keySet();
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                String a2 = f.a(context, str);
                e.a("PushLogAC2705", "packageName:" + str + " token:" + com.huawei.android.pushagent.c.a.a.e.a(a2));
                if (!TextUtils.isEmpty(a2)) {
                    this.a.put(a2, str);
                } else {
                    hVar.f(str);
                }
            }
        }
    }

    public static synchronized b a(Context context) {
        synchronized (b.class) {
            if (b != null) {
                b bVar = b;
                return bVar;
            }
            b = new b(context);
            b bVar2 = b;
            return bVar2;
        }
    }

    static void a(Context context, String str, String str2) {
        if (a(context).a == null) {
            e.d("PushLogAC2705", "responseRegisterToken the map is null!!! ");
            return;
        }
        a(context).a.put(str, str2);
        f.b(context, str2, str);
    }

    private static void a(Context context, String str, ArrayList arrayList, ArrayList arrayList2) {
        h hVar = new h(context, "pclient_request_info");
        for (String str2 : hVar.b().keySet()) {
            if (arrayList2.contains(str2)) {
                arrayList.add(b(context, str, str2));
                e.a("PushLogAC2705", "the package name is : " + str2 + " need register");
            } else {
                e.a("PushLogAC2705", "the package name is : " + str2 + " has removed");
                hVar.f(str2);
            }
        }
    }

    public static void a(Context context, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            h hVar = new h(context, "pclient_info_v2");
            h hVar2 = new h(context, "pclient_request_info");
            for (String str : strArr) {
                e.a("PushLogAC2705", str + " need to register again");
                String a2 = f.a(context, str);
                hVar.f(str);
                a(context).a.remove(a2);
                hVar2.a(str, "true");
            }
        }
    }

    public static boolean a(Context context, String str) {
        h hVar = new h(context, "pclient_info_v2");
        return hVar.e(str) && !TextUtils.isEmpty(hVar.b(str));
    }

    private static com.huawei.android.pushagent.a.b.a.b b(Context context, String str, String str2) {
        return new n(str, a.f(context, str2));
    }

    public static ArrayList b(Context context) {
        h hVar = new h(context, "pclient_info_v2");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent("com.huawei.android.push.intent.RECEIVE"), 640);
        int size = queryBroadcastReceivers == null ? 0 : queryBroadcastReceivers.size();
        if (size == 0) {
            e.a("PushLogAC2705", "we have no push client");
            return arrayList;
        }
        String a2 = a.a(context);
        ArrayList arrayList2 = new ArrayList();
        Set<String> keySet = hVar.b().keySet();
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = queryBroadcastReceivers.get(i);
            ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
            if (componentInfo != null && !TextUtils.isEmpty(componentInfo.packageName) && !"com.huawei.android.pushagent".equals(componentInfo.packageName)) {
                arrayList2.add(componentInfo.packageName);
            }
        }
        a(context, a2, arrayList, arrayList2);
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                if (!arrayList2.contains(str)) {
                    String a3 = f.a(context, str);
                    e.a("PushLogAC2705", "this package [" + str + "] need to unregister device toeken");
                    arrayList.add(new p(a3));
                    b(context, str);
                }
            }
        }
        if (arrayList.size() == 0) {
            e.a("PushLogAC2705", "there is no more client need register and unregister token");
        }
        return arrayList;
    }

    static void b(Context context, String str) {
        if (a(context).a == null) {
            e.d("PushLogAC2705", "when removeClientInfo, tokenMap the map is null!!! ");
        } else {
            new h(context, "pclient_info_v2").f(str);
        }
    }

    public static void c(Context context) {
        h hVar = new h(context, "pclient_info_v2");
        Map b2 = hVar.b();
        if (b2 != null && b2.size() > 0) {
            h hVar2 = new h(context, "pclient_request_info");
            for (String str : b2.keySet()) {
                hVar2.a(str, "true");
                e.a("PushLogAC2705", str + " need to register again");
            }
            hVar.c();
            a(context).a.clear();
        }
    }

    static void c(Context context, String str) {
        String str2 = a(context).a != null ? (String) a(context).a.get(str) : "";
        h hVar = new h(context, "pclient_info_v2");
        e.a("PushLogAC2705", "responseUnregisterToken,after delPClientInfo token,  packagename: " + str2);
        a(context).a.remove(str);
        hVar.f(str2);
    }

    public static String d(Context context, String str) {
        return f.a(context, str);
    }
}
