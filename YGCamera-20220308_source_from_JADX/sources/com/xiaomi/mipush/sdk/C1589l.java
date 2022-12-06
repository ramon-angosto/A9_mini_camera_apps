package com.xiaomi.mipush.sdk;

import com.xiaomi.push.C1873ht;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.l */
public class C1589l {

    /* renamed from: a */
    private static HashMap<C1582e, C1590a> f1729a = new HashMap<>();

    /* renamed from: com.xiaomi.mipush.sdk.l$a */
    static class C1590a {

        /* renamed from: a */
        public String f1730a;

        /* renamed from: b */
        public String f1731b;

        public C1590a(String str, String str2) {
            this.f1730a = str;
            this.f1731b = str2;
        }
    }

    static {
        m2451a(C1582e.ASSEMBLE_PUSH_HUAWEI, new C1590a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        m2451a(C1582e.ASSEMBLE_PUSH_FCM, new C1590a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        m2451a(C1582e.ASSEMBLE_PUSH_COS, new C1590a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        m2451a(C1582e.ASSEMBLE_PUSH_FTOS, new C1590a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    /* renamed from: a */
    public static C1575au m2448a(C1582e eVar) {
        int i = C1591m.f1732a[eVar.ordinal()];
        if (i == 1) {
            return C1575au.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return C1575au.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return C1575au.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return C1575au.UPLOAD_FTOS_TOKEN;
    }

    /* renamed from: a */
    public static C1590a m2449a(C1582e eVar) {
        return f1729a.get(eVar);
    }

    /* renamed from: a */
    public static C1873ht m2450a(C1582e eVar) {
        return C1873ht.AggregatePushSwitch;
    }

    /* renamed from: a */
    private static void m2451a(C1582e eVar, C1590a aVar) {
        if (aVar != null) {
            f1729a.put(eVar, aVar);
        }
    }
}
