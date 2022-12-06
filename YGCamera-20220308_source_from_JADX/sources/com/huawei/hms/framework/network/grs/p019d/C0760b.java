package com.huawei.hms.framework.network.grs.p019d;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.framework.network.grs.d.b */
public class C0760b {

    /* renamed from: a */
    private static final String f578a = "b";

    /* renamed from: b */
    private static final Pattern f579b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    public static String m667a(String str) {
        return m668a(str, "SHA-256");
    }

    /* renamed from: a */
    private static String m668a(String str, String str2) {
        String str3;
        String str4;
        try {
            try {
                return m669a(MessageDigest.getInstance(str2).digest(str.getBytes(Key.STRING_CHARSET_NAME)));
            } catch (NoSuchAlgorithmException unused) {
                str3 = f578a;
                str4 = "encrypt NoSuchAlgorithmException";
                Logger.m478w(str3, str4);
                return null;
            }
        } catch (UnsupportedEncodingException unused2) {
            str3 = f578a;
            str4 = "encrypt UnsupportedEncodingException";
            Logger.m478w(str3, str4);
            return null;
        }
    }

    /* renamed from: a */
    private static String m669a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m670b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            String str2 = str.charAt(i2) + "";
            if (f579b.matcher(str2).matches()) {
                if (i % 2 == 0) {
                    str2 = "*";
                }
                i++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }
}
