package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.a0 */
public abstract class C0774a0 {

    /* renamed from: com.huawei.hms.hatool.a0$a */
    public static class C0775a extends Exception {
        public C0775a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static C0778b0 m714a(String str, byte[] bArr, Map<String, String> map) {
        return m715a(str, bArr, map, "POST");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[ExcHandler: a (unused com.huawei.hms.hatool.a0$a), SYNTHETIC, Splitter:B:18:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00cd  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.hatool.C0778b0 m715a(java.lang.String r6, byte[] r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "hmsSdk"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0012
            com.huawei.hms.hatool.b0 r6 = new com.huawei.hms.hatool.b0
            r7 = -100
            r6.<init>(r7, r2)
            return r6
        L_0x0012:
            r1 = -102(0xffffffffffffff9a, float:NaN)
            r3 = -101(0xffffffffffffff9b, float:NaN)
            r4 = 0
            int r5 = r7.length     // Catch:{ a -> 0x011c, SecurityException -> 0x0103, SSLPeerUnverifiedException -> 0x00ea, SSLHandshakeException -> 0x00d1, ConnectException -> 0x00b8, UnknownHostException -> 0x009f, IOException -> 0x0086, all -> 0x0081 }
            java.net.HttpURLConnection r6 = m716a((java.lang.String) r6, (int) r5, (java.util.Map<java.lang.String, java.lang.String>) r8, (java.lang.String) r9)     // Catch:{ a -> 0x011c, SecurityException -> 0x0103, SSLPeerUnverifiedException -> 0x00ea, SSLHandshakeException -> 0x00d1, ConnectException -> 0x00b8, UnknownHostException -> 0x009f, IOException -> 0x0086, all -> 0x0081 }
            if (r6 != 0) goto L_0x002f
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ a -> 0x007e, SecurityException -> 0x007b, SSLPeerUnverifiedException -> 0x0078, SSLHandshakeException -> 0x0075, ConnectException -> 0x0073, UnknownHostException -> 0x0071, IOException -> 0x006f, all -> 0x006b }
            r7.<init>(r3, r2)     // Catch:{ a -> 0x007e, SecurityException -> 0x007b, SSLPeerUnverifiedException -> 0x0078, SSLHandshakeException -> 0x0075, ConnectException -> 0x0073, UnknownHostException -> 0x0071, IOException -> 0x006f, all -> 0x006b }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r4)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r4)
            if (r6 == 0) goto L_0x002e
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x002e:
            return r7
        L_0x002f:
            java.io.OutputStream r8 = r6.getOutputStream()     // Catch:{ a -> 0x007e, SecurityException -> 0x007b, SSLPeerUnverifiedException -> 0x0078, SSLHandshakeException -> 0x0075, ConnectException -> 0x0073, UnknownHostException -> 0x0071, IOException -> 0x006f, all -> 0x006b }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ a -> 0x011e, SecurityException -> 0x0105, SSLPeerUnverifiedException -> 0x00ec, SSLHandshakeException -> 0x00d3, ConnectException -> 0x00ba, UnknownHostException -> 0x00a1, IOException -> 0x0088, all -> 0x0068 }
            r9.<init>(r8)     // Catch:{ a -> 0x011e, SecurityException -> 0x0105, SSLPeerUnverifiedException -> 0x00ec, SSLHandshakeException -> 0x00d3, ConnectException -> 0x00ba, UnknownHostException -> 0x00a1, IOException -> 0x0088, all -> 0x0068 }
            r9.write(r7)     // Catch:{ a -> 0x011f, SecurityException -> 0x0106, SSLPeerUnverifiedException -> 0x00ed, SSLHandshakeException -> 0x00d4, ConnectException -> 0x00bb, UnknownHostException -> 0x00a2, IOException -> 0x0089 }
            r9.flush()     // Catch:{ a -> 0x011f, SecurityException -> 0x0106, SSLPeerUnverifiedException -> 0x00ed, SSLHandshakeException -> 0x00d4, ConnectException -> 0x00bb, UnknownHostException -> 0x00a2, IOException -> 0x0089 }
            int r7 = r6.getResponseCode()     // Catch:{ a -> 0x011f, SecurityException -> 0x0106, SSLPeerUnverifiedException -> 0x00ed, SSLHandshakeException -> 0x00d4, ConnectException -> 0x00bb, UnknownHostException -> 0x00a2, IOException -> 0x0089 }
            java.lang.String r1 = m718b(r6)     // Catch:{ a -> 0x011f, SecurityException -> 0x0065, SSLPeerUnverifiedException -> 0x0062, SSLHandshakeException -> 0x005f, ConnectException -> 0x005c, UnknownHostException -> 0x0059, IOException -> 0x0057 }
            com.huawei.hms.hatool.b0 r4 = new com.huawei.hms.hatool.b0     // Catch:{ a -> 0x011f, SecurityException -> 0x0065, SSLPeerUnverifiedException -> 0x0062, SSLHandshakeException -> 0x005f, ConnectException -> 0x005c, UnknownHostException -> 0x0059, IOException -> 0x0057 }
            r4.<init>(r7, r1)     // Catch:{ a -> 0x011f, SecurityException -> 0x0065, SSLPeerUnverifiedException -> 0x0062, SSLHandshakeException -> 0x005f, ConnectException -> 0x005c, UnknownHostException -> 0x0059, IOException -> 0x0057 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x0056
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x0056:
            return r4
        L_0x0057:
            r1 = r7
            goto L_0x0089
        L_0x0059:
            r1 = r7
            goto L_0x00a2
        L_0x005c:
            r1 = r7
            goto L_0x00bb
        L_0x005f:
            r1 = r7
            goto L_0x00d4
        L_0x0062:
            r1 = r7
            goto L_0x00ed
        L_0x0065:
            r1 = r7
            goto L_0x0106
        L_0x0068:
            r7 = move-exception
            goto L_0x0137
        L_0x006b:
            r7 = move-exception
            r8 = r4
            goto L_0x0137
        L_0x006f:
            r8 = r4
            goto L_0x0088
        L_0x0071:
            r8 = r4
            goto L_0x00a1
        L_0x0073:
            r8 = r4
            goto L_0x00ba
        L_0x0075:
            r8 = r4
            goto L_0x00d3
        L_0x0078:
            r8 = r4
            goto L_0x00ec
        L_0x007b:
            r8 = r4
            goto L_0x0105
        L_0x007e:
            r8 = r4
            goto L_0x011e
        L_0x0081:
            r7 = move-exception
            r6 = r4
            r8 = r6
            goto L_0x0137
        L_0x0086:
            r6 = r4
            r8 = r6
        L_0x0088:
            r9 = r4
        L_0x0089:
            java.lang.String r7 = "events PostRequest(byte[]): IOException occurred."
            com.huawei.hms.hatool.C0841y.m1092f(r0, r7)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ all -> 0x0135 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x009e
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x009e:
            return r7
        L_0x009f:
            r6 = r4
            r8 = r6
        L_0x00a1:
            r9 = r4
        L_0x00a2:
            java.lang.String r7 = "No address associated with hostname or No network"
            com.huawei.hms.hatool.C0841y.m1092f(r0, r7)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ all -> 0x0135 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x00b7
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x00b7:
            return r7
        L_0x00b8:
            r6 = r4
            r8 = r6
        L_0x00ba:
            r9 = r4
        L_0x00bb:
            java.lang.String r7 = "Network is unreachable or Connection refused"
            com.huawei.hms.hatool.C0841y.m1092f(r0, r7)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ all -> 0x0135 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x00d0
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x00d0:
            return r7
        L_0x00d1:
            r6 = r4
            r8 = r6
        L_0x00d3:
            r9 = r4
        L_0x00d4:
            java.lang.String r7 = "Chain validation failed,Certificate expired"
            com.huawei.hms.hatool.C0841y.m1092f(r0, r7)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ all -> 0x0135 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x00e9
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x00e9:
            return r7
        L_0x00ea:
            r6 = r4
            r8 = r6
        L_0x00ec:
            r9 = r4
        L_0x00ed:
            java.lang.String r7 = "Certificate has not been verified,Request is restricted!"
            com.huawei.hms.hatool.C0841y.m1092f(r0, r7)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ all -> 0x0135 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x0102
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x0102:
            return r7
        L_0x0103:
            r6 = r4
            r8 = r6
        L_0x0105:
            r9 = r4
        L_0x0106:
            java.lang.String r7 = "SecurityException with HttpClient. Please check INTERNET permission."
            com.huawei.hms.hatool.C0841y.m1092f(r0, r7)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ all -> 0x0135 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x011b
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x011b:
            return r7
        L_0x011c:
            r6 = r4
            r8 = r6
        L_0x011e:
            r9 = r4
        L_0x011f:
            java.lang.String r7 = "PostRequest(byte[]): No ssl socket factory set!"
            com.huawei.hms.hatool.C0841y.m1092f(r0, r7)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.b0 r7 = new com.huawei.hms.hatool.b0     // Catch:{ all -> 0x0135 }
            r7.<init>(r3, r2)     // Catch:{ all -> 0x0135 }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r9)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x0134
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x0134:
            return r7
        L_0x0135:
            r7 = move-exception
            r4 = r9
        L_0x0137:
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r4)
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r8)
            if (r6 == 0) goto L_0x0142
            com.huawei.hms.hatool.C0826r0.m1018a((java.net.HttpURLConnection) r6)
        L_0x0142:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.C0774a0.m715a(java.lang.String, byte[], java.util.Map, java.lang.String):com.huawei.hms.hatool.b0");
    }

    /* renamed from: a */
    public static HttpURLConnection m716a(String str, int i, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            C0841y.m1084b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        m717a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(i));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry next : map.entrySet()) {
                String str3 = (String) next.getKey();
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty(str3, (String) next.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m717a(java.net.HttpURLConnection r3) {
        /*
            java.lang.String r0 = "hmsSdk"
            boolean r1 = r3 instanceof javax.net.ssl.HttpsURLConnection
            if (r1 == 0) goto L_0x0039
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3
            r1 = 0
            android.content.Context r2 = com.huawei.hms.hatool.C0777b.m729f()     // Catch:{ NoSuchAlgorithmException -> 0x001e, KeyStoreException -> 0x001b, GeneralSecurityException -> 0x0018, IOException -> 0x0015, IllegalAccessException -> 0x0012 }
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactory r1 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x001e, KeyStoreException -> 0x001b, GeneralSecurityException -> 0x0018, IOException -> 0x0015, IllegalAccessException -> 0x0012 }
            goto L_0x0023
        L_0x0012:
            java.lang.String r2 = "getSocketFactory(): Illegal Access Exception "
            goto L_0x0020
        L_0x0015:
            java.lang.String r2 = "getSocketFactory(): IO Exception!"
            goto L_0x0020
        L_0x0018:
            java.lang.String r2 = "getSocketFactory(): General Security Exception"
            goto L_0x0020
        L_0x001b:
            java.lang.String r2 = "getSocketFactory(): Key Store exception"
            goto L_0x0020
        L_0x001e:
            java.lang.String r2 = "getSocketFactory(): Algorithm Exception!"
        L_0x0020:
            com.huawei.hms.hatool.C0841y.m1092f(r0, r2)
        L_0x0023:
            if (r1 == 0) goto L_0x0031
            r3.setSSLSocketFactory(r1)
            com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier r0 = new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier
            r0.<init>()
            r3.setHostnameVerifier(r0)
            goto L_0x0039
        L_0x0031:
            com.huawei.hms.hatool.a0$a r3 = new com.huawei.hms.hatool.a0$a
            java.lang.String r0 = "No ssl socket factory set"
            r3.<init>(r0)
            throw r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.C0774a0.m717a(java.net.HttpURLConnection):void");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.huawei.hms.hatool.C0841y.m1092f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r4 = r4.getResponseCode();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m718b(java.net.HttpURLConnection r4) {
        /*
            r0 = 0
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ IOException -> 0x000f }
            java.lang.String r4 = com.huawei.hms.hatool.C0826r0.m1014a((java.io.InputStream) r0)     // Catch:{ IOException -> 0x000f }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r0)
            return r4
        L_0x000d:
            r4 = move-exception
            goto L_0x002f
        L_0x000f:
            int r4 = r4.getResponseCode()     // Catch:{ all -> 0x000d }
            java.lang.String r1 = "hmsSdk"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x000d }
            r2.<init>()     // Catch:{ all -> 0x000d }
            java.lang.String r3 = "When Response Content From Connection inputStream operation exception! "
            r2.append(r3)     // Catch:{ all -> 0x000d }
            r2.append(r4)     // Catch:{ all -> 0x000d }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x000d }
            com.huawei.hms.hatool.C0841y.m1092f(r1, r4)     // Catch:{ all -> 0x000d }
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r0)
            java.lang.String r4 = ""
            return r4
        L_0x002f:
            com.huawei.hms.hatool.C0826r0.m1015a((java.io.Closeable) r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.C0774a0.m718b(java.net.HttpURLConnection):java.lang.String");
    }
}
