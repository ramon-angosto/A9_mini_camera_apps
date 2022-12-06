package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.ah */
public class C1615ah {

    /* renamed from: a */
    static final char[] f1766a = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    public static String m2511a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i + i3] & 255;
            sb.append(f1766a[b >> 4]);
            sb.append(f1766a[b & 15]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m2512a(Context context) {
        return C1614ag.f1765b;
    }
}
