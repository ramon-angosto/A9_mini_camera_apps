package com.huawei.updatesdk.p025a.p026a.p031d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.Key;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

/* renamed from: com.huawei.updatesdk.a.a.d.g */
public abstract class C0975g {
    /* renamed from: a */
    public static String m1702a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, Key.STRING_CHARSET_NAME).replace("+", "%20").replace("*", "%2A").replace(Constants.WAVE_SEPARATOR, "%7E");
        } catch (UnsupportedEncodingException e) {
            C0968a.m1681a("StringUtils", "encode2utf8 error", e);
            return null;
        }
    }

    /* renamed from: a */
    public static String m1703a(byte[] bArr) {
        String str;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            StringBuilder sb = new StringBuilder(256);
            for (byte b : instance.digest()) {
                sb.append(String.format(Locale.ENGLISH, "%02X", new Object[]{Byte.valueOf(b)}));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            str = "sha256EncryptStr error:NoSuchAlgorithmException";
            C0968a.m1682b("StringUtils", str);
            return null;
        } catch (IllegalFormatException unused2) {
            str = "sha256EncryptStr error:IllegalFormatException";
            C0968a.m1682b("StringUtils", str);
            return null;
        } catch (Exception unused3) {
            str = "sha256EncryptStr error:Exception";
            C0968a.m1682b("StringUtils", str);
            return null;
        }
    }

    /* renamed from: b */
    public static String m1704b(String str) {
        String e = m1707e(str);
        if (e == null) {
            return null;
        }
        return e.toLowerCase(Locale.getDefault());
    }

    /* renamed from: c */
    public static byte[] m1705c(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i] = Byte.valueOf(String.valueOf(digit)).byteValue();
        }
        return bArr;
    }

    /* renamed from: d */
    public static boolean m1706d(String str) {
        return str != null && str.trim().startsWith("{") && str.trim().endsWith("}");
    }

    /* renamed from: e */
    public static String m1707e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return m1703a(str.getBytes(Key.STRING_CHARSET_NAME));
        } catch (UnsupportedEncodingException unused) {
            C0968a.m1682b("StringUtils", "can not getBytes");
            return null;
        }
    }
}
