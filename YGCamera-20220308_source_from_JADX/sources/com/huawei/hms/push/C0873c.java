package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.c */
/* compiled from: BundleUtil */
public class C0873c {
    /* renamed from: a */
    public static byte[] m1216a(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (Exception e) {
            HMSLog.m1379i("BundleUtil", "getByteArray exception" + e.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    public static String m1217b(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            HMSLog.m1379i("BundleUtil", "getString exception" + e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static String m1218c(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (Exception e) {
            HMSLog.m1379i("BundleUtil", "getString exception" + e.getMessage());
            return "";
        }
    }
}
