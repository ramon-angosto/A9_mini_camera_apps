package com.huawei.android.pushagent.c.a.a;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.a.d;
import com.huawei.android.pushagent.c.a.e;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] a = a();
            if (a.length == 0) {
                return "";
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(a, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
            return a(b.a(bArr), b.a(instance.doFinal(str.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException | Exception | IllegalArgumentException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e);
            return null;
        }
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str2.substring(0, 6));
                stringBuffer.append(str.substring(0, 6));
                stringBuffer.append(str2.substring(6, 10));
                stringBuffer.append(str.substring(6, 16));
                stringBuffer.append(str2.substring(10, 16));
                stringBuffer.append(str.substring(16));
                stringBuffer.append(str2.substring(16));
                return stringBuffer.toString();
            } catch (Exception e) {
                e.d("AES128_CBC", e.toString());
            }
        }
        return "";
    }

    private static byte[] a() {
        byte[] c = b.c(d.a());
        byte[] c2 = b.c(d.a());
        return a(a(a(c, c2), b.c("2A57086C86EF54970C1E6EB37BFC72B1")));
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public static String b(String str) {
        String str2 = "aes cbc decrypter data error";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] a = a();
            if (a.length == 0) {
                return "";
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(a, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            String c = c(str);
            String d = d(str);
            if (!TextUtils.isEmpty(c)) {
                if (!TextUtils.isEmpty(d)) {
                    instance.init(2, secretKeySpec, new IvParameterSpec(b.c(c)));
                    return new String(instance.doFinal(b.c(d)), "UTF-8");
                }
            }
            e.b("AES128_CBC", "ivParameter or encrypedWord is null");
            return "";
        } catch (UnsupportedEncodingException | IllegalArgumentException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e = e;
            e.c("AES128_CBC", str2, e);
            return "";
        } catch (Exception e2) {
            e = e2;
            str2 = "aes cbc encrypter data error";
            e.c("AES128_CBC", str2, e);
            return "";
        }
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(6, 12));
            stringBuffer.append(str.substring(16, 26));
            stringBuffer.append(str.substring(32, 48));
            return stringBuffer.toString();
        } catch (Exception e) {
            e.d("AES128_CBC", e.toString());
            return "";
        }
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 6));
            stringBuffer.append(str.substring(12, 16));
            stringBuffer.append(str.substring(26, 32));
            stringBuffer.append(str.substring(48));
            return stringBuffer.toString();
        } catch (Exception e) {
            e.d("AES128_CBC", e.toString());
            return "";
        }
    }
}
