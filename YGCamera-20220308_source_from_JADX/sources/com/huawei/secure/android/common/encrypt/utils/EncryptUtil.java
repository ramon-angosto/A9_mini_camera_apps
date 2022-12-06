package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

public class EncryptUtil {

    /* renamed from: P */
    private static final String f1119P = "RSA";

    /* renamed from: Q */
    private static boolean f1120Q = false;

    /* renamed from: R */
    private static boolean f1121R = true;
    private static final String TAG = "EncryptUtil";

    /* renamed from: a */
    private static boolean m1476a() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static byte[] generateSecureRandom(int i) {
        if (f1120Q && m1476a()) {
            return m1478b(i);
        }
        try {
            byte[] bArr = new byte[i];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        } catch (Exception e) {
            C0932b.m1497f(TAG, "generate secure random error" + e.getMessage());
            return new byte[0];
        }
    }

    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static SecureRandom genSecureRandom() {
        if (!f1120Q || !m1476a()) {
            return new SecureRandom();
        }
        return m1477b();
    }

    /* renamed from: b */
    private static SecureRandom m1477b() {
        try {
            SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
            AESEngine aESEngine = new AESEngine();
            byte[] bArr = new byte[32];
            instanceStrong.nextBytes(bArr);
            return new SP800SecureRandomBuilder(instanceStrong, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
        } catch (NoSuchAlgorithmException unused) {
            C0932b.m1497f(TAG, "NoSuchAlgorithmException");
            return new SecureRandom();
        } catch (Throwable th) {
            if (f1121R) {
                C0932b.m1497f(TAG, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                f1121R = false;
            }
            return new SecureRandom();
        }
    }

    /* renamed from: b */
    private static byte[] m1478b(int i) {
        C0932b.m1494c(TAG, "generateSecureRandomNew ");
        SecureRandom b = m1477b();
        if (b == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        b.nextBytes(bArr);
        return bArr;
    }

    public static boolean isBouncycastleFlag() {
        return f1120Q;
    }

    public static void setBouncycastleFlag(boolean z) {
        C0932b.m1495d(TAG, "setBouncycastleFlag: " + z);
        f1120Q = z;
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f1119P).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                C0932b.m1497f(TAG, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            C0932b.m1497f(TAG, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            C0932b.m1497f(TAG, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(f1119P).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                C0932b.m1497f(TAG, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            C0932b.m1497f(TAG, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            C0932b.m1497f(TAG, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }
}
