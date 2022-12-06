package com.huawei.android.pushagent.c.a.a;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public final class b {
    public static byte[] a(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return a(bArr, i, bArr2, i2, 0);
    }

    private static byte[] a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        if (i <= 0 || i > bArr.length) {
            i = bArr.length;
        }
        if (i2 <= 0 || i2 > bArr2.length) {
            i2 = bArr2.length;
        }
        if (i2 > 16) {
            i2 = 16;
        }
        byte[] bArr3 = new byte[16];
        for (int i4 = 0; i4 < 16; i4++) {
            bArr3[i4] = 0;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            bArr3[i5] = bArr2[i5];
        }
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(i3 == 0 ? 1 : 2, new SecretKeySpec(bArr3, 0, 16, "AES"));
        return instance.doFinal(bArr, 0, i);
    }

    public static byte[] b(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return a(bArr, i, bArr2, i2, 1);
    }
}
