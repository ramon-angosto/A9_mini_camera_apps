package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class d {
    static Context a;
    static HashMap<String, SoftReference<u>> b = new HashMap<>();
    public static boolean c = false;
    public static int d = 4;
    public static boolean e = false;
    public static byte f = 0;
    public static String g = "10.0.0.200";
    public static int h = 80;

    public interface a {
        void onError(int i, int i2, String str, Object obj);

        void onOk(int i, int i2, String str, Object obj);
    }

    public static HttpURLConnection a(String str) throws IOException {
        URLConnection uRLConnection;
        String str2;
        String str3;
        if (!c) {
            a();
            if (!c) {
                return null;
            }
        }
        if (e) {
            int indexOf = str.indexOf(47, 7);
            if (indexOf < 0) {
                str3 = str.substring(7);
                str2 = "";
            } else {
                str3 = str.substring(7, indexOf);
                str2 = str.substring(indexOf);
            }
            if (f == 1) {
                uRLConnection = new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(g, 80)));
            } else {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://" + g + str2).openConnection();
                httpURLConnection.setRequestProperty("X-Online-Host", str3);
                return httpURLConnection;
            }
        } else {
            uRLConnection = new URL(str).openConnection();
        }
        return (HttpURLConnection) uRLConnection;
    }

    public static void a() {
        NetworkInfo activeNetworkInfo;
        Context context = a;
        ConnectivityManager connectivityManager = context != null ? (ConnectivityManager) context.getSystemService("connectivity") : null;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            c = false;
        } else {
            a(activeNetworkInfo, activeNetworkInfo.isConnected());
        }
    }

    public static void a(final int i, final int i2, final String str, final a aVar) {
        if (str != null && str.startsWith("http://")) {
            new Thread() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.InputStream} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.net.HttpURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.net.HttpURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.net.HttpURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.InputStream} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.InputStream} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.net.HttpURLConnection} */
                /* JADX WARNING: type inference failed for: r3v0, types: [java.net.HttpURLConnection] */
                /* JADX WARNING: type inference failed for: r3v1 */
                /* JADX WARNING: type inference failed for: r3v3 */
                /* JADX WARNING: type inference failed for: r3v8 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
                    if (r3 == 0) goto L_0x00c4;
                 */
                /* JADX WARNING: Failed to insert additional move for type inference */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7 A[Catch:{ all -> 0x00c6 }] */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x00b9 A[SYNTHETIC, Splitter:B:48:0x00b9] */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x00c3 A[Catch:{ IOException -> 0x0092 }] */
                /* JADX WARNING: Removed duplicated region for block: B:59:0x00c9 A[SYNTHETIC, Splitter:B:59:0x00c9] */
                /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3 A[Catch:{ IOException -> 0x0092 }] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r9 = this;
                        java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<com.baidu.mapapi.u>> r0 = com.baidu.mapapi.d.b
                        monitor-enter(r0)
                        java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<com.baidu.mapapi.u>> r1 = com.baidu.mapapi.d.b     // Catch:{ all -> 0x00d7 }
                        java.lang.String r2 = r3     // Catch:{ all -> 0x00d7 }
                        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00d7 }
                        java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1     // Catch:{ all -> 0x00d7 }
                        if (r1 == 0) goto L_0x0024
                        java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00d7 }
                        com.baidu.mapapi.u r1 = (com.baidu.mapapi.u) r1     // Catch:{ all -> 0x00d7 }
                        if (r1 == 0) goto L_0x0024
                        com.baidu.mapapi.d$a r2 = r4     // Catch:{ all -> 0x00d7 }
                        int r3 = r1     // Catch:{ all -> 0x00d7 }
                        int r4 = r2     // Catch:{ all -> 0x00d7 }
                        java.lang.String r5 = r3     // Catch:{ all -> 0x00d7 }
                        r2.onOk(r3, r4, r5, r1)     // Catch:{ all -> 0x00d7 }
                        monitor-exit(r0)     // Catch:{ all -> 0x00d7 }
                        return
                    L_0x0024:
                        java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00d7 }
                        r1.<init>()     // Catch:{ all -> 0x00d7 }
                        r2 = 0
                        java.lang.String r3 = r3     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
                        java.net.HttpURLConnection r3 = com.baidu.mapapi.d.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
                        if (r3 == 0) goto L_0x007b
                        r4 = 20000(0x4e20, float:2.8026E-41)
                        r3.setConnectTimeout(r4)     // Catch:{ Exception -> 0x009c }
                        r3.connect()     // Catch:{ Exception -> 0x009c }
                        int r4 = r3.getResponseCode()     // Catch:{ Exception -> 0x009c }
                        r5 = 200(0xc8, float:2.8E-43)
                        if (r4 != r5) goto L_0x008c
                        java.io.InputStream r2 = r3.getInputStream()     // Catch:{ Exception -> 0x009c }
                        r4 = 2048(0x800, float:2.87E-42)
                        byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x009c }
                    L_0x004a:
                        int r5 = r2.read(r4)     // Catch:{ Exception -> 0x009c }
                        r6 = -1
                        if (r5 == r6) goto L_0x0056
                        r6 = 0
                        r1.write(r4, r6, r5)     // Catch:{ Exception -> 0x009c }
                        goto L_0x004a
                    L_0x0056:
                        com.baidu.mapapi.d$a r4 = r4     // Catch:{ Exception -> 0x009c }
                        if (r4 == 0) goto L_0x008c
                        com.baidu.mapapi.u r4 = new com.baidu.mapapi.u     // Catch:{ Exception -> 0x009c }
                        byte[] r1 = r1.toByteArray()     // Catch:{ Exception -> 0x009c }
                        r4.<init>(r1)     // Catch:{ Exception -> 0x009c }
                        java.lang.ref.SoftReference r1 = new java.lang.ref.SoftReference     // Catch:{ Exception -> 0x009c }
                        r1.<init>(r4)     // Catch:{ Exception -> 0x009c }
                        java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<com.baidu.mapapi.u>> r5 = com.baidu.mapapi.d.b     // Catch:{ Exception -> 0x009c }
                        java.lang.String r6 = r3     // Catch:{ Exception -> 0x009c }
                        r5.put(r6, r1)     // Catch:{ Exception -> 0x009c }
                        com.baidu.mapapi.d$a r1 = r4     // Catch:{ Exception -> 0x009c }
                        int r5 = r1     // Catch:{ Exception -> 0x009c }
                        int r6 = r2     // Catch:{ Exception -> 0x009c }
                        java.lang.String r7 = r3     // Catch:{ Exception -> 0x009c }
                        r1.onOk(r5, r6, r7, r4)     // Catch:{ Exception -> 0x009c }
                        goto L_0x008c
                    L_0x007b:
                        com.baidu.mapapi.d$a r1 = r4     // Catch:{ Exception -> 0x009c }
                        if (r1 == 0) goto L_0x008c
                        com.baidu.mapapi.d$a r1 = r4     // Catch:{ Exception -> 0x009c }
                        int r4 = r1     // Catch:{ Exception -> 0x009c }
                        int r5 = r2     // Catch:{ Exception -> 0x009c }
                        java.lang.String r6 = r3     // Catch:{ Exception -> 0x009c }
                        java.lang.String r7 = "网络连接失败"
                        r1.onError(r4, r5, r6, r7)     // Catch:{ Exception -> 0x009c }
                    L_0x008c:
                        if (r2 == 0) goto L_0x0096
                        r2.close()     // Catch:{ IOException -> 0x0092 }
                        goto L_0x0096
                    L_0x0092:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
                    L_0x0096:
                        if (r3 == 0) goto L_0x00c4
                    L_0x0098:
                        r3.disconnect()     // Catch:{ all -> 0x00d7 }
                        goto L_0x00c4
                    L_0x009c:
                        r1 = move-exception
                        goto L_0x00a3
                    L_0x009e:
                        r1 = move-exception
                        r3 = r2
                        goto L_0x00c7
                    L_0x00a1:
                        r1 = move-exception
                        r3 = r2
                    L_0x00a3:
                        com.baidu.mapapi.d$a r4 = r4     // Catch:{ all -> 0x00c6 }
                        if (r4 == 0) goto L_0x00b4
                        com.baidu.mapapi.d$a r4 = r4     // Catch:{ all -> 0x00c6 }
                        int r5 = r1     // Catch:{ all -> 0x00c6 }
                        int r6 = r2     // Catch:{ all -> 0x00c6 }
                        java.lang.String r7 = r3     // Catch:{ all -> 0x00c6 }
                        java.lang.String r8 = "网络连接失败"
                        r4.onError(r5, r6, r7, r8)     // Catch:{ all -> 0x00c6 }
                    L_0x00b4:
                        r1.printStackTrace()     // Catch:{ all -> 0x00c6 }
                        if (r2 == 0) goto L_0x00c1
                        r2.close()     // Catch:{ IOException -> 0x00bd }
                        goto L_0x00c1
                    L_0x00bd:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
                    L_0x00c1:
                        if (r3 == 0) goto L_0x00c4
                        goto L_0x0098
                    L_0x00c4:
                        monitor-exit(r0)     // Catch:{ all -> 0x00d7 }
                        return
                    L_0x00c6:
                        r1 = move-exception
                    L_0x00c7:
                        if (r2 == 0) goto L_0x00d1
                        r2.close()     // Catch:{ IOException -> 0x00cd }
                        goto L_0x00d1
                    L_0x00cd:
                        r2 = move-exception
                        r2.printStackTrace()     // Catch:{ all -> 0x00d7 }
                    L_0x00d1:
                        if (r3 == 0) goto L_0x00d6
                        r3.disconnect()     // Catch:{ all -> 0x00d7 }
                    L_0x00d6:
                        throw r1     // Catch:{ all -> 0x00d7 }
                    L_0x00d7:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x00d7 }
                        goto L_0x00db
                    L_0x00da:
                        throw r1
                    L_0x00db:
                        goto L_0x00da
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.d.AnonymousClass1.run():void");
                }
            }.start();
        }
    }

    static void a(Context context) {
        a = context;
    }

    public static void a(NetworkInfo networkInfo, boolean z) {
        c = z;
        try {
            if (networkInfo.getType() == 1) {
                d = 4;
            } else {
                String extraInfo = networkInfo.getExtraInfo();
                if (extraInfo == null) {
                    d = 0;
                    g = android.net.Proxy.getDefaultHost();
                    h = android.net.Proxy.getDefaultPort();
                    if (g == null || "".equals(g)) {
                        d = 1;
                    } else {
                        d = 2;
                        e = true;
                        if ("10.0.0.200".equals(g)) {
                            f = 1;
                            return;
                        } else {
                            f = 0;
                            return;
                        }
                    }
                } else {
                    String trim = extraInfo.toLowerCase().trim();
                    if (!trim.startsWith("cmwap") && !trim.startsWith("uniwap")) {
                        if (!trim.startsWith("3gwap")) {
                            if (trim.startsWith("ctwap")) {
                                d = 2;
                                e = true;
                                f = 1;
                                g = "10.0.0.200";
                                return;
                            } else if (trim.startsWith("cmnet") || trim.startsWith("uninet") || trim.startsWith("ctnet") || trim.startsWith("3gnet")) {
                                d = 1;
                            } else {
                                return;
                            }
                        }
                    }
                    d = 2;
                    e = true;
                    f = 0;
                    g = "10.0.0.172";
                    return;
                }
            }
            e = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
