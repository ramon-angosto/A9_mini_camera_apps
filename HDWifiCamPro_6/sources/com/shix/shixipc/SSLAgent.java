package com.shix.shixipc;

import android.util.Log;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLAgent {
    private static final boolean DEBUG = true;
    private static final String TAG = "SSLAgent";
    private static SSLAgent mSSLAgent;
    private HostnameVerifier mHostnameVerifier = new HostnameVerifier() {
        public boolean verify(String str, SSLSession sSLSession) {
            SSLAgent sSLAgent = SSLAgent.this;
            sSLAgent.log("hostname:" + str);
            return true;
        }
    };

    public static SSLAgent getInstance() {
        if (mSSLAgent == null) {
            mSSLAgent = new SSLAgent();
        }
        return mSSLAgent;
    }

    public void trustAllHttpsCertificates() {
        try {
            TrustManager[] trustManagerArr = {new MyTrustManager()};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init((KeyManager[]) null, trustManagerArr, (SecureRandom) null);
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(this.mHostnameVerifier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyTrustManager implements TrustManager, X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isClientTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }

        public boolean isServerTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }

        private MyTrustManager() {
        }
    }

    /* access modifiers changed from: private */
    public void log(String str) {
        Log.i(TAG, str);
    }
}
