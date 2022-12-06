package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/* renamed from: com.huawei.secure.android.common.ssl.util.b */
public class C0941b {

    /* renamed from: a */
    private static final String f1238a = "b";

    /* renamed from: b */
    private static final int f1239b = 5;

    /* renamed from: a */
    public static X509Certificate m1547a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e) {
            String str2 = f1238a;
            C0946g.m1579b(str2, "generateX509FromStr: CertificateException" + e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m1555b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        int length = x509CertificateArr.length;
        int i = 0;
        while (i < length) {
            try {
                x509CertificateArr[i].checkValidity(date);
                i++;
            } catch (CertificateExpiredException | CertificateNotYetValidException e) {
                String str = f1238a;
                C0946g.m1579b(str, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e2) {
                String str2 = f1238a;
                C0946g.m1579b(str2, "verifyCertificateDate : exception : " + e2.getMessage());
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m1552a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        if (!m1551a(x509Certificate, x509CertificateArr) && !m1554a(x509CertificateArr, x509crl) && m1549a(x509CertificateArr[x509CertificateArr.length - 1], str) && m1555b(x509CertificateArr)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1554a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate serialNumber : x509CertificateArr) {
            arrayList.add(serialNumber.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                return true;
            }
            for (X509CRLEntry serialNumber2 : revokedCertificates) {
                if (arrayList.contains(serialNumber2.getSerialNumber())) {
                    C0946g.m1579b(f1238a, "verify: certificate revoked");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            C0946g.m1579b(f1238a, "verify: revoked verify exception : " + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1549a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        C0946g.m1579b(f1238a, "verify: subject name is error");
        return false;
    }

    /* renamed from: a */
    public static boolean m1550a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (m1555b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            C0946g.m1579b(f1238a, "verify: date not right");
            return false;
        } catch (CertificateException e) {
            String str = f1238a;
            C0946g.m1579b(str, "verify: publickey CertificateException " + e.getMessage());
            return false;
        } catch (InvalidKeyException e2) {
            String str2 = f1238a;
            C0946g.m1579b(str2, "verify: publickey InvalidKeyException " + e2.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e3) {
            String str3 = f1238a;
            C0946g.m1579b(str3, "verify: publickey NoSuchAlgorithmException " + e3.getMessage());
            return false;
        } catch (NoSuchProviderException e4) {
            String str4 = f1238a;
            C0946g.m1579b(str4, "verify: publickey NoSuchProviderException " + e4.getMessage());
            return false;
        } catch (SignatureException e5) {
            String str5 = f1238a;
            C0946g.m1579b(str5, "verify: publickey SignatureException " + e5.getMessage());
            return false;
        } catch (Exception e6) {
            String str6 = f1238a;
            C0946g.m1579b(str6, "verify: Exception " + e6.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1551a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i = 0;
        while (i < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i].verify(x509CertificateArr[i - 1].getPublicKey());
                } else {
                    C0946g.m1579b(f1238a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i++;
            principal = subjectDN;
        }
        if (m1550a(x509Certificate, x509CertificateArr[0]) && m1555b(x509CertificateArr) && m1548a(x509Certificate) && m1553a(x509CertificateArr)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static X509Certificate m1546a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e) {
                C0946g.m1578a(f1238a, "exception", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m1553a(X509Certificate[] x509CertificateArr) {
        for (int i = 0; i < x509CertificateArr.length - 1; i++) {
            if (!m1548a(x509CertificateArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m1548a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
