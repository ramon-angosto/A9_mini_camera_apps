package com.adcolony.sdk;

import java.net.URL;

class d0 {
    private URL a;

    d0(URL url) {
        this.a = url;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            java.net.URL r2 = r6.a     // Catch:{ IOException -> 0x006f, all -> 0x006b }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x006f, all -> 0x006b }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x006f, all -> 0x006b }
            java.lang.String r3 = "POST"
            r2.setRequestMethod(r3)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r2.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r2.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            java.nio.charset.Charset r0 = com.adcolony.sdk.h.a     // Catch:{ IOException -> 0x005c, all -> 0x0059 }
            byte[] r7 = r7.getBytes(r0)     // Catch:{ IOException -> 0x005c, all -> 0x0059 }
            r5.write(r7)     // Catch:{ IOException -> 0x005c, all -> 0x0059 }
            r5.close()     // Catch:{ IOException -> 0x005c, all -> 0x0059 }
            int r7 = r2.getResponseCode()     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            r4.close()
            java.io.InputStream r0 = r2.getInputStream()
            if (r0 == 0) goto L_0x004f
            java.io.InputStream r0 = r2.getInputStream()
            r0.close()
        L_0x004f:
            r2.disconnect()
            return r7
        L_0x0053:
            r7 = move-exception
            r1 = r3
            goto L_0x005a
        L_0x0056:
            r7 = move-exception
            r1 = r3
            goto L_0x0069
        L_0x0059:
            r7 = move-exception
        L_0x005a:
            r0 = r5
            goto L_0x0076
        L_0x005c:
            r7 = move-exception
            goto L_0x0069
        L_0x005e:
            r7 = move-exception
            goto L_0x0076
        L_0x0060:
            r7 = move-exception
            r5 = r0
            goto L_0x0069
        L_0x0063:
            r7 = move-exception
            r4 = r0
            goto L_0x0076
        L_0x0066:
            r7 = move-exception
            r4 = r0
            r5 = r4
        L_0x0069:
            r0 = r2
            goto L_0x0072
        L_0x006b:
            r7 = move-exception
            r2 = r0
            r4 = r2
            goto L_0x0076
        L_0x006f:
            r7 = move-exception
            r4 = r0
            r5 = r4
        L_0x0072:
            throw r7     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r7 = move-exception
            r2 = r0
            goto L_0x005a
        L_0x0076:
            if (r0 == 0) goto L_0x007d
            if (r1 != 0) goto L_0x007d
            r0.close()
        L_0x007d:
            if (r4 == 0) goto L_0x0082
            r4.close()
        L_0x0082:
            if (r2 == 0) goto L_0x0094
            java.io.InputStream r0 = r2.getInputStream()
            if (r0 == 0) goto L_0x0091
            java.io.InputStream r0 = r2.getInputStream()
            r0.close()
        L_0x0091:
            r2.disconnect()
        L_0x0094:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.d0.a(java.lang.String):int");
    }
}
