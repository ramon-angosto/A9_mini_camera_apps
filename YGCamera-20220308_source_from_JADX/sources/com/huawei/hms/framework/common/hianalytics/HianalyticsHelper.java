package com.huawei.hms.framework.common.hianalytics;

import android.content.Context;
import android.provider.Settings;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class HianalyticsHelper {
    private static final String EVENT_ID = "networkkit_restclient";
    private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
    private static final String TAG = "HianalyticsHelper";
    private static final int TYPE_MAINTF = 1;
    private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    private static final int USER_EXPERIENCE_ON = 1;
    private static volatile HianalyticsHelper instance;
    private HiAnalyticsInstance hInstance = null;
    private String haTag = HWID_HA_SERVICE_TAG;
    private boolean hasHianalytics;
    private ExecutorService reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report_ha");

    private HianalyticsHelper() {
        try {
            HiAnalytics.getInitFlag();
            this.hasHianalytics = true;
        } catch (Throwable unused) {
            Logger.m478w(TAG, "maybe you need add Hianalytics sdk");
            this.hasHianalytics = false;
        }
    }

    public static HianalyticsHelper getInstance() {
        if (instance == null) {
            synchronized (HianalyticsHelper.class) {
                if (instance == null) {
                    instance = new HianalyticsHelper();
                }
            }
        }
        return instance;
    }

    public ExecutorService getReportExecutor() {
        return this.reportExecutor;
    }

    public boolean isEnableReport(Context context) {
        if (!this.hasHianalytics) {
            return false;
        }
        return isEnableReportNoSeed(context);
    }

    public boolean isEnableReportNoSeed(Context context) {
        String str;
        if (!this.hasHianalytics) {
            str = "Hianalytics sdk need to be initialized";
        } else if (context == null) {
            str = "HianalyticsHelper context can't be null";
        } else if (Settings.Secure.getInt(context.getContentResolver(), USER_EXPERIENCE_INVOLVED, -1) != 1) {
            str = "user experience involved needs to be opened";
        } else if (HiAnalytics.getInitFlag()) {
            return true;
        } else {
            if (this.hInstance == null) {
                this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
            }
            return this.hInstance != null;
        }
        Logger.m474i(TAG, str);
        return false;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap) {
        onEvent(linkedHashMap, EVENT_ID);
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str) {
        if (this.hasHianalytics && linkedHashMap != null) {
            Logger.m477v(TAG, "data = %s", linkedHashMap);
            if (HiAnalytics.getInitFlag()) {
                HiAnalytics.onEvent(1, str, linkedHashMap);
                return;
            }
            HiAnalyticsInstance hiAnalyticsInstance = this.hInstance;
            if (hiAnalyticsInstance != null) {
                hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
            }
        }
    }

    public void reportException(final Throwable th, final String str) {
        final String name = Thread.currentThread().getName();
        try {
            this.reportExecutor.submit(new Runnable() {
                public void run() {
                    CrashHianalyticsData crashHianalyticsData = new CrashHianalyticsData();
                    crashHianalyticsData.put(CrashHianalyticsData.THREAD_NAME, name);
                    crashHianalyticsData.put(CrashHianalyticsData.EXCEPTION_NAME, th.getClass().getName());
                    crashHianalyticsData.put(CrashHianalyticsData.MESSAGE, StringUtils.anonymizeMessage(th.getMessage()));
                    crashHianalyticsData.put(CrashHianalyticsData.STACK_TRACE, StringUtils.getTraceInfo(th));
                    HianalyticsHelper.getInstance().onEvent(crashHianalyticsData.get(), str);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.m474i(TAG, "reportException error RejectedExecutionException");
        } catch (Exception unused2) {
            Logger.m475i(TAG, "reportException error!", th);
        }
    }

    public void setHaTag(String str) {
        this.haTag = str;
    }
}
