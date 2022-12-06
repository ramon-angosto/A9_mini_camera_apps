package com.huawei.android.pushagent.c.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0108, code lost:
        if (r8 != null) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0137, code lost:
        if (r8 != null) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0166, code lost:
        if (r8 != null) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0168, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "disconnect the socket");
        r8.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        java.lang.Thread.sleep(2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0174, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0175, code lost:
        com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", r10.toString(), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
        if (r8 == null) goto L_0x016e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0101 A[SYNTHETIC, Splitter:B:103:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0127 A[SYNTHETIC, Splitter:B:113:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0130 A[SYNTHETIC, Splitter:B:118:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0156 A[SYNTHETIC, Splitter:B:128:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x015f A[SYNTHETIC, Splitter:B:133:0x015f] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0185 A[SYNTHETIC, Splitter:B:148:0x0185] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x018e A[SYNTHETIC, Splitter:B:153:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x00f8 A[SYNTHETIC, Splitter:B:98:0x00f8] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:95:0x00e0=Splitter:B:95:0x00e0, B:125:0x013e=Splitter:B:125:0x013e, B:110:0x010f=Splitter:B:110:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.android.pushagent.a.e a(android.content.Context r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "query trs err:"
            java.lang.String r1 = "close br err"
            java.lang.String r2 = "close is err"
            java.lang.String r3 = "disconnect the socket"
            r4 = 0
            java.lang.String r5 = a(r10, r11, r4)
            java.lang.String r6 = "PushLogAC2705"
            java.lang.String r7 = "queryTrs runing"
            com.huawei.android.pushagent.c.a.e.a(r6, r7)
            r7 = 0
            javax.net.ssl.HttpsURLConnection r8 = a(r10, r5, r11, r4, r4)     // Catch:{ UnsupportedEncodingException -> 0x013a, IOException -> 0x010b, Exception -> 0x00dc, all -> 0x00d6 }
            if (r8 == 0) goto L_0x001c
            goto L_0x0033
        L_0x001c:
            r9 = 1
            javax.net.ssl.HttpsURLConnection r8 = a(r10, r5, r11, r9, r4)     // Catch:{ UnsupportedEncodingException -> 0x00d1, IOException -> 0x00cd, Exception -> 0x00c9, all -> 0x00c4 }
            if (r8 == 0) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            javax.net.ssl.HttpsURLConnection r4 = a(r10, r5, r11, r4, r9)     // Catch:{ UnsupportedEncodingException -> 0x00d1, IOException -> 0x00cd, Exception -> 0x00c9, all -> 0x00c4 }
            if (r4 == 0) goto L_0x002c
            r8 = r4
            goto L_0x0033
        L_0x002c:
            javax.net.ssl.HttpsURLConnection r11 = a(r10, r5, r11, r9, r9)     // Catch:{ UnsupportedEncodingException -> 0x00c1, IOException -> 0x00be, Exception -> 0x00bb, all -> 0x00b8 }
            if (r11 == 0) goto L_0x009e
            r8 = r11
        L_0x0033:
            java.lang.String r11 = "queryTrs connect() success"
            com.huawei.android.pushagent.c.a.e.a(r6, r11)     // Catch:{ UnsupportedEncodingException -> 0x00d1, IOException -> 0x00cd, Exception -> 0x00c9, all -> 0x00c4 }
            java.io.InputStream r11 = r8.getInputStream()     // Catch:{ UnsupportedEncodingException -> 0x00d1, IOException -> 0x00cd, Exception -> 0x00c9, all -> 0x00c4 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ UnsupportedEncodingException -> 0x009a, IOException -> 0x0096, Exception -> 0x0092, all -> 0x008e }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ UnsupportedEncodingException -> 0x009a, IOException -> 0x0096, Exception -> 0x0092, all -> 0x008e }
            java.lang.String r9 = "UTF-8"
            r5.<init>(r11, r9)     // Catch:{ UnsupportedEncodingException -> 0x009a, IOException -> 0x0096, Exception -> 0x0092, all -> 0x008e }
            r4.<init>(r5)     // Catch:{ UnsupportedEncodingException -> 0x009a, IOException -> 0x0096, Exception -> 0x0092, all -> 0x008e }
            java.lang.String r5 = r4.readLine()     // Catch:{ UnsupportedEncodingException -> 0x008b, IOException -> 0x0088, Exception -> 0x0085 }
            if (r5 == 0) goto L_0x006c
            com.huawei.android.pushagent.a.e r9 = new com.huawei.android.pushagent.a.e     // Catch:{ UnsupportedEncodingException -> 0x008b, IOException -> 0x0088, Exception -> 0x0085 }
            r9.<init>(r10, r5)     // Catch:{ UnsupportedEncodingException -> 0x008b, IOException -> 0x0088, Exception -> 0x0085 }
            if (r11 == 0) goto L_0x005c
            r11.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005c
        L_0x0059:
            com.huawei.android.pushagent.c.a.e.d(r6, r2)
        L_0x005c:
            r4.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            com.huawei.android.pushagent.c.a.e.d(r6, r1)
        L_0x0063:
            if (r8 == 0) goto L_0x006b
            com.huawei.android.pushagent.c.a.e.a(r6, r3)
            r8.disconnect()
        L_0x006b:
            return r9
        L_0x006c:
            java.lang.String r10 = "response is null"
            com.huawei.android.pushagent.c.a.e.a(r6, r10)     // Catch:{ UnsupportedEncodingException -> 0x008b, IOException -> 0x0088, Exception -> 0x0085 }
            if (r11 == 0) goto L_0x007a
            r11.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007a
        L_0x0077:
            com.huawei.android.pushagent.c.a.e.d(r6, r2)
        L_0x007a:
            r4.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0081
        L_0x007e:
            com.huawei.android.pushagent.c.a.e.d(r6, r1)
        L_0x0081:
            if (r8 == 0) goto L_0x016e
            goto L_0x0168
        L_0x0085:
            r10 = move-exception
            goto L_0x00e0
        L_0x0088:
            r10 = move-exception
            goto L_0x010f
        L_0x008b:
            r10 = move-exception
            goto L_0x013e
        L_0x008e:
            r10 = move-exception
            r4 = r7
            goto L_0x0183
        L_0x0092:
            r10 = move-exception
            r4 = r7
            goto L_0x00e0
        L_0x0096:
            r10 = move-exception
            r4 = r7
            goto L_0x010f
        L_0x009a:
            r10 = move-exception
            r4 = r7
            goto L_0x013e
        L_0x009e:
            java.lang.String r10 = "after all, trs connect is null"
            com.huawei.android.pushagent.c.a.e.d(r6, r10)     // Catch:{ UnsupportedEncodingException -> 0x00b5, IOException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
            if (r11 == 0) goto L_0x00ab
            com.huawei.android.pushagent.c.a.e.a(r6, r3)
            r11.disconnect()
        L_0x00ab:
            return r7
        L_0x00ac:
            r10 = move-exception
            r8 = r11
            goto L_0x00c5
        L_0x00af:
            r10 = move-exception
            r8 = r11
            goto L_0x00ca
        L_0x00b2:
            r10 = move-exception
            r8 = r11
            goto L_0x00ce
        L_0x00b5:
            r10 = move-exception
            r8 = r11
            goto L_0x00d2
        L_0x00b8:
            r10 = move-exception
            r8 = r4
            goto L_0x00c5
        L_0x00bb:
            r10 = move-exception
            r8 = r4
            goto L_0x00ca
        L_0x00be:
            r10 = move-exception
            r8 = r4
            goto L_0x00ce
        L_0x00c1:
            r10 = move-exception
            r8 = r4
            goto L_0x00d2
        L_0x00c4:
            r10 = move-exception
        L_0x00c5:
            r11 = r7
            r4 = r11
            goto L_0x0183
        L_0x00c9:
            r10 = move-exception
        L_0x00ca:
            r11 = r7
            r4 = r11
            goto L_0x00e0
        L_0x00cd:
            r10 = move-exception
        L_0x00ce:
            r11 = r7
            r4 = r11
            goto L_0x010f
        L_0x00d1:
            r10 = move-exception
        L_0x00d2:
            r11 = r7
            r4 = r11
            goto L_0x013e
        L_0x00d6:
            r10 = move-exception
            r11 = r7
            r4 = r11
            r8 = r4
            goto L_0x0183
        L_0x00dc:
            r10 = move-exception
            r11 = r7
            r4 = r11
            r8 = r4
        L_0x00e0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0182 }
            r5.<init>()     // Catch:{ all -> 0x0182 }
            r5.append(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x0182 }
            r5.append(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0182 }
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r6, (java.lang.String) r0, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0182 }
            if (r11 == 0) goto L_0x00ff
            r11.close()     // Catch:{ IOException -> 0x00fc }
            goto L_0x00ff
        L_0x00fc:
            com.huawei.android.pushagent.c.a.e.d(r6, r2)
        L_0x00ff:
            if (r4 == 0) goto L_0x0108
            r4.close()     // Catch:{ IOException -> 0x0105 }
            goto L_0x0108
        L_0x0105:
            com.huawei.android.pushagent.c.a.e.d(r6, r1)
        L_0x0108:
            if (r8 == 0) goto L_0x016e
            goto L_0x0168
        L_0x010b:
            r10 = move-exception
            r11 = r7
            r4 = r11
            r8 = r4
        L_0x010f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0182 }
            r5.<init>()     // Catch:{ all -> 0x0182 }
            r5.append(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x0182 }
            r5.append(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0182 }
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r6, (java.lang.String) r0, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0182 }
            if (r11 == 0) goto L_0x012e
            r11.close()     // Catch:{ IOException -> 0x012b }
            goto L_0x012e
        L_0x012b:
            com.huawei.android.pushagent.c.a.e.d(r6, r2)
        L_0x012e:
            if (r4 == 0) goto L_0x0137
            r4.close()     // Catch:{ IOException -> 0x0134 }
            goto L_0x0137
        L_0x0134:
            com.huawei.android.pushagent.c.a.e.d(r6, r1)
        L_0x0137:
            if (r8 == 0) goto L_0x016e
            goto L_0x0168
        L_0x013a:
            r10 = move-exception
            r11 = r7
            r4 = r11
            r8 = r4
        L_0x013e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0182 }
            r5.<init>()     // Catch:{ all -> 0x0182 }
            r5.append(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x0182 }
            r5.append(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0182 }
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r6, (java.lang.String) r0, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0182 }
            if (r11 == 0) goto L_0x015d
            r11.close()     // Catch:{ IOException -> 0x015a }
            goto L_0x015d
        L_0x015a:
            com.huawei.android.pushagent.c.a.e.d(r6, r2)
        L_0x015d:
            if (r4 == 0) goto L_0x0166
            r4.close()     // Catch:{ IOException -> 0x0163 }
            goto L_0x0166
        L_0x0163:
            com.huawei.android.pushagent.c.a.e.d(r6, r1)
        L_0x0166:
            if (r8 == 0) goto L_0x016e
        L_0x0168:
            com.huawei.android.pushagent.c.a.e.a(r6, r3)
            r8.disconnect()
        L_0x016e:
            r10 = 2000(0x7d0, double:9.88E-321)
            java.lang.Thread.sleep(r10)     // Catch:{ InterruptedException -> 0x0174 }
            goto L_0x017c
        L_0x0174:
            r10 = move-exception
            java.lang.String r11 = r10.toString()
            com.huawei.android.pushagent.c.a.e.c(r6, r11, r10)
        L_0x017c:
            java.lang.String r10 = "get IP/PORT failed, retry again."
            com.huawei.android.pushagent.c.a.e.a(r6, r10)
            return r7
        L_0x0182:
            r10 = move-exception
        L_0x0183:
            if (r11 == 0) goto L_0x018c
            r11.close()     // Catch:{ IOException -> 0x0189 }
            goto L_0x018c
        L_0x0189:
            com.huawei.android.pushagent.c.a.e.d(r6, r2)
        L_0x018c:
            if (r4 == 0) goto L_0x0195
            r4.close()     // Catch:{ IOException -> 0x0192 }
            goto L_0x0195
        L_0x0192:
            com.huawei.android.pushagent.c.a.e.d(r6, r1)
        L_0x0195:
            if (r8 == 0) goto L_0x019d
            com.huawei.android.pushagent.c.a.e.a(r6, r3)
            r8.disconnect()
        L_0x019d:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.f.a(android.content.Context, java.lang.String):com.huawei.android.pushagent.a.e");
    }

    private static String a(Context context, String str, boolean z) {
        String a = a("push.hicloud.com", str);
        if (z && a != null && a.length() > 0) {
            a = a.split(":")[0] + ":5222";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://");
        stringBuffer.append(a);
        stringBuffer.append("/TRSServer/TRSRequest3");
        e.a("PushLogAC2705", "url:" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            e.c("PushLogAC2705", "belongId is null or trsAddress is null");
            return str;
        } else if (!str.startsWith("push")) {
            e.c("PushLogAC2705", "trsAddress is invalid:" + str);
            return str;
        } else {
            try {
                int parseInt = Integer.parseInt(str2.trim());
                if (parseInt <= 0) {
                    e.c("PushLogAC2705", "belongId is invalid:" + parseInt);
                    return str;
                }
                int indexOf = str.indexOf(".");
                if (indexOf <= -1) {
                    return str;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str.substring(0, indexOf));
                stringBuffer.append(parseInt);
                stringBuffer.append(str.substring(indexOf));
                return stringBuffer.toString();
            } catch (NumberFormatException e) {
                e.c("PushLogAC2705", "belongId parseInt error: " + str2, e);
                return str;
            } catch (Exception e2) {
                e.c("PushLogAC2705", e2.getMessage(), e2);
                return str;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r6 = r4.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r6 = r4.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0084, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", r6.toString(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008f, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00cd, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e A[SYNTHETIC, Splitter:B:32:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0080 A[SYNTHETIC, Splitter:B:40:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f A[ExcHandler: IOException (e java.io.IOException), Splitter:B:10:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static javax.net.ssl.HttpsURLConnection a(android.content.Context r4, java.lang.String r5, java.lang.String r6, boolean r7, boolean r8) {
        /*
            if (r8 == 0) goto L_0x0006
            java.lang.String r5 = a(r4, r6, r8)
        L_0x0006:
            r0 = 0
            java.lang.String r1 = "PushLogAC2705"
            if (r5 != 0) goto L_0x0011
            java.lang.String r4 = "TRSUrl is null, cannot create connection."
            com.huawei.android.pushagent.c.a.e.a(r1, r4)
            return r0
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "TRS httpUrl = "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = ",useDefaultPort = "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.huawei.android.pushagent.c.a.e.a(r1, r8)
            javax.net.ssl.HttpsURLConnection r5 = b(r4, r5, r7)     // Catch:{ IOException -> 0x00b1, Exception -> 0x0091 }
            java.lang.String r7 = "get connection success."
            com.huawei.android.pushagent.c.a.e.a(r1, r7)     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
            r5.connect()     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
            java.io.OutputStream r7 = r5.getOutputStream()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r4 = b(r4, r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r6 = "UTF-8"
            byte[] r4 = r4.getBytes(r6)     // Catch:{ Exception -> 0x005e }
            r7.write(r4)     // Catch:{ Exception -> 0x005e }
            r7.flush()     // Catch:{ Exception -> 0x005e }
            if (r7 == 0) goto L_0x0078
            r7.close()     // Catch:{ Exception -> 0x0053, IOException -> 0x008f }
            goto L_0x0078
        L_0x0053:
            r4 = move-exception
            java.lang.String r6 = r4.toString()     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
        L_0x0058:
            com.huawei.android.pushagent.c.a.e.c(r1, r6, r4)     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
            goto L_0x0078
        L_0x005c:
            r4 = move-exception
            goto L_0x007e
        L_0x005e:
            r4 = move-exception
            goto L_0x0065
        L_0x0060:
            r4 = move-exception
            r7 = r0
            goto L_0x007e
        L_0x0063:
            r4 = move-exception
            r7 = r0
        L_0x0065:
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x005c }
            com.huawei.android.pushagent.c.a.e.c(r1, r6, r4)     // Catch:{ all -> 0x005c }
            if (r7 == 0) goto L_0x0078
            r7.close()     // Catch:{ Exception -> 0x0072, IOException -> 0x008f }
            goto L_0x0078
        L_0x0072:
            r4 = move-exception
            java.lang.String r6 = r4.toString()     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
            goto L_0x0058
        L_0x0078:
            java.lang.String r4 = "call conn.connect() success"
            com.huawei.android.pushagent.c.a.e.a(r1, r4)     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
            return r5
        L_0x007e:
            if (r7 == 0) goto L_0x008c
            r7.close()     // Catch:{ Exception -> 0x0084, IOException -> 0x008f }
            goto L_0x008c
        L_0x0084:
            r6 = move-exception
            java.lang.String r7 = r6.toString()     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
            com.huawei.android.pushagent.c.a.e.c(r1, r7, r6)     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
        L_0x008c:
            throw r4     // Catch:{ IOException -> 0x008f, Exception -> 0x008d }
        L_0x008d:
            r4 = move-exception
            goto L_0x0093
        L_0x008f:
            r4 = move-exception
            goto L_0x00b3
        L_0x0091:
            r4 = move-exception
            r5 = r0
        L_0x0093:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "connect to TRS cause Exception:"
            r6.append(r7)
            java.lang.String r7 = r4.toString()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.huawei.android.pushagent.c.a.e.c(r1, r6, r4)
            if (r5 == 0) goto L_0x00b0
            r5.disconnect()
        L_0x00b0:
            return r0
        L_0x00b1:
            r4 = move-exception
            r5 = r0
        L_0x00b3:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "connect to TRS cause IOException:"
            r6.append(r7)
            java.lang.String r4 = r4.toString()
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.huawei.android.pushagent.c.a.e.d(r1, r4)
            if (r5 == 0) goto L_0x00d0
            r5.disconnect()
        L_0x00d0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.f.a(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):javax.net.ssl.HttpsURLConnection");
    }

    private static String b(Context context, String str) {
        String h = a.h(context);
        String a = a.a(context);
        String a2 = a.a(context);
        String g = a.g(context);
        String c = a.c();
        String packageName = context.getPackageName();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mccmnc", a(h));
            jSONObject.put("PushID", a(a));
            jSONObject.put("udid", a(a2));
            jSONObject.put("belongid", a(str));
            jSONObject.put("version", a(g));
            jSONObject.put("protocolversion", "2.0");
            jSONObject.put("info", 0);
            jSONObject.put("channel", a(packageName));
            jSONObject.put("mode", a(Build.MODEL));
            jSONObject.put("mac", a(""));
            jSONObject.put("intelligent", 3);
            jSONObject.put("emV", a(c));
            jSONObject.put("rV", a(Build.DISPLAY));
        } catch (JSONException e) {
            e.c("PushLogAC2705", e.toString());
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: type inference failed for: r8v5, types: [java.net.URLConnection] */
    /* JADX WARNING: type inference failed for: r9v11, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.net.ssl.HttpsURLConnection b(android.content.Context r7, java.lang.String r8, boolean r9) throws java.lang.Exception {
        /*
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)
            r1 = 1
            javax.net.ssl.TrustManager[] r2 = new javax.net.ssl.TrustManager[r1]
            com.huawei.android.pushagent.c.a.i r3 = new com.huawei.android.pushagent.c.a.i
            r3.<init>(r7)
            r4 = 0
            r2[r4] = r3
            java.security.SecureRandom r3 = new java.security.SecureRandom
            r3.<init>()
            r4 = 0
            r0.init(r4, r2, r3)
            com.huawei.android.pushagent.c.a.g r2 = new com.huawei.android.pushagent.c.a.g
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()
            r2.<init>(r0)
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r2)
            com.huawei.android.pushagent.c.c.g r0 = new com.huawei.android.pushagent.c.c.g
            r0.<init>()
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(r0)
            java.lang.String r0 = "PushLogAC2705"
            if (r9 == 0) goto L_0x00c1
            int r9 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r7)
            if (r1 == r9) goto L_0x00c1
            r9 = -1
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0060 }
            r3 = 11
            if (r2 < r3) goto L_0x0055
            java.lang.String r2 = "http.proxyHost"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "http.proxyPort"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch:{ Exception -> 0x005e }
            if (r3 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            java.lang.String r3 = "-1"
        L_0x0050:
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x005e }
            goto L_0x007b
        L_0x0055:
            java.lang.String r2 = android.net.Proxy.getHost(r7)     // Catch:{ Exception -> 0x0060 }
            int r3 = android.net.Proxy.getPort(r7)     // Catch:{ Exception -> 0x005e }
            goto L_0x007b
        L_0x005e:
            r3 = move-exception
            goto L_0x0062
        L_0x0060:
            r3 = move-exception
            r2 = r4
        L_0x0062:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "get proxy ip or port error:"
            r5.append(r6)
            java.lang.String r3 = r3.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            com.huawei.android.pushagent.c.a.e.d(r0, r3)
            r3 = -1
        L_0x007b:
            if (r2 == 0) goto L_0x00c1
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x00c1
            if (r3 == r9) goto L_0x00c1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r4 = "use Proxy "
            r9.append(r4)
            r9.append(r2)
            java.lang.String r4 = ":"
            r9.append(r4)
            r9.append(r3)
            java.lang.String r4 = " to open:"
            r9.append(r4)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.huawei.android.pushagent.c.a.e.a(r0, r9)
            java.net.Proxy r9 = new java.net.Proxy
            java.net.Proxy$Type r4 = java.net.Proxy.Type.HTTP
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress
            r5.<init>(r2, r3)
            r9.<init>(r4, r5)
            java.net.URL r2 = new java.net.URL
            r2.<init>(r8)
            java.net.URLConnection r9 = r2.openConnection(r9)
            r4 = r9
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4
        L_0x00c1:
            if (r4 != 0) goto L_0x00e3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "direct to open "
            r9.append(r2)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.huawei.android.pushagent.c.a.e.a(r0, r9)
            java.net.URL r9 = new java.net.URL
            r9.<init>(r8)
            java.net.URLConnection r8 = r9.openConnection()
            r4 = r8
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4
        L_0x00e3:
            com.huawei.android.pushagent.b.b.a r8 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r7)
            long r8 = r8.u()
            int r9 = (int) r8
            int r9 = r9 * 1000
            r4.setConnectTimeout(r9)
            com.huawei.android.pushagent.b.b.a r7 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r7)
            long r7 = r7.v()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r2
            int r8 = (int) r7
            r4.setReadTimeout(r8)
            r4.setDoOutput(r1)
            r4.setDoInput(r1)
            java.lang.String r7 = "POST"
            r4.setRequestMethod(r7)
            java.lang.String r7 = "Content-type"
            java.lang.String r8 = "json/text; charset=UTF-8"
            r4.setRequestProperty(r7, r8)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.f.b(android.content.Context, java.lang.String, boolean):javax.net.ssl.HttpsURLConnection");
    }
}
