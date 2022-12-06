package com.bytedance.sdk.component.utils;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import kotlin.UByte;

/* compiled from: DigestUtils */
public class e {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr != null) {
            return a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                byte b = bArr[i5 + i] & UByte.MAX_VALUE;
                int i6 = i4 + 1;
                char[] cArr2 = a;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e A[SYNTHETIC, Splitter:B:21:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x002b }
            r2.<init>(r5)     // Catch:{ all -> 0x002b }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x002c }
        L_0x0013:
            int r3 = r5.length     // Catch:{ all -> 0x002c }
            r4 = 0
            int r3 = r2.read(r5, r4, r3)     // Catch:{ all -> 0x002c }
            if (r3 <= 0) goto L_0x001f
            r1.update(r5, r4, r3)     // Catch:{ all -> 0x002c }
            goto L_0x0013
        L_0x001f:
            byte[] r5 = r1.digest()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = a((byte[]) r5)     // Catch:{ all -> 0x002c }
            r2.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            return r5
        L_0x002b:
            r2 = r0
        L_0x002c:
            if (r2 == 0) goto L_0x0031
            r2.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.e.a(java.io.File):java.lang.String");
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
                    instance.update(str.getBytes("UTF-8"));
                    return a(instance.digest());
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
