package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hms.stats.b */
/* compiled from: HiAnalyticsOfCpUtils */
public class C0899b {

    /* renamed from: a */
    public static HiAnalyticsInstance f945a;

    /* renamed from: a */
    public static HiAnalyticsInstance m1338a(Context context) {
        f945a = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        return f945a;
    }

    /* renamed from: a */
    public static void m1341a(Context context, String str, String str2) {
        if (m1338a(context) != null) {
            f945a.onEvent(context, str, str2);
        }
    }

    /* renamed from: a */
    public static void m1340a(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m1338a(context) != null) {
            f945a.onEvent(i, str, linkedHashMap);
        }
    }

    /* renamed from: a */
    public static void m1339a(Context context, int i) {
        if (m1338a(context) != null) {
            f945a.onReport(i);
        }
    }
}
