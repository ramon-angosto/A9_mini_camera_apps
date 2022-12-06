package com.huawei.secure.android.common.encrypt.aes;

import android.os.Build;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesGcm {
    private static final String TAG = AesGcm.class.getSimpleName();

    /* renamed from: f */
    private static final String f1057f = "security:";

    /* renamed from: h */
    private static final String f1058h = "AES";

    /* renamed from: i */
    private static final String f1059i = "";

    /* renamed from: l */
    private static final String f1060l = "AES/GCM/NoPadding";

    /* renamed from: m */
    private static final int f1061m = 16;

    /* renamed from: n */
    private static final int f1062n = 12;

    /* renamed from: o */
    private static final int f1063o = 2;

    private AesGcm() {
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isBuildVersionHigherThan19()) {
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return encrypt(str, hexStr2ByteArray);
        }
        C0932b.m1497f(TAG, "key length is not right");
        return "";
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isBuildVersionHigherThan19()) {
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return decrypt(str, hexStr2ByteArray);
        }
        C0932b.m1497f(TAG, "key length is not right");
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(12);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encrypt(java.lang.String r3, byte[] r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x003e
            if (r4 == 0) goto L_0x003e
            int r0 = r4.length
            r2 = 16
            if (r0 < r2) goto L_0x003e
            boolean r0 = isBuildVersionHigherThan19()
            if (r0 != 0) goto L_0x0016
            goto L_0x003e
        L_0x0016:
            r0 = 12
            byte[] r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(r0)
            byte[] r3 = m1441a(r3, r4, r0)
            if (r3 == 0) goto L_0x003e
            int r4 = r3.length
            if (r4 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0026:
            java.lang.String r4 = com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr((byte[]) r0)
            java.lang.String r3 = com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr((byte[]) r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.aes.AesGcm.encrypt(java.lang.String, byte[]):java.lang.String");
    }

    public static String decrypt(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && isBuildVersionHigherThan19()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f1058h);
                Cipher instance = Cipher.getInstance(f1060l);
                String a = m1440a(str);
                String b = m1444b(str);
                if (!TextUtils.isEmpty(a)) {
                    if (!TextUtils.isEmpty(b)) {
                        instance.init(2, secretKeySpec, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(a)));
                        return new String(instance.doFinal(HexUtil.hexStr2ByteArray(b)), Key.STRING_CHARSET_NAME);
                    }
                }
                C0932b.m1497f(TAG, "ivParameter or encrypedWord is null");
                return "";
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !isBuildVersionHigherThan19()) {
            C0932b.m1497f(TAG, "gcm encrypt parameter is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && str3.length() >= 12) {
            return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        C0932b.m1497f(TAG, "key length or iv length is not right");
        return "";
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !isBuildVersionHigherThan19()) {
            C0932b.m1497f(TAG, "gcm decrypt param is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && hexStr2ByteArray2.length >= 12) {
            return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        C0932b.m1497f(TAG, "key length or iv length is not right");
        return "";
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 12 && isBuildVersionHigherThan19()) {
            return HexUtil.byteArray2HexStr(m1441a(str, bArr, bArr2));
        }
        C0932b.m1497f(TAG, "gcm encrypt param is not right");
        return "";
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 12 && isBuildVersionHigherThan19()) {
            try {
                return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), Key.STRING_CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    /* renamed from: a */
    private static byte[] m1441a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !isBuildVersionHigherThan19()) {
            C0932b.m1497f(TAG, "gcm encrypt param is not right");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes(Key.STRING_CHARSET_NAME), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 12 || !isBuildVersionHigherThan19()) {
            C0932b.m1497f(TAG, "gcm encrypt param is not right");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f1058h);
            Cipher instance = Cipher.getInstance(f1060l);
            instance.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            String str = TAG;
            C0932b.m1497f(str, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || !isBuildVersionHigherThan19()) {
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f1058h);
            Cipher instance = Cipher.getInstance(f1060l);
            instance.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            String str = TAG;
            C0932b.m1497f(str, "GCM decrypt data exception: " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        return m1443a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(m1445b(bArr), bArr2, m1442a(bArr));
    }

    /* renamed from: a */
    private static byte[] m1443a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    private static byte[] m1442a(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    /* renamed from: b */
    private static byte[] m1445b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 12)];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    /* renamed from: a */
    private static String m1440a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        C0932b.m1497f(TAG, "IV is invalid.");
        return "";
    }

    /* renamed from: b */
    private static String m1444b(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    public static boolean isBuildVersionHigherThan19() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c = AesCbc.m1437c(str);
            if ("".equals(c)) {
                return "";
            }
            int indexOf = c.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c.substring(0, indexOf)));
            }
            C0932b.m1497f(TAG, " gcm cipherText data missing colon");
        }
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException unused) {
            C0932b.m1497f(TAG, "UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] c = AesCbc.m1438c(bArr);
        if (c.length == 0) {
            return new byte[0];
        }
        int d = m1446d(c);
        if (d >= 0) {
            byte[] copyOf = Arrays.copyOf(c, d);
            int length = (c.length - copyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(c, d + 1, bArr3, 0, length);
            return decrypt(bArr3, bArr2, copyOf);
        }
        C0932b.m1497f(TAG, " gcm cipherText data missing colon");
        return new byte[0];
    }

    /* renamed from: d */
    private static int m1446d(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new IvParameterSpec(bArr);
        }
        return new GCMParameterSpec(128, bArr);
    }
}
