package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.opendevice.d */
/* compiled from: HttpClient */
public abstract class C0849d {

    /* renamed from: com.huawei.hms.opendevice.d$a */
    /* compiled from: HttpClient */
    private enum C0850a {
        GET("GET"),
        POST("POST");
        

        /* renamed from: d */
        public String f787d;

        /* access modifiers changed from: public */
        C0850a(String str) {
            this.f787d = str;
        }

        /* renamed from: a */
        public String mo14159a() {
            return this.f787d;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v38, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v40, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v41, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v43, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v44, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v47, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v48, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v49, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r8v3, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r8v42 */
    /* JADX WARNING: type inference failed for: r8v46 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00b8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1135a(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            java.lang.String r0 = "close connection"
            java.lang.String r1 = "PushHttpClient"
            r2 = 0
            if (r9 == 0) goto L_0x011f
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L_0x011f
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 == 0) goto L_0x0015
            goto L_0x011f
        L_0x0015:
            r3 = -1
            com.huawei.hms.opendevice.d$a r4 = com.huawei.hms.opendevice.C0849d.C0850a.POST     // Catch:{ IOException -> 0x00e6, RuntimeException -> 0x00cd, Exception -> 0x00b4, all -> 0x00ad }
            java.lang.String r4 = r4.mo14159a()     // Catch:{ IOException -> 0x00e6, RuntimeException -> 0x00cd, Exception -> 0x00b4, all -> 0x00ad }
            java.net.HttpURLConnection r7 = m1136a((android.content.Context) r7, (java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.String>) r10, (java.lang.String) r4)     // Catch:{ IOException -> 0x00e6, RuntimeException -> 0x00cd, Exception -> 0x00b4, all -> 0x00ad }
            if (r7 != 0) goto L_0x0032
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r2)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r2)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r2)
            com.huawei.hms.opendevice.C0867s.m1189a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.m1379i(r1, r0)
            return r2
        L_0x0032:
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00ab, RuntimeException -> 0x00a9, Exception -> 0x00a7, all -> 0x00a0 }
            java.io.OutputStream r10 = r7.getOutputStream()     // Catch:{ IOException -> 0x00ab, RuntimeException -> 0x00a9, Exception -> 0x00a7, all -> 0x00a0 }
            r8.<init>(r10)     // Catch:{ IOException -> 0x00ab, RuntimeException -> 0x00a9, Exception -> 0x00a7, all -> 0x00a0 }
            java.lang.String r10 = "UTF-8"
            byte[] r9 = r9.getBytes(r10)     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            r8.write(r9)     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            r8.flush()     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            int r3 = r7.getResponseCode()     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            r9.<init>()     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            java.lang.String r10 = "http post response code: "
            r9.append(r10)     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            r9.append(r3)     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            com.huawei.hms.support.log.HMSLog.m1374d(r1, r9)     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            r9 = 400(0x190, float:5.6E-43)
            if (r3 < r9) goto L_0x0068
            java.io.InputStream r9 = r7.getErrorStream()     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
            goto L_0x006c
        L_0x0068:
            java.io.InputStream r9 = r7.getInputStream()     // Catch:{ IOException -> 0x009d, RuntimeException -> 0x009b, Exception -> 0x0099, all -> 0x0093 }
        L_0x006c:
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0090, RuntimeException -> 0x008d, Exception -> 0x008b, all -> 0x0085 }
            r10.<init>(r9)     // Catch:{ IOException -> 0x0090, RuntimeException -> 0x008d, Exception -> 0x008b, all -> 0x0085 }
            java.lang.String r2 = com.huawei.hms.opendevice.C0867s.m1185a((java.io.InputStream) r10)     // Catch:{ IOException -> 0x00ea, RuntimeException -> 0x00d1, Exception -> 0x00b8 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r8)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)
            com.huawei.hms.opendevice.C0867s.m1189a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.m1379i(r1, r0)
            return r2
        L_0x0085:
            r10 = move-exception
            r6 = r2
            r2 = r10
            r10 = r6
            goto L_0x010f
        L_0x008b:
            r10 = r2
            goto L_0x00b8
        L_0x008d:
            r10 = r2
            goto L_0x00d1
        L_0x0090:
            r10 = r2
            goto L_0x00ea
        L_0x0093:
            r9 = move-exception
            r10 = r2
            r2 = r9
            r9 = r10
            goto L_0x010f
        L_0x0099:
            r9 = r2
            goto L_0x00b7
        L_0x009b:
            r9 = r2
            goto L_0x00d0
        L_0x009d:
            r9 = r2
            goto L_0x00e9
        L_0x00a0:
            r8 = move-exception
            r9 = r2
            r10 = r9
            r2 = r8
            r8 = r10
            goto L_0x010f
        L_0x00a7:
            r8 = r2
            goto L_0x00b6
        L_0x00a9:
            r8 = r2
            goto L_0x00cf
        L_0x00ab:
            r8 = r2
            goto L_0x00e8
        L_0x00ad:
            r7 = move-exception
            r8 = r2
            r9 = r8
            r10 = r9
            r2 = r7
            r7 = r10
            goto L_0x010f
        L_0x00b4:
            r7 = r2
            r8 = r7
        L_0x00b6:
            r9 = r8
        L_0x00b7:
            r10 = r9
        L_0x00b8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r4.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r5 = "http execute encounter unknown exception - http code:"
            r4.append(r5)     // Catch:{ all -> 0x010e }
            r4.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x010e }
            com.huawei.hms.support.log.HMSLog.m1380w(r1, r3)     // Catch:{ all -> 0x010e }
            goto L_0x00fe
        L_0x00cd:
            r7 = r2
            r8 = r7
        L_0x00cf:
            r9 = r8
        L_0x00d0:
            r10 = r9
        L_0x00d1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r4.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r5 = "http execute encounter RuntimeException - http code:"
            r4.append(r5)     // Catch:{ all -> 0x010e }
            r4.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x010e }
            com.huawei.hms.support.log.HMSLog.m1380w(r1, r3)     // Catch:{ all -> 0x010e }
            goto L_0x00fe
        L_0x00e6:
            r7 = r2
            r8 = r7
        L_0x00e8:
            r9 = r8
        L_0x00e9:
            r10 = r9
        L_0x00ea:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r4.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r5 = "http execute encounter IOException - http code:"
            r4.append(r5)     // Catch:{ all -> 0x010e }
            r4.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x010e }
            com.huawei.hms.support.log.HMSLog.m1380w(r1, r3)     // Catch:{ all -> 0x010e }
        L_0x00fe:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r8)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)
            com.huawei.hms.opendevice.C0867s.m1189a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.m1379i(r1, r0)
            return r2
        L_0x010e:
            r2 = move-exception
        L_0x010f:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r8)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)
            com.huawei.hms.opendevice.C0867s.m1189a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.m1379i(r1, r0)
            throw r2
        L_0x011f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.C0849d.m1135a(android.content.Context, java.lang.String, java.lang.String, java.util.Map):java.lang.String");
    }

    /* renamed from: a */
    public static HttpURLConnection m1136a(Context context, String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        m1137a(context, httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry next : map.entrySet()) {
                String str3 = (String) next.getKey();
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty(str3, URLEncoder.encode(next.getValue() == null ? "" : (String) next.getValue(), Key.STRING_CHARSET_NAME));
                }
            }
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    public static void m1137a(Context context, HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SecureSSLSocketFactory secureSSLSocketFactory = null;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(context);
            } catch (NoSuchAlgorithmException unused) {
                HMSLog.m1380w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
            } catch (KeyStoreException unused2) {
                HMSLog.m1380w("PushHttpClient", "Get SocketFactory Key Store exception.");
            } catch (GeneralSecurityException unused3) {
                HMSLog.m1380w("PushHttpClient", "Get SocketFactory General Security Exception.");
            } catch (IOException unused4) {
                HMSLog.m1380w("PushHttpClient", "Get SocketFactory IO Exception.");
            } catch (IllegalAccessException unused5) {
                HMSLog.m1380w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
            } catch (IllegalArgumentException unused6) {
                HMSLog.m1380w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
            }
            if (secureSSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
                httpsURLConnection.setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                return;
            }
            throw new Exception("No ssl socket factory set.");
        }
    }
}
