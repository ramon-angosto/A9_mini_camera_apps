package com.bytedance.sdk.component.d.b;

import com.bytedance.sdk.component.d.d;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultHttpClient */
public class a implements d<d> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14, types: [byte[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.d.b.d<byte[]> a(com.bytedance.sdk.component.d.e r10) {
        /*
            r9 = this;
            java.lang.String r0 = "InternalHttpClient"
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r4 = r10.a()     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            r4 = 5000(0x1388, float:7.006E-42)
            r3.setConnectTimeout(r4)     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            r3.setReadTimeout(r4)     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            r3.connect()     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            java.io.InputStream r4 = r3.getInputStream()     // Catch:{ MalformedURLException -> 0x008e, IOException -> 0x006d, all -> 0x0069 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ MalformedURLException -> 0x0066, IOException -> 0x0063, all -> 0x0060 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x0066, IOException -> 0x0063, all -> 0x0060 }
            r6.<init>()     // Catch:{ MalformedURLException -> 0x0066, IOException -> 0x0063, all -> 0x0060 }
        L_0x0030:
            int r7 = r4.read(r5)     // Catch:{ MalformedURLException -> 0x005d, IOException -> 0x005a }
            r8 = -1
            if (r7 == r8) goto L_0x003b
            r6.write(r5, r1, r7)     // Catch:{ MalformedURLException -> 0x005d, IOException -> 0x005a }
            goto L_0x0030
        L_0x003b:
            r1 = 200(0xc8, float:2.8E-43)
            byte[] r5 = r6.toByteArray()     // Catch:{ MalformedURLException -> 0x005d, IOException -> 0x005a }
            boolean r10 = r10.b()     // Catch:{ MalformedURLException -> 0x0058, IOException -> 0x0056 }
            if (r10 == 0) goto L_0x004c
            java.util.Map r10 = r9.a((java.net.HttpURLConnection) r3)     // Catch:{ MalformedURLException -> 0x0058, IOException -> 0x0056 }
            r2 = r10
        L_0x004c:
            com.bytedance.sdk.component.d.c.c.b.a(r4)
            com.bytedance.sdk.component.d.c.c.b.a(r6)
            java.lang.String r10 = "success"
            goto L_0x00b4
        L_0x0056:
            r10 = move-exception
            goto L_0x0071
        L_0x0058:
            r10 = move-exception
            goto L_0x0092
        L_0x005a:
            r10 = move-exception
            r5 = r2
            goto L_0x0071
        L_0x005d:
            r10 = move-exception
            r5 = r2
            goto L_0x0092
        L_0x0060:
            r10 = move-exception
            r6 = r2
            goto L_0x00bb
        L_0x0063:
            r10 = move-exception
            r5 = r2
            goto L_0x0070
        L_0x0066:
            r10 = move-exception
            r5 = r2
            goto L_0x0091
        L_0x0069:
            r10 = move-exception
            r4 = r2
            r6 = r4
            goto L_0x00bb
        L_0x006d:
            r10 = move-exception
            r4 = r2
            r5 = r4
        L_0x0070:
            r6 = r5
        L_0x0071:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r3.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "IOException:"
            r3.append(r7)     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r10.getMessage()     // Catch:{ all -> 0x00ba }
            r3.append(r7)     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ba }
            android.util.Log.w(r0, r3)     // Catch:{ all -> 0x00ba }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00ba }
            goto L_0x00ae
        L_0x008e:
            r10 = move-exception
            r4 = r2
            r5 = r4
        L_0x0091:
            r6 = r5
        L_0x0092:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r3.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "MalformedURLException:"
            r3.append(r7)     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r10.getMessage()     // Catch:{ all -> 0x00ba }
            r3.append(r7)     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ba }
            android.util.Log.w(r0, r3)     // Catch:{ all -> 0x00ba }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00ba }
        L_0x00ae:
            com.bytedance.sdk.component.d.c.c.b.a(r4)
            com.bytedance.sdk.component.d.c.c.b.a(r6)
        L_0x00b4:
            com.bytedance.sdk.component.d.b.d r0 = new com.bytedance.sdk.component.d.b.d
            r0.<init>(r1, r5, r10, r2)
            return r0
        L_0x00ba:
            r10 = move-exception
        L_0x00bb:
            com.bytedance.sdk.component.d.c.c.b.a(r4)
            com.bytedance.sdk.component.d.c.c.b.a(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.b.a.a(com.bytedance.sdk.component.d.e):com.bytedance.sdk.component.d.b.d");
    }

    private Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List list = (List) headerFields.get(str);
            if (list != null && list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }
}
