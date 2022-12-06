package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C0940a;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.IOException;
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
import org.apache.http.conn.ssl.SSLSocketFactory;

public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f1125i = SASFCompatiableSystemCA.class.getSimpleName();

    /* renamed from: j */
    private static volatile SASFCompatiableSystemCA f1126j = null;

    /* renamed from: a */
    private SSLContext f1127a;

    /* renamed from: b */
    private SSLSocket f1128b;

    /* renamed from: c */
    private Context f1129c;

    /* renamed from: d */
    private String[] f1130d;

    /* renamed from: e */
    private X509TrustManager f1131e;

    /* renamed from: f */
    private String[] f1132f;

    /* renamed from: g */
    private String[] f1133g;

    /* renamed from: h */
    private String[] f1134h;

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f1128b = null;
    }

    /* renamed from: a */
    static void m1502a(X509TrustManager x509TrustManager) {
        C0946g.m1580c(f1125i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f1126j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            C0946g.m1579b(f1125i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            C0946g.m1579b(f1125i, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            C0946g.m1579b(f1125i, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            C0946g.m1579b(f1125i, "KeyStoreException");
        }
        String str = f1125i;
        C0946g.m1577a(str, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        C0942c.m1557a(context);
        if (f1126j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f1126j == null) {
                    f1126j = new SASFCompatiableSystemCA(keyStore, context);
                }
            }
        }
        return f1126j;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        C0946g.m1580c(f1125i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f1127a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m1501a(createSocket);
            this.f1128b = (SSLSocket) createSocket;
            this.f1130d = (String[]) this.f1128b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f1132f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f1131e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f1129c;
    }

    public String[] getProtocols() {
        return this.f1134h;
    }

    public SSLContext getSslContext() {
        return this.f1127a;
    }

    public SSLSocket getSslSocket() {
        return this.f1128b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f1130d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f1133g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f1131e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f1132f = strArr;
    }

    public void setContext(Context context) {
        this.f1129c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f1134h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f1127a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f1128b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f1133g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f1131e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f1128b = null;
        if (context == null) {
            C0946g.m1579b(f1125i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f1131e = SSFSecureX509SingleInstance.getInstance(context);
        this.f1127a.init((KeyManager[]) null, new X509TrustManager[]{this.f1131e}, (SecureRandom) null);
    }

    public Socket createSocket() throws IOException {
        C0946g.m1580c(f1125i, "createSocket: ");
        Socket createSocket = this.f1127a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            m1501a(createSocket);
            this.f1128b = (SSLSocket) createSocket;
            this.f1130d = (String[]) this.f1128b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    /* renamed from: a */
    private void m1501a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (!C0940a.m1545a(this.f1134h)) {
            C0946g.m1580c(f1125i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f1134h);
            z = true;
        } else {
            z = false;
        }
        if (!C0940a.m1545a(this.f1133g) || !C0940a.m1545a(this.f1132f)) {
            C0946g.m1580c(f1125i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C0940a.m1545a(this.f1133g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f1133g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f1132f);
            }
        } else {
            z2 = false;
        }
        if (!z) {
            C0946g.m1580c(f1125i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z2) {
            C0946g.m1580c(f1125i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f1128b = null;
        this.f1127a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f1127a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }
}
