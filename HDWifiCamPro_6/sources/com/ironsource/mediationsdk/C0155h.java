package com.ironsource.mediationsdk;

import android.content.Context;
import android.util.Pair;
import com.ironsource.mediationsdk.server.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.g;
import com.ironsource.mediationsdk.utils.p;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.h  reason: case insensitive filesystem */
public final class C0155h {
    ISBannerSize a;
    private final String b = "1";
    private final String c = "102";
    private final String d = "103";
    private final String e = "102";
    private final String f = "GenericNotifications";
    private String g;
    private String h;
    private c i;
    private C0154g j;

    /* renamed from: com.ironsource.mediationsdk.h$a */
    static class a implements Runnable {
        private WeakReference<C0154g> a;
        private int b;
        private String c;
        private String d;
        private List<b> e;
        private b f;
        private JSONObject g;
        private JSONObject h;
        private long i;
        private int j;
        private String k = "other";
        private int l;
        private String m = "";
        private int n = 0;
        private final URL o;
        private final JSONObject p;
        private final boolean q;
        private final int r;
        private final long s;
        private final boolean t;
        private final boolean u;
        private final int v;

        a(C0154g gVar, URL url, JSONObject jSONObject, boolean z, int i2, long j2, boolean z2, boolean z3, int i3) {
            this.a = new WeakReference<>(gVar);
            this.o = url;
            this.p = jSONObject;
            this.q = z;
            this.r = i2;
            this.s = j2;
            this.t = z2;
            this.u = z3;
            this.v = i3;
        }

        private static String a(HttpURLConnection httpURLConnection) {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        /* JADX WARNING: type inference failed for: r0v19, types: [java.net.URLConnection] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0220  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a() {
            /*
                r17 = this;
                r1 = r17
                java.lang.String r2 = "decompression error"
                java.lang.String r3 = "decryption error"
                java.lang.String r4 = "other"
                java.util.Date r0 = new java.util.Date
                r0.<init>()
                long r5 = r0.getTime()
                r1.i = r5
                r5 = 0
                int r0 = r1.n     // Catch:{ Exception -> 0x0251 }
                r6 = 1015(0x3f7, float:1.422E-42)
                r7 = 1
                if (r0 != r6) goto L_0x001d
                r0 = r7
                goto L_0x001f
            L_0x001d:
                int r0 = r1.v     // Catch:{ Exception -> 0x0251 }
            L_0x001f:
                r1.l = r0     // Catch:{ Exception -> 0x0251 }
                r1.j = r5
                r0 = 0
                r8 = r0
            L_0x0025:
                int r0 = r1.j
                int r9 = r1.r
                if (r0 >= r9) goto L_0x0248
                java.util.Date r0 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                long r9 = r0.getTime()     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.lang.String r11 = "Auction Handler: auction trial "
                r0.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                int r11 = r1.j     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                int r11 = r11 + r7
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.lang.String r11 = " out of "
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                int r11 = r1.r     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.lang.String r11 = " max trials"
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.lang.String r0 = r0.toString()     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                com.ironsource.mediationsdk.logger.IronSourceLoggerManager r11 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r12 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                r11.log(r12, r0, r5)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r0)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.net.URL r0 = r1.o     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                long r11 = r1.s     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                int r11 = (int) r11     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                r12 = r0
                java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.lang.String r0 = "POST"
                r12.setRequestMethod(r0)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r13 = "application/json; charset=utf-8"
                r12.setRequestProperty(r0, r13)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                r12.setReadTimeout(r11)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                r12.setDoInput(r7)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                r12.setDoOutput(r7)     // Catch:{ SocketTimeoutException -> 0x0231, Exception -> 0x0209 }
                org.json.JSONObject r8 = r1.p     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                boolean r11 = r1.t     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.io.OutputStream r13 = r12.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.io.OutputStreamWriter r14 = new java.io.OutputStreamWriter     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r0 = "UTF-8"
                r14.<init>(r13, r0)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.io.BufferedWriter r15 = new java.io.BufferedWriter     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r15.<init>(r14)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r16 = ""
                int r0 = r1.l     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r5 = 2
                if (r0 != r5) goto L_0x00b0
                com.ironsource.mediationsdk.utils.g r0 = com.ironsource.mediationsdk.utils.g.a()     // Catch:{ JSONException -> 0x00a5 }
                java.lang.String r16 = r0.d()     // Catch:{ JSONException -> 0x00a5 }
                goto L_0x00b0
            L_0x00a5:
                r0 = move-exception
                java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r1.m = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r1.n = r6     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r1.l = r7     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
            L_0x00b0:
                java.lang.String r0 = r8.toString()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r8 = r17.b()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                if (r11 == 0) goto L_0x00c6
                com.ironsource.mediationsdk.logger.IronLog r11 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r6 = "compressing and encrypting auction request"
                r11.verbose(r6)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.compressAndEncrypt(r8, r0)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                goto L_0x00ca
            L_0x00c6:
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.encode(r8, r0)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
            L_0x00ca:
                int r6 = r1.l     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                if (r6 != r5) goto L_0x00dc
                java.lang.String r6 = "{\"sk\" : \"%1$s\", \"ct\" : \"%2$s\"}"
                java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r11 = 0
                r8[r11] = r16     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r8[r7] = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r0 = java.lang.String.format(r6, r8)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                goto L_0x00e7
            L_0x00dc:
                java.lang.String r6 = "{\"request\" : \"%1$s\"}"
                java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r11 = 0
                r8[r11] = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r0 = java.lang.String.format(r6, r8)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
            L_0x00e7:
                r15.write(r0)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r15.flush()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r15.close()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r14.close()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r13.close()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                int r0 = r12.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r6 = 200(0xc8, float:2.8E-43)
                if (r0 == r6) goto L_0x013c
                r5 = 1001(0x3e9, float:1.403E-42)
                r1.b = r5     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r6 = "Auction status not 200 error, error code response from server - "
                r5.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r5.append(r0)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r0 = r5.toString()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r1.c = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r5 = r1.c     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r0.error(r5)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r12.disconnect()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                int r0 = r1.j     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                int r5 = r1.r     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                int r5 = r5 - r7
                if (r0 >= r5) goto L_0x0139
                long r5 = r1.s     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.util.Date r0 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                long r13 = r0.getTime()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                long r13 = r13 - r9
                long r5 = r5 - r13
                r8 = 0
                int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x0139
                android.os.SystemClock.sleep(r5)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
            L_0x0139:
                r8 = r12
                goto L_0x023e
            L_0x013c:
                java.lang.String r0 = a(r12)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                boolean r6 = r1.q     // Catch:{ JSONException -> 0x01c3 }
                boolean r8 = r1.u     // Catch:{ JSONException -> 0x01c3 }
                boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x01c3 }
                if (r9 != 0) goto L_0x01bb
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01c3 }
                r9.<init>(r0)     // Catch:{ JSONException -> 0x01c3 }
                if (r6 == 0) goto L_0x0194
                java.lang.String r0 = r17.b()     // Catch:{ JSONException -> 0x01c3 }
                int r6 = r1.l     // Catch:{ JSONException -> 0x01c3 }
                if (r6 != r5) goto L_0x015c
                java.lang.String r5 = "ct"
                goto L_0x015e
            L_0x015c:
                java.lang.String r5 = "response"
            L_0x015e:
                java.lang.String r5 = r9.getString(r5)     // Catch:{ JSONException -> 0x01c3 }
                if (r8 == 0) goto L_0x017d
                com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ JSONException -> 0x01c3 }
                java.lang.String r8 = "decrypting and decompressing auction response"
                r6.verbose(r8)     // Catch:{ JSONException -> 0x01c3 }
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.decryptAndDecompress(r0, r5)     // Catch:{ JSONException -> 0x01c3 }
                if (r0 == 0) goto L_0x0177
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01c3 }
                r5.<init>(r0)     // Catch:{ JSONException -> 0x01c3 }
                goto L_0x018c
            L_0x0177:
                org.json.JSONException r0 = new org.json.JSONException     // Catch:{ JSONException -> 0x01c3 }
                r0.<init>(r2)     // Catch:{ JSONException -> 0x01c3 }
                throw r0     // Catch:{ JSONException -> 0x01c3 }
            L_0x017d:
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.decode(r0, r5)     // Catch:{ JSONException -> 0x01c3 }
                boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x01c3 }
                if (r5 != 0) goto L_0x018e
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01c3 }
                r5.<init>(r0)     // Catch:{ JSONException -> 0x01c3 }
            L_0x018c:
                r9 = r5
                goto L_0x0194
            L_0x018e:
                org.json.JSONException r0 = new org.json.JSONException     // Catch:{ JSONException -> 0x01c3 }
                r0.<init>(r3)     // Catch:{ JSONException -> 0x01c3 }
                throw r0     // Catch:{ JSONException -> 0x01c3 }
            L_0x0194:
                com.ironsource.mediationsdk.C0153f.a()     // Catch:{ JSONException -> 0x01c3 }
                com.ironsource.mediationsdk.f$a r0 = com.ironsource.mediationsdk.C0153f.a((org.json.JSONObject) r9)     // Catch:{ JSONException -> 0x01c3 }
                java.lang.String r5 = r0.a     // Catch:{ JSONException -> 0x01c3 }
                r1.d = r5     // Catch:{ JSONException -> 0x01c3 }
                java.util.List<com.ironsource.mediationsdk.server.b> r5 = r0.b     // Catch:{ JSONException -> 0x01c3 }
                r1.e = r5     // Catch:{ JSONException -> 0x01c3 }
                com.ironsource.mediationsdk.server.b r5 = r0.c     // Catch:{ JSONException -> 0x01c3 }
                r1.f = r5     // Catch:{ JSONException -> 0x01c3 }
                org.json.JSONObject r5 = r0.d     // Catch:{ JSONException -> 0x01c3 }
                r1.g = r5     // Catch:{ JSONException -> 0x01c3 }
                org.json.JSONObject r5 = r0.e     // Catch:{ JSONException -> 0x01c3 }
                r1.h = r5     // Catch:{ JSONException -> 0x01c3 }
                int r5 = r0.f     // Catch:{ JSONException -> 0x01c3 }
                r1.b = r5     // Catch:{ JSONException -> 0x01c3 }
                java.lang.String r0 = r0.g     // Catch:{ JSONException -> 0x01c3 }
                r1.c = r0     // Catch:{ JSONException -> 0x01c3 }
                r12.disconnect()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                return r7
            L_0x01bb:
                org.json.JSONException r0 = new org.json.JSONException     // Catch:{ JSONException -> 0x01c3 }
                java.lang.String r5 = "empty response"
                r0.<init>(r5)     // Catch:{ JSONException -> 0x01c3 }
                throw r0     // Catch:{ JSONException -> 0x01c3 }
            L_0x01c3:
                r0 = move-exception
                java.lang.String r5 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                if (r5 == 0) goto L_0x01dc
                java.lang.String r5 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                boolean r5 = r5.equalsIgnoreCase(r3)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                if (r5 == 0) goto L_0x01dc
                r5 = 1003(0x3eb, float:1.406E-42)
                r1.b = r5     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r5 = "Auction decryption error"
                r1.c = r5     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
            L_0x01dc:
                java.lang.String r5 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                if (r5 == 0) goto L_0x01f5
                java.lang.String r0 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                if (r0 == 0) goto L_0x01f5
                r0 = 1008(0x3f0, float:1.413E-42)
                r1.b = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r0 = "Auction decompression error"
            L_0x01f2:
                r1.c = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                goto L_0x01fc
            L_0x01f5:
                r0 = 1002(0x3ea, float:1.404E-42)
                r1.b = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                java.lang.String r0 = "Auction parsing error"
                goto L_0x01f2
            L_0x01fc:
                java.lang.String r0 = "parsing"
                r1.k = r0     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r12.disconnect()     // Catch:{ SocketTimeoutException -> 0x0207, Exception -> 0x0205 }
                r2 = 0
                return r2
            L_0x0205:
                r0 = move-exception
                goto L_0x020b
            L_0x0207:
                r8 = r12
                goto L_0x0231
            L_0x0209:
                r0 = move-exception
                r12 = r8
            L_0x020b:
                com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r5 = "getting exception "
                r3.<init>(r5)
                r3.append(r0)
                java.lang.String r3 = r3.toString()
                r2.error(r3)
                if (r12 == 0) goto L_0x0223
                r12.disconnect()
            L_0x0223:
                r2 = 1000(0x3e8, float:1.401E-42)
                r1.b = r2
                java.lang.String r0 = r0.getMessage()
                r1.c = r0
                r1.k = r4
                r2 = 0
                return r2
            L_0x0231:
                if (r8 == 0) goto L_0x0236
                r8.disconnect()
            L_0x0236:
                r0 = 1006(0x3ee, float:1.41E-42)
                r1.b = r0
                java.lang.String r0 = "Connection timed out"
                r1.c = r0
            L_0x023e:
                int r0 = r1.j
                int r0 = r0 + r7
                r1.j = r0
                r5 = 0
                r6 = 1015(0x3f7, float:1.422E-42)
                goto L_0x0025
            L_0x0248:
                int r9 = r9 - r7
                r1.j = r9
                java.lang.String r0 = "trials_fail"
                r1.k = r0
                r2 = 0
                return r2
            L_0x0251:
                r0 = move-exception
                r2 = r5
                r3 = 1007(0x3ef, float:1.411E-42)
                r1.b = r3
                java.lang.String r0 = r0.getMessage()
                r1.c = r0
                r1.j = r2
                r1.k = r4
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0155h.a.a():boolean");
        }

        private String b() {
            return this.l == 2 ? g.a().c() : g.a().b();
        }

        public final void run() {
            boolean a2 = a();
            C0154g gVar = (C0154g) this.a.get();
            if (gVar != null) {
                long time = new Date().getTime() - this.i;
                if (a2) {
                    gVar.a(this.e, this.d, this.f, this.g, this.h, this.j + 1, time, this.n, this.m);
                } else {
                    gVar.a(this.b, this.c, this.j + 1, this.k, time);
                }
            }
        }
    }

    public C0155h(String str, c cVar, C0154g gVar) {
        this.g = str;
        this.i = cVar;
        this.j = gVar;
        this.h = IronSourceUtils.getSessionId();
    }

    private JSONObject a(Context context, Map<String, Object> map, List<String> list, C0156i iVar, int i2, boolean z, IronSourceSegment ironSourceSegment) {
        new JSONObject();
        p c2 = H.a().i.c.e.c();
        JSONObject a2 = a(ironSourceSegment);
        boolean z2 = c2.d;
        C0153f a3 = C0153f.a();
        if (z2) {
            return a3.a(this.g, z, map, list, iVar, i2, this.a, a2);
        }
        JSONObject a4 = a3.a(context, map, list, iVar, i2, this.h, this.i, this.a, a2);
        a4.put(IronSourceConstants.EVENTS_AD_UNIT, this.g);
        a4.put("doNotEncryptResponse", z ? "false" : "true");
        return a4;
    }

    private static JSONObject a(IronSourceSegment ironSourceSegment) {
        JSONObject jSONObject = new JSONObject();
        if (ironSourceSegment == null) {
            return null;
        }
        Vector<Pair<String, String>> a2 = ironSourceSegment.a();
        for (int i2 = 0; i2 < a2.size(); i2++) {
            try {
                jSONObject.put((String) a2.get(i2).first, a2.get(i2).second);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void a(b bVar, int i2, b bVar2) {
        for (String a2 : bVar.f()) {
            String a3 = C0153f.a().a(a2, i2, bVar, "", "", "");
            C0153f.a();
            C0153f.a("reportLoadSuccess", bVar.a(), a3);
        }
        if (bVar2 != null) {
            for (String a4 : bVar2.f()) {
                String a5 = C0153f.a().a(a4, i2, bVar, "", "102", "");
                C0153f.a();
                C0153f.a("reportLoadSuccess", "GenericNotifications", a5);
            }
        }
    }

    public static void a(b bVar, int i2, b bVar2, String str) {
        for (String a2 : bVar.d()) {
            String a3 = C0153f.a().a(a2, i2, bVar, "", "", str);
            C0153f.a();
            C0153f.a("reportImpression", bVar.a(), a3);
        }
        if (bVar2 != null) {
            for (String a4 : bVar2.d()) {
                String a5 = C0153f.a().a(a4, i2, bVar, "", "102", str);
                C0153f.a();
                C0153f.a("reportImpression", "GenericNotifications", a5);
            }
        }
    }

    public static void a(ArrayList<String> arrayList, ConcurrentHashMap<String, b> concurrentHashMap, int i2, b bVar, b bVar2) {
        Iterator<String> it = arrayList.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals(bVar2.a())) {
                z2 = i2 == 2;
                z = true;
            } else {
                int i3 = i2;
                b bVar3 = concurrentHashMap.get(next);
                String c2 = bVar3.c();
                String str = z ? z2 ? "102" : "103" : "1";
                for (String a2 : bVar3.e()) {
                    String a3 = C0153f.a().a(a2, i2, bVar2, c2, str, "");
                    C0153f.a();
                    C0153f.a("reportAuctionLose", bVar3.a(), a3);
                }
            }
        }
        int i4 = i2;
        if (bVar != null) {
            for (String a4 : bVar.e()) {
                String a5 = C0153f.a().a(a4, i2, bVar2, "", "102", "");
                C0153f.a();
                C0153f.a("reportAuctionLose", "GenericNotifications", a5);
            }
        }
    }

    public final void a(Context context, Map<String, Object> map, List<String> list, C0156i iVar, int i2, IronSourceSegment ironSourceSegment) {
        try {
            boolean z = IronSourceUtils.getSerr() == 1;
            com.ironsource.environment.e.c.a.c(new a(this.j, new URL(this.i.d), a(context, map, list, iVar, i2, z, ironSourceSegment), z, this.i.e, this.i.h, this.i.p, this.i.q, this.i.r));
        } catch (Exception e2) {
            this.j.a(1000, e2.getMessage(), 0, "other", 0);
        }
    }

    public final void a(CopyOnWriteArrayList<Y> copyOnWriteArrayList, ConcurrentHashMap<String, b> concurrentHashMap, int i2, b bVar, b bVar2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Y> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().k());
        }
        a((ArrayList<String>) arrayList, concurrentHashMap, i2, bVar, bVar2);
    }
}
