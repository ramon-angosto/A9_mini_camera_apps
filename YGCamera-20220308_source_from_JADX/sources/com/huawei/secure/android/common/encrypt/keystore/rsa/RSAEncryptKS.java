package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public abstract class RSAEncryptKS {

    /* renamed from: C */
    private static final String f1099C = "AndroidKeyStore";

    /* renamed from: G */
    private static final String f1100G = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: H */
    private static final int f1101H = 2048;

    /* renamed from: I */
    private static final int f1102I = 3072;
    private static final String TAG = RSAEncryptKS.class.getSimpleName();

    /* renamed from: i */
    private static final String f1103i = "";

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes(Key.STRING_CHARSET_NAME)), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            C0932b.m1497f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            C0932b.m1497f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str4 = TAG;
            C0932b.m1497f(str4, "Exception: " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return m1459a(str, bArr, false);
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C0932b.m1497f(TAG, "alias or encrypted content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            C0932b.m1497f(TAG, "sdk version is too low");
            return bArr2;
        } else {
            PrivateKey privateKey = getPrivateKey(str);
            if (privateKey == null) {
                C0932b.m1497f(TAG, "Private key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance(f1100G);
                instance.init(2, privateKey, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e2) {
                String str3 = TAG;
                C0932b.m1497f(str3, "NoSuchPaddingException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str4 = TAG;
                C0932b.m1497f(str4, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e4) {
                String str5 = TAG;
                C0932b.m1497f(str5, "InvalidAlgorithmParameterException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                String str6 = TAG;
                C0932b.m1497f(str6, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (BadPaddingException e6) {
                String str7 = TAG;
                C0932b.m1497f(str7, "BadPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                String str8 = TAG;
                C0932b.m1497f(str8, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes(Key.STRING_CHARSET_NAME)), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            C0932b.m1497f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            C0932b.m1497f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str4 = TAG;
            C0932b.m1497f(str4, "Exception: " + e2.getMessage());
            return "";
        }
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return m1459a(str, bArr, true);
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    /* renamed from: a */
    private static byte[] m1459a(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C0932b.m1497f(TAG, "alias or content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            C0932b.m1497f(TAG, "sdk version is too low");
            return bArr2;
        } else {
            PublicKey b = m1460b(str, z);
            if (b == null) {
                C0932b.m1497f(TAG, "Public key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance(f1100G);
                instance.init(1, b, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e2) {
                String str3 = TAG;
                C0932b.m1497f(str3, "NoSuchPaddingException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str4 = TAG;
                C0932b.m1497f(str4, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e4) {
                String str5 = TAG;
                C0932b.m1497f(str5, "InvalidAlgorithmParameterException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                String str6 = TAG;
                C0932b.m1497f(str6, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (BadPaddingException e6) {
                String str7 = TAG;
                C0932b.m1497f(str7, "BadPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                String str8 = TAG;
                C0932b.m1497f(str8, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    /* renamed from: a */
    private static synchronized KeyPair m1458a(String str, boolean z) {
        KeyPair keyPair;
        synchronized (RSAEncryptKS.class) {
            keyPair = null;
            if (m1462g(str)) {
                C0932b.m1497f(TAG, "Key pair exits");
                return null;
            }
            C0932b.m1495d(TAG, "generate key pair.");
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", f1099C);
                if (!z) {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(new String[]{"SHA-256", "SHA-512"}).setEncryptionPaddings(new String[]{"OAEPPadding"}).setKeySize(2048).build());
                } else {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(new String[]{"SHA-256", "SHA-512"}).setEncryptionPaddings(new String[]{"OAEPPadding"}).setKeySize(f1102I).build());
                }
                keyPair = instance.generateKeyPair();
            } catch (NoSuchAlgorithmException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "NoSuchAlgorithmException: " + e.getMessage());
            } catch (NoSuchProviderException e2) {
                String str3 = TAG;
                C0932b.m1497f(str3, "NoSuchProviderException: " + e2.getMessage());
            } catch (InvalidAlgorithmParameterException e3) {
                String str4 = TAG;
                C0932b.m1497f(str4, "InvalidAlgorithmParameterException: " + e3.getMessage());
            } catch (Exception e4) {
                String str5 = TAG;
                C0932b.m1497f(str5, "Exception: " + e4.getMessage());
            }
        }
        return keyPair;
    }

    /* renamed from: b */
    private static PublicKey m1460b(String str, boolean z) {
        if (!m1462g(str)) {
            m1458a(str, z);
        }
        Certificate f = m1461f(str);
        if (f != null) {
            return f.getPublicKey();
        }
        return null;
    }

    /* renamed from: f */
    private static Certificate m1461f(String str) {
        try {
            KeyStore instance = KeyStore.getInstance(f1099C);
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance.getCertificate(str);
        } catch (KeyStoreException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "KeyStoreException: " + e.getMessage());
            return null;
        } catch (CertificateException e2) {
            String str3 = TAG;
            C0932b.m1497f(str3, "CertificateException: " + e2.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e3) {
            String str4 = TAG;
            C0932b.m1497f(str4, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (IOException e4) {
            String str5 = TAG;
            C0932b.m1497f(str5, "IOException: " + e4.getMessage());
            return null;
        } catch (Exception e5) {
            String str6 = TAG;
            C0932b.m1497f(str6, "Exception: " + e5.getMessage());
            return null;
        }
    }

    private static PrivateKey getPrivateKey(String str) {
        if (!m1462g(str)) {
            return null;
        }
        try {
            KeyStore instance = KeyStore.getInstance(f1099C);
            instance.load((KeyStore.LoadStoreParameter) null);
            return (PrivateKey) instance.getKey(str, (char[]) null);
        } catch (KeyStoreException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "KeyStoreException: " + e.getMessage());
        } catch (CertificateException e2) {
            String str3 = TAG;
            C0932b.m1497f(str3, "CertificateException: " + e2.getMessage());
        } catch (UnrecoverableKeyException e3) {
            String str4 = TAG;
            C0932b.m1497f(str4, "UnrecoverableKeyException: " + e3.getMessage());
        } catch (NoSuchAlgorithmException e4) {
            String str5 = TAG;
            C0932b.m1497f(str5, "NoSuchAlgorithmException: " + e4.getMessage());
        } catch (IOException e5) {
            String str6 = TAG;
            C0932b.m1497f(str6, "IOException: " + e5.getMessage());
        } catch (Exception e6) {
            String str7 = TAG;
            C0932b.m1497f(str7, "Exception: " + e6.getMessage());
        }
        return null;
    }

    private static boolean isBuildVersionHigherThan22() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: g */
    private static boolean m1462g(String str) {
        try {
            KeyStore instance = KeyStore.getInstance(f1099C);
            instance.load((KeyStore.LoadStoreParameter) null);
            if (instance.getKey(str, (char[]) null) != null) {
                return true;
            }
            return false;
        } catch (KeyStoreException e) {
            String str2 = TAG;
            C0932b.m1497f(str2, "KeyStoreException: " + e.getMessage());
            return false;
        } catch (CertificateException e2) {
            String str3 = TAG;
            C0932b.m1497f(str3, "CertificateException: " + e2.getMessage());
            return false;
        } catch (UnrecoverableKeyException e3) {
            String str4 = TAG;
            C0932b.m1497f(str4, "UnrecoverableKeyException: " + e3.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e4) {
            String str5 = TAG;
            C0932b.m1497f(str5, "NoSuchAlgorithmException: " + e4.getMessage());
            return false;
        } catch (IOException e5) {
            String str6 = TAG;
            C0932b.m1497f(str6, "IOException: " + e5.getMessage());
            return false;
        } catch (Exception e6) {
            String str7 = TAG;
            C0932b.m1497f(str7, "Exception: " + e6.getMessage());
            return false;
        }
    }
}
