package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;

public class Anonymizer {
    private static final String TAG = Anonymizer.class.getSimpleName();

    public static String maskName(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        return maskCommonString(str, 1, 0);
    }

    public static String maskBirthday(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return C0926a.m1428b(str, '*');
        }
        String[] split = C0926a.split(str, 4);
        return C0926a.m1429b("", C0926a.m1420a(split, 0), C0926a.m1419a(C0926a.m1420a(split, 1), "0123456789", "*"));
    }

    public static String maskBankAccount(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return C0926a.m1428b(str, '*');
        }
        if (str.length() < 11 || str.length() >= 20) {
            return maskCommonString(str, 6, 4);
        }
        return maskCommonString(str, 4, 4);
    }

    public static String maskEmail(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            String[] split = C0926a.split(str, 1);
            return C0926a.m1429b("", C0926a.m1420a(split, 0), C0926a.m1428b(C0926a.m1420a(split, 1), '*'));
        }
        String[] a = C0926a.m1423a(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return C0926a.m1429b("", C0926a.m1428b(C0926a.m1420a(a, 0), '*'), C0926a.m1420a(a, 1), C0926a.m1428b(C0926a.m1420a(a, 2), '*'), C0926a.m1420a(a, 3));
    }

    public static String maskPhone(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return C0926a.m1428b(str, '*');
        }
        if (str.length() < 8 || str.length() >= 11) {
            return maskCommonString(str, 3, 4);
        }
        return maskCommonString(str, 2, 2);
    }

    public static String maskIpV4(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return C0926a.m1428b(str, '*');
        }
        String[] split = C0926a.split(str, lastIndexOf + 1);
        return C0926a.m1429b("", C0926a.m1420a(split, 0), C0926a.m1428b(C0926a.m1420a(split, 1), '*'));
    }

    public static String maskIpV6(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] a = C0926a.m1421a(str, ':');
        if (a.length <= 1) {
            return C0926a.m1428b(str, '*');
        }
        if (a.length != 8) {
            String[] split = C0926a.split(str, str.indexOf(58) + 1);
            return C0926a.m1429b("", C0926a.m1420a(split, 0), C0926a.m1419a(C0926a.m1420a(split, 1), "0123456789ABCDEFabcdef", "*"));
        }
        a[2] = maskLower8Bit(a[2]);
        for (int i = 3; i < a.length; i++) {
            a[i] = C0926a.m1428b(a[i], '*');
        }
        return C0926a.m1429b(Constants.COLON_SEPARATOR, a);
    }

    public static String maskLower8Bit(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "maskLower8Bit: s is null");
            return "";
        } else if (str.length() <= 2) {
            return C0926a.m1428b(str, '*');
        } else {
            String[] split = C0926a.split(str, str.length() - 2);
            return C0926a.m1429b("", C0926a.m1420a(split, 0), C0926a.m1428b(C0926a.m1420a(split, 1), '*'));
        }
    }

    public static String maskId(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 12, 0);
    }

    public static String maskMac(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int a = C0926a.m1418a(str, '-', 2);
        if (a < 0) {
            return C0926a.m1419a(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] split = C0926a.split(str, a);
        return C0926a.m1429b("", C0926a.m1420a(split, 0), C0926a.m1419a(C0926a.m1420a(split, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String maskImeiImsi(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 4, 0);
    }

    public static String maskAccountId(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        if (str.length() < 8) {
            return maskCommonString(str, 0, 1);
        }
        return maskCommonString(str, 0, 4);
    }

    public static String maskCommonString(String str, int i, int i2) {
        int i3;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (str.length() <= i + i2) {
            i3 = str.length() - 1;
            i = 1;
        } else {
            i3 = str.length() - i2;
        }
        String[] a = C0926a.m1422a(str, i, i3);
        return C0926a.m1429b("", C0926a.m1420a(a, 0), C0926a.m1428b(C0926a.m1420a(a, 1), '*'), C0926a.m1420a(a, 2));
    }
}
