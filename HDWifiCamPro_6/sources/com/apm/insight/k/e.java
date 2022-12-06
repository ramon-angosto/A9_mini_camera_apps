package com.apm.insight.k;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.apm.insight.Npth;
import com.apm.insight.h;
import com.apm.insight.l.k;
import com.apm.insight.l.q;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public static boolean a = false;
    private static h b;

    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        
        final int d;

        private a(int i) {
            this.d = i;
        }
    }

    public enum b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);
        
        final int l;

        private b(int i) {
            this.l = i;
        }
    }

    public static l a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) {
        String str3;
        byte[] bArr2;
        String str4;
        StringBuilder sb;
        String str5;
        if (Npth.isStopUpload()) {
            return new l(201);
        }
        if (str == null) {
            return new l(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str6 = null;
        if (a.GZIP == aVar && length > 128) {
            bArr = b(bArr);
            str6 = "gzip";
        } else if (a.DEFLATER == aVar && length > 128) {
            bArr = a(bArr);
            str6 = "deflate";
        }
        byte[] bArr3 = bArr;
        String str7 = str6;
        if (bArr3 == null) {
            return new l(202);
        }
        if (!z) {
            return a(str, bArr3, str2, str7, ShareTarget.METHOD_POST, true, false);
        }
        byte[] a2 = h.i().getEncryptImpl().a(bArr3);
        if (a2 != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                str5 = "?";
                if (!str.endsWith(str5)) {
                    sb = new StringBuilder();
                }
                bArr2 = a2;
                str4 = str + "tt_data=a";
                str3 = "application/octet-stream;tt-data=a";
            } else {
                str5 = "&";
                if (!str.endsWith(str5)) {
                    sb = new StringBuilder();
                }
                bArr2 = a2;
                str4 = str + "tt_data=a";
                str3 = "application/octet-stream;tt-data=a";
            }
            sb.append(str);
            sb.append(str5);
            str = sb.toString();
            bArr2 = a2;
            str4 = str + "tt_data=a";
            str3 = "application/octet-stream;tt-data=a";
        } else {
            str4 = str;
            str3 = str2;
            bArr2 = bArr3;
        }
        return a(str4, bArr2, str3, str7, ShareTarget.METHOD_POST, true, true);
    }

    public static l a(String str, String str2) {
        return a(str, str2, b());
    }

    public static l a(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    return a(CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z);
                }
            }
            return new l(201);
        } catch (Throwable th) {
            q.b(th);
            return new l(207, th);
        }
    }

    public static l a(String str, String str2, File... fileArr) {
        return b(str, str2, fileArr);
    }

    private static l a(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        return b(str, bArr, str2, str3, str4, z, z2);
    }

    private static String a(String str, Map map) {
        if (TextUtils.isDigitsOnly(str) || map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    if (!sb.toString().endsWith("?")) {
                        sb.append("&");
                    }
                    sb.append(d(entry.getKey().toString(), "UTF-8"));
                    sb.append("=");
                    sb.append(d(entry.getValue().toString(), "UTF-8"));
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(h hVar) {
        b = hVar;
    }

    public static boolean a() {
        return true;
    }

    public static boolean a(String str, String str2, String str3, String str4, List<String> list) {
        if (Npth.isStopUpload()) {
            return false;
        }
        try {
            j jVar = new j(str, "UTF-8", false);
            jVar.a("aid", str2);
            jVar.a("device_id", str3);
            jVar.a("os", "Android");
            jVar.a("process_name", str4);
            for (String file : list) {
                File file2 = new File(file);
                if (file2.exists()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("logtype", "alog");
                    hashMap.put("scene", "Crash");
                    jVar.a(file2.getName(), file2, (Map<String, String>) hashMap);
                }
            }
            try {
                return new JSONObject(jVar.a()).optInt("errno", -1) == 200;
            } catch (JSONException unused) {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    k.a((Closeable) byteArrayOutputStream);
                }
            }
        }
    }

    public static byte[] a(String str, Map<String, String> map, byte[] bArr) {
        try {
            return a(CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE, a(str, (Map) map), bArr, a.GZIP, "application/json; charset=utf-8", false).b();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static l b(String str, String str2) {
        return a(str, str2, a());
    }

    public static l b(String str, String str2, File... fileArr) {
        if (Npth.isStopUpload()) {
            return new l(201);
        }
        try {
            j jVar = new j(c(str, "have_dump=true&encrypt=true"), "UTF-8", true);
            jVar.a("json", str2, true);
            jVar.a("file", fileArr);
            try {
                return new l(0, new JSONObject(jVar.a()));
            } catch (JSONException e) {
                return new l(0, (Throwable) e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new l(207);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|(2:4|5)|6|7|(3:9|10|11)(1:12)|(1:14)|(1:16)|17|(4:19|(6:23|24|25|26|27|28)|35|(8:37|38|39|(6:41|42|43|44|45|46)(1:52)|53|(2:55|56)|57|59)(5:62|63|(2:65|66)|67|69))(3:70|71|72)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ all -> 0x0053, all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[Catch:{ all -> 0x0053, all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[Catch:{ all -> 0x0053, all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[Catch:{ all -> 0x0053, all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00bc A[SYNTHETIC, Splitter:B:70:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d4 A[SYNTHETIC, Splitter:B:79:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.apm.insight.k.l b(java.lang.String r2, byte[] r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7, boolean r8) {
        /*
            java.lang.String r8 = "gzip"
            r0 = 0
            com.apm.insight.k.h r1 = b     // Catch:{ all -> 0x00c6 }
            if (r1 == 0) goto L_0x000d
            com.apm.insight.k.h r1 = b     // Catch:{ all -> 0x000d }
            java.lang.String r2 = r1.a(r2, r3)     // Catch:{ all -> 0x000d }
        L_0x000d:
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x00c6 }
            r1.<init>(r2)     // Catch:{ all -> 0x00c6 }
            java.net.URLConnection r2 = r1.openConnection()     // Catch:{ all -> 0x00c6 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ all -> 0x00c6 }
            if (r7 == 0) goto L_0x001f
            r7 = 1
            r2.setDoOutput(r7)     // Catch:{ all -> 0x00c4 }
            goto L_0x0023
        L_0x001f:
            r7 = 0
            r2.setDoOutput(r7)     // Catch:{ all -> 0x00c4 }
        L_0x0023:
            if (r4 == 0) goto L_0x002a
            java.lang.String r7 = "Content-Type"
            r2.setRequestProperty(r7, r4)     // Catch:{ all -> 0x00c4 }
        L_0x002a:
            if (r5 == 0) goto L_0x0031
            java.lang.String r4 = "Content-Encoding"
            r2.setRequestProperty(r4, r5)     // Catch:{ all -> 0x00c4 }
        L_0x0031:
            java.lang.String r4 = "Accept-Encoding"
            r2.setRequestProperty(r4, r8)     // Catch:{ all -> 0x00c4 }
            if (r6 == 0) goto L_0x00bc
            r2.setRequestMethod(r6)     // Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x005b
            int r4 = r3.length     // Catch:{ all -> 0x00c4 }
            if (r4 <= 0) goto L_0x005b
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ all -> 0x0055 }
            java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ all -> 0x0055 }
            r4.<init>(r5)     // Catch:{ all -> 0x0055 }
            r4.write(r3)     // Catch:{ all -> 0x0053 }
            r4.flush()     // Catch:{ all -> 0x0053 }
            com.apm.insight.l.k.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00c4 }
            goto L_0x005b
        L_0x0053:
            r3 = move-exception
            goto L_0x0057
        L_0x0055:
            r3 = move-exception
            r4 = r0
        L_0x0057:
            com.apm.insight.l.k.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00c4 }
            throw r3     // Catch:{ all -> 0x00c4 }
        L_0x005b:
            int r3 = r2.getResponseCode()     // Catch:{ all -> 0x00c4 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x009b
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = r2.getContentEncoding()     // Catch:{ all -> 0x0097 }
            boolean r4 = r8.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0097 }
            if (r4 == 0) goto L_0x0086
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0081 }
            r4.<init>(r3)     // Catch:{ all -> 0x0081 }
            byte[] r5 = a((java.io.InputStream) r4)     // Catch:{ all -> 0x007e }
            com.apm.insight.l.k.a((java.io.Closeable) r4)     // Catch:{ all -> 0x0097 }
            goto L_0x008a
        L_0x007e:
            r5 = move-exception
            r0 = r4
            goto L_0x0082
        L_0x0081:
            r5 = move-exception
        L_0x0082:
            com.apm.insight.l.k.a((java.io.Closeable) r0)     // Catch:{ all -> 0x0097 }
            throw r5     // Catch:{ all -> 0x0097 }
        L_0x0086:
            byte[] r5 = a((java.io.InputStream) r3)     // Catch:{ all -> 0x0097 }
        L_0x008a:
            com.apm.insight.k.l r4 = c(r5)     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0093
            r2.disconnect()     // Catch:{ Exception -> 0x0093 }
        L_0x0093:
            com.apm.insight.l.k.a((java.io.Closeable) r3)
            return r4
        L_0x0097:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L_0x00c8
        L_0x009b:
            com.apm.insight.k.l r4 = new com.apm.insight.k.l     // Catch:{ all -> 0x00c4 }
            r5 = 206(0xce, float:2.89E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
            r6.<init>()     // Catch:{ all -> 0x00c4 }
            java.lang.String r7 = "http response code "
            r6.append(r7)     // Catch:{ all -> 0x00c4 }
            r6.append(r3)     // Catch:{ all -> 0x00c4 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x00c4 }
            r4.<init>((int) r5, (java.lang.String) r3)     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00b8
            r2.disconnect()     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            com.apm.insight.l.k.a((java.io.Closeable) r0)
            return r4
        L_0x00bc:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = "request method is not null"
            r3.<init>(r4)     // Catch:{ all -> 0x00c4 }
            throw r3     // Catch:{ all -> 0x00c4 }
        L_0x00c4:
            r3 = move-exception
            goto L_0x00c8
        L_0x00c6:
            r3 = move-exception
            r2 = r0
        L_0x00c8:
            com.apm.insight.l.q.a((java.lang.Throwable) r3)     // Catch:{ all -> 0x00db }
            com.apm.insight.k.l r4 = new com.apm.insight.k.l     // Catch:{ all -> 0x00db }
            r5 = 207(0xcf, float:2.9E-43)
            r4.<init>((int) r5, (java.lang.Throwable) r3)     // Catch:{ all -> 0x00db }
            if (r2 == 0) goto L_0x00d7
            r2.disconnect()     // Catch:{ Exception -> 0x00d7 }
        L_0x00d7:
            com.apm.insight.l.k.a((java.io.Closeable) r0)
            return r4
        L_0x00db:
            r3 = move-exception
            if (r2 == 0) goto L_0x00e1
            r2.disconnect()     // Catch:{ Exception -> 0x00e1 }
        L_0x00e1:
            com.apm.insight.l.k.a((java.io.Closeable) r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.e.b(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.apm.insight.k.l");
    }

    public static boolean b() {
        return true;
    }

    private static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    private static l c(byte[] bArr) {
        return new l(204, bArr);
    }

    public static String c() {
        return h.i().getJavaCrashUploadUrl();
    }

    private static String c(String str, String str2) {
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str + "?";
                }
            } else if (!str.endsWith("&")) {
                str = str + "&";
            }
            return str + str2;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String d() {
        return h.i().getAlogUploadUrl();
    }

    private static String d(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String e() {
        return h.i().getLaunchCrashUploadUrl();
    }

    public static String f() {
        return h.i().getExceptionUploadUrl();
    }

    public static String g() {
        return h.i().getNativeCrashUploadUrl();
    }
}
