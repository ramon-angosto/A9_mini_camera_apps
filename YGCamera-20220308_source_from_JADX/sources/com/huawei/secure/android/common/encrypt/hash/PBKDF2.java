package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class PBKDF2 {

    /* renamed from: A */
    private static final int f1078A = 1000;
    private static final String TAG = PBKDF2.class.getSimpleName();

    /* renamed from: i */
    private static final String f1079i = "";

    /* renamed from: u */
    private static final String f1080u = "PBKDF2WithHmacSHA1";

    /* renamed from: v */
    private static final String f1081v = "PBKDF2WithHmacSHA256";

    /* renamed from: w */
    private static final int f1082w = 8;

    /* renamed from: x */
    private static final int f1083x = 16;

    /* renamed from: y */
    private static final int f1084y = 32;

    /* renamed from: z */
    private static final int f1085z = 10000;

    @Deprecated
    public static String pbkdf2Encrypt(String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, int i) {
        return pbkdf2Encrypt(str, EncryptUtil.generateSecureRandom(8), i, 32);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, byte[] bArr, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            C0932b.m1497f(TAG, "pwd is null.");
            return "";
        } else if (i < 1000) {
            C0932b.m1497f(TAG, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 8) {
            C0932b.m1497f(TAG, "salt parameter is null or length is not enough");
            return "";
        } else if (i2 < 32) {
            C0932b.m1497f(TAG, "cipherLen length is not enough");
            return "";
        } else {
            byte[] pbkdf2 = pbkdf2(str.toCharArray(), bArr, i, i2 * 8);
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2);
        }
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2) {
        return validatePassword(str, str2, 10000);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return m1454b(pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i, 256), HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i, int i2) {
        return m1453a(cArr, bArr, i, i2, false);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) {
            return m1453a(cArr, bArr, i, i2, true);
        }
        C0932b.m1497f(TAG, "system version not high than 26");
        return bArr2;
    }

    /* renamed from: a */
    private static byte[] m1453a(char[] cArr, byte[] bArr, int i, int i2, boolean z) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i, i2);
            if (z) {
                secretKeyFactory = SecretKeyFactory.getInstance(f1081v);
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance(f1080u);
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            String str = TAG;
            C0932b.m1497f(str, "pbkdf exception : " + e.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    private static boolean m1454b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        byte length = bArr.length ^ bArr2.length;
        int i = 0;
        while (i < bArr.length && i < bArr2.length) {
            length |= bArr[i] ^ bArr2[i];
            i++;
        }
        if (length == 0) {
            return true;
        }
        return false;
    }

    public static String pbkdf2EncryptNew(String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static String pbkdf2EncryptNew(String str, int i) {
        return pbkdf2EncryptNew(str, EncryptUtil.generateSecureRandom(16), i, 32);
    }

    public static String pbkdf2EncryptNew(String str, byte[] bArr, int i, int i2) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str)) {
            C0932b.m1497f(TAG, "pwd is null.");
            return "";
        } else if (i < 1000) {
            C0932b.m1497f(TAG, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 16) {
            C0932b.m1497f(TAG, "salt parameter is null or length is not enough");
            return "";
        } else if (i2 < 32) {
            C0932b.m1497f(TAG, "cipherLen length is not enough");
            return "";
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                C0932b.m1495d(TAG, "sha 1");
                bArr2 = pbkdf2(str.toCharArray(), bArr, i, i2 * 8);
            } else {
                C0932b.m1495d(TAG, "sha 256");
                bArr2 = pbkdf2SHA256(str.toCharArray(), bArr, i, i2 * 8);
            }
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(bArr2);
        }
    }

    public static boolean validatePasswordNew(String str, String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    public static boolean validatePasswordNew(String str, String str2, int i) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        String substring2 = str2.substring(32);
        if (Build.VERSION.SDK_INT < 26) {
            bArr = pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i, 256);
        } else {
            bArr = pbkdf2SHA256(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i, 256);
        }
        return m1454b(bArr, HexUtil.hexStr2ByteArray(substring2));
    }
}
