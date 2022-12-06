package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
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
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public abstract class RSASignKS {

    /* renamed from: C */
    private static final String f1104C = "AndroidKeyStore";

    /* renamed from: H */
    private static final int f1105H = 2048;

    /* renamed from: I */
    private static final int f1106I = 3072;

    /* renamed from: J */
    private static final String f1107J = "SHA256withRSA/PSS";
    private static final String TAG = RSASignKS.class.getSimpleName();

    /* renamed from: i */
    private static final String f1108i = "";

    @Deprecated
    public static String sign(String str, String str2) {
        try {
            return Base64.encodeToString(sign(str, str2.getBytes(Key.STRING_CHARSET_NAME)), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            Log.e(str3, "sign UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        try {
            return verifySign(str, str2.getBytes(Key.STRING_CHARSET_NAME), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e) {
            String str4 = TAG;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            String str5 = TAG;
            C0932b.m1497f(str5, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    public static String signNew(String str, String str2) {
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes(Key.STRING_CHARSET_NAME)), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            Log.e(str3, "sign UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        try {
            return verifySignNew(str, str2.getBytes(Key.STRING_CHARSET_NAME), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e) {
            String str4 = TAG;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            String str5 = TAG;
            C0932b.m1497f(str5, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return m1465b(str, bArr, false);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return m1464a(str, bArr, bArr2, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return m1465b(str, bArr, true);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return m1464a(str, bArr, bArr2, true);
    }

    /* renamed from: b */
    private static byte[] m1465b(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C0932b.m1497f(TAG, "alias or content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            C0932b.m1497f(TAG, "sdk version is too low");
            return bArr2;
        } else {
            KeyStore.Entry c = m1466c(str, z);
            if (!(c instanceof KeyStore.PrivateKeyEntry)) {
                C0932b.m1497f(TAG, "Not an instance of a PrivateKeyEntry");
                return bArr2;
            }
            try {
                Signature instance = Signature.getInstance(f1107J);
                instance.initSign(((KeyStore.PrivateKeyEntry) c).getPrivateKey());
                instance.update(bArr);
                return instance.sign();
            } catch (NoSuchAlgorithmException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (SignatureException e2) {
                String str3 = TAG;
                C0932b.m1497f(str3, "SignatureException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str4 = TAG;
                C0932b.m1497f(str4, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (Exception e4) {
                String str5 = TAG;
                C0932b.m1497f(str5, "Exception: " + e4.getMessage());
                return bArr2;
            }
        }
    }

    /* renamed from: a */
    private static boolean m1464a(String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr2 == null) {
            C0932b.m1497f(TAG, "alias or content or sign value is null");
            return false;
        } else if (!isBuildVersionHigherThan22()) {
            C0932b.m1497f(TAG, "sdk version is too low");
            return false;
        } else {
            KeyStore.Entry c = m1466c(str, z);
            if (!(c instanceof KeyStore.PrivateKeyEntry)) {
                C0932b.m1497f(TAG, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature instance = Signature.getInstance(f1107J);
                instance.initVerify(((KeyStore.PrivateKeyEntry) c).getCertificate());
                instance.update(bArr);
                return instance.verify(bArr2);
            } catch (NoSuchAlgorithmException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "NoSuchAlgorithmException: " + e.getMessage());
                return false;
            } catch (SignatureException e2) {
                String str3 = TAG;
                C0932b.m1497f(str3, "SignatureException: " + e2.getMessage());
                return false;
            } catch (InvalidKeyException e3) {
                String str4 = TAG;
                C0932b.m1497f(str4, "InvalidKeyException: " + e3.getMessage());
                return false;
            } catch (Exception e4) {
                String str5 = TAG;
                C0932b.m1497f(str5, "Exception: " + e4.getMessage());
                return false;
            }
        }
    }

    /* renamed from: a */
    private static synchronized KeyPair m1463a(String str, boolean z) {
        KeyPair keyPair;
        synchronized (RSASignKS.class) {
            keyPair = null;
            if (m1467g(str)) {
                C0932b.m1497f(TAG, "Key pair exits");
                return null;
            }
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", f1104C);
                if (!z) {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(new String[]{"SHA-256", "SHA-512"}).setSignaturePaddings(new String[]{"PSS"}).setKeySize(2048).build());
                } else {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(new String[]{"SHA-256", "SHA-512"}).setSignaturePaddings(new String[]{"PSS"}).setKeySize(f1106I).build());
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
            }
        }
        return keyPair;
    }

    /* renamed from: c */
    private static KeyStore.Entry m1466c(String str, boolean z) {
        if (!m1467g(str)) {
            m1463a(str, z);
        }
        try {
            KeyStore instance = KeyStore.getInstance(f1104C);
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance.getEntry(str, (KeyStore.ProtectionParameter) null);
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
        } catch (UnrecoverableEntryException e5) {
            String str6 = TAG;
            C0932b.m1497f(str6, "UnrecoverableEntryException: " + e5.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: g */
    private static boolean m1467g(String str) {
        try {
            KeyStore instance = KeyStore.getInstance(f1104C);
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
        }
    }
}
