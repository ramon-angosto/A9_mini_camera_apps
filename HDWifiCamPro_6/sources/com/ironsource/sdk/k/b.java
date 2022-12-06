package com.ironsource.sdk.k;

import android.os.Handler;
import android.os.Message;
import androidx.core.view.PointerIconCompat;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;

public final class b {
    private static b c;
    public a a = new a(com.ironsource.environment.e.a.a());
    public final String b;
    private Thread d;

    static class a implements Callable<C0097b> {
        private String a;
        private String b;
        private String c;
        private long d;
        private String e;

        a(String str, String str2, String str3, long j, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = j;
            this.e = str4;
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [java.io.InputStream] */
        /* JADX WARNING: type inference failed for: r3v1, types: [java.io.InputStream] */
        /* JADX WARNING: type inference failed for: r3v2, types: [java.net.HttpURLConnection] */
        /* JADX WARNING: type inference failed for: r3v3 */
        /* JADX WARNING: type inference failed for: r3v4, types: [java.net.HttpURLConnection] */
        /* JADX WARNING: type inference failed for: r3v5 */
        /* JADX WARNING: type inference failed for: r3v6 */
        /* JADX WARNING: type inference failed for: r3v7 */
        /* JADX WARNING: type inference failed for: r3v8, types: [java.io.InputStream] */
        /* JADX WARNING: type inference failed for: r3v10 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x013a A[SYNTHETIC, Splitter:B:105:0x013a] */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x0142 A[Catch:{ all -> 0x013e }] */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0151 A[SYNTHETIC, Splitter:B:117:0x0151] */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x0159 A[Catch:{ all -> 0x0155 }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0073 A[SYNTHETIC, Splitter:B:18:0x0073] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x007b A[Catch:{ all -> 0x0077 }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3 A[Catch:{ all -> 0x00c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac A[SYNTHETIC, Splitter:B:40:0x00ac] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4 A[Catch:{ all -> 0x00b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00d2 A[Catch:{ all -> 0x00f0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00db A[SYNTHETIC, Splitter:B:57:0x00db] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00e3 A[Catch:{ all -> 0x00df }] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00f5 A[SYNTHETIC, Splitter:B:68:0x00f5] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x00fd A[Catch:{ all -> 0x00f9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x010c A[SYNTHETIC, Splitter:B:81:0x010c] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0114 A[Catch:{ all -> 0x0110 }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0123 A[SYNTHETIC, Splitter:B:93:0x0123] */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x012b A[Catch:{ all -> 0x0127 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.ironsource.sdk.k.b.C0097b a(java.lang.String r9, int r10) {
            /*
                r8 = this;
                java.lang.String r0 = "DownloadManager"
                com.ironsource.sdk.k.b$b r1 = new com.ironsource.sdk.k.b$b
                r1.<init>()
                boolean r2 = android.text.TextUtils.isEmpty(r9)
                if (r2 == 0) goto L_0x0014
                r1.a = r9
                r9 = 1007(0x3ef, float:1.411E-42)
                r1.b = r9
                return r1
            L_0x0014:
                r2 = 1019(0x3fb, float:1.428E-42)
                r3 = 0
                r4 = 0
                java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x014e, URISyntaxException -> 0x0137, SocketTimeoutException -> 0x0120, FileNotFoundException -> 0x0109, Exception -> 0x00c6, Error -> 0x0097, all -> 0x0093 }
                r5.<init>(r9)     // Catch:{ MalformedURLException -> 0x014e, URISyntaxException -> 0x0137, SocketTimeoutException -> 0x0120, FileNotFoundException -> 0x0109, Exception -> 0x00c6, Error -> 0x0097, all -> 0x0093 }
                r5.toURI()     // Catch:{ MalformedURLException -> 0x014e, URISyntaxException -> 0x0137, SocketTimeoutException -> 0x0120, FileNotFoundException -> 0x0109, Exception -> 0x00c6, Error -> 0x0097, all -> 0x0093 }
                java.net.URLConnection r5 = r5.openConnection()     // Catch:{ MalformedURLException -> 0x014e, URISyntaxException -> 0x0137, SocketTimeoutException -> 0x0120, FileNotFoundException -> 0x0109, Exception -> 0x00c6, Error -> 0x0097, all -> 0x0093 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ MalformedURLException -> 0x014e, URISyntaxException -> 0x0137, SocketTimeoutException -> 0x0120, FileNotFoundException -> 0x0109, Exception -> 0x00c6, Error -> 0x0097, all -> 0x0093 }
                java.lang.String r6 = "GET"
                r5.setRequestMethod(r6)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r6 = 5000(0x1388, float:7.006E-42)
                r5.setConnectTimeout(r6)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r5.setReadTimeout(r6)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r5.connect()     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                int r4 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r6 = 200(0xc8, float:2.8E-43)
                if (r4 < r6) goto L_0x004e
                r6 = 400(0x190, float:5.6E-43)
                if (r4 < r6) goto L_0x0043
                goto L_0x004e
            L_0x0043:
                java.io.InputStream r3 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                byte[] r10 = a(r3)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r1.c = r10     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                goto L_0x0071
            L_0x004e:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                java.lang.String r7 = " RESPONSE CODE: "
                r6.<init>(r7)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r6.append(r4)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                java.lang.String r7 = " URL: "
                r6.append(r7)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r6.append(r9)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                java.lang.String r7 = " ATTEMPT: "
                r6.append(r7)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r6.append(r10)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                java.lang.String r10 = r6.toString()     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                com.ironsource.sdk.utils.Logger.i(r0, r10)     // Catch:{ MalformedURLException -> 0x014f, URISyntaxException -> 0x0138, SocketTimeoutException -> 0x0121, FileNotFoundException -> 0x010a, Exception -> 0x008f, Error -> 0x008b, all -> 0x0088 }
                r4 = 1011(0x3f3, float:1.417E-42)
            L_0x0071:
                if (r3 == 0) goto L_0x0079
                r3.close()     // Catch:{ all -> 0x0077 }
                goto L_0x0079
            L_0x0077:
                r10 = move-exception
                goto L_0x007f
            L_0x0079:
                if (r5 == 0) goto L_0x0082
                r5.disconnect()     // Catch:{ all -> 0x0077 }
                goto L_0x0082
            L_0x007f:
                r10.printStackTrace()
            L_0x0082:
                r1.a = r9
                r1.b = r4
                goto L_0x0166
            L_0x0088:
                r10 = move-exception
                goto L_0x00f3
            L_0x008b:
                r10 = move-exception
                r4 = r3
                r3 = r5
                goto L_0x0099
            L_0x008f:
                r10 = move-exception
                r2 = r3
                r3 = r5
                goto L_0x00c8
            L_0x0093:
                r10 = move-exception
                r5 = r3
                goto L_0x00f3
            L_0x0097:
                r10 = move-exception
                r4 = r3
            L_0x0099:
                java.lang.String r5 = r10.getMessage()     // Catch:{ all -> 0x00c1 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00c1 }
                if (r5 != 0) goto L_0x00aa
                java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00c1 }
                com.ironsource.sdk.utils.Logger.i(r0, r10)     // Catch:{ all -> 0x00c1 }
            L_0x00aa:
                if (r4 == 0) goto L_0x00b2
                r4.close()     // Catch:{ all -> 0x00b0 }
                goto L_0x00b2
            L_0x00b0:
                r10 = move-exception
                goto L_0x00b8
            L_0x00b2:
                if (r3 == 0) goto L_0x00bb
                r3.disconnect()     // Catch:{ all -> 0x00b0 }
                goto L_0x00bb
            L_0x00b8:
                r10.printStackTrace()
            L_0x00bb:
                r1.a = r9
                r1.b = r2
                goto L_0x0166
            L_0x00c1:
                r10 = move-exception
                r5 = r3
                r3 = r4
                r4 = r2
                goto L_0x00f3
            L_0x00c6:
                r10 = move-exception
                r2 = r3
            L_0x00c8:
                java.lang.String r5 = r10.getMessage()     // Catch:{ all -> 0x00f0 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00f0 }
                if (r5 != 0) goto L_0x00d9
                java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00f0 }
                com.ironsource.sdk.utils.Logger.i(r0, r10)     // Catch:{ all -> 0x00f0 }
            L_0x00d9:
                if (r2 == 0) goto L_0x00e1
                r2.close()     // Catch:{ all -> 0x00df }
                goto L_0x00e1
            L_0x00df:
                r10 = move-exception
                goto L_0x00e7
            L_0x00e1:
                if (r3 == 0) goto L_0x00ea
                r3.disconnect()     // Catch:{ all -> 0x00df }
                goto L_0x00ea
            L_0x00e7:
                r10.printStackTrace()
            L_0x00ea:
                r1.a = r9
                r9 = 1009(0x3f1, float:1.414E-42)
                goto L_0x0164
            L_0x00f0:
                r10 = move-exception
                r5 = r3
                r3 = r2
            L_0x00f3:
                if (r3 == 0) goto L_0x00fb
                r3.close()     // Catch:{ all -> 0x00f9 }
                goto L_0x00fb
            L_0x00f9:
                r0 = move-exception
                goto L_0x0101
            L_0x00fb:
                if (r5 == 0) goto L_0x0104
                r5.disconnect()     // Catch:{ all -> 0x00f9 }
                goto L_0x0104
            L_0x0101:
                r0.printStackTrace()
            L_0x0104:
                r1.a = r9
                r1.b = r4
                throw r10
            L_0x0109:
                r5 = r3
            L_0x010a:
                if (r3 == 0) goto L_0x0112
                r3.close()     // Catch:{ all -> 0x0110 }
                goto L_0x0112
            L_0x0110:
                r10 = move-exception
                goto L_0x0118
            L_0x0112:
                if (r5 == 0) goto L_0x011b
                r5.disconnect()     // Catch:{ all -> 0x0110 }
                goto L_0x011b
            L_0x0118:
                r10.printStackTrace()
            L_0x011b:
                r1.a = r9
                r9 = 1018(0x3fa, float:1.427E-42)
                goto L_0x0164
            L_0x0120:
                r5 = r3
            L_0x0121:
                if (r3 == 0) goto L_0x0129
                r3.close()     // Catch:{ all -> 0x0127 }
                goto L_0x0129
            L_0x0127:
                r10 = move-exception
                goto L_0x012f
            L_0x0129:
                if (r5 == 0) goto L_0x0132
                r5.disconnect()     // Catch:{ all -> 0x0127 }
                goto L_0x0132
            L_0x012f:
                r10.printStackTrace()
            L_0x0132:
                r1.a = r9
                r9 = 1008(0x3f0, float:1.413E-42)
                goto L_0x0164
            L_0x0137:
                r5 = r3
            L_0x0138:
                if (r3 == 0) goto L_0x0140
                r3.close()     // Catch:{ all -> 0x013e }
                goto L_0x0140
            L_0x013e:
                r10 = move-exception
                goto L_0x0146
            L_0x0140:
                if (r5 == 0) goto L_0x0149
                r5.disconnect()     // Catch:{ all -> 0x013e }
                goto L_0x0149
            L_0x0146:
                r10.printStackTrace()
            L_0x0149:
                r1.a = r9
                r9 = 1010(0x3f2, float:1.415E-42)
                goto L_0x0164
            L_0x014e:
                r5 = r3
            L_0x014f:
                if (r3 == 0) goto L_0x0157
                r3.close()     // Catch:{ all -> 0x0155 }
                goto L_0x0157
            L_0x0155:
                r10 = move-exception
                goto L_0x015d
            L_0x0157:
                if (r5 == 0) goto L_0x0160
                r5.disconnect()     // Catch:{ all -> 0x0155 }
                goto L_0x0160
            L_0x015d:
                r10.printStackTrace()
            L_0x0160:
                r1.a = r9
                r9 = 1004(0x3ec, float:1.407E-42)
            L_0x0164:
                r1.b = r9
            L_0x0166:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.k.b.a.a(java.lang.String, int):com.ironsource.sdk.k.b$b");
        }

        private static byte[] a(InputStream inputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            r2 = a(r7.a, r1);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.ironsource.sdk.k.b.C0097b call() {
            /*
                r7 = this;
                java.lang.String r0 = "DownloadManager"
                long r1 = r7.d
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 != 0) goto L_0x000e
                r1 = 1
                r7.d = r1
            L_0x000e:
                r1 = 0
                r2 = 0
            L_0x0010:
                long r3 = (long) r1
                long r5 = r7.d
                int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                r4 = 1009(0x3f1, float:1.414E-42)
                if (r3 >= 0) goto L_0x002a
                java.lang.String r2 = r7.a
                com.ironsource.sdk.k.b$b r2 = r7.a(r2, r1)
                int r3 = r2.b
                r5 = 1008(0x3f0, float:1.413E-42)
                if (r3 == r5) goto L_0x0027
                if (r3 != r4) goto L_0x002a
            L_0x0027:
                int r1 = r1 + 1
                goto L_0x0010
            L_0x002a:
                if (r2 == 0) goto L_0x00ab
                byte[] r1 = r2.c
                if (r1 == 0) goto L_0x00ab
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = r7.b
                r1.append(r3)
                java.lang.String r3 = java.io.File.separator
                r1.append(r3)
                java.lang.String r3 = r7.c
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = r7.e
                r3.append(r5)
                java.lang.String r5 = java.io.File.separator
                r3.append(r5)
                java.lang.String r5 = "tmp_"
                r3.append(r5)
                java.lang.String r5 = r7.c
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                byte[] r5 = r2.c     // Catch:{ FileNotFoundException -> 0x00a7, Exception -> 0x0092, Error -> 0x007d }
                int r5 = com.ironsource.sdk.utils.IronSourceStorageUtils.saveFile(r5, r3)     // Catch:{ FileNotFoundException -> 0x00a7, Exception -> 0x0092, Error -> 0x007d }
                if (r5 != 0) goto L_0x0072
                r1 = 1006(0x3ee, float:1.41E-42)
                r2.b = r1     // Catch:{ FileNotFoundException -> 0x00a7, Exception -> 0x0092, Error -> 0x007d }
                goto L_0x00ab
            L_0x0072:
                boolean r1 = com.ironsource.sdk.utils.IronSourceStorageUtils.renameFile(r3, r1)     // Catch:{ FileNotFoundException -> 0x00a7, Exception -> 0x0092, Error -> 0x007d }
                if (r1 != 0) goto L_0x00ab
                r1 = 1020(0x3fc, float:1.43E-42)
                r2.b = r1     // Catch:{ FileNotFoundException -> 0x00a7, Exception -> 0x0092, Error -> 0x007d }
                goto L_0x00ab
            L_0x007d:
                r1 = move-exception
                java.lang.String r3 = r1.getMessage()
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x008f
                java.lang.String r1 = r1.getMessage()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
            L_0x008f:
                r0 = 1019(0x3fb, float:1.428E-42)
                goto L_0x00a9
            L_0x0092:
                r1 = move-exception
                java.lang.String r3 = r1.getMessage()
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x00a4
                java.lang.String r1 = r1.getMessage()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
            L_0x00a4:
                r2.b = r4
                goto L_0x00ab
            L_0x00a7:
                r0 = 1018(0x3fa, float:1.427E-42)
            L_0x00a9:
                r2.b = r0
            L_0x00ab:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.k.b.a.call():com.ironsource.sdk.k.b$b");
        }
    }

    /* renamed from: com.ironsource.sdk.k.b$b  reason: collision with other inner class name */
    static class C0097b {
        public String a;
        int b;
        byte[] c;

        C0097b() {
        }
    }

    static class c implements Runnable {
        private final long a = 3;
        private final String b;
        private Handler c;
        private String d;
        private String e;
        private String f;
        private long g;

        c(com.ironsource.sdk.h.c cVar, String str, Handler handler, String str2) {
            this.d = str;
            this.e = cVar.getParent();
            this.f = cVar.getName();
            this.g = 3;
            this.c = handler;
            this.b = str2;
        }

        public final void run() {
            int i;
            com.ironsource.sdk.h.c cVar = new com.ironsource.sdk.h.c(this.e, this.f);
            Message message = new Message();
            message.obj = cVar;
            String makeDir = IronSourceStorageUtils.makeDir(cVar.getParent());
            if (makeDir == null) {
                i = 1020;
            } else {
                C0097b a2 = new a(this.d, makeDir, cVar.getName(), this.g, this.b).call();
                i = a2.b == 200 ? PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW : a2.b;
            }
            message.what = i;
            this.c.sendMessage(message);
        }
    }

    private b(String str, com.ironsource.environment.e.a aVar) {
        this.b = str;
        IronSourceStorageUtils.deleteFolder(c());
        IronSourceStorageUtils.makeDir(c());
    }

    public static synchronized b a(String str, com.ironsource.environment.e.a aVar) {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b(str, aVar);
            }
            bVar = c;
        }
        return bVar;
    }

    private String c() {
        return IronSourceStorageUtils.buildAbsolutePathToDirInCache(this.b, "temp");
    }

    public final synchronized void a() {
        c = null;
        if (this.a != null) {
            this.a.a = null;
            this.a = null;
        }
    }

    public final void a(com.ironsource.sdk.h.c cVar, String str) {
        this.d = new Thread(new c(cVar, str, this.a, c()));
        this.d.start();
    }

    public final void a(com.ironsource.sdk.h.c cVar, String str, Handler handler) {
        new Thread(new c(cVar, str, handler, c())).start();
    }

    public final boolean b() {
        Thread thread = this.d;
        return thread != null && thread.isAlive();
    }
}
