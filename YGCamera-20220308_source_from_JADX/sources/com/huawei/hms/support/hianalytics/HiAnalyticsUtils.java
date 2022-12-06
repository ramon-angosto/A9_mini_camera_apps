package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.C0898a;
import com.huawei.hms.stats.C0899b;
import com.huawei.hms.stats.C0900c;
import com.huawei.hms.support.log.HMSLog;
import java.util.LinkedHashMap;
import java.util.Map;

public class HiAnalyticsUtils {

    /* renamed from: c */
    public static final Object f983c = new Object();

    /* renamed from: d */
    public static final Object f984d = new Object();

    /* renamed from: e */
    public static HiAnalyticsUtils f985e;

    /* renamed from: a */
    public int f986a = 0;

    /* renamed from: b */
    public boolean f987b = C0900c.m1342a();

    /* renamed from: a */
    public static LinkedHashMap<String, String> m1369a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (String next : map.keySet()) {
            linkedHashMap.put(next, map.get(next));
        }
        return linkedHashMap;
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f983c) {
            if (f985e == null) {
                f985e = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = f985e;
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.m1379i("HiAnalyticsUtils", "Enable Log");
        if (!this.f987b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HiAnalyticTools.enableLog(context);
        }
    }

    public boolean getInitFlag() {
        if (!this.f987b) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public boolean hasError(Context context) {
        return C0898a.m1337c(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        if (!hasError(context) && context != null) {
            onEvent2(context, str, str2);
        }
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        if (!hasError(context) && map != null && !map.isEmpty() && context != null && getInitFlag()) {
            if (!this.f987b) {
                HmsHiAnalyticsUtils.onEvent(0, str, m1369a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, m1369a(map));
            } else {
                C0899b.m1340a(context, 0, str, m1369a(map));
                C0899b.m1340a(context, 1, str, m1369a(map));
            }
            mo14550a(context);
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        if (hasError(context) || context == null || !getInitFlag()) {
            return;
        }
        if (!this.f987b) {
            HmsHiAnalyticsUtils.onEvent(context, str, str2);
        } else {
            C0899b.m1341a(context, str, str2);
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        if (!hasError(context) && map != null && !map.isEmpty() && context != null && getInitFlag()) {
            if (!this.f987b) {
                HmsHiAnalyticsUtils.onEvent(0, str, m1369a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onEvent(1, str, m1369a((Map<String, String>) map));
            } else {
                C0899b.m1340a(context, 0, str, m1369a((Map<String, String>) map));
                C0899b.m1340a(context, 1, str, m1369a((Map<String, String>) map));
            }
            mo14550a(context);
        }
    }

    public void onReport(Context context, String str, Map map) {
        if (hasError(context) || map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (!this.f987b) {
            HmsHiAnalyticsUtils.onEvent(0, str, m1369a((Map<String, String>) map));
            HmsHiAnalyticsUtils.onEvent(1, str, m1369a((Map<String, String>) map));
            HmsHiAnalyticsUtils.onReport();
            return;
        }
        C0899b.m1340a(context, 0, str, m1369a((Map<String, String>) map));
        C0899b.m1340a(context, 1, str, m1369a((Map<String, String>) map));
        C0899b.m1339a(context, 0);
        C0899b.m1339a(context, 1);
    }

    /* renamed from: a */
    public final void mo14550a(Context context) {
        synchronized (f984d) {
            if (this.f986a < 60) {
                this.f986a++;
            } else {
                this.f986a = 0;
                if (!this.f987b) {
                    HmsHiAnalyticsUtils.onReport();
                } else {
                    C0899b.m1339a(context, 0);
                    C0899b.m1339a(context, 1);
                }
            }
        }
    }

    public void enableLog() {
        HMSLog.m1379i("HiAnalyticsUtils", "Enable Log");
        if (!this.f987b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.m1379i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    public void onReport(Context context, String str, Map map, int i) {
        if (!hasError(context)) {
            if (i != 0 && i != 1) {
                HMSLog.m1377e("HiAnalyticsUtils", "Data reporting type is not supported");
            } else if (map != null && !map.isEmpty() && context != null && getInitFlag()) {
                if (!this.f987b) {
                    HmsHiAnalyticsUtils.onEvent(i, str, m1369a((Map<String, String>) map));
                    HmsHiAnalyticsUtils.onReport();
                    return;
                }
                C0899b.m1340a(context, i, str, m1369a((Map<String, String>) map));
                C0899b.m1339a(context, i);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i) {
        if (!hasError(context)) {
            if (i != 0 && i != 1) {
                HMSLog.m1377e("HiAnalyticsUtils", "Data reporting type is not supported");
            } else if (map != null && !map.isEmpty() && context != null && getInitFlag()) {
                if (!this.f987b) {
                    HmsHiAnalyticsUtils.onEvent(i, str, m1369a((Map<String, String>) map));
                } else {
                    C0899b.m1340a(context, i, str, m1369a((Map<String, String>) map));
                }
                mo14550a(context);
            }
        }
    }
}
