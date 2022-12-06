package com.meizu.cloud.pushsdk.a.d;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.meizu.cloud.pushsdk.a.a.a;
import com.meizu.cloud.pushsdk.a.d.k;
import com.meizu.cloud.pushsdk.a.h.b;
import com.meizu.cloud.pushsdk.a.h.c;
import com.meizu.cloud.pushsdk.a.h.f;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class e implements a {
    i a;

    protected static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public e(i iVar) {
        this.a = iVar;
    }

    public k a() throws IOException {
        HttpURLConnection a2 = a(this.a);
        for (String next : this.a.d().b()) {
            String a3 = this.a.a(next);
            a.b("current header name " + next + " value " + a3);
            a2.addRequestProperty(next, a3);
        }
        a(a2, this.a);
        int responseCode = a2.getResponseCode();
        return new k.a().a(responseCode).a(this.a.d()).a(a2.getResponseMessage()).a(this.a).a(a(a2)).a();
    }

    private static l a(final HttpURLConnection httpURLConnection) throws IOException {
        if (!httpURLConnection.getDoInput()) {
            return null;
        }
        final c a2 = f.a(f.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
        return new l() {
            public c a() {
                return a2;
            }
        };
    }

    private HttpURLConnection a(i iVar) throws IOException {
        String fVar = iVar.a().toString();
        HttpURLConnection a2 = a(new URL(fVar));
        a2.setConnectTimeout(60000);
        a2.setReadTimeout(60000);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if (iVar.f() && fVar.startsWith("https://push.statics")) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a2;
            httpsURLConnection.setSSLSocketFactory(com.meizu.cloud.pushsdk.platform.a.a());
            httpsURLConnection.setHostnameVerifier(com.meizu.cloud.pushsdk.platform.a.b());
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    static void a(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        int c = iVar.c();
        if (c == 0) {
            httpURLConnection.setRequestMethod("GET");
        } else if (c == 1) {
            httpURLConnection.setRequestMethod("POST");
            b(httpURLConnection, iVar);
        } else if (c == 2) {
            httpURLConnection.setRequestMethod("PUT");
            b(httpURLConnection, iVar);
        } else if (c == 3) {
            httpURLConnection.setRequestMethod("DELETE");
        } else if (c == 4) {
            httpURLConnection.setRequestMethod("HEAD");
        } else if (c == 5) {
            httpURLConnection.setRequestMethod("PATCH");
            b(httpURLConnection, iVar);
        } else {
            throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void b(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        j e = iVar.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, e.a().toString());
            b a2 = f.a(f.a(httpURLConnection.getOutputStream()));
            e.a(a2);
            a2.close();
        }
    }
}
