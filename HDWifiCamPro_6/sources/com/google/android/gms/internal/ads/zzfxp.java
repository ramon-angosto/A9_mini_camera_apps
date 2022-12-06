package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Queue;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfxp {
    private static final OutputStream zza = new zzfxo();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r3 >= 4096) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r2 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r3 = com.google.android.gms.internal.ads.zzfxs.zzc(((long) r3) * ((long) r2));
        r2 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] zza(java.io.InputStream r9) throws java.io.IOException {
        /*
            if (r9 == 0) goto L_0x0064
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r1 = 20
            r0.<init>(r1)
            r1 = 0
            int r2 = java.lang.Integer.highestOneBit(r1)
            r3 = 8192(0x2000, float:1.14794E-41)
            r4 = 128(0x80, float:1.794E-43)
            int r2 = r2 + r2
            int r2 = java.lang.Math.max(r4, r2)
            int r2 = java.lang.Math.min(r3, r2)
            r3 = r2
            r2 = r1
        L_0x001d:
            r4 = -1
            r5 = 2147483639(0x7ffffff7, float:NaN)
            if (r2 >= r5) goto L_0x0051
            int r5 = r5 - r2
            int r5 = java.lang.Math.min(r3, r5)
            byte[] r5 = new byte[r5]
            r0.add(r5)
            r6 = r2
            r2 = r1
        L_0x002f:
            int r7 = r5.length
            if (r2 >= r7) goto L_0x0041
            int r7 = r7 - r2
            int r7 = r9.read(r5, r2, r7)
            if (r7 != r4) goto L_0x003e
            byte[] r9 = zzb(r0, r6)
            goto L_0x005b
        L_0x003e:
            int r2 = r2 + r7
            int r6 = r6 + r7
            goto L_0x002f
        L_0x0041:
            r2 = 4096(0x1000, float:5.74E-42)
            if (r3 >= r2) goto L_0x0047
            r2 = 4
            goto L_0x0048
        L_0x0047:
            r2 = 2
        L_0x0048:
            long r3 = (long) r3
            long r7 = (long) r2
            long r3 = r3 * r7
            int r3 = com.google.android.gms.internal.ads.zzfxs.zzc(r3)
            r2 = r6
            goto L_0x001d
        L_0x0051:
            int r9 = r9.read()
            if (r9 != r4) goto L_0x005c
            byte[] r9 = zzb(r0, r5)
        L_0x005b:
            return r9
        L_0x005c:
            java.lang.OutOfMemoryError r9 = new java.lang.OutOfMemoryError
            java.lang.String r0 = "input is too large to fit in a byte array"
            r9.<init>(r0)
            throw r9
        L_0x0064:
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfxp.zza(java.io.InputStream):byte[]");
    }

    private static byte[] zzb(Queue queue, int i) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i) {
            return bArr;
        }
        int i2 = i - length;
        byte[] copyOf = Arrays.copyOf(bArr, i);
        while (i2 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(i2, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i - i2, min);
            i2 -= min;
        }
        return copyOf;
    }
}
