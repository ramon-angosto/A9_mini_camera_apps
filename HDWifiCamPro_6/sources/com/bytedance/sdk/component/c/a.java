package com.bytedance.sdk.component.c;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.utils.l;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES */
public class a {
    private static String a;

    @Deprecated
    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            if (TextUtils.isEmpty(a)) {
                a = a("AES/CBC/PKCS5Padding");
            }
            Cipher instance = Cipher.getInstance(a);
            instance.init(1, secretKeySpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            l.b(th.getMessage());
            return null;
        }
    }

    public static String a(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(instance.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            l.d(th.getMessage());
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return new String(instance.doFinal(decode));
        } catch (Throwable th) {
            l.d(th.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            if (TextUtils.isEmpty(a)) {
                a = a("AES/CBC/PKCS5Padding");
            }
            Cipher instance = Cipher.getInstance(a);
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(decode));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        int[] iArr = new int[str.length()];
        iArr[4] = 6;
        iArr[5] = 1;
        iArr[6] = 1;
        return new String(a(str.getBytes(), iArr));
    }

    public static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr == null || bArr.length == 0 || iArr == null || iArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ iArr[i % iArr.length]);
        }
        return bArr2;
    }
}
