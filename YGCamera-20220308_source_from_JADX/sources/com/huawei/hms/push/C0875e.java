package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.p022ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.p022ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.e */
/* compiled from: PushAnalyticsUtils */
public class C0875e {

    /* renamed from: a */
    public static final String f876a = "e";

    /* renamed from: a */
    public static void m1221a(Context context, String str, String str2, String str3) {
        PushBaseAnalytics pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics != null) {
            Bundle a = m1220a(context, str, str2);
            String str4 = f876a;
            HMSLog.m1379i(str4, "eventId:" + str3 + ",UserProfiles:" + a.toString());
            pushAnalytics.report(context, str3, a);
        }
    }

    /* renamed from: a */
    public static Bundle m1220a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("sdkVer", String.valueOf(50101300));
        bundle.putString("pkgName", context.getPackageName());
        bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
        PushProxy proxy = ProxyCenter.getProxy();
        if (proxy != null) {
            bundle.putString("proxyType", proxy.getProxyType());
        }
        bundle.putString(RemoteMessageConst.MSGID, str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("analyticInfo", str2);
        }
        return bundle;
    }
}
