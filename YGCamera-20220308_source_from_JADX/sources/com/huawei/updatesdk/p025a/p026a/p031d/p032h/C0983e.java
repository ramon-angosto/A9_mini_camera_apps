package com.huawei.updatesdk.p025a.p026a.p031d.p032h;

import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.C0964a;

/* renamed from: com.huawei.updatesdk.a.a.d.h.e */
public class C0983e {

    /* renamed from: a */
    private static String f1324a = "";

    /* renamed from: a */
    public static boolean m1750a() {
        if ("KidWatch".equals(f1324a)) {
            return true;
        }
        String a = C0981c.m1727a("ro.vendor.market.type", "");
        f1324a = a;
        C0964a.m1667b("WearDeviceUtil", "Children watch property value is " + a);
        if (!TextUtils.isEmpty(a)) {
            return "KidWatch".equals(a);
        }
        return false;
    }
}
