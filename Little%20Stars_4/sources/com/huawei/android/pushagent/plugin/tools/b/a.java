package com.huawei.android.pushagent.plugin.tools.b;

import android.content.Context;
import com.huawei.android.pushagent.c.a.i;
import com.huawei.android.pushagent.plugin.a.e;
import com.huawei.android.pushagent.plugin.a.g;
import com.xiaomi.mipush.sdk.Constants;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class a {

    /* renamed from: com.huawei.android.pushagent.plugin.tools.b.a$a  reason: collision with other inner class name */
    private static class C0037a {
        /* access modifiers changed from: private */
        public static String a = "http://";
        /* access modifiers changed from: private */
        public static String b = "pushaix.hicloud.com";
        /* access modifiers changed from: private */
        public static String c = "80";
        /* access modifiers changed from: private */
        public static String d = "/report";
    }

    private static class b {
        /* access modifiers changed from: private */
        public static String a = "https://";
        /* access modifiers changed from: private */
        public static String b = "pushaix.hicloud.com";
        /* access modifiers changed from: private */
        public static String c = "443";
        /* access modifiers changed from: private */
        public static String d = "/getSalt";
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0160 A[SYNTHETIC, Splitter:B:103:0x0160] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0112 A[SYNTHETIC, Splitter:B:83:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x012f A[SYNTHETIC, Splitter:B:88:0x012f] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0143 A[SYNTHETIC, Splitter:B:98:0x0143] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r7, int r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "close is err:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "httpRequest requestType is "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PushLogSC2705"
            com.huawei.android.pushagent.c.a.e.a(r2, r1)
            r1 = 1
            r3 = 0
            r4 = 0
            java.net.HttpURLConnection r5 = a(r7, r8, r3, r1, r9)     // Catch:{ IOException -> 0x00f3, all -> 0x00ee }
            if (r5 != 0) goto L_0x0032
            java.net.HttpURLConnection r5 = a(r7, r8, r3, r3, r9)     // Catch:{ IOException -> 0x002c, all -> 0x0026 }
            goto L_0x0032
        L_0x0026:
            r7 = move-exception
            r8 = r7
            r9 = r4
        L_0x0029:
            r7 = r5
            goto L_0x0141
        L_0x002c:
            r7 = move-exception
            r8 = r7
        L_0x002e:
            r7 = r4
            r9 = r7
            goto L_0x00f8
        L_0x0032:
            if (r5 != 0) goto L_0x0039
            java.net.HttpURLConnection r3 = a(r7, r8, r1, r3, r9)     // Catch:{ IOException -> 0x002c, all -> 0x0026 }
            goto L_0x003a
        L_0x0039:
            r3 = r5
        L_0x003a:
            if (r3 != 0) goto L_0x004b
            java.net.HttpURLConnection r7 = a(r7, r8, r1, r1, r9)     // Catch:{ IOException -> 0x0047, all -> 0x0041 }
            goto L_0x004c
        L_0x0041:
            r7 = move-exception
            r8 = r7
            r7 = r3
        L_0x0044:
            r9 = r4
            goto L_0x0141
        L_0x0047:
            r7 = move-exception
            r8 = r7
            r5 = r3
            goto L_0x002e
        L_0x004b:
            r7 = r3
        L_0x004c:
            if (r7 != 0) goto L_0x0059
            java.lang.String r8 = "get conn failed"
            com.huawei.android.pushagent.c.a.e.b(r2, r8)     // Catch:{ IOException -> 0x00ea, all -> 0x00e7 }
            if (r7 == 0) goto L_0x0058
            r7.disconnect()
        L_0x0058:
            return r4
        L_0x0059:
            java.lang.String r8 = "get conn success"
            com.huawei.android.pushagent.c.a.e.b(r2, r8)     // Catch:{ IOException -> 0x00ea, all -> 0x00e7 }
            java.io.InputStream r8 = r7.getInputStream()     // Catch:{ IOException -> 0x00ea, all -> 0x00e7 }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00e1, all -> 0x00da }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00e1, all -> 0x00da }
            java.lang.String r3 = "UTF-8"
            r1.<init>(r8, r3)     // Catch:{ IOException -> 0x00e1, all -> 0x00da }
            r9.<init>(r1)     // Catch:{ IOException -> 0x00e1, all -> 0x00da }
            java.lang.String r1 = r9.readLine()     // Catch:{ IOException -> 0x00d5, all -> 0x00d0 }
            if (r1 == 0) goto L_0x009f
            if (r8 == 0) goto L_0x0091
            r8.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x0091
        L_0x007a:
            r8 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r8.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x0091:
            r9.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0099:
            if (r7 == 0) goto L_0x009e
            r7.disconnect()
        L_0x009e:
            return r1
        L_0x009f:
            java.lang.String r1 = "response is null"
            com.huawei.android.pushagent.c.a.e.b(r2, r1)     // Catch:{ IOException -> 0x00d5, all -> 0x00d0 }
            if (r8 == 0) goto L_0x00c1
            r8.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00c1
        L_0x00aa:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = r8.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x00c1:
            r9.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00c9:
            if (r7 == 0) goto L_0x013c
            r7.disconnect()
            goto L_0x013c
        L_0x00d0:
            r1 = move-exception
            r4 = r8
            r8 = r1
            goto L_0x0141
        L_0x00d5:
            r1 = move-exception
            r5 = r7
            r7 = r8
            r8 = r1
            goto L_0x00f8
        L_0x00da:
            r9 = move-exception
            r6 = r4
            r4 = r8
            r8 = r9
            r9 = r6
            goto L_0x0141
        L_0x00e1:
            r9 = move-exception
            r5 = r7
            r7 = r8
            r8 = r9
            r9 = r4
            goto L_0x00f8
        L_0x00e7:
            r8 = move-exception
            goto L_0x0044
        L_0x00ea:
            r8 = move-exception
            r5 = r7
            goto L_0x002e
        L_0x00ee:
            r7 = move-exception
            r8 = r7
            r7 = r4
            r9 = r7
            goto L_0x0141
        L_0x00f3:
            r7 = move-exception
            r8 = r7
            r7 = r4
            r9 = r7
            r5 = r9
        L_0x00f8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x013d }
            r1.<init>()     // Catch:{ all -> 0x013d }
            java.lang.String r3 = "connect url err:"
            r1.append(r3)     // Catch:{ all -> 0x013d }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x013d }
            r1.append(r3)     // Catch:{ all -> 0x013d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x013d }
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r2, (java.lang.String) r1, (java.lang.Throwable) r8)     // Catch:{ all -> 0x013d }
            if (r7 == 0) goto L_0x012d
            r7.close()     // Catch:{ IOException -> 0x0116 }
            goto L_0x012d
        L_0x0116:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r0 = r7.toString()
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r2, (java.lang.String) r8, (java.lang.Throwable) r7)
        L_0x012d:
            if (r9 == 0) goto L_0x0137
            r9.close()     // Catch:{ IOException -> 0x0133 }
            goto L_0x0137
        L_0x0133:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0137:
            if (r5 == 0) goto L_0x013c
            r5.disconnect()
        L_0x013c:
            return r4
        L_0x013d:
            r8 = move-exception
            r4 = r7
            goto L_0x0029
        L_0x0141:
            if (r4 == 0) goto L_0x015e
            r4.close()     // Catch:{ IOException -> 0x0147 }
            goto L_0x015e
        L_0x0147:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r1.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x015e:
            if (r9 == 0) goto L_0x0168
            r9.close()     // Catch:{ IOException -> 0x0164 }
            goto L_0x0168
        L_0x0164:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0168:
            if (r7 == 0) goto L_0x016d
            r7.disconnect()
        L_0x016d:
            goto L_0x016f
        L_0x016e:
            throw r8
        L_0x016f:
            goto L_0x016e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.plugin.tools.b.a.a(android.content.Context, int, java.lang.String):java.lang.String");
    }

    public static String a(Context context, g gVar) {
        return a(context, 2, gVar.a(context));
    }

    public static String a(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Constants.EXTRA_KEY_TOKEN);
        stringBuffer.append("=");
        stringBuffer.append(str);
        stringBuffer.append("&");
        stringBuffer.append("securityAlg");
        stringBuffer.append("=");
        stringBuffer.append(2);
        return a(context, 1, stringBuffer.toString());
    }

    private static String a(Context context, boolean z) {
        String a = b.b;
        String b2 = b.c;
        String c = b.d;
        StringBuffer stringBuffer = new StringBuffer();
        if (z) {
            stringBuffer.append(b.a);
            stringBuffer.append(a);
            stringBuffer.append(":");
            stringBuffer.append(b2);
        } else {
            stringBuffer.append(b.a);
            stringBuffer.append(a);
        }
        stringBuffer.append(c);
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097 A[SYNTHETIC, Splitter:B:28:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc A[Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d4 A[Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0124 A[SYNTHETIC, Splitter:B:56:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013f A[SYNTHETIC, Splitter:B:62:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01f4 A[SYNTHETIC, Splitter:B:92:0x01f4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.HttpURLConnection a(android.content.Context r7, int r8, boolean r9, boolean r10, java.lang.String r11) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "connect to srv cause IOException:"
            java.lang.String r3 = "PushLogSC2705"
            if (r1 != r8) goto L_0x0010
            a(r7)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.lang.String r8 = a((android.content.Context) r7, (boolean) r10)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            goto L_0x0014
        L_0x0010:
            java.lang.String r8 = b(r7, r10)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
        L_0x0014:
            if (r9 == 0) goto L_0x0094
            int r9 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r7)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            if (r1 == r9) goto L_0x0094
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r10 = 11
            if (r9 < r10) goto L_0x0024
            r9 = 1
            goto L_0x0025
        L_0x0024:
            r9 = 0
        L_0x0025:
            if (r9 == 0) goto L_0x003d
            java.lang.String r7 = "http.proxyHost"
            java.lang.String r7 = java.lang.System.getProperty(r7)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.lang.String r9 = "http.proxyPort"
            java.lang.String r9 = java.lang.System.getProperty(r9)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            if (r9 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            java.lang.String r9 = "-1"
        L_0x0038:
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            goto L_0x0048
        L_0x003d:
            java.lang.String r9 = android.net.Proxy.getHost(r7)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            int r7 = android.net.Proxy.getPort(r7)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r6 = r9
            r9 = r7
            r7 = r6
        L_0x0048:
            if (r7 == 0) goto L_0x008f
            int r10 = r7.length()     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            if (r10 <= 0) goto L_0x008f
            r10 = -1
            if (r9 == r10) goto L_0x008f
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r10.<init>()     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.lang.String r4 = "use Proxy "
            r10.append(r4)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r10.append(r7)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.lang.String r4 = ":"
            r10.append(r4)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r10.append(r9)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.lang.String r4 = " to open:"
            r10.append(r4)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r10.append(r8)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.lang.String r10 = r10.toString()     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            com.huawei.android.pushagent.c.a.e.b(r3, r10)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.net.Proxy r10 = new java.net.Proxy     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.net.Proxy$Type r4 = java.net.Proxy.Type.HTTP     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r5.<init>(r7, r9)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r10.<init>(r4, r5)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            r7.<init>(r8)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.net.URLConnection r7 = r7.openConnection(r10)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
            goto L_0x0095
        L_0x008f:
            java.lang.String r7 = "proxy param invalid"
            com.huawei.android.pushagent.c.a.e.b(r3, r7)     // Catch:{ MalformedURLException -> 0x01d7, IOException -> 0x01bd, NullPointerException -> 0x01ad, IllegalArgumentException -> 0x019d, UnsupportedOperationException -> 0x018d }
        L_0x0094:
            r7 = r0
        L_0x0095:
            if (r7 != 0) goto L_0x00b7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.<init>()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r10 = "direct to open "
            r9.append(r10)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.append(r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r9 = r9.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            com.huawei.android.pushagent.c.a.e.a(r3, r9)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.<init>(r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.net.URLConnection r8 = r9.openConnection()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r7 = r8
        L_0x00b7:
            boolean r8 = r7 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            if (r8 == 0) goto L_0x00be
            javax.net.ssl.HttpsURLConnection r7 = (javax.net.ssl.HttpsURLConnection) r7     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
        L_0x00be:
            r8 = 30000(0x7530, float:4.2039E-41)
            r7.setConnectTimeout(r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r8 = 20000(0x4e20, float:2.8026E-41)
            r7.setReadTimeout(r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r7.setDoOutput(r1)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r7.setDoInput(r1)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            boolean r8 = android.text.TextUtils.isEmpty(r11)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            if (r8 != 0) goto L_0x015b
            java.lang.String r8 = "UTF-8"
            byte[] r8 = r11.getBytes(r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.io.OutputStream r9 = r7.getOutputStream()     // Catch:{ Exception -> 0x010a, all -> 0x0107 }
            r9.write(r8)     // Catch:{ Exception -> 0x0105 }
            r9.flush()     // Catch:{ Exception -> 0x0105 }
            if (r9 == 0) goto L_0x015b
            r9.close()     // Catch:{ Exception -> 0x00eb }
            goto L_0x015b
        L_0x00eb:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.<init>()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.append(r2)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r10 = r8.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.append(r10)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r9 = r9.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
        L_0x00ff:
            com.huawei.android.pushagent.c.a.e.c(r3, r9, r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            goto L_0x015b
        L_0x0103:
            r8 = move-exception
            goto L_0x013d
        L_0x0105:
            r8 = move-exception
            goto L_0x010c
        L_0x0107:
            r8 = move-exception
            r9 = r0
            goto L_0x013d
        L_0x010a:
            r8 = move-exception
            r9 = r0
        L_0x010c:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r10.<init>()     // Catch:{ all -> 0x0103 }
            r10.append(r2)     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = r8.toString()     // Catch:{ all -> 0x0103 }
            r10.append(r11)     // Catch:{ all -> 0x0103 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0103 }
            com.huawei.android.pushagent.c.a.e.c(r3, r10, r8)     // Catch:{ all -> 0x0103 }
            if (r9 == 0) goto L_0x015b
            r9.close()     // Catch:{ Exception -> 0x0128 }
            goto L_0x015b
        L_0x0128:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.<init>()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.append(r2)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r10 = r8.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r9.append(r10)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r9 = r9.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            goto L_0x00ff
        L_0x013d:
            if (r9 == 0) goto L_0x015a
            r9.close()     // Catch:{ Exception -> 0x0143 }
            goto L_0x015a
        L_0x0143:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r10.<init>()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r10.append(r2)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r11 = r9.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r10.append(r11)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r10 = r10.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            com.huawei.android.pushagent.c.a.e.c(r3, r10, r9)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
        L_0x015a:
            throw r8     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
        L_0x015b:
            r7.connect()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            int r8 = r7.getResponseCode()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r9 = r7.getResponseMessage()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r10.<init>()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r11 = "httpRequest responseCode is "
            r10.append(r11)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r10.append(r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r8 = "/"
            r10.append(r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            r10.append(r9)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            java.lang.String r8 = r10.toString()     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            com.huawei.android.pushagent.c.a.e.a(r3, r8)     // Catch:{ MalformedURLException -> 0x018b, IOException -> 0x0189, NullPointerException -> 0x0187, IllegalArgumentException -> 0x0185, UnsupportedOperationException -> 0x0183 }
            return r7
        L_0x0183:
            r8 = move-exception
            goto L_0x0190
        L_0x0185:
            r8 = move-exception
            goto L_0x01a0
        L_0x0187:
            r8 = move-exception
            goto L_0x01b0
        L_0x0189:
            r8 = move-exception
            goto L_0x01c0
        L_0x018b:
            r8 = move-exception
            goto L_0x01da
        L_0x018d:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L_0x0190:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            java.lang.String r10 = r8.toString()
            goto L_0x01cc
        L_0x019d:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L_0x01a0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            java.lang.String r10 = r8.toString()
            goto L_0x01cc
        L_0x01ad:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L_0x01b0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            java.lang.String r10 = r8.toString()
            goto L_0x01cc
        L_0x01bd:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L_0x01c0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            java.lang.String r10 = r8.toString()
        L_0x01cc:
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r9, r8)
            goto L_0x01f2
        L_0x01d7:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L_0x01da:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "connect to srv cause MalformedURLException:"
            r9.append(r10)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.huawei.android.pushagent.c.a.e.d(r3, r8)
        L_0x01f2:
            if (r7 == 0) goto L_0x0211
            r7.disconnect()     // Catch:{ Exception -> 0x01f8 }
            goto L_0x0211
        L_0x01f8:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "close connection cause Exception:"
            r8.append(r9)
            java.lang.String r9 = r7.toString()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r8, r7)
        L_0x0211:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.plugin.tools.b.a.a(android.content.Context, int, boolean, boolean, java.lang.String):java.net.HttpURLConnection");
    }

    private static void a(Context context) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{new i(context)}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(new com.huawei.android.pushagent.c.a.g(instance.getSocketFactory()));
            HttpsURLConnection.setDefaultHostnameVerifier(new b());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private static String b(Context context, boolean z) {
        String a = C0037a.b;
        String b2 = C0037a.c;
        String c = C0037a.d;
        StringBuffer stringBuffer = new StringBuffer();
        int f = new e(context).f();
        if (f > 0 && a.contains("pushaix")) {
            int indexOf = C0037a.b.indexOf(".");
            a = C0037a.b.substring(0, indexOf) + f + C0037a.b.substring(indexOf);
        }
        if (z) {
            stringBuffer.append(C0037a.a);
            stringBuffer.append(a);
            stringBuffer.append(":");
            stringBuffer.append(b2);
        } else {
            stringBuffer.append(C0037a.a);
            stringBuffer.append(a);
        }
        stringBuffer.append(c);
        return stringBuffer.toString();
    }
}
