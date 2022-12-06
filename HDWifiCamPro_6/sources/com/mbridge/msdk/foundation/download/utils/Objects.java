package com.mbridge.msdk.foundation.download.utils;

import java.util.Arrays;

public class Objects {
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
}
