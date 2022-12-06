package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C0940a;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.IOException;
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

public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f1135i = SSFCompatiableSystemCA.class.getSimpleName();

    /* renamed from: j */
    private static volatile SSFCompatiableSystemCA f1136j = null;

    /* renamed from: a */
    private SSLContext f1137a;

    /* renamed from: b */
    private SSLSocket f1138b;

    /* renamed from: c */
    private Context f1139c;

    /* renamed from: d */
    private String[] f1140d;

    /* renamed from: e */
    private X509TrustManager f1141e;

    /* renamed from: f */
    private String[] f1142f;

    /* renamed from: g */
    private String[] f1143g;

    /* renamed from: h */
    private String[] f1144h;

    private SSFCompatiableSystemCA(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f1137a = null;
        this.f1138b = null;
        if (context == null) {
            C0946g.m1579b(f1135i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f1141e = SSFSecureX509SingleInstance.getInstance(context);
        this.f1137a.init((KeyManager[]) null, new X509TrustManager[]{this.f1141e}, (SecureRandom) null);
    }

    /* renamed from: a */
    static void m1504a(X509TrustManager x509TrustManager) {
        C0946g.m1580c(f1135i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f1136j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            C0946g.m1579b(f1135i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            C0946g.m1579b(f1135i, "KeyManagementException");
        }
        String str = f1135i;
        C0946g.m1577a(str, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SSFCompatiableSystemCA getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        C0942c.m1557a(context);
        if (f1136j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f1136j == null) {
                    f1136j = new SSFCompatiableSystemCA(context);
                }
            }
        }
        if (f1136j.f1139c == null && context != null) {
            f1136j.setContext(context);
        }
        return f1136j;
    }

    public Socket createSocket(String str, int i) throws IOException {
        C0946g.m1580c(f1135i, "createSocket: host , port");
        Socket createSocket = this.f1137a.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            m1503a(createSocket);
            this.f1138b = (SSLSocket) createSocket;
            this.f1140d = (String[]) this.f1138b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f1142f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f1141e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f1139c;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f1144h;
    }

    public SSLContext getSslContext() {
        return this.f1137a;
    }

    public SSLSocket getSslSocket() {
        return this.f1138b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f1140d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f1143g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f1141e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f1142f = strArr;
    }

    public void setContext(Context context) {
        this.f1139c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f1144h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f1137a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f1143g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f1141e = x509TrustManager;
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
        C0946g.m1580c(f1135i, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.f1137a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            m1503a(createSocket);
            this.f1138b = (SSLSocket) createSocket;
            this.f1140d = (String[]) this.f1138b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    /* renamed from: a */
    private void m1503a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (!C0940a.m1545a(this.f1144h)) {
            C0946g.m1580c(f1135i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f1144h);
            z = true;
        } else {
            z = false;
        }
        if (!C0940a.m1545a(this.f1143g) || !C0940a.m1545a(this.f1142f)) {
            C0946g.m1580c(f1135i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C0940a.m1545a(this.f1143g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f1143g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f1142f);
            }
        } else {
            z2 = false;
        }
        if (!z) {
            C0946g.m1580c(f1135i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z2) {
            C0946g.m1580c(f1135i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f1137a = null;
        this.f1138b = null;
        this.f1137a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f1137a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }
}
