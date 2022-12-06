package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.push.q */
/* compiled from: CommFun */
public class C0887q {
    /* renamed from: a */
    public static String m1303a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m1379i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    /* renamed from: b */
    public static Intent m1309b(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            HMSLog.m1380w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m1310c(Context context, String str) {
        if (!(context == null || str == null || "".equals(str))) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" is installed");
                HMSLog.m1374d("PushSelfShowLog", sb.toString());
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m1311d(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        context.getPackageManager().getPreferredActivities(arrayList, arrayList2, str);
        return arrayList2.size() > 0;
    }

    /* renamed from: e */
    public static void m1312e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m1379i("PushSelfShowLog", "url is null.");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(402653184);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            String str2 = null;
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str3 = it.next().activityInfo.packageName;
                if (m1311d(context, str3)) {
                    str2 = str3;
                    break;
                }
            }
            if (str2 == null) {
                Iterator<ResolveInfo> it2 = queryIntentActivities.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String str4 = it2.next().activityInfo.packageName;
                    if ("com.android.browser".equalsIgnoreCase(str4)) {
                        str2 = str4;
                        break;
                    }
                }
            }
            if (str2 != null) {
                intent.setPackage(str2);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            HMSLog.m1377e("PushSelfShowLog", "start browser activity failed, exception:" + e.getMessage());
        }
    }

    /* renamed from: a */
    public static Boolean m1302a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    if (queryIntentActivities.get(i).activityInfo != null && str.equals(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            HMSLog.m1378e("PushSelfShowLog", e.toString(), (Throwable) e);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1307a() {
        return Build.VERSION.SDK_INT >= 11;
    }

    /* renamed from: a */
    public static long m1301a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Date date = new Date();
            int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
            String concat = str.concat(str);
            StringBuilder sb = new StringBuilder();
            sb.append("startIndex is ");
            sb.append(hours);
            sb.append(",ap is:");
            sb.append(concat);
            sb.append(",length is:");
            sb.append(concat.length());
            HMSLog.m1379i("PushSelfShowLog", sb.toString());
            int length = concat.length();
            for (int i = hours; i < length; i++) {
                if (concat.charAt(i) != '0') {
                    long minutes = 60000 * ((long) (((i - hours) * 30) - (date.getMinutes() % 30)));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("startIndex is:");
                    sb2.append(hours);
                    sb2.append(" i is:");
                    sb2.append(i);
                    sb2.append(" delay:");
                    sb2.append(minutes);
                    HMSLog.m1374d("PushSelfShowLog", sb2.toString());
                    if (minutes >= 0) {
                        return minutes;
                    }
                    return 0;
                }
            }
        } catch (Exception e) {
            HMSLog.m1378e("PushSelfShowLog", "error ", (Throwable) e);
        }
        return 0;
    }

    /* renamed from: a */
    public static void m1306a(Context context, Intent intent, long j) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter setAPDelayAlarm(intent:");
            sb.append(intent.toURI());
            sb.append(" interval:");
            sb.append(j);
            sb.append("ms, context:");
            sb.append(context);
            HMSLog.m1374d("PushSelfShowLog", sb.toString());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() / 1000), intent, 0));
            }
        } catch (Exception e) {
            HMSLog.m1380w("PushSelfShowLog", "set DelayAlarm error" + e.toString());
        }
    }

    /* renamed from: a */
    public static boolean m1308a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }

    /* renamed from: a */
    public static void m1304a(Context context, int i) {
        if (context == null) {
            HMSLog.m1377e("PushSelfShowLog", "context is null");
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.cancel(i);
            }
        } catch (Exception e) {
            HMSLog.m1377e("PushSelfShowLog", "removeNotifiCationById err:" + e.toString());
        }
    }

    /* renamed from: a */
    public static void m1305a(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("selfshow_auto_clear_id", 0);
            StringBuilder sb = new StringBuilder();
            sb.append("setDelayAlarm(cancel) alarmNotityId ");
            sb.append(intExtra);
            HMSLog.m1374d("PushSelfShowLog", sb.toString());
            if (intExtra != 0) {
                Intent intent2 = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
                intent2.setPackage(context.getPackageName()).setFlags(32);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                PendingIntent broadcast = PendingIntent.getBroadcast(context, intExtra, intent2, 536870912);
                if (broadcast == null || alarmManager == null) {
                    HMSLog.m1374d("PushSelfShowLog", "alarm not exist");
                    return;
                }
                HMSLog.m1374d("PushSelfShowLog", "alarm cancel");
                alarmManager.cancel(broadcast);
            }
        } catch (Exception e) {
            HMSLog.m1377e("PushSelfShowLog", "cancelAlarm err:" + e.toString());
        }
    }
}
