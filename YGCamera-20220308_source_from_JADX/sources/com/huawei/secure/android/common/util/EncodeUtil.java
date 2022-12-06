package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class EncodeUtil {
    private static final String TAG = EncodeUtil.class.getSimpleName();

    /* renamed from: f */
    private static final char[] f1257f = {',', '.', '-'};

    /* renamed from: g */
    private static final String[] f1258g = new String[256];

    static {
        for (char c = 0; c < 255; c = (char) (c + 1)) {
            if ((c < '0' || c > '9') && ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z'))) {
                f1258g[c] = m1602b(c).intern();
            } else {
                f1258g[c] = null;
            }
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, f1257f);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return m1600a(cArr, str);
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "encode js: " + e.getMessage());
            return "";
        }
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            C0952a aVar = new C0952a(str);
            while (aVar.hasNext()) {
                Character a = m1597a(aVar);
                if (a != null) {
                    sb.append(a);
                } else {
                    sb.append(aVar.mo14818b());
                }
            }
            return sb.toString();
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "decode js: " + e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    private static String m1600a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(m1599a(cArr, Character.valueOf(str.charAt(i))));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m1599a(char[] cArr, Character ch) {
        if (m1601a(ch.charValue(), cArr)) {
            return "" + ch;
        } else if (m1598a(ch.charValue()) == null) {
            return "" + ch;
        } else {
            String hexString = Integer.toHexString(ch.charValue());
            if (ch.charValue() < 256) {
                return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
            }
            return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
    }

    /* renamed from: a */
    private static boolean m1601a(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m1598a(char c) {
        if (c < 255) {
            return f1258g[c];
        }
        return m1602b(c);
    }

    /* renamed from: b */
    private static String m1602b(char c) {
        return Integer.toHexString(c);
    }

    /* renamed from: a */
    private static Character m1597a(C0952a aVar) {
        aVar.mo14823f();
        Character b = aVar.mo14818b();
        if (b == null) {
            aVar.reset();
            return null;
        } else if (b.charValue() != '\\') {
            aVar.reset();
            return null;
        } else {
            Character b2 = aVar.mo14818b();
            if (b2 == null) {
                aVar.reset();
                return null;
            } else if (b2.charValue() == 'b') {
                return 8;
            } else {
                if (b2.charValue() == 't') {
                    return 9;
                }
                if (b2.charValue() == 'n') {
                    return 10;
                }
                if (b2.charValue() == 'v') {
                    return 11;
                }
                if (b2.charValue() == 'f') {
                    return 12;
                }
                if (b2.charValue() == 'r') {
                    return 13;
                }
                if (b2.charValue() == '\"') {
                    return '\"';
                }
                if (b2.charValue() == '\'') {
                    return '\'';
                }
                if (b2.charValue() == '\\') {
                    return '\\';
                }
                int i = 0;
                if (Character.toLowerCase(b2.charValue()) == 'x') {
                    StringBuilder sb = new StringBuilder();
                    while (i < 2) {
                        Character c = aVar.mo14819c();
                        if (c != null) {
                            sb.append(c);
                            i++;
                        } else {
                            aVar.reset();
                            return null;
                        }
                    }
                    try {
                        int parseInt = Integer.parseInt(sb.toString(), 16);
                        if (Character.isValidCodePoint(parseInt)) {
                            return Character.valueOf((char) parseInt);
                        }
                    } catch (NumberFormatException unused) {
                        aVar.reset();
                        return null;
                    }
                } else if (Character.toLowerCase(b2.charValue()) == 'u') {
                    StringBuilder sb2 = new StringBuilder();
                    while (i < 4) {
                        Character c2 = aVar.mo14819c();
                        if (c2 != null) {
                            sb2.append(c2);
                            i++;
                        } else {
                            aVar.reset();
                            return null;
                        }
                    }
                    try {
                        int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                        if (Character.isValidCodePoint(parseInt2)) {
                            return Character.valueOf((char) parseInt2);
                        }
                    } catch (NumberFormatException unused2) {
                        aVar.reset();
                        return null;
                    }
                } else if (C0952a.m1652c(b2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b2);
                    Character b3 = aVar.mo14818b();
                    if (!C0952a.m1652c(b3)) {
                        aVar.mo14817a(b3);
                    } else {
                        sb3.append(b3);
                        Character b4 = aVar.mo14818b();
                        if (!C0952a.m1652c(b4)) {
                            aVar.mo14817a(b4);
                        } else {
                            sb3.append(b4);
                        }
                    }
                    try {
                        int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                        if (Character.isValidCodePoint(parseInt3)) {
                            return Character.valueOf((char) parseInt3);
                        }
                    } catch (NumberFormatException unused3) {
                        aVar.reset();
                        return null;
                    }
                }
                return b2;
            }
        }
    }
}
