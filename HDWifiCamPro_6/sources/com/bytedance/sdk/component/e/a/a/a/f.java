package com.bytedance.sdk.component.e.a.a.a;

import android.text.TextUtils;
import android.util.Base64;

/* compiled from: ParamEncode */
public class f {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Base64.encodeToString(str.getBytes(), 10);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new String(Base64.decode(str, 10));
    }
}
