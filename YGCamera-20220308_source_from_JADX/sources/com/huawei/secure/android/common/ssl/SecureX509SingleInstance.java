package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0943d;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.X509TrustManager;

public class SecureX509SingleInstance {

    /* renamed from: a */
    private static final String f1175a = "SecureX509SingleInstance";

    /* renamed from: b */
    private static volatile SecureX509TrustManager f1176b;

    private SecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            C0942c.m1557a(context);
            if (f1176b == null) {
                synchronized (SecureX509SingleInstance.class) {
                    if (f1176b == null) {
                        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                        if (filesBksIS == null) {
                            C0946g.m1580c(f1175a, "get assets bks");
                            filesBksIS = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            C0946g.m1580c(f1175a, "get files bks");
                        }
                        f1176b = new SecureX509TrustManager(filesBksIS, "");
                        new C0943d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[]{context});
                    }
                }
            }
            String str = f1175a;
            C0946g.m1577a(str, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return f1176b;
        }
        throw new NullPointerException("context is null");
    }

    public static void updateBks(InputStream inputStream) {
        C0946g.m1580c(f1175a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (!(inputStream == null || f1176b == null)) {
            f1176b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.m1508a((X509TrustManager) f1176b);
            SecureApacheSSLSocketFactory.m1506a((X509TrustManager) f1176b);
        }
        String str = f1175a;
        C0946g.m1580c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
