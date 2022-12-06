package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* renamed from: com.huawei.secure.android.common.ssl.util.j */
public class C0949j {

    /* renamed from: b */
    private static final String f1249b = "X509CertificateUtil";

    /* renamed from: c */
    public static final String f1250c = "hmsrootcas.bks";

    /* renamed from: d */
    public static final String f1251d = "";

    /* renamed from: e */
    public static final String f1252e = "bks";

    /* renamed from: f */
    public static final String f1253f = "052root";

    /* renamed from: g */
    private static final String f1254g = "hmsincas.bks";

    /* renamed from: h */
    private static final String f1255h = "huawei cbg application integration ca";

    /* renamed from: a */
    private Context f1256a;

    public C0949j(Context context) {
        this.f1256a = context;
    }

    /* renamed from: a */
    public X509Certificate mo14806a(String str, String str2) {
        InputStream inputStream;
        X509Certificate x509Certificate;
        try {
            KeyStore instance = KeyStore.getInstance(f1252e);
            inputStream = this.f1256a.getAssets().open(str);
            try {
                inputStream.reset();
                instance.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) instance.getCertificate(str2);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                e = e;
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            e = e2;
            inputStream = null;
            try {
                C0946g.m1579b(f1249b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                C0945f.m1570a(inputStream);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                C0945f.m1570a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            C0945f.m1570a(inputStream);
            throw th;
        }
        C0945f.m1570a(inputStream);
        return x509Certificate;
    }

    /* renamed from: b */
    public X509Certificate mo14807b() {
        return mo14806a("hmsrootcas.bks", f1253f);
    }

    /* renamed from: a */
    public X509Certificate mo14805a() {
        return mo14806a(f1254g, f1255h);
    }
}
