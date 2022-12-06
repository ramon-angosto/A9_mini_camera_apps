package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public abstract class RSAEncrypt {
    private static final String CHARSET = "UTF-8";

    /* renamed from: H */
    private static final int f1109H = 2048;

    /* renamed from: K */
    private static final String f1110K = "RSA";
    private static final String TAG = "RSAEncrypt";

    /* renamed from: i */
    private static final String f1111i = "";

    /* renamed from: s */
    private static final String f1112s = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return encrypt(str, (PublicKey) EncryptUtil.getPublicKey(str2));
        }
        C0932b.m1497f(TAG, "content or public key is null");
        return "";
    }

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return decrypt(str, EncryptUtil.getPrivateKey(str2));
        }
        C0932b.m1497f(TAG, "content or private key is null");
        return "";
    }

    public static String encrypt(String str, PublicKey publicKey) {
        if (TextUtils.isEmpty(str) || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            C0932b.m1497f(TAG, "content or PublicKey is null , or length is too short");
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
        } catch (UnsupportedEncodingException unused) {
            C0932b.m1497f(TAG, "encrypt: UnsupportedEncodingException");
            return "";
        } catch (Exception e) {
            C0932b.m1497f(TAG, "exception : " + e.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, PrivateKey privateKey) {
        if (TextUtils.isEmpty(str) || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            C0932b.m1497f(TAG, "content or privateKey is null , or length is too short");
            return "";
        }
        try {
            return new String(decrypt(Base64.decode(str, 0), privateKey), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C0932b.m1497f(TAG, "RSA decrypt exception : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            C0932b.m1497f(TAG, "exception : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            C0932b.m1497f(TAG, "content or PublicKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher instance = Cipher.getInstance(f1112s);
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            C0932b.m1497f(TAG, "RSA encrypt exception : " + e.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            C0932b.m1497f(TAG, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher instance = Cipher.getInstance(f1112s);
            instance.init(2, privateKey);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            C0932b.m1497f(TAG, "RSA decrypt exception : " + e.getMessage());
            return bArr2;
        }
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey rSAPrivateKey) {
        return rSAPrivateKey != null && rSAPrivateKey.getModulus().bitLength() >= 2048;
    }

    public static Map<String, Key> generateRSAKeyPair(int i) throws NoSuchAlgorithmException {
        HashMap hashMap = new HashMap(2);
        if (i < 2048) {
            C0932b.m1497f(TAG, "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        SecureRandom genSecureRandom = EncryptUtil.genSecureRandom();
        KeyPairGenerator instance = KeyPairGenerator.getInstance(f1110K);
        instance.initialize(i, genSecureRandom);
        KeyPair generateKeyPair = instance.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }
}
