package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C0940a;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i */
    private static final String f1155i = SecureApacheSSLSocketFactory.class.getSimpleName();

    /* renamed from: j */
    private static volatile SecureApacheSSLSocketFactory f1156j = null;

    /* renamed from: a */
    private SSLContext f1157a;

    /* renamed from: b */
    private SSLSocket f1158b;

    /* renamed from: c */
    private Context f1159c;

    /* renamed from: d */
    private String[] f1160d;

    /* renamed from: e */
    private X509TrustManager f1161e;

    /* renamed from: f */
    private String[] f1162f;

    /* renamed from: g */
    private String[] f1163g;

    /* renamed from: h */
    private String[] f1164h;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f1158b = null;
    }

    /* renamed from: a */
    static void m1506a(X509TrustManager x509TrustManager) {
        C0946g.m1580c(f1155i, "sasf update socket factory trust manager");
        try {
            f1156j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            C0946g.m1579b(f1155i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            C0946g.m1579b(f1155i, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            C0946g.m1579b(f1155i, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            C0946g.m1579b(f1155i, "KeyStoreException");
        } catch (CertificateException unused5) {
            C0946g.m1579b(f1155i, "CertificateException");
        } catch (IOException unused6) {
            C0946g.m1579b(f1155i, "IOException");
        }
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        C0942c.m1557a(context);
        if (f1156j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f1156j == null) {
                    f1156j = new SecureApacheSSLSocketFactory(keyStore, context);
                }
            }
        }
        return f1156j;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        C0946g.m1580c(f1155i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f1157a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m1505a(createSocket);
            this.f1158b = (SSLSocket) createSocket;
            this.f1160d = (String[]) this.f1158b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f1162f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f1161e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f1159c;
    }

    public String[] getProtocols() {
        return this.f1164h;
    }

    public SSLContext getSslContext() {
        return this.f1157a;
    }

    public SSLSocket getSslSocket() {
        return this.f1158b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f1160d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f1163g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f1161e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f1162f = strArr;
    }

    public void setContext(Context context) {
        this.f1159c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f1164h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f1157a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f1158b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f1163g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f1161e = x509TrustManager;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f1158b = null;
        if (context == null) {
            C0946g.m1579b(f1155i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f1161e = SecureX509SingleInstance.getInstance(context);
        this.f1157a.init((KeyManager[]) null, new X509TrustManager[]{this.f1161e}, (SecureRandom) null);
    }

    public Socket createSocket() throws IOException {
        C0946g.m1580c(f1155i, "createSocket: ");
        Socket createSocket = this.f1157a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            m1505a(createSocket);
            this.f1158b = (SSLSocket) createSocket;
            this.f1160d = (String[]) this.f1158b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    /* renamed from: a */
    private void m1505a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (!C0940a.m1545a(this.f1164h)) {
            C0946g.m1580c(f1155i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f1164h);
            z = true;
        } else {
            z = false;
        }
        if (!C0940a.m1545a(this.f1163g) || !C0940a.m1545a(this.f1162f)) {
            C0946g.m1580c(f1155i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C0940a.m1545a(this.f1163g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f1163g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f1162f);
            }
        } else {
            z2 = false;
        }
        if (!z) {
            C0946g.m1580c(f1155i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z2) {
            C0946g.m1580c(f1155i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f1158b = null;
        this.f1157a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f1157a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, (SecureRandom) null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f1158b = null;
        this.f1157a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f1157a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }
}
