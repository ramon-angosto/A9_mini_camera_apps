package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.HashMap;
import java.util.Map;

public class HiAnalyticsUtil {

    /* renamed from: a */
    private static final Object f980a = new Object();

    /* renamed from: b */
    private static HiAnalyticsUtil f981b;

    /* renamed from: c */
    private static HiAnalyticsUtils f982c;

    /* renamed from: a */
    private String m1368a(Context context, String str) {
        String packageName = context.getPackageName();
        return "01|" + "" + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + packageName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Util.getAppId(context) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + 50200300 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str;
    }

    public static HiAnalyticsUtil getInstance() {
        HiAnalyticsUtil hiAnalyticsUtil;
        synchronized (f980a) {
            if (f981b == null) {
                f981b = new HiAnalyticsUtil();
                f982c = HiAnalyticsUtils.getInstance();
            }
            hiAnalyticsUtil = f981b;
        }
        return hiAnalyticsUtil;
    }

    public static Map<String, String> getMapFromForegroundResponseHeader(ResponseHeader responseHeader) {
        HashMap hashMap = new HashMap();
        if (responseHeader == null) {
            return hashMap;
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, responseHeader.getTransactionId());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, responseHeader.getActualAppID());
        hashMap.put("service", responseHeader.getSrvName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APINAME, responseHeader.getApiName());
        hashMap.put("package", responseHeader.getPkgName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
        hashMap.put("result", String.valueOf(responseHeader.getErrorCode()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, responseHeader.getErrorReason());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_CALLTMEI, String.valueOf(System.currentTimeMillis()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "5.2.0.300");
        return hashMap;
    }

    public static Map<String, String> getMapFromRequestHeader(ResponseHeader responseHeader) {
        HashMap hashMap = new HashMap();
        if (responseHeader == null) {
            return hashMap;
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, responseHeader.getTransactionId());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, responseHeader.getActualAppID());
        hashMap.put("service", responseHeader.getSrvName());
        String apiName = responseHeader.getApiName();
        if (!TextUtils.isEmpty(apiName)) {
            String[] split = apiName.split("\\.");
            if (split.length >= 2) {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APINAME, split[1]);
            }
        }
        hashMap.put("package", responseHeader.getPkgName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
        hashMap.put("result", String.valueOf(responseHeader.getErrorCode()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, responseHeader.getErrorReason());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_CALLTMEI, String.valueOf(System.currentTimeMillis()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "5.2.0.300");
        return hashMap;
    }

    public static String versionCodeToName(String str) {
        return HiAnalyticsUtils.versionCodeToName(str);
    }

    @Deprecated
    public Map<String, String> getMapForBi(Context context, String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split("\\.");
        if (split.length >= 2) {
            String str2 = split[0];
            String str3 = split[1];
            String appId = Util.getAppId(context);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, TransactionIdCreater.getId(appId, str));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, appId);
            hashMap.put("service", str2);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APINAME, str3);
            hashMap.put("package", context.getPackageName());
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, "5.2.0.300");
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_CALLTMEI, String.valueOf(System.currentTimeMillis()));
        }
        return hashMap;
    }

    public Map<String, String> getMapFromForegroundRequestHeader(RequestHeader requestHeader) {
        HashMap hashMap = new HashMap();
        if (requestHeader == null) {
            return hashMap;
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, requestHeader.getTransactionId());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, requestHeader.getActualAppID());
        hashMap.put("service", requestHeader.getSrvName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APINAME, requestHeader.getApiName());
        hashMap.put("package", requestHeader.getPkgName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_CALLTMEI, String.valueOf(System.currentTimeMillis()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "5.2.0.300");
        return hashMap;
    }

    @Deprecated
    public boolean hasError() {
        if (SystemUtils.isChinaROM()) {
            return false;
        }
        HMSLog.m1379i("HiAnalyticsUtil", "not ChinaROM ");
        return true;
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        f982c.onBuoyEvent(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        f982c.onEvent(context, str, map);
    }

    public void onEvent2(Context context, String str, String str2) {
        f982c.onEvent2(context, str, str2);
    }

    public void onNewEvent(Context context, String str, Map map) {
        f982c.onNewEvent(context, str, map);
    }

    public void onEvent(Context context, String str, String str2) {
        if (context != null) {
            onEvent2(context, str, m1368a(context, str2));
        }
    }

    public boolean hasError(Context context) {
        return f982c.hasError(context);
    }

    public Map<String, String> getMapFromRequestHeader(RequestHeader requestHeader) {
        HashMap hashMap = new HashMap();
        if (requestHeader == null) {
            return hashMap;
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, requestHeader.getTransactionId());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, requestHeader.getActualAppID());
        hashMap.put("service", requestHeader.getSrvName());
        String apiName = requestHeader.getApiName();
        if (!TextUtils.isEmpty(apiName)) {
            String[] split = apiName.split("\\.");
            if (split.length >= 2) {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APINAME, split[1]);
            }
        }
        hashMap.put("package", requestHeader.getPkgName());
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_CALLTMEI, String.valueOf(System.currentTimeMillis()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "5.2.0.300");
        return hashMap;
    }
}
