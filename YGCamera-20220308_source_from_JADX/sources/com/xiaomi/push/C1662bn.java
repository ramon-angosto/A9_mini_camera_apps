package com.xiaomi.push;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.xiaomi.push.bn */
public class C1662bn {
    /* renamed from: a */
    private static String m2723a(byte b) {
        int i = (b & Byte.MAX_VALUE) + (b < 0 ? (byte) 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 16 ? "0" : "");
        sb.append(Integer.toHexString(i).toLowerCase());
        return sb.toString();
    }

    /* renamed from: a */
    public static String m2724a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            for (byte a : digest) {
                stringBuffer.append(m2723a(a));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m2725b(String str) {
        return m2724a(str).subSequence(8, 24).toString();
    }
}
