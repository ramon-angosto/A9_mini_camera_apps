package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.C0875e;
import com.huawei.hms.push.C0878h;
import com.huawei.hms.push.C0879i;
import com.huawei.hms.push.C0890t;
import com.huawei.hms.push.C0896w;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginUtil {
    /* renamed from: a */
    public static void m1330a(Context context, String str, String str2, String str3) {
        HMSLog.m1379i("PluginUtil", "onNotification");
        if (!C0890t.m1323a(context)) {
            HMSLog.m1379i("PluginUtil", context.getPackageName() + " disable display notification.");
            C0875e.m1221a(context, str, (String) null, "103");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", str3.getBytes(C0896w.f942a));
        intent.putExtra("selfshow_token", str2.getBytes(C0896w.f942a));
        intent.setPackage(context.getPackageName());
        C0879i.m1226a(context, intent);
        HMSLog.m1379i("PluginUtil", "invokeSelfShow done");
    }

    public static void onAppOpened(Context context, String str, String str2) {
        C0875e.m1221a(context, str, str2, "appHasOpenedId");
    }

    public static boolean onDataMessage(Context context, String str, String str2, boolean z) {
        HMSLog.m1379i("PluginUtil", "onDataMessage");
        if (TextUtils.isEmpty(str2)) {
            HMSLog.m1379i("PluginUtil", "Empty message received");
            return true;
        }
        if (z) {
            m1329a(context, str);
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_id", str);
        bundle.putByteArray(RemoteMessageConst.MSGBODY, str2.getBytes(C0896w.f942a));
        bundle.putString("message_type", "received_message");
        return new C0878h().mo14284a(context, bundle, intent);
    }

    public static boolean onDeletedMessages(Context context) {
        HMSLog.m1379i("PluginUtil", "onDeletedMessages");
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        bundle.putString("message_type", "server_deleted_message");
        return new C0878h().mo14284a(context, bundle, intent);
    }

    public static void onMessage(Context context, String[] strArr) {
        HMSLog.m1379i("PluginUtil", "onMessage");
        if (context != null && strArr != null && strArr.length >= 5) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if (m1332a(context, strArr)) {
                m1330a(context, strArr[0], strArr[3], strArr[4]);
            } else {
                onDataMessage(context, strArr[0], strArr[4], true);
            }
        }
    }

    public static boolean onNewToken(Context context, String str, String str2, ErrorEnum errorEnum) {
        HMSLog.m1379i("PluginUtil", "onNewToken called.");
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt("error", errorEnum.getInternalCode());
        bundle.putString("message_type", "new_token");
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, str);
        if (TextUtils.equals(str2, context.getPackageName())) {
            bundle.putString("subjectId", (String) null);
        } else {
            bundle.putString("subjectId", str2);
        }
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        return new C0878h().mo14284a(context, bundle, intent);
    }

    public static void onNotificationArrived(Context context, String str, String str2) {
        C0875e.m1221a(context, str, str2, "100");
    }

    public static void onNotificationClicked(Context context, String str, String str2) {
        C0875e.m1221a(context, str, str2, "1");
        onAppOpened(context, str, str2);
    }

    public static boolean onOldDataMessage(Context context, String str, String str2) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        return onDataMessage(context, str, m1328a(str2), true);
    }

    public static void saveNotifySwitch(Context context, boolean z) {
        new PushPreferences(context, "push_notify_flag").saveBoolean("notify_msg_enable", z);
    }

    /* renamed from: a */
    public static String m1328a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(RemoteMessageConst.DATA, str);
            jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException unused) {
            HMSLog.m1377e("PluginUtil", "rebuild message failed");
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m1331a(Context context) {
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(context.getPackageName())) {
                    int i = next.importance;
                    if (i == 100 || i == 200) {
                        z = false;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m1332a(Context context, String[] strArr) {
        if (!TextUtils.equals(strArr[1], "0")) {
            return false;
        }
        if (m1331a(context) || TextUtils.equals(strArr[2], "1")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m1329a(Context context, String str) {
        C0875e.m1221a(context, str, (String) null, "102");
    }
}
