package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public final class CertificateUtil {

    /* renamed from: a */
    private static final String f1237a = "CertificateUtil";

    private CertificateUtil() {
    }

    public static X509Certificate getHwCbgRootCA(Context context) {
        InputStream inputStream;
        X509Certificate x509Certificate = null;
        try {
            KeyStore instance = KeyStore.getInstance(C0949j.f1252e);
            inputStream = context.getAssets().open("hmsrootcas.bks");
            try {
                inputStream.reset();
                instance.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) instance.getCertificate(C0949j.f1253f);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                e = e;
                try {
                    C0946g.m1579b(f1237a, "loadBksCA: exception : " + e.getMessage());
                    C0945f.m1570a(inputStream);
                    return x509Certificate;
                } catch (Throwable th) {
                    th = th;
                    C0945f.m1570a(inputStream);
                    throw th;
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            e = e2;
            inputStream = null;
            C0946g.m1579b(f1237a, "loadBksCA: exception : " + e.getMessage());
            C0945f.m1570a(inputStream);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            C0945f.m1570a(inputStream);
            throw th;
        }
        C0945f.m1570a(inputStream);
        return x509Certificate;
    }
}
