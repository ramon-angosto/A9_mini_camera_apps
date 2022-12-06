package com.xiaomi.push;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.xiaomi.push.i */
public class C1880i {

    /* renamed from: a */
    private static final byte[] f2976a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    /* renamed from: a */
    private static Cipher m3998a(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f2976a);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, ivParameterSpec);
        return instance;
    }

    /* renamed from: a */
    public static byte[] m3999a(byte[] bArr, byte[] bArr2) {
        return m3998a(bArr, 2).doFinal(bArr2);
    }

    /* renamed from: b */
    public static byte[] m4000b(byte[] bArr, byte[] bArr2) {
        return m3998a(bArr, 1).doFinal(bArr2);
    }
}
