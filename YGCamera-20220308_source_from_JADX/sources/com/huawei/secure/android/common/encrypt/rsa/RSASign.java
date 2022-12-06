package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.keystore.rsa.RSASignKS;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public abstract class RSASign {
    private static final String CHARSET = "UTF-8";

    /* renamed from: L */
    private static final String f1113L = "SHA256WithRSA/PSS";
    private static final String TAG = RSASign.class.getSimpleName();

    /* renamed from: i */
    private static final String f1114i = "";

    /* renamed from: s */
    private static final String f1115s = "SHA256WithRSA";

    @Deprecated
    public static String sign(String str, String str2) {
        return m1468a(str, str2, false);
    }

    public static String newSign(String str, String str2) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return m1468a(str, str2, true);
        }
        C0932b.m1497f(TAG, "sdk version is too low");
        return "";
    }

    /* renamed from: a */
    private static String m1468a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0932b.m1497f(TAG, "sign content or key is null");
            return "";
        }
        PrivateKey privateKey = EncryptUtil.getPrivateKey(str2);
        if (z) {
            return newSign(str, privateKey);
        }
        return sign(str, privateKey);
    }

    @Deprecated
    public static String sign(String str, PrivateKey privateKey) {
        return m1469a(str, privateKey, false);
    }

    public static String newSign(String str, PrivateKey privateKey) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return m1469a(str, privateKey, true);
        }
        C0932b.m1497f(TAG, "sdk version is too low");
        return "";
    }

    /* renamed from: a */
    private static String m1469a(String str, PrivateKey privateKey, boolean z) {
        try {
            return Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z), 0);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "sign UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            C0932b.m1497f(TAG, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        if (z) {
            try {
                signature = Signature.getInstance(f1113L);
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (NoSuchAlgorithmException e) {
                String str = TAG;
                C0932b.m1497f(str, "sign NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (InvalidKeyException e2) {
                String str2 = TAG;
                C0932b.m1497f(str2, "sign InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (SignatureException e3) {
                String str3 = TAG;
                C0932b.m1497f(str3, "sign SignatureException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e4) {
                String str4 = TAG;
                C0932b.m1497f(str4, "sign InvalidAlgorithmParameterException: " + e4.getMessage());
                return bArr2;
            } catch (Exception e5) {
                String str5 = TAG;
                C0932b.m1497f(str5, "sign Exception: " + e5.getMessage());
                return bArr2;
            }
        } else {
            signature = Signature.getInstance(f1115s);
        }
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        return m1470a(str, str2, str3, false);
    }

    public static boolean newVerifySign(String str, String str2, String str3) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return m1470a(str, str2, str3, true);
        }
        C0932b.m1497f(TAG, "sdk version is too low");
        return false;
    }

    /* renamed from: a */
    private static boolean m1470a(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            C0932b.m1497f(TAG, "content or public key or sign value is null");
            return false;
        }
        RSAPublicKey publicKey = EncryptUtil.getPublicKey(str3);
        if (z) {
            return newVerifySign(str, str2, (PublicKey) publicKey);
        }
        return verifySign(str, str2, (PublicKey) publicKey);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, PublicKey publicKey) {
        return m1471a(str, str2, publicKey, false);
    }

    public static boolean newVerifySign(String str, String str2, PublicKey publicKey) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return m1471a(str, str2, publicKey, true);
        }
        C0932b.m1497f(TAG, "sdk version is too low");
        return false;
    }

    /* renamed from: a */
    private static boolean m1471a(String str, String str2, PublicKey publicKey, boolean z) {
        try {
            return verifySign(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            C0932b.m1497f(str3, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            String str4 = TAG;
            C0932b.m1497f(str4, "base64 decode Exception : " + e2.getMessage());
            return false;
        }
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z) {
        Signature signature;
        if (bArr == null || publicKey == null || bArr2 == null || !RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            C0932b.m1497f(TAG, "content or publicKey is null , or length is too short");
            return false;
        }
        if (z) {
            try {
                signature = Signature.getInstance(f1113L);
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (GeneralSecurityException e) {
                String str = TAG;
                C0932b.m1497f(str, "check sign exception: " + e.getMessage());
                return false;
            } catch (Exception e2) {
                String str2 = TAG;
                C0932b.m1497f(str2, "exception : " + e2.getMessage());
                return false;
            }
        } else {
            signature = Signature.getInstance(f1115s);
        }
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
