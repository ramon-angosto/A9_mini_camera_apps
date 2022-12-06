package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0945f;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SecureX509TrustManager implements X509TrustManager {

    /* renamed from: c */
    private static final String f1177c = SecureX509TrustManager.class.getSimpleName();

    /* renamed from: d */
    public static final String f1178d = "hmsrootcas.bks";

    /* renamed from: e */
    private static final String f1179e = "";

    /* renamed from: f */
    private static final String f1180f = "X509";

    /* renamed from: g */
    private static final String f1181g = "bks";

    /* renamed from: h */
    private static final String f1182h = "AndroidCAStore";

    /* renamed from: a */
    protected List<X509TrustManager> f1183a;

    /* renamed from: b */
    private X509Certificate[] f1184b;

    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    /* renamed from: a */
    private void m1509a() {
        C0946g.m1580c(f1177c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore instance = KeyStore.getInstance(f1182h);
            instance.load((InputStream) null, (char[]) null);
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(f1180f);
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.f1183a.add((X509TrustManager) trustManagers[i]);
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            String str = f1177c;
            C0946g.m1579b(str, "loadSystemCA: exception : " + e.getMessage());
        }
        String str2 = f1177c;
        C0946g.m1577a(str2, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C0946g.m1580c(f1177c, "checkClientTrusted: ");
        for (X509TrustManager checkServerTrusted : this.f1183a) {
            try {
                checkServerTrusted.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e) {
                String str2 = f1177c;
                C0946g.m1579b(str2, "checkServerTrusted CertificateException" + e.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        C0946g.m1580c(f1177c, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
        long currentTimeMillis = System.currentTimeMillis();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            C0946g.m1577a(f1177c, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            C0946g.m1577a(f1177c, "IssuerDN :" + x509Certificate.getIssuerDN());
            C0946g.m1577a(f1177c, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f1183a.size();
        int i = 0;
        while (i < size) {
            try {
                C0946g.m1580c(f1177c, "check server i : " + i);
                X509TrustManager x509TrustManager = this.f1183a.get(i);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    C0946g.m1580c(f1177c, "client root ca size is : " + acceptedIssuers.length);
                    for (int i2 = 0; i2 < acceptedIssuers.length; i2++) {
                        C0946g.m1577a(f1177c, "client root ca getIssuerDN :" + acceptedIssuers[i2].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                C0946g.m1580c(f1177c, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e) {
                C0946g.m1579b(f1177c, "checkServerTrusted error :" + e.getMessage() + " , time : " + i);
                if (i == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        C0946g.m1579b(f1177c, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e;
                }
                i++;
            }
        }
        C0946g.m1577a(f1177c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager acceptedIssuers : this.f1183a) {
                arrayList.addAll(Arrays.asList(acceptedIssuers.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            String str = f1177c;
            C0946g.m1579b(str, "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.f1184b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f1183a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.f1184b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.f1183a = list;
    }

    public SecureX509TrustManager(Context context, boolean z) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f1183a = new ArrayList();
        if (context != null) {
            C0942c.m1557a(context);
            if (z) {
                m1509a();
            }
            m1510a(context);
            if (this.f1183a.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    /* renamed from: a */
    private void m1510a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        boolean z;
        C0946g.m1580c(f1177c, "loadBksCA");
        long currentTimeMillis = System.currentTimeMillis();
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                C0946g.m1580c(f1177c, "get bks not from assets");
                m1511a(filesBksIS);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                String str = f1177c;
                C0946g.m1579b(str, "loadBksCA: exception : " + e.getMessage());
                z = false;
            }
        }
        z = true;
        if (!z || filesBksIS == null) {
            C0946g.m1580c(f1177c, " get bks from assets ");
            m1511a(context.getAssets().open("hmsrootcas.bks"));
        }
        String str2 = f1177c;
        C0946g.m1577a(str2, "loadBksCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    /* renamed from: a */
    private void m1511a(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(f1180f);
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, "".toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.f1183a.add((X509TrustManager) trustManagers[i]);
                }
            }
        } finally {
            C0945f.m1570a(inputStream);
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.f1183a = new ArrayList();
        m1512a(inputStream, str);
    }

    /* renamed from: a */
    private void m1512a(InputStream inputStream, String str) {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(f1180f);
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, str.toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.f1183a.add((X509TrustManager) trustManagers[i]);
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            String str2 = f1177c;
            C0946g.m1579b(str2, "loadInputStream: exception : " + e.getMessage());
        } finally {
            C0945f.m1570a(inputStream);
        }
        String str3 = f1177c;
        C0946g.m1577a(str3, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    public SecureX509TrustManager(String str, boolean z) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.f1183a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                m1512a(fileInputStream, "");
                C0945f.m1570a((InputStream) fileInputStream);
                if (z) {
                    m1509a();
                }
            } catch (Throwable th) {
                th = th;
                C0945f.m1570a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            C0945f.m1570a((InputStream) fileInputStream);
            throw th;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z) throws IllegalArgumentException {
        this.f1183a = new ArrayList();
        if (z) {
            m1509a();
        }
        m1512a(inputStream, str);
    }
}
