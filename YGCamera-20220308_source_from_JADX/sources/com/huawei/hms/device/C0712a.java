package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.ssl.util.C0949j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.device.a */
/* compiled from: X509CertUtil */
public class C0712a {
    /* renamed from: a */
    public static boolean m454a(X509Certificate x509Certificate, List<X509Certificate> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (x509Certificate == null) {
            HMSLog.m1377e("X509CertUtil", "rootCert is null,verify failed ");
            return false;
        }
        PublicKey publicKey = x509Certificate.getPublicKey();
        for (X509Certificate next : list) {
            if (next == null) {
                return false;
            }
            try {
                next.checkValidity();
                next.verify(publicKey);
                publicKey = next.getPublicKey();
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                HMSLog.m1377e("X509CertUtil", "verify failed " + e.getMessage());
            }
        }
        return m456a(list);
    }

    /* renamed from: b */
    public static List<X509Certificate> m458b(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String a : list) {
            arrayList.add(m449a(a));
        }
        return arrayList;
    }

    /* renamed from: c */
    public static List<String> m461c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException e) {
            HMSLog.m1377e("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /* renamed from: b */
    public static List<X509Certificate> m457b(String str) {
        return m458b(m461c(str));
    }

    /* renamed from: b */
    public static boolean m460b(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(m446a(x509Certificate.getSubjectDN().getName(), str));
    }

    /* renamed from: b */
    public static boolean m459b(X509Certificate x509Certificate, String str) {
        return m460b(x509Certificate, "OU", str);
    }

    /* renamed from: a */
    public static X509Certificate m449a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return m450a(Base64.decode(str));
        } catch (IllegalArgumentException e) {
            HMSLog.m1377e("X509CertUtil", "getCert failed : " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static X509Certificate m450a(byte[] bArr) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e) {
            HMSLog.m1377e("X509CertUtil", "Failed to get cert: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static String m446a(String str, String str2) {
        String upperCase = str.toUpperCase(Locale.getDefault());
        int indexOf = upperCase.indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, indexOf);
        if (indexOf2 != -1) {
            return str.substring(indexOf + str2.length() + 1, indexOf2);
        }
        return str.substring(indexOf + str2.length() + 1);
    }

    /* renamed from: a */
    public static boolean m451a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (5 < keyUsage.length) {
            return keyUsage[5];
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m456a(List<X509Certificate> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (!m451a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m452a(X509Certificate x509Certificate, String str) {
        return m460b(x509Certificate, "CN", str);
    }

    /* renamed from: a */
    public static boolean m453a(X509Certificate x509Certificate, String str, String str2) {
        try {
            return m455a(x509Certificate, str.getBytes(Key.STRING_CHARSET_NAME), Base64.decode(str2));
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            HMSLog.m1377e("X509CertUtil", " plainText exception: " + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m455a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        try {
            Signature instance = Signature.getInstance(x509Certificate.getSigAlgName());
            instance.initVerify(x509Certificate.getPublicKey());
            instance.update(bArr);
            return instance.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            HMSLog.m1377e("X509CertUtil", "failed checkSignature : " + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static X509Certificate m448a(Context context, String str) {
        InputStream inputStream;
        if (context == null || TextUtils.isEmpty(str)) {
            HMSLog.m1377e("X509CertUtil", "args are error");
            return null;
        }
        try {
            KeyStore instance = KeyStore.getInstance(C0949j.f1252e);
            inputStream = context.getAssets().open("hmsrootcas.bks");
            try {
                instance.load(inputStream, "".toCharArray());
                if (!instance.containsAlias(str)) {
                    HMSLog.m1377e("X509CertUtil", "Not include alias " + str);
                    IOUtils.closeQuietly(inputStream);
                    return null;
                }
                Certificate certificate = instance.getCertificate(str);
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    x509Certificate.checkValidity();
                    IOUtils.closeQuietly(inputStream);
                    return x509Certificate;
                }
                IOUtils.closeQuietly(inputStream);
                return null;
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                e = e;
                try {
                    HMSLog.m1377e("X509CertUtil", "exception:" + e.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            e = e2;
            inputStream = null;
            HMSLog.m1377e("X509CertUtil", "exception:" + e.getMessage());
            IOUtils.closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static X509Certificate m447a(Context context) {
        return m448a(context, C0949j.f1253f);
    }
}
