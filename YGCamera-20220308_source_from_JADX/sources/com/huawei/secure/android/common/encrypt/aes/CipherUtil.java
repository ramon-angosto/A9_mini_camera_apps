package com.huawei.secure.android.common.encrypt.aes;

import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherUtil {
    private static final String TAG = "CipherUtil";

    /* renamed from: g */
    private static final String f1064g = "AES/CBC/PKCS5Padding";

    /* renamed from: h */
    private static final String f1065h = "AES";

    /* renamed from: i */
    private static final String f1066i = "";

    /* renamed from: k */
    private static final int f1067k = 16;

    /* renamed from: l */
    private static final String f1068l = "AES/GCM/NoPadding";

    /* renamed from: m */
    private static final int f1069m = 16;

    /* renamed from: n */
    private static final int f1070n = 12;

    public static Cipher getAesGcmEncryptCipher(byte[] bArr) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        C0932b.m1494c(TAG, "getEncryptCipher: iv is : " + HexUtil.byteArray2HexStr(generateSecureRandom));
        return getAesGcmEncryptCipher(bArr, generateSecureRandom);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesGcmEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(12));
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesGcmDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr) {
        return getAesCbcEncryptCipher(bArr, EncryptUtil.generateSecureRandom(16));
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesCbcEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesCbcDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr, byte[] bArr2) {
        return m1448a(bArr, bArr2, 1);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m1447a(getAesGcmEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, byte[] bArr2) {
        return m1448a(bArr, bArr2, 2);
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr, byte[] bArr2) {
        return m1450b(bArr, bArr2, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m1447a(getAesCbcEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, byte[] bArr2) {
        return m1450b(bArr, bArr2, 2);
    }

    /* renamed from: a */
    private static Cipher m1448a(byte[] bArr, byte[] bArr2, int i) {
        return m1449a(bArr, bArr2, i, f1068l);
    }

    /* renamed from: b */
    private static Cipher m1450b(byte[] bArr, byte[] bArr2, int i) {
        return m1449a(bArr, bArr2, i, f1064g);
    }

    /* renamed from: a */
    private static Cipher m1449a(byte[] bArr, byte[] bArr2, int i, String str) {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !AesGcm.isBuildVersionHigherThan19()) {
            C0932b.m1497f(TAG, "gcm encrypt param is not right");
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f1065h);
            Cipher instance = Cipher.getInstance(str);
            if (f1068l.equals(str)) {
                algorithmParameterSpec = AesGcm.getGcmAlgorithmParams(bArr2);
            } else {
                algorithmParameterSpec = new IvParameterSpec(bArr2);
            }
            instance.init(i, secretKeySpec, algorithmParameterSpec);
            return instance;
        } catch (GeneralSecurityException e) {
            C0932b.m1497f(TAG, "GCM encrypt data error" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static int m1447a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }

    public static int getContent(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher == null || bArr == null) {
            C0932b.m1497f(TAG, "getEncryptCOntent: cipher is null or content is null");
            return -1;
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length, bArr2);
        } catch (BadPaddingException unused) {
            C0932b.m1497f(TAG, "getContent: BadPaddingException");
            return -1;
        } catch (IllegalBlockSizeException unused2) {
            C0932b.m1497f(TAG, "getContent: IllegalBlockSizeException");
            return -1;
        } catch (ShortBufferException unused3) {
            C0932b.m1497f(TAG, "getContent: ShortBufferException");
            return -1;
        }
    }

    public static byte[] getContent(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            C0932b.m1497f(TAG, "getEncryptCOntent: cipher is null or content is null");
            return new byte[0];
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length);
        } catch (BadPaddingException unused) {
            C0932b.m1497f(TAG, "getContent: BadPaddingException");
            return new byte[0];
        } catch (IllegalBlockSizeException unused2) {
            C0932b.m1497f(TAG, "getContent: IllegalBlockSizeException");
            return new byte[0];
        }
    }
}
