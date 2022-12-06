package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.xiaomi.mipush.sdk.Constants;

public class AGCUtils {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m420a(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "Get "
            java.lang.String r1 = ""
            java.lang.String r2 = "AGCUtils"
            com.huawei.agconnect.config.AGConnectServicesConfig r3 = com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(r6)
            r4 = 0
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ IOException -> 0x003f, NullPointerException -> 0x0023 }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ IOException -> 0x003f, NullPointerException -> 0x0023 }
            java.lang.String r5 = "agconnect-services.json"
            java.io.InputStream r4 = r6.open(r5)     // Catch:{ IOException -> 0x003f, NullPointerException -> 0x0023 }
            r3.overlayWith((java.io.InputStream) r4)     // Catch:{ IOException -> 0x003f, NullPointerException -> 0x0023 }
            java.lang.String r6 = r3.getString(r7)     // Catch:{ IOException -> 0x003f, NullPointerException -> 0x0023 }
            goto L_0x005b
        L_0x0021:
            r6 = move-exception
            goto L_0x007f
        L_0x0023:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r3.<init>()     // Catch:{ all -> 0x0021 }
            r3.append(r0)     // Catch:{ all -> 0x0021 }
            r3.append(r7)     // Catch:{ all -> 0x0021 }
            java.lang.String r0 = " with AGConnectServicesConfig failed: "
            r3.append(r0)     // Catch:{ all -> 0x0021 }
            r3.append(r6)     // Catch:{ all -> 0x0021 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0021 }
            com.huawei.hms.support.log.HMSLog.m1377e(r2, r6)     // Catch:{ all -> 0x0021 }
            goto L_0x005a
        L_0x003f:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r3.<init>()     // Catch:{ all -> 0x0021 }
            r3.append(r0)     // Catch:{ all -> 0x0021 }
            r3.append(r7)     // Catch:{ all -> 0x0021 }
            java.lang.String r0 = " failed: "
            r3.append(r0)     // Catch:{ all -> 0x0021 }
            r3.append(r6)     // Catch:{ all -> 0x0021 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0021 }
            com.huawei.hms.support.log.HMSLog.m1377e(r2, r6)     // Catch:{ all -> 0x0021 }
        L_0x005a:
            r6 = r1
        L_0x005b:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r4)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0065
            return r6
        L_0x0065:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "The "
            r6.append(r0)
            r6.append(r7)
            java.lang.String r7 = " is null."
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.huawei.hms.support.log.HMSLog.m1377e(r2, r6)
            return r1
        L_0x007f:
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.AGCUtils.m420a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static String m421b(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m1377e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("com.huawei.hms.client.cpid")) == null) {
                HMSLog.m1379i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m1377e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        }
    }

    /* renamed from: c */
    public static boolean m422c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageName());
    }

    public static String getAppId(Context context) {
        if (m422c(context)) {
            return m420a(context, "client/app_id");
        }
        String str = null;
        try {
            str = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.m1377e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String a = m419a(context);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        return m420a(context, "client/app_id");
    }

    public static String getCpId(Context context) {
        if (m422c(context)) {
            return m420a(context, "client/cp_id");
        }
        String str = null;
        try {
            str = AGConnectServicesConfig.fromContext(context).getString("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.m1377e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String b = m421b(context);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        return m420a(context, "client/cp_id");
    }

    /* renamed from: a */
    public static String m419a(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m1377e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get(Constants.HUAWEI_HMS_CLIENT_APPID)) == null) {
                HMSLog.m1377e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m1377e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        }
    }
}
