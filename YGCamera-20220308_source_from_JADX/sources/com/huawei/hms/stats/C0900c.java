package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.stats.c */
/* compiled from: HianalyticsExist */
public class C0900c {

    /* renamed from: a */
    public static final Object f946a = new Object();

    /* renamed from: b */
    public static boolean f947b = false;

    /* renamed from: c */
    public static boolean f948c = false;

    /* renamed from: a */
    public static boolean m1342a() {
        boolean z;
        synchronized (f946a) {
            if (!f947b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    HMSLog.m1379i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    HMSLog.m1379i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    f948c = true;
                }
                f947b = true;
                HMSLog.m1379i("HianalyticsExist", "hianalytics exist: " + f948c);
            }
        }
        return f948c;
    }
}
