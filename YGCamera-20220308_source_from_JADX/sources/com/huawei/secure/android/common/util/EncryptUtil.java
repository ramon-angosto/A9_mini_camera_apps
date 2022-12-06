package com.huawei.secure.android.common.util;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptUtil {
    private static final String TAG = EncryptUtil.class.getSimpleName();

    /* renamed from: h */
    private static final String f1259h = "RSA";

    @Deprecated
    public static byte[] generateSecureRandom(int i) {
        try {
            byte[] bArr = new byte[i];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        } catch (Exception e) {
            String str = TAG;
            LogsUtil.m1619e(str, "generate secure random error" + e.getMessage(), true);
            return new byte[0];
        }
    }

    @Deprecated
    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    @Deprecated
    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f1259h).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                String str2 = TAG;
                LogsUtil.m1619e(str2, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.m1619e(TAG, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.m1619e(TAG, "base64 decode Exception", true);
            return null;
        }
    }

    @Deprecated
    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(f1259h).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                String str2 = TAG;
                LogsUtil.m1619e(str2, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.m1619e(TAG, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.m1619e(TAG, "base64 decode Exception", true);
            return null;
        }
    }
}
