package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C0940a;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureSSLSocketFactory extends SSLSocketFactory {
    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i */
    private static final String f1165i = SecureSSLSocketFactory.class.getSimpleName();

    /* renamed from: j */
    private static volatile SecureSSLSocketFactory f1166j = null;

    /* renamed from: a */
    private SSLContext f1167a;

    /* renamed from: b */
    private SSLSocket f1168b;

    /* renamed from: c */
    private Context f1169c;

    /* renamed from: d */
    private String[] f1170d;

    /* renamed from: e */
    private X509TrustManager f1171e;

    /* renamed from: f */
    private String[] f1172f;

    /* renamed from: g */
    private String[] f1173g;

    /* renamed from: h */
    private String[] f1174h;

    public SecureSSLSocketFactory(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f1167a = null;
        this.f1168b = null;
        this.f1167a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f1167a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, (SecureRandom) null);
    }

    /* renamed from: a */
    static void m1508a(X509TrustManager x509TrustManager) {
        C0946g.m1580c(f1165i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f1166j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            C0946g.m1579b(f1165i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            C0946g.m1579b(f1165i, "KeyManagementException");
        }
        String str = f1165i;
        C0946g.m1577a(str, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SecureSSLSocketFactory getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        C0942c.m1557a(context);
        if (f1166j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f1166j == null) {
                    f1166j = new SecureSSLSocketFactory(context);
                }
            }
        }
        if (f1166j.f1169c == null && context != null) {
            f1166j.setContext(context);
        }
        String str = f1165i;
        C0946g.m1577a(str, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f1166j;
    }

    public Socket createSocket(String str, int i) throws IOException {
        C0946g.m1580c(f1165i, "createSocket: host , port");
        Socket createSocket = this.f1167a.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            m1507a(createSocket);
            this.f1168b = (SSLSocket) createSocket;
            this.f1170d = (String[]) this.f1168b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f1172f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f1171e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f1169c;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f1174h;
    }

    public SSLContext getSslContext() {
        return this.f1167a;
    }

    public SSLSocket getSslSocket() {
        return this.f1168b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f1170d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f1173g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f1171e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f1172f = strArr;
    }

    public void setContext(Context context) {
        this.f1169c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f1174h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f1167a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f1173g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f1171e = x509TrustManager;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return createSocket(str, i);
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        C0946g.m1580c(f1165i, "createSocket s host port autoClose");
        Socket createSocket = this.f1167a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m1507a(createSocket);
            this.f1168b = (SSLSocket) createSocket;
            this.f1170d = (String[]) this.f1168b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    /* renamed from: a */
    private void m1507a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (!C0940a.m1545a(this.f1174h)) {
            C0946g.m1580c(f1165i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f1174h);
            z = true;
        } else {
            z = false;
        }
        if (!C0940a.m1545a(this.f1173g) || !C0940a.m1545a(this.f1172f)) {
            C0946g.m1580c(f1165i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C0940a.m1545a(this.f1173g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f1173g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f1172f);
            }
        } else {
            z2 = false;
        }
        if (!z) {
            C0946g.m1580c(f1165i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z2) {
            C0946g.m1580c(f1165i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    private SecureSSLSocketFactory(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f1167a = null;
        this.f1168b = null;
        if (context == null) {
            C0946g.m1579b(f1165i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f1171e = SecureX509SingleInstance.getInstance(context);
        this.f1167a.init((KeyManager[]) null, new X509TrustManager[]{this.f1171e}, (SecureRandom) null);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f1167a = null;
        this.f1168b = null;
        this.f1167a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f1167a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }
}
