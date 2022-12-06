package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.string.c;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class d {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static final class a extends FilterInputStream {
        private boolean a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.a && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.a = true;
            return -1;
        }
    }

    public static class b {
        public int a;
        public Map<String, String> b;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", new Object[]{Integer.valueOf(this.a), this.b.toString()});
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r2) {
        /*
            r0 = -1
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch:{ Exception -> 0x0018 }
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ Exception -> 0x0018 }
            if (r2 != 0) goto L_0x000c
            return r0
        L_0x000c:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch:{  }
            if (r2 != 0) goto L_0x0013
            return r0
        L_0x0013:
            int r2 = r2.getType()
            return r2
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(android.content.Context):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f1, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f3, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f4, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ff, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0102, code lost:
        r4 = th;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0109, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010d, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0111, code lost:
        android.util.Log.e("com.xiaomi.common.Network", "error while closing strean", r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:22:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f3 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:1:0x0008] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0105 A[SYNTHETIC, Splitter:B:54:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d A[Catch:{ IOException -> 0x0109 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.channel.commonutils.network.b a(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "com.xiaomi.common.Network"
            com.xiaomi.channel.commonutils.network.b r1 = new com.xiaomi.channel.commonutils.network.b
            r1.<init>()
            r2 = 0
            java.net.URL r5 = b((java.lang.String) r5)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.net.HttpURLConnection r4 = b(r4, r5)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r5 = 10000(0x2710, float:1.4013E-41)
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r5 = 15000(0x3a98, float:2.102E-41)
            r4.setReadTimeout(r5)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            if (r6 != 0) goto L_0x001e
            java.lang.String r6 = "GET"
        L_0x001e:
            r4.setRequestMethod(r6)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            if (r7 == 0) goto L_0x0041
            java.util.Set r5 = r7.keySet()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
        L_0x002b:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            if (r6 == 0) goto L_0x0041
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.lang.Object r3 = r7.get(r6)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r4.setRequestProperty(r6, r3)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            goto L_0x002b
        L_0x0041:
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r6 = 0
            r7 = 1
            if (r5 != 0) goto L_0x006e
            r4.setDoOutput(r7)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            byte[] r5 = r8.getBytes()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.io.OutputStream r8 = r4.getOutputStream()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            int r3 = r5.length     // Catch:{ IOException -> 0x0069, Throwable -> 0x0064, all -> 0x005f }
            r8.write(r5, r6, r3)     // Catch:{ IOException -> 0x0069, Throwable -> 0x0064, all -> 0x005f }
            r8.flush()     // Catch:{ IOException -> 0x0069, Throwable -> 0x0064, all -> 0x005f }
            r8.close()     // Catch:{ IOException -> 0x0069, Throwable -> 0x0064, all -> 0x005f }
            goto L_0x006e
        L_0x005f:
            r4 = move-exception
            r5 = r2
            r2 = r8
            goto L_0x0103
        L_0x0064:
            r4 = move-exception
            r5 = r2
            r2 = r8
            goto L_0x00f5
        L_0x0069:
            r4 = move-exception
            r5 = r2
            r2 = r8
            goto L_0x0101
        L_0x006e:
            int r5 = r4.getResponseCode()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r1.a = r5     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r5.<init>()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.lang.String r8 = "Http POST Response Code: "
            r5.append(r8)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            int r8 = r1.a     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r5.append(r8)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
        L_0x008a:
            java.lang.String r5 = r4.getHeaderFieldKey(r6)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.lang.String r8 = r4.getHeaderField(r6)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            if (r5 != 0) goto L_0x00e7
            if (r8 != 0) goto L_0x00e7
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00aa, Throwable -> 0x00f3, all -> 0x00f0 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00aa, Throwable -> 0x00f3, all -> 0x00f0 }
            com.xiaomi.channel.commonutils.network.d$a r7 = new com.xiaomi.channel.commonutils.network.d$a     // Catch:{ IOException -> 0x00aa, Throwable -> 0x00f3, all -> 0x00f0 }
            java.io.InputStream r8 = r4.getInputStream()     // Catch:{ IOException -> 0x00aa, Throwable -> 0x00f3, all -> 0x00f0 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x00aa, Throwable -> 0x00f3, all -> 0x00f0 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00aa, Throwable -> 0x00f3, all -> 0x00f0 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00aa, Throwable -> 0x00f3, all -> 0x00f0 }
            goto L_0x00bd
        L_0x00aa:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            com.xiaomi.channel.commonutils.network.d$a r7 = new com.xiaomi.channel.commonutils.network.d$a     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            java.io.InputStream r4 = r4.getErrorStream()     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r7.<init>(r4)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
        L_0x00bd:
            java.lang.String r4 = r5.readLine()     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            r6.<init>()     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            java.lang.String r7 = "line.separator"
            java.lang.String r7 = java.lang.System.getProperty(r7)     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
        L_0x00cc:
            if (r4 == 0) goto L_0x00d9
            r6.append(r4)     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            r6.append(r7)     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            java.lang.String r4 = r5.readLine()     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            goto L_0x00cc
        L_0x00d9:
            java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            r1.c = r4     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            r5.close()     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00e3 }
            return r1
        L_0x00e3:
            r4 = move-exception
            goto L_0x00f5
        L_0x00e5:
            r4 = move-exception
            goto L_0x0101
        L_0x00e7:
            java.util.Map<java.lang.String, java.lang.String> r3 = r1.b     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            r3.put(r5, r8)     // Catch:{ IOException -> 0x00ff, Throwable -> 0x00f3, all -> 0x00f0 }
            int r6 = r6 + 1
            int r6 = r6 + r7
            goto L_0x008a
        L_0x00f0:
            r4 = move-exception
            r5 = r2
            goto L_0x0103
        L_0x00f3:
            r4 = move-exception
            r5 = r2
        L_0x00f5:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0102 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0102 }
            r6.<init>(r4)     // Catch:{ all -> 0x0102 }
            throw r6     // Catch:{ all -> 0x0102 }
        L_0x00ff:
            r4 = move-exception
            r5 = r2
        L_0x0101:
            throw r4     // Catch:{ all -> 0x0102 }
        L_0x0102:
            r4 = move-exception
        L_0x0103:
            if (r2 == 0) goto L_0x010b
            r2.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x010b
        L_0x0109:
            r5 = move-exception
            goto L_0x0111
        L_0x010b:
            if (r5 == 0) goto L_0x0116
            r5.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0116
        L_0x0111:
            java.lang.String r6 = "error while closing strean"
            android.util.Log.e(r0, r6, r5)
        L_0x0116:
            goto L_0x0118
        L_0x0117:
            throw r4
        L_0x0118:
            goto L_0x0117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.xiaomi.channel.commonutils.network.b");
    }

    public static b a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, (Map<String, String>) null, (b) null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection b2 = b(context, url2);
                b2.setConnectTimeout(10000);
                b2.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    b2.setRequestProperty(HttpHeaders.USER_AGENT, str);
                }
                if (str2 != null) {
                    b2.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String next : map.keySet()) {
                        b2.setRequestProperty(next, map.get(next));
                    }
                }
                if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                    bVar.a = b2.getResponseCode();
                    if (bVar.b == null) {
                        bVar.b = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = b2.getHeaderFieldKey(i);
                        String headerField = b2.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey)) {
                            if (!TextUtils.isEmpty(headerField)) {
                                bVar.b.put(headerFieldKey, headerField);
                            }
                        }
                        i++;
                    }
                }
                return new a(b2.getInputStream());
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        } else {
            throw new IllegalArgumentException(PushConstants.WEB_URL);
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, (String) null, "UTF-8", (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[SYNTHETIC, Splitter:B:19:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r2, java.net.URL r3, boolean r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "Failed to close responseStream"
            java.lang.String r1 = "com.xiaomi.common.Network"
            java.io.InputStream r2 = a((android.content.Context) r2, (java.net.URL) r3, (boolean) r4, (java.lang.String) r5, (java.lang.String) r7)     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r4 = 1024(0x400, float:1.435E-42)
            r3.<init>(r4)     // Catch:{ all -> 0x004b }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x004b }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x004b }
            r5.<init>(r2, r6)     // Catch:{ all -> 0x004b }
            r4.<init>(r5)     // Catch:{ all -> 0x004b }
            r5 = 4096(0x1000, float:5.74E-42)
            char[] r5 = new char[r5]     // Catch:{ all -> 0x004b }
        L_0x001d:
            r6 = -1
            int r7 = r4.read(r5)     // Catch:{ all -> 0x004b }
            if (r6 == r7) goto L_0x0029
            r6 = 0
            r3.append(r5, r6, r7)     // Catch:{ all -> 0x004b }
            goto L_0x001d
        L_0x0029:
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0046
        L_0x002f:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r2 = r2.toString()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.e(r1, r2)
        L_0x0046:
            java.lang.String r2 = r3.toString()
            return r2
        L_0x004b:
            r3 = move-exception
            goto L_0x004f
        L_0x004d:
            r3 = move-exception
            r2 = 0
        L_0x004f:
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x006c
        L_0x0055:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r2 = r2.toString()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.e(r1, r2)
        L_0x006c:
            goto L_0x006e
        L_0x006d:
            throw r3
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(android.content.Context, java.net.URL, boolean, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", new Object[]{str, c.a(String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[]{str}))});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014d A[SYNTHETIC, Splitter:B:62:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0155 A[Catch:{ IOException -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015a A[Catch:{ IOException -> 0x0151 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.io.File r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "--"
            java.lang.String r1 = "error while closing strean"
            java.lang.String r2 = "com.xiaomi.common.Network"
            java.lang.String r3 = "\r\n"
            boolean r4 = r11.exists()
            r5 = 0
            if (r4 != 0) goto L_0x0010
            return r5
        L_0x0010:
            java.lang.String r4 = r11.getName()
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.net.URLConnection r9 = r6.openConnection()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r6 = 15000(0x3a98, float:2.102E-41)
            r9.setReadTimeout(r6)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r6 = 10000(0x2710, float:1.4013E-41)
            r9.setConnectTimeout(r6)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r6 = 1
            r9.setDoInput(r6)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r9.setDoOutput(r6)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r6 = 0
            r9.setUseCaches(r6)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.String r7 = "POST"
            r9.setRequestMethod(r7)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.String r7 = "Connection"
            java.lang.String r8 = "Keep-Alive"
            r9.setRequestProperty(r7, r8)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "multipart/form-data;boundary=*****"
            r9.setRequestProperty(r7, r8)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            if (r10 == 0) goto L_0x006d
            java.util.Set r10 = r10.entrySet()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
        L_0x0051:
            boolean r7 = r10.hasNext()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r10.next()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r9.setRequestProperty(r8, r7)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            goto L_0x0051
        L_0x006d:
            int r10 = r4.length()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            int r10 = r10 + 77
            long r7 = r11.length()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            int r4 = (int) r7     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            int r10 = r10 + r4
            int r4 = r12.length()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            int r10 = r10 + r4
            r9.setFixedLengthStreamingMode(r10)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.io.OutputStream r4 = r9.getOutputStream()     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            r10.<init>(r4)     // Catch:{ IOException -> 0x0146, Throwable -> 0x0139, all -> 0x0135 }
            java.lang.String r4 = "--*****\r\n"
            r10.writeBytes(r4)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r4.<init>()     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            java.lang.String r7 = "Content-Disposition: form-data; name=\""
            r4.append(r7)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r4.append(r12)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            java.lang.String r12 = "\";filename=\""
            r4.append(r12)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            java.lang.String r12 = r11.getName()     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r4.append(r12)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            java.lang.String r12 = "\""
            r4.append(r12)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r4.append(r3)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            java.lang.String r12 = r4.toString()     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r10.writeBytes(r12)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r10.writeBytes(r3)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r12.<init>(r11)     // Catch:{ IOException -> 0x0132, Throwable -> 0x012f, all -> 0x012c }
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r11 = new byte[r11]     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
        L_0x00c3:
            int r4 = r12.read(r11)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r7 = -1
            if (r4 == r7) goto L_0x00d1
            r10.write(r11, r6, r4)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r10.flush()     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            goto L_0x00c3
        L_0x00d1:
            r10.writeBytes(r3)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r10.writeBytes(r0)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            java.lang.String r11 = "*****"
            r10.writeBytes(r11)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r10.writeBytes(r0)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r10.writeBytes(r3)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r10.flush()     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            java.lang.StringBuffer r11 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r11.<init>()     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            com.xiaomi.channel.commonutils.network.d$a r4 = new com.xiaomi.channel.commonutils.network.d$a     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r4.<init>(r9)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0128, Throwable -> 0x0124, all -> 0x0120 }
        L_0x00fd:
            java.lang.String r9 = r0.readLine()     // Catch:{ IOException -> 0x011e, Throwable -> 0x011c, all -> 0x011a }
            if (r9 == 0) goto L_0x0107
            r11.append(r9)     // Catch:{ IOException -> 0x011e, Throwable -> 0x011c, all -> 0x011a }
            goto L_0x00fd
        L_0x0107:
            java.lang.String r9 = r11.toString()     // Catch:{ IOException -> 0x011e, Throwable -> 0x011c, all -> 0x011a }
            r12.close()     // Catch:{ IOException -> 0x0115 }
            r10.close()     // Catch:{ IOException -> 0x0115 }
            r0.close()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0119
        L_0x0115:
            r10 = move-exception
            android.util.Log.e(r2, r1, r10)
        L_0x0119:
            return r9
        L_0x011a:
            r9 = move-exception
            goto L_0x0122
        L_0x011c:
            r9 = move-exception
            goto L_0x0126
        L_0x011e:
            r9 = move-exception
            goto L_0x012a
        L_0x0120:
            r9 = move-exception
            r0 = r5
        L_0x0122:
            r5 = r12
            goto L_0x014b
        L_0x0124:
            r9 = move-exception
            r0 = r5
        L_0x0126:
            r5 = r12
            goto L_0x013c
        L_0x0128:
            r9 = move-exception
            r0 = r5
        L_0x012a:
            r5 = r12
            goto L_0x0149
        L_0x012c:
            r9 = move-exception
            r0 = r5
            goto L_0x014b
        L_0x012f:
            r9 = move-exception
            r0 = r5
            goto L_0x013c
        L_0x0132:
            r9 = move-exception
            r0 = r5
            goto L_0x0149
        L_0x0135:
            r9 = move-exception
            r10 = r5
            r0 = r10
            goto L_0x014b
        L_0x0139:
            r9 = move-exception
            r10 = r5
            r0 = r10
        L_0x013c:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x014a }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x014a }
            r11.<init>(r9)     // Catch:{ all -> 0x014a }
            throw r11     // Catch:{ all -> 0x014a }
        L_0x0146:
            r9 = move-exception
            r10 = r5
            r0 = r10
        L_0x0149:
            throw r9     // Catch:{ all -> 0x014a }
        L_0x014a:
            r9 = move-exception
        L_0x014b:
            if (r5 == 0) goto L_0x0153
            r5.close()     // Catch:{ IOException -> 0x0151 }
            goto L_0x0153
        L_0x0151:
            r10 = move-exception
            goto L_0x015e
        L_0x0153:
            if (r10 == 0) goto L_0x0158
            r10.close()     // Catch:{ IOException -> 0x0151 }
        L_0x0158:
            if (r0 == 0) goto L_0x0161
            r0.close()     // Catch:{ IOException -> 0x0151 }
            goto L_0x0161
        L_0x015e:
            android.util.Log.e(r2, r1, r10)
        L_0x0161:
            goto L_0x0163
        L_0x0162:
            throw r9
        L_0x0163:
            goto L_0x0162
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(java.lang.String, java.util.Map, java.io.File, java.lang.String):java.lang.String");
    }

    public static String a(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol());
        sb.append("://");
        sb.append("10.0.0.172");
        sb.append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            sb.append("?");
            sb.append(url.getQuery());
        }
        return sb.toString();
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : map.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + e.toString());
                    Log.d("com.xiaomi.common.Network", "map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static HttpURLConnection b(Context context, URL url) {
        URLConnection openConnection;
        if ("http".equals(url.getProtocol())) {
            if (c(context)) {
                openConnection = url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
                return (HttpURLConnection) openConnection;
            } else if (b(context)) {
                String host = url.getHost();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a(url)).openConnection();
                httpURLConnection.addRequestProperty("X-Online-Host", host);
                return httpURLConnection;
            }
        }
        openConnection = url.openConnection();
        return (HttpURLConnection) openConnection;
    }

    private static URL b(String str) {
        return new URL(str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r8) {
        /*
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r8.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r0 = r0.getSimCountryIso()
            java.lang.String r1 = "CN"
            boolean r0 = r1.equalsIgnoreCase(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0016
            return r1
        L_0x0016:
            java.lang.String r0 = "connectivity"
            java.lang.Object r8 = r8.getSystemService(r0)     // Catch:{ Exception -> 0x0053 }
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch:{ Exception -> 0x0053 }
            if (r8 != 0) goto L_0x0021
            return r1
        L_0x0021:
            android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch:{  }
            if (r8 != 0) goto L_0x0028
            return r1
        L_0x0028:
            java.lang.String r2 = r8.getExtraInfo()
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 != 0) goto L_0x0053
            int r8 = r2.length()
            r0 = 3
            if (r8 >= r0) goto L_0x003a
            goto L_0x0053
        L_0x003a:
            java.lang.String r8 = "ctwap"
            boolean r8 = r2.contains(r8)
            if (r8 == 0) goto L_0x0043
            return r1
        L_0x0043:
            r3 = 1
            int r8 = r2.length()
            int r4 = r8 + -3
            r6 = 0
            r7 = 3
            java.lang.String r5 = "wap"
            boolean r8 = r2.regionMatches(r3, r4, r5, r6, r7)
            return r8
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.b(android.content.Context):boolean");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(android.content.Context r3) {
        /*
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r3.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r0 = r0.getSimCountryIso()
            java.lang.String r1 = "CN"
            boolean r0 = r1.equalsIgnoreCase(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0016
            return r1
        L_0x0016:
            java.lang.String r0 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch:{ Exception -> 0x0044 }
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0021
            return r1
        L_0x0021:
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()     // Catch:{  }
            if (r3 != 0) goto L_0x0028
            return r1
        L_0x0028:
            java.lang.String r3 = r3.getExtraInfo()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0044
            int r0 = r3.length()
            r2 = 3
            if (r0 >= r2) goto L_0x003a
            goto L_0x0044
        L_0x003a:
            java.lang.String r0 = "ctwap"
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L_0x0044
            r3 = 1
            return r3
        L_0x0044:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.c(android.content.Context):boolean");
    }

    public static boolean d(Context context) {
        return a(context) >= 0;
    }

    public static boolean e(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r2 = r2.getActiveNetworkInfo();
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(android.content.Context r2) {
        /*
            r0 = 0
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch:{ Exception -> 0x001b }
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ Exception -> 0x001b }
            if (r2 != 0) goto L_0x000c
            return r0
        L_0x000c:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch:{  }
            if (r2 != 0) goto L_0x0013
            return r0
        L_0x0013:
            int r2 = r2.getType()
            r1 = 1
            if (r1 != r2) goto L_0x001b
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.f(android.content.Context):boolean");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g(android.content.Context r3) {
        /*
            java.lang.String r0 = ""
            boolean r1 = f(r3)
            if (r1 == 0) goto L_0x000b
            java.lang.String r3 = "wifi"
            return r3
        L_0x000b:
            java.lang.String r1 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch:{ Exception -> 0x0048 }
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3     // Catch:{ Exception -> 0x0048 }
            if (r3 != 0) goto L_0x0016
            return r0
        L_0x0016:
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()     // Catch:{  }
            if (r3 != 0) goto L_0x001d
            return r0
        L_0x001d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.getTypeName()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            java.lang.String r2 = r3.getSubtypeName()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r3 = r3.getExtraInfo()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r3 = r3.toLowerCase()
            return r3
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.g(android.content.Context):java.lang.String");
    }
}
