package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C0941b;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0946g;
import com.huawei.secure.android.common.ssl.util.C0949j;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.secure.android.common.ssl.c */
public class C0937c implements X509TrustManager {

    /* renamed from: c */
    private static final String f1207c = "WebViewX509TrustManger";

    /* renamed from: a */
    private X509Certificate f1208a;

    /* renamed from: b */
    private List<X509TrustManager> f1209b = new ArrayList();

    public C0937c(Context context) {
        if (context != null) {
            C0942c.m1557a(context);
            this.f1208a = new C0949j(context).mo14807b();
            if (this.f1208a == null) {
                throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
            }
            return;
        }
        throw new NullPointerException("WebViewX509TrustManger context is null");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C0946g.m1580c(f1207c, "checkClientTrusted");
        if (!this.f1209b.isEmpty()) {
            this.f1209b.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C0946g.m1580c(f1207c, "checkServerTrusted");
        boolean z = false;
        for (int i = 0; i < x509CertificateArr.length; i++) {
            C0946g.m1577a(f1207c, "checkServerTrusted " + i + " : " + x509CertificateArr[i].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            x509CertificateArr2[i2] = x509CertificateArr[(x509CertificateArr.length - 1) - i2];
        }
        CertificateException e = new CertificateException("CBG root CA CertificateException");
        try {
            z = C0941b.m1551a(this.f1208a, x509CertificateArr2);
        } catch (NoSuchProviderException e2) {
            C0946g.m1579b(f1207c, "checkServerTrusted NoSuchProviderException: " + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            C0946g.m1579b(f1207c, "checkServerTrusted NoSuchAlgorithmException: " + e3.getMessage());
        } catch (InvalidKeyException e4) {
            C0946g.m1579b(f1207c, "checkServerTrusted InvalidKeyException: " + e4.getMessage());
        } catch (SignatureException e5) {
            C0946g.m1579b(f1207c, "checkServerTrusted SignatureException: " + e5.getMessage());
        } catch (CertificateException e6) {
            e = e6;
            C0946g.m1579b(f1207c, "checkServerTrusted CertificateException: " + e.getMessage());
        }
        if (!z) {
            throw e;
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager acceptedIssuers : this.f1209b) {
                arrayList.addAll(Arrays.asList(acceptedIssuers.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            C0946g.m1579b(f1207c, "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }
}
