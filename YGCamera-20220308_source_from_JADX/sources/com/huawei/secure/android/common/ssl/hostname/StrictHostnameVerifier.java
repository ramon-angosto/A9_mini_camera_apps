package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.C0946g;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public class StrictHostnameVerifier implements HostnameVerifier {
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            C0946g.m1577a("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            C0939b.m1525a(str, x509Certificate, true);
            return true;
        } catch (SSLException e) {
            C0946g.m1579b("", "SSLException : " + e.getMessage());
            return false;
        }
    }
}
