package com.huawei.secure.android.common.anonymization;

/* renamed from: com.huawei.secure.android.common.anonymization.a */
public class C0926a {
    /* renamed from: a */
    public static String[] m1427a(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    /* renamed from: a */
    public static String[] m1425a(String str, String[] strArr) {
        return m1427a(new String[]{str}, strArr);
    }

    /* renamed from: a */
    public static String[] m1426a(String[] strArr, String str) {
        return m1427a(strArr, new String[]{str});
    }

    /* renamed from: a */
    public static String[] m1422a(String str, int i, int i2) {
        String[] split = split(str, i);
        return m1425a(m1420a(split, 0), split(m1420a(split, 1), i2 - i));
    }

    /* renamed from: a */
    public static String[] m1423a(String str, int i, int i2, int i3) {
        String[] split = split(str, i);
        return m1425a(m1420a(split, 0), m1422a(m1420a(split, 1), i2 - i, i3 - i));
    }

    /* renamed from: a */
    public static String[] m1424a(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        } else if (iArr.length <= 1) {
            return split(str, iArr[0]);
        } else {
            int i = iArr[0];
            int[] iArr2 = new int[(iArr.length - 1)];
            int i2 = 0;
            while (i2 < iArr2.length) {
                int i3 = i2 + 1;
                iArr2[i2] = iArr[i3] - i;
                i2 = i3;
            }
            String[] split = split(str, i);
            return m1425a(m1420a(split, 0), m1424a(m1420a(split, 1), iArr2));
        }
    }

    public static String[] split(String str, int i) {
        if (str == null) {
            return new String[]{"", ""};
        }
        if (i < 0 || i > str.length()) {
            return new String[]{str, ""};
        }
        return new String[]{str.substring(0, i), str.substring(i)};
    }

    /* renamed from: a */
    public static String[] m1421a(String str, char c) {
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        if (i <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder(str.length());
        int i3 = 0;
        for (int i4 = 0; i4 < str.length() && i3 < i; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == c) {
                strArr[i3] = sb.toString();
                sb.setLength(0);
                i3++;
            } else {
                sb.append(charAt);
            }
        }
        strArr[i3] = sb.toString();
        return strArr;
    }

    /* renamed from: b */
    public static String m1429b(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i] != null) {
                sb.append(str);
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m1419a(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int lastIndexOf = str2.lastIndexOf(c);
            if (lastIndexOf < 0) {
                cArr[i] = c;
            } else {
                cArr[i] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m1420a(String[] strArr, int i) {
        if (strArr == null || strArr.length <= 0 || i < 0 || i >= strArr.length) {
            return "";
        }
        return strArr[i];
    }

    /* renamed from: b */
    public static String m1428b(String str, char c) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        char[] cArr = new char[str.length()];
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = c;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static int m1418a(String str, char c, int i) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c || i - 1 > 0)) {
            length--;
        }
        return length;
    }
}
