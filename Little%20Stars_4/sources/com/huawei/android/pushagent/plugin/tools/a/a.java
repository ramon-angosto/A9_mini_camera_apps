package com.huawei.android.pushagent.plugin.tools.a;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    private SecureRandom a = new SecureRandom();
    private Key b;

    private a() {
    }

    public static a a(byte[] bArr) throws InvalidKeyException, NoSuchAlgorithmException {
        a aVar = new a();
        aVar.b(bArr);
        return aVar;
    }

    private byte[] a(byte[] bArr, Key key, int i) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        if (bArr == null || key == null) {
            return new byte[0];
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        int i2 = 16;
        byte[] bArr2 = new byte[16];
        if (i == 1) {
            c(bArr2);
            i2 = 0;
        } else if (i != 2) {
            return new byte[0];
        } else {
            if (bArr.length <= 16) {
                return new byte[0];
            }
            for (int i3 = 0; i3 < 16; i3++) {
                bArr2[i3] = bArr[i3];
            }
        }
        instance.init(i, key, new IvParameterSpec(bArr2));
        byte[] doFinal = instance.doFinal(bArr, i2, bArr.length - i2);
        if (i != 1) {
            return doFinal;
        }
        byte[] copyOf = Arrays.copyOf(bArr2, bArr2.length + doFinal.length);
        System.arraycopy(doFinal, 0, copyOf, bArr2.length, doFinal.length);
        return copyOf;
    }

    public String a(String str) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return b.b(a(str.getBytes("UTF-8"), this.b, 1));
    }

    public void b(byte[] bArr) {
        if (bArr.length == 16) {
            this.b = new SecretKeySpec(bArr, "AES");
        }
    }

    public void c(byte[] bArr) {
        this.a.nextBytes(bArr);
    }
}
