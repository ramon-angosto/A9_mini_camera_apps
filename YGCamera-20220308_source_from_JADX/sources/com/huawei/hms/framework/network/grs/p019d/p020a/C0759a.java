package com.huawei.hms.framework.network.grs.p019d.p020a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.p019d.C0758a;
import com.huawei.hms.framework.network.grs.p019d.p021b.C0761a;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.framework.network.grs.d.a.a */
public class C0759a {
    /* renamed from: a */
    public static HttpsURLConnection m666a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection openConnection = new URL(str).openConnection();
        if (openConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            try {
                httpsURLConnection.setSSLSocketFactory(C0761a.m672a(context));
                httpsURLConnection.setHostnameVerifier(C0761a.m671a());
            } catch (IllegalArgumentException unused) {
                Logger.m478w("URLConnectionHelper", "init https ssl socket failed.");
            }
            httpsURLConnection.setConnectTimeout(HwBuildEx.VersionCodes.CUR_DEVELOPMENT);
            httpsURLConnection.setReadTimeout(HwBuildEx.VersionCodes.CUR_DEVELOPMENT);
            String b = C0758a.m665b(context, "NetworkKit-grs", str2);
            Logger.m469d("URLConnectionHelper", "request to grs server with a User-Agent header is:" + b);
            httpsURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, b);
            return httpsURLConnection;
        }
        Logger.m478w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
        return null;
    }
}
