package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;

/* compiled from: StringUtils */
public final class x {
    public static boolean a(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str);
    }

    public static boolean b(String str) {
        return str != null && !TextUtils.isEmpty(str.trim()) && !"null".equals(str);
    }
}
