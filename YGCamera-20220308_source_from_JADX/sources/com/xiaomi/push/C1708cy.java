package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.bumptech.glide.load.Key;
import com.shix.shixipc.system.ContentCommon;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

/* renamed from: com.xiaomi.push.cy */
public abstract class C1708cy {

    /* renamed from: com.xiaomi.push.cy$a */
    public static class C1709a extends C1707cx {
        public C1709a() {
            super(1);
        }

        /* renamed from: a */
        public String mo17373a(Context context, String str, List<C1652bh> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (C1652bh next : list) {
                    buildUpon.appendQueryParameter(next.mo17253a(), next.mo17254b());
                }
                url = new URL(buildUpon.toString());
            }
            return C1653bi.m2676a(context, url);
        }
    }

    /* renamed from: a */
    static int m2946a(int i, int i2) {
        return (((i2 + 243) / 1448) * ContentCommon.CMD_PTZ_RESET) + 1080 + i + i2;
    }

    /* renamed from: a */
    static int m2947a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * ContentCommon.CMD_PTZ_RESET) + PointerIconCompat.TYPE_COPY + i2 + i + i3;
    }

    /* renamed from: a */
    private static int m2948a(C1707cx cxVar, String str, List<C1652bh> list, String str2) {
        if (cxVar.mo17372a() == 1) {
            return m2946a(str.length(), m2949a(str2));
        }
        if (cxVar.mo17372a() != 2) {
            return -1;
        }
        return m2947a(str.length(), m2950a(list), m2949a(str2));
    }

    /* renamed from: a */
    static int m2949a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes(Key.STRING_CHARSET_NAME).length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    static int m2950a(List<C1652bh> list) {
        int i = 0;
        for (C1652bh next : list) {
            if (!TextUtils.isEmpty(next.mo17253a())) {
                i += next.mo17253a().length();
            }
            if (!TextUtils.isEmpty(next.mo17254b())) {
                i += next.mo17254b().length();
            }
        }
        return i * 2;
    }

    /* renamed from: a */
    public static String m2951a(Context context, String str, List<C1652bh> list) {
        return m2952a(context, str, list, new C1709a(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x009d A[SYNTHETIC, Splitter:B:47:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b1 A[Catch:{ MalformedURLException -> 0x00bc }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m2952a(android.content.Context r19, java.lang.String r20, java.util.List<com.xiaomi.push.C1652bh> r21, com.xiaomi.push.C1707cx r22, boolean r23) {
        /*
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = r22
            boolean r4 = com.xiaomi.push.C1653bi.m2685b(r19)
            r5 = 0
            if (r4 == 0) goto L_0x00c0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x00bc }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x00bc }
            if (r23 == 0) goto L_0x0026
            com.xiaomi.push.cu r6 = com.xiaomi.push.C1702cu.mo17360a()     // Catch:{ MalformedURLException -> 0x00bc }
            com.xiaomi.push.cq r6 = r6.mo17357a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x00bc }
            if (r6 == 0) goto L_0x0024
            java.util.ArrayList r4 = r6.mo17332a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x00bc }
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
            boolean r0 = r3.mo17373a((android.content.Context) r1, (java.lang.String) r14, (java.util.List<com.xiaomi.push.C1652bh>) r15)     // Catch:{ IOException -> 0x0099 }
            if (r0 != 0) goto L_0x0058
            goto L_0x00ba
        L_0x0058:
            java.lang.String r12 = r3.mo17373a((android.content.Context) r1, (java.lang.String) r14, (java.util.List<com.xiaomi.push.C1652bh>) r15)     // Catch:{ IOException -> 0x0099 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ IOException -> 0x0095 }
            if (r0 != 0) goto L_0x0077
            if (r13 == 0) goto L_0x00bb
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0075 }
            long r8 = r6 - r16
            int r0 = m2948a(r3, r14, r15, r12)     // Catch:{ IOException -> 0x0075 }
            long r10 = (long) r0     // Catch:{ IOException -> 0x0075 }
            r6 = r13
            r7 = r14
            r6.mo17338a(r7, r8, r10)     // Catch:{ IOException -> 0x0075 }
            goto L_0x00bb
        L_0x0075:
            r0 = move-exception
            goto L_0x009b
        L_0x0077:
            if (r13 == 0) goto L_0x0092
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0095 }
            long r8 = r6 - r16
            int r0 = m2948a(r3, r14, r15, r12)     // Catch:{ IOException -> 0x0095 }
            long r10 = (long) r0
            r0 = 0
            r6 = r13
            r7 = r14
            r18 = r12
            r12 = r0
            r6.mo17339a(r7, r8, r10, r12)     // Catch:{ IOException -> 0x008e }
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
            int r6 = m2948a(r3, r14, r15, r12)     // Catch:{ MalformedURLException -> 0x00bc }
            long r10 = (long) r6     // Catch:{ MalformedURLException -> 0x00bc }
            r6 = r13
            r7 = r14
            r18 = r12
            r12 = r0
            r6.mo17339a(r7, r8, r10, r12)     // Catch:{ MalformedURLException -> 0x00bc }
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1708cy.m2952a(android.content.Context, java.lang.String, java.util.List, com.xiaomi.push.cx, boolean):java.lang.String");
    }
}
