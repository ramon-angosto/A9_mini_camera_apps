package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.WebViewSSLCheckThread;
import com.huawei.secure.android.common.ssl.util.C0941b;
import com.huawei.secure.android.common.ssl.util.C0946g;
import com.huawei.secure.android.common.ssl.util.C0949j;
import java.security.cert.X509Certificate;

public class WebViewSSLCheck {

    /* renamed from: a */
    private static final String f1185a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, (String) null, context, (WebViewSSLCheckThread.Callback) null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        String str2 = f1185a;
        C0946g.m1580c(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate a = C0941b.m1546a(sslError.getCertificate());
        X509Certificate a2 = new C0949j(context).mo14805a();
        String str3 = f1185a;
        C0946g.m1577a(str3, "checkServerCertificateNew: error certificate is : " + a);
        if (C0941b.m1550a(a2, a)) {
            C0946g.m1580c(f1185a, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
            } else {
                sslErrorHandler.proceed();
            }
        } else {
            C0946g.m1579b(f1185a, "checkServerCertificateNew: cancel");
            if (callback != null) {
                callback.onCancel(context, str);
            } else {
                sslErrorHandler.cancel();
            }
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return C0941b.m1550a(x509Certificate, C0941b.m1546a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(C0941b.m1547a(str), sslError);
    }
}
