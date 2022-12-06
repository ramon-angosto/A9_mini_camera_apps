package com.meizu.cloud.pushsdk.common.b;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.common.b.e;

class d {
    private static e.c<String> a;

    public static synchronized e.c<String> a() {
        e.c<String> cVar;
        synchronized (d.class) {
            if (a == null) {
                a = new e.c<>();
            }
            if (!a.a || TextUtils.isEmpty((CharSequence) a.b)) {
                a = e.a("android.telephony.MzTelephonyManager").b("getDeviceId").a();
            }
            cVar = a;
        }
        return cVar;
    }
}
