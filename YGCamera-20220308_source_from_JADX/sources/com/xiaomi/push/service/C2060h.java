package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.List;

/* renamed from: com.xiaomi.push.service.h */
public class C2060h {
    /* renamed from: a */
    public static ComponentName m5229a(Context context, Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                return new ComponentName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m5230a(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m5231a(Context context, String str) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            if (serviceInfoArr == null) {
                return false;
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            C1524b.m2141a("checkService " + e);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m5232a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            return queryIntentServices != null && !queryIntentServices.isEmpty();
        } catch (Exception e) {
            C1524b.m2141a("checkService action: " + str2 + ", " + e);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m5233b(Context context, String str) {
        boolean z;
        boolean z2 = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT < 19) {
                return true;
            }
            List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders((String) null, 0, 8);
            if (queryContentProviders == null || queryContentProviders.isEmpty()) {
                return false;
            }
            for (ProviderInfo next : queryContentProviders) {
                try {
                    if (next.enabled && next.exported && next.authority.equals(str)) {
                        z2 = true;
                    }
                } catch (Exception e) {
                    e = e;
                    z = z2;
                    C1524b.m2141a("checkProvider " + e);
                    return z;
                }
            }
            return z2;
        } catch (Exception e2) {
            e = e2;
            z = false;
            C1524b.m2141a("checkProvider " + e);
            return z;
        }
    }

    /* renamed from: b */
    public static boolean m5234b(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            return packageManager.resolveActivity(intent, 65536) != null;
        } catch (Exception e) {
            C1524b.m2141a("checkActivity action: " + str2 + ", " + e);
            return false;
        }
    }
}
