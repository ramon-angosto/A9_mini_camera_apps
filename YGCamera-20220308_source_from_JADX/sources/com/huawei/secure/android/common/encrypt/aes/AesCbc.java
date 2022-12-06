package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesCbc {
    private static final String TAG = AesCbc.class.getSimpleName();

    /* renamed from: f */
    private static final String f1051f = "security:";

    /* renamed from: g */
    private static final String f1052g = "AES/CBC/PKCS5Padding";

    /* renamed from: h */
    private static final String f1053h = "AES";

    /* renamed from: i */
    private static final String f1054i = "";

    /* renamed from: j */
    private static final int f1055j = 16;

    /* renamed from: k */
    private static final int f1056k = 16;

    private AesCbc() {
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0932b.m1497f(TAG, "cbc encrypt param is not right");
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
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0932b.m1497f(TAG, "content or key is null");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return decrypt(str, hexStr2ByteArray);
        }
        C0932b.m1497f(TAG, "key length is not right");
        return "";
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16) {
            C0932b.m1497f(TAG, "cbc encrypt param is not right");
            return "";
        }
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        byte[] a = m1432a(str, bArr, generateSecureRandom);
        if (a == null || a.length == 0) {
            return "";
        }
        return m1431a(HexUtil.byteArray2HexStr(generateSecureRandom), HexUtil.byteArray2HexStr(a));
    }

    public static String decrypt(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String a = m1430a(str);
            String b = m1435b(str);
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(b)) {
                return decrypt(b, bArr, HexUtil.hexStr2ByteArray(a));
            }
            C0932b.m1497f(TAG, "ivParameter or encrypedWord is null");
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C0932b.m1497f(TAG, "cbc encrypt param is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && hexStr2ByteArray2.length >= 16) {
            return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        C0932b.m1497f(TAG, "key length or ivParameter length is not right");
        return "";
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C0932b.m1497f(TAG, "cbc decrypt param is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && hexStr2ByteArray2.length >= 16) {
            return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        C0932b.m1497f(TAG, "key length or ivParameter is not right");
        return "";
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 16) {
            return HexUtil.byteArray2HexStr(m1432a(str, bArr, bArr2));
        }
        C0932b.m1497f(TAG, "cbc encrypt param is not right");
        return "";
    }

    /* renamed from: a */
    private static byte[] m1432a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C0932b.m1497f(TAG, "cbc encrypt param is not right");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes(Key.STRING_CHARSET_NAME), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, " cbc encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 16) {
            C0932b.m1497f(TAG, "cbc decrypt param is not right");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, " cbc decrypt data error" + e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    private static String m1431a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e) {
                String str3 = TAG;
                C0932b.m1497f(str3, "mix exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 16) {
            C0932b.m1497f(TAG, "cbc encrypt param is not right");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f1053h);
        try {
            Cipher instance = Cipher.getInstance(f1052g);
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            String str = TAG;
            C0932b.m1497f(str, "NoSuchAlgorithmException: " + e.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e2) {
            String str2 = TAG;
            C0932b.m1497f(str2, "NoSuchPaddingException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            String str3 = TAG;
            C0932b.m1497f(str3, "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e4) {
            String str4 = TAG;
            C0932b.m1497f(str4, "InvalidAlgorithmParameterException: " + e4.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e5) {
            String str5 = TAG;
            C0932b.m1497f(str5, "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (BadPaddingException e6) {
            String str6 = TAG;
            C0932b.m1497f(str6, "BadPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 16) {
            C0932b.m1497f(TAG, "cbc decrypt param is not right");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f1053h);
        try {
            Cipher instance = Cipher.getInstance(f1052g);
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            String str = TAG;
            C0932b.m1497f(str, "NoSuchAlgorithmException: " + e.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e2) {
            String str2 = TAG;
            C0932b.m1497f(str2, "NoSuchPaddingException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            String str3 = TAG;
            C0932b.m1497f(str3, "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e4) {
            String str4 = TAG;
            C0932b.m1497f(str4, "InvalidAlgorithmParameterException: " + e4.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e5) {
            String str5 = TAG;
            C0932b.m1497f(str5, "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (BadPaddingException e6) {
            String str6 = TAG;
            C0932b.m1497f(str6, "BadPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        return m1434a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(m1436b(bArr), bArr2, m1433a(bArr));
    }

    /* renamed from: a */
    private static byte[] m1434a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    private static byte[] m1433a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    /* renamed from: b */
    private static byte[] m1436b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    /* renamed from: a */
    private static String m1430a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "getIv exception : " + e.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    private static String m1435b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "get encryptword exception : " + e.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    static String m1437c(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf(f1051f) != -1) {
            return str.substring(9);
        }
        return "";
    }

    /* renamed from: c */
    static byte[] m1438c(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "stripCryptHead: exception : " + e.getMessage());
            str = "";
        }
        if (!str.startsWith(f1051f)) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[(bArr.length - 9)];
        System.arraycopy(bArr, 9, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c = m1437c(str);
            if ("".equals(c)) {
                return "";
            }
            int indexOf = c.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c.substring(0, indexOf)));
            }
            C0932b.m1497f(TAG, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException unused) {
            C0932b.m1497f(TAG, "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] c = m1438c(bArr);
        if (c.length == 0) {
            return new byte[0];
        }
        int d = m1439d(c);
        if (d >= 0) {
            byte[] copyOf = Arrays.copyOf(c, d);
            int length = (c.length - copyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(c, d + 1, bArr3, 0, length);
            return decrypt(bArr3, bArr2, copyOf);
        }
        C0932b.m1497f(TAG, " cbc cipherText data missing colon");
        return new byte[0];
    }

    /* renamed from: d */
    private static int m1439d(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }
}
