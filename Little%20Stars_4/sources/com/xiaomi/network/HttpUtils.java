package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mapapi.MKEvent;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.channel.commonutils.network.d;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

public abstract class HttpUtils {

    public static class DefaultHttpGetProcessor extends HttpProcessor {
        public DefaultHttpGetProcessor() {
            super(1);
        }

        public String b(Context context, String str, List<c> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (c next : list) {
                    buildUpon.appendQueryParameter(next.a(), next.b());
                }
                url = new URL(buildUpon.toString());
            }
            return d.a(context, url);
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + MKEvent.ERROR_LOCATION_FAILED) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    private static int a(HttpProcessor httpProcessor, String str, List<c> list, String str2) {
        if (httpProcessor.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (httpProcessor.a() != 2) {
            return -1;
        }
        return a(str.length(), a(list), a(str2));
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    static int a(List<c> list) {
        int i = 0;
        for (c next : list) {
            if (!TextUtils.isEmpty(next.a())) {
                i += next.a().length();
            }
            if (!TextUtils.isEmpty(next.b())) {
                i += next.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<c> list) {
        return a(context, str, list, new DefaultHttpGetProcessor(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x009d A[SYNTHETIC, Splitter:B:47:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b1 A[Catch:{ MalformedURLException -> 0x00bc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r19, java.lang.String r20, java.util.List<com.xiaomi.channel.commonutils.network.c> r21, com.xiaomi.network.HttpProcessor r22, boolean r23) {
        /*
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = r22
            boolean r4 = com.xiaomi.channel.commonutils.network.d.d(r19)
            r5 = 0
            if (r4 == 0) goto L_0x00c0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x00bc }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x00bc }
            if (r23 == 0) goto L_0x0026
            com.xiaomi.network.HostManager r6 = com.xiaomi.network.HostManager.getInstance()     // Catch:{ MalformedURLException -> 0x00bc }
            com.xiaomi.network.Fallback r6 = r6.getFallbacksByURL(r0)     // Catch:{ MalformedURLException -> 0x00bc }
            if (r6 == 0) goto L_0x0024
            java.util.ArrayList r4 = r6.a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x00bc }
        L_0x0024:
            r13 = r6
            goto L_0x0027
        L_0x0026:
            r13 = r5
        L_0x0027:
            boolean r6 = r4.contains(r0)     // Catch:{ MalformedURLException -> 0x00bc }
            if (r6 != 0) goto L_0x0030
            r4.add(r0)     // Catch:{ MalformedURLException -> 0x00bc }
        L_0x0030:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ MalformedURLException -> 0x00bc }
            r6 = r5
        L_0x0035:
            boolean r0 = r4.hasNext()     // Catch:{ MalformedURLException -> 0x00bc }
            if (r0 == 0) goto L_0x00ba
            java.lang.Object r0 = r4.next()     // Catch:{ MalformedURLException -> 0x00bc }
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ MalformedURLException -> 0x00bc }
            if (r2 == 0) goto L_0x004b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x00bc }
            r0.<init>(r2)     // Catch:{ MalformedURLException -> 0x00bc }
            r15 = r0
            goto L_0x004c
        L_0x004b:
            r15 = r5
        L_0x004c:
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x00bc }
            boolean r0 = r3.a(r1, r14, r15)     // Catch:{ IOException -> 0x0099 }
            if (r0 != 0) goto L_0x0058
            goto L_0x00ba
        L_0x0058:
            java.lang.String r12 = r3.b(r1, r14, r15)     // Catch:{ IOException -> 0x0099 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ IOException -> 0x0095 }
            if (r0 != 0) goto L_0x0077
            if (r13 == 0) goto L_0x00bb
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0075 }
            long r8 = r6 - r16
            int r0 = a(r3, r14, r15, r12)     // Catch:{ IOException -> 0x0075 }
            long r10 = (long) r0     // Catch:{ IOException -> 0x0075 }
            r6 = r13
            r7 = r14
            r6.a(r7, r8, r10)     // Catch:{ IOException -> 0x0075 }
            goto L_0x00bb
        L_0x0075:
            r0 = move-exception
            goto L_0x009b
        L_0x0077:
            if (r13 == 0) goto L_0x0092
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0095 }
            long r8 = r6 - r16
            int r0 = a(r3, r14, r15, r12)     // Catch:{ IOException -> 0x0095 }
            long r10 = (long) r0
            r0 = 0
            r6 = r13
            r7 = r14
            r18 = r12
            r12 = r0
            r6.a(r7, r8, r10, r12)     // Catch:{ IOException -> 0x008e }
            goto L_0x00b6
        L_0x008e:
            r0 = move-exception
            r12 = r18
            goto L_0x009b
        L_0x0092:
            r18 = r12
            goto L_0x00b6
        L_0x0095:
            r0 = move-exception
            r18 = r12
            goto L_0x009b
        L_0x0099:
            r0 = move-exception
            r12 = r6
        L_0x009b:
            if (r13 == 0) goto L_0x00b1
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x00bc }
            long r8 = r6 - r16
            int r6 = a(r3, r14, r15, r12)     // Catch:{ MalformedURLException -> 0x00bc }
            long r10 = (long) r6     // Catch:{ MalformedURLException -> 0x00bc }
            r6 = r13
            r7 = r14
            r18 = r12
            r12 = r0
            r6.a(r7, r8, r10, r12)     // Catch:{ MalformedURLException -> 0x00bc }
            goto L_0x00b3
        L_0x00b1:
            r18 = r12
        L_0x00b3:
            r0.printStackTrace()     // Catch:{ MalformedURLException -> 0x00bc }
        L_0x00b6:
            r6 = r18
            goto L_0x0035
        L_0x00ba:
            r12 = r6
        L_0x00bb:
            return r12
        L_0x00bc:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00c0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HttpUtils.a(android.content.Context, java.lang.String, java.util.List, com.xiaomi.network.HttpProcessor, boolean):java.lang.String");
    }
}
