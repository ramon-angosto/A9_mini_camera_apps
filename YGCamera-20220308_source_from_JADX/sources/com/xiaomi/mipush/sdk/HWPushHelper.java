package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import org.json.JSONArray;
import org.json.JSONObject;

public class HWPushHelper {

    /* renamed from: a */
    private static boolean f1619a = false;

    public static void convertMessage(Intent intent) {
        C1586i.m2437a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return C1586i.m2430a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String a = C1586i.m2432a(C1582e.ASSEMBLE_PUSH_HUAWEI);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        String a2 = C1586i.m2431a(context, a);
        String a3 = C1559af.m2278a(context).mo17126a(C1575au.UPLOAD_HUAWEI_TOKEN);
        return !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3) && "synced".equals(a3);
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return f1619a;
    }

    public static void notifyHmsNotificationMessageClicked(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has("pushMsg")) {
                            str2 = jSONObject.getString("pushMsg");
                            break;
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                C1524b.m2160d(e.toString());
            }
        }
        PushMessageReceiver a = C1586i.m2430a(context);
        if (a != null) {
            MiPushMessage a2 = C1586i.m2429a(str2);
            if (!a2.getExtra().containsKey("notify_effect")) {
                a.onNotificationMessageClicked(context, a2);
            }
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(RemoteMessageConst.Notification.CONTENT)) {
                    str2 = jSONObject.getString(RemoteMessageConst.Notification.CONTENT);
                }
            }
        } catch (Exception e) {
            C1524b.m2160d(e.toString());
        }
        PushMessageReceiver a = C1586i.m2430a(context);
        if (a != null) {
            a.onReceivePassThroughMessage(context, C1586i.m2429a(str2));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager a = C1583f.m2419a(context).mo17188a(C1582e.ASSEMBLE_PUSH_HUAWEI);
        if (a != null) {
            a.register();
        }
    }

    public static void reportError(String str, int i) {
        C1586i.m2439a(str, i);
    }

    public static synchronized void setConnectTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void setGetTokenTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
        }
    }

    public static void setNeedConnect(boolean z) {
        f1619a = z;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = false;
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1)) > 172800000) {
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = false;
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1)) > 5000) {
                z = true;
            }
        }
        return z;
    }

    public static void uploadToken(Context context, String str) {
        C1586i.m2436a(context, C1582e.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
