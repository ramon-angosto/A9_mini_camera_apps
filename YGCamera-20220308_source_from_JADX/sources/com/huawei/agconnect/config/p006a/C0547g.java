package com.huawei.agconnect.config.p006a;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.agconnect.config.a.g */
public class C0547g {
    /* renamed from: a */
    public static SecretKey m59a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bArr.length == 16 && bArr2.length == 16 && bArr3.length == 16) {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(C0545e.m55a(m62a(bArr, bArr2, bArr3)).toCharArray(), bArr4, 5000, 128)).getEncoded(), "AES");
        }
        throw new IllegalArgumentException("invalid data for generating the key.");
    }

    /* renamed from: a */
    private static byte[] m60a(byte[] bArr, int i) {
        if (bArr != null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (i < 0) {
                    bArr[i2] = (byte) (bArr[i2] << (-i));
                } else {
                    bArr[i2] = (byte) (bArr[i2] >> i);
                }
            }
            return bArr;
        }
        throw new NullPointerException("bytes must not be null.");
    }

    /* renamed from: a */
    private static byte[] m61a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        } else if (bArr.length == bArr2.length) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
            }
            return bArr3;
        } else {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
    }

    /* renamed from: a */
    public static byte[] m62a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m61a(m60a(m61a(m60a(bArr, -4), bArr2), 6), bArr3);
    }
}
