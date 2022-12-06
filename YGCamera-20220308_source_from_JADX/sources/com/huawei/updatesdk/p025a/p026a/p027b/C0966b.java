package com.huawei.updatesdk.p025a.p026a.p027b;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* renamed from: com.huawei.updatesdk.a.a.b.b */
public class C0966b {

    /* renamed from: a */
    private HttpURLConnection f1301a = null;

    /* renamed from: com.huawei.updatesdk.a.a.b.b$a */
    public static class C0967a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f1302a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f1303b;

        /* renamed from: a */
        public int mo14881a() {
            return this.f1303b;
        }

        /* renamed from: b */
        public String mo14882b() {
            return this.f1302a;
        }
    }

    /* renamed from: a */
    private HttpURLConnection m1672a(String str, Context context) {
        URL url = new URL(str);
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(SecureSSLSocketFactory.getInstance(context));
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            return httpsURLConnection;
        } else if (openConnection instanceof HttpURLConnection) {
            return (HttpURLConnection) url.openConnection();
        } else {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032 A[SYNTHETIC, Splitter:B:21:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0041 A[SYNTHETIC, Splitter:B:28:0x0041] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m1673a(byte[] r8) {
        /*
            r7 = this;
            java.lang.String r0 = "gzip error!"
            java.lang.String r1 = "HttpsUtil"
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x002b }
            r3.<init>()     // Catch:{ IOException -> 0x002b }
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0027 }
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0027 }
            int r6 = r8.length     // Catch:{ IOException -> 0x0027 }
            r5.<init>(r3, r6)     // Catch:{ IOException -> 0x0027 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0027 }
            r2 = 0
            int r5 = r8.length     // Catch:{ IOException -> 0x0024, all -> 0x0021 }
            r4.write(r8, r2, r5)     // Catch:{ IOException -> 0x0024, all -> 0x0021 }
            r4.flush()     // Catch:{ IOException -> 0x0024, all -> 0x0021 }
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0021:
            r8 = move-exception
            r2 = r4
            goto L_0x003f
        L_0x0024:
            r8 = move-exception
            r2 = r4
            goto L_0x002d
        L_0x0027:
            r8 = move-exception
            goto L_0x002d
        L_0x0029:
            r8 = move-exception
            goto L_0x003f
        L_0x002b:
            r8 = move-exception
            r3 = r2
        L_0x002d:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r0, r8)     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r8 = move-exception
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r0, r8)
        L_0x003a:
            byte[] r8 = r3.toByteArray()
            return r8
        L_0x003f:
            if (r2 == 0) goto L_0x0049
            r2.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r2 = move-exception
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r0, r2)
        L_0x0049:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p025a.p026a.p027b.C0966b.m1673a(byte[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.updatesdk.p025a.p026a.p027b.C0966b.C0967a mo14879a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, android.content.Context r8) {
        /*
            r3 = this;
            com.huawei.updatesdk.a.a.b.b$a r0 = new com.huawei.updatesdk.a.a.b.b$a
            r0.<init>()
            r1 = 0
            java.net.HttpURLConnection r4 = r3.m1672a(r4, r8)     // Catch:{ all -> 0x00b8 }
            if (r4 != 0) goto L_0x0018
            if (r4 == 0) goto L_0x0011
            r4.disconnect()
        L_0x0011:
            com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1692a((java.io.Closeable) r1)
        L_0x0014:
            com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1692a((java.io.Closeable) r1)
            return r0
        L_0x0018:
            r3.f1301a = r4     // Catch:{ all -> 0x00b6 }
            r8 = 1
            r4.setDoInput(r8)     // Catch:{ all -> 0x00b6 }
            r4.setDoOutput(r8)     // Catch:{ all -> 0x00b6 }
            r8 = 0
            r4.setUseCaches(r8)     // Catch:{ all -> 0x00b6 }
            r8 = 5000(0x1388, float:7.006E-42)
            r4.setConnectTimeout(r8)     // Catch:{ all -> 0x00b6 }
            r8 = 10000(0x2710, float:1.4013E-41)
            r4.setReadTimeout(r8)     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = "POST"
            r4.setRequestMethod(r8)     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = "Content-Type"
            java.lang.String r2 = "application/x-gzip"
            r4.setRequestProperty(r8, r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = "Content-Encoding"
            java.lang.String r2 = "gzip"
            r4.setRequestProperty(r8, r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = "Connection"
            java.lang.String r2 = "Keep-Alive"
            r4.setRequestProperty(r8, r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = "User-Agent"
            r4.setRequestProperty(r8, r7)     // Catch:{ all -> 0x00b6 }
            java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch:{ all -> 0x00b6 }
            java.io.OutputStream r8 = r4.getOutputStream()     // Catch:{ all -> 0x00b6 }
            r7.<init>(r8)     // Catch:{ all -> 0x00b6 }
            byte[] r5 = r5.getBytes(r6)     // Catch:{ all -> 0x007a }
            byte[] r5 = r3.m1673a(r5)     // Catch:{ all -> 0x007a }
            r7.write(r5)     // Catch:{ all -> 0x007a }
            r7.flush()     // Catch:{ all -> 0x007a }
            int r5 = r4.getResponseCode()     // Catch:{ all -> 0x007a }
            int unused = r0.f1303b = r5     // Catch:{ all -> 0x007a }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 != r6) goto L_0x007c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x007a }
            java.io.InputStream r6 = r4.getInputStream()     // Catch:{ all -> 0x007a }
            r5.<init>(r6)     // Catch:{ all -> 0x007a }
            goto L_0x0085
        L_0x007a:
            r5 = move-exception
            goto L_0x00bc
        L_0x007c:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x007a }
            java.io.InputStream r6 = r4.getErrorStream()     // Catch:{ all -> 0x007a }
            r5.<init>(r6)     // Catch:{ all -> 0x007a }
        L_0x0085:
            r1 = r5
            com.huawei.updatesdk.a.a.d.b r5 = new com.huawei.updatesdk.a.a.d.b     // Catch:{ all -> 0x007a }
            r5.<init>()     // Catch:{ all -> 0x007a }
            com.huawei.updatesdk.a.a.b.a r6 = com.huawei.updatesdk.p025a.p026a.p027b.C0965a.m1669b()     // Catch:{ all -> 0x007a }
            byte[] r6 = r6.mo14878a()     // Catch:{ all -> 0x007a }
        L_0x0093:
            int r8 = r1.read(r6)     // Catch:{ all -> 0x007a }
            r2 = -1
            if (r8 == r2) goto L_0x009e
            r5.mo14884a(r6, r8)     // Catch:{ all -> 0x007a }
            goto L_0x0093
        L_0x009e:
            com.huawei.updatesdk.a.a.b.a r8 = com.huawei.updatesdk.p025a.p026a.p027b.C0965a.m1669b()     // Catch:{ all -> 0x007a }
            r8.mo14877a(r6)     // Catch:{ all -> 0x007a }
            java.lang.String r5 = r5.mo14883a()     // Catch:{ all -> 0x007a }
            java.lang.String unused = r0.f1302a = r5     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x00b1
            r4.disconnect()
        L_0x00b1:
            com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1692a((java.io.Closeable) r7)
            goto L_0x0014
        L_0x00b6:
            r5 = move-exception
            goto L_0x00bb
        L_0x00b8:
            r4 = move-exception
            r5 = r4
            r4 = r1
        L_0x00bb:
            r7 = r1
        L_0x00bc:
            if (r4 == 0) goto L_0x00c1
            r4.disconnect()
        L_0x00c1:
            com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1692a((java.io.Closeable) r7)
            com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1692a((java.io.Closeable) r1)
            goto L_0x00c9
        L_0x00c8:
            throw r5
        L_0x00c9:
            goto L_0x00c8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p025a.p026a.p027b.C0966b.mo14879a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context):com.huawei.updatesdk.a.a.b.b$a");
    }

    /* renamed from: a */
    public void mo14880a() {
        HttpURLConnection httpURLConnection = this.f1301a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
