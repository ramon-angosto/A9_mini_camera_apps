package com.huawei.hms.framework.network.grs.p019d.p021b;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.framework.network.grs.d.b.a */
public class C0761a {
    /* renamed from: a */
    public static HostnameVerifier m671a() {
        return new StrictHostnameVerifier();
    }

    /* renamed from: a */
    public static SSLSocketFactory m672a(Context context) {
        try {
            return new SecureSSLSocketFactory((X509TrustManager) new SecureX509TrustManager(context.getAssets().open("grs_sp.bks"), ""));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
