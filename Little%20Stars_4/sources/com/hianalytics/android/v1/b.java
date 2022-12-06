package com.hianalytics.android.v1;

import javax.net.ssl.HttpsURLConnection;

public final class b {
    private static HttpsURLConnection a;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0085 A[SYNTHETIC, Splitter:B:24:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A[SYNTHETIC, Splitter:B:33:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r5, byte[] r6) {
        /*
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            java.net.URLConnection r5 = r2.openConnection()     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            com.hianalytics.android.a.a.a.h()     // Catch:{ IOException -> 0x0065 }
            java.lang.String r2 = "POST"
            r5.setRequestMethod(r2)     // Catch:{ IOException -> 0x0065 }
            r2 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0065 }
            r2 = 1
            r5.setDoOutput(r2)     // Catch:{ IOException -> 0x0065 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded; charset=UTF-8"
            r5.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0065 }
            java.lang.String r3 = "Content-Length"
            int r4 = r6.length     // Catch:{ IOException -> 0x0065 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0065 }
            r5.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0065 }
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch:{ IOException -> 0x0065 }
            r1.write(r6)     // Catch:{ IOException -> 0x0065 }
            r1.flush()     // Catch:{ IOException -> 0x0065 }
            int r6 = r5.getResponseCode()     // Catch:{ IOException -> 0x0065 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0065 }
            java.lang.String r4 = "connHttp.getResponseCode() = "
            r3.<init>(r4)     // Catch:{ IOException -> 0x0065 }
            r3.append(r6)     // Catch:{ IOException -> 0x0065 }
            r3.toString()     // Catch:{ IOException -> 0x0065 }
            com.hianalytics.android.a.a.a.h()     // Catch:{ IOException -> 0x0065 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r6 != r3) goto L_0x0052
            r0 = 1
        L_0x0052:
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005c:
            if (r5 == 0) goto L_0x0064
            r5.disconnect()
            com.hianalytics.android.a.a.a.h()
        L_0x0064:
            return r0
        L_0x0065:
            r6 = move-exception
            goto L_0x006c
        L_0x0067:
            r6 = move-exception
            r5 = r1
            goto L_0x0097
        L_0x006a:
            r6 = move-exception
            r5 = r1
        L_0x006c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = "connHttp error:"
            r2.<init>(r3)     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x0096 }
            r2.append(r3)     // Catch:{ all -> 0x0096 }
            r2.toString()     // Catch:{ all -> 0x0096 }
            com.hianalytics.android.a.a.a.h()     // Catch:{ all -> 0x0096 }
            r6.printStackTrace()     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x008d
            r1.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008d:
            if (r5 == 0) goto L_0x0095
            r5.disconnect()
            com.hianalytics.android.a.a.a.h()
        L_0x0095:
            return r0
        L_0x0096:
            r6 = move-exception
        L_0x0097:
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a1
        L_0x009d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a1:
            if (r5 == 0) goto L_0x00a9
            r5.disconnect()
            com.hianalytics.android.a.a.a.h()
        L_0x00a9:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hianalytics.android.v1.b.a(java.lang.String, byte[]):boolean");
    }
}
