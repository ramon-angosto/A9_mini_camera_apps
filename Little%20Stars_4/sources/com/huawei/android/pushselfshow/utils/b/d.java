package com.huawei.android.pushselfshow.utils.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import com.huawei.android.pushagent.c.a.e;
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class d {
    private static String b = "PushSelfShowLog";
    private Context a;

    public d(Context context) {
        this.a = context;
    }

    public String a() {
        String str = null;
        try {
            str = Build.VERSION.SDK_INT >= 11 ? System.getProperty("http.proxyHost") : Proxy.getHost(this.a);
            String str2 = b;
            e.b(str2, "proxyHost=" + str);
        } catch (Exception e) {
            String str3 = b;
            e.d(str3, "getProxyHost error:" + e.getMessage());
        }
        return str;
    }

    public HttpResponse a(String str, HttpClient httpClient, HttpGet httpGet) {
        StringBuilder sb;
        String str2;
        String str3;
        try {
            HttpParams params = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, 30000);
            HttpConnectionParams.setSoTimeout(params, 30000);
            HttpClientParams.setRedirecting(params, true);
            HttpProtocolParams.setUseExpectContinue(params, false);
            a((HttpRequest) httpGet, httpClient, str);
            return httpClient.execute(httpGet);
        } catch (SocketTimeoutException e) {
            str2 = b;
            sb = new StringBuilder();
            sb.append("SocketTimeoutException occur");
            str3 = e.getMessage();
            sb.append(str3);
            e.d(str2, sb.toString());
            return null;
        } catch (ClientProtocolException e2) {
            str2 = b;
            sb = new StringBuilder();
            sb.append("ClientProtocolException occur");
            str3 = e2.getMessage();
            sb.append(str3);
            e.d(str2, sb.toString());
            return null;
        } catch (IOException e3) {
            str2 = b;
            sb = new StringBuilder();
            sb.append("IOException occur");
            str3 = e3.getMessage();
            sb.append(str3);
            e.d(str2, sb.toString());
            return null;
        } catch (Exception e4) {
            str2 = b;
            sb = new StringBuilder();
            sb.append("Exception occur");
            str3 = e4.getMessage();
            sb.append(str3);
            e.d(str2, sb.toString());
            return null;
        }
    }

    public void a(HttpRequest httpRequest, HttpClient httpClient, String str) {
        httpRequest.setHeader("Accept-Encoding", "");
        String a2 = a();
        int b2 = b();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0 && a2 != null && a2.length() > 0 && b2 != -1) {
            HttpParams params = httpClient.getParams();
            ConnRouteParams.setDefaultProxy(params, new HttpHost(a(), b()));
            httpRequest.setParams(params);
        }
    }

    public int b() {
        int i = -1;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                i = Integer.parseInt(property);
            } else {
                i = Proxy.getPort(this.a);
            }
            String str = b;
            e.b(str, "proxyPort=" + i);
        } catch (Exception e) {
            String str2 = b;
            e.d(str2, "proxyPort error:" + e.getMessage());
        }
        return i;
    }
}
