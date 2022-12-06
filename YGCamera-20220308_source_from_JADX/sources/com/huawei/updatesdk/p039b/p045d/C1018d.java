package com.huawei.updatesdk.p039b.p045d;

import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* renamed from: com.huawei.updatesdk.b.d.d */
public class C1018d {

    /* renamed from: a */
    private static volatile C1018d f1383a;

    /* renamed from: a */
    public static synchronized C1018d m1901a() {
        C1018d dVar;
        synchronized (C1018d.class) {
            if (f1383a == null) {
                f1383a = new C1018d();
            }
            dVar = f1383a;
        }
        return dVar;
    }

    /* renamed from: b */
    public static String m1902b() {
        String b = C0985a.m1757c().mo14893b();
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        String str = b + "/updatesdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    /* renamed from: a */
    public HttpURLConnection mo14994a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(7000);
        httpURLConnection.setReadTimeout(HwBuildEx.VersionCodes.CUR_DEVELOPMENT);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setInstanceFollowRedirects(true);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(SecureSSLSocketFactory.getInstance(C0985a.m1757c().mo14892a()));
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        return httpURLConnection;
    }
}
