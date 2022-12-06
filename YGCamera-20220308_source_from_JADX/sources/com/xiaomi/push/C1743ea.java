package com.xiaomi.push;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.ea */
public class C1743ea extends C1741dz {
    public C1743ea(Context context, int i) {
        super(context, i);
    }

    /* renamed from: a */
    public C1870hq mo16986a() {
        return C1870hq.Storage;
    }

    /* renamed from: a */
    public String m3079a() {
        return "23";
    }

    /* renamed from: b */
    public String mo17404b() {
        return "ram:" + C1907j.m4548a() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + C1907j.m4560b() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "ramOriginal:" + C1907j.m4566c() + Constants.ACCEPT_TIME_SEPARATOR_SP + "romOriginal:" + C1907j.m4571d();
    }
}
