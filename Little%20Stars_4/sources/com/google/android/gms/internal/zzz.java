package com.google.android.gms.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzz implements zzy {
    private final zza zzaE;
    private final SSLSocketFactory zzaF;

    public interface zza {
        String zzh(String str);
    }

    public zzz() {
        this((zza) null);
    }

    public zzz(zza zza2) {
        this(zza2, (SSLSocketFactory) null);
    }

    public zzz(zza zza2, SSLSocketFactory sSLSocketFactory) {
        this.zzaE = zza2;
        this.zzaF = sSLSocketFactory;
    }

    private HttpURLConnection zza(URL url, zzk<?> zzk) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection zza2 = zza(url);
        int zzs = zzk.zzs();
        zza2.setConnectTimeout(zzs);
        zza2.setReadTimeout(zzs);
        zza2.setUseCaches(false);
        zza2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.zzaF) != null) {
            ((HttpsURLConnection) zza2).setSSLSocketFactory(sSLSocketFactory);
        }
        return zza2;
    }

    private static HttpEntity zza(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r3.setRequestMethod(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        zzb(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r3.setRequestMethod(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(java.net.HttpURLConnection r3, com.google.android.gms.internal.zzk<?> r4) throws java.io.IOException, com.google.android.gms.internal.zza {
        /*
            int r0 = r4.getMethod()
            java.lang.String r1 = "POST"
            switch(r0) {
                case -1: goto L_0x0033;
                case 0: goto L_0x002d;
                case 1: goto L_0x0026;
                case 2: goto L_0x0020;
                case 3: goto L_0x001d;
                case 4: goto L_0x001a;
                case 5: goto L_0x0017;
                case 6: goto L_0x0014;
                case 7: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Unknown method type."
            r3.<init>(r4)
            throw r3
        L_0x0011:
            java.lang.String r0 = "PATCH"
            goto L_0x0022
        L_0x0014:
            java.lang.String r4 = "TRACE"
            goto L_0x002f
        L_0x0017:
            java.lang.String r4 = "OPTIONS"
            goto L_0x002f
        L_0x001a:
            java.lang.String r4 = "HEAD"
            goto L_0x002f
        L_0x001d:
            java.lang.String r4 = "DELETE"
            goto L_0x002f
        L_0x0020:
            java.lang.String r0 = "PUT"
        L_0x0022:
            r3.setRequestMethod(r0)
            goto L_0x0029
        L_0x0026:
            r3.setRequestMethod(r1)
        L_0x0029:
            zzb(r3, r4)
            goto L_0x0058
        L_0x002d:
            java.lang.String r4 = "GET"
        L_0x002f:
            r3.setRequestMethod(r4)
            goto L_0x0058
        L_0x0033:
            byte[] r0 = r4.zzl()
            if (r0 == 0) goto L_0x0058
            r2 = 1
            r3.setDoOutput(r2)
            r3.setRequestMethod(r1)
            java.lang.String r4 = r4.zzk()
            java.lang.String r1 = "Content-Type"
            r3.addRequestProperty(r1, r4)
            java.io.DataOutputStream r4 = new java.io.DataOutputStream
            java.io.OutputStream r3 = r3.getOutputStream()
            r4.<init>(r3)
            r4.write(r0)
            r4.close()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzz.zza(java.net.HttpURLConnection, com.google.android.gms.internal.zzk):void");
    }

    private static void zzb(HttpURLConnection httpURLConnection, zzk<?> zzk) throws IOException, zza {
        byte[] zzp = zzk.zzp();
        if (zzp != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, zzk.zzo());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzp);
            dataOutputStream.close();
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection zza(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse zza(zzk<?> zzk, Map<String, String> map) throws IOException, zza {
        String str;
        String url = zzk.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(zzk.getHeaders());
        hashMap.putAll(map);
        zza zza2 = this.zzaE;
        if (zza2 != null) {
            str = zza2.zzh(url);
            if (str == null) {
                String valueOf = String.valueOf(url);
                throw new IOException(valueOf.length() != 0 ? "URL blocked by rewriter: ".concat(valueOf) : new String("URL blocked by rewriter: "));
            }
        } else {
            str = url;
        }
        HttpURLConnection zza3 = zza(new URL(str), zzk);
        for (String str2 : hashMap.keySet()) {
            zza3.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        zza(zza3, zzk);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (zza3.getResponseCode() != -1) {
            BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, zza3.getResponseCode(), zza3.getResponseMessage()));
            basicHttpResponse.setEntity(zza(zza3));
            for (Map.Entry entry : zza3.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
                }
            }
            return basicHttpResponse;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }
}
