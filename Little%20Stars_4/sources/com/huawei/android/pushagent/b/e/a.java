package com.huawei.android.pushagent.b.e;

import android.content.Context;
import com.huawei.android.pushagent.b.a.a.b.b;
import com.huawei.android.pushagent.c.a.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static a a;

    private a() {
    }

    public static synchronized a a() {
        synchronized (a.class) {
            if (a != null) {
                a aVar = a;
                return aVar;
            }
            a = new a();
            a aVar2 = a;
            return aVar2;
        }
    }

    private void a(JSONObject jSONObject, Context context) throws JSONException {
        e.a("PushLogAC2705", "server command agent to refresh token");
        JSONObject jSONObject2 = jSONObject.getJSONObject("refreshToken");
        if (jSONObject2.has("pkgs")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("pkgs");
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                e.a("PushLogAC2705", "package need to refresh token:" + string);
                strArr[i] = string;
            }
            b.a(context, strArr);
            return;
        }
        e.a("PushLogAC2705", "all packages need to refresh token");
        b.c(context);
    }

    private void b(JSONObject jSONObject, Context context) throws JSONException {
        e.a("PushLogAC2705", "server command agent to refresh trs");
        JSONObject jSONObject2 = jSONObject.getJSONObject("refreshTrs");
        if (jSONObject2.has("belongId")) {
            int i = jSONObject2.getInt("belongId");
            e.a("PushLogAC2705", "need to refresh trs in belongId:" + i);
            if (i >= 0) {
                com.huawei.android.pushagent.b.b.a.a(context).a("belongId", (Object) Integer.valueOf(i));
            }
        }
        com.huawei.android.pushagent.b.b.a.b(context);
    }

    private void c(JSONObject jSONObject, Context context) throws JSONException {
        e.a("PushLogAC2705", "server command agent to refresh heartbeat");
        JSONObject jSONObject2 = jSONObject.getJSONObject("refreshHb");
        if (jSONObject2.has("fixedWifiHb")) {
            int i = jSONObject2.getInt("fixedWifiHb");
            e.a("PushLogAC2705", "fixed heartbeat in wifi is " + i);
            if (i > 60) {
                long j = (long) i;
                com.huawei.android.pushagent.b.b.a.a(context).a(j);
                com.huawei.android.pushagent.b.b.a.a(context).b(j);
            } else {
                e.a("PushLogAC2705", "fixed heartbeat in wifi is invalid");
            }
        }
        if (jSONObject2.has("fixed3GHb")) {
            int i2 = jSONObject2.getInt("fixed3GHb");
            e.a("PushLogAC2705", "fixed heartbeat in 3g is " + i2);
            if (i2 > 60) {
                long j2 = (long) i2;
                com.huawei.android.pushagent.b.b.a.a(context).c(j2);
                com.huawei.android.pushagent.b.b.a.a(context).d(j2);
            } else {
                e.a("PushLogAC2705", "fixed heartbeat in 3g is invalid");
            }
        }
        try {
            e.a("PushLogAC2705", "delete heartbeat files and reload heartbeat");
            com.huawei.android.pushagent.c.a.e(context, new b(context).c());
            com.huawei.android.pushagent.b.a.a.e().e.f();
        } catch (Exception e) {
            e.c("PushLogAC2705", "delete heartbeat files or reload heartbeat error:" + e.getMessage(), e);
        }
    }

    public void a(Context context, com.huawei.android.pushagent.a.b.b bVar) {
        StringBuilder sb;
        Exception exc;
        String str;
        try {
            byte a2 = bVar.a();
            if (-91 == a2) {
                e.a("PushLogAC2705", "receive response from server");
            } else if (-90 == a2) {
                JSONObject c = bVar.c();
                if (c.has("refreshHb")) {
                    c(c, context);
                } else if (c.has("refreshToken")) {
                    a(c, context);
                } else if (c.has("refreshTrs")) {
                    b(c, context);
                } else {
                    e.d("PushLogAC2705", "cannot parse the unknown message:" + c.toString());
                }
            }
        } catch (JSONException e) {
            sb = new StringBuilder();
            sb.append("parse json error:");
            str = e.getMessage();
            exc = e;
            sb.append(str);
            e.c("PushLogAC2705", sb.toString(), exc);
        } catch (Exception e2) {
            sb = new StringBuilder();
            sb.append("parse DecoupledPushMessage error: ");
            str = e2.getMessage();
            exc = e2;
            sb.append(str);
            e.c("PushLogAC2705", sb.toString(), exc);
        }
    }
}
