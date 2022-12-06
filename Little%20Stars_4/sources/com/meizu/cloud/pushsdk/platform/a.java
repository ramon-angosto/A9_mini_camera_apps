package com.meizu.cloud.pushsdk.platform;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class a {
    public static SSLSocketFactory a() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        try {
            sSLContext = SSLContext.getInstance("TLS");
            try {
                sSLContext.init((KeyManager[]) null, new TrustManager[]{new b()}, new SecureRandom());
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
            } catch (KeyManagementException e4) {
                e2 = e4;
                e2.printStackTrace();
                return sSLContext.getSocketFactory();
            }
        } catch (NoSuchAlgorithmException e5) {
            NoSuchAlgorithmException noSuchAlgorithmException = e5;
            sSLContext = null;
            e = noSuchAlgorithmException;
            e.printStackTrace();
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException e6) {
            KeyManagementException keyManagementException = e6;
            sSLContext = null;
            e2 = keyManagementException;
            e2.printStackTrace();
            return sSLContext.getSocketFactory();
        }
        return sSLContext.getSocketFactory();
    }

    public static HostnameVerifier b() {
        return new C0047a();
    }

    private static class b implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        private b() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.platform.a$a  reason: collision with other inner class name */
    private static class C0047a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        private C0047a() {
        }
    }
}
