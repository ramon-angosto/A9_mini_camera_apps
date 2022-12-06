package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;
import java.util.Map;

/* renamed from: com.huawei.hms.support.hianalytics.b */
/* compiled from: HiAnalyticsInnerClient */
public class C0917b extends C0916a {
    /* renamed from: a */
    public static void m1372a(Context context, String str, String str2, String str3, String str4) {
        Map<String, String> mapForBi = C0916a.getMapForBi(context, str);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = TransactionIdCreater.getId(str2, str);
        }
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, str3);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        if (!TextUtils.isEmpty(str4)) {
            mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(str4));
        }
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapForBi);
    }

    /* renamed from: a */
    public static void m1371a(Context context, ResponseHeader responseHeader, String str) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        if (!TextUtils.isEmpty(str)) {
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(str));
        }
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapFromRequestHeader);
    }
}
