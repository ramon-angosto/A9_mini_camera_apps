package com.huawei.hms.stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.stats.a */
/* compiled from: AnalyticsSwitchHolder */
public class C0898a {

    /* renamed from: a */
    public static int f943a;

    /* renamed from: b */
    public static final Object f944b = new Object();

    /* renamed from: a */
    public static boolean m1335a(Context context) {
        if (context == null) {
            HMSLog.m1377e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.m1377e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            }
        }
        HMSLog.m1379i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    /* renamed from: b */
    public static boolean m1336b(Context context) {
        if (context == null) {
            HMSLog.m1377e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.m1377e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            }
        }
        HMSLog.m1379i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007f, code lost:
        return r2;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1337c(android.content.Context r6) {
        /*
            java.lang.Object r0 = f944b
            monitor-enter(r0)
            int r1 = f943a     // Catch:{ all -> 0x0080 }
            r2 = 1
            if (r1 != 0) goto L_0x0078
            if (r6 != 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            return r2
        L_0x000c:
            boolean r1 = m1335a(r6)     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x001c
            java.lang.String r6 = "AnalyticsSwitchHolder"
            java.lang.String r1 = "Builder->biReportSetting :true"
            com.huawei.hms.support.log.HMSLog.m1379i(r6, r1)     // Catch:{ all -> 0x0080 }
            f943a = r2     // Catch:{ all -> 0x0080 }
            goto L_0x0078
        L_0x001c:
            boolean r1 = m1336b(r6)     // Catch:{ all -> 0x0080 }
            r3 = 2
            if (r1 == 0) goto L_0x002d
            java.lang.String r6 = "AnalyticsSwitchHolder"
            java.lang.String r1 = "Builder->biSetting :true"
            com.huawei.hms.support.log.HMSLog.m1379i(r6, r1)     // Catch:{ all -> 0x0080 }
            f943a = r3     // Catch:{ all -> 0x0080 }
            goto L_0x0078
        L_0x002d:
            java.lang.String r1 = "CN"
            com.huawei.hms.framework.network.grs.GrsApp r4 = com.huawei.hms.framework.network.grs.GrsApp.getInstance()     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.getIssueCountryCode(r6)     // Catch:{ all -> 0x0080 }
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0040
            f943a = r2     // Catch:{ all -> 0x0080 }
            goto L_0x0078
        L_0x0040:
            java.lang.String r1 = "AnalyticsSwitchHolder"
            java.lang.String r4 = "not ChinaROM"
            com.huawei.hms.support.log.HMSLog.m1379i(r1, r4)     // Catch:{ all -> 0x0080 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x006f }
            java.lang.String r1 = "hw_app_analytics_state"
            int r6 = android.provider.Settings.Secure.getInt(r6, r1)     // Catch:{ SettingNotFoundException -> 0x006f }
            java.lang.String r1 = "AnalyticsSwitchHolder"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SettingNotFoundException -> 0x006f }
            r4.<init>()     // Catch:{ SettingNotFoundException -> 0x006f }
            java.lang.String r5 = "hw_app_analytics_state value is "
            r4.append(r5)     // Catch:{ SettingNotFoundException -> 0x006f }
            r4.append(r6)     // Catch:{ SettingNotFoundException -> 0x006f }
            java.lang.String r4 = r4.toString()     // Catch:{ SettingNotFoundException -> 0x006f }
            com.huawei.hms.support.log.HMSLog.m1379i(r1, r4)     // Catch:{ SettingNotFoundException -> 0x006f }
            if (r6 != r2) goto L_0x006c
            f943a = r2     // Catch:{ SettingNotFoundException -> 0x006f }
            goto L_0x0078
        L_0x006c:
            f943a = r3     // Catch:{ SettingNotFoundException -> 0x006f }
            goto L_0x0078
        L_0x006f:
            java.lang.String r6 = "AnalyticsSwitchHolder"
            java.lang.String r1 = "Get OOBE failed"
            com.huawei.hms.support.log.HMSLog.m1379i(r6, r1)     // Catch:{ all -> 0x0080 }
            f943a = r3     // Catch:{ all -> 0x0080 }
        L_0x0078:
            int r6 = f943a     // Catch:{ all -> 0x0080 }
            if (r6 == r2) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r2 = 0
        L_0x007e:
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            return r2
        L_0x0080:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.stats.C0898a.m1337c(android.content.Context):boolean");
    }
}
