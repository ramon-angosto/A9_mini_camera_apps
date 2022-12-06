package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.util.SafeString;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";

    public static String anonymizeMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 != 0) {
                charArray[i] = '*';
            }
        }
        return new String(charArray);
    }

    public static String byte2Str(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            Logger.m478w("StringUtils.byte2str error: UnsupportedEncodingException", e);
            return "";
        }
    }

    private static boolean checkCompatible(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (StringUtils.class) {
                IS_AEGIS_STRING_LIBRARY_LOADED = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static byte[] getBytes(long j) {
        return getBytes(String.valueOf(j));
    }

    public static byte[] getBytes(String str) {
        byte[] bArr = new byte[0];
        if (str == null) {
            return bArr;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Logger.m478w(TAG, "the content has error while it is converted to bytes");
            return bArr;
        }
    }

    public static String getTraceInfo(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(1024);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("at ");
            sb.append(stackTraceElement.toString());
            sb.append(";");
        }
        return sb.toString();
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            return SafeString.replace(str, charSequence, charSequence2);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence)) {
            return str;
        }
        try {
            return str.replace(charSequence, charSequence2);
        } catch (Exception unused) {
            return str;
        }
    }

    public static byte[] str2Byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes(Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            Logger.m478w("StringUtils.str2Byte error: UnsupportedEncodingException", e);
            return new byte[0];
        }
    }

    public static boolean strEquals(String str, String str2) {
        return str == str2 || (str != null && str.equals(str2));
    }

    public static int stringToInteger(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            Logger.m479w(TAG, "String to Integer catch NumberFormatException.", (Throwable) e);
            return i;
        }
    }

    public static long stringToLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            Logger.m479w(TAG, "String to Long catch NumberFormatException.", (Throwable) e);
            return j;
        }
    }

    public static String substring(String str, int i) {
        if (checkCompatible(SAFE_STRING_PATH)) {
            return SafeString.substring(str, i);
        }
        if (!TextUtils.isEmpty(str) && str.length() >= i && i >= 0) {
            try {
                return str.substring(i);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String substring(String str, int i, int i2) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            return SafeString.substring(str, i, i2);
        }
        if (!TextUtils.isEmpty(str) && i >= 0 && i2 <= str.length() && i2 >= i) {
            try {
                return str.substring(i, i2);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String toLowerCase(String str) {
        return str == null ? str : str.toLowerCase(Locale.ROOT);
    }
}
