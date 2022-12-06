package com.huawei.android.pushagent.c.a;

import com.huawei.android.pushagent.plugin.tools.BLocation;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class i implements X509TrustManager {
    X509TrustManager a;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(android.content.Context r6) throws java.lang.Exception {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            java.lang.String r1 = "X509"
            javax.net.ssl.TrustManagerFactory r1 = javax.net.ssl.TrustManagerFactory.getInstance(r1)     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "BKS"
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r2)     // Catch:{ all -> 0x005b }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "rootca_0727.bks"
            java.io.InputStream r6 = r6.open(r3)     // Catch:{ all -> 0x005b }
            r6.reset()     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = com.huawei.android.pushagent.c.a.d.b()     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = com.huawei.android.pushagent.c.a.a.f.b((android.content.Context) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0059 }
            char[] r0 = r0.toCharArray()     // Catch:{ all -> 0x0059 }
            r2.load(r6, r0)     // Catch:{ all -> 0x0059 }
            r1.init(r2)     // Catch:{ all -> 0x0059 }
            javax.net.ssl.TrustManager[] r0 = r1.getTrustManagers()     // Catch:{ all -> 0x0059 }
            r1 = 0
        L_0x0034:
            int r2 = r0.length     // Catch:{ all -> 0x0059 }
            if (r1 >= r2) goto L_0x004c
            r2 = r0[r1]     // Catch:{ all -> 0x0059 }
            boolean r2 = r2 instanceof javax.net.ssl.X509TrustManager     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0049
            r0 = r0[r1]     // Catch:{ all -> 0x0059 }
            javax.net.ssl.X509TrustManager r0 = (javax.net.ssl.X509TrustManager) r0     // Catch:{ all -> 0x0059 }
            r5.a = r0     // Catch:{ all -> 0x0059 }
            if (r6 == 0) goto L_0x0048
            r6.close()
        L_0x0048:
            return
        L_0x0049:
            int r1 = r1 + 1
            goto L_0x0034
        L_0x004c:
            if (r6 == 0) goto L_0x0051
            r6.close()
        L_0x0051:
            java.lang.Exception r6 = new java.lang.Exception
            java.lang.String r0 = "Couldn't initialize"
            r6.<init>(r0)
            throw r6
        L_0x0059:
            r0 = move-exception
            goto L_0x005f
        L_0x005b:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x005f:
            if (r6 == 0) goto L_0x0064
            r6.close()
        L_0x0064:
            goto L_0x0066
        L_0x0065:
            throw r0
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.a.i.<init>(android.content.Context):void");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.a(BLocation.TAG, "check ClientTrusted");
        this.a.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.a(BLocation.TAG, "check ServerTrusted");
        this.a.checkServerTrusted(x509CertificateArr, str);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
