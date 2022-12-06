package com.huawei.android.pushagent.c.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import java.util.Iterator;
import java.util.List;

public class d {
    private static long a(ResolveInfo resolveInfo, String str) {
        if (resolveInfo == null) {
            return -1;
        }
        try {
            return Long.parseLong(b(resolveInfo, str));
        } catch (NumberFormatException unused) {
            e.a("PushLogAC2705", str + " is not set in " + a(resolveInfo));
            return -1;
        }
    }

    private static ResolveInfo a(Context context, String str, String str2) {
        StringBuilder sb;
        String str3;
        List b = a.b(context, str);
        if (b == null || b.size() == 0) {
            sb = new StringBuilder();
            str3 = "no push service install, may be system Err!! pkgName:";
        } else {
            e.a("PushLogAC2705", "begin to get the hight Version package, have action:" + str);
            ResolveInfo a = a(b, str2);
            if (a != null) {
                return a;
            }
            sb = new StringBuilder();
            str3 = "there is no hightVersion PushService, maybe system Err!! pkgName:";
        }
        sb.append(str3);
        sb.append(context.getPackageName());
        e.d("PushLogAC2705", sb.toString());
        return null;
    }

    private static ResolveInfo a(List list, String str) {
        ResolveInfo resolveInfo = null;
        if (!(list == null || list.size() == 0)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ResolveInfo resolveInfo2 = (ResolveInfo) it.next();
                if (a(resolveInfo2, resolveInfo, str)) {
                    resolveInfo = resolveInfo2;
                }
            }
            if (resolveInfo != null) {
                String str2 = resolveInfo.serviceInfo != null ? resolveInfo.serviceInfo.packageName : resolveInfo.activityInfo.packageName;
                e.a("PushLogAC2705", "after getHighVersion pushService pkgName=" + str2);
            }
        }
        return resolveInfo;
    }

    private static String a(ResolveInfo resolveInfo) {
        if (resolveInfo != null) {
            return resolveInfo.serviceInfo != null ? resolveInfo.serviceInfo.packageName : resolveInfo.activityInfo.packageName;
        }
        e.b("PushLogAC2705", "ResolveInfo is null , cannot get packageName");
        return null;
    }

    private static boolean a() {
        if (-2 != a.a(1, 3) && !e.c()) {
            return true;
        }
        e.a("PushLogAC2705", "not support ctrlsocket.");
        return false;
    }

    public static boolean a(Context context) {
        try {
            String b = b(context);
            new h(context, "pushConfig").a("votedPackageName", b);
            e.a("PushLogAC2705", "start push service ,the highPkgName is :" + b);
            if (!context.getPackageName().equals(b) && b != null) {
                if (!"android".equals(b)) {
                    context.sendBroadcast(new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.intent.action.PUSH_ON").putExtra("Remote_Package_Name", b).setFlags(32).setPackage(b));
                } else {
                    e.a("PushLogAC2705", "pushservice start by framework");
                }
            }
            return context.getPackageName().equals(b);
        } catch (SecurityException e) {
            e.c("PushLogAC2705", "startService SecurityException:" + e.getMessage());
            return false;
        } catch (Exception e2) {
            e.c("PushLogAC2705", "isVotedSelf exception: " + e2.toString(), e2);
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        e.a("PushLogAC2705", "isPkgInstall(pkgName:" + str + " context:" + context);
        return b(context, str) != null;
    }

    private static boolean a(ResolveInfo resolveInfo, ResolveInfo resolveInfo2, String str) {
        if (resolveInfo2 == null) {
            return true;
        }
        if (resolveInfo == null) {
            return false;
        }
        String a = a(resolveInfo);
        long a2 = a(resolveInfo, str);
        long a3 = a(resolveInfo2, str);
        String str2 = resolveInfo2.serviceInfo != null ? resolveInfo2.serviceInfo.packageName : resolveInfo2.activityInfo.packageName;
        e.a("PushLogAC2705", "the curPkgName(" + a + ")version is:" + a2 + "the oldPkgName (" + str2 + ")version is:" + a3);
        if (a2 > a3) {
            return true;
        }
        return a2 == a3 && a != null && a.compareTo(str2) > 0;
    }

    private static PackageInfo b(Context context, String str) {
        e.a("PushLogAC2705", "getPkgVersion(pkgName:" + str + " context:" + context);
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static String b(Context context) {
        StringBuilder sb;
        e.a("PushLogAC2705", " choose the high version for push service");
        if (a.o(context)) {
            return "android";
        }
        long c = c(context);
        String str = "com.huawei.android.pushagent";
        if (228 > c || !a()) {
            ResolveInfo a = a(context, "com.huawei.android.push.intent.REGISTER", "CS_cloud_version");
            long a2 = a(a, "CS_cloud_version");
            e.a("PushLogAC2705", "the getHightMetaPackageName return version is :" + a2 + " curApkVersion:" + c);
            if (c >= a2) {
                sb = new StringBuilder();
                sb.append("the push APK version (");
                sb.append(c);
                sb.append(")is hight,use APK for push service");
            } else {
                str = a(a);
                sb = new StringBuilder();
                sb.append("use the hight version(");
                sb.append(a2);
                sb.append(" )for push service, highPkgName is :");
                sb.append(str);
            }
            e.a("PushLogAC2705", sb.toString());
        } else {
            e.b("PushLogAC2705", "support ctrlsocket.");
        }
        return str;
    }

    private static String b(ResolveInfo resolveInfo, String str) {
        Bundle bundle = resolveInfo.serviceInfo != null ? resolveInfo.serviceInfo.metaData : resolveInfo.activityInfo.metaData;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    private static long c(Context context) {
        long j = -1000;
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent("com.huawei.android.push.intent.REGISTER").setPackage("com.huawei.android.pushagent"), 640);
            if (queryBroadcastReceivers != null) {
                if (queryBroadcastReceivers.size() != 0) {
                    j = 228;
                    String str = queryBroadcastReceivers.get(0).serviceInfo != null ? queryBroadcastReceivers.get(0).serviceInfo.packageName : queryBroadcastReceivers.get(0).activityInfo.packageName;
                    if (str != null && str.equals("com.huawei.android.pushagent")) {
                        j = a(queryBroadcastReceivers.get(0), "CS_cloud_version");
                    }
                    e.a("PushLogAC2705", "start to get Apk version , the APK version is :" + j);
                    return j;
                }
            }
            return -1000;
        } catch (Exception e) {
            e.d("PushLogAC2705", "get Apk version faild ,Exception e= " + e.toString());
        }
    }
}
