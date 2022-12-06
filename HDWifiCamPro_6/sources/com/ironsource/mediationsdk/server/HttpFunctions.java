package com.ironsource.mediationsdk.server;

import com.ironsource.mediationsdk.H;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpFunctions {
    public static final String ERROR_PREFIX = "ERROR:";
    private static final ExecutorService a = Executors.newSingleThreadExecutor();

    public static String getStringFromURL(String str) {
        return getStringFromURL(str, (H.a) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringFromURL(java.lang.String r4, com.ironsource.mediationsdk.H.a r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0084, all -> 0x0077 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0084, all -> 0x0077 }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x0084, all -> 0x0077 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0084, all -> 0x0077 }
            r1 = 15000(0x3a98, float:2.102E-41)
            r4.setReadTimeout(r1)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            r4.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            java.lang.String r1 = "GET"
            r4.setRequestMethod(r1)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            r1 = 1
            r4.setDoInput(r1)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            r4.connect()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            int r1 = r4.getResponseCode()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 != r2) goto L_0x0035
            if (r5 == 0) goto L_0x002f
            java.lang.String r1 = "Bad Request - 400"
            r5.a(r1)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
        L_0x002f:
            if (r4 == 0) goto L_0x0034
            r4.disconnect()
        L_0x0034:
            return r0
        L_0x0035:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            java.io.InputStream r2 = r4.getInputStream()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086, all -> 0x006e }
            r1.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x006e }
        L_0x0048:
            java.lang.String r2 = r5.readLine()     // Catch:{ Exception -> 0x0086, all -> 0x006e }
            if (r2 == 0) goto L_0x0052
            r1.append(r2)     // Catch:{ Exception -> 0x0086, all -> 0x006e }
            goto L_0x0048
        L_0x0052:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0086, all -> 0x006e }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0086, all -> 0x006e }
            if (r2 == 0) goto L_0x0065
            if (r4 == 0) goto L_0x0061
            r4.disconnect()
        L_0x0061:
            r5.close()
            return r0
        L_0x0065:
            if (r4 == 0) goto L_0x006a
            r4.disconnect()
        L_0x006a:
            r5.close()
            return r1
        L_0x006e:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x0079
        L_0x0073:
            r5 = move-exception
            goto L_0x0079
        L_0x0075:
            r5 = r0
            goto L_0x0086
        L_0x0077:
            r5 = move-exception
            r4 = r0
        L_0x0079:
            if (r4 == 0) goto L_0x007e
            r4.disconnect()
        L_0x007e:
            if (r0 == 0) goto L_0x0083
            r0.close()
        L_0x0083:
            throw r5
        L_0x0084:
            r4 = r0
            r5 = r4
        L_0x0086:
            if (r4 == 0) goto L_0x008b
            r4.disconnect()
        L_0x008b:
            if (r5 == 0) goto L_0x0090
            r5.close()
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.server.HttpFunctions.getStringFromURL(java.lang.String, com.ironsource.mediationsdk.H$a):java.lang.String");
    }

    public static void sendPostRequest(String str, String str2, a aVar) {
        sendPostRequestWithAutho(str, str2, (String) null, (String) null, aVar);
    }

    public static void sendPostRequestWithAutho(String str, String str2, String str3, String str4, a aVar) {
        final String str5 = str;
        final String str6 = str3;
        final String str7 = str4;
        final String str8 = str2;
        final a aVar2 = aVar;
        a.submit(new Runnable() {
            /* JADX WARNING: type inference failed for: r1v0, types: [java.io.OutputStream, java.net.HttpURLConnection] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00b5 A[SYNTHETIC, Splitter:B:33:0x00b5] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00bf  */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00c6 A[SYNTHETIC, Splitter:B:41:0x00c6] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0  */
            /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r8 = this;
                    r0 = 0
                    r1 = 0
                    java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    java.lang.String r3 = r2     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    if (r3 == 0) goto L_0x001e
                    java.lang.String r3 = r4     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    if (r3 == 0) goto L_0x001e
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    java.lang.String r4 = r4     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    java.lang.String r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.getBase64Auth(r3, r4)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    java.lang.String r4 = "Authorization"
                    r1.setRequestProperty(r4, r3)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                L_0x001e:
                    java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0091, all -> 0x008e }
                    r3 = 15000(0x3a98, float:2.102E-41)
                    r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x008c }
                    r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x008c }
                    java.lang.String r3 = "POST"
                    r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x008c }
                    r3 = 1
                    r2.setDoInput(r3)     // Catch:{ Exception -> 0x008c }
                    r2.setDoOutput(r3)     // Catch:{ Exception -> 0x008c }
                    java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ Exception -> 0x008c }
                    java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x008c }
                    java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x008c }
                    java.lang.String r6 = "UTF-8"
                    r5.<init>(r1, r6)     // Catch:{ Exception -> 0x008c }
                    r4.<init>(r5)     // Catch:{ Exception -> 0x008c }
                    java.lang.String r5 = r5     // Catch:{ Exception -> 0x008c }
                    r4.write(r5)     // Catch:{ Exception -> 0x008c }
                    r4.flush()     // Catch:{ Exception -> 0x008c }
                    r4.close()     // Catch:{ Exception -> 0x008c }
                    int r4 = r2.getResponseCode()     // Catch:{ Exception -> 0x008c }
                    r5 = 200(0xc8, float:2.8E-43)
                    if (r4 != r5) goto L_0x005c
                    goto L_0x005d
                L_0x005c:
                    r3 = r0
                L_0x005d:
                    if (r3 != 0) goto L_0x0077
                    com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x008c }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c }
                    java.lang.String r7 = "invalid response code "
                    r6.<init>(r7)     // Catch:{ Exception -> 0x008c }
                    r6.append(r4)     // Catch:{ Exception -> 0x008c }
                    java.lang.String r4 = " sending request"
                    r6.append(r4)     // Catch:{ Exception -> 0x008c }
                    java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x008c }
                    r5.error(r4)     // Catch:{ Exception -> 0x008c }
                L_0x0077:
                    com.ironsource.mediationsdk.server.a r4 = r6     // Catch:{ Exception -> 0x008c }
                    r4.a(r3)     // Catch:{ Exception -> 0x008c }
                    if (r1 == 0) goto L_0x0086
                    r1.close()     // Catch:{ IOException -> 0x0082 }
                    goto L_0x0086
                L_0x0082:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0086:
                    if (r2 == 0) goto L_0x00c2
                    r2.disconnect()
                    return
                L_0x008c:
                    r3 = move-exception
                    goto L_0x0094
                L_0x008e:
                    r0 = move-exception
                    r2 = r1
                    goto L_0x00c4
                L_0x0091:
                    r2 = move-exception
                    r3 = r2
                    r2 = r1
                L_0x0094:
                    r3.printStackTrace()     // Catch:{ all -> 0x00c3 }
                    com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00c3 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
                    java.lang.String r6 = "exception while sending request "
                    r5.<init>(r6)     // Catch:{ all -> 0x00c3 }
                    java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00c3 }
                    r5.append(r3)     // Catch:{ all -> 0x00c3 }
                    java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00c3 }
                    r4.error(r3)     // Catch:{ all -> 0x00c3 }
                    com.ironsource.mediationsdk.server.a r3 = r6     // Catch:{ all -> 0x00c3 }
                    r3.a(r0)     // Catch:{ all -> 0x00c3 }
                    if (r1 == 0) goto L_0x00bd
                    r1.close()     // Catch:{ IOException -> 0x00b9 }
                    goto L_0x00bd
                L_0x00b9:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x00bd:
                    if (r2 == 0) goto L_0x00c2
                    r2.disconnect()
                L_0x00c2:
                    return
                L_0x00c3:
                    r0 = move-exception
                L_0x00c4:
                    if (r1 == 0) goto L_0x00ce
                    r1.close()     // Catch:{ IOException -> 0x00ca }
                    goto L_0x00ce
                L_0x00ca:
                    r1 = move-exception
                    r1.printStackTrace()
                L_0x00ce:
                    if (r2 == 0) goto L_0x00d3
                    r2.disconnect()
                L_0x00d3:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.server.HttpFunctions.AnonymousClass1.run():void");
            }
        });
    }
}
