package com.huawei.android.pushagent.c;

public class g {
    private static final String[] a = {"com.huawei.android.push.intent.DEREGISTER", "android.intent.action.TIME_SET", "android.intent.action.TIMEZONE_CHANGED", "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT", "com.huawei.intent.action.PUSH_OFF", "com.huawei.action.CONNECT_PUSHSRV", "com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV", "com.huawei.android.push.intent.GET_PUSH_STATE", "android.ctrlsocket.all.allowed", "android.scroff.ctrlsocket.status"};

    public static String[] a() {
        String[] strArr = a;
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }
}
