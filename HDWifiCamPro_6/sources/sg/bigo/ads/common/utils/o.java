package sg.bigo.ads.common.utils;

import android.graphics.Color;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Locale;
import kotlin.UByte;
import sg.bigo.ads.common.k.a;

public final class o {
    public static final SecureRandom a = new SecureRandom();

    public static int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static long a(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return j;
        }
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static String a(String str, String str2) {
        if (b(str) || b(str2)) {
            return !b(str) ? str : !b(str2) ? str2 : "";
        }
        return str + "," + str2;
    }

    public static String a(String str, String str2, String str3, boolean z) {
        if (b(str) || b(str2) || b(str3)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length() - 1;
        while (true) {
            int indexOf = (b(str) || b(str2)) ? -1 : z ? str.toLowerCase().indexOf(str2.toLowerCase()) : str.indexOf(str2);
            if (indexOf != -1) {
                sb.append(str.substring(0, indexOf));
                sb.append(str3);
                str = indexOf < length ? str.substring(indexOf + str2.length()) : "";
            } else {
                sb.append(str);
                return sb.toString();
            }
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & UByte.MAX_VALUE).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static int b(String str, int i) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean c(String str) {
        return !b(str);
    }

    public static boolean d(String str) {
        if (b(str)) {
            return true;
        }
        return b(str.replaceAll("\\s*", ""));
    }

    public static byte[] e(String str) {
        if (b(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
        }
        return bArr;
    }

    public static String f(String str) {
        return b(str) ? str : str.toLowerCase();
    }

    public static String g(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            a.a(0, "StringUtils", "Error encoding url, error message is : " + e.toString());
            return str;
        }
    }

    public static String h(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            a.a(0, "StringUtils", "Error decoding url, error message is : " + e.toString());
            return str;
        }
    }
}
