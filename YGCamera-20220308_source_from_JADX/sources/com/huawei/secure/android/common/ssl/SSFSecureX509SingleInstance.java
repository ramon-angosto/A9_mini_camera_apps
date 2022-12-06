package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.C0942c;
import com.huawei.secure.android.common.ssl.util.C0944e;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.X509TrustManager;

public class SSFSecureX509SingleInstance {

    /* renamed from: a */
    private static final String f1145a = "SSFSecureX509SingleInstance";

    /* renamed from: b */
    private static volatile SecureX509TrustManager f1146b;

    private SSFSecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (context != null) {
            C0942c.m1557a(context);
            if (f1146b == null) {
                synchronized (SSFSecureX509SingleInstance.class) {
                    if (f1146b == null) {
                        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                        if (filesBksIS == null) {
                            C0946g.m1580c(f1145a, "get assets bks");
                            filesBksIS = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            C0946g.m1580c(f1145a, "get files bks");
                        }
                        f1146b = new SecureX509TrustManager(filesBksIS, "", true);
                        new C0944e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[]{context});
                    }
                }
            }
            return f1146b;
        }
        throw new NullPointerException("context is null");
    }

    public static void updateBks(InputStream inputStream) {
        C0946g.m1580c(f1145a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (!(inputStream == null || f1146b == null)) {
            f1146b = new SecureX509TrustManager(inputStream, "", true);
            String str = f1145a;
            C0946g.m1577a(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.m1504a((X509TrustManager) f1146b);
            SASFCompatiableSystemCA.m1502a((X509TrustManager) f1146b);
        }
        String str2 = f1145a;
        C0946g.m1577a(str2, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
