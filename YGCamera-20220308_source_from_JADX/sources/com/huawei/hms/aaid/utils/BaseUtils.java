package com.huawei.hms.aaid.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.opendevice.C0847b;
import com.huawei.hms.opendevice.C0849d;
import com.huawei.hms.opendevice.C0851e;
import com.huawei.hms.opendevice.C0855i;
import com.huawei.hms.opendevice.C0860n;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;

public class BaseUtils {
    public static void clearSubjectIds(Context context) {
        C0855i.m1144a(context).removeKey("subjectId");
    }

    public static void delLocalToken(Context context, String str) {
        C0855i.m1144a(context).mo14169c(str);
    }

    public static void deleteAllTokenCache(Context context) {
        C0855i.m1144a(context).mo14165a();
    }

    public static void deleteCacheData(Context context, String str) {
        C0855i.m1144a(context).removeKey(str);
    }

    public static String getBaseUrl(Context context, String str, String str2, String str3, String str4) {
        return C0851e.m1139a(context, str, str2, str3, str4);
    }

    public static String getCacheData(Context context, String str, boolean z) {
        if (z) {
            return C0855i.m1144a(context).mo14164a(str);
        }
        return C0855i.m1144a(context).getString(str);
    }

    public static String getLocalToken(Context context, String str) {
        return C0855i.m1144a(context).mo14167b(str);
    }

    public static boolean getProxyInit(Context context) {
        return C0855i.m1144a(context).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context context) {
        String string = C0855i.m1144a(context).getString("subjectId");
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public static void initSecret(Context context) {
        C0847b.m1117a(context);
    }

    public static boolean isMainProc(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        String str = context.getApplicationInfo().processName;
        int myPid = Process.myPid();
        HMSLog.m1374d("BaseUtils", "my.pid -> " + myPid + ", mainProcessName -> " + str);
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            HMSLog.m1374d("BaseUtils", "info.pid -> " + next.pid + ", info.processName -> " + next.processName);
            if (next.pid == myPid && str.equals(next.processName)) {
                return true;
            }
        }
        return false;
    }

    public static void reportAaidToken(Context context, String str) {
        C0860n.m1154a(context, str);
    }

    public static boolean saveCacheData(Context context, String str, String str2, boolean z) {
        if (z) {
            return C0855i.m1144a(context).mo14166a(str, str2);
        }
        return C0855i.m1144a(context).saveString(str, str2);
    }

    public static void saveProxyInit(Context context, boolean z) {
        C0855i.m1144a(context).saveBoolean("_proxy_init", z);
    }

    public static void saveToken(Context context, String str, String str2) {
        C0855i.m1144a(context).mo14168b(str, str2);
    }

    public static String sendPostRequest(Context context, String str, String str2, Map<String, String> map) {
        return C0849d.m1135a(context, str, str2, map);
    }
}
