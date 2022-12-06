package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* renamed from: com.huawei.hms.opendevice.t */
/* compiled from: StringUtils */
public class C0868t {
    /* renamed from: a */
    public static boolean m1190a(String... strArr) {
        for (String isEmpty : strArr) {
            if (TextUtils.isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }
}
