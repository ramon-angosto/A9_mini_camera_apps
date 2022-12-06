package com.mbridge.msdk.videocommon.download;

import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.videocommon.download.f;
import com.mbridge.msdk.videocommon.download.g;

/* compiled from: DownLoadUtils */
public final class e {
    public static void a(final String str, final g.c cVar, final boolean z) {
        try {
            if (!x.a(str)) {
                if (URLUtil.isNetworkUrl(str)) {
                    f.a.a.a(new a() {
                        public final void b() {
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: byte[]} */
                        /* JADX WARNING: type inference failed for: r7v1 */
                        /* JADX WARNING: Failed to insert additional move for type inference */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:100:0x0159 A[Catch:{ Exception -> 0x0155 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:53:0x00d0 A[SYNTHETIC, Splitter:B:53:0x00d0] */
                        /* JADX WARNING: Removed duplicated region for block: B:58:0x00d8 A[Catch:{ Exception -> 0x00d4 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:61:0x00e5 A[SYNTHETIC, Splitter:B:61:0x00e5] */
                        /* JADX WARNING: Removed duplicated region for block: B:77:0x010e A[Catch:{ all -> 0x00f6 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:80:0x011a A[Catch:{ all -> 0x00f6 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:95:0x0151 A[SYNTHETIC, Splitter:B:95:0x0151] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void a() {
                            /*
                                r11 = this;
                                java.lang.String r0 = "DownLoadUtils"
                                r1 = 0
                                r2 = 0
                                com.mbridge.msdk.videocommon.download.g$c r3 = r3     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                if (r3 == 0) goto L_0x000d
                                com.mbridge.msdk.videocommon.download.g$c r3 = r3     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r3.a()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                            L_0x000d:
                                java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.lang.String r4 = r2     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r3.<init>(r4)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r4 = 30000(0x7530, float:4.2039E-41)
                                r3.setReadTimeout(r4)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r4 = 20000(0x4e20, float:2.8026E-41)
                                r3.setConnectTimeout(r4)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                int r4 = r3.getResponseCode()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r5.<init>()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.lang.String r6 = "response code "
                                r5.append(r6)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r5.append(r4)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                com.mbridge.msdk.foundation.tools.q.a(r0, r5)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r5 = 200(0xc8, float:2.8E-43)
                                if (r4 != r5) goto L_0x0082
                                java.io.InputStream r4 = r3.getInputStream()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r5 = 6144(0x1800, float:8.61E-42)
                                byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x007f, all -> 0x007b }
                                java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x007f, all -> 0x007b }
                                r6.<init>()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
                            L_0x004d:
                                int r7 = r4.read(r5)     // Catch:{ Exception -> 0x0077 }
                                r8 = -1
                                if (r7 == r8) goto L_0x0058
                                r6.write(r5, r1, r7)     // Catch:{ Exception -> 0x0077 }
                                goto L_0x004d
                            L_0x0058:
                                byte[] r5 = r6.toByteArray()     // Catch:{ Exception -> 0x0077 }
                                if (r5 == 0) goto L_0x0071
                                byte[] r5 = r6.toByteArray()     // Catch:{ Exception -> 0x0077 }
                                boolean r7 = r4     // Catch:{ Exception -> 0x006e }
                                if (r7 != 0) goto L_0x006c
                                java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x006e }
                                r7.<init>(r5)     // Catch:{ Exception -> 0x006e }
                                goto L_0x0073
                            L_0x006c:
                                r7 = r2
                                goto L_0x0073
                            L_0x006e:
                                r3 = move-exception
                                r7 = r2
                                goto L_0x00b2
                            L_0x0071:
                                r5 = r2
                                r7 = r5
                            L_0x0073:
                                r8 = 1
                                java.lang.String r9 = ""
                                goto L_0x0098
                            L_0x0077:
                                r3 = move-exception
                                r5 = r2
                                r7 = r5
                                goto L_0x00b2
                            L_0x007b:
                                r0 = move-exception
                                r6 = r2
                                goto L_0x014e
                            L_0x007f:
                                r3 = move-exception
                                r5 = r2
                                goto L_0x00b0
                            L_0x0082:
                                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r5.<init>()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.lang.String r6 = "responseCode is "
                                r5.append(r6)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r5.append(r4)     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                java.lang.String r9 = r5.toString()     // Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
                                r8 = r1
                                r4 = r2
                                r5 = r4
                                r6 = r5
                                r7 = r6
                            L_0x0098:
                                r3.disconnect()     // Catch:{ Exception -> 0x00a7 }
                                if (r4 == 0) goto L_0x00a0
                                r4.close()     // Catch:{ Exception -> 0x00d4 }
                            L_0x00a0:
                                if (r6 == 0) goto L_0x00a5
                                r6.close()     // Catch:{ Exception -> 0x00d4 }
                            L_0x00a5:
                                r1 = r8
                                goto L_0x00e3
                            L_0x00a7:
                                r3 = move-exception
                                goto L_0x00b2
                            L_0x00a9:
                                r0 = move-exception
                                r6 = r2
                                goto L_0x014f
                            L_0x00ad:
                                r3 = move-exception
                                r4 = r2
                                r5 = r4
                            L_0x00b0:
                                r6 = r5
                                r7 = r6
                            L_0x00b2:
                                java.lang.String r9 = r3.getMessage()     // Catch:{ all -> 0x014d }
                                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x014d }
                                r8.<init>()     // Catch:{ all -> 0x014d }
                                java.lang.String r10 = "getStringFromUrl failed "
                                r8.append(r10)     // Catch:{ all -> 0x014d }
                                java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x014d }
                                r8.append(r3)     // Catch:{ all -> 0x014d }
                                java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x014d }
                                com.mbridge.msdk.foundation.tools.q.d(r0, r3)     // Catch:{ all -> 0x014d }
                                if (r4 == 0) goto L_0x00d6
                                r4.close()     // Catch:{ Exception -> 0x00d4 }
                                goto L_0x00d6
                            L_0x00d4:
                                r0 = move-exception
                                goto L_0x00dc
                            L_0x00d6:
                                if (r6 == 0) goto L_0x00e3
                                r6.close()     // Catch:{ Exception -> 0x00d4 }
                                goto L_0x00e3
                            L_0x00dc:
                                r0.printStackTrace()
                                java.lang.String r9 = r0.getMessage()
                            L_0x00e3:
                                if (r1 == 0) goto L_0x00f8
                                boolean r0 = r4     // Catch:{ all -> 0x00f6 }
                                if (r0 == 0) goto L_0x00f8
                                if (r5 == 0) goto L_0x00f8
                                int r0 = r5.length     // Catch:{ all -> 0x00f6 }
                                if (r0 <= 0) goto L_0x00f8
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x00f6 }
                                java.lang.String r1 = r2     // Catch:{ all -> 0x00f6 }
                                r0.a(r2, r5, r1)     // Catch:{ all -> 0x00f6 }
                                goto L_0x014c
                            L_0x00f6:
                                r0 = move-exception
                                goto L_0x0135
                            L_0x00f8:
                                if (r1 == 0) goto L_0x011a
                                boolean r0 = com.mbridge.msdk.foundation.tools.x.b(r7)     // Catch:{ all -> 0x00f6 }
                                if (r0 == 0) goto L_0x011a
                                int r0 = r7.length()     // Catch:{ all -> 0x00f6 }
                                if (r0 <= 0) goto L_0x011a
                                java.lang.String r0 = "<mbridgeloadend></mbridgeloadend>"
                                boolean r0 = r7.contains(r0)     // Catch:{ all -> 0x00f6 }
                                if (r0 == 0) goto L_0x011a
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x00f6 }
                                if (r0 == 0) goto L_0x014c
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x00f6 }
                                java.lang.String r1 = r2     // Catch:{ all -> 0x00f6 }
                                r0.a(r7, r5, r1)     // Catch:{ all -> 0x00f6 }
                                goto L_0x014c
                            L_0x011a:
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x00f6 }
                                if (r0 == 0) goto L_0x014c
                                com.mbridge.msdk.videocommon.download.g$c r0 = r3     // Catch:{ all -> 0x00f6 }
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f6 }
                                r1.<init>()     // Catch:{ all -> 0x00f6 }
                                java.lang.String r2 = "content write failed:"
                                r1.append(r2)     // Catch:{ all -> 0x00f6 }
                                r1.append(r9)     // Catch:{ all -> 0x00f6 }
                                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f6 }
                                r0.a(r1)     // Catch:{ all -> 0x00f6 }
                                goto L_0x014c
                            L_0x0135:
                                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                                if (r1 == 0) goto L_0x013c
                                r0.printStackTrace()
                            L_0x013c:
                                com.mbridge.msdk.videocommon.download.g$c r1 = r3
                                if (r1 == 0) goto L_0x014c
                                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0148 }
                                r1.a(r0)     // Catch:{ Exception -> 0x0148 }
                                goto L_0x014c
                            L_0x0148:
                                r0 = move-exception
                                r0.printStackTrace()
                            L_0x014c:
                                return
                            L_0x014d:
                                r0 = move-exception
                            L_0x014e:
                                r2 = r4
                            L_0x014f:
                                if (r2 == 0) goto L_0x0157
                                r2.close()     // Catch:{ Exception -> 0x0155 }
                                goto L_0x0157
                            L_0x0155:
                                r1 = move-exception
                                goto L_0x015d
                            L_0x0157:
                                if (r6 == 0) goto L_0x0163
                                r6.close()     // Catch:{ Exception -> 0x0155 }
                                goto L_0x0163
                            L_0x015d:
                                r1.printStackTrace()
                                r1.getMessage()
                            L_0x0163:
                                throw r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.e.AnonymousClass1.a():void");
                        }
                    });
                    return;
                }
            }
            if (cVar != null) {
                cVar.a("url is error");
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }
}
