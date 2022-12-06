package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.google.android.gms.stats.CodePackage;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmKS {

    /* renamed from: C */
    private static final String f1094C = "AndroidKeyStore";

    /* renamed from: F */
    private static final int f1095F = 256;
    private static final String TAG = AesGcmKS.class.getSimpleName();

    /* renamed from: i */
    private static final String f1096i = "";

    /* renamed from: l */
    private static final String f1097l = "AES/GCM/NoPadding";

    /* renamed from: n */
    private static final int f1098n = 12;

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0932b.m1497f(TAG, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes(Key.STRING_CHARSET_NAME)));
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            C0932b.m1497f(str3, "encrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0932b.m1497f(TAG, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            C0932b.m1497f(str3, "decrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    /* renamed from: e */
    private static synchronized SecretKey m1457e(String str) {
        SecretKey secretKey;
        synchronized (AesGcmKS.class) {
            secretKey = null;
            try {
                KeyStore instance = KeyStore.getInstance(f1094C);
                instance.load((KeyStore.LoadStoreParameter) null);
                java.security.Key key = instance.getKey(str, (char[]) null);
                if (key == null || !(key instanceof SecretKey)) {
                    KeyGenerator instance2 = KeyGenerator.getInstance("AES", f1094C);
                    instance2.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build());
                    secretKey = instance2.generateKey();
                } else {
                    secretKey = (SecretKey) key;
                }
            } catch (KeyStoreException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "KeyStoreException : " + e.getMessage());
            } catch (IOException e2) {
                String str3 = TAG;
                C0932b.m1497f(str3, "IOException : " + e2.getMessage());
            } catch (CertificateException e3) {
                String str4 = TAG;
                C0932b.m1497f(str4, "CertificateException : " + e3.getMessage());
            } catch (NoSuchAlgorithmException e4) {
                String str5 = TAG;
                C0932b.m1497f(str5, "NoSuchAlgorithmException : " + e4.getMessage());
            } catch (UnrecoverableKeyException e5) {
                String str6 = TAG;
                C0932b.m1497f(str6, "UnrecoverableKeyException : " + e5.getMessage());
            } catch (InvalidAlgorithmParameterException e6) {
                String str7 = TAG;
                C0932b.m1497f(str7, "InvalidAlgorithmParameterException : " + e6.getMessage());
            } catch (NoSuchProviderException e7) {
                String str8 = TAG;
                C0932b.m1497f(str8, "NoSuchProviderException : " + e7.getMessage());
            } catch (Exception e8) {
                String str9 = TAG;
                C0932b.m1497f(str9, "Exception: " + e8.getMessage());
            }
        }
        return secretKey;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C0932b.m1497f(TAG, "alias or encrypt content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            C0932b.m1497f(TAG, "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher instance = Cipher.getInstance(f1097l);
                SecretKey e = m1457e(str);
                if (e == null) {
                    C0932b.m1497f(TAG, "Encrypt secret key is null");
                    return bArr2;
                }
                instance.init(1, e);
                byte[] doFinal = instance.doFinal(bArr);
                byte[] iv = instance.getIV();
                if (iv != null) {
                    if (iv.length == 12) {
                        byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                        System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                        return copyOf;
                    }
                }
                C0932b.m1497f(TAG, "IV is invalid.");
                return bArr2;
            } catch (NoSuchAlgorithmException e2) {
                String str2 = TAG;
                C0932b.m1497f(str2, "NoSuchAlgorithmException : " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                String str3 = TAG;
                C0932b.m1497f(str3, "NoSuchPaddingException : " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                String str4 = TAG;
                C0932b.m1497f(str4, "BadPaddingException : " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                String str5 = TAG;
                C0932b.m1497f(str5, "IllegalBlockSizeException : " + e5.getMessage());
                return bArr2;
            } catch (InvalidKeyException e6) {
                String str6 = TAG;
                C0932b.m1497f(str6, "InvalidKeyException : " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                String str7 = TAG;
                C0932b.m1497f(str7, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C0932b.m1497f(TAG, "alias or encrypt content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            C0932b.m1497f(TAG, "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 12) {
            C0932b.m1497f(TAG, "Decrypt source data is invalid.");
            return bArr2;
        } else {
            SecretKey e = m1457e(str);
            if (e == null) {
                C0932b.m1497f(TAG, "Decrypt secret key is null");
                return bArr2;
            }
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            try {
                Cipher instance = Cipher.getInstance(f1097l);
                instance.init(2, e, new GCMParameterSpec(128, copyOf));
                return instance.doFinal(bArr, 12, bArr.length - 12);
            } catch (NoSuchAlgorithmException e2) {
                String str2 = TAG;
                C0932b.m1497f(str2, "NoSuchAlgorithmException : " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                String str3 = TAG;
                C0932b.m1497f(str3, "NoSuchPaddingException : " + e3.getMessage());
                return bArr2;
            } catch (InvalidKeyException e4) {
                String str4 = TAG;
                C0932b.m1497f(str4, "InvalidKeyException : " + e4.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e5) {
                String str5 = TAG;
                C0932b.m1497f(str5, "InvalidAlgorithmParameterException : " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                String str6 = TAG;
                C0932b.m1497f(str6, "IllegalBlockSizeException : " + e6.getMessage());
                return bArr2;
            } catch (BadPaddingException e7) {
                String str7 = TAG;
                C0932b.m1497f(str7, "BadPaddingException : " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                String str8 = TAG;
                C0932b.m1497f(str8, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
    }

    private static boolean isBuildVersionHigherThan22() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
