package com.huawei.android.pushagent.c.a.a;

import android.text.TextUtils;

public class e {
    private static String a(char c, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    public static String a(Object obj) {
        return a(String.valueOf(obj));
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() < 2) {
            return str;
        }
        try {
            double length = (double) (str.length() * 25);
            Double.isNaN(length);
            int ceil = (int) Math.ceil(length / 100.0d);
            double length2 = (double) (str.length() * 50);
            Double.isNaN(length2);
            int ceil2 = (int) Math.ceil(length2 / 100.0d);
            return str.substring(0, ceil) + a('*', ceil2) + str.substring(ceil + ceil2);
        } catch (IndexOutOfBoundsException unused) {
            return "";
        }
    }
}
