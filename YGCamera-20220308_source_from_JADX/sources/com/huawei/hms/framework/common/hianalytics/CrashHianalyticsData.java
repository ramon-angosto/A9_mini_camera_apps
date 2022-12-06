package com.huawei.hms.framework.common.hianalytics;

import android.os.Process;

public class CrashHianalyticsData extends HianalyticsBaseData {
    public static final String EXCEPTION_NAME = "exception_name";
    public static final String MESSAGE = "message";
    public static final String PROCESS_ID = "process_id";
    public static final String STACK_TRACE = "stack_trace";
    public static final String THREAD_ID = "thread_id";
    public static final String THREAD_NAME = "thread_name";
    public static final String TIME = "time";

    public CrashHianalyticsData() {
        put("sdk_name", "Restclient_Crash");
        put(TIME, "" + System.currentTimeMillis());
        put(PROCESS_ID, "" + Process.myPid());
        put(THREAD_ID, "" + Process.myTid());
    }
}
