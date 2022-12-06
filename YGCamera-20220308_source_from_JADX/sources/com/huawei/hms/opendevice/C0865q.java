package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* renamed from: com.huawei.hms.opendevice.q */
/* compiled from: PushBiUtil */
public final class C0865q {
    /* renamed from: a */
    public static String m1180a(Context context, String str) {
        return HiAnalyticsClient.reportEntry(context, str, 50101300);
    }

    /* renamed from: a */
    public static void m1181a(Context context, String str, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 50101300);
    }

    /* renamed from: a */
    public static void m1183a(Context context, String str, String str2, ErrorEnum errorEnum) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 50101300);
    }

    /* renamed from: a */
    public static void m1182a(Context context, String str, String str2, int i) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), i, 50101300);
    }
}
