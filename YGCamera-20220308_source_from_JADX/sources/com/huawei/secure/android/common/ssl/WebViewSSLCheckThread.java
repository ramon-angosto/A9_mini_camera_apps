package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class WebViewSSLCheckThread extends Thread {
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final String f1186i = WebViewSSLCheckThread.class.getSimpleName();

    /* renamed from: a */
    private SSLSocketFactory f1187a;

    /* renamed from: b */
    private HostnameVerifier f1188b;

    /* renamed from: c */
    private org.apache.http.conn.ssl.SSLSocketFactory f1189c;

    /* renamed from: d */
    private X509HostnameVerifier f1190d;

    /* renamed from: e */
    private SslErrorHandler f1191e;

    /* renamed from: f */
    private String f1192f;

    /* renamed from: g */
    private Callback f1193g;

    /* renamed from: h */
    private Context f1194h;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    /* renamed from: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread$a */
    static class C0934a implements okhttp3.Callback {

        /* renamed from: a */
        final /* synthetic */ Callback f1195a;

        /* renamed from: b */
        final /* synthetic */ Context f1196b;

        /* renamed from: c */
        final /* synthetic */ String f1197c;

        /* renamed from: d */
        final /* synthetic */ SslErrorHandler f1198d;

        C0934a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f1195a = callback;
            this.f1196b = context;
            this.f1197c = str;
            this.f1198d = sslErrorHandler;
        }

        public void onFailure(Call call, IOException iOException) {
            String a = WebViewSSLCheckThread.f1186i;
            C0946g.m1579b(a, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f1195a;
            if (callback != null) {
                callback.onCancel(this.f1196b, this.f1197c);
            } else {
                this.f1198d.cancel();
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            C0946g.m1579b(WebViewSSLCheckThread.f1186i, "onResponse . proceed");
            Callback callback = this.f1195a;
            if (callback != null) {
                callback.onProceed(this.f1196b, this.f1197c);
            } else {
                this.f1198d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    /* renamed from: b */
    private void m1514b() {
        C0946g.m1580c(f1186i, "callbackCancel: ");
        Callback callback = this.f1193g;
        if (callback != null) {
            callback.onCancel(this.f1194h, this.f1192f);
        } else if (this.f1191e != null) {
            C0946g.m1580c(f1186i, "callbackCancel 2: ");
            this.f1191e.cancel();
        }
    }

    /* renamed from: c */
    private void m1515c() {
        C0946g.m1580c(f1186i, "callbackProceed: ");
        Callback callback = this.f1193g;
        if (callback != null) {
            callback.onProceed(this.f1194h, this.f1192f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f1191e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, (Callback) null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f1190d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f1189c;
    }

    public Callback getCallback() {
        return this.f1193g;
    }

    public Context getContext() {
        return this.f1194h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f1188b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f1191e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f1187a;
    }

    public String getUrl() {
        return this.f1192f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            super.run()
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f1189c
            r1 = 0
            if (r0 == 0) goto L_0x00d5
            org.apache.http.conn.ssl.X509HostnameVerifier r0 = r8.f1190d
            if (r0 == 0) goto L_0x00d5
            android.webkit.SslErrorHandler r0 = r8.f1191e
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = r8.f1192f
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001a
            goto L_0x00ca
        L_0x001a:
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f1189c     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.ssl.X509HostnameVerifier r2 = r8.f1190d     // Catch:{ Exception -> 0x00a4 }
            r0.setHostnameVerifier(r2)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f1189c     // Catch:{ Exception -> 0x00a4 }
            boolean r0 = r0 instanceof com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory     // Catch:{ Exception -> 0x00a4 }
            if (r0 == 0) goto L_0x0030
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f1189c     // Catch:{ Exception -> 0x00a4 }
            com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory r0 = (com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory) r0     // Catch:{ Exception -> 0x00a4 }
            android.content.Context r2 = r8.f1194h     // Catch:{ Exception -> 0x00a4 }
            r0.setContext(r2)     // Catch:{ Exception -> 0x00a4 }
        L_0x0030:
            org.apache.http.params.BasicHttpParams r0 = new org.apache.http.params.BasicHttpParams     // Catch:{ Exception -> 0x00a4 }
            r0.<init>()     // Catch:{ Exception -> 0x00a4 }
            r2 = 30000(0x7530, float:4.2039E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r2)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r2)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.scheme.SchemeRegistry r2 = new org.apache.http.conn.scheme.SchemeRegistry     // Catch:{ Exception -> 0x00a4 }
            r2.<init>()     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.scheme.Scheme r3 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = "https"
            org.apache.http.conn.ssl.SSLSocketFactory r5 = r8.f1189c     // Catch:{ Exception -> 0x00a4 }
            r6 = 443(0x1bb, float:6.21E-43)
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x00a4 }
            r2.register(r3)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.scheme.Scheme r3 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = "http"
            org.apache.http.conn.scheme.PlainSocketFactory r5 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory()     // Catch:{ Exception -> 0x00a4 }
            r6 = 80
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x00a4 }
            r2.register(r3)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager r3 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager     // Catch:{ Exception -> 0x00a4 }
            r3.<init>(r0, r2)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.impl.client.DefaultHttpClient r2 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ Exception -> 0x00a4 }
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.client.methods.HttpGet r0 = new org.apache.http.client.methods.HttpGet     // Catch:{ Exception -> 0x00a4 }
            r0.<init>()     // Catch:{ Exception -> 0x00a4 }
            java.net.URI r3 = new java.net.URI     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = r8.f1192f     // Catch:{ Exception -> 0x00a4 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00a4 }
            r0.setURI(r3)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.HttpResponse r0 = r2.execute(r0)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = f1186i     // Catch:{ Exception -> 0x00a4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            r3.<init>()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = "status code is : "
            r3.append(r4)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.StatusLine r0 = r0.getStatusLine()     // Catch:{ Exception -> 0x00a4 }
            int r0 = r0.getStatusCode()     // Catch:{ Exception -> 0x00a4 }
            r3.append(r0)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00a4 }
            com.huawei.secure.android.common.ssl.util.C0946g.m1580c(r2, r0)     // Catch:{ Exception -> 0x00a4 }
            com.huawei.secure.android.common.ssl.util.C0945f.m1572a((java.io.Reader) r1)
            r8.m1515c()
            return
        L_0x00a2:
            r0 = move-exception
            goto L_0x00c6
        L_0x00a4:
            r0 = move-exception
            java.lang.String r2 = f1186i     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r3.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "run: exception : "
            r3.append(r4)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a2 }
            r3.append(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.C0946g.m1579b(r2, r0)     // Catch:{ all -> 0x00a2 }
            r8.m1514b()     // Catch:{ all -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.C0945f.m1572a((java.io.Reader) r1)
            return
        L_0x00c6:
            com.huawei.secure.android.common.ssl.util.C0945f.m1572a((java.io.Reader) r1)
            throw r0
        L_0x00ca:
            java.lang.String r0 = f1186i
            java.lang.String r1 = "sslErrorHandler or url is null"
            com.huawei.secure.android.common.ssl.util.C0946g.m1579b(r0, r1)
            r8.m1514b()
            return
        L_0x00d5:
            javax.net.ssl.SSLSocketFactory r0 = r8.f1187a
            if (r0 == 0) goto L_0x014a
            javax.net.ssl.HostnameVerifier r0 = r8.f1188b
            if (r0 == 0) goto L_0x014a
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x011c, all -> 0x0117 }
            java.lang.String r2 = r8.f1192f     // Catch:{ Exception -> 0x011c, all -> 0x0117 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x011c, all -> 0x0117 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x011c, all -> 0x0117 }
            boolean r2 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x011c, all -> 0x0117 }
            if (r2 == 0) goto L_0x010d
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x011c, all -> 0x0117 }
            javax.net.ssl.SSLSocketFactory r1 = r8.f1187a     // Catch:{ Exception -> 0x010b }
            r0.setSSLSocketFactory(r1)     // Catch:{ Exception -> 0x010b }
            javax.net.ssl.HostnameVerifier r1 = r8.f1188b     // Catch:{ Exception -> 0x010b }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x010b }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x010b }
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x010b }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x010b }
            r0.connect()     // Catch:{ Exception -> 0x010b }
            goto L_0x010e
        L_0x010b:
            r1 = move-exception
            goto L_0x0120
        L_0x010d:
            r0 = r1
        L_0x010e:
            if (r0 == 0) goto L_0x0113
            r0.disconnect()
        L_0x0113:
            r8.m1515c()
            return
        L_0x0117:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0144
        L_0x011c:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0120:
            java.lang.String r2 = f1186i     // Catch:{ all -> 0x0143 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0143 }
            r3.<init>()     // Catch:{ all -> 0x0143 }
            java.lang.String r4 = "exception : "
            r3.append(r4)     // Catch:{ all -> 0x0143 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0143 }
            r3.append(r1)     // Catch:{ all -> 0x0143 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0143 }
            com.huawei.secure.android.common.ssl.util.C0946g.m1579b(r2, r1)     // Catch:{ all -> 0x0143 }
            r8.m1514b()     // Catch:{ all -> 0x0143 }
            if (r0 == 0) goto L_0x0142
            r0.disconnect()
        L_0x0142:
            return
        L_0x0143:
            r1 = move-exception
        L_0x0144:
            if (r0 == 0) goto L_0x0149
            r0.disconnect()
        L_0x0149:
            throw r1
        L_0x014a:
            r8.m1514b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.run():void");
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f1190d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f1189c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f1193g = callback;
    }

    public void setContext(Context context) {
        this.f1194h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f1188b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f1191e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f1187a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f1192f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactory((X509TrustManager) new C0937c(context)));
        setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory((KeyStore) null, (X509TrustManager) new C0937c(context)));
        } catch (UnrecoverableKeyException e) {
            String str2 = f1186i;
            C0946g.m1579b(str2, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            C0946g.m1579b(f1186i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactory secureSSLSocketFactory = new SecureSSLSocketFactory((X509TrustManager) new C0937c(context));
            secureSSLSocketFactory.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactory, new C0937c(context));
            builder.hostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new C0934a(callback, context, str, sslErrorHandler));
        } catch (Exception e) {
            String str2 = f1186i;
            C0946g.m1579b(str2, "checkServerCertificateWithOK: exception : " + e.getMessage());
            sslErrorHandler.cancel();
        }
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.f1191e = sslErrorHandler;
        this.f1192f = str;
        this.f1189c = sSLSocketFactory;
        this.f1190d = x509HostnameVerifier;
        this.f1193g = callback;
        this.f1194h = context;
    }
}
